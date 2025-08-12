package nirmalya.aatithya.restmodule.master.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestEventFeedbackDao {
	Logger logger = LoggerFactory.getLogger(RestEventFeedbackDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEventFeedback(String userId, String orgName, String orgDivision) {
		logger.info("Method : getEventFeedback Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "eventFeedback").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEventFeedback Dao ends" + resp);
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> addFeedback(String itm, String eventId, String attendeesId
			,String userId,String orgName,String orgDivision,String status,String eventType,String rating) {
		logger.info("Method : addFeedback dao starts" + itm);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_eventId='" + eventId + "',@itm='" + itm + "'"
					+ ",@p_attendeesId='"+attendeesId+"',@p_userId='"+userId+"',@p_orgName='"+orgName+"'"
					+ ",@p_orgDivision='"+orgDivision+"',@p_status='"+status+"',@p_eventType='"+eventType+"'"
					+ ",@p_rating='"+rating+"';";
			System.out.println("Updated Seert ID: " + value);
			em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines").setParameter("actionType", "approveFeedback")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data Saved Successfully");
			
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addFeedback dao ends");
		return response;

	}
}
