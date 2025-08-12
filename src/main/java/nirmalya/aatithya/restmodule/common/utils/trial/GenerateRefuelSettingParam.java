package nirmalya.aatithya.restmodule.common.utils.trial;

import nirmalya.aatithya.restmodule.trial.model.RefuelSettingRestModel;

public class GenerateRefuelSettingParam {
	
	public static String addvehicleparam(RefuelSettingRestModel refuelsettingRestModel) {

		String s = ""; 
		
		if (refuelsettingRestModel.getRfsettingid() != null || refuelsettingRestModel.getRfsettingid() != "") {
			s = s + "@p_rfsettingid='" + refuelsettingRestModel.getRfsettingid() + "',";
		}
		
		if (refuelsettingRestModel.getVehicleregno() != null || refuelsettingRestModel.getVehicleregno() != "") {
			s = s + "@p_vehicleregno='" + refuelsettingRestModel.getVehicleregno() + "',";
		}
		
		if (refuelsettingRestModel.getDrivername() != null || refuelsettingRestModel.getDrivername() != "") {
			s = s + "@p_drivername='" + refuelsettingRestModel.getDrivername() + "',";
		}
		
		if (refuelsettingRestModel.getDriverphone() != null || refuelsettingRestModel.getDriverphone() != "") {
			s = s + "@p_driverphone='" + refuelsettingRestModel.getDriverphone() + "',";
		}
		
		if (refuelsettingRestModel.getIdDate() != null || refuelsettingRestModel.getIdDate() != "") {
			s = s + "@p_iddate='" + refuelsettingRestModel.getIdDate() + "',";
		}
		
		if (refuelsettingRestModel.getFueltype() != null || refuelsettingRestModel.getFueltype() != "") {
			s = s + "@p_fueltype='" + refuelsettingRestModel.getFueltype() + "',";
		}
		
		if (refuelsettingRestModel.getRflimit() != null || refuelsettingRestModel.getRflimit() != "") {
			s = s + "@p_rflimit='" + refuelsettingRestModel.getRflimit() + "',";
		}
		
		if (refuelsettingRestModel.getStationname() != null || refuelsettingRestModel.getStationname() != "") {
			s = s + "@p_stationname='" + refuelsettingRestModel.getStationname() + "',";
		}
		
		if (refuelsettingRestModel.getPlace() != null || refuelsettingRestModel.getPlace() != "") {
			s = s + "@p_place='" + refuelsettingRestModel.getPlace() + "',";
		}
		
		if (refuelsettingRestModel.getBudget() != null) {
			s = s + "@p_budget='" + refuelsettingRestModel.getBudget() + "',";
		}
		
		if (refuelsettingRestModel.getMaxunit() != null) {
			s = s + "@p_maxunit='" + refuelsettingRestModel.getMaxunit() + "',";
		}
		
		if (refuelsettingRestModel.getCpercent() != null) {
			s = s + "@p_cpercent='" + refuelsettingRestModel.getCpercent() + "',";
		}
		
		if (refuelsettingRestModel.getKpunit() != null) {
			s = s + "@p_kpunit='" + refuelsettingRestModel.getKpunit() + "',";
		}
		
		if (refuelsettingRestModel.getOdometerday() != null) {
			s = s + "@p_odometerday='" + refuelsettingRestModel.getOdometerday() + "',";
		}
		
		if (refuelsettingRestModel.getOdorefueling() != null) {
			s = s + "@p_odorefueling='" + refuelsettingRestModel.getOdorefueling() + "',";
		}
		
		if (refuelsettingRestModel.getLreading() != null) {
			s = s + "@p_lreading='" + refuelsettingRestModel.getLreading() + "',";
		}
		
		if (refuelsettingRestModel.getLastunit() != null) {
			s = s + "@p_lastunit='" + refuelsettingRestModel.getLastunit() + "',";
		}
		
		if (refuelsettingRestModel.getUtaken() != null) {
			s = s + "@p_utaken='" + refuelsettingRestModel.getUtaken() + "',";
		}
		
		if (refuelsettingRestModel.getDocName() != null || refuelsettingRestModel.getDocName() != "") {
			s = s + "@p_docname='" + refuelsettingRestModel.getDocName() + "',";
		}
		

		if (refuelsettingRestModel.getScapply() != null || refuelsettingRestModel.getScapply() != "") {
			s = s + "@p_scapply='" + refuelsettingRestModel.getScapply() + "',";
		}
			
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("output= " +s);
		return s;
	}

}
