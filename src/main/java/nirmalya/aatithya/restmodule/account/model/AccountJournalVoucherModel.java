/**
 * 
 */
package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class AccountJournalVoucherModel {
	private String journalVoucher;
	private String costCenter;
	private String description;
	private String fromAccountSubGroup;
	private String fromName;
	private Double fromAmount;
	private String toAccountSubGroup;
	private String toName;
	private Double toAmount;
	private Double totalAmount;
	private Boolean active;
	private String createdOn;
	private String createdBy;
	private String transactionType;
	private Integer currentStageNo;
	private Integer approverStageNo;
	private Integer currentLevelNo;
	private Integer approverLevelNo;
	private Byte approveStatus;
	private String voucherType;
	private String subGroupName;

	private String debitTrans;
	private String creditTrans;
	private String voucherDate;
	private String currentBalance;
	private String organization;
	private String orgDivision;
	private String listTdsId;
	private String taxType;
	private String methodOfNote;

	private String paymentType;
	private String paymentDesc;
	private String advOrNewRfAmount;
	private String invoiceObj;
	private String advReceiveObj;
	private String newRefLedgerId;
	private String billDetails;

	private String advanceRemaingDetails;
	private String paymentMethodDetails;
	public AccountJournalVoucherModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object description,
			Object fromAccountSubGroup, Object fromName, Object fromAmount, Object toAccountSubGroup, Object toName,
			Object toAmount, Object totalAmount, Object active, Object createdOn, Object createdBy,
			Object transactionType, Object currentStageNo, Object approverStageNo, Object currentLevelNo,
			Object approverLevelNo, Object approveStatus) {
		super();
		this.journalVoucher = (String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.description = (String) description;
		this.fromAccountSubGroup = (String) fromAccountSubGroup;
		this.fromName = (String) fromName;
		this.fromAmount = (Double) fromAmount;
		this.toAccountSubGroup = (String) toAccountSubGroup;
		this.toName = (String) toName;
		this.toAmount = (Double) toAmount;
		this.totalAmount = (Double) totalAmount;
		this.active = (Boolean) active;
		this.createdOn = (String) createdOn;
		this.createdBy = (String) createdBy;
		this.transactionType = (String) transactionType;
		this.currentStageNo = (Integer) currentStageNo;
		this.approverStageNo = (Integer) approverStageNo;
		this.currentLevelNo = (Integer) currentLevelNo;
		this.approverLevelNo = (Integer) approverLevelNo;
		this.approveStatus = (Byte) approveStatus;
	}

	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object totalAmount,
			Object currentStageNo, Object approveStatus, Object createdOn, Object description) {
		super();
		this.journalVoucher = (String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.totalAmount = (Double) totalAmount;
		this.currentStageNo = (Integer) currentStageNo;
		this.approveStatus = (Byte) approveStatus;
		this.createdOn = (String) createdOn;
		this.description = (String) description;

	}

	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object description,
			Object fromAccountSubGroup, Object fromName, Object fromAmount, Object toAmount, Object transactionType,
			Object currentStageNo, Object approveStatus, Object subGroupName, Object voucherDate, Object currentBalance,
			Object methodOfNote) {
		super();
		this.journalVoucher = (String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.description = (String) description;
		this.fromAccountSubGroup = (String) fromAccountSubGroup;
		this.fromName = (String) fromName;
		this.fromAmount = (Double) fromAmount;
		this.toAmount = (Double) toAmount;
		this.transactionType = (String) transactionType;
		this.currentStageNo = (Integer) currentStageNo;
		this.approveStatus = (Byte) approveStatus;
		this.subGroupName = (String) subGroupName;
		this.voucherDate = (String) voucherDate;
		this.currentBalance = (String) currentBalance;
		this.methodOfNote = (String) methodOfNote;
	}

	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object description,
			Object fromAccountSubGroup, Object fromName, Object fromAmount, Object toAmount, Object transactionType,
			Object currentStageNo, Object approveStatus, Object subGroupName, Object voucherDate, Object currentBalance,
			Object voucherType, Object organization, Object orgDivision, Object paymentDesc) {
		super();
		this.journalVoucher = (String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.description = (String) description;
		this.fromAccountSubGroup = (String) fromAccountSubGroup;
		this.fromName = (String) fromName;
		this.fromAmount = (Double) fromAmount;
		this.toAmount = (Double) toAmount;
		this.transactionType = (String) transactionType;
		this.currentStageNo = (Integer) currentStageNo;
		this.approveStatus = (Byte) approveStatus;
		this.subGroupName = (String) subGroupName;
		this.voucherDate = (String) voucherDate;
		this.currentBalance = (String) currentBalance;
		this.voucherType = (String) voucherType;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
		this.paymentDesc = (String) paymentDesc;
	}

	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object description,
			Object fromAccountSubGroup, Object fromName, Object fromAmount, Object toAmount, Object transactionType,
			Object currentStageNo, Object approveStatus, Object subGroupName, Object voucherDate,
			Object currentBalance) {
		super();
		this.journalVoucher = (String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.description = (String) description;
		this.fromAccountSubGroup = (String) fromAccountSubGroup;
		this.fromName = (String) fromName;
		this.fromAmount = (Double) fromAmount;
		this.toAmount = (Double) toAmount;
		this.transactionType = (String) transactionType;
		this.currentStageNo = (Integer) currentStageNo;
		this.approveStatus = (Byte) approveStatus;
		this.subGroupName = (String) subGroupName;
		this.voucherDate = (String) voucherDate;
		this.currentBalance = (String) currentBalance;
	}
	
	
	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object description,
			Object fromAccountSubGroup, Object fromName, Object fromAmount, Object toAmount, Object transactionType,
			Object currentStageNo, Object approveStatus, Object subGroupName, Object voucherDate,
			Object currentBalance,Object paymentMethodDetails,Object paymentDesc,Object createdOn,Object organization,Object orgDivision) {
		super();
		this.journalVoucher = (String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.description = (String) description;
		this.fromAccountSubGroup = (String) fromAccountSubGroup;
		this.fromName = (String) fromName;
		this.fromAmount = (Double) fromAmount;
		this.toAmount = (Double) toAmount;
		this.transactionType = (String) transactionType;
		this.currentStageNo = (Integer) currentStageNo;
		this.approveStatus = (Byte) approveStatus;
		this.subGroupName = (String) subGroupName;
		this.voucherDate = (String) voucherDate;
		this.currentBalance = (String) currentBalance;
		this.paymentMethodDetails = (String) paymentMethodDetails;
		this.paymentDesc = (String) paymentDesc;
		this.createdOn = (String) createdOn;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
	}

	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object description,
			Object fromAccountSubGroup, Object fromName, Object fromAmount, Object toAmount, Object transactionType,
			Object currentStageNo, Object approveStatus, Object subGroupName, Object voucherDate, Object currentBalance,
			Object newRefLedgerId, Object organization, Object orgDivision) {
		super();
		this.journalVoucher = (String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.description = (String) description;
		this.fromAccountSubGroup = (String) fromAccountSubGroup;
		this.fromName = (String) fromName;
		this.fromAmount = (Double) fromAmount;
		this.toAmount = (Double) toAmount;
		this.transactionType = (String) transactionType;
		this.currentStageNo = (Integer) currentStageNo;
		this.approveStatus = (Byte) approveStatus;
		this.subGroupName = (String) subGroupName;
		this.voucherDate = (String) voucherDate;
		this.currentBalance = (String) currentBalance;
		this.newRefLedgerId = (String) newRefLedgerId;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
	}

	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object description,
			Object fromAccountSubGroup, Object fromName, Object fromAmount, Object toAmount, Object transactionType,
			Object currentStageNo, Object approveStatus, Object subGroupName, Object voucherDate, Object currentBalance,
			Object paymentType, Object paymentDesc) {
		super();
		this.journalVoucher = (String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.description = (String) description;
		this.fromAccountSubGroup = (String) fromAccountSubGroup;
		this.fromName = (String) fromName;
		this.fromAmount = (Double) fromAmount;
		this.toAmount = (Double) toAmount;
		this.transactionType = (String) transactionType;
		this.currentStageNo = (Integer) currentStageNo;
		this.approveStatus = (Byte) approveStatus;
		this.subGroupName = (String) subGroupName;
		this.voucherDate = (String) voucherDate;
		this.currentBalance = (String) currentBalance;
		this.paymentType = (String) paymentType;
		this.paymentDesc = (String) paymentDesc;
	}

	public AccountJournalVoucherModel(Object journalVoucher) {
		super();
		this.journalVoucher = (String) journalVoucher;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public String getDescription() {
		return description;
	}

	public String getFromAccountSubGroup() {
		return fromAccountSubGroup;
	}

	public String getFromName() {
		return fromName;
	}

	public Double getFromAmount() {
		return fromAmount;
	}

	public String getToAccountSubGroup() {
		return toAccountSubGroup;
	}

	public String getToName() {
		return toName;
	}

	public Double getToAmount() {
		return toAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public Boolean getActive() {
		return active;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Integer getCurrentStageNo() {
		return currentStageNo;
	}

	public void setCurrentStageNo(Integer currentStageNo) {
		this.currentStageNo = currentStageNo;
	}

	public Integer getApproverStageNo() {
		return approverStageNo;
	}

	public void setApproverStageNo(Integer approverStageNo) {
		this.approverStageNo = approverStageNo;
	}

	public Integer getCurrentLevelNo() {
		return currentLevelNo;
	}

	public void setCurrentLevelNo(Integer currentLevelNo) {
		this.currentLevelNo = currentLevelNo;
	}

	public Integer getApproverLevelNo() {
		return approverLevelNo;
	}

	public void setApproverLevelNo(Integer approverLevelNo) {
		this.approverLevelNo = approverLevelNo;
	}

	public Byte getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Byte approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getJournalVoucher() {
		return journalVoucher;
	}

	public void setJournalVoucher(String journalVoucher) {
		this.journalVoucher = journalVoucher;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFromAccountSubGroup(String fromAccountSubGroup) {
		this.fromAccountSubGroup = fromAccountSubGroup;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public void setFromAmount(Double fromAmount) {
		this.fromAmount = fromAmount;
	}

	public void setToAccountSubGroup(String toAccountSubGroup) {
		this.toAccountSubGroup = toAccountSubGroup;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public void setToAmount(Double toAmount) {
		this.toAmount = toAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getSubGroupName() {
		return subGroupName;
	}

	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}

	public String getDebitTrans() {
		return debitTrans;
	}

	public void setDebitTrans(String debitTrans) {
		this.debitTrans = debitTrans;
	}

	public String getCreditTrans() {
		return creditTrans;
	}

	public void setCreditTrans(String creditTrans) {
		this.creditTrans = creditTrans;
	}

	public String getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(String voucherDate) {
		this.voucherDate = voucherDate;
	}

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
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

	public String getListTdsId() {
		return listTdsId;
	}

	public void setListTdsId(String listTdsId) {
		this.listTdsId = listTdsId;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getMethodOfNote() {
		return methodOfNote;
	}

	public void setMethodOfNote(String methodOfNote) {
		this.methodOfNote = methodOfNote;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentDesc() {
		return paymentDesc;
	}

	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc = paymentDesc;
	}

	public String getAdvOrNewRfAmount() {
		return advOrNewRfAmount;
	}

	public void setAdvOrNewRfAmount(String advOrNewRfAmount) {
		this.advOrNewRfAmount = advOrNewRfAmount;
	}

	public String getInvoiceObj() {
		return invoiceObj;
	}

	public void setInvoiceObj(String invoiceObj) {
		this.invoiceObj = invoiceObj;
	}

	public String getAdvReceiveObj() {
		return advReceiveObj;
	}

	public void setAdvReceiveObj(String advReceiveObj) {
		this.advReceiveObj = advReceiveObj;
	}

	public String getNewRefLedgerId() {
		return newRefLedgerId;
	}

	public void setNewRefLedgerId(String newRefLedgerId) {
		this.newRefLedgerId = newRefLedgerId;
	}

	public String getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(String billDetails) {
		this.billDetails = billDetails;
	}

	public String getAdvanceRemaingDetails() {
		return advanceRemaingDetails;
	}

	public void setAdvanceRemaingDetails(String advanceRemaingDetails) {
		this.advanceRemaingDetails = advanceRemaingDetails;
	}

	
	public String getPaymentMethodDetails() {
		return paymentMethodDetails;
	}

	public void setPaymentMethodDetails(String paymentMethodDetails) {
		this.paymentMethodDetails = paymentMethodDetails;
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
