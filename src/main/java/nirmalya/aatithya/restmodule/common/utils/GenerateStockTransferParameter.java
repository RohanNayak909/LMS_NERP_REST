package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.warehouse.model.RestStockTransferModel;

public class GenerateStockTransferParameter {
	
	public static String getStockTrasfer(RestStockTransferModel av) {
		String s = "";
		
		
		if (av.getCreatedBy() != null && av.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.getCreatedBy() + "',";
		}
		if (av.getOrganization() != null && av.getOrganization() != "") {
			s = s + "@p_org='" + av.getOrganization() + "',";
		}
		if (av.getOrgDivision() != null && av.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.getOrgDivision() + "',";
		}
		if (av.getBindata() != null && av.getBindata() != "") {
			s = s + "@p_binData='" + av.getBindata() + "',";
		}
		if (av.getUpdatebindata() != null && av.getUpdatebindata() != "") {
			s = s + "@p_upadtedBinData='" + av.getUpdatebindata() + "',";
		}
		if (av.getAllocationId() != null && av.getAllocationId() != "") {
			s = s + "@p_allocationId='" + av.getAllocationId() + "',";
		}
		if (av.getQuantity() != null && av.getQuantity() != "") {
			s = s + "@p_quantity='" + av.getQuantity() + "',";
		}
		
		
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}

	

}
