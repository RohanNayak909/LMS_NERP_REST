package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestQuotationDetailsModel;

public class GeneratePurchaseQuotationDetails {
	public static String getAddPurchaseQuotation(List<RestQuotationDetailsModel> purchase) {
		String s = "";
		String listdata = "";
		String vendorId = "";
		String quotationId = "";
		String qutValidDate="";
		String reference = "";
		String paymentTermId = "";
		String qutNo = "";
		String qutDescription = "";
	
		String subTotal = "0.00";
		String qIGST ="0.00";
		String qCGST = "0.00";
		String qSGST = "0.00";
		String grandTotal = "0.00";

		Boolean taxType = null;
		Double adjustment = 0.00;
		Double tcsAmount = 0.00;
		String tcs = "";
		String terms = "";
		
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String shippingDetails = "";
		String orgDetails = "";
		String custDetails = "";
		String paymentMode = "";

		String multidocument = "";
		String project = "";
		String createdByType = "";

		
		

		for (RestQuotationDetailsModel m : purchase) {
			vendorId = m.getVendorId();
			quotationId = m.getQuotationId();
			qutValidDate=m.getQutValidDate();
			reference = m.getReference();
			paymentTermId = m.getPaymentTermId();
			qutNo = m.getQutNo();
			qutDescription = m.getQutDescription();
			
			if(m.getSubTotal()!=null) {
				subTotal=m.getSubTotal();
			}
			if(m.getqIGST()!=null) {
				qIGST=m.getqIGST();
			}
			if(m.getqCGST()!=null) {
				qCGST=m.getqCGST();
			}
			if(m.getqSGST()!=null) {
				qSGST=m.getqSGST();
			}
			if(m.getGrandTotal()!=null) {
				grandTotal=m.getGrandTotal();
			}
			/*
			 * subTotal = m.getSubTotal(); qIGST = m.getqIGST(); qCGST = m.getqCGST(); qSGST
			 * = m.getqSGST(); grandTotal = m.getGrandTotal();
			 */
			taxType = m.getTaxType();
			
			 if(m.getAdjustment()!=null) {
			    	adjustment=m.getAdjustment();
			    }
				if(m.getTcsAmount()!=null) {
					tcsAmount=m.getTcsAmount();
				}
			//adjustment = m.getAdjustment();
			//tcsAmount = m.getTcsAmount();
			tcs = m.getTcs();
			terms = m.getTerms();
			
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			shippingDetails = m.getShippingDetails();
			orgDetails = m.getOrgDetails();
			custDetails = m.getCustDetails();
			paymentMode = m.getPaymentModeId();
			project=m.getProject();
			createdByType=m.getCreatedByType();
			
		}
		
		
		
       
		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_quoId='" + quotationId + "',";
		s = s + "@p_qutValidDate='" + DateFormatter.getStringDate(qutValidDate) + "',";
		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_paymentTermId='" + paymentTermId + "',";
		s = s + "@p_qutNo='" + qutNo + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_subTotal=" + subTotal + ",";
		s = s + "@p_qIGST=" + qIGST + ",";
		s = s + "@p_qCGST=" + qCGST + ",";
		s = s + "@p_qSGST=" + qSGST + ",";

		s = s + "@p_grandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_adjustment=" + adjustment + ",";
		s = s + "@p_tcsAmount=" + tcsAmount + ",";
		s = s + "@p_tcs='" + tcs + "',";
		s = s + "@p_terms=\"" + terms + "\",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_shippingDetails='" + shippingDetails + "',";
		s = s + "@p_orgDetails='" + orgDetails + "',";
		s = s + "@p_custDetails='" + custDetails + "',";
		s = s + "@p_pMode='" + paymentMode + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_createdByType='" + createdByType + "',";
		

		if (!purchase.get(0).getQuotationId().contentEquals("1")) {
			for (RestQuotationDetailsModel m : purchase) {

				listdata = listdata + "(@p_quoId,\"" + m.getItemId() + "\",\"" + m.getItemName()
						+ "\"," + m.getQuantity() + "," + m.getUnitPrice() + "," + m.getDiscount() + "," + m.getDiscountType() + ","
						+ m.getGstRate() + "," + m.getLineTotal() + ",\"" + m.getSku() + "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + ",\"" + m.getHsnCode() + "\",\"" + m.getUnit() + "\"," + m.getTaxableAmt() + ",@p_organization,@p_orgDivision),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";
			
			/*
			 * List<InventoryVendorDocumentModel> item2 = purchase.get(0).getDocumentList();
			 * if (purchase.get(0).getDocumentList().size() > 0) { for
			 * (InventoryVendorDocumentModel a : item2) { if
			 * (!a.getDocumnentName().contentEquals("") &&
			 * !a.getDocumnentName().contentEquals("null")) { multidocument = multidocument
			 * + "(@p_quoId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() +
			 * "\",@p_createdBy,@p_organization,@p_orgDivision),"; } }
			 * multidocument=multidocument.substring(0,multidocument.length()-1); }else {
			 * multidocument=""; } s = s + "@p_vendorDocuments='" + multidocument + "',";
			 */
			
			/*
			 * for (InventoryVendorDocumentModel a : purchase.get(0).getDocumentList()) {
			 * if(!a.getDocumnentName().contentEquals("") &&
			 * !a.getDocumnentName().contentEquals("null")) { multidocument = multidocument
			 * + "(@p_quoId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() +
			 * "\",@p_createdBy,@p_organization,@p_orgDivision),";}
			 * 
			 * } if (!multidocument.isEmpty()) { multidocument = multidocument.substring(0,
			 * multidocument.length() - 1); s = s + "@p_vendorDocuments='" + multidocument +
			 * "',"; }
			 */
			
			if (purchase.get(0).getDocumentList() != null && !purchase.get(0).getDocumentList().isEmpty()) {
				for (InventoryVendorDocumentModel m : purchase.get(0).getDocumentList()) {
					multidocument = multidocument + "(@p_quoId,\"" + m.getSlno() + "\",\"" + m.getDocName() + "\",\""
							+ m.getDocView() + "\",@p_createdby,@p_orgName,@p_orgDiv),"; 
				}
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			} else {
				s = s + "@p_vendorDocuments='',";
			}

		
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		return s;
	}
}
