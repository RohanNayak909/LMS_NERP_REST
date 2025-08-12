package nirmalya.aatithya.restmodule.common.utils.account;

import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;

public class GenerateManageLeadgerParam {

	public static String addManageLeadgerParam(RestManageLeadgerModel manageleadger) {

		String s = "";
		if (manageleadger.getLeadgerId() != null || manageleadger.getLeadgerId() != "") {
			s = s + "@p_leaderId='" + manageleadger.getLeadgerId() + "',";
		}
		if (manageleadger.getLedgername() != null || manageleadger.getLedgername() != "") {
			s = s + "@p_leaderName='" + manageleadger.getLedgername() + "',";
		}
		if (manageleadger.getGroupId() != null || manageleadger.getGroupId() != "") {
			s = s + "@p_groupId='" + manageleadger.getGroupId() + "',";
		}
		if (manageleadger.getLedgername() != null || manageleadger.getLedgername() != "") {
			s = s + "@p_mailingName='" + manageleadger.getLedgername() + "',";
		}
		if (manageleadger.getLedgerEmail() != null || manageleadger.getLedgerEmail() != "") {
			s = s + "@p_ledgerEmail='" + manageleadger.getLedgerEmail() + "',";
		}
		if (manageleadger.getLedgerAddress1() != null || manageleadger.getLedgerAddress1() != "") {
			s = s + "@p_ledgerAddress1='" + manageleadger.getLedgerAddress1() + "',";
		}
		if (manageleadger.getLedgerAddress2() != null || manageleadger.getLedgerAddress2() != "") {
			s = s + "@p_ledgerAddress2='" + manageleadger.getLedgerAddress2() + "',";
		}
		if (manageleadger.getLedgerAddress3() != null || manageleadger.getLedgerAddress3() != "") {
			s = s + "@p_ledgerAddress3='" + manageleadger.getLedgerAddress3() + "',";
		}
		if (manageleadger.getLedgerCountry() != null || manageleadger.getLedgerCountry() != "") {
			s = s + "@p_ledgerCountry='" + manageleadger.getLedgerCountry() + "',";
		}
		if (manageleadger.getLedgerState() != null || manageleadger.getLedgerState() != "") {
			s = s + "@p_ledgerState='" + manageleadger.getLedgerState() + "',";
		}
		if (manageleadger.getLedgerPinCode() != null || manageleadger.getLedgerPinCode() != "") {
			s = s + "@p_ledgerPinCode='" + manageleadger.getLedgerPinCode() + "',";
		}
		if (manageleadger.getLedgerPan() != null || manageleadger.getLedgerPan() != "") {
			s = s + "@p_ledgerPan='" + manageleadger.getLedgerPan() + "',";
		}
		if (manageleadger.getOpeninbalanceDate() != null || manageleadger.getOpeninbalanceDate() != "") {
			s = s + "@p_leaderopebal='" + manageleadger.getOpeninbalanceDate() + "',";
		}
		if (manageleadger.getOrganization() != null || manageleadger.getOrganization() != "") {
			s = s + "@p_org='" + manageleadger.getOrganization() + "',";
		}
		if (manageleadger.getOrgDivision() != null || manageleadger.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + manageleadger.getOrgDivision() + "',";
		}
		if (manageleadger.getLedgerMobile() != null || manageleadger.getLedgerMobile() != "") {
			s = s + "@p_ledgerMobile='" + manageleadger.getLedgerMobile() + "',";
		}
		if (manageleadger.getLedgerGst() != null || manageleadger.getLedgerGst() != "") {
			s = s + "@p_ledgerGst='" + manageleadger.getLedgerGst() + "',";
		}
		if (manageleadger.getLedgerType() != null || manageleadger.getLedgerType() != "") {
			s = s + "@p_ledgerType='" + manageleadger.getLedgerType() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}

	public static String addLedgerModalParam(RestManageLeadgerModel manageleadger) {

		String s = "";

		if (manageleadger.getLeadgerId() != null || manageleadger.getLeadgerId() != "") {
			s = s + "@p_leaderId='" + manageleadger.getLeadgerId() + "',";
		}
		if (manageleadger.getLedgername() != null || manageleadger.getLedgername() != "") {
			s = s + "@p_ledgerName='" + manageleadger.getLedgername() + "',";
		}
		if (manageleadger.getGroupId() != null || manageleadger.getGroupId() != "") {
			s = s + "@p_groupId='" + manageleadger.getGroupId() + "',";
		}
		if (manageleadger.getLedgerEmail() != null || manageleadger.getLedgerEmail() != "") {
			s = s + "@p_ledgerEmail='" + manageleadger.getLedgerEmail() + "',";
		}
		if (manageleadger.getLedgerAddress1() != null || manageleadger.getLedgerAddress1() != "") {
			s = s + "@p_ledgerAddress1='" + manageleadger.getLedgerAddress1() + "',";
		}
		if (manageleadger.getLedgerAddress2() != null || manageleadger.getLedgerAddress2() != "") {
			s = s + "@p_ledgerAddress2='" + manageleadger.getLedgerAddress2() + "',";
		}
		if (manageleadger.getLedgerAddress3() != null || manageleadger.getLedgerAddress3() != "") {
			s = s + "@p_ledgerAddress3='" + manageleadger.getLedgerAddress3() + "',";
		}
		if (manageleadger.getLedgerCountry() != null || manageleadger.getLedgerCountry() != "") {
			s = s + "@p_ledgerCountry='" + manageleadger.getLedgerCountry() + "',";
		}
		if (manageleadger.getLedgerState() != null || manageleadger.getLedgerState() != "") {
			s = s + "@p_ledgerState='" + manageleadger.getLedgerState() + "',";
		}
		if (manageleadger.getLedgerPinCode() != null || manageleadger.getLedgerPinCode() != "") {
			s = s + "@p_ledgerPinCode='" + manageleadger.getLedgerPinCode() + "',";
		}
		if (manageleadger.getLedgerMobile() != null || manageleadger.getLedgerMobile() != "") {
			s = s + "@p_ledgerMobile='" + manageleadger.getLedgerMobile() + "',";
		}
		if (manageleadger.getLedgerPan() != null || manageleadger.getLedgerPan() != "") {
			s = s + "@p_ledgerPan='" + manageleadger.getLedgerPan() + "',";
		}
		if (manageleadger.getLedgerGst() != null || manageleadger.getLedgerGst() != "") {
			s = s + "@p_ledgerGst='" + manageleadger.getLedgerGst() + "',";
		}
		if (manageleadger.getOrganization() != null || manageleadger.getOrganization() != "") {
			s = s + "@p_org='" + manageleadger.getOrganization() + "',";
		}
		if (manageleadger.getOrgDivision() != null || manageleadger.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + manageleadger.getOrgDivision() + "',";
		}
		/*
		 * if (manageleadger.getOpeninbalanceDate() != null ||
		 * manageleadger.getOpeninbalanceDate() != "") { s = s +
		 * "@p_openinbalanceDate='" + manageleadger.getOpeninbalanceDate() + "',"; }
		 */

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;
	}

}
