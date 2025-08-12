package nirmalya.aatithya.restmodule.common.utils.purchase;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.purchase.model.RestRmPmMaterialIssueModel;

public class GenerateRmPmMaterialIssueParam {
	
	public static String getRmPmMaterialIssue(RestRmPmMaterialIssueModel qa) {
		String s = "";
		String listdata = "";
		System.out.println("gatepass====" + qa);
		if (qa.getSlipId() != null && qa.getSlipId() != "") {
			s = s + "@p_slipId='" + qa.getSlipId() + "',";
		}
		if (qa.getReqId() != null && qa.getReqId() != "") {
			s = s + "@p_reqId='" + qa.getReqId() + "',";
		}
		if (qa.getMaterialIssueDate() != null && qa.getMaterialIssueDate() != "") {
			s = s + "@p_materialIssueDate='" + DateFormatter.getStringDate(qa.getMaterialIssueDate()) + "',";
		}
		if (qa.getReceiveDate() != null && qa.getReceiveDate() != "") {
			s = s + "@p_requestedDate='" + DateFormatter.getStringDate(qa.getReceiveDate()) + "',";
		}
		if (qa.getDesc() != null && qa.getDesc() != "") {
			s = s + "@p_desc='" + qa.getDesc() + "',";
		}
		
		if (qa.getCreatedBy() != null && qa.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qa.getCreatedBy() + "',";
		}
		if (qa.getOrganization() != null && qa.getOrganization() != "") {
			s = s + "@p_org='" + qa.getOrganization() + "',";
		}
		if (qa.getOrgDivision() != null && qa.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qa.getOrgDivision() + "',";
		}


		if (qa.getDetails() != null && !qa.getDetails().isEmpty()) {
			for (RestRmPmMaterialIssueModel m : qa.getDetails()) {
				listdata = listdata + "(@p_slipId,\""  + qa.getReqId() + "\",\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\"" + m.getModel()
				+ "\",\"" + m.getSku()  + "\",\"" + m.getHsnCode()  + "\",\"" + m.getUnit() + "\",\"" + m.getQuantity() + "\",\"" + m.getQuantityIssued() + "\",\"" + m.getGrnNo() 
				+ "\",\"" + qa.getOrganization() + "\",\"" + qa.getOrgDivision() + "\"),";
				
				

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_itemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_itemSubQuery='',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}

}
