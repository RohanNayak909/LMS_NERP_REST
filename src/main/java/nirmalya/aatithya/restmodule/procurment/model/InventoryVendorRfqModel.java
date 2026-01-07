package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryVendorRfqModel {
	private String vendorRfqId;
	private String rfqId;
	private String reqId;
	private String desc;
	private String reqType;
	private String reqPrior;
	private String receiveDate;

	private String sku;
	private String brand;
	private String itemName;
	private String itemId;
	private String model;
	private String itemCategoryId;
	private String itemCategoryName;
	private String uom;
	private String uomId;
	private String lastPoDate;
	private Double estimatedPrice;
	private Double estimatedTotalPrice;
	private Double qty;
	private String location;
	private String locationId;
	private String createdBy;
	private String createdOn;
	private String updatedon;
	private String updatedBy;

	private String moduleId;
	private String componentId;
	private String subComponentId;
	private String approveStatus;
	private String brandName;
	private String modelName;
	private String openDate;
	private String submittedDate;
	private String closedDate;
	private String comments;
	private String saveStatus;

	private List<InventoryVendorDocumentModel> documentList;
	private String OrganizationName;
	private String OrganizationDivision;

	public InventoryVendorRfqModel() {
		super();
	}

	public InventoryVendorRfqModel(Object vendorRfqId, Object rfqId, Object reqId, Object sku, Object brand,
			Object itemName, Object itemId, Object model, Object qty, Object estimatedPrice, Object estimatedTotalPrice,
			Object uom, Object uomId, Object location, Object locationId, Object createdBy, Object createdOn,
			Object desc, Object reqType, Object reqPrior, Object receiveDate, Object brandName, Object openDate,
			Object submittedDate, Object closedDate, Object comments ,Object saveStatus,Object organizationName, Object organizationDivision) {
		super();
		this.vendorRfqId = (String) vendorRfqId;
		this.rfqId = (String) rfqId;
		this.reqId = (String) reqId;
		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.model = (String) model;
		this.qty = (Double) qty;
		this.estimatedPrice = (Double) estimatedPrice;
		this.estimatedTotalPrice = (Double) estimatedTotalPrice;
		this.uom = (String) uom;
		this.uomId = (String) uomId;
		this.location = (String) location;
		this.locationId = (String) locationId;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.desc = (String) desc;
		this.reqType = (String) reqType;
		this.reqPrior = (String) reqPrior;
		this.receiveDate = (String) receiveDate;
		this.brandName = (String) brandName;
		this.openDate = (String) openDate;
		this.submittedDate = (String) submittedDate;
		this.closedDate = (String) closedDate;
		this.comments = (String) comments;
		this.saveStatus = (String) saveStatus;
		this.OrganizationName = (String)organizationName;
		this.OrganizationDivision = (String)organizationDivision;
	}
	

	

	public InventoryVendorRfqModel(Object rfqId, Object reqId, Object sku, Object brand, Object itemName, Object itemId,
			Object model, Object qty, Object estimatedPrice, Object estimatedTotalPrice, Object uom, Object uomId,
			Object location, Object locationId, Object createdBy, Object createdOn, Object desc, Object reqType,
			Object reqPrior, Object receiveDate, Object brandName, Object modelName) {

		super();
		this.rfqId = (String) rfqId;
		this.reqId = (String) reqId;
		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.model = (String) model;
		this.qty = (Double) qty;
		this.estimatedPrice = (Double) estimatedPrice;
		this.estimatedTotalPrice = (Double) estimatedTotalPrice;
		this.uom = (String) uom;
		this.uomId = (String) uomId;
		this.location = (String) location;
		this.locationId = (String) locationId;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.desc = (String) desc;
		this.reqType = (String) reqType;
		this.reqPrior = (String) reqPrior;
		this.receiveDate = (String) receiveDate;
		this.brandName = (String) brandName;
		this.modelName = (String) modelName;

	}

	public String getVendorRfqId() {
		return vendorRfqId;
	}

	public void setVendorRfqId(String vendorRfqId) {
		this.vendorRfqId = vendorRfqId;
	}

	public String getRfqId() {
		return rfqId;
	}

	public void setRfqId(String rfqId) {
		this.rfqId = rfqId;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getReqPrior() {
		return reqPrior;
	}

	public void setReqPrior(String reqPrior) {
		this.reqPrior = reqPrior;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(String itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getLastPoDate() {
		return lastPoDate;
	}

	public void setLastPoDate(String lastPoDate) {
		this.lastPoDate = lastPoDate;
	}

	public Double getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(Double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	public Double getEstimatedTotalPrice() {
		return estimatedTotalPrice;
	}

	public void setEstimatedTotalPrice(Double estimatedTotalPrice) {
		this.estimatedTotalPrice = estimatedTotalPrice;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
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

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getSubComponentId() {
		return subComponentId;
	}

	public void setSubComponentId(String subComponentId) {
		this.subComponentId = subComponentId;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}

	public String getSaveStatus() {
		return saveStatus;
	}

	public void setSaveStatus(String saveStatus) {
		this.saveStatus = saveStatus;
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
