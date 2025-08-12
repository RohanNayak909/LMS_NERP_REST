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
import nirmalya.aatithya.restmodule.master.dao.SelfAppraisalKeyFactorDao;
import nirmalya.aatithya.restmodule.master.model.AppraisalKeyFactorRestModel;

@RestController
@RequestMapping(value = "master/")
public class SelfAppraisalKeyFactorRectController {
	Logger logger = LoggerFactory.getLogger(SelfAppraisalKeyFactorRectController.class);
	
	@Autowired
	SelfAppraisalKeyFactorDao SelfAppraisalKeyFactorDao;
	

	@RequestMapping(value = "rest-getSelfAppraisalData", method = { RequestMethod.GET })
	public JsonResponse<Object> getAppraisalData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAppraisalData start");

		logger.info("Method :getAppraisalData endss");
		return SelfAppraisalKeyFactorDao.getAppraisalData(orgName, orgDivision);
	}

	@PostMapping(value = "rest-SelfappraisalKeyfactorAdd")
	public ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>> appraisalKeyfactorAdd(
			@RequestBody List<AppraisalKeyFactorRestModel> assetPolicyModel) {
		logger.info("Method : appraisalKeyfactorAdd starts");
		logger.info("Method : appraisalKeyfactorAdd ends");
		return SelfAppraisalKeyFactorDao.appraisalKeyfactorAdd(assetPolicyModel);
	}
	
	@RequestMapping(value = "rest-viewSelfAppraisalData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAppraisalData(@RequestParam String orgName, String orgDivision,@RequestParam String userid) {
		logger.info("Method :getAppraisalData start");

		logger.info("Method :getAppraisalData endss");
		return SelfAppraisalKeyFactorDao.viewAppraisalData(orgName, orgDivision,userid);
	}
	
	
	@RequestMapping(value = "rest-editSelfAppraisalData", method = { RequestMethod.GET })
	public JsonResponse<Object> editAppraisalData(@RequestParam String orgName, String orgDivision,String id,String assignid) {
		logger.info("Method :editAppraisalData start");

		logger.info("Method :editAppraisalData endss");
		return SelfAppraisalKeyFactorDao.editAppraisalData(orgName, orgDivision,id,assignid);
	}
	
	@RequestMapping(value = "rest-approveSelfAppraisal", method = { RequestMethod.GET })
	public JsonResponse<Object> approveAppraisal(@RequestParam String orgName, String orgDivision,String id) {
		logger.info("Method :approveAppraisal start");

		logger.info("Method :approveAppraisal endss");
		return SelfAppraisalKeyFactorDao.approveAppraisal(orgName, orgDivision,id);
	}
	
	@RequestMapping(value = "rest-getSelfAssignEmployeeList", method = { RequestMethod.GET })
	public JsonResponse<Object> getAssignEmployeeList(@RequestParam String orgName, String orgDivision,String id) {
		logger.info("Method :getAssignEmployeeList start");

		logger.info("Method :getAssignEmployeeList endss");
		return SelfAppraisalKeyFactorDao.getAssignEmployeeList(orgName, orgDivision,id);
	}
	
	
	@RequestMapping(value = "rest-SelfemployeeAssign", method = { RequestMethod.GET })
	public JsonResponse<Object> employeeAssign(@RequestParam String orgName, String orgDivision,String categoryId,String empId,String userId) {
		logger.info("Method :employeeAssign start" + empId);

		logger.info("Method :employeeAssign endss");
		return SelfAppraisalKeyFactorDao.employeeAssign(orgName, orgDivision,categoryId,empId,userId);
	}
	
	@RequestMapping(value = "self-appraisal-keyfactor-assignView", method = { RequestMethod.GET })
	public JsonResponse<Object> assignEmployeeView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAppraisalData start");

		logger.info("Method :assignEmployeeView endss");
		return SelfAppraisalKeyFactorDao.assignEmployeeView(orgName, orgDivision);
	}

	@RequestMapping(value = "rest-edit-self-appraisal", method = { RequestMethod.GET })
	public JsonResponse<Object> editSelfAppraisalData(@RequestParam String orgName, String orgDivision,String id,String factorId) {
		logger.info("Method :editSelfAppraisalData start");

		logger.info("Method :editSelfAppraisalData endss");
		return SelfAppraisalKeyFactorDao.editSelfAppraisalData(orgName, orgDivision,id,factorId);
	}
	
	
}
