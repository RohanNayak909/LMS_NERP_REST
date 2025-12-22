package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryGatePassModel {

	private String getPassEntryId;
	private String poNumber;
	private String challanNo;
	private String entrydate;
	private String entryTime;
	private String vendorName;
	private String vechileNo;
	private String driverName;
	private String driverMobile;
	private Double grossWeight;
	private String quantitybags;
	private String description;
	private String itemCategory;
	private String itemSubCategory;
	private String itemName;
	private String vendorQuantity;
	private String netQuantity;
	private Double itemWeight;
	private String createdBy;
	private String createdOn;
	private String OrganizationName;
	private String OrganizationDivision;
	private String itemCategoryName;
	private String itemSubCategoryName;
	private String getPassExitId;
	private String invoice;
	private String exitDate;
	private String exitTime;
	public InventoryGatePassModel() {
		super();
	}

	public InventoryGatePassModel(Object getPassEntryId, Object poNumber, Object challanNo, Object entrydate,
			Object entryTime, Object vendorName, Object vechileNo, Object driverName, Object driverMobile,
			Object grossWeight, Object quantitybags, Object description,  Object createdBy,
			Object createdOn, Object organizationName, Object organizationDivision) {
		super();
		this.getPassEntryId = (String) getPassEntryId;
		this.poNumber = (String) poNumber;
		this.challanNo = (String) challanNo;
		this.entrydate = (String) entrydate;
		this.entryTime = (String) entryTime;
		this.vendorName = (String) vendorName;
		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;
		this.grossWeight = (Double) grossWeight;
		this.quantitybags = (String) quantitybags;
		this.description = (String) description;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.OrganizationName = (String) organizationName;
		this.OrganizationDivision = (String) organizationDivision;
	}
	
	public InventoryGatePassModel(Object getPassExitId, Object poNumber, Object challanNo, Object entrydate,
			Object entryTime, Object vendorName, Object vechileNo) {
		super();
		this.getPassExitId = (String) getPassExitId;
		this.poNumber = (String) poNumber;
		this.challanNo = (String) challanNo;
		this.entrydate = (String) entrydate;
		this.entryTime = (String) entryTime;
		this.vendorName = (String) vendorName;
		this.vechileNo = (String) vechileNo;
		
	}
	
	public InventoryGatePassModel(Object getPassEntryId, Object poNumber, Object challanNo, Object entrydate,
			Object entryTime, Object vendorName, Object vechileNo, Object driverName, Object driverMobile,
			Object grossWeight, Object quantitybags, Object description, Object itemCategoryName, Object itemSubCategoryName,
			Object itemName, Object vendorQuantity, Object netQuantity, Object itemWeight, Object createdBy) {
		super();
		this.getPassEntryId = (String) getPassEntryId;
		this.poNumber = (String) poNumber;
		this.challanNo = (String) challanNo;
		this.entrydate = (String) entrydate;
		this.entryTime = (String) entryTime;
		this.vendorName = (String) vendorName;
		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;
		this.grossWeight = (Double) grossWeight;
		this.quantitybags = (String) quantitybags;
		this.description = (String) description;
		this.itemCategoryName = (String) itemCategoryName;
		this.itemSubCategoryName = (String) itemSubCategoryName;
		this.itemName = (String) itemName;
		this.vendorQuantity = (String) vendorQuantity;
		this.netQuantity = (String) netQuantity;
		this.itemWeight = (Double) itemWeight;
		this.createdBy = (String) createdBy;
		
	}

	public InventoryGatePassModel(Object getPassExitId, Object poNumber, Object challanNo, Object exitDate,
			Object exitTime, Object vendorName, Object vechileNo, Object driverName, Object driverMobile,
			Object grossWeight, Object quantitybags, Object description, Object itemCategoryName, Object itemSubCategoryName,
			Object itemName, Object vendorQuantity, Object netQuantity, Object itemWeight, Object invoice, Object createdBy) {
		super();
		this.getPassExitId = (String) getPassExitId;
		this.poNumber = (String) poNumber;
		this.challanNo = (String) challanNo;
		this.exitDate = (String) exitDate;
		this.exitTime = (String) exitTime;
		this.vendorName = (String) vendorName;
		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;
		this.grossWeight = (Double) grossWeight;
		this.quantitybags = (String) quantitybags;
		this.description = (String) description;
		this.itemCategoryName = (String) itemCategoryName;
		this.itemSubCategoryName = (String) itemSubCategoryName;
		this.itemName = (String) itemName;
		this.vendorQuantity = (String) vendorQuantity;
		this.netQuantity = (String) netQuantity;
		this.itemWeight = (Double) itemWeight;
		this.invoice = (String) invoice;
		this.createdBy = (String) createdBy;
		
	}
	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	public String getGetPassExitId() {
		return getPassExitId;
	}

	public void setGetPassExitId(String getPassExitId) {
		this.getPassExitId = getPassExitId;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getGetPassEntryId() {
		return getPassEntryId;
	}

	public void setGetPassEntryId(String getPassEntryId) {
		this.getPassEntryId = getPassEntryId;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVechileNo() {
		return vechileNo;
	}

	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobile() {
		return driverMobile;
	}

	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}

	public Double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getQuantitybags() {
		return quantitybags;
	}

	public void setQuantitybags(String quantitybags) {
		this.quantitybags = quantitybags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemSubCategory() {
		return itemSubCategory;
	}

	public void setItemSubCategory(String itemSubCategory) {
		this.itemSubCategory = itemSubCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getVendorQuantity() {
		return vendorQuantity;
	}

	public void setVendorQuantity(String vendorQuantity) {
		this.vendorQuantity = vendorQuantity;
	}

	public String getNetQuantity() {
		return netQuantity;
	}

	public void setNetQuantity(String netQuantity) {
		this.netQuantity = netQuantity;
	}

	public Double getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(Double itemWeight) {
		this.itemWeight = itemWeight;
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

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public String getOrganizationDivision() {
		return OrganizationDivision;
	}

	public void setOrganizationDivision(String organizationDivision) {
		OrganizationDivision = organizationDivision;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public String getItemSubCategoryName() {
		return itemSubCategoryName;
	}

	public void setItemSubCategoryName(String itemSubCategoryName) {
		this.itemSubCategoryName = itemSubCategoryName;
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
