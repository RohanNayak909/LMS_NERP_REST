package nirmalya.aatithya.restmodule.common.utils.trial;

import nirmalya.aatithya.restmodule.trial.model.RestManageLegalDocumentModel;

public class GenerateManageLegalDocumentParameter {

	public static String getManagelegalDocumentParam(RestManageLegalDocumentModel doctemp) {

		String s = "";

		if (doctemp.getLegalId() != null && doctemp.getLegalId() != "") {
			s = s + "@p_legalid='" + doctemp.getLegalId() + "',";
		}
		if (doctemp.getDocumentId() != null && doctemp.getDocumentId() != "") {
			s = s + "@p_document='" + doctemp.getDocumentId() + "',";
		}
		if (doctemp.getVendorId() != null && doctemp.getVendorId() != "") {
			s = s + "@p_vendor='" + doctemp.getVendorId() + "',";
		}
		if (doctemp.getVehicleId() != null && doctemp.getVehicleId() != "") {
			s = s + "@p_vehicle='" + doctemp.getVehicleId() + "',";
		}
		if (doctemp.getNotifyId() != null) {
			s = s + "@p_notify='" + doctemp.getNotifyId() + "',";
		}

		if (doctemp.getLastIssueId() != null && doctemp.getLastIssueId() != "") {
			s = s + "@p_lastIssueDate='" + doctemp.getLastIssueId() + "',";
		}
		if (doctemp.getEmailId() != null && doctemp.getEmailId() != "") {
			s = s + "@p_email='" + doctemp.getEmailId() + "',";
		}
		if (doctemp.getExpireDate() != null && doctemp.getExpireDate() != "") {
			s = s + "@p_expireDate='" + doctemp.getExpireDate() + "',";
		}
		if (doctemp.getSmsId() != null && doctemp.getSmsId() != "") {
			s = s + "@p_sms='" + doctemp.getSmsId() + "',";
		}
		if (doctemp.getChargeId() != null) {
			s = s + "@p_charge='" + doctemp.getChargeId() + "',";
		}
		if (doctemp.getFileUpload() != null && doctemp.getFileUpload() != "") {
			s = s + "@p_docAttach='" + doctemp.getFileUpload() + "',";
		}
		
		if (doctemp.getEmail() != null && doctemp.getEmail() != "") {
			s = s + "@p_email1='" + doctemp.getEmail() + "',";
		}
		if (doctemp.getSms() != null && doctemp.getSms() != "") {
			s = s + "@p_mobile='" + doctemp.getSms() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
