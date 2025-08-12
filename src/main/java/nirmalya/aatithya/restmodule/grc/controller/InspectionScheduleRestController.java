package nirmalya.aatithya.restmodule.grc.controller;

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
import nirmalya.aatithya.restmodule.grc.dao.InspectionScheduleRestDao;
import nirmalya.aatithya.restmodule.grc.model.AuditScheduleRestModel;

@RestController
@RequestMapping(value = "grc/")
public class InspectionScheduleRestController {

	Logger logger = LoggerFactory.getLogger(InspectionScheduleRestController.class);

	@Autowired
	InspectionScheduleRestDao inceptionScheduleRestDao;

	@RequestMapping(value = "rest-inspection-schedule-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewInspectionSchedule(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewInspectionSchedule start");

		logger.info("Method :viewInspectionSchedule endss");
		return inceptionScheduleRestDao.viewInspectionSchedule(orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-inspection-schedule-add")
	public ResponseEntity<JsonResponse<Object>> inspectionPlanSchedule(
			@RequestBody AuditScheduleRestModel model) {
		logger.info("Method :inspectionPlanSchedule starts");
		logger.info("Method :inspectionPlanSchedule endss");
		return inceptionScheduleRestDao.inspectionPlanSchedule(model);
	}
	
	@RequestMapping(value = "rest-inspection-schedule-unschedule", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> unScheduledInspectionPlan(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : unScheduledInspectionPlan starts");

		logger.info("Method : unScheduledInspectionPlan ends");
		return inceptionScheduleRestDao.unScheduledInspectionPlan(id, org, orgDiv);

	}
}
