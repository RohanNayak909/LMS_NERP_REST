package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.api.model.RestCrmClassifiedBillingModel;

public class GenerateCRMClassifiedBillingParam {
	public static String getBillingParam(RestCrmClassifiedBillingModel billModel) {

		String s = "";

		if (billModel.getBillId() != null && billModel.getBillId() != "") {
			s = s + "@p_billId='" + billModel.getBillId() + "',";
		}
		if (billModel.getBill() != null && billModel.getBill() != "") {
			s = s + "@p_bill='" + billModel.getBill() + "',";
		}
		if (billModel.getBillDate() != null && billModel.getBillDate() != "") {
			s = s + "@p_billDate='" + DateFormatter.getStringDate(billModel.getBillDate()) + "',";
		}
		if (billModel.getDisplayBill() != null && billModel.getDisplayBill() != "") {
			s = s + "@p_displayBill='" + billModel.getDisplayBill() + "',";
		}
		if (billModel.getCreatedBy() != null || billModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + billModel.getCreatedBy() + "',";
		}
		if(billModel.getOrgName() != null || billModel.getOrgName() != "") {
			s = s + "@p_org='" + billModel.getOrgName() + "',";
		}
		if(billModel.getOrgDiv() != null || billModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + billModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
