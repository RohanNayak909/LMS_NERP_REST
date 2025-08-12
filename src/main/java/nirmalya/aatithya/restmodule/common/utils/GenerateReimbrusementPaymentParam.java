package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.ReimbrusementPaymentModel;
//import nirmalya.aatithya.restmodule.employee.model.ReimbursementPaymentModel;

public class GenerateReimbrusementPaymentParam {

	public static String getReimbursementParamPayment(ReimbrusementPaymentModel reimbursementModel) {

		String s = "";

		if (reimbursementModel.getPaymentId() != null && reimbursementModel.getPaymentId() != "") {
			s = s + "@p_paymentId='" + reimbursementModel.getPaymentId() + "',";
		}
		if (reimbursementModel.getPaymentMode() != null && reimbursementModel.getPaymentMode() != "") {
			s = s + "@p_paymentMode='" + reimbursementModel.getPaymentMode() + "',";
		}
		if (reimbursementModel.getBankName() != null || reimbursementModel.getBankName() != "") {
			s = s + "@p_bankName='" + reimbursementModel.getBankName() + "',";
		}
		if (reimbursementModel.getBranchName() != null && reimbursementModel.getBranchName() != "") {
			s = s + "@p_branchName='" + reimbursementModel.getBranchName() + "',";
		}

		if (reimbursementModel.getAccNo() != null && reimbursementModel.getAccNo() != "") {
			s = s + "@p_accNo='" + reimbursementModel.getAccNo() + "',";
		}

		/*
		 * if (reimbursementModel.getAccHolderName() != null ||
		 * reimbursementModel.getAccHolderName() != "") { s = s + "@p_accHolderName='" +
		 * reimbursementModel.getAccHolderName() + "',"; }
		 * 
		 * if (reimbursementModel.getAdvanceTaken() != null ) { s = s +
		 * "@p_advanceTaken='" + reimbursementModel.getAdvanceTaken() + "',"; }
		 * 
		 * if (reimbursementModel.getAmountTobePaid() != null) { s = s +
		 * "@p_amountPaid='" + reimbursementModel.getAmountTobePaid() + "',"; }
		 */

		if (reimbursementModel.getTransactionDate() != null || reimbursementModel.getTransactionDate() != "") {
			s = s + "@p_transactionDate='" + reimbursementModel.getTransactionDate() + "',";
		}

		if (reimbursementModel.getChequeNo() != null || reimbursementModel.getChequeNo() != "") {
			s = s + "@p_chequeNo='" + reimbursementModel.getChequeNo() + "',";
		}

		if (reimbursementModel.getTransactionNo() != null || reimbursementModel.getTransactionNo() != "") {
			s = s + "@p_transactionNo='" + reimbursementModel.getTransactionNo() + "',";
		}

		if (reimbursementModel.getTotal() != null ) {
			s = s + "@p_total='" + reimbursementModel.getTotal() + "',";
		}

		if (reimbursementModel.getAmtPaid() != null ) {
			s = s + "@p_amtPaid='" + reimbursementModel.getAmtPaid() + "',";
		}

		if (reimbursementModel.getAdvRequired() != null) {
			s = s + "@p_advRequired='" + reimbursementModel.getAdvRequired() + "',";
		}

		if (reimbursementModel.getCreatedBy() != null || reimbursementModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + reimbursementModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
