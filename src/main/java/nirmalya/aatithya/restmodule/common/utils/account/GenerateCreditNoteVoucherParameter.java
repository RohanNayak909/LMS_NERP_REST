package nirmalya.aatithya.restmodule.common.utils.account;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

public class GenerateCreditNoteVoucherParameter {

	
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
		String buyerLedger = "";
		String modeOfNote = "";
		
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
			buyerLedger = m.getToAccountSubGroup();
			modeOfNote = m.getMethodOfNote();
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
		s = s + "@p_sellerledger='" + journalVoucherModel.get(0).getFromAccountSubGroup()+ "',";
		s = s + "@p_buyerledger='" + buyerLedger + "',";
		s = s + "@p_modeOfLedger='" + modeOfNote + "',";
		

		for (AccountJournalVoucherModel m : journalVoucherModel) {
			m.setTransactionType("Debit");
			m.setDebitTrans("YES");
			m.setCreditTrans("");
			if (m.getFromAmount() != null && m.getFromAccountSubGroup() != null) {
				litem = litem + "(@p_creditNoteId,\""+m.getDebitTrans()+"\",\""+m.getCreditTrans()+"\","
						+ "\"" + m.getFromAccountSubGroup() + "\",\"" + m.getTransactionType()+ "\","
								+ "\"" + m.getFromName() + "\"," + m.getFromAmount() + ",@p_organization,@p_orgDivision),";
			}
		}
		List<DropDownModel> creditList = new ArrayList<DropDownModel>();
		for (AccountJournalVoucherModel m : journalVoucherModel) {
			m.setTransactionType("Credit");
			m.setDebitTrans("");
			m.setCreditTrans("YES");
			if (m.getToAmount() != null && m.getToAccountSubGroup() != null) {
				litem = litem + "(@p_creditNoteId,\""+m.getDebitTrans()+"\",\""+m.getCreditTrans()+"\",\"" + m.getToAccountSubGroup() + "\",\"" + m.getTransactionType()
						+ "\",\"" + m.getToName() + "\"," + m.getToAmount() + ",@p_organization,@p_orgDivision),";
				DropDownModel d = new DropDownModel();
				d.setKey(m.getToAccountSubGroup());
				d.setName(m.getToAmount().toString());
				creditList.add(d);

			}
		}
		litem = litem.substring(0, litem.length()-1);

		s = s + "@p_jVSubQuery='" + litem + "', @p_creditList='" + creditList.toString() + "',";


		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("==>>>>>>>>>>>>>>>>>>"+s);
		return s;
	}
}
