package nirmalya.aatithya.restmodule.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import nirmalya.aatithya.restmodule.procurment.model.InventoryPoModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;

/**
 * 
 * @author Nirmalya Labs
 *
 */
public class GeneratePoParam {
	private GeneratePoParam() {
		throw new IllegalStateException("GeneratePoParam class");

	}

	/**
	 * 
	 * @param inventoryPoModel
	 * @return query for adding and modifying PO
	 */
	public static String getPoParam(InventoryPoModel inventoryPoModel) {
		String s = "";
		String litem = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		if (inventoryPoModel.getPoId() != null && inventoryPoModel.getPoId() != "") {
			s = s + "@p_poId='" + inventoryPoModel.getPoId() + "',";
		}
		if (inventoryPoModel.getReqId() != null && inventoryPoModel.getReqId() != "") {
			s = s + "@p_sourceId='" + inventoryPoModel.getReqId() + "',";
		}
		if (inventoryPoModel.getDesc() != null && inventoryPoModel.getDesc() != "") {
			s = s + "@p_desc='" + inventoryPoModel.getDesc() + "',";
		}
		if (inventoryPoModel.getReqType() != null && inventoryPoModel.getReqType() != "") {
			s = s + "@p_reqTypeId='" + inventoryPoModel.getReqType() + "',";
		}
		if (inventoryPoModel.getReqPrior() != null && inventoryPoModel.getReqPrior() != "") {
			s = s + "@p_reqPriorityId='" + inventoryPoModel.getReqPrior() + "',";
		}
		if (inventoryPoModel.getHoldStatus() != null && inventoryPoModel.getHoldStatus() != "") {
			s = s + "@p_approveStatus='" + inventoryPoModel.getHoldStatus() + "',";
		}
		if (inventoryPoModel.getReceiveDate() != null && inventoryPoModel.getReceiveDate() != "") {
			s = s + "@p_receiveDate='" + DateFormatter.getStringDate(inventoryPoModel.getReceiveDate()) + "',";
		}
		if (inventoryPoModel.getStartDate() != null && inventoryPoModel.getStartDate() != "") {
			s = s + "@p_startDate='" + DateFormatter.getStringDate(inventoryPoModel.getStartDate()) + "',";
		}
		if (inventoryPoModel.getExpireDate() != null && inventoryPoModel.getExpireDate() != "") {
			s = s + "@p_expireDate='" + DateFormatter.getStringDate(inventoryPoModel.getExpireDate()) + "',";
		}
		if (inventoryPoModel.getExpireDate() != null && inventoryPoModel.getExpireDate() != "") {
			s = s + "@p_expireDate='" + DateFormatter.getStringDate(inventoryPoModel.getExpireDate()) + "',";
		}
		if (inventoryPoModel.getTotalMaxAmount() != null) {
			s = s + "@p_maxTotal='" + inventoryPoModel.getTotalMaxAmount() + "',";
		}
		if (inventoryPoModel.getPaymentTerm() != null && inventoryPoModel.getPaymentTerm() != "") {
			s = s + "@p_payTerm='" + inventoryPoModel.getPaymentTerm() + "',";
		}
		if (inventoryPoModel.getVendorId() != null && inventoryPoModel.getVendorId() != "") {

			s = s + "@p_vendor='" + inventoryPoModel.getVendorId() + "',";
		}
		if (inventoryPoModel.getLegalTerm() != null && inventoryPoModel.getLegalTerm() != "") {
			s = s + "@p_legalTerm='" + inventoryPoModel.getLegalTerm() + "',";
		}
		if (inventoryPoModel.getLegalTermDesc() != null && inventoryPoModel.getLegalTermDesc() != "") {
			s = s + "@p_legalTermDesc='" + inventoryPoModel.getLegalTermDesc() + "',";
		}

		if (inventoryPoModel.getHoldStatus().contentEquals("4")) {
			s = s + "@p_onHoldDate='" + dtf.format(now) + "',";
		}
		if (inventoryPoModel.getOrganizationName() != null
				&& inventoryPoModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + inventoryPoModel.getOrganizationName() + "',";
		}
		if (inventoryPoModel.getOrganizationDivision() != null
				&& inventoryPoModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + inventoryPoModel.getOrganizationDivision() + "',";
		}
		s = s + "@p_moduleId='" + inventoryPoModel.getModuleId() + "',";
		s = s + "@p_componentId='" + inventoryPoModel.getComponentId() + "',";
		s = s + "@p_subCmponentId='" + inventoryPoModel.getSubComponentId() + "',";
		s = s + "@p_createdBy='" + inventoryPoModel.getCreatedBy() + "',";

		for (InventoryProductModel m : inventoryPoModel.getProductList()) {

			litem = litem + "(@p_PoId,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\"" + m.getCostCenterId()
					+ "\",\"" + m.getLocationId() + "\",\"" + m.getQuantity() + "\",\"" + m.getUomId() + "\",\""
					+ m.getUnitPrice() + "\",\"" + m.getDiscount() + "\",\"" + m.getSubTotalPrice() + "\",\""
					+ m.getTax() + "\",\"" + m.getShipping() + "\",\"" + m.getTotal() + "\",\"" + m.getMaxValue()
					+ "\",@p_createdBy" + ",\""+inventoryPoModel.getOrganizationName()+"\",\""+inventoryPoModel.getOrganizationDivision()+"\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	/**
	 * 
	 * @param inventoryPoModel
	 * @return query for multiple update of status
	 */
	public static String getPoApproveParam(InventoryPoModel inventoryPoModel) {
		String[] userIds = inventoryPoModel.getPoId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_poId='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + inventoryPoModel.getModuleId() + "\",\"" + inventoryPoModel.getComponentId() + "\",\""
					+ inventoryPoModel.getSubComponentId() + "\",\"" + a + "\",\"" + "Approve PO" + "\",\""
					+ inventoryPoModel.getCreatedBy() + "\",\"" + inventoryPoModel.getOrganizationName() + "\",\"" + inventoryPoModel.getOrganizationDivision() + "\"),";

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
	 * @param inventoryPoModel
	 * @return query for multiple update of status
	 */
	public static String getPoDeleteParam(InventoryPoModel inventoryPoModel) {
		String[] userIds = inventoryPoModel.getPoId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_poId='" + litem + "',";
		s = s + "@p_orgName='" + litem + "',";
		s = s + "@p_orgDiv='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + inventoryPoModel.getModuleId() + "\",\"" + inventoryPoModel.getComponentId() + "\",\""
					+ inventoryPoModel.getSubComponentId() + "\",\"" + a + "\",\"" + "Delete PO" + "\",\""
					+ inventoryPoModel.getCreatedBy() + "\",\""+inventoryPoModel.getOrganizationName()+"\",\""+inventoryPoModel.getOrganizationDivision()+"\"),";

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
