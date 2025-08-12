package nirmalya.aatithya.restmodule.employee.model;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageEmployeeAddressRestModel {
	

	private String addressId;
	private String employeeId;
	private String type;
	private String typeid;
	
	private String address;
	private String city;
	private String cityid;
	private String state;
	private String stateid;
	private String country;
	private String countryid;
	private String zipCode;
	private String status;
	private String createdBy;
	private String organization;
	private String orgDivision;
	private String checkBox;
	
	public String getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}
	public ManageEmployeeAddressRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManageEmployeeAddressRestModel(Object addressId, Object employeeId, Object type, Object typeid, Object address, Object city,Object cityid,
			Object state,Object stateid, Object country, Object countryid, Object zipCode, Object status, Object createdBy , Object checkBox ) {
		super();
		this.addressId = (String)addressId;
		this.employeeId = (String)employeeId;
		this.type = (String)type;
		this.typeid = (String)typeid;
		
		this.address = (String)address;
		this.city =(String) city;
		this.cityid =(String) cityid;
		this.state = (String)state;
		this.stateid = (String)stateid;
		this.country =(String) country;
		this.countryid=(String) countryid;
		this.zipCode = (String)zipCode;
		this.status =(String) status;
		this.createdBy =(String) createdBy;
		this.checkBox =(String) checkBox;
		
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	
	
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
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
