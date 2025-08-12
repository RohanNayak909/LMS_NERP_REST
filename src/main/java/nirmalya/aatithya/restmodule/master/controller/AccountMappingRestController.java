package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.AccountMappingDao;
import nirmalya.aatithya.restmodule.master.model.AccountMappingModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("master")
public class AccountMappingRestController {
	Logger logger = LoggerFactory.getLogger(AccountMappingRestController.class);
	
	@Autowired
	AccountMappingDao accountMappingDao;
	@SuppressWarnings("unchecked")

	@RequestMapping(value = "accountMappingSave", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> accountMappingSave(
			@RequestBody List<AccountMappingModel> accountMappingModel) {
		logger.info("Method : accountMappingSave ends");
		logger.info("Method : accountMappingSave ends");
		return accountMappingDao.accountMappingSave(accountMappingModel);
	}
	
	@RequestMapping(value = "getAllAccMappingList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountMappingModel>>> getAllAccMappingList() {
		logger.info("Method : getAllAccMappingList starts");
		
		logger.info("Method : getAllAccMappingList ends");
		return accountMappingDao.getAllAccMappingList();
	}
	
	@RequestMapping(value = "getAccMapListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountMappingModel>>> getAccMapListById(@RequestParam String id) {
		logger.info("Method : getAccMapListById starts");
		
		logger.info("Method : getAccMapListById ends");
		return accountMappingDao.getAccMapListById(id);
	}
}
