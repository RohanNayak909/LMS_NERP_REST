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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestEmployeeGroupSchedulingDao;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeGroupSchedulingModel;

@RestController
@RequestMapping(value = { "master/" })
public class RestEmployeeGroupSchedulingController {

	Logger logger = LoggerFactory.getLogger(RestEmployeeGroupSchedulingController.class);

	@Autowired
	RestEmployeeGroupSchedulingDao restEmployeeGroupSchedulingDao;

	// View

	@GetMapping(value = "rest-viewGroupSchedulingData" )
	public JsonResponse<Object> viewGroupSchedulingData(@RequestParam String orgName, @RequestParam String orgDivision,
			String sec) {
		logger.info("Method :viewGroupSchedulingData start");

		logger.info("Method :viewGroupSchedulingData endss");
		return restEmployeeGroupSchedulingDao.viewGroupSchedulingData(orgName, orgDivision, sec);

	}

	// View All

	@GetMapping(value = "rest-viewGroupSchedulingAllData" )
	public JsonResponse<Object> viewGroupSchedulingAllData(@RequestParam String orgName, String orgDivision,
			String sec) {
		logger.info("Method :viewGroupSchedulingAllData start");

		logger.info("Method :viewGroupSchedulingAllData endss");
		return restEmployeeGroupSchedulingDao.viewGroupSchedulingAllData(orgName, orgDivision, sec);

	}

	// View All

	@GetMapping(value = "rest-all-employee-dtls-group")
	public JsonResponse<Object> viewAllEmp(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewAllEmp start");

		logger.info("Method :viewAllEmp endss");
		return restEmployeeGroupSchedulingDao.viewAllEmp(orgName, orgDivision);

	}

	// Revised Group

	@PostMapping(value = "rest-addRevisedGroup")
	public ResponseEntity<JsonResponse<Object>> addRevisedGroup(
			@RequestBody List<RestEmployeeGroupSchedulingModel> restEmployeeGroupSchedulingModel) {
		logger.info("Method : addRevisedGroup starts");

		logger.info("Method : addRevisedGroup ends");
		return restEmployeeGroupSchedulingDao.addRevisedGroup(restEmployeeGroupSchedulingModel);
	}


	// approve group

	@GetMapping(value = "rest-approve-group")
	public JsonResponse<Object> approveGroup(@RequestParam String slNo, String flag, String orgName, String orgDivision,
			String userId) {
		logger.info("Method : approveGroup starts");

		logger.info("Method : approveGroup ends");
		return restEmployeeGroupSchedulingDao.approveGroup(slNo, flag, orgName, orgDivision, userId);
	}
}
