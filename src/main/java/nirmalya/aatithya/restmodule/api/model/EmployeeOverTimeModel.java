package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeOverTimeModel {
	private String employee;
	private String employeeName;
	private String mobile;
	private String dept;
	private String deptName;
	private String subDept;
	private String subDeptName;
	private String overTimeDate;
	private String overTimeStart;
	private String overTimeEnd;
	private String overTimeDuration;
	private String assignStatus;
	private String assignedBy;
	private String assignedByName;

 
	private Boolean punchInStatus;
	private Boolean punchOutStatus;

	private String organization;
	private String orgDivision;

	public EmployeeOverTimeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeOverTimeModel(Object employee, Object employeeName, Object mobile, Object dept, Object deptName,
			Object subDept, Object subDeptName, Object overTimeDate, Object overTimeStart, Object overTimeEnd,
			Object assignStatus, Object overTimeDuration,Object punchInStatus,Object punchOutStatus) {
		super();
		this.employee = (String) employee;
		this.employeeName = (String) employeeName;
		this.mobile = (String) mobile;
		this.dept = (String) dept;
		this.deptName = (String) deptName;
		this.subDept = (String) subDept;
		this.subDeptName = (String) subDeptName;
		this.overTimeDate = (String) overTimeDate;
		this.overTimeStart = (String) overTimeStart;
		this.overTimeEnd = (String) overTimeEnd;
		this.assignStatus = (String) assignStatus;
		this.overTimeDuration = (String) overTimeDuration;
		this.punchInStatus = (Boolean) punchInStatus;
		this.punchOutStatus = (Boolean) punchOutStatus;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSubDept() {
		return subDept;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSubDeptName() {
		return subDeptName;
	}

	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
	}

	public void setSubDept(String subDept) {
		this.subDept = subDept;
	}

	public String getOverTimeDate() {
		return overTimeDate;
	}

	public void setOverTimeDate(String overTimeDate) {
		this.overTimeDate = overTimeDate;
	}

	public String getOverTimeStart() {
		return overTimeStart;
	}

	public void setOverTimeStart(String overTimeStart) {
		this.overTimeStart = overTimeStart;
	}

	public String getOverTimeEnd() {
		return overTimeEnd;
	}

	public void setOverTimeEnd(String overTimeEnd) {
		this.overTimeEnd = overTimeEnd;
	}

	public String getOverTimeDuration() {
		return overTimeDuration;
	}

	public void setOverTimeDuration(String overTimeDuration) {
		this.overTimeDuration = overTimeDuration;
	}

	public String getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
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

	public Boolean getPunchInStatus() {
		return punchInStatus;
	}

	public void setPunchInStatus(Boolean punchInStatus) {
		this.punchInStatus = punchInStatus;
	}

	public Boolean getPunchOutStatus() {
		return punchOutStatus;
	}

	public void setPunchOutStatus(Boolean punchOutStatus) {
		this.punchOutStatus = punchOutStatus;
	}

	public String getAssignedByName() {
		return assignedByName;
	}

	public void setAssignedByName(String assignedByName) {
		this.assignedByName = assignedByName;
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
