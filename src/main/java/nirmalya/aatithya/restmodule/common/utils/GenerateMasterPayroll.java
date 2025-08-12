package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.master.model.RestPayrollMasterModel;

public class GenerateMasterPayroll {
	
	public static String addSalaryAmount(RestPayrollMasterModel restPayrollMasterModel) {

		String s = "";
		

		if(restPayrollMasterModel.getOrganization() != null || restPayrollMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restPayrollMasterModel.getOrganization() + "',";
		}
		if(restPayrollMasterModel.getOrgDivision() != null || restPayrollMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restPayrollMasterModel.getOrgDivision() + "',";
		}
		if (restPayrollMasterModel.getSalaryComponent() != null || restPayrollMasterModel.getSalaryComponent() != "") {
			s = s + "@p_SalaryComponent='" + restPayrollMasterModel.getSalaryComponent() + "',";
		}
		if (restPayrollMasterModel.getAmount() != null || restPayrollMasterModel.getAmount() != "") {
			s = s + "@p_Amount='" + restPayrollMasterModel.getAmount() + "',";
		}
		if (restPayrollMasterModel.getCalculationType() != null || restPayrollMasterModel.getCalculationType() != "") {
			s = s + "@p_CalculationType='" + restPayrollMasterModel.getCalculationType() + "',";
		}
		
		if (restPayrollMasterModel.getBandName() != null || restPayrollMasterModel.getBandName() != "") {
			s = s + "@p_BandName='" + restPayrollMasterModel.getBandName() + "',";
		}
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss"+s);
		return s;
	}
}
