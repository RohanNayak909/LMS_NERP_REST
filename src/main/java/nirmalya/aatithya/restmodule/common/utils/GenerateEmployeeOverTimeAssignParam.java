package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.api.model.EmployeeOverTimeModel;

public class GenerateEmployeeOverTimeAssignParam {
	public static String getOverTimeParam(List<EmployeeOverTimeModel> overTimeModel) {

		String s = "";
		String sitem = "";
		String assignEmp = "";
		if (overTimeModel.get(0).getOrganization() != null || overTimeModel.get(0).getOrganization() != "") {
			s = s + "@p_org='" + overTimeModel.get(0).getOrganization() + "',";
		}
		if (overTimeModel.get(0).getOrgDivision() != null || overTimeModel.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + overTimeModel.get(0).getOrgDivision() + "',";
		}

		for (EmployeeOverTimeModel m : overTimeModel) {
			if(m.getAssignStatus().equals("0")) {
			assignEmp = assignEmp + "\"" + m.getEmployee() + "\",";
			sitem = sitem + "(\"" + m.getEmployee() + "\",\"" + m.getDept() + "\",\"" + m.getSubDept() + "\",\""
					+ DateFormatter.getStringDate(m.getOverTimeDate()) + "\",\"" + m.getOverTimeStart() + "\",\""
					+ m.getOverTimeEnd() + "\",\"" + m.getOverTimeDuration() + "\"," + "\"" + m.getAssignedBy()
					+ "\",\"" + overTimeModel.get(0).getOrganization() + "\",\"" + overTimeModel.get(0).getOrgDivision()
					+ "\"),";
		  }
		}
		if (!sitem.isEmpty()) {
			sitem = sitem.substring(0, sitem.length() - 1);
			assignEmp = assignEmp.substring(0, assignEmp.length() - 1);
			s = s + "@p_assignQuery='" + sitem + "',";
			s = s + "@p_assignQueryDate='" + DateFormatter.getStringDate(overTimeModel.get(0).getOverTimeDate()) + "',";
			s = s + "@p_assignQueryEmployee='" + "(" + assignEmp + ")" + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
