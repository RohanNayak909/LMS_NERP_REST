package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.controller.RestEmployeeBonusModel;

public class GenerateParameterEmployeeBonusExgratia {

	public static String addUloadedEmployeeBonusExgratia(List<RestEmployeeBonusModel> model) {
		String s = "";
		String datalist = ""; 
		String empList = "";

		if (model.size() > 0) {
			for (RestEmployeeBonusModel m : model) {
				datalist = datalist+ "(\"" + m.getEmployeeId() + "\",\"" + m.getDate() + "\",\"" + m.getAttendance() + "\",\"" + m.getBasicSal() + "\",\"" 
				+ m.getBonus() + "\", \"" + m.getExgratia() + "\",\"" + m.getTotal() + "\", \"" + m.getDetails() + "\",now(),\"" 
				+ m.getCreatedBy() + "\",\""+m.getOrganization()+"\",\"" + m.getOrgDivision()
				+"\",DATE_FORMAT(@p_date, \"%m\"),DATE_FORMAT(@p_date, \\\"%Y\\\")),";
				
				empList = empList + "\"" + m.getEmployeeId() +"\",";
			}
		}
		if(!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_EmpSubQuery='" + datalist + "',";
		}
		empList = empList.substring(0, empList.length() - 1);
		s = s + "@p_empList='(" + empList + ")',";
		s = s + "@p_date='" + model.get(0).getDate() + "',";
		s = s + "@p_month='DATE_FORMAT(@p_date, \\\"%m\\\")',";
		s = s + "@p_year='DATE_FORMAT(@p_date, \\\"%Y\\\")',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
