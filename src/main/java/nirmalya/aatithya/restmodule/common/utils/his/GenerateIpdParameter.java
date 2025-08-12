package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

public class GenerateIpdParameter {

	public static String addPatientIPDParam(HISPatientRestModel patientRestModel) {

		String s = "";
	//	String sitem = "";


			if (patientRestModel.getPatientId() != null || patientRestModel.getPatientId() != "") {
				s = s + "@p_patientId='" + patientRestModel.getPatientId() + "',";
			}

			if (patientRestModel.getPatientType() != null || patientRestModel.getPatientType() != "") {
				s = s + "@p_patientType='" + patientRestModel.getPatientType() + "',";
			}

			if (patientRestModel.getfName() != null || patientRestModel.getfName() != "") {
				s = s + "@p_patientFName='" + patientRestModel.getfName() + "',";
			}
			if (patientRestModel.getMiddleName() != null || patientRestModel.getMiddleName() != "") {
				s = s + "@p_patientMName='" + patientRestModel.getMiddleName() + "',";
			}

			if (patientRestModel.getlName() != null || patientRestModel.getlName() != "") {
				s = s + "@p_patientLName='" + patientRestModel.getlName() + "',";
			}

			if (DateFormatter.getStringDate(patientRestModel.getDob()) != null || DateFormatter.getStringDate(patientRestModel.getDob()) != "") {
				s = s + "@p_dateOfBirth='" + DateFormatter.getStringDate(patientRestModel.getDob()) + "',";
			}

			if (patientRestModel.getAge() != null || patientRestModel.getAge() != "") {
				s = s + "@p_age='" + patientRestModel.getAge() + "',";
			}

			if (patientRestModel.getGender() != null || patientRestModel.getGender() != "") {
				s = s + "@p_gender='" + patientRestModel.getGender() + "',";
			}
			

			if (patientRestModel.getNationality() != null || patientRestModel.getNationality() != "") {
				s = s + "@p_nationality='" + patientRestModel.getNationality() + "',";
			}

			if (patientRestModel.getAddress() != null || patientRestModel.getAddress() != "") {
				s = s + "@p_address='" + patientRestModel.getAddress() + "',";
			}

			if (patientRestModel.getCity() != null || patientRestModel.getCity() != "") {
				s = s + "@p_city='" + patientRestModel.getCity() + "',";
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

			if (patientRestModel.getZipCode() != null || patientRestModel.getZipCode() != "") {
				s = s + "@p_zipCode='" + patientRestModel.getZipCode() + "',";
			}

			if (patientRestModel.getMobNo() != null || patientRestModel.getMobNo() != "") {
				s = s + "@p_mobNo='" + patientRestModel.getMobNo() + "',";
			}

			if (patientRestModel.getContactNo() != null || patientRestModel.getContactNo() != "") {
				s = s + "@p_altmobNo='" + patientRestModel.getContactNo() + "',";
			}
			if (patientRestModel.getEmail() != null || patientRestModel.getEmail() != "") {
				s = s + "@p_email='" + patientRestModel.getEmail() + "',";
			}

			if (patientRestModel.getRecommended() != null || patientRestModel.getRecommended() != "") {
				s = s + "@p_recomended='" + patientRestModel.getRecommended() + "',";
			}
			if (patientRestModel.getOccupation() != null || patientRestModel.getOccupation() != "") {
				s = s + "@p_occupation='" + patientRestModel.getOccupation() + "',";
			}

			if (patientRestModel.getOfficeName() != null || patientRestModel.getOfficeName() != "") {
				s = s + "@p_officeName='" + patientRestModel.getOfficeName() + "',";
			}
			if (patientRestModel.getOfficeAddress() != null || patientRestModel.getOfficeAddress() != "") {
				s = s + "@p_officeAddress='" + patientRestModel.getOfficeAddress() + "',";
			}
			if (patientRestModel.getIncome() != null || patientRestModel.getIncome() != "") {
				s = s + "@p_income='" + patientRestModel.getIncome() + "',";
			}

			if (patientRestModel.getPatientStatus() != null || patientRestModel.getPatientStatus() != "") {
				s = s + "@p_patientStatus='" + patientRestModel.getPatientStatus() + "',";
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

			//

			if (patientRestModel.getDepartment() != null || patientRestModel.getDepartment() != "") {
				s = s + "@p_department='" + patientRestModel.getDepartment() + "',";
			}

			if (patientRestModel.getDoctor() != null && patientRestModel.getDoctor() != "") {
				s = s + "@p_doctor='" + patientRestModel.getDoctor() + "',";
			}

			if (patientRestModel.getDateOfAppointment() != null && patientRestModel.getDateOfAppointment() != "") {
				s = s + "@p_dateOfAppoint='" + patientRestModel.getDateOfAppointment() + "',";
			}
			if (patientRestModel.getDescription() != null && patientRestModel.getDescription() != "") {
				s = s + "@p_description='" + patientRestModel.getDescription() + "',";
			}
	     
			
			if (patientRestModel.getDepName() != null && patientRestModel.getDepName() != "") {
				s = s + "@p_dependentName='" + patientRestModel.getDepName() + "',";
			}

			if (patientRestModel.getDepRelation() != null && patientRestModel.getDepRelation() != "") {
				s = s + "@p_dependentRelation='" + patientRestModel.getDepRelation() + "',";
			}
			if (patientRestModel.getDepMobNo() != null && patientRestModel.getDepMobNo() != "") {
				s = s + "@p_depMobile='" + patientRestModel.getDepMobNo() + "',";
			}
			
			if (patientRestModel.getInsuranceName() != null && patientRestModel.getInsuranceName() != "") {
				s = s + "@p_insurancename='" + patientRestModel.getInsuranceName() + "',";
			}
			
			if (patientRestModel.getDignosys() != null && patientRestModel.getDignosys() != "") {
				s = s + "@p_dignosys='" + patientRestModel.getDignosys() + "',";
			}


			
			
			/*
			 * for (HISPatientRestModel m : patientRestModel.getPayList()) { sitem = sitem +
			 * "(@p_patientId,\"" + m.getPayRemarks() + "\",\"" + m.getPaymentMode() +
			 * "\",\"" + m.getChequeNo() + "\",\"" + m.getChequeBankName() + "\",\"" +
			 * m.getChequeBankBranch() + "\",\"" + m.getChequeAccountNumber() + "\",\"" +
			 * m.getBankSelect() + "\",\"" + m.getTransactionNumber() + "\",\"" +
			 * m.getReceiverBankName() + "\",\"" + m.getReceiverBankBranch() + "\",\"" +
			 * m.getReceiverIfscCode() + "\",\"" + m.getReceiverAccountNumber() + "\",\"" +
			 * m.getOnlineUpiID() + "\",\"" + m.getReceiverOnlineUpiID() + "\",\"" +
			 * m.getReceiverUpiTransactionID() + "\",\"" + m.getMethodOfAdj() + "\",\"" +
			 * m.getVendorId() + "\",\"" + m.getPayAmount() + "\",@p_org,@p_orgDiv,\"" +
			 * m.getBankSelectPayment() + "\",\"" + m.getDoctorFees() + "\",\"" +
			 * m.getAmbulanceFees() + "\"),"; }
			 * 
			 * sitem = sitem.substring(0, sitem.length() - 1);
			 * 
			 * s = s + "@p_itemSubQuery='" + sitem + "',";
			 */

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		System.out.println("inParameter-------------" + s);
		return s;

	}
}
