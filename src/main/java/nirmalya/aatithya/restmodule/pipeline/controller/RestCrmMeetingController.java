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
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmMeetingDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
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
public class RestCrmMeetingController {
	Logger logger = LoggerFactory.getLogger(RestCrmMeetingController.class);
	@Autowired
	RestCrmMeetingDao restCrmMeetingDao;

	
	/**
	 * Post Mapping to Add new addDeal
	 *
	 */
	// add

	@PostMapping(value = "/addMeeting")
	public JsonResponse<Object> addMeeting(@RequestBody RestCrmMeetingModel meeting) {
		logger.info("Method : addMeeting starts");

		logger.info("Method : addMeeting ends");
		return restCrmMeetingDao.addMeeting(meeting);
	}
	
	
	//getLeadNameList
	
/*	@RequestMapping(value = "getLeadNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadNameList() {
		
		logger.info("Method : getLeadNameList starts");
		logger.info("Method : getLeadNameList ends");
		
		return restCrmTaskDao.getLeadNameList();
	}
	*/
	
	//restViewTaskdetails
	

/*
	 * for view
	 */
	@RequestMapping(value="restViewMeetingDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> restViewMeetingDetails(@RequestParam String pageno,
			@RequestParam String userId,@RequestParam String orgName,@RequestParam String orgDivision){
		logger.info("Method: restViewMeetingDetails View Start");
		
		logger.info("Method: restViewMeetingDetails ends");
		return restCrmMeetingDao.restViewMeetingDetails(pageno,userId,orgName,orgDivision);
	}

	
	
	
	//editTaskInfo
			
	@GetMapping(value = "editMeetingInfo")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> editMeetingInfo(@RequestParam String id) {
		logger.info("Method :editMeetingInfo starts");

		logger.info("Method :editMeetingInfo ends"+id);
		return restCrmMeetingDao.editMeetingInfo(id);

	}
	
	//delete-task-Details
	
	@RequestMapping(value = "delete-meeting-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteMeetingDetails(@RequestParam String id) {
		logger.info("Method :  deleteMeetingDetails starts"+id);

		logger.info("Method :  deleteMeetingDetails ends");
		return restCrmMeetingDao.deleteMeetingDetails(id);
	}
	
	
	
}
