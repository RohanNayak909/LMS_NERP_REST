package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestDeliveryChallanModel;
import nirmalya.aatithya.restmodule.sales.model.RestPaymentsReceivedModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesShipmentsModel;

public class GenerateSalesPaymentsReceivedParameter {
	public static String getAddParam(List<RestPaymentsReceivedModel> customer) {
		String s = "";
		
		
		
		String paymentId="";
		String custId="";
		String saleInvoiceId="";
	    Double amountReceived=0.00;
		Double bankCharges=0.00;
		String payment="";
		String depositTo="";
		
		String paymentMode="";
		String reference="";
		String internalNotes="";
	    String qutCreatedBy="";
		String multidocument="";
		Double fullyPaymentAmount=0.00;
		String checkBox=null;
		/*
		 * String organization=""; String orgDivision="";
		 */
	
		
	
		
		
		for (RestPaymentsReceivedModel m : customer) {
			
			paymentId=m.getPaymentId();
			custId=m.getCustId();
			saleInvoiceId=m.getSaleInvoiceId();
			amountReceived=m.getAmountReceived();
			bankCharges=m.getBankCharges();
			payment=m.getPayment();
			depositTo=m.getDepositTo();
			paymentMode=m.getPaymentMode();
			reference=m.getReference();
			internalNotes=m.getInternalNotes();
			qutCreatedBy=m.getQutCreatedBy();
			fullyPaymentAmount=m.getFullyPaymentAmount();
			checkBox=m.getCheckBox();
			/*
			 * organization=m.getOrganization(); orgDivision=m.getOrgDivision();
			 */
			
					
		}
		
		
		s = s + "@p_paymentId='" + paymentId + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_saleInvoiceId='" + saleInvoiceId + "',";
		s = s + "@p_amountReceived='" + amountReceived + "',";
		s = s + "@p_bankCharges='" + bankCharges + "',";
		s = s + "@p_payment='" + payment + "',";
		s = s + "@p_depositTo='" + depositTo + "',";
		s = s + "@p_paymentMode='" + paymentMode + "',";
		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_internalNotes='" + internalNotes + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_fullyPaymentAmount='" + fullyPaymentAmount + "',";
		s = s + "@p_checkBox='" + checkBox + "',";
		/*
		 * s = s + "@p_organization='" + organization + "',"; s = s + "@p_orgDivision='"
		 * + orgDivision + "',";
		 */
		System.out.println(customer);
		if(!customer.get(0).getPaymentId().contentEquals("1")) {
			
			for (InventoryVendorDocumentModel a : customer.get(0).getDocumentList()) {
				multidocument = multidocument + "(@p_paymentId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",@p_qutCreatedBy),";
			}
			if(!multidocument.isEmpty()) {
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			}



			if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			}
			}
			//System.out.println("Item Details"+s);
			return s;
	}
}
