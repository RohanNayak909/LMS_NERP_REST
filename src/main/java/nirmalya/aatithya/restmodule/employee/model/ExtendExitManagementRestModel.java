package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtendExitManagementRestModel {

	private String employeeExit;
	private String empID;
	private String empName;
	private String designationId;
	private String designation;
	private String noticePeriod;
	private Double salary;
	private String resignDate;
	private String releaseDate;
	private Double bonus;
	private Double recovery;
	private String reason;
	private String empStatus;
	private String deptId;
	private String deptName;
	private String managerId;
	private String managerName;
	private String clearanceBefore;
	private String clearanceId;
	private String clearanceDeptId;
	private String clearanceDeptName;
	private String clearanceBy;
	private String clearancePName;
	private String clearanceCmnt;
	private String clearanceStatus;
	private String financeStatus;
	private String initId;
	private String createdBy;
	private String empClrncStatus;
	private String financeId;
	private String employeeIdF;
	private String empNameF;
	private String empDepartmentF;
	private String empDepartmentNameF;
	private String managerF;
	private String managerNameF;
	private Double salaryF;
	private String noticePeriodF;
	private Double bonusF;
	private Double other;
	private String comment;
	private Double recoveryF;
	private String organization;
	private String orgDivision;
	private String subDeptId;
	private String subDept;
	private String regStatus;
	private String noticeRemarks;
	private String resignType;
	private String type;
	private String toName;
	private String ccName;
	private String reasonForResignationAttrition;

	public ExtendExitManagementRestModel() {
		super();
// TODO Auto-generated constructor stub
	}

	public ExtendExitManagementRestModel(Object employeeExit, Object empID, Object empName, Object designationId,
			Object designation, Object noticePeriod, Object salary, Object resignDate, Object releaseDate, Object bonus,
			Object recovery, Object reason, Object empStatus, Object deptId, Object deptName, Object managerId,
			Object managerName, Object empClrncStatus, Object other, Object subDeptId, Object subDept, Object regStatus,
			Object financeStatus, Object comment, Object financeId, Object toName, Object ccName) {
		super();

		this.employeeExit = (String) employeeExit;
		this.empID = (String) empID;
		this.empName = (String) empName;
		this.designationId = (String) designationId;
		this.designation = (String) designation;
		this.noticePeriod = (String) noticePeriod;
		this.salary = (Double) salary;
		this.resignDate = (String) resignDate;
		this.releaseDate = (String) releaseDate;
		this.bonus = (Double) bonus;
		this.recovery = (Double) recovery;
		this.reason = (String) reason;
		this.empStatus = (String) empStatus;
		this.deptId = (String) deptId;
		this.deptName = (String) deptName;
		this.managerId = (String) managerId;
		this.managerName = (String) managerName;
		this.empClrncStatus = (String) empClrncStatus;
		this.other = (Double) other;
		this.subDeptId = (String) subDeptId;
		this.subDept = (String) subDept;
		this.regStatus = (String) regStatus;
		this.financeStatus = (String) financeStatus;
		this.comment = (String) comment;
		this.financeId = (String) financeId;
		this.toName = (String) toName;
		this.ccName = (String) ccName;
	}

	public ExtendExitManagementRestModel(Object clearanceId, Object employeeExit, Object empID, Object clearanceDeptId,
			Object clearanceDeptName, Object clearanceBy, Object clearancePName, Object clearanceStatus,
			Object clearanceCmnt) {
		super();
		this.clearanceId = (String) clearanceId;
		this.employeeExit = (String) employeeExit;
		this.empID = (String) empID;
		this.clearanceDeptId = (String) clearanceDeptId;
		this.clearanceDeptName = (String) clearanceDeptName;
		this.clearanceBy = (String) clearanceBy;
		this.clearancePName = (String) clearancePName;
		this.clearanceStatus = (String) clearanceStatus;
		this.clearanceCmnt = (String) clearanceCmnt;
	}

	public ExtendExitManagementRestModel(Object initId, Object employeeExit, Object empID, Object managerId,
			Object deptId, Object clearanceId, Object clearanceDeptId, Object clearanceDeptName, Object clearanceBy,
			Object clearancePName, Object clearanceStatus, Object clearanceCmnt, Object subDeptId) {
		super();
		this.initId = (String) initId;
		this.employeeExit = (String) employeeExit;
		this.empID = (String) empID;
		this.managerId = (String) managerId;
		this.deptId = (String) deptId;
		this.clearanceDeptName = (String) clearanceDeptName;
		this.clearanceId = (String) clearanceId;
		this.clearanceDeptId = (String) clearanceDeptId;
		this.clearanceBy = (String) clearanceBy;
		this.clearancePName = (String) clearancePName;
		this.clearanceStatus = (String) clearanceStatus;
		this.clearanceCmnt = (String) clearanceCmnt;
		this.subDeptId = (String) subDeptId;
	}

	public ExtendExitManagementRestModel(Object financeId, Object employeeIdF, Object empNameF, Object empDepartmentF,
			Object empDepartmentNameF, Object managerF, Object managerNameF, Object salaryF, Object noticePeriodF,
			Object bonusF, Object other, Object comment, Object recoveryF, Object employeeExit) {
		super();
		this.financeId = (String) financeId;
		this.employeeIdF = (String) employeeIdF;
		this.empNameF = (String) empNameF;
		this.empDepartmentF = (String) empDepartmentF;
		this.empDepartmentNameF = (String) empDepartmentNameF;
		this.managerF = (String) managerF;
		this.managerNameF = (String) managerNameF;
		this.salaryF = (Double) salaryF;
		this.noticePeriodF = (String) noticePeriodF;
		this.bonusF = (Double) bonusF;
		this.other = (Double) other;
		this.comment = (String) comment;
		this.recoveryF = (Double) recoveryF;
		this.employeeExit = (String) employeeExit;
	}

	
	public String getClearanceBefore() {
		return clearanceBefore;
	}

	public void setClearanceBefore(String clearanceBefore) {
		this.clearanceBefore = clearanceBefore;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResignType() {
		return resignType;
	}

	public void setResignType(String resignType) {
		this.resignType = resignType;
	}

	public String getNoticeRemarks() {
		return noticeRemarks;
	}

	public void setNoticeRemarks(String noticeRemarks) {
		this.noticeRemarks = noticeRemarks;
	}

	public String getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(String subDeptId) {
		this.subDeptId = subDeptId;
	}

	public String getSubDept() {
		return subDept;
	}

	public void setSubDept(String subDept) {
		this.subDept = subDept;
	}

	public String getEmployeeExit() {
		return employeeExit;
	}

	public void setEmployeeExit(String employeeExit) {
		this.employeeExit = employeeExit;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getResignDate() {
		return resignDate;
	}

	public void setResignDate(String resignDate) {
		this.resignDate = resignDate;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Double getRecovery() {
		return recovery;
	}

	public void setRecovery(Double recovery) {
		this.recovery = recovery;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getClearanceId() {
		return clearanceId;
	}

	public void setClearanceId(String clearanceId) {
		this.clearanceId = clearanceId;
	}

	public String getClearanceDeptId() {
		return clearanceDeptId;
	}

	public void setClearanceDeptId(String clearanceDeptId) {
		this.clearanceDeptId = clearanceDeptId;
	}

	public String getClearanceDeptName() {
		return clearanceDeptName;
	}

	public void setClearanceDeptName(String clearanceDeptName) {
		this.clearanceDeptName = clearanceDeptName;
	}

	public String getClearanceBy() {
		return clearanceBy;
	}

	public void setClearanceBy(String clearanceBy) {
		this.clearanceBy = clearanceBy;
	}

	public String getClearancePName() {
		return clearancePName;
	}

	public void setClearancePName(String clearancePName) {
		this.clearancePName = clearancePName;
	}

	public String getClearanceCmnt() {
		return clearanceCmnt;
	}

	public void setClearanceCmnt(String clearanceCmnt) {
		this.clearanceCmnt = clearanceCmnt;
	}

	public String getClearanceStatus() {
		return clearanceStatus;
	}

	public void setClearanceStatus(String clearanceStatus) {
		this.clearanceStatus = clearanceStatus;
	}

	public String getFinanceStatus() {
		return financeStatus;
	}

	public void setFinanceStatus(String financeStatus) {
		this.financeStatus = financeStatus;
	}

	public String getInitId() {
		return initId;
	}

	public void setInitId(String initId) {
		this.initId = initId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getEmpClrncStatus() {
		return empClrncStatus;
	}

	public void setEmpClrncStatus(String empClrncStatus) {
		this.empClrncStatus = empClrncStatus;
	}

	public String getFinanceId() {
		return financeId;
	}

	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}

	public String getEmployeeIdF() {
		return employeeIdF;
	}

	public void setEmployeeIdF(String employeeIdF) {
		this.employeeIdF = employeeIdF;
	}

	public String getEmpNameF() {
		return empNameF;
	}

	public void setEmpNameF(String empNameF) {
		this.empNameF = empNameF;
	}

	public String getEmpDepartmentF() {
		return empDepartmentF;
	}

	public void setEmpDepartmentF(String empDepartmentF) {
		this.empDepartmentF = empDepartmentF;
	}

	public String getEmpDepartmentNameF() {
		return empDepartmentNameF;
	}

	public void setEmpDepartmentNameF(String empDepartmentNameF) {
		this.empDepartmentNameF = empDepartmentNameF;
	}

	public String getManagerF() {
		return managerF;
	}

	public void setManagerF(String managerF) {
		this.managerF = managerF;
	}

	public String getManagerNameF() {
		return managerNameF;
	}

	public void setManagerNameF(String managerNameF) {
		this.managerNameF = managerNameF;
	}

	public Double getSalaryF() {
		return salaryF;
	}

	public void setSalaryF(Double salaryF) {
		this.salaryF = salaryF;
	}

	public String getNoticePeriodF() {
		return noticePeriodF;
	}

	public void setNoticePeriodF(String noticePeriodF) {
		this.noticePeriodF = noticePeriodF;
	}

	public Double getBonusF() {
		return bonusF;
	}

	public void setBonusF(Double bonusF) {
		this.bonusF = bonusF;
	}

	public Double getOther() {
		return other;
	}

	public void setOther(Double other) {
		this.other = other;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getRecoveryF() {
		return recoveryF;
	}

	public void setRecoveryF(Double recoveryF) {
		this.recoveryF = recoveryF;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrgDivision() {
		return orgDivision;
	}

	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	
	
	

	public String getReasonForResignationAttrition() {
		return reasonForResignationAttrition;
	}

	public void setReasonForResignationAttrition(String reasonForResignationAttrition) {
		this.reasonForResignationAttrition = reasonForResignationAttrition;
	}

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}

}