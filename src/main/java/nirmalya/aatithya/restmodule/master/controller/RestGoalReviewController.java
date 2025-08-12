package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestGoalReviewDao;
import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;
import nirmalya.aatithya.restmodule.master.model.RestGoalReviewModel;
import nirmalya.aatithya.restmodule.master.model.RestSelfAppraisalModel;



@RestController
@RequestMapping(value = { "master" })
public class RestGoalReviewController {
	Logger logger = LoggerFactory.getLogger(RestHrMasterController.class);

	@Autowired
	RestGoalReviewDao restGoalReviewDao;
	/*
	 * for employee list
	 */
	
	@RequestMapping(value = "getempList", method = { RequestMethod.GET })
	public List<DropDownModel> getempLists(String id) {
		logger.info("Method : getempLists starts");

		logger.info("Method : getempLists ends");
		return restGoalReviewDao.getempLists(id);
	}
	/*
	 * view goal review employee list
	 */
	@RequestMapping(value = "view-emp-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewEmployeeList(String userId) {
		logger.info("Method : viewEmployeeList starts");

		logger.info("Method : viewEmployeeList ends");
		return restGoalReviewDao.viewEmployeeListDao(userId);
	}
	/*
	 * view goal review employeeband
	 */
	@RequestMapping(value = "view-empband", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewEmployeeBandList(String id) {
		logger.info("Method : viewEmployeeBandList starts");

		logger.info("Method : viewEmployeeBandList ends");
		return restGoalReviewDao.viewEmployeeBandListDao(id);
	}
	/*
	 * view goal review goal list
	 */
	@RequestMapping(value = "view-goal-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewGoalList(String id) {
		logger.info("Method : viewGoalList starts");

		logger.info("Method : viewGoalList ends");
		return restGoalReviewDao.viewGoalListDao(id);
	}
	@PostMapping(value = "save-goal-review")
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> savegoalReview(@RequestBody RestGoalReviewModel review) {
		logger.info("Method : saveGoalReview starts");
		logger.info("Method : saveGoalReview ends");
		return restGoalReviewDao.saveGoalReviewDao(review);
	}
	/*
	 * view goal review goal list
	 */
	@RequestMapping(value = "view-review-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewReviewList(String id) {
		logger.info("Method : viewReviewList starts");

		logger.info("Method : viewReviewList ends");
		return restGoalReviewDao.viewReviewListDao(id);
	}
	//delete review details
	
		@GetMapping(value="delete-review")
		public JsonResponse<RestGoalReviewModel> deleteReview(@RequestParam String id){
			logger.info("Method : deleteReview starts");
			
			logger.info("Method : deleteReview ends");
			return restGoalReviewDao.deleteReview(id);
		}
		/*
		 * Add Meeting details
		 */
		
		@PostMapping(value = "rest-save-meetingdetails")
		public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> saveMeetingDetailsRest(
				@RequestBody List<RestGoalReviewModel> goalReviewModel) {
			logger.info("Method : addMeetingDetailsRest starts");
			logger.info("Method : addMeetingDetailsRest ends");
			return restGoalReviewDao.saveMeetingDetailsDao(goalReviewModel);
		}
		/*
		 * view goal review employee list
		 */
		@RequestMapping(value = "view-meeting-list", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewMeetingDetails() {
			logger.info("Method : viewMeetingDetails starts");

			logger.info("Method : viewMeetingDetails ends");
			return restGoalReviewDao.viewMeetingDetailsDao();
		}
}
