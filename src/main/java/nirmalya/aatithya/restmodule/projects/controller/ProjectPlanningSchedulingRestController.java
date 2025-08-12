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
import nirmalya.aatithya.restmodule.projects.dao.ProjectPlanningSchedulingDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestPlanningSchedulesubModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;

@RestController
@RequestMapping(value = "projects")
public class ProjectPlanningSchedulingRestController {

	Logger logger = LoggerFactory.getLogger(ProjectPlanningSchedulingRestController.class);

	@Autowired
	ProjectPlanningSchedulingDao projectPlanningSchedulingDao;

	// Drop down Project Name
	@GetMapping(value = "get-projectName-list")
	public List<DropDownModel> getprojectNamelist() {
		logger.info("Method : getprojectNamelist starts");

		logger.info("Method : getprojectNamelist ends");
		return projectPlanningSchedulingDao.getprojectNameList();
	}

	// projectNameDetails on change drop down

	@GetMapping(value = "rest-getProjectName-Details")
	public List<ProjectPlanningSchedulingRestModel> getProjectNmDetails(@RequestParam String id,
			@RequestParam String id1) {
		logger.info("Method : getProjectNameDetails starts" + id);

		logger.info("Method : getProjectNameDetails endss");
		return projectPlanningSchedulingDao.getProjectNameDetails(id, id1);
	}

	// view project creation table

	@RequestMapping(value = "rest-PlanScheduling-view", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> viewPlanScheduling() {
		logger.info("Method: viewPlanSchedule View Start");

		logger.info("Method: viewPlanSchedule ends");
		return projectPlanningSchedulingDao.viewPlanScheduling();
	}

	@GetMapping(value = "getProjectList-list")
	public JsonResponse<List<ProjectCreationRestModel>> getProjectList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getProjectList starts" + id);

		logger.info("Method : getProjectList ends");
		return projectPlanningSchedulingDao.getProjectList(id, org, orgDiv);
	}

	@PostMapping(value = "rest-copyproject-Details")
	public List<ProjectPlanningSchedulingRestModel> copyprojectDetails(
			@RequestBody ProjectPlanningSchedulingRestModel model) {
		logger.info("Method : copyprojectDetails starts");

		logger.info("Method : copyprojectDetails endss");
		return projectPlanningSchedulingDao.copyprojectDetails(model);
	}

	@GetMapping(value = "rest-getfirstProjectName-Details")
	public List<ProjectPlanningSchedulingRestModel> getFirstProjectNmDetails(@RequestParam String id) {
		logger.info("Method : getFirstProjectNmDetails starts" + id);

		logger.info("Method : getFirstProjectNmDetails endss");
		return projectPlanningSchedulingDao.getFirstProjectNmDetails(id);
	}

	@RequestMapping(value = "getAllPlanningCategoryList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getAllPlanningCategoryList(
			@RequestParam String id) {
		logger.info("Method : getAllProjectCategoryList starts");

		logger.info("Method : getAllProjectCategoryList ends");
		return projectPlanningSchedulingDao.getAllPlanningCategoryList(id);
	}

	@RequestMapping(value = "getAllPlanningSchDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> getAllPlanningSchDtls(
			@RequestParam String id, @RequestParam String id2) {
		logger.info("Method : getAllPlanningSchDtls starts");

		logger.info("Method : getAllPlanningSchDtls ends");
		return projectPlanningSchedulingDao.getAllPlanningSchDtls(id, id2);
	}

	@PostMapping(value = "save-savePlanningScheduleBrowse")
	public ResponseEntity<JsonResponse<Object>> savePlanschedule(@RequestBody RestPlanningSchedulesubModel eventModel) {
		logger.info("Method : savePlanschedule starts");
		logger.info("Method : savePlanschedule ends");
		return projectPlanningSchedulingDao.savePlanningScheduleBrowse(eventModel);
	}

	@GetMapping(value = "rest-getplanschdata")
	public JsonResponse<ProjectPlanningSchedulingRestModel> getPlannScheduleData(@RequestParam String id) {
		logger.info("Method : getPlannScheduleData starts");

		logger.info("Method : getPlannScheduleData ends");
		return projectPlanningSchedulingDao.getPlannScheduleData(id);
	}

	@PostMapping(value = "modifychilddata")
	public ResponseEntity<JsonResponse<Object>> modifyChildData(
			@RequestBody ProjectPlanningSchedulingRestModel eventModel) {
		logger.info("Method : modifyChildData starts");
		logger.info("Method : modifyChildData ends");
		return projectPlanningSchedulingDao.modifyChildData(eventModel);
	}

	@GetMapping(value = "rest-getcategoryData")
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> getcategoryData(
			@RequestParam String id) {
		logger.info("Method : getcategoryData starts" + id);

		logger.info("Method :getcategoryData endss");
		return projectPlanningSchedulingDao.getcategoryData(id);
	}

	@PostMapping(value = "save-saveParentData")
	public ResponseEntity<JsonResponse<Object>> saveParentData(
			@RequestBody ProjectPlanningSchedulingRestModel eventModel) {
		logger.info("Method : saveParentData starts");
		logger.info("Method : saveParentData ends");
		return projectPlanningSchedulingDao.saveParentData(eventModel);
	}

	@PostMapping(value = "save-parentDataSchedule")
	public ResponseEntity<JsonResponse<Object>> parentDataSchedule(
			@RequestBody List<ProjectPlanningSchedulingRestModel> eventModel) {
		logger.info("Method : parentDataSchedule starts");
		logger.info("Method : parentDataSchedule ends");
		return projectPlanningSchedulingDao.saveparentDataSchedule(eventModel);
	}

	@PostMapping(value = "save-childDataSchedule")
	public ResponseEntity<JsonResponse<Object>> savechildDataSchedule(
			@RequestBody List<ProjectPlanningSchedulingRestModel> eventModel) {
		logger.info("Method : savechildDataSchedule starts");
		logger.info("Method : savechildDataSchedule ends");
		return projectPlanningSchedulingDao.savechildDataSchedule(eventModel);
	}

	/*
	 * @GetMapping(value = "rest-getPrecedAutoSearchList-planning") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>
	 * getPrecedAutoSearchListPlanning(@RequestParam String id, String projectId) {
	 * logger.info("Method : getPrecedAutoSearchListPlanning starts");
	 * 
	 * logger.info("Method :getPrecedAutoSearchListPlanning endss"); return
	 * projectPlanningSchedulingDao.getPrecedAutoSearchListPlanning(id, projectId);
	 * }
	 */

	//
	// FOR DELETE
	@RequestMapping(value = "deleteProjectPlan", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProjectPlan(@RequestParam String id, @RequestParam String exeId) {
		logger.info("Method : deleteProjectPlan starts" + id);

		logger.info("Method : deleteProjectPlan ends" + exeId);
		return projectPlanningSchedulingDao.deleteProjectPlan(id, exeId);
	}

	// FOR DELETE child
	@RequestMapping(value = "deleteProjectPlanChild", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProjectPlanChild(@RequestParam String id,
			@RequestParam String pId, @RequestParam String proId) {
		logger.info("Method : deleteProjectPlanChild starts" + id);

		logger.info("Method : deleteProjectPlanChild ends");
		return projectPlanningSchedulingDao.deleteProjectPlanChild(id, pId, proId);
	}

	@GetMapping(value = "rest-calculationdatetime")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> calculationdatetime(@RequestParam String startDt,
			String endDt) {
		logger.info("Method : calculationdatetime starts");

		logger.info("Method :calculationdatetime endss");
		return projectPlanningSchedulingDao.calculationdatetime(startDt, endDt);
	}
}
