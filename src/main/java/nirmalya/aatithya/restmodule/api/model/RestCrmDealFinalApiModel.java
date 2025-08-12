package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmDealFinalApiModel {
	private String dealId;
	private String dealPlanId;
	private String lead; 
	private String leadName;
	private String clientMob;
	private String clientEmail;
	private String clientAddress;
	private String decisionMaker;
	private String decisionMakerName;
	private String dmEmail;
	private String dmPhone;
	private String sector;
	private String dealDate;
	private String dealStatus;
	private String dealCreatedBy;
	private String dealCreatedByName;
	private String orgName;
	private String orgDiv;
	
	private String paymentMode;
	private String bankName;
	private String bankBranch; 
	private String accountNo; 
	private String chqNo;
	private String chqdate;
	private String transactionNo;
	
	private String orderRecived;
	private String amount; 
	private String pcdCollected; 
	private String pcdAmount;
	private String pcdDate;
	private String docName;
	private MultipartFile mulFile;
	private String extension;
	public RestCrmDealFinalApiModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestCrmDealFinalApiModel(Object dealId, Object lead, Object leadName,Object decisionMaker ,Object decisionMakerName,
			Object sector,Object dealDate,Object dealCreatedBy,
			Object dealCreatedByName, Object dealStatus,Object amount,Object pcdAmount,Object pcdDate,
			Object paymentMode,Object bankName,Object bankBranch,Object accountNo,Object chqNo,Object chqdate,Object transactionNo) {
		super();
		this.dealId = (String)dealId;
		this.lead = (String)lead;
		this.leadName = (String)leadName;
		this.decisionMaker= (String)decisionMaker; 
		this.decisionMakerName = (String)decisionMakerName;
		this.sector = (String)sector;
		this.dealDate = (String)dealDate;
		this.dealCreatedBy = (String)dealCreatedBy;
		this.dealCreatedByName = (String)dealCreatedByName;
		this.dealStatus = (String)dealStatus;
		this.amount = (String)amount;
		this.pcdAmount = (String)pcdAmount;
		this.pcdDate = (String)pcdDate;
		this.paymentMode = (String)paymentMode;
		this.bankName = (String)bankName;
		this.bankBranch = (String)bankBranch;
		this.accountNo = (String)accountNo;
		this.chqNo = (String)chqNo;
		this.chqdate = (String)chqdate;
		this.transactionNo = (String)transactionNo;
	}
	public RestCrmDealFinalApiModel(Object dealId, Object lead, Object leadName,Object decisionMaker ,Object decisionMakerName,
			Object sector,Object dealDate,Object dealCreatedBy,
			Object dealCreatedByName, Object dealStatus,Object amount,
			Object pcdAmount,Object pcdDate,Object docName,Object clientMob,Object clientEmail,Object clientAddress,Object dmEmail,Object dmPhone) {
		super();
		this.dealId = (String)dealId;
		this.lead = (String)lead;
		this.leadName = (String)leadName;
		this.decisionMaker= (String)decisionMaker; 
		this.decisionMakerName = (String)decisionMakerName;
		this.sector = (String)sector;
		this.dealDate = (String)dealDate;
		this.dealCreatedBy = (String)dealCreatedBy;
		this.dealCreatedByName = (String)dealCreatedByName;
		this.dealStatus = (String)dealStatus;
		this.amount = (String)amount;
		this.pcdAmount = (String)pcdAmount;
		this.pcdDate = (String)pcdDate;
		this.docName = (String)docName;
		this.clientMob = (String)clientMob;
		this.clientEmail = (String)clientEmail;
		this.clientAddress = (String)clientAddress;
		this.dmEmail = (String)dmEmail;
		this.dmPhone = (String)dmPhone;
	}
	public RestCrmDealFinalApiModel(Object dealId, Object lead, Object leadName,Object decisionMaker ,Object decisionMakerName,
			Object sector,Object dealDate,Object dealCreatedBy,
			Object dealCreatedByName, Object dealStatus,Object amount,
			Object pcdAmount,Object pcdDate,Object docName,Object clientMob,Object clientEmail,Object clientAddress,Object dmEmail,Object dmPhone,
			Object paymentMode,Object bankName,Object bankBranch,Object accountNo,Object chqNo,Object chqdate,Object transactionNo) {
		super();
		this.dealId = (String)dealId;
		this.lead = (String)lead;
		this.leadName = (String)leadName;
		this.decisionMaker= (String)decisionMaker; 
		this.decisionMakerName = (String)decisionMakerName;
		this.sector = (String)sector;
		this.dealDate = (String)dealDate;
		this.dealCreatedBy = (String)dealCreatedBy;
		this.dealCreatedByName = (String)dealCreatedByName;
		this.dealStatus = (String)dealStatus;
		this.amount = (String)amount;
		this.pcdAmount = (String)pcdAmount;
		this.pcdDate = (String)pcdDate;
		this.docName = (String)docName;
		this.clientMob = (String)clientMob;
		this.clientEmail = (String)clientEmail;
		this.clientAddress = (String)clientAddress;
		this.dmEmail = (String)dmEmail;
		this.dmPhone = (String)dmPhone;
		this.paymentMode = (String)paymentMode;
		this.bankName = (String)bankName;
		this.bankBranch = (String)bankBranch;
		this.accountNo = (String)accountNo;
		this.chqNo = (String)chqNo;
		this.chqdate = (String)chqdate;
		this.transactionNo = (String)transactionNo;
	}
	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	public String getDealPlanId() {
		return dealPlanId;
	}
	public void setDealPlanId(String dealPlanId) {
		this.dealPlanId = dealPlanId;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	
	public String getClientMob() {
		return clientMob;
	}
	public void setClientMob(String clientMob) {
		this.clientMob = clientMob;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getDmEmail() {
		return dmEmail;
	}
	public void setDmEmail(String dmEmail) {
		this.dmEmail = dmEmail;
	}
	public String getDmPhone() {
		return dmPhone;
	}
	public void setDmPhone(String dmPhone) {
		this.dmPhone = dmPhone;
	}
	public String getDecisionMaker() {
		return decisionMaker;
	}
	public void setDecisionMaker(String decisionMaker) {
		this.decisionMaker = decisionMaker;
	}
	public String getDecisionMakerName() {
		return decisionMakerName;
	}
	public void setDecisionMakerName(String decisionMakerName) {
		this.decisionMakerName = decisionMakerName;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	public String getDealCreatedBy() {
		return dealCreatedBy;
	}
	public void setDealCreatedBy(String dealCreatedBy) {
		this.dealCreatedBy = dealCreatedBy;
	}
	public String getDealCreatedByName() {
		return dealCreatedByName;
	}
	public void setDealCreatedByName(String dealCreatedByName) {
		this.dealCreatedByName = dealCreatedByName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgDiv() {
		return orgDiv;
	}
	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
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
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getChqNo() {
		return chqNo;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	public String getChqdate() {
		return chqdate;
	}
	public void setChqdate(String chqdate) {
		this.chqdate = chqdate;
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public String getOrderRecived() {
		return orderRecived;
	}
	public void setOrderRecived(String orderRecived) {
		this.orderRecived = orderRecived;
	}
 
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPcdCollected() {
		return pcdCollected;
	}
	public void setPcdCollected(String pcdCollected) {
		this.pcdCollected = pcdCollected;
	}
	public String getPcdAmount() {
		return pcdAmount;
	}
	public void setPcdAmount(String pcdAmount) {
		this.pcdAmount = pcdAmount;
	}
	public String getPcdDate() {
		return pcdDate;
	}
	public void setPcdDate(String pcdDate) {
		this.pcdDate = pcdDate;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public MultipartFile getMulFile() {
		return mulFile;
	}
	public void setMulFile(MultipartFile mulFile) {
		this.mulFile = mulFile;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
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
