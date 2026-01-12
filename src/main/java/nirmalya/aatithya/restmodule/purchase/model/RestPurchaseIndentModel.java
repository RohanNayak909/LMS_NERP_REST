package nirmalya.aatithya.restmodule.purchase.model;

import java.util.List;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class RestPurchaseIndentModel {

	private String indentId;
	private String receiveDate;
	private String deptName;
	private String deptId;
	private String desc;
	private String indentDate;
	private Integer slNo;
	private String itemName;
	private String hsnCode;
	private Double quantity;

	private String qty;

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	private Double unitPrice;
	private Double lineTotal;
	private String model;
	private String sku;
	private String itemId;
	private String unit;
	private String unitName;
	private String creditLimit;
	private String approveStatus;
	private String brandName;
	private String createdBy;
	private String updatedOn;
	private String organization;
	private String orgDivision;
	private String aprroveStatus;
	private String reqId;
	private String stock;
	private String stockForDays;
	private String current;
	private String previous;
	private String rfqStatus;
	private String project;
	private String projectName;
	private String status;
//	private String rfqStatus;
	List<InventoryVendorDocumentModel> documentList;

	public RestPurchaseIndentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestPurchaseIndentModel(Object indentId, Object deptName, Object deptId, Object receiveDate, Object desc,
			Object createdBy, Object aprroveStatus, Object updatedOn, Object current, Object previous, Object project,
			Object projectName) {
		super();

		this.indentId = (String) indentId;
		this.deptName = (String) deptName;
		this.deptId = (String) deptId;
		this.receiveDate = (String) receiveDate;
		this.desc = (String) desc;
		this.createdBy = (String) createdBy;
		this.aprroveStatus = (String) aprroveStatus;
		this.updatedOn = (String) updatedOn;
		this.current = (String) current;
		this.previous = (String) previous;
		this.project = (String) project;
		this.projectName = (String) projectName;
	}

	public RestPurchaseIndentModel(Object itemId, Object sku, Object itemName, Object hsnCode, Object quantity,
			Object indentId, Object unit, Object unitName, Object reqId, Object project,
			Object rfqStatus,Object organization ,Object orgDivision) {
		super();
		this.itemId = (String) itemId;
		this.sku = (String) sku;
		this.itemName = (String) itemName;
		this.hsnCode = (String) hsnCode;
		this.quantity = (Double) quantity;
		this.indentId = (String) indentId;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.reqId = (String) reqId;
		this.project = (String) project;
		this.rfqStatus = (String) rfqStatus;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
	}

	public RestPurchaseIndentModel(Object itemId, Object sku, Object itemName, Object hsnCode, Object quantity,
			Object indentId, Object unit, Object unitName, Object current, Object rfqStatus, Object project) {
		super();

		this.itemId = (String) itemId;
		this.sku = (String) sku;
		this.itemName = (String) itemName;
		this.hsnCode = (String) hsnCode;
		this.quantity = (Double) quantity;
		this.indentId = (String) indentId;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.current = (String) current;
		this.rfqStatus = (String) rfqStatus;
		this.project = (String) project;

	}

	public RestPurchaseIndentModel(Object reqId, Object deptName, Object deptId, Object receiveDate, Object desc,
			Object createdBy, Object aprroveStatus, Object updatedOn, Object project) {
		super();

		this.reqId = (String) reqId;
		this.deptName = (String) deptName;
		this.deptId = (String) deptId;
		this.receiveDate = (String) receiveDate;
		this.desc = (String) desc;
		this.createdBy = (String) createdBy;
		this.aprroveStatus = (String) aprroveStatus;
		this.updatedOn = (String) updatedOn;
		this.project = (String) project;

	}

	public RestPurchaseIndentModel(Object reqId, Object deptName, Object deptId, Object receiveDate, Object desc,
			Object itemId, Object sku, Object itemName, Object hsnCode, Object model, Object unit, Object unitName,
			Object quantity, Object status, Object project, Object projectName) {
		super();

		this.reqId = (String) reqId;
		this.deptName = (String) deptName;
		this.deptId = (String) deptId;
		this.receiveDate = (String) receiveDate;
		this.desc = (String) desc;
		this.itemId = (String) itemId;
		this.sku = (String) sku;
		this.itemName = (String) itemName;
		this.hsnCode = (String) hsnCode;
		this.model = (String) model;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.quantity = (Double) quantity;
		//this.updatedOn = (String) updatedOn;
		this.status = (String) status;
		this.project = (String) project;
		this.projectName = (String) projectName;
	}

	public RestPurchaseIndentModel(Object indentId, Object deptName, Object deptId, Object receiveDate, Object desc,
			Object itemId, Object sku, Object itemName, Object hsnCode, Object model, Object unit, Object unitName,
			Object quantity, Object stock, Object stockForDays, Object project, Object projectName) {
		super();

		this.indentId = (String) indentId;
		this.deptName = (String) deptName;
		this.deptId = (String) deptId;
		this.receiveDate = (String) receiveDate;
		this.desc = (String) desc;
		this.itemId = (String) itemId;
		this.sku = (String) sku;
		this.itemName = (String) itemName;
		this.hsnCode = (String) hsnCode;
		this.model = (String) model;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.quantity = (Double) quantity;
		this.stock = (String) stock;
		this.stockForDays = (String) stockForDays;
		this.project = (String) project;
		this.projectName = (String) projectName;
	}

	public String getIndentId() {
		return indentId;
	}

	public void setIndentId(String indentId) {
		this.indentId = indentId;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(String indentDate) {
		this.indentDate = indentDate;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getItemName() {
		return itemName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
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

	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}

	public String getAprroveStatus() {
		return aprroveStatus;
	}

	public void setAprroveStatus(String aprroveStatus) {
		this.aprroveStatus = aprroveStatus;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getStockForDays() {
		return stockForDays;
	}

	public void setStockForDays(String stockForDays) {
		this.stockForDays = stockForDays;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getRfqStatus() {
		return rfqStatus;
	}

	public void setRfqStatus(String rfqStatus) {
		this.rfqStatus = rfqStatus;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
