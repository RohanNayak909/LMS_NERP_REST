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
import nirmalya.aatithya.restmodule.master.dao.LeaveApplyDao;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;

@RestController
@RequestMapping(value = "master/")
public class LeaveApplyRestController {
Logger logger = LoggerFactory.getLogger(LeaveApplyRestController.class);
	
	@Autowired
	LeaveApplyDao leaveApplyDao;
	
	// view leave apply new

		@GetMapping(value = "viewLeaveApplynew")
		public JsonResponse<List<LeaveApplyRestModel>> viewLeaveApplynew(@RequestParam String userid, String org, String orgDiv) {
			logger.info("Method : viewLeaveApplynew starts");

			logger.info("Method : viewLeaveApplynew ends");
			return leaveApplyDao.viewLeaveApplynew(userid,org,orgDiv);
		}
		
		@GetMapping(value = "editLeaveApplynew")
		public JsonResponse<List<LeaveApplyRestModel>> editLeaveApplynew(@RequestParam String userid, @RequestParam String leaveId) {
			logger.info("Method : editLeaveApplynew starts "+leaveId);

			logger.info("Method : editLeaveApplynew ends");
			return leaveApplyDao.editLeaveApplynew(userid,leaveId);
		}
	
	//view leave apply
	
		@PostMapping(value="viewleaveapply")
		public JsonResponse<List<LeaveApplyRestModel>> viewLeaveApply(@RequestBody EmpRoleModel empModel){
			logger.info("Method : viewLeaveApply starts");
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
			logger.info("Method : viewLeaveApply ends");
			return leaveApplyDao.viewLeaveApply(userId,userRole,organization,orgDivision,empModel.getSelfType());
		}
		

	
	
	//dropdown for leave type
	
	@GetMapping(value = "getleavelists")
	public List<DropDownModel> leaveTypeList(@RequestParam String userId,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : leaveTypeList starts");

		logger.info("Method : leaveTypeList ends");
		return leaveApplyDao.leaveTypeList(userId,organization,orgDivision);
	}
	
	//dropdown Employee List
	
	@GetMapping(value = "getEmplists")
	public List<DropDownModel> employeeList(@RequestParam String userId,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : employeeList starts");

		logger.info("Method : employeeList ends");
		return leaveApplyDao.employeeList(userId,organization,orgDivision);
	}

	
	//add leave apply
	
	@PostMapping(value = "saveleaveapply")
	public ResponseEntity<JsonResponse<List<LeaveApplyRestModel>>> addLeaveApply(
			@RequestBody List<LeaveApplyRestModel> leave) {
		logger.info("Method : addLeaveApply starts");
		
		
		logger.info("Method : addLeaveApply ends");
		return leaveApplyDao.addLeaveApply(leave);
	}
	
	//edit leave apply
	
	@GetMapping(value="editleaveapply")
	public JsonResponse<List<LeaveApplyRestModel>> editLeaveApply(@RequestParam String id){
		logger.info("Method : editLeaveApply starts");
		
		logger.info("Method : editLeaveApply ends");
		return leaveApplyDao.editLeaveApply(id);
	}
	
 
	 //delete leave details
 
	@RequestMapping(value = "deleteleaveapply", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteLeaveApply(@RequestParam String leaveId,String organization,String orgDivision) {
		logger.info("Method : deleteLeaveApply starts");

		logger.info("Method : deleteLeaveApply ends");
		return leaveApplyDao.deleteLeaveApply(leaveId,organization,orgDivision);
	}
	//approve leave details
	
	@GetMapping(value="approveleaveapply")
	public JsonResponse<LeaveApplyRestModel> approveLeaveApply(@RequestParam String id,String name,String comment,String userRole,String dateid){
		logger.info("Method : approveLeaveApply starts");
		
		logger.info("Method : approveLeaveApply ends");
		return leaveApplyDao.approveLeaveApply(id,name,comment,userRole,dateid);
	}
	//approve leave details api
	@PostMapping(value="approveleaveapply-api")
	public JsonResponse<LeaveApplyRestModel> approveleaveapplyApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : approveleaveapplyApi starts");
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		String dataid=empModel.getDateid();
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
		logger.info("Method : approveleaveapplyApi ends");
		return leaveApplyDao.approveLeaveApply(id,name,comment,userRole,dataid);
	}
	//reject leave
	
	@GetMapping(value="rejectleaveapply")
	public JsonResponse<LeaveApplyRestModel> rejectLeaveApply(@RequestParam String id,String name,String comment){
		logger.info("Method : rejectLeaveApply starts");
		
		logger.info("Method : rejectLeaveApply ends");
		return leaveApplyDao.rejectLeaveApply(id,name,comment);
	}
	//reject leave details api
	@PostMapping(value="rejectleaveapply-api")
	public JsonResponse<LeaveApplyRestModel> rejectleaveapplyApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : rejectleaveapplyApi starts");
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
		logger.info("Method : rejectleaveapplyApi ends");
		return leaveApplyDao.rejectLeaveApply(id,name,comment);
	}
	// Leave list dropdown for mobile
	@RequestMapping(value = "getleavelistsApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> leaveTypeListApi(@RequestParam String empId,String organization,String orgDivision) {
		logger.info("Method : leaveTypeListApi starts");

		logger.info("Method : leaveTypeListApi ends");
		return leaveApplyDao.leaveTypeListApiDao(empId,organization,orgDivision);
	}
	//view leave apply api
	@RequestMapping(value = "viewleaveapply-api", method = { RequestMethod.GET })
	public JsonResponse<List<LeaveApplyRestModel>> viewLeaveApplyApi(@RequestParam String userId,String organization,String orgDivision){
		logger.info("Method : viewLeaveApplyApi starts");
 
		
	logger.info("Method : viewLeaveApplyApi ends");
	return leaveApplyDao.viewLeaveApplyApi(userId,organization,orgDivision);
	}
	
	@RequestMapping(value = "rest-leave-apply-approve-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getLeaveApproveDates(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getLeaveApproveDates start");

		logger.info("Method :getLeaveApproveDates endss");
		return leaveApplyDao.getLeaveApproveDates(id, orgName, orgDivision);
	}
}
