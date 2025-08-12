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
import nirmalya.aatithya.restmodule.account.model.RestCurrencyModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateManageCurrencyParameter {
	

	
	public static String getAddCurrencyParam(RestCurrencyModel form) {

		String s = "";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";

		if (form.getCurrencyId() != null) {
			s = s + "@p_currencyId='" + form.getCurrencyId() + "',";
		}

		if (form.getCurrency() != null && form.getCurrency() != "") {
			s = s + "@p_currency='" + form.getCurrency() + "',";
		}
		
		if (form.getDateAdjust() != null && form.getDateAdjust() != "") {
			s = s + "@p_dateAdjust='" + form.getDateAdjust() + "',";
		}
		
		if (form.getExchangeRateInr() != null && form.getExchangeRateInr() != "") {
			s = s + "@p_exchangeRateINR='" + form.getExchangeRateInr() + "',";
		}
			
				
		if (form.getStatus() != null && form.getStatus() != "") {
			s = s + "@p_status='" + form.getStatus() + "',";
		}
		
		
		if (form.getNotes() != null && form.getNotes() != "") {
			s = s + "@p_notes='" + form.getNotes() + "',";
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
