package nirmalya.aatithya.restmodule.user.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.dao.EmployeeStatusDao;
import nirmalya.aatithya.restmodule.user.dao.RolesAccessDao;
import nirmalya.aatithya.restmodule.user.dao.UserRoleAssignDao;
import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;
import nirmalya.aatithya.restmodule.user.model.RolesAccessModel;
import nirmalya.aatithya.restmodule.user.model.UserAccessModel;

@RestController
@RequestMapping(value = "user/")
public class EmployeeStatusRestController {
	
	@Autowired
	EmployeeStatusDao employeeStatusDao;

	Logger logger = LoggerFactory.getLogger(EmployeeStatusRestController.class);
	
	// view

		@RequestMapping(value = "viewEmployeeMasterView", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestUserRoleAssignModel>>> viewEmployeeMasterView(@RequestParam String org, String orgDiv) {
			logger.info("Method : viewEmployeeMasterView starts");

			logger.info("Method : viewEmployeeMasterView ends");
			return employeeStatusDao.viewEmployeeMasterView(org,orgDiv);
		}
		
		@RequestMapping(value = "addEmployeeMasteradd", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addEmployeeMasteradd(@RequestBody RestUserRoleAssignModel id) {
			logger.info("Method : addEmployeeMaster starts");
			
			logger.info("Method : addEmployeeMaster ends");
			return employeeStatusDao.addEmployeeMasteradd(id);
		}
		// clear Password
		@RequestMapping(value = "rest-clearPassword", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> clearPassword(@RequestParam String id,String org, String orgDiv) {
			logger.info("Method : clearPassword starts");

			logger.info("Method : clearPassword ends");
			return employeeStatusDao.clearPassword(id,org,orgDiv);
		}
		// clear IMEI
		@RequestMapping(value = "rest-clearIMEI", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> clearIMEI(@RequestParam String id,String org, String orgDiv) {
			logger.info("Method : clearIMEI starts");
			
			logger.info("Method : clearIMEI ends");
			return employeeStatusDao.clearIMEI(id,org,orgDiv);
		}
}