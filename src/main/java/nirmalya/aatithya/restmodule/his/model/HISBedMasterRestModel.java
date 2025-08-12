package nirmalya.aatithya.restmodule.his.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HISBedMasterRestModel {

	private String bedId;
	private String bedName;
	private String propertyFloorType;
	private String ward;

	private String bedCharge;
	// private Double bedCharge;
	private String bedDescription;
	private String status;
	private String organization;
	private String orgDivision;
	private String createdBy;
	private String wardId;
	private String bedAvailability;

	public HISBedMasterRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HISBedMasterRestModel(Object bedId, Object bedName, Object propertyFloorType, Object ward, Object bedCharge,
			Object bedDescription, Object status, Object organization, Object orgDivision, Object createdBy,Object bedAvailability) {
		super();
		this.bedId = (String) bedId;
		this.bedName = (String) bedName;
		this.propertyFloorType = (String) propertyFloorType;
		this.ward = (String) ward;
		this.bedCharge = (String) bedCharge;
		// this.bedCharge = (Double) bedCharge;
		this.bedDescription = (String) bedDescription;
		this.status = (String) status;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
		this.createdBy = (String) createdBy;
		this.bedAvailability = (String) bedAvailability;

	}

	/*
	 * public HISBedMasterRestModel(Object bedId, Object bedName, Object
	 * propertyFloorType, Object ward, Object bedCharge, Object bedDescription,
	 * Object status, Object organization, Object orgDivision, Object createdBy,
	 * Object wardId) { super(); this.bedId = (String) bedId; this.bedName =
	 * (String) bedName; this.propertyFloorType = (String) propertyFloorType;
	 * this.ward = (String) ward;
	 * 
	 * this.bedCharge = (String) bedCharge; // this.bedCharge = (Double) bedCharge;
	 * this.bedDescription = (String) bedDescription; this.status = (String) status;
	 * this.organization = (String) organization; this.orgDivision = (String)
	 * orgDivision; this.createdBy = (String) createdBy; this.wardId = (String)
	 * wardId;
	 * 
	 * }
	 */

	public HISBedMasterRestModel(Object bedId, Object bedName, Object propertyFloorType, Object ward, Object bedCharge,
			Object bedDescription, Object status, Object wardId,Object bedAvailability) {
		super();
		this.bedId = (String) bedId;
		this.bedName = (String) bedName;
		this.propertyFloorType = (String) propertyFloorType;
		this.wardId = (String) wardId;

		this.bedCharge = (String) bedCharge;
		this.bedDescription = (String) bedDescription;
		this.status = (String) status;
		this.ward = (String) ward;
		this.bedAvailability = (String) bedAvailability;

	}

	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getBedName() {
		return bedName;
	}

	public void setBedName(String bedName) {
		this.bedName = bedName;
	}

	public String getPropertyFloorType() {
		return propertyFloorType;
	}

	public void setPropertyFloorType(String propertyFloorType) {
		this.propertyFloorType = propertyFloorType;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	/*
	 * public Double getBedCharge() { return bedCharge; }
	 * 
	 * 
	 * public void setBedCharge(Double bedCharge) { this.bedCharge = bedCharge; }
	 */
	public String getBedCharge() {
		return bedCharge;
	}

	public void setBedCharge(String bedCharge) {
		this.bedCharge = bedCharge;
	}

	public String getBedDescription() {
		return bedDescription;
	}

	public void setBedDescription(String bedDescription) {
		this.bedDescription = bedDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getBedAvailability() {
		return bedAvailability;
	}

	public void setBedAvailability(String bedAvailability) {
		this.bedAvailability = bedAvailability;
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
