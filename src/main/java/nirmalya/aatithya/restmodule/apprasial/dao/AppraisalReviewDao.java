package nirmalya.aatithya.restmodule.apprasial.dao;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.MailService;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AppraisalReviewDao {

	Logger logger = LoggerFactory.getLogger(AppraisalReviewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	MailService mailService;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllFeedbackEmployee(String orgName, String orgDivision, String id,String finYear) {
		logger.info("Method : getAllEmployee Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + id + "',@p_finYear= '"+ finYear + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_review_routines")
					.setParameter("actionType", "getAllReviewEmployee").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllFeedbackEmployee Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllEmployee() {

		logger.info("Method : getAllEmployee starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("appraisal_review_routines")
					.setParameter("actionType", "getAllEmployee").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllEmployee ends" + departType);
		return departType;
	}

	/* saveAppraisalKraDetails */
//	@Transactional
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<Object>> savemanageRemarks(String managerRemarksData, String userId, String org,
//			String orgDiv,String baseUrl) {
//		logger.info("method: savemanageRemarks Dao Starts");
//
//		JsonResponse<Object> resp = new JsonResponse<>();
//		try {
//			String value = "SET @p_allData='" + managerRemarksData + "', @p_userId='" + userId + "', @p_org='" + org
//					+ "', @p_orgDiv='" + orgDiv + "';";
//
//
//			String reviewId = "";
//			Gson gson = new Gson();
//			JsonObject jsonObject = null;
//
//			try {
//				jsonObject = gson.fromJson(managerRemarksData, JsonObject.class);
//				if (jsonObject.has("reviewId")) {
//					reviewId = jsonObject.get("reviewId").getAsString();
//				}
//			} catch (Exception parseException) {
//				logger.error("Error parsing managerRemarksData with Gson: ", parseException);
//			}
//
//
//			if (reviewId == null || reviewId.trim().isEmpty()) {
//				List<String> feedbackIdList = em.createNamedStoredProcedureQuery("appraisal_review_routines")
//						.setParameter("actionType", "saveManagerRemarks").setParameter("actionValue", value)
//						.getResultList();
//
//				String newFeedbackId = feedbackIdList.get(0).toString();
//
//				resp.setMessage("Feedback Forwarded successfully!");
//				resp.setCode("Success");
//
//
//				// Send Email Notification
//				if (jsonObject != null && jsonObject.has("managerEmail")) {
//					JsonArray emails = jsonObject.getAsJsonArray("managerEmail");
//
//					String encodedFeedbackId = Base64.getEncoder().encodeToString(newFeedbackId.getBytes());
//
//					for (JsonElement emailElement : emails) {
//						String email = emailElement.getAsString();
//						System.out.println("email==============================>" + email);
//
//						String subject = "📝 Feedback Request for Employee Review";
//						String feedbackLink = baseUrl + "feedback-form?id=" + encodedFeedbackId;
//						System.out.println("===================>feedbackLink"+ feedbackLink);
//
//						String message = "Dear Manager,\n\n"
//								+ "You are kindly requested to provide your feedback for an employee appraisal.\n"
//								+ "Please use the link below to access the feedback form:\n\n" + feedbackLink + "\n\n"
//								+ "Your input is valuable and helps in performance evaluations.\n\n"
//								+ "Best regards,\nHR Team";
//
//						try {
//							mailService.sendEmail(email, subject, message);
//						} catch (Exception ex) {
//							logger.error("Error sending email to " + email + ": ", ex);
//						}
//					}
//				}
//
//			} else {
//				List<String> feedbackId = em.createNamedStoredProcedureQuery("appraisal_review_routines")
//						.setParameter("actionType", "modifyManagerRemarks").setParameter("actionValue", value)
//						.getResultList();
//
//				resp.setMessage("Data modified successfully!");
//				resp.setCode("Success");
//
//				System.out.println(feedbackId);
//			}
//
//		} catch (Exception e) {
//			logger.error("Error in savemanageRemarks: ", e);
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
//		logger.info("method: savemanageRemarks Dao Ends");
//		return response;
//	}

	@Transactional
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> savemanageRemarks(String managerRemarksData, String userId, String org,
			String orgDiv, String baseUrl) {
		logger.info("method: savemanageRemarks Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @p_allData='" + managerRemarksData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			String reviewId = "";
			String empName = "";
			Gson gson = new Gson();
			JsonObject jsonObject = null;

			try {
			    if (managerRemarksData != null && !managerRemarksData.trim().isEmpty()) {
			        jsonObject = gson.fromJson(managerRemarksData, JsonObject.class);
			        
			        if (jsonObject != null) {
			            if (jsonObject.has("reviewId") && !jsonObject.get("reviewId").isJsonNull()) {
			                reviewId = jsonObject.get("reviewId").getAsString();
			            }

			            if (jsonObject.has("empName") && !jsonObject.get("empName").isJsonNull()) {
			                empName = jsonObject.get("empName").getAsString();
			            }
			        }
			    }
			} catch (Exception parseException) {
			    logger.error("Error parsing managerRemarksData with Gson: ", parseException);
			}


			if (reviewId == null || reviewId.trim().isEmpty()) {
				// Save new remarks
				List<String> feedbackIdList = em.createNamedStoredProcedureQuery("appraisal_review_routines")
						.setParameter("actionType", "saveManagerRemarks").setParameter("actionValue", value)
						.getResultList();

				String newFeedbackId = feedbackIdList.get(0).toString();

				resp.setMessage("Feedback Forwarded successfully!");
				resp.setCode("Success");

				if (jsonObject != null && jsonObject.has("managerList")) {
					JsonArray managerList = jsonObject.getAsJsonArray("managerList");

					for (JsonElement managerElement : managerList) {
						JsonObject manager = managerElement.getAsJsonObject();

						String email = manager.has("email") && !manager.get("email").isJsonNull()
								? manager.get("email").getAsString().trim()
								: "";

						String managerId = manager.has("managerId") && !manager.get("managerId").isJsonNull()
								? manager.get("managerId").getAsString().trim()
								: "";

						String managerName = manager.has("managerName") && !manager.get("managerName").isJsonNull()
								? manager.get("managerName").getAsString().trim()
								: "";

						String displayName = (managerName == null || managerName.trim().isEmpty()) ? "Sir/Madam"
								: managerName;
						
                        System.out.println("==================> " +empName);

						// Encode even if managerId is empty — it's fine
						if (!email.isEmpty()) {
							try {
								String cleanFeedbackId = (newFeedbackId != null) ? newFeedbackId.trim() : "";
								String cleanEmail = (email != null) ? email.trim() : "";
								String cleanManagerId = (managerId != null) ? managerId.trim() : "";

								String combined = cleanFeedbackId + "::" + cleanEmail + "::" + cleanManagerId;
								String encodedCombined = Base64.getEncoder().encodeToString(combined.getBytes("UTF-8"));

								String feedbackLink = baseUrl + "feedback-form?id=" + encodedCombined;

								String subject = "📝 Feedback Request for Employee Review";

								String message = "<html><body style='font-family: Arial, sans-serif;'>"
										+ "<p>Dear <strong>" + displayName + "</strong>,</p>"
										+ "<p>You are kindly requested to provide your feedback for the appraisal of <strong>" + empName + "</strong>.</p>"
										+ "<p><a href=\"" + feedbackLink
										+ "\" style=\"padding: 10px 15px; background-color: rgb(191, 5, 255); color: white; text-decoration: none; border-radius: 5px;\">Click here to give your feedback</a></p>"
										+ "<p>Your input is valuable and will contribute to the performance evaluation process.</p>"
										+ "<p>Best regards,<br>HR Team</p>"
										+ "</body></html>";


								mailService.sendHtmlEmail(email, subject, message);

							} catch (Exception ex) {
								logger.error("Error sending email to " + email + ": ", ex);
							}
						}
					}
				}

			} else {
				// Modify existing remarks
				List<String> feedbackId = em.createNamedStoredProcedureQuery("appraisal_review_routines")
						.setParameter("actionType", "modifyManagerRemarks").setParameter("actionValue", value)
						.getResultList();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");

				System.out.println(feedbackId);
			}

		} catch (Exception e) {
			logger.error("Error in savemanageRemarks: ", e);
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
		logger.info("method: savemanageRemarks Dao Ends");
		return response;
	}

	/* getAllReviewById */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllReviewById(String orgName, String orgDivision, String id,String email) {
		logger.info("Method : getAllReviewById Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_feedbackId='" + id + "',@p_email='"+ email +"';";
			logger.info(value);

			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_review_routines")
					.setParameter("actionType", "getAllReviewById").setParameter("actionValue", value).getResultList();
			resp.setBody(list);

			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllReviewById Dao ends");
		return resp;
	}

	/* getAllKraLists */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllKraLists(String orgName, String orgDivision, String id) {
		logger.info("Method : getAllKraLists Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_designation_id='" + id
					+ "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_review_routines")
					.setParameter("actionType", "getAllKraList").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllKraLists Dao ends");
		return resp;
	}

	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveFeedback(String responseData, String userId, String org,
			String orgDiv, String baseUrl) {
		logger.info("method: savemanageRemarks Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		
			String value = "SET @p_allData='" + responseData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";
			System.out.println("value is coming like this =========================> " + value);
			try {
		 em.createNamedStoredProcedureQuery("appraisal_review_routines")
					.setParameter("actionType", "saveFeedback").setParameter("actionValue", value)
					.execute();


			resp.setMessage("Feedback Submitted successfully!");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Error in savemanageRemarks: ", e);
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
		logger.info("method: savemanageRemarks Dao Ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllFeedbackDetails(String orgName, String orgDivision, String id,String finYear) {
		logger.info("Method : getAllFeedbackDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_emp_id='" + id
					+ "',@p_finYear='" + finYear + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_review_routines")
					.setParameter("actionType", "getAllFeedbackDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllFeedbackDetails Dao ends");
		return resp;
	}

}