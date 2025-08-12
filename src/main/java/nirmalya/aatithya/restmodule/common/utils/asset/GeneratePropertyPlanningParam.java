package nirmalya.aatithya.restmodule.common.utils.asset;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetPlanningRestModel;


public class GeneratePropertyPlanningParam {
	public static String addPlanProperty(List<AssetPlanningRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getPlanId() != null || av.get(0).getPlanId() != "") {
			s = s + "@p_PlanId='" + av.get(0).getPlanId() + "',";
		}
		if (av.get(0).getSpaceId() != null || av.get(0).getSpaceId() != "") {
			s = s + "@p_SpaceId='" + av.get(0).getSpaceId() + "',";
		}
		if (av.get(0).getSpaceName() != null || av.get(0).getSpaceName() != "") {
			s = s + "@p_SpaceName='" + av.get(0).getSpaceName() + "',";
		}
		if (av.get(0).getPropertyId() != null || av.get(0).getPropertyId() != "") {
			s = s + "@p_PropertyId='" + av.get(0).getPropertyId() + "',";
		}
		if (av.get(0).getFloorId() != null || av.get(0).getFloorId() != "") {
			s = s + "@p_FloorId='" + av.get(0).getFloorId() + "',";
		}
		if (av.get(0).getApprovedSts() != null || av.get(0).getApprovedSts() != "") {
			s = s + "@p_ApprovedSts='" + av.get(0).getApprovedSts() + "',";
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


		for (AssetPlanningRestModel m : av.get(0).getPlanList()) {
			sitem = sitem + "(@p_PlanId,\"" + m.getSpaceId() + "\",\"" + m.getFloorId() + "\",\"" + m.getPropertyId()
			+ "\",\"" + m.getAssetCategory() + "\",\"" + m.getAssetSubcategory() + "\",\"" + m.getDefiniteQty()+ "\",\"" + m.getRequiredQty()+ "\",\"" + m.getApprovedQty() + "\",@p_org,@p_orgDiv),";
		}
		if(sitem.length()!=0) {
			sitem = sitem.substring(0, sitem.length() - 1);
		}

		s = s + "@p_planningQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("VALUES::::"+s);
		return s;
	}

}
