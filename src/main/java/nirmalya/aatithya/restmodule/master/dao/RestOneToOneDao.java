package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterGoalOnetoOne;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestOneToOneModel;

@Repository
public class RestOneToOneDao {
	Logger logger = LoggerFactory.getLogger(RestGoalFeedbackDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	/*
	 * get name list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getNameListO() {
		List<DropDownModel> getNameList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowOneToOne")
					.setParameter("actionType", "getNameList").setParameter("actionValue", "").getResultList();
		for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				getNameList.add(dropDownModel);
			}
		logger.info("##############"+getNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getNameLists Dao ends");

		return getNameList;
	}
	/*
	 * get designation list on change of name
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDesignationList(String id) {
		logger.info("Method : getDesignationList starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tGuestName='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowOneToOne")
					.setParameter("actionType", "getDeginationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}

			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDesignationList ends");
		return resp;
	}
	/*
	 * view onetoone ag-grid data
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOneToOneModel>>> viewOneToOneData(String name) {
		logger.info("Method : viewSelfAppraisalData starts");

		List<RestOneToOneModel> jobList = new ArrayList<RestOneToOneModel>();
		
		String value = "SET @p_empName='" + name + "';";
		
		try {
			logger.info("11111111111111"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowOneToOne")
					.setParameter("actionType", "viewOneToOneData").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {				
				RestOneToOneModel dropDownModel = new RestOneToOneModel(m[0].toString(), m[1], m[2], m[3],m[4], m[5], m[6], m[7],m[8]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestOneToOneModel>> resp = new JsonResponse<List<RestOneToOneModel>>();
		resp.setBody(jobList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestOneToOneModel>>> response = new ResponseEntity<JsonResponse<List<RestOneToOneModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewSelfAppraisalData ends");
		return response;
	}
	/*
	 * final submit goal onetoone
	 */
	public ResponseEntity<JsonResponse<List<RestOneToOneModel>>> saveGoalOneToOne(List<RestOneToOneModel> restGoalOneToOne) {
		logger.info("Method : addGoalReview Dao starts");
		
		JsonResponse<List<RestOneToOneModel>> resp = new JsonResponse<List<RestOneToOneModel>>();
		List<RestOneToOneModel> listData = new ArrayList<RestOneToOneModel>();
		
			try {
				String values = GenerateMasterGoalOnetoOne.addGoalOneToOne(restGoalOneToOne);

				if (restGoalOneToOne.get(0).getGoalId() != null && restGoalOneToOne.get(0).getGoalId() != "") {
					logger.info("%%%%%%%%%%%%"+values);
					em.createNamedStoredProcedureQuery("hrmsGrowOneToOne").setParameter("actionType", "updateGoalOneToOne")
							.setParameter("actionValue", values).execute();
				}
					
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestOneToOneModel>>> response = new ResponseEntity<JsonResponse<List<RestOneToOneModel>>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addGoalReview Dao ends");

		return response;
	}
}
