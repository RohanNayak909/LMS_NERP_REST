package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.DebitRestDao;
import nirmalya.aatithya.restmodule.account.dao.RestAccountCreditNoteDao;
import nirmalya.aatithya.restmodule.account.model.RestDebitLedgerModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.model.RestQuotationDetailsModel;

@RestController
@RequestMapping(value = "account")
public class DebitRestController {
	
	Logger logger = LoggerFactory.getLogger(RestAccountCreditNoteController.class);
	@Autowired
	DebitRestDao debitRestDao;

	
	@RequestMapping(value = "getfiscalList", method = { RequestMethod.GET })
	public List<DropDownModel> getfiscalList() {
		logger.info("Method : getfiscalList starts");

		logger.info("Method : getfiscalList ends");
		return debitRestDao.getfiscalList();

	}


	// view
	@RequestMapping(value = "rest-viewDebit", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDebit(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewDebit start");
		logger.info("Method :viewDebit endss");
		return debitRestDao.viewDebit(orgName, orgDivision);
	}
	
	
	@RequestMapping(value = "debit-view-Filter", method = { RequestMethod.GET })
	public JsonResponse<Object> debitviewFilter(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String financialYear, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :debitviewFilter start");

		logger.info("Method :debitviewFilter endss");
		return debitRestDao.debitviewFilter(orgName, orgDivision,financialYear,fromDate,toDate);
	}
	
	@GetMapping(value = "debitgetvenderlist")
	public ResponseEntity<JsonResponse<List<RestDebitLedgerModel>>> DebitgetVenderList(
			@RequestParam String id) {
		logger.info("Method : getDebitgetVenderList starts");

		logger.info("Method :getDebitgetVenderList endss");
		return debitRestDao.getDebitgetVenderList(id)
;
	}
	
	@GetMapping(value = "debitledgerpdf")
	public ResponseEntity<JsonResponse<List<RestDebitLedgerModel>>> debitledgerpdf(@RequestParam String id, String fromDate, String toDate) {
		logger.info("Method :debitledgerpdf starts"+fromDate);

		logger.info("Method :debitledgerpdf ends"+toDate);
		return debitRestDao.debitledgerpdf(id,fromDate,toDate);
	}

}