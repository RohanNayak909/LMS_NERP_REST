package nirmalya.aatithya.restmodule.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.api.dao.EmployeeOverTimeDao;
import nirmalya.aatithya.restmodule.api.model.AttendanceModel;
import nirmalya.aatithya.restmodule.api.model.EmployeeOverTimeLocationModel;
import nirmalya.aatithya.restmodule.api.model.EmployeeOverTimeModel;
import nirmalya.aatithya.restmodule.api.model.OvertimePunchinDetaillsModel;
import nirmalya.aatithya.restmodule.api.model.RegistrationRestCrmModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.DocumentUpload;
@RestController
@RequestMapping(value = "api")
public class EmployeeOverTimeController {
	@Autowired
	EmployeeOverTimeDao employeeOverTimeDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	DocumentUpload documentUpload;

	Logger logger = LoggerFactory.getLogger(EmployeeOverTimeController.class);
	
	/*
	 * Get mapping for department
	 */
	@GetMapping(value = "get-departmentLists-api")
	public JsonResponse<List<DropDownModel>> getDepartmentListApi(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getDepartmentListApi starts");

		logger.info("Method : getDepartmentListApi ends");
		return employeeOverTimeDao.getDepartmentListApi(organization,orgDivision);
	}
	/*
	 * Get mapping for sub-department
	 */
	@GetMapping(value = "get-sub-departmentLists-api")
	public JsonResponse<List<DropDownModel>> getSubDepartmentListApi(@RequestParam String organization,String orgDivision,String deptId) {
		logger.info("Method : getSubDepartmentListApi starts");
		
		logger.info("Method : getSubDepartmentListApi ends");
		return employeeOverTimeDao.getSubDepartmentListApi(organization,orgDivision,deptId);
	}
	/*
	 * viewEmployeeOverTimeAssignDetails
	 */
	@GetMapping(value = "get-employee-overtime-assign-details")
	public JsonResponse<List<EmployeeOverTimeModel>> viewEmployeeOverTimeAssignDetails(@RequestParam String date,String userId,String dept,String subDept,String organization,String orgDivision) {
		logger.info("Method :viewEmployeeOverTimeAssignDetails starts");
		
		logger.info("Method :viewEmployeeOverTimeAssignDetails endss");
		return employeeOverTimeDao.viewEmployeeOverTimeAssignDetails(date,userId,dept,subDept,organization,orgDivision);
	}
	// assign over time
	@PostMapping(value = "post-assign-employe-overtime")
	public ResponseEntity<JsonResponse<List<EmployeeOverTimeModel>>> assignEmployeeOverTime(
			@RequestBody List<EmployeeOverTimeModel> overTimeModel) {
		logger.info("Method : assignEmployeeOverTime starts");
		logger.info("Method : assignEmployeeOverTime ends");
		return employeeOverTimeDao.assignEmployeeOverTime(overTimeModel);
	}
	/*
	 * Get mapping for over time
	 */
	@GetMapping(value = "get-employee-overtime-details")
	public JsonResponse<EmployeeOverTimeModel> viewEmployeeOverTimeDetails(@RequestParam String date,String userId,String organization,String orgDivision) {
		logger.info("Method :viewEmployeeOverTimeDetails starts");
		
		logger.info("Method :viewEmployeeOverTimeDetails endss");
		return employeeOverTimeDao.viewEmployeeOverTimeDetails(date,userId,organization,orgDivision);
	}
	/*
	 *off assign over time
	 */
	@RequestMapping(value = "off-assign-employee-overtime", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> offAssignEmployeeOverTime(@RequestParam String date,String userId,String organization,String orgDivision){
		logger.info("Method : offAssignEmployeeOverTime starts");

		logger.info("Method : offAssignEmployeeOverTime ends");
		return employeeOverTimeDao.offAssignEmployeeOverTime(date,userId,organization,orgDivision);
	}
	/*
	 * Get mapping for over time employee wise
	 */
	@GetMapping(value = "get-overtime-employee-wise")
	public JsonResponse<List<EmployeeOverTimeModel>> getOverTimeEmployeeWise(@RequestParam String date,String userId,String organization,String orgDivision) {
		logger.info("Method :getOverTimeEmployeeWise starts");
		
		logger.info("Method :getOverTimeEmployeeWise endss");
		return employeeOverTimeDao.getOverTimeEmployeeWise(date,userId,organization,orgDivision);
	}
	
	
	@RequestMapping(value = "overtime-punchin-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<OvertimePunchinDetaillsModel>>> overtimePunchInDetailsData(
			@RequestBody OvertimePunchinDetaillsModel overTimeModel){
		logger.info("Method : overtimePunchInDetailsData starts");

		logger.info("Method : overtimePunchInDetailsData ends");
		return employeeOverTimeDao.overtimePunchInDetailsData(overTimeModel);
	}
	
	
	
	@RequestMapping(value = "overtime-punchout-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<OvertimePunchinDetaillsModel>>> overtimePunchOutDetailsData(
			@RequestBody OvertimePunchinDetaillsModel overTimeModel){
		logger.info("Method : overtimePunchOutDetailsData starts");

		logger.info("Method : overtimePunchOutDetailsData ends");
		return employeeOverTimeDao.overtimePunchOutDetailsData(overTimeModel);
	}
	
	
	@GetMapping(value = "get-overtime-attendance-details")
	public JsonResponse<List<OvertimePunchinDetaillsModel>> getOvertimeAttendanceDetails(@RequestParam String userId,@RequestParam String fromdate,@RequestParam String todate,
			@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method :getOvertimeAttendanceDetails starts");
		
		logger.info("Method :getOvertimeAttendanceDetails endss");
		return employeeOverTimeDao.getOvertimeAttendanceDetails(userId,fromdate,todate,organization,orgDivision);
	}
	@GetMapping(value = "/get-employee-overtime-location")
	public ResponseEntity<JsonResponse<EmployeeOverTimeLocationModel>> getEmpOverTimeLocation(@RequestParam String userid,String date,
			String organization, String orgDivision) {
		logger.info("Method : getEmpOverTimeLocation starts");

		logger.info("Method : getEmpOverTimeLocation ends");
		return employeeOverTimeDao.getEmpOverTimeLocation(userid,date,organization,orgDivision);
	}

}
