package nirmalya.aatithya.restmodule.common.utils.productionplan;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.productionplan.model.RmPmRequisitionRestModel;

public class GenerateParamRmPmRequisition {
	
	public static String getRmPmRequisition(RmPmRequisitionRestModel qa) {
		String s = "";
		String listdata = "";
		System.out.println("gatepass====" + qa);
		if (qa.getReqId() != null && qa.getReqId() != "") {
			s = s + "@p_reqId='" + qa.getReqId() + "',";
		}else {
			s = s + "@p_reqId='',";
		}
		if (qa.getPlanId() != null && qa.getPlanId() != "") {
			s = s + "@p_planId='" + qa.getPlanId() + "',";
		}else {
			s = s + "@p_planId='',";
		}
		if (qa.getReceiveDate() != null && qa.getReceiveDate() != "") {
			s = s + "@p_receivedDate='" + DateFormatter.getStringDate(qa.getReceiveDate()) + "',";
		}else {
			s = s + "@p_receivedDate='',";
		}
		if (qa.getDesc() != null && qa.getDesc() != "") {
			s = s + "@p_desc='" + qa.getDesc() + "',";
		}else {
			s = s + "@p_desc='',";
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
		if (qa.getProjectId() != null && qa.getProjectId() != "") {
			s = s + "@p_projectId='" + qa.getProjectId() + "',";
		}


		if (qa.getDetails() != null && !qa.getDetails().isEmpty()) {
			for (RmPmRequisitionRestModel m : qa.getDetails()) {
				listdata = listdata + "(@p_reqId,\""  + m.getItemId() + "\",\"" + m.getItemName() + "\",\"" + m.getModel()
				+ "\",\"" + m.getSku()  + "\",\"" + m.getHsnCode()  + "\",\"" + m.getUnit() + "\",\"" + m.getQuantity() 
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
