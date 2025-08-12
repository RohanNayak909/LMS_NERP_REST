package nirmalya.aatithya.restmodule.api.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import nirmalya.aatithya.restmodule.api.dao.RegistrationCrmRestDao;
import nirmalya.aatithya.restmodule.api.model.CustomerProfileApiModel;
import nirmalya.aatithya.restmodule.api.model.RegistrationRestCrmModel;
import nirmalya.aatithya.restmodule.api.model.RestDirecterManagerCrmModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.pipeline.model.CrmVisitHistoryReportRestModel;
import nirmalya.aatithya.restmodule.util.DocumentUpload;

@RestController
@RequestMapping(value = "api")
public class RegistrationCrmController {

	@Autowired
	RegistrationCrmRestDao registrationCrmRestDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	DocumentUpload documentUpload;

	Logger logger = LoggerFactory.getLogger(RegistrationCrmController.class);

	@RequestMapping(value = "/getCustomerLists", method = { RequestMethod.GET })
	public List<DropDownModel> getCustomerLists(@RequestParam String organization,String orgDivision,String userId) {
		logger.info("Method : getCustomerLists starts");

		logger.info("Method : getCustomerLists end");
		return registrationCrmRestDao.getCustomerLists(organization,orgDivision,userId);
	}
	
	@RequestMapping(value = "/getSalesTeamLists", method = { RequestMethod.GET })
	public List<DropDownModel> getSalesTeamLists(@RequestParam String organization,String orgDivision,String userId) {
		logger.info("Method : getSalesTeamLists starts");

		logger.info("Method : getSalesTeamLists end");
		return registrationCrmRestDao.getSalesTeamLists(organization,orgDivision,userId);
	}
	/*
	 * add
	 */
	@PostMapping(value = "addClientDetails")
	public ResponseEntity<JsonResponse<List<RegistrationRestCrmModel>>> addClientDetails(
			@RequestBody List<RegistrationRestCrmModel> registrationRestCrmModel) {
		logger.info("Method :addClientDetails starts");
		logger.info("Method :addClientDetails endss");
		return registrationCrmRestDao.addClientDetails(registrationRestCrmModel);
	}
	/*
	 * modify Decision Maker
	 */
	@PostMapping(value = "modifyDecisionMaker")
	public ResponseEntity<JsonResponse<RestDirecterManagerCrmModel>> modifyDecisionMaker(
			@RequestBody  RestDirecterManagerCrmModel  restDirecterManagerCrmModel) {
		logger.info("Method :modifyDecisionMaker starts");
		logger.info("Method :modifyDecisionMaker endss");
		return registrationCrmRestDao.modifyDecisionMaker(restDirecterManagerCrmModel);
	}

	@GetMapping(value = "getClientDetails")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetails(String createdby,String organization, String orgDivision) {
		logger.info("Method : getClientDetails starts");

		logger.info("Method : getClientDetails ends");

		return registrationCrmRestDao.getClientDetails(createdby,organization,orgDivision);
	}
//getClientDetailsEdit
	@GetMapping(value = "getClientDetailsEdit")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsEdit(String id,String organization, String orgDivision) {
		logger.info("Method : getClientDetailsEdit starts");

		logger.info("Method : getClientDetailsEdit ends");
		return registrationCrmRestDao.getClientDetailsEdit(id,organization,orgDivision);
	}

	// Post mapping

