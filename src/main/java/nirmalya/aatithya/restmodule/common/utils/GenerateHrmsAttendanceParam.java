package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestHrmsAttendanceModel;

public class GenerateHrmsAttendanceParam {
	
public static String getAttendanceData(RestHrmsAttendanceModel attendanceModel) {
		
		String s = "";
		if (attendanceModel.getEmpId() != null && attendanceModel.getEmpId() != "") {
			s = s + "@p_empId='" + attendanceModel.getEmpId() + "',";
		}
		if (attendanceModel.getDate() != null && attendanceModel.getDate() != "") {
			s = s + "@p_getDate='" + DateFormatter.getStringDate(attendanceModel.getDate()) + "',";
		}
		if (attendanceModel.getShift() != null && attendanceModel.getShift() != "") {
			s = s + "@p_shift='" + attendanceModel.getShift() + "',";
		}
		if (attendanceModel.getTime() != null && attendanceModel.getTime() != "") {
			s = s + "@p_time='" + attendanceModel.getTime() + "',";
		}
		if (attendanceModel.getPunchOutTime() != null && attendanceModel.getPunchOutTime() != "") {
			s = s + "@p_punchOutTime='" + attendanceModel.getPunchOutTime() + "',";
		}
		if (attendanceModel.getCreatedBy() != null && attendanceModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + attendanceModel.getCreatedBy() + "',";
		}
		if (attendanceModel.getOrganization() != null && attendanceModel.getOrganization() != "") {
			s = s + "@p_org='" + attendanceModel.getOrganization() + "',";
		}
		if (attendanceModel.getOrgDivision() != null && attendanceModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + attendanceModel.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("Generate Param==="+s);
		}
		return s;
	}

}
