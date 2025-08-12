package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.BudgetPlanMasterModel;

public class GenerateBudgetPlanParameter {

	public static String saveBudgetPlan(List<BudgetPlanMasterModel> budgetPlanDtls) {
		String s = "";
		String budget = "";
		
		if(budgetPlanDtls.get(0).getYear()!=null && budgetPlanDtls.get(0).getYear()!="") {
			s = s + "@P_Year='" + budgetPlanDtls.get(0).getYear() + "',";
		}
		
		for(BudgetPlanMasterModel m : budgetPlanDtls) {
			budget = budget + "(\"" + m.getYear() + "\",\"" + m.getId() + "\"," + m.getJan() + "," +
					m.getFeb() + "," + m.getMar() + "," + m.getApr() + "," + m.getMay() + "," + m.getJun() +
					"," + m.getJul() + "," + m.getAug() + "," + m.getSep() + "," + m.getOct() + "," + m.getNov() +
					"," + m.getDec() + "," + m.getTotal() + ",\"" + m.getCreatedBy() + "\"),";
		}
		
		budget = budget.substring(0, budget.length() - 1);
		s = s + "@p_budgetSubQuery='" + budget + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

	public static String getCCByYear(String id, String mnth) {
		String s = "";
		
		if(id != null && id != "") {
			s = s + "@P_Year='" + id + "',";
		}
		
		if(mnth != null && mnth != "") {
			String[] mnthData = mnth.split(",");
			for(int i = 0; i < mnthData.length - 1; i++) {
				int c = i + 1;
				s = s + "@P_M"+c+"='" + mnthData[i] + "',";
			}
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getCAccntByCC(String id, String year, String mnth) {
		String s = "";
		
		if(id != null && id != "") {
			s = s + "@P_CostCenter='" + id + "',";
		}
		if(year != null && year != "") {
			s = s + "@P_Year='" + year + "',";
		}
		
		if(mnth != null && mnth != "") {
			String[] mnthData = mnth.split(",");
			for(int i = 0; i < mnthData.length - 1; i++) {
				int c = i + 1;
				s = s + "@P_M"+c+"='" + mnthData[i] + "',";
			}
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
