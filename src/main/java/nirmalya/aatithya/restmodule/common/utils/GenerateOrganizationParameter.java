package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestOrganizationMasterModel;

public class GenerateOrganizationParameter {

public static String saveOrganizationCategory(RestOrganizationMasterModel organization) {
		
		String s = "";
		
		if(organization.getOrganizationalId()!=null && organization.getOrganizationalId()!="") {
			s = s + "@p_organizationId='" + organization.getOrganizationalId() + "',";
		}
		if(organization.getOrganizationalName()!=null && organization.getOrganizationalName()!="") {
			s = s + "@p_organizationName='" + organization.getOrganizationalName() + "',";
		}
		if(organization.getAssignEmployee()!=null && organization.getAssignEmployee()!="") {
			s = s + "@p_assignEmployee='" + organization.getAssignEmployee() + "',";
		}
		if(organization.getParentId()!=null && organization.getParentId()!="") {
			s = s + "@p_parentId='" + organization.getParentId() + "',";
		}
		if(organization.getCreatedBy()!=null && organization.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + organization.getCreatedBy() + "',";
		}
		if(organization.getOrgName()!=null && organization.getOrgName()!="") {
			s = s + "@p_org='" + organization.getOrgName() + "',";
		}
		if(organization.getOrgDivision()!=null && organization.getOrgDivision()!="") {
			s = s + "@p_orgDiv='" + organization.getOrgDivision() + "',";
		}
		if(organization.getOrganizationalStatus()!=null && organization.getOrganizationalStatus()!="") {
			s = s + "@p_isActive='" + organization.getOrganizationalStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}
}
