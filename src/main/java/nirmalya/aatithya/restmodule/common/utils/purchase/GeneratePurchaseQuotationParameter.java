package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.inventory.model.InventoryRfqVendorModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;

    public class GeneratePurchaseQuotationParameter {
	public static String getAddQuotParam(List<RestPurchaseQuotationModel> purchase) {
		String s = "";
		String listdata ="";
		String vendorParam = "";
		//String vendorId="";
		String rfqId="";
		String reqNo="";
		String desc="";
		String reqType="";
		String reqPrior="";
		String receiveDate="";
		 String createdBy="";
        String organization="";
        String orgDivision="";
        String indentId="";
        String project="";
		
		for (RestPurchaseQuotationModel m : purchase) {
			//vendorId=m.getVendorId();
			rfqId=m.getRfqId();
			reqNo=m.getReqNo();
			desc=m.getDesc();
			reqType=m.getReqType();
			reqPrior=m.getReqPrior();
			receiveDate=m.getReceiveDate();
			createdBy=m.getCreatedBy();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
			indentId=m.getIndentId();
			project=m.getProject();
			
		}
		
		//s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_rfqId='" + rfqId + "',";
		s = s + "@p_reqNo='" + reqNo + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_reqType='" + reqType + "',";
		
		s = s + "@p_reqPrior='" + reqPrior + "',";
		s = s + "@p_receiveDate='" + DateFormatter.getStringDate(receiveDate) + "',";
		
		//s = s + "@p_receiveDate='" + receiveDate + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_div='" + orgDivision + "',";
		s = s + "@p_indentId='" + indentId + "',";
		s = s + "@p_project='" + project + "',";
		System.out.println("INDENYTTTT" + indentId);
		if(!purchase.get(0).getRfqId().contentEquals("1")) {
		for (RestPurchaseQuotationModel m : purchase) {

			listdata = listdata + "(@p_rfqId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\","
					+ m.getQuantity() + ",\"" + m.getUnit() + "\"," + m.getUnitPrice() +"," + m.getLineTotal() + ",\"" + m.getHsnCode() + "\",\"" + m.getSku()
					+ "\",@p_org,@p_div),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";
		
		List<InventoryRfqVendorModel> vendorList1 = new ArrayList<InventoryRfqVendorModel>();
		
		vendorList1 = purchase.get(0).getVendorList();
		
		for (InventoryRfqVendorModel a : vendorList1) {

			vendorParam = vendorParam + "(@p_rfqId,\"" + a.getVendorId() + "\",\"" + a.getLocationId() + "\",\""
					+ a.getExpertizeId() + "\",@p_createdBy,\"" + a.getReqSent() + "\",\""
					+ a.getCandidates() + "\",\"" + a.getClosed() + "\",@p_org,@p_div),";

		}
		vendorParam = vendorParam.substring(0, vendorParam.length() - 1);

		s = s + "@p_vendorParamSubQuery='" + vendorParam + "',";
	

		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		}
		System.out.println("Item Details" + s);
		return s;
	}

	
	public static String getDeleteInquiry(RestPurchaseQuotationModel purchase) {
		String[] userIds = purchase.getRfqId().split(",");
		
		String s = "";
		String litem = "";
		
		if (purchase.getOrganization() != null && purchase.getOrganization() != "") {
			s = s + "@p_orgName='" + purchase.getOrganization() + "',";
		}
		if (purchase.getOrgDivision() != null && purchase.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + purchase.getOrgDivision() + "',";
		}
		
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_rfqId='" + litem + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}
}
