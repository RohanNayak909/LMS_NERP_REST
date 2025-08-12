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

import nirmalya.aatithya.restmodule.account.dao.RestAccountDebitNoteDao;
import nirmalya.aatithya.restmodule.account.model.AccountCreditNoteRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestPurchaseItemModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountDebitNoteController {
	Logger logger = LoggerFactory.getLogger(RestAccountDebitNoteController.class);
	@Autowired
	RestAccountDebitNoteDao debitNoteDao;
	
	
	@RequestMapping(value = "getPurchaseorderList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getorderList(@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getorderList starts");
		logger.info("Method : getorderList ends");
		return debitNoteDao.getorderList(id,orgName,orgDivision);
	}

	@RequestMapping(value = "getPurchaseProductList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProductList(@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getProductList starts");
		logger.info("Method : getProductList ends");
		return debitNoteDao.getProductList(id,orgName,orgDivision);
	}
	
	@GetMapping(value = "getDebitLedgerList")
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> getDebitLedgerList(@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getDebitLedgerList starts");

		logger.info("Method :getDebitLedgerList endss");
		return debitNoteDao.getDebitLedgerList(id,orgName,orgDivision);
	}

	@RequestMapping(value = "getPurchaseProductDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseItemModel>>> getProductDetails(@RequestParam String id,
			@RequestParam String pid,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getProductDetails starts");
		logger.info("Method : getProductDetails ends");
		return debitNoteDao.getProductDetails(id, pid,orgName,orgDivision);
	}

	/*
	 * @PostMapping(value = "addDebitNote") public
	 * ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> addDebitNote(
	 * 
	 * @RequestBody List<AccountCreditNoteRestModel> addCreditNote) {
	 * logger.info("Method :addDebitNote starts"); System.out.println("adddddddd" +
	 * addCreditNote); logger.info("Method :addDebitNote endss"); return
	 * debitNoteDao.addDebitNote(addCreditNote); }
	 */
	
	@RequestMapping(value = "addDebitNote", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDebitNote(@RequestBody AccountCreditNoteRestModel addCreditNote) {
		logger.info("Method : addDebitNote starts");

		logger.info("Method : addDebitNote ends");

		return debitNoteDao.addDebitNote(addCreditNote);
	}

	// creditNoteView

	/*
	 * @RequestMapping(value = "debitNoteView", method = { RequestMethod.GET })
	 * public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>>
	 * debitNoteView(@RequestParam String userId,@RequestParam String
	 * orgName,@RequestParam String orgDivision) {
	 * logger.info("Method: debitNoteView Start");
	 * 
	 * logger.info("Method: debitNoteView ends"); return
	 * debitNoteDao.debitNoteView(userId,orgName,orgDivision); }
	 */
	
	@RequestMapping(value = "debitNoteView", method = { RequestMethod.GET })
	public JsonResponse<Object> debitNoteView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :debitNoteView start");

		logger.info("Method :debitNoteView endss");
		return debitNoteDao.debitNoteView(orgName, orgDivision);
	}
	
	
	/*
	 * @GetMapping(value = "viewDebitNote") public
	 * ResponseEntity<JsonResponse<AccountCreditNoteRestModel>>
	 * viewDebitNote(@RequestParam String id,@RequestParam String
	 * orgName,@RequestParam String orgDivision) {
	 * logger.info("Method :viewDebitNote starts");
	 * 
	 * logger.info("Method :viewDebitNote ends"+id); return
	 * debitNoteDao.viewDebitNote(id,orgName,orgDivision);
	 * 
	 * }
	 */
	

	@RequestMapping(value = "viewDebitNote", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDebitNote(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :viewDebitNote start");

		logger.info("Method :viewDebitNote endss");
		return debitNoteDao.viewDebitNote(id,orgName, orgDivision);
	}

	@RequestMapping(value = "getDebitNotevoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber(String orgName , String orgDivision) {
		logger.info("Method: voucherNumber View Start");

		logger.info("Method: voucherNumber ends");
		return debitNoteDao.voucherNumber(orgName,orgDivision);
	}
	
	@RequestMapping(value = "viewDebitNoteFilter", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDebitNoteFilter(@RequestParam String orgName, @RequestParam String orgDivision,
			String fromDate, String toDate) {
		logger.info("Method :viewDebitNoteFilter start");
		
		logger.info("Method :viewDebitNoteFilter endss");
		return debitNoteDao.viewDebitNoteFilter(orgName, orgDivision, fromDate, toDate);
	}
	
	
	@RequestMapping(value = "addDebitNoteVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDebitNoteVoucher(
			@RequestBody List<AccountJournalVoucherModel> addDebitNoteVoucher) {
		logger.info("Method : addDebitNoteVoucher starts");
		System.out.println("===>>>"+addDebitNoteVoucher);
		logger.info("Method : addDebitNoteVoucher ends");
		return debitNoteDao.addDebitNoteVoucher(addDebitNoteVoucher);
	}
	
	@GetMapping(value = "editVoucherForDebit")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editVoucherForDebit(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :editVoucherForDebit starts");

		logger.info("Method :editVoucherForDebit ends" + id);
		return debitNoteDao.editVoucherForDebit(id, orgName, orgDivision);

	}
	
	@RequestMapping(value = "deleteDebitNote", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDebitNote(@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method :  deleteDebitNote starts" + id);

		logger.info("Method :  deleteDebitNote ends");
		return debitNoteDao.deleteDebitNote(id,orgName,orgDivision);
	}

}
