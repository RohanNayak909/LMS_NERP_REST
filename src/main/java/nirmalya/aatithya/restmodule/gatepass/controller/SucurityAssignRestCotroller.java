package nirmalya.aatithya.restmodule.gatepass.controller;

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
import nirmalya.aatithya.restmodule.gatepass.dao.SecurityAssignDao;
import nirmalya.aatithya.restmodule.gatepass.model.RestSecurityAssignModel;

@RestController
@RequestMapping("gatepass/")
public class SucurityAssignRestCotroller {
	Logger logger = LoggerFactory.getLogger(SucurityAssignRestCotroller.class);

	@Autowired
	SecurityAssignDao securityAssignDao;

	@GetMapping(value = "getpostGateLists")
	public List<DropDownModel> getpostGateLists(@RequestParam String org, String orgDiv) {
		logger.info("Method : getpostGateLists starts");
		logger.info("Method : getpostGateLists endss");
		return securityAssignDao.getpostGateLists(org, orgDiv);
	}

	@GetMapping(value = "getSecurityName")
	public List<DropDownModel> getSecurityName(@RequestParam String org, String orgDiv) {
		logger.info("Method : getSecurityName starts");
		logger.info("Method : getSecurityName endss");
		return securityAssignDao.getSecurityName(org, orgDiv);
	}

	/*
	 * 
	 * PostMapping for add rest ItemRequisition
	 * 
	 * 
	 */
	@PostMapping(value = "rest-saveSecurityAssign")
	public ResponseEntity<JsonResponse<List<RestSecurityAssignModel>>> saveSecurityAssign(
			@RequestBody List<RestSecurityAssignModel> restSecurityAssignModel) {
		logger.info("Method : saveSecurityAssign starts");
		logger.info("Method : saveSecurityAssign ends");
		return securityAssignDao.saveSecurityAssign(restSecurityAssignModel);
	}

	// view ProductItem Data

	@RequestMapping(value = "viewSecurityAssign", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSecurityAssign(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewSecurityAssign start");

		logger.info("Method :viewSecurityAssign endss");
		return securityAssignDao.viewSecurityAssign(orgName, orgDivision);

	}

	// View allocation data
	@RequestMapping(value = "rest-editSecurityAssign", method = { RequestMethod.GET })
	public JsonResponse editSecurityAssign(@RequestParam String assignId, String org, String orgDiv) {
		logger.info("Method :editSecurityAssign start");

		logger.info("Method :editSecurityAssign endss");
		return securityAssignDao.editSecurityAssign(assignId, org, orgDiv);

	}

	@RequestMapping(value = "rest-assign-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> getAssignPdfDetails(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getAssignPdfDetails start");

		logger.info("Method :getAssignPdfDetails endss");
		return securityAssignDao.getAssignPdfDetails(id, orgName, orgDivision);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteAssignDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssignDetails(@RequestParam String id) {
		logger.info("Method : deleteAssignDetails starts");

		
		logger.info("Method : deleteAssignDetails ends");
		return securityAssignDao.deleteAssignDetails(id);
	}

	// approve

	@GetMapping(value = "approveAssign")
	public JsonResponse<DropDownModel> approveAssign(@RequestParam String approveStatus, String securityAssignId,
			String orgName, String orgDivision) {
		logger.info("Method : approveAssign starts");
		System.out.println("value===" + approveStatus);
		System.out.println("value===" + securityAssignId);
		System.out.println("value===" + orgName);
		System.out.println("value===" + orgDivision);
		logger.info("Method : approveAssign ends");
		return securityAssignDao.approveAssign(approveStatus,securityAssignId,orgName,orgDivision);
	}
	
	@RequestMapping(value = "getSecurityNameList",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSecurityNameList(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method : getSecurityNameList starts");
		logger.info("Method : getSecurityNameList ends");
		return securityAssignDao.getSecurityNameList(id,orgName,orgDivision);
	}
	

}
