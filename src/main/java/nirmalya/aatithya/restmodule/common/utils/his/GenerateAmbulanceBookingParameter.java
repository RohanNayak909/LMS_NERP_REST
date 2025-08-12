package nirmalya.aatithya.restmodule.common.utils.his;


import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.his.model.RestHisBookingAmbulanceModel;

public class GenerateAmbulanceBookingParameter {

	
	public static String getAddAmbulanceBooking(RestHisBookingAmbulanceModel ambulance) {
		String s = "";
		
		if (ambulance.getBookingId() != null && ambulance.getBookingId() != "") {
			s = s + "@p_bookingId='" + ambulance.getBookingId() + "',";
		}
		if (ambulance.getPatientId() != null && ambulance.getPatientId() != "") {
			s = s + "@p_custId='" + ambulance.getPatientId() + "',";
		}else {
			s = s + "@p_custId=null,";
		}
		if (ambulance.getPatientName() != null && ambulance.getPatientName() != "") {
			s = s + "@p_custName='" + ambulance.getPatientName() + "',";
		}
		if (ambulance.getMobNo() != null && ambulance.getMobNo() != "") {
			s = s + "@p_mobNo='" + ambulance.getMobNo() + "',";
		}
		if (ambulance.getIsdate() != null && ambulance.getIsdate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(ambulance.getIsdate()) + "',";
		}
		if (ambulance.getTime() != null && ambulance.getTime() != "") {
			s = s + "@p_time='" + DateFormatter.getStringTimeNew(ambulance.getTime()) + "',";
		}
		if (ambulance.getCountryid() != null && ambulance.getCountryid() != "") {
			s = s + "@p_country='" + ambulance.getCountryid() + "',";
		}
		if (ambulance.getStateid() != null && ambulance.getStateid() != "") {
			s = s + "@p_state='" + ambulance.getStateid() + "',";
		}
		if (ambulance.getDist() != null && ambulance.getDist() != "") {
			s = s + "@p_district='" + ambulance.getDist() + "',";
		}
		if (ambulance.getCityid() != null && ambulance.getCityid() != "") {
			s = s + "@p_city='" + ambulance.getCityid() + "',";
		}
		if (ambulance.getAdd() != null && ambulance.getAdd() != "") {
			s = s + "@p_address='" + ambulance.getAdd() + "',";
		}
		if (ambulance.getPincode() != null && ambulance.getPincode() != "") {
			s = s + "@p_pincode='" + ambulance.getPincode() + "',";
		}
		if (ambulance.getAge() != null && ambulance.getAge() != "") {
			s = s + "@p_age='" + ambulance.getAge() + "',";
		}
		if (ambulance.getGender() != null && ambulance.getGender() != "") {
			s = s + "@p_gender='" + ambulance.getGender() + "',";
		}
		if (ambulance.getMobNo2() != null && ambulance.getMobNo2() != "") {
			s = s + "@p_altMob='" + ambulance.getMobNo2() + "',";
		}
		if (ambulance.getAmublanceNo() != null && ambulance.getAmublanceNo() != "") {
			s = s + "@p_ambulanceNo='" + ambulance.getAmublanceNo() + "',";
		}
		if (ambulance.getDriverId() != null && ambulance.getDriverId() != "") {
			s = s + "@p_driverId='" + ambulance.getDriverId() + "',";
		}
		if (ambulance.getReasonambulance() != null && ambulance.getReasonambulance() != "") {
			s = s + "@p_reason='" + ambulance.getReasonambulance() + "',";
		}
		if (ambulance.getTypeAmb() != null && ambulance.getTypeAmb() != "") {
			s = s + "@p_ambType='" + ambulance.getTypeAmb() + "',";
		}
		if (ambulance.getReqAmb() != null && ambulance.getReqAmb() != "") {
			s = s + "@p_ambReqFor='" + ambulance.getReqAmb() + "',";
		}
		if (ambulance.getCreatedBy() != null && ambulance.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + ambulance.getCreatedBy() + "',";
		}
		if (ambulance.getOrg() != null && ambulance.getOrg() != "") {
			s = s + "@p_org='" + ambulance.getOrg() + "',";
		}
		if (ambulance.getDiv() != null && ambulance.getDiv() != "") {
			s = s + "@p_orgDiv='" + ambulance.getDiv() + "',";
		}
		if (ambulance.getType() != null && ambulance.getType() != "") {
			s = s + "@p_bookFromType='" + ambulance.getType() + "',";
		}
		if (ambulance.getType() != null && ambulance.getType() != "") {
			s = s + "@p_type='" + ambulance.getType() + "',";
		}
		if (ambulance.getDependantList() != null && ambulance.getDependantList() != "") {
			s = s + "@p_dependantList='" + ambulance.getDependantList() + "',";
		}
		if (ambulance.getDepartment() != null && ambulance.getDepartment() != "") {
			s = s + "@p_department='" + ambulance.getDepartment() + "',";
		} else {
			s = s + "@p_department=null,";
		}
		if (ambulance.getEmail() != null && ambulance.getEmail() != "") {
			s = s + "@p_email='" + ambulance.getEmail() + "',";
		} else {
			s = s + "@p_email=null,";
		}
		if (ambulance.getOccupation() != null && ambulance.getOccupation() != "") {
			s = s + "@p_occupation='" + ambulance.getOccupation() + "',";
		} else {
			s = s + "@p_occupation=null,";
		}
		if (ambulance.getOfficeName() != null && ambulance.getOfficeName() != "") {
			s = s + "@p_officeName='" + ambulance.getOfficeName() + "',";
		} else {
			s = s + "@p_officeName=null,";
		}
		if (ambulance.getOfficeAddress() != null && ambulance.getOfficeAddress() != "") {
			s = s + "@p_officeAddress='" + ambulance.getOfficeAddress() + "',";
		} else {
			s = s + "@p_officeAddress=null,";
		}
		if (ambulance.getIncome() != null && ambulance.getIncome() != "") {
			s = s + "@p_income='" + ambulance.getIncome() + "',";
		} else {
			s = s + "@p_income=null,";
		}
		if (ambulance.getRecommended() != null && ambulance.getRecommended() != "") {
			s = s + "@p_recommended='" + ambulance.getRecommended() + "',";
		} else {
			s = s + "@p_recommended=null,";
		}
		if (ambulance.getDescription() != null && ambulance.getDescription() != "") {
			s = s + "@p_description='" + ambulance.getDescription() + "',";
		} else {
			s = s + "@p_description=null,";
		}
		if (ambulance.getNationality() != null && ambulance.getNationality() != "") {
			s = s + "@p_nationality='" + ambulance.getNationality() + "',";
		} else {
			s = s + "@p_nationality=null,";
		}
		if (ambulance.getInsuranceName() != null && ambulance.getInsuranceName() != "") {
			s = s + "@p_insuranceName='" + ambulance.getInsuranceName() + "',";
		} else {
			s = s + "@p_insuranceName=null,";
		}
		if (ambulance.getDiagnosis() != null && ambulance.getDiagnosis() != "") {
			s = s + "@p_diagnosis='" + ambulance.getDiagnosis() + "',";
		} else {
			s = s + "@p_diagnosis=null,";
		}
		
		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		
		return s;
	}
}
