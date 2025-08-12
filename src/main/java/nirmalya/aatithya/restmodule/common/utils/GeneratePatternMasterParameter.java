package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestPatternMasterModel;

public class GeneratePatternMasterParameter {
	public static String getPatternMasterParam(RestPatternMasterModel patternModel) {

		String s = "";
		String document = "";

		if (patternModel.getPatternId() != null || patternModel.getPatternId() != "") {
			s = s + "@p_patternId='" + patternModel.getPatternId() + "',";
		}
		if (patternModel.getProjectName() != null || patternModel.getProjectName() != "") {
			s = s + "@p_pojectName='" + patternModel.getProjectName() + "',";
		}
		if (patternModel.getItemName() != null || patternModel.getItemName() != "") {
			s = s + "@p_itemName='" + patternModel.getItemName() + "',";
		}
		if (patternModel.getDate() != null || patternModel.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(patternModel.getDate()) + "',";
		}
		if (patternModel.getHeight() != null || patternModel.getHeight()!="") {
			s = s + "@p_width='" + patternModel.getHeight() + "',";
		}
		if (patternModel.getWidth() != null || patternModel.getWidth()!="") {
			s = s + "@p_height='" + patternModel.getWidth() + "',";
		}
		if (patternModel.getDesc() != null || patternModel.getDesc()!="") {
			s = s + "@p_desc='" + patternModel.getDesc() + "',";
		}
		if (patternModel.getCreatedBy() != null || patternModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + patternModel.getCreatedBy() + "',";
		}
		if(patternModel.getOrganization() != null || patternModel.getOrganization() != "") {
			s = s + "@p_org='" + patternModel.getOrganization() + "',";
		}
		if(patternModel.getOrgDivision() != null || patternModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + patternModel.getOrgDivision() + "',";
		}
		
		for (InventoryVendorDocumentModel a : patternModel.getDocumentList()) {
			if(a.getFileName()!="" && a.getFileName()!=null) {
				document = document + "(@p_patternId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()+ "\",@p_createdBy),";
			}
		}
		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_documents='" + document + "',";
		}else {
			s = s + "@p_documents='" +null+ "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
