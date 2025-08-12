package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.grc.model.RestIncidentManageModel;

public class GenerateIncidentManageParameters {

	public static String getIncidentManageParam(RestIncidentManageModel restManageData) {

		String s = "";


		if (restManageData.getAssignNo() != null ||  restManageData.getAssignNo() != "") {
			s = s + "@p_assignNo='" + restManageData.getAssignNo() + "',";
		}
		if (restManageData.getIncidentNo() != null ||  restManageData.getIncidentNo() != "") {
			s = s + "@p_incidentNo='" + restManageData.getIncidentNo() + "',";
		}
		if (restManageData.getProjectId() != null ||  restManageData.getProjectId() != "") {
			s = s + "@p_projectId='" + restManageData.getProjectId() + "',";
		}
		if (restManageData.getAssignToId() != null ||  restManageData.getAssignToId() != "") {
			s = s + "@p_searchValue='" + restManageData.getAssignToId() + "',";
		}
		if (restManageData.getAssignTo() != null ||  restManageData.getAssignTo() != "") {
			s = s + "@p_assignTo='" + restManageData.getAssignTo() + "',";
		}
		if (restManageData.getTask() != null ||  restManageData.getTask() != "") {
			s = s + "@p_task='" + restManageData.getTask() + "',";
		}
		if (restManageData.getDueDate() != null ||  restManageData.getDueDate() != "") {
			s = s + "@p_dueDate='" + restManageData.getDueDate() + "',";
		}
		if (restManageData.getRemarks() != null || restManageData.getRemarks() != "") {
			s = s + "@p_remarks='" + restManageData.getRemarks() + "',";
		}
		
		
		

		if (restManageData.getOrganization() != null ||  restManageData.getOrganization() != "") {
			s = s + "@p_organization='" + restManageData.getOrganization() + "',";
		}
		if (restManageData.getOrgDivision() != null ||  restManageData.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restManageData.getOrgDivision() + "',";
		}
		if (restManageData.getCreatedBy() != null ||  restManageData.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restManageData.getCreatedBy() + "',";
		}
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
