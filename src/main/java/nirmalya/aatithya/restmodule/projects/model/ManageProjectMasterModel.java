package nirmalya.aatithya.restmodule.projects.model;

public class ManageProjectMasterModel {

	private String projectId;
	private String projectName;
	private String projectType;
	private String projectTypeName;
	private String priority;
	private String priorityName;
	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	private String projectDesc;
	private String dept;
	private String projectOwner;
	private String startDate;
	private String endDate;
	private Double budgetHour;
	private Double budgetResourceSpend;
	private Double budgetNonResourceSpend;
	private String createdBy;
	private String createdOn;
	
	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public ManageProjectMasterModel(Object projectId, Object projectName, Object projectType, Object projectTypeName, Object priority,
			Object priorityName, Object projectDesc, Object dept, Object projectOwner, Object startDate, Object endDate, Object budgetHour,
			Object budgetResourceSpend, Object budgetNonResourceSpend, Object createdBy, Object createdOn) {
		
		this.projectId = (String) projectId;
		this.projectName = (String) projectName;
		this.projectType = (String) projectType;
		this.priority = (String) priority;
		this.projectDesc = (String) projectDesc;
		this.dept = (String) dept;
		this.projectOwner = (String) projectOwner;
		this.startDate = (String) startDate;
		this.endDate = (String) endDate;
		this.budgetHour = (Double) budgetHour;
		this.budgetResourceSpend = (Double) budgetResourceSpend;
		this.budgetNonResourceSpend = (Double) budgetNonResourceSpend;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.projectTypeName = (String) projectTypeName;
		this.priorityName = (String) priorityName;
	}
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getProjectOwner() {
		return projectOwner;
	}
	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Double getBudgetHour() {
		return budgetHour;
	}
	public void setBudgetHour(Double budgetHour) {
		this.budgetHour = budgetHour;
	}
	public Double getBudgetResourceSpend() {
		return budgetResourceSpend;
	}
	public void setBudgetResourceSpend(Double budgetResourceSpend) {
		this.budgetResourceSpend = budgetResourceSpend;
	}
	public Double getBudgetNonResourceSpend() {
		return budgetNonResourceSpend;
	}
	public void setBudgetNonResourceSpend(Double budgetNonResourceSpend) {
		this.budgetNonResourceSpend = budgetNonResourceSpend;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
