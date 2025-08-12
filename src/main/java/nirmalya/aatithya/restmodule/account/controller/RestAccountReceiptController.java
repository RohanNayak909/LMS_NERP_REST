package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountReceiptDao;
import nirmalya.aatithya.restmodule.account.dao.RestJournalVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountCusRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountCustomerOrderRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestSalesInvoicePaymentModel;
import nirmalya.aatithya.restmodule.account.model.RestVendorNameListModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountReceiptController {
	Logger logger = LoggerFactory.getLogger(RestAccountReceiptController.class);
	@Autowired
	RestAccountReceiptDao restReceiptDao;

	@RequestMapping(value = "addReceiptJournalVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveJournalVoucher(
			@RequestBody List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : addReceiptJournalVoucher starts");
		logger.info("Method : addReceiptJournalVoucher ends");
		return restReceiptDao.addReceiptVoucher(journalVoucherModel);
	}

	// JSON view receipt
	@RequestMapping(value = "viewReceiptVoucher", method = { RequestMethod.GET })
	public JsonResponse<Object> restViewReceiptVoucher(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :restViewReceiptVoucher start");

		logger.info("Method :restViewReceiptVoucher endss");
		return restReceiptDao.viewReceiptVoucher(orgName, orgDivision);

	}

	// editAccountInfo

	@GetMapping(value = "editReceiptInfo")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editJournalInfo(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :editJournalInfo starts");

		logger.info("Method :editJournalInfo ends" + id);
		return restReceiptDao.editReceiptInfo(id, orgName, orgDivision);

	}

	@RequestMapping(value = "getReceiptvoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber(String orgName,String orgDivision) {
		logger.info("Method: voucherNumber View Start");

		logger.info("Method: voucherNumber ends");
		return restReceiptDao.voucherNumber(orgName,orgDivision);
	}

	/*
	 * getDebitAccountSearch auto search
	 */
	/*
	 * @GetMapping(value = "getDebitReceiptAccountSearch") public
	 * ResponseEntity<JsonResponse<List<RestContraVoucherModel>>>
	 * getDebitAccountSearch(@RequestParam String id) {
	 * logger.info("Method : getDebitAccountSearch starts");
	 * 
	 * logger.info("Method :getDebitAccountSearch endss"); return
	 * restReceiptDao.getDebitAccountSearch(id); }
	 */

	@GetMapping(value = "getDebitReceiptAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getDebitAccountSearch starts");

		logger.info("Method :getDebitAccountSearch endss");
		return restReceiptDao.getDebitAccountSearch(id, orgName, orgDivision);
	}

	/*
	 * getCreditAccountSearch auto search
	 */
	@GetMapping(value = "getCreditReceiptAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getCreditAccountSearch(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getCreditAccountSearch starts");

		logger.info("Method :getCreditAccountSearch endss");
		return restReceiptDao.getCreditAccountSearch(id, orgName, orgDivision);
	}

	// deleteJournalDetails

	@RequestMapping(value = "deleteReceiptDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :  deleteJournalDetails starts" + id);

		logger.info("Method :  deleteJournalDetails ends");
		return restReceiptDao.deleteJournalDetails(id, orgName, orgDivision);
	}

	@RequestMapping(value = "viewReceiptFilter", method = { RequestMethod.GET })
	public JsonResponse<Object> viewReceiptFilter(@RequestParam String orgName, @RequestParam String orgDivision,
			String fromDate, String toDate) {
		logger.info("Method :viewReceiptFilter start");

		logger.info("Method :viewReceiptFilter endss");
		return restReceiptDao.viewReceiptFilter(orgName, orgDivision, fromDate, toDate);

	}

	/* Auto Search for Dealer */

	/*@GetMapping(value = "getDealerList")
	public ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> getDealerList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getDealerList starts");

		logger.info("Method :getDealerList endss");
		return restReceiptDao.getDealerList(id, org, orgDiv);
	}*/

	/* Auto Search for Distributor */

	/*@GetMapping(value = "getDistributorList")
	public ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> getDistributorList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getDistributorList starts");

		logger.info("Method :getDistributorList endss");
		return restReceiptDao.getDistributorList(id, org, orgDiv);
	}

	@GetMapping(value = "getDelaerOrder")
	public ResponseEntity<JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>> getDelaerOrder(
			@RequestParam String orgName, @RequestParam String orgDivision, String id) {
		logger.info("Method : getDelaerOrder starts");
		logger.info("Method : getDelaerOrder endss");
		return restReceiptDao.getDelaerOrder(orgName, orgDivision, id);
	}

	@GetMapping(value = "getDistributorOrder")
	public ResponseEntity<JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>> getDistributorOrder(
			@RequestParam String orgName, @RequestParam String orgDivision, String id) {
		logger.info("Method : getDistributorOrder starts");
		logger.info("Method : getDistributorOrder endss");
		return restReceiptDao.getDistributorOrder(orgName, orgDivision, id);
	}*/

	@RequestMapping(value = "addPaymentInvoice", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPaymentInvoice(
			@RequestBody RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		logger.info("Method : addPaymentInvoice starts" + restSalesInvoicePaymentModel);

		logger.info("Method : addPaymentInvoice ends");
		return restReceiptDao.addPaymentInvoice(restSalesInvoicePaymentModel);
	}

//	@GetMapping(value = "addPaymentForUser")
	@RequestMapping(value = "addPaymentForUser", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPaymentForUser(@RequestBody RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		logger.info("Method : addPaymentForUser starts");

		logger.info("Method : addPaymentForUser ends");
		return restReceiptDao.addPaymentForUser(restSalesInvoicePaymentModel);
	}

	@RequestMapping(value = "restGetCreditNoteListPayment", method = { RequestMethod.GET })
	public JsonResponse<Object> restGetCreditNoteListPayment(@RequestParam String orgName, String orgDivision,String vendorId) {
		logger.info("Method :restGetCreditNoteListPayment start");

		logger.info("Method :restGetCreditNoteListPayment endss");
		return restReceiptDao.restGetCreditNoteListPayment(orgName, orgDivision,vendorId);

	}
	
	@GetMapping(value = "getCustomerListRest")
	public ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> getCustomerListRest(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getCustomerListRest starts");

		logger.info("Method :getCustomerListRest endss");
		return restReceiptDao.getCustomerListRest(id, org, orgDiv);
	}
	
	@GetMapping(value = "getCustomerOrderList")
	public ResponseEntity<JsonResponse<List<AccountCustomerOrderRestModel>>> getCustomerOrderList(
			@RequestParam String orgName, @RequestParam String orgDivision, String id) {
		logger.info("Method : getCustomerOrderList starts");
		logger.info("Method : getCustomerOrderList endss");
		return restReceiptDao.getCustomerOrderList(orgName, orgDivision, id);
	}
	@GetMapping(value = "receiptVoucherPdf")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> receiptVoucherPdf(
			@RequestParam String fromDate, String toDate, String orgDivision,String orgName) {
		logger.info("Method :receiptVoucherPdf starts");
		
		logger.info("Method :receiptVoucherPdf ends");
		return restReceiptDao.receiptVoucherPdf(fromDate,toDate,orgDivision,orgName);
	}
	
	@RequestMapping(value = "getRcvTdsInvoiceList", method = { RequestMethod.GET })
	public JsonResponse<Object> getTdsVoucherListRCV(String id, String orgName, String orgDiv) {
		logger.info("Method :getTdsVoucherListRCV start");

		logger.info("Method :getTdsVoucherListRCV endss");
		return restReceiptDao.getTdsVoucherListRCV(id, orgName, orgDiv);
	}
	
	@RequestMapping(value = "getReceiveInvoiceInfo", method = { RequestMethod.GET })
	public JsonResponse<Object> getReceiveInvoiceInfo(String ledgerid,String voucherid, String orgName, String orgDiv) {
		logger.info("Method :getReceiveInvoiceInfo start");

		logger.info("Method :getReceiveInvoiceInfo endss");
		return restReceiptDao.getReceiveInvoiceInfo(ledgerid,voucherid, orgName, orgDiv);
	}
	 
	@RequestMapping(value = "rest-approveRcptVoucher", method = { RequestMethod.POST })
	public JsonResponse<Object> approveRcptVoucherRest(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId, @RequestBody String data) {
		logger.info("Method :approveRcptVoucherRest start");
		
		logger.info("Method :approveRcptVoucherRest endss");
		return restReceiptDao.approveRcptVoucherDao(org, orgDiv, userId, data);
	}
	
	@RequestMapping(value = "receiptVoucherDetailsPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> receiptVoucherDetailsPdf(@RequestParam String id, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :receiptVoucherDetailsPdf start");

		logger.info("Method :receiptVoucherDetailsPdf endss");
		return restReceiptDao.receiptVoucherDetailsPdf(id, orgName, orgDivision);
	}
}
