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
public class KpiDashboardDao {
Logger logger = LoggerFactory.getLogger(KpiDashboardDao.class);
	
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiResponseTimeData(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiResponseTimeData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiResponseTimeData----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiResponseData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiResponseTimeData Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiResolutionTimeData(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiResolutionTimeData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiResolutionTimeData----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiResolutionData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiResolutionTimeData Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiAverageAnswerTime(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiAverageAnswerTime Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiAverageAnswerTime----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiAverageAnswerTime").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiAverageAnswerTime Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiTicketByType(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiTicketByType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiTicketByType----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiTicketByType").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiTicketByType Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiTicketByCategory(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiTicketByCategory Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiTicketByCategory----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiTicketByCategory").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiTicketByCategory Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiCallAnswerTime(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiCallAnswerTime Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiCallAnswerTime----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiCallAnswerTime").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiCallAnswerTime Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiNetPromoterScore(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiNetPromoterScore Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiNetPromoterScore----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiNetPromoterScore").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiNetPromoterScore Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiCustomerRetention(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiCustomerRetention Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiCustomerRetention----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiCustomerRetention").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiCustomerRetention Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiCustomerEffortScore(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : kpiCustomerEffortScore Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("kpiCustomerEffortScore----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "kpiCustomerEffortScore").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiCustomerEffortScore Dao ends" + resp);
		return resp;
	}
}
