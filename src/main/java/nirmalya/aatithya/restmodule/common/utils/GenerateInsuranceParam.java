package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.RestEmployeeNomineModel;

public class GenerateInsuranceParam {

	public static String addInsuranceParam(RestEmployeeNomineModel restEmployeeNomineModel) {

		String s = "";
		if (restEmployeeNomineModel.getInsuranceId() != null && restEmployeeNomineModel.getInsuranceId() != "") {
			s = s + "@p_insuranceId='" + restEmployeeNomineModel.getInsuranceId() + "',";
		}
		if (restEmployeeNomineModel.getInsuranceTypeId() != null && restEmployeeNomineModel.getInsuranceTypeId() != "") {
			s = s + "@p_insuranceTypeId='" + restEmployeeNomineModel.getInsuranceTypeId() + "',";
		}
		if (restEmployeeNomineModel.getemployeeId() != null || restEmployeeNomineModel.getemployeeId() != "") {
			s = s + "@p_empId='" + restEmployeeNomineModel.getemployeeId() + "',";
		}
		if (restEmployeeNomineModel.getInsuranceName() != null && restEmployeeNomineModel.getInsuranceName() != "") {
			s = s + "@p_insuranceName='" + restEmployeeNomineModel.getInsuranceName() + "',";
		}
		if (restEmployeeNomineModel.getInsuranceProvider() != null && restEmployeeNomineModel.getInsuranceProvider() != "") {
			s = s + "@p_insuranceProvider='" + restEmployeeNomineModel.getInsuranceProvider() + "',";
		}
		if (restEmployeeNomineModel.getInsuredAmount() != null && restEmployeeNomineModel.getInsuredAmount() != "") {
			s = s + "@p_insuredAmount='" + restEmployeeNomineModel.getInsuredAmount() + "',";
		}
		if (restEmployeeNomineModel.getfDate() != null && restEmployeeNomineModel.getfDate() != "") {
			s = s + "@p_fDate='" + restEmployeeNomineModel.getfDate() + "',";
		}
		if (restEmployeeNomineModel.gettDate() != null && restEmployeeNomineModel.gettDate() != "") {
			s = s + "@p_tDate='" + restEmployeeNomineModel.gettDate() + "',";
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
