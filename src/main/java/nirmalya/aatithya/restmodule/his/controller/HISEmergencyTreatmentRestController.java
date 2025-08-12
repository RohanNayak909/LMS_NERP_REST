package nirmalya.aatithya.restmodule.his.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISEmergenecyTreatmentDao;
import nirmalya.aatithya.restmodule.his.model.HISTreatmentRestModel;

@RestController
@RequestMapping(value = "his/")
public class HISEmergencyTreatmentRestController {

	Logger logger = LoggerFactory.getLogger(HISEmergencyTreatmentRestController.class);

	@Autowired
	HISEmergenecyTreatmentDao treatmentEmerDao;
	
	/* add */

	@RequestMapping(value = "rest-emergency-treatment-add", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addEmergencyTreatment(@RequestBody HISTreatmentRestModel restData) {
		logger.info("Method : addEmergencyTreatment starts"/* +restData */);

		logger.info("Method : addEmergencyTreatment ends");
		return treatmentEmerDao.addEmergencyTreatment(restData);
	}
	
	@RequestMapping(value = "viewEmergencyTreatmentLists", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEmergencyLists(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :viewEmergencyLists start...");
		logger.info("Method :viewEmergencyLists ends...");
		return treatmentEmerDao.viewEmergencyLists(orgName, orgDivision, userId, fromDate, toDate);
	}
	
	@RequestMapping(value = "rest-emergency-test", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addEmergencyTest(@RequestBody HISTreatmentRestModel restData) {
		logger.info("Method : addEmergencyTest starts"/* +restData */);

		logger.info("Method : addEmergencyTest ends");
		return treatmentEmerDao.addEmergencyTest(restData);
	}

	@RequestMapping(value = "viewEmergencyTestLists", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEmergencyTestLists(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :viewEmergencyTestLists start...");
		logger.info("Method :viewEmergencyTestLists ends...");
		return treatmentEmerDao.viewEmergencyTestLists(orgName, orgDivision, userId, fromDate, toDate);
	}
}
