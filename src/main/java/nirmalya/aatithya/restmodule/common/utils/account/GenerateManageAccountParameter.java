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

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateManageAccountParameter {
	

	
	public static String getAddAccountParam(RestAccountModel form) {

		String s = "";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";

		if (form.getAccountId() != null) {
			s = s + "@p_accountId='" + form.getAccountId() + "',";
		}

		if (form.getBankName() != null && form.getBankName() != "") {
			s = s + "@p_bankName='" + form.getBankName() + "',";
		}
		
		if (form.getBranchName() != null && form.getBranchName() != "") {
			s = s + "@p_branchName='" + form.getBranchName() + "',";
		}
		
		if (form.getAccountHolder() != null && form.getAccountHolder() != "") {
			s = s + "@p_accountHolder='" + form.getAccountHolder() + "',";
		}
		
		if (form.getAccountType() != null && form.getAccountType() != "") {
			s = s + "@p_accountType='" + form.getAccountType() + "',";
		}
		
		if (form.getAccountNumber() != null && form.getAccountNumber() != "") {
			s = s + "@p_accountNumber='" + form.getAccountNumber() + "',";
		}
		
		if (form.getIfscNumber() != null && form.getIfscNumber() != "") {
			s = s + "@p_ifscNumber='" + form.getIfscNumber() + "',";
		}
				
		if (form.getStatus() != null && form.getStatus() != "") {
			s = s + "@p_bankStatus='" + form.getStatus() + "',";
		}
		
		
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		
		if (form.getOrganization() != null && form.getOrganization() != "") {
			s = s + "@p_orgName='" + form.getOrganization() + "',";
		}
		
		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + form.getOrgDivision() + "',";
		}
		
		if (form.getOpeningBalance() != null && form.getOpeningBalance() != "") {
			s = s + "@p_openingBalance='" + form.getOpeningBalance() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}


}
