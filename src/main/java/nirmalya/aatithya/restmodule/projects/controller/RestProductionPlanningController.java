package nirmalya.aatithya.restmodule.projects.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.RestProductionPlanningDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;

@RestController
@RequestMapping("projects/")
public class RestProductionPlanningController {
	Logger logger = LoggerFactory.getLogger(RestProductionPlanningController.class);

	@Autowired
	RestProductionPlanningDao restProductionPlanningDao;

	@RequestMapping(value = "rest-getfirstProjectName-production-planning", method = { RequestMethod.GET })

	public JsonResponse<Object> getFirstProjectNmDetails(@RequestParam String id, @RequestParam String userid,
			@RequestParam String org, @RequestParam String div) {
		logger.info("Method :getFirstProjectNmDetails start");

		logger.info("Method :getFirstProjectNmDetails endss");
		return restProductionPlanningDao.getFirstProjectNmDetail(id, userid, org, div);
	}

	@PostMapping(value = "save-parentProductionPlanningData")
	public ResponseEntity<JsonResponse<Object>> parentProductionPlanningData(
			@RequestBody List<ProjectPlanningSchedulingRestModel> eventModel) {
		logger.info("Method : parentPlanningData starts");
		logger.info("Method : parentPlanningData ends");
		return restProductionPlanningDao.parentProductionPlanningData(eventModel);
	}

	@PostMapping(value = "save-MasterDataProductionPlanning")
	public ResponseEntity<JsonResponse<Object>> saveMasterDataPlanning(
			@RequestBody ProjectPlanningSchedulingRestModel eventModel) {
		logger.info("Method : saveMasterDataPlanning starts");
		logger.info("Method : saveMasterDataPlanning ends");
		return restProductionPlanningDao.saveMasterDataPlanning(eventModel);
	}

	@RequestMapping(value = "rest-getProductionParentDetails", method = { RequestMethod.GET })

	public JsonResponse<Object> getProductionParentDetails(@RequestParam String id, @RequestParam String id2,
			@RequestParam String userid, @RequestParam String org, @RequestParam String div) {
		logger.info("Method :getProductionParentDetails start");

		logger.info("Method :getParentDataDtls endss");
		return restProductionPlanningDao.getProductionParentDetails(id, id2, userid, org, div);
	}

	@RequestMapping(value = "rest-getProductionParentEditDatas", method = { RequestMethod.GET })

	public JsonResponse<Object> getParentEdits(@RequestParam String id, @RequestParam String userid,
			@RequestParam String org, @RequestParam String div) {
		logger.info("Method :getParentEdits start");

		logger.info("Method :getParentEdits endss");
		return restProductionPlanningDao.getParentEdits(id, userid, org, div);
	}

	// delete Planning

	@RequestMapping(value = "rest-production-planning-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> planningschedulingdelete(@RequestParam String userid,

			@RequestParam String org, @RequestParam String div, @RequestParam String id, @RequestParam String id2) {
		logger.info("Method :  planningschedulingdelete starts" + id);

		logger.info("Method :  planningschedulingdelete ends");
		return restProductionPlanningDao.planningschedulingdeleteDao(userid, org, div, id, id2);
	}

	@RequestMapping(value = "rest-productionplanning-TaskCategory-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> TaskCategoryDelete(@RequestParam String userid,

			@RequestParam String org, @RequestParam String div, @RequestParam String id) {
		logger.info("Method :  TaskCategoryDelete starts" + id);

		logger.info("Method :  TaskCategoryDelete ends");
		return restProductionPlanningDao.TaskCategoryDeleteDao(userid, org, div, id);
	}

	@RequestMapping(value = "rest-getcalculationdatetimeProductionPlan", method = { RequestMethod.GET })

	public JsonResponse<Object> calculationdatetime(@RequestParam String startDt, @RequestParam String endDt) {
		logger.info("Method :calculationdatetime start");

		logger.info("Method :calculationdatetime endss");
		return restProductionPlanningDao.calculationdatetimeDAo(startDt, endDt);
	}

	@GetMapping(value = "rest-getcategoryDataProductionPlanning")
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> getcategoryDataPlanning(
			@RequestParam String id) {
		logger.info("Method : getcategoryDataPlanning starts" + id);

		logger.info("Method :getcategoryDataPlanning endss");
		return restProductionPlanningDao.getcategoryDataPlanning(id);
	}
	
	// Drop down Project Name
		@GetMapping(value = "get-productionPlanningCategoryList")
		public List<DropDownModel> productionPlanningCategoryList() {
			logger.info("Method : productionPlanningCategoryList starts");

			logger.info("Method : productionPlanningCategoryList ends");
			return restProductionPlanningDao.productionPlanningCategoryList();
		}
		

}
