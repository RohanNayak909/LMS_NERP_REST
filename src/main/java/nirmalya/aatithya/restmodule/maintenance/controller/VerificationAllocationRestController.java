package nirmalya.aatithya.restmodule.maintenance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.maintenance.dao.AllotedMaintenanceDao;
import nirmalya.aatithya.restmodule.maintenance.dao.VerificationAllocationDao;

@RestController
@RequestMapping(value = { "maintenance/" })
public class VerificationAllocationRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	VerificationAllocationDao verificationAllocationDao;

	@RequestMapping(value = "rest-verification-allocation-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVerificationAsset(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewVerificationAsset start");

		logger.info("Method :viewVerificationAsset endss");
		return verificationAllocationDao.viewVerificationAsset(orgName, orgDivision,userId);
	}
	
	@RequestMapping(value = "rest-verification-allocation-allocate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> allocateVerification(@RequestParam String assetid,String assetemp,String assigndate,String frequency, String org, String orgDiv, String userid) {
		logger.info("Method : allocateVerification starts");

		logger.info("Method : allocateVerification ends");
		return verificationAllocationDao.allocateVerification(assetid,assetemp,assigndate,frequency,org,orgDiv,userid);

	}
	
	@RequestMapping(value = "rest-verification-allocation-deallocate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVerifyAlloc(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteVerifyAlloc starts");

		logger.info("Method : deleteVerifyAlloc ends");
		return verificationAllocationDao.deleteVerifyAlloc(id, org, div);

	}
}
