package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;
import nirmalya.aatithya.restmodule.master.dao.RestEmployeeReportDao;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeReportsModel;

@RestController
@RequestMapping("master/")
public class RestEmployeeReportController {
	Logger logger = LoggerFactory.getLogger(RestEmployeeReportController.class);

	@Autowired
	RestEmployeeReportDao restEmployeeReportDao;
	
	// view
	@GetMapping(value = "rest-viewEmployeeReport")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeReportDetails(@RequestParam String userId,String organization,String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewEmployeeReportDetails starts");

		logger.info("Method : viewEmployeeReportDetails ends");

		return restEmployeeReportDao.viewEmployeeReportDetails(userId,organization,orgDivision,fromDate,toDate);
	}
	
	// view attendance
	@GetMapping(value = "rest-viewEmployeeAttendanceReports")
	public JsonResponse<Object> viewEmployeeAttendanceReports(@RequestParam String userId,String organization,String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewEmployeeAttendanceReports starts");

		logger.info("Method : viewEmployeeAttendanceReports ends");

		return restEmployeeReportDao.viewEmployeeAttendanceReports(userId,organization,orgDivision,fromDate,toDate);
	}
	// view Resignation
	@GetMapping(value = "viewExitdetails")//"rest-viewEmployeeResignationReports")
	public JsonResponse<Object> viewEmployeeResignationReports(@RequestParam String userId,String userRole, String organization,String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewEmployeeResignationReports starts");
		
		logger.info("Method : viewEmployeeResignationReports ends");
		
		return restEmployeeReportDao.viewEmployeeResignationReports(userId,userRole,organization,orgDivision,fromDate,toDate);
	}
	// view attendance dept wise
	@GetMapping(value = "rest-empAttendanceDetailsDepartmentWise")
	public JsonResponse<Object> empAttendanceDetailsDepartmentWise(@RequestParam String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		logger.info("Method : empAttendanceDetailsDepartmentWise starts");

		logger.info("Method : empAttendanceDetailsDepartmentWise ends");

		return restEmployeeReportDao.empAttendanceDetailsDepartmentWise(dept,subDept,fromDate,toDate,organization,orgDivision);
	}
	// view attendance Status
	@GetMapping(value = "rest-empAttendanceDetailsStatusWise")
	public JsonResponse<Object> empAttendanceDetailsStatusWise(@RequestParam String dept,String subDept,String attndate,String organization,String orgDivision,String status) {
		logger.info("Method : empAttendanceDetailsStatusWise starts");
		
		logger.info("Method : empAttendanceDetailsStatusWise ends");
		
		return restEmployeeReportDao.empAttendanceDetailsStatusWise(dept,subDept,attndate,organization,orgDivision,status);
	}
	
	// view attendance
		@GetMapping(value = "rest-viewEmployeeLeaveReports")
		public JsonResponse<Object> viewEmployeeLeaveReports(@RequestParam String userId,String organization,String orgDivision,String fromDate,String toDate) {
			logger.info("Method : viewEmployeeLeaveReports starts");

			logger.info("Method : viewEmployeeLeaveReports ends");

			return restEmployeeReportDao.viewEmployeeLeaveReports(userId,organization,orgDivision,fromDate,toDate);
		}
	// view attendance
		@GetMapping(value = "rest-empLeaveDepartmentWise")
		public JsonResponse<Object> empLeaveDepartmentWise(@RequestParam String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
			logger.info("Method : empLeaveDepartmentWise starts");
			logger.info("Method : empLeaveDepartmentWise ends");
			return restEmployeeReportDao.empLeaveDepartmentWise(dept,subDept,fromDate,toDate,organization,orgDivision);
		}
// view attendance
	@GetMapping(value = "rest-resginDepartmentWise")
	public JsonResponse<Object> resginDepartmentWise(@RequestParam String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		logger.info("Method : resginDepartmentWise starts");
		logger.info("Method : resginDepartmentWise ends");
		return restEmployeeReportDao.resginDepartmentWise(dept,subDept,fromDate,toDate,organization,orgDivision);
	}
}
