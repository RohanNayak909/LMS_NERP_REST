package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.RestHISIcuModel;

public class GenerateIcuParameter {

	public static String getAddIcu(RestHISIcuModel icu) {

		String s = "";

		if (icu.getIcu() != null || icu.getIcu() != "") {
			s = s + "@p_icu='" + icu.getIcu() + "',";
		}
		if (icu.getIcuName() != null || icu.getIcuName() != "") {
			s = s + "@p_icuName='" + icu.getIcuName() + "',";
		}
		
		if (icu.getPropertyFloorType() != null || icu.getPropertyFloorType() != "") {
			s = s + "@p_propertytype='" + icu.getPropertyFloorType() + "',";
		}

		if (icu.getIcuDes() != null || icu.getIcuDes() != "") {
			s = s + "@p_icuDes='" + icu.getIcuDes() + "',";
		}

		if (icu.getIcuStatus() != null || icu.getIcuStatus() != "") {
			s = s + "@p_icuStatus='" + icu.getIcuStatus() + "',";
		}
		if (icu.getIcuOrg() != null || icu.getIcuOrg() != "") {
			s = s + "@p_icuOrg='" + icu.getIcuOrg() + "',";
		}
		if (icu.getIcuDiv() != null || icu.getIcuDiv() != "") {
			s = s + "@p_icuDiv='" + icu.getIcuDiv() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("--------" + s);
		return s;

	}

}
