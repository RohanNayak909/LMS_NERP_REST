package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestSelfAppraisalModel {
	private String name;
	private String designation;
	private String goalId;
	private String goalName;
	private String expectedResults;
	private String weightage;
	private String selfReview;
	private String slNo;
	
	
	public RestSelfAppraisalModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestSelfAppraisalModel(Object goalId,Object slNo,Object goalName,Object expectedResults,Object weightage,Object selfReview) {
		super();
		
		this.goalId = (String) goalId;
		this.slNo = (String) slNo;
		this.goalName = (String) goalName;
		this.expectedResults = (String) expectedResults;
		this.weightage = (String) weightage;
		this.selfReview = (String) selfReview;
	}
	
	
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGoalId() {
		return goalId;
	}

	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public String getExpectedResults() {
		return expectedResults;
	}

	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}

	public String getWeightage() {
		return weightage;
	}

	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}

	public String getSelfReview() {
		return selfReview;
	}

	public void setSelfReview(String selfReview) {
		this.selfReview = selfReview;
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
