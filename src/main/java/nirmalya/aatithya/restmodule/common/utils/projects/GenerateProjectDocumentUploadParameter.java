package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectFileuploadModel;

public class GenerateProjectDocumentUploadParameter {
	
	
	public static String getDocumentParamSave(List<ProjectCreationRestModel> prjCreation) {
		String s = "";
		String multidocument = "";
		if (!prjCreation.get(0).getDocumentTypeId().contentEquals("1")) {
			if (prjCreation.get(0).getDocumentTypeId() != null && prjCreation.get(0).getDocumentTypeId() != "") {
				s = s + "@p_typeid='" + prjCreation.get(0).getDocumentTypeId() + "',";
			}
			if (prjCreation.get(0).getProjectId() != null && prjCreation.get(0).getProjectId() != "") {
				s = s + "@p_projectId='" + prjCreation.get(0).getProjectId() + "',";
			}
			for (RestProjectFileuploadModel a : prjCreation.get(0).getDocumentList()) {
				multidocument = multidocument + "(@p_documentId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
				+ "\",\"" + prjCreation.get(0).getProjectId() + "\",\"" + prjCreation.get(0).getDocumentTypeId()
				+ "\",\"" + prjCreation.get(0).getCreatedBy() + "\",\"" + prjCreation.get(0).getOrganizationName()
				+ "\",\"" + prjCreation.get(0).getOrganizationDivision() + "\",\""
				+ DateFormatter.getStringDate(a.getDocDate()) + "\"),";
		 }
		multidocument = multidocument.substring(0, multidocument.length() - 1);
		s = s + "@p_projectDocuments='" + multidocument + "',";

				if (s != "") {
					s = s.substring(0, s.length() - 1);

					s = "SET " + s + ";";
				}
		}
	
		return s;

	}
	
	

	public static String getDocumentParamTemplate(List<ProjectCreationRestModel> prjCreation) {
		String s = "";
		String multidocument = "";
		if (!prjCreation.get(0).getDocumentTypeId().contentEquals("1")) {
			if (prjCreation.get(0).getDocumentTypeId() != null && prjCreation.get(0).getDocumentTypeId() != "") {
				s = s + "@p_typeid='" + prjCreation.get(0).getDocumentTypeId() + "',";
			}
			for (RestProjectFileuploadModel a : prjCreation.get(0).getDocumentList()) {
				multidocument = multidocument + "(\"" + a.getFileName() + "\",\"" + a.getDocumnentName() + "\",\""
						+ prjCreation.get(0).getDocumentTypeId() + "\",\"" + prjCreation.get(0).getCreatedBy() + "\",\""
						+ prjCreation.get(0).getOrganizationName() + "\",\""
						+ prjCreation.get(0).getOrganizationDivision() + "\"),";
			}
			multidocument = multidocument.substring(0, multidocument.length() - 1);
			s = s + "@p_projectDocuments='" + multidocument + "',";

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}

		return s;

	}

}
