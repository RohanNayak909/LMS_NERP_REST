package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestGoalMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestGoalMastersModel;
import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;

@RestController
@RequestMapping(value = "master/")
public class RestGoalMasterController {
	Logger logger = LoggerFactory.getLogger(RestGoalMasterController.class);

	@Autowired
	RestGoalMasterDao restGoalMasterDao;

	
	// Post mapping foe view Goal Master

	@GetMapping(value = "rest-viewGoalMaster")
	public JsonResponse<List<RestGoalMastersModel>> viewGoalMaster() {
		logger.info("Method : viewGoalMaster");

		logger.info("Method : viewGoalMaster ends");
		return restGoalMasterDao.viewGoalMaster();
	}
	
	
	
	// add
		
		@RequestMapping(value = "rest-addGoalMaster", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addsalaryrevision(@RequestBody RestGoalMastersModel restPayroll) {
			logger.info("Method : addGoalMaster starts");

			logger.info("Method : addGoalMaster ends");
			return restGoalMasterDao.addGoalMaster(restPayroll);
		}
		
	

		
		/*
		 *
		 * Edit  rest
		 *
		 */
	
	@RequestMapping(value = "rest-GoalMaster-edit", method = { RequestMethod.GET })
	public JsonResponse<RestGoalMastersModel> editGoalMaster(@RequestParam String id) {
		logger.info("Method : editGoalMaster rest starts");

		logger.info("Method :editGoalMaster rest ends");
		return restGoalMasterDao.editGoalMaster(id);
	}
	 
		
	
	// delete

	@RequestMapping(value = "rest-GoalMaster-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGoalMaster(@RequestParam String id) {
		logger.info("Method : deleteGoalMaster starts");

		logger.info("Method : deleteGoalMaster ends");
		return restGoalMasterDao.deleteGoalMaster(id);
	}
	 
}
