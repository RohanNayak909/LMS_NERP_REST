package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

//import nirmalya.aathithya.webmodule.employee.model.ReimbursementDocumentModel;

public class ReimbursementModel {
	private String reqType;
	private String reqTypeName;
	private String applyDate;
	private String travellingPurpose;
	private String expenseDate1;
	private String descExpense;
	private String eAmount;
	private String docName1;
	private String referenceNo1;
	private String empID1;
	private MultipartFile mulFile;
	private String docType;
	private String extension;
	private String userid;
	private String filetype;
	private String organization;
	private String orgDivision;

	private String reimbursementReqId;
	private String slNo;
	private String empName;
	private String empId;
	private String requisitionId;
	private String placeName;
	private String fromDate;
	private String toDate;
	private String purpose;
	private String advanceReq;
	private String advanceAmount;
	private Double aamttPaid;
	private String approveStatus;
	private String approvedDate;
	private String approvedBy;
	private String rejectDate;
	private String rejectedBy;
	private String approveComment;

	private String reimTypeId;
	// private String reimTypeName;
	private String reimPolicyId;
	// private String reimPolicyName;
	private String expenseDate;
	private String expenseDesc;
	private Double expenseAmount;
	private String referenceNo;
	private String documentName;
	private String docName;
//	private List<ReimbursementDocumentModel> documentList;

	private String createdBy;
	private String createdOn;
	private String updatedBy;
	private String updatedOn;
	private String total;

	private String module;
	private String component;
	private String subcomponent;

	public ReimbursementModel(Object slNo, Object reimbursementReqId, Object requisitionId, Object empName,
			Object placeName, Object fromDate, Object toDate, Object purpose, String advanceReq, Object advanceAmount,
			Double aamttPaid, Object approveStatus, Object approvedDate, Object approvedBy, Object rejectDate,
			Object rejectedBy, Object approveComment, Object reimPolicyId, Object expenseDate, Object expenseDesc,

			Double expenseAmount, Object referenceNo, Object documentName, Object docName, Object createdBy,
			Object createdOn, Object updatedBy, Object updatedOn, Object total, Object module, Object component,
			Object subcomponent) {

		super();

		this.reimbursementReqId = (String) reimbursementReqId;
		this.requisitionId = (String) requisitionId;
		this.empName = (String) empName;
		this.placeName = (String) placeName;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.purpose = (String) purpose;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (String) advanceAmount;
		this.aamttPaid = aamttPaid;
		this.approveStatus = (String) approveStatus;
		this.approvedDate = (String) approvedDate;
		this.approvedBy = (String) approvedBy;
		this.rejectDate = (String) rejectDate;
		this.rejectedBy = (String) rejectedBy;
		this.approveComment = (String) approveComment;

		this.slNo = (String) slNo;
		this.reimTypeId = (String) reimTypeId;
		// this.reimTypeName = (String) reimTypeName;
		this.reimPolicyId = (String) reimPolicyId;
		// this.reimPolicyName = (String) reimPolicyName;
		this.expenseDate = (String) expenseDate;
		this.expenseDesc = (String) expenseDesc;
		this.expenseAmount = (Double) expenseAmount;
		this.referenceNo = (String) referenceNo;
		this.documentName = (String) documentName;
		this.docName = (String) docName;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.updatedBy = (String) updatedBy;
		this.updatedOn = (String) updatedOn;
		this.total = (String) total;
		this.module = (String) module;
		this.component = (String) component;
		this.subcomponent = (String) subcomponent;

	}

	/*
	 * private String reqType; private String applyDate; private String
	 * travellingPurpose; private String expenseDate1; private String descExpense;
	 * private String eAmount; private String docName1; private String referenceNo1;
	 */

	public ReimbursementModel(Object reimbursementReqId, Object reqType, Object applyDate, Object travellingPurpose,
			Object expenseDate1, Object descExpense, Object eAmount, Object referenceNo1, Object advanceReq,
			Object advanceAmount, Object createdBy, Object empID1, Object approveStatus, Object approvedBy,
			Object rejectedBy, Object approveComment,Object docName1,Object docName,Object reqTypeName) {

		super();

		this.reimbursementReqId = (String) reimbursementReqId;
		this.reqType = (String) reqType;
		this.applyDate = (String) applyDate;
		this.travellingPurpose = (String) travellingPurpose;
		this.expenseDate1 = (String) expenseDate1;
		this.descExpense = (String) descExpense;
		this.eAmount = (String) eAmount;
		this.referenceNo1 = (String) referenceNo1;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (String) advanceAmount;
		this.createdBy = (String) createdBy;
		this.empID1 = (String) empID1;
		this.approveStatus = (String) approveStatus;
		this.approvedBy = (String) approvedBy;
		this.rejectedBy = (String) rejectedBy;
		this.approveComment = (String) approveComment;
		this.docName1 = (String) docName1;
		this.docName = (String) docName;
		this.reqTypeName = (String) reqTypeName;
	}

