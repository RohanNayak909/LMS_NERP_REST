package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestProcurementStockDetailsModel {
	private String month;
	private Double requisition;
	private Double stockTransit;
	private Double stockHand;

	public RestProcurementStockDetailsModel() {
		super();
	}

	public RestProcurementStockDetailsModel(Object month, Object requisition, Object stockTransit, Object stockHand) {
		super();
		this.month = (String) month;
		this.requisition = (Double) requisition;
		this.stockTransit = (Double) stockTransit;
		this.stockHand = (Double) stockHand;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getRequisition() {
		return requisition;
	}

	public void setRequisition(Double requisition) {
		this.requisition = requisition;
	}

	public Double getStockTransit() {
		return stockTransit;
	}

	public void setStockTransit(Double stockTransit) {
		this.stockTransit = stockTransit;
	}

	public Double getStockHand() {
		return stockHand;
	}

	public void setStockHand(Double stockHand) {
		this.stockHand = stockHand;
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
