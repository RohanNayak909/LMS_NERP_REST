package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateIpdTestParameter {

	public static String addIpdTestParam(HISPatientRestModel patientRestModel) {

		String s = "";


			if (patientRestModel.getTestIds() != null || patientRestModel.getTestIds() != "") {
				s = s + "@p_testId='" + patientRestModel.getTestIds() + "',";
			}

			if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
				s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
			}
			if (patientRestModel.getIpdId() != null || patientRestModel.getIpdId() != "") {
				s = s + "@p_ipdId='" + patientRestModel.getIpdId() + "',";
			}
			
			if (patientRestModel.getTestName() != null || patientRestModel.getTestName() != "") {
				s = s + "@p_testName='" + patientRestModel.getTestName() + "',";
			}
			if (patientRestModel.getTestCategory() != null || patientRestModel.getTestCategory() != "") {
				s = s + "@p_testCategory='" + patientRestModel.getTestCategory() + "',";
			}


			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		System.out.println("inParameter-------------" + s);
		return s;

	}
}
