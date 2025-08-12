package nirmalya.aatithya.restmodule.common.utils.grc;

import nirmalya.aatithya.restmodule.grc.model.SafetyAssesmentRestModel;

public class GenerateSafetyAssesmentParam {

	public static String getAddQuotParam(SafetyAssesmentRestModel model) {
		String s = "";
//		if (employee.getBudgetId() != null) {
			s = s + "@p_safetyId='" + model.getSafetyId() + "',";

			if (model.getAssessedBy() != null && model.getAssessedBy() != "") {
				s = s + "@p_assessedBy='" + model.getAssessedBy() + "',";
			}
			if (model.getAssessDate() != null && model.getAssessDate() != "") {
				s = s + "@p_assessDate='" + model.getAssessDate() + "',";
			}
			if (model.getAssessNotes() != null && model.getAssessNotes() != "") {
				s = s + "@p_assessNotes='" + model.getAssessNotes() + "',";
			}

			if (model.getRequire() != null && model.getRequire() != "") {
				s = s + "@p_require='" + model.getRequire() + "',";
			}

			if (model.getRemarks() != null && model.getRemarks() != "") {
				s = s + "@p_remarks='" + model.getRemarks() + "',";
			}

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
			return s;

	}

}
