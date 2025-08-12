package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class RestDirecterManagerCrmModel {
	
	private String clientId;
	private String clientMob;
	private String clientEmail;
	private String clientAddress;
	private String dmId;
	private String dmName;
	private String dmEmail;
	private String dmPhone;
	private String dmDesignation;
	private String dmDob;
	private String dmMarriageDate;
	private String createdBy;
	private String createdByName;
	private String org;
	private String orgDiv;
	
	public RestDirecterManagerCrmModel() {
		super();
		
	}
	public RestDirecterManagerCrmModel(Object dmId, Object dmName, Object dmEmail, Object dmPhone,
			Object dmDesignation,Object dmDob,Object dmMarriageDate,Object createdBy,Object clientId,Object createdByName) {
		super();
		this.dmId = (String)dmId;
		this.dmName = (String)dmName;
		this.dmEmail = (String)dmEmail;
		this.dmPhone = (String)dmPhone;
		this.dmDesignation = (String)dmDesignation;
		this.dmDob = (String)dmDob;
		this.dmMarriageDate = (String)dmMarriageDate;
		this.createdBy = (String)createdBy;
		this.clientId = (String)clientId;
		this.createdByName = (String)createdByName;
	}
	public RestDirecterManagerCrmModel(Object dmId, Object dmName, Object dmEmail, Object dmPhone,
			Object dmDesignation,Object dmDob,Object dmMarriageDate,Object createdBy,Object clientId,Object createdByName,
			Object clientMob,Object clientEmail,Object clientAddress) {
		super();
		this.dmId = (String)dmId;
		this.dmName = (String)dmName;
		this.dmEmail = (String)dmEmail;
		this.dmPhone = (String)dmPhone;
		this.dmDesignation = (String)dmDesignation;
		this.dmDob = (String)dmDob;
		this.dmMarriageDate = (String)dmMarriageDate;
		this.createdBy = (String)createdBy;
		this.clientId = (String)clientId;
		this.createdByName = (String)createdByName;
		this.clientMob = (String)clientMob;
		this.clientEmail = (String)clientEmail;
		this.clientAddress = (String)clientAddress;
	}
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientMob() {
		return clientMob;
	}
	public void setClientMob(String clientMob) {
		this.clientMob = clientMob;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getDmId() {
		return dmId;
	}
	public void setDmId(String dmId) {
		this.dmId = dmId;
	}
	public String getDmName() {
		return dmName;
	}
	public void setDmName(String dmName) {
		this.dmName = dmName;
	}
	public String getDmEmail() {
		return dmEmail;
	}
	public void setDmEmail(String dmEmail) {
		this.dmEmail = dmEmail;
	}
	public String getDmPhone() {
		return dmPhone;
	}
	public void setDmPhone(String dmPhone) {
		this.dmPhone = dmPhone;
	}
	public String getDmDesignation() {
		return dmDesignation;
	}
	public void setDmDesignation(String dmDesignation) {
		this.dmDesignation = dmDesignation;
	}
	public String getDmDob() {
		return dmDob;
	}
	public void setDmDob(String dmDob) {
		this.dmDob = dmDob;
	}
	public String getDmMarriageDate() {
		return dmMarriageDate;
	}
	public void setDmMarriageDate(String dmMarriageDate) {
		this.dmMarriageDate = dmMarriageDate;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOrg() {
		return org;
	}


	public void setOrg(String org) {
		this.org = org;
	}


	public String getOrgDiv() {
		return orgDiv;
	}


	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
	}


	public String getCreatedByName() {
		return createdByName;
	}


	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
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
