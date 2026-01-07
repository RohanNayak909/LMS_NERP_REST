package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;

public class GenerateCrmLeadDetails {
	public static String dateString = "";

	public static String generateCrmLeadParam(RestCrmLeadsModel crmModel) {

		String s = "";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		if (crmModel.getLeadId() != null && crmModel.getLeadId() != "") {
			s = s + "@p_leadId='" + crmModel.getLeadId() + "',";
		}else {
			s = s + "@p_leadId='',";
		}
		if (crmModel.getLeadOwner() != null && crmModel.getLeadOwner() != "") {
			s = s + "@p_leadOwner='" + crmModel.getLeadOwner() + "',";
		}else {
			s = s + "@p_leadOwner='',";
		}
		if (crmModel.getCompany() != null && crmModel.getCompany() != "") {
			s = s + "@p_company='" + crmModel.getCompany() + "',";
		}else {
			s = s + "@p_company='',";
		}
		if (crmModel.getFirstName() != null && crmModel.getFirstName() != "") {
			s = s + "@p_firstName='" + crmModel.getFirstName() + "',";
		}else {
			s = s + "@p_firstName='',";
		}
		if (crmModel.getLastName() != null && crmModel.getLastName() != "") {
			s = s + "@p_lastName='" + crmModel.getLastName() + "',";
		}else {
			s = s + "@p_lastName='',";
		}
		if (crmModel.getTitle() != null && crmModel.getTitle() != "") {
			s = s + "@p_title='" + crmModel.getTitle() + "',";
		}else {
			s = s + "@p_title='',";
		}
		if (crmModel.getEmail() != null && crmModel.getEmail() != "") {
			s = s + "@p_email='" + crmModel.getEmail() + "',";
		}else {
			s = s + "@p_email='',";
		}
		if (crmModel.getPhone() != null && crmModel.getPhone() != "") {
			s = s + "@p_phone='" + crmModel.getPhone() + "',";
		}else {
			s = s + "@p_phone='',";
		}
		if (crmModel.getFax() != null && crmModel.getFax() != "") {
			s = s + "@p_fax='" + crmModel.getFax() + "',";
		}else {
			s = s + "@p_fax='',";
		}
		if (crmModel.getMobile() != null && crmModel.getMobile() != "") {
			s = s + "@p_mobile='" + crmModel.getMobile() + "',";
		}else {
			s = s + "@p_mobile='',";
		}
		if (crmModel.getWebsite() != null && crmModel.getWebsite() != "") {
			s = s + "@p_webSite='" + crmModel.getWebsite() + "',";
		}else {
			s = s + "@p_webSite='',";
		}
		if (crmModel.getReferenceContact() != null && crmModel.getReferenceContact() != "") {
			s = s + "@p_referenceContact='" + crmModel.getReferenceContact() + "',";
		}else {
			s = s + "@p_referenceContact='',";
		}
		if (crmModel.getLeadSource() != null && crmModel.getLeadSource() != "") {
			s = s + "@p_leadSource='" + crmModel.getLeadSource() + "',";
		}else {
			s = s + "@p_leadSource='',";
		}
		if (crmModel.getLeadStatus() != null && crmModel.getLeadStatus() != "") {
			s = s + "@p_leadStatus='" + crmModel.getLeadStatus() + "',";
		}else {
			s = s + "@p_leadStatus='',";
		}
		if (crmModel.getIndustry() != null && crmModel.getIndustry() != "") {
			s = s + "@p_industry='" + crmModel.getIndustry() + "',";
		}else {
			s = s + "@p_industry='',";
		}
		if (crmModel.getNoOfEmp() != null && crmModel.getNoOfEmp() != "") {
			s = s + "@p_noOfEmployee='" + crmModel.getNoOfEmp() + "',";
		}else {
			s = s + "@p_noOfEmployee='',";
		}
		if (crmModel.getAnnualRevenue() != null && crmModel.getAnnualRevenue() != "") {
			s = s + "@p_annualRevenue='" + crmModel.getAnnualRevenue() + "',";
		}else {
			s = s + "@p_annualRevenue='',";
		}
		if (crmModel.getRatings() != null && crmModel.getRatings() != "") {
			s = s + "@p_ratings='" + crmModel.getRatings() + "',";
		}else {
			s = s + "@p_ratings='',";
		}
		if (crmModel.getEmailOpt() != null && crmModel.getEmailOpt() != "") {
			s = s + "@p_emailOpt='" + crmModel.getEmailOpt() + "',";
		}else {
			s = s + "@p_emailOpt='',";
		}
		if (crmModel.getSkypeId() != null && crmModel.getSkypeId() != "") {
			s = s + "@p_skypeId='" + crmModel.getSkypeId() + "',";
		}else {
			s = s + "@p_skypeId='',";
		}
		if (crmModel.getSecondaryEmail() != null && crmModel.getSecondaryEmail() != "") {
			s = s + "@p_secondaryEmail='" + crmModel.getSecondaryEmail() + "',";
		}else {
			s = s + "@p_secondaryEmail='',";
		}
		if (crmModel.getTwitter() != null && crmModel.getTwitter() != "") {
			s = s + "@p_twitter='" + crmModel.getTwitter() + "',";
		}else {
			s = s + "@p_twitter='',";
		}
		if (crmModel.getCountry() != null && crmModel.getCountry() != "") {
			s = s + "@p_country='" + crmModel.getCountry() + "',";
		}else {
			s = s + "@p_country='',";
		}
		if (crmModel.getStates() != null && crmModel.getStates() != "") {
			s = s + "@p_states='" + crmModel.getStates() + "',";
		}else {
			s = s + "@p_states='',";
		}
		if (crmModel.getCity() != null && crmModel.getCity() != "") {
			s = s + "@p_city='" + crmModel.getCity() + "',";
		}else {
			s = s + "@p_city='',";
		}
		if (crmModel.getAddressStreet() != null && crmModel.getAddressStreet() != "") {
			s = s + "@p_addressStreet='" + crmModel.getAddressStreet() + "',";
		}else {
			s = s + "@p_addressStreet='',";
		}
		if (crmModel.getZip() != null && crmModel.getZip() != "") {
			s = s + "@p_zip='" + crmModel.getZip() + "',";
		}else {
			s = s + "@p_zip='',";
		}
		if (crmModel.getDescription() != null && !crmModel.getDescription().isEmpty()) {
		    String sanitizedDescription = crmModel.getDescription().replace("'", "\\'").replace("\"", "\\\\\"");
		    s = s + "@p_desc='" + sanitizedDescription + "',";
		} else {
		    s = s + "@p_desc='',";
		}

		if (crmModel.getImageName() != null && crmModel.getImageName() != "") {
			s = s + "@p_image='" + crmModel.getImageName() + "',";
		}else {
			s = s + "@p_image='',";
		}
		if (crmModel.getCreatedBy() != null && crmModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + crmModel.getCreatedBy() + "',";
		}else {
			s = s + "@p_createdBy='',";
		}
		if (crmModel.getOrganization() != null && crmModel.getOrganization() != "") {
			s = s + "@p_organization='" + crmModel.getOrganization() + "',";
		}else {
			s = s + "@p_organization='',";
		}
		if (crmModel.getOrgDivision() != null && crmModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + crmModel.getOrgDivision() + "',";
		}else {
			s = s + "@p_orgDivision='',";
		}
		if (crmModel.getNoteId() != null && crmModel.getNoteId() != "") {
			s = s + "@p_noteId='" + crmModel.getNoteId() + "',";
		}else {
			s = s + "@p_noteId='',";
		}
		if (crmModel.getTitleId() != null && crmModel.getTitleId() != "") {
			s = s + "@p_titleId='" + crmModel.getTitleId() + "',";
		}else {
			s = s + "@p_titleId='',";
		}
		if (crmModel.getReason() != null && crmModel.getReason() != "") {
			s = s + "@p_reason='" + crmModel.getReason() + "',";
		}else {
			s = s + "@p_titleId='',";
		}
		List<JSONObject> myJSONObjects = new ArrayList<JSONObject>();
		System.out.println("Doccccccccccccccccccc============>"+crmModel.getDocumentList());
		if (crmModel.getDocumentList() != null) {
		    for (int i = 0; i < crmModel.getDocumentList().size(); i++) {
		        JSONObject obj = new JSONObject();
		        obj.put("fileName", crmModel.getDocumentList().get(i).getFileName());
		        obj.put("fileUrl", crmModel.getDocumentList().get(i).getDocumnentName());
		        obj.put("desc", crmModel.getDocumentList().get(i).getDesc());
		        myJSONObjects.add(obj);
		        System.out.println("DoC OBJ======>"+obj);
		    }
		}
		s = s + "@p_noteDoc='" + myJSONObjects + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("Lead Data" + s);

		return s;
	}

