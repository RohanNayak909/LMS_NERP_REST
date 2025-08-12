/**
 * 
 */
package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class RestTransactionLockingModel {
	private String id;
	private String salesLock;
	private String purchaseLock;
	private String bankingLock;
	private String accountantLock;
	
	private String salesLockDate;
	private String reasonSalesLock;
	private String reasonSalesUnlock;
	
	private String purchaseLockDate;
	private String reasonPurchaseLock;
	private String reasonPurchaseUnlock;
	
	private String bankingLockDate;
	private String reasonBankingLock;
	private String reasonBankingUnlock;
	
	private String accountantLockDate;
	private String reasonAccountLock;
	private String reasonAccountantUnlock;
	
	private String status;
	private String createdDate;	
	private String createdBy;
	
	public RestTransactionLockingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestTransactionLockingModel(Object id, 
			Object salesLock,  Object salesLockDate,  Object reasonSalesLock,  Object reasonSalesUnlock,
			Object purchaseLock, Object purchaseLockDate,  Object reasonPurchaseLock,  Object reasonPurchaseUnlock,
			Object bankingLock, Object bankingLockDate,  Object reasonBankingLock,  Object reasonBankingUnlock,
			Object accountantLock, Object accountantLockDate,  Object reasonAccountLock,  Object reasonAccountantUnlock,
			Object status,  Object createdDate) {
		super();
		this.id = (String) id;
		this.salesLock = (String) salesLock;
		this.salesLockDate = (String) salesLockDate;
		this.reasonSalesLock = (String) reasonSalesLock;
		this.reasonSalesUnlock = (String) reasonSalesUnlock;
		
		this.purchaseLock = (String) purchaseLock;
		this.purchaseLockDate = (String) purchaseLockDate;
		this.reasonPurchaseLock = (String) reasonPurchaseLock;
		this.reasonPurchaseUnlock = (String) reasonPurchaseUnlock;
		
		this.bankingLock = (String) bankingLock;
		this.bankingLockDate = (String) bankingLockDate;
		this.reasonBankingLock = (String) reasonBankingLock;
		this.reasonBankingUnlock = (String) reasonBankingUnlock;
		
		this.accountantLock = (String) accountantLock;
		this.accountantLockDate = (String) accountantLockDate;
		this.reasonAccountLock = (String) reasonAccountLock;
		this.reasonAccountantUnlock = (String) reasonAccountantUnlock;
		
		this.status = (String) status;
		this.createdDate = (String) createdDate;		
	}
	
	

	public String getSalesLockDate() {
		return salesLockDate;
	}


	public void setSalesLockDate(String salesLockDate) {
		this.salesLockDate = salesLockDate;
	}


	public String getReasonSalesLock() {
		return reasonSalesLock;
	}


	public void setReasonSalesLock(String reasonSalesLock) {
		this.reasonSalesLock = reasonSalesLock;
	}


	public String getReasonSalesUnlock() {
		return reasonSalesUnlock;
	}


	public void setReasonSalesUnlock(String reasonSalesUnlock) {
		this.reasonSalesUnlock = reasonSalesUnlock;
	}


	public String getPurchaseLockDate() {
		return purchaseLockDate;
	}


	public void setPurchaseLockDate(String purchaseLockDate) {
		this.purchaseLockDate = purchaseLockDate;
	}


	public String getReasonPurchaseLock() {
		return reasonPurchaseLock;
	}


	public void setReasonPurchaseLock(String reasonPurchaseLock) {
		this.reasonPurchaseLock = reasonPurchaseLock;
	}


	public String getReasonPurchaseUnlock() {
		return reasonPurchaseUnlock;
	}


	public void setReasonPurchaseUnlock(String reasonPurchaseUnlock) {
		this.reasonPurchaseUnlock = reasonPurchaseUnlock;
	}


	public String getBankingLockDate() {
		return bankingLockDate;
	}


	public void setBankingLockDate(String bankingLockDate) {
		this.bankingLockDate = bankingLockDate;
	}


	public String getReasonBankingLock() {
		return reasonBankingLock;
	}


	public void setReasonBankingLock(String reasonBankingLock) {
		this.reasonBankingLock = reasonBankingLock;
	}


	public String getReasonBankingUnlock() {
		return reasonBankingUnlock;
	}


	public void setReasonBankingUnlock(String reasonBankingUnlock) {
		this.reasonBankingUnlock = reasonBankingUnlock;
	}


	public String getAccountantLockDate() {
		return accountantLockDate;
	}


	public void setAccountantLockDate(String accountantLockDate) {
		this.accountantLockDate = accountantLockDate;
	}


	public String getReasonAccountLock() {
		return reasonAccountLock;
	}


	public void setReasonAccountLock(String reasonAccountLock) {
		this.reasonAccountLock = reasonAccountLock;
	}


	public String getReasonAccountantUnlock() {
		return reasonAccountantUnlock;
	}


	public void setReasonAccountantUnlock(String reasonAccountantUnlock) {
		this.reasonAccountantUnlock = reasonAccountantUnlock;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSalesLock() {
		return salesLock;
	}


	public void setSalesLock(String salesLock) {
		this.salesLock = salesLock;
	}


	public String getPurchaseLock() {
		return purchaseLock;
	}


	public void setPurchaseLock(String purchaseLock) {
		this.purchaseLock = purchaseLock;
	}


	public String getBankingLock() {
		return bankingLock;
	}


	public void setBankingLock(String bankingLock) {
		this.bankingLock = bankingLock;
	}


	public String getAccountantLock() {
		return accountantLock;
	}


	public void setAccountantLock(String accountantLock) {
		this.accountantLock = accountantLock;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}




	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
