package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateIpdTreatmentParameter {
	public static String addIpdTreatmentParam(HISPatientRestModel patientRestModel) {

		String s = "";


			if (patientRestModel.getTreatmentIds() != null || patientRestModel.getTreatmentIds() != "") {
				s = s + "@p_treatmentId='" + patientRestModel.getTreatmentIds() + "',";
			}

			if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
				s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
			}
			if (patientRestModel.getIpdId() != null || patientRestModel.getIpdId() != "") {
				s = s + "@p_ipdId='" + patientRestModel.getIpdId() + "',";
			}
			
			if (patientRestModel.getMedicinename() != null || patientRestModel.getMedicinename() != "") {
				s = s + "@p_medicineName='" + patientRestModel.getMedicinename() + "',";
			}

			if (patientRestModel.getDosage() != null || patientRestModel.getDosage() != "") {
				s = s + "@p_dosage='" + patientRestModel.getDosage() + "',";
			}
			if (patientRestModel.getFrequency() != null || patientRestModel.getFrequency() != "") {
				s = s + "@p_frequency='" + patientRestModel.getFrequency() + "',";
			}

			if (patientRestModel.getDuration() != null || patientRestModel.getDuration() != "") {
				s = s + "@p_duration='" + patientRestModel.getDuration() + "',";
			}


			if (patientRestModel.getInstruction() != null || patientRestModel.getInstruction() != "") {
				s = s + "@p_instruction='" + patientRestModel.getInstruction() + "',";
			}

			if (patientRestModel.getTreatmentTypes() != null || patientRestModel.getTreatmentTypes() != "") {
				s = s + "@p_treatmentType='" + patientRestModel.getTreatmentTypes() + "',";
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


			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		System.out.println("inParameter-------------" + s);
		return s;

	}
}
