package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.RestEmployeeNomineModel;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateNomineParam {
	
	public static String addNomineParam(RestEmployeeNomineModel restEmployeeNomineModel) {

		String s = "";

			if (restEmployeeNomineModel.getNomineId() != null || restEmployeeNomineModel.getNomineId() != "") {
				s = s + "@p_nomineId='" + restEmployeeNomineModel.getNomineId() + "',";
			}
			if (restEmployeeNomineModel.getemployeeId() != null || restEmployeeNomineModel.getemployeeId() != "") {
				s = s + "@p_empId='" + restEmployeeNomineModel.getemployeeId() + "',";
			}

			if (restEmployeeNomineModel.getInsuredName() != null || restEmployeeNomineModel.getInsuredName() != "") {
				s = s + "@p_insuredName='" + restEmployeeNomineModel.getInsuredName() + "',";
			}
			if (restEmployeeNomineModel.getDateOfBirth() != null || restEmployeeNomineModel.getDateOfBirth() != "") {
				s = s + "@p_dob='" + restEmployeeNomineModel.getDateOfBirth() + "',";
			}
			
			if (restEmployeeNomineModel.getAge() != null || restEmployeeNomineModel.getAge() != "") {
				s = s + "@p_age='" + restEmployeeNomineModel.getAge() + "',";
			}

			if (restEmployeeNomineModel.getDepRelation() != null || restEmployeeNomineModel.getDepRelation() != "") {
				s = s + "@p_relation='" + restEmployeeNomineModel.getDepRelation() + "',";
			}
			
			if (restEmployeeNomineModel.getCreatedBy() != null || restEmployeeNomineModel.getCreatedBy() != "") {
				s = s + "@p_createdBy='" + restEmployeeNomineModel.getCreatedBy() + "',";
			}

			if (restEmployeeNomineModel.getOrganization() != null && restEmployeeNomineModel.getOrganization() != "") {
				s = s + "@p_org='" + restEmployeeNomineModel.getOrganization() + "',";
			}
			if (restEmployeeNomineModel.getOrgDivision() != null && restEmployeeNomineModel.getOrgDivision() != "") {
				s = s + "@p_orgDiv='" + restEmployeeNomineModel.getOrgDivision() + "',";
			}

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		System.out.println("inParameter-------------" + s);
		return s;

	}
}
