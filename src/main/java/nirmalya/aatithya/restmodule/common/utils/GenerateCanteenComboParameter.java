package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.account.model.RestManualJournalModel;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;


public class GenerateCanteenComboParameter {
    
    public static String addcanteenComboParam(RestMenuModel canteenmenu) {
    	
        String s = "";
        String litem = "";
        
        System.out.println("Hello" + s);
        System.out.println("Hello" + litem);
        
        if (canteenmenu.getComboId() != null && !canteenmenu.getComboId().isEmpty()) {
            s = s + "@combo_id='" + canteenmenu.getComboId() + "',";
        }
        
        if (canteenmenu.getComboName() != null && !canteenmenu.getComboName().isEmpty()) {
            s = s + "@p_comboName='" + canteenmenu.getComboName() + "',";
        }
        	
        if (canteenmenu.getAllPrice() != null && !canteenmenu.getAllPrice().isEmpty()) {
            s = s + "@p_allprice='" + canteenmenu.getAllPrice() + "',";
        }
        
        
        if (canteenmenu.getOrganization() != null || canteenmenu.getOrganization() != "") {
     	   s = s + "@p_org='" + canteenmenu.getOrganization() + "',";
     	 }
       
       if (canteenmenu.getOrgDivision() != null || canteenmenu.getOrgDivision() != "") {
     	   s = s + "@p_orgDiv='" + canteenmenu.getOrgDivision() + "',";
     	 }

        
        if (canteenmenu.getItemList() != null && !canteenmenu.getItemList().isEmpty()) {
           
            for (RestMenuModel item : canteenmenu.getItemList()) {
                if (item.getItemId() != null && item.getItemName() != null && item.getPrice() != null  ) {
                    litem = litem + "(@combo_id,\"" + item.getItemId() + "\",\"" + item.getItemName() + "\",\"" + item.getPrice() + "\",\"" + canteenmenu.getOrganization() + "\",\"" + canteenmenu.getOrgDivision() + "\"),";
                }
            }
        }
        
        
        
        
		
        System.out.print("<<<<<<<<Bulet"+s); 
        System.out.print("<<<<<<<<"+litem);
       	
        
		  litem = litem.substring(0, litem.length() - 1);
		  
		  s = s + "@p_itemId='" + litem + "',";
		
        
        if (s != "") {
            s = s.substring(0, s.length() - 1);
            
            s = "SET " + s + ";";
        }
        
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + s);
        return s;
    }
}
