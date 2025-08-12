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
import nirmalya.aatithya.restmodule.qa.dao.QaFatSolAnalysisDao;
import nirmalya.aatithya.restmodule.qa.dao.QaPcaAnalysisDao;
import nirmalya.aatithya.restmodule.qa.dao.QaRCFTMDao;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestFatSolAnalysisModel;

@RestController
@RequestMapping(value = { "qa/" })
public class QaFatSolubilityAnalysisRestController {

	Logger logger = LoggerFactory.getLogger(QaFatSolubilityAnalysisRestController.class);

	@Autowired
	QaFatSolAnalysisDao qaFatSolAnalysisDao;

	// add 
	@PostMapping(value = "saveFatSolubilityAnalysisRecord")
	public ResponseEntity<JsonResponse<Object>> saveFatSolubilityAnalysisRecord(@RequestBody RestFatSolAnalysisModel model) {
		logger.info("Method : saveFatSolubilityAnalysisRecord starts");

		logger.info("Method : saveFatSolubilityAnalysisRecord ends");
		return qaFatSolAnalysisDao.saveFatSolubilityAnalysisRecord(model);
	}

	// getTotalCrqsView
	@RequestMapping(value = "getTotalFatSolAnalysisView", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalFatSolAnalysisView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalFatSolAnalysisView start");

		logger.info("Method :getTotalFatSolAnalysisView endss");
		return qaFatSolAnalysisDao.getTotalFatSolAnalysisView(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-editFatSolAnalysisRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> editFatSolAnalysisRecord(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editFatSolAnalysisRecord start");

		logger.info("Method :editFatSolAnalysisRecord endss");
		return qaFatSolAnalysisDao.editFatSolAnalysisRecord(id, orgName, orgDivision);
	}

	// delete
	@RequestMapping(value = "rest-deleteFatSolAnalysisRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteFatSolAnalysisRecord(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteFatSolAnalysisRecord starts");

		logger.info("Method : deleteFatSolAnalysisRecord ends");
		return qaFatSolAnalysisDao.deleteFatSolAnalysisRecord(id, org, orgDiv);

	}

	// restapprove
	@RequestMapping(value = "rest-approveFatSolAnalysisRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveFatSolAnalysisRecord(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveFatSolAnalysisRecord starts");
		System.out.println("ORGANISATION DIVISION" + orgDiv);
		logger.info("Method : approveFatSolAnalysisRecord ends");
		return qaFatSolAnalysisDao.approveFatSolAnalysisRecord(id, org, orgDiv);

	}
//
	//PDF
		@RequestMapping(value = "rest-fatSolAnalysisPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> fatSolAnalysisPdf(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :fatSolAnalysisPdf start");

			logger.info("Method :fatSolAnalysisPdf endss");
			return qaFatSolAnalysisDao.fatSolAnalysisPdf(id,orgName,orgDivision);

		}
}