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
import nirmalya.aatithya.restmodule.account.dao.RestBudgetDao;
import nirmalya.aatithya.restmodule.account.dao.RestTransactionLockingDao;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestBudgetModel;
import nirmalya.aatithya.restmodule.account.model.RestTransactionLockingModel;
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
public class RestTransactionLockingController {
	Logger logger = LoggerFactory.getLogger(RestTransactionLockingController.class);
	@Autowired
	RestTransactionLockingDao restTransactionLockingDao;

	/*
	 * for Add Bank
	 */
	/*@RequestMapping(value="addBudget" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addBudget(@RequestBody RestBudgetModel restBudgetModel) 
	{
		logger.info("Method : addBudget starts");
		
		System.out.println("addBudget---------------------"+restBudgetModel);
		
		logger.info("Method : addBudget ends");
		
		return restBudgetDao.addBudget(restBudgetModel);
	}*/
	
	//addTransactionSaleLock
	
	@RequestMapping(value="addTransactionSaleLock" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addTransactionSaleLock(@RequestBody RestTransactionLockingModel restTransactionLockingModel) 
	{
		logger.info("Method : addTransactionSaleLock starts");
		
		System.out.println("addTransactionSaleLock---------------------"+restTransactionLockingModel);
		
		logger.info("Method : addTransactionSaleLock ends");
		
		return restTransactionLockingDao.addTransactionSaleLock(restTransactionLockingModel);
	}
	
	
	//addTransactionSaleUnlock
	
	@RequestMapping(value="addTransactionSaleUnlock" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addTransactionSaleUnlock(@RequestBody RestTransactionLockingModel restTransactionLockingModel) 
	{
		logger.info("Method : addTransactionSaleUnlock starts");
		
		System.out.println("addTransactionSaleunLock---------------------"+restTransactionLockingModel);
		
		logger.info("Method : addTransactionSaleUnlock ends");
		
		return restTransactionLockingDao.addTransactionSaleUnlock(restTransactionLockingModel);
	}
	
	
	//addTransactionPurchaseLock
	
		@RequestMapping(value="addTransactionPurchaseLock" , method={RequestMethod.POST})
		public ResponseEntity<JsonResponse<Object>> addTransactionPurchaseLock(@RequestBody RestTransactionLockingModel restTransactionLockingModel) 
		{
			logger.info("Method : addTransactionPurchaseLock starts");
			
			System.out.println("addTransactionPurchaseLock---------------------"+restTransactionLockingModel);
			
			logger.info("Method : addTransactionPurchaseLock ends");
			
			return restTransactionLockingDao.addTransactionPurchaseLock(restTransactionLockingModel);
		}
		
		
		//addTransactionPurchaseUnlock
		
		@RequestMapping(value="addTransactionPurchaseUnlock" , method={RequestMethod.POST})
		public ResponseEntity<JsonResponse<Object>> addTransactionPurchaseUnlock(@RequestBody RestTransactionLockingModel restTransactionLockingModel) 
		{
			logger.info("Method : addTransactionPurchaseUnlock starts");
			
			System.out.println("addTransactionPurchaseUnlock---------------------"+restTransactionLockingModel);
			
			logger.info("Method : addTransactionPurchaseUnlock ends");
			
			return restTransactionLockingDao.addTransactionPurchaseUnlock(restTransactionLockingModel);
		}

		//addTransactionBankingLock
		
		@RequestMapping(value="addTransactionBankingLock" , method={RequestMethod.POST})
		public ResponseEntity<JsonResponse<Object>> addTransactionBankingLock(@RequestBody RestTransactionLockingModel restTransactionLockingModel) 
		{
			logger.info("Method : addTransactionBankingLock starts");
			
			System.out.println("addTransactionBankingLock---------------------"+restTransactionLockingModel);
			
			logger.info("Method : addTransactionBankingLock ends");
			
			return restTransactionLockingDao.addTransactionBankingLock(restTransactionLockingModel);
		}
		
		
		//addTransactionBankingUnlock
		
		@RequestMapping(value="addTransactionBankingUnlock" , method={RequestMethod.POST})
		public ResponseEntity<JsonResponse<Object>> addTransactionBankingUnlock(@RequestBody RestTransactionLockingModel restTransactionLockingModel) 
		{
			logger.info("Method : addTransactionBankingUnlock starts");
			
			System.out.println("addTransactionBankingUnlock---------------------"+restTransactionLockingModel);
			
			logger.info("Method : addTransactionBankingUnlock ends");
			
			return restTransactionLockingDao.addTransactionBankingUnlock(restTransactionLockingModel);
		}
		
		//addTransactionAccountLock
		//addTransactionAccountUnlock
		
		@RequestMapping(value="addTransactionAccountLock" , method={RequestMethod.POST})
		public ResponseEntity<JsonResponse<Object>> addTransactionAccountLock(@RequestBody RestTransactionLockingModel restTransactionLockingModel) 
		{
			logger.info("Method : addTransactionAccountLock starts");
			
			System.out.println("addTransactionAccountLock---------------------"+restTransactionLockingModel);
			
			logger.info("Method : addTransactionAccountLock ends");
			
			return restTransactionLockingDao.addTransactionAccountLock(restTransactionLockingModel);
		}
		
		
		//addTransactionAccountUnlock
		
		@RequestMapping(value="addTransactionAccountUnlock" , method={RequestMethod.POST})
		public ResponseEntity<JsonResponse<Object>> addTransactionAccountUnlock(@RequestBody RestTransactionLockingModel restTransactionLockingModel) 
		{
			logger.info("Method : addTransactionAccountUnlock starts");
			
			System.out.println("addTransactionAccountUnlock---------------------"+restTransactionLockingModel);
			
			logger.info("Method : addTransactionAccountUnlock ends");
			
			return restTransactionLockingDao.addTransactionAccountUnlock(restTransactionLockingModel);
		}
		
	//restViewAccountDetails
	
	/*
	 * for view
	 */
/*	@RequestMapping(value="restViewBudgetDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestBudgetModel>>> restViewBudgetDetails(){
		logger.info("Method: restViewBudgetDetails View Start");
		System.out.println("rest Budget controller");
		logger.info("Method: restViewBudgetDetails ends");
		return restBudgetDao.restViewBudgetDetails();
	}
*/	
	
	//editBudgetInfo

	
	@GetMapping(value = "getTransactionData")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> getTransactionData(@RequestParam String id) {
		logger.info("Method :getTransactionData starts");

		logger.info("Method :getTransactionData ends"+id);
		return restTransactionLockingDao.getTransactionData(id);

	}
	
	//getTransactionSalesData
	
	@GetMapping(value = "getTransactionSalesData")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> getTransactionSalesData(@RequestParam String id) {
		logger.info("Method :getTransactionSalesData starts");

		logger.info("Method :getTransactionSalesData ends"+id);
		return restTransactionLockingDao.getTransactionSalesData(id);

	}
	
	
	//getTransactionPurchaseData
	
	@GetMapping(value = "getTransactionPurchaseData")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> getTransactionPurchaseData(@RequestParam String id) {
		logger.info("Method :getTransactionPurchaseData starts");

		logger.info("Method :getTransactionPurchaseData ends"+id);
		return restTransactionLockingDao.getTransactionPurchaseData(id);

	}
	
	//getTransactionBankingData
	
	@GetMapping(value = "getTransactionBankingData")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> getTransactionBankingData(@RequestParam String id) {
		logger.info("Method :getTransactionBankingData starts");

		logger.info("Method :getTransactionBankingData ends"+id);
		return restTransactionLockingDao.getTransactionBankingData(id);

	}
	
	//getTransactionAccountData
	
	@GetMapping(value = "getTransactionAccountData")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> getTransactionAccountData(@RequestParam String id) {
		logger.info("Method :getTransactionAccountData starts");

		logger.info("Method :getTransactionAccountData ends"+id);
		return restTransactionLockingDao.getTransactionAccountData(id);

	}
	
	
	//delete-budget-Details
	
	/*@RequestMapping(value = "deleteBudgetDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBudgetDetails(@RequestParam String id) {
		logger.info("Method :  deleteBudgetDetails starts"+id);

		logger.info("Method :  deleteBudgetDetails ends");
		return restBudgetDao.deleteBudgetDetails(id);
	}*/
	

	
}

