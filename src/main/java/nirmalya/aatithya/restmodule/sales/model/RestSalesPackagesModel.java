package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestSalesPackagesModel {
	private String salePackageId;
    private String custId;
	private String custName;
	private String salesOrder;
	private String salesOrderId;
	private String poId;
	private String quotationId;
	private String saleInvoiceId;
	
	private String qutActive;
	private String qutCreatedBy;
	private String qutUpdatedOn;
	private String packageSlip;
	private String packagingDate;
	private String carrier;
	private String tracking;
	private String status;
	private String shipmentDate;
	private Double ordered;
	private String packed;
	private Double quantityOfPack;
	private String internalNotes;
	
	private String itemId;
	private String itemName;
	private String itemDesc;
	private String hsnCode;
	private Double quantity;
	private String unit;
	private String unitName;
	private String sku;
	private String skuName;
	private String returnQuantity;
	private String orgName;
	private String orgDiv;


	 private String packItemName;
	 private String packTotalQut;
	 private String packUnit;
	 private String packQut;
	 private String packingQut;
	 private String packType;
	 private String packName;
	 private String packDate;
	 private String packDesc;
	 private String packedQut;
     private String pendingQut;
     private  String salesShipmentId ;
	 
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
 	private Double itemIgst;
 	private Double itemCgst;
 	
 	private Double itemSgst;
 	private Double adjustment;
 	 private String tcsId;
 	
 	private Double tcsAmount;
 	private String tcs;
	private Integer slNo;
	 private String dchallan;
	 private String dchallanStatus;
	 private Double taxableAmt;
	 private Double freigtTaxRate;
	 private Double noOfItem;
	 private  String shippingHiddenId ;
	public RestSalesPackagesModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestSalesPackagesModel(Object custId,Object custName,Object poId,Object salePackageId, 
			Object itemId, Object slNo, Object itemName, Object quantity, Object unitPrice,
			Object discount, Object gstRate, Object lineTotal, Object subTotal, Object qIGST, Object qCGST,
			Object qSGST, Object grandTotal, Object taxType, Object sku, Object itemIgst, Object itemCgst,
			Object itemSgst,  Object adjustment, Object tcsId, Object tcsAmount, 
			Object tcs,Object hsnCode,Object unit,Object unitName,Object taxableAmt,Object freigtTaxRate,Object shippingHiddenId) {
		super();
		this.custId =(String)custId;
		this.custName =(String)custName;
	    this.poId = (String)poId;
		this.salePackageId = (String)salePackageId;
		this.itemId = (String)itemId;
		this.slNo = (Integer)slNo;
		this.itemName = (String)itemName;
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
		this.hsnCode =(String)hsnCode;
		this.unit =(String)unit;
		this.unitName =(String)unitName;
		this.taxableAmt = (Double)taxableAmt;
		this.freigtTaxRate = (Double)freigtTaxRate;
		this.shippingHiddenId = (String)shippingHiddenId;
	}

	
	public RestSalesPackagesModel(Object salePackageId, Object custId, Object custName, Object salesOrder,
			Object poId, Object quotationId, Object saleInvoiceId,  Object qutActive,
			Object qutCreatedBy, Object qutUpdatedOn,Object packageSlip, Object packagingDate,
			 Object quantity, Object itemId, Object itemName, Object ordered,
			Object packed, Object quantityOfPack, Object internalNotes, Object dchallan, Object dchallanStatus,Object shippingHiddenId ) {
		super();
		this.salePackageId = (String)salePackageId;
		this.custId = (String)custId;
		this.custName = (String)custName;
		this.salesOrder = (String)salesOrder;
		this.poId = (String)poId;
		this.quotationId = (String)quotationId;
		this.saleInvoiceId = (String)saleInvoiceId;
		
		this.qutActive = (String)qutActive;
		this.qutCreatedBy = (String)qutCreatedBy;
		this.qutUpdatedOn = (String)qutUpdatedOn;
		this.packageSlip = (String)packageSlip;
		this.packagingDate = (String)packagingDate;
		
		this.quantity = (Double)quantity;
		this.itemId = (String)itemId;
		this.itemName = (String)itemName;
		this.ordered = (Double)ordered;
		this.packed = (String)packed;
		this.quantityOfPack = (Double)quantityOfPack;
		this.internalNotes = (String)internalNotes;
		this.dchallan = (String)dchallan;
		this.dchallanStatus = (String)dchallanStatus;
		this.shippingHiddenId = (String)shippingHiddenId;
	}

	public RestSalesPackagesModel(Object salePackageId, Object custId, Object custName, 
			Object salesOrderId,Object packageSlip, Object packagingDate, Object internalNotes, Object itemId,
			Object itemName, Object quantity, Object unitName, Object sku,Object hsnCode,
			Object packQut, Object packType, Object packDate,Object packDesc,Object packedQut,Object pendingQut,Object packName,Object unit,Object noOfItem,
			Object salesOrder,Object poId,Object shippingHiddenId ) {
		super();
		this.salePackageId = (String)salePackageId;
		this.custId = (String)custId;
		this.custName = (String)custName;
		this.salesOrderId = (String)salesOrderId;
		this.packageSlip = (String)packageSlip;
		this.packagingDate = (String)packagingDate;
		this.internalNotes = (String)internalNotes;
		this.itemId = (String)itemId;
		this.itemName = (String)itemName;
		this.quantity = (Double)quantity;
		this.unitName = (String)unitName;
		this.sku = (String)sku;
		this.hsnCode = (String)hsnCode;
		
		this.packQut = (String)packQut;
		this.packType = (String)packType;
		this.packDate = (String)packDate;
		this.packDesc = (String)packDesc;
		this.packedQut = (String)packedQut;
		this.pendingQut = (String)pendingQut;
		this.packName = (String)packName;
		this.unit = (String)unit;
		this.noOfItem = (Double)noOfItem;
		this.salesOrder = (String)salesOrder;
		this.poId = (String)poId;
		this.shippingHiddenId = (String)shippingHiddenId;
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
	public String getSaleInvoiceId() {
		return saleInvoiceId;
	}
	public void setSaleInvoiceId(String saleInvoiceId) {
		this.saleInvoiceId = saleInvoiceId;
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
	public String getPackagingDate() {
		return packagingDate;
	}
	public void setPackagingDate(String packagingDate) {
		this.packagingDate = packagingDate;
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
	
	public Double getOrdered() {
		return ordered;
	}

	public void setOrdered(Double ordered) {
		this.ordered = ordered;
	}

	public String getPacked() {
		return packed;
	}
	public void setPacked(String packed) {
		this.packed = packed;
	}
	
	public Double getQuantityOfPack() {
		return quantityOfPack;
	}

	public void setQuantityOfPack(Double quantityOfPack) {
		this.quantityOfPack = quantityOfPack;
	}

	public String getInternalNotes() {
		return internalNotes;
	}
	public void setInternalNotes(String internalNotes) {
		this.internalNotes = internalNotes;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	

	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public String getPackageSlip() {
		return packageSlip;
	}


	public void setPackageSlip(String packageSlip) {
		this.packageSlip = packageSlip;
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


	public String getSalesShipmentId() {
		return salesShipmentId;
	}


	public void setSalesShipmentId(String salesShipmentId) {
		this.salesShipmentId = salesShipmentId;
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


	public String getPackItemName() {
		return packItemName;
	}


	public void setPackItemName(String packItemName) {
		this.packItemName = packItemName;
	}


	public String getPackTotalQut() {
		return packTotalQut;
	}


	public void setPackTotalQut(String packTotalQut) {
		this.packTotalQut = packTotalQut;
	}


	public String getPackUnit() {
		return packUnit;
	}


	public void setPackUnit(String packUnit) {
		this.packUnit = packUnit;
	}


	public String getPackQut() {
		return packQut;
	}


	public void setPackQut(String packQut) {
		this.packQut = packQut;
	}


	public String getPackingQut() {
		return packingQut;
	}


	public void setPackingQut(String packingQut) {
		this.packingQut = packingQut;
	}


	public String getPackType() {
		return packType;
	}


	public void setPackType(String packType) {
		this.packType = packType;
	}


	public String getPackDate() {
		return packDate;
	}


	public void setPackDate(String packDate) {
		this.packDate = packDate;
	}


	public String getPackDesc() {
		return packDesc;
	}


	public void setPackDesc(String packDesc) {
		this.packDesc = packDesc;
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


	public String getSku() {
		return sku;
	}

	public Integer getSlNo() {
		return slNo;
	}


	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getReturnQuantity() {
		return returnQuantity;
	}


	public void setReturnQuantity(String returnQuantity) {
		this.returnQuantity = returnQuantity;
	}


	public String getSalePackageId() {
		return salePackageId;
	}


	public void setSalePackageId(String salePackageId) {
		this.salePackageId = salePackageId;
	}

	public String getDchallan() {
		return dchallan;
	}
	public void setDchallan(String dchallan) {
		this.dchallan = dchallan;
	}
	public String getDchallanStatus() {
		return dchallanStatus;
	}
	public void setDchallanStatus(String dchallanStatus) {
		this.dchallanStatus = dchallanStatus;
	}
	
	public Double getTaxableAmt() {
		return taxableAmt;
	}
	public void setTaxableAmt(Double taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	
	
	
	
	public Double getFreigtTaxRate() {
		return freigtTaxRate;
	}
	public void setFreigtTaxRate(Double freigtTaxRate) {
		this.freigtTaxRate = freigtTaxRate;
	}
	
	
	public Double getNoOfItem() {
		return noOfItem;
	}
	public void setNoOfItem(Double noOfItem) {
		this.noOfItem = noOfItem;
	}
	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	
	
	public String getShippingHiddenId() {
		return shippingHiddenId;
	}
	public void setShippingHiddenId(String shippingHiddenId) {
		this.shippingHiddenId = shippingHiddenId;
	}
	
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
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
