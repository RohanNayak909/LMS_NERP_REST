package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateAddPatientParameter {

	public static String addPatientParam(HISPatientRestModel patientRestModel) {

		String s = "";
		String sitem = "";
		String ditem = "";
		String aitem = "";

		if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
			s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
		}

		
		  if (patientRestModel.getPatientType() != null ||
		  patientRestModel.getPatientType() != "") { s = s + "@p_patientType='" +
		  patientRestModel.getPatientType() + "',"; }
		 

		
		if (patientRestModel.getfName() != null || patientRestModel.getfName() != "") {
			s = s + "@p_patientFName='" + patientRestModel.getfName() + "',";
		}
		if (patientRestModel.getmName() != null || patientRestModel.getmName() != "") {
			s = s + "@p_patientMName='" + patientRestModel.getmName() + "',";
		}

		if (patientRestModel.getlName() != null || patientRestModel.getlName() != "") {
			s = s + "@p_patientLName='" + patientRestModel.getlName() + "',";
		}

		/*
		 * if (patientRestModel.getDateOfBirth() != null ||
		 * patientRestModel.getDateOfBirth() != "") { s = s + "@p_dateOfBirth='" +
		 * patientRestModel.getDateOfBirth() + "',"; }
		 */
		if (DateFormatter.getStringDate(patientRestModel.getDateOfBirth()) != null || DateFormatter.getStringDate(patientRestModel.getDateOfBirth()) != "") {
			s = s + "@p_dateOfBirth='" + DateFormatter.getStringDate(patientRestModel.getDateOfBirth()) + "',";
		}
		if (patientRestModel.getAge() != null || patientRestModel.getAge() != "") {
			s = s + "@p_age='" + patientRestModel.getAge() + "',";
		}
		if (patientRestModel.getMobNo() != null || patientRestModel.getMobNo() != "") {
			s = s + "@p_mobNo='" + patientRestModel.getMobNo() + "',";
		}
		
		if (patientRestModel.getAltMobNo() != null || patientRestModel.getAltMobNo() != "") {
			s = s + "@p_altMob='" + patientRestModel.getAltMobNo() + "',";
		}
		if (patientRestModel.getEmail() != null || patientRestModel.getEmail() != "") {
			s = s + "@p_email='" + patientRestModel.getEmail() + "',";
		}
		if (patientRestModel.getGender() != null || patientRestModel.getGender() != "") {
			s = s + "@p_gender='" + patientRestModel.getGender() + "',";
		}

		
		if (patientRestModel.getNationality() != null || patientRestModel.getNationality() != "") {
			s = s + "@p_nationality='" + patientRestModel.getNationality() + "',";
		}

		if (patientRestModel.getCountry() != null || patientRestModel.getCountry() != "") {
			s = s + "@p_country='" + patientRestModel.getCountry() + "',";
		}
		if (patientRestModel.getStates() != null || patientRestModel.getStates() != "") {
			s = s + "@p_state='" + patientRestModel.getStates() + "',";
		}
		if (patientRestModel.getDist() != null || patientRestModel.getDist() != "") {
			s = s + "@p_dist='" + patientRestModel.getDist() + "',";
		}
		if (patientRestModel.getCity() != null || patientRestModel.getCity() != "") {
			s = s + "@p_city='" + patientRestModel.getCity() + "',";
		}
		if (patientRestModel.getAddress() != null || patientRestModel.getAddress() != "") {
			s = s + "@p_address='" + patientRestModel.getAddress() + "',";
		}

		
		if (patientRestModel.getZipCode() != null || patientRestModel.getZipCode() != "") {
			s = s + "@p_zipCode='" + patientRestModel.getZipCode() + "',";
		}

		if (patientRestModel.getRecommended() != null || patientRestModel.getRecommended() != "") {
			s = s + "@p_recomended='" + patientRestModel.getRecommended() + "',";
		}
		if (patientRestModel.getPatientStatus() != null || patientRestModel.getPatientStatus() != "") {
			s = s + "@p_patientStatus='" + patientRestModel.getPatientStatus() + "',";
		}
		
		//working details
		
		if (patientRestModel.getOccupation() != null || patientRestModel.getOccupation() != "") {
			s = s + "@p_occupation='" + patientRestModel.getOccupation() + "',";
		}

		if (patientRestModel.getOfficeName() != null || patientRestModel.getOfficeName() != "") {
			s = s + "@p_officeName='" + patientRestModel.getOfficeName() + "',";
		}
		if (patientRestModel.getOfficeAddress() != null || patientRestModel.getOfficeAddress() != "") {
			s = s + "@p_officeAddress='" + patientRestModel.getOfficeAddress() + "',";
		}
		/*
		 * if (patientRestModel.getIncome() != null || patientRestModel.getIncome() !=
		 * "") { s = s + "@p_income='" + patientRestModel.getIncome() + "',"; }
		 */
		if (patientRestModel.getIncome() != null && !patientRestModel.getIncome().isEmpty()) {
		    s = s + "@p_income='" + patientRestModel.getIncome() + "',";
		} else {
		    s = s + "@p_income='0.00',";
		}

		//for dependent details
		if (patientRestModel.getDepName() != null || patientRestModel.getDepName() != "") {
			s = s + "@p_dependentName='" + patientRestModel.getDepName() + "',";
		}

		if (patientRestModel.getDepRelation() != null && patientRestModel.getDepRelation() != "") {
			s = s + "@p_dependentRelation='" + patientRestModel.getDepRelation() + "',";
		}

		if (patientRestModel.getDepMobNo() != null && patientRestModel.getDepMobNo() != "") {
			s = s + "@p_depMobile='" + patientRestModel.getDepMobNo() + "',";
		}
		
		//department and doctor details
		if (patientRestModel.getDepartment() != null || patientRestModel.getDepartment() != "") {
			s = s + "@p_department='" + patientRestModel.getDepartment() + "',";
		}

		if (patientRestModel.getDoctor() != null && patientRestModel.getDoctor() != "") {
			s = s + "@p_doctor='" + patientRestModel.getDoctor() + "',";
		}
		if (patientRestModel.getDocFee() != null && patientRestModel.getDocFee() != "") {
			s = s + "@p_docFee='" + patientRestModel.getDocFee() + "',";
		}
		if (patientRestModel.getAvlSlot() != null && patientRestModel.getAvlSlot() != "") {
			s = s + "@p_avlSlot='" + patientRestModel.getAvlSlot() + "',";
		}

		if (patientRestModel.getDateOfAppointment() != null && patientRestModel.getDateOfAppointment() != "") {
			s = s + "@p_dateOfAppoint='" + patientRestModel.getDateOfAppointment() + "',";
		}
		if (patientRestModel.getDescription() != null && patientRestModel.getDescription() != "") {
			s = s + "@p_description='" + patientRestModel.getDescription() + "',";
		}
 
		
		if (patientRestModel.getCreatedBy() != null && patientRestModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + patientRestModel.getCreatedBy() + "',";
		}

		if (patientRestModel.getOrganization() != null && patientRestModel.getOrganization() != "") {
			s = s + "@p_org='" + patientRestModel.getOrganization() + "',";
		}
		if (patientRestModel.getOrgDivision() != null && patientRestModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + patientRestModel.getOrgDivision() + "',";
		}

	
		if (patientRestModel.getBed() != null && patientRestModel.getBed() != "") {
			s = s + "@p_bed='" + patientRestModel.getBed() + "',";
		}
		if (patientRestModel.getWard() != null && patientRestModel.getWard() != "") {
			s = s + "@p_ward='" + patientRestModel.getWard() + "',";
		}
		
		if (patientRestModel.getpImgName() != null && patientRestModel.getpImgName() != "") {
			s = s + "@p_img='" + patientRestModel.getpImgName() + "',";
		}
		/*
		 * for (HISPatientRestModel m : patientRestModel.getPayList()) { sitem = sitem +
		 * "(@p_pat_inv, @p_patientId, \"" + m.getPayRemarks() + "\",\"" +
		 * m.getPaymentMode() + "\",\"" + m.getChequeNo() + "\",\"" +
		 * m.getChequeBankName() + "\",\"" + m.getChequeBankBranch() + "\",\"" +
		 * m.getChequeAccountNumber() + "\",\"" + m.getBankSelect() + "\",\"" +
		 * m.getTransactionNumber() + "\",\"" + m.getReceiverBankName() + "\",\"" +
		 * m.getReceiverBankBranch() + "\",\"" + m.getReceiverIfscCode() + "\",\"" +
		 * m.getReceiverAccountNumber() + "\",\"" + m.getOnlineUpiID() + "\",\"" +
		 * m.getReceiverOnlineUpiID() + "\",\"" + m.getReceiverUpiTransactionID() +
		 * "\",\"" + m.getMethodOfAdj() + "\",\"" + m.getVendorId() + "\",\"" +
		 * m.getPayAmount() + "\",@p_org,@p_orgDiv,\"" + m.getBankSelectPayment() +
		 * "\",\"" + m.getDoctorFees() + "\",\"" + m.getAmbulanceFees() + "\"),"; }
		 */
		
		/*
		 * for (HISPatientRestModel m : patientRestModel.getPayList()) { ditem = ditem
		 * += "(@p_pat_inv, @p_patientId, @p_patientType, \"" + m.getDoctorFees() +
		 * "\"),"; }
		 * 
		 * for (HISPatientRestModel m : patientRestModel.getPayList()) { aitem = aitem
		 * += "(@p_pat_inv, @p_patientId, @p_patientType, \"" + m.getAmbulanceFees() +
		 * "\"),"; }
		 */
		/*
		 * for (HISPatientRestModel m : patientRestModel.getPayList()) { if
		 * (m.getDoctorFees() != null && !m.getDoctorFees().isEmpty()) { ditem=ditem +=
		 * "(@p_pat_inv, @p_patientId, @p_patientType, \"doctorFee\", \"" +
		 * m.getDoctorFees() + "\",@p_org,@p_orgDiv),"; } }
		 * 
		 * for (HISPatientRestModel m : patientRestModel.getPayList()) { if
		 * (m.getAmbulanceFees() != null && !m.getAmbulanceFees().isEmpty()) { aitem=
		 * aitem += "(@p_pat_inv, @p_patientId, @p_patientType, \"ambulanceFee\", \"" +
		 * m.getAmbulanceFees() + "\",@p_org,@p_orgDiv),"; } }
		 */

		// Remove trailing commas if strings are not empty
		if (!sitem.isEmpty()) {
		    sitem = sitem.substring(0, sitem.length() - 1);
		    s += "@p_itemSubQuery='" + sitem + "',";
		}

		if (!ditem.isEmpty()) {
		    ditem = ditem.substring(0, ditem.length() - 1);
		    s += "@p_ditemSubQuery='" + ditem + "',";
		}

		if (!aitem.isEmpty()) {
		    aitem = aitem.substring(0, aitem.length() - 1);
		    s += "@p_aitemSubQuery='" + aitem + "',";
		}

		// Remove trailing comma from `s` if not empty
		if (!s.isEmpty()) {
		    s = s.substring(0, s.length() - 1);
		    s = "SET " + s + ";";
		}

		System.out.println("inParameter-------------" + s);
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static String addPatientModalParam(HISPatientRestModel patientRestModel) {

		String s = "";

		if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
			s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
		}

		if (patientRestModel.getpTypeModal() != null || patientRestModel.getpTypeModal() != "") {
			s = s + "@p_patientType='" + patientRestModel.getpTypeModal() + "',";
		}

		if (patientRestModel.getSal() != null || patientRestModel.getSal() != "") {
			s = s + "@p_salutation='" + patientRestModel.getSal() + "',";
		}

		if (patientRestModel.getFirstName() != null || patientRestModel.getFirstName() != "") {
			s = s + "@p_patientFName='" + patientRestModel.getFirstName() + "',";
		}
		if (patientRestModel.getMiddleName() != null || patientRestModel.getMiddleName() != "") {
			s = s + "@p_patientMName='" + patientRestModel.getMiddleName() + "',";
		}

		if (patientRestModel.getLastName() != null || patientRestModel.getLastName() != "") {
			s = s + "@p_patientLName='" + patientRestModel.getLastName() + "',";
		}

		if (patientRestModel.getDob() != null || patientRestModel.getDob() != "") {
			s = s + "@p_dateOfBirth='" + patientRestModel.getDob() + "',";
		}

		if (patientRestModel.getAgeModal() != null || patientRestModel.getAgeModal() != "") {
			s = s + "@p_age='" + patientRestModel.getAgeModal() + "',";
		}

		if (patientRestModel.getGenderModal() != null || patientRestModel.getGenderModal() != "") {
			s = s + "@p_gender='" + patientRestModel.getGenderModal() + "',";
		}
		if (patientRestModel.getMaritialStatusModal() != null || patientRestModel.getMaritialStatusModal() != "") {
			s = s + "@p_maritalStatus='" + patientRestModel.getMaritialStatusModal() + "',";
		}

		if (patientRestModel.getReligionModal() != null || patientRestModel.getReligionModal() != "") {
			s = s + "@p_religion='" + patientRestModel.getReligionModal() + "',";
		}

		if (patientRestModel.getNationalityModal() != null || patientRestModel.getNationalityModal() != "") {
			s = s + "@p_nationality='" + patientRestModel.getNationalityModal() + "',";
		}

		if (patientRestModel.getAddressModal() != null || patientRestModel.getAddressModal() != "") {
			s = s + "@p_address='" + patientRestModel.getAddressModal() + "',";
		}

		if (patientRestModel.getCityModal() != null || patientRestModel.getCityModal() != "") {
			s = s + "@p_city='" + patientRestModel.getCityModal() + "',";
		}
		if (patientRestModel.getCountryModal() != null || patientRestModel.getCountryModal() != "") {
			s = s + "@p_country='" + patientRestModel.getCountryModal() + "',";
		}

		if (patientRestModel.getStatesModal() != null || patientRestModel.getStatesModal() != "") {
			s = s + "@p_state='" + patientRestModel.getStatesModal() + "',";
		}
		if (patientRestModel.getDistModal() != null || patientRestModel.getDistModal() != "") {
			s = s + "@p_dist='" + patientRestModel.getDistModal() + "',";
		}

		if (patientRestModel.getZipCodeModal() != null || patientRestModel.getZipCodeModal() != "") {
			s = s + "@p_zipCode='" + patientRestModel.getZipCodeModal() + "',";
		}

		if (patientRestModel.getMobNoModal() != null || patientRestModel.getMobNoModal() != "") {
			s = s + "@p_mobNo='" + patientRestModel.getMobNoModal() + "',";
		}

		if (patientRestModel.getContactNoModal() != null || patientRestModel.getContactNoModal() != "") {
			s = s + "@p_contactNo='" + patientRestModel.getContactNoModal() + "',";
		}
		if (patientRestModel.getEmailModal() != null || patientRestModel.getEmailModal() != "") {
			s = s + "@p_email='" + patientRestModel.getEmailModal() + "',";
		}

		if (patientRestModel.getRecommendedModal() != null || patientRestModel.getRecommendedModal() != "") {
			s = s + "@p_recomended='" + patientRestModel.getRecommendedModal() + "',";
		}
		if (patientRestModel.getOccupationModal() != null || patientRestModel.getOccupationModal() != "") {
			s = s + "@p_occupation='" + patientRestModel.getOccupationModal() + "',";
		}

		if (patientRestModel.getOfficeNameModal() != null || patientRestModel.getOfficeNameModal() != "") {
			s = s + "@p_officeName='" + patientRestModel.getOfficeNameModal() + "',";
		}
		if (patientRestModel.getOfficeAddressModal() != null || patientRestModel.getOfficeAddressModal() != "") {
			s = s + "@p_officeAddress='" + patientRestModel.getOfficeAddressModal() + "',";
		}
		if (patientRestModel.getIncomeModal() != null || patientRestModel.getIncomeModal() != "") {
			s = s + "@p_income='" + patientRestModel.getIncomeModal() + "',";
		}

		if (patientRestModel.getpStatus() != null || patientRestModel.getpStatus() != "") {
			s = s + "@p_patientStatus='" + patientRestModel.getpStatus() + "',";
		}

		if (patientRestModel.getCreatedByModal() != null && patientRestModel.getCreatedByModal() != "") {
			s = s + "@p_createdBy='" + patientRestModel.getCreatedByModal() + "',";
		}

		if (patientRestModel.getOrganizationModal() != null && patientRestModel.getOrganizationModal() != "") {
			s = s + "@p_org='" + patientRestModel.getOrganizationModal() + "',";
		}
		if (patientRestModel.getOrgDivisionModal() != null && patientRestModel.getOrgDivisionModal() != "") {
			s = s + "@p_orgDiv='" + patientRestModel.getOrgDivisionModal() + "',";
		}

		//

		if (patientRestModel.getDepartmentModal() != null || patientRestModel.getDepartmentModal() != "") {
			s = s + "@p_department='" + patientRestModel.getDepartmentModal() + "',";
		}

		if (patientRestModel.getDoctorModal() != null && patientRestModel.getDoctorModal() != "") {
			s = s + "@p_doctor='" + patientRestModel.getDoctorModal() + "',";
		}

		if (patientRestModel.getDateOfAppointmentModal() != null && patientRestModel.getDateOfAppointmentModal() != "") {
			s = s + "@p_dateOfAppoint='" + patientRestModel.getDateOfAppointmentModal() + "',";
		}
		if (patientRestModel.getDescriptionModal() != null && patientRestModel.getDescriptionModal() != "") {
			s = s + "@p_description='" + patientRestModel.getDescriptionModal() + "',";
		}
      //for fee and slot
		if (patientRestModel.getDocFeeModal() != null && patientRestModel.getDocFeeModal() != "") {
			s = s + "@p_docFee='" + patientRestModel.getDocFeeModal() + "',";
		}
		if (patientRestModel.getAvlSlotModal() != null && patientRestModel.getAvlSlotModal() != "") {
			s = s + "@p_avlSlot='" + patientRestModel.getAvlSlotModal() + "',";
		}
		
		if (patientRestModel.getBedModal() != null && patientRestModel.getBedModal() != "") {
			s = s + "@p_bed='" + patientRestModel.getBedModal() + "',";
		}
		if (patientRestModel.getWardModal() != null && patientRestModel.getWardModal() != "") {
			s = s + "@p_ward='" + patientRestModel.getWardModal() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("inParameter-------------" + s);
		return s;

	}

}
