package nirmalya.aatithya.restmodule.recruitment.controller;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
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
import nirmalya.aatithya.restmodule.recruitment.dao.ReviewHiringProcessDao;
import nirmalya.aatithya.restmodule.recruitment.model.ActionEmployeeDetailsModel;
import nirmalya.aatithya.restmodule.recruitment.model.ReviewHiringProcessRestModel;

@RestController
@RequestMapping("recruitment")
public class ReviewHiringProcessRestController<E> {

	Logger logger = LoggerFactory.getLogger(ReviewHiringProcessRestController.class);

	@Autowired
	ReviewHiringProcessDao hiringDao;
	
	
	/*
	 * view requisition
	 * 
	 */
	
	@GetMapping(value = "get-candidate-listing")
	public JsonResponse<Object> getCandidateListing(@RequestParam String orgName, String orgDivision,String exp) {
		logger.info("Method : getCandidateListing starts");

		logger.info("Method : getCandidateListing ends");
		return hiringDao.getCandidateListing(orgName, orgDivision,exp);
	}
	
	/*
	 * view requisition by department
	 * 
	 */
	
	@GetMapping(value = "get-candidate-listing-department")
	public JsonResponse<Object> getCandidateListingByDept(@RequestParam String orgName, String orgDivision,String exp , String userId) {
		logger.info("Method : getCandidateListingByDept starts");
		
		logger.info("Method : getCandidateListingByDept ends");
		return hiringDao.getCandidateListingByDept(orgName, orgDivision, exp, userId);
	}
	
	/*
	 * view requisition
	 * 
	 */
	
	
	@GetMapping(value = "rest-view-requisitions")
	public JsonResponse<Object> viewRequisitions(@RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : viewRequisitions starts");
		
		logger.info("Method : viewRequisitions ends" + orgDivision);
		return hiringDao.viewRequisitions(userId, orgName, orgDivision);
	}
	
	/*
	 * shortlist candidates
	 * 
	 */
	@PostMapping(value = "rest-shortlist-candidate")
	public ResponseEntity<JsonResponse<Object>> shortlistCandidate(@RequestBody ReviewHiringProcessRestModel data) {
		logger.info("Method : shortlistCandidate starts");
		
		logger.info("Method : shortlistCandidate ends" );
		return hiringDao.shortlistCandidate(data);
	}
	
	
	/*
	 * get all shortlisted candidates
	 * 
	 */
	
	@GetMapping(value = "get-all-shortlisted-candidates")
	public JsonResponse<Object> getAllShortlistedCandidates(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getAllShortlistedCandidates starts");
		
		logger.info("Method : getAllShortlistedCandidates ends" + orgDivision);
		return hiringDao.getAllShortlistedCandidates(orgName, orgDivision);
	}
	
	/* 
	 * 
	 * Function for get employee lists 
	 * 
	 */
	
	@GetMapping(value = "interviewr-listing")
	public List<ActionEmployeeDetailsModel> interviewerList(@RequestParam String org,String orgDiv) {
		logger.info("Method : interviewerList starts");

		logger.info("Method : interviewerList ends");
	return hiringDao.interviewerList(org,orgDiv);
	}
	
	/*
	 * Schedule Interview
	 * 
	 */
	@PostMapping(value = "schedule-interview")
	public ResponseEntity<JsonResponse<Object>> scheduleInterview(@RequestBody ReviewHiringProcessRestModel data) {
		logger.info("Method : scheduleInterview starts");
		
		logger.info("Method : scheduleInterview ends" );
		return hiringDao.scheduleInterview(data);
	}
	
	/* 
	 * 
	 * Function for get all scheduled interviews
	 * 
	 */
	

	@GetMapping(value = "rest-get-all-scheduled-interviews")
	public JsonResponse<Object> scheduledInterviews(@RequestParam String userId, String orgName, String orgDivision) {
		logger.info("Method : scheduledInterviews starts");

		logger.info("Method : scheduledInterviews ends");
	return hiringDao.scheduledInterviews(userId, orgName, orgDivision);
	}
	
