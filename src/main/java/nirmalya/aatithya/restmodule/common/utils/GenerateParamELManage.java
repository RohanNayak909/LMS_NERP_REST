package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestELManageModel;

public class GenerateParamELManage {

	public static String getELManageParam(RestELManageModel vitamin) {
		String s = "";
		System.out.println(vitamin);
		if (vitamin.getEarnLeaveID() != null && vitamin.getEarnLeaveID() != "") {
			s = s + "@p_earnedID='" + vitamin.getEarnLeaveID() + "',";
		}else {
			s = s + "@p_earnedID='',";
		}
		if (vitamin.getEmpId() != null && vitamin.getEmpId() != "") {
			s = s + "@p_empId='" + vitamin.getEmpId() + "',";
		}
		if (vitamin.getEmployeeName() != null && vitamin.getEmployeeName() != "") {
			s = s + "@p_empName='" + vitamin.getEmployeeName() + "',";
		}
		if (vitamin.getPrevEL() != null && vitamin.getPrevEL() != "") {
			s = s + "@p_prevEL='" + vitamin.getPrevEL() + "',";
		}
		if (vitamin.getAssignedEL() != null && vitamin.getAssignedEL() != "") {
			s = s + "@p_assignedEL='" + vitamin.getAssignedEL() + "',";
		}
		if (vitamin.getAvailedEL() != null && vitamin.getAvailedEL() != "") {
			s = s + "@p_availedEL='" + vitamin.getAvailedEL() + "',";
		}
		if (vitamin.getBalanceEL() != null && vitamin.getBalanceEL() != "") {
			s = s + "@p_balanceEL='" + vitamin.getBalanceEL() + "',";
		}
		if (vitamin.getTotalEL() != null && vitamin.getTotalEL() != "") {
			s = s + "@p_totalEL='" + vitamin.getTotalEL() + "',";
		}
		if (vitamin.getYear() != null && vitamin.getYear() != "") {
			s = s + "@p_year='" + vitamin.getYear() + "',";
		}
		
		if (vitamin.getCreatedBy() != null && vitamin.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + vitamin.getCreatedBy() + "',";
		}
		if (vitamin.getOrganization() != null && vitamin.getOrganization() != "") {
			s = s + "@p_org='" + vitamin.getOrganization() + "',";
		}
		if (vitamin.getOrgDivision() != null && vitamin.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + vitamin.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
