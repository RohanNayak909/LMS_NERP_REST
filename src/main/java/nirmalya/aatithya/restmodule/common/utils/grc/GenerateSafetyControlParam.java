package nirmalya.aatithya.restmodule.common.utils.grc;

import nirmalya.aatithya.restmodule.grc.model.SafetyControlRestModel;

public class GenerateSafetyControlParam {
	public static String getAddQuotParam(SafetyControlRestModel model) {
		String s = "";
//		if (employee.getBudgetId() != null) {
			s = s + "@p_actionId='" + model.getActionId() + "',";
			if (model.getSafetyId() != null && model.getSafetyId() != "") {
				s = s + "@p_safetyId='" + model.getSafetyId() + "',";
			}
			if (model.getActionTaken() != null && model.getActionTaken() != "") {
				s = s + "@p_actionTaken='" + model.getActionTaken() + "',";
			}
			if (model.getIndentNo() != null && model.getIndentNo() != "") {
				s = s + "@p_indentNo='" + model.getIndentNo() + "',";
			}
			if (model.getIndentDate() != null && model.getIndentDate() != "") {
				s = s + "@p_indentDate='" + model.getIndentDate() + "',";
			}
			if (model.getStatus() != null && model.getStatus() != "") {
				s = s + "@p_status='" + model.getStatus() + "',";
			}
			if (model.getRemark() != null && model.getRemark() != "") {
				s = s + "@p_remarks='" + model.getRemark() + "',";
			}
			if (model.getCreatedBy() != null && model.getCreatedBy() != "") {
				s = s + "@p_createdBy='" + model.getCreatedBy() + "',";
			}
			if (model.getOrganizationName() != null && model.getOrganizationName() != "") {
				s = s + "@p_org='" + model.getOrganizationName() + "',";
			}
			if (model.getOrganizationDivision() != null && model.getOrganizationDivision() != "") {
				s = s + "@p_orgDiv='" + model.getOrganizationDivision() + "',";
			}

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
			return s;

	}
}
