package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.ExitFinancialSettelmentRestModel;


public class GenerateExitFinanceParameter {
	public static String getAddExitFinanceParam(ExitFinancialSettelmentRestModel exitFinance) {
		
		String comment = exitFinance.getComment()
                .replace("\\", "\\\\")   // Escape backslashes
                .replace("'", "''")      // Escape single quotes for SQL
                .replace("\"", "\\\"")   // Escape double quotes
                .replace("\n", "\\n")    // Escape newlines
                .replace(";", "\\;");    // Escape semicolons
		String s = "";
			
			if(exitFinance.getFinanceId()!=null && exitFinance.getFinanceId()!="")
			{
				s = s + "@p_financeId='" + exitFinance.getFinanceId() + "',";
			}
			if(exitFinance.getEmployeeId()!=null && exitFinance.getEmployeeId()!="")
			{
				s = s + "@p_employeeId='" + exitFinance.getEmployeeId() + "',";
			}
			 
			if(exitFinance.getEmpName()!=null && exitFinance.getEmpName()!="")
			{
				s = s + "@p_empName='" + exitFinance.getEmpName() + "',";
			}
			if(exitFinance.getEmpDepartment()!=null && exitFinance.getEmpDepartment()!="")
			{
				s = s + "@p_empDep='" + exitFinance.getEmpDepartment() + "',";
			}
			if(exitFinance.getManager()!=null && exitFinance.getManager()!="")
			{
				s = s + "@p_empManager='" + exitFinance.getManager() + "',";
			}
			
			if(exitFinance.getSalary()!=null)
			{
				s = s + "@p_salary=" + exitFinance.getSalary() + ",";
			}
			if(exitFinance.getBonus()!=null)
			{
				s = s + "@p_bonus=" + exitFinance.getBonus() + ",";
			}
			if(exitFinance.getRecovery()!=null) {
				s = s + "@p_recovery=" + exitFinance.getRecovery() + ",";
			}
			if(exitFinance.getOther()!=null) {
				s = s + "@p_other=" + exitFinance.getOther() + ",";
			}
			if(exitFinance.getNoticePeriod()!=null && exitFinance.getNoticePeriod()!="")
			{
				s = s + "@p_noticeperiod='" + exitFinance.getNoticePeriod() + "',";
			}
			
			if(comment !=null && comment !="")
			{
				s = s + "@p_comment='" + comment + "',";
			}
			
			if(exitFinance.getCreatedBy()!=null && exitFinance.getCreatedBy()!=" ")
			{
				s = s + "@p_createdBy='" + exitFinance.getCreatedBy() + "',";
			}
			if(s != "") {
				s = s.substring(0, s.length()-1);
				
				s = "SET " + s + ";" ;
			}
			System.out.println(s);
			return s;
		}
	
	
	
	public static String updateClearanceStatus(ExitFinancialSettelmentRestModel exitFinance) {
		String comment = exitFinance.getComment()
                .replace("\\", "\\\\")   // Escape backslashes
                .replace("'", "''")      // Escape single quotes for SQL
                .replace("\"", "\\\"")   // Escape double quotes
                .replace("\n", "\\n")    // Escape newlines
                .replace(";", "\\;");    // Escape semicolons
		
		String s = "";
			
			if(exitFinance.getClearanceId()!=null && exitFinance.getClearanceId()!="")
			{
				s = s + "@p_clearanceId='" + exitFinance.getClearanceId() + "',";
			}
			if(exitFinance.getRecovery()!=null && exitFinance.getRecovery()!="")
			{
				s = s + "@p_recovery='" + exitFinance.getRecovery() + "',";
			}
			 
			if(comment!=null && comment!="")
			{
				s = s + "@p_remarks=\"" + comment  + "\",";
			}
			
			if(exitFinance.getCreatedBy()!=null && exitFinance.getCreatedBy()!=" ")
			{
				s = s + "@p_createdBy='" + exitFinance.getCreatedBy() + "',";
			}
			if(exitFinance.getOrganization()!=null && exitFinance.getOrganization()!=" ")
			{
				s = s + "@p_org='" + exitFinance.getOrganization() + "',";
			}
			if(exitFinance.getOrgDivision()!=null && exitFinance.getOrgDivision()!=" ")
			{
				s = s + "@p_orgDiv='" + exitFinance.getOrgDivision() + "',";
			}
			
			if(s != "") {
				s = s.substring(0, s.length()-1);
				
				s = "SET " + s + ";" ;
			}
			System.out.println(s);
			return s;
		}
}
