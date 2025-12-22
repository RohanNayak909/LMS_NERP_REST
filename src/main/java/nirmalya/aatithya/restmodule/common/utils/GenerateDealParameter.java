package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;

public class GenerateDealParameter {

	public static String getAddDealParam(RestDealModel form) {
		// TODO Auto-generated method stub
		String s = "";		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		if (form.getDealId() != null && form.getDealId() != "") {
			s = s + "@p_dealId='" + form.getDealId() + "',";
		}
		

		if (form.getDealOwner()!= null && form.getDealOwner() != "") {
			s = s + "@p_dealOwner='" + form.getDealOwner() + "',";
		}
		
		if (form.getDealAmount()!= null && form.getDealAmount() != "") {
			s = s + "@p_dealAmount='" + form.getDealAmount() + "',";
		}
		if (form.getDealName() != null  && form.getDealName() != "") {
			s = s + "@p_dealName='" + form.getDealName() + "',";
		}
		if (form.getDealClosingDate() != null  && form.getDealClosingDate() != "") {
			//s = s + "@p_dealClosingDate='" + DateFormatter.getStringDate(form.getDealClosingDate()) + "',";
			
			s = s + "@p_dealClosingDate='" + form.getDealClosingDate() + "',";
		}
		if (form.getDealAccountName() != null && form.getDealAccountName() != "") {
			s = s + "@p_dealAccountName='" + form.getDealAccountName() + "',";
		}
		
		if (form.getDealStage() != null && form.getDealStage() != "") {
			s = s + "@p_dealStage='" + form.getDealStage() + "',";
		}
		if (form.getDealType() != null && form.getDealType() != "") {
			s = s + "@p_dealType='" + form.getDealType() + "',";
		}
		if (form.getProbability() != null && form.getProbability() != "") {
			s = s + "@p_probability='" + form.getProbability() + "',";
		}
		
		if (form.getNextStep() != null && form.getNextStep() != "") {
			s = s + "@p_nextStep='" + form.getNextStep() + "',";
		}
		if (form.getExpectedRevenue() != null && form.getExpectedRevenue() != "") {
			s = s + "@p_expectedRevenue='" + form.getExpectedRevenue() + "',";
		}
				
	
		if (form.getDealLeadSource() != null && form.getDealLeadSource() != "") {
			s = s + "@p_dealLeadSource='" + form.getDealLeadSource() + "',";
		}
		
		if (form.getCampaignSource() != null && form.getCampaignSource() != "") {
			s = s + "@p_campaignSource='" + form.getCampaignSource() + "',";
		}

		if (form.getContactName() != null && form.getContactName() != "") {
			s = s + "@p_contactName='" + form.getContactName() + "',";
		}
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription() + "',";
		}
				
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		if (form.getAccountId() != null && form.getAccountId() != "") {
			s = s + "@p_accountId='" + form.getAccountId() + "',";
		}
		if (form.getCampaignSourceId() != null && form.getCampaignSourceId() != "") {
			s = s + "@p_cSourceId='" + form.getCampaignSourceId() + "',";
		}
				
		if (form.getContactId() != null && form.getContactId() != "") {
			s = s + "@p_contactId='" + form.getContactId() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------"+s);
		return s;

	}
	
	
	
}
