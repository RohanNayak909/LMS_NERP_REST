package nirmalya.aatithya.restmodule.common.utils;
import nirmalya.aatithya.restmodule.api.model.RestCrmApiCallModel;
import nirmalya.aatithya.restmodule.api.model.RestCrmApiMeetingModel;
import nirmalya.aatithya.restmodule.api.model.RestCrmApiTaskModel;

public class GenerateCrmVisitApiParam {
	public static String getTaskMasterParam(RestCrmApiTaskModel restTask) {

		String s = "";


		if (restTask.getTaskId() != null &&  restTask.getTaskId() != "") {
			s = s + "@p_taskId='" + restTask.getTaskId() + "',";
		}
		if (restTask.getTaskExcutive() != null &&  restTask.getTaskExcutive() != "") {
			s = s + "@p_executive='" + restTask.getTaskExcutive() + "',";
		}
		if (restTask.getTaskLead() != null && restTask.getTaskLead() != "") {
			s = s + "@p_lead='" + restTask.getTaskLead() + "',";
		}
		if (restTask.getTaskDecisionMaker() != null && restTask.getTaskDecisionMaker() != "") {
			s = s + "@p_decisionMaker='" + restTask.getTaskDecisionMaker() + "',";
		}
		if (restTask.getTaskSubject() != null &&  restTask.getTaskSubject() != "") {
			s = s + "@p_subject='" + restTask.getTaskSubject() + "',";
		}
		if (restTask.getTaskDeliveryDate() != null &&  restTask.getTaskDeliveryDate() != "") {
			s = s + "@p_deliveryDate='" + restTask.getTaskDeliveryDate() + "',";
		}
		if (restTask.getTaskContactName() != null &&  restTask.getTaskContactName() != "") {
			s = s + "@p_contactName='" + restTask.getTaskContactName() + "',";
		}
		if (restTask.getTaskAccountName() != null &&  restTask.getTaskAccountName() != "") {
			s = s + "@p_accountName='" + restTask.getTaskAccountName() + "',";
		}
		if (restTask.getTaskStatus() != null && restTask.getTaskStatus() != "") {
			s = s + "@p_taskStatus='" + restTask.getTaskStatus() + "',";
		}

		if (restTask.getTaskPriority() != null &&  restTask.getTaskPriority() != "") {
			s = s + "@p_taskPriority='" + restTask.getTaskPriority() + "',";
		}
		if (restTask.getTaskRepeate() != null &&  restTask.getTaskRepeate() != "") {
			s = s + "@p_taskRepeate='" + restTask.getTaskRepeate() + "',";
		}
		if (restTask.getTaskReminder() != null &&  restTask.getTaskReminder() != "") {
			s = s + "@p_taskReminder='" + restTask.getTaskReminder() + "',";
		}
		if (restTask.getTaskDesc() != null &&  restTask.getTaskDesc() != "") {
			s = s + "@p_taskDesc='" + restTask.getTaskDesc() + "',";
		}
		if (restTask.getTaskCreatedBy() != null &&  restTask.getTaskCreatedBy() != "") {
			s = s + "@p_createdby='" + restTask.getTaskCreatedBy() + "',";
		}
		if (restTask.getOrgName() != null &&  restTask.getOrgName() != "") {
			s = s + "@p_org='" + restTask.getOrgName() + "',";
		}
		if (restTask.getOrgDiv() != null &&  restTask.getOrgDiv() != "") {
			s = s + "@p_div='" + restTask.getOrgDiv() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	public static String getTaskMasterCheckinParam(RestCrmApiTaskModel restTask) {
		String s = "";
		
		if (restTask.getTaskId() != null &&  restTask.getTaskId() != "") {
			s = s + "@p_taskId='" + restTask.getTaskId() + "',";
		}
 
// checkin
		
		if (restTask.getTaskLongitude() != null &&  restTask.getTaskLongitude() != "") {
			s = s + "@p_longitude='" + restTask.getTaskLongitude() + "',";
		}
		if (restTask.getTaskLatitude() != null &&  restTask.getTaskLatitude() != "") {
			s = s + "@p_latitude='" + restTask.getTaskLatitude() + "',";
		}
		if (restTask.getTaskCheckDate() != null && restTask.getTaskCheckDate() != "") {
			s = s + "@p_checkDate='" + DateFormatter.getStringDate(restTask.getTaskCheckDate()) + "',";
		}
		
		if (restTask.getTaskCheckTime() != null &&  restTask.getTaskCheckTime() != "") {
			s = s + "@p_checkTime='" + restTask.getTaskCheckTime() + "',";
		}
		
		if (restTask.getCkeckAddress() != null && restTask.getCkeckAddress() != "") {
			s = s + "@p_checkAddress=\"" + restTask.getCkeckAddress() + "\",";
		}
		if (restTask.getCkeckDesc() != null && restTask.getCkeckDesc() != "") {
			s = s + "@p_checkDesc=\"" + restTask.getCkeckDesc() + "\",";
		}
		if (restTask.getMeetOtherName() != null && restTask.getMeetOtherName() != "") {
			s = s + "@p_meetOtherName=\"" + restTask.getMeetOtherName() + "\",";
		}
		if (restTask.getMeetOtherMob() != null && restTask.getMeetOtherMob() != "") {
			s = s + "@p_meetOtherMob=\"" + restTask.getMeetOtherMob() + "\",";
		}
		if (restTask.getCheckImg() != null && restTask.getCheckImg() != "") {
			s = s + "@p_checkImg=\"" + restTask.getCheckImg() + "\",";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		return s;
		
	}
	
	public static String getMeetingMasterParam(RestCrmApiMeetingModel restMeeting) {

		String s = "";


		if (restMeeting.getMeetingId() != null &&  restMeeting.getMeetingId() != "") {
			s = s + "@p_meetingId='" + restMeeting.getMeetingId() + "',";
		}
		if (restMeeting.getMeetingTitle() != null &&  restMeeting.getMeetingTitle() != "") {
			s = s + "@p_meetingTitle='" + restMeeting.getMeetingTitle() + "',";
		}
		if (restMeeting.getMeetingLead() != null &&  restMeeting.getMeetingLead() != "") {
			s = s + "@p_lead='" + restMeeting.getMeetingLead() + "',";
		}
		if (restMeeting.getMeetingDecisionMaker() != null &&  restMeeting.getMeetingDecisionMaker() != "") {
			s = s + "@p_decisionMaker='" + restMeeting.getMeetingDecisionMaker() + "',";
		}
		if (restMeeting.getMeetingLocation() != null && restMeeting.getMeetingLocation() != "") {
			s = s + "@p_location='" + restMeeting.getMeetingLocation() + "',";
		}
		if (restMeeting.getMeetingFromDate() != null &&  restMeeting.getMeetingFromDate() != "") {
			s = s + "@p_fromDate='" + restMeeting.getMeetingFromDate() + "',";
		}
		if (restMeeting.getMeetingFromTime() != null &&  restMeeting.getMeetingFromTime() != "") {
			s = s + "@p_fromTime='" + restMeeting.getMeetingFromTime() + "',";
		}
		if (restMeeting.getMeetingHost() != null &&  restMeeting.getMeetingHost() != "") {
			s = s + "@p_host='" + restMeeting.getMeetingHost() + "',";
		}
		if (restMeeting.getMeetingLeadContact() != null &&  restMeeting.getMeetingLeadContact() != "") {
			s = s + "@p_leadContact='" + restMeeting.getMeetingLeadContact() + "',";
		}
		if (restMeeting.getMeetingParticipants() != null && restMeeting.getMeetingParticipants() != "") {
			s = s + "@p_participants='" + restMeeting.getMeetingParticipants() + "',";
		}
		if (restMeeting.getMeetingStatus() != null &&  restMeeting.getMeetingStatus() != "") {
			s = s + "@p_status='" + restMeeting.getMeetingStatus() + "',";
		}
		if (restMeeting.getMeetingRepeatType() != null &&  restMeeting.getMeetingRepeatType() != "") {
			s = s + "@p_repeate='" + restMeeting.getMeetingRepeatType() + "',";
		}
		if (restMeeting.getMeetingDesc() != null &&  restMeeting.getMeetingDesc() != "") {
			s = s + "@p_desc=\"" + restMeeting.getMeetingDesc() + "\",";
		}
		if (restMeeting.getMeetingCreatedBy() != null &&  restMeeting.getMeetingCreatedBy() != "") {
			s = s + "@p_createdBy='" + restMeeting.getMeetingCreatedBy() + "',";
		}
		if (restMeeting.getOrgName() != null &&  restMeeting.getOrgName() != "") {
			s = s + "@p_org=\"" + restMeeting.getOrgName() + "\",";
		}
		if (restMeeting.getOrgDiv() != null &&  restMeeting.getOrgDiv() != "") {
			s = s + "@p_div=\"" + restMeeting.getOrgDiv() + "\",";
		}
				

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
}	
	public static String getMeetingMasterCheckinParam(RestCrmApiMeetingModel restMeeting) {
		
		String s = "";
		
		
		if (restMeeting.getMeetingId() != null &&  restMeeting.getMeetingId() != "") {
			s = s + "@p_meetingId='" + restMeeting.getMeetingId() + "',";
		}
		
		// checkin
		
		if (restMeeting.getLongitude() != null &&  restMeeting.getLongitude() != "") {
			s = s + "@p_longitude='" + restMeeting.getLongitude() + "',";
		}
		if (restMeeting.getLatitude() != null &&  restMeeting.getLatitude() != "") {
			s = s + "@p_latitude='" + restMeeting.getLatitude() + "',";
		}
		if (restMeeting.getCheckDate() != null && restMeeting.getCheckDate() != "") {
			s = s + "@p_checkDate='" + DateFormatter.getStringDate(restMeeting.getCheckDate()) + "',";
		}
		
		if (restMeeting.getCheckTime() != null &&  restMeeting.getCheckTime() != "") {
			s = s + "@p_checkTime='" + restMeeting.getCheckTime() + "',";
		}
		if (restMeeting.getCkeckAddress() != null &&  restMeeting.getCkeckAddress() != "") {
			s = s + "@p_chechAddress=\"" + restMeeting.getCkeckAddress() + "\",";
		}
		
		if (restMeeting.getCkeckDesc() != null && restMeeting.getCkeckDesc() != "") {
			s = s + "@p_checkDesc=\"" + restMeeting.getCkeckDesc() + "\",";
		}
		if (restMeeting.getMeetOtherName() != null && restMeeting.getMeetOtherName() != "") {
		s = s + "@p_meetOtherName=\"" + restMeeting.getMeetOtherName() + "\",";
		}
		if (restMeeting.getMeetOtherMob() != null && restMeeting.getMeetOtherMob() != "") {
			s = s + "@p_meetOtherMob=\"" + restMeeting.getMeetOtherMob() + "\",";
		}
		if (restMeeting.getCheckImg() != null && restMeeting.getCheckImg() != "") {
			s = s + "@p_checkImg=\"" + restMeeting.getCheckImg() + "\",";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		return s;
	}	
		
public static String getCallMasterParam(RestCrmApiCallModel restCall) {
			String s = "";
			if (restCall.getCallId() != null &&  restCall.getCallId() != "") {
				s = s + "@p_callId='" + restCall.getCallId() + "',";
			}
			if (restCall.getCallLead() != null &&  restCall.getCallLead() != "") {
				s = s + "@p_lead='" + restCall.getCallLead() + "',";
			}
			if (restCall.getCallDecisionMaker() != null &&  restCall.getCallDecisionMaker() != "") {
				s = s + "@p_dmakaer='" + restCall.getCallDecisionMaker() + "',";
			}
			if (restCall.getCallSubject() != null && restCall.getCallSubject() != "") {
				s = s + "@p_sub=\"" + restCall.getCallSubject() + "\",";
			}
			if (restCall.getCallDate() != null &&  restCall.getCallDate() != "") {
				s = s + "@p_callDate='" +restCall.getCallDate()+ "',";
			}
			if (restCall.getCallTime() != null &&  restCall.getCallTime() != "") {
				s = s + "@p_callTime='" + restCall.getCallTime() + "',";
			}
			if (restCall.getCallStatus() != null &&  restCall.getCallStatus() != "") {
				s = s + "@p_status='" + restCall.getCallStatus() + "',";
			}
			if (restCall.getCallReminder() != null &&  restCall.getCallReminder() != "") {
				s = s + "@p_reminder='" + restCall.getCallReminder() + "',";
			}
			if (restCall.getCallDesc() != null && restCall.getCallDesc() != "") {
				s = s + "@p_callDesc=\"" + restCall.getCallDesc() + "\",";
			}
			if (restCall.getCallCreatedBy() != null &&  restCall.getCallCreatedBy() != "") {
				s = s + "@p_createdBy='" + restCall.getCallCreatedBy() + "',";
			}
			if (restCall.getOrgName() != null &&  restCall.getOrgName() != "") {
				s = s + "@p_org=\"" + restCall.getOrgName() + "\",";
			}
			if (restCall.getOrgDiv() != null &&  restCall.getOrgDiv() != "") {
				s = s + "@p_div=\"" + restCall.getOrgDiv() + "\",";
			}
			

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
			return s;

	}
public static String getCallMasterCheckinParam(RestCrmApiCallModel restCall) {
	String s = "";
	if (restCall.getCallId() != null &&  restCall.getCallId() != "") {
		s = s + "@p_callId='" + restCall.getCallId() + "',";
	}
	// checkin
	
	if (restCall.getLongitude() != null &&  restCall.getLongitude() != "") {
		s = s + "@p_longitude='" + restCall.getLongitude() + "',";
	}
	if (restCall.getLatitude() != null &&  restCall.getLatitude() != "") {
		s = s + "@p_latitude='" + restCall.getLatitude() + "',";
	}
	if (restCall.getCheckDate() != null && restCall.getCheckDate() != "") {
		s = s + "@p_checkDate='" + DateFormatter.getStringDate(restCall.getCheckDate()) + "',";
	}
	
	if (restCall.getCheckTime() != null &&  restCall.getCheckTime() != "") {
		s = s + "@p_checkTime=\"" + restCall.getCheckTime() + "\",";
	}
	if (restCall.getCkeckAddress() != null &&  restCall.getCkeckAddress() != "") {
		s = s + "@p_checkaddress=\"" + restCall.getCkeckAddress() + "\",";
	}
	
	if (restCall.getCkeckDesc() != null && restCall.getCkeckDesc() != "") {
		s = s + "@p_checkDesc=\"" + restCall.getCkeckDesc() + "\",";
	}
	if (restCall.getMeetOtherName() != null && restCall.getMeetOtherName() != "") {
	s = s + "@p_meetOtherName=\"" + restCall.getMeetOtherName() + "\",";
	}
	if (restCall.getMeetOtherMob() != null && restCall.getMeetOtherMob() != "") {
		s = s + "@p_meetOtherMob=\"" + restCall.getMeetOtherMob() + "\",";
	}
	if (restCall.getCheckImg() != null && restCall.getCheckImg() != "") {
		s = s + "@p_checkImg=\"" + restCall.getCheckImg() + "\",";
	}
	
	if (s != "") {
		s = s.substring(0, s.length() - 1);
		
		s = "SET " + s + ";";
	}
	return s;
	
}
	
}
