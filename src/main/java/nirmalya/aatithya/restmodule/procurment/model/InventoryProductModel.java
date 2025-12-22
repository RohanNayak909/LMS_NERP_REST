package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryProductModel {
	private String sku;
	private String brand;
	private String itemName;
	private String itemId;
	private String model;
	private String itemCategoryId;
	private String itemCategoryName;
	private String uom;
	private String uomId;
	private String location;
	private String locationId;
	private String costCenter;
	private String costCenterId;
	private String createdBy;
	private String createdOn;
	private String updatedon;
	private String updatedBy;
	private Double unitPrice;
	private Double subTotalPrice;
	private Double discount;
	private String discountType;
	private Double tax;
	private Double taxAmt;
	private Double quantity;
	private Double shipping;
	private Double total;
	private Double maxValue;
	private String vendorName;
	private String vendorId;
	private String accountId;
	private String accountName;
	private Double qtyDelivered;
	private Double outstandQty;
	private Double invoiceQty;
	private Double receiveQty;
	private Double notReceivedQty;
	private Double returnQty;
	private String OrganizationName;
	private String OrganizationDivision;

	public InventoryProductModel() {
		super();
	}

	public InventoryProductModel(Object sku, Object brand, Object itemName, Object itemId, Object uom, Object location,
			Object quantity, Object qtyDelivered, Object outstandQty, Object locationId, Object uomId) {
		super();
		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.uom = (String) uom;
		this.location = (String) location;
		this.quantity = (Double) quantity;
		this.qtyDelivered = (Double) qtyDelivered;
		this.outstandQty = (Double) outstandQty;
		this.locationId = (String) locationId;
		this.uomId = (String) uomId;
	}

	public InventoryProductModel(Object sku, Object brand, Object itemName, Object itemId, Object model, Object uom,
			Object uomId, Object location, Object locationId, Object costCenter, Object costCenterId, Object createdBy,
			Object createdOn, Object unitPrice, Object subTotalPrice, Object discount, Object tax, Object quantity,
			Object shipping, Object total, Object maxValue, Object vendorName, Object vendorId) {
		super();
		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.model = (String) model;
		this.uom = (String) uom;
		this.uomId = (String) uomId;
		this.location = (String) location;
		this.locationId = (String) locationId;
		this.costCenter = (String) costCenter;
		this.costCenterId = (String) costCenterId;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.unitPrice = (Double) unitPrice;
		this.subTotalPrice = (Double) subTotalPrice;
		this.discount = (Double) discount;
		this.tax = (Double) tax;
		this.quantity = (Double) quantity;
		this.shipping = (Double) shipping;
		this.total = (Double) total;
		this.maxValue = (Double) maxValue;
		this.vendorName = (String) vendorName;
		this.vendorId = (String) vendorId;

	}

	public InventoryProductModel(Object sku, Object brand, Object itemName, Object itemId, Object model, Object uom,
			Object uomId, Object location, Object locationId, Object createdBy, Object createdOn, Object unitPrice,
			Object subTotalPrice, Object discount, Object tax, Object quantity, Object shipping, Object total,
			Object costCenter, Object costCenterId, Object accountName, Object accountId, Object discountType,
			Object taxAmt) {
		super();
		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.model = (String) model;
		this.uom = (String) uom;
		this.uomId = (String) uomId;
		this.location = (String) location;
		this.locationId = (String) locationId;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.unitPrice = (Double) unitPrice;
		this.subTotalPrice = (Double) subTotalPrice;
		this.discount = (Double) discount;
		this.tax = (Double) tax;
		this.quantity = (Double) quantity;
		this.shipping = (Double) shipping;
		this.total = (Double) total;
		this.costCenter = (String) costCenter;
		this.costCenterId = (String) costCenterId;
		this.accountName = (String) accountName;
		this.accountId = (String) accountId;
		this.discountType = (String) discountType;
		this.taxAmt = (Double) taxAmt;
	}

	public InventoryProductModel(Object sku, Object brand, Object itemName, Object itemId, Object model, Object uom,
			Object uomId, Object location, Object locationId, Object costCenter, Object costCenterId, Object createdBy,
			Object createdOn, Object unitPrice, Object subTotalPrice, Object discount, Object tax, Object quantity,
			Object shipping, Object total, Object maxValue, Object vendorName, Object vendorId,Object organizationName, Object organizationDivision) {
		super();
		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.model = (String) model;
		this.uom = (String) uom;
		this.uomId = (String) uomId;
		this.location = (String) location;
		this.locationId = (String) locationId;
		this.costCenter = (String) costCenter;
		this.costCenterId = (String) costCenterId;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.unitPrice = (Double) unitPrice;
		this.subTotalPrice = (Double) subTotalPrice;
		this.discount = (Double) discount;
		this.tax = (Double) tax;
		this.quantity = (Double) quantity;
		this.shipping = (Double) shipping;
		this.total = (Double) total;
		this.maxValue = (Double) maxValue;
		this.vendorName = (String) vendorName;
		this.vendorId = (String) vendorId;
		this.OrganizationName = (String)organizationName;
		this.OrganizationDivision = (String)organizationDivision;


	}
	public InventoryProductModel(Object sku, Object brand, Object itemName, Object itemId, Object uom, Object uomId,
			Object location, Object locationId, Object createdBy, Object createdOn, Object invoiceQty,
			Object qtyDelivered, Object receiveQty, Object notReceivedQty, Object outstandQty) {
		super();
		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.uom = (String) uom;
		this.uomId = (String) uomId;
		this.location = (String) location;
		this.locationId = (String) locationId;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.invoiceQty = (Double) invoiceQty;
		this.qtyDelivered = (Double) qtyDelivered;
		this.receiveQty = (Double) receiveQty;
		this.notReceivedQty = (Double) notReceivedQty;
		this.outstandQty = (Double) outstandQty;
	}

	public InventoryProductModel(Object sku, Object brand, Object itemName, Object itemId, Object returnQty,
			Object createdOn) {
		super();
		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.returnQty = (Double) returnQty;
		this.createdOn = (String) createdOn;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getModel() {
		return model;
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

	public void setModel(String model) {
		this.model = model;
	}

	public String getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(String itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(String costCenterId) {
		this.costCenterId = costCenterId;
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

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getSubTotalPrice() {
		return subTotalPrice;
	}

	public void setSubTotalPrice(Double subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getShipping() {
		return shipping;
	}

	public void setShipping(Double shipping) {
		this.shipping = shipping;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getQtyDelivered() {
		return qtyDelivered;
	}

	public void setQtyDelivered(Double qtyDelivered) {
		this.qtyDelivered = qtyDelivered;
	}

	public Double getOutstandQty() {
		return outstandQty;
	}

	public void setOutstandQty(Double outstandQty) {
		this.outstandQty = outstandQty;
	}

	public Double getInvoiceQty() {
		return invoiceQty;
	}

	public void setInvoiceQty(Double invoiceQty) {
		this.invoiceQty = invoiceQty;
	}

	public Double getReceiveQty() {
		return receiveQty;
	}

	public void setReceiveQty(Double receiveQty) {
		this.receiveQty = receiveQty;
	}

	public Double getNotReceivedQty() {
		return notReceivedQty;
	}

	public void setNotReceivedQty(Double notReceivedQty) {
		this.notReceivedQty = notReceivedQty;
	}

	public Double getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(Double returnQty) {
		this.returnQty = returnQty;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Double getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(Double taxAmt) {
		this.taxAmt = taxAmt;
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
