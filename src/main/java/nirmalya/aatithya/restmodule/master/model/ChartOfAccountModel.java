package nirmalya.aatithya.restmodule.master.model;

import java.math.BigInteger;

public class ChartOfAccountModel {
	private String ccId;
	private String ccName;
	private String ccCode;
	private String chartAccDebitStatus;
	private String chartAccCreditStatus;
	private String createdBy;
	private String level;
	private String parentId;
	private BigInteger nodeCount;
	public ChartOfAccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChartOfAccountModel(Object ccId, Object ccName, Object ccCode, Object chartAccDebitStatus,Object chartAccCreditStatus,Object createdBy,Object level,Object parentId,Object nodeCount) {
		super();
		try {
			this.ccId = (String) ccId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ccName = (String) ccName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ccCode = (String) ccCode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.chartAccDebitStatus = (String) chartAccDebitStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.chartAccCreditStatus = (String) chartAccCreditStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.level = (String) level;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.parentId = (String) parentId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.nodeCount = (BigInteger) nodeCount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getCcId() {
		return ccId;
	}

	public void setCcId(String ccId) {
		this.ccId = ccId;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getCcCode() {
		return ccCode;
	}

	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}

	public String getChartAccDebitStatus() {
		return chartAccDebitStatus;
	}
	public void setChartAccDebitStatus(String chartAccDebitStatus) {
		this.chartAccDebitStatus = chartAccDebitStatus;
	}
	public String getChartAccCreditStatus() {
		return chartAccCreditStatus;
	}
	public void setChartAccCreditStatus(String chartAccCreditStatus) {
		this.chartAccCreditStatus = chartAccCreditStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public BigInteger getNodeCount() {
		return nodeCount;
	}
	public void setNodeCount(BigInteger nodeCount) {
		this.nodeCount = nodeCount;
	}
	
	
}
