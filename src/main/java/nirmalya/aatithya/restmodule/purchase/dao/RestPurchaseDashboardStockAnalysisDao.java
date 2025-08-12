package nirmalya.aatithya.restmodule.purchase.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestPurchaseDashboardStockAnalysisDao {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardStockAnalysisDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	// analysisHeadData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> analysisHeadData(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : analysisHeadData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("analysisHeadData : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "analysisHeadData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : analysisHeadData Dao ends" + resp);
		return resp;
	}

	// stockHeadData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> stockHeadData(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : stockHeadData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("stockHeadData : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "stockHeadData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : stockHeadData Dao ends" + resp);
		return resp;
	}

	// mostViewed
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> mostViewed(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : mostViewed Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("mostViewed : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "mostViewed").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : mostViewed Dao ends" + resp);
		return resp;
	}

	// leastViewed
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> leastViewed(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : leastViewed Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("leastViewed : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "leastViewed").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : leastViewed Dao ends" + resp);
		return resp;
	}

	// highInventory
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> highInventory(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : highInventory Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("highInventory : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "highInventory").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : highInventory Dao ends" + resp);
		return resp;
	}

	// pridectedDayOutOfStock
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> pridectedDayOutOfStock(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : pridectedDayOutOfStock Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("pridectedDayOutOfStock : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "bottomSales").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : pridectedDayOutOfStock Dao ends" + resp);
		return resp;
	}

	// bottomSales
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> bottomSales(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : bottomSales Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("bottomSales : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "bottomSales").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : bottomSales Dao ends" + resp);
		return resp;
	}

	// topRunningOutOfStock
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> topRunningOutOfStock(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : topRunningOutOfStock Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("topRunningOutOfStock : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "topRunningOutOfStock").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : topRunningOutOfStock Dao ends" + resp);
		return resp;
	}

	// topSalesOutOfStock
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> topSalesOutOfStock(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : topSalesOutOfStock Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("topSalesOutOfStock : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "topSalesOutOfStock").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : topSalesOutOfStock Dao ends" + resp);
		return resp;
	}

	// simulatedDaysOutOfStock
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> simulatedDaysOutOfStock(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : simulatedDaysOutOfStock Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("simulatedDaysOutOfStock : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "simulatedDaysOutOfStock").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : simulatedDaysOutOfStock Dao ends" + resp);
		return resp;
	}
}
