package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestPlanningSchedulesubModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;

public class GenerateParameterSavePlannSchedule {
	public static String getAddParam(RestPlanningSchedulesubModel bmoModel) {

		String s = "";

		/*
		 * s = s + "@p_planschid='" + bmoModel.getPlanschid() + "',";
		 * 
		 * s = s + "@createdby='" + bmoModel.getCreatedBy() + "',";
		 * 
		 * s = s + "@org='" + bmoModel.getOrganizationName() + "',";
		 * 
		 * s = s + "@orgdiv='" + bmoModel.getOrganizationDivision() + "',";
		 */

		String itemparam = "";
		List<ProjectPlanningSchedulingRestModel> items = bmoModel.getTaskmodel();
		if (bmoModel.getTaskmodel().size() > 0) {
			for (ProjectPlanningSchedulingRestModel m : items) {

				itemparam = itemparam + "(@p_serialId,@p_planschid,@p_plancategoryId,\"" + "L1" + "\",\""
						+ m.getProjectId() + "\",@CNT,@p_plancategoryId,\"" + m.getPriority() + "\",\""
						+ m.getStartDate() + "\",\"" + m.getEndDate() + "\",\"" + m.getAssignedTo() + "\",\""
						+ m.getDuration() + "\",\"" + m.getPredecessors() + "\",\"" + m.getNotes() + "\",\""
						+ m.getCategory() + "\",\"" +bmoModel.getCreatedBy() + "\",\"" +bmoModel.getOrganizationName() + "\",\""
						+ bmoModel.getOrganizationDivision() + "\"),";
				
			}

			itemparam = itemparam.substring(0, itemparam.length() - 1);
		} else {
			itemparam = "";
		}
		s = s + "@p_itemParam='" + itemparam + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	
	public static String modifyParentPlanning(List<ProjectPlanningSchedulingRestModel> category) {

		String s = "";
		if (category.get(0).getCategoryid() != null && category.get(0).getCategoryid() != "") {
			s = s + "@p_categoryId='" + category.get(0).getCategoryid() + "',";
		}else {
			s = s + "@p_categoryId=null,";
		}
		if (category.get(0).getcName() != null && category.get(0).getcName() != "") {
			s = s + "@p_categoryName='" + category.get(0).getcName() + "',";
		}else {
			s = s + "@p_categoryName=null,";
		}
		if (category.get(0).getPriority() != null && category.get(0).getPriority() != "") {
			s = s + "@p_priority='" + category.get(0).getPriority() + "',";
		}
		else {
			s = s + "@p_priority=null,";
		}
		if (DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate())!= null && DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) != "") {
			s = s + "@p_stdt='" + DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) + "',";
		}
		else {
			s = s + "@p_stdt=null,";
		}
		if (DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) != "") {
			s = s + "@p_nddt='" + DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) + "',";
		}else {
			s = s + "@p_nddt=null,";
		}
		if (category.get(0).getDuration() != null && category.get(0).getDuration() != "") {
			s = s + "@p_duration='" + category.get(0).getDuration() + "',";
		}else {
			s = s + "@p_duration=null,";
		}
		if (category.get(0).getPredecessors() != null && category.get(0).getPredecessors() != "") {
			s = s + "@p_predecessors='" + category.get(0).getPredecessors() + "',";
		}else {
			s = s + "@p_predecessors=null,";
		}

		if (category.get(0).getNotes() != null && category.get(0).getNotes() != "") {
			s = s + " @p_notes='" + category.get(0).getNotes() + "',";
		}else {
			s = s + "@p_notes=null,";
		}

		if (category.get(0).getOrganizationName() != null && category.get(0).getOrganizationName() != "") {
			s = s + "@p_orgname='" + category.get(0).getOrganizationName() + "',";
		}else {
			s = s + "@p_orgname=null,";
		}


		if (category.get(0).getOrganizationDivision() != null && category.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgdiv='" + category.get(0).getOrganizationDivision() + "',";
		}else {
			s = s + "@p_orgdiv=null,";
		}
		if (category.get(0).getProplanid() != null && category.get(0).getProplanid() != "") {
			s = s + "@p_planId='" + category.get(0).getProplanid() + "',";
		}else {
			s = s + "@p_planId=null,";
		}

		if (category.get(0).getProjectId() != null && category.get(0).getProjectId() != "") {
			s = s + "@p_projectId='" + category.get(0).getProjectId() + "',";
		}else {
			s = s + "@p_projectId=null,";
		}

		if (category.get(0).getPlaaningMainId() != null && category.get(0).getPlaaningMainId() != "") {
			s = s + "@p_planMainId='" + category.get(0).getPlaaningMainId() + "',";
		}else {
			s = s + "@p_planMainId=null,";
		}
		if (category.get(0).getProjectplanId() != null && category.get(0).getProjectplanId() != "") {
			s = s + "@p_projectEditId='" + category.get(0).getProjectplanId() + "',";
		}else {
			s = s + "@p_projectEditId=null,";
		}
		if (category.get(0).getAssignedTo() != null && category.get(0).getAssignedTo() != "") {
			s = s + "@p_assignTo='" + category.get(0).getAssignedTo() + "',";
		}else {
			s = s + "@p_assignTo=null,";
		}
		
		if (category.get(0).getProjectStatus() != null && category.get(0).getProjectStatus() != "") {
			s = s + "@p_projectStatus='" + category.get(0).getProjectStatus() + "',";
		}else {
			s = s + "@p_projectStatus=null,";
		}
		if (category.get(0).getPlanhours() != null && category.get(0).getPlanhours() != "") {
			s = s + "@p_plannedHrs='" + category.get(0).getPlanhours() + "',";
		}else {
			s = s + "@p_plannedHrs=null,";
		}
		
