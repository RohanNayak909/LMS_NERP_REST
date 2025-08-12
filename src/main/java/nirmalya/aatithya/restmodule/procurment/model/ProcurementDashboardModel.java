package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProcurementDashboardModel {

	private String vendorId;
	private String vendorName;
	private String order;
	private String status;
	private String date;
	private Double amount;
	private String createdBy;
	private String sku;
	private String itemName;
	private Double modelId;
	private Double minStock;
	private String stocksInHand;
	private String requisitionId;
	private String description;
	private String type;
	private String priority;
	private String receivedDate;
	private String poStatus;
	private String expDate;
	private String age;
	private String vendName;
	private String billNum;
	private String baseAmt;
	private String amtPaid;
	private String state;
	private Double totalVendor;
	private Double totalStocks;
	private Double totalPo;
	private Double totalRequi;
	private Double totalIntransit;
	private Double receivedData;
	private Double returnData;
	private Double totalInventory;
	private Double totalStocksInHand;
	private Double totalStocksInTransit;
	private Double totalStock;
	private String requ;
	private String stockTransit;
	private String stockHand;

	private BigInteger totalImmediate;
	private BigInteger totalGeneral;
	private BigInteger totalHigh;

	private String dueDate;
	private String vendorNme;
	private String billNumber;
	private Double baseAmount;
	private String stateVendor;

	public ProcurementDashboardModel() {
		super();
	}

	public ProcurementDashboardModel(Object vendorId, Object vendorName, Object order, Object status, Object date,
			Object amount, Object CreatedBy, Object sku, Object itemName, Object modelId, Object minStock,
			Object stocksInHand, Object requisitionId, Object description, Object type, Object priority,
			Object receivedDate, Object poStatus, Object expDate, Object age, Object vendName, Object billNum,
			Object baseAmt, Object amtPaid, Object state, Object totalVendor, Object totalStocks, Object totalPo,
			Object totalRequi, Object totalIntransit, Object receivedData, Object returnData, Object totalInventory,
			Object totalStocksInHand, Object totalStocksInTransit, Object totalStock, Object totalImmediate,
			Object totalGeneral, Object totalHigh, Object dueDate, Object vendorNme, Object billNumber,
			Object baseAmount, Object stateVendor) {
		super();

		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.order = (String) order;
		this.status = (String) status;
		this.date = (String) date;
		this.amount = (Double) amount;
		this.createdBy = (String) createdBy;
		this.sku = (String) sku;
		this.itemName = (String) itemName;
		this.modelId = (Double) modelId;
		this.minStock = (Double) minStock;
		this.stocksInHand = (String) stocksInHand;

		this.requisitionId = (String) requisitionId;
		this.description = (String) description;
		this.type = (String) type;
		this.priority = (String) priority;
		this.receivedDate = (String) receivedDate;
		this.poStatus = (String) poStatus;

		this.expDate = (String) expDate;
		this.age = (String) age;
		this.vendName = (String) vendName;
		this.billNum = (String) billNum;
		this.baseAmt = (String) baseAmt;
		this.amtPaid = (String) amtPaid;
		this.state = (String) state;

		this.totalVendor = (Double) totalVendor;
		this.totalStocks = (Double) totalStocks;
		this.totalPo = (Double) totalPo;
		this.totalRequi = (Double) totalRequi;
		this.totalIntransit = (Double) totalIntransit;
		this.receivedData = (Double) receivedData;
		this.returnData = (Double) returnData;
		this.totalInventory = (Double) totalInventory;
		this.totalStocksInHand = (Double) totalStocksInHand;
		this.totalStocksInTransit = (Double) totalStocksInTransit;
		this.totalStock = (Double) totalStock;

		this.totalImmediate = (BigInteger) totalImmediate;
		this.totalGeneral = (BigInteger) totalGeneral;
		this.totalHigh = (BigInteger) totalHigh;

		this.dueDate = (String) dueDate;
		this.vendorNme = (String) vendorNme;
		this.billNumber = (String) billNumber;
		this.baseAmount = (Double) baseAmount;
		this.stateVendor = (String) stateVendor;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getModelId() {
		return modelId;
	}

	public void setModelId(Double modelId) {
		this.modelId = modelId;
	}

	public Double getMinStock() {
		return minStock;
	}

	public void setMinStock(Double minStock) {
		this.minStock = minStock;
	}

	public String getStocksInHand() {
		return stocksInHand;
	}

	public void setStocksInHand(String stocksInHand) {
		this.stocksInHand = stocksInHand;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getVendName() {
		return vendName;
	}

	public void setVendName(String vendName) {
		this.vendName = vendName;
	}

	public String getBillNum() {
		return billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public String getBaseAmt() {
		return baseAmt;
	}

	public void setBaseAmt(String baseAmt) {
		this.baseAmt = baseAmt;
	}

	public String getAmtPaid() {
		return amtPaid;
	}

	public void setAmtPaid(String amtPaid) {
		this.amtPaid = amtPaid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getTotalVendor() {
		return totalVendor;
	}

	public void setTotalVendor(Double totalVendor) {
		this.totalVendor = totalVendor;
	}

	public Double getTotalStocks() {
		return totalStocks;
	}

	public void setTotalStocks(Double totalStocks) {
		this.totalStocks = totalStocks;
	}

	public Double getTotalPo() {
		return totalPo;
	}

	public void setTotalPo(Double totalPo) {
		this.totalPo = totalPo;
	}

	public Double getTotalRequi() {
		return totalRequi;
	}

	public void setTotalRequi(Double totalRequi) {
		this.totalRequi = totalRequi;
	}

	public Double getTotalIntransit() {
		return totalIntransit;
	}

	public void setTotalIntransit(Double totalIntransit) {
		this.totalIntransit = totalIntransit;
	}

	public Double getReceivedData() {
		return receivedData;
	}

	public void setReceivedData(Double receivedData) {
		this.receivedData = receivedData;
	}

	public Double getReturnData() {
		return returnData;
	}

	public void setReturnData(Double returnData) {
		this.returnData = returnData;
	}

	public Double getTotalInventory() {
		return totalInventory;
	}

	public void setTotalInventory(Double totalInventory) {
		this.totalInventory = totalInventory;
	}

	public Double getTotalStocksInHand() {
		return totalStocksInHand;
	}

	public void setTotalStocksInHand(Double totalStocksInHand) {
		this.totalStocksInHand = totalStocksInHand;
	}

	public Double getTotalStocksInTransit() {
		return totalStocksInTransit;
	}

	public void setTotalStocksInTransit(Double totalStocksInTransit) {
		this.totalStocksInTransit = totalStocksInTransit;
	}

	public Double getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(Double totalStock) {
		this.totalStock = totalStock;
	}

	public String getRequ() {
		return requ;
	}

	public void setRequ(String requ) {
		this.requ = requ;
	}

	public String getStockTransit() {
		return stockTransit;
	}

	public void setStockTransit(String stockTransit) {
		this.stockTransit = stockTransit;
	}

	public String getStockHand() {
		return stockHand;
	}

	public void setStockHand(String stockHand) {
		this.stockHand = stockHand;
	}

	public BigInteger getTotalImmediate() {
		return totalImmediate;
	}

	public void setTotalImmediate(BigInteger totalImmediate) {
		this.totalImmediate = totalImmediate;
	}

	public BigInteger getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(BigInteger totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public BigInteger getTotalHigh() {
		return totalHigh;
	}

	public void setTotalHigh(BigInteger totalHigh) {
		this.totalHigh = totalHigh;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getVendorNme() {
		return vendorNme;
	}

	public void setVendorNme(String vendorNme) {
		this.vendorNme = vendorNme;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(Double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public String getStateVendor() {
		return stateVendor;
	}

	public void setStateVendor(String stateVendor) {
		this.stateVendor = stateVendor;
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
