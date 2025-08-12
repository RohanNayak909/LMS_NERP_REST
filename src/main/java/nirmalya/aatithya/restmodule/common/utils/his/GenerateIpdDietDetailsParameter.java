package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateIpdDietDetailsParameter {
	
	public static String addIpdDietParam(HISPatientRestModel patientRestModel) {

		String s = "";


			if (patientRestModel.getDietId() != null || patientRestModel.getDietId() != "") {
				s = s + "@p_dietId='" + patientRestModel.getDietId() + "',";
			}

			if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
				s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
			}
			if (patientRestModel.getIpdId() != null || patientRestModel.getIpdId() != "") {
				s = s + "@p_ipdId='" + patientRestModel.getIpdId() + "',";
			}

			if (patientRestModel.getCategory() != null || patientRestModel.getCategory() != "") {
				s = s + "@p_category='" + patientRestModel.getCategory() + "',";
			}
			if (patientRestModel.getItemId() != null || patientRestModel.getItemId() != "") {
				s = s + "@p_itemId='" + patientRestModel.getItemId() + "',";
			}

			if (patientRestModel.getNote() != null || patientRestModel.getNote() != "") {
				s = s + "@p_note='" + patientRestModel.getNote() + "',";
			}


			if (patientRestModel.getLunch() != null || patientRestModel.getLunch() != "") {
				s = s + "@p_lunch='" + patientRestModel.getLunch() + "',";
			}

			if (patientRestModel.getItemId1() != null || patientRestModel.getItemId1() != "") {
				s = s + "@p_itemId1='" + patientRestModel.getItemId1() + "',";
			}
			if (patientRestModel.getNote1() != null || patientRestModel.getNote1() != "") {
				s = s + "@p_note1='" + patientRestModel.getNote1() + "',";
			}
			if (patientRestModel.getDinner() != null || patientRestModel.getDinner() != "") {
				s = s + "@p_dinner='" + patientRestModel.getDinner() + "',";
			}
			
			if (patientRestModel.getItemId2() != null || patientRestModel.getItemId2() != "") {
				s = s + "@p_itemId2='" + patientRestModel.getItemId2() + "',";
			}
			
			
			if (patientRestModel.getNote2() != null || patientRestModel.getNote2() != "") {
				s = s + "@p_note2='" + patientRestModel.getNote2() + "',";
			}
			
			if (patientRestModel.getRemark() != null || patientRestModel.getRemark() != "") {
				s = s + "@p_remark='" + patientRestModel.getRemark() + "',";
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
