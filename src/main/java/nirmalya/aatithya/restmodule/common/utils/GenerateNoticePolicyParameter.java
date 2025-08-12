package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.ManageNoticeRestModel;
import nirmalya.aatithya.restmodule.master.model.ManagePolicyRestModel;
import nirmalya.aatithya.restmodule.master.model.ManagePolicyRulesRestModel;
import nirmalya.aatithya.restmodule.master.model.NoticeDocumentUploadRestController;

public class GenerateNoticePolicyParameter {
	
	/*
	 * 
	 * ################################### Letter Section ###################################################
	 * 
	 */								
		
	
	public static String addNoticePolicy(ManagePolicyRestModel notice) {
		String s = "";
		String sitem = "";
	

		// parent table

		if (notice.getPolicyNo() != null && !notice.getPolicyNo().isEmpty()) {
			s = s + "@p_policyNo='" + notice.getPolicyNo() + "',";
		}
		
		if (notice.getPolicyDate() == null || notice.getPolicyDate().isEmpty()) {
		} else {
			s = s + "@p_policyDate='" + DateFormatter.getStringDate(notice.getPolicyDate()) + "',";
		}

		if (notice.getPolicyRemarks() != null && !notice.getPolicyRemarks().isEmpty()) {
			s = s + "@p_remarks=\"" + notice.getPolicyRemarks() + "\",";
		}
		if (notice.getDept() != null && !notice.getDept().isEmpty()) {
			s = s + "@p_dept='" + notice.getDept() + "',";
		}
		if (notice.getIsActive() != null && !notice.getIsActive().isEmpty()) {
			s = s + "@p_isActive='" + notice.getIsActive() + "',";
		}
		if (notice.getCreatedBy() != null && !notice.getCreatedBy().isEmpty()) {
			s = s + "@p_createdBy='" + notice.getCreatedBy() + "',";
		}
		if (notice.getOrganization() != null && !notice.getOrganization().isEmpty()) {
			s = s + "@p_org='" + notice.getOrganization() + "',";
		}
		if (notice.getOrgDivision() != null && !notice.getOrgDivision().isEmpty()) {
			s = s + "@p_orgDiv='" + notice.getOrgDivision() + "',";
		}

		// child table
		for (ManagePolicyRulesRestModel m : notice.getRules()) {
			
			 sitem = sitem + "(@p_policyNo,\"" + m.getPolicyParameter() +
	                    "\",\"" + m.getPolicyFromDays() + "\",\"" + m.getPolicyToDays() + "\",\"" + m.getPolicyGracePeriod() +"\",\"" +
					 notice.getCreatedBy() + "\",\"" + notice.getOrganization() + "\",\"" + notice.getOrgDivision() + "\"),";

		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_rules='" + sitem + "',";

		if (!s.isEmpty()) {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		return s;
	}
	
	
	
	public static String saveNoticeDetails(ManageNoticeRestModel notice) {
		
		String description = notice.getNoticeDescription()
                .replace("'", "''")     
                .replace("\"", "\\\""); 
		
		String subject = notice.getNoticeSubject()
                .replace("'", "''")     
                .replace("\"", "\\\""); 
		
		String reason = notice.getNoticeReason()
				.replace("'", "''")    
				.replace("\"", "\\\""); 
		
		String s = "";
	
		if (notice.getNoticeId() != null && !notice.getNoticeId().isEmpty()) {
			s = s + "@p_noticeId='" + notice.getNoticeId() + "',";
		}
		
		if (notice.getEmployeeId() != null && !notice.getEmployeeId().isEmpty()) {
			s = s + "@p_employeeId='" + notice.getEmployeeId() + "',";
		}
		
		if (notice.getCurrDate() == null || notice.getCurrDate().isEmpty()) {
		} else {
			s = s + "@p_noticeDate='" + DateFormatter.getStringDate(notice.getCurrDate()) + "',";
		}
		if (notice.getAbsentFromDate() == null || notice.getAbsentFromDate().isEmpty()) {
		} else {
			s = s + "@p_absentFrom='" + DateFormatter.getStringDate(notice.getAbsentFromDate()) + "',";
		}
		if (notice.getNoticeType() != null && !notice.getNoticeType().isEmpty()) {
			s = s + "@p_noticeType=\"" + notice.getNoticeType() + "\",";
		}
		if (reason != null && !reason.isEmpty()) {
			s = s + "@p_noticeReason=\"" + reason + "\",";
		}
		if (subject != null && !subject.isEmpty()) {
			s = s + "@p_noticeSubject=\"" + subject + "\",";
		}
		if (description != null && !description.isEmpty()) {
			s = s + "@p_noticeDesc=\"" + description + "\",";
		}
		if (notice.getCreatedBy() != null && !notice.getCreatedBy().isEmpty()) {
			s = s + "@p_createdBy='" + notice.getCreatedBy() + "',";
		}
		if (notice.getOrganization() != null && !notice.getOrganization().isEmpty()) {
			s = s + "@p_org='" + notice.getOrganization() + "',";
		}
		if (notice.getOrgDivision() != null && !notice.getOrgDivision().isEmpty()) {
			s = s + "@p_orgDiv='" + notice.getOrgDivision() + "',";
		}

		if (!s.isEmpty()) {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}
	
	
	//upload response by HR
	public static String uploadResponse(ManageNoticeRestModel notice) {
		String s = "";
		String document = "";
		
		if (notice.getNoticeId() != null && !notice.getNoticeId().isEmpty()) {
			s = s + "@p_noticeId='" + notice.getNoticeId() + "',";
		}
	
		if (notice.getResponseUploadDate() == null || notice.getResponseUploadDate().isEmpty()) {
		} else {
			s = s + "@p_noticeReplyUploadDate='" + DateFormatter.getStringDate(notice.getResponseUploadDate()) + "',";
		}
		if (notice.getEmployeeReplydate() == null || notice.getEmployeeReplydate().isEmpty()) {
		} else {
			s = s + "@p_noticeReplyDate='" + DateFormatter.getStringDate(notice.getEmployeeReplydate()) + "',";
		}
		if (notice.gethRRemarks() != null && !notice.gethRRemarks().isEmpty()) {
			s = s + "@p_hrRemarks=\"" + notice.gethRRemarks() + "\",";
		}
		if (notice.getEmpResponse() != null && !notice.getEmpResponse().isEmpty()) {
			s = s + "@p_empResponse=\"" + notice.getEmpResponse() + "\",";
		}
		if (notice.getNoticeStatus() != null && !notice.getNoticeStatus().isEmpty()) {
			s = s + "@p_noticeStatus=\"" + notice.getNoticeStatus() + "\",";
		}
		
		if (notice.getCreatedBy() != null && !notice.getCreatedBy().isEmpty()) {
			s = s + "@p_createdBy='" + notice.getCreatedBy() + "',";
		}
		if (notice.getOrganization() != null && !notice.getOrganization().isEmpty()) {
			s = s + "@p_org='" + notice.getOrganization() + "',";
		}
		if (notice.getOrgDivision() != null && !notice.getOrgDivision().isEmpty()) {
			s = s + "@p_orgDiv='" + notice.getOrgDivision() + "',";
		}
		
		
		for (NoticeDocumentUploadRestController a : notice.getDocumentList()) {
			document = document + "(@p_noticeId,\"" + a.getDocumnentName() + "\",\""
					+ a.getFileName() + "\",\"" + a.getDocumentURL() + "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
		
		if(document.length()!=0) {
			document = document.substring(0, document.length() - 1);
		}
		
		s = s + "@p_documentSubQuery='" + document + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		
		return s;
	}
	
	
	/*
	 * 
	 * ################################### Notice Section ###################################################
	 * 
	 */		
	
	 

	public static String publishsNoticeDetails(ManageNoticeRestModel notice) {
		String s = "";
	
		String description = notice.getNoticeDescription()
                .replace("'", "''")     // Escape single quotes
                .replace("\"", "\\\""); // Escape double quotes, if needed
		
		String subject = notice.getNoticeSubject()
                .replace("'", "''")     // Escape single quotes
                .replace("\"", "\\\""); // Escape double quotes, if needed

		 
		if (notice.getNoticeId() != null && !notice.getNoticeId().isEmpty()) {
			s = s + "@p_noticeId='" + notice.getNoticeId() + "',";
		}
		
		if (notice.getPublishDate() == null || notice.getPublishDate().isEmpty()) {
		} else {
			s = s + "@p_publishDate='" + DateFormatter.getStringDate(notice.getPublishDate()) + "',";
		}
		
		if (notice.getPublishTo() != null && !notice.getPublishTo().isEmpty()) {
			s = s + "@p_publishTo=\"" + notice.getPublishTo() + "\",";
		}
		if (subject != null && !subject.isEmpty()) {
			s = s + "@p_noticeSubject=\"" + subject + "\",";
		}
		if (description != null && !description.isEmpty()) {
			s = s + "@p_noticeDesc=\"" + description + "\",";
		}
		if (notice.getNoticeType() != null && !notice.getNoticeType().isEmpty()) {
			s = s + "@p_noticeType=\"" + notice.getNoticeType() + "\",";
		}
		if (notice.getCreatedBy() != null && !notice.getCreatedBy().isEmpty()) {
			s = s + "@p_createdBy='" + notice.getCreatedBy() + "',";
		}
		if (notice.getOrganization() != null && !notice.getOrganization().isEmpty()) {
			s = s + "@p_org='" + notice.getOrganization() + "',";
		}
		if (notice.getOrgDivision() != null && !notice.getOrgDivision().isEmpty()) {
			s = s + "@p_orgDiv='" + notice.getOrgDivision() + "',";
		}

		if (!s.isEmpty()) {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}
	

}
