package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.VendorDeliveryChallanModel;
import nirmalya.aatithya.restmodule.purchase.model.VendorInvoiceRestModel;

public class GenerateVendorInvoiceParam {
	public static String getAddInvoiceParam(List<VendorInvoiceRestModel> purchase) {
		String s = "";
		String listdata ="";
		String listdata1 ="";
		String vendorInvoice="";
		String poId="";
		String qutCreatedBy="";
		Double subTotal=0.00;
		Double qIGST=0.00;
		Double qCGST=0.00;
		Double qSGST=0.00;
		Double grandTotal=0.00;
		Boolean taxType=null;
        String vendorId="";
        String organization="";
        String orgDivision="";
        Double adjustment=0.00;
		String paymentTermId="";
		String dueDate="";
		String challan=""; 
		String challanDate="";
		String ebillNo=""; 
		String ebillDate="";
		Double totalFreightCharges=0.00;
		Double total=0.00;
		String vendorDeliveryChallan="";
		String project = "";
		Double tcsAmount = 0.00;
		String tcs = "";
		String tcstype = "";
		Double tdsAmount = 0.00;
		String tds = "";
		String tdstype = "";
		
		String transporterId = "";
		String transporterName = "";
		String carrierId = "";
		String vehicleNo = "";
		String driverName = "";
		String driverMobile = "";
		String eWayBillingNo = "";
		String invoiceNo = "";
		String multidocument = "";
		String createdBy = "";
		 String terms = "";
		
		for (VendorInvoiceRestModel m : purchase) {
			vendorInvoice=m.getVendorInvoice();
			poId=m.getPoId();
			qutCreatedBy=m.getQutCreatedBy();
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
			
			invoiceNo = m.getInvoiceNo();
			carrierId = m.getCarrierId();
			vehicleNo = m.getVehicleNo();
			driverName = m.getDriverName();
			driverMobile = m.getDriverMobile();
			eWayBillingNo = m.geteWayBillingNo();
			transporterId = m.getTransporterId();
			transporterName = m.getTransporterName();
			taxType=m.getTaxType();
			vendorId=m.getVendorId();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
		    if(m.getAdjustment()!=null) {
		    	adjustment=m.getAdjustment();
		    }
			
			paymentTermId=m.getPaymentTermId();
			dueDate=m.getDueDate();
			challan=m.getChallanId();
			challanDate=m.getChallanDate();
			ebillNo=m.getEbillNo();
			ebillDate=m.getEbillDate();
			vendorDeliveryChallan=m.getVendorDeliveryChallan();
			if(m.getTotalFreightCharges()!=null) {
				totalFreightCharges=m.getTotalFreightCharges();
		    }
			if(m.getTotal()!=null) {
				total=m.getTotal();
		    }
			
			project = m.getProject();
			if (m.getTcsAmount() != null) {
				tcsAmount = m.getTcsAmount();
			}
			tcs = m.getTcs();
			tcstype = m.getTcstype();
			if (m.getTdsAmount() != null && m.getTdsAmount() != "") {
				tdsAmount = Double.valueOf(m.getTdsAmount());
			}
			tds = m.getTds();
			tdstype = m.getTdstype();
			createdBy= m.getQutCreatedBy();
			terms= m.getTerms();
		}
		
		s = s + "@p_vendorInvoice='" + vendorInvoice + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_div='" + orgDivision + "',";
		s = s + "@p_adjustment='" +  adjustment + "',";
		s = s + "@p_tcsAmount=" + tcsAmount + ",";
		s = s + "@p_tcs='" + tcs + "',";
		s = s + "@p_tcstype='" + tcstype + "',";
		s = s + "@p_tdsAmount=" + tdsAmount + ",";
		s = s + "@p_tds='" + tds + "',";
		s = s + "@p_tdstype='" + tdstype + "',";
		s = s + "@p_paymentterm='" + paymentTermId + "',";
		s = s + "@p_dueDate='" +  dueDate + "',";
		s = s + "@p_challan='" + challan + "',"; 
		s = s + "@p_challanDate='" + challanDate+ "',";
		s = s + "@p_ebillNo='" + ebillNo + "',"; 
		s = s + "@p_ebillDate='" + ebillDate+ "',";
		s = s + "@p_totalFreightCharges='" +  totalFreightCharges + "',";
		s = s + "@p_total='" +  total + "',";
		s = s + "@p_vendorDeliveryChallan='" +  vendorDeliveryChallan + "',";
		s = s + "@p_project='" + project + "',";
		
		s = s + "@p_carrierId='" + carrierId + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_driverName='" + driverName + "',";
		s = s + "@p_driverMobile='" + driverMobile + "',";
		s = s + "@p_eWayBillingNo='" + eWayBillingNo + "',";
		s = s + "@p_transporterId='" + transporterId + "',";
		s = s + "@p_transporterName='" + transporterName + "',";
		s = s + "@p_invoiceNo='" + invoiceNo + "',";
	    s = s + "@p_createdBy='" + createdBy + "',";
	    s = s + "@p_terms='" + terms + "',";
	    
		for (VendorInvoiceRestModel m : purchase) {
			Double pending = 0.00;
            if(m.getPendingQuantity()!=null) {
            	pending=m.getPendingQuantity();
            }
        	Double receiving = 0.00;
            if(m.getReceivingQuantity()!=null) {
            	
            	receiving=m.getReceivingQuantity();
            	
            }
        	Double received = 0.00;
            if(m.getReceivedQuantity()!=null) {
            	received=m.getReceivedQuantity();
            }
			listdata = listdata + "(@p_vendorInvoice,@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + m.getUnitPrice() +"\",\"" + m.getDiscount() + "\",\""
					+ m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\"" + m.getHsnCode() + "\",\"" + m.getSku()
					+ "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + "," + m.getTaxableAmt() + ",@p_org,@p_div),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";
		
		for (VendorInvoiceRestModel m : purchase) {						
			listdata1 = listdata1 + "\"" + m.getSku() + "\",";
		}
		listdata1 = listdata1.substring(0, listdata1.length() - 1);
		s = s + "@p_sku='(" + listdata1 + ")',";
		
		
		for (InventoryVendorDocumentModel a : purchase.get(0).getDocumentList()) {
			if (!a.getDocumnentName().contentEquals("") && !a.getDocumnentName().contentEquals("null")) {
				multidocument = multidocument + "(@p_vendorInvoice,\"" + a.getDocumnentName() + "\",\""
						+ a.getFileName() + "\",@p_createdBy,@p_org,@p_div),";
			}

		}
		if (!multidocument.isEmpty()) {
			multidocument = multidocument.substring(0, multidocument.length() - 1);
			s = s + "@p_vendorDocuments='" + multidocument + "',";
		}
		
		
		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		return s;
	}
	
	public static String getDeleteParamnew(VendorInvoiceRestModel purchase) {
		String[] userIds = purchase.getVendorInvoice().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_vendorInvoice='" + litem + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
