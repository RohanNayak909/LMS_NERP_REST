package nirmalya.aatithya.restmodule.common.utils.sales;

import nirmalya.aatithya.restmodule.sales.model.RestProductsConversionChartModel;

public class GenerateProductConversionParameter {
	public static String getAddProductConversionParam(RestProductsConversionChartModel form) {
		String s = "";
		
		if (form.getProductId() != null) {
			s = s + "@p_productId='" + form.getProductId() + "',";
		}
		
		if (form.getPackSize() != null && form.getPackSize() != "") {
			s = s + "@p_packSize='" + form.getPackSize() + "',";
		}
		
		if (form.getPouchBag() != null && form.getPouchBag() != "") {
			s = s + "@p_pouchBag='" + form.getPouchBag() + "',";
		}
		
		if (form.getCostPerMT() != null && form.getCostPerMT() != "") {
			s = s + "@p_costPerMT='" + form.getCostPerMT() + "',";
		}
		
		if (form.getCostPerKG() != null && form.getCostPerKG() != "") {
			s = s + "@p_costPerKG='" + form.getCostPerKG() + "',";
		}
		
		if (form.getCostPerBag() != null && form.getCostPerBag() != "") {
			s = s + "@p_costPerBag='" + form.getCostPerBag() + "',";
		}
		
		if (form.getStatus() != null && form.getStatus() != "") {
			s = s + "@p_status='" + form.getStatus() + "',";
		}
		
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription() + "',";
		}
		
		if (form.getPerEaToGm() != null && form.getPerEaToGm() != "") {
			s = s + "@p_perEaToGm='" + form.getPerEaToGm() + "',";
		}
		
		if (form.getPerBagToGm() != null && form.getPerBagToGm() != "") {
			s = s + "@p_perBagToGm='" + form.getPerBagToGm() + "',";
		}
		
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		
		if (form.getOrgName() != null && form.getOrgName() != "") {
			s = s + "@p_orgName='" + form.getOrgName() + "',";
		}
		
		if (form.getOrgDiv() != null && form.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + form.getOrgDiv() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
