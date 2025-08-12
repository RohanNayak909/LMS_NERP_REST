package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestAdvanceManagementDao;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;

@RestController
@RequestMapping(value = "master/")
public class RestAdvanceManagementController {
	Logger logger = LoggerFactory.getLogger(RestAdvanceManagementController.class);

	@Autowired
	RestAdvanceManagementDao restAdvanceManagementDao;

	@GetMapping(value = "get-advance-policy-list")
	public List<DropDownModel> getAdvancePolicyList(@RequestParam String userId, String org, String orgDiv) {
		logger.info("Method : getAdvancePolicyList starts");

		logger.info("Method : getAdvancePolicyList ends");
		return restAdvanceManagementDao.getAdvancePolicyList(userId,org,orgDiv);
	}

	@GetMapping(value = "get-advance-policy-list-api")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAdvancePolicyListApi(@RequestParam String userId) {
		logger.info("Method : getAdvancePolicyListApi starts");

		logger.info("Method : getAdvancePolicyListApi ends");
		return restAdvanceManagementDao.getAdvancePolicyListApi(userId);
	}
	
	
	//dropdown Employee List
	
	@GetMapping(value = "getEmplistsForAdvanceManagement")
	public List<DropDownModel> employeeList(@RequestParam String userId,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : employeeList starts");

		logger.info("Method : employeeList ends");
		return restAdvanceManagementDao.employeeList(userId,organization,orgDivision);
	}

	
	/**
	 * Rest Controller - Get getPolicyDetails
	 *
	 */
	@GetMapping(value = "rest-getPolicyDetails")
	public ResponseEntity<JsonResponse<DropDownModel>> getPolicyDetails(@RequestParam String reqPolicyId) {
		logger.info("Method : getPolicyDetails starts");

		logger.info("Method : getPolicyDetails ends");
		return restAdvanceManagementDao.getPolicyDetails(reqPolicyId);
	}

	// add Advance apply
	@PostMapping(value="saveAdvanceDetailsApply")
	public ResponseEntity<JsonResponse<Object>> saveAdvanceDetailsApply(@RequestBody RestAdvanceManagementModel advance){
		logger.info("Method : saveAdvanceDetailsApply starts");
		
		logger.info("Method : saveAdvanceDetailsApply ends");
		return restAdvanceManagementDao.saveAdvanceDetailsApply(advance);
	}
 

	
	// view Advance apply

		@PostMapping(value = "viewAdvanceApply")
		public JsonResponse<List<RestAdvanceManagementModel>> viewAdvanceApply(@RequestBody EmpRoleModel empModel) {
			logger.info("Method : viewAdvanceApply starts");

			System.err.println("empModel======="+empModel);
			String userId = empModel.getUserId();
			String organization=empModel.getOrganization(); 
			String orgDivision=empModel.getOrgDivision();
			List<String> roleList = empModel.getUserRole();
			String userRole = "";
			if(roleList.size() > 0) {
				for(String m : roleList) {
					if(empModel.getType().equals("WEB")) {
						userRole = userRole + m + ",";
					} else {
						userRole = userRole +"\"" + m + "\",";
					}
				}
			}
			if(userRole != null && userRole != "") {
				userRole = userRole.substring(0, userRole.length() - 1);
			}
			logger.info("User Id = "+userId+ " *** userRole====="+userRole);
			logger.info("Method : viewAdvanceApply ends");
			return restAdvanceManagementDao.viewAdvanceApply(userId, userRole,organization,orgDivision,empModel.getSelfType());
		}
	
	
	/*
	 *
	 * Edit Advance rest
	 *
	 */
	@RequestMapping(value = "editAdvanceApply", method = { RequestMethod.GET })
	public JsonResponse<RestAdvanceManagementModel> editAdvanceApply(@RequestParam String id) {
		logger.info("Method : editAdvanceApply rest starts"+id);

		logger.info("Method :editAdvanceApply rest ends");
		return restAdvanceManagementDao.editAdvanceApply(id);
	}
	
	/*
	 *
	 * Delete Advance rest
	 *
	 */
	/*
	 * @GetMapping(value = "deleteAdvanceApply") public
	 * JsonResponse<RestAdvanceManagementModel> deleteAdvanceApply(@RequestParam
	 * String id) { logger.info("Method : Delete deleteAdvanceApply rest starts");
	 * 
	 * logger.info("Method :Delete deleteAdvanceApply rest ends"); return
	 * restAdvanceManagementDao.deleteAdvanceApply(id); }
	 */
 
	
	
