package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestSalesPackagesModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesRefundModel;

public class GenerateSalesRefundParameter {

	
	public static String getAddempParam(List<RestSalesRefundModel> customer) {
		String s = "";
		
		
		String refundId="";
		String saleInvoiceId="";
		String custId="";
	//	String qutActive=null;
		String qutCreatedBy="";
		String returnPaymentMode="";
		Double amount=0.00;
		
		String transactionId="";
		
		for (RestSalesRefundModel m : customer) {
			refundId=m.getRefundId();
			saleInvoiceId=m.getSaleInvoiceId();
			custId=m.getCustId();
			
			qutCreatedBy=m.getQutCreatedBy();
			returnPaymentMode=m.getReturnPaymentMode();
			amount=m.getAmount();
			transactionId=m.getTransactionId();
					
		}
		
		s = s + "@p_refundId='" + refundId + "',";
		s = s + "@p_saleInvoiceId='" + saleInvoiceId + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		
		s = s + "@p_returnPaymentMode='" + returnPaymentMode + "',";
		s = s + "@p_amount='" + amount + "',";
		s = s + "@p_transactionId='" + transactionId + "',";
		
		System.out.println(customer);
		if(!customer.isEmpty()) {
			if(!customer.get(0).getRefundId().contentEquals("1")) {
				if (s != "") {
				s = s.substring(0, s.length() - 1);
				s = "SET " + s + ";";
				}
				}
		}else {
			System.out.println("customer object is empty.");
		}
		
		
		return s;
	}
	
}
