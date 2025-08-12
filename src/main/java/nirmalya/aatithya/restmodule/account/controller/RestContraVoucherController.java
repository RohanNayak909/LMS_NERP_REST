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
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
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
public class RestContraVoucherController {
	Logger logger = LoggerFactory.getLogger(RestContraVoucherController.class);
	@Autowired
	RestContraVoucherDao restContraVoucherDao;

	@RequestMapping(value = "getVoucherTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getVoucherTypeList() {

		logger.info("Method : getVoucherTypeList starts");
		logger.info("Method : getVoucherTypeList ends");
		return restContraVoucherDao.getVoucherTypeList();
	}

	// getFiscalYearList

	@RequestMapping(value = "getFiscalYearList", method = { RequestMethod.GET })
	public List<DropDownModel> getFiscalYearList() {

		logger.info("Method : getFiscalYearList starts");
		logger.info("Method : getFiscalYearList ends");

		return restContraVoucherDao.getFiscalYearList();
	}

	@RequestMapping(value = "getCostCenterList", method = { RequestMethod.GET })
	public List<DropDownModel> getCostCenterList() {

		logger.info("Method : getCostCenterList starts");
		logger.info("Method : getCostCenterList");

		return restContraVoucherDao.getCostCenterList();
	}

	// addContraVoucher

	/*
	 * @RequestMapping(value = "addContraVoucher", method = { RequestMethod.POST })
	 * public ResponseEntity<JsonResponse<Object>> addContraVoucher(
	 * 
	 * @RequestBody List<AccountJournalVoucherModel> journalVoucherModel) {
	 * logger.info("Method : addContraVoucher starts");
	 * logger.info("Method : addContraVoucher ends"); return
	 * restContraVoucherDao.addContraVoucher(journalVoucherModel); }
	 */

	@RequestMapping(value = "addContraVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addContraVoucher(
			@RequestBody List<AccountJournalVoucherModel> addContraVoucher) {
		logger.info("Method : addContraVoucher starts");
		System.out.println("===>>>" + addContraVoucher);
		logger.info("Method : addContraVoucher ends");
		return restContraVoucherDao.addContraVoucher(addContraVoucher);
	}

	// JSON view for restViewContraVouDetails
	@RequestMapping(value = "restViewContraVouDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> restViewJournalVoucher(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :restViewJournalVoucher start");

		logger.info("Method :restViewJournalVoucher endss");
		return restContraVoucherDao.restViewContraVouDetails(orgName, orgDivision);

	}

	// editContraInfo

	@GetMapping(value = "editContraInfo")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editJournalInfo(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :editJournalInfo starts");

		logger.info("Method :editJournalInfo ends" + id);
		return restContraVoucherDao.editContraInfo(id, orgName, orgDivision);

	}

	// delete-account-Details

	@RequestMapping(value = "deleteContraDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteContraDetails(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :  deleteContraDetails starts" + id);

		logger.info("Method :  deleteContraDetails ends");
		return restContraVoucherDao.deleteContraDetails(id, orgName, orgDivision);
	}

	// getDebitAccountSearch

	/*
	 * getDebitAccountSearch auto search
	 */
	@GetMapping(value = "getDebitAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getDebitAccountSearch starts");

		logger.info("Method :getDebitAccountSearch endss");
		return restContraVoucherDao.getDebitAccountSearch(id, orgName, orgDivision);
	}

	/*
	 * getDebitAccountSearch auto search
	 */
	@GetMapping(value = "getCreditAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getCreditAccountSearch(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getCreditAccountSearch starts");

		logger.info("Method :getCreditAccountSearch endss");
		return restContraVoucherDao.getCreditAccountSearch(id, orgName, orgDivision);
	}

	// getFromAccountB2BSearch

	/*
	 * getFromAccountB2BSearch auto search
	 */
	@GetMapping(value = "getFromAccountB2BSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getFromAccountB2BSearch(@RequestParam String id) {
		logger.info("Method : getFromAccountB2BSearch starts");

		logger.info("Method :getFromAccountB2BSearch endss");
		return restContraVoucherDao.getFromAccountB2BSearch(id);
	}

	// getContraVoucherReport

	/**
	 * REST CONTROLLER - CONTRA VOUCHER REPORT
	 *
	 */
	@RequestMapping(value = "getContraVoucherReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getContraVoucherReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getContraVoucherReport for rest controller starts");

		logger.info("Method : getContraVoucherReport for rest controller ends");
		return restContraVoucherDao.getContraVoucherReport(request);

	}

	@RequestMapping(value = "getContravoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getContravoucherNumber(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method: getContravoucherNumber View Start");

		logger.info("Method: getContravoucherNumber ends");
		return restContraVoucherDao.getContravoucherNumber(orgName, orgDivision);
	}

	@RequestMapping(value = "addLedgerModal", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addLedgerModal(@RequestBody RestManageLeadgerModel LedgerDetails) {
		logger.info("Method : addLedgerModal starts");

		logger.info("Method : addrestLedger  ends");
		return restContraVoucherDao.addLedgerModal(LedgerDetails);
	}

	@RequestMapping(value = "restViewContraFilter", method = { RequestMethod.GET })
	public JsonResponse<Object> restViewContraFilter(@RequestParam String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method :restViewContraFilter start");

		logger.info("Method :restViewContraFilter endss");
		return restContraVoucherDao.restViewContraFilter(orgName, orgDivision, fromDate, toDate);

	}

	@RequestMapping(value = "getLedgerList", method = { RequestMethod.GET })
	public List<DropDownModel> getLedgerList() {

		logger.info("Method : getLedgerList starts");
		logger.info("Method : getLedgerList");

		return restContraVoucherDao.getLedgerList();
	}
	
	@RequestMapping(value = "getBankNameList",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBankNameList() {
		logger.info("Method : getBankNameList starts");
		logger.info("Method : getBankNameList ends");
		return restContraVoucherDao.getBankNameList();
	}

}
