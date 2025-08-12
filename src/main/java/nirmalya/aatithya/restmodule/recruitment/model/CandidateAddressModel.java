package nirmalya.aatithya.restmodule.recruitment.model;

public class CandidateAddressModel {

	private String addressId;
	private String candidateId;
	private String type;
	private String address;
	private String country;
	private String state;
	private String city;
	private String pinCode;
	private String createdBy;
	private String typeId;
	private String countryId;
	private String stateId;
	private String cityId;
	public CandidateAddressModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateAddressModel(Object addressId, Object candidateId, Object type,Object typeId, Object address, Object country,
			Object countryId, Object state,Object stateId, Object city, Object cityId, Object pinCode, Object createdBy) {
		super();
		this.candidateId = (String) candidateId;
		this.type = (String) type;
		this.address = (String) address;
		this.country = (String) country;
		this.state = (String) state;
		this.city = (String) city;
		this.pinCode = (String) pinCode;
		this.createdBy = (String) createdBy;
		this.addressId = (String) addressId;
		this.typeId = (String) typeId;
		this.countryId = (String) countryId;
		this.stateId = (String) stateId;
		this.cityId = (String) cityId;
	}
	public CandidateAddressModel(Object candidateId , Object addressId,Object type , Object address , Object country , Object state , Object city , Object pinCode) {
		// TODO Auto-generated constructor stub
		super();
		this.candidateId = (String) candidateId;
		this.addressId = (String) addressId;
		this.type = (String) type;
		this.address = (String) address;
		this.country = (String) country;
		this.state = (String) state;
		this.city = (String) city;
		this.pinCode = (String) pinCode;
	}
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
}
