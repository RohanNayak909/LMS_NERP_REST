package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestPayrollDao;
import nirmalya.aatithya.restmodule.master.model.RestPayrollApprovalModel;
import nirmalya.aatithya.restmodule.master.model.RestPayrollModel;
import nirmalya.aatithya.restmodule.master.model.RestPayslipModel;

@RestController
@RequestMapping(value = "master")
public class RestPayrollController {
	Logger logger = LoggerFactory.getLogger(RestPayrollController.class);

	@Autowired
	RestPayrollDao restPayrollDao;
	@Autowired
	EntityManager em;

	/**
	 * Rest Controller - Get months For Drop Down
	 *
	 */
	@RequestMapping(value = "getMonthLists", method = { RequestMethod.GET })
	public List<DropDownModel> getMonthList() {
		logger.info("Method : getMonthList starts");

		logger.info("Method : getMonthList ends");
		return restPayrollDao.getMonthListsDao();
	}

	@RequestMapping(value = "getStaffTypeMasterAttendance", method = { RequestMethod.GET })
	public List<DropDownModel> getStaffTypeMasterAttendance(@RequestParam String organization, String orgDivision) {
		logger.info("Method : getStaffTypeMasterAttendance starts");

		logger.info("Method : getStaffTypeMasterAttendance ends");
		return restPayrollDao.getStaffTypeMasterAttendance(organization, orgDivision);
	}

	@RequestMapping(value = "getEmployedByList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployedByList(@RequestParam String organization, String orgDivision) {
		logger.info("Method : getEmployedByList starts");

		logger.info("Method : getEmployedByList ends");
		return restPayrollDao.getEmployedByList(organization, orgDivision);
	}

	/*************************** Process *******************************/
	/*
	 * Process
	 */
	@GetMapping(value = "rest-viewProcess")
	public JsonResponse<List<RestPayrollModel>> viewProcess(@RequestParam String fromDate, String toDate, String userId,
			String organization, String orgDivision, String employedBy, String stafftype, String id) {
		logger.info("Method : viewProcess starts");

		logger.info("Method : viewProcess ends");

		return restPayrollDao.viewProcessDao(fromDate, toDate, userId, organization, orgDivision, employedBy,
				stafftype,id);
	}

	/**
	 * Rest Controller - getComponetList
	 *
	 */
	@GetMapping(value = "rest-getComponetList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getComponetList(@RequestParam String organization,
			String orgDivision) {
		logger.info("Method : getComponetList starts");

		logger.info("Method : getComponetList ends");
		return restPayrollDao.getComponetList(organization, orgDivision);
	}

	/**
	 * Rest Controller - Get getApproverStatus
	 *
	 */
	@GetMapping(value = "rest-getApproverStatus")
	public ResponseEntity<JsonResponse<DropDownModel>> getApproverStatus(@RequestParam String fromDate, String process,
			String userId, String organization, String orgDivision) {
		logger.info("Method : getApproverStatus starts");

		logger.info("Method : getApproverStatus ends");
		return restPayrollDao.getApproverStatus(fromDate, process, userId, organization, orgDivision);
	}

	@RequestMapping(value = "approveProcessDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> approveProcessDetails(
			@RequestBody List<RestPayrollApprovalModel> data) {
		logger.info("Method : approveProcessDetails starts");

		logger.info("Method : approveProcessDetails ends");
		return restPayrollDao.approveProcessDetails(data);
	}

	/*************************** Approve *******************************/
	/*
	 * Approve
	 */
	@GetMapping(value = "rest-viewApprove")
	public JsonResponse<List<RestPayrollModel>> viewApprove(@RequestParam String fromDate, String toDate,
			String employedBy, String userId, String organization, String orgDivision, String stafftype, String id) {
		logger.info("Method : viewApprove starts");

		logger.info("Method : viewApprove ends");

		return restPayrollDao.viewApproveDao(fromDate, toDate, employedBy, userId, organization, orgDivision,
				stafftype,id);
	}

	/*************************** Salary Advice *******************************/
	/*
	 * view Salary Advice
	 */

	@GetMapping(value = "rest-viewSalaryAdvice")
	public JsonResponse<List<RestPayrollModel>> viewSalaryAdvice(@RequestParam String fromDate, String toDate,
			String employedBy, String userId, String organization, String orgDivision, String stafftype, String id) {
		logger.info("Method : viewSalaryAdvice starts");

		logger.info("Method : viewSalaryAdvice ends");

		return restPayrollDao.viewSalaryAdviceDao(fromDate, toDate, employedBy, userId, organization, orgDivision,
				stafftype,id);
	}

	/*************************** EPF *******************************/
	/*
	 * view EPF
	 */

	@GetMapping(value = "rest-viewEpf")
	public JsonResponse<List<RestPayrollModel>> viewEpf(@RequestParam String fromDate, String toDate, String employedBy,
			String userId, String organization, String orgDivision, String stafftype, String id) {
		logger.info("Method : viewEpf starts");

		logger.info("Method : viewEpf ends");

		return restPayrollDao.viewEpfDao(fromDate, toDate, employedBy, userId, organization, orgDivision, stafftype,id);
	}

	/*************************** ESI *******************************/
	/*
	 * view ESI
	 */

