package nirmalya.aatithya.restmodule.projects.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.ProjectEstimationDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectProdDetailsRestModel;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStackholderRentOSModel;

	
	@RestController
	@RequestMapping(value = "projects")
	
	public class ProjectEstimationRestController {
	
		Logger logger = LoggerFactory.getLogger(ProjectEstimationRestController.class);
	
		@Autowired
		ProjectEstimationDao estimationDao;
		
		
		/* rest-get-all-category-by-typeId */
//		@RequestMapping(value = "rest-get-all-category-by-typeId", method = { RequestMethod.GET })
//		public JsonResponse<Object> viewAllProjectByTypeId(@RequestParam String orgName, @RequestParam String orgDivision,
//				@RequestParam String id) {
//			logger.info("Method :viewAllProjectByTypeId start");
//			logger.info("Method :viewAllProjectByTypeId endss");
//			return estimationDao.viewAllProjectByTypeId(orgName, orgDivision, id);
//		}
		/*rest-save-all-categories*/
		@PostMapping(value = "rest-save-all-categories")
		public ResponseEntity<JsonResponse<Object>> saveAllCategories(@RequestBody String dataToSend,
				@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :saveAllCategories starts");
			logger.info("Method :saveAllCategories endss");
			return estimationDao.saveAllCategories(dataToSend, userId, org, orgDiv);
		}
		
		@RequestMapping(value = "rest-view-sku", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<ProjectProdDetailsRestModel>>> viewSku() {
			logger.info("Method : viewSku starts");

			logger.info("Method : viewSku ends");
			return estimationDao.viewSku();
		}
		
		/* rest-get-all-category-details-by-typeId */
		@RequestMapping(value = "rest-get-all-category-details-by-typeId", method = { RequestMethod.GET })
		public JsonResponse<Object> viewAllProjectDetailsByTypeId(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String id,@RequestParam String type) {
			logger.info("Method :viewAllProjectDetailsByTypeId start");
			logger.info("Method :viewAllProjectDetailsByTypeId endss");
			return estimationDao.viewAllProjectDetailsByTypeId(orgName, orgDivision, id,type);
		}
		/* rest-save-all-estimation */
		@PostMapping(value = "rest-save-all-estimation")
		public ResponseEntity<JsonResponse<Object>> saveAllEstimation(@RequestBody String dataToSend,
				@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :saveAllEstimation starts");
			logger.info("Method :saveAllEstimation endss");
			return estimationDao.saveAllEstimation(dataToSend, userId, org, orgDiv);
		}

}
