package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.grc.model.RestIncidentMasterModel;

public class GenerateIncidentMasterParameters {
	
	public static String getIncidentMasterParam(RestIncidentMasterModel restMasterData) {

		String s = "";


		if (restMasterData.getIncidentCode() != null ||  restMasterData.getIncidentCode() != "") {
			s = s + "@p_incidentCode='" + restMasterData.getIncidentCode() + "',";
		}
		if (restMasterData.getIncidentType() != null ||  restMasterData.getIncidentType() != "") {
			s = s + "@p_incidentType='" + restMasterData.getIncidentType() + "',";
		}
		if (restMasterData.getIncidentDesc() != null || restMasterData.getIncidentDesc() != "") {
			s = s + "@p_incidentDesc='" + restMasterData.getIncidentDesc() + "',";
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
