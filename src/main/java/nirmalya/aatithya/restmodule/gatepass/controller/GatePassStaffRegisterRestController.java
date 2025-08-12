package nirmalya.aatithya.restmodule.gatepass.controller;

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
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassStaffRegisterRestDao;
import nirmalya.aatithya.restmodule.gatepass.model.EmployeeAttendance;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassStaffRegisterModel;

@RestController
@RequestMapping("gatepass/")
public class GatePassStaffRegisterRestController {

	Logger logger = LoggerFactory.getLogger(GatePassStaffRegisterRestController.class);

	@Autowired
	GatePassStaffRegisterRestDao gatePassStaffRegisterRestDao;

	@RequestMapping(value = "getDepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList(@RequestParam String org, String orgDiv) {
		logger.info("Method : getDepartmentList starts");

		logger.info("Method : getDepartmentList ends");
		return gatePassStaffRegisterRestDao.getDepartmentList(org, orgDiv);
	}

	@RequestMapping(value = "rest-viewGatePassStaffRegister", method = { RequestMethod.GET })
	public JsonResponse<Object> viewGatePassStaffRegister(@RequestParam String orgName,
			@RequestParam String orgDivision, String dept, String fromdate, String todate, String pageno) {
		logger.info("Method :viewGatePassStaffRegister start");

		logger.info("Method :viewGatePassStaffRegister endss");
		return gatePassStaffRegisterRestDao.viewGatePassStaffRegister(orgName, orgDivision, dept, fromdate, todate,
				pageno);

	}
	

	@GetMapping(value = "rest-get-all-employees")
	public JsonResponse<Object> getAllEmployee(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :getAllEmployee start");

		logger.info("Method :getAllEmployee endss");
		return gatePassStaffRegisterRestDao.getAllEmployee(org, orgDiv);

	}


	// getDepartmentList Api.

	@RequestMapping(value = "getDepartmentList-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDepartmentListApi(@RequestParam String org,
			String orgDiv) {
		logger.info("Method : getDepartmentListApi starts");

		logger.info("Method : getDepartmentListApi ends");
		return gatePassStaffRegisterRestDao.getDepartmentListApi(org, orgDiv);
	}

	@RequestMapping(value = "rest-updateAttendance", method = { RequestMethod.POST })
	public JsonResponse<Object> updateAttendance(@RequestParam String orgName, @RequestParam String orgDivision,
			String userId, @RequestBody EmployeeAttendance employeeData) {
		logger.info("Method :updateAttendance start and end");
		return gatePassStaffRegisterRestDao.updateAttendance(orgName, orgDivision, userId, employeeData);
	}
	

	@PostMapping(value = "add-gatepass-details-offline")
	public ResponseEntity<JsonResponse<GatePassStaffRegisterModel>> saveOfflineDetails(
			@RequestBody List<GatePassStaffRegisterModel> category) {
		logger.info("Method : saveOfflineDetails starts");

		logger.info("Method : saveOfflineDetails ends");
		return gatePassStaffRegisterRestDao.saveOfflineDetails(category);
	}
}
	
	
	