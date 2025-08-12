package nirmalya.aatithya.restmodule.common.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.inventory.model.RestShoukeenDealerModel;

public class GenerateShoukeenDealerDetails {

	public static String generateDealerParam(RestShoukeenDealerModel restShoukeenDealerModel) {
		
		String s="";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		if(restShoukeenDealerModel.getDealerId() !=null && restShoukeenDealerModel.getDealerId()!="")
		{
			s = s + "@p_dealerId='" + restShoukeenDealerModel.getDealerId()+ "',";
		}
		if(restShoukeenDealerModel.getDealerName()!=null && restShoukeenDealerModel.getDealerName()!="")
		{
			s = s + "@p_dealerName='" + restShoukeenDealerModel.getDealerName()+ "',";
		}
		
		if(restShoukeenDealerModel.getDealerEmail()!=null && restShoukeenDealerModel.getDealerEmail()!="")
		{
			s = s + "@p_dealerEmail='" + restShoukeenDealerModel.getDealerEmail()+ "',";
		}
		if(restShoukeenDealerModel.getDealerMobile()!=null && restShoukeenDealerModel.getDealerMobile()!="")
		{
			s = s + "@p_dealerMobile='" + restShoukeenDealerModel.getDealerMobile()+ "',";
		}
		if(restShoukeenDealerModel.getDealerPassword()!=null && restShoukeenDealerModel.getDealerPassword()!="")
		{
			s = s + "@p_dealerPassword='" + restShoukeenDealerModel.getDealerPassword()+ "',";
		}
		
		if(restShoukeenDealerModel.getLegalName()!=null && restShoukeenDealerModel.getLegalName()!="")
		{
			s = s + "@p_legalName='" + restShoukeenDealerModel.getLegalName()+ "',";
		}
		if(restShoukeenDealerModel.getStoreName()!=null && restShoukeenDealerModel.getStoreName()!="")
		{
			s = s + "@p_storeName='" + restShoukeenDealerModel.getStoreName()+ "',";
		}
		if(restShoukeenDealerModel.getProductCategory()!=null && restShoukeenDealerModel.getProductCategory()!="")
		{
			s = s + "@p_productCategory='" + restShoukeenDealerModel.getProductCategory()+ "',";
		}
		if(restShoukeenDealerModel.getCountry()!=null && restShoukeenDealerModel.getCountry()!="")
		{
			s = s + "@p_country='" + restShoukeenDealerModel.getCountry()+ "',";
		}
		if(restShoukeenDealerModel.getStates()!=null && restShoukeenDealerModel.getStates()!="")
		{
			s = s + "@p_state='" + restShoukeenDealerModel.getStates()+ "',";
		}
		if(restShoukeenDealerModel.getCity()!=null && restShoukeenDealerModel.getCity()!="")
		{
			s = s + "@p_cityName='" + restShoukeenDealerModel.getCity()+ "',";
		}
		if(restShoukeenDealerModel.getAddress1()!=null && restShoukeenDealerModel.getAddress1()!="")
		{
			s = s + "@p_address1='" + restShoukeenDealerModel.getAddress1()+ "',";
		}
		if(restShoukeenDealerModel.getAddress2()!=null && restShoukeenDealerModel.getAddress2()!="")
		{
			s = s + "@p_address2='" + restShoukeenDealerModel.getAddress2()+ "',";
		}
		
		if(restShoukeenDealerModel.getPinCode()!=null && restShoukeenDealerModel.getPinCode()!="")
		{
			s = s + "@p_pinCode='" + restShoukeenDealerModel.getPinCode()+ "',";
		}
		
		if(restShoukeenDealerModel.getIsTaxable()!=null && restShoukeenDealerModel.getIsTaxable()!="")
		{
			s = s + "@p_isTaxable='" + restShoukeenDealerModel.getIsTaxable()+ "',";
		}
		
		
		if(restShoukeenDealerModel.getTaxStateGst()!=null && restShoukeenDealerModel.getTaxStateGst()!="")
		{
			s = s + "@p_taxStateGst='" + restShoukeenDealerModel.getTaxStateGst()+ "',";
		}
		
		if(restShoukeenDealerModel.getProvisionalGSTINNo()!=null && restShoukeenDealerModel.getProvisionalGSTINNo()!="")
		{
			s = s + "@p_provisionalGstINNo='" + restShoukeenDealerModel.getProvisionalGSTINNo()+ "',";
		}
		
		
		if(restShoukeenDealerModel.getPanNumber()!=null && restShoukeenDealerModel.getPanNumber()!="")
		{
			s = s + "@p_panNo='" + restShoukeenDealerModel.getPanNumber()+ "',";
		}
		
		if(restShoukeenDealerModel.getBuyProductFrom()!=null && restShoukeenDealerModel.getBuyProductFrom()!="")
		{
			s = s + "@p_buyProductFrom='" + restShoukeenDealerModel.getBuyProductFrom()+ "',";
		}
		
		if(restShoukeenDealerModel.getAnnualTurnOver()!=null && restShoukeenDealerModel.getAnnualTurnOver()!="")
		{
			s = s + "@p_annualTurnOver='" + restShoukeenDealerModel.getAnnualTurnOver()+ "',";
		}
		
		if(restShoukeenDealerModel.getAnnualSell()!=null && restShoukeenDealerModel.getAnnualSell()!="")
		{
			s = s + "@p_annualSell='" + restShoukeenDealerModel.getAnnualSell()+ "',";
		}
		
		if(restShoukeenDealerModel.getSellOnOtherWebsiteYesOrNo()!=null && restShoukeenDealerModel.getSellOnOtherWebsiteYesOrNo()!="")
		{
			s = s + "@p_sellOnOtherWebsiteYesOrNo='" + restShoukeenDealerModel.getSellOnOtherWebsiteYesOrNo()+ "',";
		}
		
		if(restShoukeenDealerModel.getOtherWebsiteName()!=null && restShoukeenDealerModel.getOtherWebsiteName()!="")
		{
			s = s + "@p_otherWebsiteName='" + restShoukeenDealerModel.getOtherWebsiteName()+ "',";
		}
		
		if(restShoukeenDealerModel.getProductCategoryWishToSell()!=null && restShoukeenDealerModel.getProductCategoryWishToSell()!="")
		{
			s = s + "@p_productCategoryWishToSell='" + restShoukeenDealerModel.getProductCategoryWishToSell()+ "',";
		}
		
		if(restShoukeenDealerModel.getDescription()!=null && restShoukeenDealerModel.getDescription()!="")
		{
			s = s + "@p_description='" + restShoukeenDealerModel.getDescription()+ "',";
		}
		
		if(restShoukeenDealerModel.getIsAgreeWithTermCondition()!=null && restShoukeenDealerModel.getIsAgreeWithTermCondition()!="")
		{
			s = s + "@p_isAgreeWithTermCondition='" + restShoukeenDealerModel.getIsAgreeWithTermCondition()+ "',";
		}
		
		
		if(restShoukeenDealerModel.getImageName()!=null && restShoukeenDealerModel.getImageName()!="")
		{
			s = s + "@p_image='" + restShoukeenDealerModel.getImageName()+ "',";
		}
		
		if(restShoukeenDealerModel.getCreatedBy()!=null && restShoukeenDealerModel.getCreatedBy()!="")
		{
			s = s + "@p_createdBy='" + restShoukeenDealerModel.getCreatedBy()+ "',";
		}
		
		
		
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		return s;
	}
	
	
}
