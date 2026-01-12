package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmQuoteModel {
	private String quotationId;
	private String qutName;
	private String custId;
	private String custName;
	private String custGSTNo;
	private String qutValidDate;
	private String qutDescription;
	private String qutActive;
	private String qutCreatedBy;
	private String createdOn;
	private String qutUpdatedOn;
	private String itemId;
	private String itemName;
	private Double quantity;
	private Double unitPrice;
	private Double discount;
	private Double gstRate;
	private Double lineTotal;
	private Double subTotal;
	private Double qIGST;
	private Double qCGST;
	private Double qSGST;
	private Double grandTotal;
	private String active;
	private Boolean taxType;
	private String qItmCode;
	private String sku;
	private Double itemIgst;
	private Double itemCgst;
	private Double itemSgst;
	private String poNo;
	private String poDate;
	private String filePoSale;
	private String salesOrder;
	private String sOrderDate;
	
	
	private String quoteOwner;
	private String dealId;
	private String quoteDealName;
	private String quoteSubject;
	private String quoteValidUntil;
	private String quoteStage;
	private String quoteContactName;
	private String quoteTeamName;
	private String quoteAccountName;
	private String quoteCarrier;
	private String billingStreet;
	private String shippingStreet;
	private String billingCity;
	private String shippingCity;
	private String billingCode;
	private String shippingCode;
	private String billingState;
	private String shippingState;
	private String billingCountry;
	private String shippingCountry;
	
	private String description;
	private String termCondition;
	private String quoteAccountId;
	private String quoteContactId;
	
	

	public RestCrmQuoteModel(Object quotationId, Object quoteOwner, Object quoteDealName, Object quoteSubject, Object quoteValidUntil,
			Object quoteStage, Object quoteContactId, Object quoteContactName, Object quoteTeamName, Object quoteAccountId,
			Object quoteAccountName, Object quoteCarrier, 
			Object billingStreet, Object shippingStreet, Object billingCity, Object shippingCity,
			Object billingState, Object shippingState, Object billingCode, Object shippingCode, Object billingCountry, Object shippingCountry,
			Object termCondition, Object description, Object subTotal, Object qCGST, Object qSGST, Object qIGST,
			Object grandTotal, Object taxType,
			Object itemId, Object itemName, Object quantity, Object unitPrice,
			Object discount, Object gstRate, Object lineTotal, Object qItmCode, Object sku, Object itemIgst,
			Object itemCgst, Object itemSgst, Object dealId) {
		
		super();
		this.quotationId = (String) quotationId;
		this.quoteOwner = (String) quoteOwner;
		this.quoteDealName = (String) quoteDealName;
		this.quoteSubject = (String) quoteSubject;
		this.quoteValidUntil = (String) quoteValidUntil;
		this.quoteStage = (String) quoteStage;
		this.quoteContactId = (String) quoteContactId;
		this.quoteContactName = (String) quoteContactName;
		this.quoteTeamName = (String) quoteTeamName;
		this.quoteAccountId = (String) quoteAccountId;
		this.quoteAccountName = (String) quoteAccountName;
		this.quoteCarrier = (String) quoteCarrier;
		this.billingStreet = (String) billingStreet;
		this.shippingStreet = (String) shippingStreet;
		this.billingCity = (String) billingCity;
		this.shippingCity = (String) shippingCity;
		this.billingState = (String) billingState;
		this.shippingState = (String) shippingState;
		this.billingCode = (String) billingCode;
		this.shippingCode = (String) shippingCode;	
		this.billingCountry = (String) billingCountry;
		this.shippingCountry = (String) shippingCountry;
		this.termCondition = (String) termCondition;
		this.description = (String) description;
		this.subTotal = (Double) subTotal;
		this.qCGST = (Double) qCGST;
		this.qSGST = (Double) qSGST;
		this.qIGST = (Double) qIGST;
		this.grandTotal = (Double) grandTotal;
		this.taxType = (Boolean) taxType;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.quantity = (Double) quantity;
		this.unitPrice = (Double) unitPrice;
		this.discount = (Double) discount;
		this.gstRate = (Double) gstRate;
		this.lineTotal = (Double) lineTotal;
		this.qItmCode = (String) qItmCode;
		this.sku = (String) sku;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;
		this.dealId = (String) dealId;
		

	}
	
	
	public RestCrmQuoteModel(Object quotationId,  Object quoteSubject, Object subTotal, Object quoteDealName, Object quoteContactName, 
			Object quoteAccountName, Object quoteOwner,  Object createdOn) {
		
		super();
		this.quotationId = (String) quotationId;
		this.quoteSubject = (String) quoteSubject;
		this.subTotal = (Double) subTotal;
		this.quoteDealName = (String) quoteDealName;
		this.quoteContactName = (String) quoteContactName;
		this.quoteAccountName = (String) quoteAccountName;
		this.quoteOwner = (String) quoteOwner;
		this.createdOn = (String) createdOn;

	}
	
	public RestCrmQuoteModel(Object itemId,  Object itemName, Object gstRate, Object sku) {
		
		super();
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.gstRate = (Double) gstRate;
		this.sku = (String) sku;

	}
	
	

	public String getDealId() {
		return dealId;
	}


	public void setDealId(String dealId) {
		this.dealId = dealId;
	}


	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	public String getsOrderDate() {
		return sOrderDate;
	}

	public void setsOrderDate(String sOrderDate) {
		this.sOrderDate = sOrderDate;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public String getFilePoSale() {
		return filePoSale;
	}

	public void setFilePoSale(String filePoSale) {
		this.filePoSale = filePoSale;
	}

	public Double getItemIgst() {
		return itemIgst;
	}

	public void setItemIgst(Double itemIgst) {
		this.itemIgst = itemIgst;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getqItmCode() {
		return qItmCode;
	}

	public void setqItmCode(String qItmCode) {
		this.qItmCode = qItmCode;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public String getCustGSTNo() {
		return custGSTNo;
	}

	public void setCustGSTNo(String custGSTNo) {
		this.custGSTNo = custGSTNo;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public RestCrmQuoteModel() {
		super();

	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}

	public String getQutName() {
		return qutName;
	}

	public void setQutName(String qutName) {
		this.qutName = qutName;
	}

	public String getQutValidDate() {
		return qutValidDate;
	}

	public void setQutValidDate(String qutValidDate) {
		this.qutValidDate = qutValidDate;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getQutDescription() {
		return qutDescription;
	}

	public void setQutDescription(String qutDescription) {
		this.qutDescription = qutDescription;
	}

	public String getQutActive() {
		return qutActive;
	}

	public void setQutActive(String qutActive) {
		this.qutActive = qutActive;
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

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getqIGST() {
		return qIGST;
	}

	public void setqIGST(Double qIGST) {
		this.qIGST = qIGST;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	

	public String getQuoteOwner() {
		return quoteOwner;
	}

	public void setQuoteOwner(String quoteOwner) {
		this.quoteOwner = quoteOwner;
	}

	public String getQuoteDealName() {
		return quoteDealName;
	}

	public void setQuoteDealName(String quoteDealName) {
		this.quoteDealName = quoteDealName;
	}

	public String getQuoteSubject() {
		return quoteSubject;
	}

	public void setQuoteSubject(String quoteSubject) {
		this.quoteSubject = quoteSubject;
	}

	public String getQuoteValidUntil() {
		return quoteValidUntil;
	}

	public void setQuoteValidUntil(String quoteValidUntil) {
		this.quoteValidUntil = quoteValidUntil;
	}

	public String getQuoteStage() {
		return quoteStage;
	}

	public void setQuoteStage(String quoteStage) {
		this.quoteStage = quoteStage;
	}

	public String getQuoteContactName() {
		return quoteContactName;
	}

	public void setQuoteContactName(String quoteContactName) {
		this.quoteContactName = quoteContactName;
	}

	public String getQuoteTeamName() {
		return quoteTeamName;
	}

	public void setQuoteTeamName(String quoteTeamName) {
		this.quoteTeamName = quoteTeamName;
	}

	public String getQuoteAccountName() {
		return quoteAccountName;
	}

	public void setQuoteAccountName(String quoteAccountName) {
		this.quoteAccountName = quoteAccountName;
	}

	public String getQuoteCarrier() {
		return quoteCarrier;
	}

	public void setQuoteCarrier(String quoteCarrier) {
		this.quoteCarrier = quoteCarrier;
	}

	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getShippingStreet() {
		return shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTermCondition() {
		return termCondition;
	}

	public void setTermCondition(String termCondition) {
		this.termCondition = termCondition;
	}
	
	


	public String getQuoteAccountId() {
		return quoteAccountId;
	}

	public void setQuoteAccountId(String quoteAccountId) {
		this.quoteAccountId = quoteAccountId;
	}

	public String getQuoteContactId() {
		return quoteContactId;
	}

	public void setQuoteContactId(String quoteContactId) {
		this.quoteContactId = quoteContactId;
	}
	
	

	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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
