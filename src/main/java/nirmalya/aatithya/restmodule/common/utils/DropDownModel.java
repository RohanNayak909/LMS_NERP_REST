/**
 * Defines menu dropdown class
 *
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class DropDownModel {
	private String key;

	private String name;

	private String code;

	private String data;
	private String id;

	private String createdBy;
	private String orgName;
	private String orgDivision;

	public DropDownModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DropDownModel(Object key, Object name) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DropDownModel(Object key, Object name, Object code) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.code = (String) code;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DropDownModel(Object key, Object name, Object code, Object data) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.code = (String) code;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.data = (String) data;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DropDownModel(Object key, Object name, Object code, Object data, Object id, Object createdBy) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.code = (String) code;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.data = (String) data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.id = (String) id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DropDownModel(Object key, Object name, Object code, Object data, Object id) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.code = (String) code;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.data = (String) data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.id = (String) id;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public DropDownModel(Object key, Object name, Object code, Object data, Object id, Object createdBy, Object orgName) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.code = (String) code;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.data = (String) data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.id = (String) id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.orgName = (String) orgName;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public DropDownModel(Object name) {
		super();
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgDivision() {
		return orgDivision;
	}

	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
