package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmDailyWorkModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;

public class GenerateDailyWorkParameter {

	public static String getAddDailyWorkParam(RestCrmDailyWorkModel form) {
		// TODO Auto-generated method stub
		String s = "";		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		
		if (form.getActivityId() != null && form.getActivityId() != "") {
			s = s + "@p_activityId='" + form.getActivityId() + "',";
		}
		
		
		if (form.getOwner() != null && form.getOwner() != "") {
			s = s + "@p_owner='" + form.getOwner() + "',";
		}

		
		
		if (form.getActivityName()!= null && form.getActivityName() != "") {
			s = s + "@p_activityName ='" + form.getActivityName() + "',";
		}
		
		if (form.getActivityStatus() != null && form.getActivityStatus() != "") {
			s = s + "@p_activityStatus ='" + form.getActivityStatus() + "',";
		}
		
		if (form.getTodayDate() != null && form.getTodayDate() != "") {
			//s = s + "@p_campaignStartDate='" + DateFormatter.getStringDate(form.getStartDate()) + "',";
			
			s = s + "@p_todayDate='" + form.getTodayDate() + "',";
		}
		
		
		
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description ='" + form.getDescription() + "',";
		}
			
		
				
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------"+s);
		return s;

	}
	
	
	
}
