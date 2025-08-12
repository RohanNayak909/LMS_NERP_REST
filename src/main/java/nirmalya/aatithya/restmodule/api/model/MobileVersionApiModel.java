package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MobileVersionApiModel {
	private String slNo;
	private String androidId;
	private String androidName;
	private String iosId;
	private String iosName;
	private String status;
	private String createdOn;
	private String updatedOn;
	
	public MobileVersionApiModel() {
		super();
	}
	public MobileVersionApiModel(Object slNo, Object androidId, Object androidName,
			Object iosId, Object iosName, Object status, Object createdOn,
			Object updatedOn) {
		super();
		this.slNo = (String) slNo;
		this.androidId = (String) androidId;
		this.androidName = (String) androidName;
		this.iosId = (String) iosId;
		this.iosName = (String) iosName;
		this.status = (String) status;
		this.createdOn = (String) createdOn;
		this.updatedOn = (String) updatedOn;
	}
	public String getSlNo() {
		return slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	public String getAndroidId() {
		return androidId;
	}

	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}

	public String getAndroidName() {
		return androidName;
	}

	public void setAndroidName(String androidName) {
		this.androidName = androidName;
	}

	public String getIosId() {
		return iosId;
	}

	public void setIosId(String iosId) {
		this.iosId = iosId;
	}

	public String getIosName() {
		return iosName;
	}

	public void setIosName(String iosName) {
		this.iosName = iosName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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
