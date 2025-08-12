package nirmalya.aatithya.restmodule.common.utils.asset;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetEquipementRequestRestModel;


public class GenerateStockRequestParam {
	public static String getRequestList(List<AssetEquipementRequestRestModel> av) {
		String s = "";
		String equipementParam = "";

		if (av.get(0).getRequestid() != null || av.get(0).getRequestid() != "") {
			s = s + "@p_requestid='" + av.get(0).getRequestid() + "',";
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
		
		for (AssetEquipementRequestRestModel a : av.get(0).getRequestList()) {
			equipementParam = equipementParam + "(@p_requestId,\"" + a.getTicketid() + "\",\""
					+ a.getAssetcat() + "\",\"" + a.getAssetscat() + "\",\"" + a.getRequestedQty() + "\",\"" + a.getApproveQty() + "\",\"" + a.getRemark() + "\",@p_createdBy,@p_org,@p_orgDiv),";
		}

		equipementParam = equipementParam.substring(0, equipementParam.length() - 1);

		s = s + "@p_Equipe='" + equipementParam + "'";

		if (s != "") {
			s = "SET " + s + ";";
		}
		System.out.println("GENERATE PARAM"+s);
		return s;
	}

}
