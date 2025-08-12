package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.EmployeeProfileFileUploadModel;

public class GenerateProfileUploadParam {

	
	public static String generateProfileUploadParam(EmployeeProfileFileUploadModel employeeProfileFileUploadModel) {
		
		String s = "";

		if (employeeProfileFileUploadModel.getFileName() != null && employeeProfileFileUploadModel.getFileName() != "") {
			s = s + "@p_getFileName='" + employeeProfileFileUploadModel.getFileName() + "',";
		}
		

		if (employeeProfileFileUploadModel.getCreatedBy() != null && employeeProfileFileUploadModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + employeeProfileFileUploadModel.getCreatedBy() + "',";
		}
		if(employeeProfileFileUploadModel.getOrganization() != null || employeeProfileFileUploadModel.getOrganization() != "") {
			s = s + "@p_org='" + employeeProfileFileUploadModel.getOrganization() + "',";
		}
		if(employeeProfileFileUploadModel.getOrgDivision() != null || employeeProfileFileUploadModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + employeeProfileFileUploadModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
