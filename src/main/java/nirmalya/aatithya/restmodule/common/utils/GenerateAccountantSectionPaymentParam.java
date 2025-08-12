package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.ReimbrusementPaymentModel;
//import nirmalya.aatithya.restmodule.employee.model.ReimbursementPaymentModel;

public class GenerateAccountantSectionPaymentParam {

	public static String getAccountantPayment(ReimbrusementPaymentModel reimbursementModel) {

		String s = "";

		if (reimbursementModel.getReqId() != null && reimbursementModel.getReqId() != "") {
			s = s + "@p_reqId='" + reimbursementModel.getReqId() + "',";
		}
		if (reimbursementModel.getReqName() != null && reimbursementModel.getReqName() != "") {
			s = s + "@p_reqName='" + reimbursementModel.getReqName() + "',";
		}
		if (reimbursementModel.getEmpId() != null && reimbursementModel.getEmpId() != "") {
			s = s + "@p_empId='" + reimbursementModel.getEmpId() + "',";
		}
		if (reimbursementModel.getPaymentId() != null && reimbursementModel.getPaymentId() != "") {
			s = s + "@p_paymentId='" + reimbursementModel.getPaymentId() + "',";
		}
		if (reimbursementModel.getPaymentMode() != null && reimbursementModel.getPaymentMode() != "") {
			s = s + "@p_paymentMode='" + reimbursementModel.getPaymentMode() + "',";
		}
		if (reimbursementModel.getBankName() != null && reimbursementModel.getBankName() != "") {
			s = s + "@p_bankName='" + reimbursementModel.getBankName() + "',";
		}
		if (reimbursementModel.getBranchName() != null && reimbursementModel.getBranchName() != "") {
			s = s + "@p_branchName='" + reimbursementModel.getBranchName() + "',";
		}

		if (reimbursementModel.getAccNo() != null && reimbursementModel.getAccNo() != "") {
			s = s + "@p_accNo='" + reimbursementModel.getAccNo() + "',";
		}

		if (reimbursementModel.getAmount() != null && reimbursementModel.getAmount() != "") {
			s = s + "@p_amount='" + reimbursementModel.getAmount() + "',";
		}

		if (reimbursementModel.getTransactionDate() != null && reimbursementModel.getTransactionDate() != "") {
			s = s + "@p_transactionDate='" + DateFormatter.getStringDate(reimbursementModel.getTransactionDate())
					+ "',";
		}

		if (reimbursementModel.getChequeNo() != null && reimbursementModel.getChequeNo() != "") {
			s = s + "@p_chequeNo='" + reimbursementModel.getChequeNo() + "',";
		}

		if (reimbursementModel.getTransactionNo() != null && reimbursementModel.getTransactionNo() != "") {
			s = s + "@p_transactionNo='" + reimbursementModel.getTransactionNo() + "',";
		}

		if (reimbursementModel.getTotal() != null) {
			s = s + "@p_total='" + reimbursementModel.getTotal() + "',";
		}

		if (reimbursementModel.getAmtPaid() != null) {
			s = s + "@p_amtPaid='" + reimbursementModel.getAmtPaid() + "',";
		}

		if (reimbursementModel.getAdvRequired() != null) {
			s = s + "@p_advRequired='" + reimbursementModel.getAdvRequired() + "',";
		}

		if (reimbursementModel.getCreatedBy() != null && reimbursementModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + reimbursementModel.getCreatedBy() + "',";
		}
		if (reimbursementModel.getOrganization() != null && reimbursementModel.getOrganization() != "") {
			s = s + "@p_org='" + reimbursementModel.getOrganization() + "',";
		}

		if (reimbursementModel.getOrgDivision() != null && reimbursementModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + reimbursementModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
