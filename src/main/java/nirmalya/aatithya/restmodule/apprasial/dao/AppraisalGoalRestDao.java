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

import nirmalya.aatithya.restmodule.apprasial.model.AppraisalGoalRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;




@Repository
public class AppraisalGoalRestDao {

	Logger logger = LoggerFactory.getLogger(AppraisalGoalRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	public ResponseEntity<JsonResponse<Object>> saveGoal(AppraisalGoalRestModel goalModel) {
		logger.info("Method : saveGoal Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(goalModel);

			System.out.println("value is coming like this========================> " + values);

			if (goalModel.getGoalId() == null || goalModel.getGoalId() == "") {

				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "saveGoal")
						.setParameter("actionValue", values).execute();
				resp.setMessage("Goal Added Successfully");
				resp.setCode("Success");
			} else {

				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "modifyGoal")
						.setParameter("actionValue", values).execute();
				resp.setMessage("Goal Updated Successfully");
				resp.setCode("Success");

			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveGoal Dao ends");
		return response;
	}

	// getAllGoal
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllGoal(String orgName, String orgDivision) {
		logger.info("Method : getAllGoal Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getAllGoal").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllGoal Dao ends");
		return resp;
	}

	/* saveAppraisalKraDetails */
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveAppraisalKraDetails(String appraisalData, String userId, String org,
			String orgDiv) {
		logger.info("method: saveAppraisalKraDetails Dao  Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @p_appraisalData='" + appraisalData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			System.out.println("value is coming like this==============> " + value);

			String goalId = "";
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(appraisalData, JsonObject.class);
				if (jsonObject.has("goalId")) {
					goalId = jsonObject.get("goalId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing appraisalData with Gson: ", parseException);
			}

			if (goalId != null || goalId == "") {
				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "saveGoalDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "modifyGoalDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in saveAppraisalKraDetails: ", e);
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

		logger.info("method: saveAppraisalKraDetails Dao Ends");
		return response;
	}
	
	/* getAllGoalDetails */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllGoalDetails(String orgName, String orgDivision,String id) {
		logger.info("Method : getAllGoalDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_goal_id='"+id+"';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getAllGoalDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllGoalDetails Dao ends");
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method : getDepartmentList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends" + departType);
		return departType;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrgGoalList() {

		logger.info("Method : getOrgGoalList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getOrgGoalList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOrgGoalList ends" + departType);
		return departType;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> saveDepGoal(AppraisalGoalRestModel goalModel) {
		logger.info("Method : saveDepGoal Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(goalModel);

			System.out.println("value is coming like this========================> " + values);

			if (goalModel.getDepGoalId() == null || goalModel.getDepGoalId() == "") {

				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "saveDepGoal")
						.setParameter("actionValue", values).execute();
				resp.setMessage("Goal Added Successfully");
				resp.setCode("Success");
			} else {

				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "modifyDepGoal")
						.setParameter("actionValue", values).execute();
				resp.setMessage("Goal Updated Successfully");
				resp.setCode("Success");

			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveDepGoal Dao ends");
		return response;
	}
	
	/* getAllDepGoal */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllDepGoal(String orgName, String orgDivision) {
		logger.info("Method : getAllDepGoal Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getAllDepGoal").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllDepGoal Dao ends");
		return resp;
	}
	/* saveDepKraDetails */
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveDepKraDetails(String deptAppraisalData, String userId, String org,
			String orgDiv) {
		logger.info("method: saveDepKraDetails Dao  Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @p_appraisalDepData='" + deptAppraisalData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			System.out.println("value is coming like this==============> " + value);

			String depGoalId = "";
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(deptAppraisalData, JsonObject.class);
				if (jsonObject.has("depGoalId")) {
					depGoalId = jsonObject.get("depGoalId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing deptAppraisalData with Gson: ", parseException);
			}

			if (depGoalId != null || depGoalId == "") {
				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "saveDepGoalDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "modifyDepGoalDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in saveDepKraDetails: ", e);
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

		logger.info("method: saveDepKraDetails Dao Ends");
		return response;
	}
	
	/* getAllGoalDetails */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllDepGoalDetails(String orgName, String orgDivision,String id) {
		logger.info("Method : getAllDepGoalDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_dep_goal_id='"+id+"';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getAllDepGoalDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllDepGoalDetails Dao ends");
		return resp;
	}
	
	/* getDepGoalList */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepGoalList() {

		logger.info("Method : getDepGoalList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getDepGoalList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepGoalList ends" + departType);
		return departType;
	}
	
	/* getDesignationList */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDesignationList() {

		logger.info("Method : getDesignationList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getDesignationList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDesignationList ends" + departType);
		return departType;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDepartmentGoalDetails(String orgName, String orgDivision,String id) {
		logger.info("Method : getDepartmentGoalDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_goalId='"+id+"';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getDepartmentGoalDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getDepartmentGoalDetails Dao ends");
		return resp;
	}
	
	
	/* saveDesigGoal */
	public ResponseEntity<JsonResponse<Object>> saveDesigGoal(AppraisalGoalRestModel goalModel) {
		logger.info("Method : saveDesigGoal Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(goalModel);

			System.out.println("value is coming like this========================> " + values);

			if (goalModel.getDesigGoalId() == null || goalModel.getDesigGoalId() == "") {

				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "saveDesigGoal")
						.setParameter("actionValue", values).execute();
				resp.setMessage("Goal Added Successfully");
				resp.setCode("Success");
			} else {

				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "modifyDesigGoal")
						.setParameter("actionValue", values).execute();
				resp.setMessage("Goal Updated Successfully");
				resp.setCode("Success");

			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveDesigGoal Dao ends");
		return response;
	}
	
	/* getAllDesigGoal */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllDesigGoal(String orgName, String orgDivision) {
		logger.info("Method : getAllDesigGoal Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_routines")
					.setParameter("actionType", "getAllDesigGoal").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllDesigGoal Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unused")
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveApppraisalDesigKraDetails(String desigAppraisalData, String userId, String org,
			String orgDiv) {
		logger.info("method: saveApppraisalDesigKraDetails Dao  Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @p_appraisalDesigData='" + desigAppraisalData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			System.out.println("value is coming like this==============> " + value);

			String desigGoalId = "";
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(desigAppraisalData, JsonObject.class);
				if (jsonObject.has("desigGoalId")) {
					desigGoalId = jsonObject.get("desigGoalId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing deptAppraisalData with Gson: ", parseException);
			}

			if (desigGoalId != null || desigGoalId !=  "") {
				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "saveDesigGoalDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("appraisal_routines").setParameter("actionType", "modifyDepGoalDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in saveApppraisalDesigKraDetails: ", e);
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

		logger.info("method: saveApppraisalDesigKraDetails Dao Ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllDesigGoalDetails(String orgName, String orgDivision,String id) {
		logger.info("Method : getAllDesigGoalDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_desig_goal_id='"+id+"';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_routines")
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
}
