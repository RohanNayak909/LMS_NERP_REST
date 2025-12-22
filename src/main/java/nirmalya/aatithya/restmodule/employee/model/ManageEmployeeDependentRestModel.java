package nirmalya.aatithya.restmodule.employee.model;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;



public class ManageEmployeeDependentRestModel {
	
	private String dependentId;
	private String employeeId;
	
	
	private String dependentType;
	private String dfirstName;
	private String dlastName;
	private String depdob;
	private String gender;
	private String genderid;
	private String drelationship;
	private String relationshipName;
	private String dependentTypeName;
	
	public String getRelationshipName() {
		return relationshipName;
	}


	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
	}


	public String getDependentTypeName() {
		return dependentTypeName;
	}
	private String createdBy;
	public ManageEmployeeDependentRestModel() {
	super();
	// TODO Auto-generated constructor stub
}
public ManageEmployeeDependentRestModel(Object dependentId, Object dependentTypeName, Object employeeId, Object dependentType, Object dfirstName, Object dlastName,
		Object depdob, Object gender,Object genderid, Object drelationship, Object relationshipName,  Object createdBy) {
	super();
	this.dependentId = (String)dependentId;
	this.dependentTypeName = (String) dependentTypeName;
	this.employeeId = (String)employeeId;
	this.dependentType = (String)dependentType;
	this.dfirstName = (String)dfirstName;
	this.dlastName = (String)dlastName;
	this.depdob =(String)depdob ;
	this.gender = (String)gender;
	this.genderid = (String)genderid;
	this.drelationship =(String) drelationship;
	this.relationshipName = (String) relationshipName;
	this.createdBy =(String) createdBy;
}
public String getDependentId() {
	return dependentId;
}
public void setDependentId(String dependentId) {
	this.dependentId = dependentId;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getDependentType() {
	return dependentType;
}
public void setDependentType(String dependentType) {
	this.dependentType = dependentType;
}
public String getDfirstName() {
	return dfirstName;
}
public void setDfirstName(String dfirstName) {
	this.dfirstName = dfirstName;
}
public String getDlastName() {
	return dlastName;
}
public void setDlastName(String dlastName) {
	this.dlastName = dlastName;
}
public String getDepdob() {
	return depdob;
}
public void setDepdob(String depdob) {
	this.depdob = depdob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}



public String getGenderid() {
	return genderid;
}
public void setGenderid(String genderid) {
	this.genderid = genderid;
}
public String getDrelationship() {
	return drelationship;
}
public void setDrelationship(String drelationship) {
	this.drelationship = drelationship;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
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
