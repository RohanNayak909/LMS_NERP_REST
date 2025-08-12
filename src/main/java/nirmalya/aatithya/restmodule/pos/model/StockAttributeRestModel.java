package nirmalya.aatithya.restmodule.pos.model;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StockAttributeRestModel {
	private int slNo;
	private String managerId;
	private String stockId;
	private String productId;
	private String productName;
	private String productSize;
	private String productQuantity;
	public StockAttributeRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockAttributeRestModel(Object productId, Object productName,
			Object productSize, Object productQuantity) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.productSize = (String) productSize;
		this.productQuantity = (String) productQuantity;
	}
	
	public int getSlNo() {
		return slNo;
	}
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
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
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
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

