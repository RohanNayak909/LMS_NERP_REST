package nirmalya.aatithya.restmodule.lms.model;

import java.math.BigDecimal;

public class RetakeOrderInfo {

  private String orderCode;
  private int basePaise;
  private BigDecimal gstPercent;
  private int gstPaise;
  private int amountPaise;
  private String currency;
  private String purpose;
  private String status;

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }
  

  public int getBasePaise() {
    return basePaise;
  }

  public void setBasePaise(int basePaise) {
    this.basePaise = basePaise;
  }

  public BigDecimal getGstPercent() {
    return gstPercent;
  }

  public void setGstPercent(BigDecimal gstPercent) {
    this.gstPercent = gstPercent;
  }

  public int getGstPaise() {
    return gstPaise;
  }

  public void setGstPaise(int gstPaise) {
    this.gstPaise = gstPaise;
  }

  public int getAmountPaise() {
    return amountPaise;
  }

  public void setAmountPaise(int amountPaise) {
    this.amountPaise = amountPaise;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
