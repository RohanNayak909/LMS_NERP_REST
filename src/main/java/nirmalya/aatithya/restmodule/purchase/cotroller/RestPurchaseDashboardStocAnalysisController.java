package nirmalya.aatithya.restmodule.purchase.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseDashboardStockAnalysisDao;

@RestController
@RequestMapping(value = { "purchase" })
public class RestPurchaseDashboardStocAnalysisController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardStocAnalysisController.class);

	@Autowired
	RestPurchaseDashboardStockAnalysisDao restPurchaseDashboardStockAnalysisDao;

	// analysis-head-data
	@RequestMapping(value = "analysis-head-data", method = { RequestMethod.GET })
	public JsonResponse<Object> analysisHeadData(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :analysisHeadData start");

		logger.info("Method :analysisHeadData endss");
		return restPurchaseDashboardStockAnalysisDao.analysisHeadData(orgName,orgDivision,fromDate,toDate,loc);
	}

	// analysis-stock-head-data
	@RequestMapping(value = "analysis-stock-head-data", method = { RequestMethod.GET })
	public JsonResponse<Object> stockHeadData(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :stockHeadData start");

		logger.info("Method :analysisHeadData endss");
		return restPurchaseDashboardStockAnalysisDao.stockHeadData(orgName,orgDivision,fromDate,toDate,loc);
	}

	// analysis-most-view
	@RequestMapping(value = "analysis-most-view", method = { RequestMethod.GET })
	public JsonResponse<Object> mostViewed(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :mostViewed start");

		logger.info("Method :mostViewed endss");
		return restPurchaseDashboardStockAnalysisDao.mostViewed(orgName,orgDivision,fromDate,toDate,loc);
	}

	// analysis-least-view
	@RequestMapping(value = "analysis-least-view", method = { RequestMethod.GET })
	public JsonResponse<Object> leastViewed(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :leastViewed start");

		logger.info("Method :leastViewed endss");
		return restPurchaseDashboardStockAnalysisDao.leastViewed(orgName,orgDivision,fromDate,toDate,loc);
	}

	// analysis-highest-inventory
	@RequestMapping(value = "analysis-highest-inventory", method = { RequestMethod.GET })
	public JsonResponse<Object> highInventory(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :highInventory start");

		logger.info("Method :highInventory endss");
		return restPurchaseDashboardStockAnalysisDao.highInventory(orgName,orgDivision,fromDate,toDate,loc);
	}

	// prideced-day-outofstock
	@RequestMapping(value = "prideced-day-outofstock", method = { RequestMethod.GET })
	public JsonResponse<Object> pridectedDayOutOfStock(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :pridectedDayOutOfStock start");

		logger.info("Method :pridectedDayOutOfStock endss");
		return restPurchaseDashboardStockAnalysisDao.pridectedDayOutOfStock(orgName,orgDivision,fromDate,toDate,loc);
	}

	// analysis-bottom-sales
	@RequestMapping(value = "analysis-bottom-sales", method = { RequestMethod.GET })
	public JsonResponse<Object> bottomSales(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :bottomSales start");

		logger.info("Method :bottomSales endss");
		return restPurchaseDashboardStockAnalysisDao.bottomSales(orgName,orgDivision,fromDate,toDate,loc);
	}

	// top-sales-running-outofstock
	@RequestMapping(value = "top-sales-running-outofstock", method = { RequestMethod.GET })
	public JsonResponse<Object> topRunningOutOfStock(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :topRunningOutOfStock start");

		logger.info("Method :topRunningOutOfStock endss");
		return restPurchaseDashboardStockAnalysisDao.topRunningOutOfStock(orgName,orgDivision,fromDate,toDate,loc);
	}

	// top-sales-outofstock
	@RequestMapping(value = "top-sales-outofstock", method = { RequestMethod.GET })
	public JsonResponse<Object> topSalesOutOfStock(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :topSalesOutOfStock start");

		logger.info("Method :topSalesOutOfStock endss");
		return restPurchaseDashboardStockAnalysisDao.topSalesOutOfStock(orgName,orgDivision,fromDate,toDate,loc);
	}

	// simulated-day-outofstock
	@RequestMapping(value = "simulated-day-outofstock", method = { RequestMethod.GET })
	public JsonResponse<Object> simulatedDaysOutOfStock(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :simulatedDaysOutOfStock start");

		logger.info("Method :simulatedDaysOutOfStock endss");
		return restPurchaseDashboardStockAnalysisDao.simulatedDaysOutOfStock(orgName,orgDivision,fromDate,toDate,loc);
	}
}
