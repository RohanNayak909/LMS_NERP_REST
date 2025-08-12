package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.pipeline.model.RestCrmOwnerModel;

public class GenerateCrmOwnerDetails {

public static String generateCrmOwnerParam(RestCrmOwnerModel crmModel) {
		
		String s="";
		
		if(crmModel.getOwnerId()!=null && crmModel.getOwnerId()!="")
		{
			s = s + "@p_ownerId='" + crmModel.getOwnerId()+ "',";
		}
		if(crmModel.getFirstName()!=null && crmModel.getFirstName()!="")
		{
			s = s + "@p_firstName='" + crmModel.getFirstName()+ "',";
		}
		if(crmModel.getLastName()!=null && crmModel.getLastName()!="")
		{
			s = s + "@p_lastName='" + crmModel.getLastName()+ "',";
		}
		if(crmModel.getOrganisationName()!=null && crmModel.getOrganisationName()!="")
		{
			s = s + "@p_organisationName='" + crmModel.getOrganisationName()+ "',";
		}
		if(crmModel.getEmail()!=null && crmModel.getEmail()!="")
		{
			s = s + "@p_email='" + crmModel.getEmail()+ "',";
		}
		if(crmModel.getPhone()!=null && crmModel.getPhone()!="")
		{
			s = s + "@p_phone='" + crmModel.getPhone()+ "',";
		}
		if(crmModel.getFax()!=null && crmModel.getFax()!="")
		{
			s = s + "@p_fax='" + crmModel.getFax()+ "',";
		}
		if(crmModel.getMobile()!=null && crmModel.getMobile()!="")
		{
			s = s + "@p_mobile='" + crmModel.getMobile()+ "',";
		}
		if(crmModel.getWebsite()!=null && crmModel.getWebsite()!="")
		{
			s = s + "@p_webSite='" + crmModel.getWebsite()+ "',";
		}
		if(crmModel.getIndustry()!=null && crmModel.getIndustry()!="")
		{
			s = s + "@p_industry='" + crmModel.getIndustry()+ "',";
		}
		
		if(crmModel.getSkypeId()!=null && crmModel.getSkypeId()!="")
		{
			s = s + "@p_skypeId='" + crmModel.getSkypeId()+ "',";
		}
		
		if(crmModel.getTwitter()!=null && crmModel.getTwitter()!="")
		{
			s = s + "@p_twitter='" + crmModel.getTwitter()+ "',";
		}
		if(crmModel.getCountry()!=null && crmModel.getCountry()!="")
		{
			s = s + "@p_country='" + crmModel.getCountry()+ "',";
		}
		if(crmModel.getStates()!=null && crmModel.getStates()!="")
		{
			s = s + "@p_states='" + crmModel.getStates()+ "',";
		}
		if(crmModel.getCity()!=null && crmModel.getCity()!="")
		{
			s = s + "@p_city='" + crmModel.getCity()+ "',";
		}
		if(crmModel.getAddressStreet()!=null && crmModel.getAddressStreet()!="")
		{
			s = s + "@p_addressStreet='" + crmModel.getAddressStreet()+ "',";
		}
		if(crmModel.getZip()!=null && crmModel.getZip()!="")
		{
			s = s + "@p_zip='" + crmModel.getZip()+ "',";
		}
		if(crmModel.getDescription()!=null && crmModel.getDescription()!="")
		{
			s = s + "@p_desc='" + crmModel.getDescription()+ "',";
		}
		
		if(crmModel.getImageName()!=null && crmModel.getImageName()!="")
		{
			s = s + "@p_image='" + crmModel.getImageName()+ "',";
		}
		if(crmModel.getStatus()!=null && crmModel.getStatus()!="")
		{
			s = s + "@p_status='" + crmModel.getStatus()+ "',";
		}
		if(crmModel.getSecondaryMail()!=null && crmModel.getSecondaryMail()!="")
		{
			s = s + "@p_secEmail='" + crmModel.getSecondaryMail()+ "',";
		}
		if(crmModel.getOwnerDob()!=null && crmModel.getOwnerDob()!="")
		{
			
			;
			s = s + "@p_dob='" + DateFormatter.getStringDate(crmModel.getOwnerDob())+ "',";
		}
		
		if(crmModel.getWhatsappNumber()!=null && crmModel.getWhatsappNumber()!="")
		{
			s = s + "@p_wpNumber='" + crmModel.getWhatsappNumber()+ "',";
		}
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		return s;
	}
}
