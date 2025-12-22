package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ScopeMatrixRestModel {

	private String scopeid;
	private String scopeMatrixSlNo;
	private String scopeMatrixDesc;
	private String matrixSamudyam;
	private String matrixClient;
	private String scopeMatrixRemarks;
	private int slno;
	public ScopeMatrixRestModel() {
		super();
	}
	public ScopeMatrixRestModel(Object scopeMatrixSlNo, Object scopeMatrixDesc, Object matrixSamudyam, Object matrixClient,Object scopeMatrixRemarks) {
		super();
		this.scopeMatrixSlNo =(String)scopeMatrixSlNo;
		this.scopeMatrixDesc = (String)scopeMatrixDesc;
		this.matrixSamudyam = (String)matrixSamudyam;
		this.matrixClient = (String)matrixClient;
		this.scopeMatrixRemarks = (String)scopeMatrixRemarks;
		
	}
	public String getScopeid() {
		return scopeid;
	}


	public void setScopeid(String scopeid) {
		this.scopeid = scopeid;
	}


	public String getScopeMatrixSlNo() {
		return scopeMatrixSlNo;
	}


	public void setScopeMatrixSlNo(String scopeMatrixSlNo) {
		this.scopeMatrixSlNo = scopeMatrixSlNo;
	}


	public String getScopeMatrixDesc() {
		return scopeMatrixDesc;
	}


	public void setScopeMatrixDesc(String scopeMatrixDesc) {
		this.scopeMatrixDesc = scopeMatrixDesc;
	}


	public String getMatrixSamudyam() {
		return matrixSamudyam;
	}


	public void setMatrixSamudyam(String matrixSamudyam) {
		this.matrixSamudyam = matrixSamudyam;
	}


	public String getMatrixClient() {
		return matrixClient;
	}


	public void setMatrixClient(String matrixClient) {
		this.matrixClient = matrixClient;
	}


	public String getScopeMatrixRemarks() {
		return scopeMatrixRemarks;
	}
	public void setScopeMatrixRemarks(String scopeMatrixRemarks) {
		this.scopeMatrixRemarks = scopeMatrixRemarks;
	}
	
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
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
