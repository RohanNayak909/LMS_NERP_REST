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
import nirmalya.aatithya.restmodule.grc.dao.InspectionReviewRestDao;
import nirmalya.aatithya.restmodule.grc.model.ScheduledAuditPlanRestModel;

@RestController
@RequestMapping(value = "grc/")

public class InspectionReviewRestController {
	
    Logger logger = LoggerFactory.getLogger(InspectionReviewRestController.class);
	
	@Autowired
	InspectionReviewRestDao inspectionReviewRestDao; 
	
  
	
	@RequestMapping(value = "rest-inspection-review-instance-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewInstnaceAudit(@RequestParam String scheduledId,String orgName, String orgDivision) {
		logger.info("Method :viewInstnaceInspection start");

		logger.info("Method :viewInstnaceInspection endss");
		return inspectionReviewRestDao.viewInstnaceInspection(scheduledId,orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-inspection-review-submit")
	public ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>> addReviewForInspection( @RequestBody List<ScheduledAuditPlanRestModel> sap) {
		logger.info("Method : addReviewForInspection starts");
		logger.info("Method : addReviewForInspection ends");
		return inspectionReviewRestDao.addReviewForInspection(sap);
	}
	
	@GetMapping(value = "get-report-all-data")
	public JsonResponse<Object> getReportAllData(@RequestParam String planId,String scheduledId,String category,String instanceId,String organization, String orgDivision) {
		logger.info("Method :getReportAllData start");

		logger.info("Method :getReportAllData endss");
		return inspectionReviewRestDao.getReportAllData(planId, scheduledId,category, instanceId, organization,orgDivision);
	}
	
}
