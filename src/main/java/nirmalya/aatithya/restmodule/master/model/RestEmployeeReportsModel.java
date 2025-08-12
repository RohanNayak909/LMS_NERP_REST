package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestEmployeeReportsModel {
	private String employeeId;
	private String employeeName;
	private String gender;
	private String dob;
	private String bloodGroup;
	private String maritialStatus;
	private String nationality;
	private String fatherName;
	private String motherName;
	private String mobile;
	private String personalMail;
	private String workMail;
	private String personalAddress;
	private String permanentAddress;
	private String panNo;
	private String pfNo;
	private String sicNo;
	private String aadharNo;
	private String department;
	private String subDepartment;
	private String designation;
	private String manager;
	
	private String overTimeDate;
	private String overTimeStart;
	private String overTimeEnd;
	private String overTimeDuration;
	private String assignedBy;
	private String date;
	private String punchInTime;
	private String punchOutTime;
	private String punchInlocation;
	private String punchOutlocation;
	private String totalTime; 
	
	private String empExit;
	private String empName;
	private String empDesg;
	private String resgDate;
	private String salary;
	private String empBonous;
	private String empNotice;
	private String empRec;
	private String resgReas;
	private String resgTo;
	private String resgCc;
	private String resgSub;
 
	public RestEmployeeReportsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestEmployeeReportsModel(Object employeeId, Object employeeName, Object date, Object punchInTime, Object punchInlocation,
			Object punchOutTime, Object punchOutlocation, Object totalTime) {
		super();

		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.date = (String) date;
		this.punchInTime = (String) punchInTime;
		this.punchInlocation = (String) punchInlocation;
		this.punchOutTime = (String) punchOutTime;
		this.punchOutlocation = (String) punchOutlocation;
		this.totalTime = (String) totalTime;
	}
	public RestEmployeeReportsModel(Object employeeId, Object employeeName, Object overTimeStart,Object overTimeEnd,Object overTimeDuration,Object assignedBy,Object date, Object punchInTime, Object punchInlocation,
			Object punchOutTime, Object punchOutlocation, Object totalTime) {
		super();

		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.overTimeStart = (String) overTimeStart;
		this.overTimeEnd = (String) overTimeEnd;
		this.overTimeDuration = (String) overTimeDuration;
		this.assignedBy = (String) assignedBy;
		this.date = (String) date;
		this.punchInTime = (String) punchInTime;
		this.punchInlocation = (String) punchInlocation;
		this.punchOutTime = (String) punchOutTime;
		this.punchOutlocation = (String) punchOutlocation;
		this.totalTime = (String) totalTime;
	}
	public RestEmployeeReportsModel(Object empExit,Object employeeId, Object employeeName, Object empDesg, Object resgDate, Object salary,
			Object empBonous, Object empNotice, Object empRec, Object resgReas, Object resgTo, Object resgCc,
			Object resgSub,Object department,Object subDepartment) {
		super();

		this.empExit = (String) empExit;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.empDesg = (String) empDesg;
		this.resgDate = (String) resgDate;
		this.salary = (String) salary;
		this.empBonous = (String) empBonous;
		this.empNotice = (String) empNotice;
		this.empRec = (String) empRec;
		this.resgReas = (String) resgReas;
		this.resgTo = (String) resgTo;
		this.resgCc = (String) resgCc;
		this.resgSub = (String) resgSub;
		this.department = (String) department;
		this.subDepartment = (String) subDepartment;
	}

	public RestEmployeeReportsModel(Object employeeId, Object employeeName, Object gender, Object dob, Object bloodGroup,
			Object maritialStatus, Object nationality, Object fatherName, Object motherName, Object mobile,
			Object personalMail, Object workMail, Object personalAddress, Object permanentAddress, Object panNo,
			Object pfNo, Object sicNo, Object aadharNo,Object department,Object subDepartment,Object designation,Object manager) {
		super();

		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.gender = (String) gender;
		this.dob = (String) dob;
		this.bloodGroup = (String) bloodGroup;
		this.maritialStatus = (String) maritialStatus;
		this.nationality = (String) nationality;
		this.fatherName = (String) fatherName;
		this.motherName = (String) motherName;
		this.mobile = (String) mobile;
		this.personalMail = (String) personalMail;
		this.workMail = (String) workMail;
		this.personalAddress = (String) personalAddress;
		this.permanentAddress = (String) permanentAddress;
		this.panNo = (String) panNo;
		this.pfNo = (String) pfNo;
		this.sicNo = (String) sicNo;
		this.aadharNo = (String) aadharNo;
		this.department = (String) department;
		this.subDepartment = (String) subDepartment;
		this.designation = (String) designation;
		this.manager = (String) manager;
	}
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPersonalMail() {
		return personalMail;
	}

	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	public String getWorkMail() {
		return workMail;
	}

	public void setWorkMail(String workMail) {
		this.workMail = workMail;
	}

	public String getPersonalAddress() {
		return personalAddress;
	}

	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getPfNo() {
		return pfNo;
	}

	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}

	public String getSicNo() {
		return sicNo;
	}

	public void setSicNo(String sicNo) {
		this.sicNo = sicNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSubDepartment() {
		return subDepartment;
	}

	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getEmpExit() {
		return empExit;
	}

	public void setEmpExit(String empExit) {
		this.empExit = empExit;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	public String getResgDate() {
		return resgDate;
	}

	public void setResgDate(String resgDate) {
		this.resgDate = resgDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmpBonous() {
		return empBonous;
	}

	public void setEmpBonous(String empBonous) {
		this.empBonous = empBonous;
	}

	public String getEmpNotice() {
		return empNotice;
	}

	public void setEmpNotice(String empNotice) {
		this.empNotice = empNotice;
	}

	public String getEmpRec() {
		return empRec;
	}

	public void setEmpRec(String empRec) {
		this.empRec = empRec;
	}

	public String getResgReas() {
		return resgReas;
	}

	public void setResgReas(String resgReas) {
		this.resgReas = resgReas;
	}

	public String getResgTo() {
		return resgTo;
	}

	public void setResgTo(String resgTo) {
		this.resgTo = resgTo;
	}

	public String getResgCc() {
		return resgCc;
	}

	public void setResgCc(String resgCc) {
		this.resgCc = resgCc;
	}

	public String getResgSub() {
		return resgSub;
	}

	public void setResgSub(String resgSub) {
		this.resgSub = resgSub;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPunchInTime() {
		return punchInTime;
	}

	public void setPunchInTime(String punchInTime) {
		this.punchInTime = punchInTime;
	}

	public String getPunchOutTime() {
		return punchOutTime;
	}

	public void setPunchOutTime(String punchOutTime) {
		this.punchOutTime = punchOutTime;
	}

	public String getPunchInlocation() {
		return punchInlocation;
	}

	public void setPunchInlocation(String punchInlocation) {
		this.punchInlocation = punchInlocation;
	}

	public String getPunchOutlocation() {
		return punchOutlocation;
	}

	public void setPunchOutlocation(String punchOutlocation) {
		this.punchOutlocation = punchOutlocation;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
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
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
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