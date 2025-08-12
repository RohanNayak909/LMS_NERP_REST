package nirmalya.aatithya.restmodule.budget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import nirmalya.aatithya.restmodule.budget.dao.RestDepartmentBudgetDao;
import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "budget")
public class RestDepartmentBudgetController {
	
	Logger logger = LoggerFactory.getLogger(RestDepartmentBudgetController.class);
	@Autowired
	RestDepartmentBudgetDao restDepartmentBudgetDao;
	
	// viewQc
		@RequestMapping(value = "rest-viewBudget", method = { RequestMethod.GET })
		public JsonResponse<Object> viewQc(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :viewBudget start");

			logger.info("Method :viewBudget endss");
			return restDepartmentBudgetDao.viewBudget(id,orgName, orgDivision);
		}
		
   // Add Budget
		
		@RequestMapping(value = "rest-addBudget", method = { RequestMethod.GET })
		public JsonResponse<Object> addBudget(@RequestParam String dept_id,String group_id,String financialYear,
				String budgetAmount,String incmRemak) {
			logger.info("Method :addBudgetAmount start");

			logger.info("Method :addBudgetAmount endss");
			return restDepartmentBudgetDao.addBudget(dept_id,group_id,financialYear,budgetAmount,incmRemak);
		}
		
		@RequestMapping(value = "rest-addActualBudget", method = { RequestMethod.GET })
		public JsonResponse<Object> addActualBudget(@RequestParam String dept_id,String group_id,String financialYear,
				String actualBudgetAmount,String actualIncmRemak) {
			logger.info("Method :addActualBudget start");

			logger.info("Method :addActualBudget endss");
			return restDepartmentBudgetDao.addActualBudget(dept_id,group_id,financialYear,actualBudgetAmount,actualIncmRemak);
		}
		
		// viewQc
				@RequestMapping(value = "rest-viewExpense", method = { RequestMethod.GET })
				public JsonResponse<Object> viewExpense(@RequestParam String id,String orgName, String orgDivision) {
					logger.info("Method :viewExpense start");

					logger.info("Method :viewExpense endss");
					return restDepartmentBudgetDao.viewExpense(id,orgName, orgDivision);
				}
				
		   // Add Budget
				
				@RequestMapping(value = "rest-addExpense", method = { RequestMethod.GET })
				public JsonResponse<Object> addExpenseAmt(@RequestParam String dept_id,String group_id,String financialYear,
						String budgetAmount,String incmRemak) {
					logger.info("Method :addExpenseAmt start");

					logger.info("Method :addExpenseAmt endss");
					return restDepartmentBudgetDao.addExpenseAmt(dept_id,group_id,financialYear,budgetAmount,incmRemak);
				}
				
				@RequestMapping(value = "rest-addActualExpnxBudget", method = { RequestMethod.GET })
				public JsonResponse<Object> addActualExpnsBudget(@RequestParam String dept_id,String group_id,String financialYear,
						String actualBudgetAmount,String actualExpnsRemak) {
					logger.info("Method :addActualExpnsBudget start");

					logger.info("Method :addActualExpnsBudget endss");
					return restDepartmentBudgetDao.addActualExpnsBudget(dept_id,group_id,financialYear,actualBudgetAmount,actualExpnsRemak);
				}
}
