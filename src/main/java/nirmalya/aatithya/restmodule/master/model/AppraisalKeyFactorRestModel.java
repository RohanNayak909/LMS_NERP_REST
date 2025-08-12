package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class AppraisalKeyFactorRestModel {
	
	private String factorCategory;
	private String fromDate;
	private String toDate;
	
	private String slno;
	private String maxmark;
	private String factors;
	private String assementMark;
	private String selfAssesment;
	private String selfRemark;
	private String managerAssessmentRemark;
	private List<AppraisalKeyFactorRestModel> grid1List;
	private List<AppraisalKeyFactorRestModel> appraisalList;
	private String orgName;
	private String orgDiv;
	private String userId;
	private String categoryId;
	private String remarks;
	private String managerRemarks;
	private String financialyear;
	private String empid;
	private String assignid;
	
	
	
	public String getFactorCategory() {
		return factorCategory;
	}
	public void setFactorCategory(String factorCategory) {
		this.factorCategory = factorCategory;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getSlno() {
		return slno;
	}
	public void setSlno(String slno) {
		this.slno = slno;
	}
	public String getMaxmark() {
		return maxmark;
	}
	public void setMaxmark(String maxmark) {
		this.maxmark = maxmark;
	}
	public String getFactors() {
		return factors;
	}
	public void setFactors(String factors) {
		this.factors = factors;
	}
	public List<AppraisalKeyFactorRestModel> getGrid1List() {
		return grid1List;
	}
	public void setGrid1List(List<AppraisalKeyFactorRestModel> grid1List) {
		this.grid1List = grid1List;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrgDiv() {
		return orgDiv;
	}
	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
	}
	
	
	public String getSelfAssesment() {
		return selfAssesment;
	}
	public void setSelfAssesment(String selfAssesment) {
		this.selfAssesment = selfAssesment;
	}
	public List<AppraisalKeyFactorRestModel> getAppraisalList() {
		return appraisalList;
	}
	public void setAppraisalList(List<AppraisalKeyFactorRestModel> appraisalList) {
		this.appraisalList = appraisalList;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getAssementMark() {
		return assementMark;
	}
	public void setAssementMark(String assementMark) {
		this.assementMark = assementMark;
	}
	
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	public String getManagerRemarks() {
		return managerRemarks;
	}
	public void setManagerRemarks(String managerRemarks) {
		this.managerRemarks = managerRemarks;
	}
	
	
	public String getFinancialyear() {
		return financialyear;
	}
	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getAssignid() {
		return assignid;
	}
	public void setAssignid(String assignid) {
		this.assignid = assignid;
	}
	
	
	
	public String getSelfRemark() {
		return selfRemark;
	}
	public void setSelfRemark(String selfRemark) {
		this.selfRemark = selfRemark;
	}
	
	
	public String getManagerAssessmentRemark() {
		return managerAssessmentRemark;
	}
	public void setManagerAssessmentRemark(String managerAssessmentRemark) {
		this.managerAssessmentRemark = managerAssessmentRemark;
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
