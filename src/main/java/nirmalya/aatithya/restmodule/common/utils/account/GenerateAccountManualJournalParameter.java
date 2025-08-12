package nirmalya.aatithya.restmodule.common.utils.account;

import java.util.List;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestManualJournalModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRequisitionIssueNoteModel;

public class GenerateAccountManualJournalParameter {

	public static String saveManualJournalParam(List<RestManualJournalModel> restManualJournalModel) {
		System.out.println(restManualJournalModel);
		String s = "";
		String litem = "";
		String journalVoucher = "";
		String costCenter = "";
		String Description = "";
		Double totalAmount = 0.0;		
		String dateJournal ="";
		String journalNo ="";
		String referenceNo ="";
		String currency ="";
		String journalType ="";			
		
		String recurringYesOrNo ="";
		String profileName ="";
		String startsOn ="";
		String endsOn ="";
		String repeatEvery ="";	
		String neverExpire ="";	
		
		String createdBy = "";
		for (RestManualJournalModel m : restManualJournalModel) {
			journalVoucher = m.getJournalVoucher();
			costCenter = m.getCostCenter();
			Description = m.getDescription();
			createdBy = m.getCreatedBy();
			totalAmount = m.getTotalAmount();			
			
			dateJournal = m.getDateJournal();
			journalNo = m.getJournalNo();
			referenceNo = m.getReferenceNo();
			currency = m.getCurrency();
			journalType = m.getJournalType();
			
			recurringYesOrNo = m.getRecurringYesOrNo();
			profileName = m.getProfileName();
			startsOn = m.getStartsOn();
			endsOn = m.getEndsOn();
			repeatEvery = m.getRepeatEvery();
			neverExpire = m.getNeverExpire();
			
		}

		s = s + "@p_journalVoucher='" + journalVoucher + "',";
		s = s + "@p_costCenter='" + costCenter + "',";
		s = s + "@p_description='" + Description + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_totalAmount='" + totalAmount + "',";
		
		s = s + "@p_dateJournal='" + dateJournal + "',";
		s = s + "@p_journalNo='" + journalNo + "',";
		s = s + "@p_referenceNo='" + referenceNo + "',";
		s = s + "@p_currency='" + currency + "',";
		s = s + "@p_journalType='" + journalType + "',";
		
		s = s + "@p_recurringYesOrNo='" + recurringYesOrNo + "',";
		s = s + "@p_profileName='" + profileName + "',";
		s = s + "@p_startsOn='" + startsOn + "',";
		s = s + "@p_endsOn='" + endsOn + "',";
		s = s + "@p_repeatEvery='" + repeatEvery + "',";
		s = s + "@p_neverExpire='" + neverExpire + "',";

		for (RestManualJournalModel m : restManualJournalModel) {
			m.setTransactionType(false);
			if (m.getFromAmount() != null && m.getCustomerName() != null && m.getFromAccountSubGroup() != null) {
				litem = litem + "(@p_journalVoucher,\"" + m.getFromAccountSubGroup() + "\"," + m.getTransactionType()
						+ ",\"" + m.getCustomerName() + "\",\""+ m.getCustomerId() + "\"," + m.getFromAmount() + "),";

			}
		}
		for (RestManualJournalModel m : restManualJournalModel) {
			m.setTransactionType(true);
			if (m.getToAmount() != null && m.getCustomerName() != null && m.getToAccountSubGroup() != null) {
				litem = litem + "(@p_journalVoucher,\"" + m.getToAccountSubGroup() + "\"," + m.getTransactionType()
						+ ",\"" + m.getCustomerName() + "\",\"" + m.getCustomerId() +"\"," + m.getToAmount() + "),";

			}
		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_jVSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
