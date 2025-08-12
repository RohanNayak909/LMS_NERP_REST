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
import nirmalya.aatithya.restmodule.qa.dao.QaPcaAnalysisDao;
import nirmalya.aatithya.restmodule.qa.dao.QaRCFTMDao;
import nirmalya.aatithya.restmodule.qa.dao.QaSampleReceivingAnalysisDao;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaEvaluationBoppTapeModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestAshAnalysisRawDataModel;

@RestController
@RequestMapping(value = { "qa/" })
public class QaSampleReceivingAnalysisRestController {

	Logger logger = LoggerFactory.getLogger(QaSampleReceivingAnalysisRestController.class);

	@Autowired
	QaSampleReceivingAnalysisDao qaSampleReceivingAnalysisDao;

	// getAggridData
	@RequestMapping(value = "rest-sample-receiving-analysis-aggrid-show", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridDataForSample(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAggridDataForSample start");

		logger.info("Method :getAggridDataForSample endss");
		return qaSampleReceivingAnalysisDao.getAggridDataForSample(orgName, orgDivision);
	}

	// add
	@PostMapping(value = "rest-addSamplereceiving")
	public ResponseEntity<JsonResponse<List<QaEvaluationBoppTapeModel>>> addSamplereceiving(

			@RequestBody List<QaEvaluationBoppTapeModel> qaModel) {
		logger.info("Method : addSamplereceiving starts");
		logger.info("Method : addSamplereceiving ends");
		return qaSampleReceivingAnalysisDao.addSamplereceiving(qaModel);
	}

	 // getTotalCrqsView
	@RequestMapping(value = "getTotalSamplereceivingView", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalSamplereceivingView(@RequestParam String orgName, String orgDivision , String type) {
		logger.info("Method :getTotalSamplereceivingView start");

		logger.info("Method :getTotalSamplereceivingView endss");
		return qaSampleReceivingAnalysisDao.getTotalSamplereceivingView(orgName, orgDivision, type);
	}

		// edit
	@RequestMapping(value = "rest-editSamplereceivingViewRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> editSamplereceivingViewRecord(@RequestParam String id, String orgName,
			String orgDivision) {
		logger.info("Method :editSamplereceivingViewRecord start");

		logger.info("Method :editSamplereceivingViewRecord endss");
		return qaSampleReceivingAnalysisDao.editSamplereceivingViewRecord(id, orgName, orgDivision);
	}

	// delete
	@RequestMapping(value = "rest-deleteSamplereceivingRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSamplereceivingRecord(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : deleteSamplereceivingRecord starts");

		logger.info("Method : deleteSamplereceivingRecord ends");
		return qaSampleReceivingAnalysisDao.deleteSamplereceivingRecord(id, org, orgDiv);

	}

	// restapprove
	@RequestMapping(value = "rest-approveSamplereceivingRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveSamplereceivingRecord(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : approveSamplereceivingRecord starts");
		System.out.println("ORGANISATION DIVISION" + orgDiv);
		logger.info("Method : approveSamplereceivingRecord ends");
		return qaSampleReceivingAnalysisDao.approveSamplereceivingRecord(id, org, orgDiv);

	}
	//PDF
		@RequestMapping(value = "rest-sampleReceivingAnalysisPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> sampleReceivingAnalysisRecord(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :sampleReceivingAnalysisRecord start");

			logger.info("Method :sampleReceivingAnalysisRecord endss");
			return qaSampleReceivingAnalysisDao.sampleReceivingAnalysisRecord(id,orgName,orgDivision);

		}
}