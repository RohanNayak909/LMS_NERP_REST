package nirmalya.aatithya.restmodule.common.utils.productionplan;

import nirmalya.aatithya.restmodule.productionplan.model.SackConfigurationRestModel;

public class GenerateSackConfigurationParam {
	
	public static String getSackConfigurationParam(SackConfigurationRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getSackId() != null && offDay.getSackId() != "") {
			s = s + "@p_sackId='" + offDay.getSackId() + "',";
		}else {
			s = s + "@p_sackId='',";
		}
		if (offDay.getSku() != null && offDay.getSku() != "") {
			s = s + "@p_sku='" + offDay.getSku() + "',";
		}
		if (offDay.getCaseConfig() != null && offDay.getCaseConfig() != "") {
			s = s + "@p_caseConfig='" + offDay.getCaseConfig() + "',";
		}
		if (offDay.getPackSize() != null && offDay.getPackSize() != "") {
			s = s + "@p_packSize='" + offDay.getPackSize() + "',";
		}
		if (offDay.getTotalMt() != null && offDay.getTotalMt() != "") {
			s = s + "@p_totalMt='" + offDay.getTotalMt() + "',";
		}
		if (offDay.getRemark() != null && offDay.getRemark() != "") {
			s = s + "@p_remark='" + offDay.getRemark() + "',";
		}
		
		if (offDay.getCreatedBy() != null && offDay.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + offDay.getCreatedBy() + "',";
		}
		if (offDay.getOrganization() != null && offDay.getOrganization() != "") {
			s = s + "@p_org='" + offDay.getOrganization() + "',";
		}
		if (offDay.getOrgDivision() != null && offDay.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + offDay.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
