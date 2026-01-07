package nirmalya.aatithya.restmodule.pipeline.controller;

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
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmContactDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmContactController {
	Logger logger = LoggerFactory.getLogger(RestCrmContactController.class);
	@Autowired
	RestCrmContactDao contactDao;

	
	
	/**
	 * Post Mapping to Add new Contact
	 *
	 */
	// add

	@PostMapping(value = "/addContact")
	public JsonResponse<Object> addContact(@RequestBody RestContactModel contact) {
		logger.info("Method : addContact starts");

		logger.info("Method : addContact ends");
		return contactDao.addContact(contact);
	}
	
	@RequestMapping(value = "viewContactSearchDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> viewLeadSearchDetails(

			@RequestBody RestContactModel searchContactModel) {
		logger.info("Method : viewContactSearchDetails starts");
		logger.info("VIEWWW" + searchContactModel);
		logger.info("Method : viewContactSearchDetails ends");

		return contactDao.viewContactSearchDetails(searchContactModel);
	}
	
	/*
	 * View pipeline Details
	 *
	 */
	
	@GetMapping(value = "getAllContact")
	public JsonResponse viewAllContact(@RequestParam String pageno,@RequestParam String userId,
			@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method :viewAllContact starts");

		logger.info("Method :viewAllContact ends");
	return contactDao.viewAllContact(pageno,userId,orgName,orgDivision);
	}

     /**
	 * returns edit editContact
	 *
	 */
	@RequestMapping(value = "/editContact", method = { RequestMethod.GET })
	public JsonResponse<RestContactModel> editContact(@RequestParam String id,@RequestParam String org,@RequestParam String orgDiv) {
		logger.info("Method : editContact starts");

		logger.info("Method :editContact ends");
		return contactDao.editContact(id,org,orgDiv);
	}
	
	@RequestMapping(value = "/viewContact", method = { RequestMethod.GET })
	public JsonResponse<RestContactModel> viewContact(@RequestParam String id,@RequestParam String org,@RequestParam String orgDiv) {
		logger.info("Method : viewContact starts");

		logger.info("Method :viewContact ends");
		return contactDao.viewContact(id,org,orgDiv);
	}
	
	
	//getLeadSourceList
	
	@RequestMapping(value = "getLeadSourceList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadSourceList() {
		
		logger.info("Method : getLeadSourceList starts");
		logger.info("Method : getLeadSourceList ends");
		
		return contactDao.getLeadSourceList();
	}
	
	//delete-contact-Details
	
	@RequestMapping(value = "delete-contact-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteContactDetails(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :  deleteContactDetails starts" + id);

		logger.info("Method :  deleteContactDetails ends");
		return contactDao.deleteContactDetails(id, org, orgDiv);
	}
	
	
	/*
	 * getAccountNameAutoSearchNewList auto search
	 */
	@GetMapping(value = "getAccountNameAutoSearchNewList")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getAccountNameAutoSearchNewList(
			@RequestParam String id,@RequestParam String userId) {
		logger.info("Method : getAccountNameAutoSearchNewList starts");

		logger.info("Method :getAccountNameAutoSearchNewList endss");
		return contactDao.getAccountNameAutoSearchNewList(id,userId);
	}
	//view-rest-LeadTaskInfo
	
			@GetMapping(value = "view-rest-ContactTaskInfo")
			public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> viewContactTaskInfo(@RequestParam String id,
					@RequestParam String org,@RequestParam String orgDiv) {
				logger.info("Method :viewContactTaskInfo starts");

				logger.info("Method :viewContactTaskInfo ends"+id);
				return contactDao.viewContactTaskInfo(id,org,orgDiv);
			}
	
	//view-rest-LeadCallInfo
	
			@GetMapping(value = "view-rest-ContactCallInfo")
			public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> viewContactCallInfo(@RequestParam String id,
					@RequestParam String org,@RequestParam String orgDiv) {
				logger.info("Method :viewContactCallInfo starts");

				logger.info("Method :viewContactCallInfo ends"+id);
				return contactDao.viewContactCallInfo(id,org,orgDiv);
			}
			
			//view-rest-LeadMeetingInfo
			@GetMapping(value = "view-rest-ContactMeetingInfo")
			
			public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> viewContactMeetingInfo(@RequestParam String id,
					@RequestParam String org,@RequestParam String orgDiv) {
				logger.info("Method :viewContactMeetingInfo starts");

				logger.info("Method :viewContactMeetingInfo ends"+id);
				return contactDao.viewContactMeetingInfo(id,org,orgDiv);
			}
			
			//view-rest-LeadCampaignInfo
			
			@GetMapping(value = "view-rest-viewContactCampaignInfo")
			public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> viewContactCampaignInfo(@RequestParam String id,@RequestParam String org,@RequestParam String orgDiv) {
				logger.info("Method :viewContactCampaignInfo starts");

				logger.info("Method :viewContactCampaignInfo ends"+id);
				return contactDao.viewContactCampaignInfo(id,org,orgDiv);

			}
			
			@RequestMapping(value="restViewDealContact" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestDealModel>>> restViewDealContact(@RequestParam String id ,@RequestParam String org, @RequestParam String orgDiv){
				logger.info("Method: restViewDealDetails View Start");
				
				logger.info("Method: restViewDealDetails ends");
				return contactDao.restViewDealContact(id,org,orgDiv);
			}
			
			@RequestMapping(value="get-deals-actions" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestDealModel>>> getDealsActions(@RequestParam String id ,@RequestParam String org, @RequestParam String orgDiv){
				logger.info("Method: getDealsActions View Start");
				
				logger.info("Method: getDealsActions ends");
				return contactDao.getDealsActions(id,org,orgDiv);
			}
			
			
			@PostMapping(value = "addContactEmailDoc")
			public ResponseEntity<JsonResponse<Object>> addContactEmailDoc(@RequestBody EmployeeDocumentModel employeeDocumentModel) {
				logger.info("Method : addContactEmailDoc starts");
				logger.info("Method : addContactEmailDoc ends");
				return contactDao.addContactEmailDoc(employeeDocumentModel);
			}
			@PostMapping(value = "addContactDraftDoc")
			public ResponseEntity<JsonResponse<Object>> addContactDraftDoc(@RequestBody EmployeeDocumentModel employeeDocumentModel) {
				logger.info("Method : addContactDraftDoc starts");
				logger.info("Method : addContactDraftDoc ends");
				return contactDao.addContactDraftDoc(employeeDocumentModel);
			}
			@RequestMapping(value = "getProductSKUListing", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<List<ProductMasterModel>>> getProductSKUListing(@RequestParam String type,String orgName,String orgDiv) {
				logger.info("Method : getProductSKUListing starts");
				
				logger.info("Method : getProductSKUListing ends");
				return contactDao.getProductSKUListing(type,orgName,orgDiv);
			}
			
			@RequestMapping(value = "/add-quotation", method = { RequestMethod.GET })
			public JsonResponse addQuotation(@RequestParam String quotId, @RequestParam String contactId, 
					@RequestParam String orgName,@RequestParam String orgDivision,@RequestParam String userId) {
				logger.info("Method : addQuotation starts");

				logger.info("Method :addQuotation ends");
				return contactDao.addQuotation(quotId, contactId,orgName,orgDivision,userId);
			}
			
			@RequestMapping(value = "/add-salesorder", method = { RequestMethod.GET })
			public JsonResponse addSalesOrder(@RequestParam String salesOrderId, @RequestParam String contactId, 
					@RequestParam String custId, @RequestParam String orgName,@RequestParam String orgDivision,@RequestParam String userId) {
				logger.info("Method : addSalesOrder starts");

				logger.info("Method :addSalesOrder ends");
				return contactDao.addSalesOrder(salesOrderId, contactId,custId, orgName,orgDivision,userId);
			}
			
			@RequestMapping(value = "/add-purchaseorder", method = { RequestMethod.GET })
			public JsonResponse addPurchaseOrder(@RequestParam String quotId, @RequestParam String contactId, @RequestParam String orgName,@RequestParam String orgDivision,
					@RequestParam String referenceId,@RequestParam String poNo,@RequestParam String custId,@RequestParam String orderType,@RequestParam String userId) {
				logger.info("Method : addPurchaseOrder starts");

				logger.info("Method :addPurchaseOrder ends");
				return contactDao.addPurchaseOrder(quotId, contactId,orgName,orgDivision,referenceId,poNo,custId,orderType,userId);
			}
			
			@RequestMapping(value = "/add-invoice", method = { RequestMethod.GET })
			public JsonResponse addInvoice(@RequestParam String saleInvoice, @RequestParam String custId,@RequestParam String invoiceDate,
					@RequestParam String contactId, @RequestParam String orgName,@RequestParam String orgDivision,@RequestParam String userId) {
				logger.info("Method : addInvoice starts");

				logger.info("Method :addInvoice ends");
				return contactDao.addInvoice(saleInvoice,custId,invoiceDate, contactId,orgName,orgDivision,userId);
			}
			

}
