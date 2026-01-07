package nirmalya.aatithya.restmodule.pipeline.controller;

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
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmTaskController {
	Logger logger = LoggerFactory.getLogger(RestCrmTaskController.class);
	@Autowired
	RestCrmTaskDao restCrmTaskDao;

	
	/**
	 * Post Mapping to Add new addDeal
	 *
	 */
	// add

	@PostMapping(value = "/addTask")
	public JsonResponse<Object> addTask(@RequestBody RestCrmTaskModel task) {
		logger.info("Method : addTask starts");
		
		logger.info("value for add task controller-------------"+task);

		logger.info("Method : addTask ends");
		return restCrmTaskDao.addTask(task);
	}
	
	
	//getLeadNameList
	
	@RequestMapping(value = "getLeadNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadNameList(@RequestParam String userId,@RequestParam String org, @RequestParam String orgDiv) {
		
		logger.info("Method : getLeadNameList starts");
		logger.info("Method : getLeadNameList ends");
		
		return restCrmTaskDao.getLeadNameList(userId,org, orgDiv);
	}
	
	
	//restViewTaskdetails
	

/*
	 * for view
	 */
	@RequestMapping(value="restViewTaskdetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> restViewTaskdetails(@RequestParam String pageno,@RequestParam String userId,
			@RequestParam String orgName,@RequestParam String orgDivision){
		logger.info("Method: restViewTaskdetails View Start");
		
		logger.info("Method: restViewTaskdetails ends");
		return restCrmTaskDao.restViewTaskdetails(pageno,userId,orgName,orgDivision);
	}

	
	//editTaskInfo
			
	@GetMapping(value = "editTaskInfo")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> editTaskInfo(@RequestParam String id) {
		logger.info("Method :editTaskInfo starts");

		logger.info("Method :editTaskInfo ends"+id);
		return restCrmTaskDao.editTaskInfo(id);

	}
	
	//delete-task-Details
	
	@RequestMapping(value = "delete-task-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTaskDetails(@RequestParam String id) {
		logger.info("Method :  deleteTaskDetails starts"+id);

		logger.info("Method :  deleteTaskDetails ends");
		return restCrmTaskDao.deleteTaskDetails(id);
	}
	
	
	
}
