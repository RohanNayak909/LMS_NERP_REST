package nirmalya.aatithya.restmodule.pipeline.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Base64.Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Hex;
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
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmLeadsDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;
import nirmalya.aatithya.restmodule.user.dao.UserLoginDao;
import nirmalya.aatithya.restmodule.pipeline.model.AdminTaskAssignRestModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmProductModel;

@RestController
@RequestMapping(value = "pipeline")
public class RestCrmLeadsController {

	Logger logger = LoggerFactory.getLogger(RestCrmLeadsController.class);
	@Autowired
	RestCrmLeadsDao restCrmLeadsDao;

	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

	/**
	 * 
	 * @return department list
	 */

	@RequestMapping(value = "getLeadList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadList() {

		logger.info("Method : getLeadList starts");
		logger.info("Method : getLeadList ends");

		return restCrmLeadsDao.getLeadList();
	}

	@RequestMapping(value = "getindustrylist", method = { RequestMethod.GET })
	public List<DropDownModel> getindustrylist() {

		logger.info("Method : getindustrylist starts");
		logger.info("Method : getindustrylist ends");

		return restCrmLeadsDao.getindustrylist();
	}

	@RequestMapping(value = "getRatingList", method = { RequestMethod.GET })
	public List<DropDownModel> getRatingList() {

		logger.info("Method : getRatingList starts");
		logger.info("Method : getRatingList ends");

		return restCrmLeadsDao.getRatingList();
	}

	@RequestMapping(value = "getDocumentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDocumentList() {

		logger.info("Method : getDocumentList starts");
		logger.info("Method : getDocumentList ends");

		return restCrmLeadsDao.getDocumentList();
	}

	@RequestMapping(value = "viewLeadSearchDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> viewLeadSearchDetails(@RequestBody RestCrmLeadsModel searchLeadModel) {
		logger.info("Method : viewLeadSearchDetails starts");
		logger.info("VIEWWW" + searchLeadModel);
		logger.info("Method : viewLeadSearchDetails ends");

		return restCrmLeadsDao.viewLeadSearchDetails(searchLeadModel);
	}

	@RequestMapping(value = "getCountry", method = { RequestMethod.GET })
	public List<DropDownModel> getCountry() {

		logger.info("Method : getCountry starts");
		logger.info("Method : getCountry ends");

		return restCrmLeadsDao.getCountry();
	}

	/*
	 * @RequestMapping(value = "viewEmailDetailsView", method = { RequestMethod.GET
	 * }) public JsonResponse<RestCrmLeadsModel> viewEmailDetails(@RequestParam
	 * String id1,@RequestParam String id2,@RequestParam String id3) {
	 * logger.info("Method : viewEmailDetails rest starts");
	 * 
	 * logger.info("Method :viewEmailDetails rest ends"); return
	 * restCrmLeadsDao.viewEmailDetails(id1,id2,id3); }
	 */

	@RequestMapping(value = "getLeadStatusList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadStatusList() {

		logger.info("Method : getLeadStatusList starts");
		logger.info("Method : getLeadStatusList ends");

		return restCrmLeadsDao.getLeadStatusList();
	}

	// addNoteDoc

	@PostMapping(value = "addNoteDoc")
	public ResponseEntity<JsonResponse<Object>> addNoteDoc(@RequestBody EmployeeDocumentModel employeeDocumentModel) {
		logger.info("Method : addNoteDoc starts");
		logger.info("Method : addNoteDoc ends");
		return restCrmLeadsDao.addNoteDoc(employeeDocumentModel);
	}

