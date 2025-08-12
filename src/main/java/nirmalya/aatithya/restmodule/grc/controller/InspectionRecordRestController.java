package nirmalya.aatithya.restmodule.grc.controller;

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
import nirmalya.aatithya.restmodule.grc.dao.InspectionRecordRestDao;
import nirmalya.aatithya.restmodule.grc.model.ScheduledAuditPlanRestModel;

@RestController
@RequestMapping(value = "grc/")
public class InspectionRecordRestController {

	Logger logger = LoggerFactory.getLogger(InspectionRecordRestController.class);

	@Autowired
	InspectionRecordRestDao inspectionRecordRestDao;

	@RequestMapping(value = "rest-inspection-record-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewScheduledInspection(@RequestParam String orgName, String orgDivision,String userId,String type,String date) {
		logger.info("Method :viewScheduledInspection start");

		logger.info("Method :viewScheduledInspection endss");
		return inspectionRecordRestDao.viewScheduledInspection(orgName, orgDivision,userId,type,date);
	}
	
	@RequestMapping(value = "rest-inspection-record-progressDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getScheduledInspectionDetails(@RequestParam String scheduledId,String auditInstId,String orgName, String orgDivision) {
		logger.info("Method :getScheduledInspectionDetails start");

		logger.info("Method :getScheduledInspectionDetails endss");
		return inspectionRecordRestDao.getScheduledInspectionDetails(scheduledId,auditInstId,orgName,orgDivision);
	}
	
	@PostMapping(value = "rest-inspection-record-submit-progress")
	public ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>> addInspectionProgress( @RequestBody List<ScheduledAuditPlanRestModel> sap) {
		logger.info("Method : addInspectionProgress starts");
		logger.info("Method : addInspectionProgress ends");
		return inspectionRecordRestDao.addInspectionProgress(sap);
	}
}
