package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.gatepass.model.ShiftRegisterReportModel;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
public class GenerateGatePassReportParameter {
	
	public static String saveGateReportDataParam(List<ShiftRegisterReportModel> gatereport) {
		String s = "";
		String listdata = "";
		String registerId = "";
		String pdate = "";
		String shift = "";
		String desc = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		

		

		for (ShiftRegisterReportModel m : gatereport) {
			registerId = m.getRegisterId();
			pdate =DateFormatter.getStringDate( m.getPdate());
			shift = m.getShift();
			desc = m.getDesc();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
	        orgDivision = m.getOrgDivision();
			
		
		}

		s = s + "@p_registerId='" + registerId + "',";
		s = s + "@p_pdate='" + pdate + "',";
		s = s + "@p_shift='" + shift + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		

		if (!gatereport.get(0).getRegisterId().contentEquals("1")) {
			for (ShiftRegisterReportModel m : gatereport) {

				listdata = listdata + "(@p_registerId,\"" + m.getCategory() + "\",\"" + m.getManPower()+ "\",@p_createdBy,@p_organization,@p_orgDivision),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		System.out.println("Item Details" + s);
		return s;
	}

}
