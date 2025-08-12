package nirmalya.aatithya.restmodule.common.utils.account;

import nirmalya.aatithya.restmodule.account.model.RestSalesInvoicePaymentModel;

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
		if (restSalesInvoicePaymentModel.getVendorId() != null || restSalesInvoicePaymentModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + restSalesInvoicePaymentModel.getVendorId() + "',";
		}
		if (restSalesInvoicePaymentModel.getAmountPaid() != null || restSalesInvoicePaymentModel.getAmountPaid() != "") {
			s = s + "@p_amountPaid='" + restSalesInvoicePaymentModel.getAmountPaid() + "',";
		}
		if (restSalesInvoicePaymentModel.getPaymentStatus() != null || restSalesInvoicePaymentModel.getPaymentStatus() != "") {
			s = s + "@p_paymentStatus='" + restSalesInvoicePaymentModel.getPaymentStatus() + "',";
		}
		if (restSalesInvoicePaymentModel.getUserRoleType() != null || restSalesInvoicePaymentModel.getUserRoleType() != "") {
			s = s + "@p_userRoleType='" + restSalesInvoicePaymentModel.getUserRoleType() + "',";
		}
		
		if (restSalesInvoicePaymentModel.getUsedCreditNotes() != null || restSalesInvoicePaymentModel.getUsedCreditNotes() != "") {
			s = s + "@p_creditNotes='" + restSalesInvoicePaymentModel.getUsedCreditNotes() + "',";
		}
		if (restSalesInvoicePaymentModel.getReceivableAmountFinal() != null || restSalesInvoicePaymentModel.getReceivableAmountFinal() != "") {
			s = s + "@p_receivableAmountFinal='" + restSalesInvoicePaymentModel.getReceivableAmountFinal() + "',";
		}
		
		if (restSalesInvoicePaymentModel.getPayableAmountFinal() != null || restSalesInvoicePaymentModel.getPayableAmountFinal() != "") {
			s = s + "@p_payableAmountFinal='" + restSalesInvoicePaymentModel.getPayableAmountFinal() + "',";
		}
		if (restSalesInvoicePaymentModel.getRemainAmount() != null || restSalesInvoicePaymentModel.getRemainAmount() != "") {
			s = s + "@p_remainAmount='" + restSalesInvoicePaymentModel.getRemainAmount() + "',";
		}
		if (restSalesInvoicePaymentModel.getBankSelectPayment() != null || restSalesInvoicePaymentModel.getBankSelectPayment() != "") {
			s = s + "@p_bankSelectPayment='" + restSalesInvoicePaymentModel.getBankSelectPayment() + "',";
		}
		if (restSalesInvoicePaymentModel.getTransactionDate() != null || restSalesInvoicePaymentModel.getTransactionDate() != "") {
			s = s + "@p_transactionDate='" + restSalesInvoicePaymentModel.getTransactionDate() + "',";
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
		
		if (restSalesInvoicePaymentModel.getInvoiceNo() != null || restSalesInvoicePaymentModel.getInvoiceNo() != "") {
			s = s + "@p_invNo='" + restSalesInvoicePaymentModel.getInvoiceNo() + "',";
		}
		if (restSalesInvoicePaymentModel.getUsedDebitNotes() != null || restSalesInvoicePaymentModel.getUsedDebitNotes() != "") {
			s = s + "@p_debitNotes='" + restSalesInvoicePaymentModel.getUsedDebitNotes() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayableAmountFinal() != null || restSalesInvoicePaymentModel.getPayableAmountFinal() != "") {
			s = s + "@p_payableAmountFinal='" + restSalesInvoicePaymentModel.getPayableAmountFinal() + "',";
		}
		if (restSalesInvoicePaymentModel.getRemainAmount() != null || restSalesInvoicePaymentModel.getRemainAmount() != "") {
			s = s + "@p_remainAmount='" + restSalesInvoicePaymentModel.getRemainAmount() + "',";
		}
		if (restSalesInvoicePaymentModel.getDueAmount() != null || restSalesInvoicePaymentModel.getDueAmount() != "") {
			s = s + "@p_dueAmount='" + restSalesInvoicePaymentModel.getDueAmount() + "',";
		}
		if (restSalesInvoicePaymentModel.getBankSelectPayment() != null || restSalesInvoicePaymentModel.getBankSelectPayment() != "") {
			s = s + "@p_bankSelectPayment='" + restSalesInvoicePaymentModel.getBankSelectPayment() + "',";
		}
		if (restSalesInvoicePaymentModel.getTransactionDate() != null || restSalesInvoicePaymentModel.getTransactionDate() != "") {
			s = s + "@p_transactionDate='" + restSalesInvoicePaymentModel.getTransactionDate() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		//System.out.println(s);
		return s;
	}
	
	// payment sent for advance and new reference
	public static String addSendPaymentParamMethod(RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		String s = "";

		if (restSalesInvoicePaymentModel.getCreatedBy() != null || restSalesInvoicePaymentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restSalesInvoicePaymentModel.getCreatedBy() + "',";
		}
		if (restSalesInvoicePaymentModel.getOrganization() != null || restSalesInvoicePaymentModel.getOrganization() != "") {
			s = s + "@p_orgName='" + restSalesInvoicePaymentModel.getOrganization() + "',";
		}
		if (restSalesInvoicePaymentModel.getOrgDivision() != null || restSalesInvoicePaymentModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restSalesInvoicePaymentModel.getOrgDivision() + "',";
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
		if (restSalesInvoicePaymentModel.getPayRemarks() != null || restSalesInvoicePaymentModel.getPayRemarks() != "") {
			s = s + "@p_payRemarks='" + restSalesInvoicePaymentModel.getPayRemarks() + "',";
		}
		if (restSalesInvoicePaymentModel.getVendorId() != null || restSalesInvoicePaymentModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + restSalesInvoicePaymentModel.getVendorId() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayAmount() != null || restSalesInvoicePaymentModel.getPayAmount() != "") {
			s = s + "@p_payAmount='" + restSalesInvoicePaymentModel.getPayAmount() + "',";
		}
		if (restSalesInvoicePaymentModel.getMethodOfAdj() != null || restSalesInvoicePaymentModel.getMethodOfAdj() != "") {
			s = s + "@p_methodOfAdj='" + restSalesInvoicePaymentModel.getMethodOfAdj() + "',";
		}
		if (restSalesInvoicePaymentModel.getBankSelectPayment() != null || restSalesInvoicePaymentModel.getBankSelectPayment() != "") {
			s = s + "@p_bankSelectPayment='" + restSalesInvoicePaymentModel.getBankSelectPayment() + "',";
		}
		if (restSalesInvoicePaymentModel.getTransactionDate() != null || restSalesInvoicePaymentModel.getTransactionDate() != "") {
			s = s + "@p_transactionDate='" + restSalesInvoicePaymentModel.getTransactionDate() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		//System.out.println(s);
		return s;
	}
	
	//sales payment received for advance and new reference
	public static String addPaymentParamMethod(RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		String s = "";

		if (restSalesInvoicePaymentModel.getCreatedBy() != null || restSalesInvoicePaymentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restSalesInvoicePaymentModel.getCreatedBy() + "',";
		}
		if (restSalesInvoicePaymentModel.getOrganization() != null || restSalesInvoicePaymentModel.getOrganization() != "") {
			s = s + "@p_orgName='" + restSalesInvoicePaymentModel.getOrganization() + "',";
		}
		if (restSalesInvoicePaymentModel.getOrgDivision() != null || restSalesInvoicePaymentModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restSalesInvoicePaymentModel.getOrgDivision() + "',";
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
		if (restSalesInvoicePaymentModel.getPayRemarks() != null || restSalesInvoicePaymentModel.getPayRemarks() != "") {
			s = s + "@p_payRemarks='" + restSalesInvoicePaymentModel.getPayRemarks() + "',";
		}
		if (restSalesInvoicePaymentModel.getVendorId() != null || restSalesInvoicePaymentModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + restSalesInvoicePaymentModel.getVendorId() + "',";
		}
		if (restSalesInvoicePaymentModel.getPayAmount() != null || restSalesInvoicePaymentModel.getPayAmount() != "") {
			s = s + "@p_payAmount='" + restSalesInvoicePaymentModel.getPayAmount() + "',";
		}
		if (restSalesInvoicePaymentModel.getMethodOfAdj() != null || restSalesInvoicePaymentModel.getMethodOfAdj() != "") {
			s = s + "@p_methodOfAdj='" + restSalesInvoicePaymentModel.getMethodOfAdj() + "',";
		}
		if (restSalesInvoicePaymentModel.getUserRoleType() != null || restSalesInvoicePaymentModel.getUserRoleType() != "") {
			s = s + "@p_userRoleType='" + restSalesInvoicePaymentModel.getUserRoleType() + "',";
		}
		if (restSalesInvoicePaymentModel.getBankSelectPayment() != null || restSalesInvoicePaymentModel.getBankSelectPayment() != "") {
			s = s + "@p_bankSelectPayment='" + restSalesInvoicePaymentModel.getBankSelectPayment() + "',";
		}
		if (restSalesInvoicePaymentModel.getTransactionDate() != null || restSalesInvoicePaymentModel.getTransactionDate() != "") {
			s = s + "@p_transactionDate='" + restSalesInvoicePaymentModel.getTransactionDate() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		//System.out.println(s);
		return s;
	}
}
