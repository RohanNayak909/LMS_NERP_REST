package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHrmsDashboardModel {

	private String UserId;
	private String Name;
	private String LeaveApplyDate;
	private String ApprovedBy;
	private String ApprovedDate;

	private String month;
	private String totalEvent;
	private String totalApplied;
	private String monthly;
	private String Count;
	private String EmpId;
	private String DepartmentName;
	private String SubDepartmentName;
	private String Monthhh;
	private String DeptId;

	private String Present;
	private String Absent;
	private String Holiday;
	private String days;
	private String OrgName;
	private String OrgDiv;
	private String EmployeeId;
	private String Names;
	private String RequisitionName;
	private String Date;
	private String Status;
	private String Reason;
	private String EventName;
	private String EventStart;
	private String EventEnd;
	private String EventOrganizor;
	private String EventVenue;

	private String monthss;
	private String MonthlyTravel;
	private String MonthlyReimbursement;
	private String Holidays;
	private String dayss;
	private String OrgNames;
	private String OrgDivs;
	private String CreatedOn;

	private String annualSalary;
	private String monthlySalary;
	private String leave;
	private String totalreimbursement;
	private String goalAchived;
	private String event_applied;
	private String OrgDivi;
	private String Created;
	private String OrgNamess;
	private String mob;
	private String totalLeaveRequest;
	private String totalReimbursementRequest;
	private String totalAttendanceRequest;
	private String totalPayrollProcessRequest;
	private String totalRequisition;
	private String totalSelect;
	private String totalCandidate;
	private String totalInterview;
	private String totalProvision;
	private String totalPermanent;
	private String totalPresent;
	private String totalAbsent;
	private String onTime;
	private String late;
	private String totalLeaveCount;
	private String birthdayEvent;
	private String designation;

	private String RejectedCandidate;
	private String ShortlistedCandidate;
	private String HiredCandidates;
	private String Counts;
	private String RequisitionStatus;
	private String RequisitionId;
	private String CandidateId;
	private String CandidateName;
	private String Designations;
	private String DesignationStatus;
	private String CandidateMobileNo;
	private String Gender;

	private String GoalAssign;
	private String Rating;

	public RestHrmsDashboardModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestHrmsDashboardModel(Object userId, Object name, Object leaveApplyDate, Object approvedBy,
			Object approvedDate) {
		super();
		this.UserId = (String) userId;
		this.Name = (String) name;
		this.LeaveApplyDate = (String) leaveApplyDate;
		this.ApprovedBy = (String) approvedBy;
		this.ApprovedDate = (String) approvedDate;

	}

	public RestHrmsDashboardModel(Object month, Object totalEvent, Object totalApplied, Object monthly, Object count,
			Object empId, Object departmentName, Object subDepartmentName, Object monthhh, Object deptId) {
		super();
		this.month = (String) month;
		this.totalEvent = (String) totalEvent;
		this.totalApplied = (String) totalApplied;
		this.monthly = (String) monthly;
		this.Count = (String) count;
		this.EmpId = (String) empId;
		this.DepartmentName = (String) departmentName;
		this.SubDepartmentName = (String) subDepartmentName;
		this.Monthhh = (String) monthhh;
		this.DeptId = (String) deptId;
	}

	public RestHrmsDashboardModel(Object orgName, Object orgDiv, Object employeeId, Object names, Object date,
			Object status, Object reason, Object goalAssign, Object rating) {
		super();

		this.OrgName = (String) orgName;
		this.OrgDiv = (String) orgDiv;
		this.EmployeeId = (String) employeeId;
		this.Names = (String) names;
		this.Date = (String) date;
		this.Status = (String) status;
		this.Reason = (String) reason;
		this.GoalAssign = (String) goalAssign;
		this.Rating = (String) rating;
	}

	public RestHrmsDashboardModel(Object present, Object absent, Object holiday, Object days, Object orgName,
			Object orgDiv, Object employeeId, Object names, Object requisitionName, Object date, Object status,
			Object reason, Object eventName, Object eventStart, Object eventEnd, Object eventOrganizor,
			Object eventVenue) {
		super();

		this.Present = (String) present;

		this.Absent = (String) absent;

		this.Holiday = (String) holiday;
		this.days = (String) days;
		this.OrgName = (String) orgName;
		this.OrgDiv = (String) orgDiv;
		this.EmployeeId = (String) employeeId;
		this.Names = (String) names;
		this.RequisitionName = (String) requisitionName;
		this.Date = (String) date;
		this.Status = (String) status;
		this.Reason = (String) reason;
		this.EventName = (String) eventName;
		this.EventStart = (String) eventStart;
		this.EventEnd = (String) eventEnd;
		this.EventOrganizor = (String) eventOrganizor;
		this.EventVenue = (String) eventVenue;

	}

	public RestHrmsDashboardModel(Object monthss, Object monthlyTravel, Object monthlyReimbursement, Object holidays,
			Object dayss, Object orgNames, Object orgDivs, Object createdOn) {
		super();
		this.monthss = (String) monthss;
		this.MonthlyTravel = (String) monthlyTravel;
		this.MonthlyReimbursement = (String) monthlyReimbursement;
		this.Holidays = (String) holidays;
		this.dayss = (String) dayss;
		this.OrgNames = (String) orgNames;
		this.OrgDivs = (String) orgDivs;
		this.CreatedOn = (String) createdOn;
	}

	public RestHrmsDashboardModel(Object annualSalary, Object monthlySalary, Object leave, Object totalreimbursement,
			Object goalAchived, Object event_applied, Object orgDivi, Object created, Object orgNamess, Object mob,
			Object totalLeaveRequest, Object totalReimbursementRequest, Object totalAttendanceRequest,
			Object totalPayrollProcessRequest) {
		super();
		this.annualSalary = (String) annualSalary;
		this.monthlySalary = (String) monthlySalary;
		this.leave = (String) leave;
		this.totalreimbursement = (String) totalreimbursement;
		this.goalAchived = (String) goalAchived;
		this.event_applied = (String) event_applied;
		this.OrgDivi = (String) orgDivi;
		this.Created = (String) created;
		this.OrgNamess = (String) orgNamess;
		this.mob = (String) mob;
		this.totalLeaveRequest = (String) totalLeaveRequest;
		this.totalReimbursementRequest = (String) totalReimbursementRequest;
		this.totalAttendanceRequest = (String) totalAttendanceRequest;
		this.totalPayrollProcessRequest = (String) totalPayrollProcessRequest;
	}

	public RestHrmsDashboardModel(Object totalRequisition, Object totalSelect, Object totalCandidate,
			Object totalInterview, Object totalProvision, Object totalPermanent, Object totalPresent,
			Object totalAbsent, Object onTime, Object late, Object totalLeaveCount, Object birthdayEvent,
			Object designation, Object rejectedCandidate, Object shortlistedCandidate, Object hiredCandidates,
			Object counts, Object requisitionStatus, Object requisitionId, Object candidateId, Object candidateName,
			Object designations, Object designationStatus, Object candidateMobileNo, Object gender) {

		super();
		this.totalRequisition = (String) totalRequisition;
		this.totalSelect = (String) totalSelect;
		this.totalCandidate = (String) totalCandidate;
		this.totalInterview = (String) totalInterview;
		this.totalProvision = (String) totalProvision;
		this.totalPermanent = (String) totalPermanent;
		this.totalPresent = (String) totalPresent;
		this.totalAbsent = (String) totalAbsent;
		this.onTime = (String) onTime;
		this.late = (String) late;
		this.totalLeaveCount = (String) totalLeaveCount;
		this.birthdayEvent = (String) birthdayEvent;
		this.designation = (String) designation;
		this.RejectedCandidate = (String) rejectedCandidate;
		this.ShortlistedCandidate = (String) shortlistedCandidate;
		this.HiredCandidates = (String) hiredCandidates;
		this.Counts = (String) counts;
		this.RequisitionStatus = (String) requisitionStatus;
		this.RequisitionId = (String) requisitionId;
		this.CandidateId = (String) candidateId;
		this.CandidateName = (String) candidateName;
		this.Designations = (String) designations;
		this.DesignationStatus = (String) designationStatus;
		this.CandidateMobileNo = (String) candidateMobileNo;
		this.Gender = (String) gender;

	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLeaveApplyDate() {
		return LeaveApplyDate;
	}

	public void setLeaveApplyDate(String leaveApplyDate) {
		LeaveApplyDate = leaveApplyDate;
	}

	public String getApprovedDate() {
		return ApprovedDate;
	}

	public void setApprovedDate(String approvedDate) {
		ApprovedDate = approvedDate;
	}

	public String getApprovedBy() {
		return ApprovedBy;
	}

	public void setApprovedBy(String approvedBy) {
		ApprovedBy = approvedBy;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTotalEvent() {
		return totalEvent;
	}

	public void setTotalEvent(String totalEvent) {
		this.totalEvent = totalEvent;
	}

	public String getTotalApplied() {
		return totalApplied;
	}

	public void setTotalApplied(String totalApplied) {
		this.totalApplied = totalApplied;
	}

	public String getMonthly() {
		return monthly;
	}

	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}

	public String getHoliday() {
		return Holiday;
	}

	public void setHoliday(String holiday) {
		Holiday = holiday;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getOrgName() {
		return OrgName;
	}

	public void setOrgName(String orgName) {
		OrgName = orgName;
	}

	public String getOrgDiv() {
		return OrgDiv;
	}

	public void setOrgDiv(String orgDiv) {
		OrgDiv = orgDiv;
	}

	public String getMonthss() {
		return monthss;
	}

	public void setMonthss(String monthss) {
		this.monthss = monthss;
	}

	public String getMonthlyTravel() {
		return MonthlyTravel;
	}

	public void setMonthlyTravel(String monthlyTravel) {
		MonthlyTravel = monthlyTravel;
	}

	public String getMonthlyReimbursement() {
		return MonthlyReimbursement;
	}

	public void setMonthlyReimbursement(String monthlyReimbursement) {
		MonthlyReimbursement = monthlyReimbursement;
	}

	public String getHolidays() {
		return Holidays;
	}

	public void setHolidays(String holidays) {
		Holidays = holidays;
	}

	public String getDayss() {
		return dayss;
	}

	public void setDayss(String dayss) {
		this.dayss = dayss;
	}

	public String getOrgNames() {
		return OrgNames;
	}

	public void setOrgNames(String orgNames) {
		OrgNames = orgNames;
	}

	public String getOrgDivs() {
		return OrgDivs;
	}

	public void setOrgDivs(String orgDivs) {
		OrgDivs = orgDivs;
	}

	public String getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}

	public String getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(String monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public String getTotalreimbursement() {
		return totalreimbursement;
	}

	public void setTotalreimbursement(String totalreimbursement) {
		this.totalreimbursement = totalreimbursement;
	}

	public String getGoalAchived() {
		return goalAchived;
	}

	public void setGoalAchived(String goalAchived) {
		this.goalAchived = goalAchived;
	}

	public String getEvent_applied() {
		return event_applied;
	}

	public void setEvent_applied(String event_applied) {
		this.event_applied = event_applied;
	}

	public String getOrgDivi() {
		return OrgDivi;
	}

	public void setOrgDivi(String orgDivi) {
		OrgDivi = orgDivi;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public String getOrgNamess() {
		return OrgNamess;
	}

	public void setOrgNamess(String orgNamess) {
		OrgNamess = orgNamess;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}

	public String getNames() {
		return Names;
	}

	public void setNames(String names) {
		Names = names;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getPresent() {
		return Present;
	}

	public void setPresent(String present) {
		Present = present;
	}

	public String getAbsent() {
		return Absent;
	}

	public void setAbsent(String absent) {
		Absent = absent;
	}

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getRequisitionName() {
		return RequisitionName;
	}

	public void setRequisitionName(String requisitionName) {
		RequisitionName = requisitionName;
	}

	public String getEventStart() {
		return EventStart;
	}

	public void setEventStart(String eventStart) {
		EventStart = eventStart;
	}

	public String getEventEnd() {
		return EventEnd;
	}

	public void setEventEnd(String eventEnd) {
		EventEnd = eventEnd;
	}

	public String getEventOrganizor() {
		return EventOrganizor;
	}

	public void setEventOrganizor(String eventOrganizor) {
		EventOrganizor = eventOrganizor;
	}

	public String getEventVenue() {
		return EventVenue;
	}

	public void setEventVenue(String eventVenue) {
		EventVenue = eventVenue;
	}

	public String getTotalLeaveRequest() {
		return totalLeaveRequest;
	}

	public void setTotalLeaveRequest(String totalLeaveRequest) {
		this.totalLeaveRequest = totalLeaveRequest;
	}

	public String getTotalReimbursementRequest() {
		return totalReimbursementRequest;
	}

	public void setTotalReimbursementRequest(String totalReimbursementRequest) {
		this.totalReimbursementRequest = totalReimbursementRequest;
	}

	public String getTotalAttendanceRequest() {
		return totalAttendanceRequest;
	}

	public void setTotalAttendanceRequest(String totalAttendanceRequest) {
		this.totalAttendanceRequest = totalAttendanceRequest;
	}

	public String getTotalPayrollProcessRequest() {
		return totalPayrollProcessRequest;
	}

	public void setTotalPayrollProcessRequest(String totalPayrollProcessRequest) {
		this.totalPayrollProcessRequest = totalPayrollProcessRequest;
	}

	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		Count = count;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	public String getSubDepartmentName() {
		return SubDepartmentName;
	}

	public void setSubDepartmentName(String subDepartmentName) {
		SubDepartmentName = subDepartmentName;
	}

	public String getTotalRequisition() {
		return totalRequisition;
	}

	public void setTotalRequisition(String totalRequisition) {
		this.totalRequisition = totalRequisition;
	}

	public String getTotalSelect() {
		return totalSelect;
	}

	public void setTotalSelect(String totalSelect) {
		this.totalSelect = totalSelect;
	}

	public String getTotalCandidate() {
		return totalCandidate;
	}

	public void setTotalCandidate(String totalCandidate) {
		this.totalCandidate = totalCandidate;
	}

	public String getTotalInterview() {
		return totalInterview;
	}

	public void setTotalInterview(String totalInterview) {
		this.totalInterview = totalInterview;
	}

	public String getTotalProvision() {
		return totalProvision;
	}

	public void setTotalProvision(String totalProvision) {
		this.totalProvision = totalProvision;
	}

	public String getTotalPermanent() {
		return totalPermanent;
	}

	public void setTotalPermanent(String totalPermanent) {
		this.totalPermanent = totalPermanent;
	}

	public String getTotalPresent() {
		return totalPresent;
	}

	public void setTotalPresent(String totalPresent) {
		this.totalPresent = totalPresent;
	}

	public String getTotalAbsent() {
		return totalAbsent;
	}

	public void setTotalAbsent(String totalAbsent) {
		this.totalAbsent = totalAbsent;
	}

	public String getOnTime() {
		return onTime;
	}

	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}

	public String getLate() {
		return late;
	}

	public void setLate(String late) {
		this.late = late;
	}

	public String getTotalLeaveCount() {
		return totalLeaveCount;
	}

	public void setTotalLeaveCount(String totalLeaveCount) {
		this.totalLeaveCount = totalLeaveCount;
	}

	public String getBirthdayEvent() {
		return birthdayEvent;
	}

	public void setBirthdayEvent(String birthdayEvent) {
		this.birthdayEvent = birthdayEvent;
	}

	public String getMonthhh() {
		return Monthhh;
	}

	public void setMonthhh(String monthhh) {
		Monthhh = monthhh;
	}

	public String getDeptId() {
		return DeptId;
	}

	public void setDeptId(String deptId) {
		DeptId = deptId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRejectedCandidate() {
		return RejectedCandidate;
	}

	public void setRejectedCandidate(String rejectedCandidate) {
		RejectedCandidate = rejectedCandidate;
	}

	public String getShortlistedCandidate() {
		return ShortlistedCandidate;
	}

	public void setShortlistedCandidate(String shortlistedCandidate) {
		ShortlistedCandidate = shortlistedCandidate;
	}

	public String getHiredCandidates() {
		return HiredCandidates;
	}

	public void setHiredCandidates(String hiredCandidates) {
		HiredCandidates = hiredCandidates;
	}

	public String getCounts() {
		return Counts;
	}

	public void setCounts(String counts) {
		Counts = counts;
	}

	public String getRequisitionStatus() {
		return RequisitionStatus;
	}

	public void setRequisitionStatus(String requisitionStatus) {
		RequisitionStatus = requisitionStatus;
	}

	public String getRequisitionId() {
		return RequisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		RequisitionId = requisitionId;
	}

	public String getCandidateId() {
		return CandidateId;
	}

	public void setCandidateId(String candidateId) {
		CandidateId = candidateId;
	}

	public String getCandidateName() {
		return CandidateName;
	}

	public void setCandidateName(String candidateName) {
		CandidateName = candidateName;
	}

	public String getDesignationStatus() {
		return DesignationStatus;
	}

	public void setDesignationStatus(String designationStatus) {
		DesignationStatus = designationStatus;
	}

	public String getDesignations() {
		return Designations;
	}

	public void setDesignations(String designations) {
		Designations = designations;
	}

	public String getCandidateMobileNo() {
		return CandidateMobileNo;
	}

	public void setCandidateMobileNo(String candidateMobileNo) {
		CandidateMobileNo = candidateMobileNo;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getGoalAssign() {
		return GoalAssign;
	}

	public void setGoalAssign(String goalAssign) {
		GoalAssign = goalAssign;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
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
