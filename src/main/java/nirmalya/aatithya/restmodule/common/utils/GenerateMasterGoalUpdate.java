package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestGoalUpdateModel;
import nirmalya.aatithya.restmodule.master.model.RestOneToOneModel;

public class GenerateMasterGoalUpdate {

	public static String addGoalUpdate(List<RestGoalUpdateModel> restGoalUpdate) {
		String s = "";
		String listdata ="";
		String goalId ="";
		
   	
		if (restGoalUpdate.get(0).getRecommendation() != null || restGoalUpdate.get(0).getRecommendation() != "") {
			s = s + "@p_getRecommandation=\"" + restGoalUpdate.get(0).getRecommendation() + "\",";
		}     
		if (restGoalUpdate.get(0).getFinalRating() != null || restGoalUpdate.get(0).getFinalRating() != "") {
			s = s + "@p_getRating=\"" + restGoalUpdate.get(0).getFinalRating() + "\",";
		}
		if (restGoalUpdate.get(0).getPromotion() != null || restGoalUpdate.get(0).getPromotion() != "") {
			s = s + "@p_getPromotion=\"" + restGoalUpdate.get(0).getPromotion() + "\",";
		}
		if (restGoalUpdate.get(0).getDesignationTitle() != null || restGoalUpdate.get(0).getDesignationTitle() != "") {
			s = s + "@p_getDesignationTitle=\"" + restGoalUpdate.get(0).getDesignationTitle() + "\",";
		}
		if (restGoalUpdate.get(0).getRatings() != null || restGoalUpdate.get(0).getRatings() != "") {
			s = s + "@p_getRatings=\"" + restGoalUpdate.get(0).getRatings() + "\",";
		}
		  for (RestGoalUpdateModel m : restGoalUpdate) { 
		  goalId=m.getGoalId();
		  }
		  for(RestGoalUpdateModel m: restGoalUpdate) { 
		  listdata = listdata+""+m.getGoalId()+ ",";
		  System.out.println(listdata); 
		  }
		 
		  System.out.println(s); 
		listdata = listdata.substring(0, listdata.length() - 1);
		
		s = "SET " + s +"@p_SQL=\"("+listdata+")\";";
		System.out.println(s); 
		return s;
	}

}
