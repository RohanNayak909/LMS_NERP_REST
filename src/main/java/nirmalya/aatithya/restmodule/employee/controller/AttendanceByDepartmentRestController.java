package nirmalya.aatithya.restmodule.employee.controller;

import java.util.Map;

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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.AttendanceByDepartmentDao;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeCCRModel;

@RestController
@RequestMapping("employee/")
public class AttendanceByDepartmentRestController {
	Logger logger = LoggerFactory.getLogger(AttendanceByDepartmentRestController.class);

	@Autowired
	AttendanceByDepartmentDao ccrDao;
	
	@Autowired
	EnvironmentVaribles env;
	@RequestMapping(value = "viewAttandance", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAttandance(@RequestParam String org, String orgDiv) {
		logger.info("Method :viewAttandance start");

		logger.info("Method :viewAttandance endss");
		return ccrDao.viewAttandance( org, orgDiv);
	}
	
	@PostMapping(value = "addAttendanceByDepartment")
	public ResponseEntity<JsonResponse<Map<String, String>>> addEmployeeReview(
			@RequestBody Map<String, String> vitamin) {
		logger.info("Method :addEmployeeReview starts"+vitamin);

		logger.info("Method :addEmployeeReview endss");
		return  ccrDao.addEmployeeReview(vitamin);
	}
}
