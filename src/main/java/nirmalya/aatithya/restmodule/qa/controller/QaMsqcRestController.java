package nirmalya.aatithya.restmodule.qa.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.qa.dao.QaCrqsCheckDao;
import nirmalya.aatithya.restmodule.qa.dao.QaMsqcDao;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsCheckRestModel;

@RestController
@RequestMapping(value = { "production/" })
public class QaMsqcRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	QaMsqcDao qaMsqcDao;

	// addCrqs
	@PostMapping(value = "rest-msqc1-details-add")
	public ResponseEntity<JsonResponse<List<QaCrqsCheckRestModel>>> addCrqs(

			@RequestBody List<QaCrqsCheckRestModel> qaCrqsRestModel) {
		logger.info("Method : restaddQc starts");
		logger.info("Method : restaddQc ends");
		return qaMsqcDao.addCrqsCheck(qaCrqsRestModel);
	}
	// getTotalCrqsView
	@RequestMapping(value = "rest-msqc1-details-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalCrqsView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalCrqsView start");

		logger.info("Method :getTotalCrqsView endss");
		return qaMsqcDao.getTotalCrqsView(orgName, orgDivision);
	}
			
	// downloadCrqs
	@RequestMapping(value = "rest-msqc1-reqst-download", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadCrqs(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editCrqs start");

		logger.info("Method :editCrqs endss");
		return qaMsqcDao.downloadCrqs(id, orgName, orgDivision);
	}
	// editCrqs
	@RequestMapping(value = "rest-msqc1-reqst-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editCrqs(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :editCrqs start");

			logger.info("Method :editCrqs endss");
			return qaMsqcDao.editCrqs(id, orgName, orgDivision);
	}
			
	// deleteCrqs
	@RequestMapping(value = "rest-msqc1-detls-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCrqs(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteCrqs starts");

		logger.info("Method : deleteCrqs ends");
		return qaMsqcDao.deleteCrqs(id, org, orgDiv);

	}
	// restapproveCrqs
	@RequestMapping(value = "rest-msqc1-detls-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restapproveCrqs(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : restapproveCrqs starts");
		System.out.println("ORGANISATION DIVISION"+orgDiv);
		logger.info("Method : restapproveCrqs ends");
		return qaMsqcDao.approveCrqs(id, org, orgDiv);

	}

}
