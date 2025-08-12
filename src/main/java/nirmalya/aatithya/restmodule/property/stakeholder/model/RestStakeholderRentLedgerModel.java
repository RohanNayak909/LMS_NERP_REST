package nirmalya.aatithya.restmodule.property.stakeholder.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestStakeholderRentLedgerModel {

	private String rentId;
	private String propNo;
	private String osamount;
	private String year;
	private String month;
	private String payAmount;
	private String rentOs;
	private String propName;
	private String tenantName;
	private String address;
	private String recdamount;
	private String Date;
	private String balance;
	private String status;
	private String createdby;
	private String createdOn;
	private String duerent;
	private String total;
	private String amount;


	public RestStakeholderRentLedgerModel() {
		super();
	}

	public RestStakeholderRentLedgerModel(Object rentId, Object propNo, Object osamount, Object month,
			Object year, Object payAmount,Object rentOs,Object propName,
			Object tenantName,Object address,Object recdamount,Object Date,Object balance,Object status,
			Object createdby, Object createdOn) {
		super();

		this.rentId = (String) rentId;
		this.propNo = (String) propNo;	
		this.osamount = (String) osamount;
		this.month = (String) month;
		this.year = (String) year;
		this.payAmount = (String) payAmount;
		this.rentOs = (String) rentOs;
		this.propName=(String)propName;
		this.tenantName=(String)tenantName;
		this.address=(String)address;
		this.recdamount=(String)recdamount;
		this.Date=(String)Date;
		this.balance=(String)balance;
		this.status=(String)status;
		this.createdby = (String) createdby;
		this.createdOn = (String) createdOn;
	}
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecdamount() {
		return recdamount;
	}

	public void setRecdamount(String recdamount) {
		this.recdamount = recdamount;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}


	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRentId() {
		return rentId;
	}

	public void setRentId(String rentId) {
		this.rentId = rentId;
	}

	public String getPropNo() {
		return propNo;
	}

	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}

	public String getOsamount() {
		return osamount;
	}

	public void setOsamount(String osamount) {
		this.osamount = osamount;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getRentOs() {
		return rentOs;
	}

	public void setRentOs(String rentOs) {
		this.rentOs = rentOs;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getDuerent() {
		return duerent;
	}

	public void setDuerent(String duerent) {
		this.duerent = duerent;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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
