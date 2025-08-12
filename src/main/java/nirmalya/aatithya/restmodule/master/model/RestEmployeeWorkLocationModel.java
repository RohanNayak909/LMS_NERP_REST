package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
public class RestEmployeeWorkLocationModel {
	
	
	private String organization;
	private String orgDivision;

	private String locId;
	private String empId;
	private String name;
	private String locationType;
	private String location;
	private String latitude;
	private String longitude;
	private String status;	
	private String createdBy;
	private String updatedBy;
	private String updatedOn;
	
	public RestEmployeeWorkLocationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestEmployeeWorkLocationModel(Object  locId ,Object empId, Object name, Object locationType, Object location, Object latitude,Object longitude,Object status) {
		super();
		this.locId = (String) locId;
		this.empId = (String) empId;
		this.name = (String) name;
		this.locationType = (String) locationType ;
		this.location = (String) location;
		this.latitude = (String) latitude;
		this.longitude = (String) longitude;
		this.status = (String) status;
		
	}
	
	
	
	
	public String getLocId() {
		return locId;
	}


	public void setLocId(String locId) {
		this.locId = locId;
	}


	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
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
