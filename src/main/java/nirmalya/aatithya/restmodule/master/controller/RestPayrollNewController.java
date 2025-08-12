//package nirmalya.aatithya.restmodule.master.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
//import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//import nirmalya.aatithya.restmodule.master.dao.PayrollAttendanceDao;
//
//
//@RestController
//@RequestMapping(value = { "master" })
//public class RestPayrollNewController {
//	Logger logger = LoggerFactory.getLogger(RestPayrollNewController.class);
//
//	@Autowired
//	PayrollAttendanceDao payrollAttendanceDao;
//	
//	@RequestMapping(value = "rest-getEmployeeList", method = { RequestMethod.GET })
//	public JsonResponse<Object> getEmployeeList(@RequestParam String orgName, String orgDivision,String userId) {
//		logger.info("Method :getEmployeeList start");
//
//		logger.info("Method :getEmployeeList endss");
//		return payrollAttendanceDao.getEmployeeList(orgName, orgDivision,userId);
//	}
//}
