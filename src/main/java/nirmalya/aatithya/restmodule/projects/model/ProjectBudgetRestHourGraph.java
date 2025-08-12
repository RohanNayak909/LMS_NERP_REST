package nirmalya.aatithya.restmodule.projects.model;

public class ProjectBudgetRestHourGraph {
private String project;
private Double allocatedHour;
private Double totalHour;
public ProjectBudgetRestHourGraph(Object project, Object allocatedHour, Object totalHour) {
	super();
	this.project = (String)project;
	this.allocatedHour = (Double)allocatedHour;
	this.totalHour = (Double)totalHour;
}
public String getProject() {
	return project;
}
public void setProject(String project) {
	this.project = project;
}
public Double getAllocatedHour() {
	return allocatedHour;
}
public void setAllocatedHour(Double allocatedHour) {
	this.allocatedHour = allocatedHour;
}
public Double getTotalHour() {
	return totalHour;
}
public void setTotalHour(Double totalHour) {
	this.totalHour = totalHour;
}

}
