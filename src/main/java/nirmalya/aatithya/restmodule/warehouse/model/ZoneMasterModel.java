package nirmalya.aatithya.restmodule.warehouse.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ZoneMasterModel {
private String zoneId;
private String zoneCode;
private String zoneName;
private String createdBy;
private String warehouseId;
private Integer zoneSlNo;
private BigInteger locCount;
private BigInteger floorCount;
private String organization;
private String orgDivision;
public ZoneMasterModel() {
	super();
	// TODO Auto-generated constructor stub
}
public ZoneMasterModel(Object zoneId,Object warehouseId, Object zoneCode, Object zoneName,Object zoneSlNo,Object locCount,
		Object floorCount,Object createdBy) {
	super();
	this.zoneId = (String) zoneId;
	this.warehouseId = (String) warehouseId;
	this.zoneCode = (String) zoneCode;
	this.zoneName = (String) zoneName;
	this.zoneSlNo = (Integer) zoneSlNo;
	this.locCount = (BigInteger) locCount;
	this.floorCount = (BigInteger) floorCount;
	this.createdBy = (String) createdBy;
}


public String getOrganization() {
	return organization;
}
public void setOrganization(String organization) {
	this.organization = organization;
}
public String getOrgDivision() {
	return orgDivision;
}
public void setOrgDivision(String orgDivision) {
	this.orgDivision = orgDivision;
}
public String getZoneId() {
	return zoneId;
}
public void setZoneId(String zoneId) {
	this.zoneId = zoneId;
}

public String getWarehouseId() {
	return warehouseId;
}
public void setWarehouseId(String warehouseId) {
	this.warehouseId = warehouseId;
}
public String getZoneCode() {
	return zoneCode;
}
public void setZoneCode(String zoneCode) {
	this.zoneCode = zoneCode;
}
public String getZoneName() {
	return zoneName;
}
public void setZoneName(String zoneName) {
	this.zoneName = zoneName;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public Integer getZoneSlNo() {
	return zoneSlNo;
}
public void setZoneSlNo(Integer zoneSlNo) {
	this.zoneSlNo = zoneSlNo;
}
public BigInteger getLocCount() {
	return locCount;
}
public void setLocCount(BigInteger locCount) {
	this.locCount = locCount;
}
public BigInteger getFloorCount() {
	return floorCount;
}
public void setFloorCount(BigInteger floorCount) {
	this.floorCount = floorCount;
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
