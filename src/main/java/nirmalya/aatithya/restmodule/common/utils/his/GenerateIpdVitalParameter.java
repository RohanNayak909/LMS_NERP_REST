package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateIpdVitalParameter {
	public static String addIpdVitalParam(HISPatientRestModel patientRestModel) {

		String s = "";

			if (patientRestModel.getSlno() != null || patientRestModel.getSlno() != "") {
				s = s + "@p_slno='" + patientRestModel.getSlno() + "',";
			}
			if (patientRestModel.getVitalId() != null || patientRestModel.getVitalId() != "") {
				s = s + "@p_vitalId='" + patientRestModel.getVitalId() + "',";
			}
			if (patientRestModel.getVitalId() != null || patientRestModel.getVitalId() != "") {
				s = s + "@p_vitalId='" + patientRestModel.getVitalId() + "',";
			}
			if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
				s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
			}
			if (patientRestModel.getIpdId() != null || patientRestModel.getIpdId() != "") {
				s = s + "@p_ipdId='" + patientRestModel.getIpdId() + "',";
			}
			
			if (patientRestModel.getBodyTemp() != null || patientRestModel.getBodyTemp() != "") {
				s = s + "@p_bodyTemp='" + patientRestModel.getBodyTemp() + "',";
			}

			if (patientRestModel.getHeartRate() != null || patientRestModel.getHeartRate() != "") {
				s = s + "@p_heartRate='" + patientRestModel.getHeartRate() + "',";
			}
			if (patientRestModel.getRespRate() != null || patientRestModel.getRespRate() != "") {
				s = s + "@p_respRate='" + patientRestModel.getRespRate() + "',";
			}

			if (patientRestModel.getBloodPres() != null || patientRestModel.getBloodPres() != "") {
				s = s + "@p_bloodPres='" + patientRestModel.getBloodPres() + "',";
			}


			if (patientRestModel.getWeight() != null || patientRestModel.getWeight() != "") {
				s = s + "@p_weight='" + patientRestModel.getWeight() + "',";
			}

			if (patientRestModel.getHeight() != null || patientRestModel.getHeight() != "") {
				s = s + "@p_height='" + patientRestModel.getHeight() + "',";
			}
			if (patientRestModel.getBmi() != null || patientRestModel.getBmi() != "") {
				s = s + "@p_bmi='" + patientRestModel.getBmi() + "',";
			}
			
			if (patientRestModel.getCreatedBy() != null && patientRestModel.getCreatedBy() != "") {
				s = s + "@p_createdBy='" + patientRestModel.getCreatedBy() + "',";
			}

			if (patientRestModel.getOrganization() != null && patientRestModel.getOrganization() != "") {
				s = s + "@p_org='" + patientRestModel.getOrganization() + "',";
			}
			if (patientRestModel.getOrgDivision() != null && patientRestModel.getOrgDivision() != "") {
				s = s + "@p_orgDiv='" + patientRestModel.getOrgDivision() + "',";
			}
			if (patientRestModel.getVitalStatus() != null && patientRestModel.getVitalStatus() != "") {
				s = s + "@p_status='" + patientRestModel.getVitalStatus() + "',";
			}


			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		System.out.println("inParameter-------------" + s);
		return s;

	}
}
