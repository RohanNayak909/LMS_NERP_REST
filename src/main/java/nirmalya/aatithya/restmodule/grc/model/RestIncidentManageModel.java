package nirmalya.aatithya.restmodule.grc.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestIncidentManageModel {

	private String assignNo;
	private String incidentNo;
	private String projectId;
	private String assignToId;
	private String assignTo;
	private String task;
	private String dueDate;
	private String remarks;
	private String organization;
	private String orgDivision;
	private String createdBy;
	
	public RestIncidentManageModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAssignNo() {
		return assignNo;
	}

	public void setAssignNo(String assignNo) {
		this.assignNo = assignNo;
	}

	public String getIncidentNo() {
		return incidentNo;
	}

	public void setIncidentNo(String incidentNo) {
		this.incidentNo = incidentNo;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getAssignToId() {
		return assignToId;
	}

	public void setAssignToId(String assignToId) {
		this.assignToId = assignToId;
	}
	
	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	
	public RestIncidentManageModel(Object assignNo, Object incidentNo, Object projectId,  Object assignTo,
			 Object task, Object dueDate, Object remarks, Object organization, Object orgDivision, Object createdBy) {
			
		super();
		this.assignNo = (String) assignNo;
		this.incidentNo = (String) incidentNo;
		this.projectId = (String) projectId;
		this.assignTo = (String) assignTo;
		this.task = (String) task;
		this.dueDate = (String) dueDate;
		this.remarks = (String) remarks;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
		this.createdBy=(String) createdBy;
		
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
