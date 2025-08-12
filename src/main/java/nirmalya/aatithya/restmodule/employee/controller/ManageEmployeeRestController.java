package nirmalya.aatithya.restmodule.employee.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.ManageEmployeeDao;
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.employee.model.EmployeeProfileFileUploadModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeAddressRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeBankDetailsRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeBenifitrestModel;
/*import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeBenifitModel;*/
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDependentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDocumentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeInsuranceDetailsrestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeWorkdetailsRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.util.PushNotification;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping("employee/")
public class ManageEmployeeRestController {

	Logger logger = LoggerFactory.getLogger(ManageEmployeeRestController.class);

	@Autowired
	ManageEmployeeDao manageemployeeDao;
	
	@Autowired
	EnvironmentVaribles env;
 
	@RequestMapping(value = "getCountryList", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");

		logger.info("Method : getCountryList ends");
		return manageemployeeDao.getCountryList();

	}

	@RequestMapping(value = "getBandList", method = { RequestMethod.GET })
	public List<DropDownModel> getBandList() {
		logger.info("Method : getBandList starts");

		logger.info("Method : getBandList ends");
		return manageemployeeDao.getBandList();

	}

	@RequestMapping(value = "getgenderList1", method = { RequestMethod.GET })
	public List<DropDownModel> getgenderList1() {
		logger.info("Method : getgenderList1 starts");

		logger.info("Method : getgenderList1 ends");
		return manageemployeeDao.getgenderList1();
	}
	
	//getOrganization
	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
		logger.info("Method : getOrganizationDivision starts");

