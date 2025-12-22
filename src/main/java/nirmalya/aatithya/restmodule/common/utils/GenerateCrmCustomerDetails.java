package nirmalya.aatithya.restmodule.common.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;

public class GenerateCrmCustomerDetails {

	public static String generateCrmCustomerParam(RestCrmCustomerModel crmModel) {
		String s="";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		if(crmModel.getCustomerId()!=null && crmModel.getCustomerId()!="")
		{
			s = s + "@p_customerId='" + crmModel.getCustomerId()+ "',";
		}
		
		if(crmModel.getExecutive()!=null && crmModel.getExecutive()!="")
		{
			s = s + "@p_executive='" + crmModel.getExecutive()+ "',";
		}
		
		if(crmModel.getCustomerName()!=null && crmModel.getCustomerName()!="")
		{
			s = s + "@p_custName='" + crmModel.getCustomerName()+ "',";
		}
		
		if(crmModel.getCompanyName()!=null && crmModel.getCompanyName()!="")
		{
			s = s + "@p_comName='" + crmModel.getCompanyName()+ "',";
		}
		
		if(crmModel.getCompanyOwner()!=null && crmModel.getCompanyOwner()!="")
		{
			s = s + "@p_companyOwner='" + crmModel.getCompanyOwner()+ "',";
		}
		
		if(crmModel.getCustomerMail()!=null && crmModel.getCustomerMail()!="")
		{
			s = s + "@p_customerMail='" + crmModel.getCustomerMail()+ "',";
		}
		
		if(crmModel.getCustomerPhone()!=null && crmModel.getCustomerPhone()!="")
		{
			s = s + "@p_customerPhone='" + crmModel.getCustomerPhone()+ "',";
		}
		
		if(crmModel.getDesignation()!=null && crmModel.getDesignation()!="")
		{
			s = s + "@p_designation='" + crmModel.getDesignation()+ "',";
		}
		
		if(crmModel.getCompanyGst()!=null && crmModel.getCompanyGst()!="")
		{
			s = s + "@p_companyGst='" + crmModel.getCompanyGst()+ "',";
		}
		
		if(crmModel.getCompanyPAN()!=null && crmModel.getCompanyPAN()!="")
		{
			s = s + "@p_companyPan='" + crmModel.getCompanyPAN()+ "',";
		}
		
		if(crmModel.getReferenceContact()!=null && crmModel.getReferenceContact()!="")
		{
			s = s + "@p_referenceContact='" + crmModel.getReferenceContact()+ "',";
		}
		
		if(crmModel.getLeadSource()!=null && crmModel.getLeadSource()!="")
		{
			s = s + "@p_leadSource='" + crmModel.getLeadSource()+ "',";
		}
		
		if(crmModel.getLeadStatus()!=null && crmModel.getLeadStatus()!="")
		{
			s = s + "@p_leadStatus='" + crmModel.getLeadStatus()+ "',";
		}
		
		if(crmModel.getIndustry()!=null && crmModel.getIndustry()!="")
		{
			s = s + "@p_industry='" + crmModel.getIndustry()+ "',";
		}
		
		if(crmModel.getDecisionMaker1()!=null && crmModel.getDecisionMaker1()!="")
		{
			s = s + "@p_decisionMaker1='" + crmModel.getDecisionMaker1()+ "',";
		}
		
		if(crmModel.getEmail1()!=null && crmModel.getEmail1()!="")
		{
			s = s + "@p_email1='" + crmModel.getEmail1()+ "',";
		}
		
		if(crmModel.getPhone1()!=null && crmModel.getPhone1()!="")
		{
			s = s + "@p_phone1='" + crmModel.getPhone1()+ "',";
		}		
		
		if(crmModel.getDesignation1()!=null && crmModel.getDesignation1()!="")
		{
			s = s + "@p_designation1='" + crmModel.getDesignation1()+ "',";
		}
		
		if(crmModel.getDob1()!=null && crmModel.getDob1()!="")
		{
			s = s + "@p_dob1='" + crmModel.getDob1()+ "',";
		}
		
		if(crmModel.getMarriageAnniversary1()!=null && crmModel.getMarriageAnniversary1()!="")
		{
			s = s + "@p_marriageAnniversary1='" + crmModel.getMarriageAnniversary1()+ "',";
		}
		
		if(crmModel.getDecisionMaker2()!=null && crmModel.getDecisionMaker2()!="")
		{
			s = s + "@p_decisionMaker2='" + crmModel.getDecisionMaker2()+ "',";
		}
		
		if(crmModel.getEmail2()!=null && crmModel.getEmail2()!="")
		{
			s = s + "@p_email2='" + crmModel.getEmail2()+ "',";
		}
		
		if(crmModel.getPhone2()!=null && crmModel.getPhone2()!="")
		{
			s = s + "@p_phone2='" + crmModel.getPhone2()+ "',";
		}		
		
		if(crmModel.getDesignation2()!=null && crmModel.getDesignation2()!="")
		{
			s = s + "@p_designation2='" + crmModel.getDesignation2()+ "',";
		}
		
		if(crmModel.getDob2()!=null && crmModel.getDob2()!="")
		{
			s = s + "@p_dob2='" + crmModel.getDob2()+ "',";
		}
		
		if(crmModel.getMarriageAnniversary2()!=null && crmModel.getMarriageAnniversary2()!="")
		{
			s = s + "@p_marriageAnniversary2='" + crmModel.getMarriageAnniversary2()+ "',";
		}
			
		
		if(crmModel.getDecisionMaker3()!=null && crmModel.getDecisionMaker3()!="")
		{
			s = s + "@p_decisionMaker3='" + crmModel.getDecisionMaker3()+ "',";
		}
		
		if(crmModel.getEmail3()!=null && crmModel.getEmail3()!="")
		{
			s = s + "@p_email3='" + crmModel.getEmail3()+ "',";
		}
		
		if(crmModel.getPhone3()!=null && crmModel.getPhone3()!="")
		{
			s = s + "@p_phone3='" + crmModel.getPhone3()+ "',";
		}		
		
		if(crmModel.getDesignation3()!=null && crmModel.getDesignation3()!="")
		{
			s = s + "@p_designation3='" + crmModel.getDesignation3()+ "',";
		}
		
		if(crmModel.getDob3()!=null && crmModel.getDob3()!="")
		{
			s = s + "@p_dob3='" + crmModel.getDob3()+ "',";
		}
		
		if(crmModel.getMarriageAnniversary3()!=null && crmModel.getMarriageAnniversary3()!="")
		{
			s = s + "@p_marriageAnniversary3='" + crmModel.getMarriageAnniversary3()+ "',";
		}
		
		if(crmModel.getCountry()!=null && crmModel.getCountry()!="")
		{
			s = s + "@p_country='" + crmModel.getCountry()+ "',";
		}
		
		if(crmModel.getStates()!=null && crmModel.getStates()!="")
		{
			s = s + "@p_state='" + crmModel.getStates()+ "',";
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
		
		
		
		if(crmModel.getCreatedBy()!=null && crmModel.getCreatedBy()!="")
		{
			s = s + "@p_createdBy='" + crmModel.getCreatedBy()+ "',";
		}
		
		
		
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		return s;
	}
	
	
}
