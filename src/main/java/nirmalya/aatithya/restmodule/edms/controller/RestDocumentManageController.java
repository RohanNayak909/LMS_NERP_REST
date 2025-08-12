package nirmalya.aatithya.restmodule.edms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.edms.dao.RestDocumentManageDao;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentManageAccessModel;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentManageModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "edms/")
public class RestDocumentManageController {

	Logger logger = LoggerFactory.getLogger(RestDocumentManageController.class);

	@Autowired
	RestDocumentManageDao restdocumentManageDao; 
	/*
	 * get all employee list
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "view-useremp-list")
	public JsonResponse getEmployeeList(@RequestParam String organization, @RequestParam String orgDivision,String userId) {
		logger.info("Method : getEmployeeList starts");

		logger.info("Method : getEmployeeList ends");
		return restdocumentManageDao.getEmployeeListDao(organization, orgDivision,userId);
	}
	/*
	 * Add user Group
	 * 
	 */
	@PostMapping(value= "rest-add-usergroup")
	public JsonResponse<Object> adduserGroup(@RequestBody RestDocumentManageModel managemodel){
		logger.info("Method: addusergroup starts");
		
		logger.info("Method: adduserGroup ends");
		return restdocumentManageDao.adduserGroup(managemodel);
	}
	/*
	 * get all user group list
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "view-usergroup-list")
	public JsonResponse getUserGroupList(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getUserGroupList starts");

		logger.info("Method : getUserGroupList ends");
		return restdocumentManageDao.getUserGroupListDao(organization, orgDivision);
	}
	/*
	 * get all user group list
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-edit-usergroup")
	public JsonResponse editUserGroup(@RequestParam String id,@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : editUserGroup starts");

		logger.info("Method : editUserGroup ends");
		return restdocumentManageDao.editUserGroupDao(id,organization, orgDivision);
	}
	/*
	 * get  Access Document listing
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-accessDocList")
	public JsonResponse getAccessDocumentListing(@RequestParam String id,@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getAccessDocumentListing starts");

		logger.info("Method : getAccessDocumentListing ends");
		return restdocumentManageDao.getAccessDocumentListingDao(id,organization, orgDivision);
	}
	/*
	 * get  Access Document listing by Type
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-accessDocListByType")
	public JsonResponse getAccessDocumentListingByType(@RequestParam String doctype,@RequestParam String date,@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getAccessDocumentListingByType starts");

		logger.info("Method : getAccessDocumentListingByType ends");
		return restdocumentManageDao.getAccessDocumentListingByType(doctype,date,organization, orgDivision);
	}
	/*
	 * Post User Access
	 * 
	 */
	@PostMapping(value = "rest-saveUserAccess")
	public JsonResponse<Object> saveUserAccess(@RequestBody List<RestDocumentManageAccessModel> restAccessModel) {
		logger.info("Method :saveUserAccess starts");

		logger.info("Method :saveUserAccess endss");
		return restdocumentManageDao.saveUserAccessDao(restAccessModel);
	}
	/*
	 * View  Access  listing
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-accessList")
	public JsonResponse getAccessList(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getAccessList starts");

		logger.info("Method : getAccessList ends");
		return restdocumentManageDao.getAccessListDao(organization, orgDivision);
	}
	/*
	 * View Document Accessed listing
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-document-accessedList")
	public JsonResponse getDocumentAccessedListing(@RequestParam String id,@RequestParam String accessid,@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getDocumentAccessedListing starts");

		logger.info("Method : getDocumentAccessedListing ends");
		return restdocumentManageDao.getDocumentAccessedListingDao(id,accessid,organization, orgDivision);
	}
	/*
	 * view Document listing
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-view-userdocumentlist")
	public JsonResponse viewUserDocumentList(@RequestParam String userid,@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : viewUserDocumentList starts");

		logger.info("Method : viewUserDocumentList ends");
		return restdocumentManageDao.viewUserDocumentListDao(userid,organization, orgDivision);
	}
	/*
	 * view auditlog listing
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-viewauditlog-list")
	public JsonResponse viewAuditLogList(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : viewAuditLogList starts");

		logger.info("Method : viewAuditLogList ends");
		return restdocumentManageDao.viewAuditLogListDao(organization, orgDivision);
	}
	
	
	/*
	 * Post Manage User Access
	 * 
	 */
	@PostMapping(value = "rest-saveUserAccessManage")
	public JsonResponse<Object> saveUserAccessManage(@RequestBody List<RestDocumentManageAccessModel> restAccessModel) {
		logger.info("Method :saveUserAccessManage starts");

		logger.info("Method :saveUserAccessManage endss");
		return restdocumentManageDao.saveUserAccessManage(restAccessModel);
	}
	
	/*
	 * get  Access Document Workflow
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-accessWorkflow")
	public JsonResponse accessWorkflow(@RequestParam String id,@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : accessWorkflow starts"+id);

		logger.info("Method : accessWorkflow ends");
		return restdocumentManageDao.accessWorkflow(id,organization, orgDivision);
	}
	
	// Document Control Workflow View
	@RequestMapping(value = "rest-documentworkFlowView", method = { RequestMethod.GET })
	public JsonResponse<Object> documentworkFlowView(@RequestParam String userId, @RequestParam String organization,
			@RequestParam String orgDivision, @RequestParam String docId) {
		logger.info("Method :documentworkFlowView start");
		
		logger.info("Method :documentworkFlowView endss");
		return restdocumentManageDao.documentworkFlowView(userId, organization, orgDivision, docId);
	}
	
	@RequestMapping(value = "getDMSEmpList", method = { RequestMethod.GET })
	public List<DropDownModel> getDMSEmpList(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method : getDMSEmpList starts");

		logger.info("Method : getDMSEmpList ends");
		return restdocumentManageDao.getDMSEmpList(orgName, orgDivision,userId);
	}
}
