package nirmalya.aatithya.restmodule.productionplan.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestProductionPlanningmachineManpowerList {
	private String date;
	private String shift;
	private String macid;
	private String machineid;
	
	
	public RestProductionPlanningmachineManpowerList(Object date,
			Object shift, Object macid, Object machineid) {
		super();
		this.date = (String) date;
		this.shift = (String) shift;
		this.macid = (String) macid;
		this.machineid = (String) machineid;
		
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getMacid() {
		return macid;
	}

	public void setMacid(String macid) {
		this.macid = macid;
	}

	public String getMachineid() {
		return machineid;
	}

	public void setMachineid(String machineid) {
		this.machineid = machineid;
	}

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
