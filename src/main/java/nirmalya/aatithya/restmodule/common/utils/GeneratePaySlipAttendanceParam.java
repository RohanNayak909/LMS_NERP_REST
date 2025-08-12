package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.AttendanceDateRestModel;

public class GeneratePaySlipAttendanceParam {
	public static String getPaySlipAttendanceParam(List<AttendanceDateRestModel> data) {
		String s = "";
		String emplist = "";
		String datalist = ""; 

		if (data.get(0).getFromDate() != null || data.get(0).getFromDate()!= "") {
			s = s + "@p_fromdate='" + DateFormatter.getStringDate(data.get(0).getFromDate()) + "',";
		}
		if (data.get(0).getRoleId() != null || data.get(0).getRoleId()!= "") {
			s = s + "@p_roleid='(" + data.get(0).getRoleId()+ ")',";
		}
		if (data.get(0).getApprovedBy() != null || data.get(0).getApprovedBy()!= "") {
			s = s + "@p_approvedBy='" + data.get(0).getApprovedBy() + "',";
		}
		if (data.size() > 0) {
			for (AttendanceDateRestModel m : data) {
				emplist=emplist+"\"" + m.getEmpId() + "\""+",";
				datalist = datalist+ "(@p_status,@p_stage,\"" + m.getEmpId() + "\",\"" + m.getBandid() + "\",\"" + m.getDept() + "\",\"" + m.getSubDept() + "\", \""+ m.getDesgid() + "\", \""  + m.getId1() + "\",\"" + m.getId2()
						+ "\",\"" + m.getId3() + "\",\"" + m.getId4() + "\"," + "\"" + m.getId5() + "\", \""
						+ m.getId6() + "\",\"" + m.getId7() + "\",\"" + m.getId8() + "\",\"" + m.getId9() + "\",\""
						+ m.getId10() + "\"," + "\"" + m.getId11() + "\",\"" + m.getId12() + "\",\"" + m.getId13()
						+ "\",\"" + m.getId14() + "\",\"" + m.getId15() + "\",\"" + m.getId16() + "\"," + "\"" + m.getId17()
						+ "\",\"" + m.getId18() + "\",\"" + m.getId19() + "\",\"" + m.getId20() + "\",\"" + m.getId21()
						+ "\",\"" + m.getId22() + "\"," + "\"" + m.getId23() + "\",\"" + m.getId24() + "\",\""
						+ m.getId25() + "\",\"" + m.getId26() + "\",\"" + m.getId27() + "\",\"" + m.getId28()
						+ "\",\"" + m.getId29() + "\",\"" + m.getId30() + "\",\"" + m.getId31() + "\",\""
						+ DateFormatter.getStringDate(m.getFromDate()) + "\",\""+ DateFormatter.getStringDate(m.getToDate()) 
						+"\",\""+ m.getTotalPresent() + "\",\"" +  m.getLeave() +"\",\"" +  m.getWeekoff() +"\",\""+ m.getHoliday() +"\",\""+ m.getWorkday()
						+"\",\""+ m.getWorkingday()+"\",\""+ m.getRemarks()+"\",\"" + m.getApprovedBy() + "\",\""+m.getOrganization()+"\",\""
						+m.getOrgDivision()+"\",\""+ m.getAttendType()+"\",\""+ m.getOffAvailed()+"\",\""+ m.getLop()+"\"),";
			}
			
		}
		if(!emplist.isEmpty()) {
			emplist = emplist.substring(0, emplist.length() - 1);
			s = s + "@p_emplist='" + emplist + "',";
		}
		if(!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_EmpSubQuery='" + datalist + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.err.println("p_emplist==="+emplist);
		System.err.println("P_EmpSubQuery==="+datalist);
		return s;
	}
	public static String getAttendanceSaveDraftParam(List<AttendanceDateRestModel> data) {
		String s = "";
		String emplist = "";
		String datalist = ""; 

		if (data.get(0).getFromDate() != null || data.get(0).getFromDate()!= "") {
			s = s + "@p_fromdate='" + DateFormatter.getStringDate(data.get(0).getFromDate()) + "',";
		}
		/*
		 * if (data.get(0).getRoleId() != null || data.get(0).getRoleId()!= "") { s = s
		 * + "@p_roleid='(" + data.get(0).getRoleId()+ ")',"; }
		 */
		if (data.get(0).getApprovedBy() != null || data.get(0).getApprovedBy()!= "") {
			s = s + "@p_approvedBy='" + data.get(0).getApprovedBy() + "',";
		}


		if (data.size() > 0) {
			for (AttendanceDateRestModel m : data) {
				emplist=emplist+"\"" + m.getEmpId() + "\""+",";
				datalist = datalist+ "(@p_status,@p_stage,\"" + m.getEmpId() + "\",\"" + m.getBandid() + "\",\"" + m.getDept() + "\",\"" + m.getSubDept() + "\", \"" + m.getDesgid() + "\", \"" + m.getId1() + "\",\"" + m.getId2()
						+ "\",\"" + m.getId3() + "\",\"" + m.getId4() + "\"," + "\"" + m.getId5() + "\", \""
						+ m.getId6() + "\",\"" + m.getId7() + "\",\"" + m.getId8() + "\",\"" + m.getId9() + "\",\""
						+ m.getId10() + "\"," + "\"" + m.getId11() + "\",\"" + m.getId12() + "\",\"" + m.getId13()
						+ "\",\"" + m.getId14() + "\",\"" + m.getId15() + "\",\"" + m.getId16() + "\"," + "\"" + m.getId17()
						+ "\",\"" + m.getId18() + "\",\"" + m.getId19() + "\",\"" + m.getId20() + "\",\"" + m.getId21()
						+ "\",\"" + m.getId22() + "\"," + "\"" + m.getId23() + "\",\"" + m.getId24() + "\",\""
						+ m.getId25() + "\",\"" + m.getId26() + "\",\"" + m.getId27() + "\",\"" + m.getId28()
						+ "\",\"" + m.getId29() + "\",\"" + m.getId30() + "\",\"" + m.getId31() + "\",\""
						+ DateFormatter.getStringDate(m.getFromDate()) + "\",\""+ DateFormatter.getStringDate(m.getToDate()) 
						+"\",\""+ m.getTotalPresent() + "\",\"" +  m.getLeave() +"\",\"" +  m.getWeekoff() +"\",\""+ m.getHoliday() +"\",\""+ m.getWorkday()
						+"\",\""+ m.getWorkingday()+"\",\""+ m.getRemarks()+"\",\"" + m.getApprovedBy() + "\",\""+m.getOrganization()+"\",\""
						+m.getOrgDivision()+"\",\""+ m.getAttendType()+"\",\""+ m.getOffAvailed()+"\",\""+ m.getLop()
						+"\",\""+ m.getOffDay()+"\"),";
			}
			
		}
		if(!emplist.isEmpty()) {
			emplist = emplist.substring(0, emplist.length() - 1);
			s = s + "@p_emplist='" + emplist + "',";
		}
		if(!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_EmpSubQuery='" + datalist + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
	//	System.out.println("s=="+s);
		return s;
	}	
}
