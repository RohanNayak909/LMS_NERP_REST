package nirmalya.aatithya.restmodule.common.utils.asset;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetEquipementRequestRestModel;


public class GenerateAssetEquipementParams {
	public static String addPlanProperty(List<AssetEquipementRequestRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getRequestid() != null || av.get(0).getRequestid() != "") {
			s = s + "@p_Requestid='" + av.get(0).getRequestid() + "',";
		}
		if (av.get(0).getAssetid() != null || av.get(0).getAssetid() != "") {
			s = s + "@p_assetid='" + av.get(0).getAssetid() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}
		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}
		
		for (AssetEquipementRequestRestModel m : av.get(0).getRequestList()) {
			sitem = sitem + "(\"" + m.getAssetid() + "\",\"" + m.getApproveQty() + "\"),";
		}
		if(sitem.length()!=0) {
			sitem = sitem.substring(0, sitem.length() - 1);
		}

		s = s + "@p_requestQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("VALUES::::"+s);
		return s;
	}

}
