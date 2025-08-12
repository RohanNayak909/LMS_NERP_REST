package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.RestAccountCreditNoteDao;
import nirmalya.aatithya.restmodule.account.model.AccountCreditNoteRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.ItemShoukeenModel;
import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountCreditNoteController {
	Logger logger = LoggerFactory.getLogger(RestAccountCreditNoteController.class);
	@Autowired
	RestAccountCreditNoteDao creditNoteDao;

	@RequestMapping(value = "getorderList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getorderList(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getorderList starts");
		logger.info("Method : getorderList ends");
		return creditNoteDao.getorderList(id, orgName, orgDivision);
	}

	@GetMapping(value = "getCreditLedgerList")
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> getCreditLedgerList(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getCreditLedgerList starts");

		logger.info("Method :getCreditLedgerList endss");
		return creditNoteDao.getCreditLedgerList(id, orgName, orgDivision);
	}

	@RequestMapping(value = "getProductList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProductList(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getProductList starts");
		logger.info("Method : getProductList ends");
		return creditNoteDao.getProductList(id, orgName, orgDivision);
	}

	@RequestMapping(value = "getProductDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ItemShoukeenModel>>> getProductDetails(@RequestParam String id,
			@RequestParam String pid, @RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getProductDetails starts");
		logger.info("Method : getProductDetails ends");
		return creditNoteDao.getProductDetails(id, pid, orgName, orgDivision);
	}

	@PostMapping(value = "addCreditNote")
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> addDealerOrderNew(
			@RequestBody List<AccountCreditNoteRestModel> addCreditNote) {
		logger.info("Method :addDealerOrderNew starts");
		System.out.println("adddddddd" + addCreditNote);
		logger.info("Method :addDealerOrderNew endss");
		return creditNoteDao.addCreditNote(addCreditNote);
	}

	// creditNoteView

	/*
	 * @RequestMapping(value = "creditNoteView", method = { RequestMethod.GET })
	 * public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>>
	 * creditNoteView(@RequestParam String userId,@RequestParam String
	 * orgName,@RequestParam String orgDivision) {
	 * logger.info("Method: creditNoteView Start");
	 * 
	 * logger.info("Method: creditNoteView ends"); return
	 * creditNoteDao.creditNoteView(userId,orgName,orgDivision); }
	 */

	@RequestMapping(value = "creditNoteView", method = { RequestMethod.GET })
	public JsonResponse<Object> creditNoteView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :creditNoteView start");

		logger.info("Method :creditNoteView endss");
		return creditNoteDao.creditNoteView(orgName, orgDivision);
	}

	
	@RequestMapping(value = "viewCreditNote", method = { RequestMethod.GET })
	public JsonResponse<Object> viewCreditNote(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :creditNoteView start");

		logger.info("Method :viewCreditNote endss");
		return creditNoteDao.viewCreditNote(id, orgName, orgDivision);
	}

	@RequestMapping(value = "getCreditNotevoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber(String orgName, String orgDivision) {
		logger.info("Method: voucherNumber View Start");

		logger.info("Method: voucherNumber ends");
		return creditNoteDao.voucherNumber(orgName, orgDivision);
	}

	@RequestMapping(value = "viewCreditNoteFilter", method = { RequestMethod.GET })
	public JsonResponse<Object> viewCreditNoteFilter(@RequestParam String orgName, @RequestParam String orgDivision,
			String fromDate, String toDate) {
		logger.info("Method :viewCreditNoteFilter start");

		logger.info("Method :viewCreditNoteFilter endss");
		return creditNoteDao.viewCreditNoteFilter(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "addCreditNoteVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPaymentVoucher(
			@RequestBody List<AccountJournalVoucherModel> addCreditNoteVoucher) {
		logger.info("Method : addCreditNoteVoucher starts");
		System.out.println("===>>>" + addCreditNoteVoucher);
		logger.info("Method : addCreditNoteVoucher ends");
		return creditNoteDao.addCreditNoteVoucher(addCreditNoteVoucher);
	}

	@GetMapping(value = "editVoucher")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editVoucher(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :editVoucher starts");

		logger.info("Method :editVoucher ends" + id);
		return creditNoteDao.editVoucher(id, orgName, orgDivision);

	}
	
	
	@RequestMapping(value = "deleteCreditNote", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCreditNote(@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method :  deleteCreditNote starts" + id);

		logger.info("Method :  deleteCreditNote ends");
		return creditNoteDao.deleteCreditNote(id,orgName,orgDivision);
	}

}
