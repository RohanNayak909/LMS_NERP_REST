package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestOrganisationTypeModel;

public class GenerateOrgMasterParameter {

	public static String addOrgType(RestOrganisationTypeModel restOrganisationTypeModel) {

		String s = "";

		if (restOrganisationTypeModel.getOrgId() != null || restOrganisationTypeModel.getOrgId() != "") {
			s = s + "@p_OrgId='" + restOrganisationTypeModel.getOrgId() + "',";
		}
		if (restOrganisationTypeModel.getOrgName() != null || restOrganisationTypeModel.getOrgName() != "") {
			s = s + "@p_OrgName='" + restOrganisationTypeModel.getOrgName() + "',";
		}

		if (restOrganisationTypeModel.getStatus() != null || restOrganisationTypeModel.getStatus() != "") {
			s = s + "@p_Status='" + restOrganisationTypeModel.getStatus() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss" + s);
		return s;
	}

	public static String addOrgTypeHoliday(RestOrganisationTypeModel restOrganisationTypeModel) {

		String s = "";

		if (restOrganisationTypeModel.getHolidayId() != null || restOrganisationTypeModel.getHolidayId() != "") {
			s = s + "@p_HolidayId=\"" + restOrganisationTypeModel.getHolidayId() + "\",";
		}

		if (restOrganisationTypeModel.getHolidayName() != null || restOrganisationTypeModel.getHolidayName() != "") {
			s = s + "@p_HolidayName=\"" + restOrganisationTypeModel.getHolidayName() + "\",";
		}
		if (restOrganisationTypeModel.getFromDate() != null || restOrganisationTypeModel.getFromDate() != "") {
			s = s + "@p_FromDate=\"" + restOrganisationTypeModel.getFromDate() + "\",";
		}

		if (restOrganisationTypeModel.getToDate() != null || restOrganisationTypeModel.getToDate() != "") {
			s = s + "@p_ToDate=\"" + restOrganisationTypeModel.getToDate() + "\",";
		}

		if (restOrganisationTypeModel.getTotalHoliday() != null || restOrganisationTypeModel.getTotalHoliday() != "") {
			s = s + "@p_TotalHoliday=\"" + restOrganisationTypeModel.getTotalHoliday() + "\",";
		}
		if (restOrganisationTypeModel.getLeavePolicyCreatedBy() != null
				|| restOrganisationTypeModel.getLeavePolicyCreatedBy() != "") {
			s = s + "@p_createdBy=\"" + restOrganisationTypeModel.getLeavePolicyCreatedBy() + "\",";
		}
		if (restOrganisationTypeModel.getOrganization() != null
				|| restOrganisationTypeModel.getOrganization() != "") {
			s = s + "@p_orgName='" + restOrganisationTypeModel.getOrganization() + "',";
		}
		if (restOrganisationTypeModel.getOrgDivision() != null
				|| restOrganisationTypeModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restOrganisationTypeModel.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss" + s);
		return s;
	}

	public static String addBankDetails(RestOrganisationTypeModel restOrganisationTypeModel) {

		String s = "";

		if (restOrganisationTypeModel.getBankId() != null || restOrganisationTypeModel.getBankId() != "") {
			s = s + "@p_BankId=\"" + restOrganisationTypeModel.getBankId() + "\",";
		}

		if (restOrganisationTypeModel.getBankName() != null || restOrganisationTypeModel.getBankName() != "") {
			s = s + "@p_BankName=\"" + restOrganisationTypeModel.getBankName() + "\",";
		}
		if (restOrganisationTypeModel.getDescription() != null || restOrganisationTypeModel.getDescription() != "") {
			s = s + "@p_Description=\"" + restOrganisationTypeModel.getDescription() + "\",";
		}

		if (restOrganisationTypeModel.getBankStatus() == true || restOrganisationTypeModel.getBankStatus() == false) {
			s = s + "@p_BankStatus=" + restOrganisationTypeModel.getBankStatus() + ",";
		}

		if (restOrganisationTypeModel.getCreatedBy() != null || restOrganisationTypeModel.getCreatedBy() != "") {
			s = s + "@p_CreatedBy=\"" + restOrganisationTypeModel.getCreatedBy() + "\",";
		}
		if (restOrganisationTypeModel.getOrganization() != null
				|| restOrganisationTypeModel.getOrganization() != "") {
			s = s + "@p_orgName='" + restOrganisationTypeModel.getOrganization() + "',";
		}
		if (restOrganisationTypeModel.getOrgDivision() != null
				|| restOrganisationTypeModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restOrganisationTypeModel.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss" + s);
		return s;
	}

	public static String addAnnouncement(RestOrganisationTypeModel restOrganisationTypeModel) {

		String s = "";

		if (restOrganisationTypeModel.getAnnouncementId() != null
				|| restOrganisationTypeModel.getAnnouncementId() != "") {
			s = s + "@p_AnncId=\"" + restOrganisationTypeModel.getAnnouncementId() + "\",";
		}

		if (restOrganisationTypeModel.getDateAnnounce() != null || restOrganisationTypeModel.getDateAnnounce() != "") {
			s = s + "@p_dateAnnounce=\"" + restOrganisationTypeModel.getDateAnnounce() + "\",";
		}
		if (restOrganisationTypeModel.getAncdtlSub() != null || restOrganisationTypeModel.getAncdtlSub() != "") {
			s = s + "@p_AnncSub=\"" + restOrganisationTypeModel.getAncdtlSub() + "\",";
		}
		if (restOrganisationTypeModel.getAncdtlDetails() != null
				|| restOrganisationTypeModel.getAncdtlDetails() != "") {
			s = s + "@p_AnncDtls=\"" + restOrganisationTypeModel.getAncdtlDetails() + "\",";
		}

		if (restOrganisationTypeModel.getAncdtlURL() != null || restOrganisationTypeModel.getAncdtlURL() != "") {
			s = s + "@p_AnncUrl=\"" + restOrganisationTypeModel.getAncdtlURL() + "\",";
		}

		if (restOrganisationTypeModel.getAncdtlStatus() != null) {
			s = s + "@p_AnncStatus=\"" + restOrganisationTypeModel.getAncdtlStatus() + "\",";
		}
		if (restOrganisationTypeModel.getCreatedByAnnouncement() != null
				|| restOrganisationTypeModel.getCreatedByAnnouncement() != "") {
			s = s + "@p_AnncCreatedBy=\"" + restOrganisationTypeModel.getCreatedByAnnouncement() + "\",";
		}
		if (restOrganisationTypeModel.getOrganization() != null || restOrganisationTypeModel.getOrganization() != "") {
			s = s + "@p_org='" + restOrganisationTypeModel.getOrganization() + "',";
		}
		if (restOrganisationTypeModel.getOrgDivision() != null || restOrganisationTypeModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restOrganisationTypeModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss" + s);
		return s;
	}

	// Leave Add

	public static String addleavepolicy(RestOrganisationTypeModel restOrganisationTypeModel) {

		String s = "";

		if (restOrganisationTypeModel.getLeavePolicyId() != null
				|| restOrganisationTypeModel.getLeavePolicyId() != "") {
			s = s + "@p_PolicylId=\"" + restOrganisationTypeModel.getLeavePolicyId() + "\",";
		}

		if (restOrganisationTypeModel.getLeaveFromDate() != null
				|| restOrganisationTypeModel.getLeaveFromDate() != "") {
			s = s + "@p_fromDate=\"" + restOrganisationTypeModel.getLeaveFromDate() + "\",";
		}
		if (restOrganisationTypeModel.getLeaveToDate() != null || restOrganisationTypeModel.getLeaveToDate() != "") {
			s = s + "@p_toDate=\"" + restOrganisationTypeModel.getLeaveToDate() + "\",";
		}
		if (restOrganisationTypeModel.getLeavePolicyDtls() != null
				|| restOrganisationTypeModel.getLeavePolicyDtls() != "") {
			s = s + "@p_policyDtls=\"" + restOrganisationTypeModel.getLeavePolicyDtls() + "\",";
		}

		if (restOrganisationTypeModel.getLeavePolicyStatus() != null
				|| restOrganisationTypeModel.getLeavePolicyStatus() != "") {
			s = s + "@p_status=\"" + restOrganisationTypeModel.getLeavePolicyStatus() + "\",";
		}
		if (restOrganisationTypeModel.getLeavePolicyCreatedBy() != null
				|| restOrganisationTypeModel.getLeavePolicyCreatedBy() != "") {
			s = s + "@p_createdBy=\"" + restOrganisationTypeModel.getLeavePolicyCreatedBy() + "\",";
		}
		if (restOrganisationTypeModel.getLeavePolicyOrgName() != null
				|| restOrganisationTypeModel.getLeavePolicyOrgName() != "") {
			s = s + "@p_orgName='" + restOrganisationTypeModel.getLeavePolicyOrgName() + "',";
		}
		if (restOrganisationTypeModel.getLeavePolicyorgDivision() != null
				|| restOrganisationTypeModel.getLeavePolicyorgDivision() != "") {
			s = s + "@p_orgDiv='" + restOrganisationTypeModel.getLeavePolicyorgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss" + s);
		return s;
	}

}