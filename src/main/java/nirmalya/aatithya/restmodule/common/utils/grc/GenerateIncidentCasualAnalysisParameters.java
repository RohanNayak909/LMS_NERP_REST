package nirmalya.aatithya.restmodule.common.utils.grc;

import nirmalya.aatithya.restmodule.grc.model.RestIncidentCasualAnalysisModel;

public class GenerateIncidentCasualAnalysisParameters {

	public static String getIncidentCasualAnalysisParam(RestIncidentCasualAnalysisModel restAnalysisData) {

		String s = "";


		if (restAnalysisData.getAssignNo() != null ||  restAnalysisData.getAssignNo() != "") {
			s = s + "@p_assignNo='" + restAnalysisData.getAssignNo() + "',";
		}
	/*	
		if (restAnalysisData.getAssignTo() != null ||  restAnalysisData.getAssignTo() != "") {
			s = s + "@p_assignTo='" + restAnalysisData.getAssignTo() + "',";
		}
		if (restAnalysisData.getTask() != null ||  restAnalysisData.getTask() != "") {
			s = s + "@p_task='" + restAnalysisData.getTask() + "',";
		}
		if (restAnalysisData.getDueDate() != null ||  restAnalysisData.getDueDate() != "") {
			s = s + "@p_dueDate='" + restAnalysisData.getDueDate() + "',";
		}
		if (restAnalysisData.getRemarks() != null || restAnalysisData.getRemarks() != "") {
			s = s + "@p_remarks='" + restAnalysisData.getRemarks() + "',";
		}
	*/	
		
		if (restAnalysisData.getCasualAnalysis() != null ||  restAnalysisData.getCasualAnalysis() != "") {
			s = s + "@p_casualAnalysis='" + restAnalysisData.getCasualAnalysis() + "',";
		}
		if (restAnalysisData.getStatus() != null ||  restAnalysisData.getStatus() != "") {
			s = s + "@p_status='" + restAnalysisData.getStatus() + "',";
		}
		if (restAnalysisData.getCloseDate() != null || restAnalysisData.getCloseDate() != "") {
			s = s + "@p_closeDate='" + restAnalysisData.getCloseDate() + "',";
		}

		if (restAnalysisData.getOrganization() != null ||  restAnalysisData.getOrganization() != "") {
			s = s + "@p_organization='" + restAnalysisData.getOrganization() + "',";
		}
		if (restAnalysisData.getOrgDivision() != null ||  restAnalysisData.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restAnalysisData.getOrgDivision() + "',";
		}
		if (restAnalysisData.getCreatedBy() != null ||  restAnalysisData.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restAnalysisData.getCreatedBy() + "',";
		}
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
