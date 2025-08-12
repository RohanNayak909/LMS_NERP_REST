package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;

public class GenerateMasterReferenceHr {

	public static String addJobTypeParam(RestHrMasterModel restHrMasterModel) {

		String s = "";
		if(restHrMasterModel.getOrganization() != null || restHrMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restHrMasterModel.getOrganization() + "',";
		}
		if(restHrMasterModel.getOrgDivision() != null || restHrMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restHrMasterModel.getOrgDivision() + "',";
		}


		if (restHrMasterModel.getJobTypeId() != null || restHrMasterModel.getJobTypeId() != "") {
			s = s + "@p_jobTypeId='" + restHrMasterModel.getJobTypeId() + "',";
		}
		if (restHrMasterModel.getJobTypeName() != null || restHrMasterModel.getJobTypeName() != "") {
			s = s + "@p_jobTypeName='" + restHrMasterModel.getJobTypeName() + "',";
		}
		if (restHrMasterModel.getJobTypeOrder() != null || restHrMasterModel.getJobTypeOrder() != "") {
			s = s + "@p_jobTypeOrder='" + restHrMasterModel.getJobTypeOrder() + "',";
		}
		if (restHrMasterModel.getJobTypeStatus() != null || restHrMasterModel.getJobTypeStatus() != "") {
			s = s + "@p_jobTypeStatus='" + restHrMasterModel.getJobTypeStatus() + "',";
		}
		if (restHrMasterModel.getCreatedBy() != null || restHrMasterModel.getCreatedBy() != "") {
			s = s + "@p_jobTypeCreatedBy='" + restHrMasterModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addWorkHoursParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}


		if (restWorkHourModel.getWorkhourId() != null || restWorkHourModel.getWorkhourId() != "") {
			s = s + "@p_WorkhourId='" + restWorkHourModel.getWorkhourId() + "',";
		}
		/*
		 * if (restWorkHourModel.getWorkhourName() != null ||
		 * restWorkHourModel.getWorkhourName() != "") { s = s + "@p_WorkhourName='" +
		 * restWorkHourModel.getWorkhourName() + "',"; }
		 */

		if (restWorkHourModel.getWorkhourOrder() != null || restWorkHourModel.getWorkhourOrder() != "") {
			s = s + "@p_WorkhourOrder='" + restWorkHourModel.getWorkhourOrder() + "',";
		}
		if (restWorkHourModel.getWorkhourStatus() != null || restWorkHourModel.getWorkhourStatus() != "") {
			s = s + "@p_WorkhourStatus='" + restWorkHourModel.getWorkhourStatus() + "',";
		}
		if (restWorkHourModel.getWorkCreatedBy() != null || restWorkHourModel.getWorkCreatedBy() != "") {
			s = s + "@p_WorkCreatedBy='" + restWorkHourModel.getWorkCreatedBy() + "',";
		}

		if (restWorkHourModel.getWorkFromTime() != null || restWorkHourModel.getWorkFromTime() != "") {
			s = s + "@p_WorkFromTime='" + restWorkHourModel.getWorkFromTime() + "',";
		}
		if (restWorkHourModel.getWorkToTime() != null || restWorkHourModel.getWorkToTime() != "") {
			s = s + "@p_WorkToTime='" + restWorkHourModel.getWorkToTime() + "',";
		}
		if (restWorkHourModel.getWorkFromDate() != null || restWorkHourModel.getWorkFromDate() != "") {
			s = s + "@p_WorkFromDate='" + restWorkHourModel.getWorkFromDate() + "',";
		}
		if (restWorkHourModel.getWorkToDate() != null || restWorkHourModel.getWorkToDate() != "") {
			s = s + "@p_WorkToDate='" + restWorkHourModel.getWorkToDate() + "',";
		}

		if (restWorkHourModel.getWorkUpdatedBy() != null || restWorkHourModel.getWorkUpdatedBy() != "") {
			s = s + "@p_WorkUpdatedBy='" + restWorkHourModel.getWorkUpdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
//shift type
	
	public static String addShiftParam(RestHrMasterModel restShift) {

		String s = "";
		if(restShift.getOrganization() != null || restShift.getOrganization() != "") {
			s = s + "@p_org='" + restShift.getOrganization() + "',";
		}
		if(restShift.getOrgDivision() != null || restShift.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restShift.getOrgDivision() + "',";
		}
		if (restShift.getShiftDepartmentName() != null || restShift.getShiftDepartmentName() != "") {
			s = s + "@p_shiftDepartment='" + restShift.getShiftDepartmentName() + "',";
		}
		if (restShift.getShiftSubDepartmentName() != null || restShift.getShiftSubDepartmentName() != "") {
			s = s + "@p_shiftSubDepartment='" + restShift.getShiftSubDepartmentName() + "',";
		}
		if (restShift.getShiftId() != null || restShift.getShiftId() != "") {
			s = s + "@p_shiftId='" + restShift.getShiftId() + "',";
		}
		if (restShift.getShiftName() != null || restShift.getShiftName() != "") {
			s = s + "@p_shiftName='" + restShift.getShiftName() + "',";
		}
		
		if (restShift.getShiftDesc() != null || restShift.getShiftDesc() != "") {
			s = s + "@p_shiftDesc='" + restShift.getShiftDesc() + "',";
		}
		
		if (restShift.getShiftStatus() != null || restShift.getShiftStatus() != "") {
			s = s + "@p_shiftStatus='" + restShift.getShiftStatus() + "',";
		}
		
		if (restShift.getShiftFromTime() != null || restShift.getShiftFromTime() != "") {
			s = s + "@p_shiftFromTime='" +convertTo24Hour(restShift.getShiftFromTime()) + "',";
		}
		if (restShift.getShiftToTime() != null || restShift.getShiftToTime() != "") {
			s = s + "@p_shiftToTime='" + convertTo24Hour(restShift.getShiftToTime()) + "',";
		}
		if (restShift.getShiftCreatedBy() != null || restShift.getShiftCreatedBy() != "") {
			s = s + "@p_shiftCreatedBy='" + restShift.getShiftCreatedBy() + "',";
		}
	
		if (restShift.getShiftUpdatedBy() != null || restShift.getShiftUpdatedBy() != "") {
			s = s + "@p_shiftUpdatedBy='" + restShift.getShiftUpdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("shift============"+s);
		return s;

	}
	public static String convertTo24Hour(String Time) {
	    DateFormat f1 = new SimpleDateFormat("hh:mm a"); //11:00 pm
	    Date d = null;
	    try {
	        d = f1.parse(Time);
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    DateFormat f2 = new SimpleDateFormat("HH:mm");
	    String x = f2.format(d); // "23:00"
System.out.println("x====="+x);
	    return x;
	}
	//add Education Param
	public static String addEducationParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getEducationId() != null || restWorkHourModel.getEducationId() != "") {
			s = s + "@p_eduId='" + restWorkHourModel.getEducationId() + "',";
		}
		if (restWorkHourModel.getEducationLevelName() != null || restWorkHourModel.getEducationLevelName() != "") {
			s = s + "@p_eduName='" + restWorkHourModel.getEducationLevelName() + "',";
		}
		if (restWorkHourModel.getEducationOrder() != null || restWorkHourModel.getEducationOrder() != "") {
			s = s + "@p_eduOrder='" + restWorkHourModel.getEducationOrder() + "',";
		}
		if (restWorkHourModel.getEducationStatus() != null || restWorkHourModel.getEducationStatus() != "") {
			s = s + "@p_eduStatus='" + restWorkHourModel.getEducationStatus() + "',";
		}
		if (restWorkHourModel.getEducationCreatedBy() != null || restWorkHourModel.getEducationCreatedBy() != "") {
			s = s + "@p_eduCreatedBy='" + restWorkHourModel.getEducationCreatedBy() + "',";
		}
		if (restWorkHourModel.getEducationupdatedBy() != null || restWorkHourModel.getEducationupdatedBy() != "") {
			s = s + "@p_eduUpdatedBy='" + restWorkHourModel.getEducationupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addJobBandParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getJobBandId() != null || restWorkHourModel.getJobBandId() != "") {
			s = s + "@p_jobBandId='" + restWorkHourModel.getJobBandId() + "',";
		}
		if (restWorkHourModel.getJobBandName() != null || restWorkHourModel.getJobBandName() != "") {
			s = s + "@p_jobBandName='" + restWorkHourModel.getJobBandName() + "',";
		}
		if (restWorkHourModel.getJobBandOrder() != null || restWorkHourModel.getJobBandOrder() != "") {
			s = s + "@p_jobBandOrder='" + restWorkHourModel.getJobBandOrder() + "',";
		}
		if (restWorkHourModel.getJobBandStatus() != null || restWorkHourModel.getJobBandStatus() != "") {
			s = s + "@p_jobBandStatus='" + restWorkHourModel.getJobBandStatus() + "',";
		}
		if (restWorkHourModel.getJobBandCreatedBy() != null || restWorkHourModel.getJobBandCreatedBy() != "") {
			s = s + "@p_jobBandCreatedBy='" + restWorkHourModel.getJobBandCreatedBy() + "',";
		}
		if (restWorkHourModel.getJobBandupdatedBy() != null || restWorkHourModel.getJobBandupdatedBy() != "") {
			s = s + "@p_jobBandUpdatedBy='" + restWorkHourModel.getJobBandupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addBenefitsParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getBenifitId() != null || restWorkHourModel.getBenifitId() != "") {
			s = s + "@p_benefitId='" + restWorkHourModel.getBenifitId() + "',";
		}
		if (restWorkHourModel.getBenifitName() != null || restWorkHourModel.getBenifitName() != "") {
			s = s + "@p_benefitName='" + restWorkHourModel.getBenifitName() + "',";
		}
		if (restWorkHourModel.getBenifitOrder() != null || restWorkHourModel.getBenifitOrder() != "") {
			s = s + "@p_benefitOrder='" + restWorkHourModel.getBenifitOrder() + "',";
		}
		if (restWorkHourModel.getBenifitStatus() != null || restWorkHourModel.getBenifitStatus() != "") {
			s = s + "@p_benefitStatus='" + restWorkHourModel.getBenifitStatus() + "',";
		}
		if (restWorkHourModel.getBenifitCreatedBy() != null || restWorkHourModel.getBenifitCreatedBy() != "") {
			s = s + "@p_benefitCreatedBy='" + restWorkHourModel.getBenifitCreatedBy() + "',";
		}
		if (restWorkHourModel.getBenifitupdatedBy() != null || restWorkHourModel.getBenifitupdatedBy() != "") {
			s = s + "@p_benefitUpdatedBy='" + restWorkHourModel.getBenifitupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addAddressParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getAddressId() != null || restWorkHourModel.getAddressId() != "") {
			s = s + "@p_addressId='" + restWorkHourModel.getAddressId() + "',";
		}
		if (restWorkHourModel.getAddressName() != null || restWorkHourModel.getAddressName() != "") {
			s = s + "@p_addressName='" + restWorkHourModel.getAddressName() + "',";
		}
		if (restWorkHourModel.getAddressOrder() != null || restWorkHourModel.getAddressOrder() != "") {
			s = s + "@p_addressOrder='" + restWorkHourModel.getAddressOrder() + "',";
		}
		if (restWorkHourModel.getAddressStatus() != null || restWorkHourModel.getAddressStatus() != "") {
			s = s + "@p_addressStatus='" + restWorkHourModel.getAddressStatus() + "',";
		}
		if (restWorkHourModel.getAddressCreatedBy() != null || restWorkHourModel.getAddressCreatedBy() != "") {
			s = s + "@p_addressCreatedBy='" + restWorkHourModel.getAddressCreatedBy() + "',";
		}

		if (restWorkHourModel.getAddressupdatedBy() != null || restWorkHourModel.getAddressupdatedBy() != "") {
			s = s + "@p_addressUpdatedBy='" + restWorkHourModel.getAddressupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addBloodGroupParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getBloodGroupId() != null || restWorkHourModel.getBloodGroupId() != "") {
			s = s + "@p_bloodGroupId='" + restWorkHourModel.getBloodGroupId() + "',";
		}
		if (restWorkHourModel.getBloodGroupName() != null || restWorkHourModel.getBloodGroupName() != "") {
			s = s + "@p_bloodGroupName='" + restWorkHourModel.getBloodGroupName() + "',";
		}
		if (restWorkHourModel.getBloodGroupOrder() != null || restWorkHourModel.getBloodGroupOrder() != "") {
			s = s + "@p_bloodGroupOrder='" + restWorkHourModel.getBloodGroupOrder() + "',";
		}
		if (restWorkHourModel.getBloodGroupStatus() != null || restWorkHourModel.getBloodGroupStatus() != "") {
			s = s + "@p_bloodGroupStatus='" + restWorkHourModel.getBloodGroupStatus() + "',";
		}
		if (restWorkHourModel.getBloodGroupCreatedBy() != null || restWorkHourModel.getBloodGroupCreatedBy() != "") {
			s = s + "@p_bloodGroupCreatedBy='" + restWorkHourModel.getBloodGroupCreatedBy() + "',";
		}

		if (restWorkHourModel.getBloodGroupsupdatedBy() != null || restWorkHourModel.getBloodGroupsupdatedBy() != "") {
			s = s + "@p_bloodGroupUpdatedBy='" + restWorkHourModel.getBloodGroupsupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addMaritalParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getMaritalId() != null || restWorkHourModel.getMaritalId() != "") {
			s = s + "@p_maritalId='" + restWorkHourModel.getMaritalId() + "',";
		}
		if (restWorkHourModel.getMaritalName() != null || restWorkHourModel.getMaritalName() != "") {
			s = s + "@p_maritalName='" + restWorkHourModel.getMaritalName() + "',";
		}
		if (restWorkHourModel.getMaritalOrder() != null || restWorkHourModel.getMaritalOrder() != "") {
			s = s + "@p_maritalOrder='" + restWorkHourModel.getMaritalOrder() + "',";
		}
		if (restWorkHourModel.getMaritalStatus() != null || restWorkHourModel.getMaritalStatus() != "") {
			s = s + "@p_maritalStatus='" + restWorkHourModel.getMaritalStatus() + "',";
		}
		if (restWorkHourModel.getMaritalCreatedBy() != null || restWorkHourModel.getMaritalCreatedBy() != "") {
			s = s + "@p_maritalCreatedBy='" + restWorkHourModel.getMaritalCreatedBy() + "',";
		}

		if (restWorkHourModel.getMaritalupdatedBy() != null || restWorkHourModel.getMaritalupdatedBy() != "") {
			s = s + "@p_maritalUpdatedBy='" + restWorkHourModel.getMaritalupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addDocumentParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getDocumentId() != null || restWorkHourModel.getDocumentId() != "") {
			s = s + "@p_documentId='" + restWorkHourModel.getDocumentId() + "',";
		}
		if (restWorkHourModel.getDocumentName() != null || restWorkHourModel.getDocumentName() != "") {
			s = s + "@p_documentName='" + restWorkHourModel.getDocumentName() + "',";
		}
		if (restWorkHourModel.getDocumentOrder() != null || restWorkHourModel.getDocumentOrder() != "") {
			s = s + "@p_documentOrder='" + restWorkHourModel.getDocumentOrder() + "',";
		}
		if (restWorkHourModel.getDocumentStatus() != null || restWorkHourModel.getDocumentStatus() != "") {
			s = s + "@p_documentStatus='" + restWorkHourModel.getDocumentStatus() + "',";
		}
		if (restWorkHourModel.getDocumentCreatedBy() != null || restWorkHourModel.getDocumentCreatedBy() != "") {
			s = s + "@p_documentCreatedBy='" + restWorkHourModel.getDocumentCreatedBy() + "',";
		}

		if (restWorkHourModel.getDocumentupdatedBy() != null || restWorkHourModel.getDocumentupdatedBy() != "") {
			s = s + "@p_documentUpdatedBy='" + restWorkHourModel.getDocumentupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addTimeSheetParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getTimeSheetId() != null || restWorkHourModel.getTimeSheetId() != "") {
			s = s + "@p_timeSheetId='" + restWorkHourModel.getTimeSheetId() + "',";
		}
		if (restWorkHourModel.getTimeSheetName() != null || restWorkHourModel.getTimeSheetName() != "") {
			s = s + "@p_timeSheetName='" + restWorkHourModel.getTimeSheetName() + "',";
		}
		if (restWorkHourModel.getTimeSheetOrder() != null || restWorkHourModel.getTimeSheetOrder() != "") {
			s = s + "@p_timeSheetOrder='" + restWorkHourModel.getTimeSheetOrder() + "',";
		}
		if (restWorkHourModel.getTimeSheetStatus() != null || restWorkHourModel.getTimeSheetStatus() != "") {
			s = s + "@p_timeSheetStatus='" + restWorkHourModel.getTimeSheetStatus() + "',";
		}
		if (restWorkHourModel.getTimeSheetCreatedBy() != null || restWorkHourModel.getTimeSheetCreatedBy() != "") {
			s = s + "@p_timeSheetCreatedBy='" + restWorkHourModel.getTimeSheetCreatedBy() + "',";
		}

		if (restWorkHourModel.getTimeSheetupdatedBy() != null || restWorkHourModel.getTimeSheetupdatedBy() != "") {
			s = s + "@p_timeSheetUpdatedBy='" + restWorkHourModel.getTimeSheetupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addEmpStatusParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getEmploymentstatusId() != null || restWorkHourModel.getEmploymentstatusId() != "") {
			s = s + "@p_empstatusId='" + restWorkHourModel.getEmploymentstatusId() + "',";
		}
		if (restWorkHourModel.getEmploymentstatusName() != null || restWorkHourModel.getEmploymentstatusName() != "") {
			s = s + "@p_empstatusName='" + restWorkHourModel.getEmploymentstatusName() + "',";
		}
		if (restWorkHourModel.getEmploymentstatusOrder() != null
				|| restWorkHourModel.getEmploymentstatusOrder() != "") {
			s = s + "@p_empstatusOrder='" + restWorkHourModel.getEmploymentstatusOrder() + "',";
		}
		if (restWorkHourModel.getEmploymentstatusStatus() != null
				|| restWorkHourModel.getEmploymentstatusStatus() != "") {
			s = s + "@p_empstatusStatus='" + restWorkHourModel.getEmploymentstatusStatus() + "',";
		}
		if (restWorkHourModel.getEmploymentstatusCreatedBy() != null
				|| restWorkHourModel.getEmploymentstatusCreatedBy() != "") {
			s = s + "@p_empstatusCreatedBy='" + restWorkHourModel.getEmploymentstatusCreatedBy() + "',";
		}

		if (restWorkHourModel.getEmploymentstatusupdatedBy() != null
				|| restWorkHourModel.getEmploymentstatusupdatedBy() != "") {
			s = s + "@p_empstatusUpdatedBy='" + restWorkHourModel.getEmploymentstatusupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addProjectTypeParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getProjectTypeId() != null || restWorkHourModel.getProjectTypeId() != "") {
			s = s + "@p_projectTypeId='" + restWorkHourModel.getProjectTypeId() + "',";
		}
		if (restWorkHourModel.getProjectTypeName() != null || restWorkHourModel.getProjectTypeName() != "") {
			s = s + "@p_projectTypeName='" + restWorkHourModel.getProjectTypeName() + "',";
		}
		if (restWorkHourModel.getProjectTypeDesc() != null || restWorkHourModel.getProjectTypeDesc() != "") {
			s = s + "@p_projectTypeDesc='" + restWorkHourModel.getProjectTypeDesc() + "',";
		}
		if (restWorkHourModel.getProjectTypeStatus() != null || restWorkHourModel.getProjectTypeStatus() != "") {
			s = s + "@p_projectTypeStatus='" + restWorkHourModel.getProjectTypeStatus() + "',";
		}
		if (restWorkHourModel.getProjectTypeId() == null || restWorkHourModel.getProjectTypeId() == "") {

			if (restWorkHourModel.getProjectTypeCreatedBy() != null
					|| restWorkHourModel.getProjectTypeCreatedBy() != "") {
				s = s + "@p_projectTypeCreatedBy='" + restWorkHourModel.getProjectTypeCreatedBy() + "',";
			}
			if (restWorkHourModel.getProjectTypeupdatedBy() != null
					|| restWorkHourModel.getProjectTypeupdatedBy() != "") {
				s = s + "@p_projectTypeUpdatedBy='" + restWorkHourModel.getProjectTypeupdatedBy() + "',";
			}
		} else {
			if (restWorkHourModel.getProjectTypeupdatedBy() != null
					|| restWorkHourModel.getProjectTypeupdatedBy() != "") {
				s = s + "@p_projectTypeUpdatedBy='" + restWorkHourModel.getProjectTypeupdatedBy() + "',";
			}
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String priorityTypeParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getPriorityId() != null || restWorkHourModel.getPriorityId() != "") {
			s = s + "@p_priorityId='" + restWorkHourModel.getPriorityId() + "',";
		}
		if (restWorkHourModel.getPriorityName() != null || restWorkHourModel.getPriorityName() != "") {
			s = s + "@p_priorityName='" + restWorkHourModel.getPriorityName() + "',";
		}
		if (restWorkHourModel.getPriorityOrder() != null || restWorkHourModel.getPriorityOrder() != "") {
			s = s + "@p_priorityOrder='" + restWorkHourModel.getPriorityOrder() + "',";
		}
		if (restWorkHourModel.getPriorityStatus() != null || restWorkHourModel.getPriorityStatus() != "") {
			s = s + "@p_priorityStatus='" + restWorkHourModel.getPriorityStatus() + "',";
		}
		if (restWorkHourModel.getPriorityCreatedBy() != null || restWorkHourModel.getPriorityCreatedBy() != "") {
			s = s + "@p_priorityCreatedBy='" + restWorkHourModel.getPriorityCreatedBy() + "',";
		}
		if (restWorkHourModel.getPriorityCreatedon() != null || restWorkHourModel.getPriorityCreatedon() != "") {
			s = s + "@p_priorityCreatedon='" + restWorkHourModel.getPriorityCreatedon() + "',";
		}

		if (restWorkHourModel.getPriorityUpdatedBy() != null || restWorkHourModel.getPriorityUpdatedBy() != "") {
			s = s + "@p_priorityUpdatedBy='" + restWorkHourModel.getPriorityUpdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String genderTypeParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getGenderId() != null || restWorkHourModel.getGenderId() != "") {
			s = s + "@p_genderId='" + restWorkHourModel.getGenderId() + "',";
		}
		if (restWorkHourModel.getGenderName() != null || restWorkHourModel.getGenderName() != "") {
			s = s + "@p_genderName='" + restWorkHourModel.getGenderName() + "',";
		}
		if (restWorkHourModel.getGenderDesc() != null || restWorkHourModel.getGenderDesc() != "") {
			s = s + "@p_genderDesc='" + restWorkHourModel.getGenderDesc() + "',";
		}
		if (restWorkHourModel.getGenderStatus() != null || restWorkHourModel.getGenderStatus() != "") {
			s = s + "@p_genderStatus='" + restWorkHourModel.getGenderStatus() + "',";
		}
		if (restWorkHourModel.getGenderCreatedBy() != null || restWorkHourModel.getGenderCreatedBy() != "") {
			s = s + "@p_genderCreatedBy='" + restWorkHourModel.getGenderCreatedBy() + "',";
		}

		if (restWorkHourModel.getGenderupdatedBy() != null || restWorkHourModel.getGenderupdatedBy() != "") {
			s = s + "@p_genderUpdatedBy='" + restWorkHourModel.getGenderupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String empDepRelationTypeParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getDepRelationId() != null || restWorkHourModel.getDepRelationId() != "") {
			s = s + "@p_depRelationId='" + restWorkHourModel.getDepRelationId() + "',";
		}
		if (restWorkHourModel.getDepRelationName() != null || restWorkHourModel.getDepRelationName() != "") {
			s = s + "@p_depRelationName='" + restWorkHourModel.getDepRelationName() + "',";
		}
		if (restWorkHourModel.getDepRelationDesc() != null || restWorkHourModel.getDepRelationDesc() != "") {
			s = s + "@p_depRelationDesc='" + restWorkHourModel.getDepRelationDesc() + "',";
		}
		if (restWorkHourModel.getDepRelationStatus() != null || restWorkHourModel.getDepRelationStatus() != "") {
			s = s + "@p_depRelationStatus='" + restWorkHourModel.getDepRelationStatus() + "',";
		}
		if (restWorkHourModel.getDepRelationCreatedBy() != null || restWorkHourModel.getDepRelationCreatedBy() != "") {
			s = s + "@p_depRelationCreatedBy='" + restWorkHourModel.getDepRelationCreatedBy() + "',";
		}

		if (restWorkHourModel.getDepRelationupdatedBy() != null || restWorkHourModel.getDepRelationupdatedBy() != "") {
			s = s + "@p_depRelationUpdatedBy='" + restWorkHourModel.getDepRelationupdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String dependentTypeParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getDependentId() != null || restWorkHourModel.getDependentId() != "") {
			s = s + "@p_dependentId='" + restWorkHourModel.getDependentId() + "',";
		}
		if (restWorkHourModel.getDependentName() != null || restWorkHourModel.getDependentName() != "") {
			s = s + "@p_dependentName='" + restWorkHourModel.getDependentName() + "',";
		}
		if (restWorkHourModel.getDependentOrder() != null || restWorkHourModel.getDependentOrder() != "") {
			s = s + "@p_dependentOrder='" + restWorkHourModel.getDependentOrder() + "',";
		}
		if (restWorkHourModel.getDependentStatus() != null || restWorkHourModel.getDependentStatus() != "") {
			s = s + "@p_dependentStatus='" + restWorkHourModel.getDependentStatus() + "',";
		}
		if (restWorkHourModel.getDependentCreatedBy() != null || restWorkHourModel.getDependentCreatedBy() != "") {
			s = s + "@p_dependentCreatedBy='" + restWorkHourModel.getDependentCreatedBy() + "',";
		}
		if (restWorkHourModel.getDependentCreatedon() != null || restWorkHourModel.getDependentCreatedon() != "") {
			s = s + "@p_dependentCreatedon='" + restWorkHourModel.getDependentCreatedon() + "',";
		}

		if (restWorkHourModel.getDependentUpdatedBy() != null || restWorkHourModel.getDependentUpdatedBy() != "") {
			s = s + "@p_dependentUpdatedBy='" + restWorkHourModel.getDependentUpdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String insuranceCompanyParam(RestHrMasterModel restWorkHourModel) {

		String s = "";
		
		if(restWorkHourModel.getOrganization() != null || restWorkHourModel.getOrganization() != "") {
			s = s + "@p_org='" + restWorkHourModel.getOrganization() + "',";
		}
		if(restWorkHourModel.getOrgDivision() != null || restWorkHourModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restWorkHourModel.getOrgDivision() + "',";
		}

		if (restWorkHourModel.getInsuranceId() != null || restWorkHourModel.getInsuranceId() != "") {
			s = s + "@p_insuranceId='" + restWorkHourModel.getInsuranceId() + "',";
		}
		if (restWorkHourModel.getInsuranceName() != null || restWorkHourModel.getInsuranceName() != "") {
			s = s + "@p_insuranceName='" + restWorkHourModel.getInsuranceName() + "',";
		}
		if (restWorkHourModel.getInsuranceDesc() != null || restWorkHourModel.getInsuranceDesc() != "") {
			s = s + "@p_insuranceDesc='" + restWorkHourModel.getInsuranceDesc() + "',";
		}
		if (restWorkHourModel.getInsuranceStatus() != null || restWorkHourModel.getInsuranceStatus() != "") {
			s = s + "@p_insuranceStatus='" + restWorkHourModel.getInsuranceStatus() + "',";
		}
		if (restWorkHourModel.getInsuranceCreatedBy() != null || restWorkHourModel.getInsuranceCreatedBy() != "") {
			s = s + "@p_insuranceCreatedBy='" + restWorkHourModel.getInsuranceCreatedBy() + "',";
		}
		if (restWorkHourModel.getInsuranceCreatedOn() != null || restWorkHourModel.getInsuranceCreatedOn() != "") {
			s = s + "@p_insuranceCreatedon='" + restWorkHourModel.getInsuranceCreatedOn() + "',";
		}

		if (restWorkHourModel.getInsuranceUpdatedBy() != null || restWorkHourModel.getInsuranceUpdatedBy() != "") {
			s = s + "@p_insuranceUpdatedBy='" + restWorkHourModel.getInsuranceUpdatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
	public static String addDesignationParam(RestHrMasterModel restHrMasterModel) {

		String s = "";
		if (restHrMasterModel.getDesignationId() != null || restHrMasterModel.getDesignationId() != "") {
			s = s + "@p_designationId='" + restHrMasterModel.getDesignationId() + "',";
		}
		if (restHrMasterModel.getDesignationOrder() != null || restHrMasterModel.getDesignationOrder() != "") {
			s = s + "@p_designationOrder='" + restHrMasterModel.getDesignationOrder() + "',";
		}
		if (restHrMasterModel.getDesignationName() != null || restHrMasterModel.getDesignationName() != "") {
			s = s + "@p_designationName='" + restHrMasterModel.getDesignationName() + "',";
		}
		if (restHrMasterModel.getDesignationStatus() != null || restHrMasterModel.getDesignationStatus() != "") {
			s = s + "@p_designationStatus='" + restHrMasterModel.getDesignationStatus() + "',";
		}
		
		if (restHrMasterModel.getDesignationCreatedBy() != null || restHrMasterModel.getDesignationCreatedBy() != "") {
			s = s + "@p_designationCreatedBy='" + restHrMasterModel.getDesignationCreatedBy() + "',";
		}
		if (restHrMasterModel.getDesignationUpdatedBy() != null || restHrMasterModel.getDesignationUpdatedBy() != "") {
			s = s + "@p_designationUpdatedBy='" + restHrMasterModel.getDesignationUpdatedBy() + "',";
		}
		
		if (restHrMasterModel.getOrganization() != null || restHrMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restHrMasterModel.getOrganization() + "',";
		}
		
		if (restHrMasterModel.getOrgDivision() != null || restHrMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restHrMasterModel.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
	
	public static String addDepartmentParam(RestHrMasterModel restHrMasterModel) {

		String s = "";
		
		if(restHrMasterModel.getOrganizationName() != null || restHrMasterModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + restHrMasterModel.getOrganizationName() + "',";
		}
		if(restHrMasterModel.getOrganizationDivision() != null || restHrMasterModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + restHrMasterModel.getOrganizationDivision() + "',";
		}

		if (restHrMasterModel.getDepartmentId() != null || restHrMasterModel.getDepartmentId() != "") {
			s = s + "@p_departmentId='" + restHrMasterModel.getDepartmentId() + "',";
		}
		if (restHrMasterModel.getDepartmentOrder() != null || restHrMasterModel.getDepartmentOrder() != "") {
			s = s + "@p_departmentOrder='" + restHrMasterModel.getDepartmentOrder() + "',";
		}
		if (restHrMasterModel.getDepartmentName() != null || restHrMasterModel.getDepartmentName() != "") {
			s = s + "@p_departmentName='" + restHrMasterModel.getDepartmentName() + "',";
		}
		if (restHrMasterModel.getDepartmentStatus() != null || restHrMasterModel.getDepartmentStatus() != "") {
			s = s + "@p_departmentStatus='" + restHrMasterModel.getDepartmentStatus() + "',";
		}
		
		if (restHrMasterModel.getDepartmentCreatedBy() != null || restHrMasterModel.getDepartmentCreatedBy() != "") {
			s = s + "@p_departmentCreatedBy='" + restHrMasterModel.getDepartmentCreatedBy() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
	
	
	public static String addSubDepartmentParam(RestHrMasterModel restHrMasterModel) {

		String s = "";
		
		if(restHrMasterModel.getOrganizationNames() != null || restHrMasterModel.getOrganizationNames() != "") {
			s = s + "@p_orgNames='" + restHrMasterModel.getOrganizationNames() + "',";
		}
		if(restHrMasterModel.getOrganizationDivisions() != null || restHrMasterModel.getOrganizationDivisions() != "") {
			s = s + "@p_orgDivs='" + restHrMasterModel.getOrganizationDivisions() + "',";
		}

		if (restHrMasterModel.getSubDepartmentId() != null || restHrMasterModel.getSubDepartmentId() != "") {
			s = s + "@p_subdepartmentId='" + restHrMasterModel.getSubDepartmentId() + "',";
		}
		if (restHrMasterModel.getSubDepartmentName() != null || restHrMasterModel.getSubDepartmentName() != "") {
			s = s + "@p_subDepartmentName='" + restHrMasterModel.getSubDepartmentName() + "',";
		}
		if (restHrMasterModel.getSubdepartmentDept() != null || restHrMasterModel.getSubdepartmentDept() != "") {
			s = s + "@p_subdepartmentDept='" + restHrMasterModel.getSubdepartmentDept() + "',";
		}
		if (restHrMasterModel.getSubDepartmentStatus() != null || restHrMasterModel.getSubDepartmentStatus() != "") {
			s = s + "@p_subdepartmentStatus='" + restHrMasterModel.getSubDepartmentStatus() + "',";
		}
		
		if (restHrMasterModel.getSubDepartmentCreatedBy() != null || restHrMasterModel.getSubDepartmentCreatedBy() != "") {
			s = s + "@p_subdepartmentCreatedBy='" + restHrMasterModel.getSubDepartmentCreatedBy() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
	


}
