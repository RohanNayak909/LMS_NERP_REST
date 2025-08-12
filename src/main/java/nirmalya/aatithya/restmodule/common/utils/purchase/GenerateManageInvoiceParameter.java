package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestGrnReturnExcelModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;


public class GenerateManageInvoiceParameter {
	public static String getAddInvoice(List<RestManageInvoiceModel> purchase) {
		String s = "";
		String listdata = "";
		String vendorId = "";
		String invoiceId = "";
		String poId = "";
		String qutValidDate="";
		String paymentTermId = "";
		String advance = "";
		String invoiceNo = "";
		String reference = "";
		String carrierId = "";
		String vehicleNo = "";
		String driverName = "";
		String driverMobile = "";
		String eWayBillingNo = "";
		String eWayBillDate = "";
		String modeTermsPayment = "";
		String referenceNo = "";
		String referenceDate = "";
		String otherReference="";
		String shippingDetails = "";
		String orgDetails = "";
		String custDetails = "";
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
		String requestType = "";
		String freightAmtMain = "";
		
		

		String multidocument = "";
		String gatePass = "";
		String transporterId = "";
		String transporterName = "";
		String receivingDocType = "";
		String challanNum = "";
		String challanDate = "";
		String invoiceDate = "";
		String project = "";
		String poDeliveryDate = "";
		String sapId = "";
		String poDocDate = "";
		
		
		String grnCreateType = "";
		String capexHeader = "";
		String lrNoGRN = "";
		System.out.println("purchaseeeeeeeeeeeeeeeee"+purchase);

		for (RestManageInvoiceModel m : purchase) {
			vendorId = m.getVendorId();
			invoiceId = m.getInvoiceId();
			poId = m.getPoId();
			qutValidDate=m.getQutValidDate();
			paymentTermId = m.getPaymentTermId();
			advance = m.getAdvance();
			invoiceNo = m.getInvoiceNo();
			reference = m.getReference();
			carrierId = m.getCarrierId();
			vehicleNo = m.getVehicleNo();
			driverName = m.getDriverName();
			driverMobile = m.getDriverMobile();
			
			
			
			eWayBillingNo = m.geteWayBillingNo();
			eWayBillDate = m.geteWayBillDate();
			modeTermsPayment = m.getModeTermsPayment();
			/*
			 * referenceNo = m.getReferenceNo(); referenceDate = m.getReferenceDate();
			 * otherReference = m.getOtherReference();
			 */
			shippingDetails = m.getShippingDetails();
			orgDetails = m.getOrgDetails();
			custDetails = m.getCustDetails();
			exptdeliveryDate = m.getExptdeliveryDate();
			qutDescription = m.getQutDescription();
			terms = m.getTerms();
			project = m.getProject();
			poDeliveryDate = m.getPoDeliveryDate();
			sapId = m.getSapId();
			freightAmtMain = m.getFreightAmtMain();
			poDocDate = m.getPoDocDate();
			
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
			//adjustment = m.getAdjustment();
			 if(m.getAdjustment()!=null) {
			    	adjustment=m.getAdjustment();
			    }
			tcs = m.getTcs();
			if(m.getTcsAmount()!=null) {
				tcsAmount=m.getTcsAmount();
			}
			//tcsAmount = m.getTcsAmount();
			
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			requestType = m.getRequestType();
			
			gatePass = m.getGatePass();
			transporterId = m.getTransporterId();
			transporterName = m.getTransporterName();
			lrNoGRN = m.getLrNoGRN();
			receivingDocType = m.getReceivingDocType();
			challanNum = m.getChallanNum();
			challanDate = m.getChallanDate();
			invoiceDate = m.getInvoiceDate();
			grnCreateType = m.getGrnCreateType();
			capexHeader = m.getCapexHeader();
			
		}
		
		
		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_invoiceId='" + invoiceId + "',";
		s = s + "@p_poId='" + poId + "',";
		if(qutValidDate!="null" && qutValidDate!="") {
			s = s + "@p_qutValidDate='" + DateFormatter.getStringDate(qutValidDate) + "',";
		}
		s = s + "@p_paymentTermId='" + paymentTermId + "',";
		s = s + "@p_advance='" + advance + "',";
		//s = s + "@p_invoiceNo='" + invoiceNo + "',";
		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_carrierId='" + carrierId + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_driverName='" + driverName + "',";
		s = s + "@p_driverMobile='" + driverMobile + "',";
		s = s + "@p_eWayBillingNo='" + eWayBillingNo + "',";
		s = s + "@p_eWayBillDate='" + eWayBillDate + "',";
		s = s + "@p_modeTermsPayment='" + modeTermsPayment + "',";
		/*
		 * s = s + "@p_referenceNo='" + referenceNo + "',"; s = s + "@p_referenceDate='"
		 * + DateFormatter.getStringDate(referenceDate) + "',"; s = s +
		 * "@p_otherReference='" + otherReference + "',";
		 */
		s = s + "@p_shippingDetails='" + shippingDetails + "',";
		s = s + "@p_orgDetails='" + orgDetails + "',";
		s = s + "@p_custDetails='" + custDetails + "',";
		//s = s + "@p_exptdeliveryDate='" + DateFormatter.getStringDate(exptdeliveryDate) + "',";
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
		s = s + "@p_requestType='" + requestType + "',";
		s = s + "@p_freightAmtMain='" + freightAmtMain + "',";
		
		
		
		
		s = s + "@p_gatePass='" + gatePass + "',";
		s = s + "@p_transporterId='" + transporterId + "',";
		s = s + "@p_transporterName='" + transporterName + "',";
		s = s + "@p_lrNoGRN='" + lrNoGRN + "',";
		s = s + "@p_receivingDocType='" + receivingDocType + "',";
		s = s + "@p_challanNum='" + challanNum + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_grnCreateType='" + grnCreateType + "',";
		s = s + "@p_capexHeader='" + capexHeader + "',";
		if(sapId!="null" && sapId!="") {
			s = s + "@p_sapId='" + sapId + "',";
		}else {
			s = s + "@p_sapId='" + " " + "',";
		}
		if(poDocDate!="null" && poDocDate!="") {
			s = s + "@p_poDocDate='" + DateFormatter.getStringDate(poDocDate) + "',";
		}
		if(poDeliveryDate!="null" && poDeliveryDate!="") {
			s = s + "@p_poDeliveryDate='" + DateFormatter.getStringDate(poDeliveryDate) + "',";
		}
		if(challanDate!="null" && challanDate!="") {
		s = s + "@p_challanDate='" + DateFormatter.getStringDate(challanDate) + "',";
		}
		if(invoiceDate!="null" && invoiceDate!="") {
			s = s + "@p_invoiceDate='" + DateFormatter.getStringDate(invoiceDate) + "',";
			}
		if (!purchase.get(0).getInvoiceId().contentEquals("1")) {

			for (RestManageInvoiceModel m : purchase) {
				Double pending = 0.00;
            if(m.getPendingQuantity()!=null) {
            	pending=m.getPendingQuantity();
            }
            System.out.println("pending "+pending);
        	Double receiving = 0.00;
            if(m.getReceivingQuantity()!=null) {
            	
            	receiving=m.getReceivingQuantity();
            	
            }
        	Double received = 0.00;
            if(m.getReceivedQuantity()!=null) {
            	received=m.getReceivedQuantity();
            }
            System.out.println("SKU "+m.getDescription());
				listdata = listdata + "(@p_invoiceId,@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName()
						+ "\",\"" + m.getHsnCode() + "\",\"" + m.getChallan_no() + "\",\"" + m.getChallan_dt() + "\"," + m.getBillquantity() + "," + m.getQuantity() + "," + m.getUnitPrice() + "," + m.getDiscount() + ","
						+ m.getGstRate() + "," + m.getLineTotal() + ",\"" + m.getSku() + "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + "," + m.getFreightAmt() 
						+ ",\"" + m.getUnit() + "\"," + pending + "," + receiving + ", " +received+ ",\"" + m.getDescription() + "\"," + m.getTaxableAmt()  
						+ ",@p_organization,@p_orgDivision,\"" + m.getModelSize() + "\",\"" + m.getSapno() + "\",\"" + m.getDiscountRateType() +"\"),";
			}
			System.out.println("listData>>----- "+listdata);
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";

			/*
			 * List<InventoryVendorDocumentModel> item2 = purchase.get(0).getDocumentList();
			 * if (purchase.get(0).getDocumentList().size() > 0) { for
			 * (InventoryVendorDocumentModel a : item2) { if
			 * (!a.getDocumnentName().contentEquals("") &&
			 * !a.getDocumnentName().contentEquals("null")) { multidocument = multidocument
			 * + "(@p_invoiceId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() +
			 * "\",@p_createdBy,@p_organization,@p_orgDivision),"; } }
			 * multidocument=multidocument.substring(0,multidocument.length()-1); }else {
			 * multidocument=""; } s = s + "@p_vendorDocuments='" + multidocument + "',";
			 */
			
			
			if (purchase.get(0).getDocumentList() != null && !purchase.get(0).getDocumentList().isEmpty()) {
				for (InventoryVendorDocumentModel m : purchase.get(0).getDocumentList()) {
					multidocument = multidocument + "(@p_invoiceId,\"" + m.getSlno() + "\",\"" + m.getDocName() + "\",\""
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
	
	
	public static String getDeleteGrn(RestManageInvoiceModel purchase) {
		String[] id = purchase.getPoId().split(",");
		System.out.println("purchase===="+purchase);
		
		String s = "";
		String litem = "";
		
		if (purchase.getOrganization() != null && purchase.getOrganization() != "") {
			s = s + "@p_orgName='" + purchase.getOrganization() + "',";
		}
		if (purchase.getOrgDivision() != null && purchase.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + purchase.getOrgDivision() + "',";
		}
		if (purchase.getCreatedBy() != null && purchase.getCreatedBy() != "") {
			s = s + "@p_craetedBy='" + purchase.getCreatedBy() + "',";
		}
		
		for (String a : id) {
			System.out.println("userIds===="+id);
			//litem = litem + "\"" + a + "\",";
			litem = litem + a ;
		}
		//litem = litem.substring(0, litem.length() - 1);
		//litem = "(" + litem + ")";
		s = s + "@p_invoiceId='" + litem + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE"+s);

		return s;
	}
	
	public static String getDeleteInvoice(RestManageInvoiceModel purchase) {
		//String[] userIds = purchase.getPoId().split(",");
		System.out.println("purchase===="+purchase);
		
		String s = "";
		//String litem = purchase.getPoId();
	
		if (purchase.getOrganization() != null && purchase.getOrganization() != "") {
			s = s + "@p_orgName='" + purchase.getOrganization() + "',";
		}
		if (purchase.getOrgDivision() != null && purchase.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + purchase.getOrgDivision() + "',";
		}
		if (purchase.getCreatedBy() != null && purchase.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + purchase.getCreatedBy() + "',";
		}
		
		/*
		 * for (String a : userIds) { System.out.println("userIds===="+userIds); litem =
		 * litem + "\"" + a + "\","; //litem = litem + a ; }
		 */
		/*
		 * litem = litem.substring(0, litem.length() - 1); litem = "(" + litem + ")";
		 */
		//s = s + "@p_invoiceId='" + litem + "',";
		s = s + "@p_invoiceId='" + purchase.getPoId() + "',";
		
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
	public static String getAddPurchaseInvoice(List<RestManageInvoiceModel> purchase) {
		String s = "";
		String listdata = "";
		String vendorId = "";
		String invoiceId = "";
		String poId = "";
		String qutValidDate="";
		String paymentTermId = "";
		String invoiceNo = "";
		String reference = "";
		String carrierId = "";
		String vehicleNo = "";
		String driverName = "";
		String driverMobile = "";
		String eWayBillingNo = "";
		String modeTermsPayment = "";
		String shippingDetails = "";
		String orgDetails = "";
		String custDetails = "";
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
		
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String requestType = "";
		
		String taxInvNo = "";
		String taxInvDt = "";

		String multidocument = "";
		String gatePass = "";
		String transporterId = "";
		String transporterName = "";
		String receivingDocType = "";
		String challanNum = "";
		String challanDate = "";
		String invoiceDate = "";
		String project = "";
		String purchaseGRNId = "";
		
		String tcsValue = "";
		String tdsValue = "";
		String tcsType = "";
		String tdsType = "";
		Double tcsAmount = 0.00;
		String tdsAmount = "";
		
		
		String netAmount = "";
		
		
		String freightAmtMain = "";
		
		String grnCreateType = "";
		String capexHeader = "";

		for (RestManageInvoiceModel m : purchase) {
			vendorId = m.getVendorId();
			invoiceId = m.getInvoiceId();
			poId = m.getPoId();
			qutValidDate=m.getQutValidDate();
			paymentTermId = m.getPaymentTermId();
			reference = m.getReference();
			carrierId = m.getCarrierId();
			vehicleNo = m.getVehicleNo();
			driverName = m.getDriverName();
			driverMobile = m.getDriverMobile();
			eWayBillingNo = m.geteWayBillingNo();
			
			taxInvNo = m.getTaxInvNo();
			taxInvDt = m.getTaxInvDt();
			
			modeTermsPayment = m.getModeTermsPayment();
			shippingDetails = m.getShippingDetails();
			orgDetails = m.getOrgDetails();
			custDetails = m.getCustDetails();
			qutDescription = m.getQutDescription();
			terms = m.getTerms();
			project = m.getProject();
			purchaseGRNId = m.getPurchaseGRNId();
			freightAmtMain = m.getFreightAmtMain();
			
			grnCreateType = m.getGrnCreateType();
			capexHeader = m.getCapexHeader();
			
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
			requestType = m.getRequestType();
			transporterId = m.getTransporterId();
			transporterName = m.getTransporterName();
			invoiceDate = m.getInvoiceDate();
			tcsValue = m.getTcsValue();
			tdsValue = m.getTdsValue();
			tcsType = m.getTcsType();
			tdsType = m.getTdsType();
			tdsAmount = m.getTdsAmount();
			netAmount = m.getNetAmount();
		}
		
		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_invoiceId='" + invoiceId + "',";
		s = s + "@p_poId='" + poId + "',";
		if(qutValidDate!="null" && qutValidDate!="") {
			s = s + "@p_qutValidDate='" + DateFormatter.getStringDate(qutValidDate) + "',";
		}
		s = s + "@p_paymentTermId='" + paymentTermId + "',";
		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_carrierId='" + carrierId + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_driverName='" + driverName + "',";
		s = s + "@p_driverMobile='" + driverMobile + "',";
		s = s + "@p_eWayBillingNo='" + eWayBillingNo + "',";
		s = s + "@p_modeTermsPayment='" + modeTermsPayment + "',";
		s = s + "@p_shippingDetails='" + shippingDetails + "',";
		s = s + "@p_orgDetails='" + orgDetails + "',";
		s = s + "@p_custDetails='" + custDetails + "',";
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
		s = s + "@p_requestType='" + requestType + "',";
		
		s = s + "@p_grnCreateType='" + grnCreateType + "',";
		s = s + "@p_capexHeader='" + capexHeader + "',";
		
		s = s + "@p_taxInvNo='" + taxInvNo + "',";
		if(taxInvDt!="null" && taxInvDt!="") {
			s = s + "@p_taxInvDt='" + DateFormatter.getStringDate(taxInvDt) + "',";
		}
		
		s = s + "@p_transporterId='" + transporterId + "',";
		s = s + "@p_transporterName='" + transporterName + "',";
		s = s + "@p_receivingDocType='" + receivingDocType + "',";
		s = s + "@p_challanNum='" + challanNum + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_purchaseGRNId='" + purchaseGRNId + "',";
		s = s + "@p_freightAmtMain='" + freightAmtMain + "',";
		s = s + "@p_tcsValue='" + tcsValue + "',";
		s = s + "@p_tdsValue='" + tdsValue + "',";
		s = s + "@p_tcsType='" + tcsType + "',";
		s = s + "@p_tdsType='" + tdsType + "',";
		s = s + "@p_tdsAmount='" + tdsAmount + "',";
		s = s + "@p_netAmount='" + netAmount + "',";
		if(challanDate!="null" && challanDate!="") {
		s = s + "@p_challanDate='" + DateFormatter.getStringDate(challanDate) + "',";
		}
		if(invoiceDate!="null" && invoiceDate!="") {
			s = s + "@p_invoiceDate='" + DateFormatter.getStringDate(invoiceDate) + "',";
			}
		if (!purchase.get(0).getInvoiceId().contentEquals("1")) {

			for (RestManageInvoiceModel m : purchase) {
				
				listdata = listdata + "(@p_invoiceId,@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName()
						+ "\",\"" + m.getHsnCode() + "\",\"" + m.getTaxInvNo() + "\",\"" + m.getTaxInvDt() + "\"," + m.getQuantity() + "," + m.getUnitPrice() + "," + m.getDiscount() + "," + m.getDiscountRateType() + ","
						+ m.getGstRate() + "," + m.getLineTotal() + ",\"" + m.getSku() + "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + ",\"" + m.getFreightAmount() + "\",\"" +  m.getUnit() + "\",\"" + m.getDescription() + "\"," + m.getTaxableAmt()  + ",@p_organization,@p_orgDivision,\"" + m.getModelSize() + "\",\"" + m.getSapno() + "\"),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";

			/*
			 * for (InventoryVendorDocumentModel a : purchase.get(0).getDocumentList()) {
			 * if(!a.getDocumnentName().contentEquals("") &&
			 * !a.getDocumnentName().contentEquals("null")) { multidocument = multidocument
			 * + "(@p_invoiceId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() +
			 * "\",@p_createdBy,@p_organization,@p_orgDivision),";}
			 * 
			 * } if (!multidocument.isEmpty()) { multidocument = multidocument.substring(0,
			 * multidocument.length() - 1); s = s + "@p_vendorDocuments='" + multidocument +
			 * "',"; }
			 */
			
			if (purchase.get(0).getDocumentList() != null && !purchase.get(0).getDocumentList().isEmpty()) {
				for (InventoryVendorDocumentModel m : purchase.get(0).getDocumentList()) {
					multidocument = multidocument + "(@p_invoiceId,\"" + m.getSlno() + "\",\"" + m.getDocName() + "\",\""
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
	
	//excel grn recieve
	public static String addGrnRecieveExcelDataParam(List<RestGrnReturnExcelModel> data) {
		String s = "";
		// String emplist = "";
		String datalist = "";
		
		if (data.size() > 0) {
			for (RestGrnReturnExcelModel m : data) {
				//System.out.println("dddddddddddddddddddddddd"+m.getNetWeight());
				datalist = datalist + "(\"" + m.getInvoiceNo() + "\",\"" + m.getPoNo() + "\",\"" + DateFormatter.getStringDate(m.getGrDate()) + "\",\""
						+ m.getVendorName() + "\",\"" + m.getMaterialCode() + "\", \"" + m.getMaterialDesc() + "\",\""
					    + m.getMaterialQty() + "\",\"" + m.getMaterialUom() + "\",\"" + m.getGrNo() + "\",\"" + m.getTransporterName() + "\",\""
					    + m.getPlant() + "\",\"" + m.getTotalCost() + "\",\"" + m.getPoItem() + "\",\"" + m.getVendorId() + "\",\""
					    + m.getTransporterId() + "\",\"" + m.getDocType() + "\",\""
					    + m.getMvtType() + "\",\"" + m.getBatch() + "\",\"" + m.getBasicValue() + "\",\""  + m.getTruckNo() + "\",\""
					    + m.getMaterialType() + "\", \""+ DateFormatter.getStringDate(m.getPoDocDate()) + "\",\"" + m.getFrtBefTax() + "\",\"" + m.getFreight() + "\",\"" + m.getIgstPercent() + "\",\""
					    + m.getIgstAmount() + "\",\"" + m.getCgstPercent() + "\",\"" + m.getCgstAmount() + "\",\"" + m.getSgstPercent() + "\",\""
					    + m.getSgstAmount() + "\", \""+ DateFormatter.getStringDate(m.getInvoiceDate()) + "\",\"" + m.getVendorGst() + "\",\"" 
					    + m.getVendorRegionName() + "\",\"" + m.getSupplierStateId() + "\",\""
					    + m.getRecPlantStateCode() + "\",\"" + m.getHsnCode() + "\",\"" + m.getGoodsServiceToggle() + "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\""
						+ m.getOrgDivision() + "\"),";
			}
          
		}
		
		if (!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_GrnRecieveQuery='" + datalist + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		return s;
	}
	
}
