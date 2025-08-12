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
import nirmalya.aatithya.restmodule.master.dao.RestHrMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;

@RestController
@RequestMapping(value = { "master" })
public class RestHrMasterController {
	Logger logger = LoggerFactory.getLogger(RestHrMasterController.class);

	@Autowired
	RestHrMasterDao restHrMasterDao;

	/*
	 * 
	 * post mapping for add JOB TYPE
	 * 
	 * 
	 */

	@RequestMapping(value = "/getDepartmentTypeForShiftType", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentTypeForShiftType(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getDepartmentTypeForShiftType starts");

		logger.info("Method : getDepartmentTypeForShiftType end");
		return restHrMasterDao.getDepartmentTypeForShiftType(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getSubDepartmentTypeForShiftType", method = { RequestMethod.GET })
	public List<DropDownModel> getSubDepartmentTypeForShiftType(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getSubDepartmentTypeForShiftType starts");

		logger.info("Method : getSubDepartmentTypeForShiftType end");
		return restHrMasterDao.getSubDepartmentTypeForShiftType(organization, orgDivision);
	}

	@RequestMapping(value = "rest-addnew-job-type", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddJobType(@RequestBody RestHrMasterModel restHrMasterModel) {
		logger.info("Method : restAddJobType starts");

		logger.info("Method : restAddJobType ends");
		return restHrMasterDao.addJobType(restHrMasterModel);
	}

	@RequestMapping(value = "viewJobType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewJobType(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewJobType starts");

		logger.info("Method : viewJobType ends");
		return restHrMasterDao.viewJobType(org, orgDiv);
	}

	@RequestMapping(value = "deleteJobType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJobType(@RequestParam String id) {
		logger.info("Method : deleteJobType starts");

		logger.info("Method : deleteJobType ends");
		return restHrMasterDao.deleteJobType(id);
	}

	/*
	 * post mapping for ADD WORK HOURs
	 */

	@RequestMapping(value = "rest-addnew-work-hour", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddWorkHour(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : restAddWorkHours starts");

		logger.info("Method : restAddWorkHours endss");
		return restHrMasterDao.addWorkHour(restHrWorkHour);
	}

	@RequestMapping(value = "rest-view-work-hour", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> restViewAllWorkHours(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : rest view work hour starts");

		logger.info("Method : rest view work hour ends");
		return restHrMasterDao.viewAllWorkHours(org, orgDiv);
	}

	@RequestMapping(value = "deleteWorkHour", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteWorkHour(@RequestParam String id) {
		logger.info("Method : rest deleteWorkHour starts");

		logger.info("Method : rest deleteWorkHour ends");
		return restHrMasterDao.deleteWorkHour(id);
	}

	/*
	 * post mapping for Education
	 */

	@RequestMapping(value = "addEducation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addEducation(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addEducation starts");

		logger.info("Method : addEducation endss");
		return restHrMasterDao.addEducation(restHrWorkHour);
	}

	@RequestMapping(value = "viewEducation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewEducation(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewEducation starts");

		logger.info("Method : viewEducationends");
		return restHrMasterDao.viewEducation(org, orgDiv);
	}

	@RequestMapping(value = "deleteEducation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteEducation(@RequestParam String id) {
		logger.info("Method : rest deleteEducation starts");

		logger.info("Method : rest deleteEducation ends");
		return restHrMasterDao.deleteEducation(id);
	}

	/*
	 * post mapping for Job Band
	 */

	@RequestMapping(value = "addJobBand", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addJobBand(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addJobBand starts");

		logger.info("Method : addJobBand endss");
		return restHrMasterDao.addJobBand(restHrWorkHour);
	}

	@RequestMapping(value = "viewJobBand", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewJobBand(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewJobBand starts");

		logger.info("Method : viewJobBand ends");
		return restHrMasterDao.viewJobBand(org, orgDiv);
	}

	@RequestMapping(value = "deleteJobBand", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJobBand(@RequestParam String id) {
		logger.info("Method : rest deleteJobBand starts");

		logger.info("Method : rest deleteJobBand ends");
		return restHrMasterDao.deleteJobBand(id);
	}

	/*
	 * post mapping for Job Band
	 */

	@RequestMapping(value = "addBenefits", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addBenefits(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addBenefits starts");

		logger.info("Method : addBenefits endss");
		return restHrMasterDao.addBenefits(restHrWorkHour);
	}

	@RequestMapping(value = "viewBenefits", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewBenefits(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewBenefits starts");

		logger.info("Method : viewBenefits ends");
		return restHrMasterDao.viewBenefits(org, orgDiv);
	}

	@RequestMapping(value = "deleteBenefits", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBenefits(@RequestParam String id) {
		logger.info("Method : rest deleteBenefits starts");

		logger.info("Method : rest deleteBenefits ends");
		return restHrMasterDao.deleteBenefits(id);
	}

	/*
	 * post mapping for Address Type
	 */

	@RequestMapping(value = "addAddress", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAddress(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addAddress starts");

		logger.info("Method : addAddress endss");
		return restHrMasterDao.addAddress(restHrWorkHour);
	}

	@RequestMapping(value = "viewAddress", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewAddress(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewAddress starts");

		logger.info("Method : viewAddress ends");
		return restHrMasterDao.viewAddress(org, orgDiv);
	}

	@RequestMapping(value = "deleteAddress", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAddress(@RequestParam String id) {
		logger.info("Method : rest deleteAddress starts");

		logger.info("Method : rest deleteAddress ends");
		return restHrMasterDao.deleteAddress(id);
	}

	/*
	 * post mapping for Blood Group Type
	 */

	@RequestMapping(value = "addBloodgroup", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addBloodgroup(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addBloodgroup starts");

		logger.info("Method : addBloodgroup endss");
		return restHrMasterDao.addBloodgroup(restHrWorkHour);
	}

	@RequestMapping(value = "viewBloodGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewBloodGroup(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewBloodGroup starts");

		logger.info("Method : viewBloodGroup ends");
		return restHrMasterDao.viewBloodGroup(org, orgDiv);
	}

	@RequestMapping(value = "deleteBloodGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBloodGroup(@RequestParam String id) {
		logger.info("Method : rest deleteBloodGroup starts");

		logger.info("Method : rest deleteBloodGroup ends");
		return restHrMasterDao.deleteBloodGroup(id);
	}

	/*
	 * post mapping for shift Type
	 */

	@RequestMapping(value = "rest-addnew-shift", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddShift(@RequestBody RestHrMasterModel restShift) {
		logger.info("Method : restAddShift starts");

		logger.info("Method : restAddShift endss");
		return restHrMasterDao.addShift(restShift);
	}

	@RequestMapping(value = "viewShift", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewShift(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewShift starts");

		logger.info("Method : viewShift ends");
		return restHrMasterDao.viewShift(org, orgDiv);
	}

	@RequestMapping(value = "deleteshift", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteShift(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest deleteShift starts");

		logger.info("Method : rest deleteShift ends");
		return restHrMasterDao.deleteShift(id,org,orgDiv);
	}

	/*
	 * post mapping for Marital Type
	 */

	@RequestMapping(value = "addMarital", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addMarital(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addMarital starts");

		logger.info("Method : addMarital endss");
		return restHrMasterDao.addMarital(restHrWorkHour);
	}

	@RequestMapping(value = "viewMarital", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewMarital(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewMarital starts");

		logger.info("Method : viewMarital ends");
		return restHrMasterDao.viewMarital(org, orgDiv);
	}

	@RequestMapping(value = "deleteMarital", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteMarital(@RequestParam String id) {
		logger.info("Method : rest deleteMarital starts");

		logger.info("Method : rest deleteMarital ends");
		return restHrMasterDao.deleteMarital(id);
	}

	/*
	 * post mapping for Document Type
	 */

	@RequestMapping(value = "addDocument", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDocument(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addDocument starts");

		logger.info("Method : addDocument endss");
		return restHrMasterDao.addDocument(restHrWorkHour);
	}

	@RequestMapping(value = "viewDocument", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDocument(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewDocument starts");

		logger.info("Method : viewDocument ends");
		return restHrMasterDao.viewDocument(org, orgDiv);
	}

	@RequestMapping(value = "deleteDocument", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDocument(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest deleteDocument starts");

		logger.info("Method : rest deleteDocument ends");
		return restHrMasterDao.deleteDocument(id,org,orgDiv);
	}

	/*
	 * post mapping for Document Type
	 */

	@RequestMapping(value = "addTimeSheet", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addTimeSheet(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addTimeSheet starts");

		logger.info("Method : addTimeSheet endss");
		return restHrMasterDao.addTimeSheet(restHrWorkHour);
	}

	@RequestMapping(value = "viewTimeSheet", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewTimeSheet(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewTimeSheet starts");

		logger.info("Method : viewTimeSheet ends");
		return restHrMasterDao.viewTimeSheet(org, orgDiv);
	}

	@RequestMapping(value = "deleteTimeSheet", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTimeSheet(@RequestParam String id) {
		logger.info("Method : rest deleteTimeSheet starts");

		logger.info("Method : rest deleteTimeSheet ends");
		return restHrMasterDao.deleteTimeSheet(id);
	}

	/*
	 * post mapping for Document Type
	 */

	@RequestMapping(value = "addEmpStatus", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addEmpStatus(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addEmpStatus starts");

		logger.info("Method : addEmpStatus endss");
		return restHrMasterDao.addEmpStatus(restHrWorkHour);
	}

	@RequestMapping(value = "viewEmpStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewEmpStatus(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewEmpStatus starts");

		logger.info("Method : viewEmpStatus ends");
		return restHrMasterDao.viewEmpStatus(org, orgDiv);
	}

	@RequestMapping(value = "deleteEmpStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteEmpStatus(@RequestParam String id) {
		logger.info("Method : rest deleteEmpStatus starts");

		logger.info("Method : rest deleteEmpStatus ends");
		return restHrMasterDao.deleteEmpStatus(id);
	}

	/*
	 * post mapping for Project Type
	 */

	@RequestMapping(value = "addprojectType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addprojectType(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addprojectType starts");

		logger.info("Method : addprojectType endss");
		return restHrMasterDao.addprojectType(restHrWorkHour);
	}

	@RequestMapping(value = "viewprojectType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewprojectType(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewprojectType starts");

		logger.info("Method : viewprojectType ends");
		return restHrMasterDao.viewprojectType(org, orgDiv);
	}

	@RequestMapping(value = "deleteprojectType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteprojectType(@RequestParam String id) {
		logger.info("Method : rest deleteprojectType starts");

		logger.info("Method : rest deleteprojectType ends");
		return restHrMasterDao.deleteprojectType(id);
	}

	/*
	 * priority Type
	 */

	@RequestMapping(value = "addPriority", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPriority(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addPriority starts");

		logger.info("Method : addPriority endss");
		return restHrMasterDao.addPriority(restHrWorkHour);
	}

	@RequestMapping(value = "viewPriority", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewPriority(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewPriority starts");

		logger.info("Method : viewPriority ends");
		return restHrMasterDao.viewPriority(org, orgDiv);
	}

	@RequestMapping(value = "deletePriority", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePriority(@RequestParam String id) {
		logger.info("Method : rest deletePriority starts");

		logger.info("Method : rest deletePriority ends");
		return restHrMasterDao.deletePriority(id);
	}

	/*
	 * Gender Type
	 */

	@RequestMapping(value = "addGender", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addGender(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addGender starts");

		logger.info("Method : addGender endss");
		return restHrMasterDao.addGender(restHrWorkHour);
	}

	@RequestMapping(value = "viewGender", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewGender(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewGender starts");

		logger.info("Method : viewGender ends");
		return restHrMasterDao.viewGender(org, orgDiv);
	}

	@RequestMapping(value = "deleteGender", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGender(@RequestParam String id) {
		logger.info("Method : rest deleteGender starts");

		logger.info("Method : rest deleteGender ends");
		return restHrMasterDao.deleteGender(id);
	}

	/*
	 * Dependent Relationship Type
	 */

	@RequestMapping(value = "addDepRelationship", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDepRelationship(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addDepRelationship starts");

		logger.info("Method : addDepRelationship endss");
		return restHrMasterDao.addDepRelationship(restHrWorkHour);
	}

	@RequestMapping(value = "viewDepRelationship", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDepRelationship(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewDepRelationship starts");

		logger.info("Method : viewDepRelationship ends");
		return restHrMasterDao.viewDepRelationship(org, orgDiv);
	}

	@RequestMapping(value = "deleteDepRelationship", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDepRelationship(@RequestParam String id) {
		logger.info("Method : rest deleteDepRelationship starts");

		logger.info("Method : rest deleteDepRelationship ends");
		return restHrMasterDao.deleteDepRelationship(id);
	}

	/*
	 * Employee Insurance Company
	 */

	@RequestMapping(value = "addInsuranceCompany", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addInsuranceCompany(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method :rest addInsuranceCompany starts");

		logger.info("Method :rest addInsuranceCompany endss");
		return restHrMasterDao.addInsuranceCompany(restHrWorkHour);
	}

	@RequestMapping(value = "viewInsuranceCompany", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewInsuranceCompany(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :rest viewInsuranceCompany starts");

		logger.info("Method :rest viewInsuranceCompany ends");
		return restHrMasterDao.viewInsuranceCompany(org, orgDiv);
	}

	@RequestMapping(value = "deleteInsuranceCompany", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteInsuranceCompany(@RequestParam String id) {
		logger.info("Method : rest deleteInsuranceCompany starts");

		logger.info("Method : rest deleteInsuranceCompany ends");
		return restHrMasterDao.deleteInsuranceCompany(id);
	}

	/*
	 *
	 * Employee Dependent Type
	 */

	@RequestMapping(value = "addDependentType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDependentType(@RequestBody RestHrMasterModel restHrWorkHour) {
		logger.info("Method : addDependentType starts");

		logger.info("Method : addDependentType endss");
		return restHrMasterDao.addDependentType(restHrWorkHour);
	}

	@RequestMapping(value = "viewDependentType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDependentType(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewDependentType starts");

		logger.info("Method : viewDependentType ends");
		return restHrMasterDao.viewDependentType(org, orgDiv);
	}

	@RequestMapping(value = "deleteDependentType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDependentType(@RequestParam String id) {
		logger.info("Method : rest deleteDependentType starts");

		logger.info("Method : rest deleteDependentType ends");
		return restHrMasterDao.deleteDependentType(id);
	}

	/*
	 * Designation
	 */

	@RequestMapping(value = "rest-addDesignationMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDesignationMaster(@RequestBody RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addDesignationMaster starts");

		logger.info("Method : addDesignationMaster ends");
		return restHrMasterDao.addDesignationMasterDao(restHrMasterModel);
	}

	@RequestMapping(value = "rest-viewDesignationDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDesignationDetails(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :rest viewDesignationDetails starts");

		logger.info("Method :rest viewDesignationDetails ends");
		return restHrMasterDao.viewDesignationDao(org, orgDiv);
	}

	@RequestMapping(value = "rest-deleteDesignationMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDesignation(@RequestParam String id, @RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method : rest deleteDesignation starts");

		logger.info("Method : rest deleteDesignation ends");
		return restHrMasterDao.deleteDesignationDao(id,orgName,orgDiv);
	}

	// *****************************8Department*************************888
	@RequestMapping(value = "rest-addDepartmentMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDepartmentMaster(@RequestBody RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addDepartmentMaster starts");

		logger.info("Method : addDepartmentMaster ends");
		return restHrMasterDao.addDepartmentMasterDao(restHrMasterModel);
	}

	@RequestMapping(value = "rest-viewDepartmentDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDepartmentDetails(@RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :rest viewDepartmentDetails starts");

		logger.info("Method :rest viewDepartmentDetails ends");
		return restHrMasterDao.viewDepartmentDetails(orgName, orgDiv);
	}

	@RequestMapping(value = "rest-deleteDepartment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDepartment(@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDiv) {
		logger.info("Method : rest deleteDepartment starts");

		logger.info("Method : rest deleteDepartment ends");
		return restHrMasterDao.deleteDepartment(id,orgName,orgDiv);
	}

	@RequestMapping(value = "rest-addSubDepartmentMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addSubDepartmentMaster(
			@RequestBody RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addSubDepartmentMaster starts");

		logger.info("Method : addSubDepartmentMaster ends");
		return restHrMasterDao.addSubDepartmentMaster(restHrMasterModel);
	}

	@RequestMapping(value = "rest-viewSubDepartmentDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewSubDepartmentDetails(@RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :rest viewSubDepartmentDetails starts");

		logger.info("Method :rest viewSubDepartmentDetails ends");
		return restHrMasterDao.viewSubDepartmentDetails(orgName, orgDiv);
	}

	@RequestMapping(value = "rest-deleteSubDepartment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSubDepartment(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : rest deleteSubDepartment starts");

		logger.info("Method : rest deleteSubDepartment ends");
		return restHrMasterDao.deleteSubDepartment(id,org,orgDiv);
	}
	// get shiftSubDepartment

	@GetMapping(value = "get-shiftSubDepartment")
	public JsonResponse<List<DropDownModel>> getshiftSubDepartment(@RequestParam String shiftDeptId,String orgName,String orgDivision) {
		logger.info("Method : getshiftSubDepartment starts");

		logger.info("Method : getshiftSubDepartment ends");
		return restHrMasterDao.getshiftSubDepartment(shiftDeptId,orgName,orgDivision);
	}
	
	//  getSubDeptTypeList

	@GetMapping(value = "get-getSubDeptTypeList")
	public JsonResponse<List<DropDownModel>> getSubDeptTypeList(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getSubDeptTypeList starts");

		logger.info("Method : getSubDeptTypeList ends");
		return restHrMasterDao.getSubDeptTypeList(orgName,orgDivision);
	}

}
