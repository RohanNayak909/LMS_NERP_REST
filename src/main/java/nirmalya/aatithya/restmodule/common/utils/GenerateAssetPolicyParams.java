package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;


public class GenerateAssetPolicyParams {
	public static String getAddAssetPolicy(List<AssetPoilcyRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getPolicyid() != null || av.get(0).getPolicyid() != "") {
			s = s + "@p_policyid='" + av.get(0).getPolicyid() + "',";
		}
		if (av.get(0).getCatid() != null || av.get(0).getCatid() != "") {
			s = s + "@p_catid='" + av.get(0).getCatid() + "',";
		}
		if (av.get(0).getAssetsubcat() != null || av.get(0).getAssetsubcat() != "") {
			s = s + "@p_assetsubcat='" + av.get(0).getAssetsubcat() + "',";
		}
		if (av.get(0).getFrequency() != null || av.get(0).getFrequency() != "") {
			s = s + "@p_frequency='" + av.get(0).getFrequency() + "',";
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

		for (AssetPoilcyRestModel m : av) {

			sitem = sitem + "(@p_policyid,\"" + m.getPolicyName() + "\",\"" + m.getPriority() + "\",\"" + m.getDescription() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
