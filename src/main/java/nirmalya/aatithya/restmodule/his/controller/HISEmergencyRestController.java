package nirmalya.aatithya.restmodule.his.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISEmergencyDao;
import nirmalya.aatithya.restmodule.his.dao.HISOPDDao;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@RestController
@RequestMapping(value = "his/")
public class HISEmergencyRestController {

	Logger logger = LoggerFactory.getLogger(HISEmergencyRestController.class);

	@Autowired
	HISEmergencyDao emergencyDao;

	// rest-emergencyDetails
	@RequestMapping(value = "rest-emergencyDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getemErgencyDetails(@RequestParam String orgName, String orgDivision,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method :getemErgencyDetails start");
		logger.info("Method :getemErgencyDetails endss");
		return emergencyDao.getemErgencyDetails(orgName, orgDivision, fromdate, todate);
	}

	@GetMapping(value = "emergencyStatus")
	public JsonResponse<HISPatientRestModel> emergencyStatus(@RequestParam String approval, String emerId,
			String approvedBy) {
		logger.info("Method : emergencyStatus starts");

		logger.info("Method : emergencyStatus ends");
		return emergencyDao.emergencyStatus(approval, emerId, approvedBy);
	}
}
