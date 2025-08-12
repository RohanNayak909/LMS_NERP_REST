package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;

public class GenerateProjectExecutionParameter {

	public static String saveProjectsCategory(List<RestProjectExecutionModel> category) {

		String s = "";

		String executionId = "";
		String categoryList = "";
		/*
		 * String CreatedBy = ""; String org = ""; String div = "";
		 * 
		 * 
		 * 
		 * executionId = category.getExecutionId(); CreatedBy = category.getCreatedBy();
		 * org = category.getOrganizationName(); div =
		 * category.getOrganizationDivision();
		 * 
		 * s = s + "@p_executionId='" + executionId + "',"; s = s + "@p_createdBy='" +
		 * CreatedBy + "',"; s = s + "@p_org='" + org + "',"; s = s + "@p_div='" + div +
		 * "',";
		 */
		if(!category.get(0).getExecutionId().contentEquals("1")) {
		for (RestProjectExecutionModel m : category) {

			categoryList = categoryList + "(gen_projectexecution_id(),\"" + m.getCategoryId() + "\",\"" + m.getCategoryName() + "\",\""
					+ m.getParentId() + "\",\"" + m.getCatLevel() + "\",\"" + m.getNodeSlNo() + "\",\""
					+ m.getProjectId() + "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganizationName()
					+ "\",\"" + m.getOrganizationDivision() + "\"),";

		}
		categoryList = categoryList.substring(0, categoryList.length() - 1);


		s = s + "@p_litemSubQuery='" + categoryList + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		}
	/*
	 * if (category.getCategoryNameList() != null) { if
	 * (category.getCategoryNameList().size() > 0) { for (RestProjectCategoryModel m
	 * : category.getCategoryNameList()) {
	 * 
	 * categoryList = categoryList + "(\"" + m.getCategoryId() + "\",\"" +
	 * m.getCategoryName() + "\",\"" + m.getParentId() + "\",\"" + m.getCatLevel() +
	 * "\",\"" + m.getNodeSlNo() + "\",\"" + m.getProjectId() + "\",\"" +
	 * m.getCreatedBy() + "\",\"" + m.getOrganizationName() + "\",\"" +
	 * m.getOrganizationDivision() + "\"),";
	 * 
	 * } categoryList = categoryList.substring(0, categoryList.length() - 1);
	 * 
	 * System.out.println("categoryList" + categoryList);
	 * 
	 * s = s + "@p_litemSubQuery='" + categoryList + "',"; if (s != "") { s =
	 * s.substring(0, s.length() - 1); s = "SET " + s + ";"; } }
	 * 
	 * else { categoryList = ""; }
	 * 
	 * }
	 */
	//	System.out.println("dfghjkljhgf" + s);

		return s;
	}

	/*
	 * String s = "";
	 * 
	 * 
	 * if(category.getExecutionId()!=null && category.getExecutionId()!="") { s = s
	 * + "@p_executionId='" + category.getExecutionId() + "',"; }
	 * if(category.getCategoryId()!=null && category.getCategoryId()!="") { s = s +
	 * "@p_categoryId='" + category.getCategoryId() + "',"; }
	 * if(category.getParentId()!=null && category.getParentId()!="") { s = s +
	 * "@p_parentId='" + category.getParentId() + "',"; }
	 * if(category.getProjectId()!=null && category.getProjectId()!="") { s = s +
	 * "@p_projectId='" + category.getProjectId() + "',"; }
	 * if(category.getCategoryName()!=null && category.getCategoryName()!="") { s =
	 * s + "@p_name='" + category.getCategoryName() + "',"; }
	 * if(category.getCatLevel()!=null && category.getCatLevel()!="") { s = s +
	 * "@p_lavl='" + category.getCatLevel() + "',"; }
	 * 
	 * if(category.getNodeSlNo()!=null && category.getNodeSlNo()!="") { s = s +
	 * "@p_slno='" + category.getNodeSlNo() + "',"; }
	 * 
	 * if(category.getCreatedBy()!=null && category.getCreatedBy()!="") { s = s +
	 * "@p_createdBy='" + category.getCreatedBy() + "',"; }
	 * 
	 * if(category.getOrganizationName()!=null &&
	 * category.getOrganizationName()!="") { s = s + "@p_orgname='" +
	 * category.getOrganizationName() + "',"; }
	 * if(category.getOrganizationDivision()!=null &&
	 * category.getOrganizationDivision()!="") { s = s + "@p_orgdiv='" +
	 * category.getOrganizationDivision() + "',"; }
	 * 
	 * if (s != "") { s = s.substring(0, s.length() - 1);
	 * 
	 * s = "SET " + s + ";"; }
	 * 
	 * System.out.println(s);
	 * 
	 * return s; }
	 */

