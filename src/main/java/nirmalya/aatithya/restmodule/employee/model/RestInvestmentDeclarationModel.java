package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
public class RestInvestmentDeclarationModel {
	private String declarId;
	private String userId;
	private String headerid;
	private String financialyr;
	private String empId;
	private String empName;
	private String deptName;
	private String subDeptName;
	private String subheader;
	private List<InvestDeclareSubModel> investmentDetails;
	private List<InvestDeclareSubModel> investDetails;
	private String docName;
	private String docFile;
	private String docFile1;
	private String extension;
	private String organization;
	private String orgDiv;
	private String fromDate;
	private String toDate;
	
	public RestInvestmentDeclarationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestInvestmentDeclarationModel(String headerid) {
		super();
		this.headerid = (String)headerid;
	}

	public RestInvestmentDeclarationModel(Object userId,
			Object subheader) {
		super();
		this.userId = (String)userId;
		this.subheader = (String)subheader;
	}
	
	
	public RestInvestmentDeclarationModel(Object headerid,Object declarId, Object financialyr, Object empId,Object empName,
			Object subheader, Object docName, Object docFile,Object docFile1) {
		super();
		this.headerid = (String)headerid;
		this.declarId = (String)declarId;
		this.financialyr =(String) financialyr;
		this.empId =(String) empId;
		this.empName =(String) empName;
		this.subheader =(String) subheader;
		this.docName =(String) docName;
		this.docFile =(String) docFile;
		this.docFile1 =(String) docFile1;
	}
	
	
	public RestInvestmentDeclarationModel(Object declarId, Object financialyr, Object empId, Object empName,Object deptName,Object subDeptName) {
		super();
		this.declarId = (String)declarId;
		this.financialyr =(String) financialyr;
		this.empId = (String)empId;
		this.empName = (String)empName;
		this.deptName = (String)deptName;
		this.subDeptName = (String)subDeptName;
	}
	
	public String getDeclarId() {
		return declarId;
	}
	public void setDeclarId(String declarId) {
		this.declarId = declarId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getHeaderid() {
		return headerid;
	}
	public void setHeaderid(String headerid) {
		this.headerid = headerid;
	}

	public String getFinancialyr() {
		return financialyr;
	}
	public void setFinancialyr(String financialyr) {
		this.financialyr = financialyr;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public List<InvestDeclareSubModel> getInvestmentDetails() {
		return investmentDetails;
	}
	public void setInvestmentDetails(List<InvestDeclareSubModel> investmentDetails) {
		this.investmentDetails = investmentDetails;
	}
	public List<InvestDeclareSubModel> getInvestDetails() {
		return investDetails;
	}
	public void setInvestDetails(List<InvestDeclareSubModel> investDetails) {
		this.investDetails = investDetails;
	}
	
	public String getSubheader() {
		return subheader;
	}
	public void setSubheader(String subheader) {
		this.subheader = subheader;
	}
	
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	public String getDocFile() {
		return docFile;
	}
	public void setDocFile(String docFile) {
		this.docFile = docFile;
	}
	
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getOrgDiv() {
		return orgDiv;
	}
	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
	}
	
	public String getSubDeptName() {
		return subDeptName;
	}
	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
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
	public String getDocFile1() {
		return docFile1;
	}
	public void setDocFile1(String docFile1) {
		this.docFile1 = docFile1;
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
