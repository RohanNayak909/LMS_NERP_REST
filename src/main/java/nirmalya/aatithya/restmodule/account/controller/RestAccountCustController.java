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

import nirmalya.aatithya.restmodule.account.dao.RestAccountBankDao;
import nirmalya.aatithya.restmodule.account.dao.RestAccountBranchDao;
import nirmalya.aatithya.restmodule.account.dao.RestAccountCustDao;
import nirmalya.aatithya.restmodule.account.dao.RestAccountDao;
import nirmalya.aatithya.restmodule.account.model.AccountCusRestModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmContactDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCustomerDao;
import nirmalya.aatithya.restmodule.pipeline.dao.PipelineDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCallDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCampaignDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmVendorDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineLogModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineSmsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestStagesDetailModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account")
public class RestAccountCustController {
	Logger logger = LoggerFactory.getLogger(RestAccountCustController.class);
	@Autowired
	RestAccountCustDao restAccountCustDao;

	/*
	 * for Add Bank
	 */
	@RequestMapping(value="addAccountCustomer" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addAccountCustomer(@RequestBody AccountCusRestModel accountCusRestModel) 
	{
		logger.info("Method : addAccountCustomer starts");
		
		System.out.println("addAccount---------------------"+accountCusRestModel);
		
		logger.info("Method : addAccountCustomer ends");
		
		return restAccountCustDao.addAccountCustomer(accountCusRestModel);
	}
	

		
	//restViewCustDtls
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewCustDtls" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountCusRestModel>>> restViewCustDtls(){
		logger.info("Method: restViewCustDtls View Start");
		System.out.println("rest Account cust controller");
		logger.info("Method: restViewCustDtls ends");
		return restAccountCustDao.restViewCustDtls();
	}
	
	
	//editAccCusInfo

	
	@GetMapping(value = "editAccCusInfo")
	public ResponseEntity<JsonResponse<List<AccountCusRestModel>>> editAccCusInfo(@RequestParam String id) {
		logger.info("Method :editAccCusInfo starts");

		logger.info("Method :editAccCusInfo ends"+id);
		return restAccountCustDao.editAccCusInfo(id);

	}
	
	//getStateLists1
	
	@RequestMapping(value = "getStateLists1",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateLists1(@RequestParam String id) {
		logger.info("Method : getStateLists1 starts");
		logger.info("Method : getStateLists1 ends");
		return restAccountCustDao.getStateLists1(id);
	}
	
	//getDistrictLists
	
		@RequestMapping(value = "getDistrictLists",method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictLists(@RequestParam String id) {
			logger.info("Method : getDistrictLists starts");
			logger.info("Method : getDistrictLists ends");
			return restAccountCustDao.getDistrictLists(id);
		}
	
	
	//delete-customer-Details
	
	@RequestMapping(value = "deleteCusAccDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCusAccDetails(@RequestParam String id) {
		logger.info("Method :  deleteCusAccDetails starts"+id);

		logger.info("Method :  deleteCusAccDetails ends");
		return restAccountCustDao.deleteCusAccDetails(id);
	}
	

	
}

