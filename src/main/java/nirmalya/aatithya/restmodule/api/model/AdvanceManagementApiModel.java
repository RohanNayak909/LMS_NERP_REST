package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AdvanceManagementApiModel {

	private String advanceId;
	private String empID;
	private String empName;
	private String advanceApplyDate;
	private String status;
	private String reqPolicyId;
	private String applydate;
	private String eligibility;
	private double loanamt;
	private double loanamtrange;
	private String ternure;
	private Double intrestRate;
	private String reason;
	private String createdBy;
	private String createdOn;
	private String approvedDate;
	private String approvedBy;
	private String rejectDate;
	private String rejectedBy;
	private String approveComment;
	private double emi;
	private double totalInterest;
	private String processStatus;
	
	public AdvanceManagementApiModel() {
		super();
	}
	public AdvanceManagementApiModel(Object advanceId,Object empID,Object ternure,Object intrestRate, Object loanamt, Object emi,
			 Object totalInterest,Object processStatus) {
		super();
		this.advanceId = (String) advanceId;
		this.empID = (String) empID;
		this.ternure = (String) ternure;
		this.intrestRate = (Double) intrestRate;
		this.loanamt = (Double) loanamt;
		this.emi = (Double) emi;
		this.totalInterest = (Double) totalInterest;
		this.processStatus = (String) processStatus;
	 
		}
	public AdvanceManagementApiModel(Object advanceId,Object reqPolicyId, Object empID, Object empName,Object loanamt, Object reason, Object advanceApplyDate,
			Object createdOn, Object status,Object approvedBy,Object rejectedBy,Object approveComment,Object approvedDate,Object processStatus) {
		super();
		this.advanceId = (String) advanceId;
		this.reqPolicyId = (String) reqPolicyId; 
		this.empID = (String) empID;
		this.empName = (String) empName;
		this.loanamt = (Double) loanamt;
		this.reason = (String) reason;
		this.advanceApplyDate = (String) advanceApplyDate;
		this.status = (String) status;
		this.createdOn = (String) createdOn;
		this.approvedBy = (String) approvedBy;
		this.rejectedBy = (String) rejectedBy;
		this.approveComment = (String) approveComment;
		this.approvedDate = (String) approvedDate;
		this.processStatus = (String) processStatus;
		}
	public AdvanceManagementApiModel(Object advanceId,Object reqPolicyId, Object empID, Object empName,Object loanamt, Object reason) {
		super();
		this.advanceId = (String) advanceId;
		this.reqPolicyId = (String) reqPolicyId; 
		this.empID = (String) empID;
		this.empName = (String) empName;
		this.loanamt = (Double) loanamt;
		this.reason = (String) reason;
		}
	public String getAdvanceId() {
		return advanceId;
	}

	public void setAdvanceId(String advanceId) {
		this.advanceId = advanceId;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAdvanceApplyDate() {
		return advanceApplyDate;
	}

	public void setAdvanceApplyDate(String advanceApplyDate) {
		this.advanceApplyDate = advanceApplyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReqPolicyId() {
		return reqPolicyId;
	}

	public void setReqPolicyId(String reqPolicyId) {
		this.reqPolicyId = reqPolicyId;
	}

	public String getApplydate() {
		return applydate;
	}

	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public double getLoanamt() {
		return loanamt;
	}

	public void setLoanamt(double loanamt) {
		this.loanamt = loanamt;
	}

	public double getLoanamtrange() {
		return loanamtrange;
	}

	public void setLoanamtrange(double loanamtrange) {
		this.loanamtrange = loanamtrange;
	}

	public String getTernure() {
		return ternure;
	}

	public void setTernure(String ternure) {
		this.ternure = ternure;
	}

	public Double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(Double intrestRate) {
		this.intrestRate = intrestRate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public double getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
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
