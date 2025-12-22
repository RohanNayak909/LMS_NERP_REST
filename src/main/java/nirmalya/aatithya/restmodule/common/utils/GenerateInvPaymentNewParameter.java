package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;

public class GenerateInvPaymentNewParameter {
	
public static String getAddpayParam(RestSalesInvoiceNewModel customer) {
		
		String s = "";
		
		
		if (customer.getPayDate() != null && customer.getPayDate() != "") {
			s = s + "@p_payDate='" + customer.getPayDate() + "',";
		}
		
		if (customer.getPaidAmnt()!= null) {
			s = s + "@p_paidAmt='" + customer.getPaidAmnt() + "',";
		}
		
		if (customer.getOutStdAmt() != null) {
			s = s + "@p_outstdAmt='" + customer.getOutStdAmt() + "',";
		}
		
		if (customer.getCustName()!= null && customer.getCustName() != "") {
			s = s + "@p_custName='" + customer.getCustName() + "',";
		}
		
		if (customer.getrVoucher()!= null && customer.getrVoucher() != "") {
			s = s + "@p_LRVoucher='" + customer.getrVoucher() + "',";
		}
		if (customer.getsOrder()!= null && customer.getsOrder() != "") {
			s = s + "@p_sOrder='" + customer.getsOrder() + "',";
		}
		if (customer.getSaleInvoice() != null && customer.getSaleInvoice() != "") {
			s = s + "@p_salesInvoice='" + customer.getSaleInvoice() + "',";
		}
		if (customer.getTaxTypepay()!= null ) {
			s = s + "@p_taxTypepay='" + customer.getTaxTypepay() + "',";
		}

		if (customer.getGstRatepay()!= null ) {
			s = s + "@p_gstRatepay='" + customer.getGstRatepay() + "',";
		}
		if (customer.getTotalAmnt()!= null) {
			s = s + "@p_totalAmt='" + customer.getTotalAmnt() + "',";
		}
		
		if (customer.getqIGSTpay()!= null ) {
			s = s + "@p_igstpay='" + customer.getqIGSTpay() + "',";
		}
		if (customer.getqCGSTpay()!= null ) {
			s = s + "@p_cgstpay='" + customer.getqCGSTpay() + "',";
		}
		if (customer.getqSGSTpay()!= null ) {
			s = s + "@p_sgstpay='" + customer.getqSGSTpay() + "',";
		}
		if (customer.getPaymodeId() != null && customer.getPaymodeId() != "") {
			s = s + "@p_payMode='" + customer.getPaymodeId() + "',";
		}
		if (customer.getTdN()!= null && customer.getTdN() != "") {
			s = s + "@p_tsnNo='" + customer.getTdN() + "',";
		}

		if (customer.getCkn()!= null && customer.getCkn() != "") {
			s = s + "@p_chkNo='" + customer.getCkn() + "',";
		}
		if (customer.getPaymentId() != null && customer.getPaymentId() != "") {
			s = s + "@p_payRefNo='" + customer.getPaymentId() + "',";
		}
		if (customer.getGrandTotalpay()!= null ) {
			s = s + "@p_gdTotalpay='" + customer.getGrandTotalpay() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("sy"+s);
		return s;
		
	}


}
