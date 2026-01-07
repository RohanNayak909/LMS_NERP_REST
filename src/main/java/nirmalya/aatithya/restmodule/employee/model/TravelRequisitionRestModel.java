package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class TravelRequisitionRestModel {

	private String travelingReqId;
	private String employeeId;
	private String employeeName;
	private String placeName;
	private String purpose;
	private String advanceReq;
	private String advanceAmount;
	private String amountPaid;
	private String status;
	private String fromDate;
	private String toDate;
	private String approvedDate;
	private String approvedBy;
	private String rejectDate;
	private String rejectedBy;
	private String approveComment;
	private String organization;
	private String orgDivision;
	
	
	//private String serviceId;
	//private String serviceName;
	//private String date;
	//private String time;
	private String fromPlace;
	private String toPlace;
	//private String description;
	private String createdBy;
	private String createdOn;
	private String updatedon;
	private String updatedBy;
	
	private String empName;
	private String empId;
	private String designation;
	private String travelFrom;
	private String remark;
	private String createdById;
	private String purposeName;
	private String claimStatus;
	//private String todate;
	//private String totime;
	private List<TravelServiceRestModel> servicedtls;
	
	
	
	
	
	public TravelRequisitionRestModel(Object travelingReqId, Object employeeId, Object placeName, Object purpose,
			Object advanceReq, Object advanceAmount, Object status, Object fromDate, Object toDate,
			Object approvedBy, Object rejectedBy, Object approveComment,Object createdOn,Object employeeName,Object createdBy,
			Object createdById,Object claimStatus) {

		super();

		this.travelingReqId = (String) travelingReqId;
		this.employeeId = (String) employeeId;
		this.placeName = (String) placeName;
		this.purpose = (String) purpose;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (String) advanceAmount;
		this.status = (String) status;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;

		this.approvedBy = (String) approvedBy;
		this.rejectedBy = (String) rejectedBy;
		this.approveComment = (String) approveComment;
		this.createdOn = (String) createdOn;
		this.employeeName = (String) employeeName;
		this.createdBy = (String) createdBy;
		this.createdById = (String) createdById;
		this.claimStatus = (String) claimStatus;
		
		
	}
	
	public TravelRequisitionRestModel(Object travelingReqId,Object placeName,Object purpose,Object advanceReq,Object advanceAmount
			,Object fromDate,Object toDate,Object empName,Object empId,Object designation,Object travelFrom,
			Object remark,Object createdById,Object employeeName,Object purposeName) {
	 
		this.travelingReqId = (String) travelingReqId;
		this.placeName = (String) placeName;
		this.purpose = (String) purpose;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (String) advanceAmount;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.empName = (String) empName;
		
		this.empId = (String) empId;
		this.designation = (String) designation;
		this.travelFrom = (String) travelFrom;
		this.remark = (String) remark;
		this.createdById = (String) createdById;
		this.employeeName = (String) employeeName;
		this.purposeName = (String) purposeName;
		
		
		
	}
	
	public TravelRequisitionRestModel(Object travelingReqId, Object employeeId, Object placeName, Object purpose,
			Object advanceReq, Object advanceAmount, Object status, Object fromDate, Object toDate,
			 Object createdBy,Object createdOn, Object updatedon, Object updatedBy,Object empName,Object empId,Object designation,
			Object travelFrom,Object remark,Object createdById,Object employeeName,Object purposeName) {

		super();

		this.travelingReqId = (String) travelingReqId;
		this.employeeId = (String) employeeId;//
		this.placeName = (String) placeName;
		this.purpose = (String) purpose;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (String) advanceAmount;
		this.status = (String) status;//
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;

	//	this.serviceId = (String) serviceId;
		//this.serviceName = (String) serviceName;
		//this.date = (String) date;
		//this.time = (String) time;
		//this.description = (String) description;
		this.toPlace = (String) toPlace;

		this.createdBy = (String) createdBy;//
		this.createdOn = (String) createdOn;//
		this.updatedon = (String) updatedon;//
		this.updatedBy = (String) updatedBy;//
		
		this.empName = (String) empName;
		this.empId = (String) empId;
		this.designation = (String) designation;
		this.travelFrom = (String) travelFrom;
		this.remark = (String) remark;
		this.createdById = (String) createdById;
		this.employeeName = (String) employeeName;
		this.purposeName = (String) purposeName;

	}
	//
//	public TravelRequisitionRestModel(Object serviceId, Object serviceName, Object date,Object time, Object description) {
//
//		super();
//		this.serviceId = (String) serviceId;
//		this.serviceName = (String) serviceName;
//		this.date = (String) date;
//		this.time = (String) time;
//		this.description = (String) description;
//		//this.toPlace = (String) toPlace;
//
//	}

	

	public TravelRequisitionRestModel() {
		// TODO Auto-generated constructor stub
	}

	public String getTravelingReqId() {
		return travelingReqId;
	}

	public void setTravelingReqId(String travelingReqId) {
		this.travelingReqId = travelingReqId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getAdvanceReq() {
		return advanceReq;
	}

	public void setAdvanceReq(String advanceReq) {
		this.advanceReq = advanceReq;
	}

	public String getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
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

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(String rejectDate) {
		this.rejectDate = rejectDate;
	}

	public String getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public String getApproveComment() {
		return approveComment;
	}

	public void setApproveComment(String approveComment) {
		this.approveComment = approveComment;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTravelFrom() {
		return travelFrom;
	}

	public void setTravelFrom(String travelFrom) {
		this.travelFrom = travelFrom;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public String getPurposeName() {
		return purposeName;
	}

	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}
	
	

	public List<TravelServiceRestModel> getServicedtls() {
		return servicedtls;
	}

	public void setServicedtls(List<TravelServiceRestModel> servicedtls) {
		this.servicedtls = servicedtls;
	}
	
	

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	//
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
