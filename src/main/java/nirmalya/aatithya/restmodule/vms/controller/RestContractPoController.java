package nirmalya.aatithya.restmodule.vms.controller;

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
import nirmalya.aatithya.restmodule.vms.dao.RestContractPoDao;

@RestController
@RequestMapping(value = { "purchase/" })
public class RestContractPoController {

	Logger logger = LoggerFactory.getLogger(RestContractLifecycleController.class);

	@Autowired
	RestContractPoDao restContractPoDao;

	// get-Contract-details
	@RequestMapping(value = "get-Contract-for-vendor", method = { RequestMethod.GET })
	public JsonResponse<Object> getContractDetails(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId) {

		logger.info("Method :getContractDetails starts");

		logger.info("Method :getContractDetails endss");
		return restContractPoDao.getContractDetails(org, orgDiv, userId);
	}

	// add-response-data
	@PostMapping(value = "add-response-data")
	public ResponseEntity<JsonResponse<Object>> saveResponseData(@RequestBody String parsedData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveResponseData starts");
		logger.info("Method :saveResponseData endss");
		return restContractPoDao.saveResponseData(userId, org, orgDiv, parsedData);
	}

	@RequestMapping(value = "view-response-data", method = { RequestMethod.GET })
	public JsonResponse<Object> viewResponseData(@RequestParam String contractId, @RequestParam String tenderId,@RequestParam String userId) {

		logger.info("Method :viewResponseData starts");

		logger.info("Method :viewResponseData endss");
		return restContractPoDao.viewResponseData(contractId,tenderId,userId);
	}
	
	@PostMapping(value = "add-admin-comment")
	public ResponseEntity<JsonResponse<Object>> saveAdminComment(@RequestBody String parsedData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveAdminComment starts");
		logger.info("Method :saveAdminComment endss");
		return restContractPoDao.saveAdminComment(userId, org, orgDiv, parsedData);
	}

}
