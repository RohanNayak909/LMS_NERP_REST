package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class RestSaleOrderNewModel {
	private String quotationId;
	private String poId;
	private String qutName;
	private String custId;
	private String custName;
	private String custGSTNo;
	private String qutValidDate;
	private String qutDescription;
	private String qutActive;
	private String qutCreatedBy;
	private String qutUpdatedOn;
	private String itemId;
	private String itemName;
	private String hsnCode;
	private Double quantity;
	private String unit;
	private String unitName;
	private Double taxableAmt;
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
	private String salesOrder;
	private String salesOrderId;
	private String storeId;
	private String orderReceiveDate;
	private String orderReceiveTime;
	private String salesActive;
	private Double itemIgst;
	private Double itemCgst;
	private Double itemSgst;
	private String organization;
	private String orgDivision;
	private String expectedShipmentDate;
	private String salesPaymentTerm;
	private String paymentTermId;
	private String deliveryMethodId;
	private String salesPersonId;
	private String salesPerson;
	private String spName;
	private Double tcsAmount;
	private String tcs;
	private Double adjustment;
	private String terms;
	private String tcsId;
	private String tcsRate;
	List<InventoryVendorDocumentModel> documentList;
	private String reference;
	private String invoice;
	private String invoiceDate;
	private String invoiceStatus;
	private String orderStatus;
	private String packQut;
	private String packedQut;
	private String pendingQut;
	private String sizeInMM;
	private String thicknessInMM;
	private String itemDesc;
	private String orderType;
	private String itemRemarks;
	private Double noOfItem;
	private String blockeOrder;
	private String approveStatus;
	private String shippingHiddenId;
	private String project;
	private String projectName;

	private String pan;
	private String gstNo;
	private String poNo;

	private String type;
	private String paymentTerm;
	private String dueDate;
	private String dateOfSupply;
	private String vehicleNo;
	private String transporterId;
	private String transporterName;
	private String lrNumber;
	private String tMode;
	private String salesRId;
	private String saleDeliverysales1;
	private String deliveryMode;
	private String deliveryTerm;
	private String soRemarks;
	private String soRef;
	private String endCustomerName;
	private String version;
	private String ourRefNo;

	public RestSaleOrderNewModel() {
		super();

	}

	public RestSaleOrderNewModel(Object poId, Object custId, Object custName, Object qutDescription,
			Object qutCreatedBy, Object itemId, Object itemName, Object quantity, Object unitPrice, Object discount,
			Object gstRate, Object lineTotal, Object subTotal, Object qIGST, Object qCGST, Object qSGST,
			Object grandTotal, Object taxType, Object hsnCode, Object sku, Object salesOrder, Object itemIgst,
			Object itemCgst, Object itemSgst, Object paymentTermId, Object deliveryMethodId, Object salesPersonId,
			Object salesPerson, Object tcsAmount, Object tcs, Object terms, Object tcsId, Object reference, Object unit,
			Object unitName, Object taxableAmt, Object tcsRate, Object orderType, Object sizeInMM, Object thicknessInMM,
			Object itemDesc, Object orderReceiveDate, Object expectedShipmentDate, Object itemRemarks, Object noOfItem,
			Object blockeOrder, Object shippingHiddenId, Object project, Object pan, Object gstNo, Object poNo,
			Object salesRId, Object paymentTerm, Object type, Object tMode, Object vehicleNo, Object transporterId,
			Object transporterName, Object lrNumber, Object dueDate, Object invoiceDate, Object dateOfSupply,
			Object saleDeliverysales1, Object deliveryMode, Object deliveryTerm, Object soRemarks, Object soRef,
			Object version, Object endCustomerName, Object salesPaymentTerm,Object ourRefNo) {
		super();
		this.poId = (String) poId;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.qutDescription = (String) qutDescription;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.itemId = (String) itemId;
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
		this.hsnCode = (String) hsnCode;
		this.sku = (String) sku;
		this.salesOrder = (String) salesOrder;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;
		this.paymentTermId = (String) paymentTermId;
		this.deliveryMethodId = (String) deliveryMethodId;
		this.salesPersonId = (String) salesPersonId;
		this.salesPerson = (String) salesPerson;
		this.tcsAmount = (Double) tcsAmount;
		this.tcs = (String) tcs;
		this.terms = (String) terms;
		this.tcsId = (String) tcsId;
		this.reference = (String) reference;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.taxableAmt = (Double) taxableAmt;
		this.tcsRate = (String) tcsRate;
		this.orderType = (String) orderType;
		this.sizeInMM = (String) sizeInMM;
		this.thicknessInMM = (String) thicknessInMM;
		this.itemDesc = (String) itemDesc;
		this.orderReceiveDate = (String) orderReceiveDate;
		this.expectedShipmentDate = (String) expectedShipmentDate;
		this.itemRemarks = (String) itemRemarks;
		this.noOfItem = (Double) noOfItem;
		this.blockeOrder = (String) blockeOrder;
		this.shippingHiddenId = (String) shippingHiddenId;
		this.project = (String) project;
		this.pan = (String) pan;
		this.gstNo = (String) gstNo;
		this.poNo = (String) poNo;

		this.salesRId = (String) salesRId;
		this.paymentTerm = (String) paymentTerm;
		this.type = (String) type;
		this.tMode = (String) tMode;
		this.vehicleNo = (String) vehicleNo;
		this.transporterId = (String) transporterId;
		this.transporterName = (String) transporterName;
		this.lrNumber = (String) lrNumber;
		this.dueDate = (String) dueDate;
		this.invoiceDate = (String) invoiceDate;
		this.dateOfSupply = (String) dateOfSupply;
		this.saleDeliverysales1 = (String) saleDeliverysales1;
		this.deliveryMode = (String) deliveryMode;
		this.deliveryTerm = (String) deliveryTerm;
		this.soRemarks = (String) soRemarks;
		this.soRef = (String) soRef;
		this.version = (String) version;
		this.endCustomerName = (String) endCustomerName;
		this.salesPaymentTerm = (String) salesPaymentTerm;
		this.ourRefNo = (String) ourRefNo;
	}

	public RestSaleOrderNewModel(Object sizeInMM, Object custId, Object custName, Object expectedShipmentDate,
			Object qutDescription, Object qutCreatedBy, Object quantity, Object grandTotal, Object salesOrder,
			Object orderReceiveDate, Object packedQut, Object pendingQut, Object approveStatus, Object shippingHiddenId,
			Object project) {
		super();
		this.poId = (String) poId;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.expectedShipmentDate = (String) expectedShipmentDate;
		this.qutDescription = (String) qutDescription;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.quantity = (Double) quantity;
		this.grandTotal = (Double) grandTotal;
		this.salesOrder = (String) salesOrder;
		this.orderReceiveDate = (String) orderReceiveDate;
		this.packedQut = (String) packedQut;
		this.pendingQut = (String) pendingQut;
		// this.orderStatus =(String) orderStatus;
		this.approveStatus = (String) approveStatus;
		this.shippingHiddenId = (String) shippingHiddenId;
		this.project = (String) project;
	}

	public RestSaleOrderNewModel(Object salesOrder, Object qutName, Object custId, Object custName, Object custGSTNo,
			Object qutValidDate, Object qutDescription, Object qutActive, Object qutCreatedBy, Object qutUpdatedOn,
			Object itemId, Object itemName, Object quantity, Object unitPrice, Object discount, Object gstRate,
			Object lineTotal, Object subTotal, Object qIGST, Object qCGST, Object qSGST, Object grandTotal,
			Object active, Object taxType, Object qItmCode, Object sku, Object poId, Object storeId,
			Object orderReceiveDate, Object orderReceiveTime, Object salesActive, Object itemIgst, Object itemCgst,
			Object itemSgst, Object expectedShipmentDate, Object paymentTermId, Object deliveryMethodId,
			Object salesPersonId, Object organization, Object orgDivision, Object salesPerson, Object tcsAmount,
			Object tcs, Object terms, Object tcsId, Object reference, Object hsnCode, Object invoice,
			Object invoiceDate, Object invoiceStatus, Object unit, Object unitName, Object taxableAmt, Object tcsRate,
			Object packQut, Object packedQut, Object pendingQut, Object noOfItem, Object salesOrderId,
			Object shippingHiddenId, Object project, Object projectName) {
		super();
		this.salesOrder = (String) salesOrder;
		this.qutName = (String) qutName;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.custGSTNo = (String) custGSTNo;
		this.qutValidDate = (String) qutValidDate;
		this.qutDescription = (String) qutDescription;
		this.qutActive = (String) qutActive;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.qutUpdatedOn = (String) qutUpdatedOn;
		this.itemId = (String) itemId;
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
		this.active = (String) active;
		this.taxType = (Boolean) taxType;
		this.qItmCode = (String) qItmCode;
		this.sku = (String) sku;
		this.poId = (String) poId;
		this.storeId = (String) storeId;
		this.orderReceiveDate = (String) orderReceiveDate;
		this.orderReceiveTime = (String) orderReceiveTime;
		this.salesActive = (String) salesActive;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;
		this.expectedShipmentDate = (String) expectedShipmentDate;
		this.paymentTermId = (String) paymentTermId;
		this.deliveryMethodId = (String) deliveryMethodId;
		this.salesPersonId = (String) salesPersonId;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
		this.salesPerson = (String) salesPerson;
		this.tcsAmount = (Double) tcsAmount;
		this.tcs = (String) tcs;

		this.terms = (String) terms;
		this.tcsId = (String) tcsId;
		this.reference = (String) reference;
		this.hsnCode = (String) hsnCode;
		this.invoice = (String) invoice;
		this.invoiceDate = (String) invoiceDate;
		this.invoiceStatus = (String) invoiceStatus;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.taxableAmt = (Double) taxableAmt;
		this.tcsRate = (String) tcsRate;
		this.packQut = (String) packQut;
		this.packedQut = (String) packedQut;
		this.pendingQut = (String) pendingQut;
		this.noOfItem = (Double) noOfItem;
		this.salesOrderId = (String) salesOrderId;
		this.shippingHiddenId = (String) shippingHiddenId;
		this.project = (String) project;
		this.projectName = (String) projectName;

	}

	public RestSaleOrderNewModel(Object poId, Object custId, Object custName, Object qutDescription,
			Object qutCreatedBy, Object itemId, Object itemName, Object quantity, Object unitPrice, Object discount,
			Object gstRate, Object lineTotal, Object subTotal, Object qIGST, Object qCGST, Object qSGST,
			Object grandTotal, Object taxType, Object hsnCode, Object sku, Object salesOrder, Object itemIgst,
			Object itemCgst, Object itemSgst, Object paymentTermId, Object deliveryMethodId, Object salesPersonId,
			Object salesPerson, Object tcsAmount, Object tcs, Object terms, Object tcsId, Object reference, Object unit,
			Object unitName, Object taxableAmt, Object tcsRate, Object orderType, Object sizeInMM, Object thicknessInMM,
			Object itemDesc, Object orderReceiveDate, Object expectedShipmentDate, Object itemRemarks, Object noOfItem,
			Object blockeOrder, Object shippingHiddenId, Object project, Object projectName) {
		super();
		this.poId = (String) poId;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.qutDescription = (String) qutDescription;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.itemId = (String) itemId;
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
		this.hsnCode = (String) hsnCode;
		this.sku = (String) sku;
		this.salesOrder = (String) salesOrder;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;
		this.paymentTermId = (String) paymentTermId;
		this.deliveryMethodId = (String) deliveryMethodId;
		this.salesPersonId = (String) salesPersonId;
		this.salesPerson = (String) salesPerson;
		this.tcsAmount = (Double) tcsAmount;
		this.tcs = (String) tcs;
		this.terms = (String) terms;
		this.tcsId = (String) tcsId;
		this.reference = (String) reference;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.taxableAmt = (Double) taxableAmt;
		this.tcsRate = (String) tcsRate;
		this.orderType = (String) orderType;
		this.sizeInMM = (String) sizeInMM;
		this.thicknessInMM = (String) thicknessInMM;
		this.itemDesc = (String) itemDesc;
		this.orderReceiveDate = (String) orderReceiveDate;
		this.expectedShipmentDate = (String) expectedShipmentDate;
		this.itemRemarks = (String) itemRemarks;
		this.noOfItem = (Double) noOfItem;
		this.blockeOrder = (String) blockeOrder;
		this.shippingHiddenId = (String) shippingHiddenId;
		this.project = (String) project;
		this.projectName = (String) projectName;
	}

	public RestSaleOrderNewModel(Object quotationId, Object custId, Object custName, Object itemId, Object itemName,
			Object sku, Object salesOrder, Object hsnCode, Object unit, Object unitName, Object quantity,
			Object pendingQut, Object packQut, Object packedQut) {
		super();
		this.quotationId = (String) quotationId;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.sku = (String) sku;
		this.salesOrder = (String) salesOrder;
		this.hsnCode = (String) hsnCode;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.quantity = (Double) quantity;
		this.pendingQut = (String) pendingQut;
		this.packQut = (String) packQut;
		this.packedQut = (String) packedQut;

	}

	public RestSaleOrderNewModel(Object itemId, Object itemName, Object gstRate, Object sku) {
		super();
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.gstRate = (Double) gstRate;
		this.sku = (String) sku;
	}

	public RestSaleOrderNewModel(Object custId, Object custName) {
		super();
		this.custId = (String) custId;
		this.custName = (String) custName;
	}

	public RestSaleOrderNewModel(Object custId, Object custName, Object active) {
		super();
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.active = (String) active;
	}

	public RestSaleOrderNewModel(Object sizeInMM, Object sku, Object itemName, Object quantity, Object unitPrice,
			Object discount, Object gstRate, Object lineTotal, Object subTotal, Object qSGST, Object qCGST,
			Object adjustment, Object poId) {
		super();

		this.sizeInMM = (String) sizeInMM;
		this.sku = (String) sku;
		this.itemName = (String) itemName;
		this.quantity = (Double) quantity;
		this.unitPrice = (Double) unitPrice;
		this.discount = (Double) discount;
		this.gstRate = (Double) gstRate;
		this.lineTotal = (Double) lineTotal;
		this.subTotal = (Double) subTotal;
		this.qSGST = (Double) qSGST;
		this.qCGST = (Double) qCGST;
		this.adjustment = (Double) adjustment;
		this.poId = (String) poId;
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

	public String getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}

	public String getQutName() {
		return qutName;
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

	public void setQutName(String qutName) {
		this.qutName = qutName;
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

	public String getCustGSTNo() {
		return custGSTNo;
	}

	public void setCustGSTNo(String custGSTNo) {
		this.custGSTNo = custGSTNo;
	}

	public String getQutValidDate() {
		return qutValidDate;
	}

	public void setQutValidDate(String qutValidDate) {
		this.qutValidDate = qutValidDate;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public String getqItmCode() {
		return qItmCode;
	}

	public void setqItmCode(String qItmCode) {
		this.qItmCode = qItmCode;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getOrderReceiveDate() {
		return orderReceiveDate;
	}

	public void setOrderReceiveDate(String orderReceiveDate) {
		this.orderReceiveDate = orderReceiveDate;
	}

	public String getOrderReceiveTime() {
		return orderReceiveTime;
	}

	public void setOrderReceiveTime(String orderReceiveTime) {
		this.orderReceiveTime = orderReceiveTime;
	}

	public String getSalesActive() {
		return salesActive;
	}

	public void setSalesActive(String salesActive) {
		this.salesActive = salesActive;
	}

	public String getExpectedShipmentDate() {
		return expectedShipmentDate;
	}

	public void setExpectedShipmentDate(String expectedShipmentDate) {
		this.expectedShipmentDate = expectedShipmentDate;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getDeliveryMethodId() {
		return deliveryMethodId;
	}

	public void setDeliveryMethodId(String deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
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

	public Double getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Double adjustment) {
		this.adjustment = adjustment;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getTcsId() {
		return tcsId;
	}

	public void setTcsId(String tcsId) {
		this.tcsId = tcsId;
	}

	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

	public Double getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(Double taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public String getTcsRate() {
		return tcsRate;
	}

	public void setTcsRate(String tcsRate) {
		this.tcsRate = tcsRate;
	}

	public String getPackedQut() {
		return packedQut;
	}

	public void setPackedQut(String packedQut) {
		this.packedQut = packedQut;
	}

	public String getPendingQut() {
		return pendingQut;
	}

	public void setPendingQut(String pendingQut) {
		this.pendingQut = pendingQut;
	}

	public String getPackQut() {
		return packQut;
	}

	public void setPackQut(String packQut) {
		this.packQut = packQut;
	}

	public String getSizeInMM() {
		return sizeInMM;
	}

	public void setSizeInMM(String sizeInMM) {
		this.sizeInMM = sizeInMM;
	}

	public String getThicknessInMM() {
		return thicknessInMM;
	}

	public void setThicknessInMM(String thicknessInMM) {
		this.thicknessInMM = thicknessInMM;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getItemRemarks() {
		return itemRemarks;
	}

	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}

	public Double getNoOfItem() {
		return noOfItem;
	}

	public void setNoOfItem(Double noOfItem) {
		this.noOfItem = noOfItem;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getBlockeOrder() {
		return blockeOrder;
	}

	public void setBlockeOrder(String blockeOrder) {
		this.blockeOrder = blockeOrder;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getShippingHiddenId() {
		return shippingHiddenId;
	}

	public void setShippingHiddenId(String shippingHiddenId) {
		this.shippingHiddenId = shippingHiddenId;
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDateOfSupply() {
		return dateOfSupply;
	}

	public void setDateOfSupply(String dateOfSupply) {
		this.dateOfSupply = dateOfSupply;
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

	public String gettMode() {
		return tMode;
	}

	public void settMode(String tMode) {
		this.tMode = tMode;
	}

	public String getSalesRId() {
		return salesRId;
	}

	public void setSalesRId(String salesRId) {
		this.salesRId = salesRId;
	}

	public String getSaleDeliverysales1() {
		return saleDeliverysales1;
	}

	public void setSaleDeliverysales1(String saleDeliverysales1) {
		this.saleDeliverysales1 = saleDeliverysales1;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getDeliveryTerm() {
		return deliveryTerm;
	}

	public void setDeliveryTerm(String deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	public String getSoRemarks() {
		return soRemarks;
	}

	public void setSoRemarks(String soRemarks) {
		this.soRemarks = soRemarks;
	}

	public String getSoRef() {
		return soRef;
	}

	public void setSoRef(String soRef) {
		this.soRef = soRef;
	}

	public String getEndCustomerName() {
		return endCustomerName;
	}

	public void setEndCustomerName(String endCustomerName) {
		this.endCustomerName = endCustomerName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSalesPaymentTerm() {
		return salesPaymentTerm;
	}

	public void setSalesPaymentTerm(String salesPaymentTerm) {
		this.salesPaymentTerm = salesPaymentTerm;
	}

	public String getOurRefNo() {
		return ourRefNo;
	}

	public void setOurRefNo(String ourRefNo) {
		this.ourRefNo = ourRefNo;
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
