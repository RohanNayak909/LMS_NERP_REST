package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OvertimePunchinDetaillsModel {
	private String employee;
	private String date;
	private String punchInTime;
	
	private String punchInLoc;
	private String punchInLat;
	private String punchInLong;
	
	private String punchOutTime;
	private String punchOutLoc;
	private String punchOutLat;
	
	private String punchOutLong;
	private String createdBy;
	
	private String organization;
	private String orgDivision;
	
	
	
	public OvertimePunchinDetaillsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OvertimePunchinDetaillsModel(Object employee,Object date,Object punchInTime,Object punchInLoc,
			Object punchInLat,Object punchInLong,Object punchOutTime,Object punchOutLoc,Object punchOutLat,Object punchOutLong) {
		super();
		this.employee = (String) employee;
		this.date = (String) date;
		this.punchInTime = (String) punchInTime;
		this.punchInLoc = (String) punchInLoc;
		this.punchInLat = (String) punchInLat;
		this.punchInLong = (String) punchInLong;
		this.punchOutTime = (String) punchOutTime;
		this.punchOutLoc = (String) punchOutLoc;
		this.punchOutLat = (String) punchOutLat;
		this.punchOutLong = (String) punchOutLong;
	}
	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public String getPunchInTime() {
		return punchInTime;
	}
	public void setPunchInTime(String punchInTime) {
		this.punchInTime = punchInTime;
	}
	public String getPunchInLoc() {
		return punchInLoc;
	}
	public void setPunchInLoc(String punchInLoc) {
		this.punchInLoc = punchInLoc;
	}
	public String getPunchInLat() {
		return punchInLat;
	}
	public void setPunchInLat(String punchInLat) {
		this.punchInLat = punchInLat;
	}
	public String getPunchInLong() {
		return punchInLong;
	}
	public void setPunchInLong(String punchInLong) {
		this.punchInLong = punchInLong;
	}
	public String getPunchOutTime() {
		return punchOutTime;
	}
	public void setPunchOutTime(String punchOutTime) {
		this.punchOutTime = punchOutTime;
	}
	public String getPunchOutLoc() {
		return punchOutLoc;
	}
	public void setPunchOutLoc(String punchOutLoc) {
		this.punchOutLoc = punchOutLoc;
	}
	public String getPunchOutLat() {
		return punchOutLat;
	}
	public void setPunchOutLat(String punchOutLat) {
		this.punchOutLat = punchOutLat;
	}
	public String getPunchOutLong() {
		return punchOutLong;
	}
	public void setPunchOutLong(String punchOutLong) {
		this.punchOutLong = punchOutLong;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
