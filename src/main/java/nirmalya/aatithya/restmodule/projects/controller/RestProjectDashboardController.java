package nirmalya.aatithya.restmodule.projects.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.RestProjectDashboardDao;

@RestController
@RequestMapping(value = { "projects/" })
public class RestProjectDashboardController {
	Logger logger = LoggerFactory.getLogger(RestProjectDashboardController.class);

	@Autowired
	RestProjectDashboardDao restProjectDashboardDao;
	
	@RequestMapping(value = "projectHeadData", method = { RequestMethod.GET })
	public JsonResponse<Object> projectHeadData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :projectHeadData start");

		logger.info("Method :projectHeadData endss");
		return restProjectDashboardDao.projectHeadData(orgName, orgDivision);

	}
	
	
	@RequestMapping(value = "projectDashoardAllReport", method = { RequestMethod.GET })
	public JsonResponse<Object> projectDashoardAllReport(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method :getAllReport start");

		logger.info("Method :getAllReport endss");
		return restProjectDashboardDao.projectDashoardAllReport(orgName, orgDivision,id);

	}
	
}