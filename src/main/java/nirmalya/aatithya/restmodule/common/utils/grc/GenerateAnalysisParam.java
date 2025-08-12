package nirmalya.aatithya.restmodule.common.utils.grc;

import java.util.List;

import nirmalya.aatithya.restmodule.grc.model.RestAnalysisModel;
import nirmalya.aatithya.restmodule.grc.model.RiskIdentifictionRestModel;

public class GenerateAnalysisParam {

	public static String getriskParam( RestAnalysisModel  model) {

		String s = "";
 
		String riskId = model.getRiskId();
		String analysisId = model.getAnalysisId();
		String	riskName= model.getRiskName();
		String	category = model.getCategory();
		String probability = model.getProbability(); 
		String	impact = model.getImpact();
	    String	remark = model.getRemark();
		String	createdBy = model.getCreatedBy();
		String organization=model.getOrganizationName(); 
		String orgDivision=model.getOrganizationDivision();
	 
		s = s + "@p_analysisId='" + analysisId + "',";
		s = s + "@p_riskId='" + riskId + "',";
		s = s + "@p_riskName='" + riskName + "',";
		s = s + "@p_category='" + category + "',";
		s = s + "@p_probability='" + probability + "',";
		s = s + "@p_impact='" + impact + "',";
		s = s + "@p_remark='" + remark + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		
 
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	public static String getimpacteParam( RestAnalysisModel  model) {

		String s = "";
		String analysisId = model.getAnalysisId();
		String impactId = model.getImpactAnalysisId();
		String riskId = model.getRiskId();
		String	riskName= model.getRiskName();
		String	riskAnalysis = model.getRiskAnalysis();
		String  impactAnalysis = model.getImpactAnalysis(); 
		String	owner = model.getOwner();
		String	createdBy = model.getCreatedBy();
		String organization=model.getOrganizationName(); 
		String orgDivision=model.getOrganizationDivision();
		String projectId = model.getProjectId();
		
		s = s + "@p_analysisId='" + analysisId + "',";
		s = s + "@p_impactAnalysisId='" + impactId + "',";
		s = s + "@p_riskId='" + riskId + "',";
		s = s + "@p_riskName='" + riskName + "',";
		s = s + "@p_riskAnalysis='" + riskAnalysis + "',";
		s = s + "@p_impactAnalysis='" + impactAnalysis + "',";
		s = s + "@p_owner='" + owner + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		s = s + "@p_project='" + projectId + "',";
 
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
	
	public static String getAddAnalysis(List<RestAnalysisModel> project) {
		String s = "";
		String listdata = "";
		String analysisId = "";
		String analysisDate = "";
		String desc = "";
		String projectId = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String reqId = "";
		for (RestAnalysisModel m : project) {
			analysisId = m.getAnalysisId();
			analysisDate = m.getAnalysisDate();
			projectId = m.getProjectId();
			desc = m.getDesc();
			createdBy = m.getCreatedBy();
			organization = m.getOrganizationName();
			orgDivision = m.getOrganizationDivision();

		}
	
		s = s + "@p_analysisId='" + analysisId + "',";
		s = s + "@p_analysisDate='" + analysisDate + "',";
		s = s + "@p_project='" + projectId + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		if (!project.get(0).getAnalysisId().contentEquals("1")) {
			for (RestAnalysisModel m : project) {

				listdata = listdata + "(@p_analysisId,\"" + m.getRiskId() + "\",\"" + m.getRiskName()
						+ "\",\""+ m.getCategory() + "\",\"" + m.getProbability() + "\",\"" + m.getImpact() + "\", \"" + m.getRemark() + "\",@p_createdBy, @p_organization,@p_orgDivision),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";
	
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		return s;
	}
}
