package nirmalya.aatithya.restmodule.common.utils;


import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestCrmQuoteModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmSalesOrderModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;


public class GenerateCRMSalesOrderParameter {
	
public static String getAddParam(List<RestCrmSalesOrderModel> customer) {
		
		String s = "";
		String listdata ="";
		String soId="";
		String qutName="";
		String custId="";
		String qutValidDate="";
		String qutDescription="";
		String qutActive=null;
		String qutCreatedBy="";
		Double subTotal=0.00;
		Double qIGST=0.00;
		Double qCGST=0.00;
		Double qSGST=0.00;
		Double grandTotal=0.00;
		Boolean taxType=null;
		
		String salesOwner="";
		String dealId="";
		String salesDealName="";
		String salesSubject="";
		String purchaseOrder="";
		String customerNo="";
		String dueDate="";
		String quoteId="";
		String quoteName="";
		String contactId="";
		String contactName="";
		
		String pending="";
		String exciseDuty="";
		String salesCarrier="";
		String salesOrderStatus="";
		String salesCommission="";
		String quoteAccountId="";
		String quoteAccountName="";
		
		String billingStreet ="";
		String shippingStreet ="";
		String billingCity ="";
		String shippingCity ="";
		String billingCode ="";
		String shippingCode ="";
		String billingState ="";
		String shippingState ="";
		String billingCountry ="";
		String shippingCountry ="";
		
		String description ="";
		String termCondition ="";
		
		
		for (RestCrmSalesOrderModel m : customer) {
			soId=m.getSoId();
			qutActive=m.getQutActive();
			qutCreatedBy=m.getQutCreatedBy();
			subTotal=m.getSubTotal();
			qIGST=m.getqIGST();
			qCGST=m.getqCGST();
			qSGST=m.getqSGST();
			grandTotal=m.getGrandTotal();
			taxType=m.getTaxType();
			
			salesOwner=m.getSalesOwner();
			dealId=m.getDealId();
			salesDealName=m.getSalesDealName();
			salesSubject=m.getSalesSubject();
			purchaseOrder=m.getPurchaseOrder();
			customerNo=m.getCustomerNo();
			dueDate=m.getDueDate();
			quoteId=m.getQuoteId();
			quoteName=m.getQuoteName();
			contactId=m.getContactId();
			contactName=m.getContactName();
			
			pending=m.getPending();
			exciseDuty=m.getExciseDuty();
			salesCarrier=m.getSalesCarrier();
			salesOrderStatus=m.getSalesOrderStatus();
			salesCommission=m.getSalesCommission();
			quoteAccountId=m.getQuoteAccountId();
			quoteAccountName=m.getQuoteAccountName();
			
			billingStreet =m.getBillingStreet();
			shippingStreet =m.getShippingStreet();
			billingCity =m.getBillingCity();
			shippingCity =m.getShippingCity();
			billingCode =m.getBillingCode();
			shippingCode =m.getShippingCode();
			billingState =m.getBillingState();
			shippingState =m.getShippingState();
			billingCountry =m.getBillingCountry();
			shippingCountry =m.getShippingCountry();
			
			description =m.getDescription();
			termCondition =m.getTermCondition();
			
			
			
		}
		
		s = s + "@p_soId='" + soId + "',";
		s = s + "@p_qutName='" + qutName + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_qutValidDate='" + qutValidDate + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_qutActive='" + qutActive + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		
		s = s + "@p_salesOwner='" + salesOwner + "',";
		s = s + "@p_dealId='" + dealId + "',";
		s = s + "@p_salesDealName='" + salesDealName + "',";
		
		s = s + "@p_salesSubject='" + salesSubject + "',";
		s = s + "@p_purchaseOrder='" + purchaseOrder + "',";
		s = s + "@p_customerNo='" + customerNo + "',";
		
		s = s + "@p_dueDate='" + dueDate + "',";
		s = s + "@p_quoteId='" + quoteId + "',";
		s = s + "@p_quoteName='" + quoteName + "',";
		s = s + "@p_contactId='" + contactId + "',";
		s = s + "@p_contactName='" + contactName + "',";
		
		
		
		s = s + "@p_pending='" + pending + "',";
		s = s + "@p_exciseDuty='" + exciseDuty + "',";
		s = s + "@p_salesCarrier='" + salesCarrier + "',";
		s = s + "@p_salesOrderStatus='" + salesOrderStatus + "',";
		s = s + "@p_salesCommission='" + salesCommission + "',";
		s = s + "@p_quoteAccountId='" + quoteAccountId + "',";
		s = s + "@p_quoteAccountName='" + quoteAccountName + "',";
		
		
		s = s + "@p_billingStreet='" + billingStreet + "',";
		s = s + "@p_shippingStreet='" + shippingStreet + "',";
		s = s + "@p_billingCity='" + billingCity + "',";
		
		
		s = s + "@p_shippingCity='" + shippingCity + "',";
		s = s + "@p_billingCode='" + billingCode + "',";
		s = s + "@p_shippingCode='" + shippingCode + "',";
		
		
		s = s + "@p_billingState='" + billingState + "',";
		s = s + "@p_shippingState='" + shippingState + "',";
		s = s + "@p_billingCountry='" + billingCountry + "',";
				
		
		s = s + "@p_shippingCountry='" + shippingCountry + "',";
		s = s + "@p_description='" + description + "',";
		s = s + "@p_termCondition='" + termCondition + "',";
		
		
		
		if(!customer.get(0).getSoId().contentEquals("1")) {
		for (RestCrmSalesOrderModel m : customer) {
			Double disc = 0.0;
			if(m.getDiscount() == null) {
				disc = 0.0;
			} else {
				disc = m.getDiscount();
			}

			listdata = listdata + "(@p_soId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getUnitPrice() + "\",\"" + disc + "\",\""
					+ m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\"" + m.getqItmCode() + "\",\"" + m.getSku()
					+ "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + "),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";


		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		}
		System.out.println("Item Details"+s);
		return s;
		
		
	}


public static String getDeleteParam(RestCrmSalesOrderModel customer) {
	String[] userIds = customer.getSoId().split(",");
	String s = "";
	String litem = "";
	for (String a : userIds) {
		litem = litem + "\"" + a + "\",";
	}
	litem = litem.substring(0, litem.length() - 1);
	litem = "(" + litem + ")";
	s = s + "@p_soId='" + litem + "',";

	
	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}

	System.out.println(s);

	return s;
}



}




