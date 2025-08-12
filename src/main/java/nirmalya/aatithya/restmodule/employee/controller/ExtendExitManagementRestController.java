package nirmalya.aatithya.restmodule.employee.controller;

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
import nirmalya.aatithya.restmodule.employee.dao.ExitManagementRestDao;
import nirmalya.aatithya.restmodule.employee.model.ExitFinancialSettelmentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;

@RestController
@RequestMapping("employee/")
public class ExtendExitManagementRestController {

	Logger logger = LoggerFactory.getLogger(ExtendExitManagementRestController.class);

	@Autowired
	ExitManagementRestDao exitManagementDao;

	// Name list

	@RequestMapping(value = "getNamelist", method = { RequestMethod.GET })
	public List<DropDownModel> namelist() {
		logger.info("Method : namelist starts");

		logger.info("Method : namelist ends");
		return exitManagementDao.namelist();
	}
	
	/*
	 * Employee AutoSearch For clearance
	 * 
	 */
	@GetMapping(value = "employee-autosearch-clearance")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> employeeAutoSearch(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : employeeAutoSearch starts");

		
		logger.info("Method :employeeAutoSearch endss");
		return exitManagementDao.employeeAutoSearch(id, org, orgDiv);
	}

	// Department list(Clearance)

	@RequestMapping(value = "getDeptlist")
	public List<DropDownModel> departmentList(String org, String orgDiv) {
		logger.info("Method : departmentList starts");

		logger.info("Method : departmentList ends");
		return exitManagementDao.deptList(org, orgDiv);
	}

	// "Clearance By" List

	@RequestMapping(value = "getClrncPersonList", method = { RequestMethod.GET })
	public List<DropDownModel> clrncPersonList() {
		logger.info("Method : clrncPersonList starts");

		logger.info("Method : clrncPersonList ends");
		return exitManagementDao.clrncPersonList();
	}

	// job

	@GetMapping(value = "rest-get-designationList")
	public JsonResponse<List<DropDownModel>> getDesignationList(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return exitManagementDao.getDesignationList(id);
	}

	/*
	 * View Exit Management
	 * 
	 */
	@GetMapping(value = "viewExitdetails")
	public JsonResponse<Object> viewExtendExitManagementDtls(@RequestParam String userId, String userRole,
			String organization, String orgDivision, String selftype) {
		logger.info("Method : viewExtendExitManagementDtls starts");

		logger.info("Method : viewExtendExitManagementDtls ends");

		return exitManagementDao.viewExtendExitManagementDtls(userId, userRole, organization, orgDivision, selftype);
	}

	/*
	 *
	 * Edit Exit details
	 *
	 */
	@RequestMapping(value = "editExitManagement", method = { RequestMethod.GET })
	public JsonResponse<ExtendExitManagementRestModel> editManagementDetails(@RequestParam String id,
			String organization, String orgDivision) {
		logger.info("Method : editManagementDetails starts");

		logger.info("Method :editManagementDetails ends");
		return exitManagementDao.editManagementDetails(id, organization, orgDivision);
	}
	/*
	 * Add Exit Management
	 * 
	 */

	@PostMapping(value = "addExitdetails")
	public JsonResponse<Object> addExitManagement(@RequestBody ExtendExitManagementRestModel exit) {
		logger.info("Method : addExitManagement starts");

		logger.info("Method : addExitManagement ends");
		return exitManagementDao.addExitManagement(exit);
	}

	/*
	 * Add Initiate & Clearance Details
	 * 
	 */
	@PostMapping(value = "addinitiatedata")

	public JsonResponse<Object> addClearanceDetails(@RequestBody ExtendExitManagementRestModel exit) {
		logger.info("Method : addClearanceDetails starts");

		logger.info("Method : addClearanceDetails ends");
		return exitManagementDao.addClearanceDetailsDao(exit);
	}

	/*
	 *
	 * Delete Student details
	 *
	 */
	@GetMapping(value = "exitManagementdelete")
	public JsonResponse<ExtendExitManagementRestModel> deleteExitDetails(@RequestParam String id) {
		logger.info("Method : deleteExitDetails starts");

		logger.info("Method :deleteExitDetails ends");
		return exitManagementDao.deleteExitDetails(id);
	}
	/*
	 * Add Finance Details
	 * 
	 */

	@PostMapping(value = "addFinancedetails")
	public JsonResponse<Object> addFinanceDetails(@RequestBody ExtendExitManagementRestModel exit) {
		logger.info("Method : addFinanceDetails starts");

		logger.info("Method : addFinanceDetails ends");
		return exitManagementDao.addFinanceDetails(exit);
	}

	@GetMapping(value = "get-deptClearanceDetails")
	public JsonResponse<List<DropDownModel>> viewdeptClearanceDetails(@RequestParam String userid) {
		logger.info("Method : viewdeptClearanceDetails starts");

		logger.info("Method : viewdeptClearanceDetails ends");
		return exitManagementDao.viewdeptClearanceDetails(userid);
	}

