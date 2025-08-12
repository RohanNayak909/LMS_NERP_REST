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
public class QualityDashboardDao {
Logger logger = LoggerFactory.getLogger(QualityDashboardDao.class);
	
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qualityGaugeData(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : qualityGaugeData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("qualityGaugeData----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "qualityGaugeData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : qualityGaugeData Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qualityGaugeSubData(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : qualityGaugeSubData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("qualityGaugeSubData----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "qualityGaugeSubData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : qualityGaugeSubData Dao ends" + resp);
		return resp;

	}
	
	 
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qualityAverageResolutionData(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : qualityAverageResolutionData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("qualityAverageResolutionData----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "qualityAverageResolution").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : qualityAverageResolutionData Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qualityHelpDeskData(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : qualityHelpDeskData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("qualityHelpDeskData----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "qualityHelpDesk").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : qualityHelpDeskData Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qualityAbandonData(String fromDate, String toDate, String organization, String division,String location) {
		logger.info("Method : qualityAbandonData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_division='" + division
					+ "',@p_location='"+location+"';";
			logger.info("qualityAbandonData----->"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "qualityAbandonData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : qualityAbandonData Dao ends" + resp);
		return resp;

	}
}
