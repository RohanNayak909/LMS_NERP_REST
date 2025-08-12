package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RequestFeedBackRestDao;
import nirmalya.aatithya.restmodule.master.model.RestGoalMastersModel;
import nirmalya.aatithya.restmodule.master.model.RestRequestFeedBackModel;
import nirmalya.aatithya.restmodule.user.controller.RolesAccessRestController;
import nirmalya.aatithya.restmodule.user.dao.RolesAccessDao;
import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;
import nirmalya.aatithya.restmodule.user.model.RolesAccessModel;

@RestController
@RequestMapping(value = "master/")
public class RestRequestFeedbackController {

	@Autowired
	RequestFeedBackRestDao requestFeedBackRestDao;

	Logger logger = LoggerFactory.getLogger(RestRequestFeedbackController.class);

	@RequestMapping(value = "getEmployeeNameList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestRequestFeedBackModel>>> getEmployeeNameList() {
		logger.info("Method : getEmployeeNameList starts");

		logger.info("Method : getEmployeeNameList ends");
		return requestFeedBackRestDao.getEmployeeNameList();
	}

	@RequestMapping(value = "addEmployeeFeedBack", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addEmployeeFeedBack(@RequestBody RestRequestFeedBackModel id) {
		logger.info("Method : addEmployeeFeedBack starts");

		logger.info("Method : addEmployeeFeedBack ends");
		return requestFeedBackRestDao.addEmployeeFeedBack(id);
	}

	/*
	 * @PostMapping(value = "addEmployeeFeedBack") public
	 * ResponseEntity<JsonResponse<List<RestRequestFeedBackModel>>>addGoalMaster(@
	 * RequestBody List<RestRequestFeedBackModel> restRequestFeedBackModel) {
	 * logger.info("Method :addEmployeeFeedBack starts");
	 * logger.info(restRequestFeedBackModel);
	 * logger.info("Method :addEmployeeFeedBack endss"); return
	 * requestFeedBackRestDao.addEmployeeFeedBack(restRequestFeedBackModel); }
	 */
}
