package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceReturnModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;


public class GenerateManageInvoiceReturnParam {
	public static String getAddInvoiceReturn(List<RestManageInvoiceReturnModel> purchase) {
		String s = "";
		String listdata = "";
		String vendorId = "";
		String invoiceId = "";
		String poId = "";
		String invoiceNo = "";
		String invoiceReturnId = "";
		String referenceNo = "";
		String referenceDate = "";
		String otherReference="";
		String exptdeliveryDate = "";
		String qutDescription = "";
		String terms="";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;
        Double adjustment = 0.00;
        String tcs = "";
		Double tcsAmount = 0.00;
		String createdBy = "";
		String organization = "";
		String orgDivision = "";

		String multidocument = "";
		String project = "";

		
		System.out.println("purchaseeeeeeeeeeeeeeeee"+purchase);

		for (RestManageInvoiceReturnModel m : purchase) {
			vendorId = m.getVendorId();
			invoiceId = m.getInvoiceId();
			invoiceReturnId = m.getInvoiceReturnId();
			poId = m.getPoId();
			invoiceNo = m.getInvoiceNo();
			exptdeliveryDate = m.getExptdeliveryDate();
			qutDescription = m.getQutDescription();
			terms = m.getTerms();
			
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
			taxType = m.getTaxType();
			 if(m.getAdjustment()!=null) {
			    	adjustment=m.getAdjustment();
			    }
			tcs = m.getTcs();
			if(m.getTcsAmount()!=null) {
				tcsAmount=m.getTcsAmount();
			}
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			project = m.getProject();
			
		}
		
		
		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_invoiceId='" + invoiceId + "',";
		s = s + "@p_invoiceReturnId='" + invoiceReturnId + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_invoiceNo='" + invoiceNo + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_terms='" + terms + "',";
		s = s + "@p_subTotal=" + subTotal + ",";
		s = s + "@p_qIGST=" + qIGST + ",";
		s = s + "@p_qCGST=" + qCGST + ",";
		s = s + "@p_qSGST=" + qSGST + ",";
        s = s + "@p_grandTotal=" + grandTotal + ",";
        s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_adjustment=" + adjustment + ",";
		s = s + "@p_tcs='" + tcs + "',";
		s = s + "@p_tcsAmount=" + tcsAmount + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_project='" + project + "',";
		

		if (!purchase.get(0).getInvoiceReturnId().contentEquals("1")) {

			for (RestManageInvoiceReturnModel m : purchase) {
				Double pending = 0.00;
            if(m.getPendingQuantity()!=null) {
            	pending=m.getPendingQuantity();
            }
           
        	Double returning = 0.00;
            if(m.getReturningQuantity()!=null) {
            	
            	returning=m.getReturningQuantity();
            	
            }
        	Double received = 0.00;
            if(m.getReceivedQuantity()!=null) {
            	received=m.getReceivedQuantity();
            }
            System.out.println("returning "+returning);
				listdata = listdata + "(@p_invoiceReturnId,@p_invoiceId,@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName()
						+ "\",\"" + m.getHsnCode() + "\"," + m.getQuantity() + "," + m.getUnitPrice() + "," + m.getDiscount() + ","
						+ m.getGstRate() + "," + m.getLineTotal() + ",\"" + m.getSku() + "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + ",\"" + m.getUnit() + "\"," + pending + ","+ received  +"," + returning + ",\"" + m.getDescription() + "\"," + m.getTaxableAmt() + ",@p_organization,@p_orgDivision),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";
			/*
			 * List<InventoryVendorDocumentModel> item2 = purchase.get(0).getDocumentList();
			 * if (purchase.get(0).getDocumentList().size() > 0) { for
			 * (InventoryVendorDocumentModel a : item2) { if
			 * (!a.getDocumnentName().contentEquals("") &&
			 * !a.getDocumnentName().contentEquals("null")) { multidocument = multidocument
			 * + "(@p_invoiceReturnId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
			 * + "\",@p_createdBy,@p_organization,@p_orgDivision),"; } }
			 * multidocument=multidocument.substring(0,multidocument.length()-1); }else {
			 * multidocument=""; } s = s + "@p_vendorDocuments='" + multidocument + "',";
			 */
			
			if (purchase.get(0).getDocumentList() != null && !purchase.get(0).getDocumentList().isEmpty()) {
				for (InventoryVendorDocumentModel m : purchase.get(0).getDocumentList()) {
					multidocument = multidocument + "(@p_invoiceReturnId,\"" + m.getSlno() + "\",\"" + m.getDocName() + "\",\""
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
		System.out.println("Item Details" + s);
		return s;
	}
	
	public static String getDeleteInvoice(RestManageInvoiceModel purchase) {
		String[] userIds = purchase.getPoId().split(",");
		System.out.println("purchase===="+purchase);
		
		String s = "";
		String litem = "";
		
		if (purchase.getOrganization() != null && purchase.getOrganization() != "") {
			s = s + "@p_orgName='" + purchase.getOrganization() + "',";
		}
		if (purchase.getOrgDivision() != null && purchase.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + purchase.getOrgDivision() + "',";
		}
		
		for (String a : userIds) {
			System.out.println("userIds===="+userIds);
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_invoiceId='" + litem + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE"+s);

		return s;
	}
	public static String getReturnInvoice(RestManageInvoiceModel returnInvoice) {
		System.out.println("purchase===="+returnInvoice);
		
		String s = "";
		
		if (returnInvoice.getOrganization() != null && returnInvoice.getOrganization() != "") {
			s = s + "@p_orgName='" + returnInvoice.getOrganization() + "',";
		}
		if (returnInvoice.getOrgDivision() != null && returnInvoice.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + returnInvoice.getOrgDivision() + "',";
		}
		if (returnInvoice.getInvoiceId() != null && returnInvoice.getInvoiceId() != "") {
			s = s + "@p_invoiceId='" + returnInvoice.getInvoiceId() + "',";
		}
		if (returnInvoice.getReceivingQuantity() != null) {
			s = s + "@p_returnQry='" + returnInvoice.getReceivingQuantity() + "',";
		}
		if (returnInvoice.getItemId() != null && returnInvoice.getItemId() != "") {
			s = s + "@p_itemId='" + returnInvoice.getItemId() + "',";
		}
		if (returnInvoice.getDescription() != null && returnInvoice.getDescription() != "") {
			s = s + "@p_description='" + returnInvoice.getDescription() + "',";
		}
		
		/*
		 * for (String a : userIds) { System.out.println("userIds===="+userIds); litem =
		 * litem + "\"" + a + "\","; } litem = litem.substring(0, litem.length() - 1);
		 * litem = "(" + litem + ")"; s = s + "@p_invoiceId='" + litem + "',";
		 * 
		 */
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE"+s);

		return s;
	}
	
	public static String getApproveGRNReturnParam(RestManageInvoiceReturnModel restManageInvoiceReturnModel) {

		String s = "";
		

		if(restManageInvoiceReturnModel.getOrganization() != null || restManageInvoiceReturnModel.getOrganization() != "") {
			s = s + "@p_org='" + restManageInvoiceReturnModel.getOrganization() + "',";
		}
		if(restManageInvoiceReturnModel.getOrgDivision() != null || restManageInvoiceReturnModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restManageInvoiceReturnModel.getOrgDivision() + "',";
		}
		if (restManageInvoiceReturnModel.getInvoiceReturnId() != null ||  restManageInvoiceReturnModel.getInvoiceReturnId() != "") {
			s = s + "@p_invreturnId='" + restManageInvoiceReturnModel.getInvoiceReturnId() + "',";
		}

		if (restManageInvoiceReturnModel.getPoId() != null ||  restManageInvoiceReturnModel.getPoId() != "") {
			s = s + "@p_poId='" + restManageInvoiceReturnModel.getPoId() + "',";
		}
		if (restManageInvoiceReturnModel.getVendorId() != null || restManageInvoiceReturnModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + restManageInvoiceReturnModel.getVendorId() + "',";
		}

		if (restManageInvoiceReturnModel.getInvoiceId() != null ||  restManageInvoiceReturnModel.getInvoiceId() != "") {
			s = s + "@p_invoiceId='" + restManageInvoiceReturnModel.getInvoiceId() + "',";
		}
		
		if (restManageInvoiceReturnModel.getCreatedBy() != null ||  restManageInvoiceReturnModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restManageInvoiceReturnModel.getCreatedBy() + "',";
		}

		if (restManageInvoiceReturnModel.getReturningQuantity() != null) {
			s = s + "@p_returnQty=" + restManageInvoiceReturnModel.getReturningQuantity() + ",";
		}
		if (restManageInvoiceReturnModel.getApproveStatus() != null ||  restManageInvoiceReturnModel.getApproveStatus() != "") {
			s = s + "@p_approveSts='" + restManageInvoiceReturnModel.getApproveStatus() + "',";
		}

		if (restManageInvoiceReturnModel.getCreditNoteAmt() != null) {
			s = s + "@p_creditNoteAmt='" + restManageInvoiceReturnModel.getCreditNoteAmt() + "',";
		}
		if (restManageInvoiceReturnModel.getGstAmount() != null) {
			s = s + "@p_gstAmt='" + restManageInvoiceReturnModel.getGstAmount() + "',";
		}
		if (restManageInvoiceReturnModel.getGrandTotal1() != null) {
			s = s + "@p_totalAmt='" + restManageInvoiceReturnModel.getGrandTotal1() + "',";
		}
		s = s + "@p_creditId='" + restManageInvoiceReturnModel.getCreditNoteId() + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}	
}
