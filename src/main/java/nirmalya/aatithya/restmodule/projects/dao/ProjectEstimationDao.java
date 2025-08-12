package nirmalya.aatithya.restmodule.projects.dao;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.model.ProjectProdDetailsRestModel;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStackholderRentOSModel;

	
	@Repository
	public class ProjectEstimationDao {
		Logger logger = LoggerFactory.getLogger(ProjectEstimationDao.class);
	
		@Autowired
		EntityManager em;
	
		@Autowired
		ServerDao serverDao;
		
//		@SuppressWarnings("unchecked")
//		public JsonResponse<Object> viewAllProjectByTypeId(String orgName, String orgDivision, String id) {
//			logger.info("Method : viewAllProjectByTypeId Dao starts");
//	
//			JsonResponse<Object> resp = new JsonResponse<Object>();
//	
//			try {
//				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
//				logger.info(value);
//				List<Object[]> list = em.createNamedStoredProcedureQuery("project_estimation_routines")
//						.setParameter("actionType", "viewAllProjectByTypeId").setParameter("actionValue", value).getResultList();
//				resp.setBody(list);
//				resp.setCode("Success");
//				resp.setMessage("Data Fetched Successfully");
//			} catch (Exception e) {
//				e.printStackTrace();
//				resp.setCode("Unsuccess");
//				resp.setMessage("Opps! Something went wrong");
//			}
//			logger.info("Method : viewAllProjectByTypeId Dao ends");
//			return resp;
//	
//		}
		/* saveAllCategories */
		@SuppressWarnings("unchecked")
		@Transactional
		public ResponseEntity<JsonResponse<Object>> saveAllCategories(String dataToSend, String userId, String org,
				String orgDiv) {
			logger.info("method: saveAllCategories Starts");

			JsonResponse<Object> resp = new JsonResponse<>();
			try {
				String value = "SET @categoryData='" + dataToSend + "', @p_userId='" + userId + "', @p_org='" + org
						+ "', @p_orgDiv='" + orgDiv + "';";
				

				String estmationId = "";
				try {
					Gson gson = new Gson();
					JsonObject jsonObject = gson.fromJson(dataToSend, JsonObject.class);
					if (jsonObject.has("estmationId")) {
						estmationId = jsonObject.get("estmationId").getAsString();
					}
				} catch (Exception parseException) {
					logger.error("Error parsing vitalData with Gson: ", parseException);
				}

				if (estmationId == null || estmationId.isEmpty()) {
					em.createNamedStoredProcedureQuery("project_estimation_routines").setParameter("actionType", "saveCategoryData")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Data saved successfully!");
					resp.setCode("Success");
				} else {
					em.createNamedStoredProcedureQuery("project_estimation_routines").setParameter("actionType", "modifiyCateData")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Data modified successfully!");
					resp.setCode("Success");
				}
			} catch (Exception e) {
				logger.error("Error in saveAllCategories: ", e);
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

			logger.info("method: saveAllCategories Ends");
			return response;
		}
		
		
		/*
		 * @SuppressWarnings("unchecked")
		 * 
		 * @Transactional public ResponseEntity<JsonResponse<Object>>
		 * saveAllCategories(String dataToSend, String userId, String org, String
		 * orgDiv) { logger.info("method: saveAllCategories Starts");
		 * 
		 * JsonResponse<Object> resp = new JsonResponse<>(); try { Gson gson = new
		 * Gson(); JsonObject jsonObject = gson.fromJson(dataToSend, JsonObject.class);
		 * 
		 * // Extract top-level fields String estimationId =
		 * jsonObject.has("estimationId") ? jsonObject.get("estimationId").getAsString()
		 * : null; String projectTypeId = jsonObject.get("projectTypeId").getAsString();
		 * String projectId = jsonObject.get("projectId").getAsString();
		 * 
		 * boolean isNew = (estimationId == null || estimationId.isEmpty());
		 * 
		 * // Extract activities and tasks JsonArray activities =
		 * jsonObject.getAsJsonArray("activities"); for (JsonElement activityElement :
		 * activities) { JsonObject activity = activityElement.getAsJsonObject(); String
		 * activityId = activity.get("activityId").getAsString();
		 * 
		 * JsonArray tasks = activity.getAsJsonArray("tasks"); for (JsonElement
		 * taskElement : tasks) { JsonObject task = taskElement.getAsJsonObject();
		 * String taskId = task.get("taskId").getAsString(); String taskName =
		 * task.get("taskName").getAsString();
		 * 
		 * // Build the dynamic SQL value String value = String.format(
		 * "SET @projectId='%s', @projectTypeId='%s', @activityId='%s', @taskId='%s', @p_userId='%s', @p_org='%s', @p_orgDiv='%s';"
		 * , projectId, projectTypeId, activityId, taskId, userId, org, orgDiv );
		 * System.out.println("value id printing like this =================>"+value);
		 * 
		 * // Call the stored procedure for each task
		 * em.createNamedStoredProcedureQuery("project_estimation_routines")
		 * .setParameter("actionType", isNew ? "saveCategoryData" : "modifiyCateData")
		 * .setParameter("actionValue", value) .execute(); } }
		 * 
		 * // Set success response resp.setMessage(isNew ? "Data saved successfully!" :
		 * "Data modified successfully!"); resp.setCode("Success");
		 * 
		 * } catch (Exception e) { logger.error("Error in saveAllCategories: ", e); try
		 * { String[] err = serverDao.errorProcedureCall(e); resp.setCode("Failed");
		 * resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong"); }
		 * catch (Exception nestedException) {
		 * logger.error("Error while handling exception: ", nestedException);
		 * resp.setCode("Failed");
		 * resp.setMessage("Oops! Something went wrong during error handling"); } }
		 * 
		 * ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp,
		 * HttpStatus.CREATED);
		 * 
		 * logger.info("method: saveAllCategories Ends"); return response; }
		 */

		
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<ProjectProdDetailsRestModel>>> viewSku() {
			logger.info("Method : viewSku Dao starts");
			List<ProjectProdDetailsRestModel> respList = new ArrayList<ProjectProdDetailsRestModel>();
			
			String value="";
			logger.info(value);
			
			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("project_estimation_routines").setParameter("actionType", "getAllSkuDetails")
						.setParameter("actionValue", value).getResultList();
				

				for (Object[] m : x) {

					ProjectProdDetailsRestModel restPayroll = new ProjectProdDetailsRestModel(m[0], m[1], m[2], m[3]);
					respList.add(restPayroll);
				}
				logger.info("VIEW" + respList);

			} catch (Exception e) {

				e.printStackTrace();

			}

			JsonResponse<List<ProjectProdDetailsRestModel>> resp = new JsonResponse<List<ProjectProdDetailsRestModel>>();
			resp.setBody(respList);
			resp.setCode("Succcess");
			resp.setMessage("Details fetched successfully");
			ResponseEntity<JsonResponse<List<ProjectProdDetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<ProjectProdDetailsRestModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("response" + response);
			logger.info("Method : viewSku Dao ends");

			logger.info("VIEWWWWWWWW" + respList);
			return response;

		}
		
		/* viewAllProjectDetailsByTypeId */
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewAllProjectDetailsByTypeId(String orgName, String orgDivision, String id,String type) {
			logger.info("Method : viewAllProjectDetailsByTypeId Dao starts");
	
			JsonResponse<Object> resp = new JsonResponse<Object>();
	
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "',@p_type='"+type+"';";
				logger.info(value);
				List<Object[]> list = em.createNamedStoredProcedureQuery("project_estimation_routines")
						.setParameter("actionType", "viewAllProjetDetails").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
				resp.setCode("Success");
				resp.setMessage("Data Fetched Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("Unsuccess");
				resp.setMessage("Opps! Something went wrong");
			}
			logger.info("Method : viewAllProjectDetailsByTypeId Dao ends");
			return resp;
	
		}

		/* saveAllEstimation */
		@SuppressWarnings("unchecked")
		@Transactional
		public ResponseEntity<JsonResponse<Object>> saveAllEstimation(String dataToSend, String userId, String org,
				String orgDiv) {
			logger.info("method: saveAllEstimation Starts");

			JsonResponse<Object> resp = new JsonResponse<>();
			try {
				String value = "SET @estimationData='" + dataToSend + "', @p_userId='" + userId + "', @p_org='" + org
						+ "', @p_orgDiv='" + orgDiv + "';";
				
				System.out.println("value for save saveAllEstimation coming like this =====================> "+value);

				String estmationId = "";
				try {
					Gson gson = new Gson();
					JsonObject jsonObject = gson.fromJson(dataToSend, JsonObject.class);
					if (jsonObject.has("estmationId")) {
						estmationId = jsonObject.get("estmationId").getAsString();
					}
				} catch (Exception parseException) {
					logger.error("Error parsing vitalData with Gson: ", parseException);
				}

				if (estmationId == null || estmationId.isEmpty()) {
					System.out.println("adding==================>");
					em.createNamedStoredProcedureQuery("project_estimation_routines").setParameter("actionType", "saveEstimationData")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Data saved successfully!");
					resp.setCode("Success");
				} else {
					System.out.println("modifying==================>");
					em.createNamedStoredProcedureQuery("project_estimation_routines").setParameter("actionType", "modifiyCateData")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Data modified successfully!");
					resp.setCode("Success");
				}
			} catch (Exception e) {
				logger.error("Error in saveVitalDetails: ", e);
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

			logger.info("method: saveAllEstimation Ends");
			return response;
		}
		

}
