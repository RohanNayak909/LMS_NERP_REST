package nirmalya.aatithya.restmodule.projects.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.BudgetEstimationDao;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestModel;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestSubModel;
import nirmalya.aatithya.restmodule.projects.model.RestExtraExpenseModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;

@RestController
@RequestMapping("projects/")
public class BudgetEstimationRestController {

	Logger logger = LoggerFactory.getLogger(BudgetEstimationRestController.class);

	@Autowired
	BudgetEstimationDao BudgetDao;

	@RequestMapping(value = "get-budgetCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> getbudgetCategoryList() {

		logger.info("Method : budgetCategoryList starts");
		logger.info("Method : budgetCategoryList ends");

		return BudgetDao.budgetCategoryListDao();
	}

	@RequestMapping(value = "get-projectList", method = { RequestMethod.GET })
	public List<DropDownModel> getProjectList() {

		logger.info("Method : getProjectList starts");
		logger.info("Method : getProjectList ends");

		return BudgetDao.getProjectListDao();
	}

	// budget sub category list
	@RequestMapping(value = "rest-get-budgetSubCategoryList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> budgetSubCategoryList(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : budgetSubCategoryList starts");
		logger.info("Method : budgetSubCategoryList ends" + id);
		return BudgetDao.budgetSubCategoryListDao(id, org, orgDiv);
	}

	@RequestMapping(value = "rest-get-budgetVariantList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> budgetVariantList(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : budgetVariantList starts");
		logger.info("Method : budgetVariantList ends" + id);
		return BudgetDao.budgetVariantListDao(id, org, orgDiv);
	}

	//
	// budget add
	@PostMapping(value = "rest-view-budget-estimate-add")
	public ResponseEntity<JsonResponse<Object>> estimateBudgetAdd(@RequestBody BudgetEstimationRestModel budget) {
		logger.info("Method : estimateBudgetAdd starts");

		logger.info("Method : estimateBudgetAdd ends");
		return BudgetDao.estimateBudgetAddDao(budget);
	}

	// budget view
	@RequestMapping(value = "rest-view-budget-estimate-view", method = { RequestMethod.GET })

	public JsonResponse<Object> estimateBudgetView(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :estimateBudgetView start");

		logger.info("Method :estimateBudgetView endss");
		return BudgetDao.estimateBudgetViewDao(userid, org, div, id);
	}

	// edit budget
	@RequestMapping(value = "rest-view-budget-estimate-edit", method = { RequestMethod.GET })

	public JsonResponse<Object> estimateBudgetEdit(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id, @RequestParam String id2) {
		logger.info("Method :estimateBudgetView start");

		logger.info("Method :estimateBudgetView endss");
		return BudgetDao.estimateBudgetEditDao(userid, org, div, id, id2);
	}

	// delete budget
	@RequestMapping(value = "rest-view-budget-estimate-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> estimateBudgetDelete(@RequestParam String id) {
		logger.info("Method :  estimateBudgetDelete starts" + id);

		logger.info("Method :  estimateBudgetDelete ends");
		return BudgetDao.estimateBudgetDeleteDao(id);
	}

	// budget view
	@RequestMapping(value = "rest-view-budget-estimate-view-data", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<BudgetEstimationRestModel>>> estimateBudgetViewData(
			@RequestParam String id) {
		logger.info("Method: estimateBudgetViewData View Start");

		logger.info("Method: estimateBudgetViewData ends");
		return BudgetDao.estimateBudgetViewDataDao(id);
	}

	// budget add data
	@PostMapping(value = "rest-view-add-data")
	public ResponseEntity<JsonResponse<List<BudgetEstimationRestModel>>> addBudgetData(
			@RequestBody List<BudgetEstimationRestModel> model) {
		logger.info("Method :addBudgetData starts");
		logger.info("Method :addBudgetData endss");
		return BudgetDao.addBudgetDataDao(model);
	}

	//
	@PostMapping(value = "rest-addExpenses")
	public JsonResponse<Object> addExpenses(@RequestBody RestExtraExpenseModel restExtraExpenseModel) {
		logger.info("Method :addExpenses starts");

		logger.info("Method : addExpenses ends");
		return BudgetDao.addExpenses(restExtraExpenseModel);
	}
	//

	@RequestMapping(value = "rest-project-expense-list", method = { RequestMethod.GET })

	public JsonResponse<Object> getExpenseForProject(@RequestParam String id) {
		logger.info("Method :getExpenseForProject start");

		logger.info("Method :getExpenseForProject endss");
		return BudgetDao.getExpenseForProject(id);
	}

	//
	/* rest project state list drop down on edit */
	@RequestMapping(value = "rest-getProjectExpenseStateList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getExpenseList(@RequestParam String id) {
		logger.info("Method : rest getExpenseList starts");

		logger.info("Method : rest getExpenseList ends");
		return BudgetDao.getExpenseList(id);
	}

	//
	@RequestMapping(value = "rest-get-budget-extra-expenses", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> budgetExtraExp(@RequestParam String id) {
		logger.info("Method : budgetExtraExp starts");
		logger.info("Method : budgetExtraExp ends" + id);
		return BudgetDao.budgetExtraExp(id);
	}
}
