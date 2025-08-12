package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.ReimbrusementRestOtherModel;

public class GenerateReimbrusementOtherParameter {
	public static String getReimbursementParamOther(ReimbrusementRestOtherModel reimbursementModel) {

		String s = "";
		if (reimbursementModel.getOtherReimbrusementId() != null
				&& reimbursementModel.getOtherReimbrusementId() != "") {
			s = s + "@p_otherReimbursementReqId='" + reimbursementModel.getOtherReimbrusementId() + "',";
		}

		if (reimbursementModel.getDate() != null && reimbursementModel.getDate() != "") {
			s = s + "@p_getDate='" + reimbursementModel.getDate() + "',";
		}

		if (reimbursementModel.getTravellingPurpose() != null && reimbursementModel.getTravellingPurpose() != "") {
			s = s + "@p_getTravellingPurpose='" + reimbursementModel.getTravellingPurpose() + "',";
		}
	
		if (reimbursementModel.getTypeReimbrusement() != null || reimbursementModel.getTypeReimbrusement() != "") {
			s = s + "@p_TypeReim='" + reimbursementModel.getTypeReimbrusement() + "',";
		}

		if (reimbursementModel.getExpenseDate() != null || reimbursementModel.getExpenseDate() != "") {
			s = s + "@p_getExpenseDate='" + reimbursementModel.getExpenseDate() + "',";
		}

		if (reimbursementModel.getDescExpense() != null && reimbursementModel.getDescExpense() != "") {
			s = s + "@p_getDescExpense='" + reimbursementModel.getDescExpense() + "',";
		}
		if (reimbursementModel.getExpenseAmount() != null) {
			s = s + "@p_getExpenseAmount='" + reimbursementModel.getExpenseAmount() + "',";
		}
		if (reimbursementModel.getDocName() != null || reimbursementModel.getDocName() != "") {
			s = s + "@p_docName='" + reimbursementModel.getDocName() + "',";
		}
		if (reimbursementModel.getReferenceNo() != null && reimbursementModel.getReferenceNo() != "") {
			s = s + "@p_referenceNo='" + reimbursementModel.getReferenceNo() + "',";
		}
		if (reimbursementModel.getCreatedBy() != null && reimbursementModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + reimbursementModel.getCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

}