	public static String savePrrojectExecutionTasks(List<RestProjectExecutionModel> category) {

		String s = "";

		if (category.get(0).getExecutionId() != null && category.get(0).getExecutionId() != "") {
			s = s + "@p_exeId='" + category.get(0).getExecutionId() + "',";
		}
		if (category.get(0).getCategoryId() != null && category.get(0).getCategoryId() != "") {
			s = s + "@p_categoryId='" + category.get(0).getCategoryId() + "',";
		}
		if (category.get(0).getParentId() != null && category.get(0).getParentId() != "") {
			s = s + "@p_parentId='" + category.get(0).getParentId() + "',";
		}
		if (category.get(0).getProjectId() != null && category.get(0).getProjectId() != "") {
			s = s + "@p_projectId='" + category.get(0).getProjectId() + "',";
		}
		if (category.get(0).getPreced() != null && category.get(0).getPreced() != "") {
			s = s + "@p_preced='" + category.get(0).getPreced() + "',";
		}
		if (category.get(0).getPhase() != null && category.get(0).getPhase() != "") {
			s = s + "@p_phase='" + category.get(0).getPhase() + "',";
		}
		if (DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) != "") {
			s = s + "@p_startDate='" + DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) + "',";
		}

		if (DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) != "") {
			s = s + "@p_endDate='" + DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) + "',";
		}

		if (category.get(0).getAssignedTo() != null && category.get(0).getAssignedTo() != "") {
			s = s + "@p_assignedTo='" + category.get(0).getAssignedTo() + "',";
		}

		if (category.get(0).getMaintype() != null && category.get(0).getMaintype() != "") {
			s = s + "@p_maintype='" + category.get(0).getMaintype() + "',";
		}
		if (category.get(0).getQtyNeeded() != null && category.get(0).getQtyNeeded() != "") {
			s = s + "@p_qtyNeeded='" + category.get(0).getQtyNeeded() + "',";
		}

		if (category.get(0).getPlannedHrs() != null && category.get(0).getPlannedHrs() != "") {
			s = s + "@p_plannedHrs='" + category.get(0).getPlannedHrs() + "',";
		}

		if (category.get(0).getActualHrs() != null && category.get(0).getActualHrs() != "") {
			s = s + "@p_actualHrs='" + category.get(0).getActualHrs() + "',";
		}

		if (category.get(0).getRequiDate() != null && category.get(0).getRequiDate() != "") {
			s = s + "@p_requiDate='" + category.get(0).getRequiDate() + "',";
		}

		if (category.get(0).getNeedDate() != null && category.get(0).getNeedDate() != "") {
			s = s + "@p_needDate='" + category.get(0).getNeedDate() + "',";
		}

		if (category.get(0).getFileAttach() != null && category.get(0).getFileAttach() != "") {
			s = s + "@p_fileAttach='" + category.get(0).getFileAttach() + "',";
		}

		if (category.get(0).getReqid() != null && category.get(0).getReqid() != "") {
			s = s + "@p_reqid='" + category.get(0).getReqid() + "',";
		}

		if (category.get(0).getNotes() != null && category.get(0).getNotes() != "") {
			s = s + "@p_notes='" + category.get(0).getNotes() + "',";
		}

		if (category.get(0).getCreatedBy() != null && category.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.get(0).getCreatedBy() + "',";
		}

		if (category.get(0).getOrganizationName() != null && category.get(0).getOrganizationName() != "") {
			s = s + "@p_orgname='" + category.get(0).getOrganizationName() + "',";
		}
		if (category.get(0).getOrganizationDivision() != null && category.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgdiv='" + category.get(0).getOrganizationDivision() + "',";
		}
		
		if (category.get(0).getActualCost() != null && category.get(0).getActualCost() != "") {
			s = s + "@p_actualCost='" + category.get(0).getActualCost() + "',";
		}
		if (category.get(0).getDuration() != null && category.get(0).getDuration() != "") {
			s = s + "@p_duartion='" + category.get(0).getDuration() + "',";
		}
		if (category.get(0).getProjectStatus() != null && category.get(0).getProjectStatus() != "") {
			s = s + "@p_prjsts='" + category.get(0).getProjectStatus() + "',";
		}
		
		if (category.get(0).getPlanningId() != null && category.get(0).getPlanningId() != "") {
			s = s + "@p_planningId='" + category.get(0).getPlanningId() + "',";
		}
		
		if (category.get(0).getBudgetCategoryId() != null && category.get(0).getBudgetCategoryId() != "") {
			s = s + "@p_budgetCatId='" + category.get(0).getBudgetCategoryId() + "',";
		}

		
		if (category.get(0).getBudgetSubCategoryId() != null && category.get(0).getBudgetSubCategoryId() != "") {
			s = s + "@p_budgetSubCatId='" + category.get(0).getBudgetSubCategoryId() + "',";
		}

		if (category.get(0).getProjectName()!= null && category.get(0).getProjectName() != "") {
			s = s + "@p_projectName='" + category.get(0).getProjectName() + "',";
		}
		if (category.get(0).getEstimatedCost() != null && category.get(0).getEstimatedCost() != "") {
			s = s + "@p_estimatedCost='" + category.get(0).getEstimatedCost() + "',";
		}
		
		if (category.get(0).getUnitPrice() != null && category.get(0).getUnitPrice() != "") {
			s = s + "@p_UnitPrice='" + category.get(0).getUnitPrice() + "',";
		}
		
		if (category.get(0).getQuantity() != null && category.get(0).getQuantity() != "") {
			s = s + "@p_quantity='" + category.get(0).getQuantity() + "',";
		}
		
		if (category.get(0).getUom() != null && category.get(0).getUom() != "") {
			s = s + "@p_uom='" + category.get(0).getUom() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

	//	System.out.println(s);

		return s;
	}
	
	
	public static String savePrrojectExecutionTasksApi(RestProjectExecutionModel category) {

		String s = "";

		if (category.getExecutionId() != null && category.getExecutionId() != "") {
			s = s + "@p_exeId='" + category.getExecutionId() + "',";
		}
		if (category.getCategoryId() != null && category.getCategoryId() != "") {
			s = s + "@p_categoryId='" + category.getCategoryId() + "',";
		}
		if (category.getParentId() != null && category.getParentId() != "") {
			s = s + "@p_parentId='" + category.getParentId() + "',";
		}
		if (category.getProjectId() != null && category.getProjectId() != "") {
			s = s + "@p_projectId='" + category.getProjectId() + "',";
		}
		if (category.getPreced() != null && category.getPreced() != "") {
			s = s + "@p_preced='" + category.getPreced() + "',";
		}
		if (category.getPhase() != null && category.getPhase() != "") {
			s = s + "@p_phase='" + category.getPhase() + "',";
		}
		if (DateFormatter.getStringDateTimeWithoutTime(category.getStartDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.getStartDate()) != "") {
			s = s + "@p_startDate='" + DateFormatter.getStringDateTimeWithoutTime(category.getStartDate()) + "',";
		}

		if (DateFormatter.getStringDateTimeWithoutTime(category.getEndDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.getEndDate()) != "") {
			s = s + "@p_endDate='" + DateFormatter.getStringDateTimeWithoutTime(category.getEndDate()) + "',";
		}

		if (category.getAssignedTo() != null && category.getAssignedTo() != "") {
			s = s + "@p_assignedTo='" + category.getAssignedTo() + "',";
		}

		if (category.getMaintype() != null && category.getMaintype() != "") {
			s = s + "@p_maintype='" + category.getMaintype() + "',";
		}
		if (category.getQtyNeeded() != null && category.getQtyNeeded() != "") {
			s = s + "@p_qtyNeeded='" + category.getQtyNeeded() + "',";
		}

		if (category.getPlannedHrs() != null && category.getPlannedHrs() != "") {
			s = s + "@p_plannedHrs='" + category.getPlannedHrs() + "',";
		}

		if (category.getActualHrs() != null && category.getActualHrs() != "") {
			s = s + "@p_actualHrs='" + category.getActualHrs() + "',";
		}

		if (category.getRequiDate() != null && category.getRequiDate() != "") {
			s = s + "@p_requiDate='" + category.getRequiDate() + "',";
		}

		if (category.getNeedDate() != null && category.getNeedDate() != "") {
			s = s + "@p_needDate='" + category.getNeedDate() + "',";
		}

		if (category.getFileAttach() != null && category.getFileAttach() != "") {
			s = s + "@p_fileAttach='" + category.getFileAttach() + "',";
		}

		if (category.getReqid() != null && category.getReqid() != "") {
			s = s + "@p_reqid='" + category.getReqid() + "',";
		}

		if (category.getNotes() != null && category.getNotes() != "") {
			s = s + "@p_notes='" + category.getNotes() + "',";
		}

		if (category.getCreatedBy() != null && category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		}

		if (category.getOrganizationName() != null && category.getOrganizationName() != "") {
			s = s + "@p_orgname='" + category.getOrganizationName() + "',";
		}
		if (category.getOrganizationDivision() != null && category.getOrganizationDivision() != "") {
			s = s + "@p_orgdiv='" + category.getOrganizationDivision() + "',";
		}
		if (category.getEstimatedCost() != null && category.getEstimatedCost() != "") {
			s = s + "@p_estimatedCost='" + category.getEstimatedCost() + "',";
		}
		if (category.getBaseline() != null && category.getBaseline() != "") {
			s = s + "@p_baseline='" + category.getBaseline() + "',";
		}
		if (category.getActualCost() != null && category.getActualCost() != "") {
			s = s + "@p_actualCost='" + category.getActualCost() + "',";
		}
		if (category.getDuration() != null && category.getDuration() != "") {
			s = s + "@p_duartion='" + category.getDuration() + "',";
		}
		if (category.getProjectStatus() != null && category.getProjectStatus() != "") {
			s = s + "@p_prjsts='" + category.getProjectStatus() + "',";
		}
		
		if (category.getPlanningId() != null && category.getPlanningId() != "") {
			s = s + "@p_planningId='" + category.getPlanningId() + "',";
		}
		
		if (category.getBudgetCategoryId() != null && category.getBudgetCategoryId() != "") {
			s = s + "@p_budgetCatId='" + category.getBudgetCategoryId() + "',";
		}

		
		if (category.getBudgetSubCategoryId() != null && category.getBudgetSubCategoryId() != "") {
			s = s + "@p_budgetSubCatId='" + category.getBudgetSubCategoryId() + "',";
		}

		/*
		 * if (category.getAreaAcer() != null && category.getAreaAcer() != "") { s = s +
		 * "@p_areaAcer='" + category.getAreaAcer() + "',"; }
		 */
		
		if (category.getProjectName()!= null && category.getProjectName() != "") {
			s = s + "@p_projectName='" + category.getProjectName() + "',";
		}

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		//System.out.println(s);

		return s;
	}
	
	
	public static String saveParentTasks(List<RestProjectExecutionModel> category) {

		String s = "";

		if (category.get(0).getExecutionId() != null && category.get(0).getExecutionId() != "") {
			s = s + "@p_exeId='" + category.get(0).getExecutionId() + "',";
		}
		if (category.get(0).getCategoryId() != null && category.get(0).getCategoryId() != "") {
			s = s + "@p_categoryId='" + category.get(0).getCategoryId() + "',";
		}
		if (category.get(0).getParentId() != null && category.get(0).getParentId() != "") {
			s = s + "@p_parentId='" + category.get(0).getParentId() + "',";
		}
		if (category.get(0).getProjectId() != null && category.get(0).getProjectId() != "") {
			s = s + "@p_projectId='" + category.get(0).getProjectId() + "',";
		}
		if (category.get(0).getPhase() != null && category.get(0).getPhase() != "") {
			s = s + "@p_phase='" + category.get(0).getPhase() + "',";
		}
		if (DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) != "") {
			s = s + "@p_startDate='" + DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) + "',";
		}

		if (DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) != "") {
			s = s + "@p_endDate='" + DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) + "',";
		}

		if (category.get(0).getAssignedTo() != null && category.get(0).getAssignedTo() != "") {
			s = s + "@p_assignedTo='" + category.get(0).getAssignedTo() + "',";
		}

		if (category.get(0).getMaintype() != null && category.get(0).getMaintype() != "") {
			s = s + "@p_maintype='" + category.get(0).getMaintype() + "',";
		}
		if (category.get(0).getQtyNeeded() != null && category.get(0).getQtyNeeded() != "") {
			s = s + "@p_qtyNeeded='" + category.get(0).getQtyNeeded() + "',";
		}

		if (category.get(0).getPlannedHrs() != null && category.get(0).getPlannedHrs() != "") {
			s = s + "@p_plannedHrs='" + category.get(0).getPlannedHrs() + "',";
		}

		if (category.get(0).getActualHrs() != null && category.get(0).getActualHrs() != "") {
			s = s + "@p_actualHrs='" + category.get(0).getActualHrs() + "',";
		}

		if (category.get(0).getRequiDate() != null && category.get(0).getRequiDate() != "") {
			s = s + "@p_requiDate='" + category.get(0).getRequiDate() + "',";
		}

		if (category.get(0).getNeedDate() != null && category.get(0).getNeedDate() != "") {
			s = s + "@p_needDate='" + category.get(0).getNeedDate() + "',";
		}

		if (category.get(0).getFileAttach() != null && category.get(0).getFileAttach() != "") {
			s = s + "@p_fileAttach='" + category.get(0).getFileAttach() + "',";
		}

		if (category.get(0).getReqid() != null && category.get(0).getReqid() != "") {
			s = s + "@p_reqid='" + category.get(0).getReqid() + "',";
		}

		if (category.get(0).getNotes() != null && category.get(0).getNotes() != "") {
			s = s + "@p_notes='" + category.get(0).getNotes() + "',";
		}

		if (category.get(0).getCreatedBy() != null && category.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.get(0).getCreatedBy() + "',";
		}
		
		if (category.get(0).getActualCost() != null && category.get(0).getActualCost() != "") {
			s = s + "@p_actualCost='" + category.get(0).getActualCost() + "',";
		}

		if (category.get(0).getOrganizationName() != null && category.get(0).getOrganizationName() != "") {
			s = s + "@p_orgname='" + category.get(0).getOrganizationName() + "',";
		}
		if (category.get(0).getOrganizationDivision() != null && category.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgdiv='" + category.get(0).getOrganizationDivision() + "',";
		}
		
		if (category.get(0).getProjectStatus()!= null && category.get(0).getProjectStatus() != "") {
			s = s + "@p_projectstatus='" + category.get(0).getProjectStatus() + "',";
		}
		
		if (category.get(0).getPreced() != null && category.get(0).getPreced() != "") {
			s = s + "@p_preced='" + category.get(0).getPreced() + "',";
		}
		
		if (category.get(0).getEstimatedCost() != null && category.get(0).getEstimatedCost() != "") {
			s = s + "@p_estimatedCost='" + category.get(0).getEstimatedCost() + "',";
		}
		
		if (category.get(0).getUnitPrice() != null && category.get(0).getUnitPrice() != "") {
			s = s + "@p_UnitPrice='" + category.get(0).getUnitPrice() + "',";
		}
		
		if (category.get(0).getQuantity() != null && category.get(0).getQuantity() != "") {
			s = s + "@p_quantity='" + category.get(0).getQuantity() + "',";
		}
		
		if (category.get(0).getUom() != null && category.get(0).getUom() != "") {
			s = s + "@p_uom='" + category.get(0).getUom() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		//System.out.println(s);

		return s;
	}

	public static String AddTaskDetail(List<RestProjectExecutionModel> category) {
		String s = "";
		if (category.get(0).getExecutionId() != null && category.get(0).getExecutionId() != "") {
			s = s + "@p_exeId='" + category.get(0).getExecutionId() + "',";
		}
		
		if (category.get(0).getSlNo() != null && category.get(0).getSlNo() != "") {
			s = s + "@p_slNo='" + category.get(0).getSlNo() + "',";
		}
		if (category.get(0).getCategoryId() != null && category.get(0).getCategoryId() != "") {
			s = s + "@p_categoryId='" + category.get(0).getCategoryId() + "',";
		}
		if (category.get(0).getProjectId() != null && category.get(0).getProjectId() != "") {
			s = s + "@p_projectId='" + category.get(0).getProjectId() + "',";
		}
		if (category.get(0).getPhase() != null && category.get(0).getPhase() != "") {
			s = s + "@p_phase='" + category.get(0).getPhase() + "',";
		}
		if (DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) != "") {
			s = s + "@p_startDate='" + DateFormatter.getStringDateTimeWithoutTime(category.get(0).getStartDate()) + "',";
		}

		if (DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) != null && DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) != "") {
			s = s + "@p_endDate='" + DateFormatter.getStringDateTimeWithoutTime(category.get(0).getEndDate()) + "',";
		}

		

		if (category.get(0).getMaintype() != null && category.get(0).getMaintype() != "") {
			s = s + "@p_maintype='" + category.get(0).getMaintype() + "',";
		}
		

		if (category.get(0).getPlannedHrs() != null && category.get(0).getPlannedHrs() != "") {
			s = s + "@p_plannedHrs='" + category.get(0).getPlannedHrs() + "',";
		}

		if (category.get(0).getActualHrs() != null && category.get(0).getActualHrs() != "") {
			s = s + "@p_actualHrs='" + category.get(0).getActualHrs() + "',";
		}

		if (DateFormatter.getStringDateTimeWithoutS(category.get(0).getActualStartDate()) != null && DateFormatter.getStringDateTimeWithoutS(category.get(0).getActualStartDate()) != "") {
			s = s + "@p_asDate='" + DateFormatter.getStringDateTimeWithoutS(category.get(0).getActualStartDate()) + "',";
		}

		

		if (category.get(0).getFileAttach() != null && category.get(0).getFileAttach() != "") {
			s = s + "@p_fileAttach='" + category.get(0).getFileAttach() + "',";
		}

		

		if (category.get(0).getNotes() != null && category.get(0).getNotes() != "") {
			s = s + "@p_notes='" + category.get(0).getNotes() + "',";
		}

		if (category.get(0).getCreatedBy() != null && category.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.get(0).getCreatedBy() + "',";
		}

		if (category.get(0).getOrganizationName() != null && category.get(0).getOrganizationName() != "") {
			s = s + "@p_orgname='" + category.get(0).getOrganizationName() + "',";
		}
		if (category.get(0).getOrganizationDivision() != null && category.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgdiv='" + category.get(0).getOrganizationDivision() + "',";
		}
		
		if (category.get(0).getFeedBack() != null && category.get(0).getFeedBack() != "") {
			s = s + "@p_feedback='" + category.get(0).getFeedBack() + "',";
		}
		
		
		if (category.get(0).getPlanningId() != null && category.get(0).getPlanningId() != "") {
			s = s + "@p_planningId='" + category.get(0).getPlanningId() + "',";
		}
		
		if (category.get(0).getBudgetCategoryId() != null && category.get(0).getBudgetCategoryId() != "") {
			s = s + "@p_budgetCategoryId='" + category.get(0).getBudgetCategoryId() + "',";
		}
		
		if (category.get(0).getBudgetSubCategoryId() != null && category.get(0).getBudgetSubCategoryId() != "") {
			s = s + "@p_budgetSubCategoryId='" + category.get(0).getBudgetSubCategoryId() + "',";
		}
		
		
		if (category.get(0).getQuantity() != null && category.get(0).getQuantity() != "") {
			s = s + "@p_quantity='" + category.get(0).getQuantity() + "',";
		}
		
		if (category.get(0).getQtyNeeded() != null && category.get(0).getQtyNeeded() != "") {
			s = s + "@p_quantityremain='" + category.get(0).getQtyNeeded() + "',";
		}
		
		
		if (category.get(0).getUnitPrice() != null && category.get(0).getUnitPrice() != "") {
			s = s + "@p_unitPrice='" + category.get(0).getUnitPrice() + "',";
		}
		
		if (category.get(0).getTotalAmnt() != null && category.get(0).getTotalAmnt() != "") {
			s = s + "@p_totalAmnt='" + category.get(0).getTotalAmnt() + "',";
		}
		
		if (category.get(0).getQtyRecieved() != null && category.get(0).getQtyRecieved() != "") {
			s = s + "@p_qtyRecieved='" + category.get(0).getQtyRecieved() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

	//	System.out.println(s);

		return s;
	}

}
