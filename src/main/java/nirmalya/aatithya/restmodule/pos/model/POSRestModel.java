package nirmalya.aatithya.restmodule.pos.model;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class POSRestModel {
	private String productId;
	private String productName;
	private String productSize;
	private String productPrice;
	private String productGst;
	private String productDiscount;
	private String stock;
	private String productCatogary;
	private String productCategoryId;

	public POSRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public POSRestModel(Object productId, Object productSize, Object productPrice, Object productDiscount,
			Object productGst,Object stock) {
		super();
		this.productId = (String) productId;
		this.productSize = (String) productSize;
		this.productPrice = (String) productPrice;
		this.productDiscount = (String) productDiscount;
		this.productGst = (String) productGst;
		this.stock = (String) stock;
	}
	public POSRestModel(Object productId, Object productName,Object productCatogary, Object productSize,Object stock) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.productCatogary = (String) productCatogary;
		this.productSize = (String) productSize;
		this.stock = (String) stock;
		
	}
	//for sub category
	public POSRestModel(Object productCategoryId, Object productCatogary, Object stock) {
		super();
		this.productCategoryId = (String) productCategoryId;
		this.productCatogary = (String) productCatogary;
		this.stock = (String) stock;
	}
	
	//for product list
	public POSRestModel(Object productId, Object productName, Object stock, Object productCatogary) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.stock = (String) stock;
		this.productCatogary = (String) productCatogary;
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

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductGst() {
		return productGst;
	}

	public void setProductGst(String productGst) {
		this.productGst = productGst;
	}

	public String getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(String productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCatogary() {
		return productCatogary;
	}

	public void setProductCatogary(String productCatogary) {
		this.productCatogary = productCatogary;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
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
