package nirmalya.aatithya.restmodule.qa.controller;

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
import nirmalya.aatithya.restmodule.qa.dao.TestReportDao;

@RestController
@RequestMapping(value = "production/")
public class TestReportRestController {
	
	Logger logger = LoggerFactory.getLogger(RestSampleTestController.class);

	@Autowired
	TestReportDao testReportDao;
	
	// Item List.
	@RequestMapping(value = "getItemList", method = { RequestMethod.GET })
	public List<DropDownModel> getItemList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getItemList starts");

		logger.info("Method : getItemList ends");
		return testReportDao.getItemList(org,orgDiv);
	}
	
	// view
	@RequestMapping(value = "rest-viewTestReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTestReportData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewTestReportData start");

		logger.info("Method :viewTestReportData endss");
		return testReportDao.viewTestReportData(orgName,orgDivision);

	}
	
	// View Details
	@RequestMapping(value = "rest-viewTestReportDtlsData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTestReportDtlsData(@RequestParam String orgName, String orgDivision, String sku , String fdate, String tdate) {
		logger.info("Method :viewTestReportDtlsData start");

		logger.info("Method :viewTestReportDtlsData endss");
		return testReportDao.viewTestReportDtlsData(orgName,orgDivision,sku,fdate,tdate);

	}

}
