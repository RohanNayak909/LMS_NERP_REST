package nirmalya.aatithya.restmodule.grc.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.SafetyAssesmentRestDao;
import nirmalya.aatithya.restmodule.grc.model.SafetyAssesmentRestModel;
@RestController
@RequestMapping(value = "grc")

public class SafetyAssesmentRestController {


	Logger logger = LoggerFactory.getLogger(SafetyAssesmentRestController.class);
	
	@Autowired
	SafetyAssesmentRestDao daoManager;
	
	//viewSafetyAssess
	@GetMapping(value = "rest-viewSafetyAssess")
	public ResponseEntity<JsonResponse<List<SafetyAssesmentRestModel>>> viewSafetyAssess(@RequestParam String id,@RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewSafetyAssess starts");

		logger.info("Method : viewSafetyAssess ends");
		return daoManager.viewSafetyAssess(id, userId, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-editSafetyAssess", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SafetyAssesmentRestModel>>> editSafetyAssess(@RequestParam String id ,@RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : editSafetyAssess starts"+id);
		
		logger.info("Method : editSafetyAssess ends");
		return daoManager.editSafetyAssess(id, userId, org, orgDiv);
	}
	//addSafetyIdentification
			@PostMapping(value = "rest-addSafetyAssess")
			public ResponseEntity<JsonResponse<Object>> addSafetyAssess(
					@RequestBody SafetyAssesmentRestModel model) {
				logger.info("Method :addSafetyAssess starts");
				logger.info("Method :addSafetyAssess endss");
				return daoManager.addSafetyAssess(model);
			}
}
