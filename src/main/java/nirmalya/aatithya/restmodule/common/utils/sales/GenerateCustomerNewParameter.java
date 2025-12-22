package nirmalya.aatithya.restmodule.common.utils.sales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.master.model.ProductDetailsModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;

public class GenerateCustomerNewParameter {
	public static String getAddCustParam(RestCustoomerNewModel form) {

		String s = "";
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
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
		if (form.getGstNo() != null && form.getGstNo() != "") {
			s = s + "@p_gstNo='" + form.getGstNo() + "',";
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
		
		if (form.getCrmContactId() != null && form.getCrmContactId() != "") {
			s = s + "@p_crmContactId='" + form.getCrmContactId() + "',";
		}

		/*
		 * if (form.getEnableDtls() != null && form.getEnableDtls() != "") { s = s +
		 * "@p_enableDtls='" + form.getEnableDtls() + "',"; }
		 */
		if (form.getPortableLang() != null && form.getPortableLang() != "") {
			s = s + "@p_portableLang='" + form.getPortableLang() + "',";
		}

		if (form.getWhatsApp() != null && form.getWhatsApp() != "") {
			s = s + "@p_whatsapp='" + form.getWhatsApp() + "',";
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
		if (form.getLeadId() != null && form.getLeadId() != "") {
			s = s + "@p_leadId='" + form.getLeadId() + "',";
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
		if (form.getOrganization() != null && form.getOrganization() != "") {
			s = s + "@p_org='" + form.getOrganization() + "',";
		}
		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + form.getOrgDivision() + "',";
		}
		if (form.getShippingDetails() != null && form.getShippingDetails() != "") {
			s = s + "@p_shippingDetails='" + form.getShippingDetails() + "',";
		}
		if (form.getPocDetails() != null && form.getPocDetails() != "") {
			s = s + "@p_pointOfContact='" + form.getPocDetails() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	public static String saveAddressDetails(RestCustoomerNewModel restCustoomerNewModel) {

		String s = "";
		
		if(restCustoomerNewModel.getCustomerId()!=null && restCustoomerNewModel.getCustomerId()!="") {
			s = s + "@p_customerId='" + restCustoomerNewModel.getCustomerId() + "',";
		}
		if(restCustoomerNewModel.getShippingId()!=null && restCustoomerNewModel.getShippingId()!="") {
			s = s + "@p_shippingId='" + restCustoomerNewModel.getShippingId() + "',";
		}
		if(restCustoomerNewModel.getCountry1()!=null && restCustoomerNewModel.getCountry1()!="") {
			s = s + "@p_country='" + restCustoomerNewModel.getCountry1() + "',";
		}
		if(restCustoomerNewModel.getStates1()!=null && restCustoomerNewModel.getStates1()!="") {
			s = s + "@p_state='" + restCustoomerNewModel.getStates1() + "',";
		}
		if(restCustoomerNewModel.getCity1()!=null && restCustoomerNewModel.getCity1()!="") {
			s = s + "@p_city='" + restCustoomerNewModel.getCity1() + "',";
		}
		if(restCustoomerNewModel.getStreet11()!=null && restCustoomerNewModel.getStreet11()!="") {
			s = s + "@p_street1='" + restCustoomerNewModel.getStreet11() + "',";
		}
		if(restCustoomerNewModel.getStreet21()!=null && restCustoomerNewModel.getStreet21()!="") {
			s = s + "@p_street2='" + restCustoomerNewModel.getStreet21() + "',";
		}
		if(restCustoomerNewModel.getZipCode1()!=null && restCustoomerNewModel.getZipCode1()!="") {
			s = s + "@p_zipCode='" + restCustoomerNewModel.getZipCode1() + "',";
		}
		if(restCustoomerNewModel.getPhone1()!=null && restCustoomerNewModel.getPhone1()!="") {
			s = s + "@p_phone='" + restCustoomerNewModel.getPhone1() + "',";
		}
		if(restCustoomerNewModel.getFax1()!=null && restCustoomerNewModel.getFax1()!="") {
			s = s + "@p_fax='" + restCustoomerNewModel.getFax1() + "',";
		}
		if(restCustoomerNewModel.getDefaultStatus()!=null && restCustoomerNewModel.getDefaultStatus()!="") {
			s = s + "@p_defaultStatus='" + restCustoomerNewModel.getDefaultStatus() + "',";
		}
		
		if(restCustoomerNewModel.getCreatedBy()!=null && restCustoomerNewModel.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + restCustoomerNewModel.getCreatedBy() + "',";
		}
		
		
		if(restCustoomerNewModel.getOrganization()!=null && restCustoomerNewModel.getOrganization()!="") {
			s = s + "@p_orgName='" + restCustoomerNewModel.getOrganization() + "',";
		}
		if(restCustoomerNewModel.getOrgDivision()!=null && restCustoomerNewModel.getOrgDivision()!="") {
			s = s + "@p_orgDiv='" + restCustoomerNewModel.getOrgDivision() + "',";
		}
	
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
