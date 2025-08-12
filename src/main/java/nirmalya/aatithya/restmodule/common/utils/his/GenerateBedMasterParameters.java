package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;

public class GenerateBedMasterParameters {
	
	public static String getBedMasterParam(HISBedMasterRestModel restMasterData) {
		
		String s = "";

		if (restMasterData.getBedId() != null ||  restMasterData.getBedId() != "") {
			s = s + "@p_bedId='" + restMasterData.getBedId() + "',";
		}
		if (restMasterData.getBedName() != null ||  restMasterData.getBedName() != "") {
			s = s + "@p_bedName='" + restMasterData.getBedName() + "',";
		}
		if (restMasterData.getPropertyFloorType() != null || restMasterData.getPropertyFloorType() != "") {
			s = s + "@p_propertyFloorType='" + restMasterData.getPropertyFloorType() + "',";
		}
		if (restMasterData.getWard() != null ||  restMasterData.getWard() != "") {
			s = s + "@p_ward='" + restMasterData.getWard() + "',";
		}
		if (restMasterData.getBedCharge() != null ||  restMasterData.getBedCharge() != "") {
			s = s + "@p_bedCharge='" + restMasterData.getBedCharge() + "',";
		}
		if (restMasterData.getBedDescription() != null || restMasterData.getBedDescription() != "") {
			s = s + "@p_bedDesp='" + restMasterData.getBedDescription() + "',";
		}
		if (restMasterData.getStatus() != null ||  restMasterData.getStatus() != "") {
			s = s + "@p_status='" + restMasterData.getStatus() + "',";
		}
		if (restMasterData.getOrganization() != null ||  restMasterData.getOrganization() != "") {
			s = s + "@p_organization='" + restMasterData.getOrganization() + "',";
		}
		if (restMasterData.getOrgDivision() != null ||  restMasterData.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restMasterData.getOrgDivision() + "',";
		}
		if (restMasterData.getCreatedBy() != null ||  restMasterData.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restMasterData.getCreatedBy() + "',";
		}
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
