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
import nirmalya.aatithya.restmodule.master.dao.RestOneToOneDao;
import nirmalya.aatithya.restmodule.master.model.RestGoalReviewModel;
import nirmalya.aatithya.restmodule.master.model.RestOneToOneModel;

@RestController
@RequestMapping(value = { "master" })
public class RestGoalOneToOneController {
	Logger logger = LoggerFactory.getLogger(RestGoalFeedbackController.class);

	@Autowired
	RestOneToOneDao restOneToOneDao;

	/*
	 * get name list
	 */
	@RequestMapping(value="getNameListO", method = {RequestMethod.GET })
	public List<DropDownModel> getNameList(){
		logger.info("Method : getNameListO starts");
		
		logger.info("Method : getNameListO ends");
		return restOneToOneDao.getNameListO();
	}
	/*
	 * get designation list on change of name
	 */
	@GetMapping(value = "get-designation-listO")
	public JsonResponse<List<DropDownModel>> getDesignationList(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return restOneToOneDao.getDesignationList(id);
	}
	/*
	 * view onetoone ag-grid data
	 */
	@RequestMapping(value = "viewOneToOneData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestOneToOneModel>>> viewOneToOneData(@RequestParam String name) {
		logger.info("Method : viewOneToOneData starts");

		logger.info("Method : viewOneToOneData ends");
		return restOneToOneDao.viewOneToOneData(name);
	}
	/*
	 * final submit goal onetoone
	 */
	@PostMapping(value = "addGoalOneToOne")
	public ResponseEntity<JsonResponse<List<RestOneToOneModel>>> saveGoalOneToOne(@RequestBody List<RestOneToOneModel> restGoalOneToOne) {
		logger.info("Method :saveGoalOneToOne starts");
		logger.info("Method :saveGoalOneToOne endss");
		return restOneToOneDao.saveGoalOneToOne(restGoalOneToOne);
	}
}
