package nirmalya.aatithya.restmodule.pos.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class POSPackagingRestModel {
	private String orderPackageId;
	private String orderShipmentId;
	private String orderDeliveryId;
	private String custOrderId;
	private String customerId;
	private String createdBy;

	private String customerName;
	private String orderStatus;
	private String createdOn;
	private String quantity;

	private String subTotal;
	private String totalCgst;
	private String totalSgst;
	private String totalIgst;
	private String paymentMode;
	private String grandTotal;
	
	private String customerEmail;
	private String customerMobile;
	private String custShipppingAddress;
	
	
	
	private String deliveryPersonName;
	private String dispatchDate;
	private String dispatchTime;
	private String deliveryPersonContact;
	private String deliveryPersonEmail;
	private String deliveryPersonVehicle;
	
	private String deliveredDate;
	private String deliveredTime;
	
	
	private List<POSProductDetailsRestModel> prdctDtls;

	public POSPackagingRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public POSPackagingRestModel(Object orderPackageId, Object custOrderId, Object customerId, Object createdBy) {
		super();
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
	}
	public POSPackagingRestModel(Object orderShipmentId,Object orderPackageId, Object custOrderId, Object customerId, Object createdBy) {
		super();
		this.orderShipmentId = (String) orderShipmentId;
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
	}
	public POSPackagingRestModel(Object orderDeliveryId,Object orderShipmentId,Object orderPackageId, Object custOrderId, Object customerId, Object createdBy) {
		super();
		this.orderDeliveryId = (String) orderDeliveryId;
		this.orderShipmentId = (String) orderShipmentId;
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
	}

	public POSPackagingRestModel(Object orderPackageId, Object custOrderId, Object customerId, Object createdBy,
			Object customerName, Object orderStatus, Object createdOn, Object quantity) {
		super();
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
		this.customerName = (String) customerName;
		this.orderStatus = (String) orderStatus;
		this.createdOn = (String) createdOn;
		this.quantity = (String) quantity;
	}
	public POSPackagingRestModel(Object orderShipmentId,Object orderPackageId, Object custOrderId, Object customerId, Object createdBy,
			Object customerName, Object orderStatus, Object createdOn, Object quantity) {
		super();
		this.orderShipmentId = (String) orderShipmentId;
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
		this.customerName = (String) customerName;
		this.orderStatus = (String) orderStatus;
		this.createdOn = (String) createdOn;
		this.quantity = (String) quantity;
	}
	public POSPackagingRestModel(Object orderDeliveryId,Object orderShipmentId,Object orderPackageId, Object custOrderId, Object customerId, Object createdBy,
			Object customerName, Object orderStatus, Object createdOn, Object quantity,Object deliveryPersonName,
			Object deliveryPersonContact,Object deliveryPersonEmail,Object dispatchDate,Object dispatchTime,Object deliveryPersonVehicle) {
		super();
		this.orderDeliveryId = (String) orderDeliveryId;
		this.orderShipmentId = (String) orderShipmentId;
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
		this.customerName = (String) customerName;
		this.orderStatus = (String) orderStatus;
		this.createdOn = (String) createdOn;
		this.quantity = (String) quantity;
		
		this.deliveryPersonName = (String) deliveryPersonName;
		this.deliveryPersonContact = (String) deliveryPersonContact;
		this.deliveryPersonEmail = (String) deliveryPersonEmail;
		this.dispatchDate = (String) dispatchDate;
		this.dispatchTime = (String) dispatchTime;
		this.deliveryPersonVehicle = (String) deliveryPersonVehicle;

	}
	
	
	public POSPackagingRestModel(Object orderPackageId, Object custOrderId, Object customerId, Object createdBy,
			Object customerName, Object orderStatus, Object createdOn, Object quantity, Object subTotal,
			Object totalCgst, Object totalSgst, Object totalIgst, Object paymentMode, Object grandTotal) {
		super();
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
		this.customerName = (String) customerName;
		this.orderStatus = (String) orderStatus;
		this.createdOn = (String) createdOn;
		this.quantity = (String) quantity;
		this.subTotal = (String) subTotal;
		this.totalCgst = (String) totalCgst;
		this.totalSgst = (String) totalSgst;
		this.totalIgst = (String) totalIgst;
		this.paymentMode = (String) paymentMode;
		this.grandTotal = (String) grandTotal;
	}
	public POSPackagingRestModel(Object orderShipmentId,Object orderPackageId, Object custOrderId, Object customerId, Object createdBy,
			Object customerName, Object orderStatus, Object createdOn, Object quantity, Object subTotal,
			Object totalCgst, Object totalSgst, Object totalIgst, Object paymentMode, Object grandTotal, Object customerEmail, Object customerMobile, Object custShipppingAddress) {
		super();
		this.orderShipmentId = (String) orderShipmentId;
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
		this.customerName = (String) customerName;
		this.orderStatus = (String) orderStatus;
		this.createdOn = (String) createdOn;
		this.quantity = (String) quantity;
		this.subTotal = (String) subTotal;
		this.totalCgst = (String) totalCgst;
		this.totalSgst = (String) totalSgst;
		this.totalIgst = (String) totalIgst;
		this.paymentMode = (String) paymentMode;
		this.grandTotal = (String) grandTotal;
		
		this.customerEmail = (String) customerEmail;
		this.customerMobile = (String) customerMobile;
		this.custShipppingAddress = (String) custShipppingAddress;
	}
	public POSPackagingRestModel(Object orderDeliveryId,Object orderShipmentId,Object orderPackageId, Object custOrderId, Object customerId, Object createdBy,
			Object customerName, Object orderStatus, Object createdOn, Object quantity, Object subTotal,
			Object totalCgst, Object totalSgst, Object totalIgst, Object paymentMode, Object grandTotal, Object customerEmail, Object customerMobile, Object custShipppingAddress,
			Object deliveryPersonName,Object deliveryPersonContact,Object deliveryPersonEmail,Object dispatchDate,Object dispatchTime,Object deliveryPersonVehicle) {
		super();
		this.orderDeliveryId = (String) orderDeliveryId;
		this.orderShipmentId = (String) orderShipmentId;
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
		this.customerName = (String) customerName;
		this.orderStatus = (String) orderStatus;
		this.createdOn = (String) createdOn;
		this.quantity = (String) quantity;
		this.subTotal = (String) subTotal;
		this.totalCgst = (String) totalCgst;
		this.totalSgst = (String) totalSgst;
		this.totalIgst = (String) totalIgst;
		this.paymentMode = (String) paymentMode;
		this.grandTotal = (String) grandTotal;
		
		this.customerEmail = (String) customerEmail;
		this.customerMobile = (String) customerMobile;
		this.custShipppingAddress = (String) custShipppingAddress;
		
		
		this.deliveryPersonName = (String) deliveryPersonName;
		this.deliveryPersonContact = (String) deliveryPersonContact;
		this.deliveryPersonEmail = (String) deliveryPersonEmail;
		this.dispatchDate = (String) dispatchDate;
		this.dispatchTime = (String) dispatchTime;
		this.deliveryPersonVehicle = (String) deliveryPersonVehicle;
	}
	public POSPackagingRestModel(Object orderDeliveryId,Object orderShipmentId,Object orderPackageId, Object custOrderId, Object customerId, Object createdBy,
			Object customerName, Object orderStatus, Object createdOn, Object quantity, Object subTotal,
			Object totalCgst, Object totalSgst, Object totalIgst, Object paymentMode, Object grandTotal, Object customerEmail, Object customerMobile, Object custShipppingAddress,
			Object deliveryPersonName,Object deliveryPersonContact,Object deliveryPersonEmail,Object dispatchDate,Object dispatchTime,Object deliveryPersonVehicle,Object deliveredDate,Object deliveredTime) {
		super();
		this.orderDeliveryId = (String) orderDeliveryId;
		this.orderShipmentId = (String) orderShipmentId;
		this.orderPackageId = (String) orderPackageId;
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.createdBy = (String) createdBy;
		this.customerName = (String) customerName;
		this.orderStatus = (String) orderStatus;
		this.createdOn = (String) createdOn;
		this.quantity = (String) quantity;
		this.subTotal = (String) subTotal;
		this.totalCgst = (String) totalCgst;
		this.totalSgst = (String) totalSgst;
		this.totalIgst = (String) totalIgst;
		this.paymentMode = (String) paymentMode;
		this.grandTotal = (String) grandTotal;
		
		this.customerEmail = (String) customerEmail;
		this.customerMobile = (String) customerMobile;
		this.custShipppingAddress = (String) custShipppingAddress;
		
		
		this.deliveryPersonName = (String) deliveryPersonName;
		this.deliveryPersonContact = (String) deliveryPersonContact;
		this.deliveryPersonEmail = (String) deliveryPersonEmail;
		this.dispatchDate = (String) dispatchDate;
		this.dispatchTime = (String) dispatchTime;
		this.deliveryPersonVehicle = (String) deliveryPersonVehicle;
		this.deliveredDate = (String) deliveredDate;
		this.deliveredTime = (String) deliveredTime;
	}
	
	public POSPackagingRestModel(Object custOrderId, Object customerId, Object customerName, Object orderStatus,
			Object createdOn, Object quantity, Object grandTotal, Object customerEmail, Object customerMobile,
			Object deliveryPersonName, Object deliveryPersonContact, Object deliveredDate, Object deliveredTime) {
		super();
		this.custOrderId = (String) custOrderId;
		this.customerId = (String) customerId;
		this.customerName = (String) customerName;
		this.orderStatus = (String) orderStatus;
		this.createdOn = (String) createdOn;
		this.quantity = (String) quantity;
		this.grandTotal = (String) grandTotal;
		this.customerEmail = (String) customerEmail;
		this.customerMobile = (String) customerMobile;
		this.deliveryPersonName = (String) deliveryPersonName;
		this.deliveryPersonContact = (String) deliveryPersonContact;
		this.deliveredDate = (String) deliveredDate;
		this.deliveredTime = (String) deliveredTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getOrderDeliveryId() {
		return orderDeliveryId;
	}

	public void setOrderDeliveryId(String orderDeliveryId) {
		this.orderDeliveryId = orderDeliveryId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getOrderPackageId() {
		return orderPackageId;
	}

	public void setOrderPackageId(String orderPackageId) {
		this.orderPackageId = orderPackageId;
	}

	public String getCustOrderId() {
		return custOrderId;
	}

	public void setCustOrderId(String custOrderId) {
		this.custOrderId = custOrderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<POSProductDetailsRestModel> getPrdctDtls() {
		return prdctDtls;
	}

	public void setPrdctDtls(List<POSProductDetailsRestModel> prdctDtls) {
		this.prdctDtls = prdctDtls;
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

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getOrderShipmentId() {
		return orderShipmentId;
	}

	public void setOrderShipmentId(String orderShipmentId) {
		this.orderShipmentId = orderShipmentId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustShipppingAddress() {
		return custShipppingAddress;
	}

	public void setCustShipppingAddress(String custShipppingAddress) {
		this.custShipppingAddress = custShipppingAddress;
	}

	public String getDeliveryPersonName() {
		return deliveryPersonName;
	}

	public void setDeliveryPersonName(String deliveryPersonName) {
		this.deliveryPersonName = deliveryPersonName;
	}

	public String getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getDispatchTime() {
		return dispatchTime;
	}

	public void setDispatchTime(String dispatchTime) {
		this.dispatchTime = dispatchTime;
	}

	public String getDeliveryPersonContact() {
		return deliveryPersonContact;
	}

	public void setDeliveryPersonContact(String deliveryPersonContact) {
		this.deliveryPersonContact = deliveryPersonContact;
	}

	public String getDeliveryPersonEmail() {
		return deliveryPersonEmail;
	}

	public void setDeliveryPersonEmail(String deliveryPersonEmail) {
		this.deliveryPersonEmail = deliveryPersonEmail;
	}

	public String getDeliveryPersonVehicle() {
		return deliveryPersonVehicle;
	}

	public void setDeliveryPersonVehicle(String deliveryPersonVehicle) {
		this.deliveryPersonVehicle = deliveryPersonVehicle;
	}

	public String getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(String deliveredTime) {
		this.deliveredTime = deliveredTime;
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
