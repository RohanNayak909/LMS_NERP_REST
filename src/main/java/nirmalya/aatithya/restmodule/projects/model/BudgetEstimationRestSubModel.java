package nirmalya.aatithya.restmodule.projects.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BudgetEstimationRestSubModel {

	private String projectId;
	private String budgetCategory;
	private String item;
	private List<BudgetEstimationRestModel> addData;

	public BudgetEstimationRestSubModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BudgetEstimationRestSubModel(Object budgetCategory, Object item, Object projectId) {
		this.budgetCategory = (String) budgetCategory;
		this.item = (String) item;
		this.projectId = (String) projectId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getBudgetCategory() {
		return budgetCategory;
	}

	public void setBudgetCategory(String budgetCategory) {
		this.budgetCategory = budgetCategory;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<BudgetEstimationRestModel> getAddData() {
		return addData;
	}

	public void setAddData(List<BudgetEstimationRestModel> addData) {
		this.addData = addData;
	}

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
