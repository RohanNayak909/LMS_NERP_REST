package nirmalya.aatithya.restmodule.training.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.training.dao.YourTrainingDao;

@RestController
@RequestMapping(value = "training/")
public class YourTrainingRestController {

	Logger logger = LoggerFactory.getLogger(YourTrainingRestController.class);

	@Autowired
	YourTrainingDao yourTrainingDao;

	/*
	 * get all employee list
	 * 	
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "view-assigned-employee-list")
	public JsonResponse getEmployeeList(
			@RequestParam String organization, @RequestParam String orgDivision,@RequestParam String state,@RequestParam String userId) {
		logger.info("Method : view-assigned-employee-list starts");

		logger.info("Method : view-assigned-employee-list ends");
		return yourTrainingDao.getAssignedEmployeeListDao(organization, orgDivision,state ,userId);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "get-category-doc-details")
	public JsonResponse getAssignedCategoryDetails(@RequestParam String organization,@RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method in rest: getAssignedCategoryDetails starts");

		logger.info("Method in rest: getAssignedCategoryDetails ends");
		return yourTrainingDao.getCategoryDetails(organization, orgDivision,id);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "get-category-doc-list")
	public JsonResponse getAssignedEmployeeDetails(@RequestParam String organization,@RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method in rest: getAssignedEmployeeDetails starts");

		logger.info("Method in rest: getAssignedEmployeeDetails ends");
		return yourTrainingDao.getCategoryDocs(organization, orgDivision,id);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "set-training-start-data")
	public JsonResponse setTrainingStartingData(@RequestParam String organization,@RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method in rest: setTrainingStartingData starts");

		logger.info("Method in rest: setTrainingStartingData ends");
		return yourTrainingDao.setStartingData(organization, orgDivision,id);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "training-count-save")
	public JsonResponse saveTrainingCount(@RequestParam String organization,@RequestParam String orgDivision,@RequestParam String count,@RequestParam String sId) {
		logger.info("Method in rest: saveTrainingCount starts");

		logger.info("Method in rest: saveTrainingCount ends");
		return yourTrainingDao.saveTrainingCount(organization, orgDivision,count,sId);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-finish-training")
	public JsonResponse finishTraining(@RequestParam String organization,@RequestParam String orgDivision,@RequestParam String schId) {
		logger.info("Method in rest: finishTraining starts");

		logger.info("Method in rest: finishTraining ends");
		return yourTrainingDao.finishTraining(organization, orgDivision,schId);
	}
}