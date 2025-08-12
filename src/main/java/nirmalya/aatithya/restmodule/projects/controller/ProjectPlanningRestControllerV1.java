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
import nirmalya.aatithya.restmodule.productionplan.model.RmPmRequisitionRestModel;
import nirmalya.aatithya.restmodule.projects.dao.ProjectPlanningDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningRestModel;

@RestController
@RequestMapping(value = "projects")
public class ProjectPlanningRestControllerV1 {

	Logger logger = LoggerFactory.getLogger(ProjectPlanningRestControllerV1.class);

	@Autowired
	ProjectPlanningDao projectPlanningDao;

	@RequestMapping(value = "get-projectPriority-list-v1", method = { RequestMethod.GET })
	public List<DropDownModel> getPriorityList() {
		logger.info("Method : getPriorityList starts");

		logger.info("Method : getPriorityList ends");
		return projectPlanningDao.getPriorityList();
	}

	// rest-add-project-planning
	@RequestMapping(value = "rest-add-project-planning", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddProjectPlanning(
			@RequestBody List<ProjectPlanningRestModel> projectPlanning) {
		logger.info("Method : restAddProjectPlanning starts");

		logger.info("Method : restAddProjectPlanning ends");

		return projectPlanningDao.restAddProjectPlanning(projectPlanning);
	}

	// rest-get-assigned-to-auto-list
	@GetMapping(value = "rest-get-assigned-to-auto-list")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssignedToAutoSearchList(@RequestParam String id) {
		logger.info("Method : getAssignedToAutoSearchList starts");

		logger.info("Method :getAssignedToAutoSearchList endss");
		return projectPlanningDao.getAssignedToAutoSearchList(id);
	}

	/* get-all-task-details */
	@RequestMapping(value = "get-all-task-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllTaskByProjectId(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :getAllTaskByProjectId start");
		logger.info("Method :getAllTaskByProjectId endss");
		return projectPlanningDao.getAllTaskByProjectId(orgName, orgDivision, id);
	}
	/* get-all-task-edit */

	@RequestMapping(value = "get-all-task-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editTaskParentDetails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :editTaskParentDetails start");
		logger.info("Method :editTaskParentDetails endss");
		return projectPlanningDao.editTaskParentDetails(orgName, orgDivision, id);
	}

	/* rest-add-project-planning-child */
	@RequestMapping(value = "rest-add-project-planning-child", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addChildProjectPlanning(
			@RequestBody List<ProjectPlanningRestModel> projectPlanning) {
		logger.info("Method : addChildProjectPlanning starts");

		logger.info("Method : addChildProjectPlanning ends");

		return projectPlanningDao.addChildProjectPlanning(projectPlanning);
	}
	
	/* get-all-version */
	@RequestMapping(value = "get-all-version", method = { RequestMethod.GET })
	public JsonResponse<Object> taskVersionDetails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :taskVersionDetails start");
		logger.info("Method :taskVersionDetails endss");
		return projectPlanningDao.taskVersionDetails(orgName, orgDivision, id);
	}
	
	
	/* rest-addRmPmRequisition-task */
	@PostMapping(value = "rest-addRmPmRequisition-task")
	public ResponseEntity<JsonResponse<RmPmRequisitionRestModel>> addRmPmRequisition(

			@RequestBody RmPmRequisitionRestModel rmPmRequisitionRestModel) {
		logger.info("Method : addRmPmRequisition starts");
		logger.info("Method : addRmPmRequisition ends");
		return projectPlanningDao.addRmPmRequisition(rmPmRequisitionRestModel);
	}
	
	/* get-all-requisition-byId */
	@RequestMapping(value = "get-all-requisition-byId", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllRequisitionById(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :getAllRequisitionById start");
		logger.info("Method :getAllRequisitionById endss");
		return projectPlanningDao.getAllRequisitionById(orgName, orgDivision, id);
	}
	
	@RequestMapping(value = "saveDprDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveDprDetails(@RequestBody ProjectPlanningRestModel data) {
		logger.info("Method : saveDprDetails starts");
		
		logger.info("Method : saveDprDetails ends");
		return projectPlanningDao.saveDprDetails(data);
	}

/* get-all-task-dpr */

@RequestMapping(value = "get-all-task-dpr", method = { RequestMethod.GET })
public JsonResponse<Object> getAllTAskDpr(@RequestParam String orgName, @RequestParam String orgDivision,
		@RequestParam String id) {
	logger.info("Method :getAllTAskDpr start");
	logger.info("Method :getAllTAskDpr endss");
	return projectPlanningDao.getAllTAskDpr(orgName, orgDivision, id);
}
}