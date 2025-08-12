package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestOFFManageModel;

public class GenerateParamOffDays {

	public static String getOffDaysParam(RestOFFManageModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getOffId() != null && offDay.getOffId() != "") {
			s = s + "@p_offID='" + offDay.getOffId() + "',";
		}else {
			s = s + "@p_offID='',";
		}
		if (offDay.getEmpId() != null && offDay.getEmpId() != "") {
			s = s + "@p_empId='" + offDay.getEmpId() + "',";
		}
		if (offDay.getEmployeeName() != null && offDay.getEmployeeName() != "") {
			s = s + "@p_empName='" + offDay.getEmployeeName() + "',";
		}
		if (offDay.getOffDays() != null && offDay.getOffDays() != "") {
			s = s + "@p_offDays='" + offDay.getOffDays() + "',";
		}
		if (offDay.getDate() != null && offDay.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(offDay.getDate()) + "',";
		}
		if (offDay.getCreatedBy() != null && offDay.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + offDay.getCreatedBy() + "',";
		}
		if (offDay.getOrganization() != null && offDay.getOrganization() != "") {
			s = s + "@p_org='" + offDay.getOrganization() + "',";
		}
		if (offDay.getOrgDivision() != null && offDay.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + offDay.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
