package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageNoticeRestModel {

	private String noticeId;
	private String currDate;
	private String employeeId;
	private String employeeName;
	private String noticeReason;
	private String empMobile;
	private String noticeType;
	private String noticeSubject;
	private String noticeDescription;
	private String department;
	private String designation;
	private String subject;
	private String absentFromDate;
	private List<NoticeDocumentUploadRestController> documentList;

	private String responseUploadDate;
	private String employeeReplydate;
	private String noticeStatus;
	private String empResponse;
	private String hRRemarks;

	private String organization;
	private String orgDivision;
	private String createdBy;
	private String publishTo;
	private String publishDate;
	private String publishBy;
	private String type;

	public ManageNoticeRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManageNoticeRestModel(Object noticeId, Object noticeDescription) {
		super();
		this.noticeId = (String) noticeId;
		this.noticeDescription = (String) noticeDescription;
	}

	public ManageNoticeRestModel(Object noticeId, Object currDate, Object employeeId, Object employeeName,
			Object noticeReason, Object empMobile, Object noticeType, Object noticeSubject, Object noticeDescription,
			Object department, Object designation, Object organization, Object createdBy) {
		super();
		this.noticeId = (String) noticeId;
		this.currDate = (String) currDate;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.noticeReason = (String) noticeReason;
		this.empMobile = (String) empMobile;
		this.noticeType = (String) noticeType;
		this.noticeSubject = (String) noticeSubject;
		this.noticeDescription = (String) noticeDescription;
		this.department = (String) department;
		this.designation = (String) designation;
		this.organization = (String) organization;
		this.createdBy = (String) createdBy;
	}

	
	
	public String getPublishTo() {
		return publishTo;
	}

	public void setPublishTo(String publishTo) {
		this.publishTo = publishTo;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublishBy() {
		return publishBy;
	}

	public void setPublishBy(String publishBy) {
		this.publishBy = publishBy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAbsentFromDate() {
		return absentFromDate;
	}

	public void setAbsentFromDate(String absentFromDate) {
		this.absentFromDate = absentFromDate;
	}

	public String getResponseUploadDate() {
		return responseUploadDate;
	}

	public void setResponseUploadDate(String responseUploadDate) {
		this.responseUploadDate = responseUploadDate;
	}

	public String getEmployeeReplydate() {
		return employeeReplydate;
	}

	public void setEmployeeReplydate(String employeeReplydate) {
		this.employeeReplydate = employeeReplydate;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public String getEmpResponse() {
		return empResponse;
	}

	public void setEmpResponse(String empResponse) {
		this.empResponse = empResponse;
	}

	public String gethRRemarks() {
		return hRRemarks;
	}

	public void sethRRemarks(String hRRemarks) {
		this.hRRemarks = hRRemarks;
	}

	public List<NoticeDocumentUploadRestController> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<NoticeDocumentUploadRestController> documentList) {
		this.documentList = documentList;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getCurrDate() {
		return currDate;
	}

	public String getNoticeReason() {
		return noticeReason;
	}

	public void setNoticeReason(String noticeReason) {
		this.noticeReason = noticeReason;
	}

	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getNoticeSubject() {
		return noticeSubject;
	}

	public void setNoticeSubject(String noticeSubject) {
		this.noticeSubject = noticeSubject;
	}

	public String getNoticeDescription() {
		return noticeDescription;
	}

	public void setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
