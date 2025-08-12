package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestSelfAppraisalDao;
import nirmalya.aatithya.restmodule.master.model.RestGoalAssignModel;
import nirmalya.aatithya.restmodule.master.model.RestGoalMastersModel;
import nirmalya.aatithya.restmodule.master.model.RestSelfAppraisalModel;

@RestController
@RequestMapping(value = { "master" })
public class RestSelfAppraisalController {
	Logger logger = LoggerFactory.getLogger(RestHrMasterController.class);

	@Autowired
	RestSelfAppraisalDao restSelfAssignDao;
	
	@RequestMapping(value = "getNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getNameList(@RequestParam String id) {
		logger.info("Method : getName starts");

		logger.info("Method : getName ends");
		return restSelfAssignDao.getNameList(id);
	}
	
	@GetMapping(value = "get-designation-list")
	public JsonResponse<List<DropDownModel>> getDesignationList(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return restSelfAssignDao.getDesignationList(id);
	}
	
	@RequestMapping(value = "viewSelfAppraisalData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSelfAppraisalModel>>> viewSelfAppraisalData(@RequestParam String name) {
		logger.info("Method : viewExploreData starts");

		logger.info("Method : viewExploreData ends");
		return restSelfAssignDao.viewSelfAppraisalData(name);
	}
	@RequestMapping(value = "rest-save-selfReview", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addSelfReview(@RequestBody RestSelfAppraisalModel restSelfAppraisal) {
		logger.info("Method : addGoalAssign starts");

		logger.info("Method : addGoalAssign endss");
		return restSelfAssignDao.addSelfReview(restSelfAppraisal);
	}
	
	/*
	 *
	 * Edit  rest
	 *
	 */

@RequestMapping(value = "rest-editSelfAppraisal-edit", method = { RequestMethod.GET })
public JsonResponse<RestSelfAppraisalModel> editSelfAppraisal(@RequestParam String id) {
	logger.info("Method : editSelfAppraisal rest starts");

	logger.info("Method :editSelfAppraisal rest ends");
	return restSelfAssignDao.editSelfAppraisal(id);
}

	
}
