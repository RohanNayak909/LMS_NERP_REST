package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestCrmInvitedMeetingsDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmInvitedMeetingsDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> invitedMeetingDtls(String id) {
		logger.info("Method : invitedMeetingInfo starts----------------------------");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			List<Object> x = em.createNamedStoredProcedureQuery("crm_invitedmeetings_routines")
					.setParameter("actionType", "invitedMeetingDtls").setParameter("actionValue", id).getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("Success");
			resp.setMessage("Meetings fetched successfully.");
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage("Something went wrong!");
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		logger.info("Method : invitedMeetingInfo ends");
	
		return resp;
	}

}
