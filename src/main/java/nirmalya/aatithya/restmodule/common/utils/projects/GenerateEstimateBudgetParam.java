package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.InventoryRfqVendorModel;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestModel;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestSubModel;
import nirmalya.aatithya.restmodule.projects.model.RestExtraExpenseModel;

public class GenerateEstimateBudgetParam {

	public static String getAddBudgetParam(BudgetEstimationRestModel model) {

		String s = "";
//	if (employee.getBudgetId() != null) {
		s = s + "@p_budgetId='" + model.getBudgetId() + "',";

		if (model.getBudgetCategory() != null && model.getBudgetCategory() != "") {
			s = s + "@p_budgetCategory='" + model.getBudgetCategory() + "',";
		}
		else {
			s = s + "@p_budgetCategory=null,";
		}
		if (model.getItem() != null && model.getItem() != "") {
			s = s + "@p_item='" + model.getItem() + "',";
		}
		
		else {
			s = s + "@p_item=null,";
		}

		if (model.getProjectId() != null && model.getProjectId() != "") {
			s = s + "@p_projectId='" + model.getProjectId() + "',";
		}
		else {
			s = s + "@p_projectId=null,";
		}
		

		if (model.getUnit() != null && model.getUnit() != "") {
			s = s + "@p_unit='" + model.getUnit() + "',";
		}
		
		else {
			s = s + "@p_unit=null,";
		}

		if (model.getQty() != null && model.getQty() != "") {
			s = s + "@p_qty='" + model.getQty() + "',";
		}
		else {
			s = s + "@p_qty=null,";
		}
		if (model.getRate() != null && model.getRate() != "") {
			s = s + "@p_rate='" + model.getRate() + "',";
		}
		else {
			s = s + "@p_rate=null,";
		}
		if (model.getNos() != null && model.getNos() != "") {
			s = s + "@p_nos='" + model.getNos() + "',";
		}
		
		else {
			s = s + "@p_nos=null,";
		}

		if (model.getMob() != null && model.getMob() != "") {
			s = s + "@p_mob='" + model.getMob() + "',";
		}
		if (model.getAmount() != null && model.getAmount() != "") {
			s = s + "@p_amount='" + model.getAmount() + "',";
		}
		
		else {
			s = s + "@p_amount=null,";
		}

		if (model.getProjected() != null && model.getProjected() != "") {
			s = s + "@p_projected='" + model.getProjected() + "',";
		}
		
		else {
			s = s + "@p_projected=null,";
		}

		if (model.getActual() != null && model.getActual() != "") {
			s = s + "@p_actual='" + model.getActual() + "',";
		}
		
		else {
			s = s + "@p_actual=null,";
		}
		if (model.getExpenseId() != null && model.getExpenseId() != "") {
			s = s + "@p_expenses='" + model.getExpenseId() + "',";
		}
		
		else {
			s = s + "@p_expenses=null,";
		}
		
		if (model.getOrganizationName() != null && model.getOrganizationName() != "") {
			s = s + "@p_orgname='" + model.getOrganizationName() + "',";
		}
		
		else {
			s = s + "@p_orgname=null,";
		}
		
		if (model.getOrganizationDivision()!= null && model.getOrganizationDivision() != "") {
			s = s + "@p_orgdiv='" + model.getOrganizationDivision() + "',";
		}
		
		else {
			s = s + "@p_orgdiv=null,";
		}
		if (model.getCreatedBy()!= null && model.getCreatedBy() != "") {
			s = s + "@p_userid='" + model.getCreatedBy() + "',";
		}
		
		else {
			s = s + "@p_userid=null,";
		}
		
		if (model.getParentSlNo() != null && model.getParentSlNo() != "") {
			s = s + "@p_parentSlNo=" + model.getParentSlNo() + ",";
		} else {
			s = s + "@p_parentSlNo=null,";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String getAddQuotParam(List<BudgetEstimationRestModel> model) {

		String s = "";
		String vendorParam = "";
	
//		
//		for (BudgetEstimationRestModel m : model) {
//			//vendorId=m.getVendorId();
//			projectId=m.getProjectId();
//			budgetId=m.getBudgetId();
//			budgetCategoryId=m.getBudgetCategoryId();
//			itemId=m.getItemId();
//		}
//		s = s + "@p_budgetId='" + budgetId + "',";
//		s = s + "@p_budgetCategoryId='" + budgetCategoryId + "',";
//		s = s + "@p_itemId='" + itemId + "',";
//		s = s + "@p_projectId='" + projectId + "',";
//	
//		
		for (BudgetEstimationRestModel a : model) {

			vendorParam = vendorParam + "(gen_budget_id(),\"" + a.getBudgetCategoryId() + "\",\"" + a.getItemId() + "\",\""
					+ a.getProjectId() + "\"),";

		}
		vendorParam = vendorParam.substring(0, vendorParam.length() - 1);


		s = s + "@p_vendorParamSubQuery='" + vendorParam + "',";
	

		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		
		return s;
	}
	//
	public static String getExtraExpensesAdd(RestExtraExpenseModel restExtraExpenseModel) {

		String s = "";

		s = s + "@p_expenseId='" + restExtraExpenseModel.getExpenseId() + "',";

		if (restExtraExpenseModel.getBudgetCategory() != null && restExtraExpenseModel.getBudgetCategory()!= "") {
			s = s + "@p_categoryId='" + restExtraExpenseModel.getBudgetCategory() + "',";
		}
		if (restExtraExpenseModel.getItem() != null && restExtraExpenseModel.getItem() != "") {
			s = s + "@p_itemId='" + restExtraExpenseModel.getItem() + "',";
		}
		if (restExtraExpenseModel.getExtraExpense() != null && restExtraExpenseModel.getExtraExpense() != "") {
			s = s + "@p_extraExpenses='" + restExtraExpenseModel.getExtraExpense() + "',";
		}
		if (restExtraExpenseModel.getCreatedBy() != null && restExtraExpenseModel.getCreatedBy() != "") {
			s = s + "@p_creayedBy='" + restExtraExpenseModel.getCreatedBy() + "',";
		}
		if (restExtraExpenseModel.getOrgName() != null && restExtraExpenseModel.getOrgName() != "") {
			s = s + "@p_org='" + restExtraExpenseModel.getOrgName() + "',";
		}
		if (restExtraExpenseModel.getOrgDivision() != null && restExtraExpenseModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restExtraExpenseModel.getOrgDivision() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
}
