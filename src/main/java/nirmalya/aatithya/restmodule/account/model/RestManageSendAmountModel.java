package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestManageSendAmountModel {
	private String vendorId;
	private String paymentId;
	private String vendorGrnId;
	private String vendorGrnAmount;
	private String vendorGrnPendingAmount;
	private String vendorGrnBulkAmount;
	private String vendorBankName;
	private String vendorBankBranch;
	private String vendorAccountNumber;
	private String vendorTransactionNumber;
	private String vendorRemarks;
	private String vendorPayToggle;
	private String userId;
	private String createdBy;
	private String organization;
	private String orgDivision;
	private String payStatus;
	private String sentBy;
	private String sentTo;
	private String paymentDate;
	private String approvalStatus;
	private String approvedBy;
	
	public RestManageSendAmountModel() {
		super();
	}
	
	public RestManageSendAmountModel(Object paymentId, Object vendorGrnId, Object vendorId, Object vendorGrnAmount, Object payStatus, Object sentBy,
			Object sentTo, Object paymentDate, Object approvalStatus, Object approvedBy) {
		super();
		this.paymentId = (String) paymentId;
		this.vendorGrnId = (String) vendorGrnId;
		this.vendorId = (String) vendorId;
		this.vendorGrnAmount = (String) vendorGrnAmount;
		this.payStatus = (String) payStatus;
		this.sentBy = (String) sentBy;
		this.sentTo = (String) sentTo;
		this.paymentDate = (String) paymentDate;
		this.approvalStatus = (String) approvalStatus;
		this.approvedBy = (String) approvedBy;
	}
	
	public RestManageSendAmountModel(Object paymentId, Object vendorGrnId, Object vendorId, Object vendorGrnAmount, Object payStatus, Object sentBy,
			Object sentTo, Object vendorBankName, Object vendorBankBranch, Object vendorAccountNumber, Object vendorTransactionNumber, Object vendorRemarks) {
		super();
		this.paymentId = (String) paymentId;
		this.vendorGrnId = (String) vendorGrnId;
		this.vendorId = (String) vendorId;
		this.vendorGrnAmount = (String) vendorGrnAmount;
		this.payStatus = (String) payStatus;
		this.sentBy = (String) sentBy;
		this.sentTo = (String) sentTo;
		this.vendorBankName = (String) vendorBankName;
		this.vendorBankBranch = (String) vendorBankBranch;
		this.vendorAccountNumber = (String) vendorAccountNumber;
		this.vendorTransactionNumber = (String) vendorTransactionNumber;
		this.vendorRemarks = (String) vendorRemarks;
	}
	
	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getVendorGrnId() {
		return vendorGrnId;
	}

	public void setVendorGrnId(String vendorGrnId) {
		this.vendorGrnId = vendorGrnId;
	}

	public String getVendorGrnAmount() {
		return vendorGrnAmount;
	}

	public void setVendorGrnAmount(String vendorGrnAmount) {
		this.vendorGrnAmount = vendorGrnAmount;
	}

	public String getVendorGrnPendingAmount() {
		return vendorGrnPendingAmount;
	}

	public void setVendorGrnPendingAmount(String vendorGrnPendingAmount) {
		this.vendorGrnPendingAmount = vendorGrnPendingAmount;
	}

	public String getVendorGrnBulkAmount() {
		return vendorGrnBulkAmount;
	}

	public void setVendorGrnBulkAmount(String vendorGrnBulkAmount) {
		this.vendorGrnBulkAmount = vendorGrnBulkAmount;
	}

	public String getVendorBankName() {
		return vendorBankName;
	}

	public void setVendorBankName(String vendorBankName) {
		this.vendorBankName = vendorBankName;
	}

	public String getVendorBankBranch() {
		return vendorBankBranch;
	}

	public void setVendorBankBranch(String vendorBankBranch) {
		this.vendorBankBranch = vendorBankBranch;
	}

	public String getVendorAccountNumber() {
		return vendorAccountNumber;
	}

	public void setVendorAccountNumber(String vendorAccountNumber) {
		this.vendorAccountNumber = vendorAccountNumber;
	}

	public String getVendorTransactionNumber() {
		return vendorTransactionNumber;
	}

	public void setVendorTransactionNumber(String vendorTransactionNumber) {
		this.vendorTransactionNumber = vendorTransactionNumber;
	}

	public String getVendorRemarks() {
		return vendorRemarks;
	}

	public void setVendorRemarks(String vendorRemarks) {
		this.vendorRemarks = vendorRemarks;
	}

	public String getVendorPayToggle() {
		return vendorPayToggle;
	}

	public void setVendorPayToggle(String vendorPayToggle) {
		this.vendorPayToggle = vendorPayToggle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
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
