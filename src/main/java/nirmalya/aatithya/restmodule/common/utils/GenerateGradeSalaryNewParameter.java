package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.RestGradeSalaryNewMasterModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

public class GenerateGradeSalaryNewParameter {

	public static String addGradeSalaryParam(List<RestGradeSalaryNewMasterModel> gradeSalaryMaster) {
		String s = "";
		String litem = "";
		String deleteGradeSalary = "";
		for (RestGradeSalaryNewMasterModel m : gradeSalaryMaster) {

			deleteGradeSalary = deleteGradeSalary + "(\"" + m.getGrade() + "\",\""+ m.getComponent() + "\",\"" + m.getComponentType()
					+ "\"),";
			litem = litem + "(\"" + m.getGrdsalaryId() + "\",\""+m.getGrade() + "\",\"" + m.getComponent() + "\",\"" + m.getComponentType() + "\",\""
					+ m.getCalculationType() + "\"," + m.getPercentage() + ",\"" + m.getgCreatedBy() + "\",\"" +m.getgActive() + "\",\"" +m.getDesc() +"\"),";
		}
		litem = litem.substring(0, litem.length() - 1);
		deleteGradeSalary = deleteGradeSalary.substring(0, deleteGradeSalary.length() - 1);

		s = s + "@p_deleteSubQuery='" + "(" + deleteGradeSalary + ")" + "',";
		s = s + "@p_gradeId='" + gradeSalaryMaster.get(0).getGrade() + "',";
		s = s + "@p_litem='" + litem + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("data are " + s);
		return s;
	}
	
}
