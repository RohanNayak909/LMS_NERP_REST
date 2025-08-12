package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.RestHISPathoLabModel;

public class GeneratePathoLabParameter {


	public static String getAddLab(RestHISPathoLabModel pathoLab) {

		String s = "";

		if (pathoLab.getPathoLab() != null || pathoLab.getPathoLab() != "") {
			s = s + "@p_lab='" + pathoLab.getPathoLab() + "',";
		}
		if (pathoLab.getLabName() != null || pathoLab.getLabName() != "") {
			s = s + "@p_labName='" + pathoLab.getLabName() + "',";
		}
		
		if (pathoLab.getLabpropertyFloorType() != null || pathoLab.getLabpropertyFloorType() != "") {
			s = s + "@p_labpropertytype='" + pathoLab.getLabpropertyFloorType() + "',";
		}

		if (pathoLab.getLabDes() != null || pathoLab.getLabDes() != "") {
			s = s + "@p_labDes='" + pathoLab.getLabDes() + "',";
		}

		if (pathoLab.getLabStatus() != null || pathoLab.getLabStatus() != "") {
			s = s + "@p_labStatus='" + pathoLab.getLabStatus() + "',";
		}
		if (pathoLab.getLabOrg() != null || pathoLab.getLabOrg() != "") {
			s = s + "@p_labOrg='" + pathoLab.getLabOrg() + "',";
		}
		if (pathoLab.getLabDiv() != null || pathoLab.getLabDiv() != "") {
			s = s + "@p_labDiv='" + pathoLab.getLabDiv() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("--------" + s);
		return s;

	}
}