	/*
	 * Submit Interview Feedback
	 * 
	 */
	@PostMapping(value = "rest-add-feedback")
	public ResponseEntity<JsonResponse<Object>> addFeedBack(@RequestBody ReviewHiringProcessRestModel data) {
		logger.info("Method : addFeedBack rest controller starts");
		
		logger.info("Method : addFeedBack rest controller ends" );
		return hiringDao.addFeedbackDao(data);
	}
	
	/* 
	 * 
	 * Function for get all scheduled interviews
	 * 
	 */
	

	@GetMapping(value = "rest-get-feedbacks")
	public JsonResponse<Object> getFeedbacks(@RequestParam String userId, String orgName, String orgDivision,
			String candId, String requiId,String type) {
		logger.info("Method : getFeedbacks starts");

		logger.info("Method : getFeedbacks ends");
	return hiringDao.getFeedbacks(userId, orgName, orgDivision,candId,requiId,type);
	}
	
	
	/* 
	 * 
	 * Function for get all selected candidates
	 * 
	 */
	

	@GetMapping(value = "rest-get-selected-candidates")
	public JsonResponse<Object> getSelectedCandidates(@RequestParam String userId, String orgName,
			String orgDivision,String reqId) {
		logger.info("Method : getSelectedCandidates starts");

		logger.info("Method : getSelectedCandidates ends");
	return hiringDao.getSelectedCandidates(userId, orgName, orgDivision,reqId);
	}
	
	
	/* 
	 * 
	 * Function for get all hold candidates
	 * 
	 */
	

	@GetMapping(value = "rest-get-hold-candidates")
	public JsonResponse<Object> getHoldCandidates(@RequestParam String userId, String orgName,
			String orgDivision,String reqId) {
		logger.info("Method : getHoldCandidates starts");

		logger.info("Method : getHoldCandidates ends");
	return hiringDao.getHoldCandidates(userId, orgName, orgDivision,reqId);
	}
	
	/* 
	 * 
	 * Function for get all rejected candidates
	 * 
	 */
	

	@GetMapping(value = "rest-get-rejected-candidates")
	public JsonResponse<Object> getRejectedCandidates(@RequestParam String userId, String orgName, 
			String orgDivision,String reqId) {
		logger.info("Method : getRejectedCandidates starts");

		logger.info("Method : getRejectedCandidates ends");
	return hiringDao.getRejectedCandidates(userId, orgName, orgDivision,reqId);
	}
	
	/* 
	 * 
	 * Function for get all accepted candidates
	 * 
	 */
	

	@GetMapping(value = "rest-get-accepted-candidates")
	public JsonResponse<Object> getAcceptedCandidates(@RequestParam String userId, String orgName, 
			String orgDivision,String reqId) {
		logger.info("Method : getAcceptedCandidates starts");

		logger.info("Method : getAcceptedCandidates ends");
	return hiringDao.getAcceptedCandidates(userId, orgName, orgDivision,reqId);
	}
	
	/* 
	 * 
	 * Function for get all declined candidates
	 * 
	 */
	

	@GetMapping(value = "rest-get-declined-candidates")
	public JsonResponse<Object> getDeclinedCandidates(@RequestParam String userId, String orgName, 
			String orgDivision,String reqId) {
		logger.info("Method : getDeclinedCandidates starts");

		logger.info("Method : getDeclinedCandidates ends");
	return hiringDao.getDeclinedCandidates(userId, orgName, orgDivision,reqId);
	}
	
	
	/*
	 * Select candidates
	 * 
	 */
	@PostMapping(value = "select-candidate")
	public ResponseEntity<JsonResponse<Object>> selectCandidate(@RequestBody ReviewHiringProcessRestModel data) {
		logger.info("Method : selectCandidate starts");
		
		logger.info("Method : selectCandidate ends" );
		return hiringDao.selectCandidate(data);
	}
	

	/* 
	 * 
	 * Function to change HOLD/REJECT status of candidate
	 * 
	 */
	

	@GetMapping(value = "rest-candidate-offer-acceptance")
	public JsonResponse<Object> candidateOfferAcceptance(@RequestParam String userId, String orgName, String orgDivision, String candId, String requiId, String status) {
		logger.info("Method : rejectAndHoldCandidate starts");

		logger.info("Method : rejectAndHoldCandidate ends");
	return hiringDao.candidateOfferAcceptance(userId, orgName, orgDivision, candId, requiId, status);
	}
	

