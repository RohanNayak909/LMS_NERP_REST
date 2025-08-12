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
import nirmalya.aatithya.restmodule.master.dao.RestEmployeeShiftSchedulingDao;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeShiftSchedulingModel;

@RestController
@RequestMapping(value = { "master/" })
public class RestEmployeeShiftSchedulingController {

	Logger logger = LoggerFactory.getLogger(RestEmployeeShiftSchedulingController.class);

	@Autowired
	RestEmployeeShiftSchedulingDao restEmployeeShiftSchedulingDao;

	// Shift List

	@GetMapping(value = "getShiftLists" )
	public List<DropDownModel> getShiftLists(@RequestParam String org, String orgDiv, String userId) {
		logger.info("Method : getShiftLists starts");

		logger.info("Method : getShiftLists ends");
		return restEmployeeShiftSchedulingDao.getShiftLists(org, orgDiv, userId);
	}
	// View

		@GetMapping(value = "rest-viewShift" )
		public JsonResponse<Object> viewShift(@RequestParam String orgName, @RequestParam String orgDivision) {
			logger.info("Method :viewShift start");

			logger.info("Method :viewShift endss");
			return restEmployeeShiftSchedulingDao.viewShift(orgName, orgDivision);

		}
	// View

	@GetMapping(value = "rest-viewShiftSchedulingData" )
	public JsonResponse<Object> viewShiftSchedulingData(@RequestParam String orgName, @RequestParam String orgDivision,
			String sec) {
		logger.info("Method :viewShiftSchedulingData start");

		logger.info("Method :viewShiftSchedulingData endss");
		return restEmployeeShiftSchedulingDao.viewShiftSchedulingData(orgName, orgDivision, sec);

	}

	// View Shift Diff Groups

	@GetMapping(value = "rest-viewShiftDiffGroupsData" )
	public JsonResponse<Object> viewShiftDiffGroupsData(@RequestParam String orgName, String orgDivision,
			String sec, String fromDate, String toDate) {
		logger.info("Method :viewShiftDiffGroupsData start");

		logger.info("Method :viewShiftDiffGroupsData endss");
		return restEmployeeShiftSchedulingDao.viewShiftDiffGroupsData(orgName, orgDivision, sec, fromDate, toDate);

	}

	// Revised Shift

	@PostMapping(value = "rest-addRevisedShift")
	public ResponseEntity<JsonResponse<Object>> addRevisedShift(
			@RequestBody List<RestEmployeeShiftSchedulingModel> restEmployeeShiftSchedulingModel) {
		logger.info("Method : addRevisedShift starts");

		logger.info("Method : addRevisedShift ends");
		return restEmployeeShiftSchedulingDao.addRevisedShift(restEmployeeShiftSchedulingModel);
	}


	// approve shift

	@GetMapping(value = "rest-approve-shift")
	public JsonResponse<Object> approveShift(@RequestParam String slNo, String flag, String orgName, String orgDivision,
			String userId) {
		logger.info("Method : approveShift starts");

		logger.info("Method : approveShift ends");
		return restEmployeeShiftSchedulingDao.approveShift(slNo, flag, orgName, orgDivision, userId);
	}


	// View All

	@GetMapping(value = "rest-all-employee-dtls")
	public JsonResponse<Object> viewAllEmp(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewAllEmp start");

		logger.info("Method :viewAllEmp endss");
		return restEmployeeShiftSchedulingDao.viewAllEmp(orgName, orgDivision);

	}
	
// View Employee DropDown

	@GetMapping(value = "rest-viewEmployeeDropDown")
	public JsonResponse<Object> viewEmployeeDropDown(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewEmployeeDropDown start");

		logger.info("Method :viewEmployeeDropDown endss");
		return restEmployeeShiftSchedulingDao.viewEmployeeDropDown(orgName, orgDivision);
	}
// View view All Shift Data

	@GetMapping(value = "rest-viewAllShiftData" )
	public JsonResponse<Object> viewAllShiftData(@RequestParam String orgName, @RequestParam String orgDivision,String sec) {
		logger.info("Method :viewAllShiftData start");

		logger.info("Method :viewAllShiftData endss");
		return restEmployeeShiftSchedulingDao.viewAllShiftData(orgName, orgDivision, sec);
	}
	
	// view Shift List Gatepass

		@GetMapping(value = "rest-viewShiftListGatepass" )
		public JsonResponse<Object> viewShiftListGatepass(@RequestParam String orgName, @RequestParam String orgDivision,String sec) {
			logger.info("Method :viewShiftListGatepass start");

			logger.info("Method :viewShiftListGatepass endss");
			return restEmployeeShiftSchedulingDao.viewShiftListGatepass(orgName, orgDivision, sec);
		}
	
		// approve wrong shift

		@GetMapping(value = "rest-approveWrongShift")
		public JsonResponse<Object> approveWrongShift(@RequestParam String slNo, String fromDate, String toDate, String orgName, String orgDivision,
				String userId) {
			logger.info("Method : approveWrongShift starts");

			logger.info("Method : approveWrongShift ends");
			return restEmployeeShiftSchedulingDao.approveWrongShift(slNo, fromDate, toDate, orgName, orgDivision, userId);
		}
}
