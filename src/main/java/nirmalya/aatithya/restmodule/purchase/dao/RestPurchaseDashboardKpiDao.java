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
public class RestPurchaseDashboardKpiDao {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardKpiDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	// kpiCostSaving1
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiCostSaving1(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : kpiCostSaving1 Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("kpiCostSaving1 : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "kpiCostSaving1").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiCostSaving1 Dao ends" + resp);
		return resp;
	}

	// departmentKpis
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> departmentKpis(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : departmentKpis Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("departmentKpis : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "departmentKpis").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : departmentKpis Dao ends" + resp);
		return resp;
	}

	// supplierPerformance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> supplierPerformance(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : supplierPerformance Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("supplierPerformance : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "supplierPerformance").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : supplierPerformance Dao ends" + resp);
		return resp;
	}

	// operationalKPIs
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> operationalKPIs(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : operationalKPIs Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("operationalKPIs : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "operationalKPIs").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : operationalKPIs Dao ends" + resp);
		return resp;
	}

	// spendUnderManagement
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> spendUnderManagement(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : spendUnderManagement Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("spendUnderManagement : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "spendUnderManagement").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : spendUnderManagement Dao ends" + resp);
		return resp;
	}

	// kpiMaverick
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> kpiMaverick(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : kpiMaverick Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("kpiMaverick : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "kpiMaverick").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : kpiMaverick Dao ends" + resp);
		return resp;
	}
}
