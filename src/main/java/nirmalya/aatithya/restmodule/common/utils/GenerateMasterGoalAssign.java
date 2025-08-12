package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestGoalAssignModel;


public class GenerateMasterGoalAssign {

	public static String generateGoalAssign(List<RestGoalAssignModel> restaddGoalAssign) {
		String s = "";
		String listdata ="";
		String goalIdAuto ="";
		String goalAssignid = "";
		String name = "";
		String designation = "";
		String createdBy = "";
		String gid = "";
		
		for (RestGoalAssignModel m : restaddGoalAssign) {
			goalIdAuto=m.getGoalIdAuto();
			goalAssignid=m.getGoalAssignid();
			name=m.getName();
			designation=m.getDesignation();
			createdBy=m.getCreatedBy();
			
		}
		for(RestGoalAssignModel m: restaddGoalAssign) {
			listdata = listdata+"(\""+m.getGoalAssignid()
			+ "\",\""+m.getName()
			+ "\",\""+m.getDesignation()
			+ "\",\""+m.getCreatedBy()
			+ "\"),";
			gid=m.getGoalAssignid();
			
		}
		listdata = listdata.substring(0, listdata.length() - 1);
		//gid = gid.substring(0, gid.length() - 1);
		
		s = "SET " + s +"@p_SQL='"+listdata+"',"+"@p_gId='"+gid+"';";
		System.out.println("Generation Parama: "+s);	
		return s;

	}
	

}
