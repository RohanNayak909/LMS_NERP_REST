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
import nirmalya.aatithya.restmodule.account.dao.RestAccountDao;
import nirmalya.aatithya.restmodule.account.dao.RestCurrencyDao;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestCurrencyModel;
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
public class RestCurrencyController {
	Logger logger = LoggerFactory.getLogger(RestCurrencyController.class);
	@Autowired
	RestCurrencyDao restCurrencyDao;

	/*
	 * for Add Bank
	 */
	@RequestMapping(value="addCurrency" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addCurrency(@RequestBody RestCurrencyModel restCurrencyModel) 
	{
		logger.info("Method : addCurrency starts");
		
		System.out.println("addCurrency---------------------"+restCurrencyModel);
		
		logger.info("Method : addCurrency ends");
		
		return restCurrencyDao.addCurrency(restCurrencyModel);
	}
	

		
	//restViewAccountDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewCurrencyDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCurrencyModel>>> restViewCurrencyDetails(){
		logger.info("Method: restViewCurrencyDetails View Start");
		System.out.println("rest Currency controller");
		logger.info("Method: restViewCurrencyDetails ends");
		return restCurrencyDao.restViewCurrencyDetails();
	}
	
	
	//editCurrencyInfo

	
	@GetMapping(value = "editCurrencyInfo")
	public ResponseEntity<JsonResponse<List<RestCurrencyModel>>> editCurrencyInfo(@RequestParam String id) {
		logger.info("Method :editCurrencyInfo starts");

		logger.info("Method :editCurrencyInfo ends"+id);
		return restCurrencyDao.editCurrencyInfo(id);

	}
	
	
	//delete-currency-Details
	
	@RequestMapping(value = "deleteCurrencyDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCurrencyDetails(@RequestParam String id) {
		logger.info("Method :  deleteCurrencyDetails starts"+id);

		logger.info("Method :  deleteCurrencyDetails ends");
		return restCurrencyDao.deleteCurrencyDetails(id);
	}
	

	
}

