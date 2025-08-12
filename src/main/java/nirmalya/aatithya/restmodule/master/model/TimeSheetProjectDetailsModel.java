package nirmalya.aatithya.restmodule.master.model;

public class TimeSheetProjectDetailsModel {
	private String employeeId;
	private String projectId;
	private String projectName;
	private String projectAllocated;
	private String projectUsed;
	private String projectAvailable;
	private String monday;
	private String tuesday;
	private String wedday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sunday;
	private String totalProjectDays;
	private String proDetailsId;

	public TimeSheetProjectDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimeSheetProjectDetailsModel(Object employeeId, Object projectId, Object projectName,
			Object projectAllocated, Object projectUsed, Object projectAvailable, Object monday, Object tuesday,
			Object wedday, Object thursday, Object friday, Object saturday, Object sunday, Object totalProjectDays,Object proDetailsId) {
		super();

		this.employeeId = (String) employeeId;
		this.projectId = (String) projectId;
		this.projectName = (String) projectName;
		this.projectAllocated = (String) projectAllocated;
		this.projectUsed = (String) projectUsed;
		this.projectAvailable = (String) projectAvailable;
		this.monday = (String) monday;
		this.tuesday = (String) tuesday;
		this.wedday = (String) wedday;
		this.thursday = (String) thursday;
		this.friday = (String) friday;
		this.saturday = (String) saturday;
		this.sunday = (String) sunday;
		this.totalProjectDays = (String) totalProjectDays;
		this.proDetailsId = (String) proDetailsId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectAllocated() {
		return projectAllocated;
	}

	public void setProjectAllocated(String projectAllocated) {
		this.projectAllocated = projectAllocated;
	}

	public String getProjectUsed() {
		return projectUsed;
	}

	public void setProjectUsed(String projectUsed) {
		this.projectUsed = projectUsed;
	}

	public String getProjectAvailable() {
		return projectAvailable;
	}

	public void setProjectAvailable(String projectAvailable) {
		this.projectAvailable = projectAvailable;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWedday() {
		return wedday;
	}

	public void setWedday(String wedday) {
		this.wedday = wedday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getTotalProjectDays() {
		return totalProjectDays;
	}

	public void setTotalProjectDays(String totalProjectDays) {
		this.totalProjectDays = totalProjectDays;
	}

	public String getProDetailsId() {
		return proDetailsId;
	}

	public void setProDetailsId(String proDetailsId) {
		this.proDetailsId = proDetailsId;
	}

}
