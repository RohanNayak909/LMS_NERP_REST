package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.procurment.model.InventoryGRNModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryGoodsReturnModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class GenerateGoodsReceiveNoteParam {

	private GenerateGoodsReceiveNoteParam() {
		throw new IllegalStateException("GenerateGoodsReceiveNoteParam class");

	}

	/**
	 *
	 * @param inventoryGRNModel
	 * @return query for adding and modifying GRN
	 */
	public static String getGrnParam(InventoryGRNModel inventoryGRNModel) throws Exception {
		String s = "";
		String litem = "";
		String document = "";
		if (inventoryGRNModel.getNoteId() != null && inventoryGRNModel.getNoteId() != "") {
			s = s + "@p_grnId='" + inventoryGRNModel.getNoteId() + "',";
		}
		if (inventoryGRNModel.getInvNo() != null && inventoryGRNModel.getInvNo() != "") {
			s = s + "@p_invNo='" + inventoryGRNModel.getInvNo() + "',";
		}
		if (inventoryGRNModel.getPoId() != null && inventoryGRNModel.getPoId() != "") {
			s = s + "@p_poId='" + inventoryGRNModel.getPoId() + "',";
		}

		if (inventoryGRNModel.getDeliveryMethodId() != null && inventoryGRNModel.getDeliveryMethodId() != "") {
			s = s + "@p_deliveryMethod='" + inventoryGRNModel.getDeliveryMethodId() + "',";
		}
		if (inventoryGRNModel.getDispatchDate() != null && inventoryGRNModel.getDispatchDate() != "") {
			s = s + "@p_dispatchDate='" + inventoryGRNModel.getDispatchDate() + "',";
		}
		if (inventoryGRNModel.getDeliveryNote() != null && inventoryGRNModel.getDeliveryNote() != "") {
			s = s + "@p_deliveryNote='" + inventoryGRNModel.getDeliveryNote() + "',";
		}
		if (inventoryGRNModel.getEstDeliveryDate() != null && inventoryGRNModel.getEstDeliveryDate() != "") {
			s = s + "@p_deliveryDate='" + inventoryGRNModel.getEstDeliveryDate() + "',";
		}
		if (inventoryGRNModel.getPoDate() != null && inventoryGRNModel.getPoDate() != "") {
			s = s + "@p_poDate='" + inventoryGRNModel.getPoDate() + "',";
		}
		if (inventoryGRNModel.getTrackingNo() != null && inventoryGRNModel.getTrackingNo() != "") {
			s = s + "@p_tracking='" + inventoryGRNModel.getTrackingNo() + "',";
		}
		if (inventoryGRNModel.getInvDate() != null && inventoryGRNModel.getInvDate() != "") {
			s = s + "@p_invDate='" + inventoryGRNModel.getInvDate() + "',";
		}
		if (inventoryGRNModel.getOrganizationName() != null && inventoryGRNModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + inventoryGRNModel.getOrganizationName() + "',";
		}
		if (inventoryGRNModel.getOrganizationDivision() != null && inventoryGRNModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + inventoryGRNModel.getOrganizationDivision() + "',";
		}
		s = s + "@p_moduleId='" + inventoryGRNModel.getModuleId() + "',";
		s = s + "@p_componentId='" + inventoryGRNModel.getComponentId() + "',";
		s = s + "@p_subCmponentId='" + inventoryGRNModel.getSubComponentId() + "',";
		s = s + "@p_createdBy='" + inventoryGRNModel.getCreatedBy() + "',";

		for (InventoryProductModel m : inventoryGRNModel.getProductList()) {

			litem = litem + "(@p_grnId,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\"" + m.getLocationId()
					+ "\",\"" + m.getUomId() + "\",\"" + m.getInvoiceQty() + "\",\"" + m.getQtyDelivered() + "\",\""
					+ m.getReceiveQty() + "\",\"" + m.getNotReceivedQty() + "\",\"" + m.getOutstandQty() + "\","
							+ "@p_createdBy" + ",\""+inventoryGRNModel.getOrganizationName()+"\",\""+inventoryGRNModel.getOrganizationDivision()+"\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		for (InventoryVendorDocumentModel a : inventoryGRNModel.getDocumentList()) {
			document = document + "(@p_grnId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
					+ "\",@p_createdBy),";
		}
		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_documents='" + document + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getGrnCompleteParam(InventoryGRNModel inventoryRfqModel) {
		String[] userIds = inventoryRfqModel.getNoteId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_grnIds='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + inventoryRfqModel.getModuleId() + "\",\"" + inventoryRfqModel.getComponentId() + "\",\""
					+ inventoryRfqModel.getSubComponentId() + "\",\"" + a + "\",\"" + "Complete GRN" + "\",\""
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

	/**
	 * 
	 * @param inventoryGRNModel
	 * @return
	 * @throws Exception
	 */
	public static String getGrnReturnParam(InventoryGoodsReturnModel inventoryGoodsReturnModel) {
		String s = "";
		String litem = "";
		String document = "";
		if (inventoryGoodsReturnModel.getNoteId() != null && inventoryGoodsReturnModel.getNoteId() != "") {
			s = s + "@p_grnId='" + inventoryGoodsReturnModel.getNoteId() + "',";
		}
		if (inventoryGoodsReturnModel.getReturnNoteId() != null && inventoryGoodsReturnModel.getReturnNoteId() != "") {
			s = s + "@p_retNoteId='" + inventoryGoodsReturnModel.getReturnNoteId() + "',";
		}

		s = s + "@p_moduleId='" + inventoryGoodsReturnModel.getModuleId() + "',";
		s = s + "@p_componentId='" + inventoryGoodsReturnModel.getComponentId() + "',";
		s = s + "@p_subCmponentId='" + inventoryGoodsReturnModel.getSubComponentId() + "',";
		s = s + "@p_createdBy='" + inventoryGoodsReturnModel.getCreatedBy() + "',";
		s = s + "@p_orgName='" + inventoryGoodsReturnModel.getOrganizationName() + "',";
		s = s + "@p_orgDiv='" + inventoryGoodsReturnModel.getOrganizationDivision() + "',";

		for (InventoryProductModel m : inventoryGoodsReturnModel.getProductList()) {

			litem = litem + "(@p_retNoteId,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\"" + m.getReturnQty()
					+ "\",@p_createdBy" + ",\"" + inventoryGoodsReturnModel.getOrganizationName() + "\",\"" + inventoryGoodsReturnModel.getOrganizationDivision() + "\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		if (inventoryGoodsReturnModel.getDocumentList() != null) {
			for (InventoryVendorDocumentModel a : inventoryGoodsReturnModel.getDocumentList()) {
				document = document + "(@p_retNoteId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
						+ "\",@p_createdBy),";
			}
			if (!document.isEmpty()) {
				document = document.substring(0, document.length() - 1);
				s = s + "@p_documents='" + document + "',";
			}
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getGrnReturnCompleteParam(InventoryGoodsReturnModel inventoryRfqModel) {
		String[] userIds = inventoryRfqModel.getReturnNoteId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_grnRetIds='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + inventoryRfqModel.getModuleId() + "\",\"" + inventoryRfqModel.getComponentId() + "\",\""
					+ inventoryRfqModel.getSubComponentId() + "\",\"" + a + "\",\"" + "Complete GRN Return" + "\",\""
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

}
