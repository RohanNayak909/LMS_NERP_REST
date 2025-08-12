package nirmalya.aatithya.restmodule.common.utils.grc;

import nirmalya.aatithya.restmodule.grc.model.RestIncidentCorrectiveActionModel;

public class GenerateIncidentCorrectiveActionParameters {

	public static String getIncidentCorrectiveActionParam(RestIncidentCorrectiveActionModel restActionData) {

		String s = "";


		if (restActionData.getAssignNo() != null ||  restActionData.getAssignNo() != "") {
			s = s + "@p_assignNo='" + restActionData.getAssignNo() + "',";
		}
	/*	
		if (restActionData.getAssignTo() != null ||  restActionData.getAssignTo() != "") {
			s = s + "@p_assignTo='" + restActionData.getAssignTo() + "',";
		}
		if (restActionData.getTask() != null ||  restActionData.getTask() != "") {
			s = s + "@p_task='" + restActionData.getTask() + "',";
		}
		if (restActionData.getDueDate() != null ||  restActionData.getDueDate() != "") {
			s = s + "@p_dueDate='" + restActionData.getDueDate() + "',";
		}
		if (restActionData.getRemarks() != null || restActionData.getRemarks() != "") {
			s = s + "@p_remarks='" + restActionData.getRemarks() + "',";
		}
	*/	
		
		if (restActionData.getCorrectiveAction() != null ||  restActionData.getCorrectiveAction() != "") {
			s = s + "@p_correctiveAction='" + restActionData.getCorrectiveAction() + "',";
		}
		if (restActionData.getStatus() != null ||  restActionData.getStatus() != "") {
			s = s + "@p_status='" + restActionData.getStatus() + "',";
		}
		if (restActionData.getCloseDate() != null || restActionData.getCloseDate() != "") {
			s = s + "@p_closeDate='" + restActionData.getCloseDate() + "',";
		}

		if (restActionData.getOrganization() != null ||  restActionData.getOrganization() != "") {
			s = s + "@p_organization='" + restActionData.getOrganization() + "',";
		}
		if (restActionData.getOrgDivision() != null ||  restActionData.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restActionData.getOrgDivision() + "',";
		}
		if (restActionData.getCreatedBy() != null ||  restActionData.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restActionData.getCreatedBy() + "',";
		}
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
