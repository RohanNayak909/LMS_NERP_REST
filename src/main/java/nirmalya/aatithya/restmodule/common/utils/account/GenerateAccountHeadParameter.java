/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils.account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountHeadModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateAccountHeadParameter {
	

	
	public static String getAddAccountHeadParam(RestAccountHeadModel form) {

		String s = "";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";

		if (form.getAccountHeadId() != null) {
			s = s + "@p_acctHeadId='" + form.getAccountHeadId() + "',";
		}

		if (form.getAccountHeadType() != null && form.getAccountHeadType() != "") {
			s = s + "@p_accHeadType='" + form.getAccountHeadType() + "',";
		}
		
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription() + "',";
		}
		
		
		if (form.getStatus() != null && form.getStatus() != "") {
			s = s + "@p_bankStatus='" + form.getStatus() + "',";
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
