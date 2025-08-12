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
import nirmalya.aatithya.restmodule.account.dao.RestAccountHeadDao;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountHeadModel;
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
public class RestAccountHeadController {
	Logger logger = LoggerFactory.getLogger(RestAccountHeadController.class);
	@Autowired
	RestAccountHeadDao restAccountHeadDao;

	/*
	 * for Add Bank
	 */
	@RequestMapping(value="addAccountHead" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addAccountHead(@RequestBody RestAccountHeadModel accountHeadModel) 
	{
		logger.info("Method : addAccountHead starts");
		
		System.out.println("addAccountHead---------------------"+accountHeadModel);
		
		logger.info("Method : addAccountHead ends");
		
		return restAccountHeadDao.addAccountHead(accountHeadModel);
	}
	

		
	//restViewAccountDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewAccountHeadDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAccountHeadModel>>> restViewAccountHeadDetails(){
		logger.info("Method: restViewAccountHeadDetails View Start");
		System.out.println("rest Account Head controller");
		logger.info("Method: restViewAccountHeadDetails ends");
		return restAccountHeadDao.restViewAccountHeadDetails();
	}
	
	
	//editBankInfo

	
	@GetMapping(value = "editAccountHeadInfo")
	public ResponseEntity<JsonResponse<List<RestAccountHeadModel>>> editAccountHeadInfo(@RequestParam String id) {
		logger.info("Method :editAccountHeadInfo starts");

		logger.info("Method :editAccountHeadInfo ends"+id);
		return restAccountHeadDao.editAccountHeadInfo(id);

	}
	
	
	//delete-account-Details
	
	@RequestMapping(value = "deleteAccountHeadDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAccountHeadDetails(@RequestParam String id) {
		logger.info("Method :  deleteAccountHeadDetails starts"+id);

		logger.info("Method :  deleteAccountHeadDetails ends");
		return restAccountHeadDao.deleteAccountHeadDetails(id);
	}
	

	
}

