package nirmalya.aatithya.restmodule.common.utils.account;

import nirmalya.aatithya.restmodule.account.model.RestManageCurrencyModel;

public class GenerateMangeCurrencyParam {
	
	public static String addmanagecurrencyParam(RestManageCurrencyModel managecurrency) {

		String s = "";
		if (managecurrency.getCurrencyid() != null || managecurrency.getCurrencyid() != "") {
			s = s + "@p_currencyId='" + managecurrency.getCurrencyid() + "',";
		}
		if (managecurrency.getFormalname() != null || managecurrency.getFormalname() != "") {
			s = s + "@p_formalName='" + managecurrency.getFormalname() + "',";
		}
		if (managecurrency.getCurrencysymbol() != null || managecurrency.getCurrencysymbol() != "") {
			s = s + "@p_currencySymbol='" + managecurrency.getCurrencysymbol() + "',";
		}
		if (managecurrency.getCurrencycode() != null || managecurrency.getCurrencycode() != "") {
			s = s + "@p_currencyCode='" + managecurrency.getCurrencycode() + "',";
		}
		if (managecurrency.getDecimalplaces() != null || managecurrency.getDecimalplaces() != "") {
			s = s + "@p_decimalPlace='" + managecurrency.getDecimalplaces() + "',";
		}
		if (managecurrency.getAmountmillions() != null || managecurrency.getAmountmillions() != "") {
			s = s + "@p_amountMillion='" + managecurrency.getAmountmillions() + "',";
		}
		if (managecurrency.getSaymbolamount() != null || managecurrency.getSaymbolamount() != "") {
			s = s + "@p_symbolAmount='" + managecurrency.getSaymbolamount() + "',";
		}
		if (managecurrency.getSpaceamountsymbol() != null || managecurrency.getSpaceamountsymbol() != "") {
			s = s + "@p_spaceamountSymblol='" + managecurrency.getSpaceamountsymbol() + "',";
		}
		if (managecurrency.getPlacesamountwords() != null || managecurrency.getPlacesamountwords() != "") {
			s = s + "@p_amountWord='" + managecurrency.getPlacesamountwords() + "',";
		}
	

		if (s != "") { 
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}


}