	@PostMapping(value = "deleteAdvanceApply")
	public JsonResponse<RestAdvanceManagementModel> deleteReimbursement(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : deleteAdvanceApply rest starts");

		List<String> roleList = empModel.getUserRole();
		
		String deleteId = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					deleteId = deleteId + m + ",";
				} else {
					deleteId = deleteId +"\"" + m + "\",";
				}
			}
		}
		
		if(deleteId != null && deleteId != "") {
			deleteId = deleteId.substring(0, deleteId.length() - 1);
		}
		
		
		logger.info("Method :Delete Reimbursement rest ends");
		return restAdvanceManagementDao.deleteAdvanceApply(deleteId);
	}
	

	// approve advance details

	@GetMapping(value = "approveAdvanceApply")
	public JsonResponse<RestAdvanceManagementModel> approveAdvanceApply(@RequestParam String id, String name, String comment,String roleid) {
		logger.info("Method : approveAdvanceApply starts");

		logger.info("Method : approveAdvanceApply ends");
		return restAdvanceManagementDao.approveAdvanceApply(id, name, comment,roleid);
	}
	//approve advance details api
	@PostMapping(value="approveAdvanceApply-api")
	public JsonResponse<RestAdvanceManagementModel> approveAdvanceApplyApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : approveAdvanceApplyApi starts");
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		logger.info("User Id = "+id+ " *** userRole====="+userRole);
		logger.info("Method : approveAdvanceApplyApi ends");
		return restAdvanceManagementDao.approveAdvanceApply(id, name, comment,userRole);
	}
	// reject advance

	@GetMapping(value = "rejectAdvanceApply")
	public JsonResponse<RestAdvanceManagementModel> rejectAdvanceApply(@RequestParam String id, String name, String comment) {
		logger.info("Method : rejectAdvanceApply starts");

		logger.info("Method : rejectAdvanceApply ends");
		return restAdvanceManagementDao.rejectAdvanceApply(id, name, comment);
	}
	//reject advance details api
	@PostMapping(value="rejectAdvanceApply-api")
	public JsonResponse<RestAdvanceManagementModel> rejectAdvanceApplyApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : rejectAdvanceApplyApi starts");
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		logger.info("User Id = "+id+ " *** userRole====="+userRole);
		logger.info("Method : rejectAdvanceApplyApi ends");
		return restAdvanceManagementDao.rejectAdvanceApply(id, name, comment);
	}
	// view Advance apply

	@GetMapping(value = "viewAdvanceProcess")
	public ResponseEntity<JsonResponse<List<RestAdvanceManagementModel>>> viewAdvanceProcess(@RequestParam String advanceId) {
		logger.info("Method : viewAdvanceProcess starts");

		logger.info("Method : viewAdvanceProcess ends");
		return restAdvanceManagementDao.viewAdvanceProcess(advanceId);
	}
	// add Advance Process Approve
	@PostMapping(value="saveAdvanceProcessApprove")
	public ResponseEntity<JsonResponse<Object>> saveAdvanceProcessApprove(@RequestBody RestAdvanceManagementModel advance){
		logger.info("Method : saveAdvanceProcessApprove starts");
		
		logger.info("Method : saveAdvanceProcessApprove ends");
		return restAdvanceManagementDao.saveAdvanceProcessApprove(advance);
	}
	// view Emi details

	@GetMapping(value = "viewEmiDetails")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> viewEmiDetails(@RequestParam String advanceId,@RequestParam String empId) {
		logger.info("Method : viewEmiDetails starts");

		logger.info("Method : viewEmiDetails ends");
		return restAdvanceManagementDao.viewEmiDetails(advanceId,empId);
	}
	@GetMapping(value = "viewEmiDetailss")
	public ResponseEntity<JsonResponse<List<RestAdvanceManagementModel>>> viewEmiDetailss(@RequestParam String advanceId,@RequestParam String empId) {
		logger.info("Method : viewEmiDetailss starts");

		logger.info("Method : viewEmiDetailss ends");
		return restAdvanceManagementDao.viewEmiDetailss(advanceId,empId);
	}
	
	// view Advance apply api
	@GetMapping(value = "viewAdvanceApply-api")
	public JsonResponse<List<RestAdvanceManagementModel>> viewAdvanceApplyApi(@RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewAdvanceApplyApi starts");

		logger.info("Method : viewAdvanceApplyApi ends");
		return restAdvanceManagementDao.viewAdvanceApplyApi(userId,organization,orgDivision);
	}
	//Edit Emi
	@RequestMapping(value = "editEmiData", method = { RequestMethod.GET })
	public JsonResponse<Object> editEmiData(@RequestParam String id,String date, String orgName, String orgDivision) {
		logger.info("Method :editEmiData start");

		logger.info("Method :editEmiData endss");
		return restAdvanceManagementDao.editEmiData(id,date, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-modifyemi", method = { RequestMethod.GET })
	public JsonResponse<Object> modifyemi(@RequestParam String advanceId,String dueDate,String dueDateNew,String empId, String org,String orgDiv) {
		logger.info("Method :modifyemi start");

		logger.info("Method :modifyemi endss");
		return restAdvanceManagementDao.modifyemi(advanceId,dueDate,dueDateNew,empId,org, orgDiv);
	}
	
	
	// add Advance Process Approve
		@PostMapping(value="saveAdvanceEMI")
		public ResponseEntity<JsonResponse<Object>> saveAdvanceEMI(@RequestBody List<RestAdvanceManagementModel> advance){
			logger.info("Method : saveAdvanceEMI starts");
			System.err.println("advance==="+advance);
;			logger.info("Method : saveAdvanceEMI ends");
			return restAdvanceManagementDao.saveAdvanceEMI(advance);
		}
}
