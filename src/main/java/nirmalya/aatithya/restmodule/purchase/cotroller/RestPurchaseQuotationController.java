package nirmalya.aatithya.restmodule.purchase.cotroller;

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
import nirmalya.aatithya.restmodule.procurment.model.InventoryRfqVendorModel;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseQuotationDao;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

@RestController
@RequestMapping("purchase/")
public class RestPurchaseQuotationController {
	Logger logger = LoggerFactory.getLogger(RestPurchaseQuotationController.class);

	@Autowired

	RestPurchaseQuotationDao restPurchaseQuotationDao;

	@GetMapping(value = "get-purchasevendor-view-list")
	public List<RestVendorNewModel> getPurchaseVendorList(@RequestParam String id, String orgName,String orgDiv) {
		logger.info("Method : getPurchaseVendorList starts");
		logger.info("Method : getPurchaseVendorList endss");
		return restPurchaseQuotationDao.getPurchaseVendorList(id,orgName,orgDiv);
	}
	
	// Req List
	@GetMapping(value = "getRequisitionList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRequisitionList(@RequestParam String id, String org, @RequestParam String orgDiv) {
		logger.info("Method : getRequisitionList starts");

		logger.info("Method : getRequisitionList ends");
		return restPurchaseQuotationDao.getRequisitionList(id,org,orgDiv);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addPurchaseQuotation")
	public ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> addPurchaseQuotation(
			@RequestBody List<RestPurchaseQuotationModel> restPurchaseQuotationModel) {
		logger.info("Method :addPurchaseQuotation starts");
		logger.info("Method :addPurchaseQuotation endss");
		return restPurchaseQuotationDao.addPurchaseQuotation(restPurchaseQuotationModel);
	}

	@RequestMapping(value = "rest-viewQuotation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> viewQuotation(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewQuotation startssssssssssssssssss");

		logger.info("Method :viewQuotation endss");
		return restPurchaseQuotationDao.viewQuotation(org, orgDiv);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewInquiryEdit")
	public List<RestPurchaseQuotationModel> viewInquiryEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewInquiryEdit starts");
		logger.info("Method : viewInquiryEdit endss");
		return restPurchaseQuotationDao.viewInquiryEdit(id, org, orgDiv);
	}

	/*
	 * delete
	 * 
	 */
	@PostMapping(value = "deleteInquiry")
	public ResponseEntity<JsonResponse<Object>> deleteInquiry(
			@RequestBody RestPurchaseQuotationModel restPurchaseQuotationModel) {
		logger.info("Method : deleteInquiry starts");
		logger.info("Method : deleteInquiry ends");
		return restPurchaseQuotationDao.deleteInquiry(restPurchaseQuotationModel);
	}

	/*
	 * pdf
	 */ @GetMapping(value = "view-itemdetails-viewPdf")
	public List<RestPurchaseQuotationModel> getItemPdfDetails(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getItemPdfDetails starts");
		logger.info("Method : getItemPdfDetails endss");
		return restPurchaseQuotationDao.getItemPdfDetails(id, org, orgDiv);
	}

	@GetMapping(value = "getVendordata")
	public List<RestVendorNewModel> getVendordata(@RequestParam String sku, String orgName, String orgDivision,String rowCount) {
		logger.info("Method : getVendordata starts");
		logger.info("Method : getVendordata endss");
		return restPurchaseQuotationDao.getVendordata(sku, orgName, orgDivision,rowCount);
	}
	
	@RequestMapping(value = "getReqNoAutoSearchList", method = { RequestMethod.GET })
	public JsonResponse<Object> getReqNoAutoSearchList(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getReqNoAutoSearchList start");

		logger.info("Method :getReqNoAutoSearchList endss");
		return restPurchaseQuotationDao.getReqNoAutoSearchList(id, org, orgDiv);
	}
	
	
	@RequestMapping(value = "getReqNoAutoSearchListDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> getReqNoAutoSearchListDtls(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getReqNoAutoSearchListDtls start");

		logger.info("Method :getReqNoAutoSearchListDtls endss");
		return restPurchaseQuotationDao.getReqNoAutoSearchListDtls(id, org, orgDiv);
	}
	
	
	@RequestMapping(value = "rest-getAllVendorListDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllVendorListDtls(@RequestParam String type, String org, String orgDiv) {
		logger.info("Method :getAllVendorListDtls start");

		logger.info("Method :getAllVendorListDtls endss");
		return restPurchaseQuotationDao.getAllVendorListDtls(type, org, orgDiv);
	}
	
	// Get Email Data
	
	@RequestMapping(value = "rest-getEmailData", method = { RequestMethod.GET })
	public JsonResponse<Object> getEmailData(@RequestParam String id, String mailStatus, String orgName, String orgDivision) {
		logger.info("Method :getEmailData start");

		logger.info("Method :getEmailData endss");
		return restPurchaseQuotationDao.getEmailData(id, mailStatus, orgName, orgDivision);
	}
	
	
	// Email
	
	@GetMapping(value = "sendEmailRfq")
	public ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> sendEmailRfq(@RequestParam String rfqId,
			String vendorNames,String vendorMails, String vendorCc, String vendorBcc, String vendorMsg, String url) {
		logger.info("Method : sendEmailRfq starts");

		logger.info("Method : sendEmailRfq ends"+url);
		return restPurchaseQuotationDao.sendEmailRfq(rfqId, vendorNames,vendorMails, vendorCc, vendorBcc, vendorMsg, url);
	}
	
}
