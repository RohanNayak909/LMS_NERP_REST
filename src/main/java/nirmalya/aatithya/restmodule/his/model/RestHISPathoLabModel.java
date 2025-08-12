package nirmalya.aatithya.restmodule.his.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHISPathoLabModel {

	private String pathoLab;
	private String labName;
	private String labpropertyFloorType;
	private String labDes;
	private String labStatus;
	private String labOrg;
	private String labDiv;
	
	
	public RestHISPathoLabModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RestHISPathoLabModel(Object pathoLab, Object labName, Object labpropertyFloorType, Object labDes,
			Object labStatus, Object labOrg,Object labDiv) {
		super();
		this.pathoLab = (String) pathoLab;
		this.labName = (String) labName;
		this.labpropertyFloorType = (String) labpropertyFloorType;
		this.labDes = (String) labDes;
		this.labStatus = (String) labStatus;
		this.labOrg = (String) labOrg;
		this.labDiv = (String) labDiv;

	}


	public String getPathoLab() {
		return pathoLab;
	}


	public void setPathoLab(String pathoLab) {
		this.pathoLab = pathoLab;
	}


	public String getLabName() {
		return labName;
	}


	public void setLabName(String labName) {
		this.labName = labName;
	}


	public String getLabpropertyFloorType() {
		return labpropertyFloorType;
	}


	public void setLabpropertyFloorType(String labpropertyFloorType) {
		this.labpropertyFloorType = labpropertyFloorType;
	}


	public String getLabDes() {
		return labDes;
	}


	public void setLabDes(String labDes) {
		this.labDes = labDes;
	}


	public String getLabStatus() {
		return labStatus;
	}


	public void setLabStatus(String labStatus) {
		this.labStatus = labStatus;
	}


	public String getLabOrg() {
		return labOrg;
	}


	public void setLabOrg(String labOrg) {
		this.labOrg = labOrg;
	}


	public String getLabDiv() {
		return labDiv;
	}


	public void setLabDiv(String labDiv) {
		this.labDiv = labDiv;
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
