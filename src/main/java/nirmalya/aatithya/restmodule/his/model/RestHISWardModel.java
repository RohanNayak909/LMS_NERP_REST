package nirmalya.aatithya.restmodule.his.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHISWardModel {

	private String wardId;
	private String wardName;
	private String floor;
	private String floorId;
	private String department;
	private String departmentId;
	private String wardStatus;
	private String description;

	private String organization;
	private String orgDivision;
	private String createdBy;

	public RestHISWardModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestHISWardModel(Object wardId, Object wardName, Object floor, Object floorId, Object department,
			Object departmentId, Object wardStatus, Object description) {

		super();

		this.wardId = (String) wardId;
		this.wardName = (String) wardName;
		this.floor = (String) floor;
		this.floorId = (String) floorId;
		this.department = (String) department;
		this.departmentId = (String) departmentId;
		this.wardStatus = (String) wardStatus;
		this.description = (String) description;

	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getWardStatus() {
		return wardStatus;
	}

	public void setWardStatus(String wardStatus) {
		this.wardStatus = wardStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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
