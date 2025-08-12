package nirmalya.aatithya.restmodule.warehouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.RestWarehouseReportDao;

@RestController
@RequestMapping(value = "master/")
public class RestWarehouseReportController {

	Logger logger = LoggerFactory.getLogger(RestWarehouseReportController.class);

	@Autowired
	RestWarehouseReportDao restWarehouseReportDao;

	@RequestMapping(value = "rest-viewWarehouseReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWarehouseReportData(@RequestParam String orgName, @RequestParam String orgDivision, String state) {
		logger.info("Method :viewWarehouseReportData start");

		logger.info("Method :viewWarehouseReportData endss");
		return restWarehouseReportDao.viewWarehouseReportData(orgName, orgDivision , state);

	}
	
	@RequestMapping(value = "rest-viewWarehouseReportFilterData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWarehouseReportFilterData(@RequestParam String orgName, @RequestParam String orgDivision, String slno) {
		logger.info("Method :viewWarehouseReportData start");

		logger.info("Method :viewWarehouseReportData endss");
		return restWarehouseReportDao.viewWarehouseReportFilterData(orgName, orgDivision , slno);

	}
	
	@RequestMapping(value = "rest-viewWarehouseReportForItemWiseStock", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWarehouseReportForItemWiseStock(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewWarehouseReportForItemWiseStock start");

		logger.info("Method :viewWarehouseReportForItemWiseStock endss");
		return restWarehouseReportDao.viewWarehouseReportForItemWiseStock(orgName, orgDivision);

	}
	
	// Stock Register View.
	
	@RequestMapping(value = "rest-viewWarehouseReportForStockRegister", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWarehouseReportForStockRegister(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewWarehouseReportForStockRegister start");

		logger.info("Method :viewWarehouseReportForStockRegister endss");
		return restWarehouseReportDao.viewWarehouseReportForStockRegister(orgName, orgDivision);

	}
}
