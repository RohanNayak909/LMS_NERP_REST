package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.his.model.HISTreatmentRestModel;

public class GenerateOpdTimeSlotParameters {

	public static String getOpdTimeSlotParam(HISPatientRestModel restMasterData) {

		String s = "";

		if (restMasterData.getDocOpdId() != null || restMasterData.getDocOpdId() != "") {
			s = s + "@p_docOpdId='" + restMasterData.getDocOpdId() + "',";
		}
		if (restMasterData.getSlotDate() != null || restMasterData.getSlotDate() != "") {
			s = s + "@p_slotDate='" + restMasterData.getSlotDate() + "',";
		}
		if (restMasterData.getSlotStartTime() != null || restMasterData.getSlotStartTime() != "") {
			s = s + "@p_slotStartTime='" + restMasterData.getSlotStartTime() + "',";
		}
		if (restMasterData.getSlotEndTime() != null || restMasterData.getSlotEndTime() != "") {
			s = s + "@p_slotEndTime='" + restMasterData.getSlotEndTime() + "',";
		}
		if (restMasterData.getSlotIntervals() != null || restMasterData.getSlotIntervals() != "") {
			s = s + "@p_slotIntervals='" + restMasterData.getSlotIntervals() + "',";
		}
		if (restMasterData.getOrganization() != null || restMasterData.getOrganization() != "") {
			s = s + "@p_organization='" + restMasterData.getOrganization() + "',";
		}
		if (restMasterData.getOrgDivision() != null || restMasterData.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restMasterData.getOrgDivision() + "',";
		}
		if (restMasterData.getCreatedBy() != null || restMasterData.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restMasterData.getCreatedBy() + "',";
		}
		if (restMasterData.getDoctor() != null || restMasterData.getDoctor() != "") {
			s = s + "@p_createdBy='" + restMasterData.getDoctor() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getOpdTreatmentParam(HISTreatmentRestModel restMasterData) {

		String s = "";

		if (restMasterData.getId() != null || restMasterData.getId() != "") {
			s = s + "@p_Id='" + restMasterData.getId() + "',";
		}

		if (restMasterData.getTestType() != null || restMasterData.getTestType() != "") {
			s = s + "@p_testType='" + restMasterData.getTestType() + "',";
		}

		if (restMasterData.getTestGroup() != null || restMasterData.getTestGroup() != "") {
			s = s + "@p_testId='" + restMasterData.getTestGroup() + "',";
		}

		if (restMasterData.getMedId() != null || restMasterData.getMedId() != "") {
			s = s + "@p_medId='" + restMasterData.getMedId() + "',";
		}

		if (restMasterData.getMedType() != null || restMasterData.getMedType() != "") {
			s = s + "@p_medType='" + restMasterData.getMedType() + "',";
		}

		if (restMasterData.getMorningCheck() != null || restMasterData.getMorningCheck() != "") {
			s = s + "@p_mornCheck='" + restMasterData.getMorningCheck() + "',";
		}
		if (restMasterData.getNoonCheck() != null || restMasterData.getNoonCheck() != "") {
			s = s + "@p_noonCheck='" + restMasterData.getNoonCheck() + "',";
		}
		if (restMasterData.getNightCheck() != null || restMasterData.getNightCheck() != "") {
			s = s + "@p_nightCheck='" + restMasterData.getNightCheck() + "',";
		}
		if (restMasterData.getDuration() != null || restMasterData.getDuration() != "") {
			s = s + "@p_duration='" + restMasterData.getDuration() + "',";
		}
		if (restMasterData.getRemarksTests() != null || restMasterData.getRemarksTests() != "") {
			s = s + "@p_remarks='" + restMasterData.getRemarksTests() + "',";
		}

		if (restMasterData.getDosage() != null || restMasterData.getDosage() != "") {
			s = s + "@p_dosage='" + restMasterData.getDosage() + "',";
		}
		if (restMasterData.getOrganization() != null || restMasterData.getOrganization() != "") {
			s = s + "@p_org='" + restMasterData.getOrganization() + "',";
		}
		if (restMasterData.getOrgDivision() != null || restMasterData.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restMasterData.getOrgDivision() + "',";
		}
		if (restMasterData.getCreatedBy() != null || restMasterData.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restMasterData.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
