package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountBankBookReportDao;
import nirmalya.aatithya.restmodule.account.model.AccountLedgerReportRestModel;
import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestBankBookReportController {
	
	
	Logger logger = LoggerFactory.getLogger(RestBankBookReportController.class);
	@Autowired
	RestAccountBankBookReportDao restBankBookReportDao;
	
	
	///view
		@RequestMapping(value = "restbankBookReportDetails", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> restViewLeadgerDetails(@RequestParam String orgName,
				@RequestParam String orgDivision) {
			logger.info("Method: restbankBookReportDetails View Start");

			logger.info("Method: restbankBookReportDetails ends");
			return restBankBookReportDao.viewLeadger(orgName,orgDivision);
		}
		
		
		@RequestMapping(value = "RestBankReportFilterData", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> bankFilterData(
				@RequestParam String id, String voucherType, String fromDate, String toDate,@RequestParam String orgName, @RequestParam String orgDivision) {
			logger.info("Method: bankFilterData Start");

			logger.info("Method: bankFilterData ends");
			return restBankBookReportDao.bankFilterData(id, voucherType, fromDate, toDate,orgName,orgDivision);
		}
		
		@RequestMapping(value = "Restbank-report-pdf" , method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> ledgerStatementPdf(
				@RequestParam String id,String voucherType , String fromDate, String toDate, @RequestParam String orgName,@RequestParam String orgDivision) {
			logger.info("Method :ledgerStatementPdf starts" + fromDate);

			logger.info("Method :ledgerStatementPdf ends" + toDate);
			return restBankBookReportDao.ledgerStatementPdf(id,voucherType, fromDate, toDate,orgName,orgDivision);
		}

}
