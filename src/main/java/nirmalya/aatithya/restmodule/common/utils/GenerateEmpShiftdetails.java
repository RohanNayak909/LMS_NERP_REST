package nirmalya.aatithya.restmodule.common.utils;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestEmployeeGroupSchedulingModel;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeShiftSchedulingModel;


public class GenerateEmpShiftdetails {

	public static String getAddRevisedShiftParam(List<RestEmployeeShiftSchedulingModel> param) {

		String s = "";
		String sitem = "";


		for (RestEmployeeShiftSchedulingModel m : param) {
		    // Initial string construction

			System.out.println("m.getRevisedToDate()=="+m.getRevisedToDate()); 
			
		    if(m.getRevisedToDate() == null) {
		    	sitem = sitem + "(\"" + m.getEmpId() + "\",\"" + DateFormatter.getStringDate(m.getRevisedDate()) + "\",\"" + m.getCurrentShift() 
		         + "\",\"" + m.getRevisedShift() + "\",\"" + m.getShiftRemarks() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() 
		         + "\",\"" + m.getCreatedBy() +  "\",\"" + m.getCurrentGroup() + "\",null),";
		    
		    }else {
		    	sitem = sitem + "(\"" + m.getEmpId() + "\",\"" + DateFormatter.getStringDate(m.getRevisedDate()) + "\",\"" + m.getCurrentShift() 
		         + "\",\"" + m.getRevisedShift() + "\",\"" + m.getShiftRemarks() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() 
		         + "\",\"" + m.getCreatedBy() +  "\",\"" + m.getCurrentGroup() + "\",\"" + DateFormatter.getStringDate(m.getRevisedToDate()) + "\"),";
		    
		    // Check if RevisedToDate is not null/empty or not equal to RevisedDate
		    if (m.getRevisedToDate() != null && !m.getRevisedToDate().equals(m.getRevisedDate())) {
		        // Add one day to RevisedDate
		    	String nextRevisedDate=getNextDate(m.getRevisedToDate());
		        sitem = sitem + "(\"" + m.getEmpId() + "\",\"" + DateFormatter.getStringDate(nextRevisedDate) + "\",\"" + m.getCurrentShift() 
		             + "\",\"" + m.getCurrentShift() + "\",\"" + m.getShiftRemarks() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() 
		             + "\",\"" + m.getCreatedBy() +  "\",\"" + m.getCurrentGroup() + "\",null),";
		    }
		    }
		}
		
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@P_shiftDetails='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	public static String getNextDate(String date) {
	    // Define the date format as dd-MM-yyyy
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	    // Parse the input date string to a LocalDate
	    LocalDate localDate = LocalDate.parse(date, formatter);

	    // Add one day to the parsed date
	    LocalDate nextDate = localDate.plusDays(1);

	    // Convert the next date back to a string and return it
	    return nextDate.format(formatter);
	}
	private static LocalDate pareseInt(String revisedDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getAddRevisedGroupParam(List<RestEmployeeGroupSchedulingModel> model) {
		String s = "";
		String sitem = "";
		String shift = "";


		for (RestEmployeeGroupSchedulingModel m : model) {

			sitem = sitem + "(\"" + m.getEmpId() + "\",\"" +DateFormatter.getStringDate(m.getRevisedDate()) + "\",\"" + m.getCurrentGroup() 
			 + "\",\"" + m.getRevisedGroup() + "\",\"" + m.getGroupRemarks().replace("'", "\\'") + "\",\"" + m.getOrganization()+ "\",\"" + m.getOrgDivision() + "\",\"" + m.getCreatedBy() +  "\"),";
			
			shift = shift + "(\"" + m.getEmpId() + "\",\"" +DateFormatter.getStringDate(m.getRevisedDate()) + "\",@p_shift,@p_shift,\"" 
			+ m.getOrganization()+ "\",\"" + m.getOrgDivision() + "\",\"" + m.getCreatedBy() + "\",\"" + m.getRevisedGroup() +  "\"),";
			
			
		}
		
		sitem = sitem.substring(0, sitem.length() - 1);
		shift = shift.substring(0, shift.length() - 1);


		s = s + "@p_group='" + model.get(0).getRevisedGroup() + "',";
		s = s + "@P_groupDetails='" + sitem + "',";
		s = s + "@P_shiftDetails='" + shift + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	
}

