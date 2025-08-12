package nirmalya.aatithya.restmodule.employee.controller;

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
import nirmalya.aatithya.restmodule.employee.dao.RestGradeSalaryNewDao;
import nirmalya.aatithya.restmodule.employee.model.RestGradeSalaryNewMasterModel;

@RestController
@RequestMapping("employee/")
public class RestGradeSalaryNewController {
	Logger logger = LoggerFactory.getLogger(RestGradeSalaryNewController.class);

	@Autowired
	RestGradeSalaryNewDao restGradeSalaryNewDao;

	@RequestMapping(value = "getGradeNameNewList", method = { RequestMethod.GET })
	public List<DropDownModel> getGradeNameNewList() {

		logger.info("Method : getGradeNameNewList starts");
		logger.info("Method : getGradeNameNewList ends");

		return restGradeSalaryNewDao.getGradeNameNewList();
	}

	@RequestMapping(value = "getComponenmewtList", method = { RequestMethod.GET })
	public List<DropDownModel> getComponenmewtList() {

		logger.info("Method : getComponenmewtList starts");
		logger.info("Method : getComponenmewtList ends");

		return restGradeSalaryNewDao.getComponenmewtList();
	}

	@RequestMapping(value = "getCalnewtList", method = { RequestMethod.GET })
	public List<DropDownModel> getCalnewtList() {

		logger.info("Method : getCalnewtList starts");
		logger.info("Method : getCalnewtList ends");

		return restGradeSalaryNewDao.getCalnewtList();
	}

	@RequestMapping(value = "getGradeDescription", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGradeDescription(@RequestParam String id) {
		logger.info("Method : getGradeDescription starts");

		logger.info("Method : getGradeDescription endss");
		return restGradeSalaryNewDao.getGradeDescription(id);
	}

	@RequestMapping(value = "getgrdsalComponentType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGradeSalaryNewMasterModel>>> getgrdsalComponentType(
			@RequestParam String id) {
		logger.info("Method : getgrdsalComponentType starts");

		logger.info("Method : getgrdsalComponentType endss");
		return restGradeSalaryNewDao.getgrdsalComponentType(id);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addgrdSalarynew")
	public ResponseEntity<JsonResponse<List<RestGradeSalaryNewMasterModel>>> addgrdSalarynew(
			@RequestBody List<RestGradeSalaryNewMasterModel> restGradeSalaryNewMasterModel) {
		logger.info("Method :addgrdSalarynew starts");
		logger.info("Method :addgrdSalarynew endss");
		return restGradeSalaryNewDao.addgrdSalarynew(restGradeSalaryNewMasterModel);
	}

	/*
	 * view
	 * 
	 */
	@GetMapping(value = "getAllgrdsal")
	public JsonResponse<List<RestGradeSalaryNewMasterModel>> getAllgrdsal() {
		logger.info("Method :getAllgrdsal starts");

		logger.info("Method :getAllgrdsal endss");
		return restGradeSalaryNewDao.getAllgrdsal();

	}

	/*
	 * edit
	 */
	@GetMapping(value = "viewgrdSalEdit")
	public List<RestGradeSalaryNewMasterModel> viewgrdSalEdit(@RequestParam String id) {
		logger.info("Method : viewgrdSalEdit starts");
		logger.info(id);
		logger.info("Method : viewgrdSalEdit endss");
		return restGradeSalaryNewDao.viewgrdSalEdit(id);
	}
	

	/*
	 * delete
	 */
	  
	
	@GetMapping(value = "deletegrdsal")
	 public JsonResponse<RestGradeSalaryNewMasterModel> deletegrdsal(@RequestParam String id) {
		logger.info("Method : deletegrdsal starts");

		logger.info("Method : deletegrdsal ends");
		return restGradeSalaryNewDao.deletegrdsal(id); 
	} 

}
