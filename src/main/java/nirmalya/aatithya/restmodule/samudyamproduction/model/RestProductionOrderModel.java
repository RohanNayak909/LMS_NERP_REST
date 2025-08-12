package nirmalya.aatithya.restmodule.samudyamproduction.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
public class RestProductionOrderModel {
	private String salesOrder;
	private String custId;
	private String custName;
	private String orderReceiveDate;
	private String expectedShipmentDate;
	private String schedulingId;
	private String schedulingDate;
	private String schedulingStatus;
	private String orderStatus;
	private String organization;
	private String orgDivision;
	private String orderCreatedBy;
	List<RestProductionOrderItemModel> itemList;
	List<InventoryVendorDocumentModel> documentList;
	
	public RestProductionOrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestProductionOrderModel(Object salesOrder, Object custId, Object custName, Object orderReceiveDate, Object expectedShipmentDate, Object schedulingId,
			Object schedulingDate, Object schedulingStatus) {
		super();

		this.salesOrder = (String) salesOrder;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.orderReceiveDate = (String) orderReceiveDate;
		this.expectedShipmentDate = (String) expectedShipmentDate;
		this.schedulingId = (String) schedulingId;
		this.schedulingDate = (String) schedulingDate;
		this.schedulingStatus = (String) schedulingStatus;
	}
	public String getSalesOrder() {
		return salesOrder;
	}
	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
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
	public String getOrderReceiveDate() {
		return orderReceiveDate;
	}
	public void setOrderReceiveDate(String orderReceiveDate) {
		this.orderReceiveDate = orderReceiveDate;
	}
	public String getExpectedShipmentDate() {
		return expectedShipmentDate;
	}
	public void setExpectedShipmentDate(String expectedShipmentDate) {
		this.expectedShipmentDate = expectedShipmentDate;
	}
	public String getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(String schedulingId) {
		this.schedulingId = schedulingId;
	}
	public String getSchedulingDate() {
		return schedulingDate;
	}
	public void setSchedulingDate(String schedulingDate) {
		this.schedulingDate = schedulingDate;
	}
	public String getSchedulingStatus() {
		return schedulingStatus;
	}
	public void setSchedulingStatus(String schedulingStatus) {
		this.schedulingStatus = schedulingStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
	public String getOrderCreatedBy() {
		return orderCreatedBy;
	}
	public void setOrderCreatedBy(String orderCreatedBy) {
		this.orderCreatedBy = orderCreatedBy;
	}
	public List<RestProductionOrderItemModel> getItemList() {
		return itemList;
	}
	public void setItemList(List<RestProductionOrderItemModel> itemList) {
		this.itemList = itemList;
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
