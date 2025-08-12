package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeliveryNoteModel {

	private String delNote;
	private String invDate;
	private String invNo;
	private String poId;
	private String poDate;
	private String dispatchDate;
	private String deliveryMethod;
	private String trackingNumber;
	private String estDeliveryDate;
	private Double outstandQty;
	private String status;
	private String createdBy;
	private String createdOn;
	private String itemId;
	private Double qty;
	private Double delQty;
	private String uom;
	private String location;
	private String sku;
	private List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
	private List<String> editDocList = new ArrayList<String>();
	private String submitDate;
	private String completeDate;
	
	private String moduleId;
	private String componentId;
	private String subComponentId;
	private String org;
	private String orgDiv;
	
	public DeliveryNoteModel() {
		super();
	}

	public DeliveryNoteModel(Object delNote, Object invDate, Object invNo, Object poId, Object poDate,
			Object dispatchDate, Object deliveryMethod, Object trackingNumber, Object estDeliveryDate,
			Object outstandQty, Object status, Object createdBy, Object createdOn, Object submitDate, Object completeDate) {
		super();
		this.delNote = (String) delNote;
		this.invDate = (String) invDate;
		this.invNo = (String) invNo;
		this.poId = (String) poId;
		this.poDate = (String) poDate;
		this.dispatchDate = (String) dispatchDate;
		this.deliveryMethod = (String) deliveryMethod;
		this.trackingNumber = (String) trackingNumber;
		this.estDeliveryDate = (String) estDeliveryDate;
		this.outstandQty = (Double) outstandQty;
		this.status = (String) status;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.submitDate = (String) submitDate;
		this.completeDate = (String) completeDate;
	}

	public String getDelNote() {
		return delNote;
	}

	public void setDelNote(String delNote) {
		this.delNote = delNote;
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

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getEstDeliveryDate() {
		return estDeliveryDate;
	}

	public void setEstDeliveryDate(String estDeliveryDate) {
		this.estDeliveryDate = estDeliveryDate;
	}

	public Double getOutstandQty() {
		return outstandQty;
	}

	public void setOutstandQty(Double outstandQty) {
		this.outstandQty = outstandQty;
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
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getDelQty() {
		return delQty;
	}

	public void setDelQty(Double delQty) {
		this.delQty = delQty;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<InventoryVendorDocumentModel> getDocList() {
		return docList;
	}

	public void setDocList(List<InventoryVendorDocumentModel> docList) {
		this.docList = docList;
	}

	public List<String> getEditDocList() {
		return editDocList;
	}

	public void setEditDocList(List<String> editDocList) {
		this.editDocList = editDocList;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
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

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getOrgDiv() {
		return orgDiv;
	}

	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
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
