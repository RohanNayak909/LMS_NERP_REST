package nirmalya.aatithya.restmodule.projects.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.ProjectBillingDao;
@RestController
@RequestMapping(value = "projects")
public class RestProjectBillingCycleController {
	Logger logger = LoggerFactory.getLogger(RestProjectBillingCycleController.class);

	@Autowired
	ProjectBillingDao projectBillingDao;
	
	@RequestMapping(value = "rest-viewGrn", method = { RequestMethod.GET })

	public JsonResponse<Object> viewGrn(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :viewGrn start");

		logger.info("Method :viewGrn endss");
		return projectBillingDao.viewGrn(userid, org, div, id);
	}
}
