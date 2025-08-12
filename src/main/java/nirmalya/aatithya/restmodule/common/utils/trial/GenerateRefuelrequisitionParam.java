package nirmalya.aatithya.restmodule.common.utils.trial;

import nirmalya.aatithya.restmodule.trial.model.RestRefuelRequisitionModel;

public class GenerateRefuelrequisitionParam {
	
public static String getAddrefuelParam(RestRefuelRequisitionModel refuel) {
		
		String s = "";


		if (refuel.getRefuelReqId() != null && refuel.getRefuelReqId() != "") {
			s = s + "@refuelreqid='" + refuel.getRefuelReqId() + "',";
		}
		if (refuel.getVehicleRegno() != null && refuel.getVehicleRegno() != "") {
			s = s + "@vehclereg='" + refuel.getVehicleRegno() + "',";
		}
		if (refuel.getFuelType() != null && refuel.getFuelType() != "") {
			s = s + "@fueltype='" + refuel.getFuelType() + "',";
		}
		if (refuel.getCurrentOdometer() != null ) {
			s = s + "@currodometer='" + refuel.getCurrentOdometer() + "',";
		}
		if (refuel.getQuantity() != null && refuel.getQuantity() != "") {
			s = s + "@quantity='" + refuel.getQuantity() + "',";
		}
		if (refuel.getFuelStationId() != null && refuel.getFuelStationId() != "") {
			s = s + "@fuelstation='" + refuel.getFuelStationId() + "',";
		}
		
		if (refuel.getLastOdometer() != null ) {
			s = s + "@lastodometer='" + refuel.getLastOdometer() + "',";
		}
		if (refuel.getStatus() != null && refuel.getStatus() != "") {
			s = s + "@statu='" + refuel.getStatus() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
