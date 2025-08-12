package nirmalya.aatithya.restmodule.apprasial.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class SelfAppraisalRestDao {

	Logger logger = LoggerFactory.getLogger(SelfAppraisalRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllEmployee(String orgName, String orgDivision,String id,String finYear) {
		logger.info("Method : getAllEmployee Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + id + "',@p_finYear='" + finYear + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("self_appraisal_routines")
					.setParameter("actionType", "getAllEmployee").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllEmployee Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllDesigGoalDLists(String orgName, String orgDivision, String id) {
		logger.info("Method : getAllDesigGoalDLists Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_desig_goal_id='" + id
					+ "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("self_appraisal_routines")
					.setParameter("actionType", "getAllGoalByDesId").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllDesigGoalDLists Dao ends");
		return resp;
	}

	/* getAllDesigGoalDetails */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllDesigGoalDetails(String orgName, String orgDivision, String id,String empId,String finYear) {
		logger.info("Method : getAllDesigGoalDLists Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_desig_goal_id='" + id
					+ "',@p_empId='" +empId+ "',@p_finYear='" + finYear + "';";
			logger.info(value);
			
			List<Object[]> list = em.createNamedStoredProcedureQuery("self_appraisal_routines")
					.setParameter("actionType", "getDesigDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllDesigGoalDetails Dao ends");
		return resp;
	}
	
	/* saveSelfAppraisal */
//	@Transactional
//	public ResponseEntity<JsonResponse<Object>> saveSelfAppraisal(String depGoalData, String userId, String org,
//			String orgDiv) {
//		logger.info("method: saveSelfAppraisal Dao  Starts");
//
//		JsonResponse<Object> resp = new JsonResponse<>();
//		try {
//			String value = "SET @p_appraisalData='" + depGoalData + "', @p_userId='" + userId + "', @p_org='" + org
//					+ "', @p_orgDiv='" + orgDiv + "';";
//
//			System.out.println("value is coming like this==============> " + value);
//
//			String selfAppId = "";
//			try {
//				Gson gson = new Gson();
//				JsonObject jsonObject = gson.fromJson(depGoalData, JsonObject.class);
//				if (jsonObject.has("selfAppId")) {
//					selfAppId = jsonObject.get("selfAppId").getAsString();
//				}
//			} catch (Exception parseException) {
//				logger.error("Error parsing deptAppraisalData with Gson: ", parseException);
//			}
//
//			if (selfAppId == null || selfAppId == "") {
//				em.createNamedStoredProcedureQuery("self_appraisal_routines").setParameter("actionType", "saveSelfAppraisal")
//						.setParameter("actionValue", value).execute();
//
//				resp.setMessage("Data saved successfully!");
//				resp.setCode("Success");
//			} else {
//				em.createNamedStoredProcedureQuery("self_appraisal_routines").setParameter("actionType", "modifyDepGoalDetails")
//						.setParameter("actionValue", value).execute();
//
//				resp.setMessage("Data modified successfully!");
//				resp.setCode("Success");
//			}
//		} catch (Exception e) {
//			logger.error("Error in saveSelfAppraisal: ", e);
//			try {
//				String[] err = serverDao.errorProcedureCall(e);
//				resp.setCode("Failed");
//				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
//			} catch (Exception nestedException) {
//				logger.error("Error while handling exception: ", nestedException);
//				resp.setCode("Failed");
//				resp.setMessage("Oops! Something went wrong during error handling");
//			}
//		}
//
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
//
//		logger.info("method: saveSelfAppraisal Dao Ends");
//		return response;
//	}
	
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveSelfAppraisal(String depGoalData, String userId, String org,
	        String orgDiv) {
	    logger.info("method: saveSelfAppraisal Dao  Starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    try {
	        String value = "SET @p_appraisalData='" + depGoalData + "', @p_userId='" + userId + "', @p_org='" + org
	                + "', @p_orgDiv='" + orgDiv + "';";

	        System.out.println("value is coming like this==============> " + value);

	        String selfAppId = "";
	        try {
	            Gson gson = new Gson();
	            JsonObject jsonObject = gson.fromJson(depGoalData, JsonObject.class);
	            if (jsonObject.has("selfAppId")) {
	                selfAppId = jsonObject.get("selfAppId").getAsString();
	            }
	        } catch (Exception parseException) {
	            logger.error("Error parsing depGoalData with Gson: ", parseException);
	        }

	        if (selfAppId == null || selfAppId.trim().isEmpty()) {  
	            em.createNamedStoredProcedureQuery("self_appraisal_routines")
	                .setParameter("actionType", "saveSelfAppraisal")
	                .setParameter("actionValue", value)
	                .execute();

	            resp.setMessage("Data saved successfully!");
	            resp.setCode("Success");
	        } else {
	            em.createNamedStoredProcedureQuery("self_appraisal_routines")
	                .setParameter("actionType", "modifyDepGoalDetails")
	                .setParameter("actionValue", value)
	                .execute();

	            resp.setMessage("Data modified successfully!");
	            resp.setCode("Success");
	        }
	    } catch (Exception e) {
	        logger.error("Error in saveSelfAppraisal: ", e);
	        try {
	            String[] err = serverDao.errorProcedureCall(e);
	            resp.setCode("Failed");
	            resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
	        } catch (Exception nestedException) {
	            logger.error("Error while handling exception: ", nestedException);
	            resp.setCode("Failed");
	            resp.setMessage("Oops! Something went wrong during error handling");
	        }
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

	    logger.info("method: saveSelfAppraisal Dao Ends");
	    return response;
	}

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllDesigGoalByEMpId(String orgName, String orgDivision, String id,String empId,String finYear) {
		logger.info("Method : getAllDesigGoalByEMpId Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_desig_goal_id='" + id
					+ "',@p_empId='" +empId+ "',@p_finYear='" + finYear +"';";
			logger.info(value);
			
			List<Object[]> list = em.createNamedStoredProcedureQuery("self_appraisal_routines")
					.setParameter("actionType", "getDesigDetailsEmp").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllDesigGoalByEMpId Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> autoSearchEmployeeList(String id) {
		logger.info("Method : autoSearchEmployeeList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("self_appraisal_routines")
					.setParameter("actionType", "getAllEmployeeList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (itemNameList.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : autoSearchEmployeeList dao ends");
		return response;
	}
	
	

}
