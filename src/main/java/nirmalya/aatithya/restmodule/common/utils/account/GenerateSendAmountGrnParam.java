package nirmalya.aatithya.restmodule.common.utils.account;

import nirmalya.aatithya.restmodule.account.model.RestManageSendAmountModel;

public class GenerateSendAmountGrnParam {
	public static String addAmountParam(RestManageSendAmountModel sendAmountModel) {
		String s = "";
		if (sendAmountModel.getPaymentId() != null || sendAmountModel.getPaymentId() != "") {
			s = s + "@p_paymentId='" + sendAmountModel.getPaymentId() + "',";
		}
		if (sendAmountModel.getVendorId() != null || sendAmountModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + sendAmountModel.getVendorId() + "',";
		}
		if (sendAmountModel.getVendorGrnId() != null || sendAmountModel.getVendorGrnId() != "") {
			s = s + "@p_grnId='" + sendAmountModel.getVendorGrnId() + "',";
		}
		if (sendAmountModel.getVendorGrnAmount() != null || sendAmountModel.getVendorGrnAmount() != "") {
			s = s + "@p_grnAmount='" + sendAmountModel.getVendorGrnAmount() + "',";
		}
		if (sendAmountModel.getVendorGrnBulkAmount() != null || sendAmountModel.getVendorGrnBulkAmount() != "") {
			s = s + "@p_bulkAmount='" + sendAmountModel.getVendorGrnBulkAmount() + "',";
		}
		if (sendAmountModel.getVendorBankName() != null || sendAmountModel.getVendorBankName() != "") {
			s = s + "@p_bankName='" + sendAmountModel.getVendorBankName() + "',";
		}
		if (sendAmountModel.getVendorBankBranch() != null || sendAmountModel.getVendorBankBranch() != "") {
			s = s + "@p_bankBranch='" + sendAmountModel.getVendorBankBranch() + "',";
		}
		if (sendAmountModel.getVendorAccountNumber() != null || sendAmountModel.getVendorAccountNumber() != "") {
			s = s + "@p_bankAccNo='" + sendAmountModel.getVendorAccountNumber() + "',";
		}
		if (sendAmountModel.getVendorTransactionNumber() != null || sendAmountModel.getVendorTransactionNumber() != "") {
			s = s + "@p_transactionNo='" + sendAmountModel.getVendorTransactionNumber() + "',";
		}
		if (sendAmountModel.getVendorPayToggle() != null || sendAmountModel.getVendorPayToggle() != "") {
			s = s + "@p_payToggle='" + sendAmountModel.getVendorPayToggle() + "',";
		}
		if (sendAmountModel.getUserId() != null || sendAmountModel.getUserId() != "") {
			s = s + "@p_userId='" + sendAmountModel.getUserId() + "',";
		}
		if (sendAmountModel.getCreatedBy() != null || sendAmountModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + sendAmountModel.getCreatedBy() + "',";
		}
		if (sendAmountModel.getOrganization() != null || sendAmountModel.getOrganization() != "") {
			s = s + "@p_orgName='" + sendAmountModel.getOrganization() + "',";
		}
		if (sendAmountModel.getOrgDivision() != null || sendAmountModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + sendAmountModel.getOrgDivision() + "',";
		}
		if (sendAmountModel.getVendorRemarks() != null || sendAmountModel.getVendorRemarks() != "") {
			s = s + "@p_remarks='" + sendAmountModel.getVendorRemarks() + "',";
		}
		if (s != "") { 
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s-----" + s);
		return s;
	}
}
