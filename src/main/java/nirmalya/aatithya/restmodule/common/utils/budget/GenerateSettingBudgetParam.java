package nirmalya.aatithya.restmodule.common.utils.budget;


import nirmalya.aatithya.restmodule.budget.model.RestBudgetSettingModel;


public class GenerateSettingBudgetParam {
	
	public static String addBudgetSettingParam(RestBudgetSettingModel settingBudget) {

		String s = "";
		if (settingBudget.getBudgetSetId() != null || settingBudget.getBudgetSetId() != "") {
			s = s + "@p_budgetSetId='" + settingBudget.getBudgetSetId() + "',";
		}
		if (settingBudget.getCurrentYear() != null || settingBudget.getCurrentYear() != "") {
			s = s + "@p_currentYear='" + settingBudget.getCurrentYear() + "',";
		}
		if (settingBudget.getLastYear() != null || settingBudget.getLastYear() != "") {
			s = s + "@p_lastYear='" + settingBudget.getLastYear() + "',";
		}
		if (settingBudget.getSecondlastYear() != null || settingBudget.getSecondlastYear() != "") {
			s = s + "@p_secondlastYear='" + settingBudget.getSecondlastYear() + "',";
		}
		
		

		if (s != "") { 
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}

}
