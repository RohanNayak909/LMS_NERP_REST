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
import nirmalya.aatithya.restmodule.master.dao.PaySlipAttendanceDao;
import nirmalya.aatithya.restmodule.master.model.AttendanceDateRestModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("master")
public class RestPaySlipAttendanceController {

	Logger logger = LoggerFactory.getLogger(PaymentModeMasterRestController.class);
	
	@Autowired
	PaySlipAttendanceDao paySlipAttendanceDao;
	
	

	@RequestMapping(value = "getYearList-attendance", method = { RequestMethod.GET })
	public List<DropDownModel> getYearList(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getYearList starts");
		
		logger.info("Method : getYearList ends");
		return paySlipAttendanceDao.getYearList(organization,orgDivision);
	}
	
	@RequestMapping(value = "getStartDayForAttendance", method = { RequestMethod.GET })
	public List<DropDownModel> getStartDayForAttendance(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getStartDayForAttendance starts");
		
		logger.info("Method : getStartDayForAttendance ends");
		return paySlipAttendanceDao.getStartDayForAttendance(organization,orgDivision);
	}
	
	@RequestMapping(value = "getAttendanceDate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAttendanceDate(@RequestParam String month,@RequestParam String lyear,String organization,String orgDivision) {
		logger.info("Method : getAttendanceDate starts");
		
		logger.info("Method : getAttendanceDate ends");
		return paySlipAttendanceDao.getAttendanceDate(month,lyear,organization,orgDivision);
	}
 
	@GetMapping(value = "getEmployeeAttendanceList")
	public JsonResponse<List<AttendanceDateRestModel>> getEmployeeAttendanceList(@RequestParam String fromDate,String toDate,String employedBy,String userId,String organization,String orgDivision,String stafftype,String id) {
		logger.info("Method : getEmployeeAttendanceList starts");
		
		logger.info("Method :getEmployeeAttendanceList endss");
		return paySlipAttendanceDao.getEmployeeAttendanceList(fromDate,toDate,employedBy,userId,organization,orgDivision,stafftype,id);

	}
	
	
	
	@RequestMapping(value = "getEmployeeLeaveList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AttendanceDateRestModel>>> getEmployeeLeaveList(@RequestParam String fromDate,String toDate,String employedBy,String userId,String organization,String orgDivision) {
		logger.info("Method : getEmployeeLeaveList starts");
		
		logger.info("Method : getEmployeeLeaveList ends");
		return paySlipAttendanceDao.getEmployeeLeaveList(fromDate,toDate,employedBy,userId,organization,orgDivision);
	}
	
	
	@GetMapping(value = "rest-attendanceType")
	public JsonResponse<List<DropDownModel>> attendanceType(@RequestParam String organization,String orgDivision) {
		logger.info("Method : attendanceType starts");

		logger.info("Method : attendanceType ends");
		return paySlipAttendanceDao.attendanceTypeDao(organization,orgDivision);
	}
	
	
	@GetMapping(value = "getAttndTypeAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAttndTypeAutoSearchList(
			@RequestParam String id) {
		logger.info("Method : getAttndTypeAutoSearchList starts");

		logger.info("Method :getAttndTypeAutoSearchList endss");
		return paySlipAttendanceDao.getAttndTypeAutoSearchList(id);
	}
	//approveEmployeeAttendance
	@PostMapping(value = "approveEmployeeAttendance")
	public JsonResponse<List<AttendanceDateRestModel>> approveEmployeeAttendance(
			@RequestBody List<AttendanceDateRestModel> attendModel) {
		logger.info("Method : approveEmployeeAttendance starts");

		logger.info("Method : approveEmployeeAttendance ends");
		return paySlipAttendanceDao.approveEmployeeAttendance(attendModel);
	}
	//saveDraftEmployeeAttendance
	@PostMapping(value = "saveDraftEmployeeAttendance")
	public JsonResponse<List<AttendanceDateRestModel>> saveDraftEmployeeAttendance(
			@RequestBody List<AttendanceDateRestModel> attendModel) {
		logger.info("Method : saveDraftEmployeeAttendance starts");
		
		logger.info("Method : saveDraftEmployeeAttendance ends");
		return paySlipAttendanceDao.saveDraftEmployeeAttendance(attendModel);
	}
	
}
