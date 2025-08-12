package nirmalya.aatithya.restmodule.trial.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageFuelRestModel {
	
	private String fsid;
	private String vehicleregno;
	private String fsname;
	private String fscontact;
	private String vendorname;
	private String fromDate;
	private String toDate;
	private String startodo;
	private String endodo;
	private String totalododiff;
	private String fueltype;
	private String rfunit;
	private String uprice;
	private String createdBy;
	
	public String getFsid() {
		return fsid;
	}
	public void setFsid(String fsid) {
		this.fsid = fsid;
	}
	public String getVehicleregno() {
		return vehicleregno;
	}
	public void setVehicleregno(String vehicleregno) {
		this.vehicleregno = vehicleregno;
	}
	public String getFsname() {
		return fsname;
	}
	public void setFsname(String fsname) {
		this.fsname = fsname;
	}
	public String getFscontact() {
		return fscontact;
	}
	public void setFscontact(String fscontact) {
		this.fscontact = fscontact;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getStartodo() {
		return startodo;
	}
	public void setStartodo(String startodo) {
		this.startodo = startodo;
	}
	public String getEndodo() {
		return endodo;
	}
	public void setEndodo(String endodo) {
		this.endodo = endodo;
	}
	public String getTotalododiff() {
		return totalododiff;
	}
	public void setTotalododiff(String totalododiff) {
		this.totalododiff = totalododiff;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public String getRfunit() {
		return rfunit;
	}
	public void setRfunit(String rfunit) {
		this.rfunit = rfunit;
	}
	public String getUprice() {
		return uprice;
	}
	public void setUprice(String uprice) {
		this.uprice = uprice;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public ManageFuelRestModel() {
		super();
	}
	
	public ManageFuelRestModel (Object fsid, Object vehicleregno, Object fsname, Object fscontact, Object vendorname, Object fromDate, Object toDate, Object startodo, Object endodo, Object totalododiff, Object fueltype, Object rfunit, Object uprice)
	
	{
		super();
		this.fsid = (String) fsid;
		this.vehicleregno = (String) vehicleregno;
		this.fsname = (String) fsname;
		this.fscontact = (String) fscontact;
		this.vendorname = (String) vendorname;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		
		this.startodo = (String) startodo;
		this.endodo = (String) endodo;
		this.totalododiff = (String) totalododiff;
		this.fueltype = (String) fueltype;
		this.rfunit = (String) rfunit;
		this.uprice = (String) uprice;
		
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
