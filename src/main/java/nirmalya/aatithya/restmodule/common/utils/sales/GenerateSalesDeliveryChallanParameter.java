package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestDeliveryChallanModel;

public class GenerateSalesDeliveryChallanParameter {
	public static String getAddChallanParam(List<RestDeliveryChallanModel> customer) {
		String s = "";
		String listdata = "";
		String saleDeliveryChallan = "";
		String poId = "";
		String salePackageId = "";

		String qutActive = null;
		String qutCreatedBy = "";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;

		String custId = "";
		String organization = "";
		String orgDivision = "";
		Double adjustment = 0.00;

		//Double tcsAmount = 0.00;
		String tcs = "";
		String challanType = "";
		String ebillNo = "";
		String ebillDate = "";
		String tMode = "";
		String freigt = "";
		Double freigtCharge = 0.00;
		Double freigtTaxRate = 0.00;
		Double total = 0.00;
		String vehicleNo = "";
		String transporterId = "";
		String transporterName = "";
		String transporterGst = "";
		String lrNumber = "";
		String shippingHiddenId = "";
		String deliveryChallanDate = "";
		String dcRemarks = "";
		String dcComment = "";
		String dcDesc = "";

		for (RestDeliveryChallanModel m : customer) {
			saleDeliveryChallan = m.getSaleDeliveryChallan();
			poId = m.getPoId();
			salePackageId = m.getSalePackageId();
			qutActive = m.getQutActive();
			qutCreatedBy = m.getQutCreatedBy();
			subTotal = m.getSubTotal();
			qIGST = m.getqIGST();
			qCGST = m.getqCGST();
			qSGST = m.getqSGST();
			grandTotal = m.getGrandTotal();
			taxType = m.getTaxType();

			custId = m.getCustId();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			adjustment = m.getAdjustment();
			/*
			 * if (m.getTcsAmount() != null) { tcsAmount = m.getTcsAmount(); }
			 */
			tcs = m.getTcs();
			challanType = m.getChallanType();
			ebillNo = m.getEbillNo();
			ebillDate = m.getEbillDate();
			tMode = m.gettMode();
			freigt = m.getFreight();
			if (m.getFreigtCharge() != null) {
				freigtCharge = m.getFreigtCharge();
			}
			if (m.getFreigtTaxRate() != null) {
				freigtTaxRate = m.getFreigtTaxRate();
			}
			if (m.getTotal() != null) {
				total = m.getTotal();
			}
			vehicleNo = m.getVehicleNo();
			transporterId = m.getTransporterId();
			transporterName = m.getTransporterName();
			transporterGst = m.getTransporterGst();
			lrNumber = m.getLrNumber();
			shippingHiddenId = m.getShippingHiddenId();
			deliveryChallanDate = m.getDeliveryChallanDate();
			dcRemarks = m.getDcRemarks().replace("'", "\\'").replace("\"", "\\\\\"");
			dcComment = m.getDcComment().replace("'", "\\'").replace("\"", "\\\\\"");
			dcDesc = m.getDcDesc().replace("'", "\\'").replace("\"", "\\\\\"");

		}

		s = s + "@p_salesDeliveryChallan='" + saleDeliveryChallan + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_salePackageId='" + salePackageId + "',";
		s = s + "@p_qutActive='" + qutActive + "',";
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
		s = s + "@p_adjustment='" + adjustment + "',";
		//s = s + "@p_tcsAmount='" + tcsAmount + "',";
		s = s + "@p_tcs='" + tcs + "',";

		s = s + "@p_challanType='" + challanType + "',";
		s = s + "@p_ebillNo='" + ebillNo + "',";
		// s = s + "@p_ebillDate='" + ebillDate + "',";
		if (ebillDate != "") {
			s = s + "@p_ebillDate='" + ebillDate + "',";
		}
		s = s + "@p_tMode='" + tMode + "',";
		s = s + "@p_freigt='" + freigt + "',";
		s = s + "@p_freigtCharge='" + freigtCharge + "',";
		s = s + "@p_freigtTaxRate='" + freigtTaxRate + "',";
		s = s + "@p_total='" + total + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_transporterId='" + transporterId + "',";
		s = s + "@p_transporterName='" + transporterName + "',";
		s = s + "@p_transporterGst='" + transporterGst + "',";
		s = s + "@p_lrNumber='" + lrNumber + "',";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',";
		s = s + "@p_deliveryChallandate='" + deliveryChallanDate + "',";
		s = s + "@p_dcRemarks='" + dcRemarks + "',";
		s = s + "@p_dcComment='" + dcComment + "',";
		s = s + "@p_dcDesc='" + dcDesc + "',";

		// if (!customer.get(0).getSaleDeliveryChallan().contentEquals("1")) {
		for (RestDeliveryChallanModel m : customer) {
			Double discount = 0.00;
			if (m.getDiscount() != null) {
				discount = m.getDiscount();
			}

			listdata = listdata + "(@p_salesDeliveryChallan,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\"" + m.getItemDesc() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getUnitPrice() + "\",\"" + discount + "\",\"" + m.getGstRate()
					+ "\",\"" + m.getLineTotal() + "\",\"" + m.getSku() + "\"," + m.getItemIgst() + ","
					+ m.getItemCgst() + "," + m.getItemSgst() + ",\"" + m.getHsnCode() + "\",\"" + m.getUnit() + "\","
					+ m.getTaxableAmt() + ",@p_org,@p_div),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		// }
		System.out.println("Item Details" + s);
		return s;
	}

	public static String getDeleteParamnew(RestDeliveryChallanModel customer) {
		String[] userIds = customer.getSaleDeliveryChallan().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_salesDeliveryChallan='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE" + s);

		return s;
	}

}
