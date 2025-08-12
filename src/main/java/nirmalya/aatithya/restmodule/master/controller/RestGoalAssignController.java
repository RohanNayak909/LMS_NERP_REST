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
import nirmalya.aatithya.restmodule.master.dao.RestGoalAssignDao;
import nirmalya.aatithya.restmodule.master.model.RestGoalAssignModel;
import nirmalya.aatithya.restmodule.master.model.RestGoalMastersModel;
import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;

@RestController
@RequestMapping(value = { "master" })
public class RestGoalAssignController {
	Logger logger = LoggerFactory.getLogger(RestHrMasterController.class);

	@Autowired
	RestGoalAssignDao restGoalAssignDao;

	
	/*
	 * get name list
	 */
	@RequestMapping(value = "get-name-list", method = { RequestMethod.GET })
	public List<DropDownModel> getName(@RequestParam String id) {
		logger.info("Method : getName starts");

		logger.info("Method : getName ends");
		return restGoalAssignDao.getName(id);
	}

	/*
	 * get designation list
	 */
	@GetMapping(value = "get-designationList")
	public JsonResponse<List<DropDownModel>> getDesignationList(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return restGoalAssignDao.getDesignation(id);
	}
	/*
	 * view explore data
	 */
	@RequestMapping(value = "viewExploreData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> viewJobType() {
		logger.info("Method : viewExploreData starts");

		logger.info("Method : viewExploreData ends");
		return restGoalAssignDao.viewExploreData();
	}
	/*
	 * add goal to assigned table 
	 */
	@PostMapping(value = "addGoalAssign")
	public ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> addGoalAssign(@RequestBody List<RestGoalAssignModel> restaddGoalAssign) {
		logger.info("Method :addGoalMaster starts");
		logger.info("Method :addGoalMaster endss");
		return restGoalAssignDao.addGoalAssign(restaddGoalAssign);
	}
	/*
	 * view assigned data
	 */
	@RequestMapping(value = "viewAssignData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> viewAssignedData(@RequestParam String name) {
		logger.info("Method : viewAssignedData starts");

		logger.info("Method : viewAssignedData ends");
		return restGoalAssignDao.viewAssignedData(name);
	}
}
