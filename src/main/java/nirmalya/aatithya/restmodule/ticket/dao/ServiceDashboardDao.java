package nirmalya.aatithya.restmodule.ticket.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class ServiceDashboardDao {
	
	Logger logger = LoggerFactory.getLogger(ServiceDashboardDao.class);
	
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> serviceHeadData(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : serviceHeadData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division + "',@p_location='" + location + "';";
			logger.info("serviceHeadData----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "serviceHeadData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : serviceHeadData Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> servicePercentageCall(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : servicePercentageCall Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division + "',@p_location='" + location + "';";
			logger.info("servicePercentageCall----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "servicePercentageCall").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : servicePercentageCall Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> serviceMonthlyTicket(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : serviceMonthlyTicket Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division + "',@p_location='" + location + "';";
			logger.info("serviceMonthlyTicket----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "serviceMonthlyTicket").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : serviceMonthlyTicket Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> serviceCallResponse(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : serviceCallResponse Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division + "',@p_location='" + location + "';";
			logger.info("serviceCallResponse----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "serviceCallResponse").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : serviceCallResponse Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> serviceTopPerformers(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : serviceTopPerformers Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division + "',@p_location='" + location + "';";
			logger.info("serviceTopPerformers----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "serviceTopPerformers").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : serviceTopPerformers Dao ends" + resp);
		return resp;

	}

	
}