	@GetMapping(value = "rest-viewEsi")
	public JsonResponse<List<RestPayrollModel>> viewEsi(@RequestParam String fromDate, String toDate,
			@RequestParam String employedBy, String userId, String organization, String orgDivision, String stafftype, String id) {
		logger.info("Method : viewEsi starts");

		logger.info("Method : viewEsi ends");

		return restPayrollDao.viewEsiDao(fromDate, toDate, employedBy, userId, organization, orgDivision, stafftype,id);
	}

	/*************************** TAX *******************************/
	/*
	 * view TAX
	 */

	@GetMapping(value = "rest-viewTax")
	public JsonResponse<List<RestPayrollModel>> viewTax(@RequestParam String fromDate, String toDate,
			@RequestParam String employedBy, String userId, String organization, String orgDivision, String stafftype, String id) {
		logger.info("Method : viewTax starts");

		logger.info("Method : viewTax ends");

		return restPayrollDao.viewTaxDao(fromDate, toDate, employedBy, userId, organization, orgDivision, stafftype,id);
	}

	////////////////////////////////////////////// PAY SLIP
	////////////////////////////////////////////// ////////////////////////////////////////////////////////
	/*
	 * dropdown for employeelist
	 */
	@GetMapping(value = "getEmployeeListsSlip")
	public List<DropDownModel> getEmppLists(@RequestParam String userId, String isHr, String organization,
			String orgDivision) {
		logger.info("Method : getEmppLists starts");

		logger.info("Method : getEmppLists ends");
		return restPayrollDao.getEmployeeListsSlip(userId, isHr, organization, orgDivision);
	}
	/*
	 * view paySlip Personal details
	 */

	@GetMapping(value = "rest-viewpaySlipPersonal")
	public List<RestPayslipModel> viewpaySlipPersonal(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String empId, @RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : viewpaySlipPersonal starts");

		logger.info("Method : viewpaySlipPersonal ends" + orgDivision);

		return restPayrollDao.viewpaySlipPersonalDao(fromDate, toDate, empId, organization, orgDivision);
	}
	// view pay slip API (Admin can see all payslip)

	@GetMapping(value = "view-employe-paySlip-api")
	public JsonResponse<List<RestPayslipModel>> viewPaySlipApi(@RequestParam String userId, String fromDate,
			String toDate, String organization, String orgDivision, String id) {
		logger.info("Method : viewPaySlipApi starts");

		logger.info("Method : viewPaySlipApi ends");
		return restPayrollDao.viewPaySlipApi(userId, organization, orgDivision, fromDate, toDate, id);
	}
	// view pay slip API (Only Respective employee can view it's own payslip)

	@GetMapping(value = "view-employe-paySlip-api-self")
	public JsonResponse<List<RestPayslipModel>> viewPaySlipApiSelf(@RequestParam String userId, String fromDate,
			String toDate, String organization, String orgDivision) {
		logger.info("Method : viewPaySlipApiSelf starts");

		logger.info("Method : viewPaySlipApiSelf ends");
		return restPayrollDao.viewPaySlipApiSelf(userId, organization, orgDivision, fromDate, toDate);
	}

	// check payslip eligible
	@GetMapping(value = "/check-payslip-eligible")
	public ResponseEntity<JsonResponse<DropDownModel>> checkPayslipEligible(@RequestParam String userId,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : checkPayslipEligible starts");

		logger.info("Method : checkPayslipEligible ends");
		return restPayrollDao.checkPayslipEligible(userId, organization, orgDivision);
	}

	/*
	 * view Proff. TAX
	 */

	@GetMapping(value = "rest-view-proffesional-tax")
	public JsonResponse<List<RestPayrollModel>> viewProffTax(@RequestParam String fromDate, String toDate,
			String employedBy, String userId, String organization, String orgDivision, String stafftype,String id) {
		logger.info("Method : viewProffTax starts");

		logger.info("Method : viewProffTax ends");

		return restPayrollDao.viewProffTax(fromDate, toDate, employedBy, userId, organization, orgDivision, stafftype , id);
	}

	@RequestMapping(value = "saveAsDraftProcessDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveAsDraftProcessDetails(
			@RequestBody List<RestPayrollApprovalModel> data) {
		logger.info("Method : saveAsDraftProcessDetails starts");

		logger.info("Method : saveAsDraftProcessDetails ends");
		return restPayrollDao.saveAsDraftProcessDetails(data);
	}

// lic view
	@GetMapping(value = "rest-viewLic")
	public JsonResponse<Object> viewLic(@RequestParam String fromDate, String toDate, String employedBy, String userId,
			String organization, String orgDivision, String stafftype,String id) {
		logger.info("Method : viewLic starts");

		logger.info("Method : viewLic ends");

		return restPayrollDao.viewLic(fromDate, toDate, employedBy, userId, organization, orgDivision, stafftype, id);
	}

	// rest-tax-Pdf
	@GetMapping(value = "rest-tax-Pdf")
	public JsonResponse<Object> downloadTaxPdf(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String stafftype, @RequestParam String employedBy, @RequestParam String fromDate,
			@RequestParam String toDate ,@RequestParam String userId,@RequestParam String id) {
		logger.info("Method :downloadTaxPdf starts");

		logger.info("Method :downloadTaxPdf ends");
		return restPayrollDao.downloadTaxPdf(orgName, orgDivision, stafftype, employedBy, fromDate, toDate,userId,id);
	}
}
