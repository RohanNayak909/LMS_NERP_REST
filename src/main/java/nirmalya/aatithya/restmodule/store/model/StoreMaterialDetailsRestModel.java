package nirmalya.aatithya.restmodule.store.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StoreMaterialDetailsRestModel {
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
	private String issueId;

	public StoreMaterialDetailsRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreMaterialDetailsRestModel(int slNo, Object slNoEdit, Object sku, Object hsnCode, Object itemName,
			Object itemId, Object model, Object locationId, Object deptName, Object deptId, Double quantity,
			Object unitName, Object unit, Object stock, Object stockForDays) {
		super();
		this.slNo = slNo;
		this.slNoEdit = (String) slNoEdit;
		this.sku = (String) sku;
		this.hsnCode = (String) hsnCode;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.model = (String) model;
		this.locationId = (String) locationId;
		this.deptName = (String) deptName;
		this.deptId = (String) deptId;
		this.quantity = quantity;
		this.unitName = (String) unitName;
		this.unit = (String) unit;
		this.stock = (String) stock;
		this.stockForDays = (String) stockForDays;
	}

	/* edit */
	public StoreMaterialDetailsRestModel(Object issueId, Object itemId, Object sku, Object itemName, Object hsnCode,
			Object model, Object quantity, Object unit, Object unitName, Object stock, Object stockForDays,
			Object remark, Object requestBy, Object assignTo) {
		super();

		this.issueId = (String) issueId;
		this.itemId = (String) itemId;
		this.sku = (String) sku;
		this.itemName = (String) itemName;
		this.hsnCode = (String) hsnCode;
		this.model = (String) model;
		this.quantity = (Double) quantity;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.stock = (String) stock;
		this.stockForDays = (String) stockForDays;
		this.remark = (String) remark;
		this.requestBy = (String) requestBy;
		this.assignTo = (String) assignTo;
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

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
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
