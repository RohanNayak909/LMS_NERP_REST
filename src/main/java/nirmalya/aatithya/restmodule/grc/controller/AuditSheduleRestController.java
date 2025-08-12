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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.AuditScheduleRestDao;
import nirmalya.aatithya.restmodule.grc.model.AuditScheduleRestModel;

@RestController
@RequestMapping(value = "grc/")

public class AuditSheduleRestController {
	Logger logger = LoggerFactory.getLogger(AuditPlanRestController.class);
	
	@Autowired
	AuditScheduleRestDao auditScheduleRestDao;
	
	@RequestMapping(value = "/getAuditPlanIds", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditPlanIds(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getAuditPlanIds starts");

		logger.info("Method : getAuditPlanIds end"); 
		return auditScheduleRestDao.getAuditPlanList(organization, orgDivision);
	}

	@RequestMapping(value = "/getDepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getDepartmentList starts");

		logger.info("Method : getDepartmentList end"); 
		return auditScheduleRestDao.getDepartmentList(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getAuditeeList", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditeeList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getAuditeeList starts");

		logger.info("Method : getAuditeeList end"); 
		return auditScheduleRestDao.getAuditeeList(organization, orgDivision);
	} 
	
	@RequestMapping(value = "/getSheduledAuditorList", method = { RequestMethod.GET })
	public List<DropDownModel> getSheduledAuditorList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getSheduledAuditorList starts");

		logger.info("Method : getSheduledAuditorList end"); 
		return auditScheduleRestDao.getSheduledAuditorList(organization, orgDivision);
	} 
	 
	@RequestMapping(value = "rest-getauditTypeWiseAuditorList",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getauditTypeWiseAuditorList(@RequestParam String id) {
		logger.info("Method : getauditTypeWiseAuditorList starts");
		logger.info("Method : getauditTypeWiseAuditorList ends");
		return auditScheduleRestDao.getauditTypeWiseAuditorList(id);
	}
	 
	
	 
	@PostMapping(value = "rest-audit-schedule-plan")
	public ResponseEntity<JsonResponse<Object>> auditPlanSchedule(
			@RequestBody AuditScheduleRestModel model) {
		logger.info("Method :auditPlanSchedule starts");
		logger.info("Method :auditPlanSchedule endss");
		return auditScheduleRestDao.auditPlanSchedule(model);
	} 
	@RequestMapping(value = "rest-audit-plan-unscheduled", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> unScheduledAuditPlan(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : unScheduledAuditPlan starts");

		logger.info("Method : unScheduledAuditPlan ends");
		return auditScheduleRestDao.unScheduledAuditPlan(id, org, orgDiv);

	}

}
