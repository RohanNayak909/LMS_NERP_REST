package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountReportsDao;
import nirmalya.aatithya.restmodule.account.model.AccountLedgerReportRestModel;
import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;
import nirmalya.aatithya.restmodule.account.model.RestAccountReportModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountTrailBalanceModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account")
public class AccountReportsRestController {
	Logger logger = LoggerFactory.getLogger(AccountReportsRestController.class);
	@Autowired
	RestAccountReportsDao restReportDao;

	/*
	 * for ledger voucher report view
	 */
	@RequestMapping(value = "viewLedgerVoucherReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerVoucherReport(
			@RequestParam String id, @RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method: viewLedgerVoucherReport View Start");
		logger.info("Method: viewLedgerVoucherReport ends");
		return restReportDao.viewLedgerVoucherReport(id, orgName, orgDivision);
	}

	/*
	 * for day book voucher report view
	 */
 
	@RequestMapping(value = "viewDayBookReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewDayBookReport(
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method: viewDayBookReport Start");
		logger.info("Method: viewDayBookReport ends");
		return restReportDao.viewDayBookReport(fromDate, toDate);
	}

	/*
	 * for cash flow voucher report view
	 */

	@RequestMapping(value = "viewCashFlowReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewCashFlowReport() {
		logger.info("Method: viewCashFlowReport Start");
		logger.info("Method: viewCashFlowReport ends");
		return restReportDao.viewCashFlowReport();
	}

	/*
	 * for account statement monthly ledger summary
	 */

