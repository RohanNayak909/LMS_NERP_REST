package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestGoalUpdateModel;
import nirmalya.aatithya.restmodule.master.model.RestOneToOneModel;

public class GenerateMasterGoalOnetoOne {

	public static String addGoalOneToOne(List<RestOneToOneModel> restGoalOneToOne) {
		String s = "";
		String listdata ="";
		String goalId ="";
		
/*		if (restGoalOneToOne.get(0).getSummary() != null || restGoalOneToOne.get(0).getSummary() != "") {
			s = s + "@p_getSummary=\"" + restGoalOneToOne.get(0).getSummary() + "\",";
		}
		if (restGoalOneToOne.get(0).getRecommendation() != null || restGoalOneToOne.get(0).getRecommendation() != "") {
			s = s + "@p_getRecommandation=\"" + restGoalOneToOne.get(0).getRecommendation() + "\",";
		}     */
		if (restGoalOneToOne.get(0).getRating() != null || restGoalOneToOne.get(0).getRating() != "") {
			s = s + "@p_getRating=\"" + restGoalOneToOne.get(0).getRating() + "\",";
		}
		
		  for (RestOneToOneModel m : restGoalOneToOne) { 
		  goalId=m.getGoalId();
		  }
		  for(RestOneToOneModel m: restGoalOneToOne) { 
		  listdata = listdata+""+m.getGoalId()+ ",";
		  System.out.println(listdata); 
		  }
		 
		  System.out.println(s); 
		listdata = listdata.substring(0, listdata.length() - 1);
		
		s = "SET " + s +"@p_SQL=\"("+listdata+")\";";
		
		return s;
	}

}
