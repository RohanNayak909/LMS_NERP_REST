package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.RestEmployeeResignationDocModel;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeResignationModel;


public class GenerateEmployeeResignationParameter {
	
	public static String getEmployeeResignationParam(RestEmployeeResignationModel data) {
		String s = "";
		String resignationDraftId = "";
		String resignationId = "";
		String empId = "";
		String regTo = "";
		String regCC = "";
		String subject = data.getSubject()
				.replace("\\", "\\\\")  
                .replace("'", "''")      
                .replace("\"", "\\\"") 
                .replace("\n", "\\n")  
                .replace(";", "\\;");   
				
		String reason = data.getReason()
                .replace("\\", "\\\\")   // Escape backslashes
                .replace("'", "''")      // Escape single quotes for SQL
                .replace("\"", "\\\"")   // Escape double quotes
                .replace("\n", "\\n")    // Escape newlines
                .replace(";", "\\;");    // Escape semicolons


		String resignDate = "";
		String releaseDate = "";
		String createdBy = "";
		String organization=""; 
		String orgDivision="";
		String document="";

			resignationDraftId = data.getResignationDraftId();
			resignationId = data.getResignationId();
			empId = data.getEmpId();
			regTo =data.getRegTo();
			regCC = data.getRegCC();
			//subject = data.getSubject();
			//reason = data.getReason();
			resignDate = data.getResignDate();
			releaseDate = data.getReleaseDate();
			createdBy=data.getCreatedBy();
			organization=data.getOrganization();
			orgDivision=data.getOrgDivision();
			
		s = s + "@p_resignationDraftId='" + resignationDraftId + "',";
		s = s + "@p_resignationId='" + resignationDraftId + "',";
		s = s + "@p_empId='" + empId + "',";
		s = s + "@p_regTo='" + regTo + "',";
		s = s + "@p_regCC='" + regCC + "',";
		s = s + "@p_subject='" + subject + "',";
		s = s + "@p_reason='" + reason + "',";
		s = s + "@p_resignDate='" + resignDate + "',";
		s = s + "@p_releaseDate='" + releaseDate + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
 
		
		System.out.println("data.getDocumentList() >>"+data.getDocumentList() );
		if(data.getDocumentList() != null && !data.getDocumentList().isEmpty()) {
		    for (RestEmployeeResignationDocModel a : data.getDocumentList()) {
		        document = document + "(@p_resignationId, \"" + a.getDocumnentName() + "\", \""
		                + a.getFileName() + "\", \"" + a.getDocumentURL() + "\", @p_createdBy, @p_org, @p_orgDiv),";
		    }
		}
		
		if(document.length()!=0) {
			document = document.substring(0, document.length() - 1);
		}
		
		s = s + "@p_documentSubQuery='" + document + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
	
		System.out.println("Generate reg Params"+s);
		return s;
	}
}
