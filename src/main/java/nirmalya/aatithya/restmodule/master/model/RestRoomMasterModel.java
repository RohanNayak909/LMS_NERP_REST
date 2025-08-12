package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestRoomMasterModel {
	private Integer roomSlNO;
	private Integer roomCount;
	private String roomId;
	private String roomName;
	private String roomCode;
	private String roomType;
	private String category;
	private String itemName;
	private Double quantity;
	private String desc;
	private String configStatus;
	
	
	public RestRoomMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RestRoomMasterModel(Object roomSlNO, Object roomCount, Object roomId, Object roomName, Object roomCode,
			Object roomType, Object category, Object itemName, Object quantity, Object desc, Object configStatus) {
		super();
		this.roomSlNO = (Integer)roomSlNO;
		this.roomCount = (Integer)roomCount;
		this.roomId = (String)roomId;
		this.roomName = (String)roomName;
		this.roomCode = (String)roomCode;
		this.roomType = (String)roomType;
		this.category = (String)category;
		this.itemName = (String)itemName;
		this.quantity = (Double)quantity;
		this.desc =(String) desc;
		this.configStatus = (String)configStatus;
	}


	public Integer getRoomSlNO() {
		return roomSlNO;
	}


	public void setRoomSlNO(Integer roomSlNO) {
		this.roomSlNO = roomSlNO;
	}


	public Integer getRoomCount() {
		return roomCount;
	}


	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}


	public String getRoomId() {
		return roomId;
	}


	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}


	public String getRoomName() {
		return roomName;
	}


	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	public String getRoomCode() {
		return roomCode;
	}


	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getConfigStatus() {
		return configStatus;
	}


	public void setConfigStatus(String configStatus) {
		this.configStatus = configStatus;
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
