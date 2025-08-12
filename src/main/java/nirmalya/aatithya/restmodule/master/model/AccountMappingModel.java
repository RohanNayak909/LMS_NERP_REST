package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountMappingModel {
private String  mappingId;
private String costCenterId;
private String chartOfAcId;
private String costcenterCode;
private String caCode;
private String createdBy;

public AccountMappingModel() {
	super();
	// TODO Auto-generated constructor stub
}
public AccountMappingModel(Object costCenterId, Object chartOfAcId, Object costcenterCode, Object caCode,Object createdBy) {
	super();
	try {
		this.costCenterId = (String) costCenterId;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.chartOfAcId = (String) chartOfAcId;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.costcenterCode = (String) costcenterCode;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.caCode = (String) caCode;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.createdBy = (String) createdBy;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		this.createdBy = (String) createdBy;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public String getMappingId() {
	return mappingId;
}
public void setMappingId(String mappingId) {
	this.mappingId = mappingId;
}
public String getCostCenterId() {
	return costCenterId;
}
public void setCostCenterId(String costCenterId) {
	this.costCenterId = costCenterId;
}
public String getChartOfAcId() {
	return chartOfAcId;
}
public void setChartOfAcId(String chartOfAcId) {
	this.chartOfAcId = chartOfAcId;
}
public String getCostcenterCode() {
	return costcenterCode;
}
public void setCostcenterCode(String costcenterCode) {
	this.costcenterCode = costcenterCode;
}
public String getCaCode() {
	return caCode;
}
public void setCaCode(String caCode) {
	this.caCode = caCode;
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
