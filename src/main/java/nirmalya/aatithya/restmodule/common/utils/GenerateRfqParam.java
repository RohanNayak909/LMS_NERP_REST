package nirmalya.aatithya.restmodule.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
 
import nirmalya.aatithya.restmodule.procurment.model.InventoryRfqModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRfqVendorModel;

public class GenerateRfqParam {

	public static String getRfqParam(List<InventoryRfqModel> inventoryRfqModel) {
		String s = "";
		String litem = "";
		String vendorParam = "";
		String itemRequisition = "";
		String rfqId = "";
		String moduleId = "";
		String componentId = "";
		String subCmponentId = "";
		String description = "";
		String expectedDate = "";
		String requisitionType = "";
		String status = null;
		String createdBy = "";
		String orgName = "";
		String orgDivision = "";
		
		
		for (InventoryRfqModel m : inventoryRfqModel) {
			itemRequisition = m.getReqId();
			rfqId = m.getRfqId();
			moduleId = m.getModuleId();
			componentId = m.getComponentId();
			subCmponentId = m.getSubComponentId();
			description = m.getDesc();
			expectedDate = m.getReceiveDate();
			requisitionType = m.getReqType();
			status = m.getHoldStatus();
			createdBy = m.getCreatedBy();
			orgName=m.getOrganizationName();
			orgDivision=m.getOrganizationDivision();
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		s = s + "@p_rfqId='" + rfqId + "',";
		s = s + "@p_itemRequisition='" + itemRequisition + "',";

		s = s + "@p_iRDescription='" + description + "',";
		s = s + "@p_receiveDate='" + expectedDate + "',";
		s = s + "@p_iRPrior='" + inventoryRfqModel.get(0).getReqPrior() + "',";
		s = s + "@p_iRType='" + requisitionType + "',";
		s = s + "@p_status=" + status + ",";
		if (status.contentEquals("4")) {
			s = s + "@p_onHoldDate='" + dtf.format(now) + "',";
		} else if (status.contentEquals("1")) {
			s = s + "@p_activeDate='" + dtf.format(now) + "',";
		}
		s = s + "@p_moduleId='" + moduleId + "',";
		s = s + "@p_componentId='" + componentId + "',";
		s = s + "@p_subCmponentId='" + subCmponentId + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_orgName='" + orgName + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		

		for (InventoryRfqModel m : inventoryRfqModel) {

			litem = litem + "(@p_rfqId,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\"" + m.getCostCenterId()
					+ "\",\"" + m.getLocationId() + "\",\"" + m.getQty() + "\",\"" + m.getUomId() + "\",\""
					+ m.getLastPurchaseTotalPrice() + "\",\"" + m.getLastPurchaseUnitPrice() + "\",\""
					+ m.getEstimatedTotalPrice() + "\",\"" + m.getEstimatedPrice() + "\",\"" + m.getCreatedBy()
					+ "\",\""+m.getOrganizationName()+"\",\""+m.getOrganizationDivision()+"\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		List<InventoryRfqVendorModel> vendorList = new ArrayList<InventoryRfqVendorModel>();
		if (inventoryRfqModel != null)
			vendorList = inventoryRfqModel.get(0).getVendorList();

		for (InventoryRfqVendorModel a : vendorList) {

			vendorParam = vendorParam + "(@p_rfqId,\"" + a.getVendorId() + "\",\"" + a.getLocationId() + "\",\""
					+ a.getExpertizeId() + "\",@p_createdBy,\"" + a.getReqSent() + "\",\""
					+ a.getCandidates() + "\",\"" + a.getClosed() + "\"),";

		}
		vendorParam = vendorParam.substring(0, vendorParam.length() - 1);

		s = s + "@p_vendorParamSubQuery='" + vendorParam + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getRfqApproveParam(InventoryRfqModel inventoryRfqModel) {
		String[] userIds = inventoryRfqModel.getRfqId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_reqIds='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + inventoryRfqModel.getModuleId() + "\",\"" + inventoryRfqModel.getComponentId() + "\",\""
					+ inventoryRfqModel.getSubComponentId() + "\",\"" + a + "\",\"" + "Update RFQ" + "\",\""
					+ inventoryRfqModel.getCreatedBy() + "\"),";

		}
		act = act.substring(0, act.length() - 1);

		s = s + "@p_actSubQuery='" + act + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getRfqDeleteParam(InventoryRfqModel inventoryRfqModel) {
		String[] userIds = inventoryRfqModel.getRfqId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_reqIds='" + litem + "',";
		s = s + "@p_orgName='" + litem + "',";
		s = s + "@p_orgDiv='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + inventoryRfqModel.getModuleId() + "\",\"" + inventoryRfqModel.getComponentId() + "\",\""
					+ inventoryRfqModel.getSubComponentId() + "\",\"" + a + "\",\"" + "Delete RFQ" + "\",\""
					+ inventoryRfqModel.getCreatedBy() + "\",\""+inventoryRfqModel.getOrganizationName()+"\",\""+inventoryRfqModel.getOrganizationDivision()+"\"),";

		}
		act = act.substring(0, act.length() - 1);

		s = s + "@p_actSubQuery='" + act + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
