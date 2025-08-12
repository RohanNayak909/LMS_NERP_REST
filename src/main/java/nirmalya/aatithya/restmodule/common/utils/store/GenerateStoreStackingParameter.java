package nirmalya.aatithya.restmodule.common.utils.store;

import java.util.List;

import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;

public class GenerateStoreStackingParameter {
	
	public static String saveStoreStackdataParam(List<StoreRomeModel> storeRomeModel) {
		String s = "";
		String zoneId="";
		String rackId="";
		String allocationId="";
		String oldBinId="";
		String newBinId="";
	    String organization="";
		String orgDivision="";
		
		for (StoreRomeModel m : storeRomeModel) {
			zoneId=m.getZoneId();
			rackId=m.getRackId();
			allocationId=m.getAllocationId();
			oldBinId=m.getOldBinId();
			newBinId=m.getNewBinId();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
			
			
					
		}
		
		s = s + "@p_zoneId='" + zoneId + "',";
		s = s + "@p_rackId='" + rackId + "',";
		s = s + "@p_allocationId='" + allocationId + "',";
		s = s + "@p_oldBinId='" + oldBinId + "',";
		s = s + "@p_newBinId='" + newBinId + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
	
	
		System.out.println(storeRomeModel);
		if(!storeRomeModel.isEmpty()) {
			if(!storeRomeModel.get(0).getAllocationId().contentEquals("1")) {
				if (s != "") {
				s = s.substring(0, s.length() - 1);
				s = "SET " + s + ";";
				}
				}
		}else {
			System.out.println("customer object is empty.");
		}
		
		
		return s;
	}
}
