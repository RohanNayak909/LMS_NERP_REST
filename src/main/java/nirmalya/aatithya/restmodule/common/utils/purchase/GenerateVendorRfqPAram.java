package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorRfqModel;

public class GenerateVendorRfqPAram {

	public static String getVendorRfqParam(List<InventoryVendorRfqModel> inventoryRfqModel) {
		String s = "";
		String litem = "";
		String document=  "";
		String itemRequisition = "";
		String comments = "";
		String vendorRfq = "";
		String rfqId = "";
		String moduleId = "";
		String componentId = "";
		String subCmponentId = "";
		String description = "";
		String expectedDate = "";
		String requisitionType = "";
		String createdBy = "";
		String saveStatus = "";
		String orgName = "";
		String orgDivision = "";
		for (InventoryVendorRfqModel m : inventoryRfqModel) {
			itemRequisition = m.getReqId();
			vendorRfq = m.getVendorRfqId();
			comments = m.getComments();
			rfqId = m.getRfqId();
			moduleId = m.getModuleId();
			componentId = m.getComponentId();
			subCmponentId = m.getSubComponentId();
			description = m.getDesc();
			expectedDate = m.getReceiveDate();
			//expectedDate = DateFormatter.getStringDate(m.getReceiveDate());
			requisitionType = m.getReqType();
			createdBy = m.getCreatedBy();
			saveStatus = m.getSaveStatus();
			orgName=m.getOrganizationName();
			orgDivision=m.getOrganizationDivision();
		}
		s = s + "@p_rfqId='" + rfqId + "',";
		s = s + "@p_itemRequisition='" + itemRequisition + "',";
		s = s + "@p_comments='" + comments + "',";
		s = s + "@p_vend_rfqId='" + vendorRfq + "',";

		s = s + "@p_iRDescription='" + description + "',";
		s = s + "@p_receiveDate='" + expectedDate + "',";
		s = s + "@p_iRPrior='" + inventoryRfqModel.get(0).getReqPrior() + "',";
		s = s + "@p_iRType='" + requisitionType + "',";
		s = s + "@p_moduleId='" + moduleId + "',";
		s = s + "@p_componentId='" + componentId + "',";
		s = s + "@p_subCmponentId='" + subCmponentId + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_saveStatus='" + saveStatus + "',";
		s = s + "@p_orgName='" + orgName + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
 
		for (InventoryVendorRfqModel m : inventoryRfqModel) {

			litem = litem + "(@p_vend_rfqId,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\"" + m.getLocationId()
					+ "\",\"" + m.getQty() + "\",\"" + m.getUomId() + "\",\"" + m.getEstimatedTotalPrice() + "\",\""
					+ m.getEstimatedPrice() + "\",\"" + m.getCreatedBy() + "\",\"" +m.getOrganizationName()+"\",\""+m.getOrganizationDivision()+"\"),";
		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";
		
		for (InventoryVendorDocumentModel a : inventoryRfqModel.get(0).getDocumentList()) {
			document = document + "(@p_vend_rfqId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",@p_createdBy,@p_orgName,@p_orgDiv),";
		}
		if(!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_vendorDocuments='" + document + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
