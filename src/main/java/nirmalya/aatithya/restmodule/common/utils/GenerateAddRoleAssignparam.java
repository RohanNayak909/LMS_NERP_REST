package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;

public class GenerateAddRoleAssignparam {

	
	public static String saveUserRoleAssignMaster(RestUserRoleAssignModel id) {
		String s = "";
		String data = "";
		String org="";
		String orgDiv="";
		if(id.getOrganization() != null || id.getOrganization() != "") {
			org=id.getOrganization();
		}
		if(id.getOrgDivision() != null || id.getOrgDivision() != "") {
			orgDiv=id.getOrgDivision();
		}
		if(id.getEmpId()!=null && id.getEmpId()!="") {
			s = s + "@p_empId='" + id.getEmpId() + "',";
		}
		if(id.getName()!=null && id.getName()!="") {
			s = s + "@p_name='" + id.getName() + "',";
		}
		if(id.getCont()!=null && id.getCont()!="") {
			s = s + "@p_cont='" + id.getCont() + "',";
		}
		if(id.getEmail()!=null && id.getEmail()!="") {
			s = s + "@p_email='" + id.getEmail() + "',";
		}

		
		if(id.getRoleList().size() > 0) {
			for(String m : id.getRoleList()) {
				data = data + "(@p_empId,\"" + m + "\",\""+org+"\",\""+orgDiv+"\"),";
			}
			
			data = data.substring(0, data.length() - 1);
		}
		s = s + "@p_userRoleList='" + data + "';";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		System.out.println(s);
		
		return s;
	}
}
