package nirmalya.aatithya.restmodule.property.stakeholder.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestStakeholderTenantModel {

	private String tenantId;

	private String propId;
	private String name;
	private String address;
	private String mobile;
	private String email;
	private String fromDate;
	private String toDate;
	private String rentAmount;
	private String deposit;
	private String latefee;
	private String day;
	private String payment;
	private String information;
	private String createdBy;
	private String docName;
	

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public RestStakeholderTenantModel() {
		super();
	}

	public RestStakeholderTenantModel(Object tenantId, Object propId, Object name, Object address, Object mobile,
			Object email, Object toDate, Object fromDate, Object rentAmount, Object deposit, Object latefee, Object day,
			Object payment, Object information, Object createdBy) {
		this.tenantId = (String) tenantId;
		this.propId = (String) propId;
		this.name = (String) name;
		this.address = (String) address;
		this.mobile = (String) mobile;
		this.email = (String) email;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.rentAmount = (String) rentAmount;
		this.deposit = (String) deposit;
		this.latefee = (String) latefee;
		this.day = (String) day;
		this.payment = (String) payment;
		this.information = (String) information;
		this.createdBy = (String) createdBy;
	

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



	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getPropId() {
		return propId;
	}

	public void setPropId(String propId) {
		this.propId = propId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(String rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getLatefee() {
		return latefee;
	}

	public void setLatefee(String latefee) {
		this.latefee = latefee;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
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