	public static String CrmLeadParam(RestCrmLeadsModel crmModel) {

		String s = "";

		if (crmModel.getLeadOwner() != null && crmModel.getLeadOwner() != "") {
			s = s + "@p_leadOwner='" + crmModel.getLeadOwner() + "',";
		}
		if (crmModel.getCompany() != null && crmModel.getCompany() != "") {
			s = s + "@p_company='" + crmModel.getCompany() + "',";
		}
		if (crmModel.getFirstName() != null && crmModel.getFirstName() != "") {
			s = s + "@p_firstName='" + crmModel.getFirstName() + "',";
		}
		if (crmModel.getLastName() != null && crmModel.getLastName() != "") {
			s = s + "@p_lastName='" + crmModel.getLastName() + "',";
		}
		if (crmModel.getTitle() != null && crmModel.getTitle() != "") {
			s = s + "@p_title='" + crmModel.getTitle() + "',";
		}
		if (crmModel.getEmail() != null && crmModel.getEmail() != "") {
			s = s + "@p_email='" + crmModel.getEmail() + "',";
		}
		if (crmModel.getPhone() != null && crmModel.getPhone() != "") {
			s = s + "@p_phone='" + crmModel.getPhone() + "',";
		}
		if (crmModel.getFax() != null && crmModel.getFax() != "") {
			s = s + "@p_fax='" + crmModel.getFax() + "',";
		}
		if (crmModel.getMobile() != null && crmModel.getMobile() != "") {
			s = s + "@p_mobile='" + crmModel.getMobile() + "',";
		}
		if (crmModel.getWebsite() != null && crmModel.getWebsite() != "") {
			s = s + "@p_webSite='" + crmModel.getWebsite() + "',";
		}
		if (crmModel.getLeadSource() != null && crmModel.getLeadSource() != "") {
			s = s + "@p_leadSource='" + crmModel.getLeadSource() + "',";
		}
		if (crmModel.getLeadStatus() != null && crmModel.getLeadStatus() != "") {
			s = s + "@p_leadStatus='" + crmModel.getLeadStatus() + "',";
		}
		if (crmModel.getIndustry() != null && crmModel.getIndustry() != "") {
			s = s + "@p_industry='" + crmModel.getIndustry() + "',";
		}
		if (crmModel.getNoOfEmp() != null && crmModel.getNoOfEmp() != "") {
			s = s + "@p_noOfEmployee='" + crmModel.getNoOfEmp() + "',";
		}
		if (crmModel.getAnnualRevenue() != null && crmModel.getAnnualRevenue() != "") {
			s = s + "@p_annualRevenue='" + crmModel.getAnnualRevenue() + "',";
		}
		if (crmModel.getRatings() != null && crmModel.getRatings() != "") {
			s = s + "@p_ratings='" + crmModel.getRatings() + "',";
		}
		if (crmModel.getEmailOpt() != null && crmModel.getEmailOpt() != "") {
			s = s + "@p_emailOpt='" + crmModel.getEmailOpt() + "',";
		}
		if (crmModel.getSkypeId() != null && crmModel.getSkypeId() != "") {
			s = s + "@p_skypeId='" + crmModel.getSkypeId() + "',";
		}
		if (crmModel.getSecondaryEmail() != null && crmModel.getSecondaryEmail() != "") {
			s = s + "@p_secondaryEmail='" + crmModel.getSecondaryEmail() + "',";
		}
		if (crmModel.getTwitter() != null && crmModel.getTwitter() != "") {
			s = s + "@p_twitter='" + crmModel.getTwitter() + "',";
		}
		if (crmModel.getCountry() != null && crmModel.getCountry() != "") {
			s = s + "@p_country='" + crmModel.getCountry() + "',";
		}
		if (crmModel.getStates() != null && crmModel.getStates() != "") {
			s = s + "@p_states='" + crmModel.getStates() + "',";
		}
		if (crmModel.getCity() != null && crmModel.getCity() != "") {
			s = s + "@p_city='" + crmModel.getCity() + "',";
		}
		if (crmModel.getAddressStreet() != null && crmModel.getAddressStreet() != "") {
			s = s + "@p_addressStreet='" + crmModel.getAddressStreet() + "',";
		}
		if (crmModel.getZip() != null && crmModel.getZip() != "") {
			s = s + "@p_zip='" + crmModel.getZip() + "',";
		}
		if (crmModel.getCreatedBy() != null && crmModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + crmModel.getCreatedBy() + "',";
		}

		if (crmModel.getSearchConvertedAccount() != null && crmModel.getSearchConvertedAccount() != "") {
			s = s + "@p_convertedAmount='" + crmModel.getSearchConvertedAccount() + "',";
		}

		if (crmModel.getSearchConvertedContact() != null && crmModel.getSearchConvertedContact() != "") {
			s = s + "@p_convertedContact='" + crmModel.getSearchConvertedContact() + "',";
		}
		if (crmModel.getSearchConvertedDeal() != null && crmModel.getSearchConvertedDeal() != "") {
			s = s + "@p_convertedDeal='" + crmModel.getSearchConvertedDeal() + "',";
		}
		if (crmModel.getSearchCreatedTime() != null && crmModel.getSearchCreatedTime() != "") {
			s = s + "@p_createdTime='" + crmModel.getSearchCreatedTime() + "',";
		}
		if (crmModel.getSearchLastActivityTime() != null && crmModel.getSearchLastActivityTime() != "") {
			s = s + "@p_activityTime='" + crmModel.getSearchLastActivityTime() + "',";
		}
		if (crmModel.getSearchLeadConversionTime() != null && crmModel.getSearchLeadConversionTime() != "") {
			s = s + "@p_conversionTime='" + crmModel.getSearchLeadConversionTime() + "',";
		}
		if (crmModel.getSearchLeadName() != null && crmModel.getSearchLeadName() != "") {
			s = s + "@p_leadName='" + crmModel.getSearchLeadName() + "',";
		}

		if (crmModel.getSearchModifiedBy() != null && crmModel.getSearchModifiedBy() != "") {
			s = s + "@p_modifiedBy='" + crmModel.getSearchModifiedBy() + "',";
		}

		if (crmModel.getSearchModifiedTime() != null && crmModel.getSearchModifiedTime() != "") {
			s = s + "@p_modifiedTime='" + crmModel.getSearchModifiedTime() + "',";
		}
		if (crmModel.getSearchSalutation() != null && crmModel.getSearchSalutation() != "") {
			s = s + "@p_salutation='" + crmModel.getSearchSalutation() + "',";
		}
		if (crmModel.getSearchModifiedByTag() != null && crmModel.getSearchModifiedByTag() != "") {
			s = s + "@p_tag='" + crmModel.getSearchModifiedByTag() + "',";
		}
		if (crmModel.getSearchUnsubscribedMode() != null && crmModel.getSearchUnsubscribedMode() != "") {
			s = s + "@p_mode='" + crmModel.getSearchUnsubscribedMode() + "',";
		}

		if (crmModel.getSearchUnsubscribedTime() != null && crmModel.getSearchUnsubscribedTime() != "") {
			s = s + "@p_time='" + crmModel.getSearchUnsubscribedTime() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	// GenerateCrmLeadTask

	public static String addleadtask(List<RestCrmLeadsModel> leadTask) {
		String s = "";
		String sitem = "";

		for (RestCrmLeadsModel m : leadTask) {
			String taskDueDate = "";
			String reminderDate = "";
			String remDate = "";
			// taskDueDate= DateFormatter.getStringDate(m.getTaskDueDate());
			taskDueDate = m.getTaskDueDate();
			if (m.getReminderDate() != null && m.getReminderDate() != "") {
				// reminderDate= DateFormatter.getStringDate(m.getReminderDate());
				reminderDate = m.getReminderDate();
				remDate = "\"" + reminderDate + "\"";
			} else {
				remDate = null;
			}

			sitem = sitem + "(\"" + m.getLeadId() + "\",\"" + m.getTaskSubject() + "\",\"" + taskDueDate + "\"," + "\""
					+ m.getTaskPriority() + "\",\"" + m.getLeadOwner() + "\",\"" + m.getReminderYesOrNo() + "\","
					+ remDate + ",\"" + m.getReminderTime() + "\",\"" + m.getTaskAlertBy() + "\"," + "\""
					+ m.getRepeateYesOrNo() + "\",\"" + m.getTaskContactName() + "\",\"" + m.getContactId() + "\",\""
					+ m.getTaskAccountName() + "\",\"" + m.getAccountId() + "\",\"" + m.getTaskStatus() + "\",\""
					+ m.getDescription() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";
		}

		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "set @p_itemSubQuery='" + sitem + "',";
		// s = s +""+ sitem + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = s + ";";
		}

		// System.out.println("Generate Parameter" + s);

		return s;
	}

	// addleadtags
	public static String addleadtags(List<RestCrmLeadsModel> leadTags) {
		String s = "";
		String sitem = "";
		for (RestCrmLeadsModel m : leadTags) {
			sitem = sitem + "(\"" + m.getLeadId() + "\",\"" + m.getTagsName() + "\",\"" + m.getIsOverWrite() + "\",\""
					+ m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		s = s + "set @p_itemSubQuery='" + sitem + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = s + ";";
		}
		return s;
	}

	// addProductAssigned

	public static String addProductAssigned(List<RestCrmLeadsModel> leadTags) {
		String s = "";
		String sitem = "";
		for (RestCrmLeadsModel m : leadTags) {
			sitem = sitem + "(\"" + m.getLeadId() + "\",\"" + m.getContactId() + "\",\"" + m.getAccountId() + "\",\""
					+ m.getDealId() + "\",\"" + m.getProductId() + "\",\"" + m.getCreatedBy() + "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		s = s + "set @p_itemSubQuery='" + sitem + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = s + ";";
		}
		return s;
	}

	// addLeadMacro

	public static String addLeadMacro(List<RestCrmLeadsModel> leadMacro) {
		String s = "";
		String sitem = "";

		for (RestCrmLeadsModel m : leadMacro) {
			sitem = sitem + "(\"" + m.getLeadId() + "\",\"" + m.getMacroName() + "\",\"" + m.getMacroDescription()
					+ "\",\"" + m.getEmailType() + "\",\"" + m.getFieldName() + "\",\"" + m.getFieldValue() + "\",\""
					+ m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";
		}

		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "set @p_itemSubQuery='" + sitem + "',";
		// s = s +""+ sitem + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = s + ";";
		}

		// System.out.println("Generate Parameter" + s);

		return s;
	}

