package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbrusementPaymentModel {
	private String paymentId;
	private String paymentMode;
	private String bankName;
	private String branchName;
	private String accNo;
	private Double total;
	private Double amtPaid;
	private Double advRequired;
	private String transactionDate;
	private String chequeNo;
	private String transactionNo;
	private String reqId;
	private String reqName;
	private String empId;
	private String amount;
	private String createdBy;
	
	private String organization;
	private String orgDivision;
	public ReimbrusementPaymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbrusementPaymentModel(String paymentId, String paymentMode, String bankName, String branchName,
			String accNo, Double total ,Double amtPaid ,Double advRequired,  String transactionDate,
			String chequeNo, String transactionNo, String createdBy) {
		super();
		this.paymentId = (String)paymentId;
		this.paymentMode = (String)paymentMode;
		this.bankName = (String)bankName;
		this.branchName = (String)branchName;
		this.accNo = (String)accNo;
		this.total = total;
		this.amtPaid = amtPaid;
		this.advRequired = advRequired;
		this.transactionDate = (String)transactionDate;
		this.chequeNo = (String)chequeNo;
		this.transactionNo = (String)transactionNo;
		this.createdBy = (String)createdBy;
	}
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getReqName() {
		return reqName;
	}
	public void setReqName(String reqName) {
		this.reqName = reqName;
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
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getAmtPaid() {
		return amtPaid;
	}
	public void setAmtPaid(Double amtPaid) {
		this.amtPaid = amtPaid;
	}
	public Double getAdvRequired() {
		return advRequired;
	}
	public void setAdvRequired(Double advRequired) {
		this.advRequired = advRequired;
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
