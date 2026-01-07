package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;

public class GenerateSalesInvoiceNewParameter {
	public static String getAddSalesInvoiceParam(List<RestSalesInvoiceNewModel> customer) {
		String s = "";
		String listdata = "";
		Boolean taxType = null;
 
		String type = "";
		String custId = "";
		String custName = "";
		String poId = "";
		String challanIds = "";
		String saleInvoice = "";
		String invoiceDate = "";
		String paymentTerm = "";
		String dueDate = "";
		String dateofSupply = "";
		String vehicleNo = "";
		String transporterId = "";
		String transporterName = "";
		String lrNumber = "";
		String otherreference = "";
		String destination = "";

		Double subTotal = 0.0;
		Double grandTotal = 0.0;
		Double qIGST = 0.0;
		Double qCGST = 0.0;
		Double qSGST = 0.0;
		String adjustment = "0.00";
		String ebillNo = "";
		String ebillDate = "";
		String tMode = "";
		String shippingHiddenId = "";
		Double total = 0.0;
		String organization = "";
		String orgDivision = "";
		String qutCreatedBy = "";
		String piRemarks = "";
		for (RestSalesInvoiceNewModel m : customer) {
			saleInvoice = m.getSaleInvoice();
			poId = m.getPoId();
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
			if (m.getAdjustment1() != null) {
				adjustment = m.getAdjustment1();
			}
			if (m.getGrandTotal() != null) {
				grandTotal = m.getGrandTotal();
			}
			custId = m.getCustId();
			taxType = m.getTaxType();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			type = m.getType();
			paymentTerm = m.getPaymentTerm();
			dueDate = m.getDueDate();
			ebillNo = m.getEbillNo();
			ebillDate = m.getEbillDate();
			shippingHiddenId = m.getShippingHiddenId();
			invoiceDate = m.getInvoiceDate();
			shippingHiddenId = m.getShippingHiddenId();
			/*
			 * orgDetails = m.getOrgDetails(); custDetails = m.getCustDetails();
			 * sapInvoiceId=m.getSapInvoiceId(); challanNo = m.getChallanNo();
			 */
			dateofSupply = m.getDateOfSupply();
			tMode = m.gettMode();
			vehicleNo = m.getVehicleNo();
			transporterId = m.getTransporterId();
			transporterName = m.getTransporterName();
			lrNumber = m.getLrNumber();
			ebillNo = m.getEbillNo();
			ebillDate = m.getEbillDate();
			challanIds = m.getChallanIds();
			// dateofSupply1 = m.getDateOfSupply() ;
			destination = m.getDestination();
			otherreference = m.getOtherreference();
			// saleDeliverysales = m.getSaleDeliverysales() ;
			// subTotal = m.getSubtotal() ;
			total = m.getTotal();
			type = m.getType();
			piRemarks = m.getPiRemarks();

		}

		s = s + "@p_salesInvoice='" + saleInvoice + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_type='" + type + "',";
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
		s = s + "@p_adjustment=" + adjustment + ",";
		s = s + "@p_paymentterm='" + paymentTerm + "',";
		if (dueDate != null && dueDate != "" && dueDate != "null") {
			s = s + "@p_dueDate='" + dueDate + "',";
		}
		s = s + "@p_challanIds='" + challanIds + "',";
		s = s + "@p_ebillNo='" + ebillNo + "',";
		s = s + "@p_ebillDate='" + ebillDate + "',";
		s = s + "@p_total=" + total + ",";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',";
		s = s + "@p_invoiceDate='" + invoiceDate + "',";
		if (dateofSupply != null && dateofSupply != "" && dateofSupply != "null") {
			s = s + "@p_dateofSupply='" + dateofSupply + "',";
		}
		s = s + "@p_tMode='" + tMode + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_transporterId='" + transporterId + "',";
		s = s + "@p_transporterName='" + transporterName + "',";
		s = s + "@p_lrNumber='" + lrNumber + "',";
		s = s + "@p_eWayBillNo='" + ebillNo + "',";
		if (ebillDate != null && ebillDate != "" && ebillDate != "null") {
			s = s + "@p_eWayBillDate='" + ebillDate + "',";
		}
		s = s + "@p_shipmentId='" + shippingHiddenId + "',";
		s = s + "@p_remarks='" + piRemarks + "',";
//		s = s + "@p_shipmentType='" + shipmentType + "',";
//		s = s + "@p_doNumber='" + doNumber + "',";
//		
//		s = s + "@p_irnNumber='" + irnNumber + "',";
//		s = s + "@p_tcsValue='" + tcsValue + "',";
//		s = s + "@p_tcsType='" + tcsType + "',";
//		s = s + "@p_tdsValue='" + tdsValue + "',";
//		s = s + "@p_tdsType='" + tdsType + "',";
//		s = s + "@p_tdsAmount='" + tdsAmount + "',";

		System.out.println("sssssssssssssssss" + customer);
		for (RestSalesInvoiceNewModel m : customer) {
			listdata = listdata + "(@p_salesInvoice,@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\"" + m.getItemDesc() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + m.getUnitPrice() + "\",\"" + m.getDiscount()
					+ "\",\"" + m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\"" + m.getHsnCode() + "\",\""
					+ m.getSku() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\","
					+ m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + "," + m.getTaxableAmt() + "),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("Item Details" + s);
		return s;
	}

	public static String getDeleteParamnew(RestSalesInvoiceNewModel customer) {
		String[] userIds = customer.getSaleDeliverysales().split(",");
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

		System.out.println("EE" + s);

		return s;
	}

	public static String addInvoiceUploadDataParam(List<RestSalesInvoiceNewModel> data) {
		String s = "";
		// String emplist = "";
		String datalist = "";

		if (data.size() > 0) {
			for (RestSalesInvoiceNewModel m : data) {
				// System.out.println("dddddddddddddddddddddddd"+m.getNetWeight());
				datalist = datalist + "(\"" + m.getCommercialInvNo() + "\",\"" + m.getGstNo() + "\",\"" + m.getPoOrSo()
						+ "\",\"" + m.getTaxInvoiceOF() + "\",\"" + DateFormatter.getStringDate(m.getBillingDate())
						+ "\",\"" + m.getSendingPlant() + "\", \"" + m.getReceivingPlant() + "\",\"" + m.getIndicator()
						+ "\",\"" + m.getSourceState() + "\",\"" + m.getStateCode() + "\",\"" + m.getDestinationState()
						+ "\",\"" + m.getMaterialCode() + "\",\"" + m.getMaterialDescription() + "\",\"" + m.getHsn()
						+ "\",\"" + m.getPriceLot() + "\",\"" + m.getDeliveryDoc() + "\",\"" + m.getQuantity()
						+ "\", \"" + m.getUom() + "\",\"" + m.getCaseConfig() + "\",\"" + m.getQuantityInCase()
						+ "\",\"" + m.getNetWeight() + "\",\"" + m.getWeigtUnit() + "\",\"" + m.getBasicPrice()
						+ "\",\"" + m.getNetValue() + "\",\"" + m.getCgstValue() + "\",\"" + m.getSgstValue() + "\",\""
						+ m.getIgstValue() + "\",\"" + m.getTotalValue() + "\",\"" + m.getQutCreatedBy() + "\",\""
						+ m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";
			}

		}

		if (!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_InvoiceSubQuery='" + datalist + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String checkGSTExistsParam(List<RestSalesInvoiceNewModel> data) {
		String s = "";
		String gstList = "";

		if (data.size() > 0) {
			for (RestSalesInvoiceNewModel m : data) {
				gstList = gstList + "(\"" + m.getGstNo() + "\"),";
			}
		}

		if (!gstList.isEmpty()) {
			gstList = gstList.substring(0, gstList.length() - 1);
			s = s + "@P_GstListQuery='" + gstList + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
