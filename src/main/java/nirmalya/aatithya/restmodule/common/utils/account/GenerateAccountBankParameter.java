/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils.account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateAccountBankParameter {
	

	
	public static String getAddBankParam(RestAccountBankModel form) {

		String s = "";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";

		if (form.getBankId() != null) {
			s = s + "@p_bankId='" + form.getBankId() + "',";
		}

		if (form.getBankName() != null && form.getBankName() != "") {
			s = s + "@p_bankName='" + form.getBankName() + "',";
		}
		
		if (form.getStatus() != null && form.getStatus() != "") {
			s = s + "@p_bankStatus='" + form.getStatus() + "',";
		}

		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_bankDescription='" + form.getDescription() + "',";
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
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}


}
