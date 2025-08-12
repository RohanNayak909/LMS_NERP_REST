package nirmalya.aatithya.restmodule.common.utils.account;

import java.util.List;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;

public class GenerateAccountJournalVoucherParameter {

	public static String saveJournalVoucherParam(List<AccountJournalVoucherModel> journalVoucherModel) {
		String s = "";
		String litem = "";
		String journalVoucher = "";
		String costCenter = "";
		String Description = "";
		Double totalAmount = 0.0;
		String createdBy = "";
		String voucherType = "";
		String voucherDate = "";
		String organization = "";
		String orgDivision = "";
		String tdsIds = "";
		String taxType = "";

		String paymentType = "";
		String paymentDesc = "";
		String advOrNewRfAmount = "";
		String invoiceObj = "";
		String advReceiveObj = "";
		String billDetails = "";
		String advanceRemaingDetails = "";
		String paymentMethodDetails = "";

		for (AccountJournalVoucherModel m : journalVoucherModel) {
			journalVoucher = m.getJournalVoucher();
			costCenter = m.getCostCenter();
			Description = m.getDescription();
			createdBy = m.getCreatedBy();
			totalAmount = m.getTotalAmount();
			voucherType = m.getVoucherType();
			voucherDate = m.getVoucherDate();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			tdsIds = m.getListTdsId();
			taxType = m.getTaxType();
			paymentType = m.getPaymentType();
			paymentDesc = m.getPaymentDesc();
			advOrNewRfAmount = m.getAdvOrNewRfAmount();
			invoiceObj = m.getInvoiceObj();
			advReceiveObj = m.getAdvReceiveObj();
			billDetails = m.getBillDetails();
			advanceRemaingDetails = m.getAdvanceRemaingDetails();
			paymentMethodDetails = m.getPaymentMethodDetails();
			
		}

		s = s + "@p_journalVoucher='" + journalVoucher + "',";
		s = s + "@p_costCenter='" + costCenter + "',";
		s = s + "@p_description='" + Description + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_voucherType='" + voucherType + "',";
		s = s + "@p_totalAmount=" + totalAmount + ",";
		s = s + "@p_voucherDate='" + voucherDate + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_tdsIds='" + tdsIds + "',";
		s = s + "@p_taxType='" + taxType + "',";
		s = s + "@p_paymentType='" + paymentType + "',";
		s = s + "@p_paymentDesc='" + paymentDesc + "',";
		s = s + "@p_advAmount='" + advOrNewRfAmount + "',";
		s = s + "@p_invObj='" + invoiceObj + "',";
		s = s + "@p_advObj='" + advReceiveObj + "',";
		s = s + "@p_billDetails='" + billDetails + "',";
		s = s + "@p_advanceRemaingDetails='" + advanceRemaingDetails + "',";
		s = s + "@p_paymentMethodDetails='" + paymentMethodDetails + "',";

		String debitedToLdeger = null;
		for (AccountJournalVoucherModel m : journalVoucherModel) {
			
			if (m.getFromAmount() != null && m.getFromAccountSubGroup() != null) {
				
				if(m.getFromAmount() > 0) {
					m.setTransactionType("Debit");
					m.setDebitTrans("YES");
					m.setCreditTrans("");
				} else {
					m.setTransactionType("Credit");
					m.setDebitTrans("");
					m.setCreditTrans("YES");
				}
				
				debitedToLdeger = m.getFromAccountSubGroup();
				litem = litem + "(@p_journalVoucher,\"" + m.getDebitTrans() + "\",\"" + m.getCreditTrans() + "\","
						+ "\"" + m.getFromAccountSubGroup() + "\",\"" + m.getTransactionType() + "\"," + "\""
						+ m.getFromName() + "\"," + Math.abs(m.getFromAmount()) + ",@p_organization,@p_orgDivision),";
			}
		}
		
		String creditedToLdeger = null;
		for (AccountJournalVoucherModel m : journalVoucherModel) {
			
			if (m.getToAmount() != null && m.getToAccountSubGroup() != null) {
				
				if(m.getToAmount() > 0) {
					m.setTransactionType("Credit");
					m.setDebitTrans("");
					m.setCreditTrans("YES");
				} else {
					m.setTransactionType("Debit");
					m.setDebitTrans("YES");
					m.setCreditTrans("");
				}
				
				creditedToLdeger = m.getToAccountSubGroup();
				litem = litem + "(@p_journalVoucher,\"" + m.getDebitTrans() + "\",\"" + m.getCreditTrans() + "\",\""
						+ m.getToAccountSubGroup() + "\",\"" + m.getTransactionType() + "\",\"" + m.getToName() + "\","
						+ Math.abs(m.getToAmount()) + ",@p_organization,@p_orgDivision),";

			}
		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_jVSubQuery='" + litem + "',";
		
		if(debitedToLdeger != null && debitedToLdeger != "") {
			s = s + "@p_debitedToLdeger='" + debitedToLdeger + "',";
		}
		if(creditedToLdeger != null && creditedToLdeger != "") {
			s = s + "@p_creditedToLdeger='" + creditedToLdeger + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("==>>>>>>>>>>>>>>>>>>" + s);
		return s;
	}

}
