package nirmalya.aatithya.restmodule.recruitment.model;

public class ActionEmployeeDetailsModel {

	private String key;
	private String name;
	private String email;
	
	
	
	public ActionEmployeeDetailsModel(Object key, Object name, Object email) {
		super();
		this.key = (String) key;
		this.name = (String) name;
		this.email = (String) email;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
