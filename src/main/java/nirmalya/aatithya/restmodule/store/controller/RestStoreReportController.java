package nirmalya.aatithya.restmodule.store.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.StoreReportDao;

@RestController
@RequestMapping(value = "master/")
public class RestStoreReportController {
	Logger logger = LoggerFactory.getLogger(RestStoreReportController.class);

	@Autowired
	StoreReportDao storeReportDao;
	
	@RequestMapping(value = "rest-viewStoreReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewStoreReportData(@RequestParam String orgName, @RequestParam String orgDivision, String state) {
		logger.info("Method :viewStoreReportData start");

		logger.info("Method :viewStoreReportData endss");
		return storeReportDao.viewStoreReportData(orgName, orgDivision , state);

	}
	
	@RequestMapping(value = "rest-viewStoreReportFilterData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewStoreReportFilterData(@RequestParam String orgName, @RequestParam String orgDivision, String slno) {
		logger.info("Method :viewStoreReportFilterData start");

		logger.info("Method :viewStoreReportFilterData endss");
		return storeReportDao.viewStoreReportFilterData(orgName, orgDivision , slno);

	}
}
