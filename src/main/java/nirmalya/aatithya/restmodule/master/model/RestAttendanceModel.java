
package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAttendanceModel {
	private String employeeId;
	private String employeeName;
	private String isOut;
	private String punchinDate;
	
	private String punchinTime;
	private String punchinLocation;
	private String punchinNote;
	private String punchoutTime;
	private String punchOutLocation;
	private String punchOutNote;
	
	private String location;
	private String latitude;
	private String longitude;
	private String punchOutLatitude;
	private String punchOutLongitude;
	private String createdBy;
	private String organization;
	private String orgDivision;
	private String shift;
	private String employedBy;
	private String status;

	public RestAttendanceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestAttendanceModel(Object employeeId, Object employeeName, Object punchinDate, Object punchinTime,
			Object punchoutTime,Object shift,Object employedBy,Object status,Object location) {
		super();
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.punchinDate = (String) punchinDate;
		this.punchinTime = (String) punchinTime; 
		this.punchoutTime = (String) punchoutTime; 
		this.shift = (String) shift; 
		this.employedBy = (String) employedBy; 
		this.status = (String) status; 
		this.location = (String) location; 
	}
	public RestAttendanceModel(Object isOut, Object punchinDate, Object punchinTime, Object punchinLocation,
			Object punchinNote, Object punchoutTime, Object punchOutLocation, Object punchOutNote) {
		super();
		this.isOut = (String) isOut;
		this.punchinDate = (String) punchinDate;
		this.punchinTime = (String) punchinTime;
		this.punchinLocation = (String) punchinLocation;
		this.punchinNote = (String) punchinNote;

		this.punchoutTime = (String) punchoutTime;
		this.punchOutLocation = (String) punchOutLocation;
		this.punchOutNote = (String) punchOutNote;

	}
	public RestAttendanceModel(Object location, Object latitude, Object longitude) {
		super();
		this.location = (String) location;
		this.latitude = (String) latitude;
		this.longitude = (String) longitude;
	}
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getIsOut() {
		return isOut;
	}

	public void setIsOut(String isOut) {
		this.isOut = isOut;
	}

	public String getPunchinDate() {
		return punchinDate;
	}

	public void setPunchinDate(String punchinDate) {
		this.punchinDate = punchinDate;
	}

	public String getPunchinTime() {
		return punchinTime;
	}

	public void setPunchinTime(String punchinTime) {
		this.punchinTime = punchinTime;
	}
	public String getPunchinNote() {
		return punchinNote;
	}

	public void setPunchinNote(String punchinNote) {
		this.punchinNote = punchinNote;
	}

	public String getPunchoutTime() {
		return punchoutTime;
	}

	public void setPunchoutTime(String punchoutTime) {
		this.punchoutTime = punchoutTime;
	}

	public String getPunchOutLocation() {
		return punchOutLocation;
	}

	public void setPunchOutLocation(String punchOutLocation) {
		this.punchOutLocation = punchOutLocation;
	}

	public String getPunchOutNote() {
		return punchOutNote;
	}

	public void setPunchOutNote(String punchOutNote) {
		this.punchOutNote = punchOutNote;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPunchinLocation() {
		return punchinLocation;
	}

	public void setPunchinLocation(String punchinLocation) {
		this.punchinLocation = punchinLocation;
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
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPunchOutLatitude() {
		return punchOutLatitude;
	}
	public void setPunchOutLatitude(String punchOutLatitude) {
		this.punchOutLatitude = punchOutLatitude;
	}
	public String getPunchOutLongitude() {
		return punchOutLongitude;
	}
	public void setPunchOutLongitude(String punchOutLongitude) {
		this.punchOutLongitude = punchOutLongitude;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
	public String getEmployedBy() {
		return employedBy;
	}
	public void setEmployedBy(String employedBy) {
		this.employedBy = employedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