	// addLeadCampaign

	public static String addLeadCampaign(List<RestCrmLeadsModel> leadCampaign) {
		String s = "";
		String sitem = "";

		for (RestCrmLeadsModel m : leadCampaign) {
			sitem = sitem + "(\"" + m.getLeadId() + "\",\"" + m.getCampaignName() + "\"," + "\"" + m.getCampaignType()
					+ "\",\"" + m.getCampaignStatus() + "\",\"" + m.getStartDate() + "\",\"" + m.getEndDate() + "\","
					+ "\"" + m.getCampExpectRevenue() + "\",\"" + m.getCampaignOwner() + "\",\"" + m.getBudgetedCost()
					+ "\"," + "\"" + m.getActualCost() + "\",\"" + m.getExpectedResponse() + "\",\"" + m.getNumberSent()
					+ "\"," + "\"" + m.getDescription() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
		}

		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "set @p_itemSubQuery='" + sitem + "',";
		// s = s +""+ sitem + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = s + ";";
		}

		return s;

	}

	public static String addleadmail(List<RestCrmLeadsModel> leadTask) {
		String s = "";
		String sitem = "";
		
	


		for (RestCrmLeadsModel m : leadTask) {
			String taskDueDate="";
			String reminderDate="";

			sitem = sitem + "(\"" + m.getLeadId() + "\",\""+m.getFromEmail() +"\",\"" + m.getToMail()
			+"\",\"" + m.getMailSubject() +"\",\"" +m.getMailDescription() +"\",\"" + m.getAttachment()+
			"\",\"" + m.getDocnoid() + "\",\""+ m.getOrganization() + "\",\""+ m.getOrgDivision() + "\"),";
		}

		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "set @p_itemSubQuery='"+ sitem + "',";
		//s = s +""+ sitem + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = s + ";";
		}

		//System.out.println("Generate Parameter" + s);

		return s;
	}

	public static String addleadmacro(RestCrmTaskModel leadTask) {

		String s = "";
		String litem = "";

		/*
		 * for (RestCRMLeadTaskModel m : leadTask) { i = i + 1; grnNumber =
		 * m.getLeadId(); invoicenumber = m.getMacroName(); purchaseorder =
		 * m.getMacroDescription(); description = m.getField(); value = m.getValue();
		 * 
		 * if (m.getDueDate() != null && m.getDueDate() != "") { invDate =
		 * DateFormatter.getStringDate(m.getDueDate()); }
		 * 
		 * }
		 */

		// s = s + "@p_leadId='" + leadTask.getLeadId() + "',";
		// s = s + "@p_macroName='" + leadTask.getMacroName() + "',";
		// s = s + "@p_macroDescription='" + leadTask.getMacroDescription() + "',";
		// s = s + "@p_field='" + leadTask.getField() + "',";
		// s = s + "@p_value=" + leadTask.getValue() + ",";
		/*
		 * for (RestCRMLeadTaskModel m : leadTask) {
		 * 
		 * litem = litem + "(@p_leadId,\"" + m.getSubject() + "\",\"" + m.getDueDate() +
		 * "\",\"" + m.getDays() + "\",\"" + m.getStatus() + "\"," + m.getPriority() +
		 * "," + m.getNotifyTime() + ")'";
		 * 
		 * }
		 */

		// litem = litem.substring(0, litem.length() - 1);

		/*
		 * if(invGoodsReceiveModel.get(0).getAddChargeDetails()!=null) { for
		 * (DropDownModel m : invGoodsReceiveModel.get(0).getAddChargeDetails()) {
		 * if(m.getKey()!=null && m.getKey()!="" && m.getName()!=null &&
		 * m.getName()!="") { aitem = aitem + "(@p_gRNInvoiceId,\"" + m.getKey() + "\","
		 * + m.getName() + "),"; } }
		 * 
		 * aitem = aitem.substring(0, aitem.length() - 1); s = s +
		 * "@p_addChargesSubQuery='" + aitem + "',"; }
		 */

		// s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;

	}

	public static String generateCrmLeadConvertParam(RestCrmLeadsModel crmModel) {

		String s = "";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		if (crmModel.getLeadId() != null && crmModel.getLeadId() != "") {
			s = s + "@p_leadId='" + crmModel.getLeadId() + "',";
		}

		if (crmModel.getLeadOwnerId() != null && crmModel.getLeadOwnerId() != "") {
			s = s + "@p_leadOwnerId='" + crmModel.getLeadOwnerId() + "',";
		}

		if (crmModel.getFirstName() != null && crmModel.getFirstName() != "") {
			s = s + "@p_firstName='" + crmModel.getFirstName() + "',";
		}

		if (crmModel.getLastName() != null && crmModel.getLastName() != "") {
			s = s + "@p_lastName='" + crmModel.getLastName() + "',";
		}

		if (crmModel.getAccountName() != null && crmModel.getAccountName() != "") {
			s = s + "@p_accountName='" + crmModel.getAccountName() + "',";
		}

		if (crmModel.getDealCheck() != null && crmModel.getDealCheck() != "") {
			s = s + "@p_dealCheck='" + crmModel.getDealCheck() + "',";
		}

		if (crmModel.getDealAmount() != null && crmModel.getDealAmount() != "") {
			s = s + "@p_dealAmount='" + crmModel.getDealAmount() + "',";
		}

		if (crmModel.getDealName() != null && crmModel.getDealName() != "") {
			s = s + "@p_dealName='" + crmModel.getDealName() + "',";
		}

		if (crmModel.getDealClosingDate() != null && crmModel.getDealClosingDate() != "") {
			s = s + "@p_dealClosingDate='" + crmModel.getDealClosingDate() + "',";
		}

		if (crmModel.getDealStage() != null && crmModel.getDealStage() != "") {
			s = s + "@p_dealStage='" + crmModel.getDealStage() + "',";
		}

		if (crmModel.getDealCampaignSource() != null && crmModel.getDealCampaignSource() != "") {
			s = s + "@p_dealCampaignSource='" + crmModel.getDealCampaignSource() + "',";
		}

		if (crmModel.getDealContactRole() != null && crmModel.getDealContactRole() != "") {
			s = s + "@p_dealDealContactRole='" + crmModel.getDealContactRole() + "',";
		}

		if (crmModel.getCreatedBy() != null && crmModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + crmModel.getCreatedBy() + "',";
		}

		if (crmModel.getEmail() != null && crmModel.getEmail() != "") {
			s = s + "@p_email='" + crmModel.getEmail() + "',";
		}

		if (crmModel.getPhone() != null && crmModel.getPhone() != "") {
			s = s + "@p_phone='" + crmModel.getPhone() + "',";
		}

		if (crmModel.getFax() != null && crmModel.getFax() != "") {
			s = s + "@p_fax='" + crmModel.getFax() + "',";
		}

		if (crmModel.getWebsite() != null && crmModel.getWebsite() != "") {
			s = s + "@p_website='" + crmModel.getWebsite() + "',";
		}

		if (crmModel.getTitle() != null && crmModel.getTitle() != "") {
			s = s + "@p_title='" + crmModel.getTitle() + "',";
		}

		if (crmModel.getMobile() != null && crmModel.getMobile() != "") {
			s = s + "@p_mobile='" + crmModel.getMobile() + "',";
		}

		if (crmModel.getSkypeId() != null && crmModel.getSkypeId() != "") {
			s = s + "@p_skypeId='" + crmModel.getSkypeId() + "',";
		}

		if (crmModel.getSecondaryEmail() != null && crmModel.getSecondaryEmail() != "") {
			s = s + "@p_secondaryEmail='" + crmModel.getSecondaryEmail() + "',";
		}

		if (crmModel.getTwitter() != null && crmModel.getTwitter() != "") {
			s = s + "@p_twitter='" + crmModel.getTwitter() + "',";
		}

		if (crmModel.getDescription() != null && crmModel.getDescription() != "") {
			s = s + "@p_description='" + crmModel.getDescription() + "',";
		}

		if (crmModel.getReferenceContact() != null && crmModel.getReferenceContact() != "") {
			s = s + "@p_referenceContact='" + crmModel.getReferenceContact() + "',";
		}

		if (crmModel.getProbability() != null && crmModel.getProbability() != "") {
			s = s + "@p_probability='" + crmModel.getProbability() + "',";
		}

		if (crmModel.getOrganization() != null && crmModel.getOrganization() != "") {
			s = s + "@p_organization ='" + crmModel.getOrganization() + "',";
		}
		if (crmModel.getOrgDivision() != null && crmModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision ='" + crmModel.getOrgDivision() + "',";
		}

		if (crmModel.getCustomerId() != null && crmModel.getCustomerId() != "") {
			s = s + "@p_customerId ='" + crmModel.getCustomerId() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
