package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.master.model.RestPayrollApprovalModel;

public class GenerateAdvanceManagementParam {
	public static String getAdvManageParam( RestAdvanceManagementModel  advance) {

		String s = "";
 
		String advanceId = advance.getAdvanceId();
		String	reqPolicyId = advance.getReqPolicyId();
		String	empID = advance.getEmpID();
		String	ternure = advance.getTernure();
		String	intrestRate = advance.getIntrestRate();
		Double loanamt = advance.getLoanamt(); 
		String reason = advance.getReason()
                .replace("\\", "\\\\")   // Escape backslashes
                .replace("'", "''")      // Escape single quotes for SQL
                .replace("\"", "\\\"")   // Escape double quotes
                .replace("\n", "\\n")    // Escape newlines
                .replace(";", "\\;");    // Escape semicolons
		String	createdBy = advance.getCreatedBy();
		String organization=advance.getOrganization(); 
		String orgDivision=advance.getOrgDivision();
		String advanceApplyDate=DateFormatter.getStringDate(advance. getAdvanceApplyDate());

		String yearMain=advance.getYearMain();;
		String monthMain=advance.getMonthMain();;
	 
		s = s + "@p_advanceId='" + advanceId + "',";
		s = s + "@p_reqPolicyId='" + reqPolicyId + "',";
		s = s + "@p_empId='" + empID + "',";
		s = s + "@p_ternure='" + ternure + "',";
		s = s + "@p_intrestRate='" + intrestRate + "',";
		s = s + "@p_loanamt='" + loanamt + "',";
		s = s + "@p_reason=\"" + reason + "\",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		s = s + "@p_advanceApplyDate='" + advanceApplyDate + "',";
		s = s + "@p_yearMain='" + yearMain + "',";
		s = s + "@p_monthMain='" + monthMain + "',";
		
 
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}
	
	
	public static String getProcessApproveParam( RestAdvanceManagementModel  advance) {

		String s = "";
		String pdata = "";
		
		String advanceId = advance.getAdvanceId();
		s = s + "@p_advanceId='" + advanceId + "',";
		
		
		int ten=Integer.parseInt(advance.getTernure());		

		 int year = Integer.parseInt(advance.getYear());
	     int month = Integer.parseInt(advance.getMonth()); 
        LocalDate currentDate = LocalDate.of(year, month, 1);
        LocalDate futureDate = currentDate;
		for (int i = 1; i <= ten ; i++) {
			System.out.println("futureDate"+futureDate);
			int m=futureDate.getMonthValue();
			int y=futureDate.getYear();
			String duedate=y+"-"+m+"-"+"01";
			futureDate = currentDate.plusMonths(i);
		 
			pdata = pdata + "(\"" +advance.getAdvanceId()+"\",\""+advance.getEmpID()+"\",\""+duedate+"\",\""+advance.getLoanamt()+"\",\""+advance.getTernure()+"\",\""+advance.getIntrestRate()+"\",\""+advance.getEmi()+"\",\""+advance.getTotalInterest()+"\",\""+ advance.getCreatedBy() +"\"),";
		}
		if (pdata != "") {
			pdata = pdata.substring(0, pdata.length() - 1);
			pdata = pdata+"";
		}
		s =s+"@P_subQuery='"+pdata+"'," ;
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}


	public static String getPreCloseAdvanceEMI(List<RestAdvanceManagementModel> data) {
		String s = ""; 
		String datalist = ""; 
 
		if (data.get(data.size()-1).getAdvanceIdList() != null || data.get(data.size()-1).getAdvanceIdList()!= "") {
			String edata=data.get(data.size()-1).getAdvanceIdList();
			s = s + "@p_advIdList=('" + edata.replaceAll("\"\"","\",\"" ) + "'),";
		}
		if (data.get(data.size()-1).getDateList() != null || data.get(data.size()-1).getDateList()!= "") {
			s = s + "@p_dateList=('" + data.get(data.size()-1).getDateList()+ "'),";
		}
		s = s + "@p_empId='" + data.get(0).getEmpID() +"',";
		if (data.size() > 0) {
			for (RestAdvanceManagementModel m : data) {
				if( m.getAdvanceId() != null && m.getAdvanceId()!= "") {
					
					datalist = datalist + "(\"" + m.getAdvanceId() + "\",\"" + m.getEmpID() + "\",\"" + m.getLoanamt() +"\",\"" 
					+ m.getEmi() + "\",\"" + m.getMonth() + "\",\"" + m.getCreatedBy() + "\",now(),\"" + m.getOrganization()
					+ "\",\""+m.getOrgDivision() + "\",\""+m.getTernure() +"\"),";
				}
			}
		}
	
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