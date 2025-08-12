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
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterGoalFeedback;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestGoalFeedbackModel;

@Repository
public class RestGoalFeedbackDao {
	Logger logger = LoggerFactory.getLogger(RestGoalFeedbackDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	/*
	 * get name list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getNameListFB() {
		List<DropDownModel> getNameList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowfeedback")
					.setParameter("actionType", "getJobTitleList").setParameter("actionValue", "").getResultList();
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
	 * get designation list
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDesignationListFB(String id) {
		logger.info("Method : getDesignationList starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tGuestName='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowfeedback")
					.setParameter("actionType", "getDeginationListFB").setParameter("actionValue", value)
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
	 * get designation list on change of name in sidenav
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDesignationList(String id) {
		logger.info("Method : getDesignationList starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tGuestName='" + id + "';";
		
		logger.info("@@@@@@@@@@@"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowfeedback")
					.setParameter("actionType", "getDesignationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
				logger.info("@@@@@@@@@@@@"+jobList);
			}

			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDesignationList ends");
		return resp;
	}

	//save feedback data
	public ResponseEntity<JsonResponse<Object>> addGoalFeedback(RestGoalFeedbackModel restGoalFeedback) {
		logger.info("Method : addGoalAssign Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterGoalFeedback.generateGoalFeedback(restGoalFeedback);
				
				em.createNamedStoredProcedureQuery("hrmsGrowfeedback").setParameter("actionType", "addGoalFeedback")
						.setParameter("actionValue", values).execute();
	
					
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
	//view feedback data
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> viewFeedbackData(String name) {
		logger.info("Method : viewJobType starts");

		List<RestGoalFeedbackModel> jobList = new ArrayList<RestGoalFeedbackModel>();
		String value = "SET @p_empName='" + name + "';";
		logger.info("@@@@@@@@@@@@@@@"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowfeedback")
					.setParameter("actionType", "viewFeedbackData").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {				
				RestGoalFeedbackModel dropDownModel = new RestGoalFeedbackModel(m[0], m[1], m[2], m[3],m[4]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalFeedbackModel>> resp = new JsonResponse<List<RestGoalFeedbackModel>>();
		resp.setBody(jobList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewJobType ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> viewEmployeeListDao(String userId) {
		logger.info("Method : viewEmployeeListDao starts");

		List<RestGoalFeedbackModel> employeeList = new ArrayList<RestGoalFeedbackModel>();
		String value = "SET @p_userId='" + userId + "';";
		logger.info(value);
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowfeedback")
					.setParameter("actionType", "viewEmployeeList").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {				
				RestGoalFeedbackModel dropDownModel = new RestGoalFeedbackModel(m[0], m[1], m[2], m[3],m[4], m[5],m[6]);
				employeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalFeedbackModel>> resp = new JsonResponse<List<RestGoalFeedbackModel>>();
		resp.setBody(employeeList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewEmployeeListDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> viewEmployeeBandListDao(String id) {
		logger.info("Method : viewEmployeeBandListDao starts");

		List<RestGoalFeedbackModel> jobList = new ArrayList<RestGoalFeedbackModel>();
		
		String value = "SET @p_empid='" + id + "';";
		
		try {
			//logger.info("11111111111111"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowfeedback")
					.setParameter("actionType", "viewEmoloyeeDetails").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {				
				RestGoalFeedbackModel dropDownModel = new RestGoalFeedbackModel(m[0],m[1],m[2],m[3],m[4],null);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalFeedbackModel>> resp = new JsonResponse<List<RestGoalFeedbackModel>>();
		resp.setBody(jobList);
		logger.info("11111111111111"+resp);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewEmployeeBandListDao ends");
		return response;
	}

	
}
