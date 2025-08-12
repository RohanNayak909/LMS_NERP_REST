package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModelV1;
import nirmalya.aatithya.restmodule.projects.model.RestProjectFileuploadModelV1;



public class GenerateProjectCreationParameterV1 {
	public static String getPrjCreateParamV1(List<ProjectCreationRestModelV1> prjCreation) {
		String s = "";
		String multidocument = "";


		if (prjCreation.get(0).getProjectId() != null || prjCreation.get(0).getProjectId() != "") {
			s = s + "@p_projectId='" + prjCreation.get(0).getProjectId() + "',";
		}

		if (prjCreation.get(0).getProjectName() != null || prjCreation.get(0).getProjectName() != "") {
			s = s + "@p_getProjectName='" + prjCreation.get(0).getProjectName() + "',";
		}
		
		if (prjCreation.get(0).getProjectIncharge() != null || prjCreation.get(0).getProjectIncharge() != "") {
			s = s + "@p_getProjectInc='" + prjCreation.get(0).getProjectIncharge() + "',";
		}

		if (prjCreation.get(0).getStatus() != null || prjCreation.get(0).getStatus() != "") {
			s = s + "@p_getStatus='" + prjCreation.get(0).getStatus() + "',";
		}
		if (prjCreation.get(0).getProjectType() != null
				|| prjCreation.get(0).getProjectType() != "") {
			s = s + "@p_ProjectType='" + prjCreation.get(0).getProjectType() + "',";
		}
		if (prjCreation.get(0).getPinCode() != null
				|| prjCreation.get(0).getPinCode() != "") {
			s = s + "@p_pinCode='" + prjCreation.get(0).getPinCode() + "',";
		}
		
		if (prjCreation.get(0).getAddress() != null
				|| prjCreation.get(0).getAddress() != "") {
			s = s + "@p_address='" + prjCreation.get(0).getAddress() + "',";
		}
		if (prjCreation.get(0).getCreatedBy() != null || prjCreation.get(0).getCreatedBy() != "") {
			s = s + "@p_getCreatedBy='" + prjCreation.get(0).getCreatedBy() + "',";
		}

		if (prjCreation.get(0).getOrganizationName() != null || prjCreation.get(0).getOrganizationName() != "") {
			s = s + "@p_org='" + prjCreation.get(0).getOrganizationName() + "',";
		}

		if (prjCreation.get(0).getOrganizationDivision() != null
				|| prjCreation.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + prjCreation.get(0).getOrganizationDivision() + "',";
		}
		
	
		if (prjCreation.get(0).getDate() != null
				|| prjCreation.get(0).getDate() != "") {
			s = s + "@p_creationDate='" + prjCreation.get(0).getDate() + "',";
		}

		if (!prjCreation.get(0).getProjectId().contentEquals("1")) {
			
			for (RestProjectFileuploadModelV1 a : prjCreation.get(0).getDocumentList1()) {
			    multidocument = multidocument + "(@p_projectId,\"" + a.getSlNo() + "\",\"" 
			        + a.getDocumentName() + "\",\"" + a.getDocumentFileName() + "\",\"" 
			        + prjCreation.get(0).getOrganizationName() + "\",\"" 
			        + prjCreation.get(0).getOrganizationDivision() + "\"),";
			}

			if (!multidocument.isEmpty()) {
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_projectDocuments='" + multidocument + "',";
			}else {
				s = s + "@p_projectDocuments='" + multidocument + "',";
			}
			
			

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
			System.out.println("value is coming for add project v1======> "+s);

		}

		return s;
		

	}


}
