package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineLogModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineSmsModel;

public class GeneratePipelineParameter {

	public static String getAddPipelineParam(RestPipelineModel form) {
		// TODO Auto-generated method stub
		String s = "";

		if (form.getPipelineId() != null && form.getPipelineId() != "") {
			s = s + "@p_pipelineId='" + form.getPipelineId() + "',";
		}

		if (form.getOppertunity() != null && form.getOppertunity() != "") {
			s = s + "@p_oppertunity='" + form.getOppertunity() + "',";
		}
		if (form.getExpectedRevenue() != null) {
			s = s + "@p_expectedRevenue=" + form.getExpectedRevenue() + ",";
		}
		if (form.getProbability() != null) {
			s = s + "@p_probability=" + form.getProbability() + ",";
		}
		if (form.getCustomer() != null && form.getCustomer() != "") {
			s = s + "@p_customer='" + form.getCustomer() + "',";
		}
		if (form.getEmail() != null && form.getEmail() != "") {
			s = s + "@p_email='" + form.getEmail() + "',";
		}
		if (form.getPhone() != null && form.getPhone() != "") {
			s = s + "@p_phone='" + form.getPhone() + "',";
		}
		if (form.getSaleperson() != null && form.getSaleperson() != "") {
			s = s + "@p_salesPerson='" + form.getSaleperson() + "',";
		}
		if (form.getSalesTeam() != null && form.getSalesTeam() != "") {
			s = s + "@p_salesTeam='" + form.getSalesTeam() + "',";
		}

		if (form.getExpectedClosing() != null && form.getExpectedClosing() != "") {
			s = s + "@p_expectedClosing='" + form.getExpectedClosing() + "',";
		}
		if (form.getPriority() != null && form.getPriority() != "") {
			s = s + "@p_priority='" + form.getPriority() + "',";
		}
		if (form.getTags() != null && form.getTags() != "") {
			s = s + "@p_tags='" + form.getTags() + "',";
		}
		if (form.getCompany() != null && form.getCompany() != "") {
			s = s + "@p_company='" + form.getCompany() + "',";
		}
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_desc='" + form.getDescription() + "',";
		}
		if (form.getCampanyName() != null && form.getCampanyName() != "") {
			s = s + "@p_contactCompanyName='" + form.getCampanyName() + "',";
		}
		if (form.getAddressStreet() != null && form.getAddressStreet() != "") {
			s = s + "@p_addressStreet='" + form.getAddressStreet() + "',";
		}
		if (form.getAddressStreet2() != null && form.getAddressStreet2() != "") {
			s = s + "@p_addressStreet2='" + form.getAddressStreet2() + "',";
		}
		if (form.getCity() != null && form.getCity() != "") {
			s = s + "@p_city='" + form.getCity() + "',";
		}
		if (form.getStates() != null && form.getStates() != "") {
			s = s + "@p_states='" + form.getStates() + "',";
		}
		if (form.getZip() != null && form.getZip() != "") {
			s = s + "@p_zip='" + form.getZip() + "',";
		}
		if (form.getCountry() != null && form.getCountry() != "") {
			s = s + "@p_country='" + form.getCountry() + "',";
		}
		if (form.getWebsite() != null && form.getWebsite() != "") {
			s = s + "@p_website='" + form.getWebsite() + "',";
		}
		if (form.getLanguage() != null && form.getLanguage() != "") {
			s = s + "@p_language='" + form.getLanguage() + "',";
		}
		if (form.getContactName() != null && form.getContactName() != "") {
			s = s + "@p_contactName='" + form.getContactName() + "',";
		}
		if (form.getTittle() != null && form.getTittle() != "") {
			s = s + "@p_tittle='" + form.getTittle() + "',";
		}
		if (form.getJobPosition() != null && form.getJobPosition() != "") {
			s = s + "@p_jobposition='" + form.getJobPosition() + "',";
		}
		if (form.getMobile() != null && form.getMobile() != "") {
			s = s + "@p_mobile='" + form.getMobile() + "',";
		}
		if (form.getReferdBy() != null && form.getReferdBy() != "") {
			s = s + "@p_referedBy='" + form.getReferdBy() + "',";
		}
		if (form.getCampaign() != null && form.getCampaign() != "") {
			s = s + "@p_Campaign='" + form.getCampaign() + "',";
		}
		if (form.getMedium() != null && form.getMedium() != "") {
			s = s + "@p_medium='" + form.getMedium() + "',";
		}
		if (form.getSource() != null && form.getSource() != "") {
			s = s + "@p_source='" + form.getSource() + "',";
		}
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
	//Genereate for Meeting part2
	
