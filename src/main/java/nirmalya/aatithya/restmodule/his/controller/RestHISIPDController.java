package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;
import java.util.Map;

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
import nirmalya.aatithya.restmodule.his.dao.RestHISIPDDao;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@RestController
@RequestMapping(value = "his/")
public class RestHISIPDController {

	Logger logger = LoggerFactory.getLogger(RestHISIPDController.class);

	@Autowired
	RestHISIPDDao restHISIPDDao;

	@GetMapping(value = "getPatientDataList")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getPatientDataList(@RequestParam String id) {
		logger.info("Method : Rest getPatientDataList starts");

		logger.info("Method :Rest getPatientDataList ends");
		return restHISIPDDao.getPatientDataList(id);
	}

	@RequestMapping(value = "/restAddIpd", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addIpd(@RequestBody HISPatientRestModel patientRestModel) {
		logger.info("Method : addIpd starts");

		logger.info("Method : addIpd ends");
		return restHISIPDDao.addIpd(patientRestModel);
	}

	@RequestMapping(value = "bedList", method = { RequestMethod.GET })
	public List<DropDownModel> bedList() {

		logger.info("Method : bedList starts");
		logger.info("Method : bedList ends");

		return restHISIPDDao.bedList();
	}

	@RequestMapping(value = "wardList", method = { RequestMethod.GET })
	public List<DropDownModel> wardList() {

		logger.info("Method : wardList starts");
		logger.info("Method : wardList ends");

		return restHISIPDDao.wardList();
	}

	@RequestMapping(value = "procedureList", method = { RequestMethod.GET })
	public List<DropDownModel> procedureList() {

		logger.info("Method : procedureList starts");
		logger.info("Method : procedureList ends");

		return restHISIPDDao.procedureList();
	}

	@RequestMapping(value = "rest-viewIpd", method = { RequestMethod.GET })
	public JsonResponse<Object> viewIpd(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewIpd start");

		logger.info("Method :viewIpd endss");
		return restHISIPDDao.viewIpd(orgName, orgDivision, userId);
	}

	@RequestMapping(value = "rest-editIpd", method = { RequestMethod.GET })
	public JsonResponse<Object> editIpd(@RequestParam String id, @RequestParam String orgName, String orgDivision,
			String userId) {
		logger.info("Method :editIpd start");

		logger.info("Method :editIpd endss");
		return restHISIPDDao.editIpd(id, orgName, orgDivision, userId);
	}

	@RequestMapping(value = "deleteIpd", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIpd(@RequestParam String id) {
		logger.info("Method : deleteIpd starts");

		logger.info("Method : deleteIpd ends");
		return restHISIPDDao.deleteIpd(id);
	}

	@RequestMapping(value = "/restAddIpdPatient", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addIpdPatient(@RequestBody HISPatientRestModel patientRestModel) {
		logger.info("Method : addIpdPatient starts");

		logger.info("Method : addIpdPatient ends");
		return restHISIPDDao.addIpdPatient(patientRestModel);
	}

	// getPatientBedList

	@RequestMapping(value = "getPatientBedList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPatientBedList(@RequestParam String id) {
		logger.info("Method : getPatientBedList starts");
		logger.info("Method : getPatientBedList ends");
		return restHISIPDDao.getPatientBedList(id);
	}

	@RequestMapping(value = "doctordepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> doctordepartmentList() {

		logger.info("Method : doctordepartmentList starts");
		logger.info("Method : doctordepartmentList ends");

		return restHISIPDDao.doctordepartmentList();
	}

	@RequestMapping(value = "getRelationList", method = { RequestMethod.GET })
	public List<DropDownModel> getRelationList() {

		logger.info("Method : getRelationList starts");
		logger.info("Method : getRelationList ends");

		return restHISIPDDao.getRelationList();
	}

	@RequestMapping(value = "getinsuranceList", method = { RequestMethod.GET })
	public List<DropDownModel> getinsuranceList() {

		logger.info("Method : getinsuranceList starts");
		logger.info("Method : getinsuranceList ends");

		return restHISIPDDao.getinsuranceList();
	}

	// getDietMenu
	@RequestMapping(value = "rest-getDietMenu", method = { RequestMethod.GET })
	public JsonResponse<Object> getDietMenu(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getDietMenu start");

		logger.info("Method :getDietMenu endss");
		return restHISIPDDao.getDietMenu(orgName, orgDivision);
	}

	// viewAllDetailsByIPDID
	@RequestMapping(value = "rest-ipd-viewAllDetailsByIPDID", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAllDetailsByIPDID(@RequestParam String orgName, String orgDivision, String userId,
			String patientId, String ipdId) {
		logger.info("Method :viewAllDetailsByIPDID start");

		logger.info("Method :viewAllDetailsByIPDID endss");
		return restHISIPDDao.viewAllDetailsByIPDID(orgName, orgDivision, userId, patientId, ipdId);
	}

	// save treatment
	@PostMapping(value = "rest-his-ipd-save-treatment-details")
	public ResponseEntity<JsonResponse<Object>> saveTreatmentDetails(
			@RequestBody List<Map<String, Object>> treatmentDataList, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveTreatmentDetails starts");
		logger.info("Method :saveTreatmentDetails endss");
		return restHISIPDDao.saveTreatmentDetails(treatmentDataList, userId, org, orgDiv);
	}

	// vital save

	@RequestMapping(value = "/rest-his-ipd-save-vital-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveVitalDetails(@RequestBody HISPatientRestModel patientRestModel) {
		logger.info("Method : saveVitalDetails starts");

		logger.info("Method : saveVitalDetails ends");
		return restHISIPDDao.saveVitalDetails(patientRestModel);
	}

	// vital edit

	@RequestMapping(value = "rest-his-ipd-editVital", method = { RequestMethod.GET })
	public JsonResponse<Object> editVital(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editVital start");
		logger.info("Method :editVital endss");
		return restHISIPDDao.editVital(Id, organization, orgDivision);
	}

	// save diet
	@PostMapping(value = "rest-his-ipd-save-diet")
	public ResponseEntity<JsonResponse<Object>> saveDietDetails(@RequestBody List<Map<String, Object>> dietDataList,
			@RequestParam String userId, String org, String orgDiv) {
		logger.info("Method :saveDietDetails starts");
		logger.info("Method :saveDietDetails endss");
		return restHISIPDDao.saveDietDetails(dietDataList, userId, org, orgDiv);
	}

	// edit diet
	@RequestMapping(value = "his-ipd-edit-diet", method = { RequestMethod.GET })
	public JsonResponse<Object> editDiet(@RequestParam String id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editDiet start");

		logger.info("Method :editDiet endss");
		return restHISIPDDao.editDiet(id, organization, orgDivision);
	}

	// save test
	@PostMapping(value = "rest-his-ipd-save-test")
	public ResponseEntity<JsonResponse<Object>> saveTestDetails(@RequestBody List<Map<String, Object>> testDataList,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveTestDetails starts");
		logger.info("Method :saveTestDetails endss");
		return restHISIPDDao.saveTestDetails(testDataList, userId, org, orgDiv);
	}

	// rest-ipd-ot-details
	@PostMapping(value = "rest-his-ipd-save-ot")
	public ResponseEntity<JsonResponse<Object>> saveOpdOt(@RequestBody String otData, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveOpdOt starts");
		logger.info("Method :saveOpdOt endss");
		return restHISIPDDao.saveIpdOt(otData, userId, org, orgDiv);
	}

	@RequestMapping(value = "rest-get-bed-lists", method = { RequestMethod.GET })
	public JsonResponse<Object> restGetBedLists(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :restGetBedLists start");

		logger.info("Method :restGetBedLists endss");
		return restHISIPDDao.restGetBedLists(org, orgDiv);
	}

	// rest-save-opd-symp-details
	@PostMapping(value = "rest-save-ipd-symp-details")
	public ResponseEntity<JsonResponse<Object>> saveSympsDetail(@RequestBody String sympData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveSympsDetail starts");
		logger.info("Method :saveSympsDetail endss");
		return restHISIPDDao.saveSympsDetail(sympData, userId, org, orgDiv);
	}

	@RequestMapping(value = "rest-ipd-manage-edit-sympt", method = { RequestMethod.GET })
	public JsonResponse<Object> editSympt(@RequestParam String orgName, String orgDivision, String symptomsId) {
		logger.info("Method :rest editSympt start");
		logger.info("Method :rest editSympt endss");
		return restHISIPDDao.editSympt(orgName, orgDivision, symptomsId);
	}

	@RequestMapping(value = "rest-ipd-view-treatment-his", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTreatmentHistory(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String patientId, @RequestParam String ipdId) {
		logger.info("Method :viewTreatmentHistory start");
		logger.info("Method :viewTreatmentHistory endss");
		return restHISIPDDao.viewTreatmentHistory(orgName, orgDivision, patientId, ipdId);
	}

	@RequestMapping(value = "rest-ipd-view-test-his", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTestHistory(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String patientId, @RequestParam String ipdId) {
		logger.info("Method :viewTestHistory start");
		logger.info("Method :viewTestHistory endss");
		return restHISIPDDao.viewTestHistory(orgName, orgDivision, patientId, ipdId);
	}

}
