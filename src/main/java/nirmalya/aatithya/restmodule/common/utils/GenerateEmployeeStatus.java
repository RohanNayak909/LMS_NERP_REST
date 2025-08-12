package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;

public class GenerateEmployeeStatus {
	
	public static String saveEmployeeMaster(RestUserRoleAssignModel id) {
		String s = "";
		String data = "";
		
		if(id.getEmpId()!=null && id.getEmpId()!="") {
			s = s + "@p_empId='" + id.getEmpId() + "',";
		}
		if(id.getName()!=null && id.getName()!="") {
			s = s + "@p_name='" + id.getName() + "',";
		}
		if(id.getEmpStatus()!=null ) {
			s = s + "@p_status='" + id.getEmpStatus() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}

}
