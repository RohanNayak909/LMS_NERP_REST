package nirmalya.aatithya.restmodule.common.utils.grc;

import java.util.List;

import nirmalya.aatithya.restmodule.grc.model.RestMitigationModel;

public class GenerateMitigationParam {
	public static String getriskParam( RestMitigationModel  model) {

		String s = "";
 
		String riskId = model.getRiskId();
		String mitigationId = model.getMitigationId();
		String	riskName= model.getRiskName();
		String	category = model.getCategory();
		String probability = model.getProbability(); 
		String	impact = model.getImpact();
	    String	mitigationPlan = model.getMitigationPlan();
		String	createdBy = model.getCreatedBy();
		String organization=model.getOrganizationName(); 
		String orgDivision=model.getOrganizationDivision();
	 
		s = s + "@p_mitigationId='" + mitigationId + "',";
		s = s + "@p_riskId='" + riskId + "',";
		s = s + "@p_riskName='" + riskName + "',";
		s = s + "@p_category='" + category + "',";
		s = s + "@p_probability='" + probability + "',";
		s = s + "@p_impact='" + impact + "',";
		s = s + "@p_mitigationPlan='" + mitigationPlan + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		
 
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	public static String getimpacteParam( RestMitigationModel  model) {

		String s = "";
		String mitigationId = model.getMitigationId();
		String impactId = model.getImpactMitigationId();
		String riskId = model.getRiskId();
		String	riskName= model.getRiskName();
		String	riskAnalysis = model.getRiskAnalysis();
		String  impactAnalysis = model.getImpactAnalysis(); 
		String	owner = model.getOwner();
		String	impactAction = model.getImpactAction();
		String	createdBy = model.getCreatedBy();
		String organization=model.getOrganizationName(); 
		String orgDivision=model.getOrganizationDivision();
		String projectId = model.getProjectId();
		
		s = s + "@p_mitigationId='" + mitigationId + "',";
		s = s + "@p_impactMitigationId='" + impactId + "',";
		s = s + "@p_riskId='" + riskId + "',";
		s = s + "@p_riskName='" + riskName + "',";
		s = s + "@p_riskAnalysis='" + riskAnalysis + "',";
		s = s + "@p_impactAnalysis='" + impactAnalysis + "',";
		s = s + "@p_owner='" + owner + "',";
		s = s + "@p_impactAction='" + impactAction + "',";
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
	
	public static String getAddMitigation(List<RestMitigationModel> project) {
		String s = "";
		String listdata = "";
		String mitigationId = "";
		String mitigationDate = "";
		String desc = "";
		String projectId = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		for (RestMitigationModel m : project) {
			mitigationId = m.getMitigationId();
			mitigationDate = m.getMitigationDate();
			projectId = m.getProjectId();
			desc = m.getDesc();
			createdBy = m.getCreatedBy();
			organization = m.getOrganizationName();
			orgDivision = m.getOrganizationDivision();

		}
	
		s = s + "@p_mitigationId='" + mitigationId + "',";
		s = s + "@p_mitigationDate='" + mitigationDate + "',";
		s = s + "@p_project='" + projectId + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		if (!project.get(0).getMitigationId().contentEquals("1")) {
			for (RestMitigationModel m : project) {

				listdata = listdata + "(@p_mitigationId,\"" + m.getRiskId() + "\",\"" + m.getRiskName()
						+ "\",\""+ m.getCategory() + "\",\"" + m.getProbability() + "\",\"" + m.getImpact() + "\", \"" + m.getMitigationPlan() + "\",@p_createdBy, @p_organization,@p_orgDivision),";
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
