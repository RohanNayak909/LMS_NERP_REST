package nirmalya.aatithya.restmodule.common.utils.projects;

import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;

public class GenerateProjectNfaParameter {
	
	public static String getProjectNfa(ProjectCreationRestModel category) {
		String s = "";

		if (category.getNfaId() != null || category.getNfaId() != "") {
			s = s + "@p_nfaId='" + category.getNfaId() + "',";
		}

		if (category.getProjectId() != null || category.getProjectId() != "") {
			s = s + "@p_projectId='" + category.getProjectId() + "',";
		}
		

		if (category.getNfaDescription() != null || category.getNfaDescription() != "") {
			s = s + "@p_nfaDesc='" + category.getNfaDescription() + "',";
		}
		
		if (category.getDocumentTypeId() != null || category.getDocumentTypeId() != "") {
			s = s + "@p_documentTypeId='" + category.getDocumentTypeId() + "',";
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
