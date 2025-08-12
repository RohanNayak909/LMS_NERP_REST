package nirmalya.aatithya.restmodule.common.utils.budget;

import nirmalya.aatithya.restmodule.budget.model.RestFinancialYearModel;

public class GenerateFinancialYearParam {
	public static String addFinancialYearInfo(RestFinancialYearModel restFinancialYearModel) {
		String s = "";
		if (restFinancialYearModel.getCreatedBy() != null || restFinancialYearModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restFinancialYearModel.getCreatedBy() + "',";
		}
		if (restFinancialYearModel.getOrgName() != null || restFinancialYearModel.getOrgName() != "") {
			s = s + "@p_orgName='" + restFinancialYearModel.getOrgName() + "',";
		}
		if (restFinancialYearModel.getOrgDivision() != null || restFinancialYearModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restFinancialYearModel.getOrgDivision() + "',";
		}		
		
		if (restFinancialYearModel.getFinancialYearId() != null || restFinancialYearModel.getFinancialYearId() != "") {
			s = s + "@p_financialYearId='" + restFinancialYearModel.getFinancialYearId() + "',";
		}
		if (restFinancialYearModel.getFinancialYearName() != null
				|| restFinancialYearModel.getFinancialYearName() != "") {
			s = s + "@p_financialYearName='" + restFinancialYearModel.getFinancialYearName() + "',";
		}

		if (restFinancialYearModel.getFinancialYearStartDate() != null || restFinancialYearModel.getFinancialYearStartDate() != "") {
			s = s + "@p_financialYearStartDate='" + restFinancialYearModel.getFinancialYearStartDate() + "',";
		}
		if (restFinancialYearModel.getFinancialYearEndDate() != null || restFinancialYearModel.getFinancialYearEndDate() != "") {
			s = s + "@p_financialYearEndDate='" + restFinancialYearModel.getFinancialYearEndDate() + "',";
		}
		if (restFinancialYearModel.getDescription() != null
				|| restFinancialYearModel.getDescription() != "") {
			s = s + "@p_description='" + restFinancialYearModel.getDescription() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;
		
		}
}
