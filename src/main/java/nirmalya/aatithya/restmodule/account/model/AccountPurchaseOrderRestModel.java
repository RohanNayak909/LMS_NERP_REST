package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountPurchaseOrderRestModel {
	private String purchaseId;
	private String totalAmount;
	private String purchaseDate;
	private String buyerName;
	private String buyerNameId;
	private String sellerName;
	private String sellerNameId;
	private String customerType;
	
	private String subTotal;
	private String sgst;
	private String cgst;
	private String igst;
	private String grandTotal;
	
	private String voucherId;
	private String voucherDate;
	private String invoiceDate;
	private String sapId;
	private String totalQuantUnit;
	private String totalQuantKg;
	private String totalQuantCase;
	private String totalItemCount;
	
	private String vType;
	private String vClass;
	
	private String tdsValue;
	private String netReceivable;
	private String tdsRate;
	private String tcsValue;
	
	List<AccountPurchaseProductRestModel> productList;
	
	public AccountPurchaseOrderRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountPurchaseOrderRestModel(Object purchaseId, Object totalAmount, Object purchaseDate, Object buyerName,
			Object buyerNameId, Object sellerName, Object sellerNameId, Object customerType) {
		super();
		this.purchaseId = (String) purchaseId;
		this.totalAmount = (String) totalAmount;
		this.purchaseDate = (String) purchaseDate;
		this.buyerName = (String) buyerName;
		this.buyerNameId = (String) buyerNameId;
		this.sellerName = (String) sellerName;
		this.sellerNameId = (String) sellerNameId;
		this.customerType = (String) customerType;
	}
	
	
	
	
	
	public AccountPurchaseOrderRestModel(Object purchaseId, Object totalAmount, Object purchaseDate, Object buyerName,
			Object buyerNameId, Object sellerName, Object sellerNameId, Object subTotal,
			Object sgst, Object cgst, Object igst, Object grandTotal, Object customerType
			) {
		super();
		this.purchaseId = (String) purchaseId;
		this.totalAmount = (String) totalAmount;
		this.purchaseDate = (String) purchaseDate;
		this.buyerName = (String) buyerName;
		this.buyerNameId = (String) buyerNameId;
		this.sellerName = (String) sellerName;
		this.sellerNameId = (String) sellerNameId;
		this.subTotal = (String) subTotal;
		this.sgst = (String) sgst;
		this.cgst = (String) cgst;
		this.igst = (String) igst;
		this.grandTotal = (String) grandTotal;
		this.customerType = (String) customerType;
		
	}
	
	

	public AccountPurchaseOrderRestModel(Object purchaseId, Object totalAmount, Object purchaseDate, Object buyerName,
			Object buyerNameId, Object sellerName, Object sellerNameId, Object subTotal,
			Object sgst, Object cgst, Object igst, Object grandTotal, Object customerType,Object voucherId,Object voucherDate,Object invoiceDate,Object sapId
			) {
		super();
		this.purchaseId = (String) purchaseId;
		this.totalAmount = (String) totalAmount;
		this.purchaseDate = (String) purchaseDate;
		this.buyerName = (String) buyerName;
		this.buyerNameId = (String) buyerNameId;
		this.sellerName = (String) sellerName;
		this.sellerNameId = (String) sellerNameId;
		this.subTotal = (String) subTotal;
		this.sgst = (String) sgst;
		this.cgst = (String) cgst;
		this.igst = (String) igst;
		this.grandTotal = (String) grandTotal;
		this.customerType = (String) customerType;
		this.voucherId = (String)voucherId;
		this.voucherDate = (String)voucherDate;
		this.invoiceDate = (String)invoiceDate;
		this.sapId = (String)sapId;
		
	}

	public AccountPurchaseOrderRestModel(Object purchaseId, Object totalAmount, Object purchaseDate, Object buyerName,
			Object buyerNameId, Object sellerName, Object sellerNameId, Object subTotal,
			Object sgst, Object cgst, Object igst, Object grandTotal, Object customerType,Object voucherId,Object voucherDate,Object invoiceDate,Object sapId,
			Object totalQuantUnit, Object totalQuantKg, Object totalQuantCase, Object totalItemCount,Object vType,Object vClass,
			Object tdsValue,Object netReceivable,Object tdsRate ,Object tcsValue) {
		super();
		this.purchaseId = (String) purchaseId;
		this.totalAmount = (String) totalAmount;
		this.purchaseDate = (String) purchaseDate;
		this.buyerName = (String) buyerName;
		this.buyerNameId = (String) buyerNameId;
		this.sellerName = (String) sellerName;
		this.sellerNameId = (String) sellerNameId;
		this.subTotal = (String) subTotal;
		this.sgst = (String) sgst;
		this.cgst = (String) cgst;
		this.igst = (String) igst;
		this.grandTotal = (String) grandTotal;
		this.customerType = (String) customerType;
		this.voucherId = (String)voucherId;
		this.voucherDate = (String)voucherDate;
		this.invoiceDate = (String)invoiceDate;
		this.sapId = (String)sapId;
		this.totalQuantUnit = (String)totalQuantUnit;
		this.totalQuantKg = (String)totalQuantKg;
		this.totalQuantCase = (String)totalQuantCase;
		this.totalItemCount = (String)totalItemCount;
		this.vType = (String)vType;
		this.vClass = (String)vClass;
		
		this.tdsValue = (String)tdsValue;
		this.netReceivable = (String)netReceivable;
		this.tdsRate = (String)tdsRate;
		this.tcsValue = (String)tcsValue;
	}
		
	
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	
	
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerNameId() {
		return buyerNameId;
	}
	public void setBuyerNameId(String buyerNameId) {
		this.buyerNameId = buyerNameId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerNameId() {
		return sellerNameId;
	}
	public void setSellerNameId(String sellerNameId) {
		this.sellerNameId = sellerNameId;
	}
	
	public List<AccountPurchaseProductRestModel> getProductList() {
		return productList;
	}
	public void setProductList(List<AccountPurchaseProductRestModel> productList) {
		this.productList = productList;
	}
	
	public String getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	public String getSgst() {
		return sgst;
	}
	public void setSgst(String sgst) {
		this.sgst = sgst;
	}
	public String getCgst() {
		return cgst;
	}
	public void setCgst(String cgst) {
		this.cgst = cgst;
	}
	public String getIgst() {
		return igst;
	}
	public void setIgst(String igst) {
		this.igst = igst;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	public String getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}
	public String getVoucherDate() {
		return voucherDate;
	}
	public void setVoucherDate(String voucherDate) {
		this.voucherDate = voucherDate;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getSapId() {
		return sapId;
	}
	public void setSapId(String sapId) {
		this.sapId = sapId;
	}
	public String getTotalQuantUnit() {
		return totalQuantUnit;
	}
	public void setTotalQuantUnit(String totalQuantUnit) {
		this.totalQuantUnit = totalQuantUnit;
	}
	public String getTotalQuantKg() {
		return totalQuantKg;
	}
	public void setTotalQuantKg(String totalQuantKg) {
		this.totalQuantKg = totalQuantKg;
	}
	public String getTotalQuantCase() {
		return totalQuantCase;
	}
	public void setTotalQuantCase(String totalQuantCase) {
		this.totalQuantCase = totalQuantCase;
	}
	public String getTotalItemCount() {
		return totalItemCount;
	}
	public void setTotalItemCount(String totalItemCount) {
		this.totalItemCount = totalItemCount;
	}
	
	
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
	public String getvClass() {
		return vClass;
	}
	public void setvClass(String vClass) {
		this.vClass = vClass;
	}
	
	
	public String getTdsValue() {
		return tdsValue;
	}
	public void setTdsValue(String tdsValue) {
		this.tdsValue = tdsValue;
	}
	public String getNetReceivable() {
		return netReceivable;
	}
	public void setNetReceivable(String netReceivable) {
		this.netReceivable = netReceivable;
	}
	
	
	public String getTdsRate() {
		return tdsRate;
	}
	public void setTdsRate(String tdsRate) {
		this.tdsRate = tdsRate;
	}
	
	
	public String getTcsValue() {
		return tcsValue;
	}
	public void setTcsValue(String tcsValue) {
		this.tcsValue = tcsValue;
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
