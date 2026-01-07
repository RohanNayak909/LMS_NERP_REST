package nirmalya.aatithya.restmodule.procurment.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestProcurementPoRecptModel {

	private String month;
	private BigInteger immediate;
	private BigInteger general;
	private BigInteger high;

	public RestProcurementPoRecptModel() {
		super();
	}

	public RestProcurementPoRecptModel(Object month, Object immediate, Object general, Object high) {
		super();
		this.month = (String) month;
		this.immediate = (BigInteger) immediate;
		this.general = (BigInteger) general;
		this.high = (BigInteger) high;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	

	

	

	public BigInteger getImmediate() {
		return immediate;
	}

	public void setImmediate(BigInteger immediate) {
		this.immediate = immediate;
	}

	public BigInteger getGeneral() {
		return general;
	}

	public void setGeneral(BigInteger general) {
		this.general = general;
	}

	public BigInteger getHigh() {
		return high;
	}

	public void setHigh(BigInteger high) {
		this.high = high;
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
