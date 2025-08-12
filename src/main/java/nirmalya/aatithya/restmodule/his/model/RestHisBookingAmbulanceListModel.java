package nirmalya.aatithya.restmodule.his.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHisBookingAmbulanceListModel {

	private String amublanceNo;
	private String driverId;
	private String driverName;
	private String type;
	private String availability;
	private String org;
	private String div;
	public String getAmublanceNo() {
		return amublanceNo;
	}
	public void setAmublanceNo(String amublanceNo) {
		this.amublanceNo = amublanceNo;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
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
