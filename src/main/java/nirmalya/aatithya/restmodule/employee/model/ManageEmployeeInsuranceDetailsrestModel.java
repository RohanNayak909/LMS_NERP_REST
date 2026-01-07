package nirmalya.aatithya.restmodule.employee.model;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageEmployeeInsuranceDetailsrestModel {
	
	
	
	private String einsuraneId;
	private String employeeId;

	private String einsurancetype;
	private String einsurancetypeid;
	private String einsurancecompany;
	private String einsurancecompanyid;
	
	private String policyno;
	private String eifromdate;
	
	private String eitodate;
	

	private String createdBy;
	
	public ManageEmployeeInsuranceDetailsrestModel() {
	super();
	// TODO Auto-generated constructor stub
}
public ManageEmployeeInsuranceDetailsrestModel(Object einsuraneId, Object employeeId, Object einsurancetype,Object einsurancetypeid, Object einsurancecompany,Object einsurancecompanyid,Object policyno,Object eifromdate,
		Object eitodate,  Object createdBy) {
	super();
	this.einsuraneId = (String)einsuraneId;
	this.employeeId = (String)employeeId;
	this.einsurancetype = (String)einsurancetype;
	this.einsurancetypeid = (String)einsurancetypeid;
	this.einsurancecompany = (String)einsurancecompany;
	this.einsurancecompanyid = (String)einsurancecompanyid;
	this.policyno = (String)policyno;
	this.eifromdate =(String)eifromdate ;
	this.eitodate = (String)eitodate;
	
	this.createdBy =(String) createdBy;
}
public String getEinsuraneId() {
	return einsuraneId;
}
public void setEinsuraneId(String einsuraneId) {
	this.einsuraneId = einsuraneId;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getEinsurancetype() {
	return einsurancetype;
}
public void setEinsurancetype(String einsurancetype) {
	this.einsurancetype = einsurancetype;
}
public String getEinsurancecompany() {
	return einsurancecompany;
}
public void setEinsurancecompany(String einsurancecompany) {
	this.einsurancecompany = einsurancecompany;
}
public String getPolicyno() {
	return policyno;
}
public void setPolicyno(String policyno) {
	this.policyno = policyno;
}
public String getEifromdate() {
	return eifromdate;
}
public void setEifromdate(String eifromdate) {
	this.eifromdate = eifromdate;
}
public String getEitodate() {
	return eitodate;
}
public void setEitodate(String eitodate) {
	this.eitodate = eitodate;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}







public String getEinsurancetypeid() {
	return einsurancetypeid;
}
public void setEinsurancetypeid(String einsurancetypeid) {
	this.einsurancetypeid = einsurancetypeid;
}
public String getEinsurancecompanyid() {
	return einsurancecompanyid;
}
public void setEinsurancecompanyid(String einsurancecompanyid) {
	this.einsurancecompanyid = einsurancecompanyid;
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
