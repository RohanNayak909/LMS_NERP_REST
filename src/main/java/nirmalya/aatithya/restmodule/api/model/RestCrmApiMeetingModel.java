package nirmalya.aatithya.restmodule.api.model;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
public class RestCrmApiMeetingModel {
	private String meetingId;
	private String meetingTitle; 
	private String meetingLocation; 
	private String meetingFromDate;
	private String meetingFromTime;
	private String meetingHost;
	private String meetingHostName;
	private String meetingLeadContact;
	private String meetingLeadContactName; 
	private String meetingParticipants;
	private String meetingStatus; 
	private String meetingStatusName; 
	private String meetingRepeatType;
	private String meetingRepeatTypeName;
	private String meetingDesc;
	private String meetingCreatedBy;
	private String meetingCreatedOn;
	private String orgName;
	private String orgDiv;
	private String meetingLead;
	private String meetingLeadName;
	private String meetingDecisionMaker;
	private String meetingDecisionMakerName;
	
	// check in 
		private String longitude;
		private String latitude;
		private String checkDate;
		private String checkTime;
		private String ckeckAddress;
		private String ckeckDesc;
		private String meetOtherName;
		private String meetOtherMob;
		private String checkInStatus;
		private String dealStatus;
		private String checkImg;
		private MultipartFile mulFile;
		private String extension;
	public RestCrmApiMeetingModel() {
		super();
	}
	
	public RestCrmApiMeetingModel(Object meetingId, Object meetingTitle, Object meetingLocation,Object meetingFromDate ,Object meetingFromTime,
			Object meetingHost,Object meetingLeadContact,
			Object meetingLeadContactName, Object meetingParticipants, Object meetingStatus,
			Object meetingRepeatType,Object meetingDesc,Object meetingCreatedBy,
			Object meetingLead,Object meetingLeadName,Object meetingDecisionMaker,Object meetingDecisionMakerName,Object meetingHostName,
			Object checkDate,Object ckeckDesc,Object ckeckAddress,Object checkTime,Object checkInStatus,Object dealStatus) {
		super();
		this.meetingId = String.valueOf(meetingId);
		this.meetingTitle = (String)meetingTitle;
		this.meetingLocation = (String)meetingLocation;
		this.meetingFromDate= (String)meetingFromDate; 
		this.meetingFromTime = (String)meetingFromTime;
		this.meetingHost = (String)meetingHost;
		this.meetingLeadContact = (String)meetingLeadContact;
		this.meetingLeadContactName = (String)meetingLeadContactName;
		this.meetingParticipants = (String)meetingParticipants;
		this.meetingStatus = (String)meetingStatus;
		this.meetingRepeatType = (String)meetingRepeatType;
		this.meetingDesc = (String)meetingDesc;
		this.meetingCreatedBy = (String)meetingCreatedBy;
		this.meetingLead = (String)meetingLead;
		this.meetingLeadName = (String)meetingLeadName;
		this.meetingDecisionMaker = (String)meetingDecisionMaker;
		this.meetingDecisionMakerName = (String)meetingDecisionMakerName;
		this.meetingHostName = (String)meetingHostName;
		this.checkDate = (String)checkDate;
		this.ckeckDesc = (String)ckeckDesc;
		this.ckeckAddress = (String)ckeckAddress;
		this.checkTime = (String)checkTime;
		this.checkInStatus = (String)checkInStatus;
		this.dealStatus = (String)dealStatus;
	}
	
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCkeckDesc() {
		return ckeckDesc;
	}

	public void setCkeckDesc(String ckeckDesc) {
		this.ckeckDesc = ckeckDesc;
	}

