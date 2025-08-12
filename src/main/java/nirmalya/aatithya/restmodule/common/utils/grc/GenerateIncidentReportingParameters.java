package nirmalya.aatithya.restmodule.common.utils.grc;

import nirmalya.aatithya.restmodule.grc.model.RestIncidentReportingModel;

public class GenerateIncidentReportingParameters {

	public static String getIncidentReportingParam(RestIncidentReportingModel restMasterData) {

		String s = "";


		if (restMasterData.getIncidentNo() != null ||  restMasterData.getIncidentNo() != "") {
			s = s + "@p_incidentNo='" + restMasterData.getIncidentNo() + "',";
		}
		if (restMasterData.getDate() != null ||  restMasterData.getDate() != "") {
			s = s + "@p_date='" + restMasterData.getDate() + "',";
		}
		if (restMasterData.getType() != null || restMasterData.getType() != "") {
			s = s + "@p_type='" + restMasterData.getType() + "',";
		}
		if (restMasterData.getDescription() != null ||  restMasterData.getDescription() != "") {
			s = s + "@p_description='" + restMasterData.getDescription() + "',";
		}
		if (restMasterData.getReportedBy() != null || restMasterData.getReportedBy() != "") {
			s = s + "@p_reportedBy='" + restMasterData.getReportedBy() + "',";
		}
		if (restMasterData.getProjectId() != null ||  restMasterData.getProjectId() != "") {
			s = s + "@p_projectId='" + restMasterData.getProjectId() + "',";
		}
		if (restMasterData.getSeverity() != null || restMasterData.getSeverity() != "") {
			s = s + "@p_severity='" + restMasterData.getSeverity() + "',";
		}
		if (restMasterData.getActionTaken() != null ||  restMasterData.getActionTaken() != "") {
			s = s + "@p_actionTaken='" + restMasterData.getActionTaken() + "',";
		}
		if (restMasterData.getLocation() != null || restMasterData.getLocation() != "") {
			s = s + "@p_location='" + restMasterData.getLocation() + "',";
		}
		if (restMasterData.getLatitude() != null ||  restMasterData.getLatitude() != "") {
			s = s + "@p_latitude='" + restMasterData.getLatitude() + "',";
		}
		if (restMasterData.getLongitude() != null || restMasterData.getLongitude() != "") {
			s = s + "@p_longitude='" + restMasterData.getLongitude() + "',";
		}

		
		if (restMasterData.getStatus() != null ||  restMasterData.getStatus() != "") {
			s = s + "@p_status='" + restMasterData.getStatus() + "',";
		}
		if (restMasterData.getOrganization() != null ||  restMasterData.getOrganization() != "") {
			s = s + "@p_organization='" + restMasterData.getOrganization() + "',";
		}
		if (restMasterData.getOrgDivision() != null ||  restMasterData.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restMasterData.getOrgDivision() + "',";
		}
		if (restMasterData.getCreatedBy() != null ||  restMasterData.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restMasterData.getCreatedBy() + "',";
		}
		
		


		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
