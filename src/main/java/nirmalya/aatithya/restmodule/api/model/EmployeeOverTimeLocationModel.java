package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeOverTimeLocationModel {
	private String employee;
	private String location;
	private String locationType;
	private String logitude;
	private String latitude;
	private Boolean punchInStatus;
	private Boolean punchOutStatus;
	
	public EmployeeOverTimeLocationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeOverTimeLocationModel(Object employee, Object location, Object locationType,
			Object logitude,Object latitude,Object punchInStatus,Object punchOutStatus) {
		super();
		this.employee = (String) employee;
		this.location = (String) location;
		this.locationType = (String) locationType;
		this.logitude = (String) logitude;
		this.latitude = (String) latitude;
		this.punchInStatus = (Boolean) punchInStatus;
		this.punchOutStatus = (Boolean) punchOutStatus;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getLogitude() {
		return logitude;
	}
	public void setLogitude(String logitude) {
		this.logitude = logitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Boolean getPunchInStatus() {
		return punchInStatus;
	}
	public void setPunchInStatus(Boolean punchInStatus) {
		this.punchInStatus = punchInStatus;
	}
	public Boolean getPunchOutStatus() {
		return punchOutStatus;
	}
	public void setPunchOutStatus(Boolean punchOutStatus) {
		this.punchOutStatus = punchOutStatus;
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
