package nirmalya.aatithya.restmodule.common.utils;
import nirmalya.aatithya.restmodule.employee.model.ReimbursementModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;

public class GenerateReimbursementParam {

	
	public static String getReimbursementParam(ReimbursementModel reimbursementModel) {

		String s = "";

		if (reimbursementModel.getReimbursementReqId() != null && reimbursementModel.getReimbursementReqId() != "") {
			s = s + "@p_reimbursementReqId='" + reimbursementModel.getReimbursementReqId() + "',";
		}
		if (reimbursementModel.getEmpId() != null && reimbursementModel.getEmpId() != "") {
			s = s + "@p_empId='" + reimbursementModel.getEmpId() + "',";
		}
		if (reimbursementModel.getReqType() != null && reimbursementModel.getReqType() != "") {
			s = s + "@p_reqType='" + reimbursementModel.getReqType() + "',";
		}
		/*
		 * if (reimbursementModel.getEmpId() != null || reimbursementModel.getEmpId() !=
		 * "") { s = s + "@p_empName='" + reimbursementModel.getEmpId() + "',"; }
		 */
		if (reimbursementModel.getApplyDate() != null && reimbursementModel.getApplyDate() != "") {
			s = s + "@p_applyDate='" + reimbursementModel.getApplyDate() + "',";
		}

		if (reimbursementModel.getTravellingPurpose() != null && reimbursementModel.getTravellingPurpose() != "") {
			s = s + "@p_purpose='" + reimbursementModel.getTravellingPurpose() + "',";
		}

		if (reimbursementModel.getExpenseDate1() != null || reimbursementModel.getExpenseDate1() != "") {
			s = s + "@p_expenseDate1='" + reimbursementModel.getExpenseDate1() + "',";
		}

		if (reimbursementModel.getDescExpense() != null && reimbursementModel.getDescExpense() != "") {
			s = s + "@p_descExpense='" + reimbursementModel.getDescExpense() + "',";
		}
		if (reimbursementModel.geteAmount() != null && reimbursementModel.geteAmount() != "") {
			s = s + "@p_amount='" + reimbursementModel.geteAmount() + "',";
		}
		
		if (reimbursementModel.getDocName1() != null && reimbursementModel.getDocName1() != "") {
			s = s + "@p_doc1='" + reimbursementModel.getDocName1() + "',";
		}

		
		if (reimbursementModel.getReferenceNo1() != null && reimbursementModel.getReferenceNo1() != "") {
			s = s + "@p_refnc='" + reimbursementModel.getReferenceNo1() + "',";
		}
		if (reimbursementModel.getAdvanceReq() != null) {
			s = s + "@p_advance='" + reimbursementModel.getAdvanceReq() + "',";
		}
		  if (reimbursementModel.getAdvanceAmount() != null && reimbursementModel.getAdvanceAmount() != "") { 
			 s = s +"@p_advanceAmount='" + reimbursementModel.getAdvanceAmount() + "',"; 
		}

		if (reimbursementModel.getCreatedBy() != null || reimbursementModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + reimbursementModel.getCreatedBy() + "',";
		}
		if(reimbursementModel.getOrganization() != null || reimbursementModel.getOrganization() != "") {
			s = s + "@p_org='" + reimbursementModel.getOrganization() + "',";
		}
		if(reimbursementModel.getOrgDivision() != null || reimbursementModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + reimbursementModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
	
	public static String getReimbursementParamTravel(ReimbursementModel reimbursementModel) {

		String s = "";
		if (reimbursementModel.getSlNo() != null && reimbursementModel.getSlNo() != "") {
			s = s + "@p_reimbursementReqIdss='" + reimbursementModel.getSlNo() + "',";
		}
		
		  if (reimbursementModel.getReimbursementReqId() != null &&
		  reimbursementModel.getReimbursementReqId() != "") { s = s +
		  "@p_reimbursementReqIds='" + reimbursementModel.getReimbursementReqId() +
		  "',"; }
		 

		if (reimbursementModel.getReimTypeId() != null && reimbursementModel.getReimTypeId() != "") {
			s = s + "@p_reimTypeId='" + reimbursementModel.getReimTypeId() + "',";
		}

		
		if (reimbursementModel.getReimPolicyId() != null || reimbursementModel.getReimPolicyId() != "") {
			s = s + "@p_reimPolicyId='" + reimbursementModel.getReimPolicyId() + "',";
		}

		

		
		if (reimbursementModel.getExpenseDate() != null || reimbursementModel.getExpenseDate() != "") {
			s = s + "@p_expenseDate='" + reimbursementModel.getExpenseDate() + "',";
		}

		if (reimbursementModel.getExpenseDesc() != null && reimbursementModel.getExpenseDesc() != "") {
			s = s + "@p_expenseDesc='" + reimbursementModel.getExpenseDesc() + "',";
		}
		if (reimbursementModel.getExpenseAmount() != null) {
			s = s + "@p_expenseAmount='" + reimbursementModel.getExpenseAmount() + "',";
		}

		if (reimbursementModel.getReferenceNo() != null && reimbursementModel.getReferenceNo() != "") {
			s = s + "@p_referenceNo='" + reimbursementModel.getReferenceNo() + "',";
		}
		if (reimbursementModel.getDocumentName() != null || reimbursementModel.getDocumentName() != "") {
			s = s + "@p_documentName='" + reimbursementModel.getDocumentName() + "',";
		}
		if (reimbursementModel.getDocName() != null || reimbursementModel.getDocName() != "") {
			s = s + "@p_docName='" + reimbursementModel.getDocName() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	public static String getApproveParam(InventoryRequisitionModel restItemRequisitonModel) {
		String[] userIds = restItemRequisitonModel.getReqId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_reqIds='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + restItemRequisitonModel.getModuleId() + "\",\""
					+ restItemRequisitonModel.getComponentId() + "\",\"" + restItemRequisitonModel.getSubComponentId()
					+ "\",\"" + a + "\",\"" + "Approve Requisition" + "\",\"" + restItemRequisitonModel.getCreatedBy()
					+ "\"),";

		}
		act = act.substring(0, act.length() - 1);

		s = s + "@p_actSubQuery='" + act + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
