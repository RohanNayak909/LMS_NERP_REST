package nirmalya.aatithya.restmodule.budget.controller;

	import java.util.List;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.budget.dao.RestAdjustmentBudgetDao;
import nirmalya.aatithya.restmodule.budget.dao.RestManageDepartmentDao;
import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.budget.model.RestManageDepartmentModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
	

	@RestController
	@RequestMapping(value = "budget/")
	public class RestAdjustmentBudgtController {
		
		Logger logger = LoggerFactory.getLogger(RestAdjustmentBudgtController.class);

		@Autowired
		RestAdjustmentBudgetDao restAdjustmentBudgetDao ;
		

		
		//rest-updateIncomeBudgetAmnt

		@RequestMapping(value = "rest-updateIncomeBudgetAmnt", method = { RequestMethod.GET })
		public JsonResponse<Object> updateIncomeBdgtAmnt(@RequestParam String deptId,String groupId,String financialYear,
				String oldBudgetAmnt,String updatedBudgetAmnt, String createdBy, String orgName, String orgDivision) {
			logger.info("Method :updateIncomeBdgtAmnt start");

			logger.info("Method :updateIncomeBdgtAmnt endss");
			return restAdjustmentBudgetDao.updateIncomeBdgtAmnt(deptId,groupId,financialYear,oldBudgetAmnt,updatedBudgetAmnt, createdBy, orgName, orgDivision);
		}
		
		//rest-updateIncomeActualAmnt
		
		@RequestMapping(value = "rest-updateIncomeActualAmnt", method = { RequestMethod.GET })
		public JsonResponse<Object> updateIncomeActualAmnt(@RequestParam String deptId,String groupId,String financialYear,
				String oldBudgetAmnt,String updatedBudgetAmnt,
				String createdBy,String orgName,String orgDivision) {
			logger.info("Method :updateIncomeActualAmnt start");
			
			logger.info("Method :updateIncomeActualAmnt endss");
			return restAdjustmentBudgetDao.updateIncomeActualAmnt(deptId,groupId,financialYear,oldBudgetAmnt,updatedBudgetAmnt,createdBy,orgName ,orgDivision);
		}
		
		//rest-updateExpenseActualAmnt
		@RequestMapping(value = "rest-updateExpenseActualAmnt", method = { RequestMethod.GET })
		public JsonResponse<Object> updateExpenseActualAmnt(@RequestParam String deptId,String groupId,String financialYear,
				String oldBudgetAmnt,String updatedBudgetAmnt,
				String createdBy,String orgName,String  orgDivision) {
			logger.info("Method :updateExpenseActualAmnt start");

			logger.info("Method :updateExpenseActualAmnt endss");
			return restAdjustmentBudgetDao.updateExpenseActualAmnt(deptId,groupId,financialYear,oldBudgetAmnt,updatedBudgetAmnt,createdBy,orgName,orgDivision);
		}
		
		//rest-updateExpenseBudgetAmnt
		@RequestMapping(value = "rest-updateExpenseBudgetAmnt", method = { RequestMethod.GET })
		public JsonResponse<Object> updateExpenseBdgtAmnt(@RequestParam String deptId,String groupId,String financialYear,
				String oldBudgetAmnt,String updatedBudgetAmnt,String createdBy,String orgName,
				String orgDivision) {
			
			logger.info("Method :updateExpenseBdgtAmnt start");

			logger.info("Method :updateExpenseBdgtAmnt endss");
			return restAdjustmentBudgetDao.updateExpenseBdgtAmnt(deptId,groupId,financialYear,oldBudgetAmnt,
					updatedBudgetAmnt,createdBy,orgName,orgDivision);
		}
		
		//adjustmentIncomeHistory
		@RequestMapping(value="adjustmentBudgetIncomeHistory" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> adjustmentBudgetIncomeHistory(@RequestParam String deptId, @RequestParam String groupId, @RequestParam String financialYear){
			logger.info("Method: adjustmentBudgetIncomeHistory Start");
			logger.info("Method: adjustmentBudgetIncomeHistory ends");
			return restAdjustmentBudgetDao.adjustmentBudgetIncomeHistory(deptId,groupId,financialYear);
		}
		
		//adjustmentActualIncomeHistory
		
		@RequestMapping(value="adjustmentActualIncomeHistory" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> adjustmentActualIncomeHistory(@RequestParam String deptId, @RequestParam String groupId, @RequestParam String financialYear){
			logger.info("Method: adjustmentActualIncomeHistory Start");
			logger.info("Method: adjustmentActualIncomeHistory ends");
			return restAdjustmentBudgetDao.adjustmentActualIncomeHistory(deptId,groupId,financialYear);
		}
		
		//adjustmentActualExpenseHistory
		
		@RequestMapping(value="adjustmentActualExpenseHistory" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> adjustmentActualExpenseHistory(@RequestParam String deptId, @RequestParam String groupId, @RequestParam String financialYear){
			logger.info("Method: adjustmentActualExpenseHistory Start");
			logger.info("Method: adjustmentActualExpenseHistory ends");
			return restAdjustmentBudgetDao.adjustmentActualExpenseHistory(deptId,groupId,financialYear);
		}
		
		//adjustmentExpenseHistory
		
		@RequestMapping(value="adjustmentBudgetExpenseHistory" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> adjustmentBudgetExpenseHistory(@RequestParam String deptId, @RequestParam String groupId, @RequestParam String financialYear){
			logger.info("Method: adjustmentBudgetExpenseHistory Start");
			logger.info("Method: adjustmentBudgetExpenseHistory ends");
			return restAdjustmentBudgetDao.adjustmentBudgetExpenseHistory(deptId,groupId,financialYear);
		}
		
	} 



