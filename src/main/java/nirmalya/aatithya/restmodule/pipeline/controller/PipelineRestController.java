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
import nirmalya.aatithya.restmodule.pipeline.dao.PipelineDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineLogModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineSmsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestStagesDetailModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class PipelineRestController {
	Logger logger = LoggerFactory.getLogger(PipelineRestController.class);
	@Autowired
	PipelineDao pipelineDao;

	/**
	 * returns customer for drop down model
	 *
	 */
	@RequestMapping(value = "/getCustomer", method = { RequestMethod.GET })
	public List<DropDownModel> getCustomer() {
		logger.info("Method : getCustomer starts");

		logger.info("Method : getCustomer end");
		return pipelineDao.getCustomer();
	}

	/**
	 * returns lost reason for drop down model
	 *
	 */
	@RequestMapping(value = "/getLostReasonList", method = { RequestMethod.GET })
	public List<DropDownModel> getLostReasonList() {
		logger.info("Method : getLostReasonList starts");

		logger.info("Method : getLostReasonList end");
		return pipelineDao.getLostReasonList();
	}

	/**
	 * returns salesperson for drop down model
	 *
	 */
	@RequestMapping(value = "/getSalesPerson", method = { RequestMethod.GET })
	public List<DropDownModel> getSalesPerson() {
		logger.info("Method : getCrmSalesPerson starts");

		logger.info("Method : getCrmSalesPerson end");
		return pipelineDao.getSalesPerson();
	}

	/**
	 * returns taglist for drop down model
	 *
	 */
	@RequestMapping(value = "/getTagList", method = { RequestMethod.GET })
	public List<DropDownModel> getTagList() {
		logger.info("Method : getTagList starts");

		logger.info("Method : getTagList end");
		return pipelineDao.getTagList();
	}

	/**
	 * returns sales team for drop down model
	 *
	 */
	@RequestMapping(value = "/getSalesTeam", method = { RequestMethod.GET })
	public List<DropDownModel> getSalesTeam() {
		logger.info("Method : getSalesTeam starts");

		logger.info("Method : getSalesTeam end");
		return pipelineDao.getSalesTeam();
	}

	/**
	 * returns tags for drop down model
	 *
	 */
	@RequestMapping(value = "/getTags", method = { RequestMethod.GET })
	public List<DropDownModel> getTags() {
		logger.info("Method : getTags starts");

		logger.info("Method : getTags end");
		return pipelineDao.getTags();
	}

	/**
	 * returns company for drop down model
	 *
	 */
	@RequestMapping(value = "/getCompanyList", method = { RequestMethod.GET })
	public List<DropDownModel> getCompanyList() {
		logger.info("Method : getCompanyList starts");

		logger.info("Method : getCompanyList end");
		return pipelineDao.getCompanyList();
	}

	/**
	 * returns states for drop down model
	 *
	 */
	@RequestMapping(value = "/getStatesList", method = { RequestMethod.GET })
	public List<DropDownModel> getStatesList() {
		logger.info("Method : getStatesList starts");

		logger.info("Method : getStatesList end");
		return pipelineDao.getStatesList();
	}

	/**
	 * returns Country for drop down model
	 *
	 */
	@RequestMapping(value = "/getCountryList", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");

		logger.info("Method : getCountryList end");
		return pipelineDao.getCountryList();
	}

	/**
	 * returns Country for drop down model
	 *
	 */
	@RequestMapping(value = "/getTittleList", method = { RequestMethod.GET })
	public List<DropDownModel> getTittleList() {
		logger.info("Method : getTittleList starts");

		logger.info("Method : getTittleList end");
		return pipelineDao.getTittleList();
	}

	/**
	 * returns campaign for drop down model
	 *
	 */
	@RequestMapping(value = "/getCampaignList", method = { RequestMethod.GET })
	public List<DropDownModel> getCampaignList() {
		logger.info("Method : getCampaignList starts");

		logger.info("Method : getCampaignList end");
		return pipelineDao.getCampaignList();
	}

	/**
	 * returns medium for drop down model
	 *
	 */
	@RequestMapping(value = "/getMediumList", method = { RequestMethod.GET })
	public List<DropDownModel> getMediumList() {
		logger.info("Method : getMediumList starts");

		logger.info("Method : getMediumList end");
		return pipelineDao.getMediumList();
	}

	/**
	 * returns medium for drop down model
	 *
	 */
	@RequestMapping(value = "/getSourceList", method = { RequestMethod.GET })
	public List<DropDownModel> getSourceList() {
		logger.info("Method : getSourceList starts");

		logger.info("Method : getSourceList end");
		return pipelineDao.getSourceList();
	}

	/**
	 * returns language for drop down model
	 *
	 */
	@RequestMapping(value = "/getLanguageList", method = { RequestMethod.GET })
	public List<DropDownModel> getLanguageList() {
		logger.info("Method : getLanguageList starts");

		logger.info("Method : getLanguageList end");
		return pipelineDao.getLanguageList();
	}

	/**
	 * returns stages for drop down model
	 *
	 */
	@RequestMapping(value = "/getStageList", method = { RequestMethod.GET })
	public List<DropDownModel> getStageList(@RequestParam String id) {
		logger.info("Method : getStageList starts");

		logger.info("Method : getStageList end");
		return pipelineDao.getStageList(id);
	}

	/**
	 * returns dates for drop down model
	 *
	 */
	@RequestMapping(value = "/getDateList", method = { RequestMethod.GET })
	public List<DropDownModel> getDateList(@RequestParam String id) {
		logger.info("Method : getDateList starts");

		logger.info("Method : getDateList end");
		return pipelineDao.getDateList(id);
	}

	/**
	 * returns activity type for drop down model
	 *
	 */
	@RequestMapping(value = "/getActivityTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getActivityTypeList() {
		logger.info("Method : getActivityTypeList starts");

		logger.info("Method : getActivityTypeList end");
		return pipelineDao.getActivityTypeList();
	}

	/**
	 * returns assignTo for drop down model
	 *
	 */
	@RequestMapping(value = "/getAssignTo", method = { RequestMethod.GET })
	public List<DropDownModel> getAssignTo() {
		logger.info("Method : getAssignTo starts");

		logger.info("Method : getAssignTo end");
		return pipelineDao.getAssignTo();
	}

	/**
	 * returns meeting reminder for drop down model
	 *
	 */
	@RequestMapping(value = "/getMeetingReminderList", method = { RequestMethod.GET })
	public List<DropDownModel> getMeetingReminderList() {
		logger.info("Method : getMeetingReminderList starts");

		logger.info("Method : getMeetingReminderList end");
		return pipelineDao.getMeetingReminderList();
	}

	/**
	 * returns meeting repetation unit for drop down model
	 *
	 */
	@RequestMapping(value = "/getMeetingRepetationUnitList", method = { RequestMethod.GET })
	public List<DropDownModel> getMeetingRepetationUnitList() {
		logger.info("Method : getMeetingRepetationUnitList starts");

		logger.info("Method : getMeetingRepetationUnitList end");
		return pipelineDao.getMeetingRepetationUnitList();
	}

	/**
	 * returns repetation untill for drop down model
	 *
	 */
	@RequestMapping(value = "/getMeetingRepetationUntilList", method = { RequestMethod.GET })
	public List<DropDownModel> getMeetingRepetationUntilList() {
		logger.info("Method : getMeetingRepetationUntilList starts");

		logger.info("Method : getMeetingRepetationUntilList end");
		return pipelineDao.getMeetingRepetationUntilList();
	}

	/**
	 * returns privacy for drop down model
	 *
	 */
	@RequestMapping(value = "/getStatusList", method = { RequestMethod.GET })
	public List<DropDownModel> getStatusList() {
		logger.info("Method : getStatusList starts");

		logger.info("Method : getStatusList end");
		return pipelineDao.getStatusList();
	}

	/**
	 * returns privacy for drop down model
	 *
	 */
	@RequestMapping(value = "/getPrivacyList", method = { RequestMethod.GET })
	public List<DropDownModel> getPrivacyList() {
		logger.info("Method : getPrivacyList starts");

		logger.info("Method : getPrivacyList end");
		return pipelineDao.getPrivacyList();
	}

	/**
	 * returns privacy for drop down model
	 *
	 */
	@RequestMapping(value = "/getShowAsTimeList", method = { RequestMethod.GET })
	public List<DropDownModel> getShowAsTimeList() {
		logger.info("Method : getShowAsTimeList starts");

		logger.info("Method : getShowAsTimeList end");
		return pipelineDao.getShowAsTimeList();
	}

	/**
	 * Post Mapping to Add new pipeline
	 *
	 */
	// add

	@PostMapping(value = "/addPipeline")
	public JsonResponse<Object> addEmployee(@RequestBody RestPipelineModel pipeline) {
		logger.info("Method : addempdetails starts");

		logger.info("Method : addempdetails ends");
		return pipelineDao.addPipeline(pipeline);
	}

	/**
	 * return for dropdown of auto fill of customer name
	 */
	@RequestMapping(value = "/getContactNameAutoComplete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPipelineModel>>> getContactNameAutoComplete(@RequestParam String id) {
		logger.info("Method : getContactNameAutoComplete starts");

		logger.info("Method : getContactNameAutoComplete ends");
		return pipelineDao.getContactNameAutoComplete(id);
	}

	/**
	 * returns all pipeline
	 *
	 */
	/*
	 * @RequestMapping(value = "getAllPipeLine", method = { RequestMethod.POST })
	 * public JsonResponse<List<RestPipelineModel>> viewAllPipelineDao() {
	 * logger.info("Method : getAllCrmPipeLine starts");
	 * logger.info("Method : getAllCrmPipeLine end"); return
	 * pipelineDao.viewAllPipelineDao(); }
	 */
	/*
	 * View pipeline Details
	 *
	 */

	@GetMapping(value = "getAllPipeLine")
	public JsonResponse<List<RestPipelineModel>> viewAllPipelineDao() {
		logger.info("Method : viewTicketAgentDtls starts");

		logger.info("Method : viewTicketAgentDtls ends");

		return pipelineDao.viewAllPipelineDao();
	}

	/**
	 * returns edit crm pipeline
	 *
	 */
	@RequestMapping(value = "/editPipeline", method = { RequestMethod.GET })
	public JsonResponse<RestPipelineModel> editPipeline(@RequestParam String id) {
		logger.info("Method : editpipeline starts");

		logger.info("Method :editpipeline ends");
		return pipelineDao.editPipeline(id);
	}

	// delete

	@GetMapping(value = "/deletePipeline")
	public JsonResponse<RestPipelineModel> deleteAssetCode(@RequestParam String id) {
		logger.info("Method : deleteAssetCode starts");
		logger.info(id + "HelloJonty");

		logger.info("Method : deleteAssetCode ends");
		return pipelineDao.deletePipeline(id);
	}

	/**
	 * returns edit crm stages
	 *
	 */
	@RequestMapping(value = "/getCrmStagesById", method = { RequestMethod.GET })
	public List<RestStagesDetailModel> getCrmStagesById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getCrmStagesById starts");
		logger.info("Method : getCrmStagesById end");
		return pipelineDao.getStagesById(id, action);
	}

	/**
	 * returns edit crm stages
	 *
	 */
	@RequestMapping(value = "/getPlannedActivityList", method = { RequestMethod.GET })
	public List<RestPipelineActivityModel> getPlannedActivityList(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getCrmPlannedActivityList starts");
		logger.info("Method : getCrmPlannedActivityList end");
		return pipelineDao.getPlannedActivityList(id, action);
	}

	/**
	 * returns view crm meeting lists
	 *
	 */
	/*
	 * @RequestMapping(value = "/getMeetingDetailsById", method = {
	 * RequestMethod.GET }) public List<RestPipelineMeetingModel>
	 * getMeetingDetailsById(@RequestParam String id,
	 * 
	 * @RequestParam("Action") String action) {
	 * logger.info("Method : getCrmMeetingDetailsById starts");
	 * logger.info("Method : getCrmMeetingDetailsById end"); return
	 * pipelineDao.getMeetingDetailsById(id, action); }
	 */
	/**
	 * add stages
	 *
	 */
	@RequestMapping(value = "/rest-addStages", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> addStages(@RequestParam String id, @RequestParam String stage,
			@RequestParam String previousStage, @RequestParam String createdBy) {
		logger.info("Method : addStages starts");

		logger.info("Method : addStages ends");
		return pipelineDao.addStagesDao(id, stage, previousStage, createdBy);
	}

	/**
	 * add lost reason
	 *
	 */
	@RequestMapping(value = "addLostReason", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> addLostReason(@RequestParam String id, @RequestParam String lostReason
			,@RequestParam String createdBy) {
	
		logger.info("Method : addLostReason starts");

		logger.info("Method : addLostReason ends");
		return pipelineDao.addLostReason(id,lostReason,createdBy);//lostReason,
	}
//meeting
	
	

	
	// add

		@PostMapping(value = "scheduleMeeting")
		public JsonResponse<Object> scheduleMeeting(@RequestBody RestPipelineModel pipeline) {
			logger.info("Method : schedule meeting rest starts");

			logger.info("Method : schedule meeting rest ends");
			return pipelineDao.scheduleMeeting(pipeline);
		}
	
	/*
	 * for Add activity type
	 */
	@RequestMapping(value = "addpipelineActivityType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addpipelineActivityType(
			@RequestBody List<RestPipelineActivityModel> pipelineActivityTypeModel) {
		logger.info("Method in rest: addpipelineActivityType starts");

		logger.info("Method in rest: addpipelineActivityType ends");
		return pipelineDao.addpipelineActivityType(pipelineActivityTypeModel);
	}

	/*
	 * for Add pipeline messages
	 */
	@RequestMapping(value = "addPipelineMessage", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCrmPipelineMessage(
			@RequestBody List<RestPipelineSmsModel> pipelineSmsModel) {
		logger.info("Method in rest: addCrmPipelineMessage starts");

		logger.info("Method in rest: addCrmPipelineMessage ends");
		return pipelineDao.addPipelineMessage(pipelineSmsModel);
	}

	/*
	 * for Add pipeline log
	 */
	@RequestMapping(value = "addCrmPipelineLog", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCrmPipelineLog(
			@RequestBody List<RestPipelineLogModel> pipelineLogModel) {
		logger.info("Method in rest: addCrmPipelineLog starts");

		logger.info("Method in rest: addCrmPipelineLog ends");
		return pipelineDao.addCrmPipelineLog(pipelineLogModel);
	}

	/*
	 * for Add pipeline meeting schedule
	 */
	/*
	 * @RequestMapping(value = "", method = { RequestMethod.POST }) public
	 * ResponseEntity<JsonResponse<Object>> addCrmPipelineMeetingSchedule(
	 * 
	 * @RequestBody List<RestPipelineMeetingModel> crmPipelineMeetingModel) {
	 * logger.info("Method in rest: addCrmPipelineMeetingSchedule starts");
	 * 
	 * logger.info("Method in rest: addCrmPipelineMeetingSchedule ends"); return
	 * pipelineDao.addCrmPipelineMeetingSchedule(crmPipelineMeetingModel); }
	 */

	/**
	 * returns delete crm meeting schedule
	 *
	 */
	@RequestMapping(value = "/deleteCrmPipelineMeetingById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCrmPipelineMeetingById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteCrmPipelineMeetingById starts");
		logger.info("Method : deleteCrmPipelineMeetingById end");
		return pipelineDao.deletePipelineMeetingById(id, createdBy);
	}

	/**
	 * returns edit meeting schedule
	 */
	/*
	 * @RequestMapping(value = "/getEditMeetingScheduleById", method = {
	 * RequestMethod.GET }) public
	 * ResponseEntity<JsonResponse<RestPipelineMeetingModel>>
	 * getEditMeetingScheduleById(@RequestParam String id) {
	 * logger.info("Method : getEditMeetingScheduleById starts");
	 * 
	 * logger.info("Method : getEditMeetingScheduleById ends"); return
	 * pipelineDao.getEditMeetingScheduleById(id); }
	 */
	/**
	 * returns delete crm meeting schedule
	 *
	 */
	@RequestMapping(value = "/changeMarkDoneStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeMarkDoneStatus(@RequestParam String id) {
		logger.info("Method : changeMarkDoneStatus starts");
		logger.info("Method : changeMarkDoneStatus end");
		return pipelineDao.changeMarkDoneStatus(id);
	}

	/**
	 * returns edit activity type schedule
	 */
	@RequestMapping(value = "/getEditActivityTypeSchedule", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestPipelineActivityModel>> getEditActivityTypeSchedule(
			@RequestParam String id) {
		logger.info("Method : getEditActivityTypeSchedule starts");

		logger.info("Method : getEditActivityTypeSchedule ends");
		return pipelineDao.getEditActivityTypeSchedule(id);
	}

	/**
	 * returns delete crm activity type schedule
	 *
	 */
	@RequestMapping(value = "/deleteActivityTypeDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteActivityTypeDetails(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteActivityTypeDetails starts");
		logger.info("Method : deleteActivityTypeDetails end");
		return pipelineDao.deleteActivityTypeDetails(id, createdBy);
	}
	//Activity Log Pipeline
	@GetMapping(value = "get-activity-log-pipeline")
	public List<ActivitylogModel> getActivityLog(@RequestParam String id) {
		logger.info("Method : getActivityLog starts");
		logger.info("Method : getActivityLog endss");
		return pipelineDao.getActivityLogPipeline(id);
	}

}
