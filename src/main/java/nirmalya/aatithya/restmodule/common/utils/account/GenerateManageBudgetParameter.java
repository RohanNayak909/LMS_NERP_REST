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

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateManageBudgetParameter {
	

	
	public static String getAddBudgetParam(RestBudgetModel form) {

		String s = "";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";

		if (form.getBudgetId() != null) {
			s = s + "@p_budgetId='" + form.getBudgetId() + "',";
		}

		if (form.getBudgetName() != null && form.getBudgetName() != "") {
			s = s + "@p_budgetName='" + form.getBudgetName() + "',";
		}
		
		if (form.getFiscalYear() != null && form.getFiscalYear() != "") {
			s = s + "@p_fiscalYear='" + form.getFiscalYear() + "',";
		}
		
		if (form.getBudgetPeriod() != null && form.getBudgetPeriod() != "") {
			s = s + "@p_budgetPeriod='" + form.getBudgetPeriod() + "',";
		}
		
		if (form.getIncomeAccGroup() != null && form.getIncomeAccGroup() != "") {
			s = s + "@p_incomeAccGrp='" + form.getIncomeAccGroup() + "',";
		}
		
		if (form.getIncomeAccGroupId() != null && form.getIncomeAccGroupId() != "") {
			s = s + "@p_incomeAccGrpId='" + form.getIncomeAccGroupId() + "',";
		}
		
				
		if (form.getExpenseAccGroup() != null && form.getExpenseAccGroup() != "") {
			s = s + "@p_expenseAccGrp='" + form.getExpenseAccGroup() + "',";
		}
		
		if (form.getExpenseAccGroupId() != null && form.getExpenseAccGroupId() != "") {
			s = s + "@p_expenseAccGrpId='" + form.getExpenseAccGroupId() + "',";
		}
		
		
		if (form.getAssetAccGroup() != null && form.getAssetAccGroup() != "") {
			s = s + "@p_assetAccGrp='" + form.getAssetAccGroup() + "',";
		}
		
		if (form.getAssetAccGroupId() != null && form.getAssetAccGroupId() != "") {
			s = s + "@p_assetAccGrpId='" + form.getAssetAccGroupId() + "',";
		}
				
		
		if (form.getLiabilityAccGroup() != null && form.getLiabilityAccGroup() != "") {
			s = s + "@p_liabilityAccGrp='" + form.getLiabilityAccGroup() + "',";
		}
		
		if (form.getLiabilityAccGroupId() != null && form.getLiabilityAccGroupId() != "") {
			s = s + "@p_liabilityAccGrpId='" + form.getLiabilityAccGroupId() + "',";
		}
		
		
		if (form.getEquityAccGroup() != null && form.getEquityAccGroup() != "") {
			s = s + "@p_equityAccGrp='" + form.getEquityAccGroup() + "',";
		}
		
		if (form.getEquityAccGroupId() != null && form.getEquityAccGroupId() != "") {
			s = s + "@p_equityAccGrpId='" + form.getEquityAccGroupId() + "',";
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
