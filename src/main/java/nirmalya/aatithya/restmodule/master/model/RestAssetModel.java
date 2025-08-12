package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.math.BigInteger;
import nirmalya.aatithya.restmodule.master.model.RestAssetModel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAssetModel {
	private String assetId;
	private String assetName;
	private String assetDesc;
	private String assetStatus;
	private String parentId;
	private String createdBy;
	private String assetLevel;
	private String parentName;
	private BigInteger nodeCount;

	public RestAssetModel() {
		super();
// TODO Auto-generated constructor stub
	}

	public RestAssetModel(Object assetId, Object assetName, Object assetDesc, Object assetStatus, Object parentId,
			Object createdBy, Object assetLevel, Object parentName, Object nodeCount) {
		super();
		this.assetId = (String) assetId;
		this.assetName = (String) assetName;
		this.assetDesc = (String) assetDesc;
		this.assetStatus = (String) assetStatus;
		this.parentId = (String) parentId;
		this.createdBy = (String) createdBy;
		this.assetLevel = (String) assetLevel;
		this.parentName = (String) parentName;
		this.nodeCount = (BigInteger) nodeCount;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetDesc() {
		return assetDesc;
	}

	public void setAssetDesc(String assetDesc) {
		this.assetDesc = assetDesc;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAssetLevel() {
		return assetLevel;
	}

	public void setAssetLevel(String assetLevel) {
		this.assetLevel = assetLevel;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public BigInteger getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(BigInteger nodeCount) {
		this.nodeCount = nodeCount;
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