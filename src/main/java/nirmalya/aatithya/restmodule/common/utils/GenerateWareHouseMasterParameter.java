package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneMasterModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneRackModel;

public class GenerateWareHouseMasterParameter {
	public static String saveZoneMaster(ZoneMasterModel zoneMasterModel) {

		String s = "";

		if (zoneMasterModel.getZoneId() != null && zoneMasterModel.getZoneId() != "") {
			s = s + "@p_zoneId='" + zoneMasterModel.getZoneId() + "',";
		}
		if (zoneMasterModel.getWarehouseId() != null && zoneMasterModel.getWarehouseId() != "") {
			s = s + "@p_warehouseId='" + zoneMasterModel.getWarehouseId() + "',";
		}
		if (zoneMasterModel.getZoneName() != null && zoneMasterModel.getZoneName() != "") {
			s = s + "@p_zoneName='" + zoneMasterModel.getZoneName() + "',";
		}
		if (zoneMasterModel.getZoneCode() != null && zoneMasterModel.getZoneCode() != "") {
			s = s + "@p_zoneCode='" + zoneMasterModel.getZoneCode() + "',";
		}
		
		if (zoneMasterModel.getCreatedBy() != null && zoneMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + zoneMasterModel.getCreatedBy() + "',";
		}
		if (zoneMasterModel.getOrganization() != null && zoneMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + zoneMasterModel.getOrganization() + "',";
		}
		if (zoneMasterModel.getOrgDivision() != null && zoneMasterModel.getOrgDivision() != "") {
			s = s + "@p_div='" + zoneMasterModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("zoneG"+s);

		return s;
	}

	public static String saveRackMaster(ZoneRackModel zoneRackModel) {

		String s = "";

		
		if (zoneRackModel.getWarehouseId() != null && zoneRackModel.getWarehouseId() != "") {
			s = s + "@p_warehouseId='" + zoneRackModel.getWarehouseId() + "',";
		}
		if (zoneRackModel.getZoneId() != null && zoneRackModel.getZoneId() != "") {
			s = s + "@p_zoneId='" + zoneRackModel.getZoneId() + "',";
		}
		if (zoneRackModel.getRackId() != null && zoneRackModel.getRackId() != "") {
			s = s + "@p_rackId='" + zoneRackModel.getRackId() + "',";
		}
		if (zoneRackModel.getRackCode()!= null && zoneRackModel.getRackCode() != "") {
			s = s + "@p_rackCode='" + zoneRackModel.getRackCode() + "',";
		}
		if (zoneRackModel.getRackName() != null && zoneRackModel.getRackName() != "") {
			s = s + "@p_rackName='" + zoneRackModel.getRackName() + "',";
		}
		if (zoneRackModel.getCreatedBy() != null && zoneRackModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + zoneRackModel.getCreatedBy() + "',";
		}
		if (zoneRackModel.getOrganization() != null && zoneRackModel.getOrganization() != "") {
			s = s + "@p_org='" + zoneRackModel.getOrganization() + "',";
		}
		if (zoneRackModel.getOrgDivision() != null && zoneRackModel.getOrgDivision() != "") {
			s = s + "@p_div='" + zoneRackModel.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("rackG"+s);

		return s;
	}

	public static String getRackIdList(List<String> id) {

		String s = "";
		String section = "";
		
		if(id.size() > 0) {
			for(String m : id) {
				section = section + "\"" + m + "\",";
			}
			
			section = section.substring(0, section.length() - 1);
		}
		
		s = "(" + section + ")";
		
		s = "SET @p_sectionListSubQuery='" + s + "';";
		
		System.out.println(s);
		
		return s;
	}
	
public static String saveBin(WirehouseRomeModel location) {
		
		String s = "";
		
		if(location.getRackId()!=null && location.getRackId()!="") {
			s = s + "@p_rackId='" + location.getRackId() + "',";
		}
		if(location.getRoomId()!=null && location.getRoomId()!="") {
			s = s + "@p_roomId='" + location.getRoomId() + "',";
		}
		if(location.getRoomCode()!=null && location.getRoomCode()!="") {
			s = s + "@p_roomCode='" + location.getRoomCode() + "',";
		}
		if(location.getRoomName()!=null && location.getRoomName()!="") {
			s = s + "@p_roomName='" + location.getRoomName() + "',";
		}
		if(location.getRoomType()!=null && location.getRoomType()!="") {
			s = s + "@p_roomType='" + location.getRoomType() + "',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}
		if (location.getOrganization() != null && location.getOrganization() != "") {
			s = s + "@p_org='" + location.getOrganization() + "',";
		}
		if (location.getOrgDivision() != null && location.getOrgDivision() != "") {
			s = s + "@p_div='" + location.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("BIN"+s);
		
		return s;
		
	}
public static String saveBinConfig(WirehouseRomeModel config) {
	
	String s = "";
	
	if(config.getBinlist()!=null && config.getBinlist()!="") {
		s = s + "@p_binlist='(" + config.getBinlist() + ")',";
	}
	if(config.getCategory()!=null && config.getCategory()!="") {
		s = s + "@p_category='" + config.getCategory() + "',";
	}
	if(config.getItemName()!=null && config.getItemName()!="") {
		s = s + "@p_itemName='" + config.getItemName() + "',";
	}
	if(config.getQuantity()!=null) {
		s = s + "@p_qty='" + config.getQuantity() + "',";
	}
	if(config.getDesc()!=null && config.getDesc()!="") {
		s = s + "@p_desc='" + config.getDesc() + "',";
	}
	if(config.getCreatedBy()!=null && config.getCreatedBy()!="") {
		s = s + "@p_createdBy='" + config.getCreatedBy() + "',";
	}
	if (config.getOrganization() != null && config.getOrganization() != "") {
		s = s + "@p_org='" + config.getOrganization() + "',";
	}
	if (config.getOrgDivision() != null && config.getOrgDivision() != "") {
		s = s + "@p_div='" + config.getOrgDivision() + "',";
	}
	if (config.getUnit() != null && config.getUnit() != "") {
		s = s + "@p_unit='" + config.getUnit() + "',";
	}
	if (s != "") {
		s = s.substring(0, s.length() - 1);
		
		s = "SET " + s + ";";
	}
	
	System.out.println("Config=="+s);
	
	return s;
	
}

}
