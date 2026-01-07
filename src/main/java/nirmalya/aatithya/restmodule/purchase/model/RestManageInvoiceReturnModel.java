package nirmalya.aatithya.restmodule.purchase.model;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class RestManageInvoiceReturnModel {
	private String vendorId;
	private String vendorName;
	private String invoiceReturnId;
	private String invoiceId;
	private String poId;
	private String qutValidDate; 
	private String paymentTermId;
	private String invoiceNo;
	private String reference;
	private String carrierId;
	private String vehicleNo;
	private String driverName;
	private String driverMobile;
	private String eWayBillingNo;
	private String modeTermsPayment;
	
	private String referenceNo;
	private String referenceDate;
	private String otherReference;
	private String shippingDetails;
	private String orgDetails;
	private String custDetails;
	private String exptdeliveryDate;
	private String qutDescription;
	private String terms;
	private String itemId;
	private Integer slNo;
	private String itemName;
	private String hsnCode;
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
	private Boolean taxType;
	private String sku;
	private Double itemIgst;
	private Double itemCgst;
	private Double itemSgst;
	private Double adjustment;
	private String tcsId;
	private Double tcsAmount;
	private String tcs;
    private String createdBy;
	private String updatedOn;
    private String organization; 
	private String orgDivision;
	private String unit;
	private Double pendingQuantity;
	private Double receivingQuantity;
	private Double receivedQuantity;
	private String description;
	private String unitName;
	private Double taxableAmt;
	private Double totalTaxableAmt;
	private String grandTotalInWords;
	private String custGSTNo;
	private Double returningQuantity;
	private String approveStatus;
	private String creditNoteId;
	private Double creditNoteAmt;
	private String project;
	private String projectName;
	private String gstAmount;
	private String grandTotal1;
	List<InventoryVendorDocumentModel> documentList;
	public RestManageInvoiceReturnModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestManageInvoiceReturnModel(Object vendorId, Object vendorName, Object invoiceId,Object invoiceReturnId, Object grandTotal,
			Object updatedOn,Object invoiceNo,Object poId,
			Object terms,Object createdBy ,Object returningQuantity ,Object creditNoteAmt, Object approveStatus,Object project, Object gstAmount) {
		super();
		this.vendorId = (String)vendorId;
		this.vendorName = (String)vendorName;
		this.invoiceId = (String)invoiceId;
		this.invoiceReturnId = (String)invoiceReturnId;
		this.grandTotal = (Double)grandTotal;
		this.updatedOn = (String)updatedOn;
		this.invoiceNo = (String)invoiceNo;
		this.poId = (String)poId;
		//this.qutValidDate = (String)qutValidDate;
		//this.qutDescription = (String)qutDescription;
		this.terms = (String)terms;
		this.createdBy = (String)createdBy;	
		this.returningQuantity =(Double) returningQuantity;
		this.creditNoteAmt =(Double) creditNoteAmt;
		this.approveStatus =(String) approveStatus;
		this.project =(String) project;
		this.gstAmount =(String) gstAmount;
	}
	public RestManageInvoiceReturnModel(Object vendorId, Object vendorName, Object invoiceId, Object poId,
			 Object invoiceReturnId, Object terms, Object itemId,
			 Object itemName, Object hsnCode, Object quantity, Object unitPrice, Object discount,
			Object gstRate, Object lineTotal, Object subTotal, Object qIGST, Object qCGST, Object qSGST,
			Object grandTotal, Object taxType, Object sku, Object itemIgst, Object itemCgst, Object itemSgst,
			Object adjustment, Object tcsId, Object tcsAmount, Object tcs, Object createdBy, Object updatedOn,
			Object unit,Object pendingQuantity,Object receivedQuantity,Object description,Object unitName,
			Object taxableAmt,Object returningQuantity,Object project,Object projectName) {
		super(); 
		this.vendorId = (String)vendorId;
		this.vendorName = (String)vendorName;
		this.invoiceId = (String)invoiceId;
		this.poId = (String)poId;
		this.invoiceReturnId = (String)invoiceReturnId;
		this.terms = (String)terms;
		this.itemId = (String)itemId;
		this.itemName = (String)itemName;
		this.hsnCode = (String)hsnCode;
		this.quantity = (Double)quantity;
		this.unitPrice = (Double)unitPrice;
		this.discount = (Double)discount;
		this.gstRate = (Double)gstRate;
		this.lineTotal = (Double)lineTotal;
		this.subTotal = (Double)subTotal;
		this.qIGST = (Double)qIGST;
		this.qCGST = (Double)qCGST;
		this.qSGST = (Double)qSGST;
		this.grandTotal = (Double)grandTotal;
		this.taxType = (Boolean)taxType;
		this.sku = (String)sku;
		this.itemIgst = (Double)itemIgst;
		this.itemCgst = (Double)itemCgst;
		this.itemSgst = (Double)itemSgst;
		this.adjustment = (Double)adjustment;
		this.tcsId = (String)tcsId;
		this.tcsAmount = (Double)tcsAmount;
		this.tcs = (String)tcs;
		this.createdBy = (String)createdBy;
		this.updatedOn = (String)updatedOn;
		this.unit = (String)unit;
		this.pendingQuantity = (Double)pendingQuantity;
		this.receivedQuantity = (Double)receivedQuantity;
		this.description = (String)description;
		this.unitName = (String)unitName;
		this.taxableAmt =(Double) taxableAmt;
		this.returningQuantity =(Double) returningQuantity;
		this.project = (String)project;
		this.projectName = (String)projectName;
		
	}
	
	
	
	
	
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getInvoiceReturnId() {
		return invoiceReturnId;
	}
	public void setInvoiceReturnId(String invoiceReturnId) {
		this.invoiceReturnId = invoiceReturnId;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getQutValidDate() {
		return qutValidDate;
	}
	public void setQutValidDate(String qutValidDate) {
		this.qutValidDate = qutValidDate;
	}
	public String getPaymentTermId() {
		return paymentTermId;
	}
	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverMobile() {
		return driverMobile;
	}
	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}
	public String geteWayBillingNo() {
		return eWayBillingNo;
	}
	public void seteWayBillingNo(String eWayBillingNo) {
		this.eWayBillingNo = eWayBillingNo;
	}
	public String getModeTermsPayment() {
		return modeTermsPayment;
	}
	public void setModeTermsPayment(String modeTermsPayment) {
		this.modeTermsPayment = modeTermsPayment;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getReferenceDate() {
		return referenceDate;
	}
	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}
	public String getOtherReference() {
		return otherReference;
	}
	public void setOtherReference(String otherReference) {
		this.otherReference = otherReference;
	}
	public String getShippingDetails() {
		return shippingDetails;
	}
	public void setShippingDetails(String shippingDetails) {
		this.shippingDetails = shippingDetails;
	}
	public String getOrgDetails() {
		return orgDetails;
	}
	public void setOrgDetails(String orgDetails) {
		this.orgDetails = orgDetails;
	}
	public String getCustDetails() {
		return custDetails;
	}
	public void setCustDetails(String custDetails) {
		this.custDetails = custDetails;
	}
	public String getExptdeliveryDate() {
		return exptdeliveryDate;
	}
	public void setExptdeliveryDate(String exptdeliveryDate) {
		this.exptdeliveryDate = exptdeliveryDate;
	}
	public String getQutDescription() {
		return qutDescription;
	}
	public void setQutDescription(String qutDescription) {
		this.qutDescription = qutDescription;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Integer getSlNo() {
		return slNo;
	}
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
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
	public Boolean getTaxType() {
		return taxType;
	}
	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getOrgDivision() {
		return orgDivision;
	}
	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getPendingQuantity() {
		return pendingQuantity;
	}
	public void setPendingQuantity(Double pendingQuantity) {
		this.pendingQuantity = pendingQuantity;
	}
	public Double getReceivingQuantity() {
		return receivingQuantity;
	}
	public void setReceivingQuantity(Double receivingQuantity) {
		this.receivingQuantity = receivingQuantity;
	}
	public Double getReceivedQuantity() {
		return receivedQuantity;
	}
	public void setReceivedQuantity(Double receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Double getTaxableAmt() {
		return taxableAmt;
	}
	public void setTaxableAmt(Double taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	public Double getTotalTaxableAmt() {
		return totalTaxableAmt;
	}
	public void setTotalTaxableAmt(Double totalTaxableAmt) {
		this.totalTaxableAmt = totalTaxableAmt;
	}
	public String getGrandTotalInWords() {
		return grandTotalInWords;
	}
	public void setGrandTotalInWords(String grandTotalInWords) {
		this.grandTotalInWords = grandTotalInWords;
	}
	public String getCustGSTNo() {
		return custGSTNo;
	}
	public void setCustGSTNo(String custGSTNo) {
		this.custGSTNo = custGSTNo;
	}
	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}

	public Double getReturningQuantity() {
		return returningQuantity;
	}

	public void setReturningQuantity(Double returningQuantity) {
		this.returningQuantity = returningQuantity;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getCreditNoteId() {
		return creditNoteId;
	}

	public void setCreditNoteId(String creditNoteId) {
		this.creditNoteId = creditNoteId;
	}

	public Double getCreditNoteAmt() {
		return creditNoteAmt;
	}

	public void setCreditNoteAmt(Double creditNoteAmt) {
		this.creditNoteAmt = creditNoteAmt;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(String gstAmount) {
		this.gstAmount = gstAmount;
	}

	public String getGrandTotal1() {
		return grandTotal1;
	}

	public void setGrandTotal1(String grandTotal1) {
		this.grandTotal1 = grandTotal1;
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
