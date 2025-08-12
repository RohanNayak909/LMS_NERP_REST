package nirmalya.aatithya.restmodule.budget.model;

public class RestBudgetSettingModel {
	
	
	private String budgetSetId;
	private String currentYear;
	private String lastYear;
	private String secondlastYear;
	
	public RestBudgetSettingModel(Object budgetSetId, Object currentYear, Object lastYear, Object secondlastYear) {
		super();
		this.budgetSetId = (String) budgetSetId;
		this.currentYear = (String) currentYear;
		this.lastYear = (String) lastYear;
		this.secondlastYear = (String) secondlastYear;
		
	}
	
	public RestBudgetSettingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBudgetSetId() {
		return budgetSetId;
	}

	public void setBudgetSetId(String budgetSetId) {
		this.budgetSetId = budgetSetId;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getLastYear() {
		return lastYear;
	}

	public void setLastYear(String lastYear) {
		this.lastYear = lastYear;
	}

	public String getSecondlastYear() {
		return secondlastYear;
	}

	public void setSecondlastYear(String secondlastYear) {
		this.secondlastYear = secondlastYear;
	}
	
	

}
