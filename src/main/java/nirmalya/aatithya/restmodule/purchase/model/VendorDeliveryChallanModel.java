package nirmalya.aatithya.restmodule.purchase.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;



public class VendorDeliveryChallanModel {
	private String vendorId;
	private String vendorName;
	private String vendorDeliveryChallan;
	private String deliveryChallanDate;
	private String vendorInvoice;
	private String vendorInvoiceId;
	private String poId;
	private String quotationId;
	private String qutActive;
	private String qutCreatedBy;
	private String qutUpdatedOn;
	private String itemId;
	private Integer slNo;
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
	private Boolean taxType;
	private String sku;
	private Double itemIgst;
	private Double itemCgst;
	private Double itemSgst;
	private String organization;
	private String orgDivision;

	private Double adjustment;
	
	private String tcs;
	private String tcstype;
	private Double tcsAmount;
	private String tds;
	private String tdstype;
	private String tdsAmount;
	private String tcsId;
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
	private String lrNumber;
	private Double fcGstAmnt;
	private Double totalFreightCharges;
	private String carrier;
	private String tracking;
    private Double rtnQut;
	private Double receivedQut;
    private Double pendingQut;
    private Double pendingQuantity;
	private Double receivingQuantity;
	private Double receivedQuantity;
	private String project;
	private String projectName;
	private String approveStatus;
	
	private String challanNo;

	List<InventoryVendorDocumentModel> documentList;

	
	
    public VendorDeliveryChallanModel() {
		super();
		// TODO Auto-generated constructor stub
	}

    public VendorDeliveryChallanModel(Object vendorDeliveryChallan, Object poId, Object qutActive,
			Object qutCreatedBy, Object qutUpdatedOn, Object grandTotal, Object vendorId, Object vendorName,
			Object salePackageId, Object shipmentId,Object carrier,Object tracking,
			Object shipmentStatus,Object invoiceStatus ,Object project ,Object organization,Object approveStatus) {
		super();
		this.vendorDeliveryChallan = (String) vendorDeliveryChallan;
		this.poId = (String) poId;
		this.qutActive = (String) qutActive;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.qutUpdatedOn = (String) qutUpdatedOn;
		this.grandTotal = (Double) grandTotal;
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.salePackageId = (String) salePackageId;
		this.shipmentId = (String) shipmentId;
		this.carrier = (String) carrier;
		this.tracking = (String) tracking;
		this.shipmentStatus = (String) shipmentStatus;
		this.invoiceStatus = (String) invoiceStatus;
		this.project = (String) project;
		this.organization = (String) organization;
		this.approveStatus = (String) approveStatus;
		
	}
    public VendorDeliveryChallanModel(Object vendorDeliveryChallan,Object poId, Object itemId, Object itemName,
    		Object quantity, Object unitPrice,Object discount, Object gstRate, 
			Object lineTotal, Object subTotal, Object qIGST, Object qCGST,
			Object qSGST,Object grandTotal, Object taxType, Object sku,
			Object itemIgst,Object itemCgst,Object itemSgst, Object vendorId,
			Object vendorName,Object adjustment,Object invoiceDate,Object challanType,Object hsnCode, 
			Object unit, Object unitName, Object ebillNo,Object ebillDate,
			Object taxableAmt,Object freight,Object freigtCharge,Object freigtTaxRate,
			Object total,Object tMode,Object vehicleNo,Object transporterId,
			Object transporterName,Object lrNumber,Object paymentTermId,Object project,Object projectName,
			Object receivingQuantity, Object receivedQuantity,Object pendingQuantity,Object tcs,Object tcstype,
			Object tcsAmount,Object tds,Object tdstype,
			Object tdsAmount,Object challanNo,Object terms) {
    	
		super();
		this.vendorDeliveryChallan = (String) vendorDeliveryChallan;
		this.poId = (String) poId;
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
		this.sku = (String) sku;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.adjustment = (Double) adjustment;
		this.invoiceDate = (String) invoiceDate;
		this.challanType = (String) challanType;
		this.hsnCode = (String) hsnCode;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.ebillNo = (String) ebillNo;
		this.ebillDate = (String) ebillDate;
		this.taxableAmt = (Double) taxableAmt;
		this.freight = (String) freight;
		this.freigtCharge = (Double) freigtCharge;		
		this.freigtTaxRate = (Double) freigtTaxRate;
		this.total = (Double) total;
		this.tMode = (String) tMode;
		this.vehicleNo = (String) vehicleNo;		
		this.transporterId = (String) transporterId;
		this.transporterName = (String) transporterName;
		this.lrNumber = (String) lrNumber;
		this.paymentTermId = (String) paymentTermId;	
		this.project = (String) project;
		this.projectName = (String) projectName;
		this.receivingQuantity = (Double) receivingQuantity;
		this.receivedQuantity = (Double) receivedQuantity;	
		this.pendingQuantity = (Double) pendingQuantity;
		this.tcs = (String) tcs;
		this.tcstype = (String) tcstype;
		this.tcsAmount = (Double) tcsAmount;
		
		this.tds = (String) tds;
		this.tdstype = (String) tdstype;
		this.tdsAmount = (String) tdsAmount;
		this.challanNo = (String) challanNo;
		this.terms = (String) terms;
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



	public String getVendorDeliveryChallan() {
		return vendorDeliveryChallan;
	}



	public void setVendorDeliveryChallan(String vendorDeliveryChallan) {
		this.vendorDeliveryChallan = vendorDeliveryChallan;
	}



	public String getDeliveryChallanDate() {
		return deliveryChallanDate;
	}



	public void setDeliveryChallanDate(String deliveryChallanDate) {
		this.deliveryChallanDate = deliveryChallanDate;
	}



	public String getVendorInvoice() {
		return vendorInvoice;
	}



	public void setVendorInvoice(String vendorInvoice) {
		this.vendorInvoice = vendorInvoice;
	}



	public String getVendorInvoiceId() {
		return vendorInvoiceId;
	}



	public void setVendorInvoiceId(String vendorInvoiceId) {
		this.vendorInvoiceId = vendorInvoiceId;
	}



	public String getPoId() {
		return poId;
	}



	public void setPoId(String poId) {
		this.poId = poId;
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



	public String getFreight() {
		return freight;
	}



	public void setFreight(String freight) {
		this.freight = freight;
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



	public Double getFcGstAmnt() {
		return fcGstAmnt;
	}



	public void setFcGstAmnt(Double fcGstAmnt) {
		this.fcGstAmnt = fcGstAmnt;
	}



	public Double getTotalFreightCharges() {
		return totalFreightCharges;
	}



	public void setTotalFreightCharges(Double totalFreightCharges) {
		this.totalFreightCharges = totalFreightCharges;
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

	public String getTcstype() {
		return tcstype;
	}

	public void setTcstype(String tcstype) {
		this.tcstype = tcstype;
	}

	public String getTds() {
		return tds;
	}

	public void setTds(String tds) {
		this.tds = tds;
	}

	public String getTdstype() {
		return tdstype;
	}

	public void setTdstype(String tdstype) {
		this.tdstype = tdstype;
	}

	public String getTdsAmount() {
		return tdsAmount;
	}

	public void setTdsAmount(String tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
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