//		if (category.get(0).getAreaAcer() != null && category.get(0).getAreaAcer() != "") {
//			s = s + "@p_areaAcer='" + category.get(0).getAreaAcer() + "',";
//		}else {
//			s = s + "@p_areaAcer=null,";
//		}

	

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}
	public static String getChildParam(ProjectPlanningSchedulingRestModel itemModel) {

		String s = "";

		s = s + "@p_planid='" + itemModel.getProplanid() + "',";
		s = s + "@p_catid='" + itemModel.getCategoryid() + "',";

		if (itemModel.getPriority() != null && itemModel.getPriority() != "") {
			s = s + "@p_priority='" + itemModel.getPriority() + "',";
		}else {
			s = s + "@p_priority=null,";
		}
		if (itemModel.getStartDate() != null && itemModel.getStartDate() != "") {
			s = s + "@p_stdt='" + itemModel.getStartDate() + "',";
		}else {
			s = s + "@p_stdt=null,";
		}

		if (itemModel.getEndDate() != null && itemModel.getEndDate() != "") {
			s = s + "@p_nddt='" + itemModel.getEndDate() + "',";
		}else {
			s = s + "@p_nddt=null,";
		}
		if (itemModel.getAssignedTo() != null && itemModel.getAssignedTo() != "") {
			s = s + "@p_assign='" + itemModel.getAssignedTo() + "',";
		}else {
			s = s + "@p_assign=null,";
		}
		if (itemModel.getDuration() != null && itemModel.getDuration() != " ") {
			s = s + "@p_duration='" + itemModel.getDuration() + "',";
		}else {
			s = s + "@p_duration=null,";
		}
		if (itemModel.getPredecessors() != null && itemModel.getPredecessors() != "") {
			s = s + "@p_predecessors='" + itemModel.getPredecessors() + "',";
		}else {
			s = s + "@p_predecessors=null,";
		}
		if (itemModel.getNotes() != null && itemModel.getNotes() != " ") {
			s = s + "@p_notes='" + itemModel.getNotes() + "',";
		}else {
			s = s + "@p_notes=null,";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getAddParamParent(ProjectPlanningSchedulingRestModel itemModel) {

		String s = "";

		if (itemModel.getProjectId() != null && itemModel.getProjectId() != "") {
			s = s + "@p_projectId='" + itemModel.getProjectId() + "',";
		}else {
			s = s + "@p_projectId=null,";
		}
		if (itemModel.getProjectName() != null && itemModel.getProjectName() != "") {
			s = s + "@p_prjname='" + itemModel.getProjectName() + "',";
		}else {
			s = s + "@p_prjname=null,";
		}

		if (itemModel.getLocation() != null && itemModel.getLocation() != "") {
			s = s + "@p_loc='" + itemModel.getLocation() + "',";
		}else {
			s = s + "@p_loc=null,";
		}
		if (itemModel.getpIncharge() != null && itemModel.getpIncharge() != "") {
			s = s + "@p_prjIncharge='" + itemModel.getpIncharge() + "',";
		}else {
			s = s + "@p_prjIncharge=null,";
		}
		if (itemModel.getCategory() != null && itemModel.getCategory() != " ") {
			s = s + "@p_budcategory='" + itemModel.getCategory() + "',";
		}else {
			s = s + "@p_budcategory=null,";
		}
		if (itemModel.getPlanningName() != null && itemModel.getPlanningName() != "") {
			s = s + "@p_planningName='" + itemModel.getPlanningName() + "',";
		}else {
			s = s + "@p_planningName=null,";
		}

		if (itemModel.getProplanid() != null && itemModel.getProplanid() != "") {
			s = s + "@p_planid='" + itemModel.getProplanid() + "',";
		}else {
			s = s + "@p_planid=null,";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getsaveparentData(List<ProjectPlanningSchedulingRestModel> category) {

		String s = "";

		String proplanId = "";
		String categoryList = "";
		String executionList = "";
		String CreatedBy = "";
		String org = "";
		String div = "";


		for (ProjectPlanningSchedulingRestModel m : category) {

			if (category.get(0).getProplanid().equals("")) {
				categoryList = categoryList + "(@p_serialId,@p_planschid,\"" + m.getcName()
						+ "\",@p_plancategoryId,@p_plancategoryId,\"" + m.getProjectId() + "\",\"" + m.getPriority()
						+ "\",\"" + DateFormatter.getStringDateTimeWithoutTime(m.getStartDate()) + "\",\""
						+ DateFormatter.getStringDateTimeWithoutTime(m.getEndDate()) + "\",\"" + m.getAssignedTo()
						+ "\",\"" + m.getDuration() + "\",\"" + m.getPredecessors() + "\",\"" + m.getNotes() + "\",\""
						+ m.getCreatedBy() + "\",\"" + m.getOrganizationName() + "\",\"" + m.getOrganizationDivision()
						+ "\",@CNT,\"" + "L1" + "\",\"" + m.getProjectName() + "\",\"" + m.getLocation() + "\",\""
						+ m.getpIncharge() + "\", \"" + m.getCategory() + "\",\"" + m.getPlanningName() + "\",\""
						+ m.getProjectStatus() + "\",\"" + m.getPlanhours() + "\",\"" + m.getEstimatedPrice() + "\"),";

			} else {

				if (m.getProplanid() != null && m.getProplanid() != "") {
					s = s + "@p_planschid='" + m.getProplanid() + "',";
				}

				categoryList = categoryList + "(@p_serialId,\"" + m.getProplanid() + "\",\"" + m.getcName()
						+ "\",@p_plancategoryId,@p_plancategoryId,\"" + m.getProjectId() + "\",\"" + m.getPriority()
						+ "\",\"" + DateFormatter.getStringDateTimeWithoutTime(m.getStartDate()) + "\",\""
						+ DateFormatter.getStringDateTimeWithoutTime(m.getEndDate()) + "\",\"" + m.getAssignedTo()
						+ "\",\"" + m.getDuration() + "\",\"" + m.getPredecessors() + "\",\"" + m.getNotes() + "\",\""
						+ m.getCreatedBy() + "\",\"" + m.getOrganizationName() + "\",\"" + m.getOrganizationDivision()
						+ "\",@CNT,\"" + "L1" + "\",\"" + m.getProjectName() + "\",\"" + m.getLocation() + "\",\""
						+ m.getpIncharge() + "\", \"" + m.getCategory() + "\",\"" + m.getPlanningName() + "\",\""
						+ m.getProjectStatus() + "\",\"" + m.getPlanhours() + "\",\"" + m.getEstimatedPrice() + "\"),";

			}

		}

		categoryList = categoryList.substring(0, categoryList.length() - 1);
		//executionList = executionList.substring(0, executionList.length() - 1);

		s = s + "@p_litemSubQuery='" + categoryList + "',";
		//s = s + "@p_excetionSubQuery='" + executionList + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}
	
	
	public static String getsavechildData(List<ProjectPlanningSchedulingRestModel> itemModel) {

		String s = "";
		if (itemModel.get(0).getPlaaningMainId()!= null && itemModel.get(0).getPlaaningMainId() != "") {
			s = s + "@p_planMainId='" + itemModel.get(0).getPlaaningMainId() + "',";
		}else {
			s = s + "@p_planMainId=null,";
		}
		if (itemModel.get(0).getSlnoId()!= null && itemModel.get(0).getSlnoId() != "") {
			s = s + "@p_serialId='" + itemModel.get(0).getSlnoId() + "',";
		}else {
			s = s + "@p_serialId=null,";
		}

		if (itemModel.get(0).getProplanid() != null && itemModel.get(0).getProplanid() != "") {
			s = s + "@p_planId='" + itemModel.get(0).getProplanid() + "',";
		}else {
			s = s + "@p_planId=null,";
		}
		if (itemModel.get(0).getCategoryid() != null && itemModel.get(0).getCategoryid() != "") {
			s = s + "@p_plancategoryId='" + itemModel.get(0).getCategoryid() + "',";
		}else {
			s = s + "@p_plancategoryId=null,";
		}
		if (itemModel.get(0).getParentid() != null && itemModel.get(0).getParentid() != "") {
			s = s + "@p_parentId='" + itemModel.get(0).getParentid() + "',";
		}else {
			s = s + "@p_parentId=null,";
		}
		
		if (itemModel.get(0).getProjectId() != null && itemModel.get(0).getProjectId() != "") {
			s = s + "@p_projectId='" + itemModel.get(0).getProjectId() + "',";
		}else {
			s = s + "@p_projectId=null,";
		}
		
		if (itemModel.get(0).getcName() != null && itemModel.get(0).getcName() != "") {
			s = s + "@p_categoryName='" + itemModel.get(0).getcName() + "',";
		}else {
			s = s + "@p_categoryName=null,";
		}
		
		if (itemModel.get(0).getPriority() != null && itemModel.get(0).getPriority() != "") {
			s = s + "@p_priority='" + itemModel.get(0).getPriority() + "',";
		}else {
			s = s + "@p_priority=null,";
		}
		if (DateFormatter.getStringDateTimeWithoutTime(itemModel.get(0).getStartDate()) != null && DateFormatter.getStringDateTimeWithoutTime(itemModel.get(0).getStartDate()) != "") {
			s = s + "@p_startdt='" + DateFormatter.getStringDateTimeWithoutTime(itemModel.get(0).getStartDate()) + "',";
		}else {
			s = s + "@p_startdt=null,";
		}

		if (DateFormatter.getStringDateTimeWithoutTime(itemModel.get(0).getEndDate()) != null && DateFormatter.getStringDateTimeWithoutTime(itemModel.get(0).getEndDate()) != "") {
			s = s + "@p_enddt='" + DateFormatter.getStringDateTimeWithoutTime(itemModel.get(0).getEndDate()) + "',";
		} else {
			s = s + "@p_enddt=null,";
		}
		if (itemModel.get(0).getAssignedTo() != null && itemModel.get(0).getAssignedTo() != "") {
			s = s + "@p_assign='" + itemModel.get(0).getAssignedTo() + "',";
		}
		else {
			s = s + "@p_assign=null,";
		}
		if (itemModel.get(0).getDuration() != null && itemModel.get(0).getDuration() != " ") {
			s = s + "@p_duration='" + itemModel.get(0).getDuration() + "',";
		}else {
			s = s + "@p_duration=null,";
		}
		if (itemModel.get(0).getPredecessors() != null && itemModel.get(0).getPredecessors() != "") {
			s = s + "@p_predecessors='" + itemModel.get(0).getPredecessors() + "',";
		}else {
			s = s + "@p_predecessors=null,";
		}
		if (itemModel.get(0).getNotes() != null && itemModel.get(0).getNotes() != " ") {
			s = s + "@p_notes='" + itemModel.get(0).getNotes() + "',";
		}else {
			s = s + "@p_notes=null,";
		}
		if (itemModel.get(0).getCreatedBy() != null && itemModel.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + itemModel.get(0).getCreatedBy() + "',";
		}else {
			s = s + "@p_createdBy=null,";
		}

		
		if (itemModel.get(0).getOrganizationName() != null && itemModel.get(0).getOrganizationName() != "") {
			s = s + "@p_orgname='" + itemModel.get(0).getOrganizationName() + "',";
		}else {
			s = s + "@p_orgname=null,";
		}
		if (itemModel.get(0).getOrganizationDivision() != null && itemModel.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgdiv='" + itemModel.get(0).getOrganizationDivision() + "',";
		}else {
			s = s + "@p_orgdiv=null,";
		}
		
		if (itemModel.get(0).getCategory() != null && itemModel.get(0).getCategory() != "") {
			s = s + "@p_category='" + itemModel.get(0).getCategory() + "',";
		}else {
			s = s + "@p_category=null,";
		}

		if (itemModel.get(0).getPlanningName() != null && itemModel.get(0).getPlanningName() != "") {
			s = s + "@p_planningName='" + itemModel.get(0).getPlanningName() + "',";
		}else {
			s = s + "@p_planningName=null,";
		}
		if (itemModel.get(0).getProjectName() != null && itemModel.get(0).getProjectName() != "") {
			s = s + "@p_pname='" + itemModel.get(0).getProjectName() + "',";
		}else {
			s = s + "@p_pname=null,";
		}
		
		if (itemModel.get(0).getLocation() != null && itemModel.get(0).getLocation() != "") {
			s = s + "@p_location='" + itemModel.get(0).getLocation() + "',";
		}else {
			s = s + "@p_location=null,";
		}

		if (itemModel.get(0).getpIncharge() != null && itemModel.get(0).getpIncharge() != "") {
			s = s + "@p_incharge='" + itemModel.get(0).getpIncharge() + "',";
		}else {
			s = s + "@p_incharge=null,";
		}
		
		 
		if (itemModel.get(0).getProjectStatus() != null && itemModel.get(0).getProjectStatus() != "") {
			s = s + "@p_projectStatus='" + itemModel.get(0).getProjectStatus() + "',";
		}else {
			s = s + "@p_projectStatus=null,";
		}
		
		if (itemModel.get(0).getPlanhours() != null && itemModel.get(0).getPlanhours() != "") {
			s = s + "@p_planedhrs='" + itemModel.get(0).getPlanhours() + "',";
		}else {
			s = s + "@p_planedhrs=null,";
		}
		
		if (itemModel.get(0).getUnit() != null && itemModel.get(0).getUnit() != "") {
			s = s + "@p_unit='" + itemModel.get(0).getUnit() + "',";
		}else {
			s = s + "@p_unit=null,";
		}
		
		if (itemModel.get(0).getUnitPlan() != null && itemModel.get(0).getUnitPlan() != "") {
			s = s + "@p_unitPlan='" + itemModel.get(0).getUnitPlan() + "',";
		}else {
			s = s + "@p_unitPlan=null,";
		}
		
		if (itemModel.get(0).getQuantity() != null && itemModel.get(0).getQuantity() != "") {
			s = s + "@p_quantity='" + itemModel.get(0).getQuantity() + "',";
		}else {
			s = s + "@p_quantity=null,";
		}
		
		if (itemModel.get(0).getEstimatedPrice() != null && itemModel.get(0).getEstimatedPrice() != "") {
			s = s + "@p_totalPrice='" + itemModel.get(0).getEstimatedPrice() + "',";
		}else {
			s = s + "@p_totalPrice=null,";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
