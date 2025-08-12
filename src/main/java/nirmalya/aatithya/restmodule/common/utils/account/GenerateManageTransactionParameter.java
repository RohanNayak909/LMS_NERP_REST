/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils.account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestBudgetModel;
import nirmalya.aatithya.restmodule.account.model.RestTransactionLockingModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateManageTransactionParameter {
	public static String getAddTransactionParam(RestTransactionLockingModel form) {

		String s = "";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";

		/*if (form.getBudgetId() != null) {
			s = s + "@p_budgetId='" + form.getBudgetId() + "',";
		}*/

		if (form.getSalesLockDate() != null && form.getSalesLockDate() != "") {
			s = s + "@p_salesLockDate='" + form.getSalesLockDate() + "',";
		}
		
		if (form.getReasonSalesLock() != null && form.getReasonSalesLock() != "") {
			s = s + "@p_reasonSalesLock='" + form.getReasonSalesLock() + "',";
		}
		
		if (form.getReasonSalesUnlock() != null && form.getReasonSalesUnlock() != "") {
			s = s + "@p_reasonSalesUnlock='" + form.getReasonSalesUnlock() + "',";
		}
		
		
		if (form.getPurchaseLockDate() != null && form.getPurchaseLockDate() != "") {
			s = s + "@p_purchaseLockDate='" + form.getPurchaseLockDate() + "',";
		}
		
		if (form.getReasonPurchaseLock() != null && form.getReasonPurchaseLock() != "") {
			s = s + "@p_reasonPurchaseLock='" + form.getReasonPurchaseLock() + "',";
		}
		
		if (form.getReasonPurchaseUnlock() != null && form.getReasonPurchaseUnlock() != "") {
			s = s + "@p_reasonPurchaseUnlock='" + form.getReasonPurchaseUnlock() + "',";
		}
		
		if (form.getBankingLockDate() != null && form.getBankingLockDate() != "") {
			s = s + "@p_bankingLockDate='" + form.getBankingLockDate() + "',";
		}
		
		if (form.getReasonBankingLock() != null && form.getReasonBankingLock() != "") {
			s = s + "@p_reasonBankingLock='" + form.getReasonBankingLock() + "',";
		}
		
		if (form.getReasonBankingUnlock() != null && form.getReasonBankingUnlock() != "") {
			s = s + "@p_reasonBankingUnlock='" + form.getReasonBankingUnlock() + "',";
		}
		
		
		if (form.getAccountantLockDate() != null && form.getAccountantLockDate() != "") {
			s = s + "@p_accountLockDate='" + form.getAccountantLockDate() + "',";
		}
		
		if (form.getReasonAccountLock() != null && form.getReasonAccountLock() != "") {
			s = s + "@p_reasonAccountLock='" + form.getReasonAccountLock() + "',";
		}
		
		if (form.getReasonAccountantUnlock() != null && form.getReasonAccountantUnlock() != "") {
			s = s + "@p_reasonAccountUnlock='" + form.getReasonAccountantUnlock() + "',";
		}
		
		
		
		
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}


}
