package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestStockAttributeModel {

	private String sizeId;
	private String binId;
	private String stockSize;
	private String stockQty;
	
	
	
	public String getSizeId() {
		return sizeId;
	}


	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}


	public String getBinId() {
		return binId;
	}


	public void setBinId(String binId) {
		this.binId = binId;
	}


	public String getStockSize() {
		return stockSize;
	}


	public void setStockSize(String stockSize) {
		this.stockSize = stockSize;
	}


	public String getStockQty() {
		return stockQty;
	}


	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}


	public RestStockAttributeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RestStockAttributeModel( Object sizeId, Object binId, Object stockSize, Object stockQty) {
		super();

		this.sizeId = (String) sizeId;
		this.binId = (String) binId;
		this.stockSize = (String) stockSize;
		this.stockQty = (String) stockQty;
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
