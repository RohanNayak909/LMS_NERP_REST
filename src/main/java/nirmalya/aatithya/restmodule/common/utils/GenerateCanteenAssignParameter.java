package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.canteen.model.RestAssignComboModel;
import nirmalya.aatithya.restmodule.canteen.model.RestAssignItemdata;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;

public class GenerateCanteenAssignParameter {
			    
			public static String addCanteenAssignParameter(RestAssignComboModel restAssignComboModel) 
			
					{
				
					 String s = "";
				    
				   
				    if (restAssignComboModel.getId() != null && !restAssignComboModel.getId().isEmpty()) {
				        s = s + "@p_id='" + restAssignComboModel.getId() + "',";
				    }
				    if (restAssignComboModel.getItemId() != null && !restAssignComboModel.getItemId().isEmpty()) {
				    	s = s + "@p_itemId='" + restAssignComboModel.getItemId() + "',";
				    }
				    
				    if (restAssignComboModel.getName() != null && !restAssignComboModel.getName().isEmpty()) {
				        s = s + "@p_name='" + restAssignComboModel.getName() + "',";
				    }
				    
				    if (restAssignComboModel.getPrice() != null || restAssignComboModel.getPrice() != "") {
				    	   s = s + "@p_price='" + restAssignComboModel.getPrice() + "',";
				       }				       
				  
			        if (restAssignComboModel.getOrganization() != null || restAssignComboModel.getOrganization() != "") {
			     	   s = s + "@p_org='" + restAssignComboModel.getOrganization() + "',";
			     	 }
			       
			       if (restAssignComboModel.getOrgDivision() != null || restAssignComboModel.getOrgDivision() != "") {
			     	   s = s + "@p_orgDiv='" + restAssignComboModel.getOrgDivision() + "',";
			     	 }
			      
			       if (DateFormatter.getStringDate(restAssignComboModel.getReceiveDate()) != null && DateFormatter.getStringDate(restAssignComboModel.getReceiveDate()) != "") {
						s = s + "@p_receiveDate='" + DateFormatter.getStringDate(restAssignComboModel.getReceiveDate()) + "',";
					}
			       if (s != "") { 
	                    s = s.substring(0, s.length() - 1);

	                        s = "SET " + s + ";";
	                    }
	             System.out.println("s--------------------------" + s);
	              return s;
					}
}
	