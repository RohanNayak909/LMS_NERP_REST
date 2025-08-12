package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.EmpMonthlyWagePlusRestModel;

public class GenerateWagePlusParams {
	//
	public static String getWagePlusMasterParam(EmpMonthlyWagePlusRestModel empMonthlyWagePlusRestModel) {

		String s = "";

		if (empMonthlyWagePlusRestModel.getWagePlusId() != null ||  empMonthlyWagePlusRestModel.getWagePlusId() != "") {
			s = s + "@p_wageplusId='" + empMonthlyWagePlusRestModel.getWagePlusId() + "',";
		}
		if (empMonthlyWagePlusRestModel.getEmpId() != null ||  empMonthlyWagePlusRestModel.getEmpId() != "") {
			s = s + "@p_empId='" + empMonthlyWagePlusRestModel.getEmpId() + "',";
		}
		if (empMonthlyWagePlusRestModel.getYear() != null ||  empMonthlyWagePlusRestModel.getYear() != "") {
			s = s + "@p_year='" + empMonthlyWagePlusRestModel.getYear() + "',";
		}
		if (empMonthlyWagePlusRestModel.getMonth()!= null ||  empMonthlyWagePlusRestModel.getMonth() != "") {
			s = s + "@p_month='" + empMonthlyWagePlusRestModel.getMonth() + "',";
		}
		if (DateFormatter.getStringDate(empMonthlyWagePlusRestModel.getFromDate()) != null || DateFormatter.getStringDate(empMonthlyWagePlusRestModel.getFromDate()) != "") {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(empMonthlyWagePlusRestModel.getFromDate()) + "',";
		}
		if (DateFormatter.getStringDate(empMonthlyWagePlusRestModel.getToDate()) != null ||  DateFormatter.getStringDate(empMonthlyWagePlusRestModel.getToDate()) != "") {
			s = s + "@p_toDate='" + DateFormatter.getStringDate(empMonthlyWagePlusRestModel.getToDate()) + "',";
		}
		if (empMonthlyWagePlusRestModel.getFyear() != null ||  empMonthlyWagePlusRestModel.getFyear() != "") {
			s = s + "@p_fyear='" + empMonthlyWagePlusRestModel.getFyear() + "',";
		}
		if (empMonthlyWagePlusRestModel.getComponent() != null ||  empMonthlyWagePlusRestModel.getComponent() != "") {
			s = s + "@p_Component='" + empMonthlyWagePlusRestModel.getComponent() + "',";
		}
		if (empMonthlyWagePlusRestModel.getCreatedBy() != null ||  empMonthlyWagePlusRestModel.getCreatedBy() != "") {
			s = s + "@p_createdby='" + empMonthlyWagePlusRestModel.getCreatedBy() + "',";
		}
		if (empMonthlyWagePlusRestModel.getOrgName() != null ||  empMonthlyWagePlusRestModel.getOrgName() != "") {
			s = s + "@p_orgName='" + empMonthlyWagePlusRestModel.getOrgName() + "',";
		}
		if (empMonthlyWagePlusRestModel.getOrgDivision()!= null ||  empMonthlyWagePlusRestModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + empMonthlyWagePlusRestModel.getOrgDivision() + "',";
		}
	
		if (empMonthlyWagePlusRestModel.getAttBonus() != null ||  empMonthlyWagePlusRestModel.getAttBonus() != "") {
			s = s + "@p_attBonus='" + empMonthlyWagePlusRestModel.getAttBonus() + "',";
		}
		if (empMonthlyWagePlusRestModel.getPenalty() != null ||  empMonthlyWagePlusRestModel.getPenalty() != "") {
			s = s + "@p_penalty='" + empMonthlyWagePlusRestModel.getPenalty() + "',";
		}
		if (empMonthlyWagePlusRestModel.getArer()!= null ||  empMonthlyWagePlusRestModel.getArer() != "") {
			s = s + "@p_arer='" + empMonthlyWagePlusRestModel.getArer() + "',";
		}
		if (empMonthlyWagePlusRestModel.getSalAdv() != null ||  empMonthlyWagePlusRestModel.getSalAdv() != "") {
			s = s + "@p_salAdv='" + empMonthlyWagePlusRestModel.getSalAdv() + "',";
		}
		if (empMonthlyWagePlusRestModel.getOtherallow() != null ||  empMonthlyWagePlusRestModel.getOtherallow() != "") {
			s = s + "@p_otherallow='" + empMonthlyWagePlusRestModel.getOtherallow() + "',";
		}
		if (empMonthlyWagePlusRestModel.getOtherdeduct()!= null ||  empMonthlyWagePlusRestModel.getOtherdeduct() != "") {
			s = s + "@p_otherdeduct='" + empMonthlyWagePlusRestModel.getOtherdeduct() + "',";
		}
		if (empMonthlyWagePlusRestModel.getReward()!= null ||  empMonthlyWagePlusRestModel.getReward() != "") {
			s = s + "@p_reward='" + empMonthlyWagePlusRestModel.getReward() + "',";
		}
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
}