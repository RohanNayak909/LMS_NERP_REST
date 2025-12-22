package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

public class GenerateSaleOrderNewParameter {
	public static String getAddempParam(List<RestSaleOrderNewModel> customer) {
		String s = "";

		String listdata = "";
		String poId = "";
		String custId = "";
		String qutDescription = "";

		String qutCreatedBy = "";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;
		String salesOrder = "";
		String orderReceiveDate = "";

		String organization = "";
		String orgDivision = "";

		String expectedShipmentDate = "";
		String paymentTermId = "";
		String deliveryMethodId = "";
		String salesPerson = "";
		String tcs = "";
		String terms = "";
		String multidocument = "";
		String reference = "";
		String orderType = "";
		String salesOrderId = "";
		String project = "";
		
		String pan = "";
		String gstNo = "";
		String poNo = "";
		String deliveryMode="";
		String deliveryTerm="";
		Double tcsAmount = 0.00;
		String shippingHiddenId = "";
		String soRef = "";
		String endCustomerName = "";
		String salesPaymentTerm = "";
		String ourRefNo = "";
 
		for (RestSaleOrderNewModel m : customer) {
			poId = m.getPoId();
			custId = m.getCustId();
			qutDescription = m.getQutDescription();

			qutCreatedBy = m.getQutCreatedBy();
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
			grandTotal = m.getGrandTotal();
			taxType = m.getTaxType();
			salesOrder = m.getSalesOrder();
			orderReceiveDate = m.getOrderReceiveDate();
			expectedShipmentDate = m.getExpectedShipmentDate();
			paymentTermId = m.getPaymentTermId();
			deliveryMethodId = m.getDeliveryMethodId();
			salesPerson = m.getSalesPerson();
			terms = m.getTerms();
			reference = m.getReference();
			salesOrderId = m.getSalesOrderId();
			project = m.getProject();
			pan = m.getPan();
			gstNo = m.getGstNo();
			poNo = m.getPoNo();

			tcs = m.getTcs();
			if (m.getTcsAmount() != null) {
				tcsAmount = m.getTcsAmount();
			}
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			orderType = m.getOrderType();
			shippingHiddenId = m.getShippingHiddenId();
			deliveryMode = m.getDeliveryMode();
			deliveryTerm = m.getDeliveryTerm();
			soRef = m.getSoRef();
			endCustomerName = m.getEndCustomerName();
			salesPaymentTerm = m.getSalesPaymentTerm();
			ourRefNo = m.getOurRefNo();
		}

		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";

		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		/*
		 * s = s + "@p_qutSubTotal=" + subTotal + ","; s = s + "@p_qutIGST=" + qIGST +
		 * ","; s = s + "@p_qutCGST=" + qCGST + ","; s = s + "@p_qutSGST=" + qSGST +
		 * ","; s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		 */
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_salesId='" + salesOrder + "',";
		s = s + "@p_orderReceiveDate='" + orderReceiveDate + "',";

		s = s + "@p_orgName='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";

		s = s + "@p_expectedDate='" + expectedShipmentDate + "',";
		s = s + "@p_paymentterm='" + paymentTermId + "',";
		s = s + "@p_deliveryMethod='" + deliveryMethodId + "',";
		s = s + "@p_salesperson='" + salesPerson + "',";
		s = s + "@p_tcsAmount='" + tcsAmount + "',";
		s = s + "@p_tcs='" + tcs + "',";
		s = s + "@p_terms='" + terms + "',";

		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_orderType='" + orderType + "',";
		s = s + "@p_salesOrderId='" + salesOrderId + "',";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_pan='" + pan + "',";
		s = s + "@p_gstNo='" + gstNo + "',";
		s = s + "@p_poNo='" + poNo + "',";
		s = s + "@p_deliveryMode='" + deliveryMode + "',";
		s = s + "@p_deliveryTerm='" + deliveryTerm + "',";
		s = s + "@p_soRef='" + soRef + "',";
		s = s + "@p_endCustomerName='" + endCustomerName + "',";
		s = s + "@p_salesPaymentTerm='" + salesPaymentTerm + "',";
		s = s + "@p_ourRefNo='" + ourRefNo + "',";

		if (!customer.get(0).getSalesOrder().contentEquals("1")) {
			for (RestSaleOrderNewModel m : customer) {
				String itemRemarks = (m.getItemRemarks() != null) ? m.getItemRemarks() : "";

				// Handling NULL values: Replace with 0 if null
				String unitPrice = (m.getUnitPrice() != null) ? String.valueOf(m.getUnitPrice()) : "0";
				String itemIgst = (m.getItemIgst() != null) ? String.valueOf(m.getItemIgst()) : "0";
				String itemCgst = (m.getItemCgst() != null) ? String.valueOf(m.getItemCgst()) : "0";
				String itemSgst = (m.getItemSgst() != null) ? String.valueOf(m.getItemSgst()) : "0";
				String taxableAmt = (m.getTaxableAmt() != null) ? String.valueOf(m.getTaxableAmt()) : "0";
				String noOfItem = (m.getNoOfItem() != null) ? String.valueOf(m.getNoOfItem()) : "0";
				String discount = (m.getDiscount() != null) ? String.valueOf(m.getDiscount()) : "0";
				String gstRate = (m.getGstRate() != null) ? String.valueOf(m.getGstRate()) : "0";
				String lineTotal = (m.getLineTotal() != null) ? String.valueOf(m.getLineTotal()) : "0";

				listdata = listdata + "(@p_salesId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
						+ m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + unitPrice + "\",\"" + discount
						+ "\",\"" + gstRate + "\",\"" + lineTotal + "\",\"" + m.getHsnCode() + "\",\""
						+ m.getSizeInMM() + "\",\"" + m.getThicknessInMM() + "\",\"" + m.getItemDesc().replace("\"", "\"\"").replace("'", "''") + "\",\""
						+ m.getSku() + "\"," + itemIgst + "," + itemCgst + "," + itemSgst + "," + taxableAmt
						+ ",@p_orgName,@p_orgDiv,\"" + itemRemarks + "\"," + noOfItem + "),";
			}

			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_litemSubQuery='" + listdata + "',";

			/*
			 * for (InventoryVendorDocumentModel a : customer.get(0).getDocumentList()) {
			 * if(!a.getDocumnentName().contentEquals("") &&
			 * a.getDocumnentName().contentEquals("null") &&
			 * a.getDocumnentName().contentEquals(null)) { multidocument = multidocument +
			 * "(@p_salesId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()+
			 * "\",@p_qutCreatedBy,@p_orgName,@p_orgDiv),"; } } if
			 * (!multidocument.isEmpty()) { multidocument = multidocument.substring(0,
			 * multidocument.length() - 1); s = s + "@p_vendorDocuments='" + multidocument +
			 * "',"; }
			 */

			for (InventoryVendorDocumentModel a : customer.get(0).getDocumentList()) {
				multidocument = multidocument + "(@p_salesId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
						+ "\",@p_qutCreatedBy,@p_orgName,@p_orgDiv),";
			}
			if (!multidocument.isEmpty()) {
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			}
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		System.out.println("Item Details-----------------------------" + s);
		return s;
	}

	public static String getDeleteParam(RestSaleOrderNewModel customer) {
		String[] userIds = customer.getSalesOrder().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_salesId='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}
