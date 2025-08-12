package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.api.model.EmployeeProfileApiModel;

public class GenerateParamEmployeeProfileParameter {

	public static String getprofileImageUploadAPIParam(EmployeeProfileApiModel employeeProfileApiModel) {

		String s = "";

		if (employeeProfileApiModel.getEmpId() != null && employeeProfileApiModel.getEmpId() != "") {
			s = s + "@p_empId='" + employeeProfileApiModel.getEmpId() + "',";
		}
		if (employeeProfileApiModel.getAuthrizationType() != null && employeeProfileApiModel.getAuthrizationType() != "") {
			s = s + "@p_authType='" + employeeProfileApiModel.getAuthrizationType() + "',";
		}
		
		if (employeeProfileApiModel.getDocName() != null && employeeProfileApiModel.getDocName() != "") {
			s = s + "@p_docName='" + employeeProfileApiModel.getDocName() + "',";
		}

		if (employeeProfileApiModel.getEmpId() != null && employeeProfileApiModel.getEmpId() != "") {
			s = s + "@p_createdBy='" + employeeProfileApiModel.getEmpId() + "',";
		}
		if(employeeProfileApiModel.getOrganization() != null || employeeProfileApiModel.getOrganization() != "") {
			s = s + "@p_org='" + employeeProfileApiModel.getOrganization() + "',";
		}
		if(employeeProfileApiModel.getOrgDivision() != null || employeeProfileApiModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + employeeProfileApiModel.getOrgDivision() + "',";
		}

	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
}
