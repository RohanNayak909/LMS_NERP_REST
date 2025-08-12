package nirmalya.aatithya.restmodule.common.utils.trial;

import nirmalya.aatithya.restmodule.trial.model.RestStationwiseRefuellingModel;

public class GenerateStationwiseRefuellingParameter {

	
	public static String getStationwiseRefuelParam(RestStationwiseRefuellingModel doc) {

		String s = "";

		if (doc.getSlId() != null && doc.getSlId() != "") {
			s = s + "@p_slId='" + doc.getSlId() + "',";
		}
		if (doc.getVehicleRegId() != null && doc.getVehicleRegId() != "") {
			s = s + "@p_vehicleRegId='" + doc.getVehicleRegId() + "',";
		}
		if (doc.getFuelTypeId() != null && doc.getFuelTypeId() != "") {
			s = s + "@p_fuelTypeId='" + doc.getFuelTypeId() + "',";
		}
		if (doc.getQuantityId() != null && doc.getQuantityId() != "") {
			s = s + "@p_quantityId='" + doc.getQuantityId() + "',";
		}
		if (doc.getUnitPriceId() != null && doc.getUnitPriceId() != ""){
			s = s + "@p_unitPriceId='" + doc.getUnitPriceId() + "',";
		}

		if (doc.getFuelStationId() != null && doc.getFuelStationId() != "") {
			s = s + "@p_fuelStationId='" + doc.getFuelStationId() + "',";
		}
		if (doc.getOdodmeterId() != null) {
			s = s + "@p_ododmeterId='" + doc.getOdodmeterId() + "',";
		}
		if (doc.getRequisitionId() != null && doc.getRequisitionId() != "") {
			s = s + "@p_requisitionId='" + doc.getRequisitionId() + "',";
		}
		if (doc.getLastOdodmeterId() != null) {
			s = s + "@p_lastOdodmeterId='" + doc.getLastOdodmeterId() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	
}
