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
import nirmalya.aatithya.restmodule.qa.dao.QaCrqsDao;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;

@RestController
@RequestMapping(value = { "production/" })
public class QaCrqsRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	QaCrqsDao qaCrqsDao;

	// getAggridData
	@RequestMapping(value = "rest-crqs-aggrid-show", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAggridData start");

		logger.info("Method :getAggridData endss");
		return qaCrqsDao.getAggridDet(orgName, orgDivision);
	}
	
	// addCrqs
	@PostMapping(value = "rest-crqs-details-add")
	public ResponseEntity<JsonResponse<List<QaCrqsRestModel>>> addCrqs(

			@RequestBody List<QaCrqsRestModel> qaCrqsRestModel) {
		logger.info("Method : restaddQc starts");
		logger.info("Method : restaddQc ends");
		return qaCrqsDao.addCrqs(qaCrqsRestModel);
	}
	// getTotalCrqsView
			@RequestMapping(value = "rest-crqs-details-view", method = { RequestMethod.GET })
			public JsonResponse<Object> getTotalCrqsView(@RequestParam String orgName, String orgDivision) {
				logger.info("Method :getTotalCrqsView start");

				logger.info("Method :getTotalCrqsView endss");
				return qaCrqsDao.getTotalCrqsView(orgName, orgDivision);
			}
			
			// downloadCrqs
			@RequestMapping(value = "rest-crqs-reqst-download", method = { RequestMethod.GET })
			public JsonResponse<Object> downloadCrqs(@RequestParam String id, String orgName, String orgDivision) {
				logger.info("Method :editCrqs start");

				logger.info("Method :editCrqs endss");
				return qaCrqsDao.downloadCrqs(id, orgName, orgDivision);
			}
			// editCrqs
						@RequestMapping(value = "rest-crqs-reqst-edit", method = { RequestMethod.GET })
						public JsonResponse<Object> editCrqs(@RequestParam String id, String orgName, String orgDivision) {
							logger.info("Method :editCrqs start");

							logger.info("Method :editCrqs endss");
							return qaCrqsDao.editCrqs(id, orgName, orgDivision);
						}
			
			// deleteCrqs
			@RequestMapping(value = "rest-crqs-detls-delete", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<Object>> deleteCrqs(@RequestParam String id, String org, String div) {
				logger.info("Method : deleteCrqs starts");

				logger.info("Method : deleteCrqs ends");
				return qaCrqsDao.deleteCrqs(id, org, div);

			}
			// restapproveCrqs
			@RequestMapping(value = "rest-crqs-detls-approve", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<Object>> restapproveCrqs(@RequestParam String id, String org, String orgDiv) {
				logger.info("Method : restapproveCrqs starts");
				System.out.println("ORGANISATION DIVISION"+orgDiv);
				logger.info("Method : restapproveCrqs ends");
				return qaCrqsDao.approveCrqs(id, org, orgDiv);

			}
			// CrqsInspect
			@RequestMapping(value = "rest-crqs-inspect-view", method = { RequestMethod.GET })
			public JsonResponse<Object> crqsInspectView(@RequestParam String id, String orgName, String orgDivision) {
				logger.info("Method :crqsInspectView start");

				logger.info("Method :crqsInspectView endss");
				return qaCrqsDao.crqsInspectView(id, orgName, orgDivision);
			}
			// addCrqsInspect
			@PostMapping(value = "rest-crqs-inspect-add")
			public ResponseEntity<JsonResponse<List<QaCrqsRestModel>>> addCrqsInspect(

					@RequestBody List<QaCrqsRestModel> qaCrqsRestModel) {
				logger.info("Method : addCrqsInspect starts");
				logger.info("Method : addCrqsInspect ends");
				return qaCrqsDao.addingCrqsInspect(qaCrqsRestModel);
			}
			// CrqsInspect
						@RequestMapping(value = "rest-crqs-inspect-download", method = { RequestMethod.GET })
						public JsonResponse<Object> crqsInspectDownload(@RequestParam String id, String orgName, String orgDivision) {
							logger.info("Method :crqsInspectView start");

							logger.info("Method :crqsInspectView endss");
							return qaCrqsDao.CrqsInspectDownload(id, orgName, orgDivision);
						}

				
}