package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageEmployeeBankDetailsRestModel {

	private String ebankId;
	private String employeeId;
	private String ebankName;
	private String ebankNameid;
	
	private String ebankAddress;
	private String ebankCity;
	private String ebankCityid;
	private String ebankState;
	private String ebankStateid;
	private String ebankCountry;
	private String ebankCountryid;
	private String ebankAccountNo;
	private String eIfic;
	private String createdBy;
	private String module;
	private String component;
	private String subcomponent;
	private String bankPrimaryStatus; 
	private String organization;
	private String orgDivision;
	
	private String ebankDocument;
	 
	public ManageEmployeeBankDetailsRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManageEmployeeBankDetailsRestModel(Object ebankId, Object employeeId, Object ebankName, Object ebankNameid, Object ebankAddress,
			Object ebankCity,   Object ebankCityid, Object ebankState,Object ebankStateid, Object ebankCountry,Object ebankCountryid,
			Object ebankAccountNo,Object eIfic, Object createdBy,Object bankPrimaryStatus,Object organization, Object orgDivision, Object ebankDocument) {
		super();
		this.ebankId = (String) ebankId;
		this.employeeId = (String) employeeId;
		this.ebankName = (String) ebankName;
		this.ebankNameid = (String) ebankNameid;
		this.ebankAddress = (String) ebankAddress;
		this.ebankCity = (String) ebankCity;
		this.ebankCityid = (String) ebankCityid;
		this.ebankState = (String) ebankState;
		this.ebankStateid = (String) ebankStateid;
		this.ebankCountry = (String) ebankCountry;
		this.ebankCountryid = (String) ebankCountryid;
		this.ebankAccountNo = (String) ebankAccountNo;
		this.eIfic = (String) eIfic;
		this.createdBy = (String) createdBy;
		 this.bankPrimaryStatus = (String) bankPrimaryStatus;
		 this.organization = (String)organization;
		this.orgDivision = (String)orgDivision;
		this.ebankDocument = (String) ebankDocument;
	}

  public String getEbankId() {
		return ebankId;
	}

	public void setEbankId(String ebankId) {
		this.ebankId = ebankId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEbankName() {
		return ebankName;
	}

	public void setEbankName(String ebankName) {
		this.ebankName = ebankName;
	}

	public String getEbankAddress() {
		return ebankAddress;
	}

	public void setEbankAddress(String ebankAddress) {
		this.ebankAddress = ebankAddress;
	}

	public String getEbankCity() {
		return ebankCity;
	}

	public void setEbankCity(String ebankCity) {
		this.ebankCity = ebankCity;
	}

	public String getEbankState() {
		return ebankState;
	}

	public void setEbankState(String ebankState) {
		this.ebankState = ebankState;
	}

	public String getEbankCountry() {
		return ebankCountry;
	}

	public void setEbankCountry(String ebankCountry) {
		this.ebankCountry = ebankCountry;
	}

	public String getEbankAccountNo() {
		return ebankAccountNo;
	}

	public void setEbankAccountNo(String ebankAccountNo) {
		this.ebankAccountNo = ebankAccountNo;
	}

	public String geteIfic() {
		return eIfic;
	}

	public void seteIfic(String eIfic) {
		this.eIfic = eIfic;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getSubcomponent() {
		return subcomponent;
	}

	public void setSubcomponent(String subcomponent) {
		this.subcomponent = subcomponent;
	}

	public String getBankPrimaryStatus() {
		return bankPrimaryStatus;
	}

	public void setBankPrimaryStatus(String bankPrimaryStatus) {
		this.bankPrimaryStatus = bankPrimaryStatus;
	}

	public String getEbankNameid() {
		return ebankNameid;
	}

	public void setEbankNameid(String ebankNameid) {
		this.ebankNameid = ebankNameid;
	}

	public String getEbankCityid() {
		return ebankCityid;
	}

	public void setEbankCityid(String ebankCityid) {
		this.ebankCityid = ebankCityid;
	}

	public String getEbankStateid() {
		return ebankStateid;
	}

	public void setEbankStateid(String ebankStateid) {
		this.ebankStateid = ebankStateid;
	}

	public String getEbankCountryid() {
		return ebankCountryid;
	}

	public void setEbankCountryid(String ebankCountryid) {
		this.ebankCountryid = ebankCountryid;
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

	public String getEbankDocument() {
		return ebankDocument;
	}

	public void setEbankDocument(String ebankDocument) {
		this.ebankDocument = ebankDocument;
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
