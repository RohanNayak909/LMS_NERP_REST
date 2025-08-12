package nirmalya.aatithya.restmodule.common.utils.account;

import nirmalya.aatithya.restmodule.account.model.RestMonthlyProvisionModel;



public class GenerateAccountMonthlyProvision {

	
	
	public static String getMonthlyprovisionParam(RestMonthlyProvisionModel restMonthlyProvisionModel) {

		String s = "";


		if (restMonthlyProvisionModel.getProvisionId() != null ||  restMonthlyProvisionModel.getProvisionId() != "") {
			s = s + "@p_provisionId='" + restMonthlyProvisionModel.getProvisionId() + "',";
		}
		if (restMonthlyProvisionModel.getCategoryId() != null ||  restMonthlyProvisionModel.getCategoryId() != "") {
			s = s + "@p_categoryId='" + restMonthlyProvisionModel.getCategoryId() + "',";
		}
		if (restMonthlyProvisionModel.getCategoryName() != null || restMonthlyProvisionModel.getCategoryName() != "") {
			s = s + "@p_categoryName='" + restMonthlyProvisionModel.getCategoryName() + "',";
		}

		
		if (restMonthlyProvisionModel.getProjectcost() != null ||  restMonthlyProvisionModel.getProjectcost() != "") {
			s = s + "@p_projectcost='" + restMonthlyProvisionModel.getProjectcost() + "',";
		}
		if (restMonthlyProvisionModel.getAnnualcost() != null ||  restMonthlyProvisionModel.getAnnualcost() != "") {
			s = s + "@p_annualcost='" + restMonthlyProvisionModel.getAnnualcost() + "',";
		}
		
		if (restMonthlyProvisionModel.getDifference() != null ||  restMonthlyProvisionModel.getDifference() != "") {
			s = s + "@p_difference='" + restMonthlyProvisionModel.getDifference() + "',";
		}
		
		if (restMonthlyProvisionModel.getYear() != null ||  restMonthlyProvisionModel.getYear() != "") {
			s = s + "@p_year='" + restMonthlyProvisionModel.getYear() + "',";
		}
		
		if (restMonthlyProvisionModel.getMonth() != null ||  restMonthlyProvisionModel.getMonth() != "") {
			s = s + "@p_month='" + restMonthlyProvisionModel.getMonth() + "',";
		}


		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	

}
