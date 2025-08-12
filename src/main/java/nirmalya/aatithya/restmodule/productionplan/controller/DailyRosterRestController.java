package nirmalya.aatithya.restmodule.productionplan.controller;

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

import nirmalya.aatithya.restmodule.asset.dao.AssetReportDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.productionplan.dao.DailyRosterDao;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionParentModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestProductionPlanningProductList;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;

@RestController
@RequestMapping(value = { "production/" })
public class DailyRosterRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	DailyRosterDao dailyRosterDao;



	// View Assigned Asset
	@RequestMapping(value = "rest-production-dailyroster-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDailyRosters(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewDailyRosters start");

		logger.info("Method :viewDailyRosters endss");
		return dailyRosterDao.viewDailyRosters(orgName, orgDivision);
	}
	

	@GetMapping(value = "rest-production-daily-planning-view")
	public ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>> viewDailyPlanning(
			@RequestParam String planid) {
		logger.info("Method : viewDailyPlanning starts");

		logger.info("Method : viewDailyPlanning ends");
		return dailyRosterDao.viewDailyPlanning(planid);
	}
	
	@RequestMapping(value = "rest-dailyrosterView", method = { RequestMethod.GET })
	public JsonResponse<Object> dailyrosterView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :dailyrosterView start");

		logger.info("Method :dailyrosterView endss");
		return dailyRosterDao.dailyrosterView(orgName, orgDivision);
	}
	
	/*
	 * @GetMapping(value = "rest-daily-viewproductionplanning") public
	 * ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>>
	 * viewPlanning(
	 * 
	 * @RequestParam String userid) { logger.info("Method : viewPlanning starts");
	 * 
	 * logger.info("Method : viewPlanning ends"); return
	 * dailyRosterDao.viewplanning(userid); }
	 */
	
	@RequestMapping(value = "rest-dailyrosterShiftView", method = { RequestMethod.GET })
	public JsonResponse<Object> dailyrosterShiftView(@RequestParam String orgName, String orgDivision , String date , String id) {
		logger.info("Method :dailyrosterShiftView start");

		logger.info("Method :dailyrosterShiftView endss");
		return dailyRosterDao.dailyrosterShiftView(orgName, orgDivision,date,id);
	}
	
	// Add Daily Roster.
	
	@PostMapping(value = "rest-addDailyRoster")
	public ResponseEntity<JsonResponse<List<RestProductionPlanningProductList>>> addDailyRoster(

			@RequestBody List<RestProductionPlanningProductList> addDailyRoster) {
		logger.info("Method : addDailyRoster starts");
		logger.info("Method : addDailyRoster ends");
		return dailyRosterDao.addDailyRoster(addDailyRoster);
	}

}
