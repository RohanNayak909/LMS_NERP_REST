package nirmalya.aatithya.restmodule.common.utils.trial;

import nirmalya.aatithya.restmodule.trial.model.ManageFuelRestModel;

public class GenerateFuelParameter {
	
	public static String addvehicleparam(ManageFuelRestModel fuelRestModel) {
		
		String s = ""; 
		
		
		if (fuelRestModel.getFsid() != null || fuelRestModel.getFsid() != "") {
			s = s + "@p_fsid='" + fuelRestModel.getFsid() + "',";
		}
		
		if (fuelRestModel.getVehicleregno() != null || fuelRestModel.getVehicleregno() != "") {
			s = s + "@p_vehicleregno='" + fuelRestModel.getVehicleregno() + "',";
		}
		
		if (fuelRestModel.getFsname() != null || fuelRestModel.getFsname() != "") {
			s = s + "@p_fsname='" + fuelRestModel.getFsname() + "',";
		}
		
		if (fuelRestModel.getFscontact() != null || fuelRestModel.getFscontact() != "") {
			s = s + "@p_fscontact='" + fuelRestModel.getFscontact() + "',";
		}
		
		if (fuelRestModel.getVendorname() != null || fuelRestModel.getVendorname() != "") {
			s = s + "@p_vendorname='" + fuelRestModel.getVendorname() + "',";
		}
		
		if (fuelRestModel.getFromDate() != null || fuelRestModel.getFromDate() != "") {
			s = s + "@p_fromdate='" + fuelRestModel.getFromDate() + "',";
		}
		
		if (fuelRestModel.getToDate() != null || fuelRestModel.getToDate() != "") {
			s = s + "@p_todate='" + fuelRestModel.getToDate() + "',";
		}
		
		if (fuelRestModel.getStartodo() != null || fuelRestModel.getStartodo() != "") {
			s = s + "@p_startodo='" + fuelRestModel.getStartodo() + "',";
		}
		
		if (fuelRestModel.getEndodo() != null || fuelRestModel.getEndodo() != "") {
			s = s + "@p_endodo='" + fuelRestModel.getEndodo() + "',";
		}
		
		if (fuelRestModel.getTotalododiff() != null || fuelRestModel.getTotalododiff() != "") {
			s = s + "@p_totalododiff='" + fuelRestModel.getTotalododiff() + "',";
		}
		
		if (fuelRestModel.getFueltype() != null || fuelRestModel.getFueltype() != "") {
			s = s + "@p_fueltype='" + fuelRestModel.getFueltype() + "',";
		}
		
		
		if (fuelRestModel.getRfunit() != null || fuelRestModel.getRfunit() != "") {
			s = s + "@p_rfunit='" + fuelRestModel.getRfunit() + "',";
		}
		
		
		if (fuelRestModel.getUprice() != null || fuelRestModel.getUprice() != "") {
			s = s + "@p_unitprice='" + fuelRestModel.getUprice() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("output= " +s);
		return s;
	
	}

}
