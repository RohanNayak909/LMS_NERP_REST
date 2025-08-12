package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestDebitLedgerModel {

	private String dealerId;
	private String dname;
	private String transactionDate;
	private String transactionMode;
	private String transactionId;
	private String transactionAmnt;
	private String transactionDebitCredit;
	private String transactionVchType;
	private String totalBillAmnt;
	private String totalPaidAmnt;
	private String totalOutstandingAmnt;
	private String dealerName;
	private String dealerAddress;
	private String dealerMobile;

	public RestDebitLedgerModel(Object transactionDate, Object transactionMode, Object transactionId,
			Object transactionAmnt, Object transactionDebitCredit, Object transactionVchType, Object totalBillAmnt,
			Object totalPaidAmnt, Object totalOutstandingAmnt, Object dealerName, Object dealerAddress,
			Object dealerMobile) {
		super();
		this.transactionDate = (String) transactionDate;
		this.transactionMode = (String) transactionMode;
		this.transactionId = (String) transactionId;
		this.transactionAmnt = (String) transactionAmnt;
		this.transactionDebitCredit = (String) transactionDebitCredit;
		this.transactionVchType = (String) transactionVchType;
		this.totalBillAmnt = (String) totalBillAmnt;
		this.totalPaidAmnt = (String) totalPaidAmnt;
		this.totalOutstandingAmnt = (String) totalOutstandingAmnt;
		this.dealerName = (String) dealerName;
		this.dealerAddress = (String) dealerAddress;
		this.dealerMobile = (String) dealerMobile;
	}

	public RestDebitLedgerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public RestDebitLedgerModel(Object orderNo, Object dealerId, Object dname,
	 * Object dmob, Object totalOrderAmount, Object totalAmount , Object
	 * paymentId,Object totalpaidAmount, Object paidAmount , Object Allpadtotaldata,
	 * Object createdOn) { super(); this.orderNo = (String) orderNo; this.dealerId =
	 * (String) dealerId; this.dname = (String) dname; this.dmob = (String) dmob;
	 * 
	 * this.distId = (String) distId; this.distName = (String) distName;
	 * this.distMob = (String) distMob;
	 * 
	 * this.totalOrderAmount = (String) totalOrderAmount; this.totalAmount =
	 * (String) totalAmount; this.paymentId = (String) paymentId;
	 * this.totalpaidAmount = (String) totalpaidAmount; this.paidAmount = (String)
	 * paidAmount; this.Allpadtotaldata = (String) Allpadtotaldata; this.createdOn =
	 * (String) createdOn;
	 * 
	 * 
	 * }
	 */

	public RestDebitLedgerModel(Object dealerId, Object dname) {

		super();

		this.dealerId = (String) dealerId;
		this.dname = (String) dname;

		/*
		 * this.dealerId = (String) distId; this.dname = (String) distName;
		 */

	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionAmnt() {
		return transactionAmnt;
	}

	public void setTransactionAmnt(String transactionAmnt) {
		this.transactionAmnt = transactionAmnt;
	}

	public String getTransactionDebitCredit() {
		return transactionDebitCredit;
	}

	public void setTransactionDebitCredit(String transactionDebitCredit) {
		this.transactionDebitCredit = transactionDebitCredit;
	}

	public String getTransactionVchType() {
		return transactionVchType;
	}

	public void setTransactionVchType(String transactionVchType) {
		this.transactionVchType = transactionVchType;
	}

	public String getTotalBillAmnt() {
		return totalBillAmnt;
	}

	public void setTotalBillAmnt(String totalBillAmnt) {
		this.totalBillAmnt = totalBillAmnt;
	}

	public String getTotalPaidAmnt() {
		return totalPaidAmnt;
	}

	public void setTotalPaidAmnt(String totalPaidAmnt) {
		this.totalPaidAmnt = totalPaidAmnt;
	}

	public String getTotalOutstandingAmnt() {
		return totalOutstandingAmnt;
	}

	public void setTotalOutstandingAmnt(String totalOutstandingAmnt) {
		this.totalOutstandingAmnt = totalOutstandingAmnt;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	public String getDealerMobile() {
		return dealerMobile;
	}

	public void setDealerMobile(String dealerMobile) {
		this.dealerMobile = dealerMobile;
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
