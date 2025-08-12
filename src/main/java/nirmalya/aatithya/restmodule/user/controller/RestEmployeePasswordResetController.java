package nirmalya.aatithya.restmodule.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.dao.RestEmployeePasswordResetDao;

@RestController
@RequestMapping(value = "user/")
public class RestEmployeePasswordResetController {
	@Autowired
	RestEmployeePasswordResetDao restEmployeePasswordResetDao;

	Logger logger = LoggerFactory.getLogger(RestEmployeePasswordResetController.class);
	
	@PostMapping(value = "/reset-employee-password")
	public ResponseEntity<JsonResponse<Object>> resetEmployeePassword(@RequestBody DropDownModel data) {
		logger.info("Method : resetEmployeePassword starts");

		logger.info("Method : resetPassword ends");
		return restEmployeePasswordResetDao.resetEmployeePasswordDao(data);
	}
}
