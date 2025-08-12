package nirmalya.aatithya.restmodule.common.utils.asset;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.maintenance.model.VendorRegistrationRestModal;

public class GenerateVendorRegistrationParams {
	
public static String getAddVendorParam(VendorRegistrationRestModal form) {
		
		String s = "";
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	s = s + "@p_createdTime='" + dateString + "',";

		if (form.getVendorId() != null) {
			s = s + "@p_vendorId='" + form.getVendorId() + "',";
		}
		if (form.getSalutation() != null && form.getSalutation() != "") {
			s = s + "@p_salutation='" + form.getSalutation() + "',";
		}
		else {
			s = s + "@p_salutation='',";
		}
		if (form.getVendorName() != null && form.getVendorName() != "") {
			s = s + "@p_vendorName='" + form.getVendorName() + "',";
		}else {
			s = s + "@p_vendorName='',";
		}
		if (form.getCompanyName() != null && form.getCompanyName() != "") {
			s = s + "@p_companyName='" + form.getCompanyName() + "',";
		}else {
			s = s + "@p_companyName='',";
		}
		
		if (form.getVendorDisplayName() != null && form.getVendorDisplayName() != "") {
			s = s + "@p_vendorDisplayName='" + form.getVendorDisplayName() + "',";
		}else {
			s = s + "@p_vendorDisplayName='',";
		}
	
		if (form.getVendorEmail() != null && form.getVendorEmail() != "") {
			s = s + "@p_vendorEmail='" + form.getVendorEmail() + "',";
		}else {
			s = s + "@p_vendorEmail='',";
		}
		if (form.getVendorPhone() != null && form.getVendorPhone() != "") {
			s = s + "@p_vendorPhone='" + form.getVendorPhone() + "',";
		}else {
			s = s + "@p_vendorPhone='',";
		}
		if (form.getVendorMobile() != null && form.getVendorMobile() != "") {
			s = s + "@p_vendorMobile='" + form.getVendorMobile() + "',";
		}else {
			s = s + "@p_vendorMobile='',";
		}
		if (form.getVendorSkype() != null && form.getVendorSkype() != "") {
			s = s + "@p_vendorSkype='" + form.getVendorSkype() + "',";
		}else {
			s = s + "@p_vendorSkype='',";
		}
		if (form.getVendorDesignation() != null && form.getVendorDesignation() != "") {
			s = s + "@p_vendorDesignation='" + form.getVendorDesignation() + "',";
		}else {
			s = s + "@p_vendorDesignation='',";
		}
		
		if (form.getDepartment() != null && form.getDepartment() != "") {
			s = s + "@p_department='" + form.getDepartment() + "',";
		}else {
			s = s + "@p_department='',";
		}
		
		if (form.getWebSite() != null ) {
			s = s + "@p_website='" + form.getWebSite() + "',";
		}
		else {
			s = s + "@p_website='',";
		}
		if (form.getStatus() != null && form.getStatus() != "") {
			s = s + "@p_status='" + form.getStatus() + "',";
		}
		else {
			s = s + "@p_status='',";
		}
		
		if (form.getPan() != null && form.getPan() != "") {
			s = s + "@p_pan='" + form.getPan() + "',";
		}
		else {
			s = s + "@p_pan='',";
		}
		
		if (form.getCurrency() != null && form.getCurrency() != "") {
			s = s + "@p_currency='" + form.getCurrency() + "',";
		}
		else {
			s = s + "@p_currency='',";
		}
		
		if (form.getOpeningBalance() != null && form.getOpeningBalance() != "") {
			s = s + "@p_openingBalance='" + form.getOpeningBalance() + "',";
		}
		else {
			s = s + "@p_openingBalance='',";
		}
		
		if (form.getPaymentTerms() != null && form.getPaymentTerms() != "") {
			s = s + "@p_paymentTerms='" + form.getPaymentTerms() + "',";
		}
		else {
			s = s + "@p_paymentTerms='',";
		}
		if (form.getTds() != null && form.getTds() != "") {
			s = s + "@p_tds='" + form.getTds() + "',";
		}else {
			s = s + "@p_tds='',";
		}
		if (form.getFaceBook() != null && form.getFaceBook() != "") {
			s = s + "@p_facebook='" + form.getFaceBook() + "',";
		}else {
			s = s + "@p_facebook='',";
		}
		if (form.getTwitter() != null && form.getTwitter() != "") {
			s = s + "@p_twitter='" + form.getTwitter() + "',";
		}
		else {
			s = s + "@p_twitter='',";
		}
		if (form.getCountry() != null && form.getCountry() != "") {
			s = s + "@p_country='" + form.getCountry() + "',";
		}else {
			s = s + "@p_country='',";
		}
		if (form.getStates() != null && form.getStates() != "") {
			s = s + "@p_state='" + form.getStates() + "',";
		}else {
			s = s + "@p_state='',";
		}
		
		if (form.getCity() != null && form.getCity() != "") {
			s = s + "@p_city='" + form.getCity() + "',";
		}else {
			s = s + "@p_city='',";
		}
		
		if (form.getStreet1() != null && form.getStreet1() != "") {
			s = s + "@p_street1='" + form.getStreet1() + "',";
		}else {
			s = s + "@p_street1='',";
		}
		
		if (form.getStreet2() != null && form.getStreet2() != "") {
			s = s + "@p_street2='" + form.getStreet2() + "',";
		}
		else {
			s = s + "@p_street2='',";
		}
		if (form.getZipCode() != null && form.getZipCode() != "") {
			s = s + "@p_zipCode='" + form.getZipCode() + "',";
		}
		else {
			s = s + "@p_zipCode='',";
		}
		if (form.getPhone() != null && form.getPhone() != "") {
			s = s + "@p_phone='" + form.getPhone() + "',";
		}
		else {
			s = s + "@p_phone='',";
		}
		if (form.getFax() != null && form.getFax() != "") {
			s = s + "@p_fax='" + form.getFax() + "',";
		}
		else {
			s = s + "@p_fax='',";
		}
		
		if (form.getSalutation1() != null && form.getSalutation1() != "") {
			s = s + "@p_salutation1='" + form.getSalutation1() + "',";
		}else {
			s = s + "@p_salutation1='',";
		}
		
		if (form.getFirstName() != null && form.getFirstName() != "") {
			s = s + "@p_firstName='" + form.getFirstName() + "',";
		}else {
			s = s + "@p_firstName='',";
		}
		
		if (form.getLastName() != null && form.getLastName() != "") {
			s = s + "@p_lastName='" + form.getLastName() + "',";
		}
		else {
			s = s + "@p_lastName='',";
		}
		
		if (form.getEmailAdd() != null && form.getEmailAdd() != "") {
			s = s + "@p_emailAdd='" + form.getEmailAdd() + "',";
		}else {
			s = s + "@p_emailAdd='',";
		}
		
		if (form.getMobile() != null && form.getMobile() != "") {
			s = s + "@p_mobile='" + form.getMobile() + "',";
		}
		else {
			s = s + "@p_mobile='',";
		}
		if (form.getBeneficiaryName() != null && form.getBeneficiaryName() != "") {
			s = s + "@p_beneficiaryName='" + form.getBeneficiaryName() + "',";
		}
		else {
			s = s + "@p_beneficiaryName='',";
		}
		if (form.getBankName() != null && form.getBankName() != "") {
			s = s + "@p_bankName='" + form.getBankName() + "',";
		}else {
			s = s + "@p_bankName='',";
		}
		
		if (form.getAccountNo() != null && form.getAccountNo() != "") {
			s = s + "@p_accountNo='" + form.getAccountNo() + "',";
		}else {
			s = s + "@p_accountNo='',";
		}
		
		if (form.getIfsc() != null && form.getIfsc() != "") {
			s = s + "@p_ifsc='" + form.getIfsc() + "',";
		}else {
			s = s + "@p_ifsc='',";
		}
		
		if (form.getRemarks() != null && form.getRemarks() != "") {
			s = s + "@p_remarks='" + form.getRemarks() + "',";
		}
		else {
			s = s + "@p_remarks='',";
		}
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}else {
			s = s + "@p_createdBy='',";
		}
		
