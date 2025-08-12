package nirmalya.aatithya.restmodule.common.utils.productionplan;

import java.util.List;

import nirmalya.aatithya.restmodule.productionplan.model.ManageBomRestModel;

public class GenerateBomDetailsParam {
	public static String getBomDetailsParam(List<ManageBomRestModel> bomDetails) {
		String s = "";
		String sitem = "";

		if (bomDetails.get(0).getBomid() != null || bomDetails.get(0).getBomid() != "") {
			s = s + "@p_bomId='" + bomDetails.get(0).getBomid() + "',";
		}

		if (bomDetails.get(0).getItemName() != null || bomDetails.get(0).getItemName() != "") {
			s = s + "@p_itemname='" + bomDetails.get(0).getItemName() + "',";
		}

		if (bomDetails.get(0).getItemId() != null || bomDetails.get(0).getItemId() != "") {
			s = s + "@p_itemid='" + bomDetails.get(0).getItemId() + "',";
		}

		if (bomDetails.get(0).getDescription() != null || bomDetails.get(0).getDescription() != "") {
			s = s + "@p_description='" + bomDetails.get(0).getDescription() + "',";
		}

		if (bomDetails.get(0).getCreatedBy() != null || bomDetails.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + bomDetails.get(0).getCreatedBy() + "',";
		}

		if (bomDetails.get(0).getOrganization() != null || bomDetails.get(0).getOrganization() != "") {
			s = s + "@p_org='" + bomDetails.get(0).getOrganization() + "',";
		}
		if (bomDetails.get(0).getOrgDivision() != null || bomDetails.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + bomDetails.get(0).getOrgDivision() + "',";
		}

		for (ManageBomRestModel m : bomDetails) {

			sitem = sitem + "(@p_bomId,\"" + m.getItemSubId() + "\",\"" + m.getItemUnitId() + "\",\""
					+ m.getActualQunt() + "\",\"" + m.getStandardQunt() + "\",\"" + m.getScrapQunt() + "\",\""
					+ m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";

		}

		// s = s + "@p_serviceId='" + bomDetails.get(0).getServiceId() +"',";
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	/*
	 * public static String getBomDeleteParam(ManageBomRestModel restBomModel) {
	 * String[] bomIds = restBomModel.getBomid().split(","); String s = ""; String
	 * sitem = ""; String act = ""; for (String a : bomIds) { sitem = sitem + "\"" +
	 * a + "\","; } sitem = sitem.substring(0, sitem.length() - 1); sitem = "(" +
	 * sitem + ")"; s = s + "@p_bomIds='" + sitem + "',";
	 * 
	 * 
	 * for (String a : userIds) {
	 * 
	 * act = act + "(\"" + resttravelModel.getModuleId() + "\",\"" +
	 * resttravelModel.getComponentId() + "\",\"" +
	 * resttravelModel.getSubComponentId() + "\",\"" + a + "\",\"" +
	 * "Delete Requisition" + "\",\"" + resttravelModel.getCreatedBy() + "\"),";
	 * 
	 * }
	 * 
	 * 
	 * 
	 * act = act.substring(0, act.length() - 1);
	 * 
	 * s = s + "@p_actSubQuery='" + act + "',";
	 * 
	 * 
	 * if (s != "") { s = s.substring(0, s.length() - 1);
	 * 
	 * s = "SET " + s + ";"; }
	 * 
	 * System.out.println("generated" + sitem);
	 * 
	 * return s; }
	 */
}
