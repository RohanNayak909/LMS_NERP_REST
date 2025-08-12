package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.ELManageDao;
import nirmalya.aatithya.restmodule.master.model.RestELManageModel;
@RestController
@RequestMapping("master/")
public class RestELManageController {
	Logger logger = LoggerFactory.getLogger(RestELManageController.class);

	@Autowired
	ELManageDao elManageDao;
	
	@Autowired
	EnvironmentVaribles env;
	
	@PostMapping(value = "addEarnedLeave")
	public ResponseEntity<JsonResponse<RestELManageModel>> addEarnedLeave(
			@RequestBody RestELManageModel vitamin) {
		logger.info("Method :addEarnedLeave starts");

		logger.info("Method :addEarnedLeave endss");
		return elManageDao.addEarnedLeave(vitamin);
	}
	@RequestMapping(value = "viewEarnedLeave", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEarnedLeave(@RequestParam String org, String orgDiv) {
		logger.info("Method :viewEarnedLeave start");

		logger.info("Method :viewEarnedLeave endss");
		return elManageDao.viewEarnedLeave( org, orgDiv);
	}
	@RequestMapping(value = "editEarnedLeave", method = { RequestMethod.GET })
	public JsonResponse<Object> editEarnedLeave(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :editEarnedLeave start");

		logger.info("Method :editEarnedLeave endss");
		return elManageDao.editEarnedLeave( id, org, orgDiv);
	}
	@RequestMapping(value = "approveEarnedLeave", method = { RequestMethod.GET })
	public JsonResponse<Object> approveEarnedLeave(@RequestParam String id, String empId, String org,String orgDiv, String userId) {
		logger.info("Method :approveEarnedLeave start");

		logger.info("Method :approveEarnedLeave endss");
		return elManageDao.approveEarnedLeave(id,empId, org, orgDiv,userId);
	}
	@RequestMapping(value = "deleteEarnedLeave", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteEmpolyeeReview(@RequestParam String id, String empId, String org,String orgDiv) {
		logger.info("Method :deleteEarnedLeave start");

		logger.info("Method :deleteEarnedLeave endss");
		return elManageDao.deleteEarnedLeave(id,empId, org, orgDiv);
	}

}
