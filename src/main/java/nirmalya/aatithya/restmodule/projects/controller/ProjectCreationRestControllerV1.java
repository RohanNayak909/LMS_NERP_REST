	package nirmalya.aatithya.restmodule.projects.controller;
	
	import java.util.List;
	
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	
	import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
	import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
	import nirmalya.aatithya.restmodule.projects.dao.ProjectCreationDaoV1;
	import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModelV1;
	
	@RestController
	@RequestMapping(value = "projects")
	
	public class ProjectCreationRestControllerV1 {
	
		Logger logger = LoggerFactory.getLogger(ProjectCreationRestControllerV1.class);
	
		@Autowired
		ProjectCreationDaoV1 projectCreationDao1;
	
		@RequestMapping(value = "rest-addPrjCreation-v1", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> restaddPrjCreation(
				@RequestBody List<ProjectCreationRestModelV1> prjCreation) {
			logger.info("Method : restaddPrjCreation starts");
	
			logger.info("Method : restaddPrjCreation ends");
	
			return projectCreationDao1.restaddPrjCreationDaoV1(prjCreation);
		}
	
		// rest-get-all-project
		@RequestMapping(value = "rest-get-all-project", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllProject(@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String type) {
			logger.info("Method :getAllProject start");
			logger.info("Method :getAllProject endss");
			return projectCreationDao1.getAllProject(orgName, orgDivision, type);
		}
	
		// rest-get-all-project-by-id
		@RequestMapping(value = "rest-get-all-project-by-id", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllPriojectById(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String id) {
			logger.info("Method :getAllPriojectById start");
			logger.info("Method :getAllPriojectById endss");
			return projectCreationDao1.getAllPriojectById(orgName, orgDivision, id);
		}
	
		/** project Type drop down **/
		@RequestMapping(value = "rest-project-type-list-v1", method = { RequestMethod.GET })
		public List<DropDownModel> getProjectTypeList() {
			logger.info("Method : getProjectTypeList starts");
	
			logger.info("Method : getProjectTypeList ends");
			return projectCreationDao1.getProjectTypeList();
		}
	
	}
