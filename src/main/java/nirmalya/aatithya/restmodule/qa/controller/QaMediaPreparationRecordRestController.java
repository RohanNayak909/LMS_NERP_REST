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
import nirmalya.aatithya.restmodule.qa.dao.QaMediaPreparationDao;
import nirmalya.aatithya.restmodule.qa.dao.QaPcaAnalysisDao;
import nirmalya.aatithya.restmodule.qa.dao.QaRCFTMDao;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaEvaluationBoppTapeModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestAshAnalysisRawDataModel;

@RestController
@RequestMapping(value = { "qa/" })
public class QaMediaPreparationRecordRestController {

	Logger logger = LoggerFactory.getLogger(QaMediaPreparationRecordRestController.class);

	@Autowired
	QaMediaPreparationDao qaMediaPreparationDao;

	// getAggridData
	@RequestMapping(value = "rest-media-preparation-record-aggrid-show", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridDataForMedia(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAggridDataForMedia start");

		logger.info("Method :getAggridDataForMedia endss");
		return qaMediaPreparationDao.getAggridDataForMedia(orgName, orgDivision);
	}

	// add
	@PostMapping(value = "rest-addMediaPreparation")
	public ResponseEntity<JsonResponse<List<QaEvaluationBoppTapeModel>>> addMediaPreparation(

			@RequestBody List<QaEvaluationBoppTapeModel> qaModel) {
		logger.info("Method : addMediaPreparation starts");
		logger.info("Method : addMediaPreparation ends");
		return qaMediaPreparationDao.addMediaPreparation(qaModel);
	}

	 // getTotalCrqsView
	@RequestMapping(value = "getTotalMediaPreparationView", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalMediaPreparationView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalMediaPreparationView start");

		logger.info("Method :getTotalMediaPreparationView endss");
		return qaMediaPreparationDao.getTotalMediaPreparationView(orgName, orgDivision);
	}

		// edit
	@RequestMapping(value = "rest-editMediaPreparationViewRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> editMediaPreparationViewRecord(@RequestParam String id, String orgName,
			String orgDivision) {
		logger.info("Method :editMediaPreparationViewRecord start");

		logger.info("Method :editMediaPreparationViewRecord endss");
		return qaMediaPreparationDao.editMediaPreparationViewRecord(id, orgName, orgDivision);
	}

	// delete
	@RequestMapping(value = "rest-deleteMediaPreparationRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteMediaPreparationRecord(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : deleteMediaPreparationRecord starts");

		logger.info("Method : deleteMediaPreparationRecord ends");
		return qaMediaPreparationDao.deleteMediaPreparationRecord(id, org, orgDiv);

	}

	// restapprove
	@RequestMapping(value = "rest-approveMediaPreparationRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveMediaPreparationRecord(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : approveMediaPreparationRecord starts");
		System.out.println("ORGANISATION DIVISION" + orgDiv);
		logger.info("Method : approveMediaPreparationRecord ends");
		return qaMediaPreparationDao.approveMediaPreparationRecord(id, org, orgDiv);

	}
	

	@RequestMapping(value = "rest-mediaPrepPdfDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> mediaPrepPdfDetails(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :mediaPrepPdfDetails start");

		logger.info("Method :mediaPrepPdfDetails endss");
		return qaMediaPreparationDao.mediaPrepPdfDetails(id, orgName, orgDivision);
}
	
}