package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;

public class GenerateContactParameter {

	public static String getAddContactParam(RestContactModel form) {
		// TODO Auto-generated method stub
		String s = "";		
		
		if (form.getPipelineId() != null && form.getPipelineId() != "") {
			s = s + "@p_pipelineId='" + form.getPipelineId() + "',";
		}
		

		if (form.getContactOwner()!= null && form.getContactOwner() != "") {
			s = s + "@p_contactOwner='" + form.getContactOwner() + "',";
		}
		if (form.getLeadSource() != null) {
			s = s + "@p_leadSource='" + form.getLeadSource() + "',";
		}
		if (form.getFirstName() != null) {
			s = s + "@p_firstName='" + form.getFirstName() + "',";
		}
		if (form.getLastName() != null && form.getLastName() != "") {
			s = s + "@p_lastName='" + form.getLastName() + "',";
		}
		if (form.getAccountId() != null && form.getAccountId() != "") {
			s = s + "@p_accountId='" + form.getAccountId() + "',";
		}else {
		    s = s + "@p_accountId=null,";
		}
		if (form.getAccountName() != null && form.getAccountName() != "") {
			s = s + "@p_accountName='" + form.getAccountName() + "',";
		}
		
		if (form.getTitle() != null && form.getTitle() != "") {
			s = s + "@p_title='" + form.getTitle() + "',";
		}
		
		if(form.getReferenceContact()!=null && form.getReferenceContact()!="")
		{
			s = s + "@p_referenceContact='" + form.getReferenceContact()+ "',";
		}
		
		if (form.getEmail() != null && form.getEmail() != "") {
			s = s + "@p_email='" + form.getEmail() + "',";
		}
		
		if (form.getDepartment() != null && form.getDepartment() != "") {
			s = s + "@p_department='" + form.getDepartment() + "',";
		}
		if (form.getPhone() != null && form.getPhone() != "") {
			s = s + "@p_phone='" + form.getPhone() + "',";
		}
				
	
		if (form.getHomePhone() != null && form.getHomePhone() != "") {
			s = s + "@p_homePhone='" + form.getHomePhone() + "',";
		}
		
		if (form.getOtherPhone() != null && form.getOtherPhone() != "") {
			s = s + "@p_otherPhone='" + form.getOtherPhone() + "',";
		}

		if (form.getFax() != null && form.getFax() != "") {
			s = s + "@p_fax='" + form.getFax() + "',";
		}
		if (form.getMobile() != null && form.getMobile() != "") {
			s = s + "@p_mobile='" + form.getMobile() + "',";
		}
		if (form.getDateBirth() != null && form.getDateBirth() != "") {
			s = s + "@p_dateBirth='" + form.getDateBirth() + "',";
		}
		if (form.getAssistant() != null && form.getAssistant() != "") {
			s = s + "@p_assistant='" + form.getAssistant() + "',";
		}
		if (form.getAssistPhone() != null && form.getAssistPhone() != "") {
			s = s + "@p_assistPhone='" + form.getAssistPhone() + "',";
		}
	
		
		if (form.getEmailOpt() != null && form.getEmailOpt() != "") {
			s = s + "@p_emailOpt='" + form.getEmailOpt() + "',";
		}
		if (form.getSkypeId() != null && form.getSkypeId() != "") {
			s = s + "@p_skypeId='" + form.getSkypeId() + "',";
		}
		if (form.getSecondaryEmail() != null && form.getSecondaryEmail() != "") {
			s = s + "@p_secondaryEmail='" + form.getSecondaryEmail() + "',";
		}
		if (form.getTwitter() != null && form.getTwitter() != "") {
			s = s + "@p_twitter='" + form.getTwitter() + "',";
		}
		if (form.getReportingTo() != null && form.getReportingTo() != "") {
			s = s + "@p_reportingTo='" + form.getReportingTo() + "',";
		}
		if (form.getMailingStreet() != null && form.getMailingStreet() != "") {
			s = s + "@p_mailingStreet='" + form.getMailingStreet() + "',";
		}
		if (form.getOtherMailing() != null && form.getOtherMailing() != "") {
			s = s + "@p_otherMailing='" + form.getOtherMailing() + "',";
		}
		if (form.getMailingCity() != null && form.getMailingCity() != "") {
			s = s + "@p_mailingCity='" + form.getMailingCity() + "',";
		}
		if (form.getOtherCity() != null && form.getOtherCity() != "") {
			s = s + "@p_otherCity='" + form.getOtherCity() + "',";
		}
		if (form.getMailingState() != null && form.getMailingState() != "") {
			s = s + "@p_mailingState='" + form.getMailingState() + "',";
		}
		if (form.getOtherState() != null && form.getOtherState() != "") {
			s = s + "@p_otherState='" + form.getOtherState() + "',";
		}
		if (form.getMailingZip() != null && form.getMailingZip() != "") {
			s = s + "@p_mailingZip='" + form.getMailingZip() + "',";
		}
		
		if (form.getOtherZip() != null && form.getOtherZip() != "") {
			s = s + "@p_otherZip='" + form.getOtherZip() + "',";
		}

		if (form.getMailingCountry() != null && form.getMailingCountry() != "") {
			s = s + "@p_mailingCountry='" + form.getMailingCountry() + "',";
		}
		if (form.getOtherCountry() != null && form.getOtherCountry() != "") {
			s = s + "@p_otherCountry='" + form.getOtherCountry() + "',";
		}
		
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription() + "',";
		}
		
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		
		if (form.getOrganization() != null && form.getOrganization() != "") {
			s = s + "@org='" + form.getOrganization() + "',";
		}
		
		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@orgDiv='" + form.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
	public static String getContactParam(RestContactModel form) {
		// TODO Auto-generated method stub
		String s = "";		
		
		if (form.getContactOwner()!= null && form.getContactOwner() != "") {
			s = s + "@p_contactOwner='" + form.getContactOwner() + "',";
		}
		if (form.getLeadSource() != null && form.getLeadSource() !="" ) {
			s = s + "@p_leadSource='" + form.getLeadSource() + "',";
		}
		if (form.getFirstName() != null && form.getFirstName() !="" ) {
			s = s + "@p_firstName='" + form.getFirstName() + "',";
		}
		if (form.getLastName() != null && form.getLastName() != "") {
			s = s + "@p_lastName='" + form.getLastName() + "',";
		}
		if (form.getAccountName() != null && form.getAccountName() != "") {
			s = s + "@p_accountName='" + form.getAccountName() + "',";
		}
		if (form.getTitle() != null && form.getTitle() != "") {
			s = s + "@p_title='" + form.getTitle() + "',";
		}
		if (form.getEmail() != null && form.getEmail() != "") {
			s = s + "@p_email='" + form.getEmail() + "',";
		}
		
		if (form.getDepartment() != null && form.getDepartment() != "") {
			s = s + "@p_department='" + form.getDepartment() + "',";
		}
		if (form.getPhone() != null && form.getPhone() != "") {
			s = s + "@p_phone='" + form.getPhone() + "',";
		}
		if (form.getHomePhone() != null && form.getHomePhone() != "") {
			s = s + "@p_homePhone='" + form.getHomePhone() + "',";
		}
		
		if (form.getOtherPhone() != null && form.getOtherPhone() != "") {
			s = s + "@p_otherPhone='" + form.getOtherPhone() + "',";
		}

		if (form.getFax() != null && form.getFax() != "") {
			s = s + "@p_fax='" + form.getFax() + "',";
		}
		if (form.getMobile() != null && form.getMobile() != "") {
			s = s + "@p_mobile='" + form.getMobile() + "',";
		}
		if (form.getDateBirth() != null && form.getDateBirth() != "") {
			s = s + "@p_dateBirth='" + form.getDateBirth() + "',";
		}
		if (form.getAssistant() != null && form.getAssistant() != "") {
			s = s + "@p_assistant='" + form.getAssistant() + "',";
		}
		if (form.getAssistPhone() != null && form.getAssistPhone() != "") {
			s = s + "@p_assistPhone='" + form.getAssistPhone() + "',";
		}
		if (form.getEmailOpt() != null && form.getEmailOpt() != "") {
			s = s + "@p_emailOpt='" + form.getEmailOpt() + "',";
		}
		if (form.getSkypeId() != null && form.getSkypeId() != "") {
			s = s + "@p_skypeId='" + form.getSkypeId() + "',";
		}
		if (form.getSecondaryEmail() != null && form.getSecondaryEmail() != "") {
			s = s + "@p_secondaryEmail='" + form.getSecondaryEmail() + "',";
		}
		if (form.getTwitter() != null && form.getTwitter() != "") {
			s = s + "@p_twitter='" + form.getTwitter() + "',";
		}
		if (form.getReportingTo() != null && form.getReportingTo() != "") {
			s = s + "@p_reportingTo='" + form.getReportingTo() + "',";
		}
		if (form.getMailingStreet() != null && form.getMailingStreet() != "") {
			s = s + "@p_mailingStreet='" + form.getMailingStreet() + "',";
		}
		if (form.getOtherMailing() != null && form.getOtherMailing() != "") {
			s = s + "@p_otherMailing='" + form.getOtherMailing() + "',";
		}
		if (form.getMailingCity() != null && form.getMailingCity() != "") {
			s = s + "@p_mailingCity='" + form.getMailingCity() + "',";
		}
		if (form.getOtherCity() != null && form.getOtherCity() != "") {
			s = s + "@p_otherCity='" + form.getOtherCity() + "',";
		}
		if (form.getMailingState() != null && form.getMailingState() != "") {
			s = s + "@p_mailingState='" + form.getMailingState() + "',";
		}
		if (form.getOtherState() != null && form.getOtherState() != "") {
			s = s + "@p_otherState='" + form.getOtherState() + "',";
		}
		if (form.getMailingZip() != null && form.getMailingZip() != "") {
			s = s + "@p_mailingZip='" + form.getMailingZip() + "',";
		}
		
		if (form.getOtherZip() != null && form.getOtherZip() != "") {
			s = s + "@p_otherZip='" + form.getOtherZip() + "',";
		}

		if (form.getMailingCountry() != null && form.getMailingCountry() != "") {
			s = s + "@p_mailingCountry='" + form.getMailingCountry() + "',";
		}
		if (form.getOtherCountry() != null && form.getOtherCountry() != "") {
			s = s + "@p_otherCountry='" + form.getOtherCountry() + "',";
		}
		
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		if (form.getOrganization() != null && form.getOrganization() != "") {
			s = s + "@org='" + form.getOrganization() + "',";
		}
		
		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@orgDiv='" + form.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
	
}
