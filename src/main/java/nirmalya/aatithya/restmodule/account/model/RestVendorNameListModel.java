package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestVendorNameListModel {

	private String vendorId;
	private String vendorName;
	private String outstandingAmt;
	
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getOutstandingAmt() {
		return outstandingAmt;
	}
	public void setOutstandingAmt(String outstandingAmt) {
		this.outstandingAmt = outstandingAmt;
	}
	
	public RestVendorNameListModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestVendorNameListModel(Object vendorId , Object vendorName, Object outstandingAmt) {
		
		this.vendorId = (String)vendorId;
		this.vendorName = (String)vendorName;
		this.outstandingAmt = (String) outstandingAmt;
		// TODO Auto-generated constructor stub
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
