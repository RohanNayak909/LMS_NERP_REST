package nirmalya.aatithya.restmodule.common.utils.projects;

import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;

public class GenerateManageProjectCategoryParameter {
	
	public static String getProjectCategoryParam(RestProjectCategoryModel category) {
		String s = "";

		if (category.getCategoryId() != null || category.getCategoryId() != "") {
			s = s + "@p_categoryId='" + category.getCategoryId() + "',";
		}

		if (category.getCategoryName() != null || category.getCategoryName() != "") {
			s = s + "@p_CategoryName='" + category.getCategoryName() + "',";
		}

		if (category.getCreatedBy() != null || category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		}

		if (category.getOrganizationName() != null || category.getOrganizationName() != "") {
			s = s + "@p_OrganizationName='" + category.getOrganizationName() + "',";
		}
		if (category.getOrganizationDivision() != null || category.getOrganizationDivision() != "") {
			s = s + "@p_OrganizationDivision='" + category.getOrganizationDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
	
	
	public static String getProjectSubCategoryParam(RestProjectCategoryModel category) {
		String s = "";

		if (category.getSubcategoryId() != null || category.getSubcategoryId() != "") {
			s = s + "@p_subcategoryId='" + category.getSubcategoryId() + "',";
		}
		
		if (category.getCategoryId() != null || category.getCategoryId() != "") {
			s = s + "@p_CategoryId='" + category.getCategoryId() + "',";
		}


		if (category.getSubcategoryName() != null || category.getSubcategoryName() != "") {
			s = s + "@p_subcategoryName='" + category.getSubcategoryName() + "',";
		}

		if (category.getCreatedBy() != null || category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		}

		if (category.getOrganizationName() != null || category.getOrganizationName() != "") {
			s = s + "@p_OrganizationName='" + category.getOrganizationName() + "',";
		}
		if (category.getOrganizationDivision() != null || category.getOrganizationDivision() != "") {
			s = s + "@p_OrganizationDivision='" + category.getOrganizationDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
