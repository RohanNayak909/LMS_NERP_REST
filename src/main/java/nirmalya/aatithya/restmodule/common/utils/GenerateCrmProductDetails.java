package nirmalya.aatithya.restmodule.common.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.pipeline.model.RestCrmProductModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;

public class GenerateCrmProductDetails {

public static String generateCrmProductParam(RestCrmProductModel crmModel) {
		
		String s="";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		if(crmModel.getProductId()!=null && crmModel.getProductId()!="")
		{
			s = s + "@p_productId='" + crmModel.getProductId()+ "',";
		}
		if(crmModel.getProductOwner()!=null && crmModel.getProductOwner()!="")
		{
			s = s + "@p_productOwner='" + crmModel.getProductOwner()+ "',";
		}
		
		if(crmModel.getProductName()!=null && crmModel.getProductName()!="")
		{
			s = s + "@p_productName='" + crmModel.getProductName()+ "',";
		}
		if(crmModel.getProductCode()!=null && crmModel.getProductCode()!="")
		{
			s = s + "@p_productCode ='" + crmModel.getProductCode()+ "',";
		}
		if(crmModel.getProductVendor()!=null && crmModel.getProductVendor()!="")
		{
			s = s + "@p_productVendor='" + crmModel.getProductVendor()+ "',";
		}
		
		if(crmModel.getProductActive()!=null && crmModel.getProductActive()!="")
		{
			s = s + "@p_productActive='" + crmModel.getProductActive()+ "',";
		}
		if(crmModel.getProductManufacturer()!=null && crmModel.getProductManufacturer()!="")
		{
			s = s + "@p_productManufacturer='" + crmModel.getProductManufacturer()+ "',";
		}
		if(crmModel.getProductCategory()!=null && crmModel.getProductCategory()!="")
		{
			s = s + "@p_productCategory='" + crmModel.getProductCategory()+ "',";
		}
		if(crmModel.getSalesStartDate()!=null && crmModel.getSalesStartDate()!="")
		{
			s = s + "@p_salesStartDate='" + crmModel.getSalesStartDate()+ "',";
		}
		if(crmModel.getSalesEndDate()!=null && crmModel.getSalesEndDate()!="")
		{
			s = s + "@p_salesEndDate='" + crmModel.getSalesEndDate()+ "',";
		}
		if(crmModel.getSupportStartDate()!=null && crmModel.getSupportStartDate()!="")
		{
			s = s + "@p_supportStartDate='" + crmModel.getSupportStartDate()+ "',";
		}
		if(crmModel.getSupportEndDate()!=null && crmModel.getSupportEndDate()!="")
		{
			s = s + "@p_supportEndDate='" + crmModel.getSupportEndDate()+ "',";
		}
		if(crmModel.getUnitPrice()!=null && crmModel.getUnitPrice()!="")
		{
			s = s + "@p_unitPrice='" + crmModel.getUnitPrice()+ "',";
		}
		if(crmModel.getCommissionRate()!=null && crmModel.getCommissionRate()!="")
		{
			s = s + "@p_commissionRate='" + crmModel.getCommissionRate()+ "',";
		}
		if(crmModel.getTax()!=null && crmModel.getTax()!="")
		{
			s = s + "@p_tax='" + crmModel.getTax()+ "',";
		}
		
		if(crmModel.getTaxable()!=null && crmModel.getTaxable()!="")
		{
			s = s + "@p_taxable='" + crmModel.getTaxable()+ "',";
		}
		
		if(crmModel.getUsageUnit()!=null && crmModel.getUsageUnit()!="")
		{
			s = s + "@p_usaseUnit='" + crmModel.getUsageUnit()+ "',";
		}
		
		if(crmModel.getQtyOrdered()!=null && crmModel.getQtyOrdered()!="")
		{
			s = s + "@p_qtyOrdered='" + crmModel.getQtyOrdered()+ "',";
		}
		
		if(crmModel.getQtyInStock()!=null && crmModel.getQtyInStock()!="")
		{
			s = s + "@p_qtyInStock='" + crmModel.getQtyInStock()+ "',";
		}
		
		if(crmModel.getReorderLevel()!=null && crmModel.getReorderLevel()!="")
		{
			s = s + "@p_reorderLevel='" + crmModel.getReorderLevel()+ "',";
		}
		
		if(crmModel.getHandler()!=null && crmModel.getHandler()!="")
		{
			s = s + "@p_handler='" + crmModel.getHandler()+ "',";
		}
		
		if(crmModel.getQtyInDemand()!=null && crmModel.getQtyInDemand()!="")
		{
			s = s + "@p_qtyIndemand='" + crmModel.getQtyInDemand()+ "',";
		}
		
				
		if(crmModel.getDescription()!=null && crmModel.getDescription()!="")
		{
			s = s + "@p_desc='" + crmModel.getDescription()+ "',";
		}
		
		if(crmModel.getImageName()!=null && crmModel.getImageName()!="")
		{
			s = s + "@p_image='" + crmModel.getImageName()+ "',";
		}
		
		if(crmModel.getCreatedBy()!=null && crmModel.getCreatedBy()!="")
		{
			s = s + "@p_createdBy='" + crmModel.getCreatedBy()+ "',";
		}
		
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		return s;
	}
	
	
}
