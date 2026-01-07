package nirmalya.aatithya.restmodule.common.utils.sales;

import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoicePaymentModel;

public class GenerateInvoicePaymentParameter {
	public static String addPaymentParam(RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		String s = "";
		if (restSalesInvoicePaymentModel.getSalesInvoiceId() != null || restSalesInvoicePaymentModel.getSalesInvoiceId() != "") {
			s = s + "@p_saleInvoiceId='" + restSalesInvoicePaymentModel.getSalesInvoiceId() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayPoId() != null || restSalesInvoicePaymentModel.getPayPoId() != "") {
			s = s + "@p_poId='" + restSalesInvoicePaymentModel.getPayPoId() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayAmount() != null || restSalesInvoicePaymentModel.getPayAmount() != "") {
			s = s + "@p_payAmount='" + restSalesInvoicePaymentModel.getPayAmount() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayRemarks() != null || restSalesInvoicePaymentModel.getPayRemarks() != "") {
			s = s + "@p_payRemarks='" + restSalesInvoicePaymentModel.getPayRemarks() + "',";
		}
		if (restSalesInvoicePaymentModel.getCreatedBy() != null || restSalesInvoicePaymentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restSalesInvoicePaymentModel.getCreatedBy() + "',";
		}
		if (restSalesInvoicePaymentModel.getOrganization() != null || restSalesInvoicePaymentModel.getOrganization() != "") {
			s = s + "@p_orgName='" + restSalesInvoicePaymentModel.getOrganization() + "',";
		}
		if (restSalesInvoicePaymentModel.getOrgDivision() != null || restSalesInvoicePaymentModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restSalesInvoicePaymentModel.getOrgDivision() + "',";
		}
		
		if (restSalesInvoicePaymentModel.getDocName() != null || restSalesInvoicePaymentModel.getDocName() != "") {
			s = s + "@p_docName='" + restSalesInvoicePaymentModel.getDocName() + "',";
		}
		if (restSalesInvoicePaymentModel.getPaymentMode() != null || restSalesInvoicePaymentModel.getPaymentMode() != "") {
			s = s + "@p_paymentMode='" + restSalesInvoicePaymentModel.getPaymentMode() + "',";
		}
		if (restSalesInvoicePaymentModel.getChequeNo() != null || restSalesInvoicePaymentModel.getChequeNo() != "") {
			s = s + "@p_chequeNo='" + restSalesInvoicePaymentModel.getChequeNo() + "',";
		}
		if (restSalesInvoicePaymentModel.getChequeBankName() != null || restSalesInvoicePaymentModel.getChequeBankName() != "") {
			s = s + "@p_chequeBankName='" + restSalesInvoicePaymentModel.getChequeBankName() + "',";
		}
		if (restSalesInvoicePaymentModel.getChequeBankBranch() != null || restSalesInvoicePaymentModel.getChequeBankBranch() != "") {
			s = s + "@p_chequeBankBranch='" + restSalesInvoicePaymentModel.getChequeBankBranch() + "',";
		}
		if (restSalesInvoicePaymentModel.getChequeAccountNumber() != null || restSalesInvoicePaymentModel.getChequeAccountNumber() != "") {
			s = s + "@p_chequeAccountNumber='" + restSalesInvoicePaymentModel.getChequeAccountNumber() + "',";
		}
		if (restSalesInvoicePaymentModel.getBankSelect() != null || restSalesInvoicePaymentModel.getBankSelect() != "") {
			s = s + "@p_bankSelect='" + restSalesInvoicePaymentModel.getBankSelect() + "',";
		}
		if (restSalesInvoicePaymentModel.getOnlineUpiID() != null || restSalesInvoicePaymentModel.getOnlineUpiID() != "") {
			s = s + "@p_onlineUpiID='" + restSalesInvoicePaymentModel.getOnlineUpiID() + "',";
		}
		if (restSalesInvoicePaymentModel.getTransactionNumber() != null || restSalesInvoicePaymentModel.getTransactionNumber() != "") {
			s = s + "@p_transactionNumber='" + restSalesInvoicePaymentModel.getTransactionNumber() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		//System.out.println(s);
		return s;
	}
	
	public static String addSendPaymentParam(RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		String s = "";
		if (restSalesInvoicePaymentModel.getSalesInvoiceId() != null || restSalesInvoicePaymentModel.getSalesInvoiceId() != "") {
			s = s + "@p_saleInvoiceId='" + restSalesInvoicePaymentModel.getSalesInvoiceId() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayPoId() != null || restSalesInvoicePaymentModel.getPayPoId() != "") {
			s = s + "@p_poId='" + restSalesInvoicePaymentModel.getPayPoId() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayAmount() != null || restSalesInvoicePaymentModel.getPayAmount() != "") {
			s = s + "@p_payAmount='" + restSalesInvoicePaymentModel.getPayAmount() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayRemarks() != null || restSalesInvoicePaymentModel.getPayRemarks() != "") {
			s = s + "@p_payRemarks='" + restSalesInvoicePaymentModel.getPayRemarks() + "',";
		}
		if (restSalesInvoicePaymentModel.getCreatedBy() != null || restSalesInvoicePaymentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restSalesInvoicePaymentModel.getCreatedBy() + "',";
		}
		if (restSalesInvoicePaymentModel.getOrganization() != null || restSalesInvoicePaymentModel.getOrganization() != "") {
			s = s + "@p_orgName='" + restSalesInvoicePaymentModel.getOrganization() + "',";
		}
		if (restSalesInvoicePaymentModel.getOrgDivision() != null || restSalesInvoicePaymentModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restSalesInvoicePaymentModel.getOrgDivision() + "',";
		}
		
		if (restSalesInvoicePaymentModel.getDocName() != null || restSalesInvoicePaymentModel.getDocName() != "") {
			s = s + "@p_docName='" + restSalesInvoicePaymentModel.getDocName() + "',";
		}
		if (restSalesInvoicePaymentModel.getPaymentMode() != null || restSalesInvoicePaymentModel.getPaymentMode() != "") {
			s = s + "@p_paymentMode='" + restSalesInvoicePaymentModel.getPaymentMode() + "',";
		}
		if (restSalesInvoicePaymentModel.getChequeNo() != null || restSalesInvoicePaymentModel.getChequeNo() != "") {
			s = s + "@p_chequeNo='" + restSalesInvoicePaymentModel.getChequeNo() + "',";
		}
		if (restSalesInvoicePaymentModel.getChequeBankName() != null || restSalesInvoicePaymentModel.getChequeBankName() != "") {
			s = s + "@p_chequeBankName='" + restSalesInvoicePaymentModel.getChequeBankName() + "',";
		}
		if (restSalesInvoicePaymentModel.getChequeBankBranch() != null || restSalesInvoicePaymentModel.getChequeBankBranch() != "") {
			s = s + "@p_chequeBankBranch='" + restSalesInvoicePaymentModel.getChequeBankBranch() + "',";
		}
		if (restSalesInvoicePaymentModel.getChequeAccountNumber() != null || restSalesInvoicePaymentModel.getChequeAccountNumber() != "") {
			s = s + "@p_chequeAccountNumber='" + restSalesInvoicePaymentModel.getChequeAccountNumber() + "',";
		}
		if (restSalesInvoicePaymentModel.getBankSelect() != null || restSalesInvoicePaymentModel.getBankSelect() != "") {
			s = s + "@p_bankSelect='" + restSalesInvoicePaymentModel.getBankSelect() + "',";
		}
		if (restSalesInvoicePaymentModel.getOnlineUpiID() != null || restSalesInvoicePaymentModel.getOnlineUpiID() != "") {
			s = s + "@p_onlineUpiID='" + restSalesInvoicePaymentModel.getOnlineUpiID() + "',";
		}
		if (restSalesInvoicePaymentModel.getTransactionNumber() != null || restSalesInvoicePaymentModel.getTransactionNumber() != "") {
			s = s + "@p_transactionNumber='" + restSalesInvoicePaymentModel.getTransactionNumber() + "',";
		}
		
		if (restSalesInvoicePaymentModel.getReceiverBankName() != null || restSalesInvoicePaymentModel.getReceiverBankName() != "") {
			s = s + "@p_receiverBankName='" + restSalesInvoicePaymentModel.getReceiverBankName() + "',";
		}
		if (restSalesInvoicePaymentModel.getReceiverBankBranch() != null || restSalesInvoicePaymentModel.getReceiverBankBranch() != "") {
			s = s + "@p_receiverBankBranch='" + restSalesInvoicePaymentModel.getReceiverBankBranch() + "',";
		}
		if (restSalesInvoicePaymentModel.getReceiverIfscCode() != null || restSalesInvoicePaymentModel.getReceiverIfscCode() != "") {
			s = s + "@p_receiverIfscCode='" + restSalesInvoicePaymentModel.getReceiverIfscCode() + "',";
		}
		if (restSalesInvoicePaymentModel.getReceiverAccountNumber() != null || restSalesInvoicePaymentModel.getReceiverAccountNumber() != "") {
			s = s + "@p_receiverAccountNumber='" + restSalesInvoicePaymentModel.getReceiverAccountNumber() + "',";
		}
		if (restSalesInvoicePaymentModel.getReceiverOnlineUpiID() != null || restSalesInvoicePaymentModel.getReceiverOnlineUpiID() != "") {
			s = s + "@p_receiverOnlineUpiID='" + restSalesInvoicePaymentModel.getReceiverOnlineUpiID() + "',";
		}
		if (restSalesInvoicePaymentModel.getReceiverUpiTransactionID() != null || restSalesInvoicePaymentModel.getReceiverUpiTransactionID() != "") {
			s = s + "@p_receiverUpiTransactionID='" + restSalesInvoicePaymentModel.getReceiverUpiTransactionID() + "',";
		}
		if (restSalesInvoicePaymentModel.getVendorId() != null || restSalesInvoicePaymentModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + restSalesInvoicePaymentModel.getVendorId() + "',";
		}
		if (restSalesInvoicePaymentModel.getPaymentStatus() != null || restSalesInvoicePaymentModel.getPaymentStatus() != "") {
			s = s + "@p_paymentStatus='" + restSalesInvoicePaymentModel.getPaymentStatus() + "',";
		}
		if (restSalesInvoicePaymentModel.getAmountPaid() != null || restSalesInvoicePaymentModel.getAmountPaid() != "") {
			s = s + "@p_amountPaid='" + restSalesInvoicePaymentModel.getAmountPaid() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		//System.out.println(s);
		return s;
	}
}
