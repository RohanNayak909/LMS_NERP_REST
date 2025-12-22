package nirmalya.aatithya.restmodule.sales.model;

public class RestCustomerStoreGraphModel {
private String cityname;
private Double invoiceAmt;
private Double salesOrderAmt;
public String getCityname() {
	return cityname;
}
public void setCityname(String cityname) {
	this.cityname = cityname;
}
public Double getInvoiceAmt() {
	return invoiceAmt;
}
public void setInvoiceAmt(Double invoiceAmt) {
	this.invoiceAmt = invoiceAmt;
}
public Double getSalesOrderAmt() {
	return salesOrderAmt;
}
public void setSalesOrderAmt(Double salesOrderAmt) {
	this.salesOrderAmt = salesOrderAmt;
}
public RestCustomerStoreGraphModel(Object cityname, Object invoiceAmt, Object salesOrderAmt) {
	super();
	this.cityname = (String)cityname;
	this.invoiceAmt = (Double)invoiceAmt;
	this.salesOrderAmt = (Double)salesOrderAmt;
}

}
