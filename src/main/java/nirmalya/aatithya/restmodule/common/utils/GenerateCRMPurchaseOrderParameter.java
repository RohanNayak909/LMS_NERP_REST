package nirmalya.aatithya.restmodule.common.utils;


import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestCrmPurchaseOrderModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmQuoteModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmSalesOrderModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;


public class GenerateCRMPurchaseOrderParameter {
	
public static String getAddParam(List<RestCrmPurchaseOrderModel> customer) {
		
		String s = "";
		String listdata ="";
		String poId="";
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
		
		String purchaseOrderOwner="";
		String poNumber="";
		String poSubject="";
		String vendorId="";
		String vendorName="";
		String requisitionNo="";
		String trackingNo="";
		String contactId="";
		String contactName="";
		
		String poDate="";
		String dueDate="";
		String quoteCarrier="";
		String exciseDuty="";
		String salesCommission="";
		String purchaseOrderStatus="";
		
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
		
		
		for (RestCrmPurchaseOrderModel m : customer) {
			poId=m.getPoId();
			qutActive=m.getQutActive();
			qutCreatedBy=m.getQutCreatedBy();
			subTotal=m.getSubTotal();
			qIGST=m.getqIGST();
			qCGST=m.getqCGST();
			qSGST=m.getqSGST();
			grandTotal=m.getGrandTotal();
			taxType=m.getTaxType();
			
			purchaseOrderOwner=m.getPurchaseOrderOwner();
			poNumber=m.getPoNumber();
			poSubject=m.getPoSubject();
			vendorId=m.getVendorId();
			vendorName=m.getVendorName();
			requisitionNo=m.getRequisitionNo();
			trackingNo=m.getTrackingNo();
			contactId=m.getContactId();
			contactName=m.getContactName();
			
			
			poDate=m.getPoDate();
			dueDate=m.getDueDate();
			quoteCarrier=m.getQuoteCarrier();
			exciseDuty=m.getExciseDuty();
			salesCommission=m.getSalesCommission();
			purchaseOrderStatus=m.getPurchaseOrderStatus();
			
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
		
		s = s + "@p_poId='" + poId + "',";
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
		
		s = s + "@p_purchaseOrderOwner='" + purchaseOrderOwner + "',";
		s = s + "@p_poNumber='" + poNumber + "',";
		s = s + "@p_poSubject='" + poSubject + "',";
		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_vendorName='" + vendorName + "',";
		s = s + "@p_requisitionNo='" + requisitionNo + "',";
		s = s + "@p_trackingNo='" + trackingNo + "',";
		s = s + "@p_contactId='" + contactId + "',";
		s = s + "@p_contactName='" + contactName + "',";
		
		
		s = s + "@p_poDate='" + poDate + "',";
		s = s + "@p_dueDate='" + dueDate + "',";
		s = s + "@p_quoteCarrier='" + quoteCarrier + "',";
		s = s + "@p_exciseDuty='" + exciseDuty + "',";
		s = s + "@p_salesCommission='" + salesCommission + "',";
		s = s + "@p_purchaseOrderStatus='" + purchaseOrderStatus + "',";
		
		
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
		
		
		
		if(!customer.get(0).getPoId().contentEquals("1")) {
		for (RestCrmPurchaseOrderModel m : customer) {
			Double disc = 0.0;
			if(m.getDiscount() == null) {
				disc = 0.0;
			} else {
				disc = m.getDiscount();
			}

			listdata = listdata + "(@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
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


public static String getDeleteParam(RestCrmPurchaseOrderModel customer) {
	String[] userIds = customer.getPoId().split(",");
	String s = "";
	String litem = "";
	for (String a : userIds) {
		litem = litem + "\"" + a + "\",";
	}
	litem = litem.substring(0, litem.length() - 1);
	litem = "(" + litem + ")";
	s = s + "@p_poId='" + litem + "',";

	
	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}

	System.out.println(s);

	return s;
}



}




