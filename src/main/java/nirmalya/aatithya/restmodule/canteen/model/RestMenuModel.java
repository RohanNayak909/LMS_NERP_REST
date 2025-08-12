package nirmalya.aatithya.restmodule.canteen.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class RestMenuModel {
    
	private String itemId;
	private String itemName;
	private String comboName;
	private String price;
	private String allPrice;
	private String categry;
	private String subcategry;
	private String variant;
	private String status;
	private String comboId;
	private String organization;
	private String orgDivision;
	
	private List<RestMenuModel> itemList;
	
	
	
	public RestMenuModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RestMenuModel(Object comboId , Object comboName ,Object allPrice ,Object itemName, Object itemId, Object price, Object categry ,Object subcategry,Object variant  ) {
		super();

		this.comboId = (String) comboId;
		this.comboName = (String) comboName;
		this.allPrice = (String) allPrice;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.price = (String) price;
		this.categry = (String) categry;
		this.subcategry = (String) subcategry;
		this.variant = (String) variant;
	}
	
	
	
	
    

	public RestMenuModel(Object categry, Object subcategry, Object variant,
			Object itemId, Object itemName,Object price,Object status) {
		super();

		this.categry = (String) categry;
		this.subcategry = (String) subcategry;
		this.variant = (String) variant;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.price = (String) price;
		this.status = (String) status;
	}
	
	
	public RestMenuModel(Object comboId, Object comboName,Object allPrice , Object status) {
		super();

		
		this.comboId = (String) comboId;
		this.comboName = (String) comboName;
		this.allPrice = (String) allPrice;
		this.status = (String) status;
		
	}
	public RestMenuModel(Object itemId, Object itemName,Object price ) {
		super();

		
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.price = (String) price;
		
	}
	
	public RestMenuModel(Object itemId, Object itemName) {
		super();

		
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		
		
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


	public String getComboId() {
		return comboId;
	}


	public void setComboId(String comboId) {
		this.comboId = comboId;
	}


	public List<RestMenuModel> getItemList() {
		return itemList;
	}


	public void setItemList(List<RestMenuModel> itemList) {
		this.itemList = itemList;
	}


	public String getComboName() {
		return comboName;
	}


	public void setComboName(String comboName) {
		this.comboName = comboName;
	}


	public String getAllPrice() {
		return allPrice;
	}


	public void setAllPrice(String allPrice) {
		this.allPrice = allPrice;
	}


	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategry() {
		return categry;
	}
	public void setCategry(String categry) {
		this.categry = categry;
	}
	public String getSubcategry() {
		return subcategry;
	}
	public void setSubcategry(String subcategry) {
		this.subcategry = subcategry;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
