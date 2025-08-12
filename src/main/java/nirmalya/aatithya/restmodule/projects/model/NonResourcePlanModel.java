package nirmalya.aatithya.restmodule.projects.model;

public class NonResourcePlanModel {

	private String projectId;
	private String nonResourceId;
	private String productId;
	private String productName;
	private String locationNonResource;
	private String nonResourceLocationName;
	private String nonResourceCostCenter;
	private String nonResourceCostCenterName;
	private String createdBy;
	private String createdOn;
	private Double unitCost;
	private Double noOfUnits;
	private Double totalAmount;
	
	
	public NonResourcePlanModel(Object projectId, Object nonResourceId, Object productId, Object productName,
			Object locationNonResource, Object nonResourceLocationName, Object nonResourceCostCenter,
			Object nonResourceCostCenterName,Object createdBy, Object createdOn, Object unitCost, Object noOfUnits, Object totalAmount) {
		super();
		this.projectId = (String) projectId;
		this.nonResourceId = (String) nonResourceId;
		this.productId = (String) productId;
		this.locationNonResource = (String) locationNonResource;
		this.nonResourceCostCenter = (String) nonResourceCostCenter;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.nonResourceLocationName = (String) nonResourceLocationName;
		this.nonResourceCostCenterName = (String) nonResourceCostCenterName;
		this.unitCost = (Double) unitCost;
		this.noOfUnits = (Double) noOfUnits;
		this.totalAmount = (Double) totalAmount;
		this.productName = (String) productName;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getNonResourceId() {
		return nonResourceId;
	}
	public void setNonResourceId(String nonResourceId) {
		this.nonResourceId = nonResourceId;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getLocationNonResource() {
		return locationNonResource;
	}
	public void setLocationNonResource(String locationNonResource) {
		this.locationNonResource = locationNonResource;
	}
	public String getNonResourceCostCenter() {
		return nonResourceCostCenter;
	}
	public void setNonResourceCostCenter(String nonResourceCostCenter) {
		this.nonResourceCostCenter = nonResourceCostCenter;
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
	public String getNonResourceLocationName() {
		return nonResourceLocationName;
	}
	public void setNonResourceLocationName(String nonResourceLocationName) {
		this.nonResourceLocationName = nonResourceLocationName;
	}
	public String getNonResourceCostCenterName() {
		return nonResourceCostCenterName;
	}
	public void setNonResourceCostCenterName(String nonResourceCostCenterName) {
		this.nonResourceCostCenterName = nonResourceCostCenterName;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public Double getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(Double noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
