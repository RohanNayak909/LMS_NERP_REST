package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountCustomerOrderRestModel {

	private String custOrderId;
	private String invoiceId;
	private String custId;
	private String custName;
	private String custMobile;
	private String custAddress;
	private String custEmail;
	private String dealerId;
	private String dealerName;
	private String custDesc;
	private String status;
	private String itemId;
	private String itemName;
	private String itemQty;
	private String itemUnitPrice;
	private String itemDiscount;
	private String itemGst;
	private String itemLineTotal;
	private String itemTotalAmount;
	private String totalItem;
	private String paymentMode;
	private String paymentModeName;
	private String paymentStatus;

	private String promoCode;
	private Double adjustment;
	private String shippingCharges;
	private String createdBy;

	private Integer slNo;
	private String sku;
	private String quantity;
	private String unitPrice;
	private String discount;
	private String gstRate;
	private String lineTotal;
	private Boolean taxType;
	private String storeId;
	private Double subTotal;

	private Double qIGST;
	private Double qCGST;
	private Double qSGST;
	private String grandTotal;
	private Double outstandingAmnt;
	private String salesOrder;

	private Double itemIgst;
	private Double itemCgst;
	private Double itemSgst;

	private String categoryId;
	private String categoryName;

	private String paymentId;
	private String transcationId;

	/*
	 * List<ItemShoukeenModel> itemattribute; List<RestInvoiceShoukeenModel>
	 * invoiceattribute;
	 */

	private String deliveryBoyId;
	private String deliveryBoyName;
	private String deliveryBoyStatus;

	private String invoiceDate;
	private String invoiceTime;

	private String size;

	private String productDimensionId;
	private String productDimension;
	private String productDimesion;
	private String currency;

	/// Type
	private String chequeNo;
	private String chequeDate;
	private String accountNo;
	private String branchName;
	private String bankName;
	private String transactionNo;
	private String utrNo;

	private String userType;
	private String paymentOrder;
	private String payAmount;
	private String createdOn;
	private String createdTime;

	private Double totalPaidAmount;
	private Double outstandingAmount;

	private Double totalOrderAmount;

	private String cashReceivedBy;
	private String chequeReceivedBy;
	private String chequeDropDate;
	private String onlineReceivedBy;

	private String isPaidUpi;
	private String upiId;

	private String approvalStatus;
	private String paymentApprovedBy;

	//List<InventoryVendorDocumentModel> documentList;
	private String receivingQuantity;

	private String distDiscount;
	private String grandTotalDiscount;

	private MultipartFile multipleFile;
	private String docType;
	private String fileName;
	private String extension;
	private String fileType;
	private byte[] bytes;

	private String documnentName;
	private String remarkId;
	private String remarkSubject;
	private String remarkNotes;

	private String replacedOrderId;
	private String paymentReceivedBy;

	private String qutActive;
	private String saleInvoiceId;
	private String saleDeliveryChallan;

	// Pagination
	private String totalPageno;
	private String totalOrderById;
	
	private String orderApprovedBy;
	private String sapId;
	private String tds;

	public AccountCustomerOrderRestModel() {
		super();
	}


	// Customer Invoice Pagination
	public AccountCustomerOrderRestModel(Object invoiceId, Object custOrderId, Object custId,
			Object custName, Object custMobile, Object custEmail, Object lineTotal, Object totalOrderAmount,
			Object status, Object itemTotalAmount, Object totalPageno, Object totalOrderById) {
		super();

		this.invoiceId = (String) invoiceId;
		this.custOrderId = (String) custOrderId;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.custMobile = (String) custMobile;
		this.custEmail = (String) custEmail;
		this.lineTotal = (String) lineTotal;
		this.totalOrderAmount = (Double) totalOrderAmount;
		this.status = (String) status;
		this.itemTotalAmount = (String) itemTotalAmount;
		this.totalPageno = (String) totalPageno;
		this.totalOrderById = (String) totalOrderById;
	}

	// delivery challan customer
	public AccountCustomerOrderRestModel(Object saleDeliveryChallan, Object saleInvoiceId, Object custName,
			Object grandTotal, Object qutActive, Object totalPageno, Object totalOrderById) {
		super();
		this.saleDeliveryChallan = (String) saleDeliveryChallan;
		this.saleInvoiceId = (String) saleInvoiceId;
		this.custName = (String) custName;
		this.grandTotal = (String) grandTotal;
		this.qutActive = (String) qutActive;
		this.totalPageno = (String) totalPageno;
		this.totalOrderById = (String) totalOrderById;

	}
	
	//dealer packaging
	public AccountCustomerOrderRestModel(Object itemName, Object itemQty, Object deliveryBoyId, Object productDimensionId) {
		super();

		this.itemName = (String) itemName;
		this.itemQty = (String) itemQty;
		this.deliveryBoyId = (String) deliveryBoyId;
		this.productDimensionId = (String) productDimensionId;
	}
	
	public AccountCustomerOrderRestModel(Object custOrderId, Object createdOn, Object paymentStatus, Object totalOrderAmount , Object totalPaidAmount , Object outstandingAmount,Object dealerId, Object dealerName,Object invoiceId,Object sapId) {
		super();

		this.custOrderId = (String) custOrderId;
		this.createdOn = (String) createdOn;
		this.paymentStatus = (String) paymentStatus;
		this.totalOrderAmount = convertToDouble(totalOrderAmount);
		this.totalPaidAmount = convertToDouble(totalPaidAmount);
		this.outstandingAmount =  convertToDouble(outstandingAmount);
		this.dealerId = (String) dealerId;
		this.dealerName = (String) dealerName;		
		this.invoiceId = (String) invoiceId;
		this.sapId = (String)sapId;
	}
	
	
	public AccountCustomerOrderRestModel(Object custOrderId, Object createdOn, Object paymentStatus,Object itemTotalAmount,Object tds, Object totalOrderAmount , Object totalPaidAmount , 
			Object outstandingAmount,Object dealerId, Object dealerName,Object invoiceId,Object sapId,Object orderApprovedBy) {
		super();

		this.custOrderId = (String) custOrderId;
		this.createdOn = (String) createdOn;
		this.paymentStatus = (String) paymentStatus;
		this.itemTotalAmount = (String)itemTotalAmount;
		this.tds = (String) tds;
		this.totalOrderAmount = convertToDouble(totalOrderAmount); 
		this.totalPaidAmount = convertToDouble(totalPaidAmount);
		this.outstandingAmount =  convertToDouble(outstandingAmount);
		this.dealerId = (String) dealerId;
		this.dealerName = (String) dealerName;		
		this.invoiceId = (String) invoiceId;
		this.sapId = (String)sapId;
		this.orderApprovedBy = (String)orderApprovedBy;
	}
	
	
	public AccountCustomerOrderRestModel(Object custOrderId, Object createdOn, Object paymentStatus,Object itemTotalAmount,Object tds, Object totalOrderAmount , Object totalPaidAmount , 
			Object outstandingAmount,Object dealerId, Object dealerName,Object invoiceId,Object sapId,Object orderApprovedBy,Object paymentModeName) {
		super();

		this.custOrderId = (String) custOrderId;
		this.createdOn = (String) createdOn;
		this.paymentStatus = (String) paymentStatus;
		this.itemTotalAmount = (String)itemTotalAmount;
		this.tds = (String) tds;
		this.totalOrderAmount = convertToDouble(totalOrderAmount); 
		this.totalPaidAmount = convertToDouble(totalPaidAmount);
		this.outstandingAmount =  convertToDouble(outstandingAmount);
		this.dealerId = (String) dealerId;
		this.dealerName = (String) dealerName;		
		this.invoiceId = (String) invoiceId;
		this.sapId = (String)sapId;
		this.orderApprovedBy = (String)orderApprovedBy;
		this.paymentModeName= (String) paymentModeName; 
	}
	private Double convertToDouble(Object value) {
	    if (value instanceof BigDecimal) {
	        return ((BigDecimal) value).doubleValue();
	    } else if (value instanceof Double) {
	        return (Double) value;
	    } else {
	        // Handle other cases or throw an exception if needed
	        return null; // Or throw an exception
	    }
	}
	public String getCustOrderId() {
		return custOrderId;
	}

	public void setCustOrderId(String custOrderId) {
		this.custOrderId = custOrderId;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
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

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getCustDesc() {
		return custDesc;
	}

	public void setCustDesc(String custDesc) {
		this.custDesc = custDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getItemQty() {
		return itemQty;
	}

	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}

	public String getItemUnitPrice() {
		return itemUnitPrice;
	}

	public void setItemUnitPrice(String itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}

	public String getItemDiscount() {
		return itemDiscount;
	}

	public void setItemDiscount(String itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	public String getItemGst() {
		return itemGst;
	}

	public void setItemGst(String itemGst) {
		this.itemGst = itemGst;
	}

	public String getItemLineTotal() {
		return itemLineTotal;
	}

	public void setItemLineTotal(String itemLineTotal) {
		this.itemLineTotal = itemLineTotal;
	}

	public String getItemTotalAmount() {
		return itemTotalAmount;
	}

	public void setItemTotalAmount(String itemTotalAmount) {
		this.itemTotalAmount = itemTotalAmount;
	}

	public String getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(String totalItem) {
		this.totalItem = totalItem;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentModeName() {
		return paymentModeName;
	}

	public void setPaymentModeName(String paymentModeName) {
		this.paymentModeName = paymentModeName;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public Double getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Double adjustment) {
		this.adjustment = adjustment;
	}

	public String getShippingCharges() {
		return shippingCharges;
	}

	public void setShippingCharges(String shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
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

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Double getOutstandingAmnt() {
		return outstandingAmnt;
	}

	public void setOutstandingAmnt(Double outstandingAmnt) {
		this.outstandingAmnt = outstandingAmnt;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
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

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getTranscationId() {
		return transcationId;
	}

	public void setTranscationId(String transcationId) {
		this.transcationId = transcationId;
	}

	/*
	 * public List<ItemShoukeenModel> getItemattribute() { return itemattribute; }
	 * 
	 * public void setItemattribute(List<ItemShoukeenModel> itemattribute) {
	 * this.itemattribute = itemattribute; }
	 * 
	 * public List<RestInvoiceShoukeenModel> getInvoiceattribute() { return
	 * invoiceattribute; }
	 * 
	 * public void setInvoiceattribute(List<RestInvoiceShoukeenModel>
	 * invoiceattribute) { this.invoiceattribute = invoiceattribute; }
	 */

	public String getDeliveryBoyId() {
		return deliveryBoyId;
	}

	public void setDeliveryBoyId(String deliveryBoyId) {
		this.deliveryBoyId = deliveryBoyId;
	}

	public String getDeliveryBoyName() {
		return deliveryBoyName;
	}

	public void setDeliveryBoyName(String deliveryBoyName) {
		this.deliveryBoyName = deliveryBoyName;
	}

	public String getDeliveryBoyStatus() {
		return deliveryBoyStatus;
	}

	public void setDeliveryBoyStatus(String deliveryBoyStatus) {
		this.deliveryBoyStatus = deliveryBoyStatus;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceTime() {
		return invoiceTime;
	}

	public void setInvoiceTime(String invoiceTime) {
		this.invoiceTime = invoiceTime;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getProductDimensionId() {
		return productDimensionId;
	}

	public void setProductDimensionId(String productDimensionId) {
		this.productDimensionId = productDimensionId;
	}

	public String getProductDimension() {
		return productDimension;
	}

	public void setProductDimension(String productDimension) {
		this.productDimension = productDimension;
	}

	public String getProductDimesion() {
		return productDimesion;
	}

	public void setProductDimesion(String productDimesion) {
		this.productDimesion = productDimesion;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/*
	 * public String getDocName() { return docName; }
	 * 
	 * public void setDocName(String docName) { this.docName = docName; }
	 */

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getUtrNo() {
		return utrNo;
	}

	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPaymentOrder() {
		return paymentOrder;
	}

	public void setPaymentOrder(String paymentOrder) {
		this.paymentOrder = paymentOrder;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public Double getTotalPaidAmount() {
		return totalPaidAmount;
	}

	public void setTotalPaidAmount(Double totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}

	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(Double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public String getCashReceivedBy() {
		return cashReceivedBy;
	}

	public void setCashReceivedBy(String cashReceivedBy) {
		this.cashReceivedBy = cashReceivedBy;
	}

	public String getChequeReceivedBy() {
		return chequeReceivedBy;
	}

	public void setChequeReceivedBy(String chequeReceivedBy) {
		this.chequeReceivedBy = chequeReceivedBy;
	}

	public String getChequeDropDate() {
		return chequeDropDate;
	}

	public void setChequeDropDate(String chequeDropDate) {
		this.chequeDropDate = chequeDropDate;
	}

	public String getOnlineReceivedBy() {
		return onlineReceivedBy;
	}

	public void setOnlineReceivedBy(String onlineReceivedBy) {
		this.onlineReceivedBy = onlineReceivedBy;
	}

	public String getIsPaidUpi() {
		return isPaidUpi;
	}

	public void setIsPaidUpi(String isPaidUpi) {
		this.isPaidUpi = isPaidUpi;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getPaymentApprovedBy() {
		return paymentApprovedBy;
	}

	public void setPaymentApprovedBy(String paymentApprovedBy) {
		this.paymentApprovedBy = paymentApprovedBy;
	}

	/*
	 * public List<InventoryVendorDocumentModel> getDocumentList() { return
	 * documentList; }
	 * 
	 * public void setDocumentList(List<InventoryVendorDocumentModel> documentList)
	 * { this.documentList = documentList; }
	 */

	public String getReceivingQuantity() {
		return receivingQuantity;
	}

	public void setReceivingQuantity(String receivingQuantity) {
		this.receivingQuantity = receivingQuantity;
	}

	public String getDistDiscount() {
		return distDiscount;
	}

	public void setDistDiscount(String distDiscount) {
		this.distDiscount = distDiscount;
	}

	public String getGrandTotalDiscount() {
		return grandTotalDiscount;
	}

	public void setGrandTotalDiscount(String grandTotalDiscount) {
		this.grandTotalDiscount = grandTotalDiscount;
	}

	public MultipartFile getMultipleFile() {
		return multipleFile;
	}

	public void setMultipleFile(MultipartFile multipleFile) {
		this.multipleFile = multipleFile;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getDocumnentName() {
		return documnentName;
	}

	public void setDocumnentName(String documnentName) {
		this.documnentName = documnentName;
	}

	public String getRemarkId() {
		return remarkId;
	}

	public void setRemarkId(String remarkId) {
		this.remarkId = remarkId;
	}

	public String getRemarkSubject() {
		return remarkSubject;
	}

	public void setRemarkSubject(String remarkSubject) {
		this.remarkSubject = remarkSubject;
	}

	public String getRemarkNotes() {
		return remarkNotes;
	}

	public void setRemarkNotes(String remarkNotes) {
		this.remarkNotes = remarkNotes;
	}

	public String getReplacedOrderId() {
		return replacedOrderId;
	}

	public void setReplacedOrderId(String replacedOrderId) {
		this.replacedOrderId = replacedOrderId;
	}

	public String getPaymentReceivedBy() {
		return paymentReceivedBy;
	}

	public void setPaymentReceivedBy(String paymentReceivedBy) {
		this.paymentReceivedBy = paymentReceivedBy;
	}

	public String getTotalPageno() {
		return totalPageno;
	}

	public void setTotalPageno(String totalPageno) {
		this.totalPageno = totalPageno;
	}

	public String getTotalOrderById() {
		return totalOrderById;
	}

	public void setTotalOrderById(String totalOrderById) {
		this.totalOrderById = totalOrderById;
	}

	public String getQutActive() {
		return qutActive;
	}

	public void setQutActive(String qutActive) {
		this.qutActive = qutActive;
	}

	public String getSaleInvoiceId() {
		return saleInvoiceId;
	}

	public void setSaleInvoiceId(String saleInvoiceId) {
		this.saleInvoiceId = saleInvoiceId;
	}

	public String getSaleDeliveryChallan() {
		return saleDeliveryChallan;
	}

	public void setSaleDeliveryChallan(String saleDeliveryChallan) {
		this.saleDeliveryChallan = saleDeliveryChallan;
	}

	public String getOrderApprovedBy() {
		return orderApprovedBy;
	}

	public void setOrderApprovedBy(String orderApprovedBy) {
		this.orderApprovedBy = orderApprovedBy;
	}
	
	
	

	public String getSapId() {
		return sapId;
	}


	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	

	public String getTds() {
		return tds;
	}


	public void setTds(String tds) {
		this.tds = tds;
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
