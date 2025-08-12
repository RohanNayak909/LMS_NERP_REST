package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestProcurementMasterModel {

	///////////// MEASUREMENT/////////////////////////////////

	private String measurementId;
	private String measurementName;
	private String measurementOrder;
	private String measurementCode;
	private String measurementDesc;
	private String measurementStatus;
	private String measurementCreatedOn;
	private String measurementCreatedBy;
	private String measurementUpdatedOn;
	private String measurementUpdatedBy;

////////Requisition Type////////

	private String requisitionId;
	private String requisitionName;
	private String requisitionDesc;
	private String requisitionStatus;
	private String requisitionCreatedOn;
	private String requisitionCreatedBy;
	private String requisitionUpdatedOn;
	private String requisitionUpdatedBy;

////////Requisition Priority Type////////

	private String requiPriorityId;
	private String requiPriorityName;
	private String requiPriorityDesc;
	private String requiPriorityStatus;
	private String requiPriorityCreatedOn;
	private String requiPriorityCreatedBy;
	private String requiPriorityUpdatedOn;
	private String requiPriorityUpdatedBy;

////////Payment Term Type////////

	private String paymentTermId;
	private String paymentTermName;
	private String paymentTermDesc;
	private String paymentTermStatus;
	private String paymentTermCreatedOn;
	private String paymentTermCreatedBy;
	private String paymentTermUpdatedOn;
	private String paymentTermUpdatedBy;

////////Legal Term Type////////

	private String legalTermId;
	private String legalTermName;
	private String legalTermDesc;
	private String legalTermStatus;
	private String legalTermCreatedOn;
	private String legalTermCreatedBy;
	private String legalTermUpdatedOn;
	private String legalTermUpdatedBy;

////////Payment Status Type////////

	private String paymentStatusId;
	private String paymentStatusName;
	private String paymentStatusDesc;
	private String paymentStatusStatus;
	private String paymentStatusCreatedOn;
	private String paymentStatusCreatedBy;
	private String paymentStatusUpdatedOn;
	private String paymentStatusUpdatedBy;

///////Delivery Method Type////////

	private String deliveryMethodId;
	private String deliveryMethodName;
	private String deliveryMethodDesc;
	private String deliveryMethodStatus;
	private String deliveryMethodCreatedOn;
	private String deliveryMethodCreatedBy;
	private String deliveryMethodUpdatedOn;
	private String deliveryMethodUpdatedBy;
	
	private String org;
	private String orgDiv;

	public RestProcurementMasterModel(Object measurementId, Object measurementName, Object measurementOrder,
			Object measurementCode, Object measurementDesc, Object measurementStatus, Object measurementCreatedOn,
			Object measurementCreatedBy, Object measurementUpdatedOn, Object measurementUpdatedBy, Object requisitionId,
			Object requisitionName, Object requisitionDesc, Object requisitionStatus, Object requisitionCreatedOn,
			Object requisitionCreatedBy, Object requisitionUpdatedOn, Object requisitionUpdatedBy,
			Object requiPriorityId, Object requiPriorityName, Object requiPriorityDesc, Object requiPriorityStatus,
			Object requiPriorityCreatedOn, Object requiPriorityCreatedBy, Object requiPriorityUpdatedOn,
			Object requiPriorityUpdatedBy, Object paymentTermId, Object paymentTermName, Object paymentTermDesc,
			Object paymentTermStatus, Object paymentTermCreatedOn, Object paymentTermCreatedBy,
			Object paymentTermUpdatedOn, Object paymentTermUpdatedBy, Object legalTermId, Object legalTermName,
			Object legalTermDesc, Object legalTermStatus, Object legalTermCreatedOn, Object legalTermCreatedBy,
			Object legalTermUpdatedOn, Object legalTermUpdatedBy, Object paymentStatusId, Object paymentStatusName,
			Object paymentStatusDesc, Object paymentStatusStatus, Object paymentStatusCreatedOn,
			Object paymentStatusCreatedBy, Object paymentStatusUpdatedOn, Object paymentStatusUpdatedBy,
			Object deliveryMethodId, Object deliveryMethodName, Object deliveryMethodDesc, Object deliveryMethodStatus,
			Object deliveryMethodCreatedOn,Object deliveryMethodCreatedBy,Object deliveryMethodUpdatedOn,Object deliveryMethodUpdatedBy) {
		super();

		this.measurementId = (String) measurementId;
		this.measurementName = (String) measurementName;
		this.measurementOrder = (String) measurementOrder;
		this.measurementCode = (String) measurementCode;
		this.measurementDesc = (String) measurementDesc;
		this.measurementStatus = (String) measurementStatus;
		this.measurementCreatedOn = (String) measurementCreatedOn;
		this.measurementCreatedBy = (String) measurementCreatedBy;
		this.measurementUpdatedOn = (String) measurementUpdatedOn;
		this.measurementUpdatedBy = (String) measurementUpdatedBy;

		this.requisitionId = (String) requisitionId;
		this.requisitionName = (String) requisitionName;
		this.requisitionDesc = (String) requisitionDesc;
		this.requisitionStatus = (String) requisitionStatus;
		this.requisitionCreatedOn = (String) requisitionCreatedOn;
		this.requisitionCreatedBy = (String) requisitionCreatedBy;
		this.requisitionUpdatedOn = (String) requisitionUpdatedOn;
		this.requisitionUpdatedBy = (String) requisitionUpdatedBy;

		this.requiPriorityId = (String) requiPriorityId;
		this.requiPriorityName = (String) requiPriorityName;
		this.requiPriorityDesc = (String) requiPriorityDesc;
		this.requiPriorityStatus = (String) requiPriorityStatus;
		this.requiPriorityCreatedOn = (String) requiPriorityCreatedOn;
		this.requiPriorityCreatedBy = (String) requiPriorityCreatedBy;
		this.requiPriorityUpdatedOn = (String) requiPriorityUpdatedOn;
		this.requiPriorityUpdatedBy = (String) requiPriorityUpdatedBy;

		this.paymentTermId = (String) paymentTermId;
		this.paymentTermName = (String) paymentTermName;
		this.paymentTermDesc = (String) paymentTermDesc;
		this.paymentTermStatus = (String) paymentTermStatus;
		this.paymentTermCreatedOn = (String) paymentTermCreatedOn;
		this.paymentTermCreatedBy = (String) paymentTermCreatedBy;
		this.paymentTermUpdatedOn = (String) paymentTermUpdatedOn;
		this.requiPriorityUpdatedBy = (String) requiPriorityUpdatedBy;

		this.legalTermId = (String) legalTermId;
		this.legalTermName = (String) legalTermName;
		this.legalTermDesc = (String) legalTermDesc;
		this.legalTermStatus = (String) legalTermStatus;
		this.legalTermCreatedOn = (String) legalTermCreatedOn;
		this.legalTermCreatedBy = (String) legalTermCreatedBy;
		this.legalTermUpdatedOn = (String) legalTermUpdatedOn;
		this.legalTermUpdatedBy = (String) legalTermUpdatedBy;

		this.paymentStatusId = (String) paymentStatusId;
		this.paymentStatusName = (String) paymentStatusName;
		this.paymentStatusDesc = (String) paymentStatusDesc;
		this.paymentStatusStatus = (String) paymentStatusStatus;
		this.paymentStatusCreatedOn = (String) paymentStatusCreatedOn;
		this.paymentStatusCreatedBy = (String) paymentStatusCreatedBy;
		this.paymentStatusUpdatedOn = (String) paymentStatusUpdatedOn;
		this.paymentStatusUpdatedBy = (String) paymentStatusUpdatedBy;

		
		this.deliveryMethodId = (String) deliveryMethodId;
		this.deliveryMethodName = (String) deliveryMethodName;
		this.deliveryMethodDesc = (String) deliveryMethodDesc;
		this.deliveryMethodStatus = (String) deliveryMethodStatus;
		this.deliveryMethodCreatedOn = (String) deliveryMethodCreatedOn;
		this.deliveryMethodCreatedBy = (String) deliveryMethodCreatedBy;
		this.deliveryMethodUpdatedOn = (String) deliveryMethodUpdatedOn;
		this.deliveryMethodUpdatedBy = (String) deliveryMethodUpdatedBy;

	}

	public String getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(String measurementId) {
		this.measurementId = measurementId;
	}

	public String getMeasurementName() {
		return measurementName;
	}

	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

	public String getMeasurementOrder() {
		return measurementOrder;
	}

	public void setMeasurementOrder(String measurementOrder) {
		this.measurementOrder = measurementOrder;
	}

	public String getMeasurementCode() {
		return measurementCode;
	}

	public void setMeasurementCode(String measurementCode) {
		this.measurementCode = measurementCode;
	}

	public String getMeasurementDesc() {
		return measurementDesc;
	}

	public void setMeasurementDesc(String measurementDesc) {
		this.measurementDesc = measurementDesc;
	}

	public String getMeasurementStatus() {
		return measurementStatus;
	}

	public void setMeasurementStatus(String measurementStatus) {
		this.measurementStatus = measurementStatus;
	}

	public String getMeasurementCreatedOn() {
		return measurementCreatedOn;
	}

	public void setMeasurementCreatedOn(String measurementCreatedOn) {
		this.measurementCreatedOn = measurementCreatedOn;
	}

	public String getMeasurementCreatedBy() {
		return measurementCreatedBy;
	}

	public void setMeasurementCreatedBy(String measurementCreatedBy) {
		this.measurementCreatedBy = measurementCreatedBy;
	}

	public String getMeasurementUpdatedOn() {
		return measurementUpdatedOn;
	}

	public void setMeasurementUpdatedOn(String measurementUpdatedOn) {
		this.measurementUpdatedOn = measurementUpdatedOn;
	}

	public String getMeasurementUpdatedBy() {
		return measurementUpdatedBy;
	}

	public void setMeasurementUpdatedBy(String measurementUpdatedBy) {
		this.measurementUpdatedBy = measurementUpdatedBy;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getRequisitionName() {
		return requisitionName;
	}

	public void setRequisitionName(String requisitionName) {
		this.requisitionName = requisitionName;
	}

	public String getRequisitionDesc() {
		return requisitionDesc;
	}

	public void setRequisitionDesc(String requisitionDesc) {
		this.requisitionDesc = requisitionDesc;
	}

	public String getRequisitionStatus() {
		return requisitionStatus;
	}

	public void setRequisitionStatus(String requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	public String getRequisitionCreatedOn() {
		return requisitionCreatedOn;
	}

	public void setRequisitionCreatedOn(String requisitionCreatedOn) {
		this.requisitionCreatedOn = requisitionCreatedOn;
	}

	public String getRequisitionCreatedBy() {
		return requisitionCreatedBy;
	}

	public void setRequisitionCreatedBy(String requisitionCreatedBy) {
		this.requisitionCreatedBy = requisitionCreatedBy;
	}

	public String getRequisitionUpdatedOn() {
		return requisitionUpdatedOn;
	}

	public void setRequisitionUpdatedOn(String requisitionUpdatedOn) {
		this.requisitionUpdatedOn = requisitionUpdatedOn;
	}

	public String getRequisitionUpdatedBy() {
		return requisitionUpdatedBy;
	}

	public void setRequisitionUpdatedBy(String requisitionUpdatedBy) {
		this.requisitionUpdatedBy = requisitionUpdatedBy;
	}

	public String getRequiPriorityId() {
		return requiPriorityId;
	}

	public void setRequiPriorityId(String requiPriorityId) {
		this.requiPriorityId = requiPriorityId;
	}

	public String getRequiPriorityName() {
		return requiPriorityName;
	}

	public void setRequiPriorityName(String requiPriorityName) {
		this.requiPriorityName = requiPriorityName;
	}

	public String getRequiPriorityDesc() {
		return requiPriorityDesc;
	}

	public void setRequiPriorityDesc(String requiPriorityDesc) {
		this.requiPriorityDesc = requiPriorityDesc;
	}

	public String getRequiPriorityStatus() {
		return requiPriorityStatus;
	}

	public void setRequiPriorityStatus(String requiPriorityStatus) {
		this.requiPriorityStatus = requiPriorityStatus;
	}

	public String getRequiPriorityCreatedOn() {
		return requiPriorityCreatedOn;
	}

	public void setRequiPriorityCreatedOn(String requiPriorityCreatedOn) {
		this.requiPriorityCreatedOn = requiPriorityCreatedOn;
	}

	public String getRequiPriorityCreatedBy() {
		return requiPriorityCreatedBy;
	}

	public void setRequiPriorityCreatedBy(String requiPriorityCreatedBy) {
		this.requiPriorityCreatedBy = requiPriorityCreatedBy;
	}

	public String getRequiPriorityUpdatedOn() {
		return requiPriorityUpdatedOn;
	}

	public void setRequiPriorityUpdatedOn(String requiPriorityUpdatedOn) {
		this.requiPriorityUpdatedOn = requiPriorityUpdatedOn;
	}

	public String getRequiPriorityUpdatedBy() {
		return requiPriorityUpdatedBy;
	}

	public void setRequiPriorityUpdatedBy(String requiPriorityUpdatedBy) {
		this.requiPriorityUpdatedBy = requiPriorityUpdatedBy;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPaymentTermName() {
		return paymentTermName;
	}

	public void setPaymentTermName(String paymentTermName) {
		this.paymentTermName = paymentTermName;
	}

	public String getPaymentTermDesc() {
		return paymentTermDesc;
	}

	public void setPaymentTermDesc(String paymentTermDesc) {
		this.paymentTermDesc = paymentTermDesc;
	}

	public String getPaymentTermStatus() {
		return paymentTermStatus;
	}

	public void setPaymentTermStatus(String paymentTermStatus) {
		this.paymentTermStatus = paymentTermStatus;
	}

	public String getPaymentTermCreatedOn() {
		return paymentTermCreatedOn;
	}

	public void setPaymentTermCreatedOn(String paymentTermCreatedOn) {
		this.paymentTermCreatedOn = paymentTermCreatedOn;
	}

	public String getPaymentTermCreatedBy() {
		return paymentTermCreatedBy;
	}

	public void setPaymentTermCreatedBy(String paymentTermCreatedBy) {
		this.paymentTermCreatedBy = paymentTermCreatedBy;
	}

	public String getPaymentTermUpdatedOn() {
		return paymentTermUpdatedOn;
	}

	public void setPaymentTermUpdatedOn(String paymentTermUpdatedOn) {
		this.paymentTermUpdatedOn = paymentTermUpdatedOn;
	}

	public String getPaymentTermUpdatedBy() {
		return paymentTermUpdatedBy;
	}

	public void setPaymentTermUpdatedBy(String paymentTermUpdatedBy) {
		this.paymentTermUpdatedBy = paymentTermUpdatedBy;
	}

	public String getLegalTermId() {
		return legalTermId;
	}

	public void setLegalTermId(String legalTermId) {
		this.legalTermId = legalTermId;
	}

	public String getLegalTermName() {
		return legalTermName;
	}

	public void setLegalTermName(String legalTermName) {
		this.legalTermName = legalTermName;
	}

	public String getLegalTermDesc() {
		return legalTermDesc;
	}

	public void setLegalTermDesc(String legalTermDesc) {
		this.legalTermDesc = legalTermDesc;
	}

	public String getLegalTermStatus() {
		return legalTermStatus;
	}

	public void setLegalTermStatus(String legalTermStatus) {
		this.legalTermStatus = legalTermStatus;
	}

	public String getLegalTermCreatedOn() {
		return legalTermCreatedOn;
	}

	public void setLegalTermCreatedOn(String legalTermCreatedOn) {
		this.legalTermCreatedOn = legalTermCreatedOn;
	}

	public String getLegalTermCreatedBy() {
		return legalTermCreatedBy;
	}

	public void setLegalTermCreatedBy(String legalTermCreatedBy) {
		this.legalTermCreatedBy = legalTermCreatedBy;
	}

	public String getLegalTermUpdatedOn() {
		return legalTermUpdatedOn;
	}

	public void setLegalTermUpdatedOn(String legalTermUpdatedOn) {
		this.legalTermUpdatedOn = legalTermUpdatedOn;
	}

	public String getLegalTermUpdatedBy() {
		return legalTermUpdatedBy;
	}

	public void setLegalTermUpdatedBy(String legalTermUpdatedBy) {
		this.legalTermUpdatedBy = legalTermUpdatedBy;
	}

	public String getPaymentStatusId() {
		return paymentStatusId;
	}

	public void setPaymentStatusId(String paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}

	public String getPaymentStatusName() {
		return paymentStatusName;
	}

	public void setPaymentStatusName(String paymentStatusName) {
		this.paymentStatusName = paymentStatusName;
	}

	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}

	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}

	public String getPaymentStatusStatus() {
		return paymentStatusStatus;
	}

	public void setPaymentStatusStatus(String paymentStatusStatus) {
		this.paymentStatusStatus = paymentStatusStatus;
	}

	public String getPaymentStatusCreatedOn() {
		return paymentStatusCreatedOn;
	}

	public void setPaymentStatusCreatedOn(String paymentStatusCreatedOn) {
		this.paymentStatusCreatedOn = paymentStatusCreatedOn;
	}

	public String getPaymentStatusCreatedBy() {
		return paymentStatusCreatedBy;
	}

	public void setPaymentStatusCreatedBy(String paymentStatusCreatedBy) {
		this.paymentStatusCreatedBy = paymentStatusCreatedBy;
	}

	public String getPaymentStatusUpdatedOn() {
		return paymentStatusUpdatedOn;
	}

	public void setPaymentStatusUpdatedOn(String paymentStatusUpdatedOn) {
		this.paymentStatusUpdatedOn = paymentStatusUpdatedOn;
	}

	public String getPaymentStatusUpdatedBy() {
		return paymentStatusUpdatedBy;
	}

	public void setPaymentStatusUpdatedBy(String paymentStatusUpdatedBy) {
		this.paymentStatusUpdatedBy = paymentStatusUpdatedBy;
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

	public String getDeliveryMethodDesc() {
		return deliveryMethodDesc;
	}

	public void setDeliveryMethodDesc(String deliveryMethodDesc) {
		this.deliveryMethodDesc = deliveryMethodDesc;
	}

	public String getDeliveryMethodStatus() {
		return deliveryMethodStatus;
	}

	public void setDeliveryMethodStatus(String deliveryMethodStatus) {
		this.deliveryMethodStatus = deliveryMethodStatus;
	}

	public String getDeliveryMethodCreatedOn() {
		return deliveryMethodCreatedOn;
	}

	public void setDeliveryMethodCreatedOn(String deliveryMethodCreatedOn) {
		this.deliveryMethodCreatedOn = deliveryMethodCreatedOn;
	}

	public String getDeliveryMethodCreatedBy() {
		return deliveryMethodCreatedBy;
	}

	public void setDeliveryMethodCreatedBy(String deliveryMethodCreatedBy) {
		this.deliveryMethodCreatedBy = deliveryMethodCreatedBy;
	}

	public String getDeliveryMethodUpdatedOn() {
		return deliveryMethodUpdatedOn;
	}

	public void setDeliveryMethodUpdatedOn(String deliveryMethodUpdatedOn) {
		this.deliveryMethodUpdatedOn = deliveryMethodUpdatedOn;
	}

	public String getDeliveryMethodUpdatedBy() {
		return deliveryMethodUpdatedBy;
	}

	public void setDeliveryMethodUpdatedBy(String deliveryMethodUpdatedBy) {
		this.deliveryMethodUpdatedBy = deliveryMethodUpdatedBy;
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
