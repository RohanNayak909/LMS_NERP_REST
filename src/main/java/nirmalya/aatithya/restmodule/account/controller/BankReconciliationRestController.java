package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.BankReconciliationDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class BankReconciliationRestController {
	Logger logger = LoggerFactory.getLogger(BankReconciliationRestController.class);
	@Autowired
	BankReconciliationDao bankReconciliationDao;
	
	@RequestMapping(value = "get-bank_ledger-list", method = { RequestMethod.GET })
	public List<DropDownModel> bankLedgerList(@RequestParam String orgName,String orgDivision) {
		logger.info("Method : bankLedgerList starts");

		logger.info("Method : bankLedgerList ends");
		return bankReconciliationDao.bankLedgerList(orgName,orgDivision);
	}
	
	@RequestMapping(value = "bank-reconciliation-view", method = { RequestMethod.GET })
	public JsonResponse<Object> bankReconciliationView(@RequestParam String orgName, String orgDivision,
			String fromDate,String toDate,String bank,String type) {
		logger.info("Method :bankReconciliationView start");

		logger.info("Method :bankReconciliationView endss");
		return bankReconciliationDao.bankReconciliationView(orgName, orgDivision,fromDate,toDate,bank,type);

	}
	@RequestMapping(value = "rest-clearanceSave", method = { RequestMethod.GET })
	public JsonResponse<Object> clearanceSave(@RequestParam String orgName, String orgDivision,
			String vid,String chqClrDate,String remarks,String userId) {
		logger.info("Method :clearanceSave start");
		
		logger.info("Method :clearanceSave endss");
		return bankReconciliationDao.clearanceSave(orgName, orgDivision,vid,chqClrDate,remarks,userId);
		
	}
}
