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
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
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
public class RestCrmCampaignController {
	Logger logger = LoggerFactory.getLogger(RestCrmCampaignController.class);
	@Autowired
	RestCrmCampaignDao restCrmCampaignDao;

	
	/**
	 * Post Mapping to Add new addDeal  
	 * @author Pankaj 
	 */
	// add

	@PostMapping(value = "/addCampaign")
	public JsonResponse<Object> addCampaign(@RequestBody RestCrmCampaignModel call) {
		logger.info("Method : addCampaign starts");

		logger.info("Method : addCampaign ends");
		return restCrmCampaignDao.addCampaign(call);
	}
	
	
	//editCampaignsInfo
			
	@GetMapping(value = "editCampaignsInfo")
	public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> editCampaignsInfo(@RequestParam String id) {
		logger.info("Method :editCampaignsInfo starts");

		logger.info("Method :editCampaignsInfo ends"+id);
		return restCrmCampaignDao.editCampaignsInfo(id);

	}
	
	//delete-task-Details
	
	@RequestMapping(value = "delete-campaign-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCampaignDetails(@RequestParam String id) {
		logger.info("Method :  deleteCampaignDetails starts"+id);

		logger.info("Method :  deleteCampaignDetails ends");
		return restCrmCampaignDao.deleteCampaignDetails(id);
	}
	

	/*
	 * for view
	 */
	@RequestMapping(value="restViewCampaignDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> restViewCampaignDetails(@RequestParam String pageno,
			@RequestParam String userId,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method: restViewCampaignDetails View Start");
		
		logger.info("Method: restViewCampaignDetails ends");
		return restCrmCampaignDao.restViewCampaignDetails(pageno,userId,orgName,orgDivision);
	}
	
	

}
