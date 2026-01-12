package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class RestDeliveryChallanModel {
	private String saleDeliveryChallan;
	private String deliveryChallanDate;
	private String saleInvoice;
	private String saleInvoiceId;
	private String poId;
	private String salesOrder;
	private String salesOrderId;
	private String quotationId;
	private String qutActive;
	private String qutCreatedBy;
	private String qutUpdatedOn;
	private String itemId;
	private Integer slNo;
	private String itemName;
	private String itemDesc;
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
	private String salesActive;
	private String organization;
	private String orgDivision;
	private String custId;
	private String custName;

	private Double adjustment;
	private String tcsId;
	private Double tcsAmount;
	private String tcs;
	private String salesPersonId;
	private String salesPerson;
	private String spName;
	private String paymentTermId;
	private String qutDescription;
	private String terms;

	private String invoiceDate;

	private String challanType;
	private String reference;
	private String salePackageId;
	private String soDate;
	private String hsnCode;
	private String unit;
	private String unitName;
	private String ebillNo;
	private String ebillDate;
	private Double taxableAmt;
	private Double totalTaxableAmt;
	private String grandTotalInWords;
	private Double totalQuantity;
	private String shipmentId;
	private String shipmentStatus;
	private String invoiceStatus;
	private String tMode;
	private String freight;
	private Double freigtCharge;
	private Double freigtTaxRate;
	private Double total;
	private String referenceId;
	private String referenceDate;
	private String vehicleNo;
	private String transporterId;
	private String transporterName;
	private String transporterGst;
	private String lrNumber;

	private Double fcGstAmnt;
	private Double totalFreightCharges;
	private String carrier;
	private String tracking;
	private Double rtnQut;
	private Double receivedQut;
	private Double pendingQut;
	private String orgAddress;
	private String orgEmail;
	private String orgPhone;
	private String orgImage;
	private String shippingHiddenId;
	private String orgGstNo;
	private String eoe;

	// For Pdf.

	private Double quantity1;
	private String unitPrice1;
	private String gstRate1;
	private String lineTotal1;
	private String subTotal1;
	private String grandTotal1;
	private String qIGST1;
	private String qCGST1;
	private String qSGST1;
	private String itemIgst1;
	private String itemCgst1;
	private String itemSgst1;
	private String tcsAmount1;
	private String taxableAmt1;
	private String totalQuantity1;
	private String totalTaxableAmt1;
	private String dcRemarks;
	private String dcComment;
	private String dcDesc;
	private String itemSlNo;
	private String chQty;
	private String packedQty;
	private String pendingQty;
	
	List<InventoryVendorDocumentModel> documentList;

	public RestDeliveryChallanModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestDeliveryChallanModel(Object saleDeliveryChallan, Object poId, Object qutActive, Object qutCreatedBy,
			Object qutUpdatedOn, Object grandTotal, Object custId, Object custName, Object salePackageId,
			Object shipmentId, Object carrier, Object tracking, Object shipmentStatus, Object invoiceStatus) {
		super();
		this.saleDeliveryChallan = (String) saleDeliveryChallan;
		this.poId = (String) poId;
		this.qutActive = (String) qutActive;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.qutUpdatedOn = (String) qutUpdatedOn;
		this.grandTotal = (Double) grandTotal;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.salePackageId = (String) salePackageId;
		this.shipmentId = (String) shipmentId;
		this.carrier = (String) carrier;
		this.tracking = (String) tracking;
		this.shipmentStatus = (String) shipmentStatus;
		this.invoiceStatus = (String) invoiceStatus;

	}

	public RestDeliveryChallanModel(Object saleDeliveryChallan, Object saleInvoice, Object saleInvoiceId,
			Object salesOrder, Object poId, Object quotationId, Object qutActive, Object qutCreatedBy,
			Object qutUpdatedOn, Object itemId, Object slNo, Object itemName, Object quantity, Object unitPrice,
			Object discount, Object gstRate, Object lineTotal, Object subTotal, Object qIGST, Object qCGST,
			Object qSGST, Object grandTotal, Object taxType, Object sku, Object itemIgst, Object itemCgst,
			Object itemSgst, Object salesActive, Object organization, Object orgDivision, Object custId,
			Object custName, Object adjustment, Object tcsId, Object tcsAmount, Object tcs, Object salesPersonId,
			Object salesPerson, Object spName, Object paymentTermId, Object qutDescription, Object terms,
			Object invoiceDate, Object challanType, Object reference, Object salePackageId, Object soDate,
			Object hsnCode, Object unit, Object unitName, Object ebillNo, Object ebillDate, Object taxableAmt,
			Object totalQuantity, Object totalTaxableAmt, Object freight, Object freigtCharge, Object freigtTaxRate,
			Object total, Object grandTotalInWords, Object referenceId, Object referenceDate, Object tMode,
			Object vehicleNo, Object transporterId, Object transporterName, Object lrNumber, Object fcGstAmnt,
			Object totalFreightCharges, Object shipmentId, Object carrier, Object tracking, Object shipmentStatus,
			Object rtnQut, Object receivedQut, Object pendingQut, Object orgAddress, Object orgEmail, Object orgPhone,
			Object orgImage, Object shippingHiddenId, Object orgGstNo, Object eoe, Object transporterGst,
			Object dcRemarks, Object dcComment, Object dcDesc) {

		super();
		this.saleDeliveryChallan = (String) saleDeliveryChallan;
		this.saleInvoice = (String) saleInvoice;
		this.saleInvoiceId = (String) saleInvoiceId;
		this.salesOrder = (String) salesOrder;
		this.poId = (String) poId;
		this.quotationId = (String) quotationId;
		this.qutActive = (String) qutActive;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.qutUpdatedOn = (String) qutUpdatedOn;
		this.itemId = (String) itemId;
		this.slNo = (Integer) slNo;
		this.itemName = (String) itemName;
		this.quantity = (Double) quantity;
		this.unitPrice = (Double) unitPrice;
		this.discount = (Double) discount;
		this.gstRate = (Double) gstRate;
		this.lineTotal = (Double) lineTotal;
		this.subTotal = (Double) subTotal;
		this.qIGST = (Double) qIGST;
		this.qCGST = (Double) qCGST;
		this.qSGST = (Double) qSGST;
		this.grandTotal = (Double) grandTotal;
		this.taxType = (Boolean) taxType;
		this.sku = (String) sku;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;
		this.salesActive = (String) salesActive;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.adjustment = (Double) adjustment;
		this.tcsId = (String) tcsId;
		this.tcsAmount = (Double) tcsAmount;
		this.tcs = (String) tcs;
		this.salesPersonId = (String) salesPersonId;
		this.salesPerson = (String) salesPerson;
		this.spName = (String) spName;
		this.paymentTermId = (String) paymentTermId;
		this.qutDescription = (String) qutDescription;
		this.terms = (String) terms;
		this.invoiceDate = (String) invoiceDate;
		this.challanType = (String) challanType;
		this.reference = (String) reference;
		this.salePackageId = (String) salePackageId;
		this.soDate = (String) soDate;
		this.hsnCode = (String) hsnCode;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.ebillNo = (String) ebillNo;
		this.ebillDate = (String) ebillDate;
		this.taxableAmt = (Double) taxableAmt;
		this.totalQuantity1 = (String) totalQuantity1;
		this.totalTaxableAmt1 = (String) totalTaxableAmt1;
		this.freight = (String) freight;
		this.freigtCharge = (Double) freigtCharge;
		this.freigtTaxRate = (Double) freigtTaxRate;
		this.total = (Double) total;
		this.grandTotalInWords = (String) grandTotalInWords;
		this.referenceId = (String) referenceId;
		this.referenceDate = (String) referenceDate;
		this.tMode = (String) tMode;
		this.vehicleNo = (String) vehicleNo;
		this.transporterId = (String) transporterId;
		this.transporterName = (String) transporterName;
		this.lrNumber = (String) lrNumber;
		this.fcGstAmnt = (Double) fcGstAmnt;
		this.totalFreightCharges = (Double) totalFreightCharges;
		this.shipmentId = (String) shipmentId;
		this.carrier = (String) carrier;
		this.tracking = (String) tracking;
		this.shipmentStatus = (String) shipmentStatus;
		this.rtnQut = (Double) rtnQut;
		this.receivedQut = (Double) receivedQut;
		this.pendingQut = (Double) pendingQut;
		this.orgAddress = (String) orgAddress;
		this.orgEmail = (String) orgEmail;
		this.orgPhone = (String) orgPhone;
		this.orgImage = (String) orgImage;
		this.shippingHiddenId = (String) shippingHiddenId;
		this.orgGstNo = (String) orgGstNo;
		this.eoe = (String) eoe;
		this.transporterGst = (String) transporterGst;
		this.dcRemarks = (String) dcRemarks;
		this.dcComment = (String) dcComment;
		this.dcDesc = (String) dcDesc;
	}

	public RestDeliveryChallanModel(Object custId, Object custName, Object salesOrder, Object salesOrderId,
			Object salePackageId, Object quotationId, Object itemId, Object slNo, Object itemName, Object quantity,
			Object unitPrice, Object discount, Object gstRate, Object lineTotal, Object subTotal, Object qIGST,
			Object qCGST, Object qSGST, Object grandTotal, Object taxType, Object sku, Object itemIgst, Object itemCgst,
			Object itemSgst, Object adjustment, Object tcsId, Object tcsAmount, Object tcs, Object challanType,
			Object qutCreatedBy, Object qutUpdatedOn, Object organization, Object orgDivision, Object hsnCode,
			Object unit, Object unitName, Object taxableAmt) {
		super();
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.salesOrder = (String) salesOrder;
		this.salesOrderId = (String) salesOrderId;
		this.salePackageId = (String) salePackageId;

		this.quotationId = (String) quotationId;
		this.itemId = (String) itemId;
		this.slNo = (Integer) slNo;
		this.itemName = (String) itemName;
		this.quantity = (Double) quantity;
		this.unitPrice = (Double) unitPrice;
		this.discount = (Double) discount;
		this.gstRate = (Double) gstRate;
		this.lineTotal = (Double) lineTotal;
		this.subTotal = (Double) subTotal;
		this.qIGST = (Double) qIGST;
		this.qCGST = (Double) qCGST;
		this.qSGST = (Double) qSGST;
		this.grandTotal = (Double) grandTotal;
		this.taxType = (Boolean) taxType;
		this.sku = (String) sku;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;
		this.adjustment = (Double) adjustment;
		this.tcsId = (String) tcsId;
		this.tcsAmount = (Double) tcsAmount;
		this.tcs = (String) tcs;
		this.challanType = (String) challanType;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.qutUpdatedOn = (String) qutUpdatedOn;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
		this.hsnCode = (String) hsnCode;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.taxableAmt = (Double) taxableAmt;

	}

	public RestDeliveryChallanModel(Object poId, Object saleDeliveryChallan, Object deliveryChallanDate,
			Object salesPersonId, Object salesPerson, Object paymentTermId, Object custId, Object custName,
			Object taxType, Object ebillNo, Object ebillDate, Object slNo, Object hsnCode, Object sku, Object itemId,
			Object itemName, Object unit, Object unitName, Object quantity, Object unitPrice, Object discount,
			Object gstRate, Object itemIgst, Object itemCgst, Object itemSgst, Object lineTotal, Object taxableAmt,
			Object subTotal, Object qIGST, Object qCGST, Object qSGST, Object tcsId, Object tcs, Object tcsAmount,
			Object grandTotal, Object total, Object freigtCharge, Object grandTotalInWords, Object shippingHiddenId) {
		super();
		this.poId = (String) poId;
		this.saleDeliveryChallan = (String) saleDeliveryChallan;
		this.deliveryChallanDate = (String) deliveryChallanDate;
		this.salesPersonId = (String) salesPersonId;
		this.salesPerson = (String) salesPerson;
		this.paymentTermId = (String) paymentTermId;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.taxType = (Boolean) taxType;
		this.ebillNo = (String) ebillNo;
		this.ebillDate = (String) ebillDate;
		this.slNo = (Integer) slNo;
		this.hsnCode = (String) hsnCode;
		this.sku = (String) sku;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.quantity = (Double) quantity;
		this.unitPrice = (Double) unitPrice;
		this.discount = (Double) discount;
		this.gstRate = (Double) gstRate;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;
		this.lineTotal = (Double) lineTotal;
		this.taxableAmt = (Double) taxableAmt;
		this.subTotal = (Double) subTotal;
		this.qIGST = (Double) qIGST;
		this.qCGST = (Double) qCGST;
		this.qSGST = (Double) qSGST;
		this.tcsId = (String) tcsId;
		this.tcs = (String) tcs;
		this.tcsAmount = (Double) tcsAmount;
		this.grandTotal = (Double) grandTotal;
		this.freigtCharge = (Double) freigtCharge;
		this.total = (Double) total;
		this.grandTotalInWords = (String) grandTotalInWords;
		this.shippingHiddenId = (String) shippingHiddenId;

	}

	public String getSaleDeliveryChallan() {
		return saleDeliveryChallan;
	}

	public void setSaleDeliveryChallan(String saleDeliveryChallan) {
		this.saleDeliveryChallan = saleDeliveryChallan;
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

	public String getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
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

	public String getSalesActive() {
		return salesActive;
	}

	public void setSalesActive(String salesActive) {
		this.salesActive = salesActive;
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

	public String getSalesPersonId() {
		return salesPersonId;
	}

	public void setSalesPersonId(String salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
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

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}

	public String getChallanType() {
		return challanType;
	}

	public void setChallanType(String challanType) {
		this.challanType = challanType;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getSalePackageId() {
		return salePackageId;
	}

	public void setSalePackageId(String salePackageId) {
		this.salePackageId = salePackageId;
	}

	public String getSoDate() {
		return soDate;
	}

	public void setSoDate(String soDate) {
		this.soDate = soDate;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getEbillNo() {
		return ebillNo;
	}

	public void setEbillNo(String ebillNo) {
		this.ebillNo = ebillNo;
	}

	public String getEbillDate() {
		return ebillDate;
	}

	public void setEbillDate(String ebillDate) {
		this.ebillDate = ebillDate;
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

	public Double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getDeliveryChallanDate() {
		return deliveryChallanDate;
	}

	public void setDeliveryChallanDate(String deliveryChallanDate) {
		this.deliveryChallanDate = deliveryChallanDate;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String gettMode() {
		return tMode;
	}

	public void settMode(String tMode) {
		this.tMode = tMode;
	}

	public Double getFreigtCharge() {
		return freigtCharge;
	}

	public void setFreigtCharge(Double freigtCharge) {
		this.freigtCharge = freigtCharge;
	}

	public Double getFreigtTaxRate() {
		return freigtTaxRate;
	}

	public void setFreigtTaxRate(Double freigtTaxRate) {
		this.freigtTaxRate = freigtTaxRate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(String transporterId) {
		this.transporterId = transporterId;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getLrNumber() {
		return lrNumber;
	}

	public void setLrNumber(String lrNumber) {
		this.lrNumber = lrNumber;
	}

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public Double getTotalFreightCharges() {
		return totalFreightCharges;
	}

	public void setTotalFreightCharges(Double totalFreightCharges) {
		this.totalFreightCharges = totalFreightCharges;
	}

	public Double getFcGstAmnt() {
		return fcGstAmnt;
	}

	public void setFcGstAmnt(Double fcGstAmnt) {
		this.fcGstAmnt = fcGstAmnt;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getTracking() {
		return tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	public Double getRtnQut() {
		return rtnQut;
	}

	public void setRtnQut(Double rtnQut) {
		this.rtnQut = rtnQut;
	}

	public Double getReceivedQut() {
		return receivedQut;
	}

	public void setReceivedQut(Double receivedQut) {
		this.receivedQut = receivedQut;
	}

	public Double getPendingQut() {
		return pendingQut;
	}

	public void setPendingQut(Double pendingQut) {
		this.pendingQut = pendingQut;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrgEmail() {
		return orgEmail;
	}

	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}

	public String getOrgPhone() {
		return orgPhone;
	}

	public void setOrgPhone(String orgPhone) {
		this.orgPhone = orgPhone;
	}

	public String getOrgImage() {
		return orgImage;
	}

	public void setOrgImage(String orgImage) {
		this.orgImage = orgImage;
	}

	public String getShippingHiddenId() {
		return shippingHiddenId;
	}

	public void setShippingHiddenId(String shippingHiddenId) {
		this.shippingHiddenId = shippingHiddenId;
	}

	public String getOrgGstNo() {
		return orgGstNo;
	}

	public void setOrgGstNo(String orgGstNo) {
		this.orgGstNo = orgGstNo;
	}

	public String getEoe() {
		return eoe;
	}

	public void setEoe(String eoe) {
		this.eoe = eoe;
	}

	// For Pdf.

	public Double getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(Double quantity1) {
		this.quantity1 = quantity1;
	}

	public String getUnitPrice1() {
		return unitPrice1;
	}

	public void setUnitPrice1(String unitPrice1) {
		this.unitPrice1 = unitPrice1;
	}

	public String getGstRate1() {
		return gstRate1;
	}

	public void setGstRate1(String gstRate1) {
		this.gstRate1 = gstRate1;
	}

	public String getLineTotal1() {
		return lineTotal1;
	}

	public void setLineTotal1(String lineTotal1) {
		this.lineTotal1 = lineTotal1;
	}

	public String getSubTotal1() {
		return subTotal1;
	}

	public void setSubTotal1(String subTotal1) {
		this.subTotal1 = subTotal1;
	}

	public String getGrandTotal1() {
		return grandTotal1;
	}

	public void setGrandTotal1(String grandTotal1) {
		this.grandTotal1 = grandTotal1;
	}

	public String getqIGST1() {
		return qIGST1;
	}

	public void setqIGST1(String qIGST1) {
		this.qIGST1 = qIGST1;
	}

	public String getqCGST1() {
		return qCGST1;
	}

	public void setqCGST1(String qCGST1) {
		this.qCGST1 = qCGST1;
	}

	public String getqSGST1() {
		return qSGST1;
	}

	public void setqSGST1(String qSGST1) {
		this.qSGST1 = qSGST1;
	}

	public String getItemIgst1() {
		return itemIgst1;
	}

	public void setItemIgst1(String itemIgst1) {
		this.itemIgst1 = itemIgst1;
	}

	public String getItemCgst1() {
		return itemCgst1;
	}

	public void setItemCgst1(String itemCgst1) {
		this.itemCgst1 = itemCgst1;
	}

	public String getItemSgst1() {
		return itemSgst1;
	}

	public void setItemSgst1(String itemSgst1) {
		this.itemSgst1 = itemSgst1;
	}

	public String getTcsAmount1() {
		return tcsAmount1;
	}

	public void setTcsAmount1(String tcsAmount1) {
		this.tcsAmount1 = tcsAmount1;
	}

	public String getTaxableAmt1() {
		return taxableAmt1;
	}

	public void setTaxableAmt1(String taxableAmt1) {
		this.taxableAmt1 = taxableAmt1;
	}

	public String getTotalQuantity1() {
		return totalQuantity1;
	}

	public void setTotalQuantity1(String totalQuantity1) {
		this.totalQuantity1 = totalQuantity1;
	}

	public String getTotalTaxableAmt1() {
		return totalTaxableAmt1;
	}

	public void setTotalTaxableAmt1(String totalTaxableAmt1) {
		this.totalTaxableAmt1 = totalTaxableAmt1;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getTransporterGst() {
		return transporterGst;
	}

	public void setTransporterGst(String transporterGst) {
		this.transporterGst = transporterGst;
	}

	public String getDcRemarks() {
		return dcRemarks;
	}

	public void setDcRemarks(String dcRemarks) {
		this.dcRemarks = dcRemarks;
	}

	public String getDcComment() {
		return dcComment;
	}

	public void setDcComment(String dcComment) {
		this.dcComment = dcComment;
	}

	public String getDcDesc() {
		return dcDesc;
	}

	public void setDcDesc(String dcDesc) {
		this.dcDesc = dcDesc;
	}

	public String getItemSlNo() {
		return itemSlNo;
	}

	public void setItemSlNo(String itemSlNo) {
		this.itemSlNo = itemSlNo;
	}

	public String getChQty() {
		return chQty;
	}

	public void setChQty(String chQty) {
		this.chQty = chQty;
	}

	public String getPackedQty() {
		return packedQty;
	}

	public void setPackedQty(String packedQty) {
		this.packedQty = packedQty;
	}

	public String getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(String pendingQty) {
		this.pendingQty = pendingQty;
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
