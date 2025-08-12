package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestSelfAppraisalModel;

public class GenerateMasterSelfReview {

	public static String generateSelfReview(RestSelfAppraisalModel restSelfAppraisal) {
		String s = "";

		if (restSelfAppraisal.getSlNo() != null || restSelfAppraisal.getSlNo() != "") {
			s = s + "@p_slno='" + restSelfAppraisal.getSlNo() + "',";
		}
		if (restSelfAppraisal.getGoalId() != null || restSelfAppraisal.getGoalId() != "") {
			s = s + "@p_getGoalId='" + restSelfAppraisal.getGoalId() + "',";
		}
		if (restSelfAppraisal.getSelfReview() != null || restSelfAppraisal.getSelfReview() != "") {
			s = s + "@p_selfReview='" + restSelfAppraisal.getSelfReview() + "',";
		}
		if (restSelfAppraisal.getExpectedResults() != null || restSelfAppraisal.getExpectedResults() != "") {
			s = s + "@p_eresult='" + restSelfAppraisal.getExpectedResults() + "',";
		}
		if (restSelfAppraisal.getWeightage() != null || restSelfAppraisal.getWeightage() != "") {
			s = s + "@p_wieght='" + restSelfAppraisal.getWeightage() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
