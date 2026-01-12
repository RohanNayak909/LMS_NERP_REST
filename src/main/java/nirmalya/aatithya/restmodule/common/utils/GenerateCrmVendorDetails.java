package nirmalya.aatithya.restmodule.common.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;

public class GenerateCrmVendorDetails {

public static String generateCrmVendorParam(RestCrmVendorModel crmModel) {
		
		String s="";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		if(crmModel.getVendorId()!=null && crmModel.getVendorId()!="")
		{
			s = s + "@p_vendorId='" + crmModel.getVendorId()+ "',";
		}
		if(crmModel.getVendorOwner()!=null && crmModel.getVendorOwner()!="")
		{
			s = s + "@p_vendorOwner='" + crmModel.getVendorOwner()+ "',";
		}
		
		if(crmModel.getVendorName()!=null && crmModel.getVendorName()!="")
		{
			s = s + "@p_vendorName='" + crmModel.getVendorName()+ "',";
		}
		if(crmModel.getVendorPhone()!=null && crmModel.getVendorPhone()!="")
		{
			s = s + "@p_vendorPhone='" + crmModel.getVendorPhone()+ "',";
		}
		if(crmModel.getVendorEmail()!=null && crmModel.getVendorEmail()!="")
		{
			s = s + "@p_vendorEmail='" + crmModel.getVendorEmail()+ "',";
		}
		
		if(crmModel.getVendorWebsite()!=null && crmModel.getVendorWebsite()!="")
		{
			s = s + "@p_vendorWebsite='" + crmModel.getVendorWebsite()+ "',";
		}
		if(crmModel.getGlaAccount()!=null && crmModel.getGlaAccount()!="")
		{
			s = s + "@p_glaAccount='" + crmModel.getGlaAccount()+ "',";
		}
		if(crmModel.getVendorCategory()!=null && crmModel.getVendorCategory()!="")
		{
			s = s + "@p_vendorCategory='" + crmModel.getVendorCategory()+ "',";
		}
		if(crmModel.getVendorStreet()!=null && crmModel.getVendorStreet()!="")
		{
			s = s + "@p_street='" + crmModel.getVendorStreet()+ "',";
		}
		if(crmModel.getVendorCity()!=null && crmModel.getVendorCity()!="")
		{
			s = s + "@p_city='" + crmModel.getVendorCity()+ "',";
		}
		if(crmModel.getVendorState()!=null && crmModel.getVendorState()!="")
		{
			s = s + "@p_state='" + crmModel.getVendorState()+ "',";
		}
		if(crmModel.getVendorZipCode()!=null && crmModel.getVendorZipCode()!="")
		{
			s = s + "@p_zipCode='" + crmModel.getVendorZipCode()+ "',";
		}
		if(crmModel.getVendorCountry()!=null && crmModel.getVendorCountry()!="")
		{
			s = s + "@p_vendorCountry='" + crmModel.getVendorCountry()+ "',";
		}
		
		if(crmModel.getDescription()!=null && crmModel.getDescription()!="")
		{
			s = s + "@p_desc='" + crmModel.getDescription()+ "',";
		}
		
		if(crmModel.getImageName()!=null && crmModel.getImageName()!="")
		{
			s = s + "@p_image='" + crmModel.getImageName()+ "',";
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
