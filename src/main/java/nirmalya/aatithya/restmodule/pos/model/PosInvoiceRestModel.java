package nirmalya.aatithya.restmodule.pos.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class PosInvoiceRestModel {
	private String storeId;
	private String storeName;
	private String storeAddress;
	private String storePincode;
	private String storeContactNo;
	private String storeCinNumber;
	private String storeWebSite;
	private String storeGstInNumber;
	private String storeStateCode;
	private String counterId;
	private String counterName;
	private String operatorId;
	private String operatorName;
	private String operatorMobile;
	private String operatorEmail;
	
	
	private String billNumber;
	private String custId;
	private String custName;
	private String custMobile;
	private String custEmail;
	private String custAddress;
	private String custCity;
	private String custState;
	private String custPincode;
	
	private String totalOrderAmount;
	private String totalItemNumber;
	private String orderCreateOn;
	private String totalDiscountedAmnt;
	private String subTotal;
	private String totalCgst;
	private String totalSgst;
	private String totalIgst;
	private String paymentMode;
	
	private List<POSProductDetailsRestModel>prdctDtls;
	
	private String futureOrderDate;
	private String futureOrdertime;
	private String transCost;
	private String deliveryCharges;
	private String adjustment;
	private String futureOrder;
	private String doorStepDelivery;

	public PosInvoiceRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PosInvoiceRestModel(Object storeId, Object storeName, Object storeAddress, Object storePincode,
			Object storeContactNo, Object storeCinNumber, Object storeWebSite, Object storeGstInNumber,
			Object storeStateCode, Object counterId, Object counterName, Object operatorName,
			Object operatorMobile, Object operatorEmail, Object billNumber, Object custId, Object custName,
			Object custMobile,Object custEmail,Object custAddress, Object custCity, Object custPincode, Object totalOrderAmount,
			Object totalItemNumber, Object orderCreateOn, Object totalDiscountedAmnt, Object subTotal, Object totalCgst,
			Object totalSgst, Object totalIgst, Object paymentMode,Object futureOrderDate,Object futureOrdertime,
			Object transCost, Object deliveryCharges, Object adjustment, Object futureOrder, Object doorStepDelivery) {
		super();
		this.storeId = (String) storeId;
		this.storeName = (String) storeName;
		this.storeAddress = (String) storeAddress;
		this.storePincode = (String) storePincode;
		this.storeContactNo = (String) storeContactNo;
		this.storeCinNumber = (String) storeCinNumber;
		this.storeWebSite = (String) storeWebSite;
		this.storeGstInNumber = (String) storeGstInNumber;
		this.storeStateCode = (String) storeStateCode;
		
		this.counterId = (String) counterId;
		this.counterName = (String) counterName;
		this.operatorName = (String) operatorName;
		this.operatorMobile = (String) operatorMobile;
		this.operatorEmail = (String) operatorEmail;
		
		this.billNumber = (String) billNumber;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.custMobile = (String) custMobile;
		this.custEmail = (String) custEmail;
		this.custAddress = (String) custAddress;
		this.custCity = (String) custCity;
		this.custPincode = (String) custPincode;
		
		this.totalOrderAmount = (String) totalOrderAmount;
		this.totalItemNumber = (String) totalItemNumber;
		this.orderCreateOn = (String) orderCreateOn;
		this.totalDiscountedAmnt = (String) totalDiscountedAmnt;
		this.subTotal = (String) subTotal;
		this.totalCgst = (String) totalCgst;
		this.totalSgst = (String) totalSgst;
		this.totalIgst = (String) totalIgst;
		this.paymentMode = (String) paymentMode;
		
		this.futureOrderDate = (String) futureOrderDate;
		this.futureOrdertime = (String) futureOrdertime;
		this.transCost = (String) transCost;
		this.deliveryCharges = (String) deliveryCharges;
		this.adjustment = (String) adjustment;
		this.futureOrder = (String) futureOrder;
		this.doorStepDelivery = (String) doorStepDelivery;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStorePincode() {
		return storePincode;
	}

	public void setStorePincode(String storePincode) {
		this.storePincode = storePincode;
	}

	public String getStoreContactNo() {
		return storeContactNo;
	}

	public void setStoreContactNo(String storeContactNo) {
		this.storeContactNo = storeContactNo;
	}

	public String getStoreCinNumber() {
		return storeCinNumber;
	}

	public void setStoreCinNumber(String storeCinNumber) {
		this.storeCinNumber = storeCinNumber;
	}

	public String getStoreWebSite() {
		return storeWebSite;
	}

	public void setStoreWebSite(String storeWebSite) {
		this.storeWebSite = storeWebSite;
	}

	public String getStoreGstInNumber() {
		return storeGstInNumber;
	}

	public void setStoreGstInNumber(String storeGstInNumber) {
		this.storeGstInNumber = storeGstInNumber;
	}

	public String getStoreStateCode() {
		return storeStateCode;
	}

	public void setStoreStateCode(String storeStateCode) {
		this.storeStateCode = storeStateCode;
	}

	public String getCounterId() {
		return counterId;
	}

	public void setCounterId(String counterId) {
		this.counterId = counterId;
	}

	public String getCounterName() {
		return counterName;
	}

	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorMobile() {
		return operatorMobile;
	}

	public void setOperatorMobile(String operatorMobile) {
		this.operatorMobile = operatorMobile;
	}

	public String getOperatorEmail() {
		return operatorEmail;
	}

	public void setOperatorEmail(String operatorEmail) {
		this.operatorEmail = operatorEmail;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
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

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCustPincode() {
		return custPincode;
	}

	public void setCustPincode(String custPincode) {
		this.custPincode = custPincode;
	}

	public String getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(String totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public String getTotalItemNumber() {
		return totalItemNumber;
	}

	public void setTotalItemNumber(String totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	public String getOrderCreateOn() {
		return orderCreateOn;
	}

	public void setOrderCreateOn(String orderCreateOn) {
		this.orderCreateOn = orderCreateOn;
	}

	public String getTotalDiscountedAmnt() {
		return totalDiscountedAmnt;
	}

	public void setTotalDiscountedAmnt(String totalDiscountedAmnt) {
		this.totalDiscountedAmnt = totalDiscountedAmnt;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public String getTotalCgst() {
		return totalCgst;
	}

	public void setTotalCgst(String totalCgst) {
		this.totalCgst = totalCgst;
	}

	public String getTotalSgst() {
		return totalSgst;
	}

	public void setTotalSgst(String totalSgst) {
		this.totalSgst = totalSgst;
	}

	public String getTotalIgst() {
		return totalIgst;
	}

	public void setTotalIgst(String totalIgst) {
		this.totalIgst = totalIgst;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public List<POSProductDetailsRestModel> getPrdctDtls() {
		return prdctDtls;
	}

	public void setPrdctDtls(List<POSProductDetailsRestModel> prdctDtls) {
		this.prdctDtls = prdctDtls;
	}
	
	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getFutureOrderDate() {
		return futureOrderDate;
	}

	public void setFutureOrderDate(String futureOrderDate) {
		this.futureOrderDate = futureOrderDate;
	}

	public String getFutureOrdertime() {
		return futureOrdertime;
	}

	public void setFutureOrdertime(String futureOrdertime) {
		this.futureOrdertime = futureOrdertime;
	}

	public String getTransCost() {
		return transCost;
	}

	public void setTransCost(String transCost) {
		this.transCost = transCost;
	}

	public String getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(String deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public String getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(String adjustment) {
		this.adjustment = adjustment;
	}

	public String getFutureOrder() {
		return futureOrder;
	}

	public void setFutureOrder(String futureOrder) {
		this.futureOrder = futureOrder;
	}

	public String getDoorStepDelivery() {
		return doorStepDelivery;
	}

	public void setDoorStepDelivery(String doorStepDelivery) {
		this.doorStepDelivery = doorStepDelivery;
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
