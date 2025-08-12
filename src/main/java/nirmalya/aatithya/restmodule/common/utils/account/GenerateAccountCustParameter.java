/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils.account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.account.model.AccountCusRestModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateAccountCustParameter {
	
	public static String getAddCustParam(AccountCusRestModel form) {

		String s = "";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";

		if (form.getCustomerId() != null) {
			s = s + "@p_customerId='" + form.getCustomerId() + "',";
		}

		if (form.getCustomerType() != null && form.getCustomerType() != "") {
			s = s + "@p_customerType='" + form.getCustomerType() + "',";
		}
		
		if (form.getSalutation() != null && form.getSalutation() != "") {
			s = s + "@p_salutation='" + form.getSalutation() + "',";
		}

		if (form.getCustomerName() != null && form.getCustomerName() != "") {
			s = s + "@p_customerName='" + form.getCustomerName() + "',";
		}
		
		if (form.getCompanyName() != null && form.getCompanyName() != "") {
			s = s + "@p_companyName='" + form.getCompanyName() + "',";
		}
		
		
		if (form.getCustomerDisplayName() != null && form.getCustomerDisplayName() != "") {
			s = s + "@p_custDisplayName='" + form.getCustomerDisplayName() + "',";
		}
		
		if (form.getCusEmail() != null && form.getCusEmail() != "") {
			s = s + "@p_custEmail='" + form.getCusEmail() + "',";
		}
		
		if (form.getCustMobile() != null && form.getCustMobile() != "") {
			s = s + "@p_custMobile='" + form.getCustMobile() + "',";
		}
		
		
		if (form.getCustSkype() != null && form.getCustSkype() != "") {
			s = s + "@p_custSkype='" + form.getCustSkype() + "',";
		}
		
		
		if (form.getCustDesignation() != null && form.getCustDesignation() != "") {
			s = s + "@p_custDesignation='" + form.getCustDesignation() + "',";
		}
		
		if (form.getDepartment() != null && form.getDepartment() != "") {
			s = s + "@p_department='" + form.getDepartment() + "',";
		}
		
		if (form.getWebSite() != null && form.getWebSite() != "") {
			s = s + "@p_website='" + form.getWebSite() + "',";
		}
		
		if (form.getStatus() != null && form.getStatus() != "") {
			s = s + "@p_status='" + form.getStatus() + "',";
		}
		
		
		if (form.getPan() != null && form.getPan() != "") {
			s = s + "@p_pan='" + form.getPan() + "',";
		}
		
		
		if (form.getCurrency() != null && form.getCurrency() != "") {
			s = s + "@p_currency='" + form.getCurrency() + "',";
		}
		
		
		if (form.getOpeningBalance() != null && form.getOpeningBalance() != "") {
			s = s + "@p_openingBalance='" + form.getOpeningBalance() + "',";
		}
		
		
		if (form.getPaymentTerms() != null && form.getPaymentTerms() != "") {
			s = s + "@p_paymentTerms='" + form.getPaymentTerms() + "',";
		}
		
		
		if (form.getEnableDtls() != null && form.getEnableDtls() != "") {
			s = s + "@p_enableDtls='" + form.getEnableDtls() + "',";
		}
		
		
		if (form.getPortableLang() != null && form.getPortableLang() != "") {
			s = s + "@p_portableLang='" + form.getPortableLang() + "',";
		}
		
		
		if (form.getFaceBook() != null && form.getFaceBook() != "") {
			s = s + "@p_facebook='" + form.getFaceBook() + "',";
		}
		
		
		if (form.getTwitter() != null && form.getTwitter() != "") {
			s = s + "@p_twitter='" + form.getTwitter() + "',";
		}
		
		if (form.getCountry() != null && form.getCountry() != "") {
			s = s + "@p_country='" + form.getCountry() + "',";
		}
		
		if (form.getStates() != null && form.getStates() != "") {
			s = s + "@p_state='" + form.getStates() + "',";
		}
		
		if (form.getCity() != null && form.getCity() != "") {
			s = s + "@p_city='" + form.getCity() + "',";
		}
		
		if (form.getStreet1() != null && form.getStreet1() != "") {
			s = s + "@p_street1='" + form.getStreet1() + "',";
		}
		
		if (form.getStreet2() != null && form.getStreet2() != "") {
			s = s + "@p_street2='" + form.getStreet2() + "',";
		}
		
		if (form.getZipCode() != null && form.getZipCode() != "") {
			s = s + "@p_zipCode='" + form.getZipCode() + "',";
		}
		
		if (form.getPhone() != null && form.getPhone() != "") {
			s = s + "@p_phone='" + form.getPhone() + "',";
		}
		
		if (form.getFax() != null && form.getFax() != "") {
			s = s + "@p_fax='" + form.getFax() + "',";
		}
		
		if (form.getCountry1() != null && form.getCountry1() != "") {
			s = s + "@p_country1='" + form.getCountry1() + "',";
		}
		
		if (form.getStates1() != null && form.getStates1() != "") {
			s = s + "@p_state1='" + form.getStates1() + "',";
		}
		
		if (form.getCity1() != null && form.getCity1() != "") {
			s = s + "@p_city1='" + form.getCity1() + "',";
		}
		
		if (form.getStreet11() != null && form.getStreet11() != "") {
			s = s + "@p_street11='" + form.getStreet11() + "',";
		}
		
		if (form.getStreet21() != null && form.getStreet21() != "") {
			s = s + "@p_street21='" + form.getStreet21() + "',";
		}
		
		if (form.getZipCode1() != null && form.getZipCode1() != "") {
			s = s + "@p_zipCode1='" + form.getZipCode1() + "',";
		}
		
		if (form.getPhone1() != null && form.getPhone1() != "") {
			s = s + "@p_phone1='" + form.getPhone1() + "',";
		}
		
		if (form.getFax1() != null && form.getFax1() != "") {
			s = s + "@p_fax1='" + form.getFax1() + "',";
		}
		
		
		if (form.getSalutation1() != null && form.getSalutation1() != "") {
			s = s + "@p_salutation1='" + form.getSalutation1() + "',";
		}
		
		if (form.getFirstName() != null && form.getFirstName() != "") {
			s = s + "@p_firstName='" + form.getFirstName() + "',";
		}
		
		if (form.getLastName() != null && form.getLastName() != "") {
			s = s + "@p_lastName='" + form.getLastName() + "',";
		}
		
		
		if (form.getEmailAdd() != null && form.getEmailAdd() != "") {
			s = s + "@p_emailAdd='" + form.getEmailAdd() + "',";
		}
		
		if (form.getMobile() != null && form.getMobile() != "") {
			s = s + "@p_mobile='" + form.getMobile() + "',";
		}
		
		if (form.getRemarks() != null && form.getRemarks() != "") {
			s = s + "@p_remarks='" + form.getRemarks() + "',";
		}
		
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		if (form.getShippingDetails() != null && form.getShippingDetails() != "") {
			s = s + "@p_shippingDetails='" + form.getShippingDetails() + "',";
		}
		if (form.getPointOfContact() != null && form.getPointOfContact() != "") {
			s = s + "@p_pointOfContact='" + form.getPointOfContact() + "',";
		}
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}


}
