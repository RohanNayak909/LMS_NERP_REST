package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;

public class GeneratePurchaseIndentParam {
	public static String getAddPurchaseIndent(List<RestPurchaseIndentModel> purchase) {
		String s = "";
		String listdata = "";
		String indentId = "";
		String indentDate = "";
		String receiveDate="";
		String desc = "";
		String dept = "";
		String project = "";
		
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
	
		String multidocument = "";
		String reqId = "";
		for (RestPurchaseIndentModel m : purchase) {
			indentId = m.getIndentId();
			indentDate = m.getIndentDate();
			receiveDate=m.getReceiveDate();
			dept = m.getDeptId();
			project = m.getProject();
			desc = m.getDesc();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			reqId = m.getReqId();

		}
	
       
		s = s + "@p_indentId='" + indentId + "',";
		s = s + "@p_indentDate='" + indentDate + "',";
		s = s + "@p_receiveDate='" + DateFormatter.getStringDate(receiveDate) + "',";
		s = s + "@p_dept='" + dept + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_reqId='" + reqId + "',";
		if (!purchase.get(0).getIndentId().contentEquals("1")) {
			for (RestPurchaseIndentModel m : purchase) {

				listdata = listdata + "(@p_indentId,\"" + m.getItemId() + "\",\"" + m.getItemName()
						+ "\"," + m.getQuantity() + ",\"" + m.getSku() + "\",\"" + m.getHsnCode() + "\",\"" + m.getUnit() + "\",\"" + m.getModel() + "\",\"" + m.getStock() + "\",\"" + m.getStockForDays() + "\", @p_organization,@p_orgDivision),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";
			
			
			for (InventoryVendorDocumentModel a : purchase.get(0).getDocumentList()) {
				if(!a.getDocumnentName().contentEquals("") && !a.getDocumnentName().contentEquals("null")) {
				multidocument = multidocument + "(@p_indentId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
						+ "\",@p_createdBy,@p_organization,@p_orgDivision),";}
				
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
		System.out.println("Item Details" + s);
		return s;
	}
	public static String getReplyAdd(RestPurchaseIndentModel restPurchaseIndentModel) {

		String s = "";

		
		//s = s + "@p_indentId=" + restPurchaseIndentModel.getIndentId() + ",";

		s = s + "@p_indentId='(" + restPurchaseIndentModel.getIndentId() + ")',";
				
		if (restPurchaseIndentModel.getCurrent() != null && restPurchaseIndentModel.getCurrent() != "") {
			s = s + "@p_current='" + restPurchaseIndentModel.getCurrent() + "',";
		}
		else {
			s = s + "@p_current='',";
		}
		if (restPurchaseIndentModel.getPrevious() != null && restPurchaseIndentModel.getPrevious() != "") {
			s = s + "@p_previous='" + restPurchaseIndentModel.getPrevious() + "',";
		}
		else {
			s = s + "@p_previous='',";
		}
		if (restPurchaseIndentModel.getOrganization() != null && restPurchaseIndentModel.getOrganization() != "") {
			s = s + "@p_org='" + restPurchaseIndentModel.getOrganization() + "',";
		}
		if (restPurchaseIndentModel.getOrgDivision() != null && restPurchaseIndentModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restPurchaseIndentModel.getOrgDivision() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
}
