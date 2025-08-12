package nirmalya.aatithya.restmodule.common.utils.grc;

import nirmalya.aatithya.restmodule.grc.model.SafetyPlanningRestModel;

public class GenerateSafetyPlanningParam {

	public static String getAddQuotParam(SafetyPlanningRestModel model) {
		String s = "";
//		if (employee.getBudgetId() != null) {
			s = s + "@p_actionId='" + model.getActionId() + "',";
			if (model.getSafetyId() != null && model.getSafetyId() != "") {
				s = s + "@p_safetyId='" + model.getSafetyId() + "',";
			}
			if (model.getProjectId() != null && model.getProjectId() != "") {
				s = s + "@p_projectId='" + model.getProjectId() + "',";
			}
			if (model.getCategoryId() != null && model.getCategoryId() != "") {
				s = s + "@p_categoryId='" + model.getCategoryId() + "',";
			}
			if (model.getCategoryCode() != null && model.getCategoryCode() != "") {
				s = s + "@p_categoryCode='" + model.getCategoryCode() + "',";
			}
			if (model.getOwner() != null && model.getOwner() != "") {
				s = s + "@p_owner='" + model.getOwner() + "',";
			}
			if (model.getActionPlan() != null && model.getActionPlan() != "") {
				s = s + "@p_actionPlan='" + model.getActionPlan() + "',";
			}
			if (model.getDueDate() != null && model.getDueDate() != "") {
				s = s + "@p_dueDate='" + model.getDueDate() + "',";
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
