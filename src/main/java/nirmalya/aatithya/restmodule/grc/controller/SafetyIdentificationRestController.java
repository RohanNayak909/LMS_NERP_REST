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
import nirmalya.aatithya.restmodule.grc.dao.SafetyIdentificationRestDao;
import nirmalya.aatithya.restmodule.grc.model.SafetyIdentificationRestModel;

@RestController
@RequestMapping(value = "grc")

public class SafetyIdentificationRestController {
	
	Logger logger = LoggerFactory.getLogger(SafetyIdentificationRestController.class);
	
	@Autowired
	SafetyIdentificationRestDao daoManager;
	
	//viewProject
	@GetMapping(value = "rest-viewProject")
	public ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> viewProject(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewProject starts");

		logger.info("Method : viewProject ends");
		return daoManager.viewProject(id, org, orgDiv);
	}
	
	//viewCategory
		@GetMapping(value = "rest-viewCategoryss")
		public ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> viewCategory(@RequestParam String id, @RequestParam String org,
				@RequestParam String orgDiv) {
			logger.info("Method : viewCategory starts");

			logger.info("Method : viewCategory ends");
			return daoManager.viewCategory(id, org, orgDiv);
		}
//addSafetyIdentification
		@PostMapping(value = "rest-addSafetyIdentification")
		public ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> addSafetyIdentification(
				@RequestBody List<SafetyIdentificationRestModel> model) {
			logger.info("Method :addSafetyIdentification starts");
			logger.info("Method :addSafetyIdentification endss");
			return daoManager.addSafetyIdentification(model);
		}
		//rest-viewSafety
		@GetMapping(value = "rest-viewSafety")
		public ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> viewSafety(@RequestParam String id,@RequestParam String userId,
				@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : viewSafety starts");

			logger.info("Method : viewSafety ends");
			return daoManager.viewSafety(id, userId, org, orgDiv);
		}
		
		//rest-viewSafety
		@RequestMapping(value = "rest-deleteSafety", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> deleteSafety(@RequestParam String id,
						@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
					logger.info("Method : deleteSafety starts");

					logger.info("Method : deleteSafety ends");
					return daoManager.deleteSafety(id, userId, org, orgDiv);
				}
	

}
