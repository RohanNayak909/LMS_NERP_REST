package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductMasterModel {

	private String productId;
	private String productName;
	private String brand;
	private String mode;
	private String hsnCode;
	private String sicCode;
	private String productStatus;
	private String createdBy;
	private String productCategoryText;
	private List<String> imgList;
	private List<String> imgName = new ArrayList<String>();
	private String skuId;
	private String model;
	private String unit;
	private Double purchasePrice;
	private Double salePrice;
	private String createdDate;
	private String manufacture;
	private String variationType;
	private String variationValue;
	private String OrganizationName;
	private String OrganizationDivision;
	private String pImgName;
	private String brandId;
	private String brandName;
	private String brandDesc;
	private String deptId;
	private String deptName;
	private String deptDesc;
	private String parentCategory;
	private String productCategory;
	private String subcategory;

	public ProductMasterModel() {
		super();
	}

	public ProductMasterModel(Object productId, Object productName, Object brand, Object mode, Object productStatus,
			Object productCategory, Object hsnCode, Object sicCode, Object createdBy, Object createdDate,
			Object skuId,Object subcategory) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.brand = (String) brand;
		this.mode = (String) mode;
		this.productStatus = (String) productStatus;
		this.productCategory = (String) productCategory;
		this.hsnCode = (String) hsnCode;
		this.sicCode = (String) sicCode;
		this.createdBy = (String) createdBy;
		this.createdDate = (String) createdDate;
		this.skuId = (String) skuId;
		this.subcategory = (String) subcategory;
	}
	
	public ProductMasterModel(Object productId, Object productName, Object brand, Object mode, Object productStatus,
			Object productCategoryText, Object hsnCode, Object sicCode, Object createdBy, Object createdDate,
			Object skuId,Object productCategory,Object subcategory) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.brand = (String) brand;
		this.mode = (String) mode;
		this.productStatus = (String) productStatus;
		this.productCategoryText = (String) productCategoryText;
		this.hsnCode = (String) hsnCode;
		this.sicCode = (String) sicCode;
		this.createdBy = (String) createdBy;
		this.createdDate = (String) createdDate;
		this.skuId = (String) skuId;
		this.productCategory = (String) productCategory;
		this.subcategory = (String) subcategory;
	}

	public ProductMasterModel(Object productId, Object productName, Object brand, Object mode, Object hsnCode,
			Object sicCode, Object productStatus, Object productCategory, Object createdBy, Object productCategoryText,
			Object skuId, Object model, Object unit, Object purchasePrice, Object salePrice, Object createdDate,
			Object manufacture, Object variationType, Object variationValue, Object organizationName,
			Object organizationDivision, Object pImgName) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.brand = (String) brand;
		this.mode = (String) mode;
		this.hsnCode = (String) hsnCode;
		this.sicCode = (String) sicCode;
		this.productStatus = (String) productStatus;
		this.productCategory = (String) productCategory;
		this.createdBy = (String) createdBy;
		this.productCategoryText = (String) productCategoryText;
		this.skuId = (String) skuId;
		this.model = (String) model;
		this.unit = (String) unit;
		this.purchasePrice = (Double) purchasePrice;
		this.salePrice = (Double) salePrice;
		this.createdDate = (String) createdDate;
		this.manufacture = (String) manufacture;
		this.variationType = (String) variationType;
		this.variationValue = (String) variationValue;
		this.OrganizationName = (String) organizationName;
		this.OrganizationDivision = (String) organizationDivision;
		this.pImgName = (String) pImgName;
	}
	
	
	public ProductMasterModel(Object productId, Object productName, Object brand, Object mode, Object hsnCode,
			Object sicCode, Object productStatus, Object productCategory, Object createdBy, Object productCategoryText,Object pImgName,Object parentCategory,Object subcategory,Object organizationName) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.brand = (String) brand;
		this.mode = (String) mode;
		this.hsnCode = (String) hsnCode;
		this.sicCode = (String) sicCode;
		this.productStatus = (String) productStatus;
		this.productCategory = (String) productCategory;
		this.createdBy = (String) createdBy;
		this.productCategoryText = (String) productCategoryText;
		this.pImgName = (String) pImgName;
		this.parentCategory = (String) parentCategory;
		this.subcategory = (String) subcategory;
		this.OrganizationName = (String) organizationName;
	}

	public ProductMasterModel(Object productId, Object productName, Object brand, Object mode, Object hsnCode,
			Object sicCode, Object productStatus, Object productCategory, Object createdBy, Object productCategoryText,
			Object skuId, Object model, Object unit, Object purchasePrice, Object salePrice, Object createdDate,
			Object manufacture, Object variationType, Object variationValue, Object organizationName,
			Object organizationDivision, Object pImgName,Object parentCategory,Object subcategory) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.brand = (String) brand;
		this.mode = (String) mode;
		this.hsnCode = (String) hsnCode;
		this.sicCode = (String) sicCode;
		this.productStatus = (String) productStatus;
		this.productCategory = (String) productCategory;
		this.createdBy = (String) createdBy;
		this.productCategoryText = (String) productCategoryText;
		this.skuId = (String) skuId;
		this.model = (String) model;
		this.unit = (String) unit;
		this.purchasePrice = (Double) purchasePrice;
		this.salePrice = (Double) salePrice;
		this.createdDate = (String) createdDate;
		this.manufacture = (String) manufacture;
		this.variationType = (String) variationType;
		this.variationValue = (String) variationValue;
		this.OrganizationName = (String) organizationName;
		this.OrganizationDivision = (String) organizationDivision;
		this.pImgName = (String) pImgName;
		this.parentCategory = (String) parentCategory;
		this.subcategory = (String) subcategory;
	}
	public ProductMasterModel(Object productId, Object productName, Object brand, Object mode, Object productStatus,
			Object productCategoryText, Object hsnCode, Object sicCode, Object createdBy, Object createdDate) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.brand = (String) brand;
		this.mode = (String) mode;
		this.productStatus = (String) productStatus;
		this.productCategoryText = (String) productCategoryText;
		this.hsnCode = (String) hsnCode;
		this.sicCode = (String) sicCode;
		this.createdBy = (String) createdBy;
		this.createdDate = (String) createdDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getSicCode() {
		return sicCode;
	}

	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProductCategoryText() {
		return productCategoryText;
	}

	public void setProductCategoryText(String productCategoryText) {
		this.productCategoryText = productCategoryText;
	}

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	public List<String> getImgName() {
		return imgName;
	}

	public void setImgName(List<String> imgName) {
		this.imgName = imgName;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getVariationType() {
		return variationType;
	}

	public void setVariationType(String variationType) {
		this.variationType = variationType;
	}

	public String getVariationValue() {
		return variationValue;
	}

	public void setVariationValue(String variationValue) {
		this.variationValue = variationValue;
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

	public String getpImgName() {
		return pImgName;
	}

	public void setpImgName(String pImgName) {
		this.pImgName = pImgName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandDesc() {
		return brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
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
