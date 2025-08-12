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

import nirmalya.aatithya.restmodule.account.dao.RestPaymentVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestSalesInvoicePaymentModel;
import nirmalya.aatithya.restmodule.account.model.RestVendorNameListModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountPaymentController {
	Logger logger = LoggerFactory.getLogger(RestAccountPaymentController.class);
	@Autowired
	RestPaymentVoucherDao restPaymentVoucherDao;

	@RequestMapping(value = "addPaymentVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPaymentVoucher(
			@RequestBody List<AccountJournalVoucherModel> addPaymentVoucher) {
		logger.info("Method : addPaymentVoucher starts");
		System.out.println("===>>>" + addPaymentVoucher);
		logger.info("Method : addPaymentVoucher ends");
		return restPaymentVoucherDao.addPaymentVoucher(addPaymentVoucher);
	}

	// restViewContraVouDetails

	@RequestMapping(value = "restViewPaymentDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> restViewPaymentDetails(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :restViewPaymentDetails start");

		logger.info("Method :restViewPaymentDetails endss");
		return restPaymentVoucherDao.restViewPaymentDetails(orgName, orgDivision);

	}

	// editContraInfo

	@GetMapping(value = "editPaymentInfo")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editPaymentInfo(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :editPaymentInfo starts");

		logger.info("Method :editPaymentInfo ends" + id);
		return restPaymentVoucherDao.editPaymentInfo(id, orgName, orgDivision);

	}

	@RequestMapping(value = "getPaymentvoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber(String orgName, String orgDivision) {
		logger.info("Method: voucherNumber View Start");

		logger.info("Method: voucherNumber ends");
		return restPaymentVoucherDao.voucherNumber(orgName, orgDivision);
	}

	/*
	 * getDebitAccountSearch auto search
	 */
	@GetMapping(value = "getDebitPaymentAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getDebitAccountSearch starts");

		logger.info("Method :getDebitAccountSearch endss");
		return restPaymentVoucherDao.getDebitAccountSearch(id, orgName, orgDivision);
	}

	/*
	 * getCreditAccountSearch auto search
	 */
	@GetMapping(value = "getCreditPaymentAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getCreditAccountSearch(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getCreditAccountSearch starts");

		logger.info("Method :getCreditAccountSearch endss");
		return restPaymentVoucherDao.getCreditAccountSearch(id, orgName, orgDivision);
	}

	// deleteJournalDetails

	@RequestMapping(value = "deletePaymentDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :  deleteJournalDetails starts" + id);

		logger.info("Method :  deleteJournalDetails ends");
		return restPaymentVoucherDao.deleteJournalDetails(id, orgName, orgDivision);
	}

	@RequestMapping(value = "restViewPaymentFilter", method = { RequestMethod.GET })
	public JsonResponse<Object> restViewPaymentFilter(@RequestParam String orgName, @RequestParam String orgDivision,
			String fromDate, String toDate) {
		logger.info("Method :restViewPaymentFilter start");

		logger.info("Method :restViewPaymentFilter endss");
		return restPaymentVoucherDao.restViewPaymentFilter(orgName, orgDivision, fromDate, toDate);

	}

	/* Get Vendor Name List */

	/*
	 * @RequestMapping(value = "getVendorName", method = { RequestMethod.GET })
	 * public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorName() {
	 * logger.info("Method: getVendorName View Start");
	 * 
	 * logger.info("Method: getVendorName ends"); return
	 * restPaymentVoucherDao.getVendorName(); }
	 */

	/* Get Invoice List */

	@RequestMapping(value = "rest-invoiceList", method = { RequestMethod.GET })
	public JsonResponse<Object> invoiceList(@RequestParam String orgName, String orgDivision, String id) {
		logger.info("Method :invoiceList start");

		logger.info("Method :invoiceList endss");
		return restPaymentVoucherDao.invoiceList(orgName, orgDivision, id);
	}

	/* Auto Search */

	@GetMapping(value = "getVendorNameList")
	public ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> getVendorNameList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getVendorNameList starts");

		logger.info("Method :getVendorNameList endss");
		return restPaymentVoucherDao.getVendorNameList(id, org, orgDiv);
	}

	@RequestMapping(value = "addDebitNoteMethodAdj", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDebitNoteMethodAdj(
			@RequestBody RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		logger.info("Method : addDebitNoteMethodAdj starts" + restSalesInvoicePaymentModel);

		logger.info("Method : addDebitNoteMethodAdj ends");
		return restPaymentVoucherDao.addDebitNoteMethodAdj(restSalesInvoicePaymentModel);
	}

	@RequestMapping(value = "restGetDebitNoteListPayment", method = { RequestMethod.GET })
	public JsonResponse<Object> restGetDebitNoteListPayment(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String vendorId) {
		logger.info("Method :restGetDebitNoteListPayment start");

		logger.info("Method :restGetDebitNoteListPayment endss");
		return restPaymentVoucherDao.restGetDebitNoteListPayment(orgName, orgDivision, vendorId);

	}

	@RequestMapping(value = "getBankAccountPaymentList", method = { RequestMethod.GET })
	public List<DropDownModel> getBankAccountPaymentList(String orgName, String orgDivision) {
		logger.info("Method : getBankAccountPaymentList starts");

		logger.info("Method : getBankAccountPaymentList ends");
		return restPaymentVoucherDao.getBankAccountPaymentList(orgName, orgDivision);
	}

	@GetMapping(value = "paymentVoucherPdf")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> paymentVoucherPdf(
			@RequestParam String fromDate, String toDate, String orgDivision, String orgName) {
		logger.info("Method :paymentVoucherPdf starts");

		logger.info("Method :paymentVoucherPdf ends");
		return restPaymentVoucherDao.paymentVoucherPdf(fromDate, toDate, orgDivision, orgName);
	}

	@RequestMapping(value = "restGetTdsVoucherList", method = { RequestMethod.GET })
	public JsonResponse<Object> getTdsVoucherList(String id, String orgName, String orgDiv) {
		logger.info("Method :getTdsVoucherList start");

		logger.info("Method :getTdsVoucherList endss");
		return restPaymentVoucherDao.getTdsVoucherList(id, orgName, orgDiv);
	}

	@RequestMapping(value = "getPayInvoiceInfo", method = { RequestMethod.GET })
	public JsonResponse<Object> getPayInvoiceInfo(String ledgerid, String voucherid, String orgName, String orgDiv) {
		logger.info("Method :getPayInvoiceInfo start");

		logger.info("Method :getPayInvoiceInfo endss");
		return restPaymentVoucherDao.getPayInvoiceInfo(ledgerid, voucherid, orgName, orgDiv);
	}

	@RequestMapping(value = "PaymentVoucherDetailsPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> newPaymentVoucherDetailsPdf(@RequestParam String id, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :PaymentVoucherDetailsPdf start");

		logger.info("Method :PaymentVoucherDetailsPdf endss");
		return restPaymentVoucherDao.PaymentVoucherDetailsPdf(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-approvePayVoucher", method = { RequestMethod.POST })
	public JsonResponse<Object> approvePayVoucherRest(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId, @RequestBody String data) {
		logger.info("Method :approvePayVoucherRest start");
		
		logger.info("Method :approvePayVoucherRest endss");
		return restPaymentVoucherDao.approvePayVoucherDao(org, orgDiv, userId, data);
	}
}