	public String getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}
	public String getMeetingTitle() {
		return meetingTitle;
	}
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}
	public String getMeetingLocation() {
		return meetingLocation;
	}
	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}
	public String getMeetingFromDate() {
		return meetingFromDate;
	}
	public void setMeetingFromDate(String meetingFromDate) {
		this.meetingFromDate = meetingFromDate;
	}
	public String getMeetingFromTime() {
		return meetingFromTime;
	}
	public void setMeetingFromTime(String meetingFromTime) {
		this.meetingFromTime = meetingFromTime;
	}
	public String getMeetingHost() {
		return meetingHost;
	}
	public void setMeetingHost(String meetingHost) {
		this.meetingHost = meetingHost;
	}
	public String getMeetingHostName() {
		return meetingHostName;
	}
	public void setMeetingHostName(String meetingHostName) {
		this.meetingHostName = meetingHostName;
	}
	public String getMeetingLeadContact() {
		return meetingLeadContact;
	}
	public void setMeetingLeadContact(String meetingLeadContact) {
		this.meetingLeadContact = meetingLeadContact;
	}
	public String getMeetingLeadContactName() {
		return meetingLeadContactName;
	}
	public void setMeetingLeadContactName(String meetingLeadContactName) {
		this.meetingLeadContactName = meetingLeadContactName;
	}
	public String getMeetingParticipants() {
		return meetingParticipants;
	}
	public void setMeetingParticipants(String meetingParticipants) {
		this.meetingParticipants = meetingParticipants;
	}
	public String getMeetingStatus() {
		return meetingStatus;
	}
	public void setMeetingStatus(String meetingStatus) {
		this.meetingStatus = meetingStatus;
	}
	public String getMeetingStatusName() {
		return meetingStatusName;
	}
	public void setMeetingStatusName(String meetingStatusName) {
		this.meetingStatusName = meetingStatusName;
	}
	public String getMeetingRepeatType() {
		return meetingRepeatType;
	}
	public void setMeetingRepeatType(String meetingRepeatType) {
		this.meetingRepeatType = meetingRepeatType;
	}
	public String getMeetingRepeatTypeName() {
		return meetingRepeatTypeName;
	}
	public void setMeetingRepeatTypeName(String meetingRepeatTypeName) {
		this.meetingRepeatTypeName = meetingRepeatTypeName;
	}
	public String getMeetingDesc() {
		return meetingDesc;
	}
	public void setMeetingDesc(String meetingDesc) {
		this.meetingDesc = meetingDesc;
	}
	public String getMeetingCreatedBy() {
		return meetingCreatedBy;
	}
	public void setMeetingCreatedBy(String meetingCreatedBy) {
		this.meetingCreatedBy = meetingCreatedBy;
	}
	public String getMeetingCreatedOn() {
		return meetingCreatedOn;
	}
	public void setMeetingCreatedOn(String meetingCreatedOn) {
		this.meetingCreatedOn = meetingCreatedOn;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgDiv() {
		return orgDiv;
	}
	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
	}
	public String getMeetingLead(){
		return meetingLead;
	}
	public void setMeetingLead(String meetingLead) {
		this.meetingLead = meetingLead;
	}

	public String getMeetingLeadName() {
		return meetingLeadName;
	}

	public void setMeetingLeadName(String meetingLeadName) {
		this.meetingLeadName = meetingLeadName;
	}

	public String getMeetingDecisionMaker() {
		return meetingDecisionMaker;
	}

	public void setMeetingDecisionMaker(String meetingDecisionMaker) {
		this.meetingDecisionMaker = meetingDecisionMaker;
	}

	public String getMeetingDecisionMakerName() {
		return meetingDecisionMakerName;
	}

	public void setMeetingDecisionMakerName(String meetingDecisionMakerName) {
		this.meetingDecisionMakerName = meetingDecisionMakerName;
	}

	public String getCkeckAddress() {
		return ckeckAddress;
	}

	public void setCkeckAddress(String ckeckAddress) {
		this.ckeckAddress = ckeckAddress;
	}

	public String getMeetOtherName() {
		return meetOtherName;
	}

	public void setMeetOtherName(String meetOtherName) {
		this.meetOtherName = meetOtherName;
	}

	public String getMeetOtherMob() {
		return meetOtherMob;
	}

	public void setMeetOtherMob(String meetOtherMob) {
		this.meetOtherMob = meetOtherMob;
	}
	public String getCheckInStatus() {
		return checkInStatus;
	}

	public void setCheckInStatus(String checkInStatus) {
		this.checkInStatus = checkInStatus;
	}

	public String getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getCheckImg() {
		return checkImg;
	}

	public void setCheckImg(String checkImg) {
		this.checkImg = checkImg;
	}

	public MultipartFile getMulFile() {
		return mulFile;
	}

	public void setMulFile(MultipartFile mulFile) {
		this.mulFile = mulFile;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
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
