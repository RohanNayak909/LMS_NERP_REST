package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequisitionVendorModel {
	
	private String vendorId;
	private String vendorName;
	private String vendorLocation;
	private String vendorExpertise;
	private String vendorReqSent;
	private String vendorCandidates;
	private String vendorAllocationId;
	private String createdOn;
	private String createdBy;
	
	private String vendorStatus;



	public RequisitionVendorModel(Object vendorId, Object vendorName, Object vendorLocation, Object vendorExpertise,
			Object vendorReqSent, Object vendorCandidates, Object vendorAllocationId, Object createdOn,
			Object createdBy) {
		
		super();
		
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.vendorLocation = (String) vendorLocation;
		this.vendorExpertise = (String) vendorExpertise;
		this.vendorReqSent = (String) vendorReqSent;
		this.vendorCandidates = (String) vendorCandidates;
		this.vendorAllocationId = (String) vendorAllocationId;
		this.createdOn = (String) createdOn;
		this.createdBy = (String) createdBy;
	}
	
	
	
	public RequisitionVendorModel(Object vendorId, Object vendorName, Object vendorLocation, Object vendorStatus,Object vendorExpertise,
			Object vendorReqSent, Object vendorCandidates, Object vendorAllocationId, Object createdOn,
			Object createdBy) {
		
		
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.vendorLocation = (String) vendorLocation;
		this.vendorStatus = (String) vendorStatus;
		this.vendorExpertise = (String) vendorExpertise;
		this.vendorReqSent = (String) vendorReqSent;
		this.vendorCandidates = (String) vendorCandidates;
		this.vendorAllocationId = (String) vendorAllocationId;
		this.createdOn = (String) createdOn;
		this.createdBy = (String) createdBy;

	}

	


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




	public String getVendorLocation() {
		return vendorLocation;
	}




	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}




	public String getVendorExpertise() {
		return vendorExpertise;
	}




	public void setVendorExpertise(String vendorExpertise) {
		this.vendorExpertise = vendorExpertise;
	}




	public String getVendorReqSent() {
		return vendorReqSent;
	}




	public void setVendorReqSent(String vendorReqSent) {
		this.vendorReqSent = vendorReqSent;
	}




	public String getVendorCandidates() {
		return vendorCandidates;
	}




	public void setVendorCandidates(String vendorCandidates) {
		this.vendorCandidates = vendorCandidates;
	}




	public String getVendorAllocationId() {
		return vendorAllocationId;
	}




	public void setVendorAllocationId(String vendorAllocationId) {
		this.vendorAllocationId = vendorAllocationId;
	}




	public String getCreatedOn() {
		return createdOn;
	}




	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}




	public String getCreatedBy() {
		return createdBy;
	}




	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getVendorStatus() {
		return vendorStatus;
	}



	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
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
