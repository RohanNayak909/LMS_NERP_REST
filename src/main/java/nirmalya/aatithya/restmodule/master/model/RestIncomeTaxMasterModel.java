package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestIncomeTaxMasterModel {
	private String organization;
	private String orgDivision;
 
	private String incomeId;
	private String incomeName;
	private String ifyearName;
	private String ifyear;
	private Double iminval;
	private Double imaxval;
	private String itax;
	private String incomeUpdatedBy;
	
	private String prId;
	private String pName;
	private String pyearName;
	private String pyear;
	private Double pminval;
	private Double pmaxval;
	private Double ptax;
	
	private String sId;
	private String sName;
	private String sdesc;
	private String status;
	
	public RestIncomeTaxMasterModel() {
		super();
	}
	
	public RestIncomeTaxMasterModel(Object sId, Object sName, Object sdesc, Object status) {
		super();
		this.sId = (String) sId;
		this.sName = (String) sName;
		this.sdesc = (String) sdesc;
		this.status = (String) status;
	}
	public RestIncomeTaxMasterModel( Object incomeId, Object incomeName,Object ifyearName, Object ifyear, Object iminval, Object imaxval,Object itax,Object incomeUpdatedBy) {
		super();
		this.incomeId = (String) incomeId;
		this.incomeName = (String) incomeName;
		this.ifyearName = (String) ifyearName;
		this.ifyear = (String) ifyear;
		this.iminval = (Double) iminval;
		this.imaxval = (Double) imaxval;
		this.itax = (String) itax;
		this.incomeUpdatedBy = (String) incomeUpdatedBy;
	}
	public RestIncomeTaxMasterModel(Object  prId ,Object pName, Object pyearName, Object pyear, Object pminval, Object pmaxval,Object ptax) {
		super();
		this.prId = (String) prId;
		this.pName = (String) pName;
		this.pyearName = (String) pyearName;
		this.pyear = (String) pyear ;
		this.pminval = (Double) pminval;
		this.pmaxval = (Double) pmaxval;
		this.ptax = (Double) ptax;
		
	}
	
	
	
	
	public String getIncomeUpdatedBy() {
		return incomeUpdatedBy;
	}

	public void setIncomeUpdatedBy(String incomeUpdatedBy) {
		this.incomeUpdatedBy = incomeUpdatedBy;
	}

	public String getIfyearName() {
		return ifyearName;
	}

	public void setIfyearName(String ifyearName) {
		this.ifyearName = ifyearName;
	}

	public String getPyearName() {
		return pyearName;
	}

	public void setPyearName(String pyearName) {
		this.pyearName = pyearName;
	}

	public String getPrId() {
		return prId;
	}

	public void setPrId(String prId) {
		this.prId = prId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getPyear() {
		return pyear;
	}

	public void setPyear(String pyear) {
		this.pyear = pyear;
	}
 

	public String getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}

	public String getIncomeName() {
		return incomeName;
	}

	public void setIncomeName(String incomeName) {
		this.incomeName = incomeName;
	}

	public String getIfyear() {
		return ifyear;
	}

	public void setIfyear(String ifyear) {
		this.ifyear = ifyear;
	}

 
	public Double getIminval() {
		return iminval;
	}

	public void setIminval(Double iminval) {
		this.iminval = iminval;
	}

	public Double getImaxval() {
		return imaxval;
	}

	public void setImaxval(Double imaxval) {
		this.imaxval = imaxval;
	}

	public String getItax() {
		return itax;
	}

	public void setItax(String itax) {
		this.itax = itax;
	}

	public Double getPminval() {
		return pminval;
	}

	public void setPminval(Double pminval) {
		this.pminval = pminval;
	}

	public Double getPmaxval() {
		return pmaxval;
	}

	public void setPmaxval(Double pmaxval) {
		this.pmaxval = pmaxval;
	}

	public Double getPtax() {
		return ptax;
	}

	public void setPtax(Double ptax) {
		this.ptax = ptax;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getSdesc() {
		return sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
