package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;

public class GenerateSalesInvoiceNewParameter {
	public static String getAddSalesInvoiceParam(List<RestSalesInvoiceNewModel> customer) {
		String s = "";
		String listdata ="";
		String saleInvoice="";
		String poId="";
		String qutCreatedBy="";
		Double subTotal=0.00;
		Double qIGST=0.00;
		Double qCGST=0.00;
		Double qSGST=0.00;
		Double grandTotal=0.00;
		Boolean taxType=null;
        String custId="";
        String organization="";
        String orgDivision="";
        Double adjustment=0.00;
    	Double tcsAmount=0.00;
		String tcs="";
		
		String dueDate="";
		String challan=""; 
		String challanDate="";
		String ebillNo=""; 
		String ebillDate="";
		String sacCode="";
		String categoryId=""; 
		String projectId="";
		Double totalFreightCharges=0.00;
		Double total=0.00;
		for (RestSalesInvoiceNewModel m : customer) {
			saleInvoice=m.getSaleInvoice();
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
			
			taxType=m.getTaxType();
			System.out.println("taxType"+m.getTaxType());
			custId=m.getCustId();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
		    if(m.getAdjustment()!=null) {
		    	adjustment=m.getAdjustment();
		    }
			if(m.getTcsAmount()!=null) {
				tcsAmount=m.getTcsAmount();
			}
			tcs=m.getTcs();
			
			dueDate=m.getDueDate();
			challan=m.getChallanId();
			challanDate=m.getChallanDate();
			ebillNo=m.getEbillNo();
			ebillDate=m.getEbillDate();
			
			sacCode=m.getSacCode();
			categoryId=m.getCategoryId();
			projectId=m.getProjectId();
			if(m.getTotalFreightCharges()!=null) {
				totalFreightCharges=m.getTotalFreightCharges();
		    }
			if(m.getTotal()!=null) {
				total=m.getTotal();
		    }
			
		}
		
		s = s + "@p_salesInvoice='" + saleInvoice + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_div='" + orgDivision + "',";
		/*
		 * s = s + "@p_adjustment='" + adjustment + "',"; s = s + "@p_tcsAmount='" +
		 * tcsAmount + "',"; s = s + "@p_tcs='" + tcs + "',"; s = s + "@p_dueDate='" +
		 * dueDate + "',"; s = s + "@p_challan='" + challan + "',"; s = s +
		 * "@p_challanDate='" + challanDate+ "',"; s = s + "@p_ebillNo='" + ebillNo +
		 * "',"; s = s + "@p_ebillDate='" + ebillDate+ "',"; s = s +
		 * "@p_totalFreightCharges='" + totalFreightCharges + "',"; s = s + "@p_total='"
		 * + total + "',";
		 */
		s = s + "@p_sacCode='" + sacCode + "',";
		s = s + "@p_categoryId='" + categoryId + "',";
		s = s + "@p_projectId='" + projectId + "',";
		 
		for (RestSalesInvoiceNewModel m : customer) {
			listdata = listdata + "(@p_salesInvoice,@p_poId,@p_projectId,@p_qutCreatedBy,@p_org,@p_div,\"" + m.getCategoryId() + "\",\"" + m.getCategoryName() + "\",\""
					+ m.getPaymentTerm() + "\"," + m.getLineTotal() + "," + m.getCurrVal() +"," + m.getTotalAmnt() + "),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		System.out.println("Item Details"+s);
		return s;
	}
	
	public static String getDeleteParamnew(RestSalesInvoiceNewModel customer) {
		String[] userIds = customer.getSaleInvoice().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_salesInvoice='" + litem + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE"+s);

		return s;
	}
//
	public static String getAddSalesOrderInvoiceParam(List<RestSalesInvoiceNewModel> customer) {
		String s = "";
		String listdata ="";

		
		String type = "" ;
		String custId1 = "" ;
		String custName1 = "" ;
		String soId = "" ;
		String salesRId = "" ;
		String challanIds = "" ;
		String saleDeliverysales1 = "" ;
		String invoiceDate = "" ;
		String paymentTerm = "" ;
		String dueDate = "" ;
		String dateofSupply = "" ;
		String vehicleNo = "" ;
		String transporterId = "" ;
		String transporterName = "" ;
		String lrNumber = "" ;
		String otherreference = "" ;
		String destination = "" ;
		Boolean taxType=null;							
		Double subTotal = 0.0 ;
		Double grandTotal = 0.0 ;
		Double qIGST = 0.0 ;
		Double qCGST = 0.0 ;
		Double qSGST = 0.0 ;
		Double adjustment = 0.0 ;
		String ebillNo = "" ;
		String ebillDate = "" ;
		String tMode = "" ;
		String shippingHiddenId = "" ;
		Double total = 0.0 ;
      String organization="";
      String orgDivision="";
      String qutCreatedBy="";
      
      String expectedShipmentDate1="";
      String deliveryTerm1="";
      String deliveryMode1="";
      String piRemarks="";
      
		for (RestSalesInvoiceNewModel m : customer) {
			saleDeliverysales1=m.getSaleDeliverysales1();
			soId=m.getSoId();
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
			custId1=m.getCustId1();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
			type=m.getType();
			paymentTerm=m.getPaymentTerm();
				dueDate = m.getDueDate();
			ebillNo=m.getEbillNo();
			ebillDate=m.getEbillDate();
			shippingHiddenId=m.getShippingHiddenId();
			invoiceDate=m.getInvoiceDate();
			shippingHiddenId = m.getShippingHiddenId();
			
			dateofSupply = m.getDateOfSupply();
			tMode = m.gettMode();
			vehicleNo = m.getVehicleNo();
			transporterId = m.getTransporterId();
			transporterName = m.getTransporterName();
			lrNumber = m.getLrNumber();
			ebillNo = m.getEbillNo();
			ebillDate = m.getEbillDate();
			challanIds = m.getChallanIds() ;
		//	dateofSupply1 = m.getDateOfSupply() ;
			destination = m.getDestination() ;
			otherreference = m.getOtherreference() ;
	//		saleDeliverysales = m.getSaleDeliverysales() ;
		//	subTotal = m.getSubtotal() ;
			total = m.getTotal() ;
			type = m.getType() ;
			salesRId = m.getSalesRId() ;
			
			expectedShipmentDate1 = m.getExpectedShipmentDate1() ;
			deliveryTerm1 = m.getDeliveryTerm1();
			deliveryMode1 = m.getDeliveryMode1() ;
			piRemarks = m.getPiRemarks() ;
		}
		
		s = s + "@p_salesInvoice='" + saleDeliverysales1 + "',";
		s = s + "@p_soId='" + soId + "',";
		s = s + "@p_salesReferenceId='" + salesRId + "',";
		s = s + "@p_type='" + type + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		
		s = s + "@p_custId='" + custId1 + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_div='" + orgDivision + "',";
		s = s + "@p_adjustment=" +  adjustment + ",";
		s = s + "@p_paymentterm='" + paymentTerm + "',";
		if(dueDate!=null && dueDate!="" && dueDate!="null") {
			s = s + "@p_dueDate='" +  dueDate + "',";
		}
		s = s + "@p_challanIds='" + challanIds + "',"; 
		s = s + "@p_ebillNo='" + ebillNo + "',"; 
		s = s + "@p_ebillDate='" + ebillDate+ "',";
		s = s + "@p_total=" +  total + ",";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',"; 
		s = s + "@p_invoiceDate='" + invoiceDate + "',"; 
			s = s + "@p_dateofSupply='" +  dateofSupply + "',";
		s = s + "@p_tMode='" + tMode + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_transporterId='" + transporterId + "',";
		s = s + "@p_transporterName='" + transporterName + "',";
		s = s + "@p_lrNumber='" + lrNumber + "',";
		s = s + "@p_eWayBillNo='" + ebillNo + "',";
		if(ebillDate!=null && ebillDate!="" && ebillDate!="null") {
			s = s + "@p_eWayBillDate='" + ebillDate + "',";
		}
		s = s + "@p_shipmentId='" + shippingHiddenId + "',";
		
		s = s + "@p_expectedDeliveryDate='" + expectedShipmentDate1 + "',";
		s = s + "@p_deliveryTerm='" + deliveryTerm1 + "',";
		s = s + "@p_deliveryMode='" + deliveryMode1 + "',";
		s = s + "@p_piRemarks='" + piRemarks + "',";

		
		System.out.println("sssssssssssssssss"+customer);
		for (RestSalesInvoiceNewModel m : customer) {
			listdata = listdata + "(@p_salesReferenceId,@p_soId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + m.getUnitPrice() +"\",\"" + m.getDiscount() + "\",\""
					+ m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\"" + m.getHsnCode() + "\",\"" + m.getSku()+ "\",\""
					+ m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + "," + m.getTaxableAmt() + "),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		System.out.println("Item Details"+s);
		return s;
	}
}
