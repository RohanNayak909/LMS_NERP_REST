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

import nirmalya.aatithya.restmodule.account.dao.RestAccountDao;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account")
public class RestAccountController {
	Logger logger = LoggerFactory.getLogger(RestAccountController.class);
	@Autowired
	RestAccountDao restAccountDao;

	/*
	 * for Add Bank
	 */
	@RequestMapping(value = "addAccount", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAccount(@RequestBody RestAccountModel accountModel) {
		logger.info("Method : addAccount starts");

		logger.info("addAccount---------------------" + accountModel);

		logger.info("Method : addAccount ends");

		return restAccountDao.addAccount(accountModel);
	}

	// restViewAccountDetails

	/*
	 * for view
	 */
	@RequestMapping(value = "restViewAccountDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestAccountModel>>> restViewAccountDetails(@RequestParam String orgName, String orgDiv) {
		logger.info("Method: restViewAccountDetails View Start");
		
		logger.info("Method: restViewAccountDetails ends");
		return restAccountDao.restViewAccountDetails(orgName, orgDiv);
	}

	// editBankInfo

	@GetMapping(value = "editAccountInfo")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editAccountInfo(@RequestParam String id, String orgName, String orgDiv) {
		logger.info("Method :editAccountInfo starts");

		logger.info("Method :editAccountInfo ends");
		return restAccountDao.editAccountInfo(id, orgName, orgDiv);

	}

	// delete-account-Details

	@RequestMapping(value = "deleteAccountDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAccountDetails(@RequestParam String id, String orgName, String orgDiv) {
		logger.info("Method :  deleteAccountDetails starts");

		logger.info("Method :  deleteAccountDetails ends");
		return restAccountDao.deleteAccountDetails(id, orgName, orgDiv);
	}
	
	@GetMapping(value = "getBranchAutoSearch")
	public ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> getBranchAutoSearch(
			@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getBranchAutoSearch starts");

		logger.info("Method :getBranchAutoSearch endss");
		return restAccountDao.getBranchAutoSearch(id,orgName,orgDivision);
	}
	
	@RequestMapping(value = "getbranchlist",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getbranchlist(@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getStateLists1 starts");
		logger.info("Method : getStateLists1 ends");
		return restAccountDao.getbranchlist(id,orgName,orgDivision);
	}
	
	
	@GetMapping(value = "getAutoSearchBank")
	public ResponseEntity<JsonResponse<List<RestAccountBankModel>>> getBankNameDetails(@RequestParam String id) {
		logger.info("Method : Rest getBankNameDetails starts");

		logger.info("Method :Rest getBankNameDetails ends");
		return restAccountDao.getBankNameDetails(id);
	}

}
