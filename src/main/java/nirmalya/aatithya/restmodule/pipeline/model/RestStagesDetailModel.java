package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestStagesDetailModel {

	private String fromStageList;
	private String toStageList;
	private String createdDateList;
	private Integer pipelineType;
	private String createdBy;
	private String createdOn;
	private Boolean status;
	private String id;

	public RestStagesDetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestStagesDetailModel(Object fromStageList, Object toStageList, Object createdDateList, Object pipelineType,
			Object createdBy, Object createdOn, Object status, Object id) {
		super();
		try {
			this.fromStageList = (String) fromStageList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.toStageList = (String) toStageList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.createdDateList = (String) createdDateList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.pipelineType = (Integer) pipelineType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.createdOn = (String) createdOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.status = (Boolean) status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.id = (String) id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFromStageList() {
		return fromStageList;
	}

	public void setFromStageList(String fromStageList) {
		this.fromStageList = fromStageList;
	}

	public String getToStageList() {
		return toStageList;
	}

	public void setToStageList(String toStageList) {
		this.toStageList = toStageList;
	}

	public String getCreatedDateList() {
		return createdDateList;
	}

	public void setCreatedDateList(String createdDateList) {
		this.createdDateList = createdDateList;
	}

	public Integer getPipelineType() {
		return pipelineType;
	}

	public void setPipelineType(Integer pipelineType) {
		this.pipelineType = pipelineType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
