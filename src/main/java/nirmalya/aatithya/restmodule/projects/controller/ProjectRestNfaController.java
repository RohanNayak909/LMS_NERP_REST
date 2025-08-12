package nirmalya.aatithya.restmodule.projects.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.ProjectNfaDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;

@RestController
@RequestMapping(value = "projects")
public class ProjectRestNfaController {
	Logger logger = LoggerFactory.getLogger(ProjectRestNfaController.class);

	@Autowired
	ProjectNfaDao projectNfaDao;
	
	@RequestMapping(value = "rest-nfaAdd", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> nfaAdd(
			@RequestBody ProjectCreationRestModel saveCategory) {
		logger.info("Method : nfaAdd starts");

		logger.info("Method : nfaAdd ends");
		return projectNfaDao.nfaAddDao(saveCategory);
	}
	
	@RequestMapping(value = "rest-nfaview", method = { RequestMethod.GET })

	public JsonResponse<Object> nfaview(@RequestParam String userid, @RequestParam String id,@RequestParam String id2, @RequestParam String org,
			@RequestParam String div) {
		logger.info("Method :rest-nfaview start");

		logger.info("Method :rest-nfaview endss");
		return projectNfaDao.nfaviewDao(userid,id,id2, org, div);
	}

}
