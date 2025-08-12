package nirmalya.aatithya.restmodule.pos.model;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class POSDashboardRestModel {
	private String totalOrder;
	private String totalCustomer;
	private String totalOrderAmount;
	private String totalProduct;
	private String totalVariety;
	
	private String totalStore;
	private String totalCounter;
	private String totalSoldItem;
	
	public POSDashboardRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public POSDashboardRestModel(Object totalOrder, Object totalCustomer, Object totalOrderAmount, Object totalProduct,
			Object totalVariety) {
		super();
		this.totalOrder = (String) totalOrder;
		this.totalCustomer = (String) totalCustomer;
		this.totalOrderAmount = (String) totalOrderAmount;
		this.totalProduct = (String) totalProduct;
		this.totalVariety = (String) totalVariety;
	}
	
	
	
	public POSDashboardRestModel(Object totalOrder, Object totalCustomer, Object totalOrderAmount, Object totalProduct,
			Object totalVariety, Object totalStore, Object totalCounter, Object totalSoldItem) {
		super();
		this.totalOrder = (String) totalOrder;
		this.totalCustomer = (String) totalCustomer;
		this.totalOrderAmount = (String) totalOrderAmount;
		this.totalProduct = (String) totalProduct;
		this.totalVariety = (String) totalVariety;
		this.totalStore = (String) totalStore;
		this.totalCounter = (String) totalCounter;
		this.totalSoldItem = (String) totalSoldItem;
	}
	public String getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(String totalOrder) {
		this.totalOrder = totalOrder;
	}
	public String getTotalCustomer() {
		return totalCustomer;
	}
	public void setTotalCustomer(String totalCustomer) {
		this.totalCustomer = totalCustomer;
	}
	public String getTotalOrderAmount() {
		return totalOrderAmount;
	}
	public void setTotalOrderAmount(String totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}
	public String getTotalProduct() {
		return totalProduct;
	}
	public void setTotalProduct(String totalProduct) {
		this.totalProduct = totalProduct;
	}
	public String getTotalVariety() {
		return totalVariety;
	}
	public void setTotalVariety(String totalVariety) {
		this.totalVariety = totalVariety;
	}
	
	
	
	public String getTotalStore() {
		return totalStore;
	}
	public void setTotalStore(String totalStore) {
		this.totalStore = totalStore;
	}
	public String getTotalCounter() {
		return totalCounter;
	}
	public void setTotalCounter(String totalCounter) {
		this.totalCounter = totalCounter;
	}
	public String getTotalSoldItem() {
		return totalSoldItem;
	}
	public void setTotalSoldItem(String totalSoldItem) {
		this.totalSoldItem = totalSoldItem;
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
