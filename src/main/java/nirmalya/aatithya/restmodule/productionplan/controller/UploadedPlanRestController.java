package nirmalya.aatithya.restmodule.productionplan.controller;

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
import nirmalya.aatithya.restmodule.productionplan.dao.UploadedPlanDao;
import nirmalya.aatithya.restmodule.productionplan.model.UploadedPlanRestModel;
import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "production/")
public class UploadedPlanRestController {
	Logger logger = LoggerFactory.getLogger(UploadedPlanRestController.class);

	@Autowired
	UploadedPlanDao uploadedPlanDao;
	//get Item lists
	@GetMapping(value = "get-Item-lists")
	public List<DropDownModel> getitemLists(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getitemLists starts");

		logger.info("Method : getitemLists ends");
		return uploadedPlanDao.getitemLists(org, orgDiv);
	}
	//get product lists
	@GetMapping(value = "get-Product-type")
	public List<DropDownModel> getProductType(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getProductType starts");

		logger.info("Method : getProductType ends");
		return uploadedPlanDao.getProductType(org, orgDiv);
	}
	//get week list
	@GetMapping(value = "get-week-list")
	public List<DropDownModel> getweeklist(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getweeklist starts");

		logger.info("Method : getweeklist ends");
		return uploadedPlanDao.getweeklist(org, orgDiv);
	}
	// add Plan-Details.
	@PostMapping(value = "rest-addPlan")
	public ResponseEntity<JsonResponse<List<UploadedPlanRestModel>>> addPlan(@RequestBody List<UploadedPlanRestModel> bomDetailsModel) {
		logger.info("Method : addPlan starts");
		logger.info("Method : addPlan ends");
		return uploadedPlanDao.addPlan(bomDetailsModel);
	}
//viewPlan
	@RequestMapping(value = "rest-viewPlan", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPlan(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewPlan start");

		logger.info("Method :viewPlan endss");
		return uploadedPlanDao.viewPlan(orgName, orgDivision);
	}
//editPlan
	@RequestMapping(value = "rest-editPlan", method = { RequestMethod.GET })
	public JsonResponse<Object> editPlan(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :editPlan start");

		logger.info("Method :editPlan endss");
		return uploadedPlanDao.editPlan(id,orgName, orgDivision);
	}
//deletePlan
	@GetMapping(value = "rest-deletePlan")
	public ResponseEntity<JsonResponse<Object>> deletePlan(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method : deletePlan starts");
		logger.info("Method : deletePlan ends");
		return uploadedPlanDao.deletePlan(id,orgName, orgDivision);
	}
	
	/*
	 * //Approve Plan
	 * 
	 * @GetMapping(value="approvePlan") public JsonResponse<UploadedPlanRestModel>
	 * approvePlan(@RequestParam String approveStatus, String planId,String
	 * orgName,String orgDivision){ logger.info("Method : approvePlan starts");
	 * 
	 * logger.info("Method : assignDispatchRequest ends"); return
	 * uploadedPlanDao.approvePlan(approveStatus, planId,orgName, orgDivision); }
	 */
		//Approve Plan 
	  @GetMapping(value="approvePlan")
	 	public JsonResponse<UploadedPlanRestModel> approvePlan(@RequestParam String approveStatus,
	 			String planId,String orgName,String orgDivision){
	 		logger.info("Method : approvePlan starts");
	 		
	 		logger.info("Method : assignDispatchRequest ends");
	 		return uploadedPlanDao.approvePlan(approveStatus, planId,orgName, orgDivision);
	 	}
	  //Get Boomlist
	  
	  @RequestMapping(value = "getAllBoomList", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllBoomList(@RequestParam String itemId,String orgName, String orgDivision) {
			logger.info("Method :getAllBoomList start");

			logger.info("Method :getAllBoomList endss");
			return uploadedPlanDao.getAllBoomList(itemId,orgName, orgDivision);

		}
	  //Add bom data
		@PostMapping(value = "addBomData")
		public ResponseEntity<JsonResponse<UploadedPlanRestModel>> addBomData(
				@RequestBody UploadedPlanRestModel uploadedPlanRestModel) {
			logger.info("Method :addBomData starts");
			
			logger.info("Method :addBomData endss");
			return uploadedPlanDao.addBomData(uploadedPlanRestModel);
		}
		
		//edit bom data
		
		@RequestMapping(value = "editBomData", method = { RequestMethod.GET })
		public JsonResponse<Object> editBomData(@RequestParam  String planId, String itemId, 
				String orgName, String orgDivision) {
			logger.info("Method :editBomData start");

			logger.info("Method :editBomData endss");
			return uploadedPlanDao.editBomData(planId,itemId, orgName, orgDivision);

		}
		
		
		//get Item lists api
		
		@RequestMapping(value = "get-Item-lists-api", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getitemListsApi(@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : getitemListsApi starts");
			logger.info("Method : getitemListsApi endss");
			return uploadedPlanDao.getitemListsApi(org, orgDiv);
		}

}
