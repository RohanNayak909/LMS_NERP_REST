package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.projects.model.RestComplianceManagementModel;

public class GenerateComplianceParam {
	public static String saveCompliance(List<RestComplianceManagementModel> category) {

		String s = "";

		if (category.get(0).getComplianceId() != null && category.get(0).getComplianceId() != "") {
			s = s + "@p_comId='" + category.get(0).getComplianceId() + "',";
		}
		if (category.get(0).getComplianceNo() != null && category.get(0).getComplianceNo() != "") {
			s = s + "@p_comNo='" + category.get(0).getComplianceNo() + "',";
		}
		if (category.get(0).getComplianceName() != null && category.get(0).getComplianceName() != "") {
			s = s + "@p_comName='" + category.get(0).getComplianceName() + "',";
		}
		if (category.get(0).getPurpose() != null && category.get(0).getPurpose() != "") {
			s = s + "@p_purpose='" + category.get(0).getPurpose() + "',";
		}
		
		if (DateFormatter.getStringDate(category.get(0).getFromdate()) != null && DateFormatter.getStringDate(category.get(0).getFromdate()) != "") {
			s = s + "@p_fDate='" + DateFormatter.getStringDate(category.get(0).getFromdate()) + "',";
		}

		if (DateFormatter.getStringDate(category.get(0).getToDate()) != null && DateFormatter.getStringDate(category.get(0).getToDate()) != "") {
			s = s + "@p_tDate='" + DateFormatter.getStringDate(category.get(0).getToDate()) + "',";
		}

		if (category.get(0).getStatus() != null && category.get(0).getStatus() != "") {
			s = s + "@p_status='" + category.get(0).getStatus() + "',";
		}
		if (category.get(0).getNoOfPeoples() != null && category.get(0).getNoOfPeoples() != "") {
			s = s + "@p_noOfPeoples='" + category.get(0).getNoOfPeoples() + "',";
		}

		

		if (category.get(0).getComDescription() != null && category.get(0).getComDescription() != "") {
			s = s + "@p_comDesc='" + category.get(0).getComDescription() + "',";
		}
		
		if (category.get(0).getFileAttach() != null && category.get(0).getFileAttach() != "") {
			s = s + "@p_fileAttach='" + category.get(0).getFileAttach() + "',";
		}
		
		if (category.get(0).getProjectId() != null && category.get(0).getProjectId() != "") {
			s = s + "@p_projectId='" + category.get(0).getProjectId() + "',";
		}

		if (category.get(0).getCreatedBy() != null && category.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.get(0).getCreatedBy() + "',";
		}

		if (category.get(0).getOrganizationName() != null && category.get(0).getOrganizationName() != "") {
			s = s + "@p_orgname='" + category.get(0).getOrganizationName() + "',";
		}
		if (category.get(0).getOrganizationDivision() != null && category.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgdiv='" + category.get(0).getOrganizationDivision() + "',";
		}
		



		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

	//	System.out.println(s);

		return s;
	}
}
