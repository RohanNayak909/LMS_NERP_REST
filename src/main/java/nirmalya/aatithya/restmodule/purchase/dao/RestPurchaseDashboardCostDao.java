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
public class RestPurchaseDashboardCostDao {
	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardCostDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	// procurementROI
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> procurementROI(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : procurementROI Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("procurementROI : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "procurementROI").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : procurementROI Dao ends" + resp);
		return resp;
	}

	// costFiveYearTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> costFiveYearTrend(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : costFiveYearTrend Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("costFiveYearTrend : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "costFiveYearTrend").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : costFiveYearTrend Dao ends" + resp);
		return resp;
	}

	// costFiveYearTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> costFiveYearTrend1(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : costFiveYearTrend1 Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("costFiveYearTrend1 : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "costFiveYearTrend1").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : costFiveYearTrend1 Dao ends" + resp);
		return resp;
	}

	// costSavingFiveYearTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> costSavingFiveYearTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : costSavingFiveYearTrend Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("costSavingFiveYearTrend : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "costSavingFiveYearTrend").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : costSavingFiveYearTrend Dao ends" + resp);
		return resp;
	}

	// costAvoidanceFiveYearTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> costAvoidanceFiveYearTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : costAvoidanceFiveYearTrend Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("costAvoidanceFiveYearTrend : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "costAvoidanceFiveYearTrend").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : costAvoidanceFiveYearTrend Dao ends" + resp);
		return resp;
	}

	// costFiveYearTrend2

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> costFiveYearTrend2(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : costFiveYearTrend2 Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("costFiveYearTrend2 : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "costAvoidanceFiveYearTrend").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : costFiveYearTrend2 Dao ends" + resp);
		return resp;
	}

	// costReductionBySupplier
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> costReductionBySupplier(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : costReductionBySupplier Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("costReductionBySupplier : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "costReductionBySupplier").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : costReductionBySupplier Dao ends" + resp);
		return resp;
	}

	// costSavings
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> costSavings(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : costReductionBySupplier Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("costSavings : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "costReductionBySupplier").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : costSavings Dao ends" + resp);
		return resp;
	}

	// costAvoidance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> costAvoidance(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : costAvoidance Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("costAvoidance : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "costAvoidance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : costAvoidance Dao ends" + resp);
		return resp;
	}
}
