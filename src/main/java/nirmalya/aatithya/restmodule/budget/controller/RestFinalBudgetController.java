package nirmalya.aatithya.restmodule.budget.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.budget.dao.RestFinalBudgetDao;
import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.budget.model.RestMonitoringBudgetModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "budget")
public class RestFinalBudgetController {
	Logger logger = LoggerFactory.getLogger(RestFinalBudgetController.class);
	@Autowired
	RestFinalBudgetDao restFinalBudgetDao;
	
	        //allDeptIncomExpenseData
			@RequestMapping(value="allFyIncomExpenseData" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> allFyIncomExpenseData(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
				logger.info("Method: allFyIncomExpenseData Start");
				logger.info("Method: allProvDeptIncomExpenseData ends");
				return restFinalBudgetDao.allFyIncomExpenseData(fyId,orgName,orgDivision);
			}
			
			//provisionalFyCurrInflationDataByFy
			
			@RequestMapping(value="fyBudgetCurrInflationDataByFy" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> fyBudgetCurrInflationDataByFy(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
				logger.info("Method: fyBudgetCurrInflationDataByFy Start");
				logger.info("Method: fyBudgetCurrInflationDataByFy ends");
				return restFinalBudgetDao.fyBudgetCurrInflationDataByFy(fyId,orgName,orgDivision);
			}	
			
			//viewProvisionalIncomeDtlsForAllDept
			
			@RequestMapping(value="viewFyBudIncomeDtlsForAllDept" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewFyBudIncomeDtlsForAllDept(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
				logger.info("Method: viewFyBudIncomeDtlsForAllDept View Start");
				
				logger.info("Method: viewFyBudIncomeDtlsForAllDept ends");
				return restFinalBudgetDao.viewFyBudIncomeDtlsForAllDept(fyId,orgName,orgDivision);
			}
			
			//viewProvisionalExpenseDtlsForAllDept
			
			@RequestMapping(value="viewFyBudExpenseDtlsForAllDept" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewFyBudExpenseDtlsForAllDept(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
				logger.info("Method: viewFyBudExpenseDtlsForAllDept View Start");
				
				logger.info("Method: viewFyBudExpenseDtlsForAllDept ends");
				return restFinalBudgetDao.viewFyBudExpenseDtlsForAllDept(fyId,orgName,orgDivision);
			}
			
			//aggregationFyCurrInflationData
			@RequestMapping(value="fyBudgetCurrInflationData" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> fyBudgetCurrInflationData(){
				logger.info("Method: fyBudgetCurrInflationData Start");
				logger.info("Method: fyBudgetCurrInflationData ends");
				return restFinalBudgetDao.fyBudgetCurrInflationData();
			}
			
			//quarterlyDataByGroupId
			
			@RequestMapping(value="quarterlyDataByGroupId" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>> quarterlyDataByGroupId(@RequestParam String groupId,@RequestParam String fyId){
				logger.info("Method: quarterlyDataByGroupId Start");
				logger.info("Method: quarterlyDataByGroupId ends");
				return restFinalBudgetDao.quarterlyDataByGroupId(groupId,fyId);
			}

}
