package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;

public class GenerateCanteenMenuParameter {

	

    public static String addcanteenmenuParam(RestMenuModel canteenmenu) {

      String s = "";
      
   if (canteenmenu.getItemId() != null || canteenmenu.getItemId() != "") {
      s = s + "@p_itemid='" + canteenmenu.getItemId() + "',";
      }
    if (canteenmenu.getItemName() != null || canteenmenu.getItemName() != "") {
   s = s + "@p_itemname='" + canteenmenu.getItemName() + "',";
   }
  if (canteenmenu.getPrice() != null || canteenmenu.getPrice() != "") {
   s = s + "@p_price='" + canteenmenu.getPrice() + "',";
 }
  if (canteenmenu.getCategry() != null || canteenmenu.getCategry() != "") {
	   s = s + "@p_categry='" + canteenmenu.getCategry() + "',";
	 }
  if (canteenmenu.getSubcategry() != null || canteenmenu.getSubcategry() != "") {
	   s = s + "@p_subcategry='" + canteenmenu.getSubcategry() + "',";
	 }
  if (canteenmenu.getVariant() != null || canteenmenu.getVariant() != "") {
	   s = s + "@p_variant='" + canteenmenu.getVariant() + "',";
	 }
  if (canteenmenu.getStatus() != null || canteenmenu.getStatus() != "") {
	   s = s + "@p_status='" + canteenmenu.getStatus() + "',";
	 }
  
  if (canteenmenu.getOrganization() != null || canteenmenu.getOrganization() != "") {
	   s = s + "@p_org='" + canteenmenu.getOrganization() + "',";
	 }
  
  if (canteenmenu.getOrgDivision() != null || canteenmenu.getOrgDivision() != "") {
	   s = s + "@p_orgDiv='" + canteenmenu.getOrgDivision() + "',";
	 }



                  if (s != "") { 
                    s = s.substring(0, s.length() - 1);

                        s = "SET " + s + ";";
                    }
             System.out.println("s--------------------------" + s);
              return s;

 }


   
	
}