		logger.info("Method : getOrganizationDivision ends");
		return manageemployeeDao.getOrganization(orgName);
	}

	
	// organisationDivision
	@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
	public List<DropDownModel> getDivision(@RequestParam String orgName) {
		logger.info("Method : getDivision starts");

		logger.info("Method : getDivision ends");
		return manageemployeeDao.getDivision(orgName);
	}
	
	
	
	
	@RequestMapping(value = "getDepartmentListDash", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentListDash(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method : getDepartmentListDash starts");

		logger.info("Method : getDepartmentListDash ends");
		return manageemployeeDao.getDepartmentListDash(orgName, orgDivision);
	}
	
	@RequestMapping(value = "getJobRoleList", method = { RequestMethod.GET })
	public List<DropDownModel> getJobRoleList(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method : getJobRoleList starts");

		logger.info("Method : getJobRoleList ends");
		return manageemployeeDao.getJobRoleList(orgName, orgDivision);
	}
	
	@RequestMapping(value = "getRecuiterList", method = { RequestMethod.GET })
	public List<DropDownModel> getRecuiterList(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method : getRecuiterList starts");

		logger.info("Method : getRecuiterList ends");
		return manageemployeeDao.getRecuiterList(orgName, orgDivision);
	}
	
	
	@RequestMapping(value = "getnationalityList1", method = { RequestMethod.GET })
	public List<DropDownModel> getnationalityList1() {
		logger.info("Method : getnationalityList1 starts");

		logger.info("Method : getnationalityList1 ends");
		return manageemployeeDao.getnationalityList1();
	}

	@RequestMapping(value = "getbloodgroupList1", method = { RequestMethod.GET })
	public List<DropDownModel> getbloodgroupList1() {
		logger.info("Method : getbloodgroupList1 starts");

		logger.info("Method : getbloodgroupList1 ends");
		return manageemployeeDao.getbloodgroupList1();
	}

	@RequestMapping(value = "getmaritalstatusList1", method = { RequestMethod.GET })
	public List<DropDownModel> getmaritalstatusList1() {
		logger.info("Method : getmaritalstatusList1 starts");

		logger.info("Method : getmaritalstatusList1 ends");
		return manageemployeeDao.getmaritalstatusList1();
	}

	@RequestMapping(value = "documentTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getdocumenttypeList1() {
		logger.info("Method : getdocumenttypeList1 starts");

		logger.info("Method : getdocumenttypeList1 ends");
		return manageemployeeDao.getdocumenttypeList1();
	}
	@RequestMapping(value = "getDesignations", method = { RequestMethod.GET })
	public List<DropDownModel> getDesignations(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getDesignations starts");

		logger.info("Method : getDesignations ends");
		return manageemployeeDao.getDesignations(organization,orgDivision);
	}
	
	@RequestMapping(value = "documentTypeListApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> documentTypeListApi() {
		logger.info("Method : documentTypeListApi starts");

		logger.info("Method : documentTypeListApi ends");
		return manageemployeeDao.documentTypeListApiDao();
	}

	@RequestMapping(value = "getJobType1", method = { RequestMethod.GET })
	public List<DropDownModel> getJobType1(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getJobType1 starts");

		logger.info("Method : getJobType1 ends");
		return manageemployeeDao.getJobType1(organization,orgDivision);
	}

	@RequestMapping(value = "getDepartmentList1", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList1(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getDepartmentList1 starts");

		logger.info("Method : getDepartmentList1 ends");
		return manageemployeeDao.getDepartmentList1(organization,orgDivision);
	}

	@RequestMapping(value = "getTimesheetType1", method = { RequestMethod.GET })
	public List<DropDownModel> getTimesheetType1(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getTimesheetType1 starts");

		logger.info("Method : getTimesheetType1 ends");
		return manageemployeeDao.getTimesheetType1(organization,orgDivision);
	}

	@RequestMapping(value = "getemploymentType1", method = { RequestMethod.GET })
	public List<DropDownModel> getemploymentType1(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getemploymentType1 starts");

		logger.info("Method : getemploymentType1 ends");
		return manageemployeeDao.getemploymentType1(organization,orgDivision);
	}

	@RequestMapping(value = "getaddressList1", method = { RequestMethod.GET })
	public List<DropDownModel> getaddressList1() {
		logger.info("Method : getaddressList1 starts");

		logger.info("Method : getaddressList1 ends");
		return manageemployeeDao.getaddressList1();
	}

	@RequestMapping(value = "getJobType2", method = { RequestMethod.GET })
	public List<DropDownModel> getJobType2(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getJobType2 starts");

		logger.info("Method : getJobType2 ends");
		return manageemployeeDao.getJobType2();
	}

	@RequestMapping(value = "getBenefits", method = { RequestMethod.GET })
	public List<DropDownModel> getBenefits(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getBenefits starts");

		logger.info("Method : getBenefits ends");
		return manageemployeeDao.getBenefits(organization,orgDivision);
	}
	@RequestMapping(value = "getBenefitsApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBenefitsApi(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getBenefitsApi starts");
		
		logger.info("Method : getBenefitsApi ends");
		return manageemployeeDao.getBenefitsApi(organization,orgDivision);
	}

	@RequestMapping(value = "getBankNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getBankNameList() {
		logger.info("Method : getBankNameList starts");

		logger.info("Method : getBankNameList ends");
		return manageemployeeDao.getBankNameList();
	}

	@RequestMapping(value = "dependentTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> dependentTypeList() {
		logger.info("Method : dependentTypeList starts");

		logger.info("Method : dependentTypeList ends");
		return manageemployeeDao.dependentTypeList();
	}

	@RequestMapping(value = "dependentTypeListapi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> dependentTypeListApi() {
		logger.info("Method : dependentTypeListApi starts");

		logger.info("Method : dependentTypeListApi ends");
		return manageemployeeDao.dependentTypeListApi();
	}

	@RequestMapping(value = "relationshipList", method = { RequestMethod.GET })
	public List<DropDownModel> relationshipList() {
		logger.info("Method : relationshipList starts");

		logger.info("Method : relationshipList ends");
		return manageemployeeDao.relationshipList();
	}

	@RequestMapping(value = "relationshipListapi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> relationshipListapi() {
		logger.info("Method : relationshipListapi starts");

		logger.info("Method : relationshipListapi ends");
		return manageemployeeDao.relationshipListapi();
	}

	@RequestMapping(value = "EmployeeList", method = { RequestMethod.GET })
	public List<DropDownModel> EmployeeList(@RequestParam String organization,String orgDivision) {
		logger.info("Method : EmployeeList starts");
		logger.info("Method : EmployeeList ends");
		return manageemployeeDao.EmployeeList(organization,orgDivision);
	}

	@RequestMapping(value = "OfferletterList", method = { RequestMethod.GET })
	public List<DropDownModel> OfferletterList() {
		logger.info("Method : OfferletterList starts");

		logger.info("Method : OfferletterList ends");
		return manageemployeeDao.OfferletterList();
	}

	@GetMapping(value = "getManager")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getManager(@RequestParam String id,String organization,String orgDivision) {
		logger.info("Method : getManager starts");

		logger.info("Method : getManager ends");
		return manageemployeeDao.getManager(id,organization,orgDivision);
	}
	
	@GetMapping(value = "getSubdepartmentList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubdepartmentList(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : getSubdepartmentList starts");

		logger.info("Method : getSubdepartmentList ends");
		return manageemployeeDao.getSubdepartmentList(id,organization,orgDivision);
	}

	@GetMapping(value = "getTeam")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTeam(@RequestParam String id,String organization,String orgDivision) {
		logger.info("Method : getTeam starts");

		logger.info("Method : getTeam ends");
		return manageemployeeDao.getTeam(id,organization,orgDivision);
	}

	@RequestMapping(value = "insuranceCompanyList", method = { RequestMethod.GET })
	public List<DropDownModel> insuranceCompanyList(@RequestParam String organization,String orgDivision) {
		logger.info("Method : insuranceCompanyList starts");

		logger.info("Method : insuranceCompanyList ends");
		return manageemployeeDao.insuranceCompanyList(organization,orgDivision);
	}

	// API INSURANCE COMPANY LIST
	@RequestMapping(value = "insuranceCompanyListApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> insuranceCompanyListApi() {
		logger.info("Method : insuranceCompanyListAPi starts");

		logger.info("Method : insuranceCompanyListAPi ends");
		return manageemployeeDao.insuranceCompanyListApiDao();
	}
