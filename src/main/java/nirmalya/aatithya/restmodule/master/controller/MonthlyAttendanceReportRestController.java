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
import nirmalya.aatithya.restmodule.master.dao.MonthlyAttendanceReportDao;
import nirmalya.aatithya.restmodule.master.model.AttendanceDateRestModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("master")
public class MonthlyAttendanceReportRestController {

	Logger logger = LoggerFactory.getLogger(MonthlyAttendanceReportRestController.class);
	
	@Autowired
	MonthlyAttendanceReportDao monthlyAttendanceReportDao;

	
	@RequestMapping(value = "getAttendanceReportDate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAttendanceDates(@RequestParam String month,@RequestParam String lyear,String organization,String orgDivision) {
		logger.info("Method : getAttendanceDate starts");
		
		logger.info("Method : getAttendanceDate ends");
		return monthlyAttendanceReportDao.getAttendanceDates(month,lyear,organization,orgDivision);
	}
 
	@GetMapping(value = "getEmployeeMonthlyAttendanceList")
	public JsonResponse<List<AttendanceDateRestModel>> getEmployeeAttendanceLists(@RequestParam String fromDate,String toDate,String attendanceType,String userId,String organization,String orgDivision,String stafftype) {
		logger.info("Method : getEmployeeAttendanceList starts");
		
		logger.info("Method :getEmployeeAttendanceList endss");
		return monthlyAttendanceReportDao.getEmployeeAttendanceLists(fromDate,toDate,attendanceType,userId,organization,orgDivision,stafftype);
	}
	
	@GetMapping(value = "rest-attendanceTypes")
	public JsonResponse<List<DropDownModel>> attendanceTypeDaos(@RequestParam String organization,String orgDivision) {
		logger.info("Method : attendanceType starts");

		logger.info("Method : attendanceType ends");
		return monthlyAttendanceReportDao.attendanceTypeDaos(organization,orgDivision);
	}
	
	@GetMapping(value = "rest-getMonthlyAttendanceApproverStatus")
	public ResponseEntity<JsonResponse<DropDownModel>> getApproverStatuss(@RequestParam String fromDate,String process,String userId,String organization,String orgDivision) {
		logger.info("Method : getApproverStatus starts");

		logger.info("Method : getApproverStatus ends");
		return monthlyAttendanceReportDao.getApproverStatuss(fromDate,process,userId,organization,orgDivision);
	}
	
	/*
	 * auto search 
	 */

	@GetMapping(value = "getAttndTypeMonthlyReportAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAttndTypeAutoSearchLists(
			@RequestParam String id) {
		logger.info("Method : getAttndTypeAutoSearchList starts");

		logger.info("Method :getAttndTypeAutoSearchList endss");
		return monthlyAttendanceReportDao.getAttndTypeAutoSearchLists(id);
	}
	
	@PostMapping(value = "approveMonthlyEmployeeAttendance")
	public JsonResponse<List<AttendanceDateRestModel>> approveEmployeeAttendances(
			@RequestBody List<AttendanceDateRestModel> approve) {
		logger.info("Method : approveEmployeeAttendance starts");

		logger.info("Method : approveEmployeeAttendance ends");
		return monthlyAttendanceReportDao.approveEmployeeAttendances(approve);
	}
	//
	@RequestMapping(value = "rest-viewMonthlyAttReport", method = { RequestMethod.GET })
	public JsonResponse<Object> viewMonthlyAttReportPdf(@RequestParam String[] empId,@RequestParam String fromDate,@RequestParam String toDate) {
		logger.info("Method :viewMonthlyAttReportPdf start");

		logger.info("Method :viewMonthlyAttReportPdf endss");
		return monthlyAttendanceReportDao.viewMonthlyAttReportPdf(empId,fromDate,toDate);

	}
}
