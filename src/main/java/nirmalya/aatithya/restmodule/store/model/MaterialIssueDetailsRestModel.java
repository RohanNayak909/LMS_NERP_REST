package nirmalya.aatithya.restmodule.store.model;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MaterialIssueDetailsRestModel {
	private int slNo;
	private String slNoEdit;
	private String sku;
	private String hsnCode;
	private String itemName;
	private String itemId;
	private String model;
	private String locationId;
	private String deptName;
	private String deptId;
	private Double quantity;
	private String unitName;
	private String unit;
	private String stock;
	private String stockForDays;
	private String requestBy;
	private String remark;
	private String assignTo;

	private String project;
	private String projectName;
	private String type;
	private String issueSlip;
	private String refNo;
	private String issueSlip1;
	private String vendorId;
	private String vendorName;
	private String date;
	private String desc;
	private String reqId;
	
	private String createdBy;
	private String organization;
	private String orgDivision;
	
	List<StoreMaterialDetailsRestModel> productattribute;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIssueSlip() {
		return issueSlip;
	}

	public void setIssueSlip(String issueSlip) {
		this.issueSlip = issueSlip;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getSlNoEdit() {
		return slNoEdit;
	}

	public void setSlNoEdit(String slNoEdit) {
		this.slNoEdit = slNoEdit;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
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

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public String getIssueSlip1() {
		return issueSlip1;
	}

	public void setIssueSlip1(String issueSlip1) {
		this.issueSlip1 = issueSlip1;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public MaterialIssueDetailsRestModel() {
		super();

	}

	public List<StoreMaterialDetailsRestModel> getProductattribute() {
		return productattribute;
	}

	public void setProductattribute(List<StoreMaterialDetailsRestModel> productattribute) {
		this.productattribute = productattribute;
	}

	public MaterialIssueDetailsRestModel(Object project, Object projectName, Object type, Object issueSlip,
			Object refNo,Object issueSlip1,Object vendorId,Object vendorName,Object date) {
		super();
		this.project = (String) project;
		this.projectName = (String) projectName;
		this.type = (String) type;
		this.issueSlip = (String) issueSlip;
		this.refNo = (String) refNo;
		this.issueSlip1 = (String) issueSlip1;
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.date = (String) date;
	}

	public MaterialIssueDetailsRestModel(Object slNoEdit, Object deptName, Object deptId, Object itemId, Object sku,
			Object itemName, Object hsnCode, Object model, Object unit, Object unitName, Object quantity, Object stock,
			Object stockForDays) {
		super();

		this.slNoEdit = (String) slNoEdit;
		this.deptName = (String) deptName;
		this.deptId = (String) deptId;
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
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

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