	@RequestMapping(value = "viewLedgerMonthlySummary", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerMonthlySummary(
			@RequestParam String id, @RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method: viewLedgerMonthlySummary Start");
		logger.info("Method: viewLedgerMonthlySummary ends");
		return restReportDao.viewLedgerMonthlySummary(id, orgName, orgDivision);
	}

	/*
	 * for account statement monthly details
	 */

	@RequestMapping(value = "viewMothlyDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewMothlyDetails(
			@RequestParam String month, @RequestParam String ledgerId, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method: viewMothlyDetails Start");
		logger.info("Method: viewMothlyDetails ends");
		return restReportDao.viewMothlyDetails(month, ledgerId, orgName, orgDivision);
	}

	/*
	 * for account statement trialBalanceReport details
	 */

	@RequestMapping(value = "trialBalanceReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> trialBalanceReport(
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method: trialBalanceReport Start");
		logger.info("Method: trialBalanceReport ends");
		return restReportDao.trialBalanceReport(fromDate, toDate);
	}

	// profitLossReport
	/*
	 * @RequestMapping(value="profitLossReport" , method = {RequestMethod.GET})
	 * public ResponseEntity<JsonResponse<List<DataSetAccountTree>>>
	 * profitLossReport(@RequestParam String fromDate,@RequestParam String toDate){
	 * logger.info("Method: profitLossReport Start");
	 * logger.info("Method: profitLossReport ends"); return
	 * restReportDao.profitLossReport(fromDate,toDate); }
	 */

	// get voucher types list
//	@RequestMapping(value = "getVoucherTypeList", method = { RequestMethod.GET })
//	public List<DropDownModel> getVoucherTypeList() {
//		logger.info("Method : getVoucherTypeList starts");
//		
//		logger.info("Method : getVoucherTypeList ends");
//		return restReportDao.getVoucherTypeList();
//	}

	@RequestMapping(value = "viewLedgerReportWrtVoucherType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerReportWrtVoucherType(
			@RequestParam String id, String voucherType) {
		logger.info("Method: viewLedgerReportWrtVoucherType Start");

		logger.info("Method: viewLedgerReportWrtVoucherType ends");
		return restReportDao.viewLedgerReportWrtVoucherType(id, voucherType);
	}

	@RequestMapping(value = "viewLedgerReportWrtDate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerReportWrtDate(
			@RequestParam String id, String voucherType, String fromDate, String toDate, String orgName,
			String orgDivision) {
		logger.info("Method: viewLedgerReportWrtDate Start");

		logger.info("Method: viewLedgerReportWrtDate ends");
		return restReportDao.viewLedgerReportWrtDate(id, voucherType, fromDate, toDate, orgName, orgDivision);
	}

	@RequestMapping(value = "dayBookReportVoucher", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> dayBookReportVoucher(
			@RequestParam String fromDate, @RequestParam String toDate, String voucherType) {
		logger.info("Method: dayBookReportVoucher Start");

		logger.info("Method: dayBookReportVoucher ends");
		return restReportDao.dayBookReportVoucher(fromDate, toDate, voucherType);
	}

	// Payment Planning Main List
	@RequestMapping(value = "restViewPaymentPlanning", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> restViewPaymentPlanning(
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method: restViewPaymentPlanning Start");

		logger.info("Method: restViewPaymentPlanning ends");
		return restReportDao.restViewPaymentPlanning(orgName, orgDivision);
	}

	// invoice lists by vendor
	@RequestMapping(value = "getInvoiceListByLedger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> getInvoiceListByLedger(
			@RequestParam String ledgerId, @RequestParam String vendorId) {
		logger.info("Method: getInvoiceListByLedger Start");

		logger.info("Method: getInvoiceListByLedger ends");
		return restReportDao.getInvoiceListByLedger(ledgerId, vendorId);
	}

	@RequestMapping(value = "profitLossSheetAct", method = { RequestMethod.GET })
	public JsonResponse<Object> profitLossSheetAct(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :profitLossSheetAct start");
		logger.info("Method :profitLossSheetAct endss");
		return restReportDao.profitLossSheetAct(orgName, orgDivision);
	}

	@RequestMapping(value = "getChildList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getChildList(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method : getChildList starts");
		logger.info("Method : getChildList ends");
		return restReportDao.getChildList(id, orgName, orgDiv);
	}

	/*
	 * @RequestMapping(value = "getParentAmount",method = {RequestMethod.GET})
	 * public ResponseEntity<JsonResponse<List<DataSetAccountTree>>>
	 * getParentAmount() { logger.info("Method : getParentAmount starts");
	 * logger.info("Method : getParentAmount ends"); return
	 * restReportDao.getParentAmount(); }
	 */

	@RequestMapping(value = "getParentAmount", method = { RequestMethod.GET })
	public JsonResponse<Object> getParentAmount(@RequestParam String orgName, String orgDiv) {
		logger.info("Method :getParentAmount start");
		logger.info("Method :getParentAmount endss");
		return restReportDao.getParentAmount(orgName, orgDiv);
	}

	@RequestMapping(value = "Rest-profile-and-loss-reportData", method = { RequestMethod.GET })
	public JsonResponse<Object> profitLosssAccountReport(@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :profitLosssAccountReport start");
		logger.info("Method :profitLosssAccountReport endss");
		return restReportDao.profitLosssAccountReport(orgName, orgDiv);
	}

	@RequestMapping(value = "trailBalanceChild", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> trailBalanceChild(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDiv, @RequestParam String fromDate,
			@RequestParam String toDate) {
		logger.info("Method : trailBalanceChild starts");
		logger.info("Method : trailBalanceChild ends");
		return restReportDao.trailBalanceChild(id, orgName, orgDiv, fromDate, toDate);
	}

	@RequestMapping(value = "getTrailBalAmount", method = { RequestMethod.GET })
	public JsonResponse<Object> getTrailBalAmount() {
		logger.info("Method :getTrailBalAmount start");
		logger.info("Method :getTrailBalAmount endss");
		return restReportDao.getTrailBalAmount();
	}

	@RequestMapping(value = "getDynamicparentlist", method = { RequestMethod.GET })
	public JsonResponse<Object> getDynamicparentlist(@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getDynamicparentlist start");
		logger.info("Method :getDynamicparentlist endss");
		return restReportDao.getDynamicparentlist(orgName, orgDiv);
	}

	@RequestMapping(value = "getProfitLossParentList", method = { RequestMethod.GET })
	public JsonResponse<Object> getProfitLossParentList(@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getProfitLossParentList start");
		logger.info("Method :getProfitLossParentList endss");
		return restReportDao.getProfitLossParentList(orgName, orgDiv);
	}

	@RequestMapping(value = "getTrialBalanceParentList", method = { RequestMethod.GET })
	public JsonResponse<Map<String, Object>> getTrialBalanceParentList(@RequestParam String orgName,
			@RequestParam String orgDiv, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :getTrialBalanceParentList start" + orgName);
		logger.info("Method :getTrialBalanceParentList endss");
		return restReportDao.getTrialBalanceParentList(orgName, orgDiv, fromDate, toDate);
	}

	@RequestMapping(value = "rest-getLedgerListBSheet", method = { RequestMethod.GET })
	public JsonResponse<Object> getLedgerListBSheet(@RequestParam String groupId, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :getLedgerListBSheet start");

		logger.info("Method :getLedgerListBSheet endss");
		return restReportDao.getLedgerListBSheet(groupId, orgName, orgDivision);

	}

	@RequestMapping(value = "viewMothlyDetailsFilter", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewMothlyDetailsFilterData(
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String ledgerId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method: viewMothlyDetailsFilter Start");
		logger.info("Method: viewMothlyDetailsFilter ends");
		return restReportDao.viewMothlyDetailsFilterData(fromDate, toDate, ledgerId, orgName, orgDivision);
	}

	@RequestMapping(value = "dayBookReportFilterData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> dayBookReportFilterData(
			@RequestParam String inputDate, @RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method: dayBookReportFilterData Start");

		logger.info("Method: dayBookReportFilterData ends");
		return restReportDao.dayBookReportFilterData(inputDate, orgName, orgDivision);
	}

	@RequestMapping(value = "dayBookPdfData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestAccountReportModel>>> dayBookPdfData(@RequestParam String inputDate,
			String orgName, String orgDivision) {
		logger.info("Method: dayBookPdfData Start");

		logger.info("Method: dayBookPdfData ends");
		return restReportDao.dayBookPdfData(inputDate, orgName, orgDivision);
	}

	@RequestMapping(value = "getVoucherDetailsBSheet", method = { RequestMethod.GET })
	public JsonResponse<Object> getVoucherDetailsBSheet(@RequestParam String voucherId, String voucherType,
			String orgName, String orgDivision) {
		logger.info("Method :getVoucherDetailsBSheet start");

		logger.info("Method :getVoucherDetailsBSheet ends");
		return restReportDao.getVoucherDetailsBSheet(voucherId, voucherType, orgName, orgDivision);
	}

	@RequestMapping(value = "proposeAmountAdd", method = { RequestMethod.POST })
	public JsonResponse<Object> proposeAmountAdd(@RequestBody String selectedRowData, @RequestParam String vendorId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :proposeAmountAddstart----" + vendorId);

		logger.info("Method :proposeAmountAdd ends");
		return restReportDao.proposeAmountAdd(selectedRowData, vendorId, orgName, orgDivision);
	}

	@RequestMapping(value = "getProposeAmountDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getProposeAmountDetails(@RequestParam String vendorId, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :getProposeAmountDetails start");

		logger.info("Method :getProposeAmountDetails ends");
		return restReportDao.getProposeAmountDetails(vendorId, orgName, orgDivision);
	}

	@RequestMapping(value = "ledgerVoucherPdfData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestAccountReportModel>>> ledgerVoucherPdfData(
			@RequestParam String ledgerId, String voucherType, String fromDate, String toDate, String orgName,
			String orgDivision) {
		logger.info("Method: ledgerVoucherPdf Start");

		logger.info("Method: ledgerVoucherPdf ends");
		return restReportDao.ledgerVoucherPdfData(ledgerId, voucherType, fromDate, toDate, orgName, orgDivision);
	}

	@RequestMapping(value = "accountStatementPdfData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestAccountReportModel>>> accountStatementPdfData(
			@RequestParam String ledgerid, String fromDate, String toDate, String month, String orgName,
			String orgDivision) {
		logger.info("Method: accountStatementPdfData Start");

		logger.info("Method: accountStatementPdfData ends");
		return restReportDao.accountStatementPdf(ledgerid, fromDate, toDate, month, orgName, orgDivision);
	}

	/* trail Balance Rest Controller */

	@PostMapping(value = "get-trial-balance-rows")
	public ResponseEntity<JsonResponse<Object>> getTrialBalanceRows(@RequestBody RestAccountTrailBalanceModel tBModel,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getTrialBalanceRows starts");

		logger.info("Method : getTrialBalanceRows ends");
		return restReportDao.getTrialBalanceRows(tBModel, orgName, orgDivision);
	}
	
	@PostMapping(value = "get-level-one")
	public ResponseEntity<JsonResponse<Object>> getLevelOne(@RequestBody RestAccountTrailBalanceModel tBModel,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getLevelOne starts");
		
		logger.info("Method : getLevelOne ends");
		return restReportDao.getLevelOne(tBModel, orgName, orgDivision);
	}

	@PostMapping(value = "get-level-others")
	public ResponseEntity<JsonResponse<Object>> getLevelOthers(@RequestBody RestAccountTrailBalanceModel tBModel,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getLevelOthers starts");
		logger.info("orgName-->" + orgName);
		logger.info("orgDivision-->" + orgDivision);
		logger.info("Method : getLevelOthers ends");
		return restReportDao.getLevelOthers(tBModel, orgName, orgDivision);
	}

	@RequestMapping(value = "viewTrailBalanceLedger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewTrailBalanceLedger(
			@RequestParam String id, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method: viewTrailBalanceLedger View Start");
		logger.info("Method: viewTrailBalanceLedger ends");
		return restReportDao.viewTrailBalanceLedger(id, orgName, orgDivision, fromdate, todate);
	}

	@RequestMapping(value = "get-AccountReportList", method = { RequestMethod.GET })
	public JsonResponse<Object> AccountReportList(@RequestParam String orgName, @RequestParam String orgDivision,
			String id) {
		logger.info("Method :AccountReportList start");

		logger.info("Method :AccountReportList endss");
		return restReportDao.AccountReportList(orgName, orgDivision, id);

	}

}
