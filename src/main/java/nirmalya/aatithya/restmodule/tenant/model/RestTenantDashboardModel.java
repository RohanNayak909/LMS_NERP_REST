package nirmalya.aatithya.restmodule.tenant.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestTenantDashboardModel {
	private String month;

	private String latefee;

	private String rentfee;
	
	private String totalos;
	
	private String notice;
	
	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getLatefee() {
		return latefee;
	}

	public void setLatefee(String latefee) {
		this.latefee = latefee;
	}

	public String getRentfee() {
		return rentfee;
	}

	public void setRentfee(String rentfee) {
		this.rentfee = rentfee;
	}

	public	RestTenantDashboardModel() {
		super();
	}
	
	public	RestTenantDashboardModel( Object month, Object rentfee, Object latefee) {
		super();
		this.month = (String)month;
		this.rentfee = (String)rentfee;
		this.latefee = (String) latefee;
		
		
	}
	public	RestTenantDashboardModel( Object rentfee, Object latefee, Object totalos, Object notice) {
		super();
		
		this.rentfee = (String)rentfee;
		this.latefee = (String) latefee;
		this.totalos = (String)totalos;
		this.notice = (String) notice;
	}
		
		
	public	RestTenantDashboardModel( Object month, Object totalos){
		super();
		this.month = (String)month;
		this.totalos = (String) totalos;
		
		
	}
	

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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
