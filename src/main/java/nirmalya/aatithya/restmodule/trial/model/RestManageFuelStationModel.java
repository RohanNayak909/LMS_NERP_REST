package nirmalya.aatithya.restmodule.trial.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestManageFuelStationModel {
	private String stationId;
	private String vendorName;
	private String contactNumber;
	private String stationName;
	private String stationCode;
	private String authorizePerson;
	private String authorize;
	private String createdBy;
	private String createdOn;
	private String updatedBy;
	private String updatedOn;
	public RestManageFuelStationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestManageFuelStationModel(Object stationId, Object vendorName, Object contactNumber, Object stationName,
			Object authorizePerson, Object authorize, Object stationCode) {
		super();
		this.stationId = (String) stationId;
		this.vendorName = (String) vendorName;
		this.contactNumber = (String) contactNumber;
		this.stationName = (String) stationName;
		this.authorizePerson = (String) authorizePerson;
		this.authorize = (String) authorize;
		this.stationCode=(String) stationCode;
		
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getAuthorizePerson() {
		return authorizePerson;
	}

	public void setAuthorizePerson(String authorizePerson) {
		this.authorizePerson = authorizePerson;
	}

	public String getAuthorize() {
		return authorize;
	}

	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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