	public ReimbursementModel(Object reimbursementReqId, Object reqType, Object applyDate, Object travellingPurpose,
			Object expenseDate1, Object descExpense, Object eAmount, Object referenceNo1, Object advanceReq,
			Object advanceAmount, Object createdBy, Object docName1,Object empId,Object empName) {

		super();

		this.reimbursementReqId = (String) reimbursementReqId;
		this.reqType = (String) reqType;
		this.applyDate = (String) applyDate;
		this.travellingPurpose = (String) travellingPurpose;
		this.expenseDate1 = (String) expenseDate1;
		this.descExpense = (String) descExpense;
		this.eAmount = (String) eAmount;
		this.referenceNo1 = (String) referenceNo1;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (String) advanceAmount;
		this.createdBy = (String) createdBy;
		this.docName1 = (String) docName1;
		this.empId = (String) empId;
		this.empName = (String) empName;

	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getReqTypeName() {
		return reqTypeName;
	}

	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	public String getEmpID1() {
		return empID1;
	}

	public void setEmpID1(String empID1) {
		this.empID1 = empID1;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getTravellingPurpose() {
		return travellingPurpose;
	}

	public void setTravellingPurpose(String travellingPurpose) {
		this.travellingPurpose = travellingPurpose;
	}

	public String getExpenseDate1() {
		return expenseDate1;
	}

	public void setExpenseDate1(String expenseDate1) {
		this.expenseDate1 = expenseDate1;
	}

	public String getDescExpense() {
		return descExpense;
	}

	public void setDescExpense(String descExpense) {
		this.descExpense = descExpense;
	}

	public MultipartFile getMulFile() {
		return mulFile;
	}

	public void setMulFile(MultipartFile mulFile) {
		this.mulFile = mulFile;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String geteAmount() {
		return eAmount;
	}

	public void seteAmount(String eAmount) {
		this.eAmount = eAmount;
	}

	public String getDocName1() {
		return docName1;
	}

	public void setDocName1(String docName1) {
		this.docName1 = docName1;
	}

	public String getReferenceNo1() {
		return referenceNo1;
	}

	public void setReferenceNo1(String referenceNo1) {
		this.referenceNo1 = referenceNo1;
	}

	public ReimbursementModel() {
		// TODO Auto-generated constructor stub
	}

	public String getReimbursementReqId() {
		return reimbursementReqId;
	}

	public void setReimbursementReqId(String reimbursementReqId) {
		this.reimbursementReqId = reimbursementReqId;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
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

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getSlNo() {
		return slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	public String getReimTypeId() {
		return reimTypeId;
	}

	public void setReimTypeId(String reimTypeId) {
		this.reimTypeId = reimTypeId;
	}

	/*
	 * public String getReimTypeName() { return reimTypeName; }
	 * 
	 * 
	 * 
	 * 
	 * public void setReimTypeName(String reimTypeName) { this.reimTypeName =
	 * reimTypeName; }
	 */

	public String getReimPolicyId() {
		return reimPolicyId;
	}

	public void setReimPolicyId(String reimPolicyId) {
		this.reimPolicyId = reimPolicyId;
	}

	/*
	 * public String getReimPolicyName() { return reimPolicyName; }
	 * 
	 * 
	 * 
	 * 
	 * public void setReimPolicyName(String reimPolicyName) { this.reimPolicyName =
	 * reimPolicyName; }
	 */

	public String getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getExpenseDesc() {
		return expenseDesc;
	}

	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}

	public Double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(Double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/*
	 * public List<ReimbursementDocumentModel> getDocumentList() { return
	 * documentList; }
	 * 
	 * 
	 * 
	 * 
	 * public void setDocumentList(List<ReimbursementDocumentModel> documentList) {
	 * this.documentList = documentList; }
	 */

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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getSubcomponent() {
		return subcomponent;
	}

	public void setSubcomponent(String subcomponent) {
		this.subcomponent = subcomponent;
	}

	public Double getAamttPaid() {
		return aamttPaid;
	}

	public void setAamttPaid(Double aamttPaid) {
		this.aamttPaid = aamttPaid;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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