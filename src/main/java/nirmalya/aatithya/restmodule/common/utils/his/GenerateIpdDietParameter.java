package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateIpdDietParameter {
	public static String addPatientIPDParam(HISPatientRestModel patientRestModel) {

		String s = "";
	//	String sitem = "";


			if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
				s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
			}

			if (patientRestModel.getPatientType() != null || patientRestModel.getPatientType() != "") {
				s = s + "@p_patientType='" + patientRestModel.getPatientType() + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		System.out.println("inParameter-------------" + s);
		return s;

	}
	
}
