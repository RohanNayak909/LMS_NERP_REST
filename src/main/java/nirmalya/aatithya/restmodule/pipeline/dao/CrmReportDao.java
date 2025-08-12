package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class CrmReportDao {
	Logger logger = LoggerFactory.getLogger(CrmReportDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getLeadData(String userId, String orgName, String orgDivision, String fromDate, String toDate,
			String filterObj) {
		logger.info("Method : getLeadData starts");
		JsonResponse jsonResp = new JsonResponse();

		String value = "SET @userId='" + userId + "',@orgName='" + orgName + "',@orgDiv='" + orgDivision
				+ "',@fromDate='" + fromDate + "'," + "@toDate='" + toDate + "', @json_data='" + filterObj + "';";
		logger.info("Required string then value 1 : {}", value);

		JSONObject filterJson = new JSONObject(filterObj);
		String requestType = filterJson.optString("type");
		try {
			if (requestType.equals("lead")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmReports_routines")
						.setParameter("actionType", "getLeadReports").setParameter("actionValue", value)
						.getResultList();
				if (x.get(0) == null) {
					jsonResp.setCode("Failed");
					jsonResp.setMessage("No Data Found!");
				} else {
					jsonResp.setBody(x.get(0));
					jsonResp.setCode("Success");
				}
			} else if (requestType.equals("contact")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmReports_routines")
						.setParameter("actionType", "getContactReports").setParameter("actionValue", value)
						.getResultList();
				if (x.get(0) == null) {
					jsonResp.setCode("Failed");
					jsonResp.setMessage("No Data Found!");
				} else {
					jsonResp.setBody(x.get(0));
					jsonResp.setCode("Success");
				}
			} else if (requestType.equals("meeting")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmReports_routines")
						.setParameter("actionType", "getMeetingsReports").setParameter("actionValue", value)
						.getResultList();
				if (x.get(0) == null) {
					jsonResp.setCode("Failed");
					jsonResp.setMessage("No Data Found!");
				} else {
					jsonResp.setBody(x.get(0));
					jsonResp.setCode("Success");
				}
			} else if (requestType.equals("deals")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmReports_routines")
						.setParameter("actionType", "getDealsReports").setParameter("actionValue", value)
						.getResultList();
				if (x.get(0) == null) {
					jsonResp.setCode("Failed");
					jsonResp.setMessage("No Data Found!");
				} else {
					jsonResp.setBody(x.get(0));
					jsonResp.setCode("Success");
				}
			} else if(requestType.equals("calls")){
            	List<Object[]> x = em.createNamedStoredProcedureQuery("crmReports_routines")
    					.setParameter("actionType", "getCallsReport").setParameter("actionValue", value).getResultList();
            	if (x.get(0) == null) {
    				jsonResp.setCode("Failed");
    				jsonResp.setMessage("No Data Found!");
    			} else {
    				jsonResp.setBody(x.get(0));
    				jsonResp.setCode("Success");
    			}
            }
			 

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				jsonResp.setCode(err[0]);
				jsonResp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		logger.info("Method : getLeadData ends");
		return jsonResp;
	}

}
