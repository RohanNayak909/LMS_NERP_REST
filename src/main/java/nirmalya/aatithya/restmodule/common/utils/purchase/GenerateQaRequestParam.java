package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;
import nirmalya.aatithya.restmodule.purchase.model.RestQaRequestModel;

public class GenerateQaRequestParam {

	public static String addQaRequestParam(List<RestQaRequestModel> data) {
		String s = "";
		String sitem = "";
		
		if (data.get(0).getInvoice_id() != null || data.get(0).getInvoice_id() != "") {
			s = s + "@p_invoice_id='" + data.get(0).getInvoice_id() + "',";
		}

		if (data.get(0).getPurchase_order() != null || data.get(0).getPurchase_order() != "") {
			s = s + "@p_purchase_order='" + data.get(0).getPurchase_order() + "',";
		}

		if (data.get(0).getVechile_no() != null || data.get(0).getVechile_no() != "") {
			s = s + "@p_vechile_no='" + data.get(0).getVechile_no() + "',";
		}
		if (data.get(0).getDriver_name() != null || data.get(0).getDriver_name() != "") {
			s = s + "@p_driver_name='" + data.get(0).getDriver_name() + "',";
		}

		if (data.get(0).getDriver_mobile() != null || data.get(0).getDriver_mobile() != "") {
			s = s + "@p_driver_mobile='" + data.get(0).getDriver_mobile() + "',";
		}
		
		if (data.get(0).getVendor_name() != null || data.get(0).getVendor_name() != "") {
			s = s + "@p_vendor_name='" + data.get(0).getVendor_name() + "',";
		}
		
		if (data.get(0).getChallan_no() != null || data.get(0).getChallan_no() != "") {
			s = s + "@p_challan_no='" + data.get(0).getChallan_no() + "',";
		}

		if (data.get(0).getOrganization() != null || data.get(0).getOrganization() != "") {
			s = s + "@p_org='" + data.get(0).getOrganization() + "',";
		}
		if (data.get(0).getOrgDivision() != null || data.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + data.get(0).getOrgDivision() + "',";
		}

		for (RestQaRequestModel m : data) {

			sitem = sitem + "(@p_reqId,\"" + m.getSku_id() + "\",\"" + m.getHsn_no() + "\",\""
					+ m.getItem_name() + "\",\"" + m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";

		}

		// s = s + "@p_serviceId='" + data.get(0).get(0).getServiceId() +"',";
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
