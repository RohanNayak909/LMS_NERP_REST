package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.AppraisalKeyFactorRestModel;

public class GenerateAppraisalKeyFactorParameter {
	
	public static String getAppraisalKeyFactorsParameters(List<AppraisalKeyFactorRestModel> av) {
	    String s = "";
	    String sitem1 = "";

	    if (av.get(0).getCategoryId() != null && !av.get(0).getCategoryId().isEmpty()) {
	        s = s + "@p_CategoryId='" + av.get(0).getCategoryId() + "',";
	    }
	    if (av.get(0).getFactorCategory() != null && !av.get(0).getFactorCategory().isEmpty()) {
	        s = s + "@p_FactorCategory='" + av.get(0).getFactorCategory() + "',";
	    }
	    
	    if (av.get(0).getFromDate() != null && !av.get(0).getFromDate().isEmpty()) {
	        s = s + "@p_FromDate='" + av.get(0).getFromDate() + "',";
	    }
	    
	    if (av.get(0).getToDate() != null && !av.get(0).getToDate().isEmpty()) {
	        s = s + "@p_ToDate='" + av.get(0).getToDate() + "',";
	    }
	    if (av.get(0).getFinancialyear() != null && !av.get(0).getFinancialyear().isEmpty()) {
	        s = s + "@p_finacialYear='" + av.get(0).getFinancialyear() + "',";
	    }
	    if (av.get(0).getUserId() != null && !av.get(0).getUserId().isEmpty()) {
	        s = s + "@p_UserId='" + av.get(0).getUserId() + "',";
	    }

	    if (av.get(0).getOrgName() != null && !av.get(0).getOrgName().isEmpty()) {
	        s = s + "@p_OrgName='" + av.get(0).getOrgName() + "',";
	    }
	    if (av.get(0).getOrgDiv() != null && !av.get(0).getOrgDiv().isEmpty()) {
	        s = s + "@p_OrgDiv='" + av.get(0).getOrgDiv() + "',";
	    }

	    
	    
	    for (AppraisalKeyFactorRestModel m : av.get(0).getGrid1List()) {
	    	sitem1 = sitem1 + "(@p_CategoryId, \"" + m.getSlno() + "\", \"" + m.getFactors() + "\", \"" 
	                 + m.getMaxmark() + "\", \"" + m.getAssementMark() + "\", @p_OrgName, @p_OrgDiv),";

	    }
	    if (!sitem1.isEmpty()) {
	        sitem1 = sitem1.substring(0, sitem1.length() - 1); 
	    }

	    s = s + "@p_itemSubQuery1='" + sitem1 + "',";

	    if (!s.isEmpty()) {
	        s = s.substring(0, s.length() - 1); 
	        s = "SET " + s + ";";
	        System.out.println("-----------------" + s);
	    }

	    return s;
	}

	public static String getSelfAppraisalKeyFactorsParams(List<AppraisalKeyFactorRestModel> av) {
	    String s = "";
	    String sitem1 = "";

	    if (av.get(0).getCategoryId() != null && !av.get(0).getCategoryId().isEmpty()) {
	        s = s + "@p_CategoryId='" + av.get(0).getCategoryId() + "',";
	    }
	    if (av.get(0).getFactorCategory() != null && !av.get(0).getFactorCategory().isEmpty()) {
	        s = s + "@p_FactorCategory='" + av.get(0).getFactorCategory() + "',";
	    }
	    
	    if (av.get(0).getFromDate() != null && !av.get(0).getFromDate().isEmpty()) {
	        s = s + "@p_FromDate='" + av.get(0).getFromDate() + "',";
	    }
	    
	    if (av.get(0).getToDate() != null && !av.get(0).getToDate().isEmpty()) {
	        s = s + "@p_ToDate='" + av.get(0).getToDate() + "',";
	    }
	    if (av.get(0).getUserId() != null && !av.get(0).getUserId().isEmpty()) {
	        s = s + "@p_UserId='" + av.get(0).getUserId() + "',";
	    }
	    if (av.get(0).getRemarks() != null && !av.get(0).getRemarks().isEmpty()) {
	        s = s + "@p_remarks='" + av.get(0).getRemarks() + "',";
	    }
	    if (av.get(0).getManagerRemarks()!= null && !av.get(0).getManagerRemarks().isEmpty()) {
	        s = s + "@p_managerRemarks='" + av.get(0).getManagerRemarks() + "',";
	    }

	    if (av.get(0).getOrgName() != null && !av.get(0).getOrgName().isEmpty()) {
	        s = s + "@p_OrgName='" + av.get(0).getOrgName() + "',";
	    }
	    if (av.get(0).getOrgDiv() != null && !av.get(0).getOrgDiv().isEmpty()) {
	        s = s + "@p_OrgDiv='" + av.get(0).getOrgDiv() + "',";
	    }
	    if (av.get(0).getEmpid() != null && !av.get(0).getEmpid().isEmpty()) {
	        s = s + "@p_empid='" + av.get(0).getEmpid() + "',";
	    }
	    if (av.get(0).getAssignid() != null && !av.get(0).getAssignid().isEmpty()) {
	        s = s + "@p_assignId='" + av.get(0).getAssignid() + "',";
	    }

	    
		/*
		 * for (AppraisalKeyFactorRestModel m : av.get(0).getGrid1List()) { sitem1 =
		 * sitem1 + "(@p_CategoryId, \"" + m.getSlno() + "\", \"" + m.getFactors() +
		 * "\", \"" + m.getMaxmark() + "\", \"" + m.getSelfAssesment() + "\", \"" +
		 * m.getAssementMark() + "\", @p_OrgName, @p_OrgDiv),"; }
		 */
	    
	    for (AppraisalKeyFactorRestModel m : av.get(0).getGrid1List()) {
	        sitem1 += "(\"" + m.getAssignid() + "\", \"" + m.getCategoryId() + "\", \"" + m.getEmpid() + "\", \"" + m.getSlno() + "\", \"" 
	                + m.getFactors() + "\", \"" + m.getMaxmark() + "\", \"" + m.getSelfAssesment() + "\", \"" + m.getAssementMark() 
	                + "\", \"" + m.getSelfRemark() + "\", @p_remarks, @p_UserId, @p_OrgName, @p_OrgDiv),";
	    }




	    if (!sitem1.isEmpty()) {
	        sitem1 = sitem1.substring(0, sitem1.length() - 1); 
	    }

	    s = s + "@p_itemSubQuery1='" + sitem1 + "',";

	    if (!s.isEmpty()) {
	        s = s.substring(0, s.length() - 1); 
	        s = "SET " + s + ";";
	        System.out.println("-----------------" + s);
	    }

	    return s;
	}
	
	
	
