package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestCheckingDetailsModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestMouldMasterModel;


public class GenerateMoldmasterParameter {
	
	public static String getMoldMasterParam(RestMouldMasterModel moldModel) {

		String s = "";
		String sitem = "";
		String document = "";

		if (moldModel.getMoldid() != null || moldModel.getMoldid() != "") {
			s = s + "@p_moldid='" + moldModel.getMoldid() + "',";
		}
		if (moldModel.getProjectName() != null || moldModel.getProjectName() != "") {
			s = s + "@p_pojectName=\"" + moldModel.getProjectName() + "\",";
		}
		if (moldModel.getItems() != null || moldModel.getItems() != "") {
			s = s + "@p_itemName=\"" + moldModel.getItems() + "\",";
		}
		if (moldModel.getPattern() != null || moldModel.getPattern() != "") {
			s = s + "@p_pattern=\"" + moldModel.getPattern() + "\",";
		}
		if (moldModel.getMoldType() != null || moldModel.getMoldType() != "") {
			s = s + "@p_moldType='" + moldModel.getMoldType() + "',";
		}
		if (moldModel.getDate() != null || moldModel.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(moldModel.getDate()) + "',";
		}
		
		if (moldModel.getSize() != null || moldModel.getSize()!="") {
			s = s + "@p_size=\"" + moldModel.getSize() + "\",";
		}
		
		if (moldModel.getTh() != null || moldModel.getTh()!="") {
			s = s + "@p_th=\"" + moldModel.getTh() + "\",";
		}

		if (moldModel.getFromDate() != null || moldModel.getFromDate() != "") {
			s = s + "@p_fromdate='" + DateFormatter.getStringDate(moldModel.getFromDate()) + "',";
		}
		
		if (moldModel.getToDate() != null || moldModel.getToDate() != "") {
			s = s + "@p_todate='" + DateFormatter.getStringDate(moldModel.getToDate())+ "',";
		}
		if (moldModel.getCostingteam() != null || moldModel.getCostingteam()!="") {
			s = s + "@p_costingteam='" + moldModel.getCostingteam() + "',";
		}
		if (moldModel.getDesc() != null || moldModel.getDesc()!="") {
			s = s + "@p_desc=\"" + moldModel.getDesc() + "\",";
		}
		if (moldModel.getCreatedBy() != null || moldModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + moldModel.getCreatedBy() + "',";
		}

		if(moldModel.getOrganization() != null || moldModel.getOrganization() != "") {
			s = s + "@p_org='" + moldModel.getOrganization() + "',";
		}
		if(moldModel.getOrgDivision() != null || moldModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + moldModel.getOrgDivision() + "',";
		}

		for (RestCheckingDetailsModel m : moldModel.getActivity()) {

			sitem = sitem + "(@p_moldid,\"" + m.getCheckingid() +
					"\",\"" +m.getCheckingname() +"\",\"" +m.getStatusid() + 
					"\",\"" + m.getStatus() + "\",\"" + m.getRemarks() +  "\"),";
 
		}
		
		sitem = sitem.substring(0, sitem.length() - 1);
		s = s + "@p_itemSubQuery='" + sitem + "',";
		
		for (InventoryVendorDocumentModel a : moldModel.getDocumentList()) {
			document = document + "(@p_moldid,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
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

		System.out.println(s);

		return s;
	}

}
