package nirmalya.aatithya.restmodule.pos.model;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class POSProductDetailsRestModel {
	private String orderId;
	private String productid;
	private String dimension;
	private String proDisc;
	private String productUnitPrice;
	private String productQnty;
	private String productAmnt;
	private String discountAmnt;
	public POSProductDetailsRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public POSProductDetailsRestModel(Object orderId, Object productid, Object dimension, Object proDisc,
			Object productUnitPrice, Object productQnty, Object productAmnt, Object discountAmnt) {
		super();
		this.orderId = (String) orderId;
		this.productid = (String) productid;
		this.dimension = (String) dimension;
		this.proDisc = (String) proDisc;
		this.productUnitPrice = (String) productUnitPrice;
		this.productQnty = (String) productQnty;
		this.productAmnt = (String) productAmnt;
		this.discountAmnt = (String) discountAmnt;
	}

	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getProDisc() {
		return proDisc;
	}
	public void setProDisc(String proDisc) {
		this.proDisc = proDisc;
	}
	public String getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(String productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public String getProductQnty() {
		return productQnty;
	}
	public void setProductQnty(String productQnty) {
		this.productQnty = productQnty;
	}
	public String getProductAmnt() {
		return productAmnt;
	}
	public void setProductAmnt(String productAmnt) {
		this.productAmnt = productAmnt;
	}
	public String getDiscountAmnt() {
		return discountAmnt;
	}
	public void setDiscountAmnt(String discountAmnt) {
		this.discountAmnt = discountAmnt;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
