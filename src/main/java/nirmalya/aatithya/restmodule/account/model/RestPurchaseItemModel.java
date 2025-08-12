package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPurchaseItemModel {
	private String productId;
	private String productName;
	private String quantity;
	private String unitPrice;
	private String discount;
	private String gstRate;
	private String lineTotal;
	private String cgst;
	private String sgst;
	private String hsnCode;
	private String categoryId;
	private String categoryName;
	private String itemIgst;
	private String taxableAmt;
	private String itemCgst;
	private String itemSgst;
	
	public RestPurchaseItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestPurchaseItemModel(Object productId, Object productName, Object quantity, Object unitPrice,
			Object discount, Object gstRate, Object lineTotal, Object cgst, Object sgst, Object hsnCode,Object categoryId,Object categoryName) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.quantity = (String) quantity;
		this.unitPrice = (String) unitPrice;
		this.discount = (String) discount;
		this.gstRate = (String) gstRate;
		this.lineTotal = (String) lineTotal;
		this.cgst = (String) cgst;
		this.sgst = (String) sgst;
		this.hsnCode = (String) hsnCode;
		this.categoryId = (String) categoryId;
		this.categoryName = (String) categoryName;
	}

	public RestPurchaseItemModel(Object productId, Object productName, Object quantity, Object unitPrice,
			Object discount, Object gstRate, Object lineTotal, Object cgst, Object sgst, Object hsnCode,
			Object categoryId, Object categoryName, Object itemIgst, Object taxableAmt, Object itemCgst,
			Object itemSgst) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.quantity = (String) quantity;
		this.unitPrice = (String) unitPrice;
		this.discount = (String) discount;
		this.gstRate = (String) gstRate;
		this.lineTotal = (String) lineTotal;
		this.cgst = (String) cgst;
		this.sgst = (String) sgst;
		this.hsnCode = (String) hsnCode;
		this.categoryId = (String) categoryId;
		this.categoryName = (String) categoryName;
		this.itemIgst = (String) itemIgst;
		this.taxableAmt = (String) taxableAmt;
		this.itemCgst = (String) itemCgst;
		this.itemSgst = (String) itemSgst;
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getGstRate() {
		return gstRate;
	}
	public void setGstRate(String gstRate) {
		this.gstRate = gstRate;
	}
	public String getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(String lineTotal) {
		this.lineTotal = lineTotal;
	}
	public String getCgst() {
		return cgst;
	}
	public void setCgst(String cgst) {
		this.cgst = cgst;
	}
	public String getSgst() {
		return sgst;
	}
	public void setSgst(String sgst) {
		this.sgst = sgst;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	
	public String getItemIgst() {
		return itemIgst;
	}

	public void setItemIgst(String itemIgst) {
		this.itemIgst = itemIgst;
	}

	public String getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(String taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public String getItemCgst() {
		return itemCgst;
	}

	public void setItemCgst(String itemCgst) {
		this.itemCgst = itemCgst;
	}

	public String getItemSgst() {
		return itemSgst;
	}

	public void setItemSgst(String itemSgst) {
		this.itemSgst = itemSgst;
	}

	public String getCategoryId() {
		return categoryId;
	}





	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}





	public String getCategoryName() {
		return categoryName;
	}





	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
