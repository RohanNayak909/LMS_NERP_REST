package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPipelineMeetingModel {
	private String meetingId;
	

	private String pipelineId;
	private String Summary;
	private String fromDate;
	private String toDate;
	private String fromTime;
	private String toTime;
	private String title;
	private String customerId;
	

	private String location;
	private String descriptionMeeting;
	private String createdBy;


	
	public RestPipelineMeetingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getPipelineId() {
		return pipelineId;
	}


	public void setPipelineId(String pipelineId) {
		this.pipelineId = pipelineId;
	}


	public String getSummary() {
		return Summary;
	}


	public void setSummary(String summary) {
		Summary = summary;
	}


	public String getFromDate() {
		return fromDate;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	public String getToDate() {
		return toDate;
	}


	public void setToDate(String toDate) {
		this.toDate = toDate;
	}


	public String getFromTime() {
		return fromTime;
	}


	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}


	public String getToTime() {
		return toTime;
	}


	public void setToTime(String toTime) {
		this.toTime = toTime;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescriptionMeeting() {
		return descriptionMeeting;
	}


	public void setDescriptionMeeting(String descriptionMeeting) {
		this.descriptionMeeting = descriptionMeeting;
	}

	
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;

	}

}
