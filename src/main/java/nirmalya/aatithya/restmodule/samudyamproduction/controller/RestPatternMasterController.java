package nirmalya.aatithya.restmodule.samudyamproduction.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.samudyamproduction.dao.RestPatternMasterDao;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestPatternMasterModel;
@RestController
@RequestMapping("production/")
public class RestPatternMasterController {
	Logger logger = LoggerFactory.getLogger(RestPatternMasterController.class);
	@Autowired
	RestPatternMasterDao restPatternMasterDao;
	
	//addPatternDetails
	@PostMapping(value = "rest-addPatternDetails")
	public ResponseEntity<JsonResponse<List<RestPatternMasterModel>>> addPatternDetails(
			@RequestBody RestPatternMasterModel patternModel) {
		logger.info("Method : addPatternDetails starts");
		logger.info("Method : addPatternDetails ends");
		return restPatternMasterDao.addPatternDetails(patternModel);
	}
	//view-pattern-details	
		@RequestMapping(value = "view-pattern-details", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestPatternMasterModel>>> viewPatternDetails(@RequestParam String org,String orgDiv) {
			logger.info("Method : viewPatternDetails starts");

			logger.info("Method : viewPatternDetails ends");
			return restPatternMasterDao.viewPatternDetails(org,orgDiv);
		}
	//view-pattern-details
		@GetMapping(value = "edit-pattern-details")
		public JsonResponse<RestPatternMasterModel> editPatternDetails(@RequestParam String id,String org,String orgDiv) {
			logger.info("Method : editPatternDetails starts");

			logger.info("Method : editPatternDetails ends");
			return restPatternMasterDao.editPatternDetails(id,org,orgDiv);
		}
		//delete-pattern-details
		@GetMapping(value = "delete-pattern-details")
		public JsonResponse<Object> deletePatternDetails(@RequestParam String patid, String org,String orgDiv) {
			logger.info("Method : deletePatternDetails starts");

			logger.info("Method : deletePatternDetails ends");
			return restPatternMasterDao.deletePatternDetails(patid,org,orgDiv);
		}
		//approve-pattern-details
		@GetMapping(value = "approve-pattern-details")
		public JsonResponse<Object> approvePatternDetails(@RequestParam String patid, String org,String orgDiv,String userId) {
			logger.info("Method : approvePatternDetails starts");
			
			logger.info("Method : approvePatternDetails ends");
			return restPatternMasterDao.approvePatternDetails(patid,org,orgDiv,userId);
		}
}
