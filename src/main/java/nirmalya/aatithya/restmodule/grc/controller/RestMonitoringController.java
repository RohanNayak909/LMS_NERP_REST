package nirmalya.aatithya.restmodule.grc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.MitigationDao;
import nirmalya.aatithya.restmodule.grc.dao.MonitoringDao;

@RestController
@RequestMapping("grc/")
public class RestMonitoringController {
	Logger logger = LoggerFactory.getLogger(RestMonitoringController.class);

	@Autowired

	MonitoringDao monitoringDao;

	@RequestMapping(value = "viewRiskdetailsForMonitoring", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRiskdetailsForMonitoring(@RequestParam String orgName, String orgDivision,
			String userId) {
		logger.info("Method :viewRiskdetailsForMonitoring start");

		logger.info("Method :viewRiskdetailsForMonitoring endss");
		return monitoringDao.viewRiskdetailsForMonitoring(orgName, orgDivision, userId);

	}
}
