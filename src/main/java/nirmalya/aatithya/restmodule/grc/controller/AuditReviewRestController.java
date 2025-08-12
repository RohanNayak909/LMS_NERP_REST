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
import nirmalya.aatithya.restmodule.grc.dao.AuditReviewRestDao;
import nirmalya.aatithya.restmodule.grc.model.ScheduledAuditPlanRestModel;

@RestController
@RequestMapping(value = "grc/")

public class AuditReviewRestController {
	
    Logger logger = LoggerFactory.getLogger(AuditReviewRestController.class);
	
	@Autowired
	AuditReviewRestDao auditReviewRestDao; 
	
  
	
	@RequestMapping(value = "rest-audit-review-instance-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewInstnaceAudit(@RequestParam String scheduledId,String orgName, String orgDivision) {
		logger.info("Method :viewInstnaceAudit start");

		logger.info("Method :viewInstnaceAudit endss");
		return auditReviewRestDao.viewInstnaceAudit(scheduledId,orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-audit-review-submit")
	public ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>> addReviewForAudit( @RequestBody List<ScheduledAuditPlanRestModel> sap) {
		logger.info("Method : addReviewForAudit starts");
		logger.info("Method : addReviewForAudit ends");
		return auditReviewRestDao.addReviewForAudit(sap);
	}
	
	@GetMapping(value = "get-all-audit-report-data")
	public JsonResponse<Object> getReportAllData(@RequestParam String planId,String scheduledId,String category,String instanceId,String organization, String orgDivision) {
		logger.info("Method :getReportAllData start");

		logger.info("Method :getReportAllData endss");
		return auditReviewRestDao.getReportAllData(planId, scheduledId,category, instanceId, organization,orgDivision);
	}
}
