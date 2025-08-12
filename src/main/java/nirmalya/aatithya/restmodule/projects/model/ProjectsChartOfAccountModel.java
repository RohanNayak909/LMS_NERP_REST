package nirmalya.aatithya.restmodule.projects.model;

public class ProjectsChartOfAccountModel {

	private String id;
	private String parentId;
	private String slNo;
	private String name;
	private String count;
	
	
	public ProjectsChartOfAccountModel(Object id, Object parentId, Object slNo, Object name, Object count) {
		super();
		this.id = (String) id;
		this.parentId = (String) parentId;
		this.slNo = (String) slNo;
		this.name = (String) name;
		this.count = (String) count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
