package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestAttendanceModel;

public class GenerateParameterAttendance {
	public static String getAddempParam(RestAttendanceModel employee) {

		String s = "";
		if (employee.getEmployeeId() != null && employee.getEmployeeId() != "") {
			s = s + "@p_empId='" + employee.getEmployeeId() + "',";
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		s = s + "@p_punchinDate='" + dateFormat.format(date) + "',";
		
		if (employee.getPunchinTime() != null && employee.getPunchinTime() != "") {
			s = s + "@p_punchinTime='" + DateFormatter.getStringDateTime(employee.getPunchinTime()) + "',";
		}

		if (employee.getPunchinLocation() != null) {
			s = s + "@p_punchinLocation='" + employee.getPunchinLocation() + "',";
		}

		if (employee.getPunchinNote() != null && employee.getPunchinNote() != "") {
			s = s + "@p_punchinNote='" + employee.getPunchinNote() + "',";
		}

		if (employee.getPunchoutTime() != null && employee.getPunchoutTime() != "") {
			s = s + "@p_atnPunchOut='" + DateFormatter.getStringDateTime(employee.getPunchoutTime()) + "',";
		}

		if (employee.getPunchOutLocation() != null) {
			s = s + "@p_atnPunchOutLoc='" + employee.getPunchOutLocation() + "',";
		}

		if (employee.getPunchOutNote() != null && employee.getPunchOutNote() != "") {
			s = s + "@p_atnPunchOutNote='" + employee.getPunchOutNote() + "',";
		}
		if (employee.getLatitude() != null && employee.getLatitude() != "") {
			s = s + "@p_latitude='" + employee.getLatitude() + "',";
		}
		if (employee.getLongitude() != null && employee.getLongitude() != "") {
			s = s + "@p_longitude='" + employee.getLongitude() + "',";
		}
		if(employee.getOrganization() != null || employee.getOrganization() != "") {
			s = s + "@p_org='" + employee.getOrganization() + "',";
		}
		if(employee.getOrgDivision() != null || employee.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + employee.getOrgDivision() + "',";
		}
		// address

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		System.out.println("Return====="+s);
		
		return s;
	}
	public static String getAddUloadedAttendanceDataParam(List<RestAttendanceModel> data) {
		String s = "";
		//String emplist = "";
		String datalist = ""; 

		if (data.size() > 0) {
			for (RestAttendanceModel m : data) {
				//emplist=emplist+"\"" + m.getEmpId() + "\""+",";
				datalist = datalist+ "(\"" + m.getEmployeeId() + "\",\"" + m.getPunchinDate() + "\",\"" + m.getPunchinTime() 
						+ "\",\"" + m.getPunchoutTime() + "\", \"" + m.getShift() + "\",\""
						 + m.getCreatedBy() + "\",\""+m.getOrganization()+"\",\""
						+m.getOrgDivision()+"\"),";
			}
			
		}
		/*
		 * if(!emplist.isEmpty()) { emplist = emplist.substring(0, emplist.length() -
		 * 1); s = s + "@p_emplist='" + emplist + "',"; }
		 */
		if(!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_EmpSubQuery='" + datalist + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
