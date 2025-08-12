package nirmalya.aatithya.restmodule.common.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;

public class GenerateLeaveParameter {
    public static String addLeaveApply(List<LeaveApplyRestModel> leave) {
        String s = "";
        String sitem = "";
        String forapprove = "";
        String dateFormat = "yyyy-MM-dd";

        //parent table

        if (leave.get(0).getLeaveId() != null && !leave.get(0).getLeaveId().isEmpty()) {
            s = s + "@p_leaveId='" + leave.get(0).getLeaveId() + "',";
        }
        if (leave.get(0).getEmpID() != null && !leave.get(0).getEmpID().isEmpty()) {
            s = s + "@p_empId='" + leave.get(0).getEmpID() + "',";
        }
        if (leave.get(0).getEmpName() != null && !leave.get(0).getEmpName().isEmpty()) {
            s = s + "@p_empName='" + leave.get(0).getEmpName() + "',";
        }
        if (leave.get(0).getLeaveApplyDate() != null && !leave.get(0).getLeaveApplyDate().isEmpty()) {
            s = s + "@p_leaveApplyDate='" + leave.get(0).getLeaveApplyDate() + "',";
        }
        if (leave.get(0).getCreatedBy() != null && !leave.get(0).getCreatedBy().isEmpty()) {
            s = s + "@p_createdBy='" + leave.get(0).getCreatedBy() + "',";
        }
        if (leave.get(0).getOrganization() != null && !leave.get(0).getOrganization().isEmpty()) {
            s = s + "@p_org='" + leave.get(0).getOrganization() + "',";
        }
        if (leave.get(0).getOrgDivision() != null && !leave.get(0).getOrgDivision().isEmpty()) {
            s = s + "@p_orgDiv='" + leave.get(0).getOrgDivision() + "',";
        }
        if (leave.get(0).getFromDate() != null && !leave.get(0).getFromDate().isEmpty()) {
            s = s + "@p_fdate='" + leave.get(0).getFromDate() + "',";
        }
        if (leave.get(0).getToDate() != null && !leave.get(0).getToDate().isEmpty()) {
            s = s + "@p_tdate='" + leave.get(0).getToDate() + "',";
        }
        if (leave.get(0).getDocumentURL() != null && !leave.get(0).getDocumentURL().isEmpty()) {
            s = s + "@p_docURL='" + leave.get(0).getDocumentURL() + "',";
        }
        if (leave.get(0).getFileName() != null && !leave.get(0).getFileName().isEmpty()) {
            s = s + "@p_docName='" + leave.get(0).getFileName() + "',";
        }

        //child table
        for (LeaveApplyRestModel m : leave) {

            sitem = sitem + "(@p_leaveId,\"" + m.getLeaveTypeId() +
                    "\",\"" + m.getFromDate() + "\",\"" + m.getToDate() + "\",\"" + m.getTotalLeave() + "\",\"" +
                    m.getReason().replace("'", "\\'").replace("\"", "\\\\\"") + "\",\"" + m.getCreatedBy() + "\",\"" 
                    + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\",\"" 
                    + m.getFileName() + "\",\"" + m.getDocumentURL() + "\",\"" + m.getHalfDayCheckbox() + "\"),";
        }
        sitem = sitem.substring(0, sitem.length() - 1);
        System.out.println("Sitemmmmmmmm========>>>>>>"+sitem);
       

        List<Pair<LocalDate, String>> datesWithWeekday = getDatesWithWeekdayBetween(leave.get(0).getFromDate(), leave.get(0).getToDate(), dateFormat);
 
            for (Pair<LocalDate, String> pair : datesWithWeekday) {
                LocalDate date = pair.getKey();
                String weekday = pair.getValue();
                forapprove = forapprove + "(@p_leaveId,\"" + date +"\",\"" + weekday +"\",\"" + leave.get(0).getCreatedBy() + "\",\"" + leave.get(0).getOrganization() + "\",\"" +
                        leave.get(0).getOrgDivision() + "\",\""+leave.get(0).getLeaveTypeId() +"\"),";
            }
        forapprove = forapprove.substring(0, forapprove.length() - 1);
        s = s + "@p_itemSubQuery='" + sitem + "'," + "@p_approveSubQuery='" + forapprove + "',";
        System.out.println("Sitemmmmmmmm========>>>>>>"+s);
        
        if (!s.isEmpty()) {
            s = s.substring(0, s.length() - 1);
            s = "SET " + s + ";";
        }
        return s;
    }
 

    public static List<Pair<LocalDate, String>> getDatesWithWeekdayBetween(String fromDateString, String toDateString, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate fromDate = LocalDate.parse(fromDateString, formatter);
        LocalDate toDate = LocalDate.parse(toDateString, formatter);

        List<Pair<LocalDate, String>> datesWithWeekday = new ArrayList<>();
        LocalDate currentDate = fromDate;

        while (!currentDate.isAfter(toDate)) {
            String weekday = currentDate.getDayOfWeek().toString();
            datesWithWeekday.add(new Pair<>(currentDate, weekday));
            currentDate = currentDate.plusDays(1);
        }

        return datesWithWeekday;
    }
}
