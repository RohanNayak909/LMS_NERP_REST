package nirmalya.aatithya.restmodule.common.utils.trial;

import nirmalya.aatithya.restmodule.trial.model.RestManageFuelStationModel;

public class GenerateFuelStationParameter {

	public static String getAddfuelParam(RestManageFuelStationModel stationfuelparam) {
		
		String s = "";


		if (stationfuelparam.getStationId() != null && stationfuelparam.getStationId() != "") {
			s = s + "@stationid='" + stationfuelparam.getStationId() + "',";
		}
		if (stationfuelparam.getVendorName() != null && stationfuelparam.getVendorName() != "") {
			s = s + "@vndrname='" + stationfuelparam.getVendorName() + "',";
		}
		if (stationfuelparam.getContactNumber() != null && stationfuelparam.getContactNumber() != "") {
			s = s + "@contno='" + stationfuelparam.getContactNumber() + "',";
		}
		if (stationfuelparam.getStationName() != null && stationfuelparam.getStationName() != "") {
			s = s + "@stationname='" + stationfuelparam.getStationName() + "',";
		}
		if (stationfuelparam.getStationCode() != null && stationfuelparam.getStationCode() != "") {
			s = s + "@stationcode='" + stationfuelparam.getStationCode() + "',";
		}
		if (stationfuelparam.getAuthorizePerson() != null && stationfuelparam.getAuthorizePerson() != "") {
			s = s + "@authorizeperson='" + stationfuelparam.getAuthorizePerson() + "',";
		}
		
		if (stationfuelparam.getAuthorize() != null && stationfuelparam.getAuthorize() != "") {
			s = s + "@authorize='" + stationfuelparam.getAuthorize() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}


}
