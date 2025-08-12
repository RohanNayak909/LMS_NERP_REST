package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

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
import nirmalya.aatithya.restmodule.master.dao.SalaryRevisionDao;
import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;

@RestController
@RequestMapping(value = { "master" })

public class RestSalaryRevisionController {

	Logger logger = LoggerFactory.getLogger(RestSalaryRevisionController.class);

	@Autowired
	SalaryRevisionDao salaryRevisionDao;

	@RequestMapping(value = "/getFinancialYrForSalaryRevision", method = { RequestMethod.GET })
	public List<DropDownModel> getFinancialYrForSalaryRevision(@RequestParam String organization, String orgDivision) {
		logger.info("Method : getFinancialYrForSalaryRevision starts");

		logger.info("Method : getFinancialYrForSalaryRevision end");
		return salaryRevisionDao.getFinancialYrForSalaryRevision(organization, orgDivision);
	}

// employeeId list
	@GetMapping(value = "get-employee-list")
	public JsonResponse<List<DropDownModel>> getEmployeeList(@RequestParam String orgName, String orgDivision) {
		logger.info("Method : getEmployeeList starts");

		logger.info("Method : getEmployeeList ends");
		return salaryRevisionDao.getEmployeeList(orgName, orgDivision);
	}

// date list

	@GetMapping(value = "get-dateList")
	public JsonResponse<List<DropDownModel>> getDateList(@RequestParam String id) {
		logger.info("Method : getDateList starts");

		logger.info("Method : getDateList ends");
		return salaryRevisionDao.getDateList(id);
	}

// designation list

	@RequestMapping(value = "rest-getDesignationDropDown", method = { RequestMethod.GET })
	public List<DropDownModel> getDesignationDropDown(@RequestParam String organization, String orgDivision) {
		logger.info("Method : getDesignationDropDown starts");

		logger.info("Method : getDesignationDropDown end");
		return salaryRevisionDao.getDesignationDropDown(organization, orgDivision);
	}

// add

	@RequestMapping(value = "rest-addnew-salary-revision", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addsalaryrevision(@RequestBody RestSalaryRevisionModel restPayroll) {
		logger.info("Method : addsalaryrevision starts");

		logger.info("Method : addsalaryrevision ends");
		return salaryRevisionDao.addsalaryrevision(restPayroll);
	}

// view

	@RequestMapping(value = "viewSalaryMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> viewSlabMaster(@RequestParam String userid,
			String organization, String orgDivision, String id) {
		logger.info("Method : viewSalaryMaster starts");

		logger.info("Method : viewSalaryMaster ends");
		return salaryRevisionDao.viewSalaryMaster(userid, organization, orgDivision,id);
	}

//

	/*
	 *
	 * Edit rest
	 *
	 */
	@RequestMapping(value = "rest-salary-revision-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editSalaryRevision(@RequestParam String id) {
		logger.info("Method : editSalaryRevision rest starts");

		logger.info("Method :editSalaryRevision rest ends");
		return salaryRevisionDao.editSalaryRevision(id);
	}

	// name and designation list

	@GetMapping(value = "get-nameandDesignationList")
	public JsonResponse<List<DropDownModel>> getnameAndDesignationList(@RequestParam String id, String organization,
			String orgDivision) {
		logger.info("Method : getnameAndDesignationList starts");

		logger.info("Method : getnameAndDesignationList ends");
		return salaryRevisionDao.getnameAndDesignationList(id, organization, orgDivision);
	}

// delete 

	@RequestMapping(value = "rest-SalaryRevision-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSalaryRevision(@RequestParam String id, String organization,
			String orgDivision) {
		logger.info("Method : deleteSalaryRevision starts");

		logger.info("Method : deleteSalaryRevision ends");
		return salaryRevisionDao.deleteSalaryRevision(id, organization, orgDivision);
	}

	@GetMapping(value = "get-getDeptAndSubDept")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptAndSubDept(@RequestParam String empid,
			String orgName, String orgDivision) {
		logger.info("Method : getDeptAndSubDept starts");

		logger.info("Method : getDeptAndSubDept ends");
		return salaryRevisionDao.getDeptAndSubDept(empid, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-view-salary-revision-bandcalc", method = { RequestMethod.GET })
	public JsonResponse<Object> restBandCalculation(@RequestParam String band, String orgName, String orgDivision,String empid) {
		logger.info("Method :restBandCalculation start");

		logger.info("Method :restBandCalculation endss");
		return salaryRevisionDao.restBandCalculation(band, orgName, orgDivision,empid);
	}

	@RequestMapping(value = "approveSalaryStatus", method = { RequestMethod.GET })
	public JsonResponse<Object> approveSalaryStatus(@RequestParam String id, String sts, String org, String orgDiv) {
		logger.info("Method :approveSalaryStatus start");

		logger.info("Method :approveSalaryStatus endss");
		return salaryRevisionDao.approveSalaryStatus(id, sts, org, orgDiv);
	}
	// view

	@RequestMapping(value = "viewSalaryMasterByYear", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> viewSalaryMasterByYear(
			@RequestParam String startDate, String endDate, String organization, String orgDivision,String id) {
		logger.info("Method : viewSalaryMasterByYear starts");

		logger.info("Method : viewSalaryMasterByYear ends");
		return salaryRevisionDao.viewSalaryMasterByYear(startDate, endDate, organization, orgDivision,id);
	}

	/*
	 * Get Salary revision report
	 * 
	 */
	
	@GetMapping(value = "salary-revision-pdf")
	public JsonResponse<Object> getReportAllData(@RequestParam String empId, String effectiveFromDate, String effectiveToDate, String organization, String orgDivision) {
		logger.info("Method :getReportAllData start");

		logger.info("Method :getReportAllData endss");
		return salaryRevisionDao.getReportAllData(empId, effectiveFromDate, effectiveToDate, organization,
				orgDivision);
	}

}
