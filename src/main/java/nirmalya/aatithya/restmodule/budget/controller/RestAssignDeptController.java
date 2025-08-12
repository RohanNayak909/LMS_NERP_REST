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


import nirmalya.aatithya.restmodule.budget.dao.RestAssigeDeptDao;
import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "budget")
public class RestAssignDeptController {
	Logger logger = LoggerFactory.getLogger(RestAssignDeptController.class);
	@Autowired
	RestAssigeDeptDao restAssigeDeptDao;
	
//getDepartmentList
	
	@RequestMapping(value = "getDepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {
		
		logger.info("Method : getDepartmentList starts");
		logger.info("Method : getDepartmentList ends");
		
		
		return restAssigeDeptDao.getDepartmentList();
	}
	
	//getFiscalYear

	@RequestMapping(value = "getFiscalYear", method = { RequestMethod.GET })
	public List<DropDownModel> getFiscalYear() {
		
		logger.info("Method : getFiscalYear starts");
		logger.info("Method : getFiscalYear ends");
		
		
		return restAssigeDeptDao.getFiscalYear();
	}
	//getCurrencyList
	
	@RequestMapping(value = "getCurrencyList", method = { RequestMethod.GET })
	public List<DropDownModel> getCurrencyList() {
		
		logger.info("Method : getCurrencyList starts");
		logger.info("Method : getCurrencyList ends");
		
		
		return restAssigeDeptDao.getCurrencyList();
	}
	
	//restViewAssignDept
	
