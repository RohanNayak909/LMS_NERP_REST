package nirmalya.aatithya.restmodule.trial.controller;

import org.slf4j.Logger;
import java.util.List;
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
import nirmalya.aatithya.restmodule.trial.dao.ManageLegalDocumentDao;
import nirmalya.aatithya.restmodule.trial.model.RestManageLegalDocumentModel;

@RestController
@RequestMapping("trial/")
public class RestManageLegalDocumentController {

	Logger logger = LoggerFactory.getLogger(RestManageLegalDocumentController.class);

	@Autowired
	ManageLegalDocumentDao manageLegalDocumentDao;

	@GetMapping(value = "dd-document-list")
	public List<DropDownModel> legaldoculist() {
		logger.info("Method : getDocumentList starts");

		logger.info("Method : getDocumentList ends");
		return manageLegalDocumentDao.legaldoculist();
	}

	@GetMapping(value = "dd-vendor-list")
	public List<DropDownModel> legalvendorlist() {
		logger.info("Method : getVendorList starts");

		logger.info("Method : getVendorList ends");
		return manageLegalDocumentDao.legalvendorlist();
	}

	@GetMapping(value = "dd-vehicle-list")
	public List<DropDownModel> legalvehiclelist() {
		logger.info("Method : getVehicleList starts");

		logger.info("Method : getVehicleList ends");
		return manageLegalDocumentDao.legalvehiclelist();
	}

	// add
	@RequestMapping(value = "rest-addLeagalData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addLegalDoc(
			@RequestBody RestManageLegalDocumentModel restManageLegalDocumentModel) {
		logger.info("Method :restlegaldoc starts");
		System.out.println(restManageLegalDocumentModel);
		logger.info("Method :restlegaldoc ends");
		return manageLegalDocumentDao.addLegalDoc(restManageLegalDocumentModel);
	}

	// view

	@RequestMapping(value = "view-LegalDocus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageLegalDocumentModel>>> legalDocDao() {
		logger.info("Method : viewLegalDoc starts");

		logger.info("Method : viewLegalDoc ends");
		return manageLegalDocumentDao.legalDocDao();
	}

	// delete
	@RequestMapping(value = "delete-LegalDoc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteLegalDoc(@RequestParam String id) {
		logger.info("Method : deleteOrganzierType starts");

		logger.info("Method : deleteOrganzierType ends");
		return manageLegalDocumentDao.deleteLegalDoc(id);
	}

	// edit
	@GetMapping(value = "edit-LegalDoc")
	public ResponseEntity<JsonResponse<RestManageLegalDocumentModel>> legalDoc(@RequestParam String id) {
		logger.info("Method : editlegalDoc starts");

		logger.info("Method :editlegalDoc ends");
		return manageLegalDocumentDao.legalDoc(id);

	}

}
