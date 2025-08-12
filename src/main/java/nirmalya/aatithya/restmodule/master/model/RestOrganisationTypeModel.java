package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class RestOrganisationTypeModel {
	//// organisation type model
	private String orgId;
	private String orgName;
	private String status;

	//// organisation holiday model
	private String holidayId;
	private String holidayName;
	private String fromDate;
	private String toDate;
	private String totalHoliday;
	
	//bank model
	
	private String bankId;
	private String bankName;
	private String description;
	private Boolean bankStatus;
	private String createdBy;
	
	//announcement model
	private String announcementId;
	private String dateAnnounce;
	private String ancdtlSub;
	private String ancdtlDetails;
	private String ancdtlURL;
	private String ancdtlStatus;
	private String createdByAnnouncement;
	private String organization;
	private String orgDivision;
	//Leave policy model
	private String leavePolicyId;
	private String leaveFromDate;
	private String leaveToDate;
	private String leavePolicyDtls;
	private String leavePolicyStatus;
	private String leavePolicyCreatedBy;
	private String leavePolicyOrgName;
	private String leavePolicyorgDivision;
 
	public RestOrganisationTypeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestOrganisationTypeModel(Object orgId, Object orgName, Object status, Object holidayId, Object holidayName,
			Object fromDate, Object toDate, Object totalHoliday) {
		super();
		this.orgId = (String) orgId;
		this.orgName = (String) orgName;
		this.status = (String) status;
		
		
		this.holidayId = (String) holidayId;
		this.holidayName = (String) holidayName;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.totalHoliday = (String) totalHoliday;
	}
	public RestOrganisationTypeModel(Object holidayId, Object holidayName,
			Object fromDate, Object toDate, Object totalHoliday) {
		super();

		this.holidayId = (String) holidayId;
		this.holidayName = (String) holidayName;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.totalHoliday = (String) totalHoliday;
	}
	
	
	


	public RestOrganisationTypeModel(Object bankId, Object bankName, Object description, Object bankStatus) {
		super();
		this.bankId = (String) bankId;
		this.bankName = (String) bankName;
		this.description = (String) description;
		this.bankStatus = (Boolean) bankStatus;
	}
	
	
	public RestOrganisationTypeModel(Object announcementId,Object dateAnnounce, Object ancdtlSub, Object ancdtlDetails, Object ancdtlURL,
			Object ancdtlStatus, Object createdByAnnouncement) {
		super();
		this.announcementId =(String)announcementId;
		this.dateAnnounce = (String)dateAnnounce;
		this.ancdtlSub =(String) ancdtlSub;
		this.ancdtlDetails =(String) ancdtlDetails;
		this.ancdtlURL = (String)ancdtlURL;
		this.ancdtlStatus = (String)ancdtlStatus;
		this.createdByAnnouncement =(String) createdByAnnouncement;
		
	}
	public RestOrganisationTypeModel(Object leavePolicyId, Object leaveFromDate, Object leaveToDate, Object leavePolicyDtls,Object leavePolicyStatus,Object leavePolicyCreatedBy) 
	   {
		super();
		this.leavePolicyId =(String)leavePolicyId;
		this.leaveFromDate = (String)leaveFromDate;
		this.leaveToDate = (String)leaveToDate;
		this.leavePolicyDtls = (String)leavePolicyDtls;
		this.leavePolicyStatus = (String)leavePolicyStatus;
		this.leavePolicyCreatedBy = (String)leavePolicyCreatedBy;
	}
	
	
	

	public String getOrgId() {
		return orgId;
	}


	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
   public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getHolidayId() {
		return holidayId;
	}


	public void setHolidayId(String holidayId) {
		this.holidayId = holidayId;
	}


	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
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



	public String getTotalHoliday() {
		return totalHoliday;
	}
	public void setTotalHoliday(String totalHoliday) {
		this.totalHoliday = totalHoliday;
	}
	
	
	
	
	public String getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getBankStatus() {
		return bankStatus;
	}
	public void setBankStatus(Boolean bankStatus) {
		this.bankStatus = bankStatus;
	}
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	public String getDateAnnounce() {
		return dateAnnounce;
	}
	public void setDateAnnounce(String dateAnnounce) {
		this.dateAnnounce = dateAnnounce;
	}
	public String getAncdtlSub() {
		return ancdtlSub;
	}
	public void setAncdtlSub(String ancdtlSub) {
		this.ancdtlSub = ancdtlSub;
	}
	public String getAncdtlDetails() {
		return ancdtlDetails;
	}
	public void setAncdtlDetails(String ancdtlDetails) {
		this.ancdtlDetails = ancdtlDetails;
	}
	public String getAncdtlURL() {
		return ancdtlURL;
	}
	public void setAncdtlURL(String ancdtlURL) {
		this.ancdtlURL = ancdtlURL;
	}
	public String getAncdtlStatus() {
		return ancdtlStatus;
	}
	public void setAncdtlStatus(String ancdtlStatus) {
		this.ancdtlStatus = ancdtlStatus;
	}
	public String getCreatedByAnnouncement() {
		return createdByAnnouncement;
	}
	public void setCreatedByAnnouncement(String createdByAnnouncement) {
		this.createdByAnnouncement = createdByAnnouncement;
	}
	
	
	
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getOrgDivision() {
		return orgDivision;
	}
	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}
	public String getLeavePolicyId() {
		return leavePolicyId;
	}
	public void setLeavePolicyId(String leavePolicyId) {
		this.leavePolicyId = leavePolicyId;
	}
	public String getLeaveFromDate() {
		return leaveFromDate;
	}
	public void setLeaveFromDate(String leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}
	public String getLeaveToDate() {
		return leaveToDate;
	}
	public void setLeaveToDate(String leaveToDate) {
		this.leaveToDate = leaveToDate;
	}
	public String getLeavePolicyDtls() {
		return leavePolicyDtls;
	}
	public void setLeavePolicyDtls(String leavePolicyDtls) {
		this.leavePolicyDtls = leavePolicyDtls;
	}
	public String getLeavePolicyStatus() {
		return leavePolicyStatus;
	}
	public void setLeavePolicyStatus(String leavePolicyStatus) {
		this.leavePolicyStatus = leavePolicyStatus;
	}
	public String getLeavePolicyCreatedBy() {
		return leavePolicyCreatedBy;
	}
	public void setLeavePolicyCreatedBy(String leavePolicyCreatedBy) {
		this.leavePolicyCreatedBy = leavePolicyCreatedBy;
	}
	public String getLeavePolicyOrgName() {
		return leavePolicyOrgName;
	}
	public void setLeavePolicyOrgName(String leavePolicyOrgName) {
		this.leavePolicyOrgName = leavePolicyOrgName;
	}
	public String getLeavePolicyorgDivision() {
		return leavePolicyorgDivision;
	}
	public void setLeavePolicyorgDivision(String leavePolicyorgDivision) {
		this.leavePolicyorgDivision = leavePolicyorgDivision;
	}
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