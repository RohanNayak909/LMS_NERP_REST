package nirmalya.aatithya.restmodule.sales.model;

public class RestCustomerGraphModel {
	private String month;
	private String store;
	private String customer;
	private Integer totalInvoice;
	private Double totalInvoiceAmt;
	private Integer totalQuotation;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getTotalInvoice() {
		return totalInvoice;
	}
	public void setTotalInvoice(Integer totalInvoice) {
		this.totalInvoice = totalInvoice;
	}
	public Integer getTotalQuotation() {
		return totalQuotation;
	}
	public void setTotalQuotation(Integer totalQuotation) {
		this.totalQuotation = totalQuotation;
	}
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public Double getTotalInvoiceAmt() {
		return totalInvoiceAmt;
	}
	public void setTotalInvoiceAmt(Double totalInvoiceAmt) {
		this.totalInvoiceAmt = totalInvoiceAmt;
	}
	public RestCustomerGraphModel(Object month, Object totalInvoice, Object totalQuotation) {
		super();
		this.month = (String)month;
		this.totalInvoice = (Integer)totalInvoice;
		this.totalQuotation = (Integer)totalQuotation;
	}
	public RestCustomerGraphModel(Object store, Object totalInvoiceAmt, Object totalQuotation,Object totalInvoice, Object month) {
		super();
		this.store = (String)store;
		this.totalInvoiceAmt = (Double)totalInvoiceAmt;
		this.totalQuotation = (Integer)totalQuotation;
		this.totalInvoice = (Integer)totalInvoice;
		this.month = (String)month;
	}
	public RestCustomerGraphModel(Object store, Object totalInvoice, Object totalQuotation, Object month) {
		super();
		this.month = (String)month;
		this.store = (String)store;
		this.totalInvoice = (Integer)totalInvoice;
		this.totalQuotation = (Integer)totalQuotation;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
}