	public static String getManagerAppraisalDetails(List<AppraisalKeyFactorRestModel> av) {
	    String s = "";
	    String sitem1 = "";

	    if (av.get(0).getCategoryId() != null && !av.get(0).getCategoryId().isEmpty()) {
	        s = s + "@p_CategoryId='" + av.get(0).getCategoryId() + "',";
	    }
	    if (av.get(0).getFactorCategory() != null && !av.get(0).getFactorCategory().isEmpty()) {
	        s = s + "@p_FactorCategory='" + av.get(0).getFactorCategory() + "',";
	    }
	    
	    if (av.get(0).getFromDate() != null && !av.get(0).getFromDate().isEmpty()) {
	        s = s + "@p_FromDate='" + av.get(0).getFromDate() + "',";
	    }
	    
	    if (av.get(0).getToDate() != null && !av.get(0).getToDate().isEmpty()) {
	        s = s + "@p_ToDate='" + av.get(0).getToDate() + "',";
	    }
	    if (av.get(0).getUserId() != null && !av.get(0).getUserId().isEmpty()) {
	        s = s + "@p_UserId='" + av.get(0).getUserId() + "',";
	    }
	    if (av.get(0).getRemarks() != null && !av.get(0).getRemarks().isEmpty()) {
	        s = s + "@p_remarks='" + av.get(0).getRemarks() + "',";
	    }
	    if (av.get(0).getManagerRemarks()!= null && !av.get(0).getManagerRemarks().isEmpty()) {
	        s = s + "@p_managerRemarks='" + av.get(0).getManagerRemarks() + "',";
	    }

	    if (av.get(0).getOrgName() != null && !av.get(0).getOrgName().isEmpty()) {
	        s = s + "@p_OrgName='" + av.get(0).getOrgName() + "',";
	    }
	    if (av.get(0).getOrgDiv() != null && !av.get(0).getOrgDiv().isEmpty()) {
	        s = s + "@p_OrgDiv='" + av.get(0).getOrgDiv() + "',";
	    }
	    if (av.get(0).getEmpid() != null && !av.get(0).getEmpid().isEmpty()) {
	        s = s + "@p_empid='" + av.get(0).getEmpid() + "',";
	    }
	    if (av.get(0).getAssignid() != null && !av.get(0).getAssignid().isEmpty()) {
	        s = s + "@p_assignId='" + av.get(0).getAssignid() + "',";
	    }
	    if (av.get(0).getManagerRemarks() != null && !av.get(0).getManagerRemarks().isEmpty()) {
	        s = s + "@p_managerRemarks='" + av.get(0).getManagerRemarks() + "',";
	    }

	    
		/*
		 * for (AppraisalKeyFactorRestModel m : av.get(0).getGrid1List()) { sitem1 =
		 * sitem1 + "(@p_CategoryId, \"" + m.getSlno() + "\", \"" + m.getFactors() +
		 * "\", \"" + m.getMaxmark() + "\", \"" + m.getSelfAssesment() + "\", \"" +
		 * m.getAssementMark() + "\", @p_OrgName, @p_OrgDiv),"; }
		 */
	    
	    for (AppraisalKeyFactorRestModel m : av.get(0).getGrid1List()) {
	        sitem1 += "(\"" + m.getAssignid() + "\", \"" + m.getCategoryId() + "\", \"" + m.getEmpid() + "\", \"" + m.getSlno() + "\", \"" 
	                + m.getFactors() + "\", \"" + m.getMaxmark() + "\", \"" + m.getSelfAssesment() + "\", \"" 
	                + m.getSelfRemark() + "\", \"" + m.getAssementMark() + "\", \"" + m.getManagerAssessmentRemark() 
	                + "\", @p_remarks,@p_managerRemarks, @p_UserId, @p_OrgName, @p_OrgDiv),";
	    }




	    if (!sitem1.isEmpty()) {
	        sitem1 = sitem1.substring(0, sitem1.length() - 1); 
	    }

	    s = s + "@p_itemSubQuery1='" + sitem1 + "',";

	    if (!s.isEmpty()) {
	        s = s.substring(0, s.length() - 1); 
	        s = "SET " + s + ";";
	        System.out.println("-----------------" + s);
	    }

	    return s;
	}
}
