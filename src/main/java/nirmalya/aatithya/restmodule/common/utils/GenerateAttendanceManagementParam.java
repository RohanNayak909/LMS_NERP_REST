package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.api.model.AttendanceModel;

public class GenerateAttendanceManagementParam {

	public static String getAttendanceParam(AttendanceModel attendanceModel) {

		String s = "";

		if (attendanceModel.gettEmployee() != null || attendanceModel.gettEmployee() != "") {
			s = s + "@p_empId='" + attendanceModel.gettEmployee() + "',";
		}

		if (attendanceModel.gettAttndncDate() != null || attendanceModel.gettAttndncDate() != "") {
			s = s + "@p_atndDate='" + attendanceModel.gettAttndncDate() + "',";
		}

		if (attendanceModel.gettAttndncPunchIn() != null || attendanceModel.gettAttndncPunchIn() != "") {
			s = s + "@p_atndPunchIn='" + attendanceModel.gettAttndncPunchIn() + "',";
		}

		if (attendanceModel.gettAttndncPunchInLoc() != null || attendanceModel.gettAttndncPunchInLoc() != "") {
			s = s + "@p_atndPunchInLoc='" + attendanceModel.gettAttndncPunchInLoc() + "',";
		}

		if (attendanceModel.gettAttndncPunchInLat() != null || attendanceModel.gettAttndncPunchInLat() != "") {
			s = s + "@p_atndPunchInLat='" + attendanceModel.gettAttndncPunchInLat() + "',";
		}

		if (attendanceModel.gettAttndncPunchInLong() != null || attendanceModel.gettAttndncPunchInLong() != "") {
			s = s + "@p_atndPunchInLong='" + attendanceModel.gettAttndncPunchInLong() + "',";
		}
		if (attendanceModel.getPunchInDist() != null || attendanceModel.getPunchInDist() != "") {
			s = s + "@p_atndPunchInDist='" + attendanceModel.getPunchInDist() + "',";
		}

		if (attendanceModel.gettAttndncPunchInNote() != null || attendanceModel.gettAttndncPunchInNote() != "") {
			s = s + "@p_atndPunchInNote='" + attendanceModel.gettAttndncPunchInNote() + "',";
		}

		if (attendanceModel.gettAttndncPunchInLogin() != null || attendanceModel.gettAttndncPunchInLogin() != "") {
			s = s + "@p_atndLoginTypePunchIn='" + attendanceModel.gettAttndncPunchInLogin() + "',";
		}

		if (attendanceModel.gettAttndncPunchOut() != null ) {
			s = s + "@p_atndPunchOut='" + attendanceModel.gettAttndncPunchOut() + "',";
		}

		if (attendanceModel.gettAttndncPunchOut_Loc() != null || attendanceModel.gettAttndncPunchOut_Loc() != "") {
			s = s + "@p_atndPunchOutLoc='" + attendanceModel.gettAttndncPunchOut_Loc() + "',";
		}

		if (attendanceModel.gettAttndncPunchOut_Lat() != null || attendanceModel.gettAttndncPunchOut_Lat() != "") {
			s = s + "@p_atndPunchOutLat='" + attendanceModel.gettAttndncPunchOut_Lat() + "',";
		}

		if (attendanceModel.gettAttndncPunchOut_Long() != null || attendanceModel.gettAttndncPunchOut_Long() != "") {
			s = s + "@p_atndPunchOutLong='" + attendanceModel.gettAttndncPunchOut_Long() + "',";
		}
		if (attendanceModel.getPunchOutDist() != null || attendanceModel.getPunchOutDist() != "") {
			s = s + "@p_atndPunchOutDist='" + attendanceModel.getPunchOutDist() + "',";
		}
		if (attendanceModel.gettAttndncPunchOutNote() != null || attendanceModel.gettAttndncPunchOutNote() != "") {
			s = s + "@p_atndPunchOutNote='" + attendanceModel.gettAttndncPunchOutNote() + "',";
		}

		if (attendanceModel.gettAttndncPunchOutLogin() != null || attendanceModel.gettAttndncPunchOutLogin() != "") {
			s = s + "@p_atndLoginTypePunchOut='" + attendanceModel.gettAttndncPunchOutLogin() + "',";
		}
		if(attendanceModel.getOrganization() != null || attendanceModel.getOrganization() != "") {
			s = s + "@p_org='" + attendanceModel.getOrganization() + "',";
		}
		if(attendanceModel.getOrgDivision() != null || attendanceModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + attendanceModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println(s);
		}

		return s;

	}

}