	@RequestMapping(value = "getStateLists", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getstateListNew(@RequestParam String id) {
		logger.info("Method : getstateList starts");
		logger.info("Method : getstateList ends");
		return restCrmLeadsDao.getcuststateListNew(id);
	}

	/*
	 * for All Add leadDetails
	 */
	@RequestMapping(value = "rest-add-lead-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddLeadDetails(@RequestBody RestCrmLeadsModel restCrmLeadsModel) {
		logger.info("Method : restAddLeadDetails starts");

		logger.info("restAddLeadDetails api value-----------------------------" + restCrmLeadsModel);

		logger.info("Method : restAddLeadDetails ends");

		return restCrmLeadsDao.restAddLeadDetails(restCrmLeadsModel);
	}
	/*
	 * for view
	 */
	/*
	 * @RequestMapping(value="viewLeadData" , method = {RequestMethod.GET}) public
	 * ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>
	 * restViewData(@RequestParam String pageno){
	 * logger.info("Method: restViewData View Start");
	 * 
	 * logger.info("Method: restViewData ends"); return
	 * restCrmLeadsDao.viewLeadData(pageno); }
	 */

	/*
	 * view lead
	 */
	@GetMapping(value = "rest-viewLeadDet")
	public JsonResponse viewLeadDet(@RequestParam String pageno, @RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String fromDate,@RequestParam String toDate) {
		logger.info("Method :viewLeadDet starts");

		logger.info("Method :viewLeadDet ends");
		return restCrmLeadsDao.viewLeadDet(pageno, userId, orgName, orgDivision,fromDate,toDate);
	}

	/* Duplicate check leaad phone and mobile */

	@GetMapping(value = "rest-duplicateCheck")
	public JsonResponse checkDuplicate(@RequestParam String email, @RequestParam String phone,
			@RequestParam String mobile, @RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String leadid) {
		logger.info("Method :checkDuplicate starts");

		logger.info("Method :checkDuplicate ends");
		return restCrmLeadsDao.checkDuplicate(email, phone, mobile, org, orgDiv, leadid);
	}

	/// edit
	@GetMapping(value = "edit-rest-LeadInfo")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> editLeadInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :editLeadInfo starts");

		logger.info("Method :editLeadInfo ends" + id);
		return restCrmLeadsDao.editLeadInfo(id, org, orgDiv);

	}

	@GetMapping(value = "edit-rest-add-customer")
	public JsonResponse<List<RestCustoomerNewModel>> addCustomer(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :addCustomer starts");

		logger.info("Method :addCustomer ends" + id);
		return restCrmLeadsDao.addCustomer(id, org, orgDiv);

	}

	// view-rest-LeadInfo

	@GetMapping(value = "view-rest-LeadInfo")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadInfo starts");

