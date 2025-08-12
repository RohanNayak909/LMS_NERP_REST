package nirmalya.aatithya.restmodule.serviceprovider.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestServiceProviderLedgerModel {
	private String rentId;
	private String propNo;
	private String propName;
	private String tenantName;
	private String address;
	private String osamount;
	private String month;
	private String duerent;
	private String total;
	private String amount;
	private String date;
	private String balance;
	private String createdby;
	private String createdOn;


	public RestServiceProviderLedgerModel() {
		super();
	}

	public RestServiceProviderLedgerModel(Object rentId, Object propNo, Object propName, Object tenantName,
			Object address, Object osamount, Object month, Object duerent, Object total, Object amount, Object date,
			Object balance, Object createdby, Object createdOn) {
		super();

		this.rentId = (String) rentId;
		this.propNo = (String) propNo;
		this.propName = (String) propName;
		this.tenantName = (String) tenantName;
		this.address = (String) address;
		this.osamount = (String) osamount;
		this.month = (String) month;
		this.duerent = (String) duerent;
		this.total = (String) total;
		this.amount = (String) amount;
		this.date = (String) date;
		this.balance = (String) balance;
		this.createdby = (String) createdby;
		this.createdOn = (String) createdOn;
	

	}

	public String getRentId() {
		return rentId;
	}

	public void setRentId(String rentId) {
		this.rentId = rentId;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
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
