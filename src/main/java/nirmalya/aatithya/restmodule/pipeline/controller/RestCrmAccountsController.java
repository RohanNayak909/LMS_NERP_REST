package nirmalya.aatithya.restmodule.pipeline.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmAccountDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmAccountsModel;

@RestController
@RequestMapping(value = "pipeline")
public class RestCrmAccountsController {

	Logger logger = LoggerFactory.getLogger(RestCrmAccountsController.class);
	@Autowired
	RestCrmAccountDao restCrmAccountDao;
	
	/**
	 * 
	 * @return department list
	 */
	@RequestMapping(value = "getAccountTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getAccountTypeList() {
		
		logger.info("Method : getAccountTypeList starts");
		logger.info("Method : getAccountTypeList ends");
		
		return restCrmAccountDao.getAccountTypeList();
	}
	
	@RequestMapping(value = "getAccountNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getAccountNameList(@RequestParam String userId,@RequestParam String org,@RequestParam String orgDiv) {
		
		logger.info("Method : getAccountNameList starts");
		logger.info("Method : getAccountNameList ends");
		
		return restCrmAccountDao.getAccountNameList(userId,org,orgDiv);
	}
	
	@RequestMapping(value = "getOwnershipList", method = { RequestMethod.GET })
	public List<DropDownModel> getOwnershipList() {
		
		logger.info("Method : getOwnershipList starts");
		logger.info("Method : getOwnershipList ends");
		
		return restCrmAccountDao.getOwnershipList();
	}
	
	
	//addAccount
	
	@PostMapping(value = "/addAccount")
	public JsonResponse<Object> addAccount(@RequestBody RestCrmAccountsModel account) {
		logger.info("Method : addAccount starts");

		logger.info("Method : addAccount ends");
		return restCrmAccountDao.addAccount(account);
	}
	

	//restViewAccountdetails
	
	//restViewAccountdetails
	

		@RequestMapping(value = "viewAccountSearchDetails", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> viewAccountSearchDetails(
				@RequestBody RestCrmAccountsModel searchAccountModel) {
			logger.info("Method : viewAccountSearchDetails starts");
	        logger.info("VIEWWW"+searchAccountModel);
			logger.info("Method : viewAccountSearchDetails ends");

			return restCrmAccountDao.viewAccountSearchDetails(searchAccountModel);
		}
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewAccountdetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>> restViewAccountdetails(@RequestParam String pageno,
			@RequestParam String userId,@RequestParam String orgName,@RequestParam String orgDivision){
		logger.info("Method: restViewAccountdetails View Start");
		
		logger.info("Method: restViewAccountdetails ends");
		return restCrmAccountDao.restViewAccountdetails(pageno,userId,orgName,orgDivision);
	}
	
	//delete-account-Details
	
		@RequestMapping(value = "delete-account-Details", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteDetails(@RequestParam String id, @RequestParam String org,@RequestParam String orgDiv) {
			logger.info("Method :  deleteAccountDetails starts"+id);

			logger.info("Method :  deleteAccountDetails ends");
			return restCrmAccountDao. deleteAccountDetails(id, org, orgDiv);
		}
		
	//editAccountInfo
		
		@GetMapping(value = "editAccountInfo")
		public ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>> editAccountInfo(@RequestParam String id, @RequestParam String org,@RequestParam String orgDiv) {
			logger.info("Method :editAccountInfo starts");

			logger.info("Method :editAccountInfo ends"+id);
			return restCrmAccountDao.editAccountInfo(id, org, orgDiv);

		}
		
		
		//viewAccountDetailsPage
		

		@GetMapping(value = "viewAccountDetailsPage")
		public ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>> viewAccountDetailsPage(@RequestParam String id, @RequestParam String org,@RequestParam String orgDiv) {
			logger.info("Method :viewAccountDetailsPage starts");

			logger.info("Method :viewAccountDetailsPage ends"+id);
			return restCrmAccountDao.viewAccountDetailsPage(id, org, orgDiv);

		}
}
