package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAccountDAshboardDao {
	Logger logger = LoggerFactory.getLogger(RestAccountDAshboardDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllCounts(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : getAllCounts Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "viewDashboard").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllCounts Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllReport(String orgName, String orgDivision, String id, String fromDate,
			String toDate, String loc) {
		logger.info("Method : getAllData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id
					+ "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "',@p_loc='" + loc + "';";
			logger.info("values********getAllReport*******************------------------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "getAllReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllData Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> currentWorkingCapital(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : currentWorkingCapital Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";

			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "currentWorkingCapital").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : currentWorkingCapital Dao ends" + resp);
		return resp;
	}

	// liquidityRatioDataCount

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> liquidityRatioDataCount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : liquidityRatioDataCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values************liquidityRatioDataCount***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "liquidityData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : liquidityRatioDataCount Dao ends" + resp);
		return resp;
	}

	// dashboardWorkingRatiosCount

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardWorkingRatiosCount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardWorkingRatiosCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values************workingRatioCount***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "workingRatioCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardWorkingRatiosCount Dao ends" + resp);
		return resp;
	}

	// dashboardRiskRatiosCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardRiskRatiosCount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardRiskRatiosCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values***********riskRatioCount****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "riskRatioCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardRiskRatiosCount Dao ends" + resp);
		return resp;
	}

	// dashboardProfitabilityRatioCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardProfitabilityRatioCount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardProfitabilityRatioCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**********profitbltyRatioCount*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "profitbltyRatioCount").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardProfitabilityRatioCount Dao ends" + resp);
		return resp;
	}

	// dashboardBalaceSheetPayableTabCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalaceSheetPayableTabCount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardBalaceSheetPayableTabCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values***************bSPayableCount*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSPayableCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalaceSheetPayableTabCount Dao ends" + resp);
		return resp;
	}

	// dashboardBalaceSheetReceivableTabCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalaceSheetReceivableTabCount(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalaceSheetReceivableTabCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*************bSReceivableCount**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSReceivableCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalaceSheetReceivableTabCount Dao ends" + resp);
		return resp;
	}

	// dashboardBalaceSheetFixedAssetsTabCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalaceSheetFixedAssetsTabCount(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalaceSheetFixedAssetsTabCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values****************bSFixAsstsCount***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSFixAsstsCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalaceSheetFixedAssetsTabCount Dao ends" + resp);
		return resp;
	}

	// dashboardBalaceWorkingCapitalTabCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalaceWorkingCapitalTabCount(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalaceWorkingCapitalTabCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**************bSWorkngCaptlCount*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSWorkngCaptlCount").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalaceWorkingCapitalTabCount Dao ends" + resp);
		return resp;
	}

	// dashboardSubscriptionCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardSubscriptionCount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardSubscriptionCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************SubSubscriptionCount*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubSubscriptionCount").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardSubscriptionCount Dao ends" + resp);
		return resp;
	}

	// dashboardOutstandingRevenueExpenseCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardOutstandingRevenueExpenseCount(String orgName, String orgDivision,
			String fromDate, String toDate, String thisYear, String lastYear, String loc) {
		logger.info("Method : dashboardOutstandingRevenueExpenseCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "',@p_thisYear='" + thisYear + "',@p_lastYear='" + lastYear
					+ "',@p_loc='" + loc + "';";
			logger.info("values  ************************dashboardOutstandingRevenueExpenseCount*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plOutRevnExpensCount").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardOutstandingRevenueExpenseCount Dao ends" + resp);
		return resp;
	}

	// dashboardMainDsoDioDpoCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardMainDsoDioDpoCount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardMainDsoDioDpoCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************perMainDsoDioDpoCount***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perMainDsoDioDpoCount").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardMainDsoDioDpoCount Dao ends" + resp);
		return resp;
	}

	// dashboardBalaceSheetDaysOrOthersCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalaceSheetDaysOrOthersCount(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalaceSheetDaysOrOthersCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************bSDaysOthrsCount**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSDaysOthrsCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalaceSheetDaysOrOthersCount Dao ends" + resp);
		return resp;
	}

	// dashboardRatioComparisionCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardRatioComparisionCount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardRatioComparisionCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**********ratioCompareCount*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "ratioCompareCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardRatioComparisionCount Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> currentBudgetVarience(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : currentBudgetVarience Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values***********currentBudgetVarience****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "currentBudgetVarience").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : currentBudgetVarience Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> vendorpaymenterrorrate(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : vendorpaymenterrorrate Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**********vendorpaymenterrorrate*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "vendorpaymenterrorrate").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : vendorpaymenterrorrate Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cashmanagementWorkingCap(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : cashmanagementWorkingCap Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************cashmanagementWorkingCap**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cashmanagementWorkingCap").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cashmanagementWorkingCap Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cashbalance(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : cashbalance Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************cashbalance************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cashbalance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cashbalance Dao ends" + resp);
		return resp;

	}

	// cashRatioTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cashRatioTrend(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : cashRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values***********cashRatioTrend****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cashRatioTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cashRatioTrend Dao ends" + resp);
		return resp;

	}

	/// quickRatioTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> quickRatioTrend(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : quickRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*********quickRatioTrnd******************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "quickRatioTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : quickRatioTrend Dao ends" + resp);
		return resp;

	}

	// currentRatioTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> currentRatioTrend(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : currentRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values************currentRatio***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "currentRatio").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : currentRatioTrend Dao ends" + resp);
		return resp;

	}

	// absoluteLiquidRatioTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> absoluteLiquidRatioTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : absoluteLiquidRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values******************absltLqudRatio*********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "absltLqudRatio").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : absoluteLiquidRatioTrend Dao ends" + resp);
		return resp;

	}

	// workingReceivableRatioTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> workingReceivableRatioTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : workingReceivableRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values***********rcvbleRatioTrnd****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "rcvbleRatioTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : workingReceivableRatioTrend Dao ends" + resp);
		return resp;

	}

	// workingCashConversionRatioTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> workingCashConversionRatioTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : workingCashConversionRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**********cccRatioTrend*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cccRatioTrend").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : workingCashConversionRatioTrend Dao ends" + resp);
		return resp;

	}

	// dashboardWorkingDebatorsRatioTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardWorkingDebatorsRatioTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardWorkingDebatorsRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**************debatorRatioTrnd*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "debatorRatioTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardWorkingDebatorsRatioTrend Dao ends" + resp);
		return resp;

	}

	// dashboardCreditorsRatioTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCreditorsRatioTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardCreditorsRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**************creditorRatioTrnd*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "creditorRatioTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCreditorsRatioTrend Dao ends" + resp);
		return resp;

	}

	//////////////////////////////////////////////////////////
	// dashboardOperatingLeverageTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardOperatingLeverageTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardOperatingLeverageTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**************operatingLvrgTrnd*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "operatingLvrgTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardOperatingLeverageTrend Dao ends" + resp);
		return resp;

	}
	// dashboardFinancialLeverageTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardFinancialLeverageTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardFinancialLeverageTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**************financialLvrgTrnd*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "financialLvrgTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardFinancialLeverageTrend Dao ends" + resp);
		return resp;

	}
	// dashboardDebtToEquityTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardDebtToEquityTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardDebtToEquityTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values************debtToEquityTrnd***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "debtToEquityTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardDebtToEquityTrend Dao ends" + resp);
		return resp;

	}
	// dashboardInterestCoverageTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardInterestCoverageTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardInterestCoverageTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*************interestCoverTrnd**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "interestCoverTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardInterestCoverageTrend Dao ends" + resp);
		return resp;

	}

	/////////////////////////////////////////////////////////
	// dashboardEarningMarginTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardEarningMarginTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardEarningMarginTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values****************earngMrginTrnd***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "earngMrginTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardInterestCoverageTrend Dao ends" + resp);
		return resp;

	}

	/////////////////////////////////////////////////////////
	// dashboardReturnOnEquityTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardReturnOnEquityTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardReturnOnEquityTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values****************returnOnEquityTrnd***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "returnOnEquityTrnd").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardReturnOnEquityTrend Dao ends" + resp);
		return resp;

	}

	/////////////////////////////////////////////////////////
	// dashboardReturnOnInvestmentTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardReturnOnInvestmentTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardReturnOnInvestmentTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values************returnOnInvestTrnd***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "returnOnInvestTrnd").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardReturnOnInvestmentTrend Dao ends" + resp);
		return resp;

	}

	/////////////////////////////////////////////////////////
	// dashboardEarnignPerShareTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardEarnignPerShareTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardEarnignPerShareTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values************earnPerShareTrnd***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "earnPerShareTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardEarnignPerShareTrend Dao ends" + resp);
		return resp;

	}

	/// dashboardBalanceSheetOverAllCashByYear
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetOverAllCashByYear(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetOverAllCashByYear Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*************bSAllCashbyYear**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSAllCashbyYear").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetOverAllCashByYear Dao ends" + resp);
		return resp;

	}
	/// dashboardBalanceSheetDebtRatios

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetDebtRatios(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetDebtRatios Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*************bSDebtRatios**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSDebtRatios").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetDebtRatios Dao ends" + resp);
		return resp;

	}
	/// dashboardBalanceSheetReceivablePayableTurnOver

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetReceivablePayableTurnOver(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetReceivablePayableTurnOver Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values****************bSRcvPayTurnOver***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSRcvPayTurnOver").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetReceivablePayableTurnOver Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetOverAllFinancialStatment
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetOverAllFinancialStatment(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetOverAllFinancialStatment Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*****************bSOverAllFinStatement**********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSOverAllFinStatement").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetOverAllFinancialStatment Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetDataTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetDataTable(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetDataTable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*************bSBalanceSheetDataTbl**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSBalanceSheetDataTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetDataTable Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetOverDueInvoiceDetailsTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetOverDueInvoiceDetailsTable(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetOverDueInvoiceDetailsTable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values***************bSOverDueInvDetlsTbls************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSOverDueInvDetlsTbls").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetOverDueInvoiceDetailsTable Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetUpcomingPaymentDtlsTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetUpcomingPaymentDtlsTable(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetUpcomingPaymentDtlsTable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**************bSUpcomingPayDtlsTbl*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSUpcomingPayDtlsTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetUpcomingPaymentDtlsTable Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetOverDueDtlsReceivableTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetOverDueDtlsReceivableTable(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetOverDueDtlsReceivableTable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************bSOverDueDtlsRcvlTbl***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSOverDueDtlsRcvlTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetOverDueDtlsReceivableTable Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable(String orgName,
			String orgDivision, String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************bSUpcmngPayDtlsRcvlTbl***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSUpcmngPayDtlsRcvlTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetAssetsTurnOverRatioTrendTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetAssetsTurnOverRatioTrendTable(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetAssetsTurnOverRatioTrendTable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************bSAsstsTurnOverTrndTbl************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSAsstsTurnOverTrndTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetAssetsTurnOverRatioTrendTable Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetCountVolumeVsAge
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetCountVolumeVsAge(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetCountVolumeVsAge Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************bSCountVolVsAge***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSCountVolVsAge").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetCountVolumeVsAge Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetPayableParVsDiscount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetPayableParVsDiscount(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetPayableParVsDiscount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************bSPayablePrVsDisc**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSPayablePrVsDisc").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetPayableParVsDiscount Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetDepartmentWiseOutstanding
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetDepartmentWiseOutstanding(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetDepartmentWiseOutstanding Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*********bSDeptWiseOuts******************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSDeptWiseOuts").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetDepartmentWiseOutstanding Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetTopVendorWiseDue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetTopVendorWiseDue(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetTopVendorWiseDue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************bSTopVndWiseDue*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSTopVndWiseDue").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetTopVendorWiseDue Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetUpcomingPayment
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetUpcomingPayment(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetUpcomingPayment Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************bSUpcomingPay**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSUpcomingPay").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetUpcomingPayment Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetPurchasePayableVsPayable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetPurchasePayableVsPayable(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetPurchasePayableVsPayable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************bSPurVsPayable**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSPurVsPayable").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetPurchasePayableVsPayable Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetExpenseTypeWiseOutstanding
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetExpenseTypeWiseOutstanding(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetExpenseTypeWiseOutstanding Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************bSExpnsTypeOutst************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSExpnsTypeOutst").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetExpenseTypeWiseOutstanding Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetYtdAmountPaid
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetYtdAmountPaid(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetYtdAmountPaid Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************bSYtdAmountPaid************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSYtdAmountPaid").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetYtdAmountPaid Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetAvgPaymentAge
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetAvgPaymentAge(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetAvgPaymentAge Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************bSAvgPaymentAge**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSAvgPaymentAge").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetAvgPaymentAge Dao ends" + resp);
		return resp;

	}

	/////////////////////////////////////////////////////////

	// dashboardBalanceSheeRcvblePaymentAgeCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheeRcvblePaymentAgeCount(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheeRcvblePaymentAgeCount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************bSRcvlPayAgeCount************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSRcvlPayAgeCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheeRcvblePaymentAgeCount Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetInvoiceCategoryBreakdown
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetInvoiceCategoryBreakdown(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetInvoiceCategoryBreakdown Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************bSInvoiceCatBreakDwn***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSInvoiceCatBreakDwn").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetInvoiceCategoryBreakdown Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetTopCustomerByDue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetTopCustomerByDue(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetTopCustomerByDue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************bSTopCustByDue***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSTopCustByDue").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetTopCustomerByDue Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetAvgRecvblePaymentAge
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetAvgRecvblePaymentAge(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetAvgRecvblePaymentAge Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************bSAvgRecvblePayAge************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSAvgRecvblePayAge").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetAvgRecvblePaymentAge Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetUpcomingReceivable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetUpcomingReceivable(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetUpcomingReceivable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************bSUpcomingRecvble***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSUpcomingRecvble").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetUpcomingReceivable Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetAccountReceivableVstime
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetAccountReceivableVstime(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetAccountReceivableVstime Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************bSAccRcvbleVstime*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSAccRcvbleVstime").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetAccountReceivableVstime Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetFixedAssetsTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetFixedAssetsTrend(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetFixedAssetsTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************bSFixdAssetsTrend**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSFixdAssetsTrend").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetFixedAssetsTrend Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetAssetsTurnOverRatioTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetAssetsTurnOverRatioTrend(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetAssetsTurnOverRatioTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************bSAssetTurnOvrRatio*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSAssetTurnOvrRatio").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetAssetsTurnOverRatioTrend Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetFixedAssetsMovementByMonth
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetFixedAssetsMovementByMonth(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetFixedAssetsMovementByMonth Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************bSFixAssetMovByMnth***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSFixAssetMovByMnth").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetFixedAssetsMovementByMonth Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetCurrRatioMomTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetCurrRatioMomTrend(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetCurrRatioMomTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************bSCurrRatioMomTrnd************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSCurrRatioMomTrnd").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetCurrRatioMomTrend Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetNetWorkingCapByMonth
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetNetWorkingCapByMonth(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetNetWorkingCapByMonth Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************bSNetWorkCapbyMonth**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSNetWorkCapbyMonth").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetNetWorkingCapByMonth Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetQuickRatioMomTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetQuickRatioMomTrend(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetQuickRatioMomTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************bSQuickRatioMomTrnd**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSQuickRatioMomTrnd").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetQuickRatioMomTrend Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetAssetsVsLiabilities
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetAssetsVsLiabilities(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetAssetsVsLiabilities Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************bSAsstsVsLiability*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSAsstsVsLiability").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetAssetsVsLiabilities Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetInvntTurnOvrRatioMomTrnd
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetInvntTurnOvrRatioMomTrnd(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetInvntTurnOvrRatioMomTrnd Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********bSInvTurnOverRatioMom****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSInvTurnOverRatioMom").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetInvntTurnOvrRatioMomTrnd Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetBaseLineVsComparisionTbl
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetBaseLineVsComparisionTbl(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetBaseLineVsComparisionTbl Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************bSBaseLineCmprTbl***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSBaseLineCmprTbl").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetBaseLineVsComparisionTbl Dao ends" + resp);
		return resp;

	}

	// dashboardBalanceSheetBaseLineVsComparisionGraph
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardBalanceSheetBaseLineVsComparisionGraph(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardBalanceSheetBaseLineVsComparisionGraph Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************bSBaseLineCmprGraph************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_bs_Routines")
					.setParameter("actionType", "bSBaseLineCmprGraph").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardBalanceSheetBaseLineVsComparisionGraph Dao ends" + resp);
		return resp;

	}

	// dashboardMonthlyRecurringRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardMonthlyRecurringRevenue(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardMonthlyRecurringRevenue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**********SubMonthlyReccRevenue*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubMonthlyReccRevenue").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardMonthlyRecurringRevenue Dao ends" + resp);
		return resp;

	}

	// dashboardTopCustByMonthlyRecurRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTopCustByMonthlyRecurRevenue(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardTopCustByMonthlyRecurRevenue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************SubTopCusByMonRecRevnue***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubTopCusByMonRecRevnue").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTopCustByMonthlyRecurRevenue Dao ends" + resp);
		return resp;

	}

	// dashboardTopCustCustByRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTopCustCustByRevenue(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardTopCustCustByRevenue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************SubTopCusByRevenue***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubTopCusByRevenue").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTopCustCustByRevenue Dao ends" + resp);
		return resp;

	}

	// dashboardTopCompanyMonthlyRecurRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTopCompanyMonthlyRecurRevenue(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardTopCompanyMonthlyRecurRevenue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************SubTopCmpnyMonthRecrRevn**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubTopCmpnyMonthRecrRevn").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTopCompanyMonthlyRecurRevenue Dao ends" + resp);
		return resp;

	}

	// dashboardCustAccountStatusBreakdown
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCustAccountStatusBreakdown(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardCustAccountStatusBreakdown Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************SubCusAccStatBreakDown***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubCusAccStatBreakDown").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCustAccountStatusBreakdown Dao ends" + resp);
		return resp;

	}

	// dashboardPaymentMonthBreakdown
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPaymentMonthBreakdown(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPaymentMonthBreakdown Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********SubPayMonthBreakDwn****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubPayMonthBreakDwn").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPaymentMonthBreakdown Dao ends" + resp);
		return resp;

	}

	// dashboardCustSubscriptionByStatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCustSubscriptionByStatus(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardCustSubscriptionByStatus Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************SubCusSubByStatus**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubCusSubByStatus").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCustSubscriptionByStatus Dao ends" + resp);
		return resp;

	}

	// dashboardSubscriptionByPlanStatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardSubscriptionByPlanStatus(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardSubscriptionByPlanStatus Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************SubSubsByPlanStatus*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubSubsByPlanStatus").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardSubscriptionByPlanStatus Dao ends" + resp);
		return resp;

	}

	// dashboardAccountReceivableByPayTarget
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAccountReceivableByPayTarget(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardAccountReceivableByPayTarget Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********SubAccRecevByPayTarget****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubAccRecevByPayTarget").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAccountReceivableByPayTarget Dao ends" + resp);
		return resp;

	}

	// dashboardPaymentByMonth
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPaymentByMonth(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPaymentByMonth Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************SubPayByMonth*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubPayByMonth").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPaymentByMonth Dao ends" + resp);
		return resp;

	}

	// dashboardTransactionCountByMonthType
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTransactionCountByMonthType(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardTransactionCountByMonthType Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************SubTransacCountByMonthType*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubTransacCountByMonthType").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTransactionCountByMonthType Dao ends" + resp);
		return resp;

	}

	// dashboardMonthlyRevenueTrendAnalysis
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardMonthlyRevenueTrendAnalysis(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardMonthlyRevenueTrendAnalysis Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************SubMonRevnTrendAnalysis*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubMonRevnTrendAnalysis").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardMonthlyRevenueTrendAnalysis Dao ends" + resp);
		return resp;

	}

	// dashboardAnnualRunRateTrendAnalysis
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAnnualRunRateTrendAnalysis(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardAnnualRunRateTrendAnalysis Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************SubAnnalRunRateTrndAnlys**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubAnnalRunRateTrndAnlys").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAnnualRunRateTrendAnalysis Dao ends" + resp);
		return resp;

	}

	// dashboardMonthlyRecurringRevenueChurn
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardMonthlyRecurringRevenueChurn(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardMonthlyRecurringRevenueChurn Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values******************SubMonRecRevenChurn**********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubMonRecRevenChurn").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardMonthlyRecurringRevenueChurn Dao ends" + resp);
		return resp;

	}

	// dashboardCustomerChurnRateTrendAnalysis
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCustomerChurnRateTrendAnalysis(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardCustomerChurnRateTrendAnalysis Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************SubCusChurnRateTrndAnalys***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubCusChurnRateTrndAnalys").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCustomerChurnRateTrendAnalysis Dao ends" + resp);
		return resp;

	}

	// dashboardAvgRevenuePerAccount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAvgRevenuePerAccount(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardAvgRevenuePerAccount Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********SubAvgRevenuePerAccnt****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubAvgRevenuePerAccnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAvgRevenuePerAccount Dao ends" + resp);
		return resp;

	}

	// dashboardInvoiceSummaryDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardInvoiceSummaryDetails(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardInvoiceSummaryDetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************SubInvSummaryDtls**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubInvSummaryDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardInvoiceSummaryDetails Dao ends" + resp);
		return resp;

	}

	// dashboardInvoiceSummaryDetailsTbl
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardInvoiceSummaryDetailsTbl(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardInvoiceSummaryDetailsTbl Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************SubInvSummaryDtlsTbl***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Sub_Routines")
					.setParameter("actionType", "SubInvSummaryDtlsTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardInvoiceSummaryDetailsTbl Dao ends" + resp);
		return resp;

	}

	// dashboardPlOpexMomYtd
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlOpexMomYtd(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPlOpexMomYtd Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values***********plOpexMomYtd****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plOpexMomYtd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlOpexMomYtd Dao ends" + resp);
		return resp;

	}

	// dashboardPlPaymentStatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlPaymentStatus(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPlPaymentStatus Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*************plPaymentStatus**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plPaymentStatus").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlPaymentStatus Dao ends" + resp);
		return resp;

	}

	// dashboardPlGrossProfitMargin
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlGrossProfitMargin(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPlGrossProfitMargin Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************plGrossPrfitMrgin**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plGrossPrfitMrgin").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlGrossProfitMargin Dao ends" + resp);
		return resp;

	}

	// dashboardPlNetProfitMargin
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlNetProfitMargin(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : dashboardPlNetProfitMargin Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plNetPrftMargin").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlNetProfitMargin Dao ends" + resp);
		return resp;

	}

	// dashboardPlTopExpbyCatPrcnt
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlTopExpbyCatPrcnt(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPlTopExpbyCatPrcnt Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**********plTopExpByCatPrcnt*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plTopExpByCatPrcnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlTopExpbyCatPrcnt Dao ends" + resp);
		return resp;

	}

	// dashboardPlRevTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlRevTrend(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : dashboardPlRevTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************plRevenueTrend*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plRevenueTrend").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlRevTrend Dao ends" + resp);
		return resp;

	}

	// dashboardPlCustGrowth
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlCustGrowth(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPlCustGrowth Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********plCustGrowth****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plCustGrowth").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlCustGrowth Dao ends" + resp);
		return resp;

	}

	// dashboardPlToRevnGenerateCont
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlToRevnGenerateCont(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPlToRevnGenerateCont Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************plRevenueGenerateCnt*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plRevenueGenerateCnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlToRevnGenerateCont Dao ends" + resp);
		return resp;

	}

	// dashboardPlIncmExpnByCatPrcnt
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlIncmExpnByCatPrcnt(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPlIncmExpnByCatPrcnt Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************plIncmExpnsCatPrcnt*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plIncmExpnsCatPrcnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlIncmExpnByCatPrcnt Dao ends" + resp);
		return resp;

	}

	// dashboardPlProfitAndLossReport
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPlProfitAndLossReport(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPlProfitAndLossReport Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************plReportTable***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "plReportTable").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPlProfitAndLossReport Dao ends" + resp);
		return resp;

	}

	// dashboardPerReturnOnAssets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerReturnOnAssets(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerReturnOnAssets Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values********************perReturnOnAssets*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perReturnOnAssets").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerReturnOnAssets Dao ends" + resp);
		return resp;

	}

	// dashboardPerWorkingCaptlRatio
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerWorkingCaptlRatio(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerWorkingCaptlRatio Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************perWorkingCapRatio***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perWorkingCapRatio").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerWorkingCaptlRatio Dao ends" + resp);
		return resp;

	}

	// dashboardPerReturnOnEquity
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerReturnOnEquity(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerReturnOnEquity Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************perReturnOnEquity*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perReturnOnEquity").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerReturnOnEquity Dao ends" + resp);
		return resp;

	}

	// dashboardPerDebtEquityRatio
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerDebtEquityRatio(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerDebtEquityRatio Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************dashboardPerDebtEquityRatio**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perDebtEquityRatio").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerDebtEquityRatio Dao ends" + resp);
		return resp;

	}

	// dashboardPerBalanceSheetCountList
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerBalanceSheetCountList(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerBalanceSheetCountList Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************perBalStCountList**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perBalStCountList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerBalanceSheetCountList Dao ends" + resp);
		return resp;

	}

	// dashboardPerProfitLossSmry
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerProfitLossSmry(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerProfitLossSmry Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************perProfitLossSmry***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perProfitLossSmry").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerProfitLossSmry Dao ends" + resp);
		return resp;

	}

	// dashboardPerNetGrossWorkingCapital
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerNetGrossWorkingCapital(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerNetGrossWorkingCapital Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************perNetGrossWorkingCap**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perNetGrossWorkingCap").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerNetGrossWorkingCapital Dao ends" + resp);
		return resp;

	}

	// dashboardPerAccReceivablePayableTurnOver
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerAccReceivablePayableTurnOver(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardPerAccReceivablePayableTurnOver Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************perAccRecPayTurnOver**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perAccRecPayTurnOver").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerAccReceivablePayableTurnOver Dao ends" + resp);
		return resp;

	}

	// dashboardPerInvoiceDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerInvoiceDetails(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerInvoiceDetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************perInvDetails***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perInvDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerInvoiceDetails Dao ends" + resp);
		return resp;

	}

	// dashboardPerAccPayableByPayTarget
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerAccPayableByPayTarget(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerAccPayableByPayTarget Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************perAccPayByPayTargt*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perAccPayByPayTargt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerAccPayableByPayTarget Dao ends" + resp);
		return resp;

	}

	// dashboardPerExpensesListCountList
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerExpensesListCountList(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : dashboardPerExpensesListCountList Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perExpnsListCnt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerExpensesListCountList Dao ends" + resp);
		return resp;

	}

	// dashboardPerInvoiceDueDtlsByCusTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerInvoiceDueDtlsByCusTable(String orgName, String orgDivision,
			String fromDate, String toDate, String loc) {
		logger.info("Method : dashboardPerInvoiceDueDtlsByCusTable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************perInvDueDtlsByCusTbl************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perInvDueDtlsByCusTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerInvoiceDueDtlsByCusTable Dao ends" + resp);
		return resp;

	}

	// dashboardPerProfitLossSummryTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerProfitLossSummryTable(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerProfitLossSummryTable Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************perProftLossSmryTbl**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perProftLossSmryTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerProfitLossSummryTable Dao ends" + resp);
		return resp;

	}

	// dashboardPerExecutiveSummryTbl
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardPerExecutiveSummryTbl(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardPerExecutiveSummryTbl Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************perExecutiveSmryTbl****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_per_Routines")
					.setParameter("actionType", "perExecutiveSmryTbl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardPerExecutiveSummryTbl Dao ends" + resp);
		return resp;

	}

	// dashboardRatioRetunOnEquityTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardRatioRetunOnEquityTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardRatioRetunOnEquityTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************returnOnEquityTrnd**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "returnOnEquityTrnd").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardRatioRetunOnEquityTrend Dao ends" + resp);
		return resp;

	}

	/////////////////////////////////////////////////////////
	// dashboardRatioEarnignMarginTrend

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardRatioEarnignMarginTrend(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : dashboardRatioEarnignMarginTrend Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********earnMarginTrnd****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "earnMarginTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardRatioEarnignMarginTrend Dao ends" + resp);
		return resp;

	}

	/////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cminventory(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : cminventory Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************cminventory***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cminventory").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cminventory Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cmPayableVsReceivable(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : cminventory Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************payblrcvable************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "payblrcvable").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cminventory Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cmPayableCount(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : cminventory Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values****************cmpayablecount***********" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cmpayablecount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cminventory Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> performanceBalanceSheet(String orgName, String orgDivision) {
		logger.info("Method : performanceBalanceSheet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "performanceBalanceSheet").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : performanceBalanceSheet Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualForcastIndicators(String orgName, String orgDivision) {
		logger.info("Method : actualForcastIndicators Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "actualForcastIndicators").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : actualForcastIndicators Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualForcastHighCharts(String orgName, String orgDivision) {
		logger.info("Method : actualForcastHighCharts Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "actualForcastHighCharts").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : actualForcastHighCharts Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> profitLossCostStatement(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : profitLossCostStatement Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**********profitLossCostStmnt*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "profitLossCostStmnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : profitLossCostStatement Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> revenuecogslist(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : revenuecogslist Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values**********revenueCogsList*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "revenueCogsList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : revenuecogslist Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> opexYearToDate(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : opexYearToDate Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values*************opexYearToDate**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "opexYearToDate").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : opexYearToDate Dao ends" + resp);
		return resp;

	}

	// earningBeforeTaxes

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> earningBeforeInterestTaxes(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : earningBeforeInterestTaxes Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values***********earnBeforeIntrstTax****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "earnBeforeIntrstTax").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : earningBeforeInterestTaxes Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> opexYearWise(String orgName, String orgDivision) {
		logger.info("Method : opexYearWise Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "opexYearWise").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : opexYearWise Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> grossProfitLossMarginPrcnt(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : grossProfitLossMarginPrcnt Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values********************grossProfitLossMrgnPcnt*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "grossProfitLossMrgnPcnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : grossProfitLossMarginPrcnt Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> grossOpexRatioPrcnt(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : grossOpexRatioPrcnt Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values************grossOpexRatioPrcnt***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "grossOpexRatioPrcnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : grossOpexRatioPrcnt Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> operatingProfitPrcnt(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : operatingProfitPrcnt Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values************operatingProfitPrcnt***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "operatingProfitPrcnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : operatingProfitPrcnt Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> netProfitMarginPrcnt(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : netProfitMarginPrcnt Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("values******netProfitMargnPrcnt*********************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_pl_Routines")
					.setParameter("actionType", "netProfitMargnPrcnt").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : netProfitMarginPrcnt Dao ends" + resp);
		return resp;

	}

	//////////////////////////////////////////////////// Start

	// actualforecastrevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastrevenue(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastrevenue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************actualforecastrevenue***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastrevenue").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastrevenue Dao ends" + resp);
		return resp;

	}

	// actualforecastcogs
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastcogs(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : actualforecastrevenue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********actualforecastcogs****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastcogs").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastrevenue Dao ends" + resp);
		return resp;

	}

	// actualforecastcogs
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastcosts(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : actualforecastcosts Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************actualforecastcosts**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastcosts").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastcosts Dao ends" + resp);
		return resp;

	}

	// actualforecasttaxes
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecasttaxes(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : actualforecasttaxes Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************actualforecasttaxes***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecasttaxes").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecasttaxes Dao ends" + resp);
		return resp;

	}

	// actualforecasttaxes
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastrevenues(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastrevenues Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**********actualforecastrevenues*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastrevenues").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastrevenues Dao ends" + resp);
		return resp;

	}

	// actualforecastbreakdownOfcosts
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastbreakdownOfcosts(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastbreakdownOfcosts Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values*************actualforecastbreakdownOfcosts**************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastbreakdownOfcosts").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastbreakdownOfcosts Dao ends" + resp);
		return resp;

	}

	// actualforecastincomebudget
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastincomebudget(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastincomebudget Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********actualforecastincomebudget****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastincomebudget").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastincomebudget Dao ends" + resp);
		return resp;

	}

	// actualforecastexpensesbudget
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastexpensesbudget(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastexpensesbudget Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values************actualforecastexpensesbudget***************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastexpensesbudget").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastexpensesbudget Dao ends" + resp);
		return resp;

	}

	// actualforecastactualincome
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastactualincome(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastactualincome Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**************actualforecastactualincome*************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastactualincome").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastactualincome Dao ends" + resp);
		return resp;

	}

	// actualforecastactualexpenses
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastactualexpenses(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastactualexpenses Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***************actualforecastactualexpenses************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastactualexpenses").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastactualexpenses Dao ends" + resp);
		return resp;

	}

	// actualforecastactualexpenses
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastbudgetactualincome(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastbudgetactualincome Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**********actualforecastbudgetactualincome*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastbudgetactualincome").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastbudgetactualincome Dao ends" + resp);
		return resp;

	}

	// actualforecastactualexpenses
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastbudgetactualexpense(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastbudgetactualexpense Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********actualforecastbudgetactualexpense****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastbudgetactualexpense").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastbudgetactualexpense Dao ends" + resp);
		return resp;

	}

	// actualforecastfinancecosts
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastfinancecosts(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastfinancecosts Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values***********actualforecastfinancecosts****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastfinancecosts").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastfinancecosts Dao ends" + resp);
		return resp;

	}

	// actualforecastfinancecosts
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualforecastnetprofit(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : actualforecastnetprofit Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "', @p_loc ='" + loc + "';";
			logger.info("values**********actualforecastnetprofit*****************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "actualforecastnetprofit").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : actualforecastnetprofit Dao ends" + resp);
		return resp;

	}

	// getOrganization
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganization(String orgName) {
		logger.info("Method : getOrganization starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "getOrganization").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOrganization ends");
		return getCollectionList;
	}

	// getDivision

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDivision(String orgName) {
		logger.info("Method : getDivision starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_af_Routines")
					.setParameter("actionType", "orgDivision").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : orgDivision ends");
		return getCollectionList;
	}

	
	
