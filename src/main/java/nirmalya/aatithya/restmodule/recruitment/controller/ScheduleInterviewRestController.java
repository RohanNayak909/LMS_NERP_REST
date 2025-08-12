package nirmalya.aatithya.restmodule.recruitment.controller;

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
import nirmalya.aatithya.restmodule.recruitment.dao.HireActionDao;
import nirmalya.aatithya.restmodule.recruitment.dao.ScheduleInterviewDao;
import nirmalya.aatithya.restmodule.recruitment.model.ActionEmployeeDetailsModel;
import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateAddressModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateDetailsModel;
import nirmalya.aatithya.restmodule.recruitment.model.HireActionModel;

@RestController
@RequestMapping("recruitment/")
public class ScheduleInterviewRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleInterviewRestController.class);

	@Autowired
	ScheduleInterviewDao scheduleInterviewDao;

	
	/* Function for get Schedule Details */
	@GetMapping(value = "getScheduleInterview")
	public ResponseEntity<JsonResponse<List<HireActionModel>>> getScheduleInterview(@RequestParam String orgName, String orgDivision , String userId) {
		logger.info("Method : getScheduleInterview starts");

		logger.info("Method : getScheduleInterview ends");
	return scheduleInterviewDao.getScheduleInterview(orgName,orgDivision,userId);
	}
	//
	@GetMapping(value = "getFeedbackList")
	public JsonResponse<List<HireActionModel>> getFeedbackList(@RequestParam String id,@RequestParam String userId,@RequestParam String candId) {
		logger.info("Method : getFeedbackList starts");

		logger.info("Method : getFeedbackList ends");
	return scheduleInterviewDao.getFeedbackList(id,userId,candId);
	}
//
	@GetMapping(value = "rest-editScheduleFeedbackDetails")
	public JsonResponse<List<HireActionModel>> editScheduleFeedbackDetails(@RequestParam String feedId, @RequestParam String candId,@RequestParam String userId) {
		logger.info("Method : editScheduleFeedbackDetails starts");

		logger.info("Method : editScheduleFeedbackDetails endss");
	return scheduleInterviewDao.editScheduleFeedbackDetails(feedId, candId,userId);
	}
//

	@GetMapping(value="submitFeedbackApply")
	public JsonResponse<AddRecruitentModel> submitFeedbackApply(@RequestParam String submitId){
		logger.info("Method : submitFeedbackApply starts");
		
		logger.info("Method : submitFeedbackApply ends");
		return scheduleInterviewDao.submitFeedbackApply(submitId);
	}
	
	

	@GetMapping(value="rest-interview-candidate-details")
	public JsonResponse<Object> getCandidateDetails(@RequestParam String userId, String orgName, String orgDivision, String candidateId, String requisitionId){
		logger.info("Method : getCandidateDetails starts");
		
		logger.info("Method : getCandidateDetails ends");
		return scheduleInterviewDao.getCandidateDetails(userId,orgName,orgDivision ,candidateId, requisitionId);
	}
}
