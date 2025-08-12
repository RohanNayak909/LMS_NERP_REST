package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISPrescriptionRestDao;
import nirmalya.aatithya.restmodule.his.model.HISPrescriptionRestModel;

@RestController
@RequestMapping(value = "his/")
public class HISPrescriptionRestController {

	Logger logger = LoggerFactory.getLogger(HISPrescriptionRestController.class);

	@Autowired
	HISPrescriptionRestDao prescriptionRestDao;

	@RequestMapping(value = "rest-viewPrescription", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPrescription(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method :viewPrescription start");
		logger.info("Method :viewPrescription endss");
		return prescriptionRestDao.viewPrescription(orgName, orgDivision, fromdate, todate);
	}
	
	@GetMapping(value = "viewPrescriptionEdit")
	public List<HISPrescriptionRestModel> viewPrescriptionEdit(@RequestParam String id) {
		logger.info("Method : viewPrescriptionEdit starts");
		// System.out.println(id);
		logger.info("Method : viewPrescriptionEdit endss");
		return prescriptionRestDao.viewPrescriptionEdit(id);
	}
	
	@GetMapping(value = "prescription-pdfData")
	public ResponseEntity<JsonResponse<List<HISPrescriptionRestModel>>> prescriptionData(
			@RequestParam String appointmentId) {
		logger.info("Method :prescriptionData starts" + appointmentId);

		logger.info("Method :prescriptionData ends" + appointmentId);
		return prescriptionRestDao.prescriptionData(appointmentId);
	}
}
