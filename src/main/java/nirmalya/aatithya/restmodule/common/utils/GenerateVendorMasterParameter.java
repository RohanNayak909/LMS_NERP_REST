package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.VendorContactMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorDocumentMaster;
import nirmalya.aatithya.restmodule.master.model.VendorLocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorMasterModel;

public class GenerateVendorMasterParameter {
	static String[] metaCharacters = {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&","%","'"};
	
	public static String saveVendorMaster(VendorMasterModel vendorMasterModel) {

		String s = "";
		
		if (vendorMasterModel.getVendorId() != null && vendorMasterModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + vendorMasterModel.getVendorId() + "',";
		}
		if (vendorMasterModel.getCode() != null && vendorMasterModel.getCode() != "") {
			s = s + "@p_codeId='" + vendorMasterModel.getCode() + "',";
		}
		if (vendorMasterModel.getVendorName() != null && vendorMasterModel.getVendorName() != "") {
			for (int i = 0 ; i < metaCharacters.length ; i++){
			vendorMasterModel.setVendorName(vendorMasterModel.getVendorName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			}
			s = s + "@p_vendorName='" + vendorMasterModel.getVendorName() + "',";
			
		}
		if (vendorMasterModel.getCategory() != null && vendorMasterModel.getCategory() != "") {
			s = s + "@p_category='" + vendorMasterModel.getCategory() + "',";
		}
		if (vendorMasterModel.getVendorStatus() != null && vendorMasterModel.getVendorStatus() != "") {
			s = s + "@p_isActive='" + vendorMasterModel.getVendorStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}
		if (vendorMasterModel.getCategoryType() != null && vendorMasterModel.getCategoryType() != "") {
			s = s + "@p_categoryType='" + vendorMasterModel.getCategoryType() + "',";
		}
		if (vendorMasterModel.getFileVendor() != null && vendorMasterModel.getFileVendor() != "") {
			s = s + "@p_fileVendor='" + vendorMasterModel.getFileVendor() + "',";
		}
		if (vendorMasterModel.getComapanyOverview() != null && vendorMasterModel.getComapanyOverview() != "") {
			s = s + "@p_companyOverView='" + vendorMasterModel.getComapanyOverview() + "',";
		}
		if (vendorMasterModel.getCreatedBy() != null && vendorMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + vendorMasterModel.getCreatedBy() + "',";
		}
		if (vendorMasterModel.getModule() != null && vendorMasterModel.getModule() != "") {
			s = s + "@p_module='" + vendorMasterModel.getModule() + "',";
		}
		if (vendorMasterModel.getComponent() != null && vendorMasterModel.getComponent() != "") {
			s = s + "@p_component='" + vendorMasterModel.getComponent() + "',";
		}
		if (vendorMasterModel.getSubcomponent()!= null && vendorMasterModel.getSubcomponent() != "") {
			s = s + "@p_subComponent='" + vendorMasterModel.getSubcomponent() + "',";
		}
		/*
		 * String establishDate = null; establishDate =
		 * DateFormatter.getStringDate(vendorMasterModel.getCompanyDate());
		 */
		if (vendorMasterModel.getCompanyDate()!= null && vendorMasterModel.getCompanyDate() != "") {
			s = s + "@p_companyDate='" + vendorMasterModel.getCompanyDate() + "',";
		}
		if (vendorMasterModel.getGrossAnnualSale()!= null && vendorMasterModel.getGrossAnnualSale() != "") {
			s = s + "@p_grossAnnualSale='" + vendorMasterModel.getGrossAnnualSale() + "',";
		}
		if (vendorMasterModel.getCurrency()!= null && vendorMasterModel.getCurrency() != "") {
			s = s + "@p_currency='" + vendorMasterModel.getCurrency() + "',";
		}
		if (vendorMasterModel.getTotalEmployee()!= null && vendorMasterModel.getTotalEmployee() != "") {
			s = s + "@p_totalEmployee='" + vendorMasterModel.getTotalEmployee() + "',";
		}
		if (vendorMasterModel.getWebsite()!= null && vendorMasterModel.getWebsite() != "") {
			s = s + "@p_website='" + vendorMasterModel.getWebsite() + "',";
		}
		if (vendorMasterModel.getGst()!= null && vendorMasterModel.getGst() != "") {
			s = s + "@p_gst='" + vendorMasterModel.getGst() + "',";
		}
		if (vendorMasterModel.getOrganizationName()!= null && vendorMasterModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + vendorMasterModel.getOrganizationName() + "',";
		}
		if (vendorMasterModel.getOrganizationDivision()!= null && vendorMasterModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + vendorMasterModel.getOrganizationDivision() + "',";
		}
		if (vendorMasterModel.getPassword()!= null && vendorMasterModel.getPassword() != "") {
			s = s + "@p_password='" + vendorMasterModel.getPassword() + "',";
		}
		if (vendorMasterModel.getCpriod()!= null && vendorMasterModel.getCpriod() != "") {
			s = s + "@p_cpriod='" + vendorMasterModel.getCpriod() + "',";
		}
		if (vendorMasterModel.getSecurity()!= null && vendorMasterModel.getSecurity() != "") {
			s = s + "@p_security='" + vendorMasterModel.getSecurity() + "',";
		}
		if (vendorMasterModel.getbGura()!= null && vendorMasterModel.getbGura() != "") {
			s = s + "@p_bGura='" + vendorMasterModel.getbGura() + "',";
		}
		if (vendorMasterModel.getPdCheak()!= null && vendorMasterModel.getPdCheak() != "") {
			s = s + "@p_pdCheak='" + vendorMasterModel.getPdCheak() + "',";
		}
		if (vendorMasterModel.getClimits()!= null && vendorMasterModel.getClimits() != "") {
			s = s + "@p_climits='" + vendorMasterModel.getClimits() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}
	
	public static String saveVendorLocationMaster(VendorLocationMasterModel vendorLocationMasterModel) {

		String s = "";

		if (vendorLocationMasterModel.getVendorLocationId() != null && vendorLocationMasterModel.getVendorLocationId() != "") {
			s = s + "@p_vendorLocId='" + vendorLocationMasterModel.getVendorLocationId() + "',";
		}
		if (vendorLocationMasterModel.getVendorId() != null && vendorLocationMasterModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + vendorLocationMasterModel.getVendorId() + "',";
		}
		if (vendorLocationMasterModel.getVendorLocationName() != null && vendorLocationMasterModel.getVendorLocationName() != "") {
			for (int i = 0 ; i < metaCharacters.length ; i++){
				vendorLocationMasterModel.setVendorLocationName(vendorLocationMasterModel.getVendorLocationName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
				}
			s = s + "@p_vendorLocationName='" + vendorLocationMasterModel.getVendorLocationName() + "',";
		
		}
		if (vendorLocationMasterModel.getVendorLocationType() != null && vendorLocationMasterModel.getVendorLocationType() != "") {
			s = s + "@p_vendorLocType='" + vendorLocationMasterModel.getVendorLocationType() + "',";
		}
	
		if (vendorLocationMasterModel.getVendorBillingStatus() != null && vendorLocationMasterModel.getVendorBillingStatus() != "") {
			s = s + "@p_billingStatus='" + vendorLocationMasterModel.getVendorBillingStatus() + "',";
		} else {
			s = s + "@p_billingStatus='" + 0 + "',";
		}
		if (vendorLocationMasterModel.getVendorPrimaryStatus() != null && vendorLocationMasterModel.getVendorPrimaryStatus() != "") {
			s = s + "@p_primaryStatus='" + vendorLocationMasterModel.getVendorPrimaryStatus() + "',";
		} else {
			s = s + "@p_primaryStatus='" + 0 + "',";
		}
		if (vendorLocationMasterModel.getVendorLocAddress() != null && vendorLocationMasterModel.getVendorLocAddress() != "") {
			s = s + "@p_locAddress='" + vendorLocationMasterModel.getVendorLocAddress() + "',";
		}
		if (vendorLocationMasterModel.getVendorCountry() != null && vendorLocationMasterModel.getVendorCountry() != "") {
			s = s + "@p_vendorCountry='" + vendorLocationMasterModel.getVendorCountry() + "',";
		}
		if (vendorLocationMasterModel.getVendorState() != null && vendorLocationMasterModel.getVendorState() != "") {
			s = s + "@p_vendorState='" + vendorLocationMasterModel.getVendorState() + "',";
		}
		if (vendorLocationMasterModel.getVendorCity()!= null && vendorLocationMasterModel.getVendorCity() != "") {
			s = s + "@p_vendorCity='" + vendorLocationMasterModel.getVendorCity() + "',";
		}
		if (vendorLocationMasterModel.getCreatedBy() != null && vendorLocationMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + vendorLocationMasterModel.getCreatedBy() + "',";
		}
		if (vendorLocationMasterModel.getModule() != null && vendorLocationMasterModel.getModule() != "") {
			s = s + "@p_module='" + vendorLocationMasterModel.getModule() + "',";
		}
		if (vendorLocationMasterModel.getComponent() != null && vendorLocationMasterModel.getComponent() != "") {
			s = s + "@p_component='" + vendorLocationMasterModel.getComponent() + "',";
		}
		if (vendorLocationMasterModel.getSubcomponent()!= null && vendorLocationMasterModel.getSubcomponent() != "") {
			s = s + "@p_subComponent='" + vendorLocationMasterModel.getSubcomponent() + "',";
		}
		if (vendorLocationMasterModel.getOrganizationName()!= null && vendorLocationMasterModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + vendorLocationMasterModel.getOrganizationName() + "',";
		}
		if (vendorLocationMasterModel.getOrganizationDivision()!= null && vendorLocationMasterModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + vendorLocationMasterModel.getOrganizationDivision() + "',";
		}
		if (vendorLocationMasterModel.getOrganizationDivision()!= null && vendorLocationMasterModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + vendorLocationMasterModel.getOrganizationDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}
	
	public static String saveVendorContactMaster(VendorContactMasterModel vendorContactMasterModel) {

		String s = "";

		if (vendorContactMasterModel.getContactId() != null && vendorContactMasterModel.getContactId() != "") {
			s = s + "@p_contactId='" + vendorContactMasterModel.getContactId() + "',";
		}
		if (vendorContactMasterModel.getVendorId() != null && vendorContactMasterModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + vendorContactMasterModel.getVendorId() + "',";
		}
		if (vendorContactMasterModel.getContactName() != null && vendorContactMasterModel.getContactName() != "") {
			for (int i = 0 ; i < metaCharacters.length ; i++){
				vendorContactMasterModel.setContactName(vendorContactMasterModel.getContactName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			}
				s = s + "@p_contactName='" + vendorContactMasterModel.getContactName() + "',";
		}
		if (vendorContactMasterModel.getContactDesignation() != null && vendorContactMasterModel.getContactDesignation() != "") {
			s = s + "@p_contactDesignation='" + vendorContactMasterModel.getContactDesignation() + "',";
		
		}
		if (vendorContactMasterModel.getContactFunction() != null && vendorContactMasterModel.getContactFunction() != "") {
			s = s + "@p_function='" + vendorContactMasterModel.getContactFunction() + "',";
		}
	
		if (vendorContactMasterModel.getPrimaryStatusContact() != null && vendorContactMasterModel.getPrimaryStatusContact() != "") {
			s = s + "@p_primaryStatusContact='" + vendorContactMasterModel.getPrimaryStatusContact() + "',";
		} else {
			s = s + "@p_primaryStatusContact='" + 0 + "',";
		}
		
		if (vendorContactMasterModel.getLocation() != null && vendorContactMasterModel.getLocation() != "") {
			s = s + "@p_location='" + vendorContactMasterModel.getLocation() + "',";
		}
		if (vendorContactMasterModel.getEmail()!= null && vendorContactMasterModel.getEmail() != "") {
			s = s + "@p_email='" + vendorContactMasterModel.getEmail() + "',";
		}
		if (vendorContactMasterModel.getPhone() != null && vendorContactMasterModel.getPhone() != "") {
			s = s + "@p_phone='" + vendorContactMasterModel.getPhone() + "',";
		}
		if (vendorContactMasterModel.getCreatedBy() != null && vendorContactMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + vendorContactMasterModel.getCreatedBy() + "',";
		}
		if (vendorContactMasterModel.getModule() != null && vendorContactMasterModel.getModule() != "") {
			s = s + "@p_module='" + vendorContactMasterModel.getModule() + "',";
		}
		if (vendorContactMasterModel.getComponent() != null && vendorContactMasterModel.getComponent() != "") {
			s = s + "@p_component='" + vendorContactMasterModel.getComponent() + "',";
		}
		if (vendorContactMasterModel.getSubcomponent()!= null && vendorContactMasterModel.getSubcomponent() != "") {
			s = s + "@p_subComponent='" + vendorContactMasterModel.getSubcomponent() + "',";
		}
		if (vendorContactMasterModel.getOrganizationName()!= null && vendorContactMasterModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + vendorContactMasterModel.getOrganizationName() + "',";
		}
		if (vendorContactMasterModel.getOrganizationDivision()!= null && vendorContactMasterModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + vendorContactMasterModel.getOrganizationDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
	
 
	
	//add vendor documents
	public static String getVendorOtherDocuments(VendorDocumentMaster vendorDocumentModel) {

		String s = "";
		if (vendorDocumentModel.getDocumentId() != null
				&& vendorDocumentModel.getDocumentId() != "") {
			s = s + "@p_docId='" + vendorDocumentModel.getDocumentId() + "',";
		}
		if (vendorDocumentModel.getVendorId() != null
				&& vendorDocumentModel.getVendorId() != "") {
			s = s + "@p_venderId='" + vendorDocumentModel.getVendorId() + "',";
		}
		if (vendorDocumentModel.getDocumentType() != null
				&& vendorDocumentModel.getDocumentType() != "") {
			s = s + "@p_docType='" + vendorDocumentModel.getDocumentType() + "',";
		}
		if (vendorDocumentModel.getDocumentNo() != null
				&& vendorDocumentModel.getDocumentNo() != "") {
			s = s + "@p_docNo='" + vendorDocumentModel.getDocumentNo() + "',";
		}
		if (vendorDocumentModel.getDocumentImage() != null
				&& vendorDocumentModel.getDocumentImage() != "") {
			s = s + "@p_documentImage='" + vendorDocumentModel.getDocumentImage() + "',";
		}
		if (vendorDocumentModel.getStatus() != null
				&& vendorDocumentModel.getStatus() != "") {
			s = s + "@p_status='" + vendorDocumentModel.getStatus() + "',";
		}
		if (vendorDocumentModel.getCreatedBy() != null
				&& vendorDocumentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + vendorDocumentModel.getCreatedBy() + "',";
		}
		if (vendorDocumentModel.getOrganizationName() != null
				&& vendorDocumentModel.getOrganizationName() != "") {
			s = s + "@p_org='" + vendorDocumentModel.getOrganizationName() + "',";
		}
		if (vendorDocumentModel.getOrganizationDivision() != null
				&& vendorDocumentModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + vendorDocumentModel.getOrganizationDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		return s;
	}

	}
