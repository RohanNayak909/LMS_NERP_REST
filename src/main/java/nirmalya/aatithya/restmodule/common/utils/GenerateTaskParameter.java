package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;

public class GenerateTaskParameter {

	public static String getAddTasklParam(RestCrmTaskModel form) {
		// TODO Auto-generated method stub
		String s = "";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		if (form.getTaskId() != null && form.getTaskId() != "") {
			s = s + "@p_taskId='" + form.getTaskId() + "',";
		}

		if (form.getLeadId() != null && form.getLeadId() != "") {
			s = s + "@p_leadId='" + form.getLeadId() + "',";
		}

		if (form.getOwnerName() != null && form.getOwnerName() != "") {
			s = s + "@p_ownerName='" + form.getOwnerName() + "',";
		}

		if (form.getTaskOwner() != null && form.getTaskOwner() != "") {
			s = s + "@p_taskOwner='" + form.getTaskOwner() + "',";
		}

		if (form.getTaskLead() != null && form.getTaskLead() != "") {
			s = s + "@p_taskLead='" + form.getTaskLead() + "',";
		}

		if (form.getTaskSubject() != null && form.getTaskSubject() != "") {
			s = s + "@p_taskSubject ='" + form.getTaskSubject() + "',";
		}

		if (form.getDueDate() != null && form.getDueDate() != "") {
			// s = s + "@p_taskDueDate='" + DateFormatter.getStringDate(form.getDueDate()) +
			// "',";

			s = s + "@p_taskDueDate='" + form.getDueDate() + "',";
		}

		if (form.getTaskContactName() != null && form.getTaskContactName() != "") {
			s = s + "@p_taskContactName='" + form.getTaskContactName() + "',";
		}

		if (form.getTaskAccountName() != null && form.getTaskAccountName() != "") {
			s = s + "@p_taskAccountName='" + form.getTaskAccountName() + "',";
		}

		if (form.getTaskStatus() != null && form.getTaskStatus() != "") {
			s = s + "@p_taskStatus='" + form.getTaskStatus() + "',";
		}

		if (form.getTaskPriority() != null && form.getTaskPriority() != "") {
			s = s + "@p_priority='" + form.getTaskPriority() + "',";
		}
		System.out.println("get repeate yes or not----------------" + form.getRepeateYesOrNo());

		if (form.getRepeateYesOrNo() != null && form.getRepeateYesOrNo() != "") {
			s = s + "@p_repeateYesOrNot='" + form.getRepeateYesOrNo() + "',";
		}
		if (form.getReminderYesOrNo() != null && form.getReminderYesOrNo() != "") {
			s = s + "@p_reminderYesOrNo='" + form.getReminderYesOrNo() + "',";
		}

		if (form.getReminderDateid() != null && form.getReminderDateid() != "") {
			// s = s + "@p_taskReminderDate='" +
			// DateFormatter.getStringDate(form.getReminderDateid()) + "',";

			s = s + "@p_taskReminderDate='" + form.getReminderDateid() + "',";
		}

		if (form.getReminderTime() != null && form.getReminderTime() != "") {
			s = s + "@p_reminderTime='" + form.getReminderTime() + "',";
		}

		if (form.getTaskAlertBy() != null && form.getTaskAlertBy() != "") {
			s = s + "@p_taskAlertBy='" + form.getTaskAlertBy() + "',";
		}

		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription().replace("'", "\\'").replace("\"", "\\\\\"") + "',";
		}

		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		if (form.getContactId() != null && form.getContactId() != "") {
			s = s + "@p_contactId='" + form.getContactId() + "',";
		}
		if (form.getAccountId() != null && form.getAccountId() != "") {
			s = s + "@p_accountId='" + form.getAccountId() + "',";
		}

		if (form.getTaskDealId() != null && form.getTaskDealId() != "") {
			s = s + "@p_taskDealId='" + form.getTaskDealId() + "',";
		}
		if (form.getTaskContactId() != null && form.getTaskContactId() != "") {
			s = s + "@p_taskContactId='" + form.getTaskContactId() + "',";
		}
		if (form.getTaskAccountId() != null && form.getTaskAccountId() != "") {
			s = s + "@p_taskAccountId='" + form.getTaskAccountId() + "',";
		}

		if (form.getQuoteId() != null && form.getQuoteId() != "") {
			s = s + "@p_quoteId='" + form.getQuoteId() + "',";
		}

		if (form.getSoId() != null && form.getSoId() != "") {
			s = s + "@p_soId='" + form.getSoId() + "',";
		}

		if (form.getPoId() != null && form.getPoId() != "") {
			s = s + "@p_poId='" + form.getPoId() + "',";
		}

		if (form.getInvoiceId() != null && form.getInvoiceId() != "") {
			s = s + "@p_invoiceId='" + form.getInvoiceId() + "',";
		}
		if (form.getOrganization() != null && form.getOrganization() != "") {
			s = s + "@p_orgName='" + form.getOrganization() + "',";
		}
		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + form.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}

}
