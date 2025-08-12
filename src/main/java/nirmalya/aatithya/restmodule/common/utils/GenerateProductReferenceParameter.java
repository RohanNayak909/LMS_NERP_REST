package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestReferenceProductModel;

public class GenerateProductReferenceParameter {

	public static String addBrandTypeParam(RestReferenceProductModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getBrandId() != null || restProcurementMasterModel.getBrandId() != "") {
			s = s + "@p_brandId='" + restProcurementMasterModel.getBrandId() + "',";
		}
		if (restProcurementMasterModel.getBrandName() != null || restProcurementMasterModel.getBrandName() != "") {
			s = s + "@p_brandName='" + restProcurementMasterModel.getBrandName() + "',";
		}
		if (restProcurementMasterModel.getBrandOrder() != null || restProcurementMasterModel.getBrandOrder() != "") {
			s = s + "@p_brandOrder='" + restProcurementMasterModel.getBrandOrder() + "',";
		}
		if (restProcurementMasterModel.getBrandCode() != null || restProcurementMasterModel.getBrandCode() != "") {
			s = s + "@p_brandCode='" + restProcurementMasterModel.getBrandCode() + "',";
		}
		if (restProcurementMasterModel.getBrandDesc() != null || restProcurementMasterModel.getBrandDesc() != "") {
			s = s + "@p_brandDesc='" + restProcurementMasterModel.getBrandDesc() + "',";
		}
		if (restProcurementMasterModel.getBrandStatus() != null || restProcurementMasterModel.getBrandStatus() != "") {
			s = s + "@p_brandStatus='" + restProcurementMasterModel.getBrandStatus() + "',";
		}
		if (restProcurementMasterModel.getBrandCreatedBy() != null
				|| restProcurementMasterModel.getBrandCreatedBy() != "") {
			s = s + "@p_brandCreatedBy='" + restProcurementMasterModel.getBrandCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String addProductTypeParam(RestReferenceProductModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getProductId() != null || restProcurementMasterModel.getProductId() != "") {
			s = s + "@p_productId='" + restProcurementMasterModel.getProductId() + "',";
		}
		if (restProcurementMasterModel.getProductOrder() != null
				|| restProcurementMasterModel.getProductOrder() != "") {
			s = s + "@p_productOrder='" + restProcurementMasterModel.getProductOrder() + "',";
		}
		if (restProcurementMasterModel.getProductName() != null || restProcurementMasterModel.getProductName() != "") {
			s = s + "@p_productName='" + restProcurementMasterModel.getProductName() + "',";
		}
		if (restProcurementMasterModel.getProductDesc() != null || restProcurementMasterModel.getProductDesc() != "") {
			s = s + "@p_productDesc='" + restProcurementMasterModel.getProductDesc() + "',";
		}
		if (restProcurementMasterModel.getProductStatus() != null
				|| restProcurementMasterModel.getProductStatus() != "") {
			s = s + "@p_productStatus='" + restProcurementMasterModel.getProductStatus() + "',";
		}
		if (restProcurementMasterModel.getProductCreatedBy() != null
				|| restProcurementMasterModel.getProductCreatedBy() != "") {
			s = s + "@p_productCreatedBy='" + restProcurementMasterModel.getProductCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	public static String addInsuranceTypeParam(RestReferenceProductModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getInsuranceId() != null || restProcurementMasterModel.getInsuranceId() != "") {
			s = s + "@p_insuranceId='" + restProcurementMasterModel.getInsuranceId() + "',";
		}
		if (restProcurementMasterModel.getInsuranceName() != null
				|| restProcurementMasterModel.getInsuranceName() != "") {
			s = s + "@p_insuranceName='" + restProcurementMasterModel.getInsuranceName() + "',";
		}
		if (restProcurementMasterModel.getInsuranceDesc() != null || restProcurementMasterModel.getInsuranceDesc() != "") {
			s = s + "@p_insuranceDesc='" + restProcurementMasterModel.getInsuranceDesc() + "',";
		}
		if (restProcurementMasterModel.getInsuranceStatus() != null
				|| restProcurementMasterModel.getInsuranceStatus() != "") {
			s = s + "@p_insuranceStatus='" + restProcurementMasterModel.getInsuranceStatus() + "',";
		}
		if (restProcurementMasterModel.getInsuranceCreatedBy() != null
				|| restProcurementMasterModel.getInsuranceCreatedBy() != "") {
			s = s + "@p_insuranceCreatedBy='" + restProcurementMasterModel.getInsuranceCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	public static String addInsuranceProvdrTypeParam(RestReferenceProductModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getInsurancePrvdrId() != null || restProcurementMasterModel.getInsurancePrvdrId() != "") {
			s = s + "@p_insurancePrvdrId='" + restProcurementMasterModel.getInsurancePrvdrId() + "',";
		}
		if (restProcurementMasterModel.getInsurancePrName() != null
				|| restProcurementMasterModel.getInsurancePrName() != "") {
			s = s + "@p_insurancePrName='" + restProcurementMasterModel.getInsurancePrName() + "',";
		}
		if (restProcurementMasterModel.getInsurancePrvdrName() != null
				|| restProcurementMasterModel.getInsurancePrvdrName() != "") {
			s = s + "@p_insurancePrvdrName='" + restProcurementMasterModel.getInsurancePrvdrName() + "',";
		}
		if (restProcurementMasterModel.getInsuranceAmount() != null || restProcurementMasterModel.getInsuranceAmount() != "") {
			s = s + "@p_insuranceAmount='" + restProcurementMasterModel.getInsuranceAmount() + "',";
		}
		if (restProcurementMasterModel.getInsurancefrmdt() != null
				|| restProcurementMasterModel.getInsurancefrmdt() != "") {
			s = s + "@p_insurancefrmdt='" + restProcurementMasterModel.getInsurancefrmdt() + "',";
		}
		if (restProcurementMasterModel.getInsurancetodt() != null
				|| restProcurementMasterModel.getInsurancetodt() != "") {
			s = s + "@p_insurancetodt='" + restProcurementMasterModel.getInsurancetodt() + "',";
		}
		if (restProcurementMasterModel.getInsurancePrvdrCreatedBy() != null
				|| restProcurementMasterModel.getInsurancePrvdrCreatedBy() != "") {
			s = s + "@p_insurancePrvdrCreatedBy='" + restProcurementMasterModel.getInsurancePrvdrCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			//System.out.println(s);
		}
		return s;
		

	}

	public static String addVariationTypeParam(RestReferenceProductModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getVariationId() != null || restProcurementMasterModel.getVariationId() != "") {
			s = s + "@p_variationId='" + restProcurementMasterModel.getVariationId() + "',";
		}
		if (restProcurementMasterModel.getVariationName() != null
				|| restProcurementMasterModel.getVariationName() != "") {
			s = s + "@p_variationName='" + restProcurementMasterModel.getVariationName() + "',";
		}
		if (restProcurementMasterModel.getVariationDesc() != null
				|| restProcurementMasterModel.getVariationDesc() != "") {
			s = s + "@p_variationDesc='" + restProcurementMasterModel.getVariationDesc() + "',";
		}
		if (restProcurementMasterModel.getVariationStatus() != null
				|| restProcurementMasterModel.getVariationStatus() != "") {
			s = s + "@p_variationStatus='" + restProcurementMasterModel.getVariationStatus() + "',";
		}
		if (restProcurementMasterModel.getVariationCreatedBy() != null
				|| restProcurementMasterModel.getVariationCreatedBy() != "") {
			s = s + "@p_variationCreatedBy='" + restProcurementMasterModel.getVariationCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	public static String addTransportTypeParam(RestReferenceProductModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getTransportId() != null || restProcurementMasterModel.getTransportId() != "") {
			s = s + "@p_transportId='" + restProcurementMasterModel.getTransportId() + "',";
		}
		if (restProcurementMasterModel.getTransportName() != null
				|| restProcurementMasterModel.getTransportName() != "") {
			s = s + "@p_transportName='" + restProcurementMasterModel.getTransportName() + "',";
		}
		if (restProcurementMasterModel.getTransportDesc() != null || restProcurementMasterModel.getTransportDesc() != "") {
			s = s + "@p_transportDesc='" + restProcurementMasterModel.getTransportDesc() + "',";
		}
		
		if (restProcurementMasterModel.getTransportCreatedBy() != null
				|| restProcurementMasterModel.getTransportCreatedBy() != "") {
			s = s + "@p_transportCreatedBy='" + restProcurementMasterModel.getTransportCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}