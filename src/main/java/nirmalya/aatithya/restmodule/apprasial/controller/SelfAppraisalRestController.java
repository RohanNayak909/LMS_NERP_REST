package nirmalya.aatithya.restmodule.apprasial.controller;

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

import nirmalya.aatithya.restmodule.apprasial.dao.SelfAppraisalRestDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = { "appraisal/" })
public class SelfAppraisalRestController {

	Logger logger = LoggerFactory.getLogger(SelfAppraisalRestController.class);

	
 @Autowired
  SelfAppraisalRestDao appraisalRestDao;
 
	/* rest-get-all-employee */
 @RequestMapping(value = "rest-get-all-employee", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllEmployee(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String id,@RequestParam String finYear) {
		logger.info("Method :getAllEmployee start");
		logger.info("Method :getAllEmployee endss");
		return appraisalRestDao.getAllEmployee(orgName, orgDivision,id,finYear);
	}
	/*rest-all-desig-goal-list*/
	@RequestMapping(value = "rest-all-desig-goal-list", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllDesigGoalDLists(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :getAllDesigGoalDLists start");
		logger.info("Method :getAllDesigGoalDLists endss");
		return appraisalRestDao.getAllDesigGoalDLists(orgName, orgDivision, id);
	}
	
	/* rest-all-desig-goal-details */
	@RequestMapping(value = "rest-all-desig-goal-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllDesigGoalDetails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id,@RequestParam String empId,@RequestParam String finYear) {
		logger.info("Method :getAllDesigGoalDetails start");
		logger.info("Method :getAllDesigGoalDetails endss");
		return appraisalRestDao.getAllDesigGoalDetails(orgName, orgDivision, id,empId,finYear);
	}
	
	/* rest-save-self-appraisal-goal */
	@PostMapping(value = "rest-save-self-appraisal-goal")
	public ResponseEntity<JsonResponse<Object>> saveSelfAppraisal(@RequestBody String depGoalData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveSelfAppraisal starts");
		logger.info("Method :saveDepKraDetails endss");
		return appraisalRestDao.saveSelfAppraisal(depGoalData, userId, org, orgDiv);
	}
	/* rest-all-desig-goal-by-emp */
	@RequestMapping(value = "rest-all-desig-goal-by-emp", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllDesigGoalByEMpId(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id,@RequestParam String empId,@RequestParam String finYear) {
		logger.info("Method :getAllDesigGoalByEMpId start");
		logger.info("Method :getAllDesigGoalByEMpId endss");
		return appraisalRestDao.getAllDesigGoalByEMpId(orgName, orgDivision, id,empId,finYear);
	}
	
	@GetMapping(value = "rest-all-employee-list-auto")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> autoSearchEmployeeList(@RequestParam String id) {
		logger.info("Method : autoSearchEmployeeList starts");

		logger.info("Method :autoSearchEmployeeList endss");
		return appraisalRestDao.autoSearchEmployeeList(id);
	}

}
