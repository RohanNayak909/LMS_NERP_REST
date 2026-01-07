package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import nirmalya.aatithya.restmodule.employee.controller.ManageEmployeeEducationRestModel;
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeAddressRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeBankDetailsRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeBenifitrestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDependentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDocumentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeInsuranceDetailsrestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeWorkdetailsRestModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class GenerateemployeemasterParameter {

	public static String getAddempParam(ManageEmployeeRestModel employee) {

		String s = "";

		if (employee.getEmployeeId() != null && employee.getEmployeeId() != "") {
			s = s + "@p_empId='" + employee.getEmployeeId() + "',";
		} else {
			s = s + "@p_empId='',";
		}
		if (employee.getFileEmployeeimg() != null && employee.getFileEmployeeimg() != "") {
			System.out.println("Inside ifff");
			s = s + "@p_empimg='" + employee.getFileEmployeeimg() + "',";
		} else {
			System.out.println("Inside elseeeeee");
			s = s + "@p_empimg='" + "" + "',";
		}
		if (employee.getFirstName() != null && employee.getFirstName() != "") {
			s = s + "@p_firstName='" + employee.getFirstName() + "',";
		}
		if (employee.getLastName() != null && employee.getLastName() != "") {
			s = s + "@p_LastName='" + employee.getLastName() + "',";
		}
		if (employee.getGender() != null && employee.getGender() != "") {
			s = s + "@p_gender='" + employee.getGender() + "',";
		}

		if (employee.getDob() != null && employee.getDob() != "") {
			s = s + "@p_dob='" + DateFormatter.getStringDate(employee.getDob()) + "',";
		}
		if (employee.getBloodGroup() != null && employee.getBloodGroup() != "") {
			s = s + "@p_bloodgroup='" + employee.getBloodGroup() + "',";
		}
		if (employee.getMaritalStatus() != null && employee.getMaritalStatus() != "") {
			s = s + "@p_maratial='" + employee.getMaritalStatus() + "',";
		}
		if (employee.getNationality() != null && employee.getNationality() != "") {
			s = s + "@p_nationality='" + employee.getNationality() + "',";
		}
		if (employee.getFatherName() != null && employee.getFatherName() != "") {
			s = s + "@p_fathername='" + employee.getFatherName() + "',";
		}
		if (employee.getMotherName() != null && employee.getMotherName() != "") {
			s = s + "@p_mothername='" + employee.getMotherName() + "',";
		}
		if (employee.getMobileNo() != null && employee.getMobileNo() != "") {
			s = s + "@p_mobileNo='" + employee.getMobileNo() + "',";
		}
		if (employee.getPersonalMail() != null && employee.getPersonalMail() != "") {
			s = s + "@p_personalmail='" + employee.getPersonalMail() + "',";
		}
		if (employee.getWorkMail() != null && employee.getWorkMail() != "") {
			s = s + "@p_workmail='" + employee.getWorkMail() + "',";
		}
		if (employee.getCreatedBy() != null && employee.getCreatedBy() != "") {
			s = s + "@p_createdby='" + employee.getCreatedBy() + "',";
		}
		if (employee.getPanno() != null && employee.getPanno() != "") {
			s = s + "@p_panno='" + employee.getPanno() + "',";
		}
		if (employee.getEpfno() != null && employee.getEpfno() != "") {
			s = s + "@p_epf='" + employee.getEpfno() + "',";
		}
		if (employee.getEsicno() != null && employee.getEsicno() != "") {
			s = s + "@p_esic='" + employee.getEsicno() + "',";
		}
		if (employee.getPassword() != null && employee.getPassword() != "") {
			s = s + "@p_password='" + employee.getPassword() + "',";
		}
		if (employee.getOfferLetterId() != null && employee.getOfferLetterId() != "") {
			s = s + "@p_offerLetterId='" + employee.getOfferLetterId() + "',";
		} else {
			s = s + "@p_offerLetterId=\"" + "" + "\",";
		}
		if (employee.getJoiningdate() != null && employee.getJoiningdate() != "") {
			s = s + "@p_joiningdate='" + DateFormatter.getStringDate(employee.getJoiningdate()) + "',";
		}
		if (employee.getAadhaar() != null && employee.getAadhaar() != "") {
			s = s + "@p_aadhaar='" + employee.getAadhaar() + "',";
		}
		if (employee.getMrgdate() != null && employee.getMrgdate() != "") {
			s = s + "@p_mrgDate='" + DateFormatter.getStringDate(employee.getMrgdate()) + "',";
		}
		if (employee.getQrCode() != null && employee.getQrCode() != "") {
			s = s + "@p_qrCode='" + employee.getQrCode() + "',";
		} else {
			s = s + "@p_qrCode=\"" + "" + "\",";
		}
		if (employee.getOrganization() != null || employee.getOrganization() != "") {
			s = s + "@p_org='" + employee.getOrganization() + "',";
		}
		if (employee.getOrgDivision() != null || employee.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + employee.getOrgDivision() + "',";
		}

		if (employee.getEmemobilenoid() != null && employee.getEmemobilenoid() != "") {
			s = s + "@p_ememobileNo='" + employee.getEmemobilenoid() + "',";
		}
		if (employee.getEmployedBy() != null && employee.getEmployedBy() != "") {
			s = s + "@p_employedBy='" + employee.getEmployedBy() + "',";
		}

		if (employee.getSaveType() != null && employee.getSaveType() != "") {
			s = s + "@p_saveType='" + employee.getSaveType() + "',";
		} else {
			s = s + "@p_saveType=\"" + "" + "\",";
		}

		if (employee.getTransferId() != null && employee.getTransferId() != "") {
			s = s + "@p_transferId='" + employee.getTransferId() + "',";
		}
		if (employee.getSpouseName() != null && employee.getSpouseName() != "") {
			s = s + "@p_spousename='" + employee.getSpouseName() + "',";
		}
		// address

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String saveempadd(ManageEmployeeAddressRestModel manageEmployeeAddressRestModel) {

		String s = "";

		if (manageEmployeeAddressRestModel.getAddressId() != null
				&& manageEmployeeAddressRestModel.getAddressId() != "") {
			s = s + "@p_getAddressId='" + manageEmployeeAddressRestModel.getAddressId() + "',";
		}
		if (manageEmployeeAddressRestModel.getEmployeeId() != null
				&& manageEmployeeAddressRestModel.getEmployeeId() != "") {
			s = s + "@p_empId='" + manageEmployeeAddressRestModel.getEmployeeId() + "',";
		} else {
			s = s + "@p_empId=\"" + "" + "\",";
		}
		if (manageEmployeeAddressRestModel.getType() != null && manageEmployeeAddressRestModel.getType() != "") {
			s = s + "@p_getType='" + manageEmployeeAddressRestModel.getType() + "',";
		}
		if (manageEmployeeAddressRestModel.getAddress() != null && manageEmployeeAddressRestModel.getAddress() != "") {
			s = s + "@p_Address='" + manageEmployeeAddressRestModel.getAddress() + "',";
		}

		if (manageEmployeeAddressRestModel.getCity() != null && manageEmployeeAddressRestModel.getCity() != "") {
			s = s + "@p_City='" + manageEmployeeAddressRestModel.getCity() + "',";
		}
		if (manageEmployeeAddressRestModel.getState() != null && manageEmployeeAddressRestModel.getState() != "") {
			s = s + "@p_State='" + manageEmployeeAddressRestModel.getState() + "',";
		}
		if (manageEmployeeAddressRestModel.getCountry() != null && manageEmployeeAddressRestModel.getCountry() != "") {
			s = s + "@p_Country='" + manageEmployeeAddressRestModel.getCountry() + "',";
		}
		if (manageEmployeeAddressRestModel.getZipCode() != null && manageEmployeeAddressRestModel.getZipCode() != "") {
			s = s + "@p_ZipCode='" + manageEmployeeAddressRestModel.getZipCode() + "',";
		}

		if (manageEmployeeAddressRestModel.getStatus() != null && manageEmployeeAddressRestModel.getStatus() != "") {
			s = s + "@p_pStatus='" + manageEmployeeAddressRestModel.getStatus() + "',";
		}
		if (manageEmployeeAddressRestModel.getCreatedBy() != null
				&& manageEmployeeAddressRestModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + manageEmployeeAddressRestModel.getCreatedBy() + "',";
		}
		if (manageEmployeeAddressRestModel.getOrganization() != null
				|| manageEmployeeAddressRestModel.getOrganization() != "") {
			s = s + "@p_org='" + manageEmployeeAddressRestModel.getOrganization() + "',";
		}
		if (manageEmployeeAddressRestModel.getOrgDivision() != null
				|| manageEmployeeAddressRestModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + manageEmployeeAddressRestModel.getOrgDivision() + "',";
		}
		if (manageEmployeeAddressRestModel.getCheckBox() != null
				|| manageEmployeeAddressRestModel.getCheckBox() != "") {
			s = s + "@p_checkBox='" + manageEmployeeAddressRestModel.getCheckBox() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String addContactMailDraftDtls(EmployeeDocumentModel employeeDocumentModel) {
		String s = "";
		String qItem = "";

		s = s + "@p_draftId='" + employeeDocumentModel.getDraftId() + "',";
		s = s + "@p_contactMailId='" + employeeDocumentModel.getEmailContactId() + "',";
		s = s + "@p_leadId='" + employeeDocumentModel.getLeadId() + "',";
		s = s + "@p_dealId='" + employeeDocumentModel.getDealId() + "',";
		s = s + "@p_accountId='" + employeeDocumentModel.getEmailAccountId() + "',";
		s = s + "@p_quoteId='" + employeeDocumentModel.getQuoteId() + "',";
		s = s + "@p_soId='" + employeeDocumentModel.getSoId() + "',";
		s = s + "@p_poId='" + employeeDocumentModel.getPoId() + "',";
		s = s + "@p_invoiceId='" + employeeDocumentModel.getInvoiceId() + "',";
		s = s + "@p_fromEmail='" + employeeDocumentModel.getFromEmail() + "',";
		s = s + "@p_toEmail='" + employeeDocumentModel.getToMail() + "',";
		s = s + "@p_mailSub='" + employeeDocumentModel.getMailSubject() + "',";
		s = s + "@p_comment='" + employeeDocumentModel.getCommentck().replace("'", "\\'").replace("\"", "\\\\\"") + "',";
		// s = s + "@p_docName='" + employeeDocumentModel.getDocName() + "',";
		s = s + "@p_createdBy='" + employeeDocumentModel.getCreatedBy() + "',";
		s = s + "@p_ccMail='" + employeeDocumentModel.getCcMail() + "',";
		s = s + "@p_bccMail='" + employeeDocumentModel.getBccMail() + "',";
		s = s + "@org='" + employeeDocumentModel.getOrganization() + "',";
		s = s + "@orgDiv='" + employeeDocumentModel.getOrgDivision() + "',";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";
		
		if (employeeDocumentModel.getDocumentList() != null && !employeeDocumentModel.getDocumentList().isEmpty()) {
		    for (InventoryVendorDocumentModel a : employeeDocumentModel.getDocumentList()) {
		        qItem = qItem + "(@p_contactMailId,@p_leadId,@p_dealId,@p_accountId,@p_quoteId,@p_soId,"
		                + "@p_poId,@p_invoiceId,@p_fromEmail,@p_toEmail,@p_mailSub,@p_comment,"
		                + "\"" + a.getDocumnentName().replace("'", "\\'").replace("\"", "\\\"") + "\",\""
		                + a.getFileName().replace("'", "\\'").replace("\"", "\\\"") + "\",@p_createdBy,@p_ccMail,@p_bccMail,@org,@orgDiv),";
		    }
		} else {
		    qItem = "(@p_contactMailId,@p_leadId,@p_dealId,@p_accountId,@p_quoteId,@p_soId,"
		            + "@p_poId,@p_invoiceId,@p_fromEmail,@p_toEmail,@p_mailSub,@p_comment,"
		            + "\"\",\"\",@p_createdBy,@p_ccMail,@p_bccMail,@org,@orgDiv),";
		}
		System.out.println("Value For Vendor Document Parameter------>"+qItem);
		/*
		 * for (InventoryVendorDocumentModel a :
		 * employeeDocumentModel.getDocumentList()) { qItem = qItem +
		 * "(@p_contactMailId,@p_leadId,@p_dealId,@p_accountId,@p_quoteId,@p_soId," +
		 * "@p_poId,@p_invoiceId,@p_fromEmail,@p_toEmail,@p_mailSub,@p_comment,\"" +
		 * a.getDocumnentName().replace("'", "\\'").replace("\"", "\\\\\"") + "\",\"" +
		 * a.getFileName() + "\",@p_createdBy,@p_ccMail,@p_bccMail,@org,@orgDiv),";
		 * System.out.println("s string cal---------------------" + a.getAction()); }
		 */

		if (!qItem.isEmpty()) {
			qItem = qItem.substring(0, qItem.length() - 1);
			s = s + "@p_vendorDocuments='" + qItem + "', @mailId=" + employeeDocumentModel.getDraftId() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		System.out.println("email details for save------------------------------" + s);
		return s;

	}

	public static String saveempworkdetails(ManageEmployeeWorkdetailsRestModel manageEmployeeWorkdetailsRestModel) {

		String s = "";

		if (manageEmployeeWorkdetailsRestModel.getEmployeeworkId() != null
				&& manageEmployeeWorkdetailsRestModel.getEmployeeworkId() != "") {
			s = s + "@p_getEmployeeworkId='" + manageEmployeeWorkdetailsRestModel.getEmployeeworkId() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getEmployeeId() != null
				&& manageEmployeeWorkdetailsRestModel.getEmployeeId() != "") {
			s = s + "@p_empId='" + manageEmployeeWorkdetailsRestModel.getEmployeeId() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getStartDate() != null
				&& manageEmployeeWorkdetailsRestModel.getStartDate() != "") {
			s = s + "@p_gtartDate='" + manageEmployeeWorkdetailsRestModel.getStartDate() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getEndDate() != null
				&& manageEmployeeWorkdetailsRestModel.getEndDate() != "") {
			s = s + "@p_AEndDates='" + manageEmployeeWorkdetailsRestModel.getEndDate() + "',";
		}

		if (manageEmployeeWorkdetailsRestModel.getJobType() != null
				&& manageEmployeeWorkdetailsRestModel.getJobType() != "") {
			s = s + "@p_JobTypee='" + manageEmployeeWorkdetailsRestModel.getJobType() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getJobTitle() != null
				&& manageEmployeeWorkdetailsRestModel.getJobTitle() != "") {
			s = s + "@p_JobTitle='" + manageEmployeeWorkdetailsRestModel.getJobTitle() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getDepartment() != null
				&& manageEmployeeWorkdetailsRestModel.getDepartment() != "") {
			s = s + "@p_Department='" + manageEmployeeWorkdetailsRestModel.getDepartment() + "',";
		}

		if (manageEmployeeWorkdetailsRestModel.getSubdepartmentid() != null
				&& manageEmployeeWorkdetailsRestModel.getSubdepartmentid() != "") {
			s = s + "@p_Subdepartmentid='" + manageEmployeeWorkdetailsRestModel.getSubdepartmentid() + "',";
		}

		if (manageEmployeeWorkdetailsRestModel.getTimesheet() != null
				&& manageEmployeeWorkdetailsRestModel.getTimesheet() != "") {
			s = s + "@p_getTimesheet='" + manageEmployeeWorkdetailsRestModel.getTimesheet() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getEmploymentStatus() != null
				&& manageEmployeeWorkdetailsRestModel.getEmploymentStatus() != "") {
			s = s + "@p_EmploymentStatu='" + manageEmployeeWorkdetailsRestModel.getEmploymentStatus() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getDegination() != null
				&& manageEmployeeWorkdetailsRestModel.getDegination() != "") {
			s = s + "@p_Deginatio='" + manageEmployeeWorkdetailsRestModel.getDegination() + "',";
		}

		if (manageEmployeeWorkdetailsRestModel.getBand() != null
				&& manageEmployeeWorkdetailsRestModel.getBand() != "") {
			s = s + "@p_Band='" + manageEmployeeWorkdetailsRestModel.getBand() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getStafftype() != null
				&& manageEmployeeWorkdetailsRestModel.getStafftype() != "") {
			s = s + "@p_StaffType='" + manageEmployeeWorkdetailsRestModel.getStafftype() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getManager() != null
				&& manageEmployeeWorkdetailsRestModel.getManager() != "") {
			s = s + "@p_Manager='" + manageEmployeeWorkdetailsRestModel.getManager() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getAnnualCTC() != null
				&& manageEmployeeWorkdetailsRestModel.getAnnualCTC() != "") {
			s = s + "@p_AnnualCTC='" + manageEmployeeWorkdetailsRestModel.getAnnualCTC() + "',";
		}
		if (manageEmployeeWorkdetailsRestModel.getCreatedBy() != null
				&& manageEmployeeWorkdetailsRestModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + manageEmployeeWorkdetailsRestModel.getCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("GENERATE@@@@@@@@@@@@@@@@@@@@@" + s);
		return s;
	}

	public static String saveemployeedependent(ManageEmployeeDependentRestModel manageEmployeeDependentRestModel) {

		String s = "";

		if (manageEmployeeDependentRestModel.getDependentId() != null
				&& manageEmployeeDependentRestModel.getDependentId() != "") {
			s = s + "@p_depId='" + manageEmployeeDependentRestModel.getDependentId() + "',";
		}
		if (manageEmployeeDependentRestModel.getEmployeeId() != null
				&& manageEmployeeDependentRestModel.getEmployeeId() != "") {
			s = s + "@p_empId='" + manageEmployeeDependentRestModel.getEmployeeId() + "',";
		}

		if (manageEmployeeDependentRestModel.getDfirstName() != null
				&& manageEmployeeDependentRestModel.getDfirstName() != "") {
			s = s + "@p_dfrtname='" + manageEmployeeDependentRestModel.getDfirstName() + "',";
		}

		if (manageEmployeeDependentRestModel.getDlastName() != null
				&& manageEmployeeDependentRestModel.getDlastName() != "") {
			s = s + "@p_dlastname='" + manageEmployeeDependentRestModel.getDlastName() + "',";
		}
		if (manageEmployeeDependentRestModel.getDepdob() != null
				&& manageEmployeeDependentRestModel.getDepdob() != "") {
			s = s + "@p_dDob='" + DateFormatter.getStringDate(manageEmployeeDependentRestModel.getDepdob()) + "',";
		}
		if (manageEmployeeDependentRestModel.getGender() != null
				&& manageEmployeeDependentRestModel.getGender() != "") {
			s = s + "@p_dgender='" + manageEmployeeDependentRestModel.getGender() + "',";
		}
		if (manageEmployeeDependentRestModel.getDrelationship() != null
				&& manageEmployeeDependentRestModel.getDrelationship() != "") {
			s = s + "@p_drel='" + manageEmployeeDependentRestModel.getDrelationship() + "',";
		}

		if (manageEmployeeDependentRestModel.getCreatedBy() != null
				&& manageEmployeeDependentRestModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + manageEmployeeDependentRestModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String saveemployeebankdetails(
			ManageEmployeeBankDetailsRestModel manageEmployeeBankDetailsRestModel) {

		String s = "";

		if (manageEmployeeBankDetailsRestModel.getEbankId() != null
				&& manageEmployeeBankDetailsRestModel.getEbankId() != "") {
			s = s + "@p_ebankId='" + manageEmployeeBankDetailsRestModel.getEbankId() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getEmployeeId() != null
				&& manageEmployeeBankDetailsRestModel.getEmployeeId() != "") {
			s = s + "@p_empId='" + manageEmployeeBankDetailsRestModel.getEmployeeId() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getEbankName() != null
				&& manageEmployeeBankDetailsRestModel.getEbankName() != "") {
			s = s + "@p_EbankName='" + manageEmployeeBankDetailsRestModel.getEbankName() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getEbankAddress() != null
				&& manageEmployeeBankDetailsRestModel.getEbankAddress() != "") {
			s = s + "@p_EbankAddress='" + manageEmployeeBankDetailsRestModel.getEbankAddress() + "',";
		}

		if (manageEmployeeBankDetailsRestModel.getEbankCity() != null
				&& manageEmployeeBankDetailsRestModel.getEbankCity() != "") {
			s = s + "@p_getEbankCity='" + manageEmployeeBankDetailsRestModel.getEbankCity() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getEbankState() != null
				&& manageEmployeeBankDetailsRestModel.getEbankState() != "") {
			s = s + "@p_getEbankState='" + manageEmployeeBankDetailsRestModel.getEbankState() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getEbankCountry() != null
				&& manageEmployeeBankDetailsRestModel.getEbankCountry() != "") {
			s = s + "@p_getEbankCountry='" + manageEmployeeBankDetailsRestModel.getEbankCountry() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getEbankAccountNo() != null
				&& manageEmployeeBankDetailsRestModel.getEbankAccountNo() != "") {
			s = s + "@p_getEbankAccountNo='" + manageEmployeeBankDetailsRestModel.getEbankAccountNo() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.geteIfic() != null
				&& manageEmployeeBankDetailsRestModel.geteIfic() != "") {
			s = s + "@p_geteIfic='" + manageEmployeeBankDetailsRestModel.geteIfic() + "',";
		}

		if (manageEmployeeBankDetailsRestModel.getBankPrimaryStatus() != null
				&& manageEmployeeBankDetailsRestModel.getBankPrimaryStatus() != "") {
			s = s + "@p_primaryStatusBank='" + manageEmployeeBankDetailsRestModel.getBankPrimaryStatus() + "',";
		} else {
			s = s + "@p_primaryStatusBank='" + 0 + "',";
		}

		if (manageEmployeeBankDetailsRestModel.getModule() != null
				&& manageEmployeeBankDetailsRestModel.getModule() != "") {
			s = s + "@p_module='" + manageEmployeeBankDetailsRestModel.getModule() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getComponent() != null
				&& manageEmployeeBankDetailsRestModel.getComponent() != "") {
			s = s + "@p_component='" + manageEmployeeBankDetailsRestModel.getComponent() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getSubcomponent() != null
				&& manageEmployeeBankDetailsRestModel.getSubcomponent() != "") {
			s = s + "@p_subComponent='" + manageEmployeeBankDetailsRestModel.getSubcomponent() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getCreatedBy() != null
				&& manageEmployeeBankDetailsRestModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + manageEmployeeBankDetailsRestModel.getCreatedBy() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getOrganization() != null
				&& manageEmployeeBankDetailsRestModel.getOrganization() != "") {
			s = s + "@p_org='" + manageEmployeeBankDetailsRestModel.getOrganization() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getOrgDivision() != null
				&& manageEmployeeBankDetailsRestModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + manageEmployeeBankDetailsRestModel.getOrgDivision() + "',";
		}
		if (manageEmployeeBankDetailsRestModel.getEbankDocument() != null
				&& manageEmployeeBankDetailsRestModel.getEbankDocument() != "") {
			s = s + "@p_docName='" + manageEmployeeBankDetailsRestModel.getEbankDocument() + "',";
		} else {
			s = s + "@p_docName='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String insurancedetails(
			ManageEmployeeInsuranceDetailsrestModel manageEmployeeInsuranceDetailsrestModel) {

		String s = "";

		if (manageEmployeeInsuranceDetailsrestModel.getEinsuraneId() != null
				&& manageEmployeeInsuranceDetailsrestModel.getEinsuraneId() != "") {
			s = s + "@p_einsuranceId='" + manageEmployeeInsuranceDetailsrestModel.getEinsuraneId() + "',";
		}
		if (manageEmployeeInsuranceDetailsrestModel.getEmployeeId() != null
				&& manageEmployeeInsuranceDetailsrestModel.getEmployeeId() != "") {
			s = s + "@p_empId='" + manageEmployeeInsuranceDetailsrestModel.getEmployeeId() + "',";
		}
		if (manageEmployeeInsuranceDetailsrestModel.getEinsurancetype() != null
				&& manageEmployeeInsuranceDetailsrestModel.getEinsurancetype() != "") {
			s = s + "@p_Einsurancetype='" + manageEmployeeInsuranceDetailsrestModel.getEinsurancetype() + "',";
		}
		if (manageEmployeeInsuranceDetailsrestModel.getEinsurancecompany() != null
				&& manageEmployeeInsuranceDetailsrestModel.getEinsurancecompany() != "") {
			s = s + "@p_Einsurancecompany='" + manageEmployeeInsuranceDetailsrestModel.getEinsurancecompany() + "',";
		}

		if (manageEmployeeInsuranceDetailsrestModel.getPolicyno() != null
				&& manageEmployeeInsuranceDetailsrestModel.getPolicyno() != "") {
			s = s + "@p_einsurancepolicy='" + manageEmployeeInsuranceDetailsrestModel.getPolicyno() + "',";
		}
		if (manageEmployeeInsuranceDetailsrestModel.getEifromdate() != null
				&& manageEmployeeInsuranceDetailsrestModel.getEifromdate() != "") {
			s = s + "@p_eifromdate='" + manageEmployeeInsuranceDetailsrestModel.getEifromdate() + "',";
		}
		if (manageEmployeeInsuranceDetailsrestModel.getEitodate() != null
				&& manageEmployeeInsuranceDetailsrestModel.getEitodate() != "") {
			s = s + "@p_eitodate='" + manageEmployeeInsuranceDetailsrestModel.getEitodate() + "',";
		}

		if (manageEmployeeInsuranceDetailsrestModel.getCreatedBy() != null
				&& manageEmployeeInsuranceDetailsrestModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + manageEmployeeInsuranceDetailsrestModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getAddbenParam(ManageEmployeeBenifitrestModel manageEmployeeBenifitrestModel) {

		String s = "";
		String qItem = "";

		if (manageEmployeeBenifitrestModel.getEmployeeId() != null
				|| manageEmployeeBenifitrestModel.getEmployeeId() != "") {
			for (int i = 0; i < manageEmployeeBenifitrestModel.getBenefits().size(); i++) {
				qItem = qItem + "(\"" + manageEmployeeBenifitrestModel.getEmployeeId() + "\",\""
						+ manageEmployeeBenifitrestModel.getBenefits().get(i) + "\",\""
						+ manageEmployeeBenifitrestModel.getCreatedby() + "\"),";
			}
			qItem = qItem.substring(0, qItem.length() - 1);

		}
		s = s + "@p_benefitsData='" + qItem + "',";
		s = s + "@p_empId='" + manageEmployeeBenifitrestModel.getEmployeeId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		return s;
	}

	public static String getEmployeeOtherDoc(ManageEmployeeDocumentRestModel employeeDocumentModel) {

		String s = "";
		if (employeeDocumentModel.getEmployeeId() != null && employeeDocumentModel.getEmployeeId() != "") {
			s = s + "@p_empId='" + employeeDocumentModel.getEmployeeId() + "',";
		}
		if (employeeDocumentModel.getDocumentType() != null && employeeDocumentModel.getDocumentType() != "") {
			s = s + "@p_docType='" + employeeDocumentModel.getDocumentType() + "',";
		}
		if (employeeDocumentModel.getDocumentName() != null && employeeDocumentModel.getDocumentName() != "") {
			s = s + "@p_docName='" + employeeDocumentModel.getDocumentName() + "',";
		}
		if (employeeDocumentModel.getCreatedBy() != null && employeeDocumentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + employeeDocumentModel.getCreatedBy() + "',";
		}
		if (employeeDocumentModel.getStatus() != null && employeeDocumentModel.getStatus() != "") {
			s = s + "@p_status='" + employeeDocumentModel.getStatus() + "',";
		}
		if (employeeDocumentModel.getOrganization() != null && employeeDocumentModel.getOrganization() != "") {
			s = s + "@p_org='" + employeeDocumentModel.getOrganization() + "',";
		}
		if (employeeDocumentModel.getOrgDivision() != null && employeeDocumentModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + employeeDocumentModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		return s;
	}

	public static String saveempaddApi(List<ManageEmployeeAddressRestModel> manageEmployeeAddressRestModel) {
		String s = "";
		String addressList = "";

		String addressId = "";
		String empId = "";

		for (ManageEmployeeAddressRestModel m : manageEmployeeAddressRestModel) {
			addressId = m.getAddressId();
			empId = m.getEmployeeId();

		}

		s = s + "@p_getAddressId='" + addressId + "',";
		s = s + "@p_empId='" + empId + "',";

		for (ManageEmployeeAddressRestModel m : manageEmployeeAddressRestModel) {
			addressList = addressList + "(@p_getAddressId,\"" + m.getEmployeeId() + "\" ,\"" + m.getType() + "\",\""
					+ m.getAddress() + "\",\"" + m.getCity() + "\",\"" + m.getState() + "\",\"" + m.getCountry()
					+ "\",\"" + m.getZipCode() + "\",\"" + m.getStatus() + "\",\"" + m.getCreatedBy() + "\",\""
					+ m.getCreatedBy() + "\",\"" + m.getCreatedBy() + "\"),";
		}

		addressList = addressList.substring(0, addressList.length() - 1);

		s = s + "@p_addressSubQuery='" + addressList + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String addContactMailDtls(EmployeeDocumentModel employeeDocumentModel) {

		String s = "";
		String qItem = "";
		if (employeeDocumentModel.getDraftId() != null || employeeDocumentModel.getDraftId() != "") {
			s = s + "@p_draftId='" + employeeDocumentModel.getDraftId() + "',";
		}
		if (employeeDocumentModel.getEmailContactId() != null || employeeDocumentModel.getEmailContactId() != "") {
			s = s + "@p_contactMailId='" + employeeDocumentModel.getEmailContactId() + "',";
		}
		if (employeeDocumentModel.getLeadId() != null || employeeDocumentModel.getLeadId() != "") {
			s = s + "@p_leadId='" + employeeDocumentModel.getLeadId() + "',";
		}
		if (employeeDocumentModel.getDealId() != null || employeeDocumentModel.getDealId() != "") {
			s = s + "@p_dealId='" + employeeDocumentModel.getDealId() + "',";
		}
		if (employeeDocumentModel.getEmailAccountId() != null || employeeDocumentModel.getEmailAccountId() != "") {
			s = s + "@p_accountId='" + employeeDocumentModel.getEmailAccountId() + "',";
		}
		if (employeeDocumentModel.getQuoteId() != null || employeeDocumentModel.getQuoteId() != "") {
			s = s + "@p_quoteId='" + employeeDocumentModel.getQuoteId() + "',";
		}
		if (employeeDocumentModel.getSoId() != null || employeeDocumentModel.getSoId() != "") {
			s = s + "@p_soId='" + employeeDocumentModel.getSoId() + "',";
		}
		if (employeeDocumentModel.getPoId() != null || employeeDocumentModel.getPoId() != "") {
			s = s + "@p_poId='" + employeeDocumentModel.getPoId() + "',";
		}
		if (employeeDocumentModel.getInvoiceId() != null || employeeDocumentModel.getInvoiceId() != "") {
			s = s + "@p_invoiceId='" + employeeDocumentModel.getInvoiceId() + "',";
		}
		if (employeeDocumentModel.getFromEmail() != null || employeeDocumentModel.getFromEmail() != "") {
			s = s + "@p_fromEmail='" + employeeDocumentModel.getFromEmail() + "',";
		}
		if (employeeDocumentModel.getToMail() != null || employeeDocumentModel.getToMail() != "") {
			s = s + "@p_toEmail='" + employeeDocumentModel.getToMail() + "',";
		}
		if (employeeDocumentModel.getMailSubject() != null || employeeDocumentModel.getMailSubject() != "") {
			s = s + "@p_mailSub='" + employeeDocumentModel.getMailSubject() + "',";
		}
		if (employeeDocumentModel.getCommentck() != null || employeeDocumentModel.getCommentck() != "") {
			s = s + "@p_comment='" + employeeDocumentModel.getCommentck() + "',";
		}
		if (employeeDocumentModel.getDocName() != null || employeeDocumentModel.getDocName() != "") {
			s = s + "@p_docName='" + employeeDocumentModel.getDocName() + "',";
		}
		if (employeeDocumentModel.getCreatedBy() != null || employeeDocumentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + employeeDocumentModel.getCreatedBy() + "',";
		}
		if (employeeDocumentModel.getCcMail() != null || employeeDocumentModel.getCcMail() != "") {
			s = s + "@p_ccMail='" + employeeDocumentModel.getCcMail() + "',";
		}
		if (employeeDocumentModel.getBccMail() != null || employeeDocumentModel.getBccMail() != "") {
			s = s + "@p_bccMail='" + employeeDocumentModel.getBccMail() + "',";
		}
		if (employeeDocumentModel.getOrganization() != null || employeeDocumentModel.getOrganization() != "") {
			s = s + "@p_organization='" + employeeDocumentModel.getOrganization() + "',";
		}
		if (employeeDocumentModel.getOrgDivision() != null || employeeDocumentModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + employeeDocumentModel.getOrgDivision() + "',";
		}

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		if (employeeDocumentModel.getDocumentList() != null && !employeeDocumentModel.getDocumentList().isEmpty()) {
		    for (InventoryVendorDocumentModel a : employeeDocumentModel.getDocumentList()) {
		        qItem = qItem + "(@p_contactMailId,@p_leadId,@p_dealId,@p_accountId,@p_quoteId,@p_soId,"
		                + "@p_poId,@p_invoiceId,@p_fromEmail,@p_toEmail,@p_mailSub,@p_comment,"
		                + "\"" + a.getDocumnentName().replace("'", "\\'").replace("\"", "\\\"") + "\",\""
		                + a.getFileName().replace("'", "\\'").replace("\"", "\\\"") + "\",@p_createdBy,@p_ccMail,@p_bccMail,@p_organization,@p_orgDivision),";
		    }
		} else {
		    qItem = "(@p_contactMailId,@p_leadId,@p_dealId,@p_accountId,@p_quoteId,@p_soId,"
		            + "@p_poId,@p_invoiceId,@p_fromEmail,@p_toEmail,@p_mailSub,@p_comment,"
		            + "\"\",\"\",@p_createdBy,@p_ccMail,@p_bccMail,@p_organization,@p_orgDivision),";
		}


System.out.println("Value For Vendor Document Parameter------>"+qItem);
		if (!qItem.isEmpty()) {
			qItem = qItem.substring(0, qItem.length() - 1);
			s = s + "@p_vendorDocuments='" + qItem + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		System.out.println("email details for save------------------------------" + s);
		return s;

	}

	public static String getLeadNoteDoc(EmployeeDocumentModel employeeDocumentModel) {

		String s = "";
		String qItem = "";
		s = s + "@p_notedets='" + employeeDocumentModel.getNotedets() + "',";
		s = s + "@p_leadNoteId='" + employeeDocumentModel.getLeadNoteId() + "',";
		s = s + "@p_leadId='" + employeeDocumentModel.getLeadId() + "',";
		s = s + "@p_contactId='" + employeeDocumentModel.getContactId() + "',";
		s = s + "@p_dealId='" + employeeDocumentModel.getDealId() + "',";
		s = s + "@p_accountId='" + employeeDocumentModel.getAccountId() + "',";
		s = s + "@p_quoteId='" + employeeDocumentModel.getQuoteId() + "',";
		s = s + "@p_soId='" + employeeDocumentModel.getSoId() + "',";
		s = s + "@p_poId='" + employeeDocumentModel.getPoId() + "',";
		s = s + "@p_invoiceId='" + employeeDocumentModel.getInvoiceId() + "',";
		s = s + "@p_titleId='" + employeeDocumentModel.getTitleId().replace("'", "\\'").replace("\"", "\\\\\"") + "',";
		s = s + "@p_noteId='" + employeeDocumentModel.getNoteId().replace("'", "\\'").replace("\"", "\\\\\"") + "',";
		s = s + "@p_createdBy='" + employeeDocumentModel.getCreatedBy() + "',";
		s = s + "@p_latitude='" + employeeDocumentModel.getLatitude() + "',";
		s = s + "@p_longitude='" + employeeDocumentModel.getLongitude() + "',";
		s = s + "@p_address='" + employeeDocumentModel.getAddress() + "',";
		s = s + "@org='" + employeeDocumentModel.getOrganization() + "',";
		s = s + "@orgDiv='" + employeeDocumentModel.getOrgDivision() + "',";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		JSONArray jsonArray = new JSONArray();

		List<JSONObject> myJSONObjects = new ArrayList<JSONObject>();

		for (int i = 0; i < employeeDocumentModel.getDocumentList().size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("fileName", employeeDocumentModel.getDocumentList().get(i).getFileName());
			obj.put("fileUrl", employeeDocumentModel.getDocumentList().get(i).getDocumnentName());
			myJSONObjects.add(obj);

		}
		s = s + "@p_noteDoc='" + myJSONObjects + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("sss@@@@@@@@@@@@@@@@@" + s);
		return s;
	}

	public static String addDocTypeParam(ManageEmployeeDocumentRestModel employeeDocumentModel) {

		String s = "";
		if (employeeDocumentModel.getDocumentType() != null && employeeDocumentModel.getDocumentType() != "") {
			s = s + "@p_docType='" + employeeDocumentModel.getDocumentType() + "',";
		} else {
			s = s + "@p_docType='',";
		}
		if (employeeDocumentModel.getDocumentName() != null && employeeDocumentModel.getDocumentName() != "") {
			s = s + "@p_docName='" + employeeDocumentModel.getDocumentName() + "',";
		} else {
			s = s + "@p_docName='',";
		}
		if (employeeDocumentModel.getCreatedBy() != null && employeeDocumentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + employeeDocumentModel.getCreatedBy() + "',";
		}
		if (employeeDocumentModel.getOrganization() != null && employeeDocumentModel.getOrganization() != "") {
			s = s + "@p_org='" + employeeDocumentModel.getOrganization() + "',";
		}
		if (employeeDocumentModel.getOrgDivision() != null && employeeDocumentModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + employeeDocumentModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		return s;
	}

	public static String saveempeducation(ManageEmployeeEducationRestModel education) {
		String s = "";
		if (education.getEmpId() != null && education.getEmpId() != "") {
			s = s + "@p_empId='" + education.getEmpId() + "',";
		}
		if (education.getEduId() != null && education.getEduId() != "") {
			s = s + "@p_eduId='" + education.getEduId() + "',";
		} else {
			s = s + "@p_eduId='',";
		}
		if (education.getQualification() != null && education.getQualification() != "") {
			s = s + "@p_qualification='" + education.getQualification() + "',";
		} else {
			s = s + "@p_qualification='',";
		}
		if (education.getInstiname() != null && education.getInstiname() != "") {
			s = s + "@p_instituteName='" + education.getInstiname() + "',";
		} else {
			s = s + "@p_instituteName='',";
		}
		if (education.getPassyear() != null && education.getPassyear() != "") {
			s = s + "@p_passYear='" + education.getPassyear() + "',";
		} else {
			s = s + "@p_passYear='',";
		}
		if (education.getDocName() != null && education.getDocName() != "") {
			s = s + "@p_docName='" + education.getDocName() + "',";
		} else {
			s = s + "@p_docName='',";
		}
		if (education.getCreatedBy() != null && education.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + education.getCreatedBy() + "',";
		}
		if (education.getOrganization() != null && education.getOrganization() != "") {
			s = s + "@p_org='" + education.getOrganization() + "',";
		}
		if (education.getOrgDivision() != null && education.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + education.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		return s;
	}
}
