package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestGoalReviewDocumentModel;
import nirmalya.aatithya.restmodule.master.model.RestGoalReviewModel;

public class GenerateMasterGoalReview {

	public static String generateGoalReview(RestGoalReviewModel restGoalReview) {
		String s = "";

		
		if (restGoalReview.getGoalId() != null || restGoalReview.getGoalId() != "") {
			s = s + "@p_getGoalId='" + restGoalReview.getGoalId() + "',";
		}
		if (restGoalReview.getManagersReview() != null || restGoalReview.getManagersReview() != "") {
			s = s + "@p_goalReview='" + restGoalReview.getManagersReview() + "',";
		}
	

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

	public static String addGoalReview(List<RestGoalReviewModel> restGoalReview) {
		String s = "";
		String listdata ="";
		String goalId ="";
		
		if (restGoalReview.get(0).getSummary() != null || restGoalReview.get(0).getSummary() != "") {
			s = s + "@p_getSummary=\"" + restGoalReview.get(0).getSummary() + "\",";
		}
		if (restGoalReview.get(0).getRecommandation() != null || restGoalReview.get(0).getRecommandation() != "") {
			s = s + "@p_getRecommandation=\"" + restGoalReview.get(0).getRecommandation() + "\",";
		}
		
		  for (RestGoalReviewModel m : restGoalReview) { 
		  goalId=m.getGoalId();
		  }
		  for(RestGoalReviewModel m: restGoalReview) { 
		  listdata = listdata+""+m.getGoalId()+ ",";
		  System.out.println(listdata); 
		  }
		 
		  System.out.println(s); 
		listdata = listdata.substring(0, listdata.length() - 1);
		
		s = "SET " + s +"@p_SQL=\"("+listdata+")\";";
		
		return s;
	}

	public static String saveGoalReview(RestGoalReviewModel restGoalReview) {
		String s = "";

		
		if (restGoalReview.getGoalAssignedId() != null || restGoalReview.getGoalAssignedId() != "") {
			s = s + "@p_getGoalAssignedId='" + restGoalReview.getGoalAssignedId() + "',";
		}
		if (restGoalReview.getSessionId() != null || restGoalReview.getSessionId() != "") {
			s = s + "@p_getSessionId='" + restGoalReview.getSessionId() + "',";
		}
		if (restGoalReview.getComment() != null || restGoalReview.getComment() != "") {
			s = s + "@p_getComment='" + restGoalReview.getComment() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

	public static String getMeetingScheduleParam(List<RestGoalReviewModel> goalReviewModel) {
		String s = "";
		String document=  "";
		String meetingNo = "";
		String meetingDate = "";
		String meetingComment = "";
		String startTime = "";
		String endTime = "";
		String meetingSubject = "";
		//String participantDept = "";
		String participants = "";
		String createdBy = "";
		
		for (RestGoalReviewModel m : goalReviewModel) {
			meetingNo = m.getMeetingNo();
			meetingDate =m.getMeetingDate();
			startTime = m.getStartTime();
			endTime = m.getEndTime();
			meetingSubject = m.getMeetingSubject();
			//participantDept = m.getParticipantDept();
			participants = m.getParticipants();
			meetingComment= m.getMeetingComment();
			createdBy=m.getCreatedBy();
			
			
		}
		s = s + "@p_meetingId='" + meetingNo + "',";
		s = s + "@p_meetingDate='" + meetingDate + "',";
		s = s + "@p_startTime='" + startTime + "',";
		s = s + "@p_endTime='" + endTime + "',";
		s = s + "@p_meetingSubject='" + meetingSubject + "',";
		//s = s + "@p_participantDept='" + participantDept + "',";
		s = s + "@p_participants='" + participants + "',";
		s = s + "@p_meetingComment='" + meetingComment + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		
		for (RestGoalReviewDocumentModel a : goalReviewModel.get(0).getDocumentList()) {
			document = document + "(@p_meetingId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",@p_createdBy),";
		}
		if(!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_meetingDocuments='" + document + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("Generate Meeting Params===="+s);
		return s;
	}


}
