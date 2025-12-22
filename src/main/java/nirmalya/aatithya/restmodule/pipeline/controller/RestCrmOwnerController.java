package nirmalya.aatithya.restmodule.pipeline.controller;

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
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmLeadsDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmOwnerDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmOwnerModel;

@RestController
@RequestMapping(value = "pipeline")
public class RestCrmOwnerController {

	
	Logger logger = LoggerFactory.getLogger(RestCrmOwnerController.class);
	@Autowired
	RestCrmOwnerDao restCrmLeadsDao;
	
	/*
	 * for All  Add leadDetails
	 */
	@RequestMapping(value="rest-add-owner-details" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddOwnerDetails(@RequestBody RestCrmOwnerModel assignSkill) 
	{
		logger.info("Method : restAddOwnerDetails starts");
		
		logger.info("Method : restAddOwnerDetails ends");
		
		return restCrmLeadsDao.restAddOwnerDetails(assignSkill);
	}
	
	/*
	 * for view
	 */
	@RequestMapping(value="rest-view-owner-details" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmOwnerModel>>> viewCrmOwnerDetails(){
		logger.info("Method: viewCrmOwnerDetails View Start");
		
		logger.info("Method: viewCrmOwnerDetails ends");
		return restCrmLeadsDao.viewCrmOwnerDetails();
	}
	
	
	///edit
			@GetMapping(value = "edit-rest-OwnerInfo")
			public ResponseEntity<JsonResponse<List<RestCrmOwnerModel>>> editOwnerInfo(@RequestParam String id) {
				logger.info("Method :editOwnerInfo starts");

				logger.info("Method :editOwnerInfo ends"+id);
				return restCrmLeadsDao.editOwnerInfo(id);

			}
			
			
			/*
			 * PostMapping for delete ItemRequisition
			 */
			@PostMapping(value = "rest-delete-OwnerInfo")
			public ResponseEntity<JsonResponse<Object>> restDeleteOwnerInfo(
					@RequestBody RestCrmOwnerModel scheduleModel) {
				logger.info("Method : restDeleteOwnerInfo starts");
				logger.info("Method : restDeleteOwnerInfo ends");
				return restCrmLeadsDao.restDeleteOwnerInfo(scheduleModel);
			}
}
