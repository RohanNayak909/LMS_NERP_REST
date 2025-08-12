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
import nirmalya.aatithya.restmodule.grc.dao.AuditRecordRestDao;
import nirmalya.aatithya.restmodule.grc.model.ScheduledAuditPlanRestModel;

@RestController
@RequestMapping(value = "grc/")

public class AuditRecordRestController {
	
    Logger logger = LoggerFactory.getLogger(AuditRecordRestController.class);
	
	@Autowired
	AuditRecordRestDao auditRecordRestDao; 
	
  
	
	@RequestMapping(value = "rest-audit-plan-schedule", method = { RequestMethod.GET })
	public JsonResponse<Object> viewScheduledAudit(@RequestParam String orgName, String orgDivision,String userId,String type,String date) {
		logger.info("Method :viewScheduledAudit start");

		logger.info("Method :viewScheduledAudit endss");
		return auditRecordRestDao.viewScheduledAudit(orgName, orgDivision,userId,type,date);
	}
	@RequestMapping(value = "rest-get-scheduled-audit-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getScheduledAuditDetails(@RequestParam String scheduledId,String auditInstId,String orgName, String orgDivision) {
		logger.info("Method :getScheduledAuditDetails start");

		logger.info("Method :getScheduledAuditDetails endss");
		return auditRecordRestDao.getScheduledAuditDetails(scheduledId,auditInstId,orgName,orgDivision);
	}
	@PostMapping(value = "rest-scheduled-audit-progress")
	public ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>> addScheduledAuditProgress( @RequestBody List<ScheduledAuditPlanRestModel> sap) {
		logger.info("Method : addScheduledAuditProgress starts");
		logger.info("Method : addScheduledAuditProgress ends");
		return auditRecordRestDao.addScheduledAuditProgress(sap);
	}

}