	/*
	 * view Exit Clearance
	 * 
	 */
	@GetMapping(value = "viewExitClearance")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewExitClearance(@RequestParam String userId,
			String exitid, String organization, String orgDivision) {
		logger.info("Method : viewExitClearance starts");

		logger.info("Method : viewExitClearance ends");

		return exitManagementDao.viewExitClearance(userId, exitid, organization, orgDivision);
	}

	/*
	 *
	 * Edit Exit Clearance
	 *
	 */
	@RequestMapping(value = "editClearance", method = { RequestMethod.GET })
	public JsonResponse<ExtendExitManagementRestModel> editClearance(@RequestParam String id, String organization,
			String orgDivision) {
		logger.info("Method : editClearance starts");

		logger.info("Method :editClearance ends");
		return exitManagementDao.editClearance(id, organization, orgDivision);
	}

	@PostMapping(value = "add-notice-proceed")
	public JsonResponse<Object> addNoticeProceed(@RequestBody ExtendExitManagementRestModel exit) {
		logger.info("Method : addNoticeProceed starts");

		logger.info("Method : addNoticeProceed ends");
		return exitManagementDao.proceedNotice(exit);
	}

	/*
	 * Get Employee Name for choosen Js(Edit)
	 */
	@GetMapping(value = "rest-exit-view-getdeptname")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptDetails(@RequestParam String id, String organization,
			String orgDivision) {
		logger.info("Method : getDeptDetails starts");

		logger.info("Method : getDeptDetails ends");
		return exitManagementDao.getDeptDetails(id, organization, orgDivision);
	}

	/*
	 * Get Employee Clearance Status
	 */

	@GetMapping(value = "rest-view-clearance-details")
	public JsonResponse<Object> getEmpClearanceStatus(@RequestParam String exitId, String organization,
			String orgDivision) {
		logger.info("Method : getEmpClearanceStatus starts");

		logger.info("Method : getEmpClearanceStatus ends");
		return exitManagementDao.getEmpClearanceStatus(exitId, organization, orgDivision);
	}

	/*
	 * View Experience Letter
	 * 
	 */
	@GetMapping(value = "get-emp-expLetter")
	public JsonResponse<Object> viewExperienceLetter(@RequestParam String exitId, String organization,
			String orgDivision) {
		logger.info("Method : viewExperienceLetter starts");

		logger.info("Method : viewExperienceLetter ends");

		return exitManagementDao.viewExperienceLetter(exitId, organization, orgDivision);
	}

	/*
	 * View No Due Certificate
	 * 
	 */
	@GetMapping(value = "get-no-due-certificate")
	public JsonResponse<Object> noDuertificate(@RequestParam String exitId, String organization,
			String orgDivision) {
		logger.info("Method : noDuertificate starts");

		logger.info("Method : noDuertificate ends");

		return exitManagementDao.noDuertificate(exitId, organization, orgDivision);
	}

	// view pay slip API

	@GetMapping(value = "view-employe-paySlip-api")
	public JsonResponse<Object> viewPaySlipApi(@RequestParam String userId, String fromDate, String toDate,
			String organization, String orgDivision) {
		logger.info("Method : viewPaySlipApi starts");

		logger.info("Method : viewPaySlipApi ends");
		return exitManagementDao.viewPaySlipApi(userId, organization, orgDivision, fromDate, toDate);
	}


	// view Final Settlement By employee ID

	@GetMapping(value = "rest-view-final-settlement")
	public JsonResponse<Object> getFinalSettlement(@RequestParam String employeeId,String fromDate,String toDate,String releaseDt, String org,
			String orgDiv) {
		logger.info("Method : getFinalSettlement starts");

		logger.info("Method : getFinalSettlement ends");
		return exitManagementDao.getFinalSettlement(employeeId,fromDate,toDate,releaseDt,org,orgDiv);
	}
	
	/*
	 * view final settlement By settlement ID
	 */
	
	@GetMapping(value = "rest-view-final-settlement-byId")
	public JsonResponse<Object> getFinalSettlementByID(@RequestParam String settlementId, String organization,
			String orgDivision) {
		logger.info("Method : getFinalSettlementByID starts");
		
		logger.info("Method : getFinalSettlementByID ends");
		return exitManagementDao.getFinalSettlementByID(settlementId, organization, orgDivision);
	}
	
	
	/*
	 * Add Final Settlement
	 * 
	 */

	@PostMapping(value = "save-final-settlement")
	public JsonResponse<Object> saveFinancialSettlement(@RequestBody ExitFinancialSettelmentRestModel exit) {
		logger.info("Method : saveFinancialSettlement starts");

		logger.info("Method : saveFinancialSettlement ends");
		return exitManagementDao.saveFinancialSettlement(exit);
	}
	
	
	// update clearance employee employee
	
	@GetMapping(value = "update-clearance-employee")
		public JsonResponse<Object> updateClearanceEmployee(@RequestParam String empId,String clearanceId, String org, String orgDiv) {
			logger.info("Method : updateClearanceEmployee starts");

			logger.info("Method : updateClearanceEmployee ends");
			return exitManagementDao.updateClearanceEmployee(empId, clearanceId, org, orgDiv);
		}

}