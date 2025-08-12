package nirmalya.aatithya.restmodule.trial.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestStationwiseRefuellingModel {
	
	private String slId;
	private String vehicleRegId;
	private String fuelTypeId;
	private String quantityId;
	private String unitPriceId;
	private String fuelStationId;
	private Double ododmeterId;
	private String requisitionId;
	private Double lastOdodmeterId;
	
	public Double getLastOdodmeterId() {
		return lastOdodmeterId;
	}





	public void setLastOdodmeterId(Double lastOdodmeterId) {
		this.lastOdodmeterId = lastOdodmeterId;
	}





	public RestStationwiseRefuellingModel(Object slId, Object vehicleRegId, Object fuelTypeId, Object quantityId,
			Object unitPriceId, Object fuelStationId, Object ododmeterId, Object requisitionId , Object lastOdodmeterId) {
		
		super();
		
		this.slId = (String) slId;
		this.vehicleRegId =(String) vehicleRegId;
		this.fuelTypeId = (String) fuelTypeId;
		this.quantityId =(String) quantityId;
		this.unitPriceId = (String) unitPriceId;
		this.fuelStationId = (String) fuelStationId;
		this.ododmeterId = (Double) ododmeterId;
		this.requisitionId = (String) requisitionId;
		this.lastOdodmeterId = (Double) lastOdodmeterId; 
		
	}
	
	

	

	public String getSlId() {
		return slId;
	}
	public void setSlId(String slId) {
		this.slId = slId;
	}
	public String getVehicleRegId() {
		return vehicleRegId;
	}
	public void setVehicleRegId(String vehicleRegId) {
		this.vehicleRegId = vehicleRegId;
	}
	public String getFuelTypeId() {
		return fuelTypeId;
	}
	public void setFuelTypeId(String fuelTypeId) {
		this.fuelTypeId = fuelTypeId;
	}
	public String getQuantityId() {
		return quantityId;
	}
	public void setQuantityId(String quantityId) {
		this.quantityId = quantityId;
	}
	public String getUnitPriceId() {
		return unitPriceId;
	}
	public void setUnitPriceId(String unitPriceId) {
		this.unitPriceId = unitPriceId;
	}
	public String getFuelStationId() {
		return fuelStationId;
	}
	public void setFuelStationId(String fuelStationId) {
		this.fuelStationId = fuelStationId;
	}
	public Double getOdodmeterId() {
		return ododmeterId;
	}
	public void setOdodmeterId(Double ododmeterId) {
		this.ododmeterId = ododmeterId;
	}
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	
	
	

	public RestStationwiseRefuellingModel() {
		// TODO Auto-generated constructor stub
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
