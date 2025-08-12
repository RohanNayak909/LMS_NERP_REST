package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.stakeholder.model.RestManagePropertyModel;

public class GenerateManagePropertyParam {
	public static String addPropertyParam(RestManagePropertyModel restManagePropertyModel) {

		String s ="";
		

		
		
		
		if (restManagePropertyModel.getPropId() != null || restManagePropertyModel.getPropId() != "") {
			s = s + "@p_propId='" + restManagePropertyModel.getPropId() + "',";
		}
		
		if (restManagePropertyModel.getType() != null || restManagePropertyModel.getType() != "") {
			s = s + "@p_type='" + restManagePropertyModel.getType()+ "',";
		}

		if (restManagePropertyModel.getPropname() != null || restManagePropertyModel.getPropname() != "") {
			s = s + "@p_propname='" + restManagePropertyModel.getPropname()+ "',";
		}
		
		if (restManagePropertyModel.getEmail() != null || restManagePropertyModel.getEmail() != "") {
			s = s + "@p_email='" + restManagePropertyModel.getEmail()+ "',";
		}
		
		if (restManagePropertyModel.getRent()!= null || restManagePropertyModel.getRent() != "") {
			s = s + "@p_rent='" + restManagePropertyModel.getRent()+ "',";
		}
		if (restManagePropertyModel.getActrent()!= null || restManagePropertyModel.getActrent() != "") {
			s = s + "@p_actrent='" + restManagePropertyModel.getActrent()+ "',";
		}
		if (restManagePropertyModel.getAreas()!= null || restManagePropertyModel.getAreas() != "") {
			s = s + "@p_areas='" + restManagePropertyModel.getAreas()+ "',";
		}
		if (restManagePropertyModel.getAddress()!= null || restManagePropertyModel.getAddress() != "") {
			s = s + "@p_address='" + restManagePropertyModel.getAddress()+ "',";
		}
		if (restManagePropertyModel.getName()!= null || restManagePropertyModel.getName() != "") {
			s = s + "@p_name='" + restManagePropertyModel.getName()+ "',";
		}
		if (restManagePropertyModel.getArea()!= null || restManagePropertyModel.getArea() != "") {
			s = s + "@p_area='" + restManagePropertyModel.getArea()+ "',";
		}
		if (restManagePropertyModel.getPropprice()!= null || restManagePropertyModel.getPropprice() != "") {
			s = s + "@p_propprice='" + restManagePropertyModel.getPropprice()+ "',";
		}
		if (restManagePropertyModel.getTenantname()!= null || restManagePropertyModel.getTenantname() != "") {
			s = s + "@p_tenantname='" + restManagePropertyModel.getTenantname()+ "',";
		}
		if (restManagePropertyModel.getDocName()!= null || restManagePropertyModel.getDocName() != "") {
			s = s + "@p_docname='" + restManagePropertyModel.getDocName()+ "',";
		}
		
		if (restManagePropertyModel.getStartdate()!= null || restManagePropertyModel.getStartdate() != "") {
			s = s + "@p_address='" + restManagePropertyModel.getAddress()+ "',";
		}
		
		if (restManagePropertyModel.getStartdate()!= null || restManagePropertyModel.getStartdate() != "") {
			s = s + "@p_startdate='" + restManagePropertyModel.getStartdate()+ "',";
		}
		
		if (restManagePropertyModel.getEnddate()!= null || restManagePropertyModel.getEnddate() != "") {
			s = s + "@p_enddate='" + restManagePropertyModel.getEnddate()+ "',";
		}
		if (restManagePropertyModel.getCreatedBy() != null || restManagePropertyModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restManagePropertyModel.getCreatedBy()+ "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

}
