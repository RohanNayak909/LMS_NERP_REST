package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestEventActivityModel;
import nirmalya.aatithya.restmodule.master.model.RestEventNotificationModel;
import nirmalya.aatithya.restmodule.master.model.RestEventManagementModel;

public class HrmsGenerateEventManagement {

	public static String addEvent(RestEventManagementModel eventManagementModel) {
		// TODO Auto-generated method stub
		String s = "";
		String eventManagement = "";
		String eventActivity = "";
		String eventNotification = "";
		eventManagement = "(@p_eventId,\""+eventManagementModel.getEventName()
				+ "\",\""+eventManagementModel.getFromDate()
				+ "\",\""+eventManagementModel.getToDate()
				+ "\",\""+eventManagementModel.getEventOrganiser()
				+ "\",\""+eventManagementModel.getEventType()
				+ "\",\""+eventManagementModel.getEventResponsible()
				+ "\",\""+eventManagementModel.getEvantMaxRegd()
				+ "\",\""+eventManagementModel.getEventVanue()
				+ "\",\""+eventManagementModel.getRegdStartDate()
				+ "\",\""+eventManagementModel.getRegdEndDate()
				+ "\",\""+eventManagementModel.getOrganization()
				+ "\",\""+eventManagementModel.getOrgDivision()
				+ "\",\""+eventManagementModel.getEventCreatedBy()
				+ "\"),";
		List<RestEventActivityModel> activity = eventManagementModel.getActivity();
		List<RestEventNotificationModel> notification = eventManagementModel.getNotification();
		for(RestEventActivityModel m: activity) {
			eventActivity = eventActivity+"(@p_eventId,\""+m.getEventSlNo()
			+ "\",\""+m.getEventActivityDate()
			+ "\",\""+m.getEventAvtivityStartTime()
			+ "\",\""+m.getEventActivityEndTime()
			+ "\",\""+m.getEventActivity()
			+ "\",\""+m.getEventActivityRemark()
			+ "\"),";
		}
		for(RestEventNotificationModel m: notification) {
			eventNotification = eventNotification+"(@p_eventId,\""+m.getNotiSend()
			+ "\",\""+m.getNotiAction()
			+ "\",\""+m.getNotiInterval()
			+ "\",\""+m.getNitoUnit()
			+ "\",\""+m.getNotiRule()
			+ "\",\""+m.getNotiSent()
			+ "\"),";
		}
		
		
		
		if (eventManagement != "") {
			eventManagement = eventManagement.substring(0, eventManagement.length() - 1);
		}
		if (eventActivity != "") {
			eventActivity = eventActivity.substring(0, eventActivity.length() - 1);
		}
		if (eventNotification != "") {
			eventNotification = eventNotification.substring(0, eventNotification.length() - 1);
		}
		s = "SET " + s +"@p_eventManagement='"+eventManagement+"',"+"@p_eventActivity='"+eventActivity+"',"+"@p_eventNotification='"+eventNotification+"';";
		System.out.println("Generation Paaaa: "+s);	
		
		return s;
	}
	
	
	
	public static String modifyEvent(RestEventManagementModel eventManagementModel) {
		// TODO Auto-generated method stub
		String s = "";
		String eventid = "";
		String eventManagement = "";
		String eventActivity = "";
		String eventNotification = "";
		eventManagement = "(\""+eventManagementModel.getEventId()
		        +"\",\""+eventManagementModel.getEventName()
				+ "\",\""+eventManagementModel.getFromDate()
				+ "\",\""+eventManagementModel.getToDate()
				+ "\",\""+eventManagementModel.getEventOrganiser()
				+ "\",\""+eventManagementModel.getEventType()
				+ "\",\""+eventManagementModel.getEventResponsible()
				+ "\",\""+eventManagementModel.getEvantMaxRegd()
				+ "\",\""+eventManagementModel.getEventVanue()
				+ "\",\""+eventManagementModel.getRegdStartDate()
				+ "\",\""+eventManagementModel.getRegdEndDate()
				+ "\",\""+eventManagementModel.getOrganization()
				+ "\",\""+eventManagementModel.getOrgDivision()
				+ "\",\""+eventManagementModel.getEventCreatedBy()
				+ "\"),";
		List<RestEventActivityModel> activity = eventManagementModel.getActivity();
		List<RestEventNotificationModel> notification = eventManagementModel.getNotification();
		for(RestEventActivityModel m: activity) {
			eventActivity = eventActivity+"(@p_eventId,\""+m.getEventSlNo()
			+ "\",\""+m.getEventActivityDate()
			+ "\",\""+m.getEventAvtivityStartTime()
			+ "\",\""+m.getEventActivityEndTime()
			+ "\",\""+m.getEventActivity()
			+ "\",\""+m.getEventActivityRemark()
			+ "\"),";
		}
		for(RestEventNotificationModel m: notification) {
			eventNotification = eventNotification+"(@p_eventId,\""+m.getNotiSend()
			+ "\",\""+m.getNotiAction()
			+ "\",\""+m.getNotiInterval()
			+ "\",\""+m.getNitoUnit()
			+ "\",\""+m.getNotiRule()
			+ "\",\""+m.getNotiSent()
			+ "\"),";
		}
		
		if (eventManagement != "") {
			eventManagement = eventManagement.substring(0, eventManagement.length() - 1);
		}
		if (eventActivity != "") {
			eventActivity = eventActivity.substring(0, eventActivity.length() - 1);
		}
		if (eventNotification != "") {
			eventNotification = eventNotification.substring(0, eventNotification.length() - 1);
		}
		//s = "SET " + s +"@p_eventManagement='"+eventManagement+"',"+"@p_eId='"+eventid+"',"+"@p_eventActivity='"+eventActivity+"',"+"@p_eventNotification='"+eventNotification+"';";
		s = "SET " + s +"@p_eventManagement='"+eventManagement+"',"+"@p_eventActivity='"+eventActivity+"',"+"@p_eventNotification='"+eventNotification+"',"+"@p_eId='"+eventManagementModel.getEventId()+"';";

		System.out.println("Generation Paaaa: "+s);	
		
		return s;
	}

	// 'SET @p_empName="EMPL0002",@p_empName=EMPL0002";')
}
