package nirmalya.aatithya.restmodule.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.api.dao.ApprovalDao;
import nirmalya.aatithya.restmodule.api.model.ApprovalModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;

@RestController
@RequestMapping(value = "api")
public class ApprovalController {
	Logger logger = LoggerFactory.getLogger(ApprovalController.class);
	
	@Autowired
	ApprovalDao approvalDao;
	
	@PostMapping(value="viewApproval")
	public JsonResponse<List<ApprovalModel>> viewApproval(@RequestBody EmpRoleModel empModel){
		logger.info("Method : viewApproval starts");
		
		String userId = empModel.getUserId();
		String requistionName = empModel.getRequisitionName();
		List<String> roleList = empModel.getUserRole();
		
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					logger.info("inside==="+m);
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		
		logger.info("User Id = "+userId+ " *** userRole====="+userRole);
		
		logger.info("Method : viewApproval ends");
		return approvalDao.viewApproval(userId ,userRole,requistionName);
	}
	
	@RequestMapping(value = "approvedApproval", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ApprovalModel>> approvedApproval(
			@RequestBody ApprovalModel approvalModel) {
		logger.info("Method : approvedApproval starts");

		logger.info("Method : approvedApproval ends");
		return approvalDao.approvedApproval(approvalModel);
	}
	
	@RequestMapping(value = "rejectedApproval", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ApprovalModel>> rejectedApproval(
			@RequestBody ApprovalModel approvalModel) {
		logger.info("Method : rejectedApproval starts");

		logger.info("Method : rejectedApproval ends");
		return approvalDao.rejectedApproval(approvalModel);
	}
	
}
