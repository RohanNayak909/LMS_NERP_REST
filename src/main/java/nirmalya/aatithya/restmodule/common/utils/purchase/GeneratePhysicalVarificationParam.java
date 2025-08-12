package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceReturnModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPhysicalVarificationModel;



public class GeneratePhysicalVarificationParam {
	public static String getAddVarificationDetils(List<RestPhysicalVarificationModel> purchase) {
		String s = "";
		String listdata = "";
		String listdata1 = "";
		String idata = "";
		String vendorId = "";
		String invoiceId = "";
		String poId = "";
		String invoiceNo = "";
		String varificationId = "";
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
		String sku1 = "";
		String productId1 = "";
		String project = "";
		
		System.out.println("purchaseeeeeeeeeeeeeeeee"+purchase);

		for (RestPhysicalVarificationModel m : purchase) {
			vendorId = m.getVendorId();
			invoiceId = m.getInvoiceId();
			varificationId = m.getVarificationId();
			poId = m.getPoId();
			invoiceNo = m.getInvoiceNo();
			exptdeliveryDate = m.getExptdeliveryDate();
			qutDescription = m.getQutDescription();
			terms = m.getTerms();
			project = m.getProject();
			
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
			sku1 =m.getSku();
		    productId1 = m.getItemId();
			
		}
		
		
		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_invoiceId='" + invoiceId + "',";
		s = s + "@p_varificationId='" + varificationId + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_invoiceNo='" + invoiceNo + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_terms=\"" + terms + "\",";
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
		s = s + "@p_sku1='" + sku1 + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_productId1='" + productId1 + "',";
		//s = s + "@p_litemUpdate='(" + productId1 + ")';";

		if (!purchase.get(0).getVarificationId().contentEquals("1")) {

			for (RestPhysicalVarificationModel m : purchase) {
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
            idata = idata+"\"" + m.getItemId() + "\""+",";
        
            System.out.println("returning "+returning);
				listdata = listdata + "(@p_varificationId,@p_invoiceId,@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName()
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
			 * + "(@p_varificationId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
			 * + "\",@p_createdBy,@p_organization,@p_orgDivision),"; } }
			 * multidocument=multidocument.substring(0,multidocument.length()-1); }else {
			 * multidocument=""; } s = s + "@p_vendorDocuments='" + multidocument + "',";
			 */
			
			if (purchase.get(0).getDocumentList() != null && !purchase.get(0).getDocumentList().isEmpty()) {
				for (InventoryVendorDocumentModel m : purchase.get(0).getDocumentList()) {
					multidocument = multidocument + "(@p_varificationId,\"" + m.getSlno() + "\",\"" + m.getDocName() + "\",\""
							+ m.getDocView() + "\",@p_createdby,@p_orgName,@p_orgDiv),"; 
				}
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			} else {
				s = s + "@p_vendorDocuments='',";
			}
			
			if(!idata.isEmpty()) {
				idata = idata.substring(0, idata.length() - 1);
				s = s + "@p_idata='(" + idata + ")',";
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
}