		if (form.getGstNumber() != null && form.getGstNumber() != "") {
			s = s + "@p_gstNumber='" + form.getGstNumber() + "',";
		}else {
			s = s + "@p_gstNumber='',";
		}
		
		if (form.getVendorCategory() != null && form.getVendorCategory() != "") {
			s = s + "@p_vendorCategory='" + form.getVendorCategory() + "',";
		}
		else {
			s = s + "@p_vendorCategory='',";
		}
		if (form.getWhatsAppNo() != null && form.getWhatsAppNo() != "") {
			s = s + "@p_whatsAppNo='" + form.getGstNumber() + "',";
		}
		else {
			s = s + "@p_whatsAppNo='',";
		}
		if (form.getTanNo() != null && form.getTanNo() != "") {
			s = s + "@p_tanNo='" + form.getTanNo() + "',";
		}
		else {
			s = s + "@p_tanNo='',";
		}
		if (form.getOrgName() != null && form.getOrgName() != "") {
			s = s + "@p_orgName='" + form.getOrgName() + "',";
		}
		else {
			s = s + "@p_orgName='',";
		}
		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + form.getOrgDivision() + "',";
		}
		else {
			s = s + "@p_orgDivision='',";
		}
		if (form.getVendorType() != null && form.getVendorType() != "") {
			s = s + "@p_vendorType='" + form.getVendorType() + "',";
		}else {
			s = s + "@p_vendorType='',";
		}
		
		if (form.getActivityType() != null && form.getActivityType() != "") {
			s = s + "@p_activityType='" + form.getActivityType() + "',";
		}else {
			s = s + "@p_activityType='',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}


public static String getServiceListParam(VendorRegistrationRestModal form) {
	
	String s = "";

	if (form.getVendorId() != null) {
		s = s + "@p_vendorId='" + form.getVendorId() + "',";
	}
	if (form.getServiceId() != null && form.getServiceId() != "") {
		s = s + "@p_serviceId='[" + form.getServiceId() + "]',";
	}
	if (form.getServiceName() != null && form.getServiceName() != "") {
		s = s + "@p_serviceName='" + form.getServiceName() + "',";
	}
	if (form.getCityId() != null && form.getCityId() != "") {
		s = s + "@p_cityId='[" + form.getCityId() + "]',";
	}
	if (form.getCityName() != null && form.getCityName() != "") {
		s = s + "@p_cityName='" + form.getCityName() + "',";
	}
	if (form.getVendorName() != null && form.getVendorName() != "") {
		s = s + "@p_vendorName='" + form.getVendorName() + "',";
	}
	if (form.getOrgName() != null && form.getOrgName() != "") {
		s = s + "@p_orgName='" + form.getOrgName() + "',";
	}
	if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
		s = s + "@p_orgDivision='" + form.getOrgDivision() + "',";
	}
	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}
	return s;

}

}
