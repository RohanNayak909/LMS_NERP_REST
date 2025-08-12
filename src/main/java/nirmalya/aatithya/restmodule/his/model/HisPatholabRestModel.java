package nirmalya.aatithya.restmodule.his.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class HisPatholabRestModel {
	private String bloddSampleId;
	private String orderId;
	private String testName;
	private String testId;
	private String qrCode;
	private String patientId;
	private String org;
	private String div;
	private String createdBy;
	private String createdOn;
	
	private String skuId;
	private String skuName;
	private String doctNotes;
	
	private String grpID;
	private String grpName;
	private String unitId;
	private String actualValue;
	private String range;
	private String customerId;
	
	private List<HisPatholabRestModel> bloodDataList;
	
	public String getBloddSampleId() {
		return bloddSampleId;
	}



	public void setBloddSampleId(String bloddSampleId) {
		this.bloddSampleId = bloddSampleId;
	}



	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public String getTestName() {
		return testName;
	}



	public void setTestName(String testName) {
		this.testName = testName;
	}



	public String getTestId() {
		return testId;
	}



	public void setTestId(String testId) {
		this.testId = testId;
	}



	public String getQrCode() {
		return qrCode;
	}



	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}



	public String getOrg() {
		return org;
	}



	public void setOrg(String org) {
		this.org = org;
	}



	public String getDiv() {
		return div;
	}



	public void setDiv(String div) {
		this.div = div;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}



	public List<HisPatholabRestModel> getBloodDataList() {
		return bloodDataList;
	}



	public void setBloodDataList(List<HisPatholabRestModel> bloodDataList) {
		this.bloodDataList = bloodDataList;
	}



	public String getPatientId() {
		return patientId;
	}



	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}



	public String getSkuId() {
		return skuId;
	}



	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}



	public String getSkuName() {
		return skuName;
	}



	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}



	public String getDoctNotes() {
		return doctNotes;
	}



	public void setDoctNotes(String doctNotes) {
		this.doctNotes = doctNotes;
	}



	public String getGrpID() {
		return grpID;
	}



	public void setGrpID(String grpID) {
		this.grpID = grpID;
	}



	public String getGrpName() {
		return grpName;
	}



	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}



	public String getUnitId() {
		return unitId;
	}



	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}



	public String getActualValue() {
		return actualValue;
	}



	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}



	public String getRange() {
		return range;
	}



	public void setRange(String range) {
		this.range = range;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