	/* 
	 * 
	 * Function to change update round against requisitionId
	 * 
	 */
	

	@GetMapping(value = "rest-update-rounds")
	public JsonResponse<Object> updateRounds(@RequestParam String userId, String orgName, String orgDivision, @RequestParam String candId, String reqId,
			String status,String roundId) {
		logger.info("Method : updateRounds starts");

		logger.info("Method : updateRounds ends");
	return hiringDao.updateRounds(userId, orgName, orgDivision, candId, reqId, status,roundId);
	}
	
	
	@RequestMapping(value = "rest-get-employee-list", method = { RequestMethod.GET })
	public JsonResponse<Object> getEmployeeList(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :rest getEmployeeList start");
		logger.info("Method :rest getEmployeeList endss");
		return hiringDao.getEmployeeList(orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-save-job-rounds")
	public ResponseEntity<JsonResponse<Object>> saveJobRounds(@RequestBody String roundData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveJobRounds starts");
		logger.info("Method :saveJobRounds endss");
		return hiringDao.saveJobRounds(roundData, userId, org, orgDiv);
	}
	
	@PostMapping(value = "rest-update-job-rounds-orders")
	public ResponseEntity<JsonResponse<Object>> updateJobRoundsOrders(@RequestBody String roundData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :updateJobRoundsOrders starts");
		logger.info("Method :updateJobRoundsOrders endss");
		return hiringDao.updateJobRoundsOrders(roundData, userId, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-get-rounds-list", method = { RequestMethod.GET })
	public JsonResponse<Object> getRoundsList(@RequestParam String requisitionId,@RequestParam String candId,@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :rest getRoundsList start");
		logger.info("Method :rest getRoundsList endss");
		return hiringDao.getRoundsList(requisitionId,candId,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-delete-rounds", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteRoundDetails(@RequestParam String roundId,@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :rest deleteRoundDetails start");
		logger.info("Method :rest deleteRoundDetails endss");
		return hiringDao.deleteRoundDetails(roundId,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-get-rounds-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getRoundsDetails(@RequestParam String roundId,@RequestParam String requisitionId,@RequestParam String candidateId,@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :rest getRoundsDetails start");
		logger.info("Method :rest getRoundsDetails endss");
		return hiringDao.getRoundsDetails(roundId,requisitionId,candidateId,orgName, orgDivision);
	}
	
	@GetMapping(value = "rest-get-candidate-evaluation")
	public JsonResponse<Object> getCandidateListingForEvaluation(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method : getCandidateListingForEvaluation starts");

		logger.info("Method : getCandidateListingForEvaluation ends");
		return hiringDao.getCandidateListingForEvaluation(orgName, orgDivision,userId);
	}
	
	@GetMapping(value = "rest-save-interviewer-response")
	public JsonResponse<Object> saveInterviewersResponse(@RequestParam String userId,String type,String roundId,String reqId,String candidateId) {
		logger.info("Method : saveInterviewersResponse starts");

		logger.info("Method : saveInterviewersResponse ends");
		return hiringDao.saveInterviewersResponse(userId,type,roundId,reqId,candidateId);
	}
	
	@GetMapping(value = "rest-get-requisitions-for-candidates-selection")
	public JsonResponse<Object> getRequisitionsForCandidateSelection(@RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getRequisitionsForCandidateSelection starts");
		
		logger.info("Method : getRequisitionsForCandidateSelection ends" + orgDivision);
		return hiringDao.getRequisitionsForCandidateSelection(userId, orgName, orgDivision);
	}
	
	@GetMapping(value = "rest-get-requisitions-candidates")
	public JsonResponse<Object> getRequisitionsCandidateList(@RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String reqId) {
		logger.info("Method : getRequisitionsCandidateList starts");
		
		logger.info("Method : getRequisitionsCandidateList ends");
		return hiringDao.getRequisitionsCandidateList(userId, orgName, orgDivision,reqId);
	}
	
	@PostMapping(value = "rest-shortlist-final-candidate")
	public ResponseEntity<JsonResponse<Object>> shortlistFinalCandidate(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv,@RequestParam String reqId) {
		logger.info("Method :shortlistFinalCandidate starts");
		logger.info("Method :shortlistFinalCandidate endss");
		return hiringDao.shortlistFinalCandidate(data, userId, org, orgDiv,reqId);
	}
	
	@GetMapping(value = "rest-get-forwarded-candidates")
	public JsonResponse<Object> getForwardedCandidateList(@RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String reqId) {
		logger.info("Method : getForwardedCandidateList starts");
		
		logger.info("Method : getForwardedCandidateList ends");
		return hiringDao.getForwardedCandidateList(userId, orgName, orgDivision,reqId);
	}
	
	@PostMapping(value = "rest-shortlist-final-candidate-by-moderator")
	public ResponseEntity<JsonResponse<Object>> candidateShortlistByModerator(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :candidateShortlistByModerator starts");
		logger.info("Method :candidateShortlistByModerator endss");
		return hiringDao.candidateShortlistByModerator(data, userId, org, orgDiv);
	}
	
	@PostMapping(value = "rest-shortlist-hold-candidate")
	public ResponseEntity<JsonResponse<Object>> shortlistHoldCandidate(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :shortlistHoldCandidate starts");
		logger.info("Method :shortlistHoldCandidate endss");
		return hiringDao.shortlistHoldCandidate(data, userId, org, orgDiv);
	}
	
	@GetMapping(value = "rest-get-candidate-evaluation-by-id")
	public JsonResponse<Object> getCandidateEvaluationById(@RequestParam String orgName, String orgDivision,String userId,
			String candidateId,String requisitionId) {
		logger.info("Method : getCandidateEvaluationById starts");

		logger.info("Method : getCandidateEvaluationById ends");
		return hiringDao.getCandidateEvaluationById(orgName, orgDivision,userId,candidateId,requisitionId);
	}
	
	@GetMapping(value = "rest-release-candidate-offer")
	public JsonResponse<Object> releaseCandidateOfferLetter(@RequestParam
			String candidateId,String requisitionId,String userId) {
		logger.info("Method : releaseCandidateOfferLetter starts");

		logger.info("Method : releaseCandidateOfferLetter ends");
		return hiringDao.releaseCandidateOfferLetter(candidateId,requisitionId,userId);
	}
	
	@GetMapping(value = "rest-get-job-details-for-candidate")
	public JsonResponse<Object> getJobDetailsForCandidates(@RequestParam
			String jobId) {
		logger.info("Method : getJobDetailsForCandidates starts");

		logger.info("Method : getJobDetailsForCandidates ends");
		return hiringDao.getJobDetailsForCandidates(jobId);
	}
	
	@GetMapping(value = "rest-get-job-list-for-candidate")
	public JsonResponse<Object> getJobListsForCandidates(@RequestParam(required = false) String search,
	                                                     @RequestParam(required = false) String location) {
	    logger.info("Method : getJobListsForCandidates starts with search: " + search + ", location: " + location);
	    
	    // Decode location if not null
	    if (location != null) {
	       // location = URLDecoder.decode(location, StandardCharsets.UTF_8);
	        logger.info("Decoded location: " + location);
	    }

	    JsonResponse<Object> response = hiringDao.getJobListsForCandidates(search, location);

	    logger.info("Method : getJobListsForCandidates ends");
	    return response;
	}
	
	@PostMapping(value = "rest-save-analysis-data")
	public ResponseEntity<JsonResponse<Object>> saveAnalysisDataOfCandidate(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveAnalysisDataOfCandidate starts");
		logger.info("Method :saveAnalysisDataOfCandidate endss");
		return hiringDao.saveAnalysisDataOfCandidate(data, userId, org, orgDiv);
	}
	
	@PostMapping(value = "rest-cand-pre-inv-access")
	public ResponseEntity<JsonResponse<Object>> candidatePreInvAccess(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :candidatePreInvAccess starts");
		logger.info("Method :candidatePreInvAccess endss");
		return hiringDao.candidatePreInvAccess(data, userId, org, orgDiv);
	}
	
	@GetMapping(value = "rest-get-interviwers-dashboard-data")
	public JsonResponse<Object> getInterviewersDashboardData(@RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getInterviewersDashboardData starts");
		
		logger.info("Method : getInterviewersDashboardData ends" + orgDivision);
		return hiringDao.getInterviewersDashboardData(userId, orgName, orgDivision);
	}


}
