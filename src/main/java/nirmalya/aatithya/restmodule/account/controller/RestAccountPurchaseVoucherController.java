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

import nirmalya.aatithya.restmodule.account.dao.RestPurchaseVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseOrderRestModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;

@RestController
@RequestMapping(value = "account")
public class RestAccountPurchaseVoucherController {
	Logger logger = LoggerFactory.getLogger(RestAccountPurchaseVoucherController.class);
	@Autowired
	RestPurchaseVoucherDao restPurchaseVoucherDao;

	// JSON purchase view
	@RequestMapping(value = "rest-viewPurchaseVoucher", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPurchaseOrder(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewPurchaseOrder start");

		logger.info("Method :viewPurchaseOrder endss");
		return restPurchaseVoucherDao.viewPurchaseVoucher(org, orgDiv);
	}
	
	@RequestMapping(value = "getProductListDD", method = { RequestMethod.GET })
	public List<DropDownModel> getProductListDD(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String type) {
		logger.info("Method :getProductListDD start");
		
		logger.info("Method :getProductListDD endss");
		return restPurchaseVoucherDao.getProductListDD(org, orgDiv, type);
	}

	@RequestMapping(value = "rest-updateItemLedger", method = { RequestMethod.POST })
	public JsonResponse<Object> updateItemLedgerRest(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestBody String data) {
		logger.info("Method :updateItemLedgerRest start");

		logger.info("Method :updateItemLedgerRest endss");
		return restPurchaseVoucherDao.updateItemLedgerDao(org, orgDiv, userId, data);
	}
	
	@RequestMapping(value = "rest-addItemLedger", method = { RequestMethod.POST })
	public JsonResponse<Object> addItemLedgerRest(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestBody String data) {
		logger.info("Method :addItemLedgerRest start");
		
		logger.info("Method :addItemLedgerRest endss");
		return restPurchaseVoucherDao.addItemLedgerDao(org, orgDiv, userId, data);
	}

	@RequestMapping(value = "rest-updateNarration", method = { RequestMethod.POST })
	public JsonResponse<Object> updateNarrationRest(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestBody String data) {
		logger.info("Method :updateNarrationRest start");

		logger.info("Method :updateNarrationRest endss");
		return restPurchaseVoucherDao.updateNarrationDao(org, orgDiv, userId, data);
	}
	
	@RequestMapping(value = "rest-updateInvoice", method = { RequestMethod.POST })
	public JsonResponse<Object> updateInvoice(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestBody String data) {
		logger.info("Method :updateInvoice start");
		
		logger.info("Method :updateInvoice endss");
		return restPurchaseVoucherDao.updateInvoice(org, orgDiv, userId, data);
	}

	@RequestMapping(value = "rest-approveVoucher", method = { RequestMethod.POST })
	public JsonResponse<Object> approveVoucherRest(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestBody String data) {
		logger.info("Method :approveVoucherRest start");

		logger.info("Method :approveVoucherRest endss");
		return restPurchaseVoucherDao.approveVoucherDao(org, orgDiv, userId, data);
	}

	@GetMapping(value = "viewPurchaseVoucher")
	public JsonResponse<Object> viewPurchaseVoucher(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String vtype) {
		logger.info("Method : viewPurchaseVoucher starts");
		logger.info("Method :viewPurchaseVoucher endss");
		return restPurchaseVoucherDao.viewPurchaseVoucher(id, org, orgDiv, vtype);
	}

	@RequestMapping(value = "rest-viewPurchaseFilteredData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPurchaseFilteredData(@RequestParam String orgName, String orgDivision,
			String fromDate, String toDate, String vtype) {
		logger.info("Method :viewPurchaseFilteredData start");

		logger.info("Method :viewPurchaseFilteredData endss");
		return restPurchaseVoucherDao.viewPurchaseFilteredData(orgName, orgDivision, fromDate, toDate, vtype);

	}

	@GetMapping(value = "accountRegisterPdf")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> accountRegisterPdf(
			@RequestParam String voucherType, String fromDate, String toDate, String orgName, String orgDivision) {
		logger.info("Method :accountRegisterPdf starts");

		logger.info("Method :accountRegisterPdf ends" + voucherType);
		return restPurchaseVoucherDao.accountRegisterPdf(voucherType, fromDate, toDate, orgName, orgDivision);
	}

	// Excel.

	@RequestMapping(value = "accountRegisterExcel", method = { RequestMethod.GET })
	public JsonResponse<Object> purchaseRegisterExcel(@RequestParam String voucherType, String fromDate, String toDate,
			String orgName, String orgDivision) {
		logger.info("Method :purchaseRegisterExcel starts");

		logger.info("Method :accountRegisterPdf ends" + voucherType);
		return restPurchaseVoucherDao.purchaseRegisterExcel(voucherType, fromDate, toDate, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-getVendorTdsAmount", method = { RequestMethod.GET })
	public JsonResponse<Object> getVendorTdsAmount(@RequestParam String orgName, String orgDivision, String voucherid,
			String invoiceid, String vtype) {
		logger.info("Method :getVendorTdsAmount start");

		logger.info("Method :getVendorTdsAmount endss");
		return restPurchaseVoucherDao.vendorTdsAmount(orgName, orgDivision, voucherid, invoiceid, vtype);

	}

	@RequestMapping(value = "rest-tdsAmountEdit", method = { RequestMethod.GET })
	public JsonResponse<Object> tdsAmountAdit(@RequestParam String orgName, String orgDivision, String tdsAmount,
			String vendorid, String tdsRate, String invoiceId, String voucherId, String userId, String finalPayableAmt,
			String tdsLedgerId, String tdsTransactionDate, String tdsNarration, String roundOffAmount, String tdsSection, String tdsInvList) {
		logger.info("Method :tdsAmountAdit start");

		logger.info("Method :tdsAmountAdit endss");
		return restPurchaseVoucherDao.tdsAmountAdit(orgName, orgDivision, tdsAmount, vendorid, tdsRate, invoiceId,
				voucherId, userId, finalPayableAmt, tdsLedgerId, tdsTransactionDate, tdsNarration, roundOffAmount, tdsSection, tdsInvList);
	}

	@RequestMapping(value = "getTdsLedgerList", method = { RequestMethod.GET })
	public List<DropDownModel> getTdsLedgerList(String orgName, String orgDivision) {
		logger.info("Method : getTdsLedgerList starts");

		logger.info("Method : getTdsLedgerList");
		return restPurchaseVoucherDao.getTdsLedgerList(orgName, orgDivision);
	}

	@RequestMapping(value = "getCurrentVoucherTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getCurrentVoucherTypeList(String orgName, String orgDivision) {
		logger.info("Method : getCurrentVoucherTypeList starts");

		logger.info("Method : getCurrentVoucherTypeList");
		return restPurchaseVoucherDao.getCurrentVoucherTypeList(orgName, orgDivision);
	}

	@GetMapping(value = "getcurrentvoucher")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getcurrentvoucher(@RequestParam String id, String orgName,
			String orgDivision) {
		logger.info("Method : getcurrentvoucher starts");

		logger.info("Method : getcurrentvoucher endss");
		return restPurchaseVoucherDao.getcurrentvoucher(id, orgName, orgDivision);
	}

	@RequestMapping(value = "getvoucherClassList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getvoucherClassList(@RequestParam String id,
			String orgName, String orgDivision) {
		logger.info("Method : getvoucherClassList starts");
		logger.info("Method : getvoucherClassList ends");
		return restPurchaseVoucherDao.getvoucherClassList(id, orgName, orgDivision);
	}

	@GetMapping(value = "getLedgervoucher")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLedgervoucher(@RequestParam String id, String orgName,
			String orgDivision) {
		logger.info("Method : getLedgervoucher starts");

		logger.info("Method : getLedgervoucher endss");
		return restPurchaseVoucherDao.getLedgervoucher(id, orgName, orgDivision);
	}
	
	@GetMapping(value = "getTdsSection")
	public ResponseEntity<JsonResponse<Object>> getTdsSection(@RequestParam String id, String org,
			String orgDiv, String type) {
		logger.info("Method : getTdsSection starts");
		
		logger.info("Method : getTdsSection endss");
		return restPurchaseVoucherDao.getTdsSection(id, org, orgDiv, type);
	}

	@RequestMapping(value = "rest-saveVoucherDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> saveVoucherDetails(@RequestParam String orgName, String orgDivision,
			String voucherTypeId, String voucherClassId, String ledgerName, String ledgerId, String pVoucherId,
			String invoiceId) {
		logger.info("Method :saveVoucherDetails start");

		logger.info("Method :saveVoucherDetails endss");
		return restPurchaseVoucherDao.saveVoucherDetails(orgName, orgDivision, voucherTypeId, voucherClassId,
				ledgerName, ledgerId, pVoucherId, invoiceId);
	}
}
