package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import nirmalya.aatithya.restmodule.projects.model.ManageProjectMasterModel;
import nirmalya.aatithya.restmodule.projects.model.NonResourcePlanModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectsTeamPlanModel;

public class GenerateProjectsParameter {

	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static Calendar cal = Calendar.getInstance();
	
	public static String addProjectsDetails(ManageProjectMasterModel form) {
		String s = "";
		//String qItem = "";
		String addReq = "";
		
		if(form.getProjectId() == null || form.getProjectId() == "") {

				addReq = addReq + "(@p_projectId,\"" + form.getProjectName() + "\",\"" + form.getProjectType() + "\",\"" + form.getPriority() + "\",\"" + 
						form.getProjectDesc() + "\",\"" + form.getDept() + "\",\"" + form.getProjectOwner() + "\",\"" +
						form.getStartDate() + "\",\"" + form.getEndDate() + "\"," + form.getBudgetHour() + "," + form.getBudgetResourceSpend() + "," +
						form.getBudgetNonResourceSpend()+ ",\"" + dateFormat.format(cal.getTime()) + "\",\"" + form.getCreatedBy()+ "\",\"" + form.getCreatedBy() +"\"),";
				addReq = addReq.substring(0, addReq.length() - 1);
			
			
			s = s + "@p_activityBy='" + form.getCreatedBy() + "',";
			
		} else {

				addReq = addReq + "(\"" + form.getProjectId() + "\",\"" + form.getProjectName() + "\",\"" + form.getProjectType() + "\",\"" + form.getPriority() + "\",\"" + 
						form.getProjectDesc() + "\",\"" + form.getDept() + "\",\"" + form.getProjectOwner() + "\",\"" +
						form.getStartDate() + "\",\"" + form.getEndDate() + "\"," + form.getBudgetHour() + "," + form.getBudgetResourceSpend() + "," +
						form.getBudgetNonResourceSpend()+ ",@p_createdBy,@p_createdOn,\"" + form.getCreatedBy() +"\"),";
				addReq = addReq.substring(0, addReq.length() - 1);
			
			s = s + "@p_projectId='" + form.getProjectId() + "',";
			s = s + "@p_activityBy='" + form.getCreatedBy() + "',";
		}
		
		//s = s + "@p_benefitsData='" + qItem + "',";
		s = s + "@p_addProjects='" + addReq + "',";
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
	
public static String addTeamPlan(ProjectsTeamPlanModel form) {
		
		String s = "";
		String addReq = "";

		if(form.getTeamPlanId() == null || form.getTeamPlanId() == "") {
			
			addReq = addReq + "(@p_teamPlanId,\"" + form.getProjectId() + "\",\"" + form.getEmployeeId() + "\"," + form.getHourlyCost() + "," + form.getBillingRate() + "," + 
					form.getTotalHour() + ",\"" + form.getLocation() + "\",\"" + form.getChartOfAccount() + "\",\"" + form.getCostCenter()
					+ "\",\"" + dateFormat.format(cal.getTime()) + "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy() +"\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		} else {
			
			addReq = addReq + "(\""+ form.getTeamPlanId() + "\",\"" + form.getProjectId() + "\",\"" + form.getEmployeeId() + "\"," + form.getHourlyCost() + "," + form.getBillingRate() + "," + 
					form.getTotalHour() + ",\"" + form.getLocation() + "\",\"" + form.getChartOfAccount() + "\",\"" + form.getCostCenter() + "\",@p_createdBy,@p_createdOn,\"" + form.getCreatedBy() +"\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		}
		
		s = s + "@p_addTeamPlan='" + addReq + "',";
		s = s + "@p_teamPlanId='" + form.getTeamPlanId() + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
		
	}

public static String addNonResource(NonResourcePlanModel form) {
	
	String s = "";
	String addReq = "";

	if(form.getNonResourceId() == null || form.getNonResourceId() == "") {
		
		addReq = addReq + "(@p_nonResourceId,\"" + form.getProjectId() + "\",\"" + form.getProductId() + "\"," + 
				form.getUnitCost() + "," + form.getNoOfUnits() + "," + form.getTotalAmount() + ",\"" + form.getLocationNonResource() + "\",\"" + form.getNonResourceCostCenter()
				+ "\",\"" + dateFormat.format(cal.getTime()) + "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy() +"\"),";
		addReq = addReq.substring(0, addReq.length() - 1);
	} else {
		
		addReq = addReq + "(\""+ form.getNonResourceId() + "\",\"" + form.getProjectId() + "\",\"" + form.getProductId() + "\"," + 
				form.getUnitCost() + "," + form.getNoOfUnits() + "," + form.getTotalAmount() + ",\"" + form.getLocationNonResource() + "\",\"" + form.getNonResourceCostCenter() + "\",@p_createdBy,@p_createdOn,\"" + form.getCreatedBy() +"\"),";
		addReq = addReq.substring(0, addReq.length() - 1);
	}
	
	s = s + "@p_addNonResourcePlan='" + addReq + "',";
	s = s + "@p_nonResourceId='" + form.getNonResourceId() + "',";
	
	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}

	return s;
	
}
	
}
