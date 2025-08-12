package nirmalya.aatithya.restmodule.recruitment.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateHireActionParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateReviewProcessingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.recruitment.model.ActionEmployeeDetailsModel;
import nirmalya.aatithya.restmodule.recruitment.model.ReviewHiringProcessRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ReviewHiringProcessDao {

	Logger logger = LoggerFactory.getLogger(ReviewHiringProcessDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// view Candidate Listing

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCandidateListing(String organization, String orgDivision, String exp) {

		logger.info("Method : getCandidateListing Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String minExp = "";
		String maxExp = "";

		if (!exp.equals("")) {

			if (exp.contains("-")) {
				String expArray[] = exp.split("-");
				minExp = expArray[0];
				maxExp = expArray[1];
			} else {
				minExp = exp;
				maxExp = "999";
			}

		}
		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@min_exp='" + minExp
					+ "',@max_exp='" + maxExp + "';";

			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getCandidateListing").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getCandidateListing Dao ends");
		return resp;

	}

	// view Candidate Listing

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCandidateListingByDept(String organization, String orgDivision, String exp,
			String userId) {

		logger.info("Method : getCandidateListingByDept Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String minExp = "";
		String maxExp = "";

		if (!exp.equals("")) {

			if (exp.contains("-")) {
				String expArray[] = exp.split("-");
				minExp = expArray[0];
				maxExp = expArray[1];
			} else {
				minExp = exp;
				maxExp = "999";
			}

		}
		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@min_exp='" + minExp + "',@max_exp='" + maxExp + "';";

			System.err.println("value=Deptt==" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getCandidateListingByDept").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getCandidateListingByDept Dao ends");
		return resp;

	}

	// view requisition
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRequisitions(String userId, String organization, String orgDivision) {

		logger.info("Method : viewRequisitions Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_empId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getReuisitionList").setParameter("actionValue", value).getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : viewRequisitions Dao ends");
		return resp;

	}

	// Short listed candidates
	public ResponseEntity<JsonResponse<Object>> shortlistCandidate(ReviewHiringProcessRestModel data) {
		logger.info("Method : shortlistCandidate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		StringBuilder candidatePairs = new StringBuilder();

		if (data.getCandidateList() != null) {
			for (ReviewHiringProcessRestModel candidate : data.getCandidateList()) {
				if (candidate.getRequisitionId() != null && candidate.getCandidateId() != null) {
					candidatePairs.append("(\"").append(candidate.getRequisitionId()).append("\",\"")
							.append(candidate.getCandidateId()).append("\"),");
				}
			}
		}

		if (candidatePairs.length() > 0) {
			candidatePairs.setLength(candidatePairs.length() - 1);
		}

		// Final string with other variables
		String value = "SET @p_createdBy='" + data.getCreatedBy() + "', @p_orgName='" + data.getOrganization()
				+ "', @p_orgDiv='" + data.getOrgDivision() + "', @p_candidatePairs='" + candidatePairs.toString()
				+ "';";

		try {
			em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "shortlistCandidates").setParameter("actionValue", value).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, "Candidates Short Listed Successfully.");

		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : shortlistCandidate ends");
		return response;
	}

	// view requisition
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllShortlistedCandidates(String organization, String orgDivision) {

		logger.info("Method : getAllShortlistedCandidates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getAllShortlistedCandidates").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getAllShortlistedCandidates Dao ends");
		return resp;

	}

	/* Get Interviewer list to schedule interview */
	@SuppressWarnings("unchecked")
	public List<ActionEmployeeDetailsModel> interviewerList(String org, String orgDiv) {
		logger.info("Method : interviewerList Dao starts");

		List<ActionEmployeeDetailsModel> jobList = new ArrayList<ActionEmployeeDetailsModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getInterviewerList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ActionEmployeeDetailsModel dropDownModel = new ActionEmployeeDetailsModel(m[0], m[1], m[2]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : interviewerList Dao ends");

		return jobList;
	}

	/* Function for schedule Interview */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> scheduleInterview(ReviewHiringProcessRestModel action) {

		logger.info("Method : scheduleInterview starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = GenerateReviewProcessingParameter.scheduleInterviewForCandidate(action);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "scheduleInterview").setParameter("actionValue", values)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, null, ResponseStatus.success,
						"Interview Scheduled Successfully On " + action.getFromDate());

			} else {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);

				// Log the error message and code for debugging
				System.err.println("Error Code: " + err[0]);
				System.err.println("Error Message: " + err[1]);

				if (err[1].toString()
						.equals("Cannot insert: Overlapping date and time range detected for this interviewer.")) {
					Util.setJsonResponse(resp, null, ResponseStatus.failed,
							"This candidate or interviewer is already scheduled for another interview at this time. Please choose a different time.");
				} else if (err[1].toString().contains("Duplicate entry")) {
					Util.setJsonResponse(resp, null, ResponseStatus.failed,
							"An interview has already been scheduled for this candidate)" + action.getCandidateId()
									+ "). Please check the schedule or select a different candidate.");
				} else {
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : scheduleInterview ends");
		return response;

	}

	// get all scheduled interview
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> scheduledInterviews(String userId, String organization, String orgDivision) {

		logger.info("Method : scheduledInterviews Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getScheduledInterviews").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : scheduledInterviews Dao ends");
		return resp;

	}

	/*
	 * Function for add FeedBack
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addFeedbackDao(ReviewHiringProcessRestModel feedBackModel) {

		logger.info("Method : addFeedbackDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ReviewHiringProcessRestModel> listData = new ArrayList<ReviewHiringProcessRestModel>();

		try {
			// Check and set blank if null or blank value is received for feedbackId
			String feedbackId = feedBackModel.getFeedbackId();
			if (feedbackId == null || feedbackId.trim().isEmpty() || feedbackId.equals("null")) {
				feedbackId = "";
			}
			feedBackModel.setFeedbackId(feedbackId);

			String values = GenerateHireActionParameter.addFeedbackModified(feedBackModel);

			if (feedbackId.equals("")) {
				em.createNamedStoredProcedureQuery("requisitionReviewProcess").setParameter("actionType", "addFeedback")
						.setParameter("actionValue", values).execute();

				resp.setCode("success");
				resp.setMessage("Feedback saved successfully for Candidate.");

			} else {

				em.createNamedStoredProcedureQuery("requisitionReviewProcess")
						.setParameter("actionType", "modifyFeedback").setParameter("actionValue", values).execute();

				resp.setCode("success");
				resp.setMessage("Feedback modified successfully for Candidate.");
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addFeedbackDao ends");
		return response;
	}

	// Get Feedbacks

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFeedbacks(String userId, String organization, String orgDivision, String candId,
			String requiId,String type) {

		logger.info("Method : getFeedbacks Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_user='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "',@p_candId='" + candId + "',@p_reqId='" + requiId + "';";
            System.out.println(value);
			List<Object[]> x;
	        if ("interviwer".equals(type)) {  
	        	System.out.println("IF:::::::::");
	            x = em.createNamedStoredProcedureQuery("requisitionReviewProcess").setParameter("actionType", "getInterviwerFeedback")
	                .setParameter("actionValue", value)
	                .getResultList();
	        } else {
	        	System.out.println("Else:::::::::");
	            x = em.createNamedStoredProcedureQuery("requisitionReviewProcess").setParameter("actionType", "getFeedback")
	                .setParameter("actionValue", value)
	                .getResultList();
	        }
			

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getFeedbacks Dao ends");
		return resp;

	}

	// Get Selected candidates

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSelectedCandidates(String userId, String organization, String orgDivision,String reqId) {

		logger.info("Method : getSelectedCandidates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_reqId='" + reqId + "',@p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getSelectedCandidates").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getSelectedCandidates Dao ends");
		return resp;

	}

	// Get Hold candidates

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getHoldCandidates(String userId, String organization, String orgDivision,String reqId) {

		logger.info("Method : getHoldCandidates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_reqId='" + reqId + "',@p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getHoldCandidates").setParameter("actionValue", value).getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getHoldCandidates Dao ends");
		return resp;

	}

	// Get Rejected candidates

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRejectedCandidates(String userId, String organization, String orgDivision,String reqId) {

		logger.info("Method : getRejectedCandidates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_reqId='" + reqId + "',@p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getRejectedCandidates").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getRejectedCandidates Dao ends");
		return resp;

	}

	// Get Accpeted candidates

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAcceptedCandidates(String userId, String organization, String orgDivision,String reqId) {

		logger.info("Method : getAccpetedCandidates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_reqId='" + reqId + "',@p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getAccpetedCandidates").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getAccpetedCandidates Dao ends");
		return resp;

	}

	// Get Declined candidates

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDeclinedCandidates(String userId, String organization, String orgDivision,String reqId) {

		logger.info("Method : getDeclinedCandidates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_reqId='" + reqId + "',@p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getDeclinedCandidates").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getDeclinedCandidates Dao ends");
		return resp;

	}

	/* Function for schedule Interview */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> selectCandidate(ReviewHiringProcessRestModel action) {

		logger.info("Method : selectCandidate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = "SET @p_candId=\"" + action.getCandidateId() + "\",@p_reqId=\"" + action.getRequisitionId()
				+ "\",@p_band=\"" + action.getBandId() + "\",@p_createdBy=\"" + action.getCreatedBy()
				+ "\",@p_salary=\"" + action.getSalary() + "\",@p_joiningdate=\""
				+ DateFormatter.getStringDate(action.getJoiningdate()) + "\",@p_orgName=\"" + action.getOrganization()
				+ "\",@p_orgDiv=\"" + action.getOrgDivision() + "\";";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "candidateHire").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, null, ResponseStatus.success, "Candidate Selected Successfully");

			} else {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);

				// Log the error message and code for debugging
				System.err.println("Error Code: " + err[0]);
				System.err.println("Error Message: " + err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : selectCandidate ends");
		return response;

	}

	// Get Declined candidates
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> candidateOfferAcceptance(String userId, String organization, String orgDivision,
			String candId, String requiId, String status) {

		logger.info("Method : candidateOfferAcceptance Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "',@p_candId='" + candId + "',@p_reqId='" + requiId + "',@p_status='" + status + "';";

			em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "candidateOfferAcceptance").setParameter("actionValue", value)
					.execute();
			
			resp.setCode("Success");
			resp.setMessage("Candidate acceptance saved successfully.");

			
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : candidateOfferAcceptance Dao ends");
		return resp;

	}

	// Update Rounds
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> updateRounds(String userId, String organization, String orgDivision, String candId,
			String reqId, String status, String roundId) {

		logger.info("Method : updateRounds Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			if (reqId != null) {
				String value = "SET @p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
						+ "',@p_reqId='" + reqId + "',@p_candId='" + candId + "',@p_status='" + status
						+ "',@p_roundId='" + roundId + "';";
				System.out.println(value);

				List<String> resultList = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
						.setParameter("actionType", "updateRounds").setParameter("actionValue", value).getResultList();

				if (resultList != null && !resultList.isEmpty()) {
					String statusMessage = resultList.get(0);

					String customMessage = getStatusMessage(status);

					resp.setMessage(customMessage);
					resp.setCode("success");
				} else {
					Util.setJsonResponse(resp, null, ResponseStatus.success, "No update performed.");
				}
			} else {
				Util.setJsonResponse(resp, null, ResponseStatus.success, "No Requisition Id Found.");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		logger.info("Method : updateRounds Dao ends");
		return resp;
	}

	private String getStatusMessage(String status) {
		switch (status) {
		case "1":
			return "Candidate shortlisted in this round.";
		case "2":
			return "Candidate put on hold in this round.";
		case "3":
			return "Candidate rejected in this round.";
		default:
			return "Unknown status for this round.";
		}
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEmployeeList(String orgName, String orgDivision) {
		logger.info("Method : getEmployeeList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> list = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeList Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveJobRounds(String roundData, String userId, String org, String orgDiv) {
	    logger.info("method: saveJobRounds Dao Starts");

	    // Declare only once
	    JsonResponse<Object> resp = new JsonResponse<>();
	    boolean hasInsert = false;
	    boolean hasUpdate = false;

	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, Object> roundDataMap = mapper.readValue(roundData, new TypeReference<Map<String, Object>>() {});
	        List<Map<String, Object>> rounds = (List<Map<String, Object>>) roundDataMap.get("rounds");

	        for (Map<String, Object> round : rounds) {
	            String roundNumber = (String) round.get("roundNumber");
	            String requisitionId = (String) round.get("requisitionId");
	            String roundTitle = (String) round.get("roundTitle");
	            String roundDescription = (String) round.get("roundDescription");
	            String roundId = (String) round.get("roundId");

	            List<Map<String, Object>> interviewers = (List<Map<String, Object>>) round.get("interviewers");
	            String interviewersJson = mapper.writeValueAsString(interviewers);

	            String value = "SET @requisitionId='" + requisitionId + "',@roundNumber='" + roundNumber
	                    + "',@roundId='" + roundId + "',@roundTitle='" + roundTitle + "',@roundDescription='"
	                    + roundDescription + "',@p_userId='" + userId + "',@interviewersJson='" + interviewersJson
	                    + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
	            
	           System.out.println(value);

	            String actionType;
	            if (roundId == null || roundId.trim().isEmpty()) {
	                actionType = "saveInterviewRounds";
	                hasInsert = true;
	            } else {
	                actionType = "updateInterviewRounds";
	                hasUpdate = true;
	            }

	            em.createNamedStoredProcedureQuery("requisitionReviewProcess")
	                .setParameter("actionType", actionType)
	                .setParameter("actionValue", value)
	                .execute();
	        }

	        if (hasInsert && hasUpdate) {
	            resp.setMessage("Rounds Saved and Modified Successfully");
	        } else if (hasInsert) {
	            resp.setMessage("Rounds Saved Successfully");
	        } else if (hasUpdate) {
	            resp.setMessage("Rounds Modified Successfully");
	        } else {
	            resp.setMessage("No changes made.");
	        }

	        resp.setCode("Success");

	    } catch (Exception e) {
	        logger.error("Error in saveJobRounds: ", e);
	        resp.setMessage("Error saving job rounds!");
	        resp.setCode("Error");
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
	    logger.info("method: saveJobRounds Dao Ends");
	    return response;
	}

	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> updateJobRoundsOrders(String roundData, String userId, String org,
	        String orgDiv) {
	    logger.info("method: updateJobRoundsOrders Dao Starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, Object> roundDataMap = mapper.readValue(roundData, new TypeReference<Map<String, Object>>() {});
	        
	        String requisitionId = (String) roundDataMap.get("requisitionId");
	        List<Map<String, Object>> rounds = (List<Map<String, Object>>) roundDataMap.get("rounds");

	        for (Map<String, Object> round : rounds) {
	            String roundId = (String) round.get("roundId");
	            String newOrder = String.valueOf(round.get("newOrder"));
	            
	            String value = "SET @p_requisitionId='" + requisitionId + "',@p_roundId='" + roundId 
	                    + "',@p_newOrder='" + newOrder + "',@p_userId='" + userId 
	                    + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

	            em.createNamedStoredProcedureQuery("requisitionReviewProcess")
	                    .setParameter("actionType", "updateInterviewRoundsOrder")
	                    .setParameter("actionValue", value)
	                    .execute();
	        }
	        
	        resp.setMessage("Rounds order updated successfully!");
	        resp.setCode("Success");

	    } catch (Exception e) {
	        logger.error("Error in updateJobRoundsOrders: ", e);
	        resp.setMessage("Error updating job rounds order!");
	        resp.setCode("Error");
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
	    logger.info("method: updateJobRoundsOrders Dao Ends");
	    return response;
	    
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRoundsList(String requisitionId, String candId, String orgName, String orgDivision) {
		logger.info("Method : getRoundsList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @requisitionId='" + requisitionId + "',@candId='" + candId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
			
			List<Object[]> list = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getRoundsList").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRoundsList Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteRoundDetails(String roundId, String orgName, String orgDivision) {
		logger.info("Method : deleteRoundDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @roundId='" + roundId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
			
			 em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "deleteRound").setParameter("actionValue", value).execute();
			 
			resp.setCode("Success");
			resp.setMessage("Round Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteRoundDetails Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRoundsDetails(String roundId, String requisitionId, String candidateId,
			String orgName, String orgDivision) {
		logger.info("Method : getRoundsDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @roundId='" + roundId + "',@requisitionId='" + requisitionId + "',@candidateId='"
					+ candidateId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> list = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getRoundsDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRoundsDetails Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCandidateListingForEvaluation(String organization, String orgDivision,
			String userId) {

		logger.info("Method : getCandidateListingForEvaluation Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@userId='" + userId
					+ "';";

			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getCandidateForEvaluation").setParameter("actionValue", value)
					.getResultList();

			System.out.println(x);
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");

		} catch (Exception e) {
			e.printStackTrace();

		}
		logger.info("Method : getCandidateListingForEvaluation Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCandidateEvaluationById(String organization, String orgDivision,
			String userId,String candidateId,String requisitionId) {

		logger.info("Method : getCandidateEvaluationById Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@userId='" + userId
					+ "',@candidateId='" + candidateId + "',@requisitionId='" + requisitionId + "';";

			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getCandidateForEvaluationById").setParameter("actionValue", value)
					.getResultList();

			System.out.println(x);
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");

		} catch (Exception e) {
			e.printStackTrace();

		}
		logger.info("Method : getCandidateEvaluationById Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveInterviewersResponse(String userId, String type, String roundId, String reqId,
			String candidateId) {

		logger.info("Method : saveInterviewersResponse Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String status = "";

			if ("interview-completed".equals(type)) {
				status = "completed";
			} else {
				status = "";
			}

			String value = "SET @userId='" + userId + "',@status='" + status + "',@roundId='" + roundId + "',@reqId='"
					+ reqId + "',@candidateId='" + candidateId + "';";

			System.out.println(value);

			em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "saveInterviewersResponse").setParameter("actionValue", value)
					.execute();

			resp.setCode("Success");
			resp.setMessage("Data save Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : saveInterviewersResponse Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRequisitionsForCandidateSelection(String userId, String organization,
			String orgDivision) {

		logger.info("Method : getRequisitionsForCandidateSelection Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_empId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getRequisitionsForCandidate").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getRequisitionsForCandidateSelection Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getInterviewersDashboardData(String userId, String organization,
			String orgDivision) {

		logger.info("Method : getInterviewersDashboardData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getInterviewersDashboardData").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getInterviewersDashboardData Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRequisitionsCandidateList(String userId, String organization, String orgDivision,
			String reqId) {

		logger.info("Method : getRequisitionsCandidateList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_empId='" + userId + "',@p_reqId='" + reqId + "',@p_org='" + organization
					+ "',@p_orgDiv='" + orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getRequisitionsAllCandidateRounds").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getRequisitionsCandidateList Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> shortlistFinalCandidate(String data, String userId, String org,
			String orgDiv, String reqId) {
		logger.info("method: shortlistFinalCandidate Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			JsonNode jsonNode = objectMapper.readTree(data);

			// Extract candidateIds as a comma-separated string
			JsonNode candidateIdsNode = jsonNode.get("candidateIds");
			String candidateIds = "";
			if (candidateIdsNode != null && candidateIdsNode.isArray()) {
				candidateIds = String.join(",", objectMapper.convertValue(candidateIdsNode, List.class));
			}

			// Prepare SQL query
			String value = "SET @p_userId='" + userId + "',@candidateJson='" + data + "',@candidateIds='" + candidateIds
					+ "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_reqId='" + reqId + "';";
			
			System.out.println("PK:::::::::::"+value);

			em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "shortlist-final-candidate").setParameter("actionValue", value)
					.execute();

			resp.setMessage("Candidate Shortlisted Successfully!");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Error in shortlist candidate: ", e);
			resp.setMessage("Error saving shortlist candidate");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		logger.info("method: shortlistFinalCandidate Dao Ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getForwardedCandidateList(String userId, String organization, String orgDivision,
			String reqId) {

		logger.info("Method : getForwardedCandidateList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_empId='" + userId + "',@p_reqId='" + reqId + "',@p_org='" + organization
					+ "',@p_orgDiv='" + orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getForwardedCandidateList").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getForwardedCandidateList Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> candidateShortlistByModerator(String data, String userId, String org,
			String orgDiv) {
		logger.info("method: candidateShortlistByModerator Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {

			JSONObject jsonData = new JSONObject(data);
			JSONArray candidateDataArray = jsonData.getJSONArray("candidateDataObj");
			String remarks = jsonData.optString("remarks", ""); // Extract remarks

			// Convert candidateDataObj back to string
			String candidateJson = candidateDataArray.toString();

			String value = "SET @p_userId='" + userId + "', @candidateJson='" + candidateJson + "', @p_remarks='"
					+ remarks + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
			System.out.println(value);

			em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "shortlist-candidates-by-moderator").setParameter("actionValue", value)
					.execute();

			resp.setMessage("Candidate Shortlisted Successfully!");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Error in shortlist candidate: ", e);
			resp.setMessage("Error saving shortlist candidate");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		logger.info("method: candidateShortlistByModerator Dao Ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> shortlistHoldCandidate(String data, String userId, String org,
	        String orgDiv) {
	    logger.info("method: shortlistHoldCandidate Dao Starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    try {
	        JSONObject jsonData = new JSONObject(data);
	        JSONArray candidateIdArray = new JSONArray(jsonData.optString("candidateId"));
	        JSONArray jobIdArray = new JSONArray(jsonData.optString("jobId"));
	        String candidateId = candidateIdArray.length() > 0 ? candidateIdArray.getString(0) : "";
	        String jobId = jobIdArray.length() > 0 ? jobIdArray.getString(0) : "";
	        String status = jsonData.optString("status"); 

	        String value = "SET @p_userId='" + userId + "', @candidateId='" + candidateId + "',@jobId='" + jobId + "', @status='"
	                + status + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
	        System.out.println(value);

	        String actionType;
	        String successMessage;
	        
	        if ("1".equals(status)) {
	            actionType = "shortlist-hold-candidates";
	            successMessage = "Candidate Shortlisted Successfully!";
	        } else if ("0".equals(status)) {
	            actionType = "reject-hold-candidates";
	            successMessage = "Candidate Rejected Successfully!";
	        } else {
	            throw new IllegalArgumentException("Invalid status value: " + status);
	        }

	        em.createNamedStoredProcedureQuery("requisitionReviewProcess")
	                .setParameter("actionType", actionType)
	                .setParameter("actionValue", value)
	                .execute();

	        resp.setMessage(successMessage);
	        resp.setCode("Success");

	    } catch (Exception e) {
	        logger.error("Error in processing candidate: ", e);
	        resp.setMessage("Error processing candidate");
	        resp.setCode("Error");
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
	    logger.info("method: shortlistHoldCandidate Dao Ends");
	    return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> releaseCandidateOfferLetter(String candidateId,String requisitionId,String userId) {

		logger.info("Method : releaseCandidateOfferLetter Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @userId='" + userId + "',@candidateId='" + candidateId + "',@requisitionId='" + requisitionId + "';";

			 em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "releaseCandidateOffer").setParameter("actionValue", value)
					.execute();
			resp.setCode("Success");
			resp.setMessage("Offer letter sent successfully");

		} catch (Exception e) {
			e.printStackTrace();

		}
		logger.info("Method : releaseCandidateOfferLetter Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getJobDetailsForCandidates(String jobId) {

		logger.info("Method : getJobDetailsForCandidates Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @jobId='" + jobId  + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
					.setParameter("actionType", "getJobDetailsForCandidates").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("Method : getJobDetailsForCandidates Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getJobListsForCandidates(String search, String location) {
	    logger.info("Fetching job lists with search: " + search + ", location: " + location);

	    JsonResponse<Object> resp = new JsonResponse<Object>();
	    try {
	        // Ensure both search and location are properly handled
	        String value = "SET @p_search=" + (search == null || search.isEmpty() ? "NULL" : "'" + search + "'") + 
	                       ", @p_location=" + (location == null || location.isEmpty() ? "NULL" : "'" + location + "'") + ";";
	        
	        System.out.println(value);
	        
	        List<Object[]> resultList = em.createNamedStoredProcedureQuery("requisitionReviewProcess")
	                .setParameter("actionType", "getJobListsForCandidates")
	                .setParameter("actionValue", value)
	                .getResultList();

	        if (!resultList.isEmpty()) {
	            Util.setJsonResponse(resp, resultList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
	        } else {
	            Util.setJsonResponse(resp, resultList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
	    }

	    return resp;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveAnalysisDataOfCandidate(String data, String userId, String org, String orgDiv) {
	    logger.info("method: saveAnalysisDataOfCandidate Dao Starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    try {
	        JSONObject jsonData = new JSONObject(data); // Convert incoming string to JSON

	        String jobId = jsonData.optString("jobId");
	        String candidateId = jsonData.optString("candidateId");
	        String overallScore = jsonData.optString("overallScore");
	        JSONObject analysisDataObject = jsonData.optJSONObject("analysisData");

	        String analysisData = analysisDataObject != null ? analysisDataObject.toString() : "";


	        // Construct the value string to be passed to the stored procedure
	        String value = "SET @p_userId='" + userId + "'," +
	                       "@jobId='" + jobId + "'," +
	                       "@analysisData='" + analysisData.replace("'", "''") + "'," +  // escape single quotes
	                       "@candidateId='" + candidateId + "'," +
	                       "@overallScore='" + overallScore + "'," +
	                       "@p_org='" + org + "'," +
	                       "@p_orgDiv='" + orgDiv + "';";

	        logger.info("Procedure Params: " + value);

	        em.createNamedStoredProcedureQuery("requisitionReviewProcess")
	            .setParameter("actionType", "save-ai-analysis-report")
	            .setParameter("actionValue", value)
	            .execute();

	        resp.setMessage("Analysis Save Successfully!");
	        resp.setCode("Success");

	    } catch (Exception e) {
	        logger.error("Error in shortlist candidate: ", e);
	        resp.setMessage("Error saving shortlist candidate");
	        resp.setCode("Error");
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
	    logger.info("method: saveAnalysisDataOfCandidate Dao Ends");
	    return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> candidatePreInvAccess(String data, String userId, String org, String orgDiv) {
	    logger.info("method: candidatePreInvAccess Dao Starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    try {
	        JSONObject jsonData = new JSONObject(data); 

	        String jobId = jsonData.optString("jobId");
	        String candidateId = jsonData.optString("candidateId");
	        String status = jsonData.optString("status");

	        String value = "SET @p_userId='" + userId + "'," +
	                       "@jobId='" + jobId + "'," +
	                       "@candidateId='" + candidateId + "'," +
	                       "@status='" + status + "'," +
	                       "@p_org='" + org + "'," +
	                       "@p_orgDiv='" + orgDiv + "';";

	        logger.info("Procedure Params: " + value);

	        em.createNamedStoredProcedureQuery("requisitionReviewProcess")
	            .setParameter("actionType", "save-candidate-pre-inv-access")
	            .setParameter("actionValue", value)
	            .execute();


	    } catch (Exception e) {
	        logger.error("Error in pre inv candidate: ", e);
	        resp.setMessage("Error saving pre inv candidate");
	        resp.setCode("Error");
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
	    logger.info("method: candidatePreInvAccess Dao Ends");
	    return response;
	}



}
