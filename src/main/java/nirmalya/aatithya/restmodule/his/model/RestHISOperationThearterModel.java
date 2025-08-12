package nirmalya.aatithya.restmodule.his.model;

public class RestHISOperationThearterModel {

	private String otId;
	private String otName;
	private String floor;

	private String otStatus;
	private String description;

	private String organization;
	private String orgDivision;
	private String createdBy;
	private String floorId;

	public RestHISOperationThearterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor for view
	public RestHISOperationThearterModel(Object otId, Object otName, Object floor, Object otStatus, Object description,
			Object floorId) {
		super();
		this.otId = (String) otId;
		this.otName = (String) otName;
		this.floor = (String) floor;
		this.otStatus = (String) otStatus;
		this.description = (String) description;
		this.floorId = (String) floorId;

	}
	
	

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getOtId() {
		return otId;
	}

	public void setOtId(String otId) {
		this.otId = otId;
	}

	public String getOtName() {
		return otName;
	}

	public void setOtName(String otName) {
		this.otName = otName;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getOtStatus() {
		return otStatus;
	}

	public void setOtStatus(String otStatus) {
		this.otStatus = otStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