	public static String getMeetingParameters(RestPipelineModel form) {
		// TODO Auto-generated method stub
		String s = "";

		if (form.getMeetingId() != null && form.getMeetingId() != "") {
			s = s + "@p_meeting_id='" + form.getMeetingId() + "',";
		}

		if (form.getToDate() != null && form.getToDate() != "") {
			s = s + "@p_toDate='" + form.getToDate() + "',";
		}
		if (form.getFromDate() != null) {
			s = s + "@p_fromDate='" + form.getFromDate() + "',";
		}
		if (form.getTitle() != null) {
			s = s + "@p_title='" + form.getTitle() + "',";
		}
		if (form.getFromTime() != null && form.getFromTime() != "") {
			s = s + "@p_fromTime='" + form.getFromTime() + "',";
		}
		if (form.getToTime() != null && form.getToTime() != "") {
			s = s + "@p_toTime='" + form.getToTime() + "',";
		}
		if (form.getCustomerId() != null && form.getCustomerId() != "") {
			s = s + "@p_customer_id='" + form.getCustomerId() + "',";
		}
		if (form.getSummary() != null && form.getSummary() != "") {
			s = s + "@p_summary='" + form.getSummary() + "',";
		}
		if (form.getLocation() != null && form.getLocation() != "") {
			s = s + "@p_location='" + form.getLocation() + "',";
		}

		if (form.getDescriptionMeeting() != null && form.getDescriptionMeeting() != "") {
			s = s + "@p_description='" + form.getDescriptionMeeting() + "',";
		}
		if (form.getPipelineId() != null && form.getPipelineId() != "") {
			s = s + "@p_pipeline_id='" + form.getPipelineId() + "',";
		}
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String getPipelineAddActivity(List<RestPipelineActivityModel> pipelineActivityModel) {
		String s = "";
		String activityTypeId = "";
		String activityName = "";
		String summary = "";
		String duedate = "";
		String assignTo = "";
		String desc = "";
		String pipelineActivityId = "";
		String createdBy = "";
		Boolean markdoneStatus = null;

		for (RestPipelineActivityModel m : pipelineActivityModel) {

			activityTypeId = m.getActivityTypeId();
			activityName = m.getActivityType();
			summary = m.getSummary();
			duedate = m.getDuedate();
			assignTo = m.getAssignTo();
			desc = m.getActivityTypeDesc();
			pipelineActivityId = m.getActivityPipeline();
			createdBy = m.getActivityTypeCreatedBy();
			markdoneStatus = m.getActivityDoneStatus();
			if (m.getDuedate() != null && m.getDuedate() != "") {

				duedate = DateFormatter.getStringDate(m.getDuedate());
			}
		}

		s = s + "@p_activityTypeId='" + activityTypeId + "',";
		s = s + "@p_activityTypeName='" + activityName + "',";
		s = s + "@p_summary='" + summary + "',";
		if (duedate != null && duedate != "") {
			s = s + "@p_duedate='" + duedate + "',";
		}
		s = s + "@p_assignTo='" + assignTo + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_pipelineActivityId='" + pipelineActivityId + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_markdoneStatus=" + markdoneStatus + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getPipelineAddMessages(List<RestPipelineSmsModel> pipelineSmsModel) {
		String s = "";
		String smsId = "";
		String pipeline = "";
		String smsTo = "";
		String smsBody = "";
		String createdBy = "";

		for (RestPipelineSmsModel m : pipelineSmsModel) {

			smsId = m.getPipelineSmsId();
			pipeline = m.getPipeline();
			smsTo = m.getPipelineSmsTo();
			smsBody = m.getPipelineSmsBody();
			createdBy = m.getPipelinSmsCreatedBy();

		}

		s = s + "@p_smsId='" + smsId + "',";
		s = s + "@p_pipeline='" + pipeline + "',";
		s = s + "@p_smsTo='" + smsTo + "',";
		s = s + "@p_smsBody='" + smsBody + "',";
		s = s + "@p_createdBy='" + createdBy + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getPipelineAddLog(List<RestPipelineLogModel> pipelineLogModel) {
		String s = "";
		String logId = "";
		String pipeline = "";
		String logBody = "";
		String createdBy = "";

		for (RestPipelineLogModel m : pipelineLogModel) {

			logId = m.getPipelineLogId();
			pipeline = m.getPipeline();
			logBody = m.getPipelineLogBody();
			createdBy = m.getPipelineLogCreatedBy();

		}

		s = s + "@p_logId='" + logId + "',";
		s = s + "@p_pipeline='" + pipeline + "',";
		s = s + "@p_logBody='" + logBody + "',";
		s = s + "@p_createdBy='" + createdBy + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
	//generate parameter for Meeting details

	/*
	 * public static String getPipelineAddMeetingSchedule(RestPipelineModel
	 * pipeline) { String s = "";
	 * 
	 * 
	 * 
	 * String meetingId = "";
	 * 
	 * String fromTime = ""; String toTime = ""; String Summary = ""; String
	 * pipelineId = ""; String fromDate = ""; String toDate = ""; String createdBy =
	 * ""; String title = ""; String customerId = "";
	 * 
	 * String location = ""; String descriptionmeeting = "";
	 * 
	 * 
	 * 
	 * for (RestPipelineModel m : pipeline) {
	 * 
	 * 
	 * meetingId = m.getMeetingId(); toDate = m.getToDate(); title = m.getTitle();
	 * createdBy = m.getCreatedBy(); customerId = m.getCustomerId(); pipelineId
	 * =m.getPipelineId(); fromDate = m.getFromDate(); fromTime = m.getFromTime();
	 * toTime = m.getToTime(); Summary = m.getSummary(); //pipelineId =
	 * m.getPipelineId(); location = m.getLocation(); descriptionmeeting =
	 * m.getDescriptionMeeting();
	 * 
	 * 
	 * s = s + "@p_meeting_id='" + meetingId + "',"; s = s + "@p_fromTime='" +
	 * fromTime + "',"; s = s + "@p_toTime='" + toTime + "',"; s = s +
	 * "@p_summary='" + Summary + "',"; s = s + "@p_pipelineId='" + pipelineId +
	 * "',"; s = s + "@p_location='" + location + "',"; s = s + "@p_description='" +
	 * descriptionmeeting + "',"; s = s + "@p_customer_id='" + customerId + "',"; s
	 * = s + "@p_title='" + title + "',"; s = s + "@p_fromDate='" + fromDate + "',";
	 * s = s + "@p_toDate='" + toDate + "',";
	 * 
	 * 
	 * s = s + "@p_createdBy='" + createdBy + "',";
	 * 
	 * 
	 * if (s != "") { s = s.substring(0, s.length() - 1);
	 * 
	 * s = "SET " + s + ";"; }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * return s; }
	 */
}
