package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventorySkuProductModel {
	private String sku;
	private String productId;
	private String productName;
	private String productNameDisp;
	private String brandId;
	private String brandName;
	private String productCatId;
	private String productCatName;
	private String hsnCode;
	private String unit;
	private Double gstRate;
	private String model;
	private String variationType;
	private String variationValue;
	private String rfqId;

	public InventorySkuProductModel() {
		super();
	}

	public InventorySkuProductModel(Object sku, Object productId, Object productName, Object brandId, Object brandName,
			Object productCatId, Object productCatName, Object hsnCode, Object unit, Object gstRate, Object model,
			Object variationType, Object variationValue,Object productNameDisp) {
		super();
		this.sku = (String) sku;
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.brandId = (String) brandId;
		this.brandName = (String) brandName;
		this.productCatId = (String) productCatId;
		this.productCatName = (String) productCatName;
		this.hsnCode = (String) hsnCode;
		this.unit = (String) unit;
		this.gstRate = (Double) gstRate;
		this.model = (String) model;
		this.variationType = (String) variationType;
		this.variationValue = (String) variationValue;
		this.productNameDisp = (String) productNameDisp;

	}

	public InventorySkuProductModel(Object rfqId) {
		super();
		this.rfqId = (String) rfqId;

	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameDisp() {
		return productNameDisp;
	}

	public void setProductNameDisp(String productNameDisp) {
		this.productNameDisp = productNameDisp;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(String productCatId) {
		this.productCatId = productCatId;
	}

	public String getProductCatName() {
		return productCatName;
	}

	public void setProductCatName(String productCatName) {
		this.productCatName = productCatName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public String getRfqId() {
		return rfqId;
	}

	public void setRfqId(String rfqId) {
		this.rfqId = rfqId;
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
