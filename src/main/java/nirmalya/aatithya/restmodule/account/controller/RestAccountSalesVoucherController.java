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

import nirmalya.aatithya.restmodule.account.dao.RestSalesVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseOrderRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountSalesVoucherController {
	Logger logger = LoggerFactory.getLogger(RestAccountSalesVoucherController.class);
	@Autowired
	RestSalesVoucherDao restSalesVoucherDao;

	@RequestMapping(value = "rest-viewSalesVoucher", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSalesOrder(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewSalesOrder start");

		logger.info("Method :viewSalesOrder endss");
		return restSalesVoucherDao.viewSalesVoucher(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-salesUpdateItemLedger", method = { RequestMethod.POST })
	public JsonResponse<Object> salesUpdateItemLedgerRest(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId, @RequestBody String data) {
		logger.info("Method :salesUpdateItemLedgerRest start");
		
		logger.info("Method :salesUpdateItemLedgerRest endss");
		return restSalesVoucherDao.salesUpdateItemLedgerDao(org, orgDiv, userId, data);
		
	}
	
	@RequestMapping(value = "rest-updateNarrationSales", method = { RequestMethod.POST })
	public JsonResponse<Object> updateNarrationSalesRest(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId, @RequestBody String data) {
		logger.info("Method :updateNarrationSalesRest start");
		
		logger.info("Method :updateNarrationSalesRest endss");
		return restSalesVoucherDao.updateNarrationSalesDao(org, orgDiv, userId, data);
	}
	
	@RequestMapping(value = "rest-approveVoucherSales", method = { RequestMethod.POST })
	public JsonResponse<Object> approveVoucherSalesRest(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId, @RequestBody String data) {
		logger.info("Method :approveVoucherSalesRest start");
		
		logger.info("Method :approveVoucherSalesRest endss");
		return restSalesVoucherDao.approveVoucherSalesDao(org, orgDiv, userId, data);
	}

	@GetMapping(value = "viewEditSalesVoucher")
	public ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> viewEditSalesVoucher(
			@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewEditSalesVoucher starts");

		logger.info("Method :viewEditSalesVoucher ends" + id);
		return restSalesVoucherDao.viewEditSalesVoucher(id, org, orgDiv);

	}

	@RequestMapping(value = "rest-viewSalesFilteredData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSalesFilteredData(@RequestParam String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method :viewSalesFilteredData start");

		logger.info("Method :viewSalesFilteredData endss");
		return restSalesVoucherDao.viewSalesFilteredData(orgName, orgDivision, fromDate, toDate);

	}

	@RequestMapping(value = "rest-getCustmerTdsAmount", method = { RequestMethod.GET })
	public JsonResponse<Object> getCustmerTdsAmount(@RequestParam String orgName, String orgDivision, String voucherid,
			String invoiceid) {
		logger.info("Method :getCustmerTdsAmount start");

		logger.info("Method :getCustmerTdsAmount endss");
		return restSalesVoucherDao.CustmerTdsAmount(orgName, orgDivision, voucherid, invoiceid);

	}

	@RequestMapping(value = "getTdsLedgerListCustmer", method = { RequestMethod.GET })
	public List<DropDownModel> getTdsLedgerListCustmer(String orgName, String orgDivision) {
		logger.info("Method : getTdsLedgerListCustmer starts");

		logger.info("Method : getTdsLedgerListCustmer");
		return restSalesVoucherDao.getTdsLedgerListCustmer(orgName, orgDivision);
	}

	@RequestMapping(value = "rest-tdsAmountEditCustomer", method = { RequestMethod.GET })
	public JsonResponse<Object> tdsAmountAdit(@RequestParam String orgName, String orgDivision, String tdsAmount,
			String vendorid, String tdsRate, String invoiceId, String voucherId, String userId, String finalPayableAmt,
			String tdsLedgerId, String tdsTransactionDate, String tdsNarration, String roundOffAmount) {
		logger.info("Method :tdsAmountAdit start");

		logger.info("Method :tdsAmountAdit endss");
		return restSalesVoucherDao.tdsAmountAdit(orgName, orgDivision, tdsAmount, vendorid, tdsRate, invoiceId,
				voucherId, userId, finalPayableAmt, tdsLedgerId, tdsTransactionDate, tdsNarration, roundOffAmount);
	}

	@RequestMapping(value = "getCurrentVoucherTypeListForSale", method = { RequestMethod.GET })
	public List<DropDownModel> getCurrentVoucherTypeListForSale(String orgName, String orgDivision) {
		logger.info("Method : getCurrentVoucherTypeListForSale starts");

		logger.info("Method : getCurrentVoucherTypeListForSale");
		return restSalesVoucherDao.getCurrentVoucherTypeListForSale(orgName, orgDivision);
	}

	@GetMapping(value = "getcurrentvoucherForSale")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getcurrentvoucherForSale(@RequestParam String id,
			String orgName, String orgDivision) {
		logger.info("Method : getcurrentvoucherForSale starts");

		logger.info("Method : getcurrentvoucherForSale endss");
		return restSalesVoucherDao.getcurrentvoucherForSale(id, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-saveVoucherDetailsforSale", method = { RequestMethod.GET })
	public JsonResponse<Object> saveVoucherDetailsforSale(@RequestParam String orgName, String orgDivision,
			String voucherTypeId, String voucherClassId, String ledgerName, String ledgerId, String pVoucherId,
			String invoiceId) {
		logger.info("Method :saveVoucherDetailsforSale start");

		logger.info("Method :saveVoucherDetailsforSale endss");
		return restSalesVoucherDao.saveVoucherDetailsforSale(orgName, orgDivision, voucherTypeId, voucherClassId,
				ledgerName, ledgerId, pVoucherId, invoiceId);
	}

}
