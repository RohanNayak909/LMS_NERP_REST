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
import nirmalya.aatithya.restmodule.account.dao.RestContraVoucherDao;
import nirmalya.aatithya.restmodule.account.dao.RestJournalVoucherDao;
import nirmalya.aatithya.restmodule.account.dao.RestManualJournalDao;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestManualJournalModel;
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
public class RestManualJournalVoucherController {
	Logger logger = LoggerFactory.getLogger(RestManualJournalVoucherController.class);
	@Autowired
	RestManualJournalDao restManualJournalDao;
	
	//getCustomerNameSearch
	
	/*
	 * getCustomerNameSearch auto search
	 */
	@GetMapping(value = "getCustomerNameSearch")
	public ResponseEntity<JsonResponse<List<RestManualJournalModel>>> getCustomerNameSearch(
			@RequestParam String id) {
		logger.info("Method : getCustomerNameSearch starts");

		logger.info("Method :getCustomerNameSearch endss");
		return restManualJournalDao.getCustomerNameSearch(id);
	}
	
	
	//addManualJournalVoucher  
	

@RequestMapping(value = "addManualJournalVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addManualJournalVoucher(@RequestBody List<RestManualJournalModel> restManualJournalModel) {
		logger.info("Method : addManualJournalVoucher starts");
		logger.info("Method : addManualJournalVoucher ends");
		return restManualJournalDao.addManualJournalVoucher(restManualJournalModel);
	}

//restViewManualDlts

@RequestMapping(value="restViewManualDlts" , method = {RequestMethod.GET})
public ResponseEntity<JsonResponse<List<RestManualJournalModel>>> restViewManualDlts(){
	logger.info("Method: restViewManualDlts View Start");
	
	logger.info("Method: restViewManualDlts ends");
	return restManualJournalDao.restViewManualDlts();
}


//deleteManualJournal

@RequestMapping(value = "deleteManualJournal", method = { RequestMethod.GET })
public ResponseEntity<JsonResponse<Object>> deleteManualJournal(@RequestParam String id) {
	logger.info("Method :  deleteManualJournal starts"+id);

	logger.info("Method :  deleteManualJournal ends");
	return restManualJournalDao.deleteManualJournal(id);
}

//editManualJournalInfo

@GetMapping(value = "editManualJournalInfo")
public ResponseEntity<JsonResponse<List<RestManualJournalModel>>> editManualJournalInfo(@RequestParam String id) {
	logger.info("Method :editManualJournalInfo starts");

	logger.info("Method :editManualJournalInfo ends"+id);
	return restManualJournalDao.editManualJournalInfo(id);

}

	
/*

@RequestMapping(value = "addJournalVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveJournalVoucher(@RequestBody List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : saveJournalVoucher starts");
		logger.info("Method : saveJournalVoucher ends");
		return restJournalVoucherDao.addJournalVoucher(journalVoucherModel);
	}

//restViewJournalVoucher

	@RequestMapping(value="restViewJournalVoucher" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> restViewJournalVoucher(){
		logger.info("Method: restViewJournalVoucher View Start");
		
		logger.info("Method: restViewJournalVoucher ends");
		return restJournalVoucherDao.restViewJournalVoucher();
	}
	
	//deleteJournalDetails
	
	@RequestMapping(value = "deleteJournalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(@RequestParam String id) {
		logger.info("Method :  deleteJournalDetails starts"+id);

		logger.info("Method :  deleteJournalDetails ends");
		return restJournalVoucherDao.deleteJournalDetails(id);
	}
	//approveJournalDetails
	@RequestMapping(value = "approveJournalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveJournalDetails(@RequestParam String id) {
		logger.info("Method :  approveJournalDetails starts"+id);

		logger.info("Method :  approveJournalDetails ends");
		return restJournalVoucherDao.approveJournalDetails(id);
	}
	//rejectJournalDetails
	
	@RequestMapping(value = "rejectJournalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> rejectJournalDetails(@RequestParam String id) {
		logger.info("Method :  rejectJournalDetails starts"+id);

		logger.info("Method :  rejectJournalDetails ends");
		return restJournalVoucherDao.rejectJournalDetails(id);
	}
	//returnJournalDetails
	@RequestMapping(value = "returnJournalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> returnJournalDetails(@RequestParam String id) {
		logger.info("Method :  returnJournalDetails starts"+id);

		logger.info("Method :  returnJournalDetails ends");
		return restJournalVoucherDao.returnJournalDetails(id);
	}
	

 
  //addContraVoucher
	
	
	@RequestMapping(value="addContraVoucher" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addAccount(@RequestBody RestContraVoucherModel restContraVoucherModel) 
	{
		logger.info("Method : addContraVoucher starts");
		
		System.out.println("restContraVoucherModel---------------------"+restContraVoucherModel);
		
		logger.info("Method : addAccount ends");
		
		return restContraVoucherDao.addContraVoucher(restContraVoucherModel);
	}
	
	@RequestMapping(value = "getVoucherTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getVoucherTypeList() {
		
		logger.info("Method : getVoucherTypeList starts");
		logger.info("Method : getVoucherTypeList");
		
		return restContraVoucherDao.getVoucherTypeList();
	}
	
	@RequestMapping(value = "getCostCenterList", method = { RequestMethod.GET })
	public List<DropDownModel> getCostCenterList() {
		
		logger.info("Method : getCostCenterList starts");
		logger.info("Method : getCostCenterList");
		
		return restContraVoucherDao.getCostCenterList();
	}
	

		
	//restViewContraVouDetails
	
	@RequestMapping(value="restViewContraVouDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> restViewContraVouDetails(){
		logger.info("Method: restViewContraVouDetails View Start");
		System.out.println("rest Account controller");
		logger.info("Method: restViewContraVouDetails ends");
		return restContraVoucherDao.restViewContraVouDetails();
	}
	
	
	//editContraInfo

	
	@GetMapping(value = "editContraInfo")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> editContraInfo(@RequestParam String id) {
		logger.info("Method :editContraInfo starts");

		logger.info("Method :editContraInfo ends"+id);
		return restContraVoucherDao.editContraInfo(id);

	}
	
	
	//delete-account-Details
	
	@RequestMapping(value = "deleteContraDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteContraDetails(@RequestParam String id) {
		logger.info("Method :  deleteContraDetails starts"+id);

		logger.info("Method :  deleteContraDetails ends");
		return restContraVoucherDao.deleteContraDetails(id);
	}
	
	//getDebitAccountSearch
	
	
	@GetMapping(value = "getDebitAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(
			@RequestParam String id) {
		logger.info("Method : getDebitAccountSearch starts");

		logger.info("Method :getDebitAccountSearch endss");
		return restContraVoucherDao.getDebitAccountSearch(id);
	}
	
	
	//getFromAccountB2BSearch
	
	
	@GetMapping(value = "getFromAccountB2BSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getFromAccountB2BSearch(
			@RequestParam String id) {
		logger.info("Method : getFromAccountB2BSearch starts");

		logger.info("Method :getFromAccountB2BSearch endss");
		return restContraVoucherDao.getFromAccountB2BSearch(id);
	}
*/
	
	
	
}

