package nirmalya.aatithya.restmodule.common.utils;


import java.util.List;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmInvoiceModel;
public class GenerateCRMInvoiceParameter {
public static String getAddParam(List<RestCrmInvoiceModel> customer) {
		
		String s = "";
		String listdata ="";
		String invoiceId="";
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
		
		String invoiceOwner="";
		String invoiceSalesOrder="";
		String subject="";
		String poNumber="";
		String invoiceDate="";
		
		String exciseDuty="";
		String dueDate="";
		String invoiceStatus="";
		String salesCommission="";
		String contactId="";
		
		String contactName="";
		String accountId="";
		String dealAccountName="";
				
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
		
		
		for (RestCrmInvoiceModel m : customer) {
			invoiceId=m.getInvoiceId();
			qutActive=m.getQutActive();
			qutCreatedBy=m.getQutCreatedBy();
			subTotal=m.getSubTotal();
			qIGST=m.getqIGST();
			qCGST=m.getqCGST();
			qSGST=m.getqSGST();
			grandTotal=m.getGrandTotal();
			taxType=m.getTaxType();
			
			invoiceOwner=m.getInvoiceOwner();
			invoiceSalesOrder=m.getInvoiceSalesOrder();
			subject=m.getSubject();
			poNumber=m.getPoNumber();
			invoiceDate=m.getInvoiceDate();
			
			exciseDuty=m.getExciseDuty();
			dueDate=m.getDueDate();
			invoiceStatus=m.getInvoiceStatus();
			salesCommission=m.getSalesCommission();
			contactId=m.getContactId();
			
			contactName=m.getContactName();
			accountId=m.getAccountId();
			dealAccountName=m.getDealAccountName();
			
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
		
		s = s + "@p_invoiceId='" + invoiceId + "',";
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
						
		s = s + "@p_invoiceOwner='" + invoiceOwner + "',";
		s = s + "@p_invoiceSalesOrder='" + invoiceSalesOrder + "',";
		s = s + "@p_subject='" + subject + "',";
		s = s + "@p_poNumber='" + poNumber + "',";
		s = s + "@p_invoiceDate='" + invoiceDate + "',";
		
		s = s + "@p_exciseDuty='" + exciseDuty + "',";
		s = s + "@p_dueDate='" + dueDate + "',";
		s = s + "@p_invoiceStatus='" + invoiceStatus + "',";
		s = s + "@p_salesCommission='" + salesCommission + "',";
		s = s + "@p_contactId='" + contactId + "',";
		
		s = s + "@p_contactName='" + contactName + "',";
		s = s + "@p_accountId='" + accountId + "',";
		s = s + "@p_dealAccountName='" + dealAccountName + "',";
				
		
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
		
		
		
		if(!customer.get(0).getInvoiceId().contentEquals("1")) {
		for (RestCrmInvoiceModel m : customer) {
			Double disc = 0.0;
			if(m.getDiscount() == null) {
				disc = 0.0;
			} else {
				disc = m.getDiscount();
			}

			listdata = listdata + "(@p_invoiceId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
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


public static String getDeleteParam(RestCrmInvoiceModel customer) {
	String[] userIds = customer.getInvoiceId().split(",");
	String s = "";
	String litem = "";
	for (String a : userIds) {
		litem = litem + "\"" + a + "\",";
	}
	litem = litem.substring(0, litem.length() - 1);
	litem = "(" + litem + ")";
	s = s + "@p_invoiceId='" + litem + "',";

	
	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}

	System.out.println(s);

	return s;
}



}




