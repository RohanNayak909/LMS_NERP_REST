package nirmalya.aatithya.restmodule.common.utils.store;

import java.util.List;

import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.store.model.StoreZoneMasterModel;
import nirmalya.aatithya.restmodule.store.model.StoreZoneRackModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneMasterModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneRackModel;

public class GenerateStoreDetailsMasterParameter {
	public static String saveStockZoneMaster(StoreZoneMasterModel stockZoneMasterModel) {

		String s = "";

		if (stockZoneMasterModel.getZoneId() != null && stockZoneMasterModel.getZoneId() != "") {
			s = s + "@p_zoneId='" + stockZoneMasterModel.getZoneId() + "',";
		}
		if (stockZoneMasterModel.getWarehouseId() != null && stockZoneMasterModel.getWarehouseId() != "") {
			s = s + "@p_warehouseId='" + stockZoneMasterModel.getWarehouseId() + "',";
		}
		if (stockZoneMasterModel.getZoneName() != null && stockZoneMasterModel.getZoneName() != "") {
			s = s + "@p_zoneName='" + stockZoneMasterModel.getZoneName() + "',";
		}
		if (stockZoneMasterModel.getZoneCode() != null && stockZoneMasterModel.getZoneCode() != "") {
			s = s + "@p_zoneCode='" + stockZoneMasterModel.getZoneCode() + "',";
		}
		
		if (stockZoneMasterModel.getCreatedBy() != null && stockZoneMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + stockZoneMasterModel.getCreatedBy() + "',";
		}
		if (stockZoneMasterModel.getOrganization() != null && stockZoneMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + stockZoneMasterModel.getOrganization() + "',";
		}
		if (stockZoneMasterModel.getOrgDivision() != null && stockZoneMasterModel.getOrgDivision() != "") {
			s = s + "@p_div='" + stockZoneMasterModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("zoneG"+s);

		return s;
	}
	
	public static String saveRackMasterr(StoreZoneRackModel stockZoneRackModel) {

		String s = "";

		
		if (stockZoneRackModel.getWarehouseId() != null && stockZoneRackModel.getWarehouseId() != "") {
			s = s + "@p_warehouseId='" + stockZoneRackModel.getWarehouseId() + "',";
		}
		if (stockZoneRackModel.getZoneId() != null && stockZoneRackModel.getZoneId() != "") {
			s = s + "@p_zoneId='" + stockZoneRackModel.getZoneId() + "',";
		}
		if (stockZoneRackModel.getRackId() != null && stockZoneRackModel.getRackId() != "") {
			s = s + "@p_rackId='" + stockZoneRackModel.getRackId() + "',";
		}
		if (stockZoneRackModel.getRackCode()!= null && stockZoneRackModel.getRackCode() != "") {
			s = s + "@p_rackCode='" + stockZoneRackModel.getRackCode() + "',";
		}
		if (stockZoneRackModel.getRackName() != null && stockZoneRackModel.getRackName() != "") {
			s = s + "@p_rackName='" + stockZoneRackModel.getRackName() + "',";
		}
		if (stockZoneRackModel.getCreatedBy() != null && stockZoneRackModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + stockZoneRackModel.getCreatedBy() + "',";
		}
		if (stockZoneRackModel.getOrganization() != null && stockZoneRackModel.getOrganization() != "") {
			s = s + "@p_org='" + stockZoneRackModel.getOrganization() + "',";
		}
		if (stockZoneRackModel.getOrgDivision() != null && stockZoneRackModel.getOrgDivision() != "") {
			s = s + "@p_div='" + stockZoneRackModel.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("rackG"+s);

		return s;
	}
	
	public static String getStockRackIdList(List<String> id) {

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
	
public static String saveStockBin(StoreRomeModel location) {
		
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

public static String saveStockBinConfig(StoreRomeModel config) {
	
	String s = "";
	String[] strArray;
	String listdata = "";
	String listdata1 = "";
	  if(config.getItemName()!=null && config.getItemName()!="") {
		  s = s + "@p_itemName='" + config.getItemName() + "',";
		  }
	  if (config.getOrganization() != null && config.getOrganization() != "") {
			s = s + "@p_org='" + config.getOrganization() + "',";
		}
		if (config.getOrgDivision() != null && config.getOrgDivision() != "") {
			s = s + "@p_div='" + config.getOrgDivision() + "',";
		}
	 
	if(config.getBinlist()!=null && config.getBinlist()!="") {
		strArray = config.getBinlist().split(",");  
		for (int i = 0; i< strArray.length; i++){ 
			System.out.println(strArray[i]); 
			listdata = listdata + "(\"" + strArray[i] + "\",\"" + config.getCategory() + "\",\""
					+ config.getItemName() + "\",\"" +config.getQuantity() + "\",\"" + config.getDesc() + "\",\""
					+ config.getUnit() + "\",\"" + config.getCreatedBy() + "\",\"" + config.getOrganization() + "\",\""
					+ config.getOrgDivision() + "\"),";
			
			
		
		    listdata1=listdata1+"\"" +  strArray[i] + "\""+",";		
			}  
	}
	
	if (!listdata.isEmpty()) {
		listdata = listdata.substring(0, listdata.length() - 1);
		s = s + "@p_stockItems='" + listdata + "',";
		
	
		}
	
	if (!listdata1.isEmpty()) {
		listdata1 = listdata1.substring(0, listdata1.length() - 1);
		s = s + "@p_binlist='(" + listdata1 + ")',";
		
	}
	
	/*
	 * if(config.getCategory()!=null && config.getCategory()!="") { s = s +
	 * "@p_category='" + config.getCategory() + "',"; }
	 * if(config.getItemName()!=null && config.getItemName()!="") { s = s +
	 * "@p_itemName='" + config.getItemName() + "',"; }
	 * if(config.getQuantity()!=null) { s = s + "@p_qty='" + config.getQuantity() +
	 * "',"; } if(config.getDesc()!=null && config.getDesc()!="") { s = s +
	 * "@p_desc='" + config.getDesc() + "',"; } if(config.getCreatedBy()!=null &&
	 * config.getCreatedBy()!="") { s = s + "@p_createdBy='" + config.getCreatedBy()
	 * + "',"; } if (config.getOrganization() != null && config.getOrganization() !=
	 * "") { s = s + "@p_org='" + config.getOrganization() + "',"; } if
	 * (config.getOrgDivision() != null && config.getOrgDivision() != "") { s = s +
	 * "@p_div='" + config.getOrgDivision() + "',"; } if (config.getUnit() != null
	 * && config.getUnit() != "") { s = s + "@p_unit='" + config.getUnit() + "',"; }
	 */
	if (s != "") {
		s = s.substring(0, s.length() - 1);
		
		s = "SET " + s + ";";
	}
	
	
	
	return s;
	
}
}
