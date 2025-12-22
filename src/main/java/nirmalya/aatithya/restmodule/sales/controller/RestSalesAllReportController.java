package nirmalya.aatithya.restmodule.sales.controller;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.RestDeliveryChallanDao;
import nirmalya.aatithya.restmodule.sales.dao.RestSalesAllReportDao;


	@RestController
	@RequestMapping("sales/")
	public class RestSalesAllReportController {
		Logger logger = LoggerFactory.getLogger(RestSalesAllReportDao.class);

		@Autowired

		RestSalesAllReportDao restSalesAllReportDao;
	
	
	

		@RequestMapping(value = "rest-viewReportList", method = { RequestMethod.GET })
		public JsonResponse<Object> viewReportList(@RequestParam String orgName, @RequestParam String orgDivision) {
			logger.info("Method :viewReportList start");

			logger.info("Method :viewReportList endss");
			return restSalesAllReportDao.viewReportList(orgName, orgDivision);

		}
		
		@RequestMapping(value = "rest-viewsalesReport", method = { RequestMethod.GET })
		public JsonResponse<Object> viewsalesReport(@RequestParam String orgName, @RequestParam String orgDivision,
				String fDate,String tDate,String empId) {
			logger.info("Method :viewsalesReport start");

			logger.info("Method :viewsalesReport endss");
			return restSalesAllReportDao.viewsalesReport(orgName, orgDivision, fDate, tDate, empId);

		}
		
		@RequestMapping(value = "rest-viewsalesPOReport", method = { RequestMethod.GET })
		public JsonResponse<Object> viewsalesPOReport(@RequestParam String orgName, @RequestParam String orgDivision,
				String fDate,String tDate,String empId) {
			logger.info("Method :viewsalesPOReport start");

			logger.info("Method :viewsalesPOReport endss");
			return restSalesAllReportDao.viewsalesPOReport(orgName, orgDivision, fDate, tDate,empId);

		}
	//
		@RequestMapping(value = "rest-viewsalesSOReport", method = { RequestMethod.GET })
		public JsonResponse<Object> viewsalesSOReport(@RequestParam String orgName, @RequestParam String orgDivision,
				String fDate,String tDate,String empId) {
			logger.info("Method :viewsalesSOReport start");

			logger.info("Method :viewsalesSOReport endss");
			return restSalesAllReportDao.viewsalesSOReport(orgName, orgDivision, fDate, tDate,empId);

		}
	//
		@RequestMapping(value = "getSaleExecutivesList", method = { RequestMethod.GET })
			public List<DropDownModel> getSaleExecutivesList(@RequestParam String org,String orgDiv) {
			logger.info("Method in rest: getSaleExecutivesList starts");
			logger.info("Method in rest: getSaleExecutivesList ends");
			return restSalesAllReportDao.getSaleExecutivesList(org,orgDiv);
		}

}
