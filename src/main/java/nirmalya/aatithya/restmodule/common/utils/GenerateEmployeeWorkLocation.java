package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestEmployeeWorkLocationModel;
import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;

public class GenerateEmployeeWorkLocation {

	public static String addEmployeeWorkLocationParam(RestEmployeeWorkLocationModel restPayroll) {
		// TODO Auto-generated method stub
		String S = "";
		
		if(restPayroll.getOrganization() != null || restPayroll.getOrganization() != "") {
			S = S + "@p_org='" + restPayroll.getOrganization() + "',";
		}
		if(restPayroll.getOrgDivision() != null || restPayroll.getOrgDivision() != "") {
			S = S + "@p_orgDiv='" + restPayroll.getOrgDivision() + "',";
		}
		if(restPayroll.getLocId() != null || restPayroll.getLocId() != "") {
			S = S + "@p_locId='" + restPayroll.getLocId() + "',";
		}
		if(restPayroll.getEmpId() != null || restPayroll.getEmpId() != "") {
			S = S + "@p_empId='" + restPayroll.getEmpId() + "',";
		}
		if(restPayroll.getName() != null || restPayroll.getName() != "") {
			S = S + "@p_name='" + restPayroll.getName() + "',";
		}
		if(restPayroll.getLocationType() != null || restPayroll.getLocationType() != "") {
			S = S + "@p_locationType='" + restPayroll.getLocationType() + "',";
		}
		if(restPayroll.getLocation() != null || restPayroll.getLocation() != "") {
			S = S + "@p_location='" + restPayroll.getLocation() + "',";
		}
		if(restPayroll.getLatitude() != null || restPayroll.getLatitude() != "") {
			S = S + "@p_latitude='" + restPayroll.getLatitude() + "',";
		}
		if(restPayroll.getLongitude() != null || restPayroll.getLongitude() != "") {
			S = S + "@p_longitude='" + restPayroll.getLongitude() + "',";
		}
		if(restPayroll.getStatus() != null || restPayroll.getStatus() != "") {
			S = S + "@p_status='" + restPayroll.getStatus() + "',";
		}
		if(restPayroll.getCreatedBy() != null || restPayroll.getCreatedBy() != "") {
			S = S + "@p_createdBy='" + restPayroll.getCreatedBy() + "',";
		}
		if(restPayroll.getUpdatedBy() != null || restPayroll.getUpdatedBy() != "") {
			S = S + "@p_updatedBy='" + restPayroll.getUpdatedBy() + "',";
		}
		if(restPayroll.getUpdatedOn() != null || restPayroll.getUpdatedOn() != "") {
			S = S + "@p_updatedOn='" + restPayroll.getUpdatedOn() + "',";
		}
		
		if (S != "") {
			S = S.substring(0, S.length() - 1);

			S = "SET " + S + ";";
		}
		System.out.println(S);
		return S;
	}
	
	
}
