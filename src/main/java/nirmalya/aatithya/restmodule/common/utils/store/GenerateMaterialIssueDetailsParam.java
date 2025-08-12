package nirmalya.aatithya.restmodule.common.utils.store;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.store.model.MaterialIssueDetailsRestModel;
import nirmalya.aatithya.restmodule.store.model.StoreMaterialDetailsRestModel;

public class GenerateMaterialIssueDetailsParam {

	public static String getAddIssuetParam(List<MaterialIssueDetailsRestModel> model) {

		String s = "";
		System.out.println("model" + model);
		String listdata = "";
//	if (employee.getBudgetId() != null) {
		s = s + "@p_issue='" + model.get(0).getIssueSlip() + "',";

		if (model.get(0).getProject() != null && model.get(0).getProject() != "") {
			s = s + "@p_project='" + model.get(0).getProject() + "',";
		}
		if (model.get(0).getRefNo() != null && model.get(0).getRefNo() != "") {
			s = s + "@p_refNo='" + model.get(0).getRefNo() + "',";
		}
		if (model.get(0).getType() != null && model.get(0).getType() != "") {
			s = s + "@p_type='" + model.get(0).getType() + "',";
		}

		if (model.get(0).getIssueSlip1() != null && model.get(0).getIssueSlip1() != "") {
			s = s + "@p_issueSlip1='" + model.get(0).getIssueSlip1() + "',";
		}

		if (model.get(0).getVendorId() != null && model.get(0).getVendorId() != "") {
			s = s + "@p_vendorId='" + model.get(0).getVendorId() + "',";
		}
		if (model.get(0).getDate() != null && model.get(0).getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(model.get(0).getDate()) + "',";
		}
		if (model.get(0).getDeptId() != null && model.get(0).getDeptId() != "") {
			s = s + "@p_deptId='" + model.get(0).getDeptId() + "',";
		}
		if (model.get(0).getRequestBy() != null && model.get(0).getRequestBy() != "") {
			s = s + "@p_requestedBy='" + model.get(0).getRequestBy() + "',";
		}
		if (model.get(0).getAssignTo() != null && model.get(0).getAssignTo() != "") {
			s = s + "@p_assignedTo='" + model.get(0).getAssignTo() + "',";
		}
		if (model.get(0).getCreatedBy() != null || model.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + model.get(0).getCreatedBy() + "',";
		}

		if (model.get(0).getOrganization() != null || model.get(0).getOrganization() != "") {
			s = s + "@p_org='" + model.get(0).getOrganization() + "',";
		}
		if (model.get(0).getOrgDivision() != null || model.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + model.get(0).getOrgDivision() + "',";
		}
		if (model.get(0).getDesc() != null || model.get(0).getDesc() != "") {
			s = s + "@p_desc='" + model.get(0).getDesc() + "',";
		}
		for (StoreMaterialDetailsRestModel m : model.get(0).getProductattribute()) {

			listdata = listdata + "(@p_issue,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\"" + m.getItemName()
					+ "\",\"" + m.getHsnCode() + "\",\"" + m.getModel() + "\",\"" + m.getQuantity() + "\",\""
					+ m.getUnit() + "\",\"" + m.getUnitName() + "\",\"" + m.getStock() + "\",\"" + m.getStockForDays()
					+ "\",\"" + m.getRemark() + "\",\"" + model.get(0).getReqId() + "\",\"" + model.get(0).getOrganization() + "\",\"" + model.get(0).getOrgDivision()  + "\"),";
		}

		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("###################" + s);
		return s;

	}

}
