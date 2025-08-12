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
public class RestPurchaseDashboardQualityDao {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardQualityDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	// spendUnderManagement
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> spendUnderManagement(String orgName, String orgDivision) {
		logger.info("Method : spendUnderManagement Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "spndUndrManagmnt").setParameter("actionValue", value).getResultList();
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

	// ReturnCostAnalysis
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> returnCostAnalysis(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : returnCostAnalysis Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("returnCostAnalysis" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "ReturnCostAnalysis").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : returnCostAnalysis Dao ends" + resp);
		return resp;

	}

	// CountVendorMonthWise
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> countVendorMonthWise(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : countVendorMonthWise Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("countVendorMonthWise" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "CntVenMonWise").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : countVendorMonthWise Dao ends" + resp);
		return resp;

	}

	// supplierQualityRating
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> supplierQualityRating(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : supplierQualityRating Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("supplierQualityRating" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "supplyQaRating").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : supplierQualityRating Dao ends" + resp);
		return resp;

	}

	// lossDefectProducts
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> lossDefectProducts(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : lossDefectProducts Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("lossDefectProducts  " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "lossDefectProducts").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : lossDefectProducts Dao ends" + resp);
		return resp;

	}

	// lossDefectSuppliers
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> lossDefectSuppliers(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : lossDefectSuppliers Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			logger.info("lossDefectSuppliers : " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "lossDefectSuppliers").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : lossDefectSuppliers Dao ends" + resp);
		return resp;

	}

	// stateWiseLoss
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> stateWiseLoss(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : stateWiseLoss Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "stateWiseLoss").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : stateWiseLoss Dao ends" + resp);
		return resp;

	}

	// trendOfLoss
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> trendOfLoss(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : trendOfLoss Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "trendOfLoss").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : trendOfLoss Dao ends" + resp);
		return resp;

	}

	// trendOfDefect
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> trendOfDefect(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : trendOfDefect Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "trendOfDefect").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : trendOfDefect Dao ends" + resp);
		return resp;
	}

	// trendOfInbound
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> trendOfInbound(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : trendOfInbound Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "trendOfInbound").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : trendOfInbound Dao ends" + resp);
		return resp;
	}

	// trendOfOutbound
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> trendOfOutbound(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : trendOfOutbound Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "trendOfOutbound").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : trendOfOutbound Dao ends" + resp);
		return resp;
	}

	// trendOfFrequency
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> trendOfFrequency(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : trendOfFrequency Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "trendOfFrequency").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : trendOfFrequency Dao ends" + resp);
		return resp;
	}

	// lossBySuppliers
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> lossBySuppliers(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : lossBySuppliers Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "lossBySuppliers").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : lossBySuppliers Dao ends" + resp);
		return resp;
	}

	// defectTypeDistribution
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> defectTypeDistribution(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : defectTypeDistribution Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "defectTypeDistribution").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : defectTypeDistribution Dao ends" + resp);
		return resp;
	}

	// distributionIssuesRemarks
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> distributionIssuesRemarks(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : defectTypeDistribution Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "distributionIssuesRemarks").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : distributionIssuesRemarks Dao ends" + resp);
		return resp;
	}

	// supplierSummary
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> supplierSummary(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : supplierSummary Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "supplierSummary").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : supplierSummary Dao ends" + resp);
		return resp;
	}

	/* Defect tab of quality */

	// defectTypeDistributionInDefects
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> defectTypeDistributionInDefects(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : defectTypeDistributionInDefects Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "defectTypeDistribut").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : defectTypeDistributionInDefects Dao ends" + resp);
		return resp;
	}

	// defectRateTrends
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> defectRateTrends(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : defectRateTrends Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "defectRateTrends").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : defectRateTrends Dao ends" + resp);
		return resp;
	}

	// defectDistTable
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> defectDistTable(String orgName, String orgDivision, String fromDate, String toDate,
			String loc) {
		logger.info("Method : defectDistTable Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "defectDistTable").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : defectDistTable Dao ends" + resp);
		return resp;
	}

	// bottomSuppliersDefect
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> bottomSuppliersDefect(String orgName, String orgDivision, String fromDate,
			String toDate, String loc) {
		logger.info("Method : bottomSuppliersDefect Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
					.setParameter("actionType", "bottomSuppliersDefect").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : bottomSuppliersDefect Dao ends" + resp);
		return resp;
	}
}
