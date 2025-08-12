package nirmalya.aatithya.restmodule.common.utils;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MailConfigRestModel {

	String empName;
	String personalMail;

	public MailConfigRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPersonalMail() {
		return personalMail;
	}

	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
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

