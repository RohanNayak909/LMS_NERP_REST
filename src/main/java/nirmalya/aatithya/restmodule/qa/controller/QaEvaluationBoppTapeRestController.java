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
import nirmalya.aatithya.restmodule.qa.dao.QaEvaluationBoppTapeDao;
import nirmalya.aatithya.restmodule.qa.dao.QaPcaAnalysisDao;
import nirmalya.aatithya.restmodule.qa.dao.QaRCFTMDao;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaEvaluationBoppTapeModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestAshAnalysisRawDataModel;

@RestController
@RequestMapping(value = { "qa/" })
public class QaEvaluationBoppTapeRestController {

	Logger logger = LoggerFactory.getLogger(QaEvaluationBoppTapeRestController.class);

	@Autowired
	QaEvaluationBoppTapeDao qaEvaluationBoppTapeDao;

	// getAggridData
	@RequestMapping(value = "rest-evaluation-bopp-tape-aggrid-show", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridDataForevaluation(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAggridDataForevaluation start");

		logger.info("Method :getAggridDataForevaluation endss");
		return qaEvaluationBoppTapeDao.getAggridDataForevaluation(orgName, orgDivision);
	}

	// add
	@PostMapping(value = "rest-addEvaluation")
	public ResponseEntity<JsonResponse<List<QaEvaluationBoppTapeModel>>> addEvaluation(

			@RequestBody List<QaEvaluationBoppTapeModel> qaModel) {
		logger.info("Method : addEvaluation starts");
		logger.info("Method : addEvaluation ends");
		return qaEvaluationBoppTapeDao.addEvaluation(qaModel);
	}

	// getTotalCrqsView
	@RequestMapping(value = "getTotalEvaluationBoppTapeView", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalEvaluationBoppTapeView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalEvaluationBoppTapeView start");

		logger.info("Method :getTotalEvaluationBoppTapeView endss");
		return qaEvaluationBoppTapeDao.getTotalEvaluationBoppTapeView(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-editEvaluationBoppTapeRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> editEvaluationBoppTapeRecord(@RequestParam String id, String orgName,
			String orgDivision) {
		logger.info("Method :editEvaluationBoppTapeRecord start");

		logger.info("Method :editEvaluationBoppTapeRecord endss");
		return qaEvaluationBoppTapeDao.editEvaluationBoppTapeRecord(id, orgName, orgDivision);
	}

	// delete
	@RequestMapping(value = "rest-deleteEvaluationBoppTapeRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteEvaluationBoppTapeRecord(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : deleteEvaluationBoppTapeRecord starts");

		logger.info("Method : deleteEvaluationBoppTapeRecord ends");
		return qaEvaluationBoppTapeDao.deleteEvaluationBoppTapeRecord(id, org, orgDiv);

	}

	// restapprove
	@RequestMapping(value = "rest-approveEvaluationBoppTapeRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveEvaluationBoppTapeRecord(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : approveEvaluationBoppTapeRecord starts");
		System.out.println("ORGANISATION DIVISION" + orgDiv);
		logger.info("Method : approveEvaluationBoppTapeRecord ends");
		return qaEvaluationBoppTapeDao.approveEvaluationBoppTapeRecord(id, org, orgDiv);

	}
	
	
	// Pdf
	
	
	@RequestMapping(value = "rest-getPdfDetailsBoppTape", method = { RequestMethod.GET })
	public JsonResponse<Object> getPdfDetailsBoppTape(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getPdfDetailsBoppTape start");

		logger.info("Method :getPdfDetailsBoppTape endss");
		return qaEvaluationBoppTapeDao.getPdfDetailsBoppTape(id, orgName, orgDivision);
	}
}