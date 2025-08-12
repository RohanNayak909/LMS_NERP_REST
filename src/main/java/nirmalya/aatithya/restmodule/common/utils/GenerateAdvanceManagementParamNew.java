package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModelNew;

public class GenerateAdvanceManagementParamNew {
	public static String getAdvManageParam(RestAdvanceManagementModelNew restAdvanceManagementModel) {

		String s = "";
		

		if(restAdvanceManagementModel.getOrganization() != null || restAdvanceManagementModel.getOrganization() != "") {
			s = s + "@p_org='" + restAdvanceManagementModel.getOrganization() + "',";
		}
		if(restAdvanceManagementModel.getOrgDivision() != null || restAdvanceManagementModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restAdvanceManagementModel.getOrgDivision() + "',";
		}
		if (restAdvanceManagementModel.getReqId() != null ||  restAdvanceManagementModel.getReqId() != "") {
			s = s + "@p_getReqId='" + restAdvanceManagementModel.getReqId() + "',";
		}

		if (restAdvanceManagementModel.getDate() != null ||  restAdvanceManagementModel.getDate() != "") {
			s = s + "@p_getDate='" + restAdvanceManagementModel.getDate() + "',";
		}
		if (restAdvanceManagementModel.getEligibility() != null || restAdvanceManagementModel.getEligibility() != "") {
			s = s + "@p_getEligibility='" + restAdvanceManagementModel.getEligibility() + "',";
		}

		if (restAdvanceManagementModel.getLoanamt() != null ) {
			s = s + "@p_getLoanamt='" + restAdvanceManagementModel.getLoanamt() + "',";
		}
		if (restAdvanceManagementModel.getTernure() != null ||  restAdvanceManagementModel.getTernure() != "") {
			s = s + "@p_getTernure='" + restAdvanceManagementModel.getTernure() + "',";
		}


		if (restAdvanceManagementModel.getIntrestRate() != null) {
			s = s + "@p_getIntrestRate=" + restAdvanceManagementModel.getIntrestRate() + ",";
		}
		if (restAdvanceManagementModel.getStatus() != null) {
			s = s + "@p_getStatus=" + restAdvanceManagementModel.getStatus() + ",";
		}

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
}
