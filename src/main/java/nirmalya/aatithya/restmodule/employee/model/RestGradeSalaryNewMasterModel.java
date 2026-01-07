package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestGradeSalaryNewMasterModel {
	private String grdsalaryId;
	private String grdId;
	private String grade;
	private String desc;
	private String gActive;
	private String gCreatedBy;
	private String gUpdatedOn;
	
	private String component;
	private String componentType;
	private String calculationType;
	private Double percentage;
	
	public RestGradeSalaryNewMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestGradeSalaryNewMasterModel(Object grdsalaryId,Object grdId, Object grade, Object desc, Object gActive,
			Object gCreatedBy, Object gUpdatedOn, Object component, Object componentType,
			Object calculationType, Object percentage) {
		super();
		this.grdsalaryId = (String) grdsalaryId;
		this.grdId =(String) grdId;
		this.grade =(String) grade;
		this.desc =(String) desc;
		this.gActive =(String) gActive;
		this.gCreatedBy =(String) gCreatedBy;
		this.gUpdatedOn =(String) gUpdatedOn;
		
		this.component =(String) component;
		this.componentType =(String) componentType;
		this.calculationType =(String) calculationType;
		this.percentage =(Double) percentage;
	}

	public String getGrdsalaryId() {
		return grdsalaryId;
	}

	public void setGrdsalaryId(String grdsalaryId) {
		this.grdsalaryId = grdsalaryId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getgActive() {
		return gActive;
	}

	public void setgActive(String gActive) {
		this.gActive = gActive;
	}

	public String getGrdId() {
		return grdId;
	}

	public void setGrdId(String grdId) {
		this.grdId = grdId;
	}

	public String getgCreatedBy() {
		return gCreatedBy;
	}

	public void setgCreatedBy(String gCreatedBy) {
		this.gCreatedBy = gCreatedBy;
	}

	public String getgUpdatedOn() {
		return gUpdatedOn;
	}

	public void setgUpdatedOn(String gUpdatedOn) {
		this.gUpdatedOn = gUpdatedOn;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	
	

	public String getCalculationType() {
		return calculationType;
	}

	public void setCalculationType(String calculationType) {
		this.calculationType = calculationType;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
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
