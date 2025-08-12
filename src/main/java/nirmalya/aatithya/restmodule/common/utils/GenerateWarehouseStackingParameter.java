package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

public class GenerateWarehouseStackingParameter {

	public static String saveStackdataParam(WirehouseRomeModel wirehouseRomeModel) {

		String s = "";
		String zoneId = "";
		String rackId = "";
		String allocationId = "";
		String oldBinId = "";
		String newBinId = "";
		String organization = "";
		String orgDivision = "";

		zoneId = wirehouseRomeModel.getZoneId();
		rackId = wirehouseRomeModel.getRackId();
		allocationId = wirehouseRomeModel.getAllocationId();
		oldBinId = wirehouseRomeModel.getOldBinId();
		newBinId = wirehouseRomeModel.getNewBinId();
		organization = wirehouseRomeModel.getOrganization();
		orgDivision = wirehouseRomeModel.getOrgDivision();

		if (zoneId != null && zoneId != "")
			s = s + "@p_zoneId='" + zoneId + "',";
		else
			s = s + "@p_zoneId=null,";
		if (rackId != null && rackId != "")
			s = s + "@p_rackId='" + rackId + "',";
		else
			s = s + "@p_rackId=null,";
		if (allocationId != null && allocationId != "")
			s = s + "@p_allocationId='" + allocationId + "',";
		else
			s = s + "@p_allocationId=null,";
		if (oldBinId != null && oldBinId != "")
			s = s + "@p_oldBinId='" + oldBinId + "',";
		else
			s = s + "@p_oldBinId=null,";
		if (newBinId != null && newBinId != "")
			s = s + "@p_newBinId='" + newBinId + "',";
		else
			s = s + "@p_newBinId=null,";
		if (organization != null && organization != "")
			s = s + "@p_organization='" + organization + "',";
		else
			s = s + "@p_organization=null,";
		if (orgDivision != null && orgDivision != "")
			s = s + "@p_orgDivision='" + orgDivision + "',";
		else
			s = s + "@p_orgDivision=null,";

		if (wirehouseRomeModel != null && s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}

}
