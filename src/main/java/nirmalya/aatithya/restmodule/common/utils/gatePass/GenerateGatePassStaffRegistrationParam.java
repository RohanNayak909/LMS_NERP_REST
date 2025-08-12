package nirmalya.aatithya.restmodule.common.utils.gatePass;

import nirmalya.aatithya.restmodule.gatepass.model.GatePassStaffRegisterModel;

public class GenerateGatePassStaffRegistrationParam {

	public static String getAddPunchInOutParam(GatePassStaffRegisterModel data) {

		String s = "";

		if (data.getEmpId() != null && data.getEmpId() != "") {
			s = s + "@p_empId='" + data.getEmpId() + "',";
		}
		if (data.getDate() != null && data.getDate() != "") {
			s = s + "@p_date='" + data.getDate() + "',";
		}
		if (data.getPunchInDateTime() != null && data.getPunchInDateTime() != "") {
			s = s + "@p_punchInTime='" + data.getPunchInDateTime() + "',";
		}
		if (data.getPunchInLocation() != null && data.getPunchInLocation() != "") {
			s = s + "@p_punchInLoc='" + data.getPunchInLocation() + "',";
		}
		if (data.getPunchInLatitude() != null && data.getPunchInLatitude() != "") {
			s = s + "@p_punchInLatitude='" + data.getPunchInLatitude() + "',";
		}
		if (data.getPunchInLongitude() != null && data.getPunchInLongitude() != "") {
			s = s + "@p_punchInLongitude='" + data.getPunchInLongitude() + "',";
		}
		if (data.getPunchInNote() != null && data.getPunchInNote() != "") {
			s = s + "@p_punchInNote='" + data.getPunchInNote() + "',";
		}
		
		if (data.getPunchOutDateTime() != null && data.getPunchOutDateTime() != "") {
			s = s + "@p_punchOutTime='" + data.getPunchOutDateTime() + "',";
		}
		if (data.getPunchOutLocation() != null && data.getPunchOutLocation() != "") {
			s = s + "@p_punchOutLoc='" + data.getPunchOutLocation() + "',";
		}
		if (data.getPunchOutLatitude() != null && data.getPunchOutLatitude() != "") {
			s = s + "@p_punchOutLatitude='" + data.getPunchOutLatitude() + "',";
		}
		if (data.getPunchOutLongitude() != null && data.getPunchOutLongitude() != "") {
			s = s + "@p_punchOutLongitude='" + data.getPunchOutLongitude() + "',";
		}
		if (data.getPunchOutNote() != null && data.getPunchOutNote() != "") {
			s = s + "@p_punchOutNote='" + data.getPunchOutNote() + "',";
		}
		
		if (data.getCreatedBy() != null && data.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + data.getCreatedBy() + "',";
		}
		if (data.getOrganization() != null && data.getOrganization() != "") {
			s = s + "@p_org='" + data.getOrganization() + "',";
		}
		if (data.getOrgDivision() != null && data.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + data.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}
}
