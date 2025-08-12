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
import nirmalya.aatithya.restmodule.master.dao.OtpAuthDao;

/**
 * @author Nirmalya Labs
 * 
 */
@RestController
@RequestMapping("master")
public class OtpAuthController {
	
	Logger logger = LoggerFactory.getLogger(OtpAuthController.class);
	
	@Autowired
	OtpAuthDao otpAuthDao;

	
	@PostMapping(value = "save-otp")
	public ResponseEntity<JsonResponse<Object>> saveGeneratedOtp(@RequestBody String data) {
		logger.info("Method :saveGeneratedOtp starts");
		logger.info("Method :saveGeneratedOtp endss");
		return otpAuthDao.saveGeneratedOtp(data);
	}
	
	@GetMapping(value = "fetch-otp")
	public JsonResponse<Object> fetchOtp(@RequestParam String otp, String id) {
		logger.info("Method : fetchOtp starts");

		logger.info("Method : fetchOtp ends");
		return otpAuthDao.fetchOtp(otp, id);
	}

}
