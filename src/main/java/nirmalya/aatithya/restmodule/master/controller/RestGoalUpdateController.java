package nirmalya.aatithya.restmodule.master.controller;

import java.util.ArrayList;
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
import nirmalya.aatithya.restmodule.master.dao.RestGoalUpdateDao;
import nirmalya.aatithya.restmodule.master.model.RestGoalUpdateModel;



@RestController
@RequestMapping(value = { "master" })
public class RestGoalUpdateController {
	Logger logger = LoggerFactory.getLogger(RestHrMasterController.class);

	@Autowired
	RestGoalUpdateDao restGoalUpdateDao;
	
	/*
	 * get name list
	 */
	@RequestMapping(value="getNameListU", method = {RequestMethod.GET })
	public List<DropDownModel> getNameList(@RequestParam String id){
		logger.info("Method : getNameListU starts");
		
		logger.info("Method : getNameListU ends");
		return restGoalUpdateDao.getNameListU(id);
	}
	/*
	 * get name list
	 */
	@RequestMapping(value="getdesignationList", method = {RequestMethod.GET })
	public List<DropDownModel> getdesignationList(){
		logger.info("Method : getdesignationList starts");
		
		logger.info("Method : getdesignationList ends");
		return restGoalUpdateDao.getdesignationList();
	}
	/*
	 * get designation list on change of name
	 */
	@GetMapping(value = "get-designation-listU")
	public JsonResponse<List<RestGoalUpdateModel>> getDesignationList(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return restGoalUpdateDao.getDesignationList(id);
	}
	/*
	 * get recommendation
	 */
	@GetMapping(value = "get-recommendation")
	public JsonResponse<List<RestGoalUpdateModel>> getRecommendation(@RequestParam String id) {
		logger.info("Method : getRecommendation starts");

		logger.info("Method : getRecommendation ends");
		return restGoalUpdateDao.getRecommendation(id);
	}
	/*
	 * view update ag-grid data
	 */
	@RequestMapping(value = "viewUpdateData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGoalUpdateModel>>> viewUpdateData(@RequestParam String name) {
		logger.info("Method : viewUpdateData starts");

		logger.info("Method : viewUpdateData ends");
		return restGoalUpdateDao.viewUpdateData(name);
	}
	/*
	 * final submit goal update
	 */
	@PostMapping(value = "addGoalUpdate")
	public ResponseEntity<JsonResponse<List<RestGoalUpdateModel>>> saveGoalUpdate(@RequestBody List<RestGoalUpdateModel> restGoalUpdate) {
		logger.info("Method :saveGoalUpdate starts");
		logger.info("Method :saveGoalOneToOne endss");
		return restGoalUpdateDao.saveGoalUpdate(restGoalUpdate);
	}

}
