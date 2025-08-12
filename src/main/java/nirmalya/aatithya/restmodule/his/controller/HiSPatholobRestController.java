package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HisPatholabDao;
import nirmalya.aatithya.restmodule.his.model.HisPatholabRestModel;
import nirmalya.aatithya.restmodule.his.model.RestHisBookingAmbulanceModel;

@RestController
@RequestMapping(value = "his/")
public class HiSPatholobRestController {
	Logger logger = LoggerFactory.getLogger(HISPatientRestController.class);

	@Autowired
	HisPatholabDao patholabDao;
	// view

	@RequestMapping(value = "rest-viewIPDOPDlist", method = { RequestMethod.GET })
	public JsonResponse<Object> viewIPDOPDlist(@RequestParam String orgName, String orgDivision, String userId, String type) {
		logger.info("Method :viewIPDOPDlist start");

		logger.info("Method :viewIPDOPDlist endss");
		return patholabDao.viewIPDOPDlist(orgName, orgDivision, userId, type);
	}

	// rest-viewPatientBloddTestName
	@RequestMapping(value = "rest-bloodtestName", method = { RequestMethod.GET })
	public JsonResponse<Object> viewbloodtestName(@RequestParam String orgName, String orgDivision, String userId,
			String id, String type) {
		logger.info("Method :viewbloodtestName start");

		logger.info("Method :viewbloodtestName endss");
		return patholabDao.viewbloodtestName(orgName, orgDivision, userId, id, type);
	}

	@PostMapping(value = "rest-saveSampleTests")
	public ResponseEntity<JsonResponse<HisPatholabRestModel>> saveSampleTests(
			@RequestBody HisPatholabRestModel addBookingAmbulance) {
		logger.info("Method :saveSampleTests starts");
		logger.info("Method :saveSampleTests endss");
		return patholabDao.saveSampleTests(addBookingAmbulance);
	}
	
	@PostMapping(value = "rest-saveTestResult")
	public ResponseEntity<JsonResponse<Object>> saveTestResult(@RequestBody DropDownModel data) {
		logger.info("Method :saveTestResult starts");
		logger.info("Method :saveTestResult endss");
		return patholabDao.saveTestResult(data);
	}
	
	@PostMapping(value = "rest-approveTestResult")
	public ResponseEntity<JsonResponse<Object>> approveTestResult(@RequestBody List<DropDownModel> data) {
		logger.info("Method :approveTestResult starts");
		logger.info("Method :approveTestResult endss");
		return patholabDao.approveTestResult(data);
	}

	// view Test Names
	@RequestMapping(value = "rest-getTestNameList", method = { RequestMethod.GET })
	public JsonResponse<Object> getTestNameList(@RequestParam String orgName, String orgDivision, String userId,
			String id) {
		logger.info("Method :getTestNameList start");

		logger.info("Method :getTestNameList endss");
		return patholabDao.getTestNameList(orgName, orgDivision, userId, id);
	}

	@RequestMapping(value = "rest-viewTestnmaelist", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTestnmaelist(@RequestParam String orgName, String orgDivision, String userId,
			String id) {
		logger.info("Method :viewTestnmaelist start");

		logger.info("Method :viewTestnmaelist endss");
		return patholabDao.viewTestnmaelist(orgName, orgDivision, userId, id);
	}
	
	@RequestMapping(value = "rest-getLabTestReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> getLabTestReportData(@RequestParam String orgName, String orgDivision, String userId,
			String id) {
		logger.info("Method :getLabTestReportData start");
		
		logger.info("Method :getLabTestReportData endss");
		return patholabDao.getLabTestReportDataDao(orgName, orgDivision, userId, id);
	}

	@RequestMapping(value = "rest-testInvoice", method = { RequestMethod.GET })
	public JsonResponse<Object> testInvoice(@RequestParam String orgName, String orgDivision, String userId,
			String id) {
		logger.info("Method :testInvoice start");

		logger.info("Method :testInvoice endss");
		return patholabDao.testInvoice(orgName, orgDivision, userId, id);
	}

	@PostMapping(value = "rest-savetestNames")
	public ResponseEntity<JsonResponse<List<HisPatholabRestModel>>> saveSampleTests(
			@RequestBody List<HisPatholabRestModel> addBookingAmbulance) {
		logger.info("Method :savetestNames starts");
		logger.info("Method :savetestNames endss");
		return patholabDao.savetestNames(addBookingAmbulance);
	}

	@PostMapping(value = "rest-saveActualValue")
	public ResponseEntity<JsonResponse<List<HisPatholabRestModel>>> saveActualValue(
			@RequestBody List<HisPatholabRestModel> saveActualValue) {
		logger.info("Method :saveActualValue starts");
		logger.info("Method :saveActualValue endss");
		return patholabDao.saveActualValue(saveActualValue);
	}

	@RequestMapping(value = "view-patient-report-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> patientreportpdf(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :patientreportpdf start");

		logger.info("Method :patientreportpdf endss");
		return patholabDao.patientreportpdf(id, org, orgDiv);

	}
}