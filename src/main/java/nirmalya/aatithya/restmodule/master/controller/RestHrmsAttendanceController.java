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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.RestHrmImsuranceController;
import nirmalya.aatithya.restmodule.employee.dao.HrmInsuranceDao;
import nirmalya.aatithya.restmodule.employee.model.TravelClaimRestModel;
import nirmalya.aatithya.restmodule.master.dao.HrmsAttendanceDao;
import nirmalya.aatithya.restmodule.master.model.RestHrmsAttendanceModel;

@RestController
@RequestMapping(value = "master/")
public class RestHrmsAttendanceController {
	Logger logger = LoggerFactory.getLogger(RestHrmsAttendanceController.class);

	@Autowired
	HrmsAttendanceDao hrmsAttendanceDao;

	
	@RequestMapping(value = "emplist", method = { RequestMethod.GET })
	public List<DropDownModel> emplist() {

		logger.info("Method : emplist starts");
		logger.info("Method : emplist ends");

		return hrmsAttendanceDao.emplist();
	}
	
	//view
	@RequestMapping(value = "rest-master-attendance-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAttendance(@RequestParam String orgName, String orgDivision,String fromDate, String toDate,String empid, String shift) {
		logger.info("Method :viewAttendance start");

		logger.info("Method :viewAttendance endss");
		return hrmsAttendanceDao.viewAttendance(orgName, orgDivision,fromDate, toDate,empid, shift);
	}
	
	// add
	
	@PostMapping(value = "rest-add-attendance")
	public ResponseEntity<JsonResponse<Object>> addAttendance(@RequestBody  RestHrmsAttendanceModel attendanceModel) {
		logger.info("Method : addAttendance starts");

		logger.info("Method : addAttendance ends");
		return hrmsAttendanceDao.addAttendance(attendanceModel);
	}
	
}
