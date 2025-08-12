package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.purchase.model.RestShipmentDetailsVendorModel;

public class GenerateShipmentEntryParam {

	public static String getShipmentParam(List<RestShipmentDetailsVendorModel> gatepass) {
		String s = "";
		String listdata = "";
		System.out.println("gatepass====" + gatepass);
		if (gatepass.get(0).getShippingId() != null && gatepass.get(0).getShippingId() != "") {
			s = s + "@p_shipmentId='" + gatepass.get(0).getShippingId() + "',";
		}

		if (gatepass.get(0).getCustId() != null && gatepass.get(0).getCustId() != "") {
			s = s + "@p_custId='" + gatepass.get(0).getCustId() + "',";
		}

		if (gatepass.get(0).getCustomerName() != null && gatepass.get(0).getCustomerName() != "") {
			s = s + "@p_custName='" + gatepass.get(0).getCustomerName() + "',";
		}

		if (gatepass.get(0).getTransportName() != null && gatepass.get(0).getTransportName() != "") {
			s = s + "@p_transportNo='" + gatepass.get(0).getTransportName() + "',";
		}

		if (gatepass.get(0).getVechileNo() != null && gatepass.get(0).getVechileNo() != "") {
			s = s + "@p_vechileno='" + gatepass.get(0).getVechileNo() + "',";
		}

		if (gatepass.get(0).getLrNo() != null && gatepass.get(0).getLrNo() != "") {
			s = s + "@p_lrNo='" + gatepass.get(0).getLrNo() + "',";
		}

		if (gatepass.get(0).getDriverName() != null && gatepass.get(0).getDriverName() != "") {
			s = s + "@p_drivername='" + gatepass.get(0).getDriverName() + "',";
		}
		if (gatepass.get(0).getDriverMobile() != null && gatepass.get(0).getDriverMobile() != "") {
			s = s + "@p_drivermob='" + gatepass.get(0).getDriverMobile() + "',";
		}

		if (gatepass.get(0).getNoOfWheel() != null && gatepass.get(0).getNoOfWheel() != "") {
			s = s + "@p_noOfWheel='" + gatepass.get(0).getNoOfWheel() + "',";
		}
		if (gatepass.get(0).getDlNo() != null && gatepass.get(0).getDlNo() != "") {
			s = s + "@p_dlNo='" + gatepass.get(0).getDlNo() + "',";
		}

		if (gatepass.get(0).getDlDate() != null && gatepass.get(0).getDlDate() != "") {
			s = s + "@p_dlDate='" + DateFormatter.getStringDate(gatepass.get(0).getDlDate()) + "',";
		}

		if (gatepass.get(0).getImage() != null && gatepass.get(0).getImage() != "") {
			s = s + "@p_image='" + gatepass.get(0).getImage() + "',";
		} else {
			s = s + "@p_image='',";
		}

		if (gatepass.get(0).getCreatedBy() != null && gatepass.get(0).getCreatedBy() != "") {
			s = s + "@p_createdby='" + gatepass.get(0).getCreatedBy() + "',";
		}
		if (gatepass.get(0).getOrganizationName() != null && gatepass.get(0).getOrganizationName() != "") {
			s = s + "@p_orgName='" + gatepass.get(0).getOrganizationName() + "',";
		}
		if (gatepass.get(0).getOrganizationDivision() != null && gatepass.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + gatepass.get(0).getOrganizationDivision() + "',";
		}
		
		
		if (gatepass.get(0).getCarrierId() != null && gatepass.get(0).getCarrierId() != "") {
			s = s + "@p_carrierId='" + gatepass.get(0).getCarrierId() + "',";
		}
		if (gatepass.get(0).getExpRDate() != null && gatepass.get(0).getExpRDate() != "") {
			s = s + "@p_expRDate='" + gatepass.get(0).getExpRDate() + "',";
		}
		if (gatepass.get(0).getTrackingId() != null && gatepass.get(0).getTrackingId() != "") {
			s = s + "@p_trackingId='" + gatepass.get(0).getTrackingId() + "',";
		}
		if (gatepass.get(0).getTrackingUrlId() != null && gatepass.get(0).getTrackingUrlId() != "") {
			s = s + "@p_trackingUrlId='" + gatepass.get(0).getTrackingUrlId() + "',";
		}
		if (gatepass.get(0).getInternalNotes() != null && gatepass.get(0).getInternalNotes() != "") {
			s = s + "@p_internalNotes='" + gatepass.get(0).getInternalNotes() + "',";
		}
		
		
		

		if (gatepass.get(0).getItemId() != null && gatepass.get(0).getItemId() != "") {
			for (RestShipmentDetailsVendorModel m : gatepass) {

				/*
				 * String cDate = ""; if (m.getPoDate() != null) { cDate =
				 * DateFormatter.getStringDate(m.getPoDate()); }
				 */

				listdata = listdata + "(@p_shipmentId,\"" + m.getVendorName1() + "\",\"" + m.getVendorId() + "\",\""
						+ m.getItemId() + "\",\"" + m.getItemName() + "\",\"" + m.getHsnCode() + "\"," + m.getQuantity()
						+ "," + m.getLineTotal() + ",\"" + m.getSku() + "\",\"" + m.getPoDate() + "\",\"" + m.getPoNo()
						+ "\",\"" + m.getDescItem() + "\",\"" + m.getOrganizationName() + "\",\""
						+ m.getOrganizationDivision() + "\",\"" + m.getUnit() + "\",\"" + m.getChallanNo() + "\",\"" + m.getChallanDate() + "\"),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_litemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_litemSubQuery='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details--------------" + s);
		return s;
	}
}
