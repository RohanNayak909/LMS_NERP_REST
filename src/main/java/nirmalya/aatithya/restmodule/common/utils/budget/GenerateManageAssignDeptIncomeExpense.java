package nirmalya.aatithya.restmodule.common.utils.budget;


import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;

public class GenerateManageAssignDeptIncomeExpense {
	public static String assignIncomeDeptParam(RestAssignDeptBudgetModel restAssignDeptBudgetModel) {

		String s = "";
		
		
		
		if (restAssignDeptBudgetModel.getGroupId() != null
				|| restAssignDeptBudgetModel.getGroupId() != "") {
			s = s + "@p_groupId='" + restAssignDeptBudgetModel.getGroupId() + "',";
		}

		if (restAssignDeptBudgetModel.getDepartmentId() != null
				|| restAssignDeptBudgetModel.getDepartmentId() != "") {
			s = s + "@p_departmentId='" + restAssignDeptBudgetModel.getDepartmentId() + "',";
		}

		

		if (restAssignDeptBudgetModel.getFyId() != null
				|| restAssignDeptBudgetModel.getFyId() != "") {
			s = s + "@p_financialYear='" + restAssignDeptBudgetModel.getFyId() + "',";
		}

		if (restAssignDeptBudgetModel.getQuarter() != null
				|| restAssignDeptBudgetModel.getQuarter() != "") {
			s = s + "@p_quarter='" + restAssignDeptBudgetModel.getQuarter() + "',";
		}
		
		if (restAssignDeptBudgetModel.getCurrencyId() != null
				|| restAssignDeptBudgetModel.getCurrencyId() != "") {
			s = s + "@p_currency='" + restAssignDeptBudgetModel.getCurrencyId() + "',";
		}

		
		if (restAssignDeptBudgetModel.getCreatedBy() != null || restAssignDeptBudgetModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restAssignDeptBudgetModel.getCreatedBy() + "',";
		}
		if (restAssignDeptBudgetModel.getOrgName() != null || restAssignDeptBudgetModel.getOrgName() != "") {
			s = s + "@p_orgName='" + restAssignDeptBudgetModel.getOrgName() + "',";
		}
		if (restAssignDeptBudgetModel.getOrgDivision() != null || restAssignDeptBudgetModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restAssignDeptBudgetModel.getOrgDivision() + "',";
		}
		

	//	DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
	//	String dateString = dateFormat.format(new Date()).toString();
	//	System.out.println("Current time in AM/PM: " + dateString);
	//	s = s + "@p_createdTime='" + dateString + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

}
