package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.InsuranceAndNomineeRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeInsuranceDetailsrestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;

public class InsuranceAndNomineeParam {
	

	public static String getAddInsuranceParam(InsuranceAndNomineeRestModel employee) {

		String s = "";
		
		
		s = s + "@p_einsuranceId='" + employee.getInsuId() + "',";
		if (employee.getEmpId() != null && employee.getEmpId() != "") {
			s = s + "@p_empId='" + employee.getEmpId() + "',";
		}
		s = s + "@p_declareId='" + employee.getDclrId() + "',";
		if (employee.getDept() != null && employee.getDept() != "") {
			s = s + "@p_dept='" + employee.getDept() + "',";
		}
		if (employee.getDecName() != null && employee.getDecName() != "") {
			s = s + "@p_empName='" + employee.getDecName() + "',";
		}
		if (employee.getDecDob() != null && employee.getDecDob() != "") {
			s = s + "@p_decDob='" + DateFormatter.getStringDate(employee.getDecDob()) + "',";
		}
		
		if (employee.getDecRelation() != null && employee.getDecRelation() != "") {
			s = s + "@p_relation='" + employee.getDecRelation() + "',";
		}
		if (employee.getOrganization() != null && employee.getOrganization() != "") {
			s = s + "@p_org='" + employee.getOrganization() + "',";
		}
		
		if (employee.getOrgDivision() != null && employee.getOrgDivision() != "") {
			s = s + "@p_div='" + employee.getOrgDivision() + "',";
		}
		if (employee.getFinancialYr() != null && employee.getFinancialYr() != "") {
			s = s + "@p_fYear='" + employee.getFinancialYr() + "',";
		}
		// address
           s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		

		return s;
	}
	
	
	public static String getAddInsuranceNomineeParam(InsuranceAndNomineeRestModel employee) {

		String s = "";
		
		s = s + "@p_nomSlNo='" + employee.getNomId() + "',";
		s = s + "@p_einsuranceId='" + employee.getInsuId() + "',";
		s = s + "@p_declareId='" + employee.getNomName() + "',";

		if (employee.getEmpId() != null && employee.getEmpId() != "") {
			s = s + "@p_empId='" + employee.getEmpId() + "',";
		}
		if (employee.getNomPerOfShare() != null && employee.getNomPerOfShare() != "") {
			s = s + "@p_pOfShare='" + employee.getNomPerOfShare() + "',";
		}
		
		if (employee.getOrganization() != null && employee.getOrganization() != "") {
			s = s + "@p_org='" + employee.getOrganization() + "',";
		}
		
		if (employee.getOrgDivision() != null && employee.getOrgDivision() != "") {
			s = s + "@p_div='" + employee.getOrgDivision() + "',";
		}
		
           s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		
		return s;
	}

}
