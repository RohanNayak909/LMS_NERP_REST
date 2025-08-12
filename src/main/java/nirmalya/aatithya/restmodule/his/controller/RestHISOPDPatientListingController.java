package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.RestOPDPatientPatientDao;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@RestController
@RequestMapping(value = "his/")
public class RestHISOPDPatientListingController {


	Logger logger = LoggerFactory.getLogger(RestHISOPDPatientListingController.class);

	@Autowired
	RestOPDPatientPatientDao restOPDPatientPatientDao;
	
	@GetMapping(value = "getListingPatientList")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getListingPatientList(@RequestParam String userId) {
		logger.info("Method :getListingPatientList starts");

		logger.info("Method :getListingPatientList endss");
		return restOPDPatientPatientDao.getListingPatientList(userId);

	}
	
	@GetMapping(value = "getEmergencyPatient")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getEmergencyPatient(@RequestParam String userId) {
		logger.info("Method :getEmergencyPatient starts");

		logger.info("Method :getEmergencyPatient endss");
		return restOPDPatientPatientDao.getEmergencyPatient(userId);

	}
}
