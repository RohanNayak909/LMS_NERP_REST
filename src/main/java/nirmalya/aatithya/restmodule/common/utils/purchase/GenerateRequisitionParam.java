package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;
 

public class GenerateRequisitionParam {

	/**
	 * add parameter set for inventory itemRequisition class
	 *
	 **/
	public static String getItemRequisitionDtlParam(List<InventoryRequisitionModel> restItemRequisitonModel) {
		String s = "";
		String litem = "";
		String itemRequisition = "";
		String description = "";
		String expectedDate = "";
		String requisitionType = "";
		String status = null;
		String createdBy = "";
		String isProductExist = "";
		String orgName = "";
		String orgDivision = "";
		String costCenter = "";
		for (InventoryRequisitionModel m : restItemRequisitonModel) {
			itemRequisition = m.getReqId();
			description = m.getDesc();
//			expectedDate = DateFormatter.getStringDate(m.getReceiveDate());
			expectedDate = m.getReceiveDate();
			requisitionType = m.getReqType();
			status = m.getHoldStatus();
			createdBy = m.getCreatedBy();
			isProductExist = m.getIsProductExist();
			orgName=m.getOrganizationName();
			orgDivision=m.getOrganizationDivision();
			costCenter=m.getCostCenterId();
		}
		s = s + "@p_itemRequisition='" + itemRequisition + "',";
		s = s + "@p_iRDescription='" + description + "',";
		s = s + "@p_receiveDate='" + expectedDate + "',";
		s = s + "@p_iRPrior='" + restItemRequisitonModel.get(0).getReqPrior() + "',";
		s = s + "@p_iRType='" + requisitionType + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_isProductExist=" + isProductExist + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_orgName='" + orgName + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		s = s + "@p_costCenter='" + costCenter + "',";
		if(!restItemRequisitonModel.get(0).getReqId().contentEquals("1")) {
			for (InventoryRequisitionModel m : restItemRequisitonModel) {

				litem = litem + "(@p_itemRequisition,\"" + m.getItemId() + "\",\"" + m.getSku() + "\", \"" + m.getHsnCode() + "\",\"" + m.getLocationId() + "\",\"" + m.getQuantity() + "\",\"" + m.getUnit()
						+ "\",\"" + m.getCreatedBy()
						+ "\",\"" +m.getOrganizationName()+ "\",\""+m.getOrganizationDivision()+"\"),";

			}
			litem = litem.substring(0, litem.length() - 1);

			s = s + "@p_litemSubQuery='" + litem + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getDeleteParam(InventoryRequisitionModel restItemRequisitonModel) {
		String[] userIds = restItemRequisitonModel.getReqId().split(",");
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

			act = act + "(\"" + restItemRequisitonModel.getModuleId() + "\",\""
					+ restItemRequisitonModel.getComponentId() + "\",\"" + restItemRequisitonModel.getSubComponentId()
					+ "\",\"" + a + "\",\"" + "Delete Requisition" + "\",\"" + restItemRequisitonModel.getCreatedBy()
					+ "\",\""+restItemRequisitonModel.getOrganizationName()+"\",\""+restItemRequisitonModel.getOrganizationDivision()+"\"),";

		}
		act = act.substring(0, act.length() - 1);

		s = s + "@p_actSubQuery='" + act + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getApproveParam(InventoryRequisitionModel restItemRequisitonModel) {
		String[] userIds = restItemRequisitonModel.getReqId().split(",");
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

			act = act + "(\"" + restItemRequisitonModel.getModuleId() + "\",\""
					+ restItemRequisitonModel.getComponentId() + "\",\"" + restItemRequisitonModel.getSubComponentId()
					+ "\",\"" + a + "\",\"" + "Approve Requisition" + "\",\"" + restItemRequisitonModel.getCreatedBy()
					+ "\"),";

		}
		act = act.substring(0, act.length() - 1);

		s = s + "@p_actSubQuery='" + act + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
	/*
	 * get category ids
	 */
	@SuppressWarnings("unused")
	public static String getProduct(String items) {
		String[] productCatIds = items.split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : productCatIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_catIds='" + litem + "',";

		//act = act.substring(0, act.length() - 1);

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	
	public static String getItemRequisitionParam(List<RestPurchaseIndentModel> purchase) {
		String s = "";
		String listdata = "";
		String reqId = "";
		String indentDate = "";
		String receiveDate="";
		String desc = "";
		String dept = "";
		String project = "";
		String taskId = "";
		
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
	
		String multidocument = "";
		

		for (RestPurchaseIndentModel m : purchase) {
			reqId = m.getReqId();
			indentDate = m.getIndentDate();
			receiveDate=m.getReceiveDate();
			dept = m.getDeptId();
			project = m.getProject();
			//taskId = m.getTaskId();
			desc = m.getDesc();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();

		}
	
       
		s = s + "@p_reqId='" + reqId + "',";
		s = s + "@p_indentDate='" + indentDate + "',";
		if (receiveDate != null && receiveDate != "null") {
			s = s + "@p_receiveDate='" + DateFormatter.getStringDate(receiveDate) + "',";
		}
		s = s + "@p_dept='" + dept + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_taskId='" + taskId + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		
		
		if (!purchase.get(0).getReqId().contentEquals("1")) {
			for (RestPurchaseIndentModel m : purchase) {

				listdata = listdata + "(@p_reqId,\"" + m.getItemId() + "\",\"" + m.getItemName()
						+ "\"," + m.getQuantity() + ",\"" + m.getSku() + "\",\"" + m.getHsnCode() + "\",\"" + m.getUnit() + "\",\"" + m.getModel() + "\",@p_organization,@p_orgDivision),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";
			
			
			for (InventoryVendorDocumentModel a : purchase.get(0).getDocumentList()) {
				if(!a.getDocumnentName().contentEquals("") && !a.getDocumnentName().contentEquals("null")) {
				multidocument = multidocument + "(@p_reqId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
						+ "\",@p_createdBy,@p_organization,@p_orgDivision),";}
				
			}
			if (!multidocument.isEmpty()) {
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			}

		
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
				System.out.println(s);
			}
		}
		return s;
	}	
	
	
	public static String getAddUloadedRequisitionDataParam(List<RestPurchaseIndentModel> data) {
		String s = "";

		String datalist = "";

		if (data.size() > 0) {
			for (RestPurchaseIndentModel m : data) {

				datalist = datalist + "(@p_reqId,getDeptId(\"" + m.getDeptId() + "\"),\"" + m.getIndentDate() + "\",\""
						+ m.getDesc() + "\",\"" + m.getSku() + "\",\"" + m.getHsnCode() + "\", getProductId(\""
						+ m.getItemName() + "\"),\"" + m.getItemName() + "\",\"" + m.getModel() + "\",\"" + m.getQty()
						+ "\",getUnitId(\"" + m.getUnit() + "\"),\"" + m.getOrganization() + "\",\""
						+ m.getOrgDivision() + "\",\"" + m.getCreatedBy() + "\"),";
			}

		}
		/*
		 * if(!emplist.isEmpty()) { emplist = emplist.substring(0, emplist.length() -
		 * 1); s = s + "@p_emplist='" + emplist + "',"; }
		 */
		if (!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_EmpSubQuery='" + datalist + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