	@RequestMapping(value="restAssignIncomeDept" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> restAssignIncomeDept(@RequestParam String dept,@RequestParam String orgName,@RequestParam String   orgDivision){
		logger.info("Method: restAssignIncomeDept View Start");
		
		logger.info("Method: restAssignIncomeDept ends");
		return restAssigeDeptDao.restAssignIncomeDept(dept,orgName,orgDivision);
	}
	//restAssignedIncomeDept
	
	@RequestMapping(value="restAssignedIncomeDept" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> restAssignedIncomeDept(@RequestParam String dept, @RequestParam String fyId,@RequestParam String orgName, @RequestParam String orgDivision){
		logger.info("Method: restAssignedIncomeDept View Start");
		System.out.println("rest controller-----------------------------dept---"+dept +" FyId--- "+fyId );
		logger.info("Method: restAssignedIncomeDept ends");
		return restAssigeDeptDao.restAssignedIncomeDept(dept,fyId,orgName,orgDivision);
	}
	//restAssignedExpenseDept
	
	@RequestMapping(value="restAssignedExpenseDept" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> restAssignedExpenseDept(@RequestParam String dept, @RequestParam String fyId,@RequestParam String orgName, @RequestParam String orgDivision){
		logger.info("Method: restAssignedExpenseDept View Start");
		
		logger.info("Method: restAssignedExpenseDept ends");
		return restAssigeDeptDao.restAssignedExpenseDept(dept,fyId,orgName,orgDivision);
	}
	
	//restAssignExpenseDept
	
	@RequestMapping(value="restAssignExpenseDept" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> restAssignExpenseDept(@RequestParam String dept, @RequestParam String orgName, String orgDivision){
		logger.info("Method: restAssignExpenseDept View Start");
		System.out.println("dept rest -------------"+dept);
		logger.info("Method: restAssignExpenseDept ends");
		return restAssigeDeptDao.restAssignExpenseDept(dept, orgName, orgDivision);
	}
	
	//departmentData
	/*@RequestMapping(value="departmentData" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> departmentData(){
		logger.info("Method: departmentData Start");
		logger.info("Method: departmentData ends");
		return restAssigeDeptDao.departmentData();
	}*/
	
	@RequestMapping(value="departmentData" , method = {RequestMethod.GET})
	public JsonResponse<Object> departmentData(@RequestParam String orgName, String orgDivision){
		logger.info("Method: departmentData Start");
		logger.info("Method: departmentData ends");
		return restAssigeDeptDao.departmentData(orgName,orgDivision);
	}
	
	
	
	//departmentDataById
		@RequestMapping(value="departmentDataById" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> departmentDataById(@RequestParam String dept,@RequestParam String orgName,@RequestParam String orgDivision){
			logger.info("Method: departmentDataById Start");
			logger.info("Method: departmentDataById ends");
			return restAssigeDeptDao.departmentDataById(dept,orgName,orgDivision);
		}
		
	//assignIncomeDept
		@RequestMapping(value = "assignIncomeDept", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> assignIncomeDept(
				@RequestBody RestAssignDeptBudgetModel restAssignDeptBudgetModel) {
			logger.info("Method : assignIncomeDept starts");

			System.out.println("dataaaa===>>>>" + restAssignDeptBudgetModel);

			logger.info("Method : assignIncomeDept ends");

			return restAssigeDeptDao.assignIncomeDept(restAssignDeptBudgetModel);
		}
	
		//assignExpenseDept
		
		@RequestMapping(value = "assignExpenseDept", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> assignExpenseDept(
				@RequestBody RestAssignDeptBudgetModel restAssignDeptBudgetModel) {
			logger.info("Method : assignExpenseDept starts");

			System.out.println("dataaaa===>>>>" + restAssignDeptBudgetModel);

			logger.info("Method : assignExpenseDept ends");

			return restAssigeDeptDao.assignExpenseDept(restAssignDeptBudgetModel);
		}
		
		//viewIncomeDtlsbyId
		@RequestMapping(value="viewIncomeDtlsbyId" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewIncomeDtlsbyId(@RequestParam String dept,@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
			logger.info("Method: viewIncomeDtlsbyId View Start");
			
			logger.info("Method: viewIncomeDtlsbyId ends");
			return restAssigeDeptDao.viewIncomeDtlsbyId(dept,fyId,orgName,orgDivision);
		}
		//viewExpnsDtlsbyId
		
		@RequestMapping(value="viewExpnsDtlsbyId" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewExpnsDtlsbyId(@RequestParam String dept,@RequestParam String fyId,@RequestParam String orgName, @RequestParam String orgDivision){
			logger.info("Method: viewExpnsDtlsbyId View Start");
			
			logger.info("Method: viewExpnsDtlsbyId ends");
			return restAssigeDeptDao.viewExpnsDtlsbyId(dept,fyId,orgName,orgDivision);
		}
		
		//deptByAllDataIncomExpense
		@RequestMapping(value="deptByAllDataIncomExpense" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> deptByAllDataIncomExpense(@RequestParam String dept,@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
			logger.info("Method: deptByAllDataIncomExpense Start");
			logger.info("Method: deptByAllDataIncomExpense ends");
			return restAssigeDeptDao.deptByAllDataIncomExpense(dept,fyId,orgName,orgDivision);
		}
		
		//aggregationFyCurrInflationData
		@RequestMapping(value="aggregationFyCurrInflationData" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> aggregationFyCurrInflationData(@RequestParam String orgName, @RequestParam String orgDivision){
			logger.info("Method: aggregationFyCurrInflationData Start");
			logger.info("Method: aggregationFyCurrInflationData ends");
			return restAssigeDeptDao.aggregationFyCurrInflationData(orgName,orgDivision);
		}
		
		//viewIncomeDtlsForAllDept
		
		@RequestMapping(value="viewIncomeDtlsForAllDept" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewIncomeDtlsForAllDept(@RequestParam String fyId,@RequestParam String orgName, @RequestParam String orgDivision){
			logger.info("Method: viewIncomeDtlsForAllDept View Start");
			
			logger.info("Method: viewIncomeDtlsForAllDept ends");
			return restAssigeDeptDao.viewIncomeDtlsForAllDept(fyId,orgName, orgDivision);
		}
		
		//viewExpenseDtlsForAllDept
		
		@RequestMapping(value="viewExpenseDtlsForAllDept" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewExpenseDtlsForAllDept(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
			logger.info("Method: viewExpenseDtlsForAllDept View Start");
			
			logger.info("Method: viewExpenseDtlsForAllDept ends");
			return restAssigeDeptDao.viewExpenseDtlsForAllDept(fyId,orgName,orgDivision);
		}
		
		//allDeptIncomExpenseData
		@RequestMapping(value="allDeptIncomExpenseData" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> allDeptIncomExpenseData(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
			logger.info("Method: allDeptIncomExpenseData Start");
			logger.info("Method: allDeptIncomExpenseData ends");
			return restAssigeDeptDao.allDeptIncomExpenseData(fyId,orgName,orgDivision);
		}
		
		//aggregationFyCurrInflationDataByFy
		
		@RequestMapping(value="aggregationFyCurrInflationDataByFy" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> aggregationFyCurrInflationDataByFy(@RequestParam String fyId){
			logger.info("Method: aggregationFyCurrInflationDataByFy Start");
			logger.info("Method: aggregationFyCurrInflationDataByFy ends");
			return restAssigeDeptDao.aggregationFyCurrInflationDataByFy(fyId);
		}
		
		@GetMapping(value = "assignDuplicateIncomeCheck")
		public JsonResponse<Object> assignDuplicateIncomeCheck(@RequestParam String id,String deptId,String financialYear) {
			logger.info("Method :assignDuplicateIncomeCheck starts");

			logger.info("Method :assignDuplicateIncomeCheck ends"+id);
			return restAssigeDeptDao.assignDuplicateIncomeCheck(id,deptId,financialYear);

		}
		
		@GetMapping(value = "assignDuplicateExpensesCheck")
		public JsonResponse<Object> assignDuplicateExpensesCheck(@RequestParam String id,String deptId,String financialYear) {
			logger.info("Method :assignDuplicateExpensesCheck starts");

			logger.info("Method :assignDuplicateExpensesCheck ends"+id);
			return restAssigeDeptDao.assignDuplicateExpensesCheck(id,deptId,financialYear);

		}
}

