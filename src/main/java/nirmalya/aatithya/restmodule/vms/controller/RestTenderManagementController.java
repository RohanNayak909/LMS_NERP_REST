package nirmalya.aatithya.restmodule.vms.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.vms.dao.RestTenderManagementDao;

@RestController
@RequestMapping(value = { "purchase/" })
public class RestTenderManagementController {

	Logger logger = LoggerFactory.getLogger(RestTenderManagementController.class);

	@Autowired
	RestTenderManagementDao restTenderManagementDao;

	@PostMapping(value = "save-tender-details")
	public ResponseEntity<JsonResponse<Object>> saveTenderData(@RequestBody String data, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveTenderData starts");
		logger.info("Method :saveTenderData endss");
		return restTenderManagementDao.saveTender(data, userId, org, orgDiv);
	}

	@RequestMapping(value = "get-tender-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getTenderDetails(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String fromDate, @RequestParam String toDate) {

		logger.info("Method :getTenderDetails starts");

		logger.info("Method :getTenderDetails endss");
		return restTenderManagementDao.getTenderDetails(org, orgDiv, userId,fromDate,toDate);
	}

	@PostMapping(value = "update-tender-details")
	public ResponseEntity<JsonResponse<Object>> updateTenderData(@RequestBody String data, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :updateTenderData starts");
		logger.info("Method :updateTenderData endss");
		return restTenderManagementDao.updateTenderData(data, userId, org, orgDiv);
	}

	@PostMapping(value = "update-criteria-tender-details")
	public ResponseEntity<JsonResponse<Object>> updateCriteriaTenderData(@RequestBody String criteriaData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :updateCriteriaTenderData starts");
		logger.info("Method :updateCriteriaTenderData endss");
		return restTenderManagementDao.updateCriteriaTenderData(criteriaData, userId, org, orgDiv);
	}

	@RequestMapping(value = "save-tender-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> saveTenderPdf(@RequestParam String filePath, @RequestParam String tenderId,
			@RequestParam String userId) {

		logger.info("Method :saveTenderPdf starts");

		logger.info("Method :saveTenderPdf endss");
		return restTenderManagementDao.saveTenderPdf(filePath, tenderId, userId);
	}

	@RequestMapping(value = "get-AlltenderData", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllTendersData(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String status) {

		logger.info("Method :getAllTendersData For Vendor starts");

		logger.info("Method :getAllTendersData For Vendor endss");
		return restTenderManagementDao.getAllTendersData(org, orgDiv, userId, status);
	}

	@PostMapping(value = "save-vendors-tender-activity")
	public ResponseEntity<JsonResponse<Object>> saveVenderActivityForTender(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveVenderActivityForTender starts");
		logger.info("Method :saveVenderActivityForTender endss");
		return restTenderManagementDao.saveVendorActivity(data, userId, org, orgDiv);
	}

	@RequestMapping(value = "get-All-AppliedVendorData", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllAppliedVendorData(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String tenderId, @RequestParam String status) {

		logger.info("Method :getAllAppliedVendorData For Vendor starts");

		logger.info("Method :getAllAppliedVendorData For Vendor endss");
		return restTenderManagementDao.getAllAppliedVendorData(org, orgDiv, userId, tenderId, status);
	}

	@PostMapping(value = "assign-vendor-details")
	public ResponseEntity<JsonResponse<Object>> assignVendorDetails(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String vendorRemarks ,@RequestParam String cancelledVendors) {
		logger.info("Method :assignVendorDetails starts");
		logger.info("Method :assignVendorDetails endss");
		return restTenderManagementDao.assignVendorDetails(data, userId, org, orgDiv, vendorRemarks,cancelledVendors);
	}
	
	@RequestMapping(value = "getAssignUserList", method = { RequestMethod.GET })
	public JsonResponse<Object> getAssignUserList(@RequestParam String id, @RequestParam String orgName,
			@RequestParam String orgDivision) {

		logger.info("Method :getAssignUserList For Vendor starts");

		logger.info("Method :getAssignUserList For Vendor endss");
		return restTenderManagementDao.getAssignUserList(id, orgName, orgDivision);
	}

	
	@PostMapping(value = "rest-evalutionUserAdd")
	public ResponseEntity<JsonResponse<Object>> evalutionUserAdd(@RequestBody String compliance,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv,@RequestParam String id) {
		logger.info("Method :evalutionUserAdd starts");
		logger.info("Method :evalutionUserAdd endss");
		return restTenderManagementDao.evalutionUserAdd(compliance, userId, org, orgDiv,id);
	}
	
	@PostMapping(value = "rest-assignUserEvalutionDetailsAdd")
	public ResponseEntity<JsonResponse<Object>> assignUserEvalutionDetailsAdd(@RequestBody String evalutionDetails,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv,@RequestParam String id) {
		logger.info("Method :assignUserEvalutionDetailsAdd starts");
		logger.info("Method :assignUserEvalutionDetailsAdd endss");
		return restTenderManagementDao.assignUserEvalutionDetailsAdd(evalutionDetails, userId, org, orgDiv,id);
	}
	
	
	@RequestMapping(value = "fetchAppliedTenderVendors", method = { RequestMethod.GET })
	public JsonResponse<Object> fetchAppliedTenderVendors(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String tenderId) {

		logger.info("Method :fetchAppliedTenderVendors For Vendor starts");

		logger.info("Method :fetchAppliedTenderVendors For Vendor endss");
		return restTenderManagementDao.fetchAppliedTenderVendors(org, orgDiv, userId, tenderId);
	}
	
	@RequestMapping(value = "vendorevalutiondetails", method = { RequestMethod.GET })
	public JsonResponse<Object> vendorevalutiondetails(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String tenderId,@RequestParam String vendorId) {

		logger.info("Method :vendorevalutiondetails For Vendor starts");

		logger.info("Method :vendorevalutiondetails For Vendor endss");
		return restTenderManagementDao.vendorevalutiondetails(org, orgDiv, userId, tenderId,vendorId);
	}
	
	
	@PostMapping(value = "rest-vendortrackingstatus")
	public ResponseEntity<JsonResponse<Object>> vendortrackingstatus(@RequestBody String compliance,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :vendortrackingstatus starts");
		logger.info("Method :vendortrackingstatus endss");
		return restTenderManagementDao.vendortrackingstatus(compliance, userId, org, orgDiv);
	}
	
	@PostMapping(value = "rest-vendorAllocationDetails")
	public ResponseEntity<JsonResponse<Object>> vendorAllocationDetails(@RequestBody String data,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :vendorAllocationDetails starts");
		logger.info("Method :vendorAllocationDetails endss");
		return restTenderManagementDao.vendorAllocationDetails(data, userId, org, orgDiv);
	}
}
