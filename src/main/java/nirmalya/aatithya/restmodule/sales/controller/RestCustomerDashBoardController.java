package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.RestCustomerDashboardDao;
import nirmalya.aatithya.restmodule.sales.model.RestCustomerGraphModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustomerStoreGraphModel;

@RestController
@RequestMapping(value = "sales/")
public class RestCustomerDashBoardController {
Logger logger = LoggerFactory.getLogger(RestCustomerDashBoardController.class);
	
	@Autowired
	RestCustomerDashboardDao customerDashboardDao;
	
	
	//getOrganization
	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
		logger.info("Method : getOrganizationDivision starts");

		logger.info("Method : getOrganizationDivision ends");
		return customerDashboardDao.getOrganization(orgName);
	}

	
	// organisationDivision
	@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
	public List<DropDownModel> getDivision(@RequestParam String orgName) {
		logger.info("Method : getDivision starts");

		logger.info("Method : getDivision ends");
		return customerDashboardDao.getDivision(orgName);
	}
	
	
	
	
	@RequestMapping(value = "customer-dashboard-oprationalHeadData", method = { RequestMethod.GET })
	public JsonResponse<Object> oprationalHeadData(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
		logger.info("Method :oprationalHeadData start");

		logger.info("Method :oprationalHeadData endss");
		return customerDashboardDao.oprationalHeadData(fromDate,toDate,org,orgDiv,loc);

	}


	
	@RequestMapping(value = "customer-dashboard-getAllInvoice", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllInvoice(@RequestParam String id,@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
		logger.info("Method :getAllInvoice start");
		
		logger.info("Method :getAllInvoice endss");
		return customerDashboardDao.getAllInvoice(id, fromDate,toDate,org,orgDiv,loc);
		
	}
	
	//getAllSalesCityList
			@RequestMapping(value = "getAllSalesCityList", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllSalesCityList(@RequestParam String id) {
				logger.info("Method : getAllSalesCityList starts");
				logger.info("Method : getAllSalesCityList ends");
				return customerDashboardDao.getAllSalesCityList(id);
			}

	
		//performanceHeadCount		
		@RequestMapping(value = "customer-dashboard-performance-count", method = { RequestMethod.GET })
		public JsonResponse<Object> performanceHeadCount(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc, @RequestParam String searchMode) {
			logger.info("Method :performanceHeadCount start");

			logger.info("Method :performanceHeadCount endss");
			return customerDashboardDao.performanceHeadCount(fromDate,toDate,org,orgDiv,loc,searchMode);

		}
		
		
		
		//performanceWeeklySalesRevenue
		@RequestMapping(value = "performanceWeeklySalesRevenue", method = { RequestMethod.GET })
		public JsonResponse<Object> performanceWeeklySalesRevenue(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc, @RequestParam String searchMode) {
			logger.info("Method :performanceWeeklySalesRevenue start");

			logger.info("Method :performanceWeeklySalesRevenue endss");
			return customerDashboardDao.performanceWeeklySalesRevenue(fromDate,toDate,org,orgDiv,loc,searchMode);

		}
		
		//stateWiseSalesPerformance		
		@RequestMapping(value = "stateWiseSalesPerformance", method = { RequestMethod.GET })
		public JsonResponse<Object> stateWiseSalesPerformance(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc, @RequestParam String searchMode) {
			logger.info("Method :stateWiseSalesPerformance start");

			logger.info("Method :stateWiseSalesPerformance endss");
			return customerDashboardDao.stateWiseSalesPerformance(fromDate,toDate,org,orgDiv,loc,searchMode);

		}
		
		
		//accumulatedRevenuePerformance
		@RequestMapping(value = "accumulatedRevenuePerformance", method = { RequestMethod.GET })
		public JsonResponse<Object> accumulatedRevenuePerformance(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc, @RequestParam String searchMode) {
			logger.info("Method :accumulatedRevenuePerformance start");

			logger.info("Method :accumulatedRevenuePerformance endss");
			return customerDashboardDao.accumulatedRevenuePerformance(fromDate,toDate,org,orgDiv,loc,searchMode);

		}
		
		
		//avgRevenuePerOrder
		@RequestMapping(value = "avgRevenuePerOrder", method = { RequestMethod.GET })
		public JsonResponse<Object> avgRevenuePerOrder(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc, @RequestParam String searchMode) {
			logger.info("Method :avgRevenuePerOrder start");

			logger.info("Method :avgRevenuePerOrder endss");
			return customerDashboardDao.avgRevenuePerOrder(fromDate,toDate,org,orgDiv,loc,searchMode);

		}
		
		
		//customerLifeTimeValue
		@RequestMapping(value = "customerLifeTimeValue", method = { RequestMethod.GET })
		public JsonResponse<Object> customerLifeTimeValue(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc, @RequestParam String searchMode) {
			logger.info("Method :customerLifeTimeValue start");

			logger.info("Method :customerLifeTimeValue endss");
			return customerDashboardDao.customerLifeTimeValue(fromDate,toDate,org,orgDiv,loc,searchMode);

		}
		
		
		//acquisitionCostPerformance
		@RequestMapping(value = "acquisitionCostPerformance", method = { RequestMethod.GET })
		public JsonResponse<Object> acquisitionCostPerformance(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc, @RequestParam String searchMode) {
			logger.info("Method :acquisitionCostPerformance start");

			logger.info("Method :acquisitionCostPerformance endss");
			return customerDashboardDao.acquisitionCostPerformance(fromDate,toDate,org,orgDiv,loc,searchMode);

		}
		
		
		//KPIHeadCount
		@RequestMapping(value = "KPIHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> KPIHeadCount(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
			logger.info("Method :KPIHeadCount start");

			logger.info("Method :KPIHeadCount endss");
			return customerDashboardDao.KPIHeadCount(fromDate,toDate,org,orgDiv,loc);

		}
		
		//KPISalesRevenueWithCross
		@RequestMapping(value = "KPISalesRevenueWithCross", method = { RequestMethod.GET })
		public JsonResponse<Object> KPISalesRevenueWithCross(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
			logger.info("Method :KPISalesRevenueWithCross start");

			logger.info("Method :KPISalesRevenueWithCross endss");
			return customerDashboardDao.KPISalesRevenueWithCross(fromDate,toDate,org,orgDiv,loc);

		}
		
		//KPIAccumulatedSalesRevenue
		@RequestMapping(value = "KPIAccumulatedSalesRevenue", method = { RequestMethod.GET })
		public JsonResponse<Object> KPIAccumulatedSalesRevenue(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc,@RequestParam String previousFromDate,@RequestParam String previousToDate) {
			logger.info("Method :KPIAccumulatedSalesRevenue start");

			logger.info("Method :KPIAccumulatedSalesRevenue endss");
			return customerDashboardDao.KPIAccumulatedSalesRevenue(fromDate,toDate,org,orgDiv,loc, previousFromDate, previousToDate);

		}
		
		//KPIIncrementalSourceRevenue
		@RequestMapping(value = "KPIIncrementalSourceRevenue", method = { RequestMethod.GET })
		public JsonResponse<Object> KPIIncrementalSourceRevenue(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
			logger.info("Method :KPIIncrementalSourceRevenue start");

			logger.info("Method :KPIIncrementalSourceRevenue endss");
			return customerDashboardDao.KPIIncrementalSourceRevenue(fromDate,toDate,org,orgDiv,loc);

		}
		
		//conversionHeadCount
		@RequestMapping(value = "conversionSalesHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> conversionSalesHeadCount(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
			logger.info("Method :conversionSalesHeadCount start");

			logger.info("Method :conversionSalesHeadCount endss");
			return customerDashboardDao.conversionSalesHeadCount(fromDate,toDate,org,orgDiv,loc);

		}
		
		//conversionLeadLastMonth
		@RequestMapping(value = "conversionLeadLastMonth", method = { RequestMethod.GET })
		public JsonResponse<Object> conversionLeadLastMonth(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
			logger.info("Method :conversionLeadLastMonth start");

			logger.info("Method :conversionLeadLastMonth endss");
			return customerDashboardDao.conversionLeadLastMonth(fromDate,toDate,org,orgDiv,loc);

		}
		
		
		//cycleAvgSalesLengthMonthly
		@RequestMapping(value = "cycleAvgSalesLengthMonthly", method = { RequestMethod.GET })
		public JsonResponse<Object> cycleAvgSalesLengthMonthly(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
			logger.info("Method :cycleAvgSalesLengthMonthly start");

			logger.info("Method :cycleAvgSalesLengthMonthly endss");
			return customerDashboardDao.cycleAvgSalesLengthMonthly(fromDate,toDate,org,orgDiv,loc);

		}
		
		//cycleFunnelCount
		@RequestMapping(value = "cycleFunnelCount", method = { RequestMethod.GET })
		public JsonResponse<Object> cycleFunnelCount(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
			logger.info("Method :cycleFunnelCount start");

			logger.info("Method :cycleFunnelCount endss");
			return customerDashboardDao.cycleFunnelCount(fromDate,toDate,org,orgDiv,loc);

		}
		
		
		//cycleAvgSalesLength
		@RequestMapping(value = "cycleAvgSalesLength", method = { RequestMethod.GET })
		public JsonResponse<Object> cycleAvgSalesLength(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String org ,@RequestParam String orgDiv,@RequestParam String loc) {
			logger.info("Method :cycleAvgSalesLength start");

			logger.info("Method :cycleAvgSalesLength endss");
			return customerDashboardDao.cycleAvgSalesLength(fromDate,toDate,org,orgDiv,loc);

		}
	
		
}
