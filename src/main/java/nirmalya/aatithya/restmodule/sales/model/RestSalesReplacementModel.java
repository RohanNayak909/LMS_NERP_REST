package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestSalesReplacementModel {
	private String saleInvoice;
	private String saleInvoiceId;
	private String replacementId;
	private String salesOrder;
	private String salesOrderId;
	private String custId;
	private String custName;
	private String replacementDate;
	private String resonForReturn;
	private String comments;
	private String qutCreatedBy;
	private String qutUpdatedOn;
	private String orgName;
	private String orgDiv;
	
	
	private String itemId;
    private String itemName;
	private Double quantity;
	private Double unitPrice;
	private Double discount;
	private Double gstRate;
	private Double lineTotal;
	private String sku;
	private Double itemCgst;
	private Double itemSgst;
	private Double subTotal;
	private Double qCGST;
	private Double qSGST;
	private Double grandTotal;
	private Double adjustment;
	private String tcsId;
	private Double tcsAmount;
	private String tcs;
	private Integer slNo;
   
	
	
	public RestSalesReplacementModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestSalesReplacementModel(Object saleInvoice, Object saleInvoiceId, Object replacementId, Object salesOrder,
			Object salesOrderId, Object custId, Object custName, Object replacementDate, Object resonForReturn,
			Object comments, Object qutCreatedBy, Object qutUpdatedOn, Object orgName, Object orgDiv) {
		super();
		this.saleInvoice = (String)saleInvoice;
		this.saleInvoiceId = (String)saleInvoiceId;
		this.replacementId = (String)replacementId;
		this.salesOrder = (String)salesOrder;
		this.salesOrderId = (String)salesOrderId;
		this.custId = (String)custId;
		this.custName = (String)custName;
		this.replacementDate = (String)replacementDate;
		this.resonForReturn = (String)resonForReturn;
		this.comments = (String)comments;
		this.qutCreatedBy = (String)qutCreatedBy;
		this.qutUpdatedOn = (String)qutUpdatedOn;
		this.orgName = (String)orgName;
		this.orgDiv = (String)orgDiv;
	}
	
	
	
	
	public RestSalesReplacementModel(Object saleInvoice, Object saleInvoiceId, Object replacementId, Object salesOrder,
			Object salesOrderId, Object custId, Object custName, Object replacementDate, Object resonForReturn,
			Object comments, Object qutCreatedBy, Object qutUpdatedOn, Object orgName, Object orgDiv, Object itemId,
			Object itemName, Object quantity, Object unitPrice, Object discount, Object gstRate, Object lineTotal,
			Object sku, Object itemCgst, Object itemSgst, Object subTotal, Object qCGST, Object qSGST,
			Object grandTotal, Object adjustment, Object tcsId, Object tcsAmount, Object tcs,Object slNo) {
		super();
		this.saleInvoice = (String)saleInvoice;
		this.saleInvoiceId = (String)saleInvoiceId;
		this.replacementId = (String)replacementId;
		this.salesOrder = (String)salesOrder;
		this.salesOrderId = (String)salesOrderId;
		this.custId = (String)custId;
		this.custName = (String)custName;
		this.replacementDate = (String)replacementDate;
		this.resonForReturn = (String)resonForReturn;
		this.comments = (String)comments;
		this.qutCreatedBy = (String)qutCreatedBy;
		this.qutUpdatedOn = (String)qutUpdatedOn;
		this.orgName = (String)orgName;
		this.orgDiv = (String)orgDiv;
		this.itemId = (String)itemId;
		this.itemName = (String)itemName;
		this.quantity = (Double)quantity;
		this.unitPrice = (Double)unitPrice;
		this.discount = (Double)discount;
		this.gstRate = (Double)gstRate;
		this.lineTotal = (Double)lineTotal;
		this.sku = (String)sku;
		this.itemCgst = (Double)itemCgst;
		this.itemSgst = (Double)itemSgst;
		this.subTotal = (Double)subTotal;
		this.qCGST = (Double)qCGST;
		this.qSGST = (Double)qSGST;
		this.grandTotal = (Double)grandTotal;
		this.adjustment = (Double)adjustment;
		this.tcsId = (String)tcsId;
		this.tcsAmount = (Double)tcsAmount;
		this.tcs = (String)tcs;
		this.slNo = (Integer)slNo;
	}
	public String getSaleInvoice() {
		return saleInvoice;
	}
	public void setSaleInvoice(String saleInvoice) {
		this.saleInvoice = saleInvoice;
	}
	public String getSaleInvoiceId() {
		return saleInvoiceId;
	}
	public void setSaleInvoiceId(String saleInvoiceId) {
		this.saleInvoiceId = saleInvoiceId;
	}
	public String getReplacementId() {
		return replacementId;
	}
	public void setReplacementId(String replacementId) {
		this.replacementId = replacementId;
	}
	public String getSalesOrder() {
		return salesOrder;
	}
	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}
	public String getSalesOrderId() {
		return salesOrderId;
	}
	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getReplacementDate() {
		return replacementDate;
	}
	public void setReplacementDate(String replacementDate) {
		this.replacementDate = replacementDate;
	}
	public String getResonForReturn() {
		return resonForReturn;
	}
	public void setResonForReturn(String resonForReturn) {
		this.resonForReturn = resonForReturn;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getQutCreatedBy() {
		return qutCreatedBy;
	}
	public void setQutCreatedBy(String qutCreatedBy) {
		this.qutCreatedBy = qutCreatedBy;
	}
	public String getQutUpdatedOn() {
		return qutUpdatedOn;
	}
	public void setQutUpdatedOn(String qutUpdatedOn) {
		this.qutUpdatedOn = qutUpdatedOn;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgDiv() {
		return orgDiv;
	}
	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getGstRate() {
		return gstRate;
	}
	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}
	public Double getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Double getItemCgst() {
		return itemCgst;
	}
	public void setItemCgst(Double itemCgst) {
		this.itemCgst = itemCgst;
	}
	public Double getItemSgst() {
		return itemSgst;
	}
	public void setItemSgst(Double itemSgst) {
		this.itemSgst = itemSgst;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getqCGST() {
		return qCGST;
	}
	public void setqCGST(Double qCGST) {
		this.qCGST = qCGST;
	}
	public Double getqSGST() {
		return qSGST;
	}
	public void setqSGST(Double qSGST) {
		this.qSGST = qSGST;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Double getAdjustment() {
		return adjustment;
	}
	public void setAdjustment(Double adjustment) {
		this.adjustment = adjustment;
	}
	public String getTcsId() {
		return tcsId;
	}
	public void setTcsId(String tcsId) {
		this.tcsId = tcsId;
	}
	public Double getTcsAmount() {
		return tcsAmount;
	}
	public void setTcsAmount(Double tcsAmount) {
		this.tcsAmount = tcsAmount;
	}
	public String getTcs() {
		return tcs;
	}
	public void setTcs(String tcs) {
		this.tcs = tcs;
	}
	
	
	public Integer getSlNo() {
		return slNo;
	}
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
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
