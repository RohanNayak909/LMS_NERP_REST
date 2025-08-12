package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.recruitment.model.ReviewHiringProcessRestModel;

public class GenerateReviewProcessingParameter {

	
	public static String scheduleInterviewForCandidate(ReviewHiringProcessRestModel data) {

		String s = "";
		
		String description = data.getDescription().replace("\\", "\\\\") // Escape backslashes
				.replace("'", "''") // Escape single quotes for SQL
				.replace("\"", "\\\"") // Escape double quotes
				.replace("\n", "\\n") // Escape newlines
				.replace(";", "\\;"); // Escape semicolons
		
		String summary = data.getSummary().replace("\\", "\\\\") // Escape backslashes
				.replace("'", "''") // Escape single quotes for SQL
				.replace("\"", "\\\"") // Escape double quotes
				.replace("\n", "\\n") // Escape newlines
				.replace(";", "\\;"); // Escape semicolons
		
		if (data.getCandidateId() != null || data.getCandidateId() != "") {
			s = s + "@p_candidateId='" + data.getCandidateId() + "',";
		}
		if (data.getRequisitionId() != null || data.getRequisitionId() != "") {
			s = s + "@p_requiId='" + data.getRequisitionId() + "',";
		}
		if (data.getInterviewer() != null || data.getInterviewer() != "") {
			s = s + "@p_interviewer='" + data.getInterviewer() + "',";
		}
		if (data.getTitle() != null || data.getTitle() != "") {
			s = s + "@p_title='" + data.getTitle() + "',";
		}
		
		if (data.getFromDate() != null && data.getFromDate() != "") {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(data.getFromDate()) + "',";
		}
		
		if (data.getToDate() != null && data.getToDate() != "") {
			s = s + "@p_toDate='" + DateFormatter.getStringDate(data.getToDate()) + "',";
		}
		
		if (data.getFromTime() != null || data.getFromTime() != "") {
			s = s + "@p_fromTime='" + data.getFromTime() + "',";
		}
		
		if (data.getToTime() != null || data.getToTime() != "") {
			s = s + "@p_toTime='" + data.getToTime() + "',";
		}
		
		if (data.getTotalDuration() != null || data.getTotalDuration() != "") {
			s = s + "@p_duration='" + data.getTotalDuration() + "',";
		}
		
		if (data.getDescription() != null || data.getDescription() != "") {
			s = s + "@p_description='" + description + "',";
		}
		if (data.getLocation() != null || data.getLocation() != "") {
			s = s + "@p_location='" + data.getLocation() + "',";
		}
		if (data.getSummary() != null || data.getSummary() != "") {
			s = s + "@p_summary='" + summary + "',";
		}
		if (data.getCreatedBy() != null || data.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + data.getCreatedBy() + "',";
		}
		if (data.getOrganization() != null || data.getOrganization() != "") {
			s = s + "@p_org='" + data.getOrganization() + "',";
		}
		if (data.getOrgDivision() != null || data.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + data.getOrgDivision() + "',";
		}
		
		if (data.getRoundId() != null || data.getRoundId() != "") {
			s = s + "@p_roundId='" + data.getRoundId() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println(s);
		}

		return s;

	}

}
