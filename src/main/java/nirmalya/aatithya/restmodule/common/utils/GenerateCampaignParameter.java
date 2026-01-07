package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;

public class GenerateCampaignParameter {

	public static String getAddCampaignParam(RestCrmCampaignModel form) {
		// TODO Auto-generated method stub
		String s = "";		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		if (form.getCampaignId() != null && form.getCampaignId() != "") {
			s = s + "@p_campaignId='" + form.getCampaignId() + "',";
		}		
		if (form.getLeadId() != null && form.getLeadId() != "") {
			s = s + "@p_leadId='" + form.getLeadId() + "',";
		}			
		if (form.getOwnerName() != null && form.getOwnerName() != "") {
			s = s + "@p_ownerName='" + form.getOwnerName() + "',";
		}
		if (form.getCampaignOwner()!= null && form.getCampaignOwner() != "") {
			s = s + "@p_campaignOwner='" + form.getCampaignOwner() + "',";
		}		
		if (form.getCampaignType()!= null && form.getCampaignType() != "") {
			s = s + "@p_campaignType='" + form.getCampaignType() + "',";
		}		
		if (form.getCampaignName()!= null && form.getCampaignName() != "") {
			s = s + "@p_campaignName ='" + form.getCampaignName() + "',";
		}		
		if (form.getCampaignStatus() != null && form.getCampaignStatus() != "") {
			s = s + "@p_campaignStatus ='" + form.getCampaignStatus() + "',";
		}		
		if (form.getStartDate() != null && form.getStartDate() != "") {
			//s = s + "@p_campaignStartDate='" + DateFormatter.getStringDate(form.getStartDate()) + "',";
			
			s = s + "@p_campaignStartDate='" + form.getStartDate() + "',";
		}		
		if (form.getEndDate() != null && form.getEndDate() != "") {
			//s = s + "@p_campaignEndDate='" + DateFormatter.getStringDate(form.getEndDate()) + "',";
			s = s + "@p_campaignEndDate='" + form.getEndDate() + "',";
		}		
		if (form.getExpectedRevenue() != null && form.getExpectedRevenue() != "") {
			s = s + "@p_expectedRevenue='" + form.getExpectedRevenue() + "',";
		}		
		if (form.getBudgetedCost() != null && form.getBudgetedCost() != "") {
			s = s + "@p_budgetedCost='" + form.getBudgetedCost() + "',";
		}		
		if (form.getActualCost() != null && form.getActualCost() != "") {
			s = s + "@p_actualCost='" + form.getActualCost() + "',";
		}		
		if (form.getExpectedResponse()!= null && form.getExpectedResponse() != "") {
			s = s + "@p_expectedResponse='" + form.getExpectedResponse() + "',";
		}		
		if (form.getNumberSent() != null && form.getNumberSent() != "") {
			s = s + "@p_numberSent='" + form.getNumberSent() + "',";
		}		
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description ='" + form.getDescription() + "',";
		}				
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		if (form.getCampaignContactId() != null && form.getCampaignContactId() != "") {
			s = s + "@p_contactId ='" + form.getCampaignContactId() + "',";
		}
		if (form.getAccountId() != null && form.getAccountId() != "") {
			s = s + "@p_accountId ='" + form.getAccountId() + "',";
		}
		if (form.getOrganization() != null && form.getOrganization() != "") {
			s = s + "@org ='" + form.getOrganization() + "',";
		}
		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@orgDiv ='" + form.getOrgDivision() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------"+s);
		return s;

	}
	
	
	
}
