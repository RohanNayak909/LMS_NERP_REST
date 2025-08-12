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
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.qa.dao.QaAshAnalysisRawDataDao;
import nirmalya.aatithya.restmodule.qa.dao.QaPcaAnalysisDao;
import nirmalya.aatithya.restmodule.qa.dao.QaRCFTMDao;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestAshAnalysisRawDataModel;

@RestController
@RequestMapping(value = { "qa/" })
public class QaAshAnalysisRawdataRestController {

	Logger logger = LoggerFactory.getLogger(QaAshAnalysisRawdataRestController.class);

	@Autowired
	QaAshAnalysisRawDataDao qaAshAnalysisRawDataDao;

	// add 
	@PostMapping(value = "saveAshAnalysisRawDataRecord")
	public ResponseEntity<JsonResponse<Object>> saveAshAnalysisRawDataRecord(@RequestBody RestAshAnalysisRawDataModel model) {
		logger.info("Method : saveAshAnalysisRawDataRecord starts");

		logger.info("Method : saveAshAnalysisRawDataRecord ends");
		return qaAshAnalysisRawDataDao.saveAshAnalysisRawDataRecord(model);
	}

	// getTotalCrqsView
	@RequestMapping(value = "getTotalAshAnalysisRawView", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalAshAnalysisRawView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalAshAnalysisRawView start");

		logger.info("Method :getTotalAshAnalysisRawView endss");
		return qaAshAnalysisRawDataDao.getTotalAshAnalysisRawView(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-editAshAnalysisRawRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> editAshAnalysisRawRecord(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAshAnalysisRawRecord start");

		logger.info("Method :editAshAnalysisRawRecord endss");
		return qaAshAnalysisRawDataDao.editAshAnalysisRawRecord(id, orgName, orgDivision);
	}

	// delete
	@RequestMapping(value = "rest-deleteAshAnalysisRawRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAshAnalysisRawRecord(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteAshAnalysisRawRecord starts");

		logger.info("Method : deleteAshAnalysisRawRecord ends");
		return qaAshAnalysisRawDataDao.deleteAshAnalysisRawRecord(id, org, orgDiv);

	}

	// restapprove
	@RequestMapping(value = "rest-approveAshAnalysisRawRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAshAnalysisRawRecord(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveAshAnalysisRawRecord starts");
		System.out.println("ORGANISATION DIVISION" + orgDiv);
		logger.info("Method : approveAshAnalysisRawRecord ends");
		return qaAshAnalysisRawDataDao.approveAshAnalysisRawRecord(id, org, orgDiv);

	}
//
	//PDF
		@RequestMapping(value = "rest-ashAnalysisReordPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> ashAnalysisReordPdf(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :ashAnalysisReordPdf start");

			logger.info("Method :ashAnalysisReordPdf endss");
			return qaAshAnalysisRawDataDao.ashAnalysisReordPdf(id,orgName,orgDivision);

		}
}