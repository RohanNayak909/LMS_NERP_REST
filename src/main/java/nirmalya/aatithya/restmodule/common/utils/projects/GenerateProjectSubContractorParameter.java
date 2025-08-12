package nirmalya.aatithya.restmodule.common.utils.projects;

import nirmalya.aatithya.restmodule.projects.model.ProjectSubContractorRestModel;

public class GenerateProjectSubContractorParameter {

	public static String getProjectSubContractorParam(ProjectSubContractorRestModel SubContractor) {
		String s = "";

		if (SubContractor.getContractorId() != null || SubContractor.getContractorId() != "") {
			s = s + "@p_ContractorId='" + SubContractor.getContractorId() + "',";
		}

		if (SubContractor.getContractorName() != null || SubContractor.getContractorName() != "") {
			s = s + "@p_ContractorName='" + SubContractor.getContractorName() + "',";
		}

		if (SubContractor.getEmail() != null || SubContractor.getEmail() != "") {
			s = s + "@p_Email='" + SubContractor.getEmail() + "',";
		}
		if (SubContractor.getPhone() != null || SubContractor.getPhone() != "") {
			s = s + "@p_Phone='" + SubContractor.getPhone() + "',";
		}
		if (SubContractor.getContractorType() != null || SubContractor.getContractorType() != "") {
			s = s + "@p_ContractorType='" + SubContractor.getContractorType() + "',";
		}
		if (SubContractor.getGstIn() != null || SubContractor.getGstIn() != "") {
			s = s + "@p_GstIn='" + SubContractor.getGstIn() + "',";
		}
		if (SubContractor.getPanId() != null || SubContractor.getPanId() != "") {
			s = s + "@p_PanId='" + SubContractor.getPanId() + "',";
		}
		if (SubContractor.getAddress1() != null || SubContractor.getAddress1() != "") {
			s = s + "@p_Address1='" + SubContractor.getAddress1() + "',";
		}
		if (SubContractor.getAddress2() != null || SubContractor.getAddress2() != "") {
			s = s + "@p_Address2='" + SubContractor.getAddress2() + "',";
		}
		if (SubContractor.getCity() != null || SubContractor.getCity() != "") {
			s = s + "@p_City='" + SubContractor.getCity() + "',";
		}
		if (SubContractor.getState() != null || SubContractor.getState() != "") {
			s = s + "@p_State='" + SubContractor.getState() + "',";
		}
		if (SubContractor.getPinId() != null || SubContractor.getPinId() != "") {
			s = s + "@p_PinId='" + SubContractor.getPinId() + "',";
		}
		if (SubContractor.getStatus() != null || SubContractor.getStatus() != "") {
			s = s + "@p_Status='" + SubContractor.getStatus() + "',";
		}

		if (SubContractor.getCreatedBy() != null || SubContractor.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + SubContractor.getCreatedBy() + "',";
		}

		if (SubContractor.getOrganizationName() != null || SubContractor.getOrganizationName() != "") {
			s = s + "@p_OrganizationName='" + SubContractor.getOrganizationName() + "',";
		}
		if (SubContractor.getOrganizationDivision() != null
				|| SubContractor.getOrganizationDivision() != "") {
			s = s + "@p_OrganizationDivision='" + SubContractor.getOrganizationDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	public static String getProjectSubContractorParamm(ProjectSubContractorRestModel SubContractor) {
		String s = "";

		if (SubContractor.getSubContractorId() != null || SubContractor.getSubContractorId() != "") {
			s = s + "@p_SubContractorId='" + SubContractor.getSubContractorId() + "',";
		}
		if (SubContractor.getProjectId() != null || SubContractor.getProjectId() != "") {
			s = s + "@p_ProjectId='" + SubContractor.getProjectId() + "',";
		}
		if (SubContractor.getProjectName() != null || SubContractor.getProjectName() != "") {
			s = s + "@p_ProjectName='" + SubContractor.getProjectName() + "',";
		}
		if (SubContractor.getTask() != null || SubContractor.getTask() != "") {
			s = s + "@p_Task='" + SubContractor.getTask() + "',";
		}
		if (SubContractor.getScopeoftheWork() != null || SubContractor.getScopeoftheWork() != "") {
			s = s + "@p_ScopeoftheWork='" + SubContractor.getScopeoftheWork() + "',";
		}
		if (SubContractor.getDurationoftheWork() != null || SubContractor.getDurationoftheWork() != "") {
			s = s + "@p_DurationoftheWork='" + SubContractor.getDurationoftheWork() + "',";
		}
		if (SubContractor.getLicenseVerified() != null || SubContractor.getLicenseVerified() != "") {
			s = s + "@p_LicenseVerified='" + SubContractor.getLicenseVerified() + "',";
		}
		if (SubContractor.getStatementofintentRecieved() != null
				|| SubContractor.getStatementofintentRecieved() != "") {
			s = s + "@p_StatementofintentRecieved='" + SubContractor.getStatementofintentRecieved() + "',";
		}
		if (SubContractor.getRequesttosubletRecieved() != null || SubContractor.getRequesttosubletRecieved() != "") {
			s = s + "@p_RequesttosubletRecieved='" + SubContractor.getRequesttosubletRecieved() + "',";
		}
		if (SubContractor.getScheduleofworkRecieved() != null || SubContractor.getScheduleofworkRecieved() != "") {
			s = s + "@p_ScheduleofworkRecieved='" + SubContractor.getScheduleofworkRecieved() + "',";
		}
		if (SubContractor.getDrawingsProvided() != null || SubContractor.getDrawingsProvided() != "") {
			s = s + "@p_DrawingsProvided='" + SubContractor.getDrawingsProvided() + "',";
		}
		if (SubContractor.getPunchlistComplete() != null || SubContractor.getPunchlistComplete() != "") {
			s = s + "@p_PunchlistComplete='" + SubContractor.getPunchlistComplete() + "',";
		}
		if (SubContractor.getDateofnoticetoproceedIssued() != null
				|| SubContractor.getDateofnoticetoproceedIssued() != "") {
			s = s + "@p_DateofnoticetoproceedIssued='" + SubContractor.getDateofnoticetoproceedIssued() + "',";
		}
		if (SubContractor.getDatecontractExecuted() != null || SubContractor.getDatecontractExecuted() != "") {
			s = s + "@p_DatecontractExecuted='" + SubContractor.getDatecontractExecuted() + "',";
		}
		if (SubContractor.getDateinsuranceRecieved() != null || SubContractor.getDateinsuranceRecieved() != "") {
			s = s + "@p_DateinsuranceRecieved='" + SubContractor.getDateinsuranceRecieved() + "',";
		}
		if (SubContractor.getOtherrequiredDocumentation() != null
				|| SubContractor.getOtherrequiredDocumentation() != "") {
			s = s + "@p_OtherrequiredDocumentation='" + SubContractor.getOtherrequiredDocumentation() + "',";
		}

		if (SubContractor.getCreatedBy() != null || SubContractor.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + SubContractor.getCreatedBy() + "',";
		}

		if (SubContractor.getOrganizationName() != null || SubContractor.getOrganizationName() != "") {
			s = s + "@p_OrganizationName='" + SubContractor.getOrganizationName() + "',";
		}
		if (SubContractor.getOrganizationDivision() != null || SubContractor.getOrganizationDivision() != "") {
			s = s + "@p_OrganizationDivision='" + SubContractor.getOrganizationDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
