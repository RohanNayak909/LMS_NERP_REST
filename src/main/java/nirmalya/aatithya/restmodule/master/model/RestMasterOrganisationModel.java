package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestMasterOrganisationModel {
	
	
	private String mainorganisationName;
	private String organisationNamediv;
	private String about;
	private String gstno;

	private String organisationId;
	private String organisationName;
	private String organisationRegNo;
	private String organisationAddress;
	private String organisationType;
	private String location;
	private String phoneNo;
	private String startDateForAttendance;
	private String logo;
	private String signature;
	private String stamp;
	private String workingDaySlNo;
	private String workingDay;
	private String workingDayType;
	private String workingHour;
	private String workingDayStatus;

	private String declareSlNo;
	private String financialYear;
	private String fromDate;
	private String toDate;
	private String declareStatus;
	
	private String organization;
	private String orgDivision;
	private String pinCode;
	private String email;
	private String country;
	private String states;
	private String street2;
	private String fax;
	private String country1;
	private String states1;
	private String city1;
	private String street11;
	private String street21;
	private String zipCode1;
	private String phone1;
	private String fax1;
	private String defaultStatus;
	private String shippingId;
	private String createdBy;
	public RestMasterOrganisationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestMasterOrganisationModel(Object organisationId, Object country1, Object states1, Object city1, Object street11,
			Object street21, Object zipCode1, Object phone1, Object fax1, Object organization, Object orgDivision,
			Object defaultStatus, Object shippingId) {
		super();
		this.organisationId = (String)organisationId;
		this.country1 = (String)country1;
		this.states1 = (String)states1;
		this.city1 = (String)city1;
		this.street11 = (String)street11;
		this.street21 = (String)street21;
		this.zipCode1 = (String)zipCode1;
		this.phone1 = (String)phone1;
		this.fax1 = (String)fax1;
		this.organization = (String)organization;
		this.orgDivision = (String)orgDivision;
		this.defaultStatus = (String)defaultStatus;
		this.shippingId = (String)shippingId;
	}
	public RestMasterOrganisationModel(Object workingDaySlNo,Object workingDay,Object workingDayType,
			Object workingHour, Object workingDayStatus) {
		super();
		this.workingDaySlNo = (String) workingDaySlNo;
		this.workingDay = (String) workingDay;
		this.workingDayType = (String) workingDayType;
		this.workingHour = (String) workingHour;
		this.workingDayStatus = (String) workingDayStatus; 
	}
	public RestMasterOrganisationModel(Object declareSlNo,Object financialYear,Object fromDate,
			Object toDate, Object declareStatus,Object organisationName,Object organisationNamediv) {
		super();
		this.declareSlNo = (String) declareSlNo;
		this.financialYear = (String) financialYear;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.declareStatus = (String) declareStatus; 
		this.organisationName = (String) organisationName; 
		this.organisationName = (String) organisationName; 
		this.organisationNamediv = (String) organisationNamediv; 
	}
	public RestMasterOrganisationModel(Object organisationId,Object organisationName,Object organisationNamediv,Object organisationRegNo, Object gstno,
			Object organisationAddress, Object organisationType, Object location,Object phoneNo,Object startDateForAttendance, Object logo, Object signature,
			Object stamp,Object about,Object pinCode,Object email,Object country,Object states,Object street2,Object fax) {
		
		super();
		
		this.organisationId = (String) organisationId;
		this.organisationName = (String) organisationName;
		this.organisationNamediv = (String) organisationNamediv;
		this.organisationRegNo = (String) organisationRegNo;
		this.gstno = (String) gstno; 
		this.organisationAddress = (String) organisationAddress;
		this.organisationType = (String) organisationType;
		this.location = (String) location; 
		this.phoneNo = (String) phoneNo; 
		this.startDateForAttendance = (String) startDateForAttendance;
		this.logo = (String) logo;
		this.signature = (String) signature;
		this.stamp = (String) stamp;
		this.about = (String) about;
		this.pinCode = (String) pinCode;
		this.email = (String) email;
		this.country = (String) country;
		this.states = (String) states;
		this.street2 = (String) street2;
		this.fax = (String) fax;
		
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
	public String getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(String organisationId) {
		this.organisationId = organisationId;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getOrganisationRegNo() {
		return organisationRegNo;
	}

	public void setOrganisationRegNo(String organisationRegNo) {
		this.organisationRegNo = organisationRegNo;
	}

	public String getOrganisationAddress() {
		return organisationAddress;
	}

	public void setOrganisationAddress(String organisationAddress) {
		this.organisationAddress = organisationAddress;
	}

	public String getOrganisationType() {
		return organisationType;
	}

	public void setOrganisationType(String organisationType) {
		this.organisationType = organisationType;
	}
 

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getStamp() {
		return stamp;
	}

	public void setStamp(String stamp) {
		this.stamp = stamp;
	}
 

	public String getStartDateForAttendance() {
		return startDateForAttendance;
	}

	public void setStartDateForAttendance(String startDateForAttendance) {
		this.startDateForAttendance = startDateForAttendance;
	}

	public String getMainorganisationName() {
		return mainorganisationName;
	}

	public void setMainorganisationName(String mainorganisationName) {
		this.mainorganisationName = mainorganisationName;
	}

	public String getOrganisationNamediv() {
		return organisationNamediv;
	}

	public void setOrganisationNamediv(String organisationNamediv) {
		this.organisationNamediv = organisationNamediv;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getGstno() {
		return gstno;
	}

	public void setGstno(String gstno) {
		this.gstno = gstno;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getWorkingDaySlNo() {
		return workingDaySlNo;
	}
	public void setWorkingDaySlNo(String workingDaySlNo) {
		this.workingDaySlNo = workingDaySlNo;
	}
	public String getWorkingDay() {
		return workingDay;
	}
	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}
	public String getWorkingDayType() {
		return workingDayType;
	}
	public void setWorkingDayType(String workingDayType) {
		this.workingDayType = workingDayType;
	}
	public String getWorkingHour() {
		return workingHour;
	}
	public void setWorkingHour(String workingHour) {
		this.workingHour = workingHour;
	}
	public String getWorkingDayStatus() {
		return workingDayStatus;
	}
	public void setWorkingDayStatus(String workingDayStatus) {
		this.workingDayStatus = workingDayStatus;
	}
	public String getDeclareSlNo() {
		return declareSlNo;
	}
	public void setDeclareSlNo(String declareSlNo) {
		this.declareSlNo = declareSlNo;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getDeclareStatus() {
		return declareStatus;
	}
	public void setDeclareStatus(String declareStatus) {
		this.declareStatus = declareStatus;
	}
	
	
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	public String getCountry1() {
		return country1;
	}
	public void setCountry1(String country1) {
		this.country1 = country1;
	}
	public String getStates1() {
		return states1;
	}
	public void setStates1(String states1) {
		this.states1 = states1;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getStreet11() {
		return street11;
	}
	public void setStreet11(String street11) {
		this.street11 = street11;
	}
	public String getStreet21() {
		return street21;
	}
	public void setStreet21(String street21) {
		this.street21 = street21;
	}
	public String getZipCode1() {
		return zipCode1;
	}
	public void setZipCode1(String zipCode1) {
		this.zipCode1 = zipCode1;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getFax1() {
		return fax1;
	}
	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}
	public String getDefaultStatus() {
		return defaultStatus;
	}
	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	
	
	
	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
