package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductDetailsModel {

	private String productId;
	private String sku;
	private String model;
	private String manufacture;
	private String variationType;
	private String variationValue;
	private String unit;
	private Double salePrice;
	private Double saleTax;
	private Double saleCess;
	private String createdBy;
	private String createdDate;
	private String isEdit;
	private String vendorId;
	private Double moq;
	private String editSKUId;
	private String editVendorId;
	private String OrganizationName;
	private String OrganizationDivision;
	private String tMode;
	private String fors;
	private String taxi;
	private String dtime;
	private String qtity;
	private String dicount;
	private String variationUnit;
	private String brand;
	private String brandName;
	
	public ProductDetailsModel() {
		super();
	}
	
	public ProductDetailsModel(Object productId, Object sku, Object model, Object manufacture, Object variationType,
			Object variationValue, Object unit, Object salePrice, Object saleTax, Object saleCess, Object createdBy,
			Object createdDate, Object isEdit, Object vendorId, Object moq,Object organizationName,
			Object organizationDivision, Object tMode, Object fors, Object taxi, Object dtime,
			Object qtity, Object dicount,Object variationUnit) {
		super();
		this.productId = (String) productId;
		this.sku = (String) sku;
		this.model = (String) model;
		this.manufacture = (String) manufacture;
		this.variationType = (String) variationType;
		this.variationValue = (String) variationValue;
		this.unit = (String) unit;
		this.salePrice = (Double) salePrice;
		this.saleTax = (Double) saleTax;
		this.saleCess = (Double) saleCess;
		this.createdBy = (String) createdBy;
		this.createdDate = (String) createdDate;
		this.isEdit = (String) isEdit;
		this.vendorId = (String) vendorId;
		this.moq = (Double) moq;
		this.OrganizationName = (String)organizationName;
		this.OrganizationDivision = (String)organizationDivision;
		this.tMode = (String)tMode;
		this.fors = (String)fors;
		this.taxi = (String)taxi;
		this.dtime = (String)dtime;
		this.qtity = (String)qtity;
		this.dicount = (String)dicount;
		this.variationUnit = (String)variationUnit;
	}

	public ProductDetailsModel(Object productId, Object sku, Object model, Object manufacture, Object variationType,
			Object variationValue, Object unit, Object salePrice, Object saleTax, Object saleCess, Object createdBy,
			Object createdDate, Object isEdit, Object vendorId, Object moq,Object organizationName,
			Object organizationDivision, Object tMode, Object fors, Object taxi, Object dtime,
			Object qtity, Object dicount,Object variationUnit,Object brand,Object brandName) {
		super();
		this.productId = (String) productId;
		this.sku = (String) sku;
		this.model = (String) model;
		this.manufacture = (String) manufacture;
		this.variationType = (String) variationType;
		this.variationValue = (String) variationValue;
		this.unit = (String) unit;
		this.salePrice = (Double) salePrice;
		this.saleTax = (Double) saleTax;
		this.saleCess = (Double) saleCess;
		this.createdBy = (String) createdBy;
		this.createdDate = (String) createdDate;
		this.isEdit = (String) isEdit;
		this.vendorId = (String) vendorId;
		this.moq = (Double) moq;
		this.OrganizationName = (String)organizationName;
		this.OrganizationDivision = (String)organizationDivision;
		this.tMode = (String)tMode;
		this.fors = (String)fors;
		this.taxi = (String)taxi;
		this.dtime = (String)dtime;
		this.qtity = (String)qtity;
		this.dicount = (String)dicount;
		this.variationUnit = (String)variationUnit;
		this.brand = (String) brand;
		this.brandName = (String)brandName;
	}
	
	public String gettMode() {
		return tMode;
	}

	public void settMode(String tMode) {
		this.tMode = tMode;
	}

	public String getFors() {
		return fors;
	}

	public void setFors(String fors) {
		this.fors = fors;
	}

	public String getTaxi() {
		return taxi;
	}

	public void setTaxi(String taxi) {
		this.taxi = taxi;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

	public String getQtity() {
		return qtity;
	}

	public void setQtity(String qtity) {
		this.qtity = qtity;
	}

	public String getDicount() {
		return dicount;
	}

	public void setDicount(String dicount) {
		this.dicount = dicount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getVariationType() {
		return variationType;
	}

	public void setVariationType(String variationType) {
		this.variationType = variationType;
	}

	public String getVariationValue() {
		return variationValue;
	}

	public void setVariationValue(String variationValue) {
		this.variationValue = variationValue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getSaleTax() {
		return saleTax;
	}

	public void setSaleTax(Double saleTax) {
		this.saleTax = saleTax;
	}

	public Double getSaleCess() {
		return saleCess;
	}

	public void setSaleCess(Double saleCess) {
		this.saleCess = saleCess;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public Double getMoq() {
		return moq;
	}

	public void setMoq(Double moq) {
		this.moq = moq;
	}

	public String getEditSKUId() {
		return editSKUId;
	}

	public void setEditSKUId(String editSKUId) {
		this.editSKUId = editSKUId;
	}

	public String getEditVendorId() {
		return editVendorId;
	}

	public void setEditVendorId(String editVendorId) {
		this.editVendorId = editVendorId;
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

	public String getVariationUnit() {
		return variationUnit;
	}

	public void setVariationUnit(String variationUnit) {
		this.variationUnit = variationUnit;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
