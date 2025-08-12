package nirmalya.aatithya.restmodule.gatepass.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GatePassStaffRegisterModel {
	private String empId;
	private String date;
	private String punchType;
	private String punchInDateTime;
	private String punchInLocation;
	private String punchInLatitude;
	private String punchInLongitude;
	private String punchInNote;
	private String punchOutDateTime;
	private String punchOutLocation;
	private String punchOutLatitude;
	private String punchOutLongitude;
	private String punchOutNote;
	private String createdBy;
	private String organization;
	private String orgDivision;
	

	public GatePassStaffRegisterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPunchType() {
		return punchType;
	}

	public void setPunchType(String punchType) {
		this.punchType = punchType;
	}

	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPunchInDateTime() {
		return punchInDateTime;
	}


	public void setPunchInDateTime(String punchInDateTime) {
		this.punchInDateTime = punchInDateTime;
	}


	public String getPunchInLocation() {
		return punchInLocation;
	}


	public void setPunchInLocation(String punchInLocation) {
		this.punchInLocation = punchInLocation;
	}


	public String getPunchInLatitude() {
		return punchInLatitude;
	}


	public void setPunchInLatitude(String punchInLatitude) {
		this.punchInLatitude = punchInLatitude;
	}


	public String getPunchInLongitude() {
		return punchInLongitude;
	}


	public void setPunchInLongitude(String punchInLongitude) {
		this.punchInLongitude = punchInLongitude;
	}


	public String getPunchInNote() {
		return punchInNote;
	}


	public void setPunchInNote(String punchInNote) {
		this.punchInNote = punchInNote;
	}


	public String getPunchOutDateTime() {
		return punchOutDateTime;
	}


	public void setPunchOutDateTime(String punchOutDateTime) {
		this.punchOutDateTime = punchOutDateTime;
	}


	public String getPunchOutLocation() {
		return punchOutLocation;
	}


	public void setPunchOutLocation(String punchOutLocation) {
		this.punchOutLocation = punchOutLocation;
	}


	public String getPunchOutLatitude() {
		return punchOutLatitude;
	}


	public void setPunchOutLatitude(String punchOutLatitude) {
		this.punchOutLatitude = punchOutLatitude;
	}


	public String getPunchOutLongitude() {
		return punchOutLongitude;
	}


	public void setPunchOutLongitude(String punchOutLongitude) {
		this.punchOutLongitude = punchOutLongitude;
	}


	public String getPunchOutNote() {
		return punchOutNote;
	}


	public void setPunchOutNote(String punchOutNote) {
		this.punchOutNote = punchOutNote;
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
