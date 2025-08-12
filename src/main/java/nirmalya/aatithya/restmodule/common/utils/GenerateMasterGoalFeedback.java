package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestGoalFeedbackModel;

public class GenerateMasterGoalFeedback {

	public static String generateGoalFeedback(RestGoalFeedbackModel restGoalFeedback) {
		String s = "";
		

		if (restGoalFeedback.getEmpid() != null || restGoalFeedback.getEmpid() != "") {
			s = s + "@p_Name='" + restGoalFeedback.getEmpid() + "',";
		}
		if (restGoalFeedback.getDesignationId() != null || restGoalFeedback.getDesignationId() != "") {
			s = s + "@p_designation='" + restGoalFeedback.getDesignationId() + "',";
		}
		if (restGoalFeedback.getEmployeeId() != null || restGoalFeedback.getEmployeeId() != "") {
			s = s + "@p_empName='" + restGoalFeedback.getEmployeeId() + "',";
		}
		if (restGoalFeedback.getDesignation() != null || restGoalFeedback.getDesignation() != "") {
			s = s + "@p_empDesignation='" + restGoalFeedback.getDesignation() + "',";
		}
		if (restGoalFeedback.getComments() != null || restGoalFeedback.getComments() != "") {
			s = s + "@p_comments='" + restGoalFeedback.getComments() + "',";
		}
		if (restGoalFeedback.getRatings() != null || restGoalFeedback.getRatings() != "") {
			s = s + "@p_ratings='" + restGoalFeedback.getRatings() + "',";
		}
		if (restGoalFeedback.getCreatedBy() != null || restGoalFeedback.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restGoalFeedback.getCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
