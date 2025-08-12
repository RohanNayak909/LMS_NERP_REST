package nirmalya.aatithya.restmodule.purchase.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseDashboardCostDao;

@RestController
@RequestMapping(value = { "purchase" })
public class RestPurchaseDashboardCostController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardCostController.class);

	@Autowired
	RestPurchaseDashboardCostDao restPurchaseDashboardCostDao;

	// procurement-roi
	@RequestMapping(value = "procurement-roi", method = { RequestMethod.GET })
	public JsonResponse<Object> procurementROI(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :procurementROI start");

		logger.info("Method :procurementROI endss");
		return restPurchaseDashboardCostDao.procurementROI(orgName,orgDivision,fromDate,toDate,loc);
	}

	// cost-fiveyear-trend
	@RequestMapping(value = "cost-fiveyear-trend", method = { RequestMethod.GET })
	public JsonResponse<Object> costFiveYearTrend(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :costFiveYearTrend start");

		logger.info("Method :costFiveYearTrend endss");
		return restPurchaseDashboardCostDao.costFiveYearTrend(orgName,orgDivision,fromDate,toDate,loc);
	}

	// cost-fiveyear-trend1
	@RequestMapping(value = "cost-fiveyear-trend1", method = { RequestMethod.GET })
	public JsonResponse<Object> costFiveYearTrend1(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :costFiveYearTrend1 start");

		logger.info("Method :costFiveYearTrend1 endss");
		return restPurchaseDashboardCostDao.costFiveYearTrend1(orgName,orgDivision,fromDate,toDate,loc);
	}

	// cost-saving-fiveyear-trend
	@RequestMapping(value = "cost-saving-fiveyear-trend", method = { RequestMethod.GET })
	public JsonResponse<Object> costSavingFiveYearTrend(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :costSavingFiveYearTrend start");

		logger.info("Method :costSavingFiveYearTrend endss");
		return restPurchaseDashboardCostDao.costSavingFiveYearTrend(orgName,orgDivision,fromDate,toDate,loc);
	}

	// cost-avoidance-fiveyear-trend
	@RequestMapping(value = "cost-avoidance-fiveyear-trend", method = { RequestMethod.GET })
	public JsonResponse<Object> costAvoidanceFiveYearTrend(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :costAvoidanceFiveYearTrend start");

		logger.info("Method :costAvoidanceFiveYearTrend endss");
		return restPurchaseDashboardCostDao.costAvoidanceFiveYearTrend(orgName,orgDivision,fromDate,toDate,loc);
	}

	// cost-fiveyear-trend2
	@RequestMapping(value = "cost-fiveyear-trend2", method = { RequestMethod.GET })
	public JsonResponse<Object> costFiveYearTrend2(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :costFiveYearTrend2 start");

		logger.info("Method :costFiveYearTrend2 endss");
		return restPurchaseDashboardCostDao.costFiveYearTrend2(orgName,orgDivision,fromDate,toDate,loc);
	}

	// cost-reduction-supplier
	@RequestMapping(value = "cost-reduction-supplier", method = { RequestMethod.GET })
	public JsonResponse<Object> costReductionBySupplier(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :costReductionBySupplier start");

		logger.info("Method :costReductionBySupplier endss");
		return restPurchaseDashboardCostDao.costReductionBySupplier(orgName,orgDivision,fromDate,toDate,loc);
	}

	// cost-saving
	@RequestMapping(value = "cost-saving", method = { RequestMethod.GET })
	public JsonResponse<Object> costSavings(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :costSavings start");

		logger.info("Method :costSavings endss");
		return restPurchaseDashboardCostDao.costSavings(orgName,orgDivision,fromDate,toDate,loc);
	}
	
	//cost-avoidance
	@RequestMapping(value = "cost-avoidance", method = { RequestMethod.GET })
	public JsonResponse<Object> costAvoidance(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :costAvoidance start");

		logger.info("Method :costAvoidance endss");
		return restPurchaseDashboardCostDao.costAvoidance(orgName,orgDivision,fromDate,toDate,loc);
	}
}
