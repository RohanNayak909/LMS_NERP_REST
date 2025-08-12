package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestDeputizationModel {
	
	private String empId;
	private String name;
	private String fromDate;
	private String toDate;
	private String basic;
	private String hra;
	private String addAllow;
	private String lta;
	private String medical;
	private String other;
	private String createdBy;
	private String editId;
	
	public RestDeputizationModel() {
		super();
	}	
	public RestDeputizationModel( Object empId, Object name, Object fromDate,Object toDate,Object basic,Object hra,Object addAllow, Object lta,Object medical,Object other,Object editId) {
		super();
		this.empId = (String) empId;
		this.name = (String) name;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.basic = (String) basic;
		this.hra = (String) hra;
		this.addAllow = (String) addAllow;
		this.lta = (String) lta;
		this.medical = (String) medical;
		this.other = (String) other;
		this.editId = (String) editId;
	}
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getHra() {
		return hra;
	}
	public void setHra(String hra) {
		this.hra = hra;
	}
	public String getAddAllow() {
		return addAllow;
	}
	public void setAddAllow(String addAllow) {
		this.addAllow = addAllow;
	}
	public String getLta() {
		return lta;
	}
	public void setLta(String lta) {
		this.lta = lta;
	}
	public String getMedical() {
		return medical;
	}
	public void setMedical(String medical) {
		this.medical = medical;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getEditId() {
		return editId;
	}
	public void setEditId(String editId) {
		this.editId = editId;
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