//save employee
	@RequestMapping(value = "saveemployeeMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeRestModel>> saveemployeeMaster(
			@RequestBody ManageEmployeeRestModel employeee) {
		logger.info("Method : saveemployeeMaster starts");
		
		logger.info("Method : saveemployeeMaster ends");
		return manageemployeeDao.saveemployeeMaster(employeee);
	}
	//new Employee
		@RequestMapping(value = "saveNewEmployeeMaster", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<ManageEmployeeRestModel>> saveNewEmployeeMaster(
				@RequestBody ManageEmployeeRestModel employeee) {
			logger.info("Method : saveNewEmployeeMaster starts");

			logger.info("Method : saveNewEmployeeMaster ends");
			return manageemployeeDao.saveNewEmployeeMaster(employeee);
		}
	/************************* View Employee *********************************/
	@RequestMapping(value = "view-manage-employee-maste", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeRestModel>>> viewmanageemployeemaste(@RequestParam String userId,@RequestParam String organization,@RequestParam String orgDivision,String type) {
		logger.info("Method : viewmanageemployeemaste start");

		logger.info("Method : viewmanageemployeemaste ends");

		return manageemployeeDao.viewmanageemployeemaste(userId,organization,orgDivision,type);

	}

	@RequestMapping(value = "saveemployeeaddress", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>> saveemployeeaddress(
			@RequestBody ManageEmployeeAddressRestModel manageEmployeeAddressModel) {
		logger.info("Method : saveemployeeaddress starts");

		logger.info("Method : saveemployeeaddress ends");
		return manageemployeeDao.saveemployeeaddress(manageEmployeeAddressModel);
	}

	@RequestMapping(value = "/viewEmployeeadd", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeAddressRestModel>>> viewEmployeeadd(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : viewEmployeeadd start");

		logger.info("Method : viewEmployeeadd ends");

		return manageemployeeDao.viewEmployeeadd(id,organization,orgDivision);
	}

	@RequestMapping(value = "saveemployeeworkdetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeWorkdetailsRestModel>> saveemployeeworkdetails(
			@RequestBody ManageEmployeeWorkdetailsRestModel manageEmployeeWorkdetailsRestModel) {
		logger.info("Method : saveemployeeworkdetails starts");

		logger.info("Method : saveemployeeworkdetails ends");
		return manageemployeeDao.saveemployeeworkdetails(manageEmployeeWorkdetailsRestModel);
	}

	@RequestMapping(value = "/viewEmployeework", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>> viewEmployeework(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : viewEmployeework start");

		logger.info("Method : viewEmployeework ends");

		return manageemployeeDao.viewEmployeework(id,organization,orgDivision);
	}

	@RequestMapping(value = "saveemployeedependent", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeDependentRestModel>> saveemployeedependent(
			@RequestBody ManageEmployeeDependentRestModel manageEmployeeDependentRestModel) {
		logger.info("Method : saveemployeedependent starts");

		logger.info("Method : saveemployeedependent ends");
		return manageemployeeDao.saveemployeedependent(manageEmployeeDependentRestModel);
	}

	/*
	 * @PostMapping(value = "saveemployeedependent") public
	 * ResponseEntity<JsonResponse<List<ManageEmployeeDependentRestModel>>>
	 * saveemployeedependent(
	 * 
	 * @RequestBody List<ManageEmployeeDependentRestModel> leave) {
	 * logger.info("Method : ManageEmployeeDependentRestModel starts");
	 * logger.info("Method : ManageEmployeeDependentRestModel ends"); return
	 * manageemployeeDao.saveemployeedependent(manageEmployeeDependentRestModel); }
	 */

	@RequestMapping(value = "/viewempdepent", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeDependentRestModel>>> viewempdepent(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : viewempdepent start");

		logger.info("Method : viewempdepent ends");

		return manageemployeeDao.viewempdepent(id,organization,orgDivision);
	}

	@RequestMapping(value = "saveemployeebank", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeBankDetailsRestModel>> saveemployeebank(
			@RequestBody ManageEmployeeBankDetailsRestModel manageEmployeeBankDetailsRestModel) {
		logger.info("Method : saveemployeebankdetails starts");

		logger.info("Method : saveemployeebankdetails ends");
		return manageemployeeDao.saveemployeebank(manageEmployeeBankDetailsRestModel);
	}

	@RequestMapping(value = "/viewebank", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>> viewebank(@RequestParam("id") String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : viewVendorBankDetails start");

		logger.info("Method : viewVendorBankDetails ends"+orgDivision);

		return manageemployeeDao.viewebank(id,organization,orgDivision);
	}

	@RequestMapping(value = "saveempinsurance", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeInsuranceDetailsrestModel>> saveempinsurance(

			@RequestBody ManageEmployeeInsuranceDetailsrestModel manageEmployeeInsuranceDetailsrestModel) {
		logger.info("Method : saveempinsurance starts");

		logger.info("Method : saveempinsurance ends");
		return manageemployeeDao.saveempinsurance(manageEmployeeInsuranceDetailsrestModel);
	}

	@RequestMapping(value = "/vieweinsurance", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeInsuranceDetailsrestModel>>> vieweinsurance(
			@RequestParam("id") String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : vieweinsurance start");

		logger.info("Method : vieweinsurance ends");

		return manageemployeeDao.vieweinsurance(id,organization,orgDivision);
	}

	@RequestMapping(value = "editmanageEmployeemasterById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ManageEmployeeRestModel>> editmanageEmployeemasterById(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : editmanageEmployeemasterById starts");

		logger.info("Method : editmanageEmployeemasterById ends");
		return manageemployeeDao.editmanageEmployeemasterById(id,organization,orgDivision);
	}

	@GetMapping(value = "deleteAddress")
	public ResponseEntity<JsonResponse<Object>> deleteAddress(@RequestParam String id,String organization,String orgDivision) {
		logger.info("Method : deleteAddress starts");

		logger.info("Method : deleteAddress ends");
		return manageemployeeDao.deleteAddress(id,organization,orgDivision);
	}

	@GetMapping(value = "deletework")
	public ResponseEntity<JsonResponse<Object>> deletework(@RequestParam String id) {
		logger.info("Method : deletework starts");

		logger.info("Method : deletework ends");
		return manageemployeeDao.deletework(id);
	}

	@GetMapping(value = "rest-deletedependent")
	public ResponseEntity<JsonResponse<Object>> deletedependent(@RequestParam String id,String organization,String orgDivision) {
		logger.info("Method : deletedependent starts");

		logger.info("Method : deletedependent ends");
		return manageemployeeDao.deletedependent(id,organization,orgDivision);
	}
	
	
	/*
	 * @PostMapping(value = "rest-deletedependent") public
	 * JsonResponse<ManageEmployeeDependentRestModel> deletedependent(@RequestBody
	 * EmpRoleModel empModel) {
	 * logger.info("Method :  deletedependent rest starts");
	 * 
	 * List<String> roleList = empModel.getUserRole(); String
	 * organization=empModel.getOrganization(); String
	 * orgDivision=empModel.getOrgDivision();
	 * 
	 * String deleteId = ""; if (roleList.size() > 0) { for (String m : roleList) {
	 * if (empModel.getType().equals("WEB")) { deleteId = deleteId + m + ","; } else
	 * { deleteId = deleteId + "\"" + m + "\","; } } }
	 * 
	 * if (deleteId != null && deleteId != "") { deleteId = deleteId.substring(0,
	 * deleteId.length() - 1); }
	 * 
	 * logger.info("Method : deletedependent rest ends"); return
	 * manageemployeeDao.deletedependent(deleteId,organization,orgDivision); }
	 */

	@GetMapping(value = "deletebank")
	public ResponseEntity<JsonResponse<Object>> deletebank(@RequestParam String id) {
		logger.info("Method : deletebank starts");

		logger.info("Method : deletebank ends");
		return manageemployeeDao.deletebank(id);
	}

	@GetMapping(value = "deleteinsurance")
	public ResponseEntity<JsonResponse<Object>> deleteinsurance(@RequestParam String id) {
		logger.info("Method : deleteinsurance starts");

		logger.info("Method : deleteinsurance ends");
		return manageemployeeDao.deleteinsurance(id);
	}

	@RequestMapping(value = "savebenifit", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> savebenifit(

			@RequestBody ManageEmployeeBenifitrestModel savebenifit) {
		logger.info("Method : savebenifit starts");

		logger.info("Method : savebenifit ends");
		return manageemployeeDao.savebenifit(savebenifit);
	}

	@RequestMapping(value = "/viewbenifit", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeBenifitrestModel>>> viewbenifit(@RequestParam String empid,String organization,String orgDivision) {
		logger.info("Method : viewbenifit start");

		logger.info("Method : viewbenifit ends");
		return manageemployeeDao.viewBenefits(empid,organization,orgDivision);
	}

	/*
	 * @PostMapping(value = "addDoc") public ResponseEntity<JsonResponse<Object>>
	 * addDoc(@RequestBody EmployeeDocumentModel employeeDocumentModel) {
	 * logger.info("Method : addDoc starts"); logger.info("Method : addDoc ends");
	 * return manageemployeeDao.addDoc(employeeDocumentModel); }
	 */

	@GetMapping(value = "viewEmpDocEdit")
	public List<InventoryVendorDocumentModel> viewEmpDocEdit(@RequestParam String id) {
		logger.info("Method : viewEmpDocEdit starts");
		logger.info("Method : viewEmpDocEdit endss");
		return manageemployeeDao.viewEmpDocEdit(id);
	}

	// Country list dropdown for country

	@RequestMapping(value = "getCountryListApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCountryListApi() {
		logger.info("Method : getCountryListApi starts");

		logger.info("Method : getCountryListApi ends");
		return manageemployeeDao.getCountryListApiDao();
	}
	// Nationality list dropdown for country
	
	@RequestMapping(value = "getNationalityListApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNationalityListApi() {
		logger.info("Method : getNationalityListApi starts");
		
		logger.info("Method : getNationalityListApi ends");
		return manageemployeeDao.getNationalityListApiDao();
	}

	// Gender list dropdown for gender

	@RequestMapping(value = "getgenderListApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getgenderListAPi() {
		logger.info("Method : getgenderListAPi starts");

		logger.info("Method : getgenderListAPi ends");
		return manageemployeeDao.getgenderListAPiDao();
	}

	// Gender list dropdown for bloodgroup

	@RequestMapping(value = "getbloodgroupListApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getbloodgroupListApi() {
		logger.info("Method : getbloodgroupListApi starts");

		logger.info("Method : getbloodgroupListApi ends");
		return manageemployeeDao.getbloodgroupListApiDao();
	}

	// Gender list dropdown for marital status

	@RequestMapping(value = "getmaritalstatusListApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getmaritalstatusListApi() {
		logger.info("Method : getmaritalstatusListApi starts");

		logger.info("Method : getmaritalstatusListApi ends");
		return manageemployeeDao.getmaritalstatusListApiDao();
	}

	@PostMapping(value = "post-profile-dataupload-api", headers = "content-type=multipart/*", consumes = {
			"application/*" })
	public ResponseEntity<JsonResponse<EmployeeProfileFileUploadModel>> profileDataUpload(
			EmployeeProfileFileUploadModel employeeProfileFileUploadModel) {
		logger.info("Method : profileDataUpload starts");

		MultipartFile x = employeeProfileFileUploadModel.getMulFile();
		String fileName = null;
		if (x != null) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = saveAllProfileDocuments(bytes, employeeProfileFileUploadModel.getExtension(),
					employeeProfileFileUploadModel.getCreatedBy());
		}
		employeeProfileFileUploadModel.setFileName(fileName);

		logger.info("Method : profileDataUpload ends");
		return manageemployeeDao.profileDataUpload(employeeProfileFileUploadModel);
	}

	public String saveAllProfileDocuments(byte[] imageBytes, String ext, String pId) {
		logger.info("Method : saveAllProfileDocuments starts");

		String imageName = null;

		try {

			if (imageBytes != null) {
				long nowTime = new Date().getTime();

				if (ext.contentEquals("jpeg")) {
					imageName = pId + "_" + nowTime + ".jpg";
				} else {
					imageName = pId + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getFileUploadProfile() + imageName);
			if (imageBytes != null) {
				if (pId != null && pId != "") {
					Files.write(path, imageBytes);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : saveAllProfileDocuments ends");
		return imageName;
	}
	@PostMapping(value = "/resetPassword")
	public ResponseEntity<JsonResponse<Object>> resetPassword(@RequestBody DropDownModel data) {
		logger.info("Method : resetPassword starts");

		logger.info("Method : resetPassword ends");
		return manageemployeeDao.resetPasswordDao(data);
	}
	@RequestMapping(value = "rest-editAddressDetails", method = { RequestMethod.GET })
	public JsonResponse<ManageEmployeeAddressRestModel> editAddressDetails(@RequestParam String addressId,String addressType, String organization, String orgDivision) {
		logger.info("Method : editAddressDetails rest starts");

		logger.info("Method :editAddressDetails rest ends");
		return manageemployeeDao.editAddressDetails(addressId,addressType,organization,orgDivision);
	}
	@RequestMapping(value = "rest-editInsurance", method = { RequestMethod.GET })
	public JsonResponse<ManageEmployeeInsuranceDetailsrestModel> editInsurance(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : editInsurance rest starts");
		
		logger.info("Method :editInsurance rest ends");
		return manageemployeeDao.editInsurance(id,organization,orgDivision);
	}
	@RequestMapping(value = "rest-editWorkDetail", method = { RequestMethod.GET })
	public JsonResponse<ManageEmployeeWorkdetailsRestModel> editWorkDetails(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : editWorkDetails rest starts");

		logger.info("Method :editWorkDetails rest ends");
		return manageemployeeDao.editWorkDetails(id,organization,orgDivision);
	}
	@RequestMapping(value = "rest-editDependentDetails", method = { RequestMethod.GET })
	public JsonResponse<ManageEmployeeDependentRestModel> editDependentDetails(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : editDependentDetails rest starts");

		logger.info("Method :editDependentDetails rest ends");
		return manageemployeeDao.editDependentDetails(id,organization,orgDivision);
	}
	@RequestMapping(value = "rest-editBankDetails", method = { RequestMethod.GET })
	public JsonResponse<ManageEmployeeBankDetailsRestModel> editBankDetails(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : editBankDetails rest starts");
		
		logger.info("Method :editBankDetails rest ends");
		return manageemployeeDao.editBankDetails(id,organization,orgDivision);
	}
	@RequestMapping(value = "/viewedocument", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeDocumentRestModel>>> viewedocument(
			@RequestParam("id") String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : viewedocument start");

		logger.info("Method : viewedocument ends");

		return manageemployeeDao.viewedocument(id,organization,orgDivision);
	}
	@RequestMapping(value = "rest-addEmpDocument", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> addEmpDocument(
			@RequestBody ManageEmployeeDocumentRestModel docModel) {
		logger.info("Method : addEmpDocument starts");

		logger.info("Method : addEmpDocument ends");
		return manageemployeeDao.addEmpDocument(docModel);
	}
	@GetMapping(value = "deleteEmpDoc")
	public ResponseEntity<JsonResponse<Object>> deleteEmpDoc(@RequestParam String docType,String empid,String organization, String orgDivision) {
		logger.info("Method : deleteEmpDoc starts");
		
		logger.info("Method : deleteEmpDoc ends");
		return manageemployeeDao.deleteEmpDoc(docType,empid, organization, orgDivision);
	}
	@RequestMapping(value = "rest-editDocumentDetails", method = { RequestMethod.GET })
	public JsonResponse<ManageEmployeeDocumentRestModel> editDocumentDetails(@RequestParam String docType,String empid,String organization, String orgDivision) {
		logger.info("Method : editDocumentDetails rest starts");

		logger.info("Method :editDocumentDetails rest ends");
		return manageemployeeDao.editDocumentDetails(docType,empid, organization, orgDivision);
	}
	// get doctype 

	@GetMapping(value = "get-getDocumentTypeList")
	public JsonResponse<List<DropDownModel>> getDocumentTypeList(@RequestParam String empid,String orgName,String orgDivision) {
		logger.info("Method : getDocumentTypeList starts");

		logger.info("Method : getDocumentTypeList ends");
		return manageemployeeDao.getDocumentTypeList(empid,orgName,orgDivision);
	}
	
	@RequestMapping(value = "getIdCardDetails", method = { RequestMethod.GET })
	public List<ManageEmployeeRestModel> getIdCardDetails(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : getIdCardDetails starts");

		logger.info("Method : getIdCardDetails ends");
		return manageemployeeDao.getIdCardDetails(id,organization,orgDivision);
	}
	@RequestMapping(value = "rest-saveeDocumentType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> saveeDocumentType(
			@RequestBody ManageEmployeeDocumentRestModel docModel) {
		logger.info("Method : saveeDocumentType starts");

		logger.info("Method : saveeDocumentType ends");
		return manageemployeeDao.saveeDocumentType(docModel);
	}
	@GetMapping(value = "getQualifyEduList")
	public JsonResponse<List<DropDownModel>> getQualifyEduList(@RequestParam String orgName,String orgDivision) {
		logger.info("Method : getQualifyEduList starts");

		logger.info("Method : getQualifyEduList ends");
		return manageemployeeDao.getQualifyEduList(orgName,orgDivision);
	}
	
	@RequestMapping(value = "saveemployeeEducation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeEducationRestModel>> saveemployeeEducation(
			@RequestBody ManageEmployeeEducationRestModel education) {
		logger.info("Method : saveemployeeEducation starts");

		logger.info("Method : saveemployeeEducation ends");
		return manageemployeeDao.saveemployeeEducation(education);
	}
	@RequestMapping(value = "/empQualificationView", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeEducationRestModel>>> empQualificationView(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : empQualificationView start");

		logger.info("Method : empQualificationView ends");

		return manageemployeeDao.empQualificationView(id,organization,orgDivision);
	}
	@RequestMapping(value = "empQualificationEdit", method = { RequestMethod.GET })
	public JsonResponse<ManageEmployeeEducationRestModel> empQualificationEdit(@RequestParam String eduid,String empid,String organization, String orgDivision) {
		logger.info("Method : empQualificationEdit rest starts");

		logger.info("Method :empQualificationEdit rest ends");
		return manageemployeeDao.empQualificationEdit(eduid,empid, organization, orgDivision);
	}
	@RequestMapping(value = "rest-saveeQualifyType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeEducationRestModel>> saveeQualifyType(
			@RequestBody ManageEmployeeEducationRestModel docModel) {
		logger.info("Method : saveeQualifyType starts");

		logger.info("Method : saveeQualifyType ends");
		return manageemployeeDao.saveQualifyType(docModel);
	}
	@GetMapping(value = "deleteEducation")
	public ResponseEntity<JsonResponse<Object>> deleteEducation(@RequestParam String id) {
		logger.info("Method : deleteEducation starts");

		logger.info("Method : deleteEducation ends");
		return manageemployeeDao.deleteEducation(id);
	}

	@RequestMapping(value = "getemployedByList", method = { RequestMethod.GET })
	public List<DropDownModel> getemployedByList(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getemployedByList starts");

		logger.info("Method : getemployedByList ends");
		return manageemployeeDao.getemployedByList(organization,orgDivision);
	}
	@RequestMapping(value = "getQualifyEduListdropdown", method = { RequestMethod.GET })
	public List<DropDownModel> getQualifyEduListdropdown(@RequestParam String orgName,String orgDivision) {
		logger.info("Method : getQualifyEduListdropdown starts");

		logger.info("Method : getQualifyEduListdropdown ends");
		return manageemployeeDao.getQualifyEduListdropdown(orgName,orgDivision);
	}
	@RequestMapping(value = "/viewSalaryMasterSingle", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> viewSalaryMasterSingle(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : viewSalaryMasterSingle start");

		logger.info("Method : viewSalaryMasterSingle ends");

		return manageemployeeDao.viewSalaryMasterSingle(id,organization,orgDivision);
	}
//	@RequestMapping(value = "rest-salary-edit", method = { RequestMethod.GET })
//	ResponseEntity<JsonResponse<RestSalaryRevisionModel>> editSalaryMasterSingle(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
//		logger.info("Method : editSalaryMasterSingle start");
//
//		logger.info("Method : editSalaryMasterSingle ends");
//
//		return manageemployeeDao.editSalaryMasterSingle(id,organization,orgDivision);
//	}

	@RequestMapping(value = "rest-saveeCCRType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> saveeCCRType(
			@RequestBody ManageEmployeeDocumentRestModel docModel) {
		logger.info("Method : saveeCCRType starts");

		logger.info("Method : saveeCCRType ends");
		return manageemployeeDao.saveeCCRType(docModel);
	}

	
}
