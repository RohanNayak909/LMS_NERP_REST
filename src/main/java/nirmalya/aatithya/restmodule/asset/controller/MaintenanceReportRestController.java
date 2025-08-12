package nirmalya.aatithya.restmodule.asset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.MaintenanceReportDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = { "asset/" })
public class MaintenanceReportRestController {
	Logger logger = LoggerFactory.getLogger(MaintenanceReportRestController.class);

	@Autowired
	MaintenanceReportDao maintenanceReportDao;
	
	@RequestMapping(value = "rest-sanitary-clean-data", method = { RequestMethod.GET })
	public JsonResponse<Object> getSanitaryCleanData(@RequestParam String fromDate,@RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getSanitaryCleanData start");

		logger.info("Method :getSanitaryCleanData endss");
		return maintenanceReportDao.getSanitaryCleanData(fromDate,toDate,orgName, orgDiv);
	}
	
	@RequestMapping(value = "rest-change-room-data", method = { RequestMethod.GET })
	public JsonResponse<Object> getChangeRoomData(@RequestParam String fromDate,@RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getChangeRoomData start");

		logger.info("Method :getChangeRoomData endss");
		return maintenanceReportDao.getChangeRoomData(fromDate,toDate,orgName, orgDiv);
	}
}
