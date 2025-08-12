package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;


import nirmalya.aatithya.restmodule.master.model.TimeSheetModel;

public class GenerateTimeSheetParameter {
	public static String timesheetParam(List<TimeSheetModel> timeSheetModel) {
	String s = "";
	String timesheet = "";
	String timesheetId="(";
	for (TimeSheetModel m : timeSheetModel) {
		timesheet = timesheet + "(\"" + m.getYear() + "\",\"" + m.getMonth() + "\",\"" + m.getEmpId() + "\",\""+ m.getWeek() + "\",\"" + m.getProject() + "\",\"" + m.getAllocateHour() + "\",\"" + m.getUsedHour() + "\",\"" + m.getAvailableHour() 
				+ "\",\"" + m.getMonday() + "\",\"" + m.getTuesday() + "\",\""+ m.getWedday() + "\",\"" + m.getThursday() + "\",\"" + m.getFriday() + "\",\""+ m.getSaturday() + "\",\""+ m.getSunday() + "\",\""+ m.getTotalProjectDays() + "\",\"" + m.getCreatedBy() + "\"),";
		timesheetId=timesheetId + m.getTimesheetId()+ ",";
	}
	timesheetId = timesheetId.substring(0, timesheetId.length() - 1);
	timesheetId=timesheetId+ ")";
	timesheet = timesheet.substring(0, timesheet.length() - 1);
	
	s = s + "@p_timeSheetSubQuery='" + timesheet + "',";
	s = s + "@p_deleteSubQuery='" + timesheetId + "',";

	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}

	System.out.println(s);

	return s;
	}
}
