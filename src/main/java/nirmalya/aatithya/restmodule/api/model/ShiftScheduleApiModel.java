package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ShiftScheduleApiModel {
	private String empId;
	private String empName;
	private String fromDate;
	private String toDate;
	private String monthYear;
	private String totalWeekoff;
	private String createdBy;
	
	public ShiftScheduleApiModel() {
		super();
	}
	public ShiftScheduleApiModel(Object empId, Object fromDate, Object toDate,
			Object monthYear, Object totalWeekoff) {
		super();
		this.empId = (String) empId;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.monthYear = (String) monthYear;
		this.totalWeekoff = (String) totalWeekoff; 
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
	public String getMonthYear() {
		return monthYear;
	}
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	public String getTotalWeekoff() {
		return totalWeekoff;
	}
	public void setTotalWeekoff(String totalWeekoff) {
		this.totalWeekoff = totalWeekoff;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
