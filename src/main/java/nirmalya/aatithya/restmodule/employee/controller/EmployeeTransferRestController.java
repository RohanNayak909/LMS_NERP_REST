package nirmalya.aatithya.restmodule.employee.controller;
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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.EmployeeTransferDao;

@RestController
@RequestMapping("employee/")
public class EmployeeTransferRestController {
	Logger logger = LoggerFactory.getLogger(EmployeeTransferRestController.class);

	@Autowired
	EmployeeTransferDao employeeTransferDao;
	
	@PostMapping(value = "save-employee-transfer-data")
	public ResponseEntity<JsonResponse<Object>> saveTransferEmployeeData(@RequestBody String data,@RequestParam String userId,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :saveTransferEmployeeData starts");
		logger.info("Method :saveTransferEmployeeData endss");
		return employeeTransferDao.saveTransferEmployeeData(data,userId,org,orgDiv);
	}
	
	@RequestMapping(value = "get-AllEmpTransferData", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllTendersData(@RequestParam String org,
				@RequestParam String orgDiv,@RequestParam String userId) {

		logger.info("Method :get-AllEmpTransferData For Vendor starts");

		logger.info("Method :get-AllEmpTransferData For Vendor endss");
		return employeeTransferDao.getAllEmpTransferData(org, orgDiv,userId);
	}

}
