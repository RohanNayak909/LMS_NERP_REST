package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;

public class GenerateCallParameter {

	public static String getAddCallParam(RestCrmCallModel form) {
		// TODO Auto-generated method stub
		String s = "";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		if (form.getCallId() != null && form.getCallId() != "") {
			s = s + "@p_callId='" + form.getCallId() + "',";
		}

		if (form.getCallToWhom() != null && form.getCallToWhom() != "") {
			s = s + "@p_callToWhom='" + form.getCallToWhom() + "',";
		}

		if (form.getOwnerName() != null && form.getOwnerName() != "") {
			s = s + "@p_ownerName='" + form.getOwnerName() + "',";
		}

		if (form.getLeadName() != null && form.getLeadName() != "") {
			s = s + "@p_leadName='" + form.getLeadName() + "',";
		}
		if (form.getLeadId() != null && form.getLeadId() != "") {
			s = s + "@p_leadId='" + form.getLeadId() + "',";
		}
		if (form.getContactName() != null && form.getContactName() != "") {
			s = s + "@p_contactName='" + form.getContactName() + "',";
		}
		if (form.getContactId() != null && form.getContactId() != "") {
			s = s + "@p_contactId='" + form.getContactId() + "',";
		}

		if (form.getRelatedType() != null && form.getRelatedType() != "") {
			s = s + "@p_relatedType ='" + form.getRelatedType() + "',";
		}
		if (form.getRelatedId() != null && form.getRelatedId() != "") {
			s = s + "@p_rnameId='" + form.getRelatedId() + "',";
		}
		if (form.getRelatedName() != null && form.getRelatedName() != "") {
			s = s + "@p_relatedName='" + form.getRelatedName() + "',";
		}
		if (form.getCallType() != null && form.getCallType() != "") {
			s = s + "@p_callType='" + form.getCallType() + "',";
		}
		if (form.getCallStatus() != null && form.getCallStatus() != "") {
			s = s + "@p_callStatus='" + form.getCallStatus() + "',";
		}
		if (form.getCallStartDate() != null && form.getCallStartDate() != "") {
			// s = s + "@p_callStartDate='" +
			// DateFormatter.getStringDate(form.getCallStartDate()) + "',";

			s = s + "@p_callStartDate='" + form.getCallStartDate() + "',";
		}
		if (form.getCallStartTime() != null && form.getCallStartTime() != "") {
			s = s + "@p_callStartTime='" + form.getCallStartTime() + "',";
		}
		if (form.getCallEndTime() != null && form.getCallEndTime() != "") {
			s = s + "@p_callEndTime='" + form.getCallEndTime() + "',";
		}
		if (form.getCallOwner() != null && form.getCallOwner() != "") {
			s = s + "@p_callOwner='" + form.getCallOwner() + "',";
		}
		if (form.getCallSubject() != null && form.getCallSubject() != "") {
			s = s + "@p_callSubject='" + form.getCallSubject() + "',";
		}
		if (form.getCallReminder() != null && form.getCallReminder() != "") {
			s = s + "@p_callReminder='" + form.getCallReminder() + "',";
		}
		if (form.getCallPurpose() != null && form.getCallPurpose() != "") {
			s = s + "@p_callPurpose='" + form.getCallPurpose() + "',";
		}
		if (form.getCallAgenda() != null && form.getCallAgenda() != "") {
			s = s + "@p_callAgenda='" + form.getCallAgenda().replace("'", "\\'").replace("\"", "\\\\\"") + "',";
		}

		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (form.getCallLeadId() != null && form.getCallLeadId() != "") {
			s = s + "@p_callLeadId='" + form.getCallLeadId() + "',";
		}

		if (form.getCallContactId() != null && form.getCallContactId() != "") {
			s = s + "@p_callContactId='" + form.getCallContactId() + "',";
		}

		if (form.getCallAccountId() != null && form.getCallAccountId() != "") {
			s = s + "@p_callAccountId='" + form.getCallAccountId() + "',";
		}

		if (form.getCallDealId() != null && form.getCallDealId() != "") {
			s = s + "@p_callDealId='" + form.getCallDealId() + "',";
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
		if (form.getAccountId() != null && form.getAccountId() != "") {
			s = s + "@p_accountId='" + form.getAccountId() + "',";
		}

		if (form.getOrganization() != null && form.getOrganization() != "") {
			s = s + "@org='" + form.getOrganization() + "',";
		}

		if (form.getOrgDivision() != null && form.getOrgDivision() != "") {
			s = s + "@orgDiv='" + form.getOrgDivision() + "',";
		}

		if (form.getParticipantId() != null && form.getParticipantId() != "") {
			s = s + "@p_participantId='" + form.getParticipantId() + "',";
		}
		if (form.getCallRemark() != null && form.getCallRemark() != "") {
			s = s + "@p_callRemark='" + form.getCallRemark().replace("'", "\\'").replace("\"", "\\\\\"") + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}

	public static String getAddStageDealParam(RestDealModel form) {
		// TODO Auto-generated method stub
		String s = "";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		if (form.getDealId() != null && form.getDealId() != "") {
			s = s + "@p_dealId='" + form.getDealId() + "',";
		}
		if (form.getStageId() != null && form.getStageId() != "") {
			s = s + "@p_stageId='" + form.getStageId() + "',";
		}
		if (form.getStageName() != null && form.getStageName() != "") {
			s = s + "@p_stageName='" + form.getStageName() + "',";
		}
		System.out.println("111111111111111111111111111111111111111111111111111111111stage" + form.getPreStageName());
		if (form.getPreStageName() != null && form.getPreStageName() != "") {
			s = s + "@p_preStageName='" + form.getPreStageName() + "',";
		}

		if (form.getDealAmount() != null && form.getDealAmount() != "") {
			s = s + "@p_dealAmount='" + form.getDealAmount() + "',";
		}
		if (form.getDealClosingDate() != null && form.getDealClosingDate() != "") {
			s = s + "@p_dealClosingDate='" + DateFormatter.getStringDate(form.getDealClosingDate()) + "',";
		}
		if (form.getProbability() != null && form.getProbability() != "") {
			s = s + "@p_probablility='" + form.getProbability() + "',";
		}
		if (form.getExpectedRevenue() != null && form.getExpectedRevenue() != "") {
			s = s + "@p_expectedRevenue='" + form.getExpectedRevenue() + "',";
		}
		if (form.getDealOwner() != null && form.getDealOwner() != "") {
			s = s + "@p_dealOwner ='" + form.getDealOwner() + "',";
		}

		if (form.getCreatedBy() != null && form.getDealOwner() != "") {
			s = s + "@p_createdBy ='" + form.getDealOwner() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}

}
