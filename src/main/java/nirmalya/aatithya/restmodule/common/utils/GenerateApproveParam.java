package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.api.model.ApprovalModel;

public class GenerateApproveParam {

	
	public static String generateApproveParam(ApprovalModel approvalModel) {

		String s = "";

		if (approvalModel.getRequisitionId() != null
				&& approvalModel.getRequisitionId() != "") {
			s = s + "@p_requisitionId='" + approvalModel.getRequisitionId() + "',";
		}
		if (approvalModel.getRequisitionName() != null
				&& approvalModel.getRequisitionName() != "") {
			s = s + "@p_requisitionName='" + approvalModel.getRequisitionName() + "',";
		}
		if (approvalModel.getApprovedBy() != null
				&& approvalModel.getApprovedBy() != "") {
			s = s + "@p_approveBy='" + approvalModel.getApprovedBy() + "',";
		}
		if (approvalModel.getRejectedBy() != null
				&& approvalModel.getRejectedBy() != "") {
			s = s + "@p_rejectBy='" + approvalModel.getRejectedBy() + "',";
		}
		if (approvalModel.getComment() != null
				&& approvalModel.getComment() != "") {
			s = s + "@p_comment='" + approvalModel.getComment() + "',";
		}
		String litem="";
		List<String> userrole = approvalModel.getUserRole();
		for (String a : userrole) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_userRole='" + litem + "',";
		
		
		
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("fffffffffffffff"+s);
		return s;
	}

	
}
