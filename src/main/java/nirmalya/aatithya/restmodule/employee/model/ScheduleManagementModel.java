package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ScheduleManagementModel {

	private String shiftScheduleId;
	private String employeeId;
	private String firstName;
	private String departmantId;
	private String departmant;
	private String sectionId;
	private String section;
	private String scheduleId;
	private String schedule;
	private String fromDate;
	private String toDate;

	private String shiftId;
	private String shift;
	private String empId;
	private String empName;
	private String remark;

	private String createdBy;
	private String createdOn;
	private String updatedon;
	private String updatedBy;
	private String organization;
	private String orgDivision;


	public ScheduleManagementModel (Object shiftScheduleId, Object employeeId, Object firstName, Object departmantId,
			Object departmant, Object sectionId, Object section, Object scheduleId, Object schedule, Object fromDate,
			Object toDate, Object shiftId, Object shift, Object empId, Object empName, Object remark, Object createdBy,
			Object createdOn, Object updatedon, Object updatedBy) {

		super();
		
		this.shiftScheduleId = (String) shiftScheduleId;
		this.employeeId = (String) employeeId;
		this.firstName = (String) firstName;
		this.departmantId = (String) departmantId;
		this.departmant = (String) departmant;
		this.sectionId = (String) sectionId;
		this.section = (String) section;
		this.scheduleId = (String) scheduleId;
		this.schedule = (String) schedule;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		
		this.shiftId = (String) shiftId;
		this.shift = (String) shift;
		this.empId = (String) empId;
		this.empName = (String) empName;
		this.remark = (String) remark;

		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.updatedon = (String) updatedon;
		this.updatedBy = (String) updatedBy;
		
	}

	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDepartmantId() {
		return departmantId;
	}

	public void setDepartmantId(String departmantId) {
		this.departmantId = departmantId;
	}

	public String getDepartmant() {
		return departmant;
	}

	public void setDepartmant(String departmant) {
		this.departmant = departmant;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	
	public String getFromDate() {
		return fromDate;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	public String getToDate() {
		return toDate;
	}


	public void setToDate(String toDate) {
		this.toDate = toDate;
	}


	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getShiftScheduleId() {
		return shiftScheduleId;
	}


	public void setShiftScheduleId(String shiftScheduleId) {
		this.shiftScheduleId = shiftScheduleId;
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
