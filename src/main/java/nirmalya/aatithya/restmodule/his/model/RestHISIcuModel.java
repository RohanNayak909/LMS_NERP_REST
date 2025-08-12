package nirmalya.aatithya.restmodule.his.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHISIcuModel {

	
	private String icu;
	private String icuName;
	private String propertyFloorType;
	private String icuDes;
	private String icuStatus;
	private String icuOrg;
	private String icuDiv;
	
	public RestHISIcuModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestHISIcuModel(Object icu, Object icuName, Object propertyFloorType, Object icuDes, Object icuStatus, Object icuOrg,
			Object icuDiv) {
		super();
		this.icu = (String) icu;
		this.icuName = (String) icuName;
		this.propertyFloorType = (String) propertyFloorType;
		this.icuDes = (String) icuDes;
		this.icuStatus = (String) icuStatus;
		this.icuOrg = (String) icuOrg;
		this.icuDiv = (String) icuDiv;

	}
	
	public RestHISIcuModel(Object icu, Object icuName, Object propertyFloorType, Object icuDes, Object icuStatus) {
		super();
		this.icu = (String) icu;
		this.icuName = (String) icuName;
		this.propertyFloorType = (String) propertyFloorType;
		this.icuDes = (String) icuDes;
		this.icuStatus = (String) icuStatus;
	

	}




	public String getIcu() {
		return icu;
	}

	public void setIcu(String icu) {
		this.icu = icu;
	}

	public String getIcuName() {
		return icuName;
	}
	

	public String getPropertyFloorType() {
		return propertyFloorType;
	}

	public void setPropertyFloorType(String propertyFloorType) {
		this.propertyFloorType = propertyFloorType;
	}

	public void setIcuName(String icuName) {
		this.icuName = icuName;
	}

	public String getIcuDes() {
		return icuDes;
	}

	public void setIcuDes(String icuDes) {
		this.icuDes = icuDes;
	}

	public String getIcuStatus() {
		return icuStatus;
	}

	public void setIcuStatus(String icuStatus) {
		this.icuStatus = icuStatus;
	}

	public String getIcuOrg() {
		return icuOrg;
	}

	public void setIcuOrg(String icuOrg) {
		this.icuOrg = icuOrg;
	}

	public String getIcuDiv() {
		return icuDiv;
	}

	public void setIcuDiv(String icuDiv) {
		this.icuDiv = icuDiv;
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
