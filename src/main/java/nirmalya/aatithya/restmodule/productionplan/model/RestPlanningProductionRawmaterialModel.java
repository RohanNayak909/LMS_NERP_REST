package nirmalya.aatithya.restmodule.productionplan.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPlanningProductionRawmaterialModel {
	private String productid;
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	private String productname;
	private String prodqty;
	private String unit;
	public RestPlanningProductionRawmaterialModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestPlanningProductionRawmaterialModel(Object productname, Object prodqty, Object unit, Object productid) {
		super();
		this.productname = (String) productname;
		this.prodqty = (String) prodqty;
		this.unit = (String) unit;
		this.productid = (String) productid;
		
		
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProdqty() {
		return prodqty;
	}

	public void setProdqty(String prodqty) {
		this.prodqty = prodqty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

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
