package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.api.model.OvertimePunchinDetaillsModel;

public class GenerateovertimePunchInParam {
	
	public static String getOvertimePunchInParams(OvertimePunchinDetaillsModel form) {
		String s = "";

		if (form.getEmployee() != null && form.getEmployee() != "") {
			s = s + "@p_pnchid='" + form.getEmployee() + "',";
		}
		
		if (form.getDate() != null && form.getDate() != "") {
			s = s + "@p_pnchdate='" + DateFormatter.getStringDate(form.getDate()) + "',";
		}


		if (form.getPunchInTime() != null && form.getPunchInTime() != "") {
			s = s + "@p_pnchintime='" + DateFormatter.getStringDateTime(form.getPunchInTime())+ "',";
		}

		if (form.getPunchInLoc() != null && form.getPunchInLoc() != "") {
			s = s + "@p_pnchinloc='" + form.getPunchInLoc() + "',";
		}

		if (form.getPunchInLat() != null && form.getPunchInLat() != "") {
			s = s + "@p_pnchinlat='" + form.getPunchInLat() + "',";
		}

		if (form.getPunchInLong() != null && form.getPunchInLong() != "") {
			s = s + "@p_pnchinlong='" + form.getPunchInLong() + "',";
		}

		if (form.getPunchOutTime() != null && form.getPunchOutTime() != "") {
			s = s + "@p_pnchottime='" + DateFormatter.getStringDateTime(form.getPunchOutTime()) + "',";
		}

		if (form.getPunchOutLoc() != null && form.getPunchOutLoc() != "") {
			s = s + "@p_pnchotloc='" + form.getPunchOutLoc() + "',";
		}
		
		
		if (form.getPunchOutLat() != null && form.getPunchOutLat() != "") {
			s = s + "@p_pnchotlat='" + form.getPunchOutLat() + "',";
		}
		
		if (form.getPunchOutLong() != null && form.getPunchOutLong() != "") {
			s = s + "@p_pnchotlong='" + form.getPunchOutLong() + "',";
		}
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdby='" + form.getCreatedBy() + "',";
		}
		if (form.getOrganization() != null && form.getOrganization() != "") {
			s = s + "@p_org='" + form.getOrganization() + "',";
		}
		
		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + form.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

}
