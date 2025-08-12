package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.model.noiseMonitorReportModel;
import nirmalya.aatithya.restmodule.master.dao.AppraisalKeyFactorDao;
import nirmalya.aatithya.restmodule.master.model.AppraisalKeyFactorRestModel;

@RestController
@RequestMapping(value = "master/")
public class AppraisalKeyFactorRestController {
	Logger logger = LoggerFactory.getLogger(AppraisalKeyFactorRestController.class);
	
	@Autowired
	AppraisalKeyFactorDao AppraisalKeyFactorDao;
	

	@RequestMapping(value = "rest-getAppraisalData", method = { RequestMethod.GET })
	public JsonResponse<Object> getAppraisalData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAppraisalData start");

		logger.info("Method :getAppraisalData endss");
		return AppraisalKeyFactorDao.getAppraisalData(orgName, orgDivision);
	}

	@PostMapping(value = "rest-appraisalKeyfactorAdd")
	public ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>> appraisalKeyfactorAdd(
			@RequestBody List<AppraisalKeyFactorRestModel> assetPolicyModel) {
		logger.info("Method : appraisalKeyfactorAdd starts");
		logger.info("Method : appraisalKeyfactorAdd ends");
		return AppraisalKeyFactorDao.appraisalKeyfactorAdd(assetPolicyModel);
	}
	
	@RequestMapping(value = "rest-viewAppraisalData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAppraisalData(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :getAppraisalData start");

		logger.info("Method :getAppraisalData endss");
		return AppraisalKeyFactorDao.viewAppraisalData(orgName, orgDivision, userId);
	}
	
	
	@RequestMapping(value = "rest-editAppraisalData", method = { RequestMethod.GET })
	public JsonResponse<Object> editAppraisalData(@RequestParam String orgName, String orgDivision,String id) {
		logger.info("Method :editAppraisalData start");

		logger.info("Method :editAppraisalData endss");
		return AppraisalKeyFactorDao.editAppraisalData(orgName, orgDivision,id);
	}
	
	@RequestMapping(value = "rest-approveAppraisal", method = { RequestMethod.GET })
	public JsonResponse<Object> approveAppraisal(@RequestParam String orgName, String orgDivision,String id) {
		logger.info("Method :approveAppraisal start");

		logger.info("Method :approveAppraisal endss");
		return AppraisalKeyFactorDao.approveAppraisal(orgName, orgDivision,id);
	}
	
	@RequestMapping(value = "rest-getAssignEmployeeList", method = { RequestMethod.GET })
	public JsonResponse<Object> getAssignEmployeeList(@RequestParam String orgName, String orgDivision,String id) {
		logger.info("Method :getAssignEmployeeList start");

		logger.info("Method :getAssignEmployeeList endss");
		return AppraisalKeyFactorDao.getAssignEmployeeList(orgName, orgDivision,id);
	}
	
	
	@RequestMapping(value = "rest-employeeAssign", method = { RequestMethod.GET })
	public JsonResponse<Object> employeeAssign(@RequestParam String orgName, String orgDivision,String categoryId,String staffId,String userId) {
		logger.info("Method :employeeAssign start" + staffId);

		logger.info("Method :employeeAssign endss");
		return AppraisalKeyFactorDao.employeeAssign(orgName, orgDivision,categoryId,staffId,userId);
	}
	
	@RequestMapping(value = "rest-assignEmployeeView", method = { RequestMethod.GET })
	public JsonResponse<Object> assignEmployeeView(@RequestParam String orgName, String orgDivision,@RequestParam String categoryId) {
		logger.info("Method :getAppraisalData start" + categoryId);

		logger.info("Method :assignEmployeeView endss");
		return AppraisalKeyFactorDao.assignEmployeeView(orgName, orgDivision,categoryId);
	}
	
	
	@RequestMapping(value = "rest-apprisalDelete", method = { RequestMethod.GET })
	public JsonResponse<Object> apprisalDelete(@RequestParam String orgName, String orgDivision,String id) {
		logger.info("Method :apprisalDelete start");

		logger.info("Method :apprisalDelete endss");
		return AppraisalKeyFactorDao.apprisalDelete(orgName, orgDivision,id);
	}
}
