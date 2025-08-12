package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.projects.model.ProjectMonitoringRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectAgendaModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectAttendeeModel;

public class GenerateProjectMonitoringParameter {

	public static String getprjMonitoringParam(ProjectMonitoringRestModel monitoringControl) {
		String s = "";

		/* FOR PROJECT HEALTH */

		if (monitoringControl.getSlnoId() != null || monitoringControl.getSlnoId() != "") {
			s = s + "@p_SlnoId='" + monitoringControl.getSlnoId() + "',";
		}
		if (monitoringControl.getPhase1() != null || monitoringControl.getPhase1() != "") {
			s = s + "@p_Phase1='" + monitoringControl.getPhase1() + "',";
		}
		if (monitoringControl.getAssignedTo() != null || monitoringControl.getAssignedTo() != "") {
			s = s + "@p_AssignedTo='" + monitoringControl.getAssignedTo() + "',";
		}
		if (monitoringControl.getPlannedStartdate() != null || monitoringControl.getPlannedStartdate() != "") {
			s = s + "@p_PlannedStartdate='" + monitoringControl.getPlannedStartdate() + "',";
		}
		if (monitoringControl.getPlannedEnddate() != null || monitoringControl.getPlannedEnddate() != "") {
			s = s + "@p_PlannedEnddate='" + monitoringControl.getPlannedEnddate() + "',";
		}
		if (monitoringControl.getActualStartdate() != null || monitoringControl.getActualStartdate() != "") {
			s = s + "@p_ActualStartdate='" + monitoringControl.getActualStartdate() + "',";
		}
		if (monitoringControl.getActualEnddate() != null || monitoringControl.getActualEnddate() != "") {
			s = s + "@p_ActualEnddate='" + monitoringControl.getActualEnddate() + "',";
		}
		if (monitoringControl.getSlipageDays1() != null || monitoringControl.getSlipageDays1() != "") {
			s = s + "@p_SlipageDays1='" + monitoringControl.getSlipageDays1() + "',";
		}
		if (monitoringControl.getQualityNeeded() != null || monitoringControl.getQualityNeeded() != "") {
			s = s + "@p_QualityNeeded='" + monitoringControl.getQualityNeeded() + "',";
		}
		if (monitoringControl.getQualityRecieved() != null || monitoringControl.getQualityRecieved() != "") {
			s = s + "@p_QualityRecieved='" + monitoringControl.getQualityRecieved() + "',";
		}
		if (monitoringControl.getVarianceQuantity() != null || monitoringControl.getVarianceQuantity() != "") {
			s = s + "@p_VarianceQuantity='" + monitoringControl.getVarianceQuantity() + "',";
		}
		if (monitoringControl.getHoursPlanned() != null || monitoringControl.getHoursPlanned() != "") {
			s = s + "@p_HoursPlanned='" + monitoringControl.getHoursPlanned() + "',";
		}
		if (monitoringControl.getVarianceHours() != null || monitoringControl.getVarianceHours() != "") {
			s = s + "@p_VarianceHours='" + monitoringControl.getVarianceHours() + "',";
		}
		if (monitoringControl.getCostPlanned() != null || monitoringControl.getCostPlanned() != "") {
			s = s + "@p_CostPlanned='" + monitoringControl.getCostPlanned() + "',";
		}
		if (monitoringControl.getCostActual() != null || monitoringControl.getCostActual() != "") {
			s = s + "@p_CostActual='" + monitoringControl.getCostActual() + "',";
		}
		if (monitoringControl.getVarianceRupees() != null || monitoringControl.getVarianceRupees() != "") {
			s = s + "@p_VarianceRupees='" + monitoringControl.getVarianceRupees() + "',";
		}
		if (monitoringControl.getDateNeeded() != null || monitoringControl.getDateNeeded() != "") {
			s = s + "@p_DateNeeded='" + monitoringControl.getDateNeeded() + "',";
		}
		if (monitoringControl.getDateRecived() != null || monitoringControl.getDateRecived() != "") {
			s = s + "@p_DateRecived='" + monitoringControl.getDateRecived() + "',";
		}
		if (monitoringControl.getSlipageDays2() != null || monitoringControl.getSlipageDays2() != "") {
			s = s + "@p_SlipageDays2='" + monitoringControl.getSlipageDays2() + "',";
		}
		if (monitoringControl.getAttachmentId() != null || monitoringControl.getAttachmentId() != "") {
			s = s + "@p_AttachmentId='" + monitoringControl.getAttachmentId() + "',";
		}
		if (monitoringControl.getNotes() != null || monitoringControl.getNotes() != "") {
			s = s + "@p_Notes='" + monitoringControl.getNotes() + "',";
		}

		/* FOR FORECASTING */

		if (monitoringControl.getSlnoId4() != null || monitoringControl.getSlnoId4() != "") {
			s = s + "@p_SlnoId4='" + monitoringControl.getSlnoId4() + "',";
		}
		if (monitoringControl.getPhase() != null || monitoringControl.getPhase() != "") {
			s = s + "@p_Phase='" + monitoringControl.getPhase() + "',";
		}
		if (monitoringControl.getPlannedcompletationDate() != null
				|| monitoringControl.getPlannedcompletationDate() != "") {
			s = s + "@p_PlannedcompletationDate='" + monitoringControl.getPlannedcompletationDate() + "',";
		}
		if (monitoringControl.getExpectedcompletationDate() != null
				|| monitoringControl.getExpectedcompletationDate() != "") {
			s = s + "@p_ExpectedcompletationDate='" + monitoringControl.getExpectedcompletationDate() + "',";
		}
		if (monitoringControl.getBudgetedCost() != null || monitoringControl.getBudgetedCost() != "") {
			s = s + "@p_BudgetedCost='" + monitoringControl.getBudgetedCost() + "',";
		}
		if (monitoringControl.getProjectedCost() != null || monitoringControl.getProjectedCost() != "") {
			s = s + "@p_ProjectedCost='" + monitoringControl.getProjectedCost() + "',";
		}
		
		/* FOR NOTES */
		
		if (monitoringControl.getNoteId() != null || monitoringControl.getNoteId() != "") {
			s = s + "@p_NoteId='" + monitoringControl.getNoteId() + "',";
		}
		if (monitoringControl.getNotesName() != null || monitoringControl.getNotesName() != "") {
			s = s + "@p_NotesName='" + monitoringControl.getNotesName() + "',";
		}
		if (monitoringControl.getNotesDate() != null || monitoringControl.getNotesDate() != "") {
			s = s + "@p_NotesDate='" + monitoringControl.getNotesDate() + "',";
		}
		if (monitoringControl.getTask() != null || monitoringControl.getTask() != "") {
			s = s + "@p_Task='" + monitoringControl.getTask() + "',";
		}
		if (monitoringControl.getDependancies() != null || monitoringControl.getDependancies() != "") {
			s = s + "@p_Dependancies='" + monitoringControl.getDependancies() + "',";
		}
		if (monitoringControl.getNotesId1() != null || monitoringControl.getNotesId1() != "") {
			s = s + "@p_NotesId1='" + monitoringControl.getNotesId1() + "',";
		}
		
		
		
		if (monitoringControl.getCreatedBy() != null || monitoringControl.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + monitoringControl.getCreatedBy() + "',";
		}
		if (monitoringControl.getCreatedOn() != null || monitoringControl.getCreatedOn() != "") {
			s = s + "@p_CreatedOn='" + monitoringControl.getCreatedOn() + "',";
		}
		if (monitoringControl.getUpdatedBy() != null || monitoringControl.getUpdatedBy() != "") {
			s = s + "@p_UpdatedBy='" + monitoringControl.getUpdatedBy() + "',";
		}
		if (monitoringControl.getUpdatedOn() != null || monitoringControl.getUpdatedOn() != "") {
			s = s + "@p_UpdatedOn='" + monitoringControl.getUpdatedOn() + "',";
		}
		if (monitoringControl.getOrganizationName() != null || monitoringControl.getOrganizationName() != "") {
			s = s + "@p_OrganizationName='" + monitoringControl.getOrganizationName() + "',";
		}
		if (monitoringControl.getOrganizationDivision() != null || monitoringControl.getOrganizationDivision() != "") {
			s = s + "@p_OrganizationDivision='" + monitoringControl.getOrganizationDivision() + "',";
		}

		/* FOR CATCH UP */

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	public static String addEvent(ProjectMonitoringRestModel projectManagementModel) {
		String s = "";
		String eventManagement = "";
		String eventAttendee = "";
		String eventAgenda = "";
		
		eventManagement = "(@p_catchupId,\""+projectManagementModel.getHost()
        + "\",\""+projectManagementModel.getLocation()
		+ "\",\""+projectManagementModel.getDate()
		+ "\",\""+projectManagementModel.getTime()
        + "\",\""+projectManagementModel.getOrganizationName()
        +"\",\""+projectManagementModel.getOrganizationDivision()
        +"\"),";
        List<RestProjectAttendeeModel> attendee=projectManagementModel.getAttendee();
		List<RestProjectAgendaModel> agenda=projectManagementModel.getAgenda();
		for(RestProjectAttendeeModel m: attendee) {
			eventAttendee = eventAttendee+"(@p_catchupId,\""+m.getNameId()
			+ "\",\""+m.getDesignation()
			+ "\",\""+m.getOrganizationName()
	        +"\",\""+m.getOrganizationDivision()
			+ "\"),";
		}
		for(RestProjectAgendaModel m: agenda) {
			eventAgenda = eventAgenda+"(@p_catchupId,\""+m.getSlnoId1()
			+ "\",\""+m.getDescription()
			+ "\",\""+m.getAction()
			+ "\",\""+m.getOwner()
			+ "\",\""+m.getOrganizationName()
	        +"\",\""+m.getOrganizationDivision()
			+ "\"),";
		}
		
		if (eventManagement != "") {
			eventManagement = eventManagement.substring(0, eventManagement.length() - 1);
		}
		if (eventAttendee != "") {
			eventAttendee = eventAttendee.substring(0, eventAttendee.length() - 1);
		}
		if (eventAgenda != "") {
			eventAgenda = eventAgenda.substring(0, eventAgenda.length() - 1);
		}
		s = "SET " + s +"@p_eventManagement='"+eventManagement+"',"+"@p_eventAttendee='"+eventAttendee+"',"+"@p_eventAgenda='"+eventAgenda+"';";
		System.out.println("Generation Paaaa: "+ s);	
		
		return s;
		
	}
	
	
	public static String modifyEvent(ProjectMonitoringRestModel projectManagementModel) {
		String s = "";
		String eventManagement = "";
		String eventAttendee = "";
		String eventAgenda = "";
		
		eventManagement = "\""+projectManagementModel.getCatchupId()
		  + "\",\""+projectManagementModel.getHost()
        + "\",\""+projectManagementModel.getLocation()
		+ "\",\""+projectManagementModel.getDate()
		+ "\",\""+projectManagementModel.getTime()
        + "\",\""+projectManagementModel.getOrganizationName()
        +"\",\""+projectManagementModel.getOrganizationDivision()
        +"\"),";
        List<RestProjectAttendeeModel> attendee=projectManagementModel.getAttendee();
		List<RestProjectAgendaModel> agenda=projectManagementModel.getAgenda();
		for(RestProjectAttendeeModel m: attendee) {
			eventAttendee = eventAttendee+"(@p_catchupId,\""+m.getNameId()
			+ "\",\""+m.getDesignation()
			+ "\",\""+m.getOrganizationName()
	        +"\",\""+m.getOrganizationDivision()
			+ "\"),";
		}
		for(RestProjectAgendaModel m: agenda) {
			eventAgenda = eventAgenda+"(@p_catchupId,\""+m.getSlnoId1()
			+ "\",\""+m.getDescription()
			+ "\",\""+m.getAction()
			+ "\",\""+m.getOwner()
			+ "\",\""+m.getOrganizationName()
	        +"\",\""+m.getOrganizationDivision()
			+ "\"),";
		}
		
		if (eventManagement != "") {
			eventManagement = eventManagement.substring(0, eventManagement.length() - 1);
		}
		if (eventAttendee != "") {
			eventAttendee = eventAttendee.substring(0, eventAttendee.length() - 1);
		}
		if (eventAgenda != "") {
			eventAgenda = eventAgenda.substring(0, eventAgenda.length() - 1);
		}
		s = "SET " + s +"@p_eventManagement='"+eventManagement+"',"+"@p_eventAttendee='"+eventAttendee+"',"+"@p_eventAgenda='"+eventAgenda+"@p_cId='"+projectManagementModel.getCatchupId()+"';";
		System.out.println("Generation Paaaa: "+ s);	
		
		return s;
		
	}

}
