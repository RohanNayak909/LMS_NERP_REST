package nirmalya.aatithya.restmodule.common.utils.grc;

import nirmalya.aatithya.restmodule.grc.model.RestRiskControlModel;

public class GenerateRiskControlParam {
	public static String getControlParam( RestRiskControlModel  model) {

		String s = "";
		String riskId = model.getRiskId();
		String	riskName= model.getRiskName();
		String	dueDate = model.getDueDate();
		String  actionTaken = model.getActionTaken(); 
		String	reqNo = model.getReqNo();
		String	remark = model.getRemark();
		String status = model.getStatus();
		String	createdBy = model.getCreatedBy();
		String organization=model.getOrganizationName(); 
		String orgDivision=model.getOrganizationDivision();
		String projectId = model.getProjectId();
		String impactMitigationId = model.getImpactMitigationId();
		String riskIdentificationId = model.getRiskIdentificationId();
		
		s = s + "@p_riskId='" + riskId + "',";
		s = s + "@p_riskName='" + riskName + "',";
		s = s + "@p_dueDate='" + dueDate + "',";
		s = s + "@p_actionTaken='" + actionTaken + "',";
		s = s + "@p_reqNo='" + reqNo + "',";
		s = s + "@p_remark='" + remark + "',";
		s = s + "@p_status='" + status + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		s = s + "@p_project='" + projectId + "',";
		s = s + "@p_impactMitigationId='" + impactMitigationId + "',";
		s = s + "@p_riskIdentificationId='" + riskIdentificationId + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	
}
