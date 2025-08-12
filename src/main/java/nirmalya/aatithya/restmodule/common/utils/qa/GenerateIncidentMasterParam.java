package nirmalya.aatithya.restmodule.common.utils.qa;
import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.RestIncidentRegisterModel;
public class GenerateIncidentMasterParam {
	
	public static String getAddIncident(List<RestIncidentRegisterModel> restIncidentRegisterModel) {
		String s = "";
		String sitem = "";

		if (restIncidentRegisterModel.get(0).getIncidentId() != null || restIncidentRegisterModel.get(0).getIncidentId() != "") {
			s = s + "@p_incidentId='" + restIncidentRegisterModel.get(0).getIncidentId() + "',";
		}

		if (restIncidentRegisterModel.get(0).getDate() != null || restIncidentRegisterModel.get(0).getDate() != "") {
			s = s + "@p_date='" + restIncidentRegisterModel.get(0).getDate() + "',";
		}


		if (restIncidentRegisterModel.get(0).getCreatedBy() != null || restIncidentRegisterModel.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restIncidentRegisterModel.get(0).getCreatedBy() + "',";
		}

		if (restIncidentRegisterModel.get(0).getOrganization() != null || restIncidentRegisterModel.get(0).getOrganization() != "") {
			s = s + "@p_org='" + restIncidentRegisterModel.get(0).getOrganization() + "',";
		}
		if (restIncidentRegisterModel.get(0).getOrgDivision() != null || restIncidentRegisterModel.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restIncidentRegisterModel.get(0).getOrgDivision() + "',";
		}

		for (RestIncidentRegisterModel m : restIncidentRegisterModel) {
			sitem = sitem + "(@p_incidentId,\"" + m.getDateOfIssue() + "\",\"" + m.getShift() +
					"\",\"" + m.getMachine() + "\",\"" + m.getIncident() + "\",\"" + m.getRejected() + "\",\"" + m.getQuantity()
					+ "\",\"" + m.getRemark() + "\",\"" + m.getSignature() + "\",\"" +  restIncidentRegisterModel.get(0).getCreatedBy()  + "\""
					+ ",\"" + restIncidentRegisterModel.get(0).getOrgDivision()+ "\",\"" + restIncidentRegisterModel.get(0).getOrgDivision() + "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("----------------------------------------"+s);

		return s;
	}

}
