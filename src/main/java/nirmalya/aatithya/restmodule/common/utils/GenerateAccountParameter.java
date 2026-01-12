package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmAccountsModel;

public class GenerateAccountParameter {

	public static String getAddAccountParam(RestCrmAccountsModel form) {
		// TODO Auto-generated method stub
		String s = "";	
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		if (form.getAccountId() != null && form.getAccountId() != "") {
			s = s + "@p_accountId='" + form.getAccountId() + "',";
		}
		

		if (form.getAccountOwner()!= null && form.getAccountOwner() != "") {
			s = s + "@p_accountOwner='" + form.getAccountOwner() + "',";
		}
		if (form.getRating() != null && form.getRating() != "") {
			s = s + "@p_rating='" + form.getRating() + "',";
		}
		if (form.getAccountName() != null && form.getAccountName() != "") {
			s = s + "@p_accountName='" + form.getAccountName() + "',";
		}
		if (form.getPhone() != null && form.getPhone() != "") {
			s = s + "@p_phone='" + form.getPhone() + "',";
		}
		
		if (form.getAccountSite() != null && form.getAccountSite() != "") {
			s = s + "@p_accountSite='" + form.getAccountSite() + "',";
		}
		if (form.getFax() != null && form.getFax() != "") {
			s = s + "@p_fax='" + form.getFax() + "',";
		}
		
		if (form.getParentAccountId() != null && form.getParentAccountId() != "") {
			s = s + "@p_parentAccountId='" + form.getParentAccountId() + "',";
		}
		
		if (form.getParentAccount() != null && form.getParentAccount() != "") {
			s = s + "@p_parentAccount='" + form.getParentAccount() + "',";
		}
		
		if (form.getWebsite() != null && form.getWebsite() != "") {
			s = s + "@p_website='" + form.getWebsite() + "',";
		}
		
		
		if(form.getReferenceContact()!=null && form.getReferenceContact()!="")
		{
			s = s + "@p_referenceContact='" + form.getReferenceContact()+ "',";
		}
		
		
		if (form.getAccountNo() != null && form.getAccountNo() != "") {
			s = s + "@p_accountNo='" + form.getAccountNo() + "',";
		}
				
	
		if (form.getTicketSymbol() != null && form.getTicketSymbol() != "") {
			s = s + "@p_ticketSymbol='" + form.getTicketSymbol() + "',";
		}
		
		if (form.getAccountType() != null && form.getAccountType() != "") {
			s = s + "@p_accountType='" + form.getAccountType() + "',";
		}

		if (form.getOwnership() != null && form.getOwnership() != "") {
			s = s + "@p_ownership='" + form.getOwnership() + "',";
		}
		if (form.getIndustry() != null && form.getIndustry() != "") {
			s = s + "@p_industry='" + form.getIndustry() + "',";
		}
		if (form.getEmployee() != null && form.getEmployee() != "") {
			s = s + "@p_employee='" + form.getEmployee() + "',";
		}
		if (form.getAccountRevenue() != null && form.getAccountRevenue() != "") {
			s = s + "@p_accountRevenue='" + form.getAccountRevenue() + "',";
		}
		if (form.getSicCode() != null && form.getSicCode() != "") {
			s = s + "@p_sicCode='" + form.getSicCode() + "',";
		}
	
		
		if (form.getBillingStreet() != null && form.getBillingStreet() != "") {
			s = s + "@p_billingStreet='" + form.getBillingStreet() + "',";
		}
		if (form.getShippingStreet() != null && form.getShippingStreet() != "") {
			s = s + "@p_shippingStreet='" + form.getShippingStreet() + "',";
		}
		if (form.getBillingCity() != null && form.getBillingCity() != "") {
			s = s + "@p_billingCity='" + form.getBillingCity() + "',";
		}
		if (form.getShippingCity() != null && form.getShippingCity() != "") {
			s = s + "@p_shippingCity='" + form.getShippingCity() + "',";
		}
		if (form.getBillingState() != null && form.getBillingState() != "") {
			s = s + "@p_billingState='" + form.getBillingState() + "',";
		}
		if (form.getShippingState() != null && form.getShippingState() != "") {
			s = s + "@p_shippingState='" + form.getShippingState() + "',";
		}
		if (form.getBillingCode() != null && form.getBillingCode() != "") {
			s = s + "@p_billingCode='" + form.getBillingCode() + "',";
		}
		if (form.getShippingCode() != null && form.getShippingCode() != "") {
			s = s + "@p_shippingCode='" + form.getShippingCode() + "',";
		}
		if (form.getBillingCountry() != null && form.getBillingCountry() != "") {
			s = s + "@p_billingCountry='" + form.getBillingCountry() + "',";
		}
		if (form.getShippingCountry() != null && form.getShippingCountry() != "") {
			s = s + "@p_shippingCountry='" + form.getShippingCountry() + "',";
		}
		
		
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription() + "',";
		}
		
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
	
}
