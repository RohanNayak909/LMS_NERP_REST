package nirmalya.aatithya.restmodule.common.utils.weight;

import nirmalya.aatithya.restmodule.weight.model.RestWeightBridgeModel;

public class GenerateWeightBridgeParameter {
	public static String addWeightParam(RestWeightBridgeModel restWeightBridgeModel) {
		String s = "";

		if (restWeightBridgeModel.getUserId() != null || restWeightBridgeModel.getUserId() != "") {
			s = s + "@p_userId='" + restWeightBridgeModel.getUserId() + "',";
		}
		if (restWeightBridgeModel.getEntryId() != null || restWeightBridgeModel.getEntryId() != "") {
			s = s + "@p_entryId='" + restWeightBridgeModel.getEntryId() + "',";
		}
		if (restWeightBridgeModel.getVehicleId() != null || restWeightBridgeModel.getVehicleId() != "") {
			s = s + "@p_vehicleId='" + restWeightBridgeModel.getVehicleId() + "',";
		}
		if (restWeightBridgeModel.getDriverName() != null || restWeightBridgeModel.getDriverName() != "") {
			s = s + "@p_driverName='" + restWeightBridgeModel.getDriverName() + "',";
		}
		if (restWeightBridgeModel.getDriverNo() != null || restWeightBridgeModel.getDriverNo() != "") {
			s = s + "@p_driverNo='" + restWeightBridgeModel.getDriverNo() + "',";
		}
		//entry
		if (restWeightBridgeModel.getWeightCarry() != null || restWeightBridgeModel.getWeightCarry() != "") {
			s = s + "@p_weightCarry='" + restWeightBridgeModel.getWeightCarry() + "',";
		}
		if (restWeightBridgeModel.getWeightUnit() != null || restWeightBridgeModel.getWeightUnit() != "") {
			s = s + "@p_weightUnit='" + restWeightBridgeModel.getWeightUnit() + "',";
		}
		if (restWeightBridgeModel.getWeightRemark() != null || restWeightBridgeModel.getWeightRemark() != "") {
			s = s + "@p_weightRemark='" + restWeightBridgeModel.getWeightRemark() + "',";
		}
		if (restWeightBridgeModel.getEntryDate() != null || restWeightBridgeModel.getEntryDate() != "") {
			s = s + "@p_entryDate='" + restWeightBridgeModel.getEntryDate() + "',";
		}
		if (restWeightBridgeModel.getEntryTime() != null || restWeightBridgeModel.getEntryTime() != "") {
			s = s + "@p_entryTime='" + restWeightBridgeModel.getEntryTime() + "',";
		}
		if (restWeightBridgeModel.getEntryDateTime() != null || restWeightBridgeModel.getEntryDateTime() != "") {
			s = s + "@p_entryDateTime='" + restWeightBridgeModel.getEntryDateTime() + "',";
		}
		if (restWeightBridgeModel.getOrganizationDivision() != null || restWeightBridgeModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + restWeightBridgeModel.getOrganizationDivision() + "',";
		}
		if (restWeightBridgeModel.getOrganizationName() != null || restWeightBridgeModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + restWeightBridgeModel.getOrganizationName() + "',";
		}
		if (restWeightBridgeModel.getWeighCharge() != null || restWeightBridgeModel.getWeighCharge() != "") {
			s = s + "@p_weighCharge='" + restWeightBridgeModel.getWeighCharge() + "',";
		}
		//exit
		if (restWeightBridgeModel.getExitWeightCarry() != null || restWeightBridgeModel.getExitWeightCarry() != "") {
			s = s + "@p_exitWeightCarry='" + restWeightBridgeModel.getExitWeightCarry() + "',";
		}
		if (restWeightBridgeModel.getExitWeightUnit() != null || restWeightBridgeModel.getExitWeightUnit() != "") {
			s = s + "@p_exitWeightUnit='" + restWeightBridgeModel.getExitWeightUnit() + "',";
		}
		if (restWeightBridgeModel.getExitWeightRemark() != null || restWeightBridgeModel.getExitWeightRemark() != "") {
			s = s + "@p_exitWeightRemark='" + restWeightBridgeModel.getExitWeightRemark() + "',";
		}
		if (restWeightBridgeModel.getExitDate() != null || restWeightBridgeModel.getExitDate() != "") {
			s = s + "@p_exitDate='" + restWeightBridgeModel.getExitDate() + "',";
		}
		if (restWeightBridgeModel.getExitTime() != null || restWeightBridgeModel.getExitTime() != "") {
			s = s + "@p_exitTime='" + restWeightBridgeModel.getExitTime() + "',";
		}
		if (restWeightBridgeModel.getExitDateTime() != null || restWeightBridgeModel.getExitDateTime() != "") {
			s = s + "@p_exitDateTime='" + restWeightBridgeModel.getExitDateTime() + "',";
		}
		if (restWeightBridgeModel.getRegisterId() != null || restWeightBridgeModel.getRegisterId() != "") {
			s = s + "@p_registerId='" + restWeightBridgeModel.getRegisterId() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
