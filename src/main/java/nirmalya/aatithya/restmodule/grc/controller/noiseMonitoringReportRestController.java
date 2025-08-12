package nirmalya.aatithya.restmodule.grc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.noiseMoniteringDao;
import nirmalya.aatithya.restmodule.grc.model.dcaMonitoringRestModel;
import nirmalya.aatithya.restmodule.grc.model.noiseMonitorReportModel;
import nirmalya.aatithya.restmodule.ticket.model.DigitalLogBookRestModel;

@RestController
@RequestMapping(value = { "grc/" })
public class noiseMonitoringReportRestController {
	
	Logger logger = LoggerFactory.getLogger(noiseMonitoringReportRestController.class);

	@Autowired
	noiseMoniteringDao noiseMoniteringDao;
	
	
	@RequestMapping(value = "rest-getNoiseMoniteringData", method = { RequestMethod.GET })
	public JsonResponse<Object> getNoiseMonitorData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getNoiseMonitorData start");

		logger.info("Method :getNoiseMonitorData endss");
		return noiseMoniteringDao.getNoiseMonitorData(orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-monitorReportAdd")
	public ResponseEntity<JsonResponse<List<noiseMonitorReportModel>>> activityAdd(
			@RequestBody List<noiseMonitorReportModel> assetPolicyModel) {
		logger.info("Method : monitorReportAdd starts");
		logger.info("Method : monitorReportAdd ends");
		return noiseMoniteringDao.activityAdd(assetPolicyModel);
	}
	
	@RequestMapping(value = "rest-viewNoiseMonitor", method = { RequestMethod.GET })
	public JsonResponse<Object> viewNoiseMonitor(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewNoiseMonitor start");

		logger.info("Method :viewNoiseMonitor endss");
		return noiseMoniteringDao.viewNoiseMonitor(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editNoiseMonitor", method = { RequestMethod.GET })
	public JsonResponse<Object> editNoiseMonitor(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editNoiseMonitor start");

		logger.info("Method :editNoiseMonitor endss");
		return noiseMoniteringDao.editNoiseMonitor(id, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-monitorReport-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteNoiseMonitor(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteNoiseMonitor starts");

		logger.info("Method : deleteNoiseMonitor ends");
		return noiseMoniteringDao.deleteNoiseMonitor(id, org, orgDiv);

	}
	
	@RequestMapping(value = "rest-monitorReportPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> monitorReportPdf(@RequestParam String id,String orgName,String orgDivision) {
		logger.info("Method :monitorReportPdf start");

		logger.info("Method :monitorReportPdf endss");
		return noiseMoniteringDao.monitorReportPdf(id,orgName,orgDivision);

	}
	
	
	
	@RequestMapping(value = "rest-getDcaMoniteringData", method = { RequestMethod.GET })
	public JsonResponse<Object> getDcaMonitorData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getDcaMonitorData start");

		logger.info("Method :getDcaMonitorData endss");
		return noiseMoniteringDao.getDcaMonitorData(orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-dcamonitorReportAdd")
	public ResponseEntity<JsonResponse<List<dcaMonitoringRestModel>>> dcaMonitorAdd(
			@RequestBody List<dcaMonitoringRestModel> assetPolicyModel) {
		logger.info("Method : dcaMonitorAdd starts");
		logger.info("Method : dcaMonitorAdd ends");
		return noiseMoniteringDao.dcaMonitorAdd(assetPolicyModel);
	}
	
	@RequestMapping(value = "rest-viewDcaMonitor", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDcaMonitor(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewDcaMonitor start");

		logger.info("Method :viewDcaMonitor endss");
		return noiseMoniteringDao.viewDcaMonitor(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editDcaMonitor", method = { RequestMethod.GET })
	public JsonResponse<Object> editDcaMonitor(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editDcaMonitor start");

		logger.info("Method :editDcaMonitor endss");
		return noiseMoniteringDao.editDcaMonitor(id, orgName, orgDivision);
	}
	
	
	@RequestMapping(value = "dcaMonitorReport-activity-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDcaMonitor(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteDcaMonitor starts");

		logger.info("Method : deleteDcaMonitor ends");
		return noiseMoniteringDao.deleteDcaMonitor(id, org, orgDiv);

	}
	
	@RequestMapping(value = "rest-dcaMonitorReportPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> dcaMonitorReportPdf(@RequestParam String id,String orgName,String orgDivision) {
		logger.info("Method :dcaMonitorReportPdf start");

		logger.info("Method :dcaMonitorReportPdf endss");
		return noiseMoniteringDao.DcamonitorReportPdf(id,orgName,orgDivision);

	}
	@GetMapping("rest-approve-noise-monitor")
	public JsonResponse<Object> approveNoiseReport(@RequestParam String noiseId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :approveNoiseReport start");

		logger.info("Method :approveChecklist ends");
		return noiseMoniteringDao.approveNoiseReport(noiseId, orgName, orgDiv);
	}
	
}
