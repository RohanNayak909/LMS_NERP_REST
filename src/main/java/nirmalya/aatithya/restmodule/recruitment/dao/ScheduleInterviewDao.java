package nirmalya.aatithya.restmodule.recruitment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;
import nirmalya.aatithya.restmodule.recruitment.model.HireActionModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ScheduleInterviewDao {

	Logger logger = LoggerFactory.getLogger(ScheduleInterviewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/* Function for get Schedule Details */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HireActionModel>>> getScheduleInterview(String orgName, String orgDivision,
			String userId) {

		logger.info("Method : getScheduleDetails starts");

		List<HireActionModel> list = new ArrayList<HireActionModel>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "getScheduleInterview").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				String sDate = null;
				if (m[3] != null) {
					sDate = m[3].toString();
				}

				String date = null;
				if (m[2] != null) {
					date = m[2].toString();
				}

				HireActionModel dropDownModel = new HireActionModel(m[0], m[1], date, sDate, m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], null, null, null, m[11], m[12], m[13], m[14]);
				list.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HireActionModel>> resp = new JsonResponse<List<HireActionModel>>();
		resp.setBody(list);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HireActionModel>>> response = new ResponseEntity<JsonResponse<List<HireActionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getScheduleDetails ends" + response);
		return response;

	}

//
	// Function for View FeedBack
	@SuppressWarnings("unchecked")
	public JsonResponse<List<HireActionModel>> getFeedbackList(String id, String userId, String candId) {

		logger.info("Method : getFeedbackList starts");

		List<HireActionModel> list = new ArrayList<HireActionModel>();

		String value = "SET @p_reqId='" + id + "',@p_userId='" + userId + "',@p_candId='" + candId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "getFeedbackListData").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				HireActionModel feedback = new HireActionModel(m[0], m[1], m[2], null, null, m[3], null, m[4], null,
						null, null, null, null, null, null, null, null, m[5], null, m[6], null);
				list.add(feedback);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<HireActionModel>> resp = new JsonResponse<List<HireActionModel>>();
		resp.setBody(list);

		logger.info("Method : getFeedbackList ends");
		return resp;

	}

//
	/*
	 * Function for edit Feedback
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<HireActionModel>> editScheduleFeedbackDetails(String feedId, String candId,
			String userId) {
		logger.info("Method : editScheduleFeedbackDetails starts");

		JsonResponse<List<HireActionModel>> resp = new JsonResponse<List<HireActionModel>>();
		List<HireActionModel> feedbackList = new ArrayList<HireActionModel>();

		try {
			String values = "SET @p_feedbackId='" + feedId + "', @p_candId='" + candId + "',@p_userId='" + userId
					+ "';";
			logger.info("values===" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "editScheduleFeedbackDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object DATE = null;
				if (m[4] != null) {
					DATE = m[4].toString();
				}
				HireActionModel feedback = new HireActionModel(m[0], m[1], m[2], m[3], DATE, m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], null, m[18], m[19]);
				feedbackList.add(feedback);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(feedbackList);
		logger.info("resp===" + resp);
		logger.info("Method : editScheduleFeedbackDetails ends");
		return resp;
	}

//
	public JsonResponse<AddRecruitentModel> submitFeedbackApply(String submitId) {
		logger.info("Method : submitFeedbackApply starts");

		AddRecruitentModel req = new AddRecruitentModel();
		JsonResponse<AddRecruitentModel> resp = new JsonResponse<AddRecruitentModel>();

		try {
			String value = "SET @p_feedbackId='" + submitId + "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("hireActionRoutines").setParameter("actionType", "submitFeedbackApply")
					.setParameter("actionValue", value).execute();

			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Data added successfully");
		} catch (Exception e) {
			try {
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				// resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				logger.error("approveRequisitionapply: " + e.getMessage());
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : submitFeedbackApply ends");
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCandidateDetails(String userId,String orgName,String orgDivision ,String candidateId,String requisitionId) {
		logger.info("Method : submitFeedbackApply starts");

		AddRecruitentModel req = new AddRecruitentModel();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String values = "SET @p_candidateId='" + candidateId + "', @p_requisitionId='" + requisitionId + "',@p_orgName='" +
					orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			logger.info("value===" + values);
			
			List<Object []> x = em.createNamedStoredProcedureQuery("hireActionRoutines").setParameter("actionType", "getCandidateDetails")
					.setParameter("actionValue", values).getResultList();

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
}
