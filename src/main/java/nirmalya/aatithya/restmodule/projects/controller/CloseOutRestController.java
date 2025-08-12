package nirmalya.aatithya.restmodule.projects.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModelNew;
import nirmalya.aatithya.restmodule.projects.dao.CloseOutRestDao;
import nirmalya.aatithya.restmodule.projects.model.CloseOutRestModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.user.model.RolesAccessModel;

@RestController
@RequestMapping(value = "projects/")
public class CloseOutRestController {

	Logger logger = LoggerFactory.getLogger(CloseOutRestController.class);

	@Autowired
	CloseOutRestDao closeoutdao;
	
	//for project dropdown
	
	@GetMapping(value = "get-closeOut-list")
	public List<DropDownModel> getprojectList() {
		logger.info("Method : getprojectList starts");

		logger.info("Method : getprojectList ends");
		return closeoutdao.getprojectList();
	}
	
	//for project dropdown list
	
	@GetMapping(value = "rest-getProjectName-Data")
	public List<CloseOutRestModel> viewProjectName(@RequestParam String id) {
		logger.info("Method : viewProjectName starts");
		
		logger.info("Method : viewProjectName endss");
		return closeoutdao.viewProjectName(id);
	}
	
	// project-view

	@RequestMapping(value = "rest-closeOut-view", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> viewCloseOut() {
		logger.info("Method : restViewCloseOut starts");

		logger.info("Method : restViewCloseOut ends");
		return closeoutdao.viewCloseOut();
	}
	
	//CRUD operations
	
	//add
	
	@RequestMapping(value = "rest-addCloseOut", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restCloseOutadd(
			@RequestBody CloseOutRestModel CloseOut) {
		logger.info("Method : restaddCloseOut starts");

		logger.info("Method : restaddCloseOut ends");
		return closeoutdao.restCloseOutadd(CloseOut);
	}
	
	// crud-view

		@RequestMapping(value = "rest-closeOutLesson-view", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> viewCloseOutLesson() {
			logger.info("Method : restViewCloseOutLesson starts");

			logger.info("Method : restViewCloseOutLesson ends");
			return closeoutdao.viewCloseOutLesson();
		}
		
		//CRUD-EDIT
		
		@RequestMapping(value = "rest-closeOutLesson-edit", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> editCloseOutLesson(@RequestParam String id) {
			logger.info("Method : edit starts");
			System.out.println("IDDDDDD=" + id);
			logger.info("Method : edit ends");
			return closeoutdao.editCloseOutLesson(id);

		}
		
		//CRUD-DELETE
		
		@RequestMapping(value = "rest-closeOutLesson-delete", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteCloseOutLesson(@RequestParam String id) {
			logger.info("Method : restdeleteCloseOut starts");

			logger.info("Method : restdeleteCloseOut ends");
			return closeoutdao.deleteCloseOutLesson(id);
		}
		
		
		//COPY-VIEW
				@RequestMapping(value="rest-close-out-project-view-data" , method = {RequestMethod.GET})
				public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> projectViewData(@RequestParam String id){
					logger.info("Method: projectViewData View Start");
					
					logger.info("Method: projectViewData View ends");
					return closeoutdao.projectViewDataDao(id);
				}
				
		//COPY-ADD
		
		@PostMapping(value = "rest-project-add-data")
		public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> addProjectData(
				@RequestBody List<CloseOutRestModel> model) {
			logger.info("Method :addProjectData starts");
			
			logger.info("Method :addProjectData endss");
			return closeoutdao.addProjectDataDao(model);
		}
		
}
