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
import nirmalya.aatithya.restmodule.purchase.dao.PurchaseInvoiceDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestManageInvoiceDao;
import nirmalya.aatithya.restmodule.purchase.model.RestQaRequestModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;

@RestController
@RequestMapping("purchase/")
public class RestPurchaseInvoiceController {
	Logger logger = LoggerFactory.getLogger(RestPurchaseInvoiceController.class);

	@Autowired

	PurchaseInvoiceDao purchaseInvoiceDao;

	@GetMapping(value = "getPurchaseInvoiceInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseInvoiceInsertedId(@RequestParam String requestType) {
		logger.info("Method : getPurchaseInvoiceInsertedId starts");

		logger.info("Method : getPurchaseInvoiceInsertedId endss");
		return purchaseInvoiceDao.getPurchaseInvoiceInsertedId(requestType);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addPurchaseInvoice")
	public ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> addPurchase(
			@RequestBody List<RestManageInvoiceModel> restManageInvoiceModel) {
		logger.info("Method :addPurchaseInvoice starts");

		logger.info("Method :addPurchaseInvoice endss");
		return purchaseInvoiceDao.addPurchaseInvoice(restManageInvoiceModel);
	}

	// view
	@RequestMapping(value = "rest-viewInvoiceDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewInvoiceDetails(@RequestParam String orgName, String orgDivision, String invType,String type,String userId) {
		logger.info("Method :viewInvoiceDetails start");

		logger.info("Method :viewInvoiceDetails endss");
		return purchaseInvoiceDao.viewInvoiceDetails(orgName, orgDivision, invType,type,userId);
	}

	
	
	/*
	 * edit
	 */ @GetMapping(value = "purchaseInvoiceEdit")
	public List<RestManageInvoiceModel> purchaseInvoiceEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : purchaseInvoiceEdit starts");
		// logger.info(id);
		logger.info("Method : purchaseInvoiceEdit endss");
		return purchaseInvoiceDao.purchaseInvoiceEdit(id, org, orgDiv);
	}

	// delete

	@PostMapping(value = "deleteInvoiceDetils")
	public ResponseEntity<JsonResponse<Object>> deleteInvoiceDetils(@RequestBody RestManageInvoiceModel restManageInvoiceModel) {
		logger.info("Method : deleteInvoiceDetils starts"); 
		
		logger.info("Method : deleteInvoiceDetils ends");
		return purchaseInvoiceDao.deleteInvoiceDetils(restManageInvoiceModel);
	}

	// approve

	@GetMapping(value = "approveInvoiceDetails")
	public JsonResponse<DropDownModel> approveInvoiceDetails(@RequestParam String approveStatus, String invoiceId,
			String orgName, String orgDivision, String approvedBy) {
		logger.info("Method : approveInvoiceDetails starts");

		logger.info("Method : approveInvoiceDetails ends");
		return purchaseInvoiceDao.approveInvoiceDetails(approveStatus, invoiceId, orgName, orgDivision, approvedBy);
	}
	
	// Search.
	
	@RequestMapping(value = "rest-viewInvoiceDetailsSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> viewInvoiceDetailsSearch(@RequestParam String orgName, String orgDivision, String invType, String search) {
		logger.info("Method :viewInvoiceDetailsSearch start");

		logger.info("Method :viewInvoiceDetailsSearch endss");
		return purchaseInvoiceDao.viewInvoiceDetailsSearch(orgName, orgDivision, invType, search);
	}

	// getFiscalYearList

	@RequestMapping(value = "getFiscalYearList", method = { RequestMethod.GET })
	public List<DropDownModel> getFiscalYearList() {

		logger.info("Method : getFiscalYearList starts");
		logger.info("Method : getFiscalYearList ends");

		return purchaseInvoiceDao.getFiscalYearList();
	}
	
	@RequestMapping(value = "purchaseInvoiceFilterdata", method = { RequestMethod.GET })
	public JsonResponse<Object> saleInvoiceFilterdata(@RequestParam String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method :purchaseInvoiceFilterdata start");

		logger.info("Method :purchaseInvoiceFilterdata endss");
		return purchaseInvoiceDao.purchaseInvoiceFilterdata(orgName, orgDivision, fromDate, toDate);

	}
}
