package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestGoalMastersModel;

public class GenerateGoalMasterParameters {


	
	public static String getGoalMasterParam(RestGoalMastersModel restAdvanceManagementModel) {

		String s = "";


		if (restAdvanceManagementModel.getGoalId() != null ||  restAdvanceManagementModel.getGoalId() != "") {
			s = s + "@p_goalId='" + restAdvanceManagementModel.getGoalId() + "',";
		}
		if (restAdvanceManagementModel.getGoalName() != null ||  restAdvanceManagementModel.getGoalName() != "") {
			s = s + "@p_goalName='" + restAdvanceManagementModel.getGoalName() + "',";
		}
		if (restAdvanceManagementModel.getGoalDesc() != null || restAdvanceManagementModel.getGoalDesc() != "") {
			s = s + "@p_goalDesc='" + restAdvanceManagementModel.getGoalDesc() + "',";
		}

		
		if (restAdvanceManagementModel.getWeightage() != null ||  restAdvanceManagementModel.getWeightage() != "") {
			s = s + "@p_waight='" + restAdvanceManagementModel.getWeightage() + "',";
		}
		if (restAdvanceManagementModel.getCreatedBy() != null ||  restAdvanceManagementModel.getCreatedBy() != "") {
			s = s + "@p_createdby='" + restAdvanceManagementModel.getCreatedBy() + "',";
		}


		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
	
}
