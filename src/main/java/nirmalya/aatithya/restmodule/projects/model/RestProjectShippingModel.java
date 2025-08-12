package nirmalya.aatithya.restmodule.projects.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestProjectShippingModel {

	private Integer slNo;
	private String shippingId;
	private String shippingName;
	private String shippingAddress;
	private String country1;
	private String stateid1;
	private String shippingCity;
	private String shippingStreet1;
	private String shippingStreet2;
	private String shippingPin;
	private String shippingEmail;
	private String shippingMobileNo;
	private String country1Name;
	private String stateid1Name;
	private String shippingGstNo;
	private String shippingContact;
	
	private String productId;
	private String productName;
	private String sku;
	private String model;
	private String unit;
	private String manufacture;
	private String brand;
	private String color;
	
	private String skus;
	private String productNames;
	private String productIds;
	
	
	
	public RestProjectShippingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestProjectShippingModel(Object shippingId, Object shippingName, Object shippingAddress, Object country1,
			Object stateid1, Object shippingCity, Object shippingStreet1, Object shippingStreet2, Object shippingPin,
			Object shippingEmail, Object shippingMobileNo,Object country1Name,Object stateid1Name
			,Object shippingContact,Object shippingGstNo) {
		super();
		this.shippingId = (String) shippingId;
		this.shippingName = (String) shippingName;
		this.shippingAddress = (String) shippingAddress;
		this.country1 = (String) country1;
		this.stateid1 = (String) stateid1;
		this.shippingCity = (String) shippingCity;
		this.shippingStreet1 = (String) shippingStreet1;
		this.shippingStreet2 = (String) shippingStreet2;
		this.shippingPin = (String) shippingPin;
		this.shippingEmail = (String) shippingEmail;
		this.shippingMobileNo = (String) shippingMobileNo;
		this.country1Name = (String) country1Name;
		this.stateid1Name = (String) stateid1Name;
		this.shippingContact = (String) shippingContact;
		this.shippingGstNo = (String) shippingGstNo;
	}
	
	
	

	public RestProjectShippingModel(Object productId, Object productName, Object sku, Object model, Object unit,
			Object manufacture, Object brand, Object color) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.sku = (String) sku;
		this.model = (String) model;
		this.unit = (String) unit;
		this.manufacture = (String) manufacture;
		this.brand = (String) brand;
		this.color = (String) color;
	}




	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCountry1() {
		return country1;
	}

	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	public String getStateid1() {
		return stateid1;
	}

	public void setStateid1(String stateid1) {
		this.stateid1 = stateid1;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingStreet1() {
		return shippingStreet1;
	}

	public void setShippingStreet1(String shippingStreet1) {
		this.shippingStreet1 = shippingStreet1;
	}

	public String getShippingStreet2() {
		return shippingStreet2;
	}

	public void setShippingStreet2(String shippingStreet2) {
		this.shippingStreet2 = shippingStreet2;
	}

	public String getShippingPin() {
		return shippingPin;
	}

	public void setShippingPin(String shippingPin) {
		this.shippingPin = shippingPin;
	}

	public String getShippingEmail() {
		return shippingEmail;
	}

	public void setShippingEmail(String shippingEmail) {
		this.shippingEmail = shippingEmail;
	}

	public String getShippingMobileNo() {
		return shippingMobileNo;
	}

	public void setShippingMobileNo(String shippingMobileNo) {
		this.shippingMobileNo = shippingMobileNo;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getCountry1Name() {
		return country1Name;
	}

	public void setCountry1Name(String country1Name) {
		this.country1Name = country1Name;
	}

	public String getStateid1Name() {
		return stateid1Name;
	}

	public void setStateid1Name(String stateid1Name) {
		this.stateid1Name = stateid1Name;
	}
	

	public String getShippingGstNo() {
		return shippingGstNo;
	}

	public void setShippingGstNo(String shippingGstNo) {
		this.shippingGstNo = shippingGstNo;
	}
	

	public String getShippingContact() {
		return shippingContact;
	}

	public void setShippingContact(String shippingContact) {
		this.shippingContact = shippingContact;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSkus() {
		return skus;
	}

	public void setSkus(String skus) {
		this.skus = skus;
	}

	public String getProductNames() {
		return productNames;
	}

	public void setProductNames(String productNames) {
		this.productNames = productNames;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
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
