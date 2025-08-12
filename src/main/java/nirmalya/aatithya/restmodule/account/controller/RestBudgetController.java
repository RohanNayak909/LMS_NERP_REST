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
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestBudgetModel;
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
public class RestBudgetController {
	Logger logger = LoggerFactory.getLogger(RestBudgetController.class);
	@Autowired
	RestBudgetDao restBudgetDao;

	/*
	 * for Add Bank
	 */
	@RequestMapping(value="addBudget" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addBudget(@RequestBody RestBudgetModel restBudgetModel) 
	{
		logger.info("Method : addBudget starts");
		
		System.out.println("addBudget---------------------"+restBudgetModel);
		
		logger.info("Method : addBudget ends");
		
		return restBudgetDao.addBudget(restBudgetModel);
	}
	

		
	//restViewAccountDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewBudgetDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestBudgetModel>>> restViewBudgetDetails(){
		logger.info("Method: restViewBudgetDetails View Start");
		System.out.println("rest Budget controller");
		logger.info("Method: restViewBudgetDetails ends");
		return restBudgetDao.restViewBudgetDetails();
	}
	
	
	//editBudgetInfo

	
	@GetMapping(value = "editBudgetInfo")
	public ResponseEntity<JsonResponse<List<RestBudgetModel>>> editBudgetInfo(@RequestParam String id) {
		logger.info("Method :editBudgetInfo starts");

		logger.info("Method :editBudgetInfo ends"+id);
		return restBudgetDao.editBudgetInfo(id);

	}
	
	
	//delete-budget-Details
	
	@RequestMapping(value = "deleteBudgetDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBudgetDetails(@RequestParam String id) {
		logger.info("Method :  deleteBudgetDetails starts"+id);

		logger.info("Method :  deleteBudgetDetails ends");
		return restBudgetDao.deleteBudgetDetails(id);
	}
	

	
}

