package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestDeputizationModel;

public class GenerateDeputizationAdd {
	
	
	
	public static String addDeputizationParam(RestDeputizationModel restPayroll) {
		// TODO Auto-generated method stub
		String S = "";
	
		if(restPayroll.getEmpId() != null || restPayroll.getEmpId() != "") {
			S = S + "@p_empId='" + restPayroll.getEmpId() + "',";
		}
		if(restPayroll.getName() != null || restPayroll.getName() != "") {
			S = S + "@p_name='" + restPayroll.getName() + "',";
		}
		
		if(restPayroll.getFromDate() != null || restPayroll.getFromDate() != "") {
			S = S + "@p_fromeDate='" + restPayroll.getFromDate() + "',";
		}
		if(restPayroll.getToDate() != null || restPayroll.getToDate() != "") {
			S = S + "@p_toDate='" + restPayroll.getToDate() + "',";
		}
		if(restPayroll.getBasic() != null || restPayroll.getBasic() != "") {
			S = S + "@p_basic='" + restPayroll.getBasic() + "',";
		}
		if(restPayroll.getHra() != null || restPayroll.getHra() != "") {
			S = S + "@p_hra='" + restPayroll.getHra() + "',";
		}
		if(restPayroll.getAddAllow() != null || restPayroll.getAddAllow() != "") {
			S = S + "@p_addAllow='" + restPayroll.getAddAllow() + "',";
		}
		if(restPayroll.getLta() != null || restPayroll.getLta() != "") {
			S = S + "@p_lta='" + restPayroll.getLta() + "',";
		}
		if(restPayroll.getMedical() != null || restPayroll.getMedical() != "") {
			S = S + "@p_medical='" + restPayroll.getMedical() + "',";
		}
		if(restPayroll.getOther() != null || restPayroll.getOther() != "") {
			S = S + "@p_other='" + restPayroll.getOther() + "',";
		}
		if(restPayroll.getEditId() != null || restPayroll.getEditId() != "") {
			S = S + "@p_editId='" + restPayroll.getEditId() + "',";
		}
		if (S != "") {
			S = S.substring(0, S.length() - 1);

			S = "SET " + S + ";";
		}
		System.out.println(S);
		return S;
	}
	
	
	

}