/*
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllCounts(String orgName, String orgDivision) {
		logger.info("Method : getAllCounts Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "viewDashboard").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllCounts Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllReport(String orgName, String orgDivision, String id) {
		logger.info("Method : getAllData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "getAllReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllData Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> currentWorkingCapital(String orgName, String orgDivision) {
		logger.info("Method : currentWorkingCapital Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "currentWorkingCapital").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : currentWorkingCapital Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> currentBudgetVarience(String orgName, String orgDivision) {
		logger.info("Method : currentBudgetVarience Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "currentBudgetVarience").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : currentBudgetVarience Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> vendorpaymenterrorrate(String orgName, String orgDivision) {
		logger.info("Method : vendorpaymenterrorrate Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "vendorpaymenterrorrate").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : vendorpaymenterrorrate Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cashmanagementWorkingCap(String orgName, String orgDivision) {
		logger.info("Method : cashmanagementWorkingCap Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cashmanagementWorkingCap").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cashmanagementWorkingCap Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cashbalance(String orgName, String orgDivision) {
		logger.info("Method : cashbalance Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cashbalance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cashbalance Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cminventory(String orgName, String orgDivision) {
		logger.info("Method : cminventory Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "cminventory").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cminventory Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> performanceBalanceSheet(String orgName, String orgDivision) {
		logger.info("Method : performanceBalanceSheet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "performanceBalanceSheet").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : performanceBalanceSheet Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> returnonequity(String orgName, String orgDivision) {
		logger.info("Method : returnonequity Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "returnonequity").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : returnonequity Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualForcastIndicators(String orgName, String orgDivision) {
		logger.info("Method : actualForcastIndicators Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "actualForcastIndicators").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : actualForcastIndicators Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> actualForcastHighCharts(String orgName, String orgDivision) {
		logger.info("Method : actualForcastHighCharts Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "actualForcastHighCharts").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : actualForcastHighCharts Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> profitLossSheet(String orgName, String orgDivision) {
		logger.info("Method : profitLossSheet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "profitLossSheet").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : profitLossSheet Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> revenuecogsRate(String orgName, String orgDivision) {
		logger.info("Method : revenuecogsRate Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "revenuecogsRate").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : revenuecogsRate Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> opexSheet(String orgName, String orgDivision) {
		logger.info("Method : opexSheet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "opexSheet").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : opexSheet Dao ends" + resp);
		return resp;

	}

	// earningBeforeTaxes

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> earningBeforeTaxes(String orgName, String orgDivision) {
		logger.info("Method : earningBeforeTaxes Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "earnBeforeTax").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : earningBeforeTaxes Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> opexYearWise(String orgName, String orgDivision) {
		logger.info("Method : opexYearWise Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "opexYearWise").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : opexYearWise Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> grossProfitLoss(String orgName, String orgDivision) {
		logger.info("Method : grossProfitLoss Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "grossProfitLoss").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : grossProfitLoss Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> grossOpexRatio(String orgName, String orgDivision) {
		logger.info("Method : grossOpexRatio Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "grossOpexRatio").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : grossOpexRatio Dao ends" + resp);
		return resp;

	}

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> operatingProfit(String orgName, String orgDivision) {
		logger.info("Method : operatingProfit Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "operatingProfit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : operatingProfit Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> netProfit(String orgName, String orgDivision) {
		logger.info("Method : netProfit Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_dashboard_Routines")
					.setParameter("actionType", "netProfit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : netProfit Dao ends" + resp);
		return resp;

	}

*/
}