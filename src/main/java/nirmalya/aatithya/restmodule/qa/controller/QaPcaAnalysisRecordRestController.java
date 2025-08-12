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
import nirmalya.aatithya.restmodule.qa.dao.QaPcaAnalysisDao;
import nirmalya.aatithya.restmodule.qa.dao.QaRCFTMDao;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;

@RestController
@RequestMapping(value = { "qa/" })
public class QaPcaAnalysisRecordRestController {

	Logger logger = LoggerFactory.getLogger(QaPcaAnalysisRecordRestController.class);

	@Autowired
	QaPcaAnalysisDao qaPcaAnalysisDao;

	// add Advance apply
	@PostMapping(value = "savePCAAnalysisRecord")
	public ResponseEntity<JsonResponse<Object>> savePCAAnalysisRecord(@RequestBody PACAnalysisRecordRestModel model) {
		logger.info("Method : savePCAAnalysisRecord starts");

		logger.info("Method : savePCAAnalysisRecord ends");
		return qaPcaAnalysisDao.savePCAAnalysisRecord(model);
	}

	// getTotalCrqsView
	@RequestMapping(value = "getTotalPcaAnalysisView", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalPcaAnalysisView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalPcaAnalysisView start");

		logger.info("Method :getTotalPcaAnalysisView endss");
		return qaPcaAnalysisDao.getTotalPcaAnalysisView(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-editAnalysisRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> editAnalysisRecord(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAnalysisRecord start");

		logger.info("Method :editAnalysisRecord endss");
		return qaPcaAnalysisDao.editAnalysisRecord(id, orgName, orgDivision);
	}

	// delete
	@RequestMapping(value = "rest-deleteAnalysisRecord", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAnalysisRecord(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteAnalysisRecord starts");

		logger.info("Method : deleteAnalysisRecord ends");
		return qaPcaAnalysisDao.deleteAnalysisRecord(id, org, orgDiv);

	}

	// restapprove
	@RequestMapping(value = "rest-approvepcaanalysis", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approvepcaanalysis(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approvepcaanalysis starts");
		System.out.println("ORGANISATION DIVISION" + orgDiv);
		logger.info("Method : approvepcaanalysis ends");
		return qaPcaAnalysisDao.approvepcaanalysis(id, org, orgDiv);

	}
//PDF
	@RequestMapping(value = "rest-pcaAnalysisRecordPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> pcaAnalysisRecord(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :pcaAnalysisRecord start");

		logger.info("Method :pcaAnalysisRecord endss");
		return qaPcaAnalysisDao.pcaAnalysisRecord(id,orgName,orgDivision);

	}
}