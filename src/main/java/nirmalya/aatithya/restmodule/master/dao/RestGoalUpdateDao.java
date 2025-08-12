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
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterGoalUpdate;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestGoalUpdateModel;

@Repository
public class RestGoalUpdateDao {
	Logger logger = LoggerFactory.getLogger(RestGoalFeedbackDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	/*
	 * get name list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getNameListU(String id) {
		List<DropDownModel> getNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_empId='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowUpdate")
					.setParameter("actionType", "getNameList").setParameter("actionValue",value).getResultList();
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
	public JsonResponse<List<RestGoalUpdateModel>> getDesignationList(String id) {
		logger.info("Method : getDesignationList starts");
		List<RestGoalUpdateModel> jobList = new ArrayList<RestGoalUpdateModel>();
		JsonResponse<List<RestGoalUpdateModel>> resp = new JsonResponse<List<RestGoalUpdateModel>>();

		String value = "SET @p_tGuestName='" + id + "';";
		logger.info("value1==="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowUpdate")
					.setParameter("actionType", "getBandList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestGoalUpdateModel dropDownModel = new RestGoalUpdateModel(m[0],m[1],m[2],m[3]);
				jobList.add(dropDownModel);
			}

			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("resp===="+resp);
		logger.info("Method : getDesignationList ends");
		return resp;
	}
	/*
	 * get recommendation
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestGoalUpdateModel>> getRecommendation(String id) {
		logger.info("Method : getRecommendation starts");
		List<RestGoalUpdateModel> jobList = new ArrayList<RestGoalUpdateModel>();
		JsonResponse<List<RestGoalUpdateModel>> resp = new JsonResponse<List<RestGoalUpdateModel>>();

		String value = "SET @p_tGuestName='" + id + "';";
		logger.info("value2==="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowUpdate")
					.setParameter("actionType", "getRecommendation").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestGoalUpdateModel dropDownModel = new RestGoalUpdateModel(m[0],m[1],m[2],m[3],m[4]);
				jobList.add(dropDownModel);
			}

			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("resp===="+resp);
		logger.info("Method : getRecommendation ends");
		return resp;
	}
	
	/*
	 * view update ag-grid data
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalUpdateModel>>> viewUpdateData(String name) {
		logger.info("Method : viewSelfAppraisalData starts");

		List<RestGoalUpdateModel> jobList = new ArrayList<RestGoalUpdateModel>();
		
		String value = "SET @p_empName='" + name + "';";
		
		try {
			logger.info("11111111111111"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowUpdate")
					.setParameter("actionType", "viewUpdateData").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {				
				RestGoalUpdateModel dropDownModel = new RestGoalUpdateModel(m[0].toString(), m[1], m[2], m[3],m[4],m[5],null,m[6],m[7]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalUpdateModel>> resp = new JsonResponse<List<RestGoalUpdateModel>>();
		resp.setBody(jobList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalUpdateModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalUpdateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewSelfAppraisalData ends");
		return response;
	}


	public ResponseEntity<JsonResponse<List<RestGoalUpdateModel>>> saveGoalUpdate(List<RestGoalUpdateModel> restGoalUpdate) {
		logger.info("Method : addGoalReview Dao starts");
		
		JsonResponse<List<RestGoalUpdateModel>> resp = new JsonResponse<List<RestGoalUpdateModel>>();
		List<RestGoalUpdateModel> listData = new ArrayList<RestGoalUpdateModel>();
		
			try {
				String values = GenerateMasterGoalUpdate.addGoalUpdate(restGoalUpdate);

				if (restGoalUpdate.get(0).getGoalId() != null && restGoalUpdate.get(0).getGoalId() != "") {
					
					em.createNamedStoredProcedureQuery("hrmsGrowUpdate").setParameter("actionType", "updateGoalUpdate")
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
		ResponseEntity<JsonResponse<List<RestGoalUpdateModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalUpdateModel>>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addGoalReview Dao ends");

		return response;
	}


	@SuppressWarnings("unchecked")
	public List<DropDownModel> getdesignationList() {
		List<DropDownModel> getNameList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowUpdate")
					.setParameter("actionType", "getDesignationList").setParameter("actionValue", "").getResultList();
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

}
