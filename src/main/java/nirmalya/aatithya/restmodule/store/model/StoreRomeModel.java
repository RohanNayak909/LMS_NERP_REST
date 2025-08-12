package nirmalya.aatithya.restmodule.store.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class StoreRomeModel {
	private String warehouseId;
	private String zoneId;
	private String rackId;
	private String roomId;
	private String zoneCode;
	private String rackCode;
	private String roomCode;
	private String zoneName;
	private String rackName;
	private String roomName;
	private Integer zoneSlNo;
	private Integer rackSlNo;
	private Integer roomSlNO;
	private String roomType;
	private String createdBy;
	private String binlist;
	private String category;
	private String itemName;
	private Double quantity;
	private String desc;
	private String configStatus;
	private String organization;
	private String orgDivision;
	private String binId;
	private String categoryId;
	private String allocationId;
	private String batchNo;
	private String manufactureDate;
	private String manufacturePlace;
	private String shift;
	private String allocationStatus;
	private String batchNoType;
	private String batchDate;
	private String lineNo;
	private String packingSite;
	private String manufactureTime;
	private String bestBeforeDate;
	private String cldNo;
	private String vreificationId;
	private String unit;
	private String requestId;
	private String blockId;
	private String remarks;
	private String blockingBy;
	private String blockStatus;
	private String assignStatus;
	private Double binQuntity;
	private String slNoFrom;
	private String slNoTo;
	private String binRemark;
	private String blockQuntity;
	private String binBlockRemark;
	private String serialNoStock;
	private String batchId;
	private String approveStatus;
	private String oldBinId;
	private String newBinId;
	private List<RestStoreRoomMasterModel> roomlist;
	public StoreRomeModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StoreRomeModel(Object warehouseId, Object zoneId, Object rackId, Object roomId, Object zoneCode,
			 Object rackCode, Object roomCode, Object zoneName, Object rackName, Object roomName,
			Object zoneSlNo, Object rackSlNo, Object roomSlNO, Object configStatus, Object createdBy) {
		super();
		this.warehouseId =(String) warehouseId;
		this.zoneId =(String) zoneId;
		this.rackId =(String) rackId;
		this.roomId =(String) roomId;
		this.zoneCode =(String) zoneCode;
	
		this.rackCode =(String) rackCode;
		this.roomCode =(String) roomCode;
		this.zoneName = (String)zoneName;
		this.rackName =(String) rackName;
		this.roomName = (String)roomName;
		this.zoneSlNo =(Integer) zoneSlNo;
		this.rackSlNo =(Integer) rackSlNo;
		this.roomSlNO =(Integer) roomSlNO;
		this.configStatus =(String) configStatus;
		this.createdBy = (String)createdBy;
	}
	


	public StoreRomeModel(Object binlist,Object warehouseId, Object category, Object itemName, Object quantity, Object desc,Object unit) {
		super();
		this.binlist =(String) binlist;
		this.warehouseId =(String) warehouseId;
		this.category = (String)category;
		this.itemName = (String)itemName;
		this.quantity = (Double)quantity;
		this.desc = (String)desc;
		this.unit = (String)unit;
	}
	
	


	public StoreRomeModel(Object warehouseId, Object zoneId, Object rackId, Object roomId,
			 Object roomCode,Object roomName,
			 Object roomSlNO, Object roomType, Object createdBy,Object category,
			Object itemName, Object quantity, Object desc, Object configStatus) {
		super();
		this.warehouseId = (String)warehouseId;
		this.zoneId = (String)zoneId;
		this.rackId = (String)rackId;
		this.roomId = (String)roomId;
		
		this.roomCode = (String)roomCode;
		
		this.roomName = (String)roomName;
		
		this.roomSlNO = (Integer)roomSlNO;
		this.roomType = (String)roomType;
		this.createdBy = (String)createdBy;
	
		this.category = (String)category;
		this.itemName = (String)itemName;
		this.quantity = (Double)quantity;
		this.desc = (String)desc;
		this.configStatus = (String)configStatus;
		
	}


	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public String getOrgDivision() {
		return orgDivision;
	}


	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}


	public String getWarehouseId() {
		return warehouseId;
	}


	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}


	public String getZoneId() {
		return zoneId;
	}


	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}


	public String getRackId() {
		return rackId;
	}


	public void setRackId(String rackId) {
		this.rackId = rackId;
	}


	public String getRoomId() {
		return roomId;
	}


	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}


	public String getZoneCode() {
		return zoneCode;
	}


	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}



	public String getRackCode() {
		return rackCode;
	}


	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}


	public String getRoomCode() {
		return roomCode;
	}


	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}


	public String getZoneName() {
		return zoneName;
	}


	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}


	public String getRackName() {
		return rackName;
	}


	public void setRackName(String rackName) {
		this.rackName = rackName;
	}


	public String getRoomName() {
		return roomName;
	}


	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	public Integer getZoneSlNo() {
		return zoneSlNo;
	}


	public void setZoneSlNo(Integer zoneSlNo) {
		this.zoneSlNo = zoneSlNo;
	}


	public Integer getRackSlNo() {
		return rackSlNo;
	}


	public void setRackSlNo(Integer rackSlNo) {
		this.rackSlNo = rackSlNo;
	}


	public Integer getRoomSlNO() {
		return roomSlNO;
	}


	public void setRoomSlNO(Integer roomSlNO) {
		this.roomSlNO = roomSlNO;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getBinlist() {
		return binlist;
	}


	public void setBinlist(String binlist) {
		this.binlist = binlist;
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


	public List<RestStoreRoomMasterModel> getRoomlist() {
		return roomlist;
	}


	public void setRoomlist(List<RestStoreRoomMasterModel> roomlist) {
		this.roomlist = roomlist;
	}


	public String getBinId() {
		return binId;
	}


	public void setBinId(String binId) {
		this.binId = binId;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getAllocationId() {
		return allocationId;
	}


	public void setAllocationId(String allocationId) {
		this.allocationId = allocationId;
	}


	public String getBatchNo() {
		return batchNo;
	}


	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}


	public String getManufactureDate() {
		return manufactureDate;
	}


	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}


	public String getManufacturePlace() {
		return manufacturePlace;
	}


	public void setManufacturePlace(String manufacturePlace) {
		this.manufacturePlace = manufacturePlace;
	}


	public String getShift() {
		return shift;
	}


	public void setShift(String shift) {
		this.shift = shift;
	}


	public String getAllocationStatus() {
		return allocationStatus;
	}


	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}


	public String getBatchNoType() {
		return batchNoType;
	}


	public void setBatchNoType(String batchNoType) {
		this.batchNoType = batchNoType;
	}


	public String getBatchDate() {
		return batchDate;
	}


	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}


	public String getLineNo() {
		return lineNo;
	}


	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}


	public String getPackingSite() {
		return packingSite;
	}


	public void setPackingSite(String packingSite) {
		this.packingSite = packingSite;
	}


	public String getManufactureTime() {
		return manufactureTime;
	}


	public void setManufactureTime(String manufactureTime) {
		this.manufactureTime = manufactureTime;
	}


	public String getBestBeforeDate() {
		return bestBeforeDate;
	}


	public void setBestBeforeDate(String bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}


	public String getCldNo() {
		return cldNo;
	}


	public void setCldNo(String cldNo) {
		this.cldNo = cldNo;
	}


	public String getVreificationId() {
		return vreificationId;
	}


	public void setVreificationId(String vreificationId) {
		this.vreificationId = vreificationId;
	}
	
	


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getRequestId() {
		return requestId;
	}


	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}


	public String getBlockId() {
		return blockId;
	}


	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getBlockingBy() {
		return blockingBy;
	}


	public void setBlockingBy(String blockingBy) {
		this.blockingBy = blockingBy;
	}


	public String getBlockStatus() {
		return blockStatus;
	}


	public void setBlockStatus(String blockStatus) {
		this.blockStatus = blockStatus;
	}


	public String getAssignStatus() {
		return assignStatus;
	}


	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}


	public Double getBinQuntity() {
		return binQuntity;
	}


	public void setBinQuntity(Double binQuntity) {
		this.binQuntity = binQuntity;
	}


	public String getSlNoFrom() {
		return slNoFrom;
	}


	public void setSlNoFrom(String slNoFrom) {
		this.slNoFrom = slNoFrom;
	}


	public String getSlNoTo() {
		return slNoTo;
	}


	public void setSlNoTo(String slNoTo) {
		this.slNoTo = slNoTo;
	}


	public String getBinRemark() {
		return binRemark;
	}


	public void setBinRemark(String binRemark) {
		this.binRemark = binRemark;
	}


	public String getBlockQuntity() {
		return blockQuntity;
	}


	public void setBlockQuntity(String blockQuntity) {
		this.blockQuntity = blockQuntity;
	}


	public String getBinBlockRemark() {
		return binBlockRemark;
	}


	public void setBinBlockRemark(String binBlockRemark) {
		this.binBlockRemark = binBlockRemark;
	}


	public String getSerialNoStock() {
		return serialNoStock;
	}


	public void setSerialNoStock(String serialNoStock) {
		this.serialNoStock = serialNoStock;
	}


	public String getBatchId() {
		return batchId;
	}


	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}


	public String getApproveStatus() {
		return approveStatus;
	}


	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}


	public String getOldBinId() {
		return oldBinId;
	}


	public void setOldBinId(String oldBinId) {
		this.oldBinId = oldBinId;
	}


	public String getNewBinId() {
		return newBinId;
	}


	public void setNewBinId(String newBinId) {
		this.newBinId = newBinId;
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
