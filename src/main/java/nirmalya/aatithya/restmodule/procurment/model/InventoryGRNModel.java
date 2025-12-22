package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryGRNModel {

	private String noteId;
	private String invDate;
	private String invNo;
	private String poId;
	private String poDate;
	private String dispatchDate;
	private String deliveryMethodId;
	private String deliveryMethodName;
	private String trackingNo;
	private String estDeliveryDate;
	private Double outStandQty;
	private String status;
	private String createdBy;
	private String createdOn;
	private String activeDate;
	private String completeDate;
	private String onholdDate;
	private String deliveryNote;
	private String moduleId;
	private String componentId;
	private String subComponentId;
	List<InventoryProductModel> productList;
	private List<InventoryVendorDocumentModel> documentList;

	private Double totalInvQty;
	private Double totalDnQty;
	private Double totalReceiveQty;
	private Double totalNotReceiveQty;
	private Double totalOutStandingQty;
	private String OrganizationName;
	private String OrganizationDivision;

	public InventoryGRNModel() {
		super();
	}

	public InventoryGRNModel(Object noteId, Object invDate, Object invNo, Object poId, Object poDate,
			Object dispatchDate, Object deliveryMethodId, Object deliveryMethodName, Object trackingNo,
			Object estDeliveryDate, Object outStandQty, Object status, Object createdBy, Object createdOn,
			Object activeDate, Object completeDate, Object onholdDate, Object deliveryNote, Object totalInvQty,
			Object totalDnQty, Object totalReceiveQty,Object organizationName, Object organizationDivision) {
		super();
		this.noteId = (String) noteId;
		this.invDate = (String) invDate;
		this.invNo = (String) invNo;
		this.poId = (String) poId;
		this.poDate = (String) poDate;
		this.dispatchDate = (String) dispatchDate;
		this.deliveryMethodId = (String) deliveryMethodId;
		this.deliveryMethodName = (String) deliveryMethodName;
		this.trackingNo = (String) trackingNo;
		this.estDeliveryDate = (String) estDeliveryDate;
		this.outStandQty = (Double) outStandQty;
		this.status = (String) status;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.activeDate = (String) activeDate;
		this.completeDate = (String) completeDate;
		this.onholdDate = (String) onholdDate;
		this.deliveryNote = (String) deliveryNote;
		this.totalInvQty = (Double) totalInvQty;
		this.totalDnQty = (Double) totalDnQty;
		this.totalReceiveQty = (Double) totalReceiveQty;
		this.OrganizationName = (String) organizationName;
		this.OrganizationDivision = (String) organizationDivision;
	}
	

	
	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public String getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getDeliveryMethodId() {
		return deliveryMethodId;
	}

	public void setDeliveryMethodId(String deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}

	public String getDeliveryMethodName() {
		return deliveryMethodName;
	}

	public void setDeliveryMethodName(String deliveryMethodName) {
		this.deliveryMethodName = deliveryMethodName;
	}

	public String getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}

	public String getEstDeliveryDate() {
		return estDeliveryDate;
	}

	public void setEstDeliveryDate(String estDeliveryDate) {
		this.estDeliveryDate = estDeliveryDate;
	}

	public Double getOutStandQty() {
		return outStandQty;
	}

	public void setOutStandQty(Double outStandQty) {
		this.outStandQty = outStandQty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public String getOnholdDate() {
		return onholdDate;
	}

	public void setOnholdDate(String onholdDate) {
		this.onholdDate = onholdDate;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getSubComponentId() {
		return subComponentId;
	}

	public void setSubComponentId(String subComponentId) {
		this.subComponentId = subComponentId;
	}

	public List<InventoryProductModel> getProductList() {
		return productList;
	}

	public void setProductList(List<InventoryProductModel> productList) {
		this.productList = productList;
	}

	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}

	public Double getTotalInvQty() {
		return totalInvQty;
	}

	public void setTotalInvQty(Double totalInvQty) {
		this.totalInvQty = totalInvQty;
	}

	public Double getTotalDnQty() {
		return totalDnQty;
	}

	public void setTotalDnQty(Double totalDnQty) {
		this.totalDnQty = totalDnQty;
	}

	public Double getTotalReceiveQty() {
		return totalReceiveQty;
	}

	public void setTotalReceiveQty(Double totalReceiveQty) {
		this.totalReceiveQty = totalReceiveQty;
	}

	public Double getTotalNotReceiveQty() {
		return totalNotReceiveQty;
	}

	public void setTotalNotReceiveQty(Double totalNotReceiveQty) {
		this.totalNotReceiveQty = totalNotReceiveQty;
	}

	public Double getTotalOutStandingQty() {
		return totalOutStandingQty;
	}

	public void setTotalOutStandingQty(Double totalOutStandingQty) {
		this.totalOutStandingQty = totalOutStandingQty;
	}
	

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public String getOrganizationDivision() {
		return OrganizationDivision;
	}

	public void setOrganizationDivision(String organizationDivision) {
		OrganizationDivision = organizationDivision;
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
