package nirmalya.aatithya.restmodule.common.utils.grc;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.grc.model.RiskIdentifictionRestModel;

public class GenerateRiskIdentificationParam {
	public static String getAddIdentification(List<RiskIdentifictionRestModel> project) {
		String s = "";
		String listdata = "";
		String identificationId = "";
		String identificationApplyDate = "";
		String desc = "";
		String projectId = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String reqId = "";
		for (RiskIdentifictionRestModel m : project) {
			identificationId = m.getIdentificationId();
			identificationApplyDate = m.getIdentificationApplyDate();
			projectId = m.getProjectId();
			desc = m.getDesc();
			createdBy = m.getCreatedBy();
			organization = m.getOrganizationName();
			orgDivision = m.getOrganizationDivision();

		}
	
       
		s = s + "@p_identificationId='" + identificationId + "',";
		s = s + "@p_identificationApplyDate='" + identificationApplyDate + "',";
		s = s + "@p_project='" + projectId + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		if (!project.get(0).getIdentificationId().contentEquals("1")) {
			for (RiskIdentifictionRestModel m : project) {

				listdata = listdata + "(@p_identificationId,\"" + m.getRiskId() + "\",\"" + m.getRiskName()
						+ "\",\""+ m.getCategory() + "\",\"" + m.getSource() + "\",\"" + m.getRemark() + "\",@p_createdBy, @p_organization,@p_orgDivision),";
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