		logger.info("Method :viewLeadInfo ends" + id);
		return restCrmLeadsDao.viewLeadInfo(id, org, orgDiv);

	}

	// convertToAccContDeal

	@PostMapping(value = "/convertToAccContDeal")
	public JsonResponse<List<RestCrmLeadsModel>> convertToAccContDeal(@RequestBody RestCrmLeadsModel leadModel) {
		logger.info("Method : convertToAccContDeal starts");

		logger.info("Method : convertToAccContDeal ends");
		return restCrmLeadsDao.convertToAccContDeal(leadModel);
	}

	// view-rest-LeadNoteInfo

	@GetMapping(value = "view-rest-LeadNoteInfo")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadNoteInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadNoteInfo starts");

		logger.info("Method :viewLeadNoteInfo ends" + id);
		return restCrmLeadsDao.viewLeadNoteInfo(id, org, orgDiv);

	}

	// view-rest-LeadMailInfo

	@GetMapping(value = "view-rest-LeadMailInfo")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadMailInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadMailInfo starts");

		logger.info("Method :viewLeadMailInfo ends" + id);
		return restCrmLeadsDao.viewLeadMailInfo(id, org, orgDiv);

	}

	// view-rest-LeadProductInfo

	@GetMapping(value = "view-rest-LeadProductInfo")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadProductInfo(@RequestParam String id,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadProductInfo starts");

		logger.info("Method :viewLeadProductInfo ends" + id);
		return restCrmLeadsDao.viewLeadProductInfo(id, userId, org, orgDiv);

	}

	// view-rest-LeadCampaignInfo

	@GetMapping(value = "view-rest-LeadCampaignInfo")
	public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> viewLeadCampaignInfo(@RequestParam String id,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadCampaignInfo starts");

		logger.info("Method :viewLeadCampaignInfo ends" + id);
		return restCrmLeadsDao.viewLeadCampaignInfo(id, userId, org, orgDiv);

	}

	// view-rest-LeadTaskInfo

	@GetMapping(value = "view-rest-LeadTaskInfo")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> viewLeadTaskInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadTaskInfo starts");

		logger.info("Method :viewLeadTaskInfo ends" + id);
		return restCrmLeadsDao.viewLeadTaskInfo(id, org, orgDiv);
	}

	// getActions

	@GetMapping(value = "get-Task-Actions")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> getTaskActions(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getTaskActions starts");

		logger.info("Method :getTaskActions ends" + id);
		return restCrmLeadsDao.getTaskActions(id, org, orgDiv);
	}

	// view-rest-LeadCallInfo

	@GetMapping(value = "view-rest-LeadCallInfo")
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> viewLeadCallInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadCallInfo starts");

		logger.info("Method :viewLeadCallInfo ends" + id);
		return restCrmLeadsDao.viewLeadCallInfo(id, org, orgDiv);
	}

	// view-rest-LeadActivityInfo

	@GetMapping(value = "view-rest-LeadActivityInfo")
	public ResponseEntity<JsonResponse<List<RestCrmActivityModel>>> viewLeadActivityInfo(@RequestParam String id,
			@RequestParam String type, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadActivityInfo starts");

		logger.info("Method :viewLeadActivityInfo ends" + id);
		return restCrmLeadsDao.viewLeadActivityInfo(id, type, org, orgDiv);
	}

	// view-rest-LeadMeetingInfo

	@GetMapping(value = "view-rest-LeadMeetingInfo")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> viewLeadMeetingInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewLeadMeetingInfo starts");

		logger.info("Method :viewLeadMeetingInfo ends" + id);
		return restCrmLeadsDao.viewLeadMeetingInfo(id, org, orgDiv);
	}

	// view-rest-LeadMeetingInfo

	@GetMapping(value = "invitedMeetingInfo")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> invitedMeetingInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :invitedMeetingInfo starts");

		logger.info("Method :invitedMeetingInfo ends" + id);
		return restCrmLeadsDao.invitedMeetingInfo(id, org, orgDiv);
	}

	//// delete
	@RequestMapping(value = "delete-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDetails(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :  deleteDetails starts" + id);

		logger.info("Method :  deleteDetails ends");
		return restCrmLeadsDao.deleteDetails(id, org, orgDiv);
	}

	// taskadd

	@PostMapping(value = "saveleadtask")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadtask(
			@RequestBody List<RestCrmLeadsModel> leadTask) {
		logger.info("Method : saveleadtask starts");

		logger.info("Method : saveleadtask ends");
		return restCrmLeadsDao.saveleadtask(leadTask);
	}

	// saveleadtags

	@PostMapping(value = "saveleadtags")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadtags(
			@RequestBody List<RestCrmLeadsModel> leadTags) {
		logger.info("Method : saveleadtags starts");

		logger.info("Method : saveleadtags ends");
		return restCrmLeadsDao.saveleadtags(leadTags);
	}

	// saveleadMacro

	@PostMapping(value = "saveleadMacro")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadMacro(
			@RequestBody List<RestCrmLeadsModel> leadMacro) {
		logger.info("Method : saveleadMacro starts");

		logger.info("Method : saveleadMacro ends");
		return restCrmLeadsDao.saveleadMacro(leadMacro);
	}

	// saveleadCampaign
	@PostMapping(value = "saveleadCampaign")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadCampaign(
			@RequestBody List<RestCrmLeadsModel> leadCampaign) {
		logger.info("Method : saveleadCampaign starts");

		logger.info("Method : saveleadCampaign ends");
		return restCrmLeadsDao.saveleadCampaign(leadCampaign);
	}

	@PostMapping(value = "saveleadmails")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadmail(
			@RequestBody List<RestCrmLeadsModel> leadTask) {
		logger.info("Method : saveleadmail starts");

		logger.info("Method : saveleadmail ends");
		return restCrmLeadsDao.saveleadmail(leadTask);
	}

	@RequestMapping(value = "rest-addTask-Leads", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> userLaundryItemService(
			@RequestBody RestCrmTaskModel restItemRequisitonModel) {
		logger.info("Method : RestCRMLeadTaskModel starts");
		logger.info("Method : RestCRMLeadTaskModel ends");
		return restCrmLeadsDao.addItemRequisition(restItemRequisitonModel);
	}

	/*
	 * for All Add leadDetails
	 */
	@RequestMapping(value = "rest-add-massUpdate", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddMassUpdate(@RequestBody RestCrmLeadsModel assignSkill) {
		logger.info("Method : restAddMassUpdate starts");

		logger.info("Method : restAddMassUpdate ends");

		return restCrmLeadsDao.restAddMassUpdate(assignSkill);
	}

	/// viewProductDetailsView (view of products)

	@GetMapping(value = "viewProductDetailsView")
	public ResponseEntity<JsonResponse<List<RestCrmProductModel>>> viewProductDetailsView(@RequestParam String id,
			@RequestParam String id2, @RequestParam String pageType, @RequestParam String productCode,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewProductDetailsView starts");

		logger.info("Method :viewProductDetailsView ends" + id);
		return restCrmLeadsDao.viewProductDetailsView(id, id2, pageType, productCode, org, orgDiv);
	}

	// saveCRMProductAdd

	@PostMapping(value = "saveCRMProductAdd")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveCRMProductAdd(
			@RequestBody List<RestCrmLeadsModel> leadTask) {
		logger.info("Method : saveCRMProductAdd starts");

		logger.info("Method : saveCRMProductAdd ends");
		return restCrmLeadsDao.saveCRMProductAdd(leadTask);
	}

	// viewProductSearchView

	@GetMapping(value = "viewProductSearchView")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> viewProductSearchView(@RequestParam String searchVal,
			@RequestParam String id, @RequestParam String assigRow, @RequestParam String pageType) {
		logger.info("Method :viewProductSearchView starts");

		logger.info("Method :searchVal ends" + searchVal);
		return restCrmLeadsDao.viewProductSearchView(searchVal, id, assigRow, pageType);
	}

	/// edit Note by note id
	@GetMapping(value = "rest-editNoteDataByNoteId")
	public JsonResponse editNoteDataByNoteId(@RequestParam String id) {
		logger.info("Method :editNoteDataByNoteId starts");

		logger.info("Method :editNoteDataByNoteId ends");
		return restCrmLeadsDao.editNoteDataByNoteId(id);

	}

	/// edit Note
	@GetMapping(value = "rest-editNote")
	public JsonResponse editNoteDet(@RequestParam String id) {
		logger.info("Method :editNoteDet starts");

		logger.info("Method :editNoteDet ends");
		return restCrmLeadsDao.editNoteDet(id);

	}

	/*
	 * delete note
	 */
	@GetMapping(value = "rest-deleteNote")
	public ResponseEntity<JsonResponse<Object>> deleteNote(@RequestParam String id) {
		logger.info("Method : deleteNote starts");

		logger.info("Method : deleteNote ends");
		return restCrmLeadsDao.deleteNoteDao(id);
	}

	/// view Note
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-viewNote")
	public JsonResponse viewNoteDet(@RequestParam String id, @RequestParam String pageno,
			@RequestParam String filterDate, @RequestParam String filterTitle, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewNoteDet starts");

		logger.info("Method :viewNoteDet ends");
		return restCrmLeadsDao.viewNoteDet(id, pageno, filterDate, filterTitle, userId, org, orgDiv);

	}

	@GetMapping(value = "rest-viewDraft")
	public JsonResponse viewDraftDet(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewDraftDet starts");

		logger.info("Method :viewDraftDet ends");
		return restCrmLeadsDao.viewDraftDet(id, org, orgDiv);
	}

	@GetMapping(value = "rest-viewMail")
	public JsonResponse viewMailDet(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewMailDet starts");

		logger.info("Method :viewMailDet ends");
		return restCrmLeadsDao.viewMailDet(id, org, orgDiv);
	}

	/*
	 * delete note
	 */
	@GetMapping(value = "rest-deleteDraft")
	public ResponseEntity<JsonResponse<Object>> deleteDraft(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : deleteDraft starts");

		logger.info("Method : deleteDraft ends");
		return restCrmLeadsDao.deleteDraftDao(id, org, orgDiv);
	}

	@RequestMapping(value = "rest-edit-draftdet", method = { RequestMethod.GET })
	public JsonResponse<RestCrmLeadsModel> editDraftDet(@RequestParam String id1, @RequestParam String id2,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : editDraftDet starts");

		logger.info("Method :editDraftDett ends");
		return restCrmLeadsDao.editDraftDet(id1, id2, org, orgDiv);
	}

	@PostMapping(value = "rest-saveleadCSV")
	public ResponseEntity<JsonResponse<Object>> saveleadCSV(@RequestBody List<RestCrmLeadsModel> lead) {
		logger.info("Method : saveleadCSV starts");

		logger.info("Method : saveleadCSV ends");
		return restCrmLeadsDao.saveleadCSV(lead);
	}

	/**
	 * User Task Status Update
	 */

	@PostMapping(value = "update-task-status")
	public JsonResponse<Object> updateTaskStatus(@RequestBody AdminTaskAssignRestModel task) {
		logger.info("Method : updateTaskStatus starts");

		logger.info("Method : updateTaskStatus ends");
		return restCrmLeadsDao.updateTaskStatus(task);
	}

	/*
	 * Reveiw note By Admin
	 */
	@GetMapping(value = "rest-reveiwNote")
	public ResponseEntity<JsonResponse<Object>> reveiwNote(@RequestParam String id, @RequestParam String desc,
			@RequestParam String userId) {
		logger.info("Method : reveiwNoteAdmin starts");

		logger.info("Method : reveiwNoteAdmin ends");
		return restCrmLeadsDao.reveiwNote(id, desc, userId);
	}

	/*
	 * Delete Product Data From Lead
	 */
	@GetMapping(value = "deleteProduct")
	public ResponseEntity<JsonResponse<Object>> deleteProduct(@RequestParam String encryptedData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :deleteProduct starts");

		String productId = "";
		try {
			encryptedData = URLDecoder.decode(encryptedData, "UTF-8");
			org = URLDecoder.decode(org, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String[] regexData = encryptedData.split("\\|");

		String[] prodId = regexData[0].split(",");

		for (String ids : prodId) {
			productId += "\"" + ids + "\",";
		}
		System.out.println(productId.substring(0, productId.length() - 1));
		System.out.println(regexData);

		productId = productId.substring(0, productId.length() - 1);

		logger.info("Method :deleteProduct ends");
		return restCrmLeadsDao.deleteProduct(productId, userId, org, orgDiv, regexData[1]);

	}

	@RequestMapping(value = "lead-status-timeline", method = { RequestMethod.GET })
	public JsonResponse<Object> leadStatusTimeline(@RequestParam String id) {

		logger.info("Method : leadStatusTimeline starts");
		logger.info("Method : leadStatusTimeline ends");

		return restCrmLeadsDao.leadStatusTimeline(id);
	}

	@RequestMapping(value = "getProjectAutoSearchList", method = { RequestMethod.GET })
	public List<DropDownModel> getProjectAutoSearchList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getProjectAutoSearchList starts");

		logger.info("Method : getProjectAutoSearchList ends");
		return restCrmLeadsDao.getProjectAutoSearchList(org, orgDiv);
	}

	@RequestMapping(value = "rest-getEmployeeList-mail", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeLists(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String managerId, @RequestParam String userId) {
		logger.info("Method : getEmployeeLists starts");

		logger.info("Method : getEmployeeLists ends");
		return restCrmLeadsDao.getEmployeeLists(orgName, orgDivision, managerId, userId);
	}

	@RequestMapping(value = "get-lead-product-list", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadProductList(@RequestParam String userId, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getLeadProductList starts");

		logger.info("Method : getLeadProductList ends");
		return restCrmLeadsDao.getLeadProductList(userId,org, orgDiv);
	}
	
	@GetMapping("rest-get-sku")
	public JsonResponse<Object> getSkuOnProduct(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String id) {
		logger.info("Method :getSkuOnProduct start");

		logger.info("Method :getSkuOnProduct ends");
		return restCrmLeadsDao.getSkuOnProduct(orgName, orgDiv, userId, id);
	}
	@PostMapping("rest-add-product-for-lead")
	public JsonResponse<Object> addProductForLead(@RequestBody Map<String, Object> requestPayload) {
		logger.info("Method : addProductForLead starts");

		logger.info("Method : addProductForLead ends");
		return restCrmLeadsDao.addProductForLead(requestPayload);
	}
	@GetMapping("rest-get-product-on-lead")
	public JsonResponse<Object> getProductOnLead(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String leadId) {
		logger.info("Method :getProductOnLead start");

		logger.info("Method :getProductOnLead ends");
		return restCrmLeadsDao.getProductOnLead(orgName, orgDiv, userId, leadId);
	}
	@GetMapping("rest-delete-lead-product")
	public JsonResponse<Object> deleteLeadProduct(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String leadId,@RequestParam String productId,@RequestParam String skuId) {
		logger.info("Method :deleteLeadProduct start");

		logger.info("Method :deleteLeadProduct ends");
		return restCrmLeadsDao.deleteLeadProduct(orgName, orgDiv, userId, leadId,productId,skuId);
	}
}
