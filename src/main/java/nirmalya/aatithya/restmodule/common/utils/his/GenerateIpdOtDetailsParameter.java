package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateIpdOtDetailsParameter {

	
	public static String addIpdOtParam(HISPatientRestModel patientRestModel) {

		String s = "";


			if (patientRestModel.getOtId() != null || patientRestModel.getOtId() != "") {
				s = s + "@p_otId='" + patientRestModel.getOtId() + "',";
			}

			if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
				s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
			}
			if (patientRestModel.getIpdId() != null || patientRestModel.getIpdId() != "") {
				s = s + "@p_ipdId='" + patientRestModel.getIpdId() + "',";
			}
			if (patientRestModel.getProcedureName() != null || patientRestModel.getProcedureName() != "") {
				s = s + "@p_procedure='" + patientRestModel.getProcedureName() + "',";
			}
			
			if (patientRestModel.getSummary() != null || patientRestModel.getSummary() != "") {
				s = s + "@p_summary='" + patientRestModel.getSummary() + "',";
			}
		
			if (DateFormatter.getStringDateTimeWithoutTime(patientRestModel.getFromDate()) != null && DateFormatter.getStringDateTimeWithoutTime(patientRestModel.getFromDate()) != "") {
				s = s + "@p_fromDate='" + DateFormatter.getStringDateTimeWithoutTime(patientRestModel.getFromDate()) + "',";
			}
			if (DateFormatter.getStringDateTimeWithoutTime(patientRestModel.getToDate()) != null && DateFormatter.getStringDateTimeWithoutTime(patientRestModel.getToDate()) != "") {
				s = s + "@p_toDate='" + DateFormatter.getStringDateTimeWithoutTime(patientRestModel.getToDate()) + "',";
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
