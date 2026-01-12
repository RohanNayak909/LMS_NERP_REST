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


import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmContactDao;
import nirmalya.aatithya.restmodule.pipeline.dao.PipelineDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCallDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCampaignDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmVendorDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineLogModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineSmsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestStagesDetailModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmVendorController {
	Logger logger = LoggerFactory.getLogger(RestCrmVendorController.class);
	@Autowired
	RestCrmVendorDao restCrmVendorDao;

	
	//addVendorCRM
	/*
	 * for All  Add vendor
	 */
	@RequestMapping(value="addVendorCRM" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addVendorCRM(@RequestBody RestCrmVendorModel assignSkill) 
	{
		logger.info("Method : addVendorCRM starts");
		
		logger.info("Method : addVendorCRM ends");
		
		return restCrmVendorDao.addVendorCRM(assignSkill);
	}
	
	//restViewVendorDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewVendorDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmVendorModel>>> restViewVendorDetails(){
		logger.info("Method: restViewVendorDetails View Start");
		
		logger.info("Method: restViewVendorDetails ends");
		return restCrmVendorDao.restViewVendorDetails();
	}
	
	
	//editVendorInfo

	
	@GetMapping(value = "editVendorInfo")
	public ResponseEntity<JsonResponse<List<RestCrmVendorModel>>> editVendorInfo(@RequestParam String id) {
		logger.info("Method :editVendorInfo starts");

		logger.info("Method :editVendorInfo ends"+id);
		return restCrmVendorDao.editVendorInfo(id);

	}
	
	
	//delete-vendor-Details
	
	@RequestMapping(value = "delete-vendor-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVendorDetails(@RequestParam String id) {
		logger.info("Method :  deleteVendorDetails starts"+id);

		logger.info("Method :  deleteVendorDetails ends");
		return restCrmVendorDao.deleteVendorDetails(id);
	}
	
	
	//getVendorNameAutoSearch
	@GetMapping(value = "getVendorNameAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorNameAutoSearch(
			@RequestParam String id) {
		logger.info("Method : getVendorNameAutoSearch starts");

		logger.info("Method :getVendorNameAutoSearch endss");
		return restCrmVendorDao.getVendorNameAutoSearch(id);
	}
}
