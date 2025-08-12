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
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.qa.dao.QaRCFTMDao;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;

@RestController
@RequestMapping(value = { "qa/" })
public class QaRunChartTempMonitoringRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	QaRCFTMDao qaRCFTMDao;

	// getAggridData
	@RequestMapping(value = "rest-rcftm-aggrid-show", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridDataForrcftm(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAggridDataForrcftm start");

		logger.info("Method :getAggridDataForrcftm endss");
		return qaRCFTMDao.getAggridDataForrcftm(orgName, orgDivision);
	}

	// addCrqs
	@PostMapping(value = "rest-rcftm-details-addRCFTM")
	public ResponseEntity<JsonResponse<List<QaRCFTMRestModel>>> addRCFTM(

			@RequestBody List<QaRCFTMRestModel> qaRCFTMRestModel) {
		logger.info("Method : addRCFTM starts");
		logger.info("Method : addRCFTM ends");
		return qaRCFTMDao.addRCFTM(qaRCFTMRestModel);
	}

	// getTotalCrqsView
	@RequestMapping(value = "rest-rcftm-details-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalRCFTMViewView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalRCFTMViewView start");

		logger.info("Method :getTotalRCFTMViewView endss");
		return qaRCFTMDao.getTotalRCFTMViewView(orgName, orgDivision);
	}

	// downloadCrqs
	@RequestMapping(value = "rest-rcftm-reqst-download", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadCrqs(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editCrqs start");

		logger.info("Method :editCrqs endss");
		return qaRCFTMDao.downloadCrqs(id, orgName, orgDivision);
	}

	// editCrqs
	@RequestMapping(value = "rest-rcftm-reqst-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editCodeRCFTM(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editCodeRCFTM start");

		logger.info("Method :editCodeRCFTM endss");
		return qaRCFTMDao.editCodeRCFTM(id, orgName, orgDivision);
	}

	// deleteCrqs
	@RequestMapping(value = "rest-rcftm-detls-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRCFTM(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteRCFTM starts");

		logger.info("Method : deleteRCFTM ends");
		return qaRCFTMDao.deleteRCFTM(id, org, orgDiv);

	}

	// restapproveCrqs
	@RequestMapping(value = "rest-rcftm-detls-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restapproveRCFTM(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : restapproveRCFTM starts");
		System.out.println("ORGANISATION DIVISION" + orgDiv);
		logger.info("Method : restapproveRCFTM ends");
		return qaRCFTMDao.restapproveRCFTM(id, org, orgDiv);

	}

	// CrqsInspect
	@RequestMapping(value = "rest-rcftm-inspect-view", method = { RequestMethod.GET })
	public JsonResponse<Object> crqsInspectView(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :crqsInspectView start");

		logger.info("Method :crqsInspectView endss");
		return qaRCFTMDao.crqsInspectView(id, orgName, orgDivision);
	}

	// addCrqsInspect
	@PostMapping(value = "rest-rcftm-inspect-add")
	public ResponseEntity<JsonResponse<List<QaCrqsRestModel>>> addCrqsInspect(

			@RequestBody List<QaCrqsRestModel> qaCrqsRestModel) {
		logger.info("Method : addCrqsInspect starts");
		logger.info("Method : addCrqsInspect ends");
		return qaRCFTMDao.addingCrqsInspect(qaCrqsRestModel);
	}

	// CrqsInspect
	@RequestMapping(value = "rest-rcftm-inspect-download", method = { RequestMethod.GET })
	public JsonResponse<Object> crqsInspectDownload(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :crqsInspectView start");

		logger.info("Method :crqsInspectView endss");
		return qaRCFTMDao.CrqsInspectDownload(id, orgName, orgDivision);
	}
	@RequestMapping(value = "saveMasterDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<QaRCFTMRestModel>> saveMasterDetails(@RequestBody QaRCFTMRestModel product) {
		logger.info("Method : saveMasterDetails starts");
		
		logger.info("Method : saveMasterDetails ends");
		return qaRCFTMDao.saveMasterDetails(product);
	}
	
	@RequestMapping(value = "saveItemDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<QaRCFTMRestModel>> saveItemDetails(@RequestBody QaRCFTMRestModel product) {
		logger.info("Method : saveItemDetails starts");
		
		logger.info("Method : saveItemDetails ends");
		return qaRCFTMDao.saveItemDetails(product);
	}
	
	@RequestMapping(value = "getTotalChildView", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalChildView(@RequestParam String runId, String orgName, String orgDivision) {
		logger.info("Method :getTotalChildView start");

		logger.info("Method :getTotalChildView endss");
		return qaRCFTMDao.getTotalChildView(runId,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editCodeForChildRCFTM", method = { RequestMethod.GET })
	public JsonResponse<Object> editCodeForChildRCFTM(@RequestParam String id,String runChartId, String orgName, String orgDivision) {
		logger.info("Method :editCodeForChildRCFTM start");

		logger.info("Method :editCodeForChildRCFTM endss");
		return qaRCFTMDao.editCodeForChildRCFTM(id,runChartId, orgName, orgDivision);
	}
	@RequestMapping(value = "rest-deleteRCFTMChild", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRCFTMChild(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteRCFTMChild starts");

		logger.info("Method : deleteRCFTMChild ends");
		return qaRCFTMDao.deleteRCFTMChild(id, org, orgDiv);

	}
	@RequestMapping(value = "rcftm-detailsForGraphs", method = { RequestMethod.GET })
	public JsonResponse<Object> detailsForGraphs(@RequestParam String id,@RequestParam String orgName, @RequestParam String orgDivision , String userId) {
		logger.info("Method :detailsForGraphs start");

		logger.info("Method :detailsForGraphs endss");
		return qaRCFTMDao.detailsForGraphs(id,orgName, orgDivision , userId);

	}
}