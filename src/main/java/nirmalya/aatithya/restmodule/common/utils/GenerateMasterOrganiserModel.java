package nirmalya.aatithya.restmodule.common.utils;


import java.time.YearMonth;

import nirmalya.aatithya.restmodule.master.model.RestMasterOrganisationModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;

public class GenerateMasterOrganiserModel {
	
	public static String addOrg(RestMasterOrganisationModel restMasterOrganisationModel) {

		String s = "";
		
		if (restMasterOrganisationModel.getOrganisationId() != null || restMasterOrganisationModel.getOrganisationId() != "") {
			s = s + "@p_OrganisationId='" + restMasterOrganisationModel.getOrganisationId() + "',";
		}
		if (restMasterOrganisationModel.getOrganisationName() != null || restMasterOrganisationModel.getOrganisationName() != "") {
			s = s + "@p_OrganisationName='" + restMasterOrganisationModel.getOrganisationName() + "',";
		}
		if (restMasterOrganisationModel.getOrganisationNamediv() != null || restMasterOrganisationModel.getOrganisationNamediv() != "") {
			s = s + "@p_Organisationdiv='" + restMasterOrganisationModel.getOrganisationNamediv() + "',";
		}
		if (restMasterOrganisationModel.getAbout() != null || restMasterOrganisationModel.getAbout() != "") {
			s = s + "@p_about='" + restMasterOrganisationModel.getAbout() + "',";
		}
		
		if (restMasterOrganisationModel.getGstno() != null || restMasterOrganisationModel.getGstno() != "") {
			s = s + "@p_gstno='" + restMasterOrganisationModel.getGstno() + "',";
		}

		if (restMasterOrganisationModel.getOrganisationRegNo() != null || restMasterOrganisationModel.getOrganisationRegNo() != "") {
			s = s + "@p_OrganisationRegNo='" + restMasterOrganisationModel.getOrganisationRegNo() + "',";
		}
		
		if (restMasterOrganisationModel.getOrganisationAddress() != null || restMasterOrganisationModel.getOrganisationAddress() != "") {
			s = s + "@p_OrganisationAddress='" + restMasterOrganisationModel.getOrganisationAddress() + "',";
		}
		
		if (restMasterOrganisationModel.getOrganisationType() != null || restMasterOrganisationModel.getOrganisationType() != "") {
			s = s + "@p_OrganisationType='" + restMasterOrganisationModel.getOrganisationType() + "',";
		}
		if (restMasterOrganisationModel.getLocation() != null || restMasterOrganisationModel.getLocation() != "") {
			s = s + "@p_location='" + restMasterOrganisationModel.getLocation() + "',";
		}
		if (restMasterOrganisationModel.getPhoneNo() != null || restMasterOrganisationModel.getPhoneNo() != "") {
			s = s + "@p_phone='" + restMasterOrganisationModel.getPhoneNo() + "',";
		}

		if (restMasterOrganisationModel.getStartDateForAttendance() != null || restMasterOrganisationModel.getStartDateForAttendance() != "") {
			s = s + "@p_startDayForAtten='" + restMasterOrganisationModel.getStartDateForAttendance() + "',";
		}
		
		if (restMasterOrganisationModel.getLogo() != null || restMasterOrganisationModel.getLogo() != "") {
			s = s + "@p_Logo='" + restMasterOrganisationModel.getLogo() + "',";
		}
		
		if (restMasterOrganisationModel.getSignature() != null || restMasterOrganisationModel.getSignature() != "") {
			s = s + "@p_Signature='" + restMasterOrganisationModel.getSignature() + "',";
		}
		
		if (restMasterOrganisationModel.getStamp() != null || restMasterOrganisationModel.getStamp() != "") {
			s = s + "@p_Stamp='" + restMasterOrganisationModel.getStamp() + "',";
		}
		
		if (restMasterOrganisationModel.getPinCode() != null || restMasterOrganisationModel.getPinCode() != "") {
			s = s + "@p_pincode='" + restMasterOrganisationModel.getPinCode() + "',";
		}
		if (restMasterOrganisationModel.getEmail() != null || restMasterOrganisationModel.getEmail() != "") {
			s = s + "@p_email='" + restMasterOrganisationModel.getEmail() + "',";
		}
		if (restMasterOrganisationModel.getCountry() != null || restMasterOrganisationModel.getCountry() != "") {
			s = s + "@p_country='" + restMasterOrganisationModel.getCountry() + "',";
		}
		if (restMasterOrganisationModel.getStates() != null || restMasterOrganisationModel.getStates() != "") {
			s = s + "@p_states='" + restMasterOrganisationModel.getStates() + "',";
		}
		if (restMasterOrganisationModel.getStreet2() != null || restMasterOrganisationModel.getStreet2() != "") {
			s = s + "@p_street1='" + restMasterOrganisationModel.getStreet2() + "',";
		}
		if (restMasterOrganisationModel.getFax() != null || restMasterOrganisationModel.getFax() != "") {
			s = s + "@p_fax='" + restMasterOrganisationModel.getFax() + "',";
		}
		
		String dayStartFrom = restMasterOrganisationModel.getStartDateForAttendance();
		int dayStartFromIntVal = 0;
		
		if(dayStartFrom != null && dayStartFrom != "") {
			dayStartFromIntVal = Integer.parseInt(dayStartFrom);
		}
		
		String litem = "";
		
		for(int i = 1; i <= 12; i++) {
            YearMonth yearMonthObject = YearMonth.of(2000,i);
            int daysInMonth = yearMonthObject.lengthOfMonth();
            int k = dayStartFromIntVal-1;
            for(int j = 1; j <= daysInMonth; j++) {
            	int leapYearStatus = 0;
                k = k + 1;
                if(k > daysInMonth) {
                    k = 1;
                    daysInMonth = daysInMonth - 1;
                }
                if(i == 2 && k == 29) {
                	leapYearStatus = 1;
                }
                litem = litem + "(\"" + j + "\",\"" + i + "\",\"" + k + "\"," + leapYearStatus + ",\""+restMasterOrganisationModel.getOrganisationName()+"\",\""+restMasterOrganisationModel.getOrganisationNamediv()+"\"),";
            }
        }
		
		if (litem != null && litem != "") {
			
			litem = litem.substring(0, litem.length() - 1);
			s = s + "@p_attndcmnthDt='" + litem + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss"+s);
		return s;
	}
	public static String addOrgWorkingDay(RestMasterOrganisationModel restMasterOrganisationModel) {

		String s = "";
		
		if (restMasterOrganisationModel.getWorkingDaySlNo() != null || restMasterOrganisationModel.getWorkingDaySlNo() != "") {
			s = s + "@p_workingDaySlNo='" + restMasterOrganisationModel.getWorkingDaySlNo() + "',";
		}
		if (restMasterOrganisationModel.getWorkingDay() != null || restMasterOrganisationModel.getWorkingDay() != "") {
			s = s + "@p_workingDay='" + restMasterOrganisationModel.getWorkingDay() + "',";
		}
		if (restMasterOrganisationModel.getWorkingDayType() != null || restMasterOrganisationModel.getWorkingDayType() != "") {
			s = s + "@p_workingDayType='" + restMasterOrganisationModel.getWorkingDayType() + "',";
		}
		if (restMasterOrganisationModel.getWorkingHour() != null || restMasterOrganisationModel.getWorkingHour() != "") {
			s = s + "@p_workingHour='" + restMasterOrganisationModel.getWorkingHour() + "',";
		}
		if (restMasterOrganisationModel.getOrganisationName() != null || restMasterOrganisationModel.getOrganisationName() != "") {
			s = s + "@p_orgName='" + restMasterOrganisationModel.getOrganisationName() + "',";
		}
		if (restMasterOrganisationModel.getOrganisationNamediv() != null || restMasterOrganisationModel.getOrganisationNamediv() != "") {
			s = s + "@p_orgDiv='" + restMasterOrganisationModel.getOrganisationNamediv() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss"+s);
		return s;
	}
	public static String taxDeclarationModifyDeclareParam(RestMasterOrganisationModel restMasterOrganisationModel) {
		
		String s = "";
		
		if (restMasterOrganisationModel.getDeclareSlNo() != null || restMasterOrganisationModel.getDeclareSlNo() != "") {
			s = s + "@p_declareSlNo='" + restMasterOrganisationModel.getDeclareSlNo() + "',";
		}
		if (restMasterOrganisationModel.getFinancialYear() != null || restMasterOrganisationModel.getFinancialYear() != "") {
			s = s + "@p_financialYear='" + restMasterOrganisationModel.getFinancialYear() + "',";
		}
		if (restMasterOrganisationModel.getFromDate() != null || restMasterOrganisationModel.getFromDate() != "") {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(restMasterOrganisationModel.getFromDate()) + "',";
		}
		if (restMasterOrganisationModel.getToDate() != null || restMasterOrganisationModel.getToDate() != "") {
			s = s + "@p_toDate='" + DateFormatter.getStringDate(restMasterOrganisationModel.getToDate()) + "',";
		}
		if (restMasterOrganisationModel.getOrganisationName() != null || restMasterOrganisationModel.getOrganisationName() != "") {
			s = s + "@p_orgName='" + restMasterOrganisationModel.getOrganisationName() + "',";
		}
		if (restMasterOrganisationModel.getOrganisationNamediv() != null || restMasterOrganisationModel.getOrganisationNamediv() != "") {
			s = s + "@p_orgDiv='" + restMasterOrganisationModel.getOrganisationNamediv() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss"+s);
		return s;
	}
	
	public static String saveAddressDetails(RestMasterOrganisationModel restMasterOrganisationModel) {

		String s = "";
		
		if(restMasterOrganisationModel.getOrganisationId()!=null && restMasterOrganisationModel.getOrganisationId()!="") {
			s = s + "@p_organisationId='" + restMasterOrganisationModel.getOrganisationId() + "',";
		}
		if(restMasterOrganisationModel.getShippingId()!=null && restMasterOrganisationModel.getShippingId()!="") {
			s = s + "@p_shippingId='" + restMasterOrganisationModel.getShippingId() + "',";
		}
		if(restMasterOrganisationModel.getCountry1()!=null && restMasterOrganisationModel.getCountry1()!="") {
			s = s + "@p_country='" + restMasterOrganisationModel.getCountry1() + "',";
		}
		if(restMasterOrganisationModel.getStates1()!=null && restMasterOrganisationModel.getStates1()!="") {
			s = s + "@p_state='" + restMasterOrganisationModel.getStates1() + "',";
		}
		if(restMasterOrganisationModel.getCity1()!=null && restMasterOrganisationModel.getCity1()!="") {
			s = s + "@p_city='" + restMasterOrganisationModel.getCity1() + "',";
		}
		if(restMasterOrganisationModel.getStreet11()!=null && restMasterOrganisationModel.getStreet11()!="") {
			s = s + "@p_street1='" + restMasterOrganisationModel.getStreet11() + "',";
		}
		if(restMasterOrganisationModel.getStreet21()!=null && restMasterOrganisationModel.getStreet21()!="") {
			s = s + "@p_street2='" + restMasterOrganisationModel.getStreet21() + "',";
		}
		if(restMasterOrganisationModel.getZipCode1()!=null && restMasterOrganisationModel.getZipCode1()!="") {
			s = s + "@p_zipCode='" + restMasterOrganisationModel.getZipCode1() + "',";
		}
		if(restMasterOrganisationModel.getPhone1()!=null && restMasterOrganisationModel.getPhone1()!="") {
			s = s + "@p_phone='" + restMasterOrganisationModel.getPhone1() + "',";
		}
		if(restMasterOrganisationModel.getFax1()!=null && restMasterOrganisationModel.getFax1()!="") {
			s = s + "@p_fax='" + restMasterOrganisationModel.getFax1() + "',";
		}
		if(restMasterOrganisationModel.getDefaultStatus()!=null && restMasterOrganisationModel.getDefaultStatus()!="") {
			s = s + "@p_defaultStatus='" + restMasterOrganisationModel.getDefaultStatus() + "',";
		}
		
		if(restMasterOrganisationModel.getCreatedBy()!=null && restMasterOrganisationModel.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + restMasterOrganisationModel.getCreatedBy() + "',";
		}
		
		
		if(restMasterOrganisationModel.getOrganization()!=null && restMasterOrganisationModel.getOrganization()!="") {
			s = s + "@p_orgName='" + restMasterOrganisationModel.getOrganization() + "',";
		}
		if(restMasterOrganisationModel.getOrgDivision()!=null && restMasterOrganisationModel.getOrgDivision()!="") {
			s = s + "@p_orgDiv='" + restMasterOrganisationModel.getOrgDivision() + "',";
		}
	
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}
}