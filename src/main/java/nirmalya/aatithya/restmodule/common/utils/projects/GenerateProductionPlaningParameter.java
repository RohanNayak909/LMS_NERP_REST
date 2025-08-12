package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;

public class GenerateProductionPlaningParameter {
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
						+ "\",\"" + DateFormatter.getStringDateTimeWithoutS(m.getStartDate()) + "\",\""
						+ DateFormatter.getStringDateTimeWithoutS(m.getEndDate()) + "\",\"" + m.getAssignedTo()
						+ "\",\"" + m.getDuration() + "\",\"" + m.getPredecessors() + "\",\"" + m.getNotes() + "\",\""
						+ m.getCreatedBy() + "\",\"" + m.getOrganizationName() + "\",\"" + m.getOrganizationDivision()
						+ "\",@CNT,\"" + "L1" + "\",\"" + m.getProjectName() + "\",\"" + m.getLocation() + "\",\""
						+ m.getpIncharge() + "\", \"" + m.getCategory() + "\",\"" + m.getSubCategory() + "\",\""
						+ m.getProjectStatus() + "\",\"" + m.getPlanhours() + "\",\"" + m.getEstimatedPrice() + "\",\""
						+ m.getUnit() + "\", \"" + m.getQuantity() + "\",\"" + m.getScopeOfWork() + "\",\""
						+ m.getVendorId() + "\",\"" + m.getVendorName() + "\"),";

			} else {

				if (m.getProplanid() != null && m.getProplanid() != "") {
					s = s + "@p_planschid='" + m.getProplanid() + "',";
				}

				categoryList = categoryList + "(@p_serialId,\"" + m.getProplanid() + "\",\"" + m.getcName()
						+ "\",@p_plancategoryId,@p_plancategoryId,\"" + m.getProjectId() + "\",\"" + m.getPriority()
						+ "\",\"" + DateFormatter.getStringDateTimeWithoutS(m.getStartDate()) + "\",\""
						+ DateFormatter.getStringDateTimeWithoutS(m.getEndDate()) + "\",\"" + m.getAssignedTo()
						+ "\",\"" + m.getDuration() + "\",\"" + m.getPredecessors() + "\",\"" + m.getNotes() + "\",\""
						+ m.getCreatedBy() + "\",\"" + m.getOrganizationName() + "\",\"" + m.getOrganizationDivision()
						+ "\",@CNT,\"" + "L1" + "\",\"" + m.getProjectName() + "\",\"" + m.getLocation() + "\",\""
						+ m.getpIncharge() + "\", \"" + m.getCategory() + "\",\"" + m.getSubCategory() + "\",\""
						+ m.getProjectStatus() + "\",\"" + m.getPlanhours() + "\",\"" + m.getEstimatedPrice() + "\",\""
						+ m.getUnit() + "\",\"" + m.getQuantity() + "\",\"" + m.getScopeOfWork() + "\",\""
						+ m.getVendorId() + "\",\"" + m.getVendorName() + "\"),";

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
		if (DateFormatter.getStringDateTimeWithoutS(category.get(0).getStartDate())!= null && DateFormatter.getStringDateTimeWithoutS(category.get(0).getStartDate()) != "") {
			s = s + "@p_stdt='" + DateFormatter.getStringDateTimeWithoutS(category.get(0).getStartDate()) + "',";
		}
		else {
			s = s + "@p_stdt=null,";
		}
		if (DateFormatter.getStringDateTimeWithoutS(category.get(0).getEndDate()) != null && DateFormatter.getStringDateTimeWithoutS(category.get(0).getEndDate()) != "") {
			s = s + "@p_nddt='" + DateFormatter.getStringDateTimeWithoutS(category.get(0).getEndDate()) + "',";
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
			s = s + "@p_projectEditId=null,";
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
		
		
		if (category.get(0).getQuantity() != null && category.get(0).getQuantity() != "") {
			s = s + "@p_quantity='" + category.get(0).getQuantity() + "',";
		}else {
			s = s + "@p_quantity=null,";
		}

		
		if (category.get(0).getUnit() != null && category.get(0).getUnit() != "") {
			s = s + "@p_unit='" + category.get(0).getUnit() + "',";
		}else {
			s = s + "@p_unit=null,";
		}

		
		if (category.get(0).getScopeOfWork() != null && category.get(0).getScopeOfWork() != "") {
			s = s + "@p_scopeOfWork='" + category.get(0).getScopeOfWork() + "',";
		}else {
			s = s + "@p_scopeOfWork=null,";
		}
		
		if (category.get(0).getVendorId() != null && category.get(0).getVendorId() != "") {
			s = s + "@p_vendorId='" + category.get(0).getVendorId() + "',";
		}else {
			s = s + "@p_vendorId=null,";
		}

		
		if (category.get(0).getVendorName() != null && category.get(0).getVendorName() != "") {
			s = s + "@p_vendorName='" + category.get(0).getVendorName() + "',";
		}else {
			s = s + "@p_vendorName=null,";
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
		if (itemModel.getSubCategory() != null && itemModel.getSubCategory() != "") {
			s = s + "@p_budsubcategory='" + itemModel.getSubCategory() + "',";
		}else {
			s = s + "@p_budsubcategory=null,";
		}

		if (itemModel.getProplanid() != null && itemModel.getProplanid() != "") {
			s = s + "@p_planid='" + itemModel.getProplanid() + "',";
		}else {
			s = s + "@p_planid=null,";
		}
		
		if (itemModel.getVendorName() != null && itemModel.getVendorName() != "") {
			s = s + "@p_vendorName='" + itemModel.getVendorName() + "',";
		}else {
			s = s + "@p_vendorName=null,";
		}
		if (itemModel.getVendorId() != null && itemModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + itemModel.getVendorId() + "',";
		}else {
			s = s + "@p_vendorId=null,";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
