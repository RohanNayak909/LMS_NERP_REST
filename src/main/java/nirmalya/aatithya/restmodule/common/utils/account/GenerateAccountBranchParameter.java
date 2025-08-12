/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils.account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateAccountBranchParameter {

	public static String getAddBranchParam(RestAccountBranchModel form) {

		String s = "";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		if (form.getBranchId() != null) {
			s = s + "@p_branchId='" + form.getBranchId() + "',";
		}

		if (form.getBank() != null && form.getBank() != "") {
			s = s + "@p_bank='" + form.getBank() + "',";
		}

		if (form.getBranchName() != null && form.getBranchName() != "") {
			s = s + "@p_branchName='" + form.getBranchName() + "',";
		}

		if (form.getIfscCode() != null && form.getIfscCode() != "") {
			s = s + "@p_ifscCode='" + form.getIfscCode() + "',";
		}

		if (form.getContactNo() != null && form.getContactNo() != "") {
			s = s + "@p_contactNo='" + form.getContactNo() + "',";
		}

		if (form.getEmail() != null && form.getEmail() != "") {
			s = s + "@p_email='" + form.getEmail() + "',";
		}

		if (form.getStatus() != null && form.getStatus() != "") {
			s = s + "@p_bankStatus='" + form.getStatus() + "',";
		}

		if (form.getCountry() != null && form.getCountry() != "") {
			s = s + "@p_country='" + form.getCountry() + "',";
		}

		if (form.getStates() != null && form.getStates() != "") {
			s = s + "@p_state='" + form.getStates() + "',";
		}

		if (form.getCity() != null && form.getCity() != "") {
			s = s + "@p_city='" + form.getCity() + "',";
		}

		if (form.getAddressStreet() != null && form.getAddressStreet() != "") {
			s = s + "@p_addressStreet='" + form.getAddressStreet() + "',";
		}

		if (form.getZip() != null && form.getZip() != "") {
			s = s + "@p_zip='" + form.getZip() + "',";
		}

		if (form.getAddress() != null && form.getAddress() != "") {
			s = s + "@p_address='" + form.getAddress() + "',";
		}

		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		
		if (form.getOrgName() != null && form.getOrgName() != "") {
			s = s + "@p_orgName='" + form.getOrgName() + "',";
		}
		
		if (form.getOrgDiv() != null && form.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + form.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

}
