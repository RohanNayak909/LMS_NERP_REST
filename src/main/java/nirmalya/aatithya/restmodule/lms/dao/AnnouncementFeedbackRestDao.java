package nirmalya.aatithya.restmodule.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AnnouncementFeedbackRestDao {
	Logger logger = LoggerFactory.getLogger(AnnouncementFeedbackRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// save
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveAnnouncement(String announceData, String userId, String org,
			String orgDiv) {
		logger.info("method: saveAnnouncement Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @announceData='" + announceData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			String announcementId = "";
			logger.info("Constructed actionValue: " + value);
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(announceData, JsonObject.class);
				if (jsonObject.has("announcementId")) {
					announcementId = jsonObject.get("announcementId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing courseData with Gson: ", parseException);
			}

			if (announcementId == null || announcementId.isEmpty()) {
				em.createNamedStoredProcedureQuery("announcement_feedback_routines")
						.setParameter("actionType", "saveAnnouncement").setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("announcement_feedback_routines")
						.setParameter("actionType", "modifyAnnouncement").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in saveCourse: ", e);
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

		logger.info("method: saveAnnouncement Ends" + response);
		return response;
	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAnnouncement(String orgName, String orgDivision) {
		logger.info("Method : viewAnnouncement Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("announcement_feedback_routines")
					.setParameter("actionType", "viewAnnouncement").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAnnouncement Dao ends");
		return resp;

	}

	// edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAnnouncement(String Id, String organization, String orgDivision) {
		logger.info("Method : editAnnouncement Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_announcementId='" + Id + "';";

			logger.info("vvvv" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("announcement_feedback_routines")
					.setParameter("actionType", "editAnnouncement").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editAnnouncement Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStudent(String orgName, String orgDivision) {
		logger.info("Method : viewStudent Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("announcement_feedback_routines")
					.setParameter("actionType", "viewStudent").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewStudent Dao ends");
		return resp;

	}

//FEEDBACK

	// save
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveFeedback(String feedbackData, String userId, String org,
			String orgDiv) {
		logger.info("method: saveFeedback Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(feedbackData, JsonObject.class);
			String value = "SET @feedbackData='" + feedbackData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			String feedbackId = "";
			logger.info("Constructed actionValue: " + value);
			try {

				if (jsonObject.has("feedbackId")) {
					feedbackId = jsonObject.get("feedbackId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing courseData with Gson: ", parseException);
			}

			if (feedbackId == null || feedbackId.isEmpty()) {
				em.createNamedStoredProcedureQuery("announcement_feedback_routines")
						.setParameter("actionType", "saveFeedback").setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("announcement_feedback_routines")
						.setParameter("actionType", "modifyFeedback").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in saveCourse: ", e);
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

		logger.info("method: saveFeedback Ends" + response);
		return response;
	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewFeedback(String orgName, String orgDivision) {
		logger.info("Method : viewFeedback Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("announcement_feedback_routines")
					.setParameter("actionType", "viewFeedback").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewFeedback Dao ends");
		return resp;

	}

	// edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editFeedback(String Id, String organization, String orgDivision) {
		logger.info("Method : editFeedback Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_feedbackId='" + Id + "';";

			logger.info("vvvv" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("announcement_feedback_routines")
					.setParameter("actionType", "editFeedback").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editFeedback Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAnnouncementAndFeedback(String orgName, String orgDivision, String userId) {
		logger.info("Method : getAnnouncementAndFeedback Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @userId = '\"" + userId + "\"',@createdBy = '" + userId + "';";

			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("announcement_feedback_routines")
					.setParameter("actionType", "getAnnouncementAndFeedback").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : getAnnouncementAndFeedback Dao ends" + resp);
		return resp;

	}

	// save
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveUserFeedback(String userFeedbackData, String orgName,
			String orgDivision, String userId) {
		logger.info("method: saveFeedback Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			
			System.out.println(userFeedbackData);
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(userFeedbackData, JsonObject.class);
			String feedbackId = jsonObject.get("feedbackId").getAsString();
			String userName = jsonObject.get("userName").getAsString();
			String ratings = jsonObject.get("ratings").toString();
			
			String value = "SET @feedbackId='" + feedbackId + "',@ratings='" + ratings + "',@userName='" + userName + "', @p_userId='" + userId + "', @p_org='"
					+ orgName + "', @p_orgDiv='" + orgDivision + "';";
			
			System.out.println(value);

			em.createNamedStoredProcedureQuery("announcement_feedback_routines")
					.setParameter("actionType", "saveUserFeedback").setParameter("actionValue", value).execute();

			resp.setMessage("Feedback given successfully!");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Error in saveFeedback: ", e);
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

		logger.info("method: saveFeedback Ends" + response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllUsersFeedbacks(String orgName, String orgDivision,String feedbackId) {
		logger.info("Method : getAllUsersFeedbacks Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_feedbackId='" + feedbackId + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("announcement_feedback_routines")
					.setParameter("actionType", "getAllUsersFeedbacks").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAllUsersFeedbacks Dao ends");
		return resp;

	}

}
