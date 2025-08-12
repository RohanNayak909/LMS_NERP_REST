package nirmalya.aatithya.restmodule.projects.controller;

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
import nirmalya.aatithya.restmodule.projects.dao.ManageProjectsDao;
import nirmalya.aatithya.restmodule.projects.model.ManageProjectMasterModel;
import nirmalya.aatithya.restmodule.projects.model.NonResourcePlanModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectsChartOfAccountModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectsCostCenterModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectsTeamPlanModel;

@RestController
@RequestMapping("projects/")
public class ManageProjectRestController {

	Logger logger = LoggerFactory.getLogger(ManageProjectRestController.class);

	@Autowired
	ManageProjectsDao projectsDao;
	
	@RequestMapping(value = "projectTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> projectTypeList() {
		logger.info("Method : projectTypeList starts");

		logger.info("Method : projectTypeList ends");
		return projectsDao.projectTypeList();
	}
	
	@RequestMapping(value = "priorityList", method = { RequestMethod.GET })
	public List<DropDownModel> priorityList() {
		logger.info("Method : priorityList starts");

		logger.info("Method : priorityList ends");
		return projectsDao.priorityList();
	}
	
	@RequestMapping(value = "EmployeeList", method = { RequestMethod.GET })
	public List<DropDownModel> EmployeeList() {
		logger.info("Method : EmployeeList starts");

		logger.info("Method : EmployeeList ends");
		return projectsDao.EmployeeList();
	}
	
	@PostMapping(value="addProjects")
	public ResponseEntity<JsonResponse<ManageProjectMasterModel>> addProjects(@RequestBody ManageProjectMasterModel projects){
		logger.info("Method : addProjects starts");
		
		logger.info("Method : addProjects ends");
		return projectsDao.addProjects(projects);
	}
	
	@RequestMapping(value = "viewProjects", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ManageProjectMasterModel>>> viewProjects() {
		logger.info("Method : viewProjects starts");

		logger.info("Method : viewProjects ends");
		return projectsDao.viewProjects();
	}
	
	@RequestMapping(value = "/deleteProjects", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deleteProjects(@RequestParam String id) {
		logger.info("Method : deleteProjects starts");

		logger.info("Method : deleteProjects ends");
		return projectsDao.deleteProjects(id); 
	}
	
	@RequestMapping(value = "/editProjects", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ManageProjectMasterModel>>> editProjects(@RequestParam String id) {
		logger.info("Method : editProjects starts");

		logger.info("Method :editProjects ends");
		return projectsDao.editProjects(id);
	}
	
	@PostMapping(value="addTeamPlan")
	public ResponseEntity<JsonResponse<Object>> addTeamPlan(@RequestBody ProjectsTeamPlanModel projectPlan){
		logger.info("Method : addTeamPlan starts");
		
		logger.info("Method : addTeamPlan ends");
		return projectsDao.addTeamPlan(projectPlan);
	}
	
	@RequestMapping(value = "viewTeamPlan", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProjectsTeamPlanModel>>> viewTeamPlan(@RequestParam String id) {
		logger.info("Method : viewTeamPlan starts");

		logger.info("Method : viewTeamPlan ends");
		return projectsDao.viewTeamPlan(id);
	}
	
	@RequestMapping(value = "deleteTeamPlan", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deleteTeamPlan(@RequestParam String id) {
		logger.info("Method : deleteTeamPlan starts");

		logger.info("Method : deleteTeamPlan ends");
		return projectsDao.deleteTeamPlan(id); 
	}
	
	@PostMapping(value="addNonResource")
	public ResponseEntity<JsonResponse<Object>> addNonResource(@RequestBody NonResourcePlanModel projectPlan){
		logger.info("Method : addNonResource starts");
		
		logger.info("Method : addNonResource ends");
		return projectsDao.addNonResource(projectPlan);
	}
	
	@RequestMapping(value = "viewNonResource", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<NonResourcePlanModel>>> viewNonResource(@RequestParam String id) {
		logger.info("Method : viewNonResource starts");

		logger.info("Method : viewNonResource ends");
		return projectsDao.viewNonResource(id);
	}
	
	@RequestMapping(value = "deleteNonResource", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deleteNonResource(@RequestParam String id) {
		logger.info("Method : deleteNonResource starts");

		logger.info("Method : deleteNonResource ends");
		return projectsDao.deleteNonResource(id); 
	}
	
	@RequestMapping(value = "viewChartAccount", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProjectsChartOfAccountModel>>> viewChartAccount() {
		logger.info("Method : viewChartAccount starts");

		logger.info("Method : viewChartAccount ends");
		return projectsDao.viewChartAccount();
	}
	
	@RequestMapping(value = "viewChartAccountAutoComplete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProjectsChartOfAccountModel>>> viewChartAccountAutoComplete(@RequestParam String search) {
		logger.info("Method : viewChartAccountAutoComplete starts");

		logger.info("Method : viewChartAccountAutoComplete ends");
		return projectsDao.viewChartAccountAutoComplete(search);
	}
	
	@RequestMapping(value = "viewCostCenterAutoComplete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProjectsCostCenterModel>>> viewCostCenterAutoComplete(@RequestParam String search) {
		logger.info("Method : viewCostCenterAutoComplete starts");

		logger.info("Method : viewCostCenterAutoComplete ends");
		return projectsDao.viewCostCenterAutoComplete(search);
	}
	
}
