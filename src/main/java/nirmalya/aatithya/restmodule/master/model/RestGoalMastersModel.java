package nirmalya.aatithya.restmodule.master.model;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestGoalMastersModel {
	private String goalId;
	private String goalName;
	private String goalDesc;
	private String bandId;
	private String fromDate;
	private String toDate;
	private String createdBy;
	private String goalIdAuto;
	private String weightage;
	
	public RestGoalMastersModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestGoalMastersModel(Object goalIdAuto,Object goalId, Object goalName, Object goalDesc, Object weightage, Object fromDate,
			Object toDate, Object createdBy) {
		super();
		this.goalId = (String) goalId;
		this.goalName = (String) goalName;
		this.goalDesc = (String) goalDesc;
		this.weightage = (String) weightage;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.createdBy=(String)createdBy;
	}
	public RestGoalMastersModel(Object goalId,Object goalName, Object goalDesc, Object weightage) {
		super();
		this.goalId = (String) goalId;
		this.goalName = (String) goalName;
		this.goalDesc = (String) goalDesc;
		this.weightage = (String) weightage;
		
	}
	public String getWeightage() {
		return weightage;
	}

	public void setWeightage(String weightage) {
		this.weightage = weightage;
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

	public String getGoalDesc() {
		return goalDesc;
	}

	public void setGoalDesc(String goalDesc) {
		this.goalDesc = goalDesc;
	}

	public String getBandId() {
		return bandId;
	}

	public void setBandId(String bandId) {
		this.bandId = bandId;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getGoalIdAuto() {
		return goalIdAuto;
	}

	public void setGoalIdAuto(String goalIdAuto) {
		this.goalIdAuto = goalIdAuto;
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
