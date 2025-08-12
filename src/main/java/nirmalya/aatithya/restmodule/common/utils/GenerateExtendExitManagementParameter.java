package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.employee.model.ExitFinancialSettelmentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;
public class GenerateExtendExitManagementParameter {
	public static String getAddExitManagementParam(ExtendExitManagementRestModel exitManagement) {
		String s = "";

		if (exitManagement.getEmployeeExit() != null && exitManagement.getEmployeeExit() != "") {
			s = s + "@p_exitMangementId='" + exitManagement.getEmployeeExit() + "',";
		}
		if (exitManagement.getEmpID() != null && exitManagement.getEmpID() != "") {
			s = s + "@p_empName='" + exitManagement.getEmpID() + "',";
		}

		if (exitManagement.getDesignation() != null && exitManagement.getDesignation() != "") {
			s = s + "@p_empdesignation='" + exitManagement.getDesignation() + "',";
		}

		if (exitManagement.getResignDate() != null && exitManagement.getResignDate() != "") {
			s = s + "@p_resignationDate='" + exitManagement.getResignDate() + "',";
		}
		if (exitManagement.getSalary() != null) {
			s = s + "@p_salary=" + exitManagement.getSalary() + ",";
		}
		if (exitManagement.getBonus() != null) {
			s = s + "@p_bonus=" + exitManagement.getBonus() + ",";
		}
		if (exitManagement.getRecovery() != null) {
			s = s + "@p_recovery=" + exitManagement.getRecovery() + ",";
		}

		if (exitManagement.getNoticePeriod() != null && exitManagement.getNoticePeriod() != "") {
			s = s + "@p_noticeperiod='" + exitManagement.getNoticePeriod() + "',";
		}

		if (exitManagement.getReleaseDate() != null && exitManagement.getReleaseDate() != "") {
			s = s + "@p_releaseDate='" + exitManagement.getReleaseDate() + "',";
		}
		if (exitManagement.getReason() != null && exitManagement.getReason() != "") {
			s = s + "@p_reason='" + exitManagement.getReason() + "',";
		}
		if (exitManagement.getEmpStatus() != null && exitManagement.getEmpStatus() != " ") {
			s = s + "@p_status='" + exitManagement.getEmpStatus() + "',";
		}
		if (exitManagement.getCreatedBy() != null && exitManagement.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + exitManagement.getCreatedBy() + "',";
		}
		if (exitManagement.getOrganization() != null || exitManagement.getOrganization() != "") {
			s = s + "@p_org='" + exitManagement.getOrganization() + "',";
		}
		if (exitManagement.getOrgDivision() != null || exitManagement.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + exitManagement.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String getAddClearanceParam(ExtendExitManagementRestModel exitManagement) {
		String s = "";
		if (exitManagement.getClearanceId() != null && exitManagement.getClearanceId() != "") {
			s = s + "@p_clearanceId='" + exitManagement.getClearanceId() + "',";
		}
		if (exitManagement.getEmployeeExit() != null && exitManagement.getEmployeeExit() != "") {
			s = s + "@p_exitId='" + exitManagement.getEmployeeExit() + "',";
		}
		if (exitManagement.getEmpID() != null && exitManagement.getEmpID() != "") {
			s = s + "@p_empId='" + exitManagement.getEmpID() + "',";
		}
 
		if (exitManagement.getClearanceDeptId() != null && exitManagement.getClearanceDeptId() != "") {
			s = s + "@p_cdept='" + exitManagement.getClearanceDeptId() + "',";
		}
		if (exitManagement.getClearanceStatus() != null && exitManagement.getClearanceStatus() != " ") {
			s = s + "@p_status='" + exitManagement.getClearanceStatus() + "',";
		}
		if (exitManagement.getClearanceBy() != null && exitManagement.getClearanceBy() != " ") {
			s = s + "@p_createdBy='" + exitManagement.getClearanceBy() + "',";
		}
		if (exitManagement.getClearanceCmnt() != null && exitManagement.getClearanceCmnt() != " ") {
			s = s + "@p_comment='" + exitManagement.getClearanceCmnt() + "',";
		}
		if (exitManagement.getOrganization() != null || exitManagement.getOrganization() != "") {
			s = s + "@p_org='" + exitManagement.getOrganization() + "',";
		}
		if (exitManagement.getOrgDivision() != null || exitManagement.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + exitManagement.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getAddFinanceDetailsParam(ExtendExitManagementRestModel exit) {
		String s = "";

		if (exit.getFinanceId() != null && exit.getFinanceId() != "") {
			s = s + "@p_financeId='" + exit.getFinanceId() + "',";
		}
		if (exit.getEmployeeExit() != null && exit.getEmployeeExit() != "") {
			s = s + "@p_employeeExit='" + exit.getEmployeeExit() + "',";
		}
		if (exit.getEmployeeIdF() != null && exit.getEmployeeIdF() != "") {
			s = s + "@p_employeeId='" + exit.getEmployeeIdF() + "',";
		}

		if (exit.getEmpNameF() != null && exit.getEmpNameF() != "") {
			s = s + "@p_empName='" + exit.getEmpNameF() + "',";
		}
		if (exit.getEmpDepartmentF() != null && exit.getEmpDepartmentF() != "") {
			s = s + "@p_empDep='" + exit.getEmpDepartmentF() + "',";
		}
		if (exit.getManagerF() != null && exit.getManagerF() != "") {
			s = s + "@p_empManager='" + exit.getManagerF() + "',";
		}

		if (exit.getSalary() != null) {
			s = s + "@p_salary=" + exit.getSalary() + ",";
		}
		if (exit.getBonus() != null) {
			s = s + "@p_bonus=" + exit.getBonus() + ",";
		}
		if (exit.getRecovery() != null) {
			s = s + "@p_recovery=" + exit.getRecovery() + ",";
		}
		if (exit.getOther() != null) {
			s = s + "@p_other=" + exit.getOther() + ",";
		}
		if (exit.getNoticePeriodF() != null && exit.getNoticePeriodF() != "") {
			s = s + "@p_noticeperiod='" + exit.getNoticePeriodF() + "',";
		}

		if (exit.getComment() != null && exit.getComment() != "") {
			s = s + "@p_comment='" + exit.getComment() + "',";
		}

		if (exit.getCreatedBy() != null && exit.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + exit.getCreatedBy() + "',";
		}
		if(exit.getOrganization() != null || exit.getOrganization() != "") {
			s = s + "@p_org='" + exit.getOrganization() + "',";
		}
		if(exit.getOrgDivision() != null || exit.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + exit.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("Finance" + s);
		return s;
	}
	
	public static String addFinalSettlement(ExitFinancialSettelmentRestModel exitManagement) {
		String s = "";

		if (exitManagement.getSettlementId() != null && exitManagement.getSettlementId() != "") {
			s = s + "@p_settlementId='" + exitManagement.getSettlementId() + "',";
		}
		if (exitManagement.getExitId() != null && exitManagement.getExitId() != "") {
			s = s + "@p_exitId='" + exitManagement.getExitId() + "',";
		}

		if (exitManagement.getBasicAmount() != null && exitManagement.getBasicAmount() != "") {
			s = s + "@p_basicAmount='" + exitManagement.getBasicAmount() + "',";
		}

		if (exitManagement.getHraAmount() != null && exitManagement.getHraAmount() != "") {
			s = s + "@p_hraAmount='" + exitManagement.getHraAmount() + "',";
		}

		if (exitManagement.getConAllowanceAmount() != null && exitManagement.getConAllowanceAmount() != "") {
			s = s + "@p_convAmount='" + exitManagement.getConAllowanceAmount() + "',";
		}

		if (exitManagement.getWashAllowanceAmount() != null && exitManagement.getWashAllowanceAmount() != "") {
			s = s + "@p_washAMount='" + exitManagement.getWashAllowanceAmount() + "',";
		}
		if (exitManagement.getTotalEarning() != null && exitManagement.getTotalEarning() != "") {
			s = s + "@p_totalEarning='" + exitManagement.getTotalEarning() + "',";
		}
		if (exitManagement.getEpfAmount() != null && exitManagement.getEpfAmount() != " ") {
			s = s + "@p_epfAmount='" + exitManagement.getEpfAmount() + "',";
		}
		if (exitManagement.getEsicAmount() != null && exitManagement.getEsicAmount() != " ") {
			s = s + "@p_esicAmount='" + exitManagement.getEsicAmount() + "',";
		}
		if (exitManagement.getProfessionalTax() != null && exitManagement.getProfessionalTax() != " ") {
			s = s + "@p_professionalTax='" + exitManagement.getProfessionalTax() + "',";
		}
		if (exitManagement.getSalaryAdvance() != null && exitManagement.getSalaryAdvance() != " ") {
			s = s + "@p_salaryAdvance='" + exitManagement.getSalaryAdvance() + "',";
		}
		if (exitManagement.getTotalDeduction() != null && exitManagement.getTotalDeduction() != " ") {
			s = s + "@p_totalDeduction='" + exitManagement.getTotalDeduction() + "',";
		}
		if (exitManagement.getNetAmount() != null && exitManagement.getNetAmount() != " ") {
			s = s + "@p_netAmount='" + exitManagement.getNetAmount() + "',";
		}
		if (exitManagement.getBonusAmount() != null && exitManagement.getBonusAmount() != " ") {
			s = s + "@p_bonusAmount='" + exitManagement.getBonusAmount() + "',";
		}
		if (exitManagement.getLeaveAmount() != null && exitManagement.getLeaveAmount() != " ") {
			s = s + "@p_leaveAmount='" + exitManagement.getLeaveAmount() + "',";
		}
		if (exitManagement.getOtherAmount() != null && exitManagement.getOtherAmount() != " ") {
			s = s + "@p_otherAmount='" + exitManagement.getOtherAmount() + "',";
		}
		if (exitManagement.getTotalAmount() != null && exitManagement.getTotalAmount() != " ") {
			s = s + "@p_totalAmount='" + exitManagement.getTotalAmount() + "',";
		}
		if (exitManagement.getFinanceStatus() != null && exitManagement.getFinanceStatus() != " ") {
			s = s + "@p_finanaceStatus='" + exitManagement.getFinanceStatus() + "',";
		}
		if (exitManagement.getCreatedBy() != null && exitManagement.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + exitManagement.getCreatedBy() + "',";
		}
		if (exitManagement.getOrganization() != null || exitManagement.getOrganization() != "") {
			s = s + "@p_org='" + exitManagement.getOrganization() + "',";
		}
		if (exitManagement.getOrgDivision() != null || exitManagement.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + exitManagement.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
}
