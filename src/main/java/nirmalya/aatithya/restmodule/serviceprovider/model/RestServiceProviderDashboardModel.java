package nirmalya.aatithya.restmodule.serviceprovider.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestServiceProviderDashboardModel {
	
	private String month;

	private String billraised;

	private String billcleared;
	
	private String billpending;
	
	private String notice;
	
	
	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getBillpending() {
		return billpending;
	}

	public void setBillpending(String billpending) {
		this.billpending = billpending;
	}

	private String totalos;
	
	
	public	RestServiceProviderDashboardModel() {
		super();
	}
	
	public	RestServiceProviderDashboardModel( Object month, Object billraised, Object billcleared) {
		super();
		this.month = (String)month;
		this.billraised = (String) billraised;
		this.billcleared = (String)billcleared;
		
	}
	public	RestServiceProviderDashboardModel( Object month, Object totalos){
		super();
		this.month = (String)month;
		this.totalos = (String) totalos;
		
		
	}
	
	public	RestServiceProviderDashboardModel( Object billraised, Object billcleared, Object billpending, Object notice) {
		super();
		
		this.billraised = (String) billraised;
		this.billcleared = (String)billcleared;
		this.billpending = (String)billpending;
		this.notice = (String)notice;
		
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getBillraised() {
		return billraised;
	}

	public void setBillraised(String billraised) {
		this.billraised = billraised;
	}

	public String getBillcleared() {
		return billcleared;
	}

	public void setBillcleared(String billcleared) {
		this.billcleared = billcleared;
	}
	

	public String getTotalos() {
		return totalos;
	}

	public void setTotalos(String totalos) {
		this.totalos = totalos;
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
