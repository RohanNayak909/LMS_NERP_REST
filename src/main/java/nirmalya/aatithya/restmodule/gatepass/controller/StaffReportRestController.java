package nirmalya.aatithya.restmodule.gatepass.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.dao.StaffReportDao;

@RestController
@RequestMapping("gatepass/")
public class StaffReportRestController {
	

	Logger logger = LoggerFactory.getLogger(StaffReportRestController.class);

	@Autowired
	StaffReportDao staffReportDao;

	// View Assigned Asset
	@RequestMapping(value = "rest-staff-report-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetReport(@RequestParam String fromdate, String todate,String orgName, String orgDivision) {
		logger.info("Method :viewAssetReport start");

		logger.info("Method :viewAssetReport endss");
		return staffReportDao.viewStaffReport(fromdate,todate,orgName, orgDivision);
	}
	@RequestMapping(value = "rest-staff-report-list", method = { RequestMethod.GET })
	public JsonResponse<Object> showTotal(@RequestParam String id,String fromdate, String todate, String orgName, String orgDivision) {
		logger.info("Method :showTotal start");

		logger.info("Method :showTotal endss");
		return staffReportDao.showTotal(id,fromdate,todate, orgName, orgDivision);
	}
}
