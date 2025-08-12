package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.RestEmployeeCCRModel;

public class GenerateParamCCRData {

	public static String getCCRParam(RestEmployeeCCRModel vitamin) {
		String s = "";
		System.out.println(vitamin);
		if (vitamin.getReviewId() != null) {
			s = s + "@p_reviewId='" + vitamin.getReviewId() + "',";
		}else {
			s = s + "@p_reviewId='',";
		}
		if (vitamin.getEmpId() != null && vitamin.getEmpId() != "") {
			s = s + "@p_empId='" + vitamin.getEmpId() + "',";
		}else {
			s = s + "@p_empId='',";
		}
		if (vitamin.getDate() != null && vitamin.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(vitamin.getDate()) + "',";
		}else {
			s = s + "@p_date='',";
		}
		if (vitamin.getType() != null && vitamin.getType() != "" ) {
			s = s + "@p_type='" + vitamin.getType() + "',";
		}else {
			s = s + "@p_type='',";
		}
		if (vitamin.getSubject() != null && vitamin.getSubject() != "") {
			s = s + "@p_subject='" + vitamin.getSubject() + "',";
		}else {
			s = s + "@p_subject='',";
		}
		if (vitamin.getRemark() != null && vitamin.getRemark() != "") {
			s = s + "@p_remark='" + vitamin.getRemark() + "',";
		}else {
			s = s + "@p_remark='',";
		}
		if (vitamin.getExpectedResult() != null && vitamin.getExpectedResult() != "") {
			s = s + "@p_expectedResult='" + vitamin.getExpectedResult() + "',";
		}else {
			s = s + "@p_expectedResult='',";
		}
		if (vitamin.getGuidedBy() != null && vitamin.getGuidedBy() != "") {
			s = s + "@p_guidedBy='" + vitamin.getGuidedBy() + "',";
		}else {
			s = s + "@p_guidedBy='',";
		}
		if (vitamin.getCreatedBy() != null && vitamin.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + vitamin.getCreatedBy() + "',";
		}else {
			s = s + "@p_createdBy='',";
		}
		if (vitamin.getOrganization() != null && vitamin.getOrganization() != "") {
			s = s + "@p_org='" + vitamin.getOrganization() + "',";
		}else {
			s = s + "@p_org='',";
		}
		if (vitamin.getOrgDivision() != null && vitamin.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + vitamin.getOrgDivision() + "',";
		}else {
			s = s + "@p_orgDiv='',";
		}
		if (vitamin.getDocName() != null && vitamin.getDocName() != "") {
			s = s + "@p_docName='" + vitamin.getDocName() + "',";
		}else {
			s = s + "@p_docName='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
