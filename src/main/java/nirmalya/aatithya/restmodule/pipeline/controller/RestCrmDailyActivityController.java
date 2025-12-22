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
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDailyWorkDao;
import nirmalya.aatithya.restmodule.pipeline.dao.PipelineDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCallDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCampaignDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmDailyWorkModel;
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
public class RestCrmDailyActivityController {
	Logger logger = LoggerFactory.getLogger(RestCrmDailyActivityController.class);
	@Autowired
	RestCrmDailyWorkDao restCrmDailyWorkDao;

	
	/**
	 * Post Mapping to Add new addDeal
	 *
	 */
	// add

	@PostMapping(value = "/addDailyWork")
	public JsonResponse<Object> addDailyWork(@RequestBody RestCrmDailyWorkModel restCrmDailyWorkModel) {
		logger.info("Method : addDailyWork starts");

		logger.info("Method : addDailyWork ends");
		return restCrmDailyWorkDao.addDailyWork(restCrmDailyWorkModel);
	}
	
	
	//getLeadNameList
	
	/*@RequestMapping(value = "getLeadNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadNameList() {
		
		logger.info("Method : getLeadNameList starts");
		logger.info("Method : getLeadNameList ends");
		
		return restCrmTaskDao.getLeadNameList();
	}*/
	
	//editCampaignsInfo
			
	@GetMapping(value = "editDailyWork")
	public ResponseEntity<JsonResponse<List<RestCrmDailyWorkModel>>> editDailyWork(@RequestParam String id) {
		logger.info("Method :editDailyWork starts");

		logger.info("Method :editDailyWork ends"+id);
		return restCrmDailyWorkDao.editDailyWork(id);

	}
	
	//deleteCrmDailyWork
	
	@RequestMapping(value = "deleteCrmDailyWork", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCrmDailyWork(@RequestParam String id) {
		logger.info("Method :  deleteCrmDailyWork starts"+id);

		logger.info("Method :  deleteCrmDailyWork ends");
		return restCrmDailyWorkDao.deleteCrmDailyWork(id);
	}
	
	
	
	

	/*
	 * for view
	 */
	@RequestMapping(value="restviewCrmDailyAjax" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmDailyWorkModel>>> restviewCrmDailyAjax(){
		logger.info("Method: restviewCrmDailyAjax View Start");
		
		logger.info("Method: restviewCrmDailyAjax ends");
		return restCrmDailyWorkDao.restviewCrmDailyAjax();
	}

}
