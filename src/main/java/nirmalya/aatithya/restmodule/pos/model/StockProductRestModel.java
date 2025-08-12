package nirmalya.aatithya.restmodule.pos.model;


import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class StockProductRestModel {
	private String productId;
	private String productName;
	private String productSize;
	private String totalQnty;
	List<StockAttributeRestModel> productDetails;
	public StockProductRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public StockProductRestModel(Object productId, Object productName,Object totalQnty) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.totalQnty = (String) totalQnty;
		
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
	public String getTotalQnty() {
		return totalQnty;
	}
	public void setTotalQnty(String totalQnty) {
		this.totalQnty = totalQnty;
	}
	
	public List<StockAttributeRestModel> getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(List<StockAttributeRestModel> productDetails) {
		this.productDetails = productDetails;
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
