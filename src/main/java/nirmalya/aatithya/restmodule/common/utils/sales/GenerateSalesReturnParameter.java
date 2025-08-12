package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceReturnModel;
import nirmalya.aatithya.restmodule.sales.model.RestDeliveryChallanModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesReturnModel;

public class GenerateSalesReturnParameter {
	public static String getAddSaleReturn(List<RestSalesReturnModel> customer) {
		String s = "";
		String listdata ="";
		String saleReturnId="";
		String custId="";
		String poId="";
		String resonForReturn="";
	    String carrierId="";
	    String qutActive=null;
	    String qutDescription="";
		Double subTotal=0.00;
		Double qIGST=0.00;
		Double qCGST=0.00;
		Double qSGST=0.00;
		Double grandTotal=0.00;
		Boolean taxType=null;
		//Double adjustment=0.00;
        String multidocument="";
    	Double tcsAmount=0.00;
		String tcs="";
		String terms="";
		String qutCreatedBy="";
	    String organization="";
	    String orgDivision="";
		for (RestSalesReturnModel m : customer) {
			saleReturnId=m.getSaleReturnId();
			custId=m.getCustId();
			poId=m.getPoId();
			resonForReturn=m.getResonForReturn();
			carrierId=m.getCarrierId();
			qutActive=m.getQutActive();
			qutDescription=m.getQutDescription();
			if (m.getSubTotal() != null) {
				subTotal = m.getSubTotal();
			}
			if (m.getqIGST() != null) {
				qIGST = m.getqIGST();
			}
			if (m.getqCGST() != null) {
				qCGST = m.getqCGST();
			}
			if (m.getqSGST() != null) {
				qSGST = m.getqSGST();
			}
			if (m.getGrandTotal() != null) {
			  	grandTotal = m.getGrandTotal();
			}
			taxType=m.getTaxType();
			//adjustment=m.getAdjustment();
			if (m.getTcsAmount() != null) {
				tcsAmount = m.getTcsAmount();
			}
			tcs=m.getTcs();
			terms=m.getTerms();
			qutCreatedBy=m.getQutCreatedBy();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
			
			
		}
		
		s = s + "@p_saleReturnId='" + saleReturnId + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_resonForReturn='" + resonForReturn + "',";
		s = s + "@p_carrierId='" + carrierId + "',";
		s = s + "@p_qutActive='" + qutActive + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		//s = s + "@p_adjustment='" +  adjustment + "',";
		s = s + "@p_tcsAmount='" +  tcsAmount + "',";
		s = s + "@p_tcs='" +  tcs + "',";
		s = s + "@p_terms='" +  terms + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_div='" + orgDivision + "',";
		
		
		if(!customer.get(0).getSaleReturnId().contentEquals("1")) {
		for (RestSalesReturnModel m : customer) {

			listdata = listdata + "(@p_saleReturnId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getUnitPrice() + "\",\"" + m.getDiscount() + "\",\""
					+ m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\"" + m.getSku()
					+ "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + ",\"" + m.getHsnCode() + "\",\"" + m.getUnit() + "\"," + m.getTaxableAmt() + "," + m.getPendingQut() + "," + m.getRtnQut() + ",@p_org,@p_div,@p_qutCreatedBy),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";
		for (InventoryVendorDocumentModel a : customer.get(0).getDocumentList()) {
			multidocument = multidocument + "(@p_saleReturnId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",@p_org,@p_div,@p_qutCreatedBy),";
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
		System.out.println("Item Details"+s);
		return s;
	}
	public static String getDeleteParamnew(RestSalesReturnModel customer) {
		String[] userIds = customer.getSaleReturnId().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_saleReturnId='" + litem + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE"+s);

		return s;
	}
	
	public static String getApproveSalesReturnParam(RestSalesReturnModel restSalesReturnModel) {

		String s = "";
		

		if(restSalesReturnModel.getOrganization() != null || restSalesReturnModel.getOrganization() != "") {
			s = s + "@p_org='" + restSalesReturnModel.getOrganization() + "',";
		}
		if(restSalesReturnModel.getOrgDivision() != null || restSalesReturnModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restSalesReturnModel.getOrgDivision() + "',";
		}
		if (restSalesReturnModel.getSaleReturnId() != null ||  restSalesReturnModel.getSaleReturnId() != "") {
			s = s + "@p_salesreturnId='" + restSalesReturnModel.getSaleReturnId() + "',";
		}

		if (restSalesReturnModel.getPoId() != null ||  restSalesReturnModel.getPoId() != "") {
			s = s + "@p_poId='" + restSalesReturnModel.getPoId() + "',";
		}
		if (restSalesReturnModel.getCustId() != null || restSalesReturnModel.getCustId() != "") {
			s = s + "@p_custId='" + restSalesReturnModel.getCustId() + "',";
		}

		if (restSalesReturnModel.getSalesInvoiceId() != null ||  restSalesReturnModel.getSalesInvoiceId() != "") {
			s = s + "@p_invoiceId='" + restSalesReturnModel.getSalesInvoiceId() + "',";
		}
		
		if (restSalesReturnModel.getQutCreatedBy() != null ||  restSalesReturnModel.getQutCreatedBy() != "") {
			s = s + "@p_createdBy='" + restSalesReturnModel.getQutCreatedBy() + "',";
		}

		if (restSalesReturnModel.getRtnQut() != null) {
			s = s + "@p_returnQty=" + restSalesReturnModel.getRtnQut() + ",";
		}
		if (restSalesReturnModel.getApproveStatus() != null ||  restSalesReturnModel.getApproveStatus() != "") {
			s = s + "@p_approveSts='" + restSalesReturnModel.getApproveStatus() + "',";
		}

		if (restSalesReturnModel.getDebitNoteAmt() != null) {
			s = s + "@p_debitNoteAmt='" + restSalesReturnModel.getDebitNoteAmt() + "',";
		}
		s = s + "@p_debitNoteId='" + restSalesReturnModel.getDebitNoteId() + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}	
}
