package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.procurment.model.InventoryActionInvoiceModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRfqModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class GenerateActionInvoicePAram {

	private GenerateActionInvoicePAram() {
		throw new IllegalStateException("GenerateActionInvoicePAram class");

	}

	/**
	 *
	 * @param inventoryActionInvoiceModel
	 * @return query for adding and modifying PO
	 */
	public static String getPoParam(InventoryActionInvoiceModel inventoryActionInvoiceModel) throws Exception {
		String s = "";
		String litem = "";
		String document = "";
		if (inventoryActionInvoiceModel.getInvId() != null && inventoryActionInvoiceModel.getInvId() != "") {
			s = s + "@p_invId='" + inventoryActionInvoiceModel.getInvId() + "',";
		}
		if (inventoryActionInvoiceModel.getInvNo() != null && inventoryActionInvoiceModel.getInvNo() != "") {
			s = s + "@p_invNo='" + inventoryActionInvoiceModel.getInvNo() + "',";
		}
		if (inventoryActionInvoiceModel.getPoId() != null && inventoryActionInvoiceModel.getPoId() != "") {
			s = s + "@p_poId='" + inventoryActionInvoiceModel.getPoId() + "',";
		}
		if (inventoryActionInvoiceModel.getVendorId() != null && inventoryActionInvoiceModel.getVendorId() != "") {
			s = s + "@p_vendor='" + inventoryActionInvoiceModel.getVendorId() + "',";
		}
		if (inventoryActionInvoiceModel.getPaymentTerm() != null
				&& inventoryActionInvoiceModel.getPaymentTerm() != "") {
			s = s + "@p_paymentTerm='" + inventoryActionInvoiceModel.getPaymentTerm() + "',";
		}
		if (inventoryActionInvoiceModel.getVendorContactId() != null
				&& inventoryActionInvoiceModel.getVendorContactId() != "") {
			s = s + "@p_vendorContactId='" + inventoryActionInvoiceModel.getVendorContactId() + "',";
		}
		if (inventoryActionInvoiceModel.getVendorLocId() != null
				&& inventoryActionInvoiceModel.getVendorLocId() != "") {
			s = s + "@p_vendorLocId='" + inventoryActionInvoiceModel.getVendorLocId() + "',";
		}
		if (inventoryActionInvoiceModel.getApproveStatus() != null
				&& inventoryActionInvoiceModel.getApproveStatus() != "") {
			s = s + "@p_approveStatus='" + inventoryActionInvoiceModel.getApproveStatus() + "',";
		}
		if (inventoryActionInvoiceModel.getPaymentStatus() != null
				&& inventoryActionInvoiceModel.getPaymentStatus() != "") {
			s = s + "@p_payStatus='" + inventoryActionInvoiceModel.getPaymentStatus() + "',";
		}
		if (inventoryActionInvoiceModel.getDueDate() != null && inventoryActionInvoiceModel.getDueDate() != "") {
			s = s + "@p_dueDate='" + inventoryActionInvoiceModel.getDueDate() + "',";
		}
		if (inventoryActionInvoiceModel.getInvDate() != null && inventoryActionInvoiceModel.getInvDate() != "") {
			s = s + "@p_invDate='" + inventoryActionInvoiceModel.getInvDate() + "',";
		}

		if (inventoryActionInvoiceModel.getTotalValue() != null) {
			s = s + "@p_total='" + inventoryActionInvoiceModel.getTotalValue() + "',";
		}
		if (inventoryActionInvoiceModel.getPaymentTerm() != null
				&& inventoryActionInvoiceModel.getPaymentTerm() != "") {
			s = s + "@p_payTerm='" + inventoryActionInvoiceModel.getPaymentTerm() + "',";
		}

		if (inventoryActionInvoiceModel.getPaymentDueIn() != null
				&& inventoryActionInvoiceModel.getPaymentDueIn() != "") {
			s = s + "@p_paymentDueIn='" + inventoryActionInvoiceModel.getPaymentDueIn() + "',";
		}
		if (inventoryActionInvoiceModel.getComments() != null && inventoryActionInvoiceModel.getComments() != "") {
			s = s + "@p_comments='" + inventoryActionInvoiceModel.getComments() + "',";
		}
		if (inventoryActionInvoiceModel.getIsSaveByVendor() != null
				&& inventoryActionInvoiceModel.getIsSaveByVendor() != "") {
			s = s + "@p_isSaveByVendor='" + inventoryActionInvoiceModel.getIsSaveByVendor() + "',";
		}
		if (inventoryActionInvoiceModel.getCompanyContactId() != null
				&& inventoryActionInvoiceModel.getCompanyContactId() != "") {
			s = s + "@p_companyContract='" + inventoryActionInvoiceModel.getCompanyContactId() + "',";
		}

		if (inventoryActionInvoiceModel.getSubTotal() != null) {
			s = s + "@p_subTotal='" + inventoryActionInvoiceModel.getSubTotal() + "',";
		}
		if (inventoryActionInvoiceModel.getSgst() != null) {
			s = s + "@p_sgst='" + inventoryActionInvoiceModel.getSgst() + "',";
		}
		if (inventoryActionInvoiceModel.getCgst() != null) {
			s = s + "@p_cgst='" + inventoryActionInvoiceModel.getCgst() + "',";
		}
		if (inventoryActionInvoiceModel.getIgst() != null) {
			s = s + "@p_igst='" + inventoryActionInvoiceModel.getIgst() + "',";
		}
		if (inventoryActionInvoiceModel.getAdjustment() != null) {
			s = s + "@p_adjustment='" + inventoryActionInvoiceModel.getAdjustment() + "',";
		}
		if (inventoryActionInvoiceModel.getTcs() != null
				&& inventoryActionInvoiceModel.getTcs() != "") {
			s = s + "@p_tcs='" + inventoryActionInvoiceModel.getTcs() + "',";
		}
		if (inventoryActionInvoiceModel.getTcsAmt() != null) {
			s = s + "@p_tcsAmt='" + inventoryActionInvoiceModel.getTcsAmt() + "',";
		}
		if (inventoryActionInvoiceModel.getOrganizationName() != null
				&& inventoryActionInvoiceModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + inventoryActionInvoiceModel.getOrganizationName() + "',";
		}
		if (inventoryActionInvoiceModel.getOrganizationDivision() != null
				&& inventoryActionInvoiceModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + inventoryActionInvoiceModel.getOrganizationDivision() + "',";
		}

		s = s + "@p_moduleId='" + inventoryActionInvoiceModel.getModuleId() + "',";
		s = s + "@p_componentId='" + inventoryActionInvoiceModel.getComponentId() + "',";
		s = s + "@p_subCmponentId='" + inventoryActionInvoiceModel.getSubComponentId() + "',";
		s = s + "@p_createdBy='" + inventoryActionInvoiceModel.getCreatedBy() + "',";
		s = s + "@p_orgName='" + inventoryActionInvoiceModel.getOrganizationName() + "',";
		s = s + "@p_orgDiv='" + inventoryActionInvoiceModel.getOrganizationDivision() + "',";

		for (InventoryProductModel m : inventoryActionInvoiceModel.getProductList()) {

			litem = litem + "(@p_invId,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\"" + m.getLocationId()
					+ "\",\"" + m.getQuantity() + "\",\"" + m.getUomId() + "\",\"" + m.getUnitPrice() + "\",\""
					+ m.getDiscount() + "\",\"" + m.getDiscountType() + "\",\"" + m.getSubTotalPrice() + "\",\""
					+ m.getTax() + "\",\"" + m.getTaxAmt() + "\",\"" + m.getTotal() + "\",\"" + m.getCostCenterId()
					+ "\",\"" + m.getAccountId() + "\",@p_createdBy" + ",\""
					+ inventoryActionInvoiceModel.getOrganizationName() + "\",\""
					+ inventoryActionInvoiceModel.getOrganizationDivision() + "\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		for (InventoryVendorDocumentModel a : inventoryActionInvoiceModel.getDocumentList()) {
			document = document + "(@p_invId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
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

	/**
	 * 
	 * @param inventoryActionInvoiceModel
	 * @return delivery note
	 * @throws Exception
	 */
	public static String getDnParam(InventoryActionInvoiceModel inventoryActionInvoiceModel) throws Exception {
		String s = "";
		String litem = "";
		if (inventoryActionInvoiceModel.getInvId() != null && inventoryActionInvoiceModel.getInvId() != "") {
			s = s + "@p_invId='" + inventoryActionInvoiceModel.getInvId() + "',";
		}
		s = s + "@p_moduleId='" + inventoryActionInvoiceModel.getModuleId() + "',";
		s = s + "@p_componentId='" + inventoryActionInvoiceModel.getComponentId() + "',";
		s = s + "@p_subCmponentId='" + inventoryActionInvoiceModel.getSubComponentId() + "',";
		s = s + "@p_createdBy='" + inventoryActionInvoiceModel.getCreatedBy() + "',";
		s = s + "@p_orgName='" + inventoryActionInvoiceModel.getOrganizationName() + "',";
		s = s + "@p_orgDiv='" + inventoryActionInvoiceModel.getOrganizationDivision() + "',";

		for (InventoryProductModel m : inventoryActionInvoiceModel.getProductList()) {

			litem = litem + "(@p_dnId,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\"" + m.getLocationId() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getUomId() + "\",\""
					+ inventoryActionInvoiceModel.getOrganizationName() + "\",\""
					+ inventoryActionInvoiceModel.getOrganizationDivision() + "\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";
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

	public static String getRfqApproveParam(InventoryActionInvoiceModel inventoryRfqModel) {
		String[] userIds = inventoryRfqModel.getInvId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_invIds='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + inventoryRfqModel.getModuleId() + "\",\"" + inventoryRfqModel.getComponentId() + "\",\""
					+ inventoryRfqModel.getSubComponentId() + "\",\"" + a + "\",\"" + "Update Inv" + "\",\""
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

	public static String getRfqDeleteParam(InventoryActionInvoiceModel inventoryRfqModel) {
		String[] userIds = inventoryRfqModel.getInvId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_invIds='" + litem + "',";
		s = s + "@p_orgName='" + litem + "',";
		s = s + "@p_orgDiv='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + inventoryRfqModel.getModuleId() + "\",\"" + inventoryRfqModel.getComponentId() + "\",\""
					+ inventoryRfqModel.getSubComponentId() + "\",\"" + a + "\",\"" + "Delete Inv" + "\",\""
					+ inventoryRfqModel.getCreatedBy() + "\",\"" + inventoryRfqModel.getOrganizationName() + "\",\""
					+ inventoryRfqModel.getOrganizationDivision() + "\"),";

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