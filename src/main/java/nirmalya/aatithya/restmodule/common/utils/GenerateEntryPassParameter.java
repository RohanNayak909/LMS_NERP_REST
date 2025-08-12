package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.ManagePassRestModel;

public class GenerateEntryPassParameter {


	public static String savePassDetails(ManagePassRestModel data) {
		String s = "";
	
		if (data.getPassId() != null && !data.getPassId().isEmpty()) {
			s = s + "@p_passId='" + data.getPassId() + "',";
		}
		
		if (data.getEmployeeId() != null && !data.getEmployeeId().isEmpty()) {
			s = s + "@p_employeeId='" + data.getEmployeeId() + "',";
		}
		
		if (data.getFromDate() == null || data.getFromDate().isEmpty()) {
		} else {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(data.getFromDate()) + "',";
		}
		
		if (data.getToDate() == null || data.getToDate().isEmpty()) {
		} else {
			s = s + "@p_toDate='" + DateFormatter.getStringDate(data.getToDate()) + "',";
		}
		
		if (data.getFromTime() != null && !data.getFromTime().isEmpty()) {
			s = s + "@p_fromTime=\"" + data.getFromTime() + "\",";
		}
		
		if (data.getToTime() != null && !data.getToTime().isEmpty()) {
			s = s + "@p_toTime=\"" + data.getToTime() + "\",";
		}
		
		if (data.getPurpose() != null && !data.getPurpose().isEmpty()) {
			s = s + "@p_passPurpose=\"" + data.getPurpose() + "\",";
		}

		if (data.getCreatedBy() != null && !data.getCreatedBy().isEmpty()) {
			s = s + "@p_createdBy='" + data.getCreatedBy() + "',";
		}
		
		if (data.getOrganization() != null && !data.getOrganization().isEmpty()) {
			s = s + "@p_org='" + data.getOrganization() + "',";
		}
		
		if (data.getOrgDivision() != null && !data.getOrgDivision().isEmpty()) {
			s = s + "@p_orgDiv='" + data.getOrgDivision() + "',";
		}

		if (!s.isEmpty()) {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}
}
