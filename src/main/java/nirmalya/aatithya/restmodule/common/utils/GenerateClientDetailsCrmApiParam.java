package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.api.model.CustomerProfileApiModel;
import nirmalya.aatithya.restmodule.api.model.EmployeeProfileApiModel;
import nirmalya.aatithya.restmodule.api.model.RegistrationRestCrmModel;
import nirmalya.aatithya.restmodule.api.model.RestDirecterManagerCrmModel;

public class GenerateClientDetailsCrmApiParam {
	public static String getAddClientParam(List<RegistrationRestCrmModel> client) {
		String s = "";
		String listdata = "";
		String clientId = "";
		String industry = "";
		String sectorName = "";
		String cmpName = "";
		String cmpEmail = "";
		String cmpPhone = "";
		String cmpAddress = "";
		String cmpLandMark = "";
		String cmpPinCode = "";
		String gst = "";
		String pan = "";
		String webSite = "";
		String leadSource = "";
		String leadstatus = "";
		String totalEmp = "";
		String empDesc = "";
		String createdBy = "";
		String orgName = "";
		String orgDiv = "";

		for (RegistrationRestCrmModel m : client) {

			clientId = m.getClientId();
			industry = m.getIndustry();
			sectorName = m.getSectorName();
			cmpName = m.getCmpName();
			cmpEmail = m.getCmpEmail();
			cmpPhone = m.getCmpPhone();
			cmpAddress = m.getCmpAddress();
			cmpLandMark = m.getCmpLandMark();
			cmpPinCode = m.getCmpPinCode();
			gst = m.getGst();
			pan = m.getPan();
			webSite = m.getWebSite();
			leadSource = m.getLeadSource();
			leadstatus = m.getLeadstatus();
			totalEmp = m.getTotalEmp();
			empDesc = m.getEmpDesc();
			createdBy = m.getCreatedBy();
			orgName = m.getOrgName();
			orgDiv = m.getOrgDiv();

		}

		s = s + "@p_clientId='" + clientId + "',";
		s = s + "@p_industry='" + industry + "',";
		s = s + "@p_sectorName='" + sectorName + "',";
		s = s + "@p_cmpName=\"" + cmpName + "\",";
		s = s + "@p_cmpEmail=\"" + cmpEmail + "\",";
		s = s + "@p_cmpPhone=\"" + cmpPhone + "\",";
		s = s + "@p_cmpAddress=\"" + cmpAddress + "\",";
		s = s + "@p_cmpLandMark=\"" + cmpLandMark + "\",";
		s = s + "@p_cmpPinCode=\"" + cmpPinCode + "\",";
		s = s + "@p_gst=\"" + gst + "\",";
		s = s + "@p_pan=\"" + pan + "\",";
		s = s + "@p_webSite=\"" + webSite + "\",";
		s = s + "@p_leadSource=\"" + leadSource + "\",";
		s = s + "@p_leadstatus=\"" + leadstatus + "\",";
		s = s + "@p_totalEmp=\"" + totalEmp + "\",";
		s = s + "@p_empDesc=\"" + empDesc + "\",";
		s = s + "@p_createdBy=\"" + createdBy + "\",";
		s = s + "@p_orgName=\"" + orgName + "\",";
		s = s + "@p_orgDiv=\"" + orgDiv + "\",";

		for (RegistrationRestCrmModel m : client) {
			List<RestDirecterManagerCrmModel> dlist = m.getDmList();
			for (RestDirecterManagerCrmModel a : dlist) {
				if (a.getDmId() == null || a.getDmId() == "") {
					listdata = listdata + "(@p_clientId,\"" + a.getDmName() + "\",\"" + a.getDmEmail() + "\",\""
							+ a.getDmPhone() + "\",\"" + a.getDmDesignation() + "\",\"" + a.getDmDob() + "\",\""
							+ a.getDmMarriageDate() + "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrgName() + "\",\""
							+ m.getOrgDiv() + "\"),";
				}
			}
		}
		System.out.println("listdata===" + listdata);
		if (listdata.isEmpty() || listdata.equals("") || listdata.equals("null")) {
			s = s + "@p_childSubQuery='',";
		} else {
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_childSubQuery='" + listdata + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("Client Details" + s);
		return s;
	}

	public static String getModifyDecisionMakerParam(RestDirecterManagerCrmModel restDirecterManagerCrmModel) {

		String s = "";

		if (restDirecterManagerCrmModel.getDmId() != null && restDirecterManagerCrmModel.getDmId() != "") {
			s = s + "@p_dmId='" + restDirecterManagerCrmModel.getDmId() + "',";
		}
		if (restDirecterManagerCrmModel.getDmName() != null && restDirecterManagerCrmModel.getDmName() != "") {
			s = s + "@p_dmName='" + restDirecterManagerCrmModel.getDmName() + "',";
		}
		if (restDirecterManagerCrmModel.getClientId() != null && restDirecterManagerCrmModel.getClientId() != "") {
			s = s + "@p_dmClient='" + restDirecterManagerCrmModel.getClientId() + "',";
		}
		if (restDirecterManagerCrmModel.getDmEmail() != null && restDirecterManagerCrmModel.getDmEmail() != "") {
			s = s + "@p_dmMail='" + restDirecterManagerCrmModel.getDmEmail() + "',";
		}
		if (restDirecterManagerCrmModel.getDmPhone() != null && restDirecterManagerCrmModel.getDmPhone() != "") {
			s = s + "@p_dmPhone='" + restDirecterManagerCrmModel.getDmPhone() + "',";
		}
		if (restDirecterManagerCrmModel.getDmDesignation() != null
				&& restDirecterManagerCrmModel.getDmDesignation() != "") {
			s = s + "@p_dmDesignation='" + restDirecterManagerCrmModel.getDmDesignation() + "',";
		}
		if (restDirecterManagerCrmModel.getDmDob() != null && restDirecterManagerCrmModel.getDmDob() != "") {
			s = s + "@p_dmDob='" + restDirecterManagerCrmModel.getDmDob() + "',";
		}
		if (restDirecterManagerCrmModel.getDmMarriageDate() != null
				&& restDirecterManagerCrmModel.getDmMarriageDate() != "") {
			s = s + "@p_dmMrgDate='" + restDirecterManagerCrmModel.getDmMarriageDate() + "',";
		}
		if (restDirecterManagerCrmModel.getCreatedBy() != null && restDirecterManagerCrmModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restDirecterManagerCrmModel.getCreatedBy() + "',";
		}
		if (restDirecterManagerCrmModel.getOrg() != null && restDirecterManagerCrmModel.getOrg() != "") {
			s = s + "@p_org='" + restDirecterManagerCrmModel.getOrg() + "',";
		}
		if (restDirecterManagerCrmModel.getOrgDiv() != null && restDirecterManagerCrmModel.getOrgDiv() != "") {
			s = s + "@p_div='" + restDirecterManagerCrmModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("zoneG" + s);

		return s;
	}

	public static String generateClientProfileUploadParam(CustomerProfileApiModel customer) {

		String s = "";

		if (customer.getCustomerId() != null && customer.getCustomerId() != "") {
			s = s + "@p_customerId='" + customer.getCustomerId() + "',";
		}
		if (customer.getDocName() != null && customer.getDocName() != "") {
			s = s + "@p_docName='" + customer.getDocName() + "',";
		}
		if (customer.getOrganization() != null || customer.getOrganization() != "") {
			s = s + "@p_org='" + customer.getOrganization() + "',";
		}
		if (customer.getOrgDivision() != null || customer.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + customer.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		return s;
	}

	public static String generateClientDetailsByAdmin(RegistrationRestCrmModel registrationRestCrmModel) {
		String s = "";

		if (registrationRestCrmModel.getClientId() != null && registrationRestCrmModel.getClientId() != "") {
			s = s + "@p_clientId='" + registrationRestCrmModel.getClientId() + "',";
		}
		if (registrationRestCrmModel.getIndustry() != null && registrationRestCrmModel.getIndustry() != "") {
			s = s + "@p_industry='" + registrationRestCrmModel.getIndustry() + "',";
		}

		if (registrationRestCrmModel.getProfileImg() != null && registrationRestCrmModel.getProfileImg() != "") {
			s = s + "@p_profile='" + registrationRestCrmModel.getProfileImg() + "',";
		}

		if (registrationRestCrmModel.getSectorName() != null && registrationRestCrmModel.getSectorName() != "") {
			s = s + "@p_sectorName='" + registrationRestCrmModel.getSectorName() + "',";
		}
		if (registrationRestCrmModel.getCmpName() != null && registrationRestCrmModel.getCmpName() != "") {
			s = s + "@p_cmpName=\'" + registrationRestCrmModel.getCmpName() + "\',";
		}
		if (registrationRestCrmModel.getCmpEmail() != null && registrationRestCrmModel.getCmpEmail() != "") {
			s = s + "@p_cmpEmail=\'" + registrationRestCrmModel.getCmpEmail() + "\',";
		}
		if (registrationRestCrmModel.getCmpPhone() != null && registrationRestCrmModel.getCmpPhone() != "") {
			s = s + "@p_cmpPhone=\'" + registrationRestCrmModel.getCmpPhone() + "\',";
		}
		if (registrationRestCrmModel.getCmpAddress() != null && registrationRestCrmModel.getCmpAddress() != "") {
			s = s + "@p_cmpAddress=\'" + registrationRestCrmModel.getCmpAddress() + "\',";
		}
		if (registrationRestCrmModel.getCmpLandMark() != null && registrationRestCrmModel.getCmpLandMark() != "") {
			s = s + "@p_cmpLandMark=\'" + registrationRestCrmModel.getCmpLandMark() + "\',";
		}
		if (registrationRestCrmModel.getCmpPinCode() != null && registrationRestCrmModel.getCmpPinCode() != "") {
			s = s + "@p_cmpPinCode=\'" + registrationRestCrmModel.getCmpPinCode() + "\',";
		}
		if (registrationRestCrmModel.getGst() != null && registrationRestCrmModel.getGst() != "") {
			s = s + "@p_gst=\'" + registrationRestCrmModel.getGst() + "\',";
		}

		if (registrationRestCrmModel.getPan() != null && registrationRestCrmModel.getPan() != "") {
			s = s + "@p_pan=\'" + registrationRestCrmModel.getPan() + "\',";
		}

		if (registrationRestCrmModel.getWebSite() != null && registrationRestCrmModel.getWebSite() != "") {
			s = s + "@p_webSite=\'" + registrationRestCrmModel.getWebSite() + "\',";
		}

		if (registrationRestCrmModel.getLeadSource() != null && registrationRestCrmModel.getLeadSource() != "") {
			s = s + "@p_leadSource=\'" + registrationRestCrmModel.getLeadSource() + "\',";
		}

		if (registrationRestCrmModel.getLeadstatus() != null && registrationRestCrmModel.getLeadstatus() != "") {
			s = s + "@p_leadstatus=\'" + registrationRestCrmModel.getLeadstatus() + "\',";
		}

		if (registrationRestCrmModel.getTotalEmp() != null && registrationRestCrmModel.getTotalEmp() != "") {
			s = s + "@p_totalEmp=\'" + registrationRestCrmModel.getTotalEmp() + "\',";
		}

		if (registrationRestCrmModel.getEmpDesc() != null && registrationRestCrmModel.getEmpDesc() != "") {
			s = s + "@p_empDesc=\'" + registrationRestCrmModel.getEmpDesc() + "\',";
		}

		if (registrationRestCrmModel.getCreatedBy() != null && registrationRestCrmModel.getCreatedBy() != "") {
			s = s + "@p_createdBy=\'" + registrationRestCrmModel.getCreatedBy() + "\',";
		}

		if (registrationRestCrmModel.getOrgName() != null && registrationRestCrmModel.getOrgName() != "") {
			s = s + "@p_org='" + registrationRestCrmModel.getOrgName() + "',";
		}
		if (registrationRestCrmModel.getOrgDiv() != null && registrationRestCrmModel.getOrgDiv() != "") {
			s = s + "@p_div='" + registrationRestCrmModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("zoneG" + s);

		return s;
	}
}