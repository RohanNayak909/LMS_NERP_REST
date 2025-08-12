package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.communication.model.CommunicationDocumentRestModel;
import nirmalya.aatithya.restmodule.communication.model.ManageCommunicationRestModel;

public class GenerateCommunicationParam {

	public static String getAddDispatchDetails(ManageCommunicationRestModel data) {
		String s = "";
		String document = "";

		if (data.getRegNo() != null || data.getRegNo() != "") {
			s = s + "@p_regNo='" + data.getRegNo() + "',";
		}

		if (data.getDispatchNo() != null || data.getDispatchNo() != "") {
			s = s + "@p_dispatchNo='" + data.getDispatchNo() + "',";
		}

		if (data.getDispatchDate() != null && data.getDispatchDate() != "") {
			s = s + "@p_dispatchDate='" + DateFormatter.getStringDate(data.getDispatchDate()) + "',";
		}

		if (data.getReceiverName() != null || data.getReceiverName() != "") {
			s = s + "@p_receiverName='" + data.getReceiverName() + "',";
		}

		if (data.getReceiverAddress() != null && !data.getReceiverAddress().isEmpty()) {
			s = s + "@p_receiverAddress=\"" + data.getReceiverAddress() + "\",";
		}

		if (data.getCountry() != null || data.getCountry() != "") {
			s = s + "@p_country='" + data.getCountry() + "',";
		}

		if (data.getState() != null || data.getState() != "") {
			s = s + "@p_state='" + data.getState() + "',";
		}

		if (data.getCity() != null || data.getCity() != "") {
			s = s + "@p_city='" + data.getCity() + "',";
		}

		if (data.getReceiverPin() != null || data.getReceiverPin() != "") {
			s = s + "@p_pin='" + data.getReceiverPin() + "',";
		}

		if (data.getReceiverSubject() != null && !data.getReceiverSubject().isEmpty()) {
			s = s + "@p_receiverSubject=\"" + data.getReceiverSubject() + "\",";
		}

		if (data.getModeOfDelivery() != null || data.getModeOfDelivery() != "") {
			s = s + "@p_modeOfDel='" + data.getModeOfDelivery() + "',";
		}

		if (data.getReceiptNo() != null || data.getReceiptNo() != "") {
			s = s + "@p_receiptNo='" + data.getReceiptNo() + "',";
		}

		if (data.getReceiptDate() != null && data.getReceiptDate() != "") {
			s = s + "@p_receiptDate='" + DateFormatter.getStringDate(data.getReceiptDate()) + "',";
		}

		if (data.getReceiptAmount() != null || data.getReceiptAmount() != "") {
			s = s + "@p_receiptAmount='" + data.getReceiptAmount() + "',";
		}

		if (data.getReceiverRemarks() != null && !data.getReceiverRemarks().isEmpty()) {
			s = s + "@p_remarks=\"" + data.getReceiverRemarks() + "\",";
		} else {
			s = s + "@p_remarks=\"\",";
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

		String p_documentSubQuery = "";

		// Check if the DocumentURL is not null and not empty
		/*
		 * if (data.getDocumentList().get(0).getDocumentURL() != null &&
		 * !data.getDocumentList().get(0).getDocumentURL().isEmpty()) { for
		 * (CommunicationDocumentRestModel a : data.getDocumentList()) { document +=
		 * "(@p_regNo,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",\"" +
		 * a.getDocumentURL() + "\",@p_createdBy,@p_org,@p_orgDiv),"; } } else {
		 * p_documentSubQuery = ""; }
		 */
		for (CommunicationDocumentRestModel a : data.getDocumentList()) {

			if (a.getDocumentURL() != null && !a.getDocumentURL().isEmpty() && !a.getDocumentURL().equals("")) {
				document += "(@p_regNo,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",\""
						+ a.getDocumentURL() + "\",@p_createdBy,@p_org,@p_orgDiv),";
			}
		}


		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			p_documentSubQuery = document;
		}

		s += "@p_documentSubQuery='" + p_documentSubQuery + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("Generate Param Dispatch>>" + s);
		return s;
	}

	public static String addReceiveDetailsDao(ManageCommunicationRestModel data) {
		String s = "";
		String document = "";

		if (data.getRegNo() != null || data.getRegNo() != "") {
			s = s + "@p_regNo='" + data.getRegNo() + "',";
		}

		if (data.getDate() != null && data.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(data.getDate()) + "',";
		}
		
		if (data.getDueDate() != null && data.getDueDate() != "") {
			s = s + "@p_dueDate='" + DateFormatter.getStringDate(data.getDueDate()) + "',";
		}

		if (data.getSenderName() != null || data.getSenderName() != "") {
			s = s + "@p_senderName='" + data.getSenderName() + "',";
		}

		if (data.getSenderAddress() != null && !data.getSenderAddress().isEmpty()) {
			s = s + "@p_senderAddress=\"" + data.getSenderAddress() + "\",";
		}

		if (data.getCountry() != null || data.getCountry() != "") {
			s = s + "@p_country='" + data.getCountry() + "',";
		}

		if (data.getState() != null || data.getState() != "") {
			s = s + "@p_state='" + data.getState() + "',";
		}

		if (data.getCity() != null || data.getCity() != "") {
			s = s + "@p_city='" + data.getCity() + "',";
		}

		if (data.getSenderPin() != null || data.getSenderPin() != "") {
			s = s + "@p_pin='" + data.getSenderPin() + "',";
		}

		if (data.getSenderSubject() != null && !data.getSenderSubject().isEmpty()) {
			s = s + "@p_senderSubjects=\"" + data.getSenderSubject() + "\",";
		}

		if (data.getSenderRefNo() != null || data.getSenderRefNo() != "") {
			s = s + "@p_senderRefNo='" + data.getSenderRefNo() + "',";
		}

		if (data.getDateRef() != null && data.getDateRef() != "") {
			s = s + "@p_refDate='" + DateFormatter.getStringDate(data.getDateRef()) + "',";
		}

		if (data.getDepartmentId() != null || data.getDepartmentId() != "") {
			s = s + "@p_department='" + data.getDepartmentId() + "',";
		}

		if (data.getSenderSection() != null && data.getSenderSection() != "") {
			s = s + "@p_senderSection='" + data.getSenderSection() + "',";
		}

		if (data.getSenderRemarks() != null && !data.getSenderRemarks().isEmpty()) {
			s = s + "@p_remarks=\"" + data.getSenderRemarks() + "\",";
		} else {
			s = s + "@p_remarks=\"\",";
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

		String p_documentSubQuery = "";

		System.out.println("data.getDocumentList()>>" + data.getDocumentList());
		/*
		 * if (data.getDocumentList().get(0).getDocumentURL() != null &&
		 * !data.getDocumentList().get(0).getDocumentURL().isEmpty() &&
		 * !data.getDocumentList().get(0).getDocumentURL().equals("")) {
		 */
		for (CommunicationDocumentRestModel a : data.getDocumentList()) {

			if (a.getDocumentURL() != null && !a.getDocumentURL().isEmpty() && !a.getDocumentURL().equals("")) {
				document += "(@p_regNo,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",\""
						+ a.getDocumentURL() + "\",@p_createdBy,@p_org,@p_orgDiv),";
			}
		}

		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			p_documentSubQuery = document;
		}

		s += "@p_documentSubQuery='" + p_documentSubQuery + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Param Rcv>>" + s);
		return s;
	}

}
