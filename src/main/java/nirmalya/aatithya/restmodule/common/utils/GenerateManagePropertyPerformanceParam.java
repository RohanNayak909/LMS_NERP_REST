package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.stakeholder.model.RestManagePropertyPerformanceModel;

public class GenerateManagePropertyPerformanceParam {

	public static String addPropertyPerformanceParam(RestManagePropertyPerformanceModel restManagePropertyPerformanceModel) {

		String s ="";
		if (restManagePropertyPerformanceModel.getPerformanceId() != null || restManagePropertyPerformanceModel.getPerformanceId() != "") {
			s = s + "@p_PerformanceId='" + restManagePropertyPerformanceModel.getPerformanceId() + "',";
		}
		if (restManagePropertyPerformanceModel.getPropNo() != null || restManagePropertyPerformanceModel.getPropNo() != "") {
			s = s + "@p_propNo='" + restManagePropertyPerformanceModel.getPropNo() + "',";
		}
		
		if (restManagePropertyPerformanceModel.getAlliesname() != null || restManagePropertyPerformanceModel.getAlliesname() != "") {
			s = s + "@p_alliesName='" + restManagePropertyPerformanceModel.getAlliesname() + "',";
		}
		
		if (restManagePropertyPerformanceModel.getActualRent() != null || restManagePropertyPerformanceModel.getActualRent() != "") {
			s = s + "@p_actualRent='" + restManagePropertyPerformanceModel.getActualRent()+ "',";
		}
		if (restManagePropertyPerformanceModel.getAnnualRent()!= null || restManagePropertyPerformanceModel.getAnnualRent() != "") {
			s = s + "@p_annualRent='" + restManagePropertyPerformanceModel.getAnnualRent()+ "',";
		}
		if (restManagePropertyPerformanceModel.getType()!= null || restManagePropertyPerformanceModel.getType() != "") {
			s = s + "@p_Type='" + restManagePropertyPerformanceModel.getType()+ "',";
		}
		if (restManagePropertyPerformanceModel.getAnnualRent()!= null || restManagePropertyPerformanceModel.getAnnualRent() != "") {
			s = s + "@p_annualRent='" + restManagePropertyPerformanceModel.getAnnualRent()+ "',";
		}
		if (restManagePropertyPerformanceModel.getExperience()!= null || restManagePropertyPerformanceModel.getExperience() != "") {
			s = s + "@p_experience='" + restManagePropertyPerformanceModel.getExperience()+ "',";
		}
		if (restManagePropertyPerformanceModel.getArea()!= null || restManagePropertyPerformanceModel.getArea() != "") {
			s = s + "@p_area='" + restManagePropertyPerformanceModel.getArea()+ "',";
		}
		if (restManagePropertyPerformanceModel.getNetIncome()!= null || restManagePropertyPerformanceModel.getNetIncome() != "") {
			s = s + "@p_netIncome='" + restManagePropertyPerformanceModel.getNetIncome()+ "',";
		}
		
		if (restManagePropertyPerformanceModel.getPropPrice()!= null || restManagePropertyPerformanceModel.getPropPrice() != "") {
			s = s + "@p_purchprice='" + restManagePropertyPerformanceModel.getPropPrice()+ "',";
		}
		if (restManagePropertyPerformanceModel.getReturnRate()!= null || restManagePropertyPerformanceModel.getReturnRate() != "") {
			s = s + "@p_returnRate='" + restManagePropertyPerformanceModel.getReturnRate()+ "',";
		}
		
		if (restManagePropertyPerformanceModel.getCreatedby() != null || restManagePropertyPerformanceModel.getCreatedby() != "") {
			s = s + "@p_createdBy='" + restManagePropertyPerformanceModel.getCreatedby()+ "',";
		}
		if (restManagePropertyPerformanceModel.getCreatedon() != null || restManagePropertyPerformanceModel.getCreatedon() != "") {
			s = s + "@p_createdon='" + restManagePropertyPerformanceModel.getCreatedon()+ "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

}
