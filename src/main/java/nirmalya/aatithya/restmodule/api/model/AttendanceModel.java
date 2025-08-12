package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AttendanceModel {

	private String tEmployee;
	private String tLocationid;
	private String tLocation;
	private String tAttndncDate;
	private String tAttndncPunchIn;
	private String tAttndncPunchInLoc;
	private String tAttndncPunchInLat;
	private String tAttndncPunchInLong;
	private String punchInDist;
	private String tAttndncPunchInNote;
	private String tAttndncPunchInLogin;
	private String tAttndncPunchOut;
	private String punchOutDist;
	private String tAttndncPunchOutNote;
	private String tAttndncPunchOut_Loc;
	private String tAttndncPunchOut_Lat;
	private String tAttndncPunchOut_Long;
	private String tAttndncPunchOutLogin;
	private String tAttndncType;
	private String tAttndncCreatedOn;
	private String tAttndncCreatedBy;
	private String tworkLocationId;
	private String locationType;
	private String locLoginType;
	private Boolean tAttndncPunchInStatus;
	private Boolean tAttndncPunchOutStatus;
	private String latitude;
	private String longitude;
	private String organization;
	private String orgDivision;
	private String attndncDistance;
	public AttendanceModel() {
		super();
	}

	public AttendanceModel(Object locationType, Object tAttndncPunchInLat, Object tAttndncPunchInLong,
			Object tAttndncPunchOut_Lat, Object tAttndncPunchOut_Long, Object tLocation, Object tAttndncPunchInStatus,
			Object tAttndncPunchOutStatus) {
		super();
		this.locationType = (String) locationType;
		this.tAttndncPunchInLat = (String) tAttndncPunchInLat;
		this.tAttndncPunchInLong = (String) tAttndncPunchInLong;
		this.tAttndncPunchOut_Lat = (String) tAttndncPunchOut_Lat;
		this.tAttndncPunchOut_Long = (String) tAttndncPunchOut_Long;
		this.tLocation = (String) tLocation;
		this.tAttndncPunchInStatus = (Boolean) tAttndncPunchInStatus;
		this.tAttndncPunchOutStatus = (Boolean) tAttndncPunchOutStatus;
	}

	public AttendanceModel(Object locationType, Object latitude, Object longitude, Object tLocation,
			Object tAttndncPunchInStatus, Object tAttndncPunchOutStatus,Object attndncDistance) {
		super();
		this.locationType = (String) locationType;
		this.latitude = (String) latitude;
		this.longitude = (String) longitude;
		this.tLocation = (String) tLocation;
		this.tAttndncPunchInStatus = (Boolean) tAttndncPunchInStatus;
		this.tAttndncPunchOutStatus = (Boolean) tAttndncPunchOutStatus;
		this.attndncDistance = (String) attndncDistance;
	}

	public String gettEmployee() {
		return tEmployee;
	}

	public void settEmployee(String tEmployee) {
		this.tEmployee = tEmployee;
	}

	public String gettAttndncDate() {
		return tAttndncDate;
	}

	public void settAttndncDate(String tAttndncDate) {
		this.tAttndncDate = tAttndncDate;
	}

	public String gettAttndncPunchIn() {
		return tAttndncPunchIn;
	}

	public void settAttndncPunchIn(String tAttndncPunchIn) {
		this.tAttndncPunchIn = tAttndncPunchIn;
	}

	public String gettAttndncPunchInNote() {
		return tAttndncPunchInNote;
	}

	public void settAttndncPunchInNote(String tAttndncPunchInNote) {
		this.tAttndncPunchInNote = tAttndncPunchInNote;
	}

	public String gettAttndncPunchOut() {
		return tAttndncPunchOut;
	}

	public void settAttndncPunchOut(String tAttndncPunchOut) {
		this.tAttndncPunchOut = tAttndncPunchOut;
	}

	public String gettAttndncPunchOutNote() {
		return tAttndncPunchOutNote;
	}

	public void settAttndncPunchOutNote(String tAttndncPunchOutNote) {
		this.tAttndncPunchOutNote = tAttndncPunchOutNote;
	}

	public String gettAttndncType() {
		return tAttndncType;
	}

	public void settAttndncType(String tAttndncType) {
		this.tAttndncType = tAttndncType;
	}

	public String gettAttndncCreatedOn() {
		return tAttndncCreatedOn;
	}

	public void settAttndncCreatedOn(String tAttndncCreatedOn) {
		this.tAttndncCreatedOn = tAttndncCreatedOn;
	}

	public String gettAttndncCreatedBy() {
		return tAttndncCreatedBy;
	}

	public void settAttndncCreatedBy(String tAttndncCreatedBy) {
		this.tAttndncCreatedBy = tAttndncCreatedBy;
	}

	public String gettLocation() {
		return tLocation;
	}

	public void settLocation(String tLocation) {
		this.tLocation = tLocation;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public Boolean gettAttndncPunchInStatus() {
		return tAttndncPunchInStatus;
	}

	public void settAttndncPunchInStatus(Boolean tAttndncPunchInStatus) {
		this.tAttndncPunchInStatus = tAttndncPunchInStatus;
	}

	public Boolean gettAttndncPunchOutStatus() {
		return tAttndncPunchOutStatus;
	}

	public void settAttndncPunchOutStatus(Boolean tAttndncPunchOutStatus) {
		this.tAttndncPunchOutStatus = tAttndncPunchOutStatus;
	}

	public String gettLocationid() {
		return tLocationid;
	}

	public void settLocationid(String tLocationid) {
		this.tLocationid = tLocationid;
	}

	public String getLocLoginType() {
		return locLoginType;
	}

	public void setLocLoginType(String locLoginType) {
		this.locLoginType = locLoginType;
	}

	public String getTworkLocationId() {
		return tworkLocationId;
	}

	public void setTworkLocationId(String tworkLocationId) {
		this.tworkLocationId = tworkLocationId;
	}

	public String gettAttndncPunchInLat() {
		return tAttndncPunchInLat;
	}

	public void settAttndncPunchInLat(String tAttndncPunchInLat) {
		this.tAttndncPunchInLat = tAttndncPunchInLat;
	}

	public String gettAttndncPunchInLong() {
		return tAttndncPunchInLong;
	}

	public void settAttndncPunchInLong(String tAttndncPunchInLong) {
		this.tAttndncPunchInLong = tAttndncPunchInLong;
	}

	public String gettAttndncPunchOut_Lat() {
		return tAttndncPunchOut_Lat;
	}

	public void settAttndncPunchOut_Lat(String tAttndncPunchOut_Lat) {
		this.tAttndncPunchOut_Lat = tAttndncPunchOut_Lat;
	}

	public String gettAttndncPunchOut_Long() {
		return tAttndncPunchOut_Long;
	}

	public void settAttndncPunchOut_Long(String tAttndncPunchOut_Long) {
		this.tAttndncPunchOut_Long = tAttndncPunchOut_Long;
	}

	public String gettAttndncPunchInLoc() {
		return tAttndncPunchInLoc;
	}

	public void settAttndncPunchInLoc(String tAttndncPunchInLoc) {
		this.tAttndncPunchInLoc = tAttndncPunchInLoc;
	}

	public String gettAttndncPunchOut_Loc() {
		return tAttndncPunchOut_Loc;
	}

	public void settAttndncPunchOut_Loc(String tAttndncPunchOut_Loc) {
		this.tAttndncPunchOut_Loc = tAttndncPunchOut_Loc;
	}

	public String gettAttndncPunchInLogin() {
		return tAttndncPunchInLogin;
	}

	public void settAttndncPunchInLogin(String tAttndncPunchInLogin) {
		this.tAttndncPunchInLogin = tAttndncPunchInLogin;
	}

	public String gettAttndncPunchOutLogin() {
		return tAttndncPunchOutLogin;
	}

	public void settAttndncPunchOutLogin(String tAttndncPunchOutLogin) {
		this.tAttndncPunchOutLogin = tAttndncPunchOutLogin;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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

	public String getPunchInDist() {
		return punchInDist;
	}

	public void setPunchInDist(String punchInDist) {
		this.punchInDist = punchInDist;
	}

	public String getPunchOutDist() {
		return punchOutDist;
	}

	public void setPunchOutDist(String punchOutDist) {
		this.punchOutDist = punchOutDist;
	}

	public String getAttndncDistance() {
		return attndncDistance;
	}

	public void setAttndncDistance(String attndncDistance) {
		this.attndncDistance = attndncDistance;
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
