package nirmalya.aatithya.restmodule.common.utils.qa;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.qa.model.RestQaWbcrModel;

public class GanearteWbcrParam {
	public static String getWbcrData(RestQaWbcrModel qa) {
		String s = "";
		String listdata = "";
		System.out.println("gatepass====" + qa);
		if (qa.getWbcrId() != null && qa.getWbcrId() != "") {
			s = s + "@p_wbcrId='" + qa.getWbcrId() + "',";
		}
		
		if (qa.getDate() != null && qa.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(qa.getDate()) + "',";
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
		
		
		
		if (qa.getItemDtls() != null && !qa.getItemDtls().isEmpty()) {
			for (RestQaWbcrModel m : qa.getItemDtls()) {
				listdata = listdata + "(@p_wbcrId,\"" + m.getType() + "\",\"" + m.getPckMcinDesc() + "\",\"" + m.getSku() + "\",\"" + m.getWsSlNo() + "\",\""+ m.getShiftA()
				+ "\",\"" + m.getShiftB() + "\",\"" + m.getShiftC() + "\",\"" + m.getRemarks()  + "\",\"" + qa.getOrganization() + "\",\"" + qa.getOrgDivision() + "\"),";

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
