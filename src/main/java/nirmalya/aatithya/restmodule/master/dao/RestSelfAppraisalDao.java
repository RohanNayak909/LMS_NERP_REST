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
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterSelfReview;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestSelfAppraisalModel;

@Repository
public class RestSelfAppraisalDao {
	Logger logger = LoggerFactory.getLogger(RestSelfAppraisalDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;


	@SuppressWarnings("unchecked")
	public List<DropDownModel> getNameList(String id) {
		List<DropDownModel> getNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_empId='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowSelfAppraisal")
					.setParameter("actionType", "getNameListSA").setParameter("actionValue", value).getResultList();
		for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				getNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getNameLists Dao ends");

		return getNameList;
	}


	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDesignationList(String id) {
		logger.info("Method : getDesignationList starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tGuestName='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowSelfAppraisal")
					.setParameter("actionType", "getDeginationListSA").setParameter("actionValue", value)
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


	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSelfAppraisalModel>>> viewSelfAppraisalData(String name) {
		logger.info("Method : viewSelfAppraisalData starts");

		List<RestSelfAppraisalModel> jobList = new ArrayList<RestSelfAppraisalModel>();
		
		logger.info("@@@@@@@@@@@@@@@"+name);
		
		String value = "SET @p_empName='" + name + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowSelfAppraisal")
					.setParameter("actionType", "viewSelfAppraisalData").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {				
				RestSelfAppraisalModel dropDownModel = new RestSelfAppraisalModel(m[0].toString(), m[1].toString(), m[2].toString(), m[3].toString(),m[4].toString(),m[5].toString());
				jobList.add(dropDownModel);
				logger.info("@@@@@@@@@@@@@@@"+jobList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestSelfAppraisalModel>> resp = new JsonResponse<List<RestSelfAppraisalModel>>();
		resp.setBody(jobList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestSelfAppraisalModel>>> response = new ResponseEntity<JsonResponse<List<RestSelfAppraisalModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewSelfAppraisalData ends");
		logger.info("VIEWWW"+response);
		return response;
	}


	public ResponseEntity<JsonResponse<Object>> addSelfReview(RestSelfAppraisalModel restSelfAppraisal) {
			logger.info("Method : addGoalAssign Dao starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();

			if (validity)
				try {
					String values = GenerateMasterSelfReview.generateSelfReview(restSelfAppraisal);

					if (restSelfAppraisal.getSlNo() != null && restSelfAppraisal.getSlNo() != "") {
						em.createNamedStoredProcedureQuery("hrmsGrowSelfAppraisal").setParameter("actionType", "modifySelfAppraisal")
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

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);

			logger.info("Method : addGoalAssign Dao ends");

			return response;
		}
	
	
	
	// edit apply

			@SuppressWarnings("unchecked")
			public JsonResponse<RestSelfAppraisalModel> editSelfAppraisal(String id) {
				logger.info("Method : editSelfAppraisal dao starts");
				logger.info("Edit" + id);
				RestSelfAppraisalModel req = new RestSelfAppraisalModel();
				JsonResponse<RestSelfAppraisalModel> resp = new JsonResponse<RestSelfAppraisalModel>();
				try {
					String value = "SET @p_slno='" + id + "';";
					List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowSelfAppraisal")
							.setParameter("actionType", "editSelfAppraisal").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {
						RestSelfAppraisalModel restPayroll = new RestSelfAppraisalModel(m[0].toString(),m[1].toString(),m[2].toString(),m[3].toString(),m[4].toString(),m[5].toString());
						req = restPayroll;

					}
					resp.setBody(req);
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("EDITT" + resp);
				logger.info("Method : editSelfAppraisal dao ends");
				return resp;
			}

		}


