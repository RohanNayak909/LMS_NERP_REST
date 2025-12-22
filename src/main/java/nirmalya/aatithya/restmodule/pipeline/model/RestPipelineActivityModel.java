package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPipelineActivityModel {
	private String activityTypeId;
	private String activityType;
	private String duedate;
	private String summary;
	private String assignTo;
	private String activityTypeDesc;
	private String activityTypeCreatedBy;
	private String activityPipeline;
	private Boolean activityDoneStatus;
	private String createdOn;
	public RestPipelineActivityModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestPipelineActivityModel(Object activityTypeId, Object activityType, Object duedate, Object summary,
			Object assignTo, Object activityTypeDesc, Object activityTypeCreatedBy, Object activityPipeline,Object activityDoneStatus,Object createdOn) {
		super();
		try {
			this.activityTypeId = (String) activityTypeId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.activityType = (String) activityType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.duedate = (String) duedate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.summary = (String) summary;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.assignTo = (String) assignTo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.activityTypeDesc = (String) activityTypeDesc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.activityTypeCreatedBy = (String) activityTypeCreatedBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.activityPipeline = (String) activityPipeline;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.activityDoneStatus = (Boolean) activityDoneStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.createdOn = (String) createdOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getActivityTypeId() {
		return activityTypeId;
	}

	public void setActivityTypeId(String activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getActivityTypeDesc() {
		return activityTypeDesc;
	}
	public void setActivityTypeDesc(String activityTypeDesc) {
		this.activityTypeDesc = activityTypeDesc;
	}
	public String getActivityTypeCreatedBy() {
		return activityTypeCreatedBy;
	}
	public void setActivityTypeCreatedBy(String activityTypeCreatedBy) {
		this.activityTypeCreatedBy = activityTypeCreatedBy;
	}
	
	public String getActivityPipeline() {
		return activityPipeline;
	}
	public void setActivityPipeline(String activityPipeline) {
		this.activityPipeline = activityPipeline;
	}
	
	public Boolean getActivityDoneStatus() {
		return activityDoneStatus;
	}
	public void setActivityDoneStatus(Boolean activityDoneStatus) {
		this.activityDoneStatus = activityDoneStatus;
	}
	
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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
