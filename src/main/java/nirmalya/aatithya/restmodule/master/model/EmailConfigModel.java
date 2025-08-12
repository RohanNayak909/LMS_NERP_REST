package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmailConfigModel {

	private String emailType;
	private String emailId;
	private String emailPassword;
	private String hostUrl;
	private String hostPort;
	private String createdBy;
	private String connectionId;
	private String usageName;
	
	public EmailConfigModel() {
		super();
	}

	public String getEmailType() {
		return emailType;
	}

	public EmailConfigModel(Object emailType, Object emailId, Object emailPassword, Object hostUrl, Object hostPort,
			Object createdBy, Object connectionId, Object usageName) {
		super();
		this.emailType = (String) emailType;
		this.emailId = (String) emailId;
		this.emailPassword = (String) emailPassword;
		this.hostUrl = (String) hostUrl;
		this.hostPort = (String) hostPort;
		this.createdBy = (String) createdBy;
		this.connectionId = (String) connectionId;
		this.usageName = (String) usageName;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public String getHostUrl() {
		return hostUrl;
	}

	public void setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
	}

	public String getHostPort() {
		return hostPort;
	}

	public void setHostPort(String hostPort) {
		this.hostPort = hostPort;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getUsageName() {
		return usageName;
	}

	public void setUsageName(String usageName) {
		this.usageName = usageName;
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