	@GetMapping(value = "getVisistorDetails")
	public JsonResponse<List<RegistrationRestCrmModel>> getVisistorDetails(@RequestParam String createdBy) {
		logger.info("Method : getVisistorDetails");

		logger.info("Method : getVisistorDetails ends");
		return registrationCrmRestDao.getVisistorDetails(createdBy);
	}
	/*
	 * search customer
	 */
	@GetMapping(value = "getClientDetailsSearch")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsSearch(String createdBy,String organization, String orgDivision,String customer) {
		logger.info("Method : getClientDetailsSearch starts");

		logger.info("Method : getClientDetailsSearch ends");

		return registrationCrmRestDao.getClientDetailsSearch(createdBy,organization,orgDivision,customer);
	}
	/*
	 * search customer by executive
	 */
	@GetMapping(value = "getClientDetailsSearchByExecutive")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsSearchByExecutive(String createdBy,String organization, String orgDivision,String executive) {
		logger.info("Method : getClientDetailsSearchByExecutive starts");
		
		logger.info("Method : getClientDetailsSearchByExecutive ends");
		
		return registrationCrmRestDao.getClientDetailsSearchByExecutive(createdBy,organization,orgDivision,executive);
	}
	// view web customer Report
	@GetMapping(value = "getClientDetailsReport")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsReport(String createdby,String organization, String orgDivision) {
		logger.info("Method : getClientDetailsReport starts");

		logger.info("Method : getClientDetailsReport ends");

		return registrationCrmRestDao.getClientDetailsReport(createdby,organization,orgDivision);
	}
	// view web customer search
	@GetMapping(value = "viewCustomerReportSearch")
	public JsonResponse<List<RegistrationRestCrmModel>> viewCustomerReportSearch(@RequestParam String createdBy,String organization, String orgDivision,String fromDate,String toDate,String customer, String saleTeam) {
		logger.info("Method : viewCustomerReportSearch");
		
		logger.info("Method : viewCustomerReportSearch ends");
		return registrationCrmRestDao.viewCustomerReportSearch(createdBy,organization,orgDivision,fromDate,toDate,customer,saleTeam);
	}	
	// view web viewDecisionMakerDeatils
	@GetMapping(value = "viewDecisionMakerDeatils")
	public JsonResponse<List<RestDirecterManagerCrmModel>> viewDecisionMakerDeatils(@RequestParam String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewDecisionMakerDeatils");
		
		logger.info("Method : viewDecisionMakerDeatils ends");
		return registrationCrmRestDao.viewDecisionMakerDeatils(createdBy,organization,orgDivision);
	}
	// view web viewExecutiveDeatils
	@GetMapping(value = "viewExecutiveDeatils")
	public JsonResponse<List<ManageEmployeeRestModel>> viewExecutiveDeatils(@RequestParam String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewExecutiveDeatils");
		
		logger.info("Method : viewExecutiveDeatils ends");
		return registrationCrmRestDao.viewExecutiveDeatils(createdBy,organization,orgDivision);
	}
	//decision maker Report Search
	
	@GetMapping(value = "viewDecisionMakerDeatilsSearch")
	public JsonResponse<List<RestDirecterManagerCrmModel>> viewDecisionMakerDeatilsSearch(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam){
		logger.info("Method : viewDecisionMakerDeatilsSearch");
		
		logger.info("Method : viewDecisionMakerDeatilsSearch ends");
		return registrationCrmRestDao.viewDecisionMakerDeatilsSearch(userId,organization,orgDivision,fromDate,toDate,customer,saleTeam);
	}
	// upload customer profle Img
	@PostMapping(value = "upload-customer-profileImg-api", headers = "content-type=multipart/*", consumes = {"application/*" })
		public ResponseEntity<JsonResponse<CustomerProfileApiModel>> customerProfileDataUpload(CustomerProfileApiModel customerProfileApiModel) {
		logger.info("Method : customerProfileDataUpload starts");
		
		MultipartFile x = customerProfileApiModel.getMulFile();
		String fileName = null;
		if (x != null) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
			fileName = documentUpload.saveAllTypeDocument(bytes,customerProfileApiModel.getExtension(),
					customerProfileApiModel.getCustomerId(),"CRM_PROFILE");
		}
		customerProfileApiModel.setDocName(fileName);
		
