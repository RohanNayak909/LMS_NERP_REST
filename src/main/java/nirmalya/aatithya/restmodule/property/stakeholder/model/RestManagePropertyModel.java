package nirmalya.aatithya.restmodule.property.stakeholder.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestManagePropertyModel {

	private String propId;
	private String propname;
	private String docName;
	
	public String getDocName() {
		return docName;
	}


	public void setDocName(String docName) {
		this.docName = docName;
	}


	public String getPropname() {
		return propname;
	}


	public void setPropname(String propname) {
		this.propname = propname;
	}
	private String  type;
	private String rent;
	private String actrent;
	private String areas;
	private String address;
	private String name;
	private String area;
	private String propprice;
	private String tenantname;
	private String startdate;
	private String enddate;
	private String email;



	private String createdBy;
	
	public	RestManagePropertyModel() {
		super();
	}

	
	public	RestManagePropertyModel( Object propId, Object type, Object propname, Object rent, 
			Object actrent, Object areas,Object address, Object area
			,Object propprice,Object tenantname, Object startdate, Object enddate,
			Object docName, Object email,Object createdBy) {
		super();
	
		this.propId = (String) propId;
		this.type = (String)type;
		this.propname= (String) propname;
		this.rent = (String)rent;
		this.actrent = (String) actrent;
		this.areas = (String) areas;
		this.address = (String)address;
	
		this.area = (String)area;
		this.propprice = (String)propprice;
		this.tenantname = (String)tenantname;
		this.startdate= (String)startdate;
		this.enddate = (String)enddate;
		this.docName=(String)docName;
		this.email=(String)email;
		this.createdBy=(String)createdBy;
		
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getPropId() {
		return propId;
	}


	public void setPropId(String propId) {
		this.propId = propId;
	}


	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRent() {
		return rent;
	}


	public void setRent(String rent) {
		this.rent = rent;
	}


	public String getActrent() {
		return actrent;
	}


	public void setActrent(String actrent) {
		this.actrent = actrent;
	}


	public String getAreas() {
		return areas;
	}


	public void setAreas(String areas) {
		this.areas = areas;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getPropprice() {
		return propprice;
	}


	public void setPropprice(String propprice) {
		this.propprice = propprice;
	}


	public String getTenantname() {
		return tenantname;
	}


	public void setTenantname(String tenantname) {
		this.tenantname = tenantname;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
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
