package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceReturnNewModel;

public class GenerateSalesInvReturnNewParameter {
	public static String getAddempParam(List<RestSalesInvoiceReturnNewModel> customer) {
		String s = "";
		String listdata ="";
		String salesInreturn="";
		String saleInvoiceId="";
		String salOrderId="";
		String qutActive=null;
		String qutDescription="";
		String qutCreatedBy="";
		Double subTotal=0.00;
		Double qIGST=0.00;
		Double qCGST=0.00;
		Double qSGST=0.00;
		Double grandTotal=0.00;
		Boolean taxType=null;
	
		
		
		
		for (RestSalesInvoiceReturnNewModel m : customer) {
			//salesInreturn=m.getSalesInreturn();
			//saleInvoiceId=m.getSaleInvoiceId();
			//salOrderId=m.getSalOrderId();
			qutActive=m.getQutActive();
			//qutDescription=m.getQutDescription();
			qutCreatedBy=m.getQutCreatedBy();
			subTotal=m.getSubTotal();
			qIGST=m.getqIGST();
			qCGST=m.getqCGST();
			qSGST=m.getqSGST();
			grandTotal=m.getGrandTotal();
			taxType=m.getTaxType();
		}
		
		s = s + "@p_salesInreturnId='" + salesInreturn + "',";
		s = s + "@p_salesInvoiceId='" + saleInvoiceId + "',";
		s = s + "@p_salesOrderId='" + salOrderId + "',";
		s = s + "@p_qutActive='" + qutActive + "',";
		s = s + "@p_qutDesp='" + qutDescription + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		
		
		
		/*
		 * if(!customer.get(0).getSalesInreturn().contentEquals("1")) { for
		 * (RestSalesInvoiceReturnNewModel m : customer) {
		 * 
		 * listdata = listdata + "(@p_salesInreturnId,\"" + m.getItemId() + "\",\"" +
		 * m.getItemName() + "\",\"" + m.getQuantity() + "\",\"" + m.getUnitPrice() +
		 * "\",\"" + m.getDiscount() + "\",\"" + m.getGstRate() + "\",\"" +
		 * m.getLineTotal() + "\",\"" + m.getSku() + "\"," + m.getItemIgst() + "," +
		 * m.getItemCgst() + "," + m.getItemSgst() + "),"; } listdata =
		 * listdata.substring(0, listdata.length() - 1);
		 * 
		 * s = s + "@p_litemSubQuery='" + listdata + "',";
		 * 
		 * 
		 * if (s != "") { s = s.substring(0, s.length() - 1);
		 * 
		 * s = "SET " + s + ";"; } }
		 */
		System.out.println("Item Details"+s);
		return s;
	}
	
	
	public static String getDeleteParamnew(RestSalesInvoiceReturnNewModel customer) {
		//String[] userIds = customer.getSalesInreturn().split(",");
		String s = "";
		String litem = "";
		/*
		 * for (String a : userIds) { litem = litem + "\"" + a + "\","; }
		 */
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_salesInreturnId='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE" + s);

		return s;
	}

}
