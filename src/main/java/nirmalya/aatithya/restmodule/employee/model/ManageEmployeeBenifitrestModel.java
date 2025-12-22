package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageEmployeeBenifitrestModel {
	
	
	
	private String ebenifitId;
	private List<String> benefits;
	private String employeeId;
	
	private String ebenifitName;
	private String Createdby;


	
	public ManageEmployeeBenifitrestModel() {
		super();
		// TODO Auto-generated constructor stub
	
	
	
	}
	
	public ManageEmployeeBenifitrestModel(Object ebenifitId, Object ebenifitName,Object employeeId,  Object createdBy) {
		super();
		this.ebenifitId = (String)ebenifitId;
		this.employeeId = (String)employeeId;
		this.ebenifitName = (String)ebenifitName;
		this.Createdby =(String) createdBy;
	}


	public String getEbenifitId() {
		return ebenifitId;
	}

	public void setEbenifitId(String ebenifitId) {
		this.ebenifitId = ebenifitId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public List<String> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<String> benefits) {
		this.benefits = benefits;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEbenifitName() {
		return ebenifitName;
	}

	public void setEbenifitName(String ebenifitName) {
		this.ebenifitName = ebenifitName;
	}

	public String getCreatedby() {
		return Createdby;
	}

	public void setCreatedby(String createdby) {
		Createdby = createdby;
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
