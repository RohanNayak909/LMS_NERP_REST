package nirmalya.aatithya.restmodule.gatepass.model;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestGatePassDetailsModel {

	private String getPassEntryId;
	private String poNumber;
	private String entrydate;
	private String entryTime;
	private String vechileNo;
	private String driverName;
	private String driverMobile;
	private Double grossWeight;
	private String quantitybags;
	private String description;
	private String itemCategory;
	private String itemSubCategory;
	private String itemName;
	private String vendorQuantity;
	private String netQuantity;
	private Double itemWeight;
	private String createdBy;
	private String createdOn;
	private String OrganizationName;
	private String OrganizationDivision;
	private String itemCategoryName;
	private String itemSubCategoryName;
	private String getPassExitId;
	private String invoice;
	private String exitDate;
	private String exitTime;
	private String customerName;
	private String remarks;

	private String itemId;
	private String hsnCode;
	private Double quantity;
	private Double unitPrice;
	private Double discount;
	private Double gstRate;
	private Double lineTotal;
	private Double subTotal;
	private Double qIGST;
	private Double qCGST;
	private Double qSGST;
	private Double grandTotal;
	private Boolean taxType;
	private String sku;
	private String updatedOn;
	private String organization;
	private String orgDivision;
	private String unit;
	private Double pendingQuantity;
	private Double receivingQuantity;
	private Double receivedQuantity;
	private String unitName;
	private String returningQuantity;
	private String poId;
	private String vendorName;

	private String descItem;
	private String appoveStatus;

	private String transportName;
	private String lrNo;
	private String noOfWheel;
	private String dlNo;
	private String depoName;
	private String truckSeal;
	private String roadTax;
	private String insuranceDate;
	private String polutionDate;
	private String polutionNo;
	private String fitnessDate;
	private String dlDate;
	private String challanDate;
	private String challanNo;
	private String type;
	private String wheelerName;
	private String exitStatus;
	private String poExitNo;

	private String visitD;
	private String visitT;
	private String visitingName;
	private String visitingAddress;
	private String visitingPurpose;
	private String visitingTomeet;
	private String visitVn;
	private String visitingPassno;
	private String visitingMobile;
	private String image;
	private String withOutPo;
	private String withPo;
	private String poType;
	private String invoiceType;
	private String vendor;
	private String vendorName1;
	private String vendorId;

	private String totalPageno;
	private String inspectList;
	private String recieverName;
	private String transportCat;
	private String shippingId;

	List<InventoryVendorDocumentModel> documentList;

	// Multiple document Ag Grid Add

	private String slno;
	private String isEditDoc;
	private String docName;
	private String docType;
	private String dociURL;
	private List<String> documentFile = new ArrayList<String>();
	private String docView;
	List<RestGatePassDetailsModel> docList;

	List<RestGatePassDetailsModel> docDetails;

	public RestGatePassDetailsModel() {
		super();
	}

	// Document Method

	public RestGatePassDetailsModel(Object slno, Object docName, Object docType, Object docView) {
		super();
		this.slno = (String) slno;
		this.docName = (String) docName;
		this.docType = (String) docType;
		this.docView = (String) docView;

	}

	public RestGatePassDetailsModel(Object getPassEntryId, Object poNumber, Object entrydate, Object entryTime,
			Object transportName, Object vechileNo, Object driverName, Object driverMobile, Object lrNo,
			Object noOfWheel, Object createdBy, Object createdOn, Object organizationName, Object organizationDivision,
			Object appoveStatus, Object type, Object exitStatus, Object visitingName, Object visitingAddress,
			Object visitingPurpose, Object visitingTomeet, Object visitingPassno, Object image, Object vendorName1,
			Object totalPageno, Object inspectList) {
		super();
		this.getPassEntryId = (String) getPassEntryId;
		this.poNumber = (String) poNumber;
		this.entrydate = (String) entrydate;
		this.entryTime = (String) entryTime;
		this.transportName = (String) transportName;
		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;
		this.lrNo = (String) lrNo;
		this.noOfWheel = (String) noOfWheel;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.OrganizationName = (String) organizationName;
		this.OrganizationDivision = (String) organizationDivision;
		this.appoveStatus = (String) appoveStatus;
		this.type = (String) type;
		this.exitStatus = (String) exitStatus;
		this.visitingName = (String) visitingName;
		this.visitingAddress = (String) visitingAddress;
		this.visitingPurpose = (String) visitingPurpose;
		this.visitingTomeet = (String) visitingTomeet;
		this.visitingPassno = (String) visitingPassno;
		this.image = (String) image;
		this.vendorName1 = (String) vendorName1;
		this.totalPageno = (String) totalPageno;

		this.inspectList = (String) inspectList;
	}

	public RestGatePassDetailsModel(Object getPassExitId, Object poNumber, Object exitDate, Object exitTime,
			Object transportName, Object vechileNo, Object driverName, Object driverMobile,

			Object lrNo, Object noOfWheel, Object wheelerName, Object createdBy, Object createdOn,
			Object organizationName, Object organizationDivision, Object type, Object appoveStatus, Object image,
			Object totalPageno, Object vendorName1, Object visitingPassno, Object inspectList) {
		super();
		this.getPassExitId = (String) getPassExitId;
		this.poNumber = (String) poNumber;
		this.exitDate = (String) exitDate;
		this.exitTime = (String) exitTime;

		this.transportName = (String) transportName;
		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;

		this.lrNo = (String) lrNo;
		this.noOfWheel = (String) noOfWheel;
		this.wheelerName = (String) wheelerName;
		this.createdBy = (String) createdBy;

		this.createdOn = (String) createdOn;
		this.OrganizationName = (String) organizationName;
		this.OrganizationDivision = (String) organizationDivision;
		this.type = (String) type;
		this.appoveStatus = (String) appoveStatus;
		this.image = (String) image;

		this.totalPageno = (String) totalPageno;
		this.vendorName1 = null;
		this.visitingPassno = null;

		this.inspectList = (String) inspectList;

	}

	public RestGatePassDetailsModel(Object getPassExitId, Object poNumber, Object challanNo, Object exitDate,
			Object exitTime, Object vendorName, Object vechileNo, Object driverName, Object driverMobile,
			Object grossWeight, Object quantitybags, Object description, Object createdBy, Object createdOn,
			Object organizationName, Object organizationDivision, Object vendorId, Object invoice,
			Object appoveStatus) {
		super();
		this.getPassExitId = (String) getPassExitId;
		this.poNumber = (String) poNumber;
		this.challanNo = (String) challanNo;

		this.exitDate = (String) exitDate;
		this.exitTime = (String) exitTime;
		this.vendorName = (String) vendorName;

		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;

		this.grossWeight = (Double) grossWeight;
		this.quantitybags = (String) quantitybags;
		this.description = (String) description;

		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.OrganizationName = (String) organizationName;

		this.OrganizationDivision = (String) organizationDivision;
		this.vendorId = (String) vendorId;
		this.invoice = (String) invoice;
		this.appoveStatus = (String) appoveStatus;

	}

	public RestGatePassDetailsModel(Object getPassExitId, Object poNumber, Object challanNo, Object entrydate,
			Object entryTime, Object vendorName, Object vechileNo) {
		super();
		this.getPassExitId = (String) getPassExitId;
		this.poNumber = (String) poNumber;
		this.challanNo = (String) challanNo;
		this.entrydate = (String) entrydate;
		this.entryTime = (String) entryTime;
		this.vendorName = (String) vendorName;
		this.vechileNo = (String) vechileNo;

	}

	public RestGatePassDetailsModel(Object getPassExitId, Object poNumber) {
		super();
		this.getPassEntryId = (String) getPassEntryId;
		this.poNumber = (String) poNumber;

	}

	public RestGatePassDetailsModel(Object vendorId, Object vendorName1, Object poId, Object itemId, Object itemName,
			Object quantity, Object lineTotal, Object sku, Object createdBy, Object createdOn, Object hsnCode,
			Object unit, Object unitName, Object receivingQuantity, Object receivedQuantity, Object pendingQuantity) {
		super();
		this.vendorId = (String) vendorId;
		this.vendorName1 = (String) vendorName1;
		this.poId = (String) poId;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.quantity = (Double) quantity;
		this.lineTotal = (Double) lineTotal;
		this.sku = (String) sku;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.hsnCode = (String) hsnCode;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.receivingQuantity = (Double) receivingQuantity;
		this.receivedQuantity = (Double) receivedQuantity;
		this.pendingQuantity = (Double) pendingQuantity;

	}

	public RestGatePassDetailsModel(Object poId, Object itemId, Object itemName, Object quantity, Object lineTotal,
			Object sku, Object createdBy, Object hsnCode, Object unit, Object unitName, Object challanNo,
			Object challanDate, Object receivingQuantity, Object receivedQuantity, Object pendingQuantity) {
		super();
		this.poId = (String) poId;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.quantity = (Double) quantity;
		this.lineTotal = (Double) lineTotal;
		this.sku = (String) sku;
		this.createdBy = (String) createdBy;
		this.hsnCode = (String) hsnCode;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.challanNo = (String) challanNo;
		this.challanDate = (String) challanDate;
		this.receivingQuantity = (Double) receivingQuantity;
		this.receivedQuantity = (Double) receivedQuantity;
		this.pendingQuantity = (Double) pendingQuantity;

	}

	public RestGatePassDetailsModel(Object getPassEntryId, Object poNumber, Object entrydate, Object entryTime,
			Object vechileNo, Object driverName, Object driverMobile, Object transportName,

			Object lrNo, Object noOfWheel, Object wheelerName, Object dlNo,

			Object depoName, Object truckSeal, Object roadTax, Object insuranceDate,

			Object polutionDate, Object fitnessDate, Object dlDate, Object createdBy, Object createdOn,
			Object organizationName, Object organizationDivision, Object itemId,

			Object itemName, Object hsnCode, Object quantity, Object lineTotal, Object sku, Object unit,
			Object unitName, Object pendingQuantity,

			Object receivingQuantity, Object receivedQuantity, Object descItem, Object challanNo, Object challanDate,
			Object type, Object visitingName, Object visitingAddress, Object visitingPurpose, Object visitingTomeet,
			Object visitingPassno, Object visitingMobile, Object polutionNo, Object image, Object poType,
			Object vendorId, Object vendorName1, Object inspectList, Object recieverName, Object transportCat,
			Object remarks, Object appoveStatus) {
		super();
		this.getPassEntryId = (String) getPassEntryId;
		this.poNumber = (String) poNumber;
		this.entrydate = (String) entrydate;
		this.entryTime = (String) entryTime;

		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;
		this.transportName = (String) transportName;

		this.lrNo = (String) lrNo;
		this.noOfWheel = (String) noOfWheel;
		this.wheelerName = (String) wheelerName;
		this.dlNo = (String) dlNo;

		this.depoName = (String) depoName;
		this.truckSeal = (String) truckSeal;
		this.roadTax = (String) roadTax;
		this.insuranceDate = (String) insuranceDate;

		this.polutionDate = (String) polutionDate;
		this.fitnessDate = (String) fitnessDate;
		this.dlDate = (String) dlDate;
		this.createdBy = (String) createdBy;

		this.createdOn = (String) createdOn;
		this.OrganizationName = (String) organizationName;
		this.OrganizationDivision = (String) organizationDivision;
		this.itemId = (String) itemId;

		this.itemName = (String) itemName;
		this.hsnCode = (String) hsnCode;
		this.quantity = (Double) quantity;
		this.lineTotal = (Double) lineTotal;

		this.sku = (String) sku;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.pendingQuantity = (Double) pendingQuantity;

		this.receivingQuantity = (Double) receivingQuantity;
		this.receivedQuantity = (Double) receivedQuantity;
		this.descItem = (String) descItem;
		this.challanNo = (String) challanNo;
		this.challanDate = (String) challanDate;
		this.type = (String) type;
		this.visitingName = (String) visitingName;
		this.visitingAddress = (String) visitingAddress;
		this.visitingPurpose = (String) visitingPurpose;
		this.visitingTomeet = (String) visitingTomeet;
		this.visitingPassno = (String) visitingPassno;
		this.visitingMobile = (String) visitingMobile;

		this.polutionNo = (String) polutionNo;
		this.image = (String) image;
		this.poType = (String) poType;
		this.vendorId = (String) vendorId;
		this.vendorName1 = (String) vendorName1;

		this.inspectList = (String) inspectList;
		this.recieverName = (String) recieverName;
		this.transportCat = (String) transportCat;
		this.remarks = (String) remarks;
		this.appoveStatus = (String) appoveStatus;
	}

	public RestGatePassDetailsModel(Object getPassExitId, Object poNumber, Object exitDate, Object exitTime,
			Object vechileNo, Object driverName, Object driverMobile, Object transportName,

			Object lrNo, Object noOfWheel, Object wheelerName, Object dlNo,

			Object depoName, Object truckSeal, Object roadTax, Object insuranceDate,

			Object polutionDate, Object fitnessDate, Object dlDate, Object createdBy, Object createdOn, Object itemId,

			Object itemName, Object hsnCode, Object quantity, Object lineTotal, Object sku, Object unit,
			Object unitName, Object pendingQuantity,

			Object receivingQuantity, Object receivedQuantity, Object descItem, Object challanNo, Object challanDate,
			Object type, Object visitingName, Object visitingAddress, Object visitingPurpose, Object visitingTomeet,
			Object visitingPassno, Object visitingMobile, Object polutionNo, Object image, Object invoiceType,
			Object vendorName, Object customerName, Object inspectList, Object remarks) {
		super();
		this.getPassExitId = (String) getPassExitId;
		this.poNumber = (String) poNumber;
		this.exitDate = (String) exitDate;
		this.exitTime = (String) exitTime;

		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;
		this.transportName = (String) transportName;

		this.lrNo = (String) lrNo;
		this.noOfWheel = (String) noOfWheel;
		this.wheelerName = (String) wheelerName;
		this.dlNo = (String) dlNo;

		this.depoName = (String) depoName;
		this.truckSeal = (String) truckSeal;
		this.roadTax = (String) roadTax;
		this.insuranceDate = (String) insuranceDate;

		this.polutionDate = (String) polutionDate;
		this.fitnessDate = (String) fitnessDate;
		this.dlDate = (String) dlDate;
		this.createdBy = (String) createdBy;

		this.createdOn = (String) createdOn;

		this.itemId = (String) itemId;

		this.itemName = (String) itemName;
		this.hsnCode = (String) hsnCode;
		this.quantity = (Double) quantity;
		this.lineTotal = (Double) lineTotal;

		this.sku = (String) sku;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.pendingQuantity = (Double) pendingQuantity;

		this.receivingQuantity = (Double) receivingQuantity;
		this.receivedQuantity = (Double) receivedQuantity;
		this.descItem = (String) descItem;
		this.challanNo = (String) challanNo;
		this.challanDate = (String) challanDate;
		this.type = (String) type;

		this.visitingName = (String) visitingName;
		this.visitingAddress = (String) visitingAddress;
		this.visitingPurpose = (String) visitingPurpose;
		this.visitingTomeet = (String) visitingTomeet;
		this.visitingPassno = (String) visitingPassno;
		this.visitingMobile = (String) visitingMobile;
		this.polutionNo = (String) polutionNo;
		this.image = (String) image;
		this.invoiceType = (String) invoiceType;
		this.vendorName = (String) vendorName;
		this.customerName = (String) customerName;
		this.inspectList = (String) inspectList;
		this.remarks = (String) remarks;
	}

	public RestGatePassDetailsModel(Object getPassEntryId, Object poNumber, Object challanNo, Object exitDate,
			Object exitTime, Object vendorName, Object vechileNo, Object driverName, Object driverMobile,
			Object grossWeight, Object quantitybags, Object description, Object createdBy, Object createdOn,
			Object organizationName, Object organizationDivision, Object vendorId, Object invoice, Object itemId,
			Object itemName, Object hsnCode, Object quantity, Object lineTotal, Object sku, Object unit,
			Object unitName, Object pendingQuantity, Object receivingQuantity, Object receivedQuantity,
			Object descItem) {
		super();
		this.getPassEntryId = (String) getPassEntryId;
		this.poNumber = (String) poNumber;
		this.challanNo = (String) challanNo;
		this.exitDate = (String) exitDate;

		this.exitTime = (String) exitTime;
		this.vendorName = (String) vendorName;
		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;

		this.driverMobile = (String) driverMobile;
		this.grossWeight = (Double) grossWeight;
		this.quantitybags = (String) quantitybags;
		this.description = (String) description;

		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.OrganizationName = (String) organizationName;
		this.OrganizationDivision = (String) organizationDivision;

		this.vendorId = (String) vendorId;
		this.invoice = (String) invoice;

		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.hsnCode = (String) hsnCode;
		this.quantity = (Double) quantity;
		this.lineTotal = (Double) lineTotal;
		this.sku = (String) sku;
		this.unit = (String) unit;
		this.unitName = (String) unitName;
		this.pendingQuantity = (Double) pendingQuantity;
		this.receivingQuantity = (Double) receivingQuantity;
		this.receivedQuantity = (Double) receivedQuantity;
		this.descItem = (String) descItem;

	}

	public RestGatePassDetailsModel(Object getPassExitId, Object poNumber, Object challanNo, Object exitDate,
			Object exitTime, Object vendorName, Object vechileNo, Object driverName, Object driverMobile,
			Object grossWeight, Object quantitybags, Object description, Object itemCategoryName,
			Object itemSubCategoryName, Object itemName, Object vendorQuantity, Object netQuantity, Object itemWeight,
			Object invoice, Object createdBy) {
		super();
		this.getPassExitId = (String) getPassExitId;
		this.poNumber = (String) poNumber;
		this.challanNo = (String) challanNo;
		this.exitDate = (String) exitDate;
		this.exitTime = (String) exitTime;
		this.vendorName = (String) vendorName;
		this.vechileNo = (String) vechileNo;
		this.driverName = (String) driverName;
		this.driverMobile = (String) driverMobile;
		this.grossWeight = (Double) grossWeight;
		this.quantitybags = (String) quantitybags;
		this.description = (String) description;
		this.itemCategoryName = (String) itemCategoryName;
		this.itemSubCategoryName = (String) itemSubCategoryName;
		this.itemName = (String) itemName;
		this.vendorQuantity = (String) vendorQuantity;
		this.netQuantity = (String) netQuantity;
		this.itemWeight = (Double) itemWeight;
		this.invoice = (String) invoice;
		this.createdBy = (String) createdBy;

	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	public String getGetPassExitId() {
		return getPassExitId;
	}

	public void setGetPassExitId(String getPassExitId) {
		this.getPassExitId = getPassExitId;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getGetPassEntryId() {
		return getPassEntryId;
	}

	public void setGetPassEntryId(String getPassEntryId) {
		this.getPassEntryId = getPassEntryId;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVechileNo() {
		return vechileNo;
	}

	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobile() {
		return driverMobile;
	}

	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}

	public Double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getQuantitybags() {
		return quantitybags;
	}

	public void setQuantitybags(String quantitybags) {
		this.quantitybags = quantitybags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemSubCategory() {
		return itemSubCategory;
	}

	public void setItemSubCategory(String itemSubCategory) {
		this.itemSubCategory = itemSubCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getVendorQuantity() {
		return vendorQuantity;
	}

	public void setVendorQuantity(String vendorQuantity) {
		this.vendorQuantity = vendorQuantity;
	}

	public String getNetQuantity() {
		return netQuantity;
	}

	public void setNetQuantity(String netQuantity) {
		this.netQuantity = netQuantity;
	}

	public Double getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(Double itemWeight) {
		this.itemWeight = itemWeight;
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

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public String getOrganizationDivision() {
		return OrganizationDivision;
	}

	public void setOrganizationDivision(String organizationDivision) {
		OrganizationDivision = organizationDivision;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public String getItemSubCategoryName() {
		return itemSubCategoryName;
	}

	public void setItemSubCategoryName(String itemSubCategoryName) {
		this.itemSubCategoryName = itemSubCategoryName;
	}

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getqIGST() {
		return qIGST;
	}

	public void setqIGST(Double qIGST) {
		this.qIGST = qIGST;
	}

	public Double getqCGST() {
		return qCGST;
	}

	public void setqCGST(Double qCGST) {
		this.qCGST = qCGST;
	}

	public Double getqSGST() {
		return qSGST;
	}

	public void setqSGST(Double qSGST) {
		this.qSGST = qSGST;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPendingQuantity() {
		return pendingQuantity;
	}

	public void setPendingQuantity(Double pendingQuantity) {
		this.pendingQuantity = pendingQuantity;
	}

	public Double getReceivingQuantity() {
		return receivingQuantity;
	}

	public void setReceivingQuantity(Double receivingQuantity) {
		this.receivingQuantity = receivingQuantity;
	}

	public Double getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(Double receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getReturningQuantity() {
		return returningQuantity;
	}

	public void setReturningQuantity(String returningQuantity) {
		this.returningQuantity = returningQuantity;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getDescItem() {
		return descItem;
	}

	public void setDescItem(String descItem) {
		this.descItem = descItem;
	}

	public String getAppoveStatus() {
		return appoveStatus;
	}

	public void setAppoveStatus(String appoveStatus) {
		this.appoveStatus = appoveStatus;
	}

	public String getTransportName() {
		return transportName;
	}

	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public String getNoOfWheel() {
		return noOfWheel;
	}

	public void setNoOfWheel(String noOfWheel) {
		this.noOfWheel = noOfWheel;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	public String getDepoName() {
		return depoName;
	}

	public void setDepoName(String depoName) {
		this.depoName = depoName;
	}

	public String getTruckSeal() {
		return truckSeal;
	}

	public void setTruckSeal(String truckSeal) {
		this.truckSeal = truckSeal;
	}

	public String getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(String roadTax) {
		this.roadTax = roadTax;
	}

	public String getInsuranceDate() {
		return insuranceDate;
	}

	public void setInsuranceDate(String insuranceDate) {
		this.insuranceDate = insuranceDate;
	}

	public String getPolutionDate() {
		return polutionDate;
	}

	public void setPolutionDate(String polutionDate) {
		this.polutionDate = polutionDate;
	}

	public String getFitnessDate() {
		return fitnessDate;
	}

	public void setFitnessDate(String fitnessDate) {
		this.fitnessDate = fitnessDate;
	}

	public String getDlDate() {
		return dlDate;
	}

	public void setDlDate(String dlDate) {
		this.dlDate = dlDate;
	}

	public String getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(String challanDate) {
		this.challanDate = challanDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWheelerName() {
		return wheelerName;
	}

	public void setWheelerName(String wheelerName) {
		this.wheelerName = wheelerName;
	}

	public String getExitStatus() {
		return exitStatus;
	}

	public void setExitStatus(String exitStatus) {
		this.exitStatus = exitStatus;
	}

	public String getPoExitNo() {
		return poExitNo;
	}

	public void setPoExitNo(String poExitNo) {
		this.poExitNo = poExitNo;
	}

	public String getVisitD() {
		return visitD;
	}

	public void setVisitD(String visitD) {
		this.visitD = visitD;
	}

	public String getVisitT() {
		return visitT;
	}

	public void setVisitT(String visitT) {
		this.visitT = visitT;
	}

	public String getVisitingName() {
		return visitingName;
	}

	public void setVisitingName(String visitingName) {
		this.visitingName = visitingName;
	}

	public String getVisitingAddress() {
		return visitingAddress;
	}

	public void setVisitingAddress(String visitingAddress) {
		this.visitingAddress = visitingAddress;
	}

	public String getVisitingPurpose() {
		return visitingPurpose;
	}

	public void setVisitingPurpose(String visitingPurpose) {
		this.visitingPurpose = visitingPurpose;
	}

	public String getVisitingTomeet() {
		return visitingTomeet;
	}

	public void setVisitingTomeet(String visitingTomeet) {
		this.visitingTomeet = visitingTomeet;
	}

	public String getVisitVn() {
		return visitVn;
	}

	public void setVisitVn(String visitVn) {
		this.visitVn = visitVn;
	}

	public String getVisitingPassno() {
		return visitingPassno;
	}

	public void setVisitingPassno(String visitingPassno) {
		this.visitingPassno = visitingPassno;
	}

	public String getVisitingMobile() {
		return visitingMobile;
	}

	public void setVisitingMobile(String visitingMobile) {
		this.visitingMobile = visitingMobile;
	}

	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}

	public String getPolutionNo() {
		return polutionNo;
	}

	public void setPolutionNo(String polutionNo) {
		this.polutionNo = polutionNo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getWithOutPo() {
		return withOutPo;
	}

	public void setWithOutPo(String withOutPo) {
		this.withOutPo = withOutPo;
	}

	public String getWithPo() {
		return withPo;
	}

	public void setWithPo(String withPo) {
		this.withPo = withPo;
	}

	public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVendorName1() {
		return vendorName1;
	}

	public void setVendorName1(String vendorName1) {
		this.vendorName1 = vendorName1;
	}

	public String getTotalPageno() {
		return totalPageno;
	}

	public void setTotalPageno(String totalPageno) {
		this.totalPageno = totalPageno;
	}

	public String getInspectList() {
		return inspectList;
	}

	public void setInspectList(String inspectList) {
		this.inspectList = inspectList;
	}

	public String getRecieverName() {
		return recieverName;
	}

	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	public String getTransportCat() {
		return transportCat;
	}

	public void setTransportCat(String transportCat) {
		this.transportCat = transportCat;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSlno() {
		return slno;
	}

	public void setSlno(String slno) {
		this.slno = slno;
	}

	public String getIsEditDoc() {
		return isEditDoc;
	}

	public void setIsEditDoc(String isEditDoc) {
		this.isEditDoc = isEditDoc;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String doctype) {
		this.docType = doctype;
	}

	public String getDociURL() {
		return dociURL;
	}

	public void setDociURL(String dociURL) {
		this.dociURL = dociURL;
	}

	public List<String> getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(List<String> documentFile) {
		this.documentFile = documentFile;
	}

	public String getDocView() {
		return docView;
	}

	public void setDocView(String docView) {
		this.docView = docView;
	}

	public List<RestGatePassDetailsModel> getDocList() {
		return docList;
	}

	public void setDocList(List<RestGatePassDetailsModel> docList) {
		this.docList = docList;
	}

	public List<RestGatePassDetailsModel> getDocDetails() {
		return docDetails;
	}

	public void setDocDetails(List<RestGatePassDetailsModel> docDetails) {
		this.docDetails = docDetails;
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
