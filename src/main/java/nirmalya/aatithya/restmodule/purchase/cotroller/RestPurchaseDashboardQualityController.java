package nirmalya.aatithya.restmodule.purchase.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseDashboardQualityDao;

@RestController
@RequestMapping(value = { "purchase" })
public class RestPurchaseDashboardQualityController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardQualityController.class);

	@Autowired
	RestPurchaseDashboardQualityDao restPurchaseDashboardQualityDao;

	// spend-under-management
	@RequestMapping(value = "spend-under-management", method = { RequestMethod.GET })
	public JsonResponse<Object> spendUnderManagement(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :spendUnderManagement start");

		logger.info("Method :spendUnderManagement endss");
		return restPurchaseDashboardQualityDao.spendUnderManagement(orgName, orgDivision);
	}

	// return-cost-analysis
	@RequestMapping(value = "return-cost-analysis", method = { RequestMethod.GET })
	public JsonResponse<Object> returnCostAnalysis(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {

		logger.info("Method :ReturnCostAnalysis start");

		logger.info("Method :ReturnCostAnalysis endss");
		return restPurchaseDashboardQualityDao.returnCostAnalysis(orgName, orgDivision, fromDate, toDate, loc);
	}

	// count-vendor-month-wise
	@RequestMapping(value = "count-vendor-month-wise", method = { RequestMethod.GET })
	public JsonResponse<Object> countVendorMonthWise(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :CountVendorMonthWise start");

		logger.info("Method :CountVendorMonthWise endss");
		return restPurchaseDashboardQualityDao.countVendorMonthWise(orgName, orgDivision, fromDate, toDate, loc);
	}

	// supplier-quality-rating
	@RequestMapping(value = "supplier-quality-rating", method = { RequestMethod.GET })
	public JsonResponse<Object> supplierQualityRating(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :supplierQualityRating start");

		logger.info("Method :supplierQualityRating endss");
		return restPurchaseDashboardQualityDao.supplierQualityRating(orgName, orgDivision, fromDate, toDate, loc);
	}

	// loss-defectProducts
	@RequestMapping(value = "loss-defectProducts", method = { RequestMethod.GET })
	public JsonResponse<Object> lossDefectProducts(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :lossDefectProducts start");

		logger.info("Method :lossDefectProducts endss");
		return restPurchaseDashboardQualityDao.lossDefectProducts(orgName, orgDivision, fromDate, toDate, loc);
	}

	// loss-defect-suppliers
	@RequestMapping(value = "loss-defect-suppliers", method = { RequestMethod.GET })
	public JsonResponse<Object> lossDefectSuppliers(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :lossDefectSuppliers start");

		logger.info("Method :lossDefectSuppliers endss");
		return restPurchaseDashboardQualityDao.lossDefectSuppliers(orgName, orgDivision, fromDate, toDate, loc);
	}

	// state-wise-loss
	@RequestMapping(value = "state-wise-loss", method = { RequestMethod.GET })
	public JsonResponse<Object> stateWiseLoss(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :stateWiseLoss start");

		logger.info("Method :stateWiseLoss endss");
		return restPurchaseDashboardQualityDao.stateWiseLoss(orgName, orgDivision, fromDate, toDate, loc);
	}

	// trend-of-loss
	@RequestMapping(value = "trend-of-loss", method = { RequestMethod.GET })
	public JsonResponse<Object> trendOfLoss(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :trendOfLoss start");

		logger.info("Method :trendOfLoss endss");
		return restPurchaseDashboardQualityDao.trendOfLoss(orgName, orgDivision, fromDate, toDate, loc);
	}

	// trend-of-defect
	@RequestMapping(value = "trend-of-defect", method = { RequestMethod.GET })
	public JsonResponse<Object> trendOfDefect(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :trendOfDefect start");

		logger.info("Method :trendOfDefect endss");
		return restPurchaseDashboardQualityDao.trendOfDefect(orgName, orgDivision, fromDate, toDate, loc);
	}

	// trend-of-inbound
	@RequestMapping(value = "trend-of-inbound", method = { RequestMethod.GET })
	public JsonResponse<Object> trendOfInbound(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :trendOfInbound start");

		logger.info("Method :trendOfInbound endss");
		return restPurchaseDashboardQualityDao.trendOfInbound(orgName, orgDivision, fromDate, toDate, loc);
	}

	// trend-of-outbound
	@RequestMapping(value = "trend-of-outbound", method = { RequestMethod.GET })
	public JsonResponse<Object> trendOfOutbound(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :trendOfOutbound start");

		logger.info("Method :trendOfOutbound endss");
		return restPurchaseDashboardQualityDao.trendOfOutbound(orgName, orgDivision, fromDate, toDate, loc);
	}

	// trend-of-frequency
	@RequestMapping(value = "trend-of-frequency", method = { RequestMethod.GET })
	public JsonResponse<Object> trendOfFrequency(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :trendOfFrequency start");

		logger.info("Method :trendOfFrequency endss");
		return restPurchaseDashboardQualityDao.trendOfFrequency(orgName, orgDivision, fromDate, toDate, loc);
	}

	/* profile tab of quality */

	// loss-by-suppliers
	@RequestMapping(value = "loss-by-suppliers", method = { RequestMethod.GET })
	public JsonResponse<Object> lossBySuppliers(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :lossBySuppliers start");

		logger.info("Method :lossBySuppliers endss");
		return restPurchaseDashboardQualityDao.lossBySuppliers(orgName, orgDivision, fromDate, toDate, loc);
	}

	// defect-type-distribution
	@RequestMapping(value = "defect-type-distribution", method = { RequestMethod.GET })
	public JsonResponse<Object> defectTypeDistribution(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :defectTypeDistribution start");

		logger.info("Method :defectTypeDistribution endss");
		return restPurchaseDashboardQualityDao.defectTypeDistribution(orgName, orgDivision, fromDate, toDate, loc);
	}

	// distribution-issues-remarks
	@RequestMapping(value = "distribution-issues-remarks", method = { RequestMethod.GET })
	public JsonResponse<Object> distributionIssuesRemarks(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :distributionIssuesRemarks start");

		logger.info("Method :distributionIssuesRemarks endss");
		return restPurchaseDashboardQualityDao.distributionIssuesRemarks(orgName, orgDivision, fromDate, toDate, loc);
	}

	// supplier-summary-product
	@RequestMapping(value = "supplier-summary-product", method = { RequestMethod.GET })
	public JsonResponse<Object> supplierSummary(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :supplierSummary start");

		logger.info("Method :supplierSummary endss");
		return restPurchaseDashboardQualityDao.supplierSummary(orgName, orgDivision, fromDate, toDate, loc);
	}

	/* Defect tab of quality */
	// distribution-defects
	@RequestMapping(value = "distribution-defects", method = { RequestMethod.GET })
	public JsonResponse<Object> defectTypeDistributionInDefects(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :defectTypeDistributionInDefects start");

		logger.info("Method :defectTypeDistributionInDefects endss");
		return restPurchaseDashboardQualityDao.defectTypeDistributionInDefects(orgName, orgDivision, fromDate, toDate, loc);
	}

	// defect-rate-trends
	@RequestMapping(value = "defect-rate-trends", method = { RequestMethod.GET })
	public JsonResponse<Object> defectRateTrends(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :defectRateTrends start");

		logger.info("Method :defectRateTrends endss");
		return restPurchaseDashboardQualityDao.defectRateTrends(orgName, orgDivision, fromDate, toDate, loc);
	}

	// distribution-table
	@RequestMapping(value = "distribution-table", method = { RequestMethod.GET })
	public JsonResponse<Object> defectDistTable(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :defectDistTable start");

		logger.info("Method :defectDistTable endss");
		return restPurchaseDashboardQualityDao.defectDistTable(orgName, orgDivision, fromDate, toDate, loc);
	}

	// bottom-suppliers-defect
	@RequestMapping(value = "bottom-suppliers-defect", method = { RequestMethod.GET })
	public JsonResponse<Object> bottomSuppliersDefect(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :bottomSuppliersDefect start");

		logger.info("Method :bottomSuppliersDefect endss");
		return restPurchaseDashboardQualityDao.bottomSuppliersDefect(orgName, orgDivision, fromDate, toDate, loc);
	}
}
