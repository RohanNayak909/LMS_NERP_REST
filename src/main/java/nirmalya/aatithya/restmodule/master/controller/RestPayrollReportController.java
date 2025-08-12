package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestPayrollDao;
import nirmalya.aatithya.restmodule.master.dao.RestPayrollReportDao;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.master.model.RestPayrollModel;

@RestController
@RequestMapping(value = "master")
public class RestPayrollReportController {

	Logger logger = LoggerFactory.getLogger(RestPayrollReportController.class);

	@Autowired
	RestPayrollReportDao restPayrollReportDao;
	@Autowired
	EntityManager em;

	@RequestMapping(value = "rest-viewReport", method = { RequestMethod.GET })
	public JsonResponse<Object> viewReport(@RequestParam String fromDate, String toDate, String staff,
			String employedBy, String userId, String organization, String orgDivision) {
		logger.info("Method :viewReport start");

		logger.info("Method :viewReport endss");
		return restPayrollReportDao.viewReport(fromDate, toDate, staff, employedBy, userId, organization, orgDivision);

	}

	@RequestMapping(value = "getYearLists", method = { RequestMethod.GET })
	public List<DropDownModel> getYearLists(@RequestParam String organization, String orgDivision) {
		logger.info("Method : getYearLists starts");

		logger.info("Method : getYearLists ends");
		return restPayrollReportDao.getYearLists(organization, orgDivision);
	}

	@RequestMapping(value = "getStaffType", method = { RequestMethod.GET })
	public List<DropDownModel> getStaffType(@RequestParam String organization, String orgDivision) {
		logger.info("Method : getStaffType starts");

		logger.info("Method : getStaffType ends");
		return restPayrollReportDao.getStaffType(organization, orgDivision);
	}

	@RequestMapping(value = "reportPivot", method = { RequestMethod.GET })
	public JsonResponse<Object> reportPivot(@RequestParam String fromDate, String toDate, String staff,String employedBy,String userId,
			String organization, String orgDivision) {
		logger.info("Method :reportPivot start");

		logger.info("Method :reportPivot endss");
		return restPayrollReportDao.reportPivot(fromDate, toDate, staff,employedBy, userId, organization, orgDivision);

	}

	@RequestMapping(value = "reportSummary", method = { RequestMethod.GET })
	public JsonResponse<Object> reportSummary(@RequestParam String fromDate, String toDate, String staff,String employedBy, String userId,
			String organization, String orgDivision) {
		logger.info("Method :reportSummary start");

		logger.info("Method :reportSummary endss");
		return restPayrollReportDao.reportSummary(fromDate, toDate, staff,employedBy, userId, organization, orgDivision);

	}

	@RequestMapping(value = "reportAttendance", method = { RequestMethod.GET })
	public JsonResponse<Object> reportAttendance(@RequestParam String fromDate, String toDate, String staff,String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method :reportAttendance start");

		logger.info("Method :reportAttendance endss");
		return restPayrollReportDao.reportAttendance(fromDate, toDate, staff,employedBy, userId, organization, orgDivision);

	}
	
	@RequestMapping(value = "reportLeave", method = { RequestMethod.GET })
	public JsonResponse<Object> reportLeave(@RequestParam String fromDate, String toDate, String staff,String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method :reportLeave start");

		logger.info("Method :reportLeave endss");
		return restPayrollReportDao.reportLeave(fromDate, toDate, staff,employedBy, userId, organization, orgDivision);

	}

	@RequestMapping(value = "reportAdvance", method = { RequestMethod.GET })
	public JsonResponse<Object> reportAdvance(@RequestParam String fromDate, String toDate, String staff,String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method :reportAdvance start");

		logger.info("Method :reportAdvance endss");
		return restPayrollReportDao.reportAdvance(fromDate, toDate, staff,employedBy, userId, organization, orgDivision);

	}
	
	
	@GetMapping(value = "emiAllDetails" )
	public JsonResponse<Object> emiAllDetails(@RequestParam String empId) {
		logger.info("Method :emiAllDetails start");

		logger.info("Method :emiAllDetails endss");
		return restPayrollReportDao.emiAllDetails(empId);

	}

	@RequestMapping(value = "reportAttendanceView", method = { RequestMethod.GET })
	public JsonResponse<Object> reportAttendanceView(@RequestParam String fromDate, String toDate, String staff,String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method :reportAttendanceView start");

		logger.info("Method :reportAttendanceView endss");
		return restPayrollReportDao.reportAttendanceView(fromDate, toDate, staff,employedBy, userId, organization, orgDivision);
	}

	@RequestMapping(value = "reportLicView", method = { RequestMethod.GET })
	public JsonResponse<Object> reportLicView(@RequestParam String fromDate, String toDate, String staff,String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method :reportLicView start");

		logger.info("Method :reportLicView endss");
		return restPayrollReportDao.reportLicView(fromDate, toDate, staff,employedBy, userId, organization, orgDivision);
	}
	@RequestMapping(value = "reportLeaveEmpData", method = { RequestMethod.GET })
	public JsonResponse<Object> reportLeaveEmpData(@RequestParam  String organization, String orgDivision) {
		logger.info("Method :reportLeaveEmpData start");

		logger.info("Method :reportLeaveEmpData endss");
		return restPayrollReportDao.reportLeaveEmpData( organization, orgDivision);
	}
	
	@RequestMapping(value = "reportLeaveWagesData", method = { RequestMethod.GET })
	public JsonResponse<Object> reportLeaveWagesData(@RequestParam  String id,String organization, String orgDivision) {
		logger.info("Method :reportLeaveWagesData start");

		logger.info("Method :reportLeaveWagesData endss");
		return restPayrollReportDao.reportLeaveWagesData( id,organization, orgDivision);
	}
	
	@RequestMapping(value = "rest-getEmployeeList", method = { RequestMethod.GET })
	public JsonResponse<Object> getEmployeeList(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :getEmployeeList start");

		logger.info("Method :getEmployeeList endss");
		return restPayrollReportDao.getEmployeeList(orgName, orgDivision,userId);
	}
}
