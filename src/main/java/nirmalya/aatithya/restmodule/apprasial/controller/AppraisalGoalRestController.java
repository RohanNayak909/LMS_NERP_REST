package nirmalya.aatithya.restmodule.apprasial.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.apprasial.dao.AppraisalGoalRestDao;
import nirmalya.aatithya.restmodule.apprasial.model.AppraisalGoalRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = { "appraisal/" })
public class AppraisalGoalRestController {

	Logger logger = LoggerFactory.getLogger(AppraisalGoalRestController.class);

	@Autowired
	AppraisalGoalRestDao apprasialDao;

	@RequestMapping(value = "rest-save-goal", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveGoal(@RequestBody AppraisalGoalRestModel goalModel) {
		logger.info("Method : saveGoal starts");

		logger.info("Method : saveGoal ends");
		return apprasialDao.saveGoal(goalModel);
	}

	/* rest-get-all-goal */
	@RequestMapping(value = "rest-get-all-goal", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllGoal(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getAllGoal start");
		logger.info("Method :getAllGoal endss");
		return apprasialDao.getAllGoal(orgName, orgDivision);
	}

	/* rest-appraisal-kra-details */
	@PostMapping(value = "rest-appraisal-kra-details")
	public ResponseEntity<JsonResponse<Object>> saveApppraisalKraDetails(@RequestBody String appraisalData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveApppraisalKraDetails starts");
		logger.info("Method :saveApppraisalKraDetails endss");
		return apprasialDao.saveAppraisalKraDetails(appraisalData, userId, org, orgDiv);
	}

	/* rest-get-all-goal-details */
	@RequestMapping(value = "rest-get-all-goal-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllGoalDetails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :getAllGoalDetails start");
		logger.info("Method :getAllGoalDetails endss");
		return apprasialDao.getAllGoalDetails(orgName, orgDivision, id);
	}

	@RequestMapping(value = "departmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {
		logger.info("Method : getDepartmentList starts");

		logger.info("Method : getDepartmentList ends");
		return apprasialDao.getDepartmentList();
	}

	@RequestMapping(value = "orgGoalList", method = { RequestMethod.GET })
	public List<DropDownModel> getOrgGoalList() {
		logger.info("Method : getOrgGoalList starts");

		logger.info("Method : getOrgGoalList ends");
		return apprasialDao.getOrgGoalList();
	}

	/* rest-save-dep-goal */
	@RequestMapping(value = "rest-save-dep-goal", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveDepGoal(@RequestBody AppraisalGoalRestModel goalModel) {
		logger.info("Method : saveDepGoal starts");

		logger.info("Method : saveDepGoal ends");
		return apprasialDao.saveDepGoal(goalModel);
	}

	/* rest-get-all-dep-goal */

	@RequestMapping(value = "rest-get-all-dep-goal", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllDepGoal(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getAllDepGoal start");
		logger.info("Method :getAllDepGoal endss");
		return apprasialDao.getAllDepGoal(orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-appraisal-dep-kra-details")
	public ResponseEntity<JsonResponse<Object>> saveDepKraDetails(@RequestBody String deptAppraisalData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveDepKraDetails starts");
		logger.info("Method :saveDepKraDetails endss");
		return apprasialDao.saveDepKraDetails(deptAppraisalData, userId, org, orgDiv);
	}
	
	/* get-all-dep-goal-details*/
	@RequestMapping(value = "get-all-dep-goal-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllDepGoalDetails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :getAllDepGoalDetails start");
		logger.info("Method :getAllDepGoalDetails endss");
		return apprasialDao.getAllDepGoalDetails(orgName, orgDivision, id);
	}
	
	/* depGoalList */
	@RequestMapping(value = "depGoalList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepGoalList() {
		logger.info("Method : getDepGoalList starts");

		logger.info("Method : getDepGoalList ends");
		return apprasialDao.getDepGoalList();
	}
	
	/* designationList */
	
	@RequestMapping(value = "designationList", method = { RequestMethod.GET })
	public List<DropDownModel> getDesignationList() {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return apprasialDao.getDesignationList();
	}
	
	/* rest-get-all-dep-goal-details */
  
	@RequestMapping(value = "rest-get-all-dep-goal-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getDepartmentGoalDetails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :getDepartmentGoalDetails start");
		logger.info("Method :getDepartmentGoalDetails endss");
		return apprasialDao.getDepartmentGoalDetails(orgName, orgDivision, id);
	}
	
	/* rest-save-desig-goal */
	@RequestMapping(value = "rest-save-desig-goal", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveDesigGoal(@RequestBody AppraisalGoalRestModel goalModel) {
		logger.info("Method : saveDesigGoal starts");

		logger.info("Method : saveDesigGoal ends");
		return apprasialDao.saveDesigGoal(goalModel);
	}

	/* rest-get-all-desig-goal */
	@RequestMapping(value = "rest-get-all-desig-goal", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllDesigGoal(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getAllDesigGoal start");
		logger.info("Method :getAllDesigGoal endss");
		return apprasialDao.getAllDesigGoal(orgName, orgDivision);
	}
	
	/* rest-appraisal-desig-kra-details */
	
	@PostMapping(value = "rest-appraisal-desig-kra-details")
	public ResponseEntity<JsonResponse<Object>> saveApppraisalDesigKraDetails(@RequestBody String desigAppraisalData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveApppraisalDesigKraDetails starts");
		logger.info("Method :saveApppraisalDesigKraDetails endss");
		return apprasialDao.saveApppraisalDesigKraDetails(desigAppraisalData, userId, org, orgDiv);
	}

	/* get-all-desig-goal-details */
	@RequestMapping(value = "get-all-desig-goal-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllDesigGoalDetails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :getAllDesigGoalDetails start");
		logger.info("Method :getAllDesigGoalDetails endss");
		return apprasialDao.getAllDesigGoalDetails(orgName, orgDivision, id);
	}
}
