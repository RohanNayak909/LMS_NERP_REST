package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.ProductDetailsModel;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;

public class GenerateProductMasterParameter {

	public static String saveProduct(ProductMasterModel product) {
		
		String s = "";
		
		if(product.getProductId()!=null && product.getProductId()!="") {
			s = s + "@p_productId='" + product.getProductId() + "',";
		}
		if(product.getProductName()!=null && product.getProductName()!="") {
			s = s + "@p_productName='" + product.getProductName() + "',";
		}
		if(product.getBrand()!=null && product.getBrand()!="") {
			s = s + "@p_brand='" + product.getBrand() + "',";
		}
		if(product.getMode()!=null && product.getMode()!="") {
			s = s + "@p_mode='" + product.getMode() + "',";
		}
		if(product.getParentCategory()!=null && product.getParentCategory()!="") {
			s = s + "@p_parentCategory='" + product.getParentCategory() + "',";
		}

		if(product.getHsnCode()!=null && product.getHsnCode()!="") {
			s = s + "@p_hsnCode='" + product.getHsnCode() + "',";
		}
		if(product.getSicCode()!=null && product.getSicCode()!="") {
			s = s + "@p_sicCode='" + product.getSicCode() + "',";
		}
		
		if(product.getProductCategory()!=null && product.getProductCategory()!="") {
			s = s + "@p_productCat='" + product.getProductCategory() + "',";
		}
		if(product.getSubcategory()!=null && product.getSubcategory()!="") {
			s = s + "@p_subCategory='" + product.getSubcategory() + "',";
		}
		if(product.getProductCategoryText()!=null && product.getProductCategoryText()!="") {
			s = s + "@p_productCatText='" + product.getProductCategoryText() + "',";
		}
		if(product.getCreatedBy()!=null && product.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + product.getCreatedBy() + "',";
		}
		if(product.getProductStatus()!=null && product.getProductStatus()!="") {
			s = s + "@p_isProdActive='" + product.getProductStatus() + "',";
		} else {
			s = s + "@p_isProdActive='" + 0 + "',";
		}
		if(product.getOrganizationName()!=null && product.getOrganizationName()!="") {
			s = s + "@p_orgName='" + product.getOrganizationName() + "',";
		}
		if(product.getOrganizationDivision()!=null && product.getOrganizationDivision()!="") {
			s = s + "@p_orgDiv='" + product.getOrganizationDivision() + "',";
		}
		
		if(product.getpImgName()!=null && product.getpImgName()!="") {
			s = s + "@p_productImg='" + product.getpImgName() + "',";
		}else {
			s = s + "@p_productImg='" + "" + "',";
		}
		
		
		/*
		 * if(product.getImgName().size() > 0) { for(String m : product.getImgName()) {
		 * img = img + "(@p_productId,\"" + m + "\"),"; }
		 * 
		 * img = img.substring(0, img.length() - 1); } s = s + "@p_productImg='" + img +
		 * "';";
		 */
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

	public static String saveProductDtls(ProductDetailsModel product) {

		String s = "";
		
		if(product.getProductId()!=null && product.getProductId()!="") {
			s = s + "@p_productDtlsId='" + product.getProductId() + "',";
		}
		//if(product.getSku()!=null && product.getSku()!="") {
			s = s + "@p_skuId='" + product.getSku() + "',";
		//}
		if(product.getModel()!=null && product.getModel()!="") {
			s = s + "@p_model='" + product.getModel() + "',";
		}
		else {
			s = s + "@p_model='',";
		}
		if(product.getManufacture()!=null && product.getManufacture()!="") {
			s = s + "@p_manufactureItem='" + product.getManufacture() + "',";
		}
		else {
			s = s + "@p_manufactureItem='',";
		}
		if(product.getVariationType()!=null && product.getVariationType()!="") {
			s = s + "@p_variationType='" + product.getVariationType() + "',";
		}
		else {
			s = s + "@p_variationType='',";
		}
		if(product.getVariationValue()!=null && product.getVariationValue()!="") {
			s = s + "@p_variationValue='" + product.getVariationValue() + "',";
		}
		else {
			s = s + "@p_variationValue='',";
		}
		if(product.getUnit()!=null && product.getUnit()!="") {
			s = s + "@p_unit='" + product.getUnit() + "',";
		}
		else {
			s = s + "@p_unit='',";
		}
		if(product.getCreatedBy()!=null && product.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + product.getCreatedBy() + "',";
		}
		else {
			s = s + "@p_createdBy='',";
		}
		if(product.getBrand()!=null && product.getBrand()!="") {
			s = s + "@p_brand='" + product.getBrand() + "',";
		}
		else {
			s = s + "@p_brand='',";
		}
		if(product.getSalePrice()!=null) {
			s = s + "@p_salePrice=" + product.getSalePrice() + ",";
		}
		else {
			s = s + "@p_salePrice= 0.00,";
		}
		/*
		 * if(product.getSaleTax()!=null) { s = s + "@p_saleTax=" + product.getSaleTax()
		 * + ","; } else { s = s + "@p_saleTax='',"; }
		 */
		/*
		 * if(product.getSaleCess()!=null) { s = s + "@p_saleCess=" +
		 * product.getSaleCess() + ","; } else { s = s + "@p_saleCess='',"; }
		 */
		
		if(product.getOrganizationName()!=null && product.getOrganizationName()!="") {
			s = s + "@p_orgName='" + product.getOrganizationName() + "',";
		}
		else {
			s = s + "@p_orgName='',";
		}
		if(product.getOrganizationDivision()!=null && product.getOrganizationDivision()!="") {
			s = s + "@p_orgDiv='" + product.getOrganizationDivision() + "',";
		}else {
			s = s + "@p_orgDiv='',";
		}
		if(product.gettMode()!=null && product.gettMode()!="") {
			s = s + "@p_tMode='" + product.gettMode() + "',";
		}else {
			s = s + "@p_tMode='',";
		}
		if(product.getFors()!=null && product.getFors()!="") {
			s = s + "@p_fors='" + product.getFors() + "',";
		}else {
			s = s + "@p_fors='',";
		}
		if(product.getTaxi()!=null && product.getTaxi()!="") {
			s = s + "@p_taxi='" + product.getTaxi() + "',";
		}else {
			s = s + "@p_taxi='',";
		}
		if(product.getDtime()!=null && product.getDtime()!="") {
			s = s + "@p_dtime='" + product.getDtime() + "',";
		}else {
			s = s + "@p_dtime='',";
		}
		if(product.getQtity()!=null && product.getQtity()!="") {
			s = s + "@p_qtity='" + product.getQtity() + "',";
		}else {
			s = s + "@p_qtity='',";
		}
		if(product.getDicount()!=null && product.getDicount()!="") {
			s = s + "@p_dicount='" + product.getDicount() + "',";
		}else {
			s = s + "@p_dicount='',";
		}
		
		/*
		 * if(product.getOrganizationName()!=null) { s = s + "@p_orgName=" +
		 * product.getOrganizationName() + ","; }
		 * if(product.getOrganizationDivision()!=null) { s = s + "@p_orgDiv=" +
		 * product.getOrganizationDivision() + ","; }
		 */
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}
	
	public static String saveProductPurchaseDtls(ProductDetailsModel product) {
		
		String s = "";
		
		if(product.getProductId()!=null && product.getProductId()!="") {
			s = s + "@p_productPurchaseId='" + product.getProductId() + "',";
		}
		if(product.getSku()!=null && product.getSku()!="") {
			s = s + "@p_skuPrId='" + product.getSku() + "',";
		}
		if(product.getVendorId()!=null && product.getVendorId()!="") {
			s = s + "@p_vendorId='" + product.getVendorId() + "',";
		}
		if(product.getCreatedBy()!=null && product.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + product.getCreatedBy() + "',";
		}
		if(product.getSalePrice()!=null) {
			s = s + "@p_purchasePrice=" + product.getSalePrice() + ",";
		}
		if(product.getSaleTax()!=null) {
			s = s + "@p_purchaseTax=" + product.getSaleTax() + ",";
		}
		if(product.getSaleCess()!=null) {
			s = s + "@p_purchaseCess=" + product.getSaleCess() + ",";
		}
		if(product.getMoq()!=null) {
			s = s + "@p_moq=" + product.getMoq() + ",";
		}
		
	
		if(product.getEditSKUId()!=null && product.getEditSKUId()!="") {
			s = s + "@p_editSkuId='" + product.getEditSKUId() + "',";
		}
		if(product.getEditVendorId()!=null && product.getEditVendorId()!="") {
			s = s + "@p_editVendorId='" + product.getEditVendorId() + "',";
		}
		if(product.getOrganizationName()!=null && product.getOrganizationName()!="") {
			s = s + "@p_orgName='" + product.getOrganizationName() + "',";
		}
		if(product.getOrganizationDivision()!=null && product.getOrganizationDivision()!="") {
			s = s + "@p_orgDiv='" + product.getOrganizationDivision() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		
		System.out.println(s);
		
		return s;
	}

}
