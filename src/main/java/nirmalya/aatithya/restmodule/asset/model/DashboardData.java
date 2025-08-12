package nirmalya.aatithya.restmodule.asset.model;

public class DashboardData {
	private String month;
	private String category;
	private double sumOfPrice;
	private Integer value;
	private Integer averageDay;
	private String key;
	private String subCategory;
	private String assetState;
	private String timeRange;
	private Integer scrapValue;

	// Constructor
	public DashboardData() {
	}

	// Getters and setters
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getSumOfPrice() {
		return sumOfPrice;
	}

	public void setSumOfPrice(double sumOfPrice) {
		this.sumOfPrice = sumOfPrice;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getAssetState() {
		return assetState;
	}

	public void setAssetState(String assetState) {
		this.assetState = assetState;
	}

	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}

	public Integer getScrapValue() {
		return scrapValue;
	}

	public void setScrapValue(Integer scrapValue) {
		this.scrapValue = scrapValue;
	}

	public Integer getAverageDay() {
		return averageDay;
	}

	public void setAverageDay(Integer averageDay) {
		this.averageDay = averageDay;
	}

}
