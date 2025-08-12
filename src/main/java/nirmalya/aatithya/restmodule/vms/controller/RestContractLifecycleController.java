package nirmalya.aatithya.restmodule.vms.controller;

import java.util.List;
import java.util.Map;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.vms.dao.RestContractLifecycleDao;

@RestController
@RequestMapping(value = { "purchase/" })
public class RestContractLifecycleController {

	Logger logger = LoggerFactory.getLogger(RestContractLifecycleController.class);

	@Autowired
	RestContractLifecycleDao restContractLifecycleDao;

	@RequestMapping(value = "rest-getTenderList", method = { RequestMethod.GET })
	public List<DropDownModel> getPolicyList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getPolicyList starts");

		logger.info("Method : getPolicyList ends");
		return restContractLifecycleDao.getPolicyList(org, orgDiv);
	}

	// save-contract-details
	@PostMapping(value = "save-contract-details")
	public ResponseEntity<JsonResponse<Object>> saveContractData(@RequestBody String data, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveContractData starts");
		logger.info("Method :saveContractData endss");
		return restContractLifecycleDao.saveContract(data, userId, org, orgDiv);
	}

	// get-Contract-details
	@RequestMapping(value = "get-Contract-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getContractDetails(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId,@RequestParam String fromDate,@RequestParam String toDate) {

		logger.info("Method :getContractDetails starts");

		logger.info("Method :getContractDetails endss");
		return restContractLifecycleDao.getContractDetails(org, orgDiv, userId,fromDate,toDate);
	}

	// update-contract-details
	@PostMapping(value = "update-contract-details")
	public ResponseEntity<JsonResponse<Object>> updateContractData(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :updateContractData starts");
		logger.info("Method :updateContractData endss");
		return restContractLifecycleDao.updateContractData(data, userId, org, orgDiv);
	}

	@RequestMapping(value = "save-contract-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> saveContractPdf(@RequestParam String filePath, @RequestParam String contractIds,
			@RequestParam String userId,@RequestParam String org,@RequestParam String orgDiv,@RequestParam String vendor) {

		logger.info("Method :saveContractPdf starts");

		logger.info("Method :saveContractPdf endss");
		return restContractLifecycleDao.saveContractPdf(filePath, contractIds, userId,org,orgDiv,vendor);
	}
	
	@RequestMapping(value = "getVendorLists", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorLists(@RequestParam String id) {
		logger.info("Method : getVendorList starts");
		logger.info("Method : getVendorList ends");
		return restContractLifecycleDao.getVendorLists(id);
	}
	
	
	//view-contract-details
	@RequestMapping(value = "view-contract-details", method = { RequestMethod.GET })
	public JsonResponse<Object> geContractVersionDetails(@RequestParam String contractId, @RequestParam String vendorId,@RequestParam String userId) {

		logger.info("Method :geContractVersionDetails starts");

		logger.info("Method :geContractVersionDetails endss");
		return restContractLifecycleDao.geContractVersionDetails(contractId,vendorId,userId);
	}
	
	
	@RequestMapping(value = "get-assign-approval-emp", method = { RequestMethod.GET })
	public JsonResponse<Object> getAssignApproveUser(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId) {

		logger.info("Method :getAssignApproveUser starts");

		logger.info("Method :getAssignApproveUser endss");
		return restContractLifecycleDao.getAssignApproveUser(org, orgDiv, userId);
	}
	
	
	@RequestMapping(value = "workflow-contract-approval", method = { RequestMethod.GET })
	public JsonResponse<Object> contractApproval(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId,@RequestParam String id) {

		logger.info("Method :contractApproval starts");

		logger.info("Method :contractApproval endss");
		return restContractLifecycleDao.contractApproval(org, orgDiv, userId,id);
	}
	
	
	@RequestMapping(value = "get-approve-Contract-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getApprovedContract(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId,@RequestParam String fromDate,@RequestParam String toDate) {

		logger.info("Method :getApprovedContract starts");

		logger.info("Method :getApprovedContract endss");
		return restContractLifecycleDao.getApprovedContract(org, orgDiv, userId,fromDate,toDate);
	}
	
	
	
	@PostMapping(value = "rest-complianceadd")
	public ResponseEntity<JsonResponse<Object>> complianceadd(@RequestBody String compliance,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :complianceadd starts");
		logger.info("Method :complianceadd endss");
		return restContractLifecycleDao.complianceadd(compliance, userId, org, orgDiv);
	}
	
	@PostMapping(value = "rest-riskAssesmentAdd")
	public ResponseEntity<JsonResponse<Object>> riskAssesmentAdd(@RequestBody String compliance,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :riskAssesmentAdd starts");
		logger.info("Method :riskAssesmentAdd endss");
		return restContractLifecycleDao.riskAssesmentAdd(compliance, userId, org, orgDiv);
	}
	
}
