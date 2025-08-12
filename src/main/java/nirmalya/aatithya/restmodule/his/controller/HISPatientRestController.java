package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISPatientDao;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.his.model.RegsPatientModel;

@RestController
@RequestMapping(value = "his/")
public class HISPatientRestController {

	Logger logger = LoggerFactory.getLogger(HISPatientRestController.class);

	@Autowired
	HISPatientDao patientDao;

	// genderList

	@RequestMapping(value = "genderList", method = { RequestMethod.GET })
	public List<DropDownModel> genderList() {

		logger.info("Method : genderList starts");
		logger.info("Method : genderList ends");

		return patientDao.genderList();
	}

	// maritalstatusList

	@RequestMapping(value = "maritalstatusList", method = { RequestMethod.GET })
	public List<DropDownModel> maritalstatusList() {

		logger.info("Method : maritalstatusList starts");
		logger.info("Method : maritalstatusList ends");

		return patientDao.maritalstatusList();
	}

	// nationalityList

	@RequestMapping(value = "nationalityList", method = { RequestMethod.GET })
	public List<DropDownModel> nationalityList() {

		logger.info("Method : nationalityList starts");
		logger.info("Method : nationalityList ends");

		return patientDao.nationalityList();
	}

	// countryList

	@RequestMapping(value = "countryList", method = { RequestMethod.GET })
	public List<DropDownModel> countryList() {

		logger.info("Method : countryList starts");
		logger.info("Method : countryList ends");

		return patientDao.countryList();
	}

	// getPatientSateList

	@RequestMapping(value = "getPatientSateList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getstateListNew(@RequestParam String id) {
		logger.info("Method : getPatientSateList starts");
		logger.info("Method : getPatientSateList ends");
		return patientDao.getPatientSateList(id);
	}
	// districtList

	@RequestMapping(value = "districtList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> districtList(@RequestParam String id) {
		logger.info("Method : districtList starts");
		logger.info("Method : districtList ends");
		return patientDao.districtList(id);
	}

	// restAddPatient
	@RequestMapping(value = "/restAddPatient", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPatient(@RequestBody HISPatientRestModel patientRestModel) {
		logger.info("Method : addPatient starts");

		logger.info("Method : addPatient ends");
		return patientDao.addPatient(patientRestModel);
	}

	// rest-viewPatient
	@RequestMapping(value = "rest-viewPatient", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPatient(@RequestParam String orgName, String orgDivision, String fromDate,
			@RequestParam String toDate, @RequestParam String from) {
		logger.info("Method :viewPatient start");

		logger.info("Method :viewPatient endss");
		return patientDao.viewPatient(orgName, orgDivision, fromDate, toDate, from);
	}

	// editPatient
	@RequestMapping(value = "editPatient", method = { RequestMethod.GET })
	public JsonResponse<Object> editPatient(@RequestParam String id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editPatient start");

		logger.info("Method :editPatient endss");
		return patientDao.editPatient(id, organization, orgDivision);
	}

	// deletePatient

	@RequestMapping(value = "deletePatient", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePatient(@RequestParam String id) {
		logger.info("Method : deletePatient starts");

		logger.info("Method : deletePatient ends");
		return patientDao.deletePatient(id);
	}

	// getPatientList
	@GetMapping(value = "getPatientList")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getPatientList(@RequestParam String id) {
		logger.info("Method : Rest getPatientList starts");

		logger.info("Method :Rest getPatientList ends");
		return patientDao.getPatientList(id);
	}

	// departmentList
	@RequestMapping(value = "departmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {
		logger.info("Method : getDepartmentList starts");
		
		logger.info("Method : getDepartmentList ends");
		return patientDao.getDepartmentList();
	}

	// feeList
	@RequestMapping(value = "feeList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> feeList(@RequestParam String id,
			@RequestParam String dateOfAppoints) {
		logger.info("Method : feeList starts");
		logger.info("Method : feeList ends");
		return patientDao.feeList(id, dateOfAppoints);
	}

	// rest-patient-invoice-details
	@RequestMapping(value = "rest-patient-invoice-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getPatientInvoiceDetails(@RequestParam String pId) {
		logger.info("Method :getPatientInvoiceDetails start");

		logger.info("Method :getPatientInvoiceDetails endss");
		return patientDao.getPatientInvoiceDetails(pId);
	}

	// opd-recep-city-list
	@RequestMapping(value = "opd-recep-city-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> cityList(@RequestParam String id) {
		logger.info("Method : cityList starts");
		logger.info("Method : cityList ends");
		return patientDao.cityList(id);
	}

	// departmentList
	@RequestMapping(value = "rest-department-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> departmentList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : department list starts");
		logger.info("Method : department list ends");
		return patientDao.departmentList(id, org, orgDiv);
	}

	@RequestMapping(value = "/rest-patientRegistrationWithTestList", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> patientRegistrationWithTestList(@RequestBody RegsPatientModel data) {
		logger.info("Method : patientRegistrationWithTestList starts");

		logger.info("Method : patientRegistrationWithTestList ends");
		return patientDao.patientRegistrationWithTestList(data);
	}
	
	@RequestMapping(value = "/rest-patientDetailsWithTestList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> patientDetailsWithTestList(@RequestParam String id,@RequestParam String type,@RequestParam String org,@RequestParam String orgDiv) {
		logger.info("Method : patientDetailsWithTestList starts");
		
		logger.info("Method : patientDetailsWithTestList ends");
		return patientDao.patientDetailsWithTestList(id,type,org,orgDiv);
	}
	
	@RequestMapping(value = "/rest-paymentProceed", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> paymentProceed(@RequestBody DropDownModel data) {
		logger.info("Method : paymentProceed starts");

		logger.info("Method : paymentProceed ends");
		return patientDao.paymentProceed(data);
	}
}
