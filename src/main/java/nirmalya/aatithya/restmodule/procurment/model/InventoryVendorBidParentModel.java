package nirmalya.aatithya.restmodule.procurment.model;

import java.util.List;

public class InventoryVendorBidParentModel {
	private String rfqId;
	private String vendorId;
	private String vendorName;
	private String additionalDetails;
	private String vendorDetails;
	private String history;
	List<InventoryVendorBidModel> vendorBidDetails;

	
	public InventoryVendorBidParentModel(Object rfqId, Object vendorId, Object vendorName, Object additionalDetails,
			Object vendorDetails, Object history) {
		super();
		this.rfqId = (String) rfqId;
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.additionalDetails = (String) additionalDetails;
		this.vendorDetails = (String) vendorDetails;
		this.history = (String) history;
	}

	public String getRfqId() {
		return rfqId;
	}

	public void setRfqId(String rfqId) {
		this.rfqId = rfqId;
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

	public List<InventoryVendorBidModel> getVendorBidDetails() {
		return vendorBidDetails;
	}

	public void setVendorBidDetails(List<InventoryVendorBidModel> vendorBidDetails) {
		this.vendorBidDetails = vendorBidDetails;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	public String getVendorDetails() {
		return vendorDetails;
	}

	public void setVendorDetails(String vendorDetails) {
		this.vendorDetails = vendorDetails;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	
	
}
