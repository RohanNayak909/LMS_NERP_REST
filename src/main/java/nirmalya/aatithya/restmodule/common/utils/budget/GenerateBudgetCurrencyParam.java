package nirmalya.aatithya.restmodule.common.utils.budget;



import nirmalya.aatithya.restmodule.budget.model.RestBudgetCurrencyModel;

public class GenerateBudgetCurrencyParam {
	
	public static String addbudgetcurrencyParam(RestBudgetCurrencyModel budgetCurrency) {

		String s = "";
		
		if (budgetCurrency.getCreatedBy() != null || budgetCurrency.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + budgetCurrency.getCreatedBy() + "',";
		}
		if (budgetCurrency.getOrgName() != null || budgetCurrency.getOrgName() != "") {
			s = s + "@p_orgName='" + budgetCurrency.getOrgName() + "',";
		}
		if (budgetCurrency.getOrgDivision() != null || budgetCurrency.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + budgetCurrency.getOrgDivision() + "',";
		}
		
		if (budgetCurrency.getCurrencyid() != null || budgetCurrency.getCurrencyid() != "") {
			s = s + "@p_currencyId='" + budgetCurrency.getCurrencyid() + "',";
		}
		if (budgetCurrency.getFormalname() != null || budgetCurrency.getFormalname() != "") {
			s = s + "@p_formalName='" + budgetCurrency.getFormalname() + "',";
		}
		if (budgetCurrency.getCurrencysymbol() != null || budgetCurrency.getCurrencysymbol() != "") {
			s = s + "@p_currencySymbol='" + budgetCurrency.getCurrencysymbol() + "',";
		}
		if (budgetCurrency.getCurrencycode() != null || budgetCurrency.getCurrencycode() != "") {
			s = s + "@p_currencyCode='" + budgetCurrency.getCurrencycode() + "',";
		}
		if (budgetCurrency.getDecimalplaces() != null || budgetCurrency.getDecimalplaces() != "") {
			s = s + "@p_decimalPlace='" + budgetCurrency.getDecimalplaces() + "',";
		}
		if (budgetCurrency.getAmountmillions() != null || budgetCurrency.getAmountmillions() != "") {
			s = s + "@p_amountMillion='" + budgetCurrency.getAmountmillions() + "',";
		}
		if (budgetCurrency.getSaymbolamount() != null || budgetCurrency.getSaymbolamount() != "") {
			s = s + "@p_symbolAmount='" + budgetCurrency.getSaymbolamount() + "',";
		}
		if (budgetCurrency.getSpaceamountsymbol() != null || budgetCurrency.getSpaceamountsymbol() != "") {
			s = s + "@p_spaceamountSymblol='" + budgetCurrency.getSpaceamountsymbol() + "',";
		}
		if (budgetCurrency.getPlacesamountwords() != null || budgetCurrency.getPlacesamountwords() != "") {
			s = s + "@p_amountWord='" + budgetCurrency.getPlacesamountwords() + "',";
		}
	

		if (s != "") { 
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}

}
