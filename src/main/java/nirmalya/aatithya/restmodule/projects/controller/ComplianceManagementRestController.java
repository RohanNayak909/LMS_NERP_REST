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
import nirmalya.aatithya.restmodule.projects.dao.ComplianceManagementDao;
import nirmalya.aatithya.restmodule.projects.model.RestComplianceManagementModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;

@RestController
@RequestMapping("projects/")
public class ComplianceManagementRestController {
	Logger logger = LoggerFactory.getLogger(ComplianceManagementRestController.class);

	@Autowired
	ComplianceManagementDao complianceManagementDao;
	
	
	@RequestMapping(value = "get-complianceName", method = { RequestMethod.GET })
	public List<DropDownModel> complianceName() {

		logger.info("Method : complianceNameList starts");
		logger.info("Method : complianceNameList ends");

		return complianceManagementDao.complianceNameListDao();
	}
	
	
	@RequestMapping(value = "rest-saveComplianceManagement", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestComplianceManagementModel>>> saveComplianceManagement(
			@RequestBody List<RestComplianceManagementModel> compliance) {
		logger.info("Method : saveComplianceManagement starts");

		logger.info("Method : saveComplianceManagement ends");
		return complianceManagementDao.saveComplianceManagementDao(compliance);
	}
	
	@RequestMapping(value = "rest-viewCompliance", method = { RequestMethod.GET })

	public JsonResponse<Object> viewCompliance(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div,@RequestParam String id) {
		logger.info("Method :viewCompliance start");

		logger.info("Method :viewCompliance endss");
		return complianceManagementDao.viewCompliance(userid, org, div,id);
	}
	
	
	@RequestMapping(value = "rest-editCompliance", method = { RequestMethod.GET })

	public JsonResponse<Object> editCompliance(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div,@RequestParam String id) {
		logger.info("Method :editCompliance start");

		logger.info("Method :editCompliance endss");
		return complianceManagementDao.editCompliance(userid, org, div,id);
	}
	
	@RequestMapping(value = "rest-deleteCompliance", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCompliance(@RequestParam String id) {
		logger.info("Method : deleteCompliance starts"+id);

		logger.info("Method : deleteCompliance ends");
		return complianceManagementDao.deleteCompliance(id);
	}	
}
