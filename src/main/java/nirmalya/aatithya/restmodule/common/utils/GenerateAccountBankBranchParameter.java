/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.AccountBankBranchModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateAccountBankBranchParameter {

	public static String getAddBankBranchParam(AccountBankBranchModel form) {

		String s = "";

		if (form.getBranchid() != null) {
			s = s + "@p_branch='" + form.getBranchid() + "',";
		}

		if (form.getBankname() != null && form.getBankname() != "") {
			s = s + "@p_bank='" + form.getBankname() + "',";
		}

		if (form.getBranchname() != null && form.getBranchname() != "") {
			s = s + "@p_branchName='" + form.getBranchname() + "',";
		}

		if (form.getIfscode() != null && form.getIfscode() != "") {
			s = s + "@p_ifsc='" + form.getIfscode() + "',";
		}

		if (form.getContactno() != null && form.getContactno() != "") {
			s = s + "@p_contactNumber='" + form.getContactno() + "',";
		}

		if (form.getEmail() != null && form.getEmail() != "") {
			s = s + "@p_email='" + form.getEmail() + "',";
		}

		if (form.getAddress() != null && form.getAddress() != "") {
			s = s + "@p_address='" + form.getAddress() + "',";
		}

		if (form.getCityname() != null && form.getCityname() != "") {
			s = s + "@p_city='" + form.getCityname() + "',";
		}

		if (form.getCityid() != null && form.getCityid() != "") {
			s = s + "@p_district='" + form.getCityid() + "',";
		}

		if (form.getStateid() != null && form.getStateid() != "") {
			s = s + "@p_state='" + form.getStateid() + "',";
		}

		if (form.getCountryid() != null && form.getCountryid() != "") {
			s = s + "@p_country='" + form.getCountryid() + "',";
		}


		s = s + "@p_branchActive=" + form.getStatus() + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

}
