package nirmalya.aatithya.restmodule.sales.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.RestSalesInvoiceReportDao;


@RestController
@RequestMapping("sales/")
public class RestSalesInvoiceReportController {
	
	Logger logger = LoggerFactory.getLogger(RestSalesInvoiceReportController.class);

	@Autowired

	RestSalesInvoiceReportDao restSalesInvoiceReportDao;
	
	@RequestMapping(value = "rest-viewSalesInvoiceReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSalesInvoiceReportData(@RequestParam String orgName, @RequestParam String orgDivision, String sec , String fromdate, String todate) {
		logger.info("Method :viewSalesInvoiceReportData start");

		logger.info("Method :viewSalesInvoiceReportData endss");
		return restSalesInvoiceReportDao.viewSalesInvoiceReportData(orgName, orgDivision , sec , fromdate , todate);

	}
	
	
	@RequestMapping(value = "rest-viewSalesReportDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSalesReportDtls(@RequestParam String orgName, @RequestParam String orgDivision, String id) {
		logger.info("Method :viewSalesReportDtls start");

		logger.info("Method :viewSalesReportDtls endss");
		return restSalesInvoiceReportDao.viewSalesReportDtls(orgName, orgDivision , id );

	}

}