		logger.info("Method : profileDataUpload ends");
		return registrationCrmRestDao.customerProfileDataUpload(customerProfileApiModel);
	}
	//visit history report web
	@GetMapping(value = "viewCrm-visitHistoryReport")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmVisitHistoryReport(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate){
		logger.info("Method : viewCrmVisitHistoryReport");
		
		logger.info("Method : viewCrmVisitHistoryReport ends");
		return registrationCrmRestDao.viewCrmVisitHistoryReport(userId,organization,orgDivision,fromDate,toDate);
	}
	//visit plan report web
	@GetMapping(value = "viewCrm-visitPlanReport")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmVisitPlanReport(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate){
		logger.info("Method : viewCrmVisitPlanReport");
		
		logger.info("Method : viewCrmVisitPlanReport ends");
		return registrationCrmRestDao.viewCrmVisitPlanReport(userId,organization,orgDivision,fromDate,toDate);
	}
	//visit in history report search web
	@GetMapping(value = "viewCrm-visitHistoryReportSearch")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmvisitHistoryReportSearch(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam){
		logger.info("Method : viewCrmvisitHistoryReportSearch");
		
		logger.info("Method : viewCrmvisitHistoryReportSearch ends");
		return registrationCrmRestDao.viewCrmvisitHistoryReportSearch(userId,organization,orgDivision,fromDate,toDate,customer,saleTeam);
	}
	//visit in history report search ByType web
	@GetMapping(value = "viewCrm-visitHistoryReportSearchByType")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmvisitHistoryReportSearchByType(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam,String type){
		logger.info("Method : viewCrmvisitHistoryReportSearchByType");
		
		logger.info("Method : viewCrmvisitHistoryReportSearchByType ends");
		return registrationCrmRestDao.viewCrmvisitHistoryReportSearchByType(userId,organization,orgDivision,fromDate,toDate,customer,saleTeam,type);
	}
	//visit in plan report search web
	@GetMapping(value = "viewCrm-visitPlanReportSearch")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmvisitPlanReportSearch(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam){
		logger.info("Method : viewCrmvisitPlanReportSearch");
		
		logger.info("Method : viewCrmvisitPlanReportSearch ends");
		return registrationCrmRestDao.viewCrmvisitPlanReportSearch(userId,organization,orgDivision,fromDate,toDate,customer,saleTeam);
	}
	//visit in plan report search ByType web
	@GetMapping(value = "viewCrm-visitPlanReportSearchByType")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmvisitPlanReportSearchByType(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam,String type){
		logger.info("Method : viewCrmvisitPlanReportSearchByType");
		
		logger.info("Method : viewCrmvisitPlanReportSearchByType ends");
		return registrationCrmRestDao.viewCrmvisitPlanReportSearchByType(userId,organization,orgDivision,fromDate,toDate,customer,saleTeam,type);
	}
	// switchCustomerApply
	@RequestMapping(value = "rest-switchCustomerApply", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> switchCustomerApply(@RequestParam String customer,String executive,String org, String orgDiv) {
		logger.info("Method : switchCustomerApply starts");
		
		logger.info("Method : switchCustomerApply ends");
		return registrationCrmRestDao.switchCustomerApply(customer,executive,org,orgDiv);
	}
	
	
	@PostMapping(value = "customerSwitchEdit")
	public ResponseEntity<JsonResponse<List<RegistrationRestCrmModel>>> customerSwitchEdit(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : customerSwitchEdit starts");

		String id = empModel.getUserId();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
	//	List<String> roleList = empModel.getUserRole();
	
		
		logger.info("User Id = "+id);
		logger.info("Method : customerSwitchEdit ends");
		return registrationCrmRestDao.customerSwitchEdit(id,organization,orgDivision);
	}
	/*
	 * add Customer
	 */
	@PostMapping(value = "addCustomerDetails")
	public ResponseEntity<JsonResponse<RegistrationRestCrmModel>> addCustomerDetails(
			@RequestBody  RegistrationRestCrmModel  registrationRestCrmModel) {
		logger.info("Method :addCustomerDetails starts");
		logger.info("Method :addCustomerDetails endss");
		return registrationCrmRestDao.addCustomerDetails(registrationRestCrmModel);
	}
	/*
	 *delete Customer
	 */
	@RequestMapping(value = "deleteCustomer", method = { RequestMethod.GET })
	public JsonResponse<RegistrationRestCrmModel> deleteCustomer(@RequestParam String deleteId,String org, String orgDiv) {
		logger.info("Method : deleteCustomer starts");

		logger.info("Method : deleteCustomer ends");
		return registrationCrmRestDao.deleteCustomer(deleteId,org,orgDiv);
	}
	/*******************    Decision Maker   ****************************/
	/*
 *
 * Edit rest
 *
 */
	@RequestMapping(value = "rest-editDecisionMaker", method = { RequestMethod.GET })
	public JsonResponse<RestDirecterManagerCrmModel> editDecisionMaker(@RequestParam String id,String org, String orgDiv) {
		logger.info("Method : editDecisionMaker rest starts");
	
		logger.info("Method :editDecisionMaker rest ends");
		return registrationCrmRestDao.editDecisionMaker(id,org,orgDiv);
	}	
	/*
	 * add Decision Maker
	 */
	@PostMapping(value = "addDecisionMaker")
	public ResponseEntity<JsonResponse<RestDirecterManagerCrmModel>> addDecisionMaker(
			@RequestBody  RestDirecterManagerCrmModel  restDirecterManagerCrmModel) {
		logger.info("Method :addDecisionMaker starts");
		logger.info("Method :addDecisionMaker endss");
		return registrationCrmRestDao.addDecisionMaker(restDirecterManagerCrmModel);
	}

	@GetMapping(value = "getClientDetailsByPagination")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsPagination(String createdby,String organization, String orgDivision,String pageNo) {
		logger.info("Method : getClientDetailsPagination starts");

		logger.info("Method : getClientDetailsPagination ends");

		return registrationCrmRestDao.getClientDetailsPagination(createdby,organization,orgDivision,pageNo);
	}
	//getClientDetailsEditWeb
	@GetMapping(value = "getClientDetailsEdit-web")
	public JsonResponse<RegistrationRestCrmModel> getClientDetailsEditWeb(String id,String organization, String orgDivision) {
		logger.info("Method : getClientDetailsEditWeb starts");

		logger.info("Method : getClientDetailsEditWeb ends");
		return registrationCrmRestDao.getClientDetailsEditWeb(id,organization,orgDivision);
	}
}
