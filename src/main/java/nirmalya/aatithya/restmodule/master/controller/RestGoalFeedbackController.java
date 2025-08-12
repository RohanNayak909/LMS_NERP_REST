package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestGoalFeedbackDao;
import nirmalya.aatithya.restmodule.master.model.RestGoalFeedbackModel;
import nirmalya.aatithya.restmodule.master.model.RestGoalReviewModel;
import nirmalya.aatithya.restmodule.master.model.RestSelfAppraisalModel;

@RestController
@RequestMapping(value = { "master" })
public class RestGoalFeedbackController {
	Logger logger = LoggerFactory.getLogger(RestGoalFeedbackController.class);

	@Autowired
	RestGoalFeedbackDao restGoalFeedbackDao;
	
	/*
	 *	get name list 
	 */
	@RequestMapping(value = "getJobTitleList", method = { RequestMethod.GET })
	public List<DropDownModel> getNameListFB() {
		logger.info("Method : getNameListFB starts");

		logger.info("Method : getNameListFB ends");
		return restGoalFeedbackDao.getNameListFB();
	}
	/*
	 *	get designation list 
	 */
	@GetMapping(value = "get-designation-listFB")
	public JsonResponse<List<DropDownModel>> getDesignationList(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return restGoalFeedbackDao.getDesignationListFB(id);
	}
	/*
	 *	get designation list on change of name in sidenav
	 */
	@GetMapping(value = "getDesignationListfb")
	public JsonResponse<List<DropDownModel>> getDesignation(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return restGoalFeedbackDao.getDesignationList(id);
	}
	/*
	 *	save feedback data
	 */
	@RequestMapping(value = "addGoalFeedback", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addGoalFeedback(@RequestBody RestGoalFeedbackModel restGoalFeedback) {
		logger.info("Method : addGoalFeedback starts");

		logger.info("Method : addGoalFeedback endss");
		return restGoalFeedbackDao.addGoalFeedback(restGoalFeedback);
	}
	/*
	 *	view feedback data
	 */
	@RequestMapping(value = "viewFeedbackData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> viewFeedbackData(@RequestParam String name) {
		logger.info("Method : viewFeedbackData starts");

		logger.info("Method : viewFeedbackData ends");
		return restGoalFeedbackDao.viewFeedbackData(name);
	}
	/*
	 * view goal feedback employee list
	 */
	@RequestMapping(value = "view-employee-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> viewEmployeeList(String userId) {
		logger.info("Method : viewEmployeeList starts");

		logger.info("Method : viewEmployeeList ends");
		return restGoalFeedbackDao.viewEmployeeListDao(userId);
	}
	/*
	 * view goal feedback employee band
	 */
	@RequestMapping(value = "view-emp-band", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalFeedbackModel>>> viewEmployeeBandList(String id) {
		logger.info("Method : viewEmployeeBandList starts");

		logger.info("Method : viewEmployeeBandList ends");
		return restGoalFeedbackDao.viewEmployeeBandListDao(id);
	}
}
