package nirmalya.aatithya.restmodule.pos.model;


import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class POSCustomerDetailsRestModel {
	private String customerId;
	private String orderId;
	private String operatorId;
	private String storeId;
	private String custName;
	private String custMobile;
	private String custEmail;
	private String shippingaddress;
	private String custCity;
	private String custPincode;
	private String birthday;
	private String spouseName;
	private String anniversary;
	private String customerGstInNo;
	private String gender;

	private String twoThousand;
	private String twoHundred;
	private String fiftyRupees;
	private String tenRupees;
	private String twoRupees;
	private String fiveHundredRupees;
	private String oneHundredRupees;
	private String twentyRupees;
	private String fiveRupees;
	private String oneRupees;
	private List<POSProductDetailsRestModel> prdctDtls;

	private String totalOrderAmount;
	private String totalItemNumber;
	private String orderCreateOn;
	private String totalDiscountedAmnt;

	private String subTotal;
	private String totalCgst;
	private String totalSgst;
	private String totalIgst;
	private String paymentMode;

	private String futureOrderDate;
	private String futureOrdertime;
	private String transCost;
	private String deliveryCharges;
	private String adjustment;
	private String futureOrder;
	private String doorStepDelivery;
	
	//Pagination
		private String totalPageno;
		private String totalOrderById;
	
	private String invoiceId;

	public POSCustomerDetailsRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public POSCustomerDetailsRestModel(Object orderId) {
		super();
		this.orderId = (String) orderId;
	}
	public POSCustomerDetailsRestModel(Object customerId, Object custName, Object custMobile, Object custEmail,
			Object shippingaddress, Object custCity, Object custPincode, Object birthday, Object spouseName,
			Object anniversary, Object gender) {
		super();
		this.customerId = (String) customerId;
		this.custName = (String) custName;
		this.custMobile = (String) custMobile;
		this.custEmail = (String) custEmail;
		this.shippingaddress = (String) shippingaddress;
		this.custCity = (String) custCity;
		this.custPincode = (String) custPincode;
		this.birthday = (String) birthday;
		this.spouseName = (String) spouseName;
		this.anniversary = (String) anniversary;
		this.gender = (String) gender;
		
	}
	
	public POSCustomerDetailsRestModel(Object customerId, Object orderId, Object custName, Object custMobile,
			Object custEmail, Object totalOrderAmount, Object totalItemNumber, Object orderCreateOn) {
		super();
		this.customerId = (String) customerId;
		this.orderId = (String) orderId;
		this.custName = (String) custName;
		this.custMobile = (String) custMobile;
		this.custEmail = (String) custEmail;
		this.totalOrderAmount = (String) totalOrderAmount;
		this.totalItemNumber = (String) totalItemNumber;
		this.orderCreateOn = (String) orderCreateOn;
	
	}
	public POSCustomerDetailsRestModel(Object customerId, Object custName, Object custMobile, Object custEmail,
			Object shippingaddress, Object custCity, Object custPincode, Object birthday, Object spouseName,
			Object anniversary, Object gender, Object totalPageno, Object totalOrderById) {
		super();
		this.customerId = (String) customerId;
		this.custName = (String) custName;
		this.custMobile = (String) custMobile;
		this.custEmail = (String) custEmail;
		this.shippingaddress = (String) shippingaddress;
		this.custCity = (String) custCity;
		this.custPincode = (String) custPincode;
		this.birthday = (String) birthday;
		this.spouseName = (String) spouseName;
		this.anniversary = (String) anniversary;
		this.gender = (String) gender;
		this.totalPageno = (String) totalPageno;
		this.totalOrderById = (String) totalOrderById;
	}

	public POSCustomerDetailsRestModel(Object customerId, Object orderId, Object custName, Object custMobile,
			Object custEmail, Object totalOrderAmount, Object totalItemNumber, Object orderCreateOn,Object totalPageno,
			Object totalOrderById) {
		super();
		this.customerId = (String) customerId;
		this.orderId = (String) orderId;
		this.custName = (String) custName;
		this.custMobile = (String) custMobile;
		this.custEmail = (String) custEmail;
		this.totalOrderAmount = (String) totalOrderAmount;
		this.totalItemNumber = (String) totalItemNumber;
		this.orderCreateOn = (String) orderCreateOn;
		this.totalPageno = (String) totalPageno;
		this.totalOrderById = (String) totalOrderById;
	}

	public POSCustomerDetailsRestModel(Object customerId, Object orderId, Object custName, Object custMobile,
			Object custEmail, Object totalOrderAmount, Object totalItemNumber, Object orderCreateOn,
			Object totalDiscountedAmnt, Object subTotal, Object totalCgst, Object totalSgst, Object totalIgst,
			Object paymentMode) {
		super();
		this.customerId = (String) customerId;
		this.orderId = (String) orderId;
		this.custName = (String) custName;
		this.custMobile = (String) custMobile;
		this.custEmail = (String) custEmail;
		this.totalOrderAmount = (String) totalOrderAmount;
		this.totalItemNumber = (String) totalItemNumber;
		this.orderCreateOn = (String) orderCreateOn;
		this.totalDiscountedAmnt = (String) totalDiscountedAmnt;
		this.subTotal = (String) subTotal;
		this.totalCgst = (String) totalCgst;
		this.totalSgst = (String) totalSgst;
		this.totalIgst = (String) totalIgst;
		this.paymentMode = (String) paymentMode;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
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

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustPincode() {
		return custPincode;
	}

	public void setCustPincode(String custPincode) {
		this.custPincode = custPincode;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}
	
	

	public String getCustomerGstInNo() {
		return customerGstInNo;
	}

	public void setCustomerGstInNo(String customerGstInNo) {
		this.customerGstInNo = customerGstInNo;
	}

	public String getTwoThousand() {
		return twoThousand;
	}

	public void setTwoThousand(String twoThousand) {
		this.twoThousand = twoThousand;
	}

	public String getTwoHundred() {
		return twoHundred;
	}

	public void setTwoHundred(String twoHundred) {
		this.twoHundred = twoHundred;
	}

	public String getFiftyRupees() {
		return fiftyRupees;
	}

	public void setFiftyRupees(String fiftyRupees) {
		this.fiftyRupees = fiftyRupees;
	}

	public String getTenRupees() {
		return tenRupees;
	}

	public void setTenRupees(String tenRupees) {
		this.tenRupees = tenRupees;
	}

	public String getTwoRupees() {
		return twoRupees;
	}

	public void setTwoRupees(String twoRupees) {
		this.twoRupees = twoRupees;
	}

	public String getFiveHundredRupees() {
		return fiveHundredRupees;
	}

	public void setFiveHundredRupees(String fiveHundredRupees) {
		this.fiveHundredRupees = fiveHundredRupees;
	}

	public String getOneHundredRupees() {
		return oneHundredRupees;
	}

	public void setOneHundredRupees(String oneHundredRupees) {
		this.oneHundredRupees = oneHundredRupees;
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

	public String getTwentyRupees() {
		return twentyRupees;
	}

	public void setTwentyRupees(String twentyRupees) {
		this.twentyRupees = twentyRupees;
	}

	public String getFiveRupees() {
		return fiveRupees;
	}

	public void setFiveRupees(String fiveRupees) {
		this.fiveRupees = fiveRupees;
	}

	public String getOneRupees() {
		return oneRupees;
	}

	public void setOneRupees(String oneRupees) {
		this.oneRupees = oneRupees;
	}

	public List<POSProductDetailsRestModel> getPrdctDtls() {
		return prdctDtls;
	}

	public void setPrdctDtls(List<POSProductDetailsRestModel> prdctDtls) {
		this.prdctDtls = prdctDtls;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
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

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
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
