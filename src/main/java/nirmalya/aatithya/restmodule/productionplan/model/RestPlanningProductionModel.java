package nirmalya.aatithya.restmodule.productionplan.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPlanningProductionModel {
	private String machineid;
	private String machinename;
	private String quantity;
	private String operator;
	private String technician;
	private String helper;
	private String matainance;
	private String other;
	private String parentId;
	private String week;

	public RestPlanningProductionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestPlanningProductionModel(Object machineid, Object machinename, Object operator, Object technician,
			Object helper, Object matainance, Object other,Object parentId) {
		super();
		this.machineid = (String) machineid;
		this.machinename = (String) machinename;
		this.operator = (String) operator;
		this.technician = (String) technician;
		this.helper = (String) helper;
		this.matainance = (String) matainance;
		this.other = (String) other;
		this.parentId = (String) parentId;
	}
	public String getMachineid() {
		return machineid;
	}

	public void setMachineid(String machineid) {
		this.machineid = machineid;
	}

	public String getMachinename() {
		return machinename;
	}

	public void setMachinename(String machinename) {
		this.machinename = machinename;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getTechnician() {
		return technician;
	}

	public void setTechnician(String technician) {
		this.technician = technician;
	}

	public String getHelper() {
		return helper;
	}

	public void setHelper(String helper) {
		this.helper = helper;
	}

	public String getMatainance() {
		return matainance;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setMatainance(String matainance) {
		this.matainance = matainance;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
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
