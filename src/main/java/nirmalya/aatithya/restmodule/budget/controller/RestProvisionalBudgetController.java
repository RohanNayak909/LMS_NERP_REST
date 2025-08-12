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

import nirmalya.aatithya.restmodule.budget.dao.RestProvisionalBudgetDao;
import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "budget")
public class RestProvisionalBudgetController {
	Logger logger = LoggerFactory.getLogger(RestProvisionalBudgetController.class);
	@Autowired
	RestProvisionalBudgetDao restProvisionalBudgetDao;
	
	        //allDeptIncomExpenseData
			@RequestMapping(value="allPrIncomExpenseData" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> allProvDeptIncomExpenseData(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
				logger.info("Method: allProvDeptIncomExpenseData Start");
				logger.info("Method: allProvDeptIncomExpenseData ends");
				return restProvisionalBudgetDao.allProvDeptIncomExpenseData(fyId,orgName, orgDivision);
			}
			
			//provisionalFyCurrInflationDataByFy
			
			@RequestMapping(value="provisionalFyCurrInflationDataByFy" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> provisionalFyCurrInflationDataByFy(@RequestParam String fyId){
				logger.info("Method: provisionalFyCurrInflationDataByFy Start");
				logger.info("Method: provisionalFyCurrInflationDataByFy ends");
				return restProvisionalBudgetDao.provisionalFyCurrInflationDataByFy(fyId);
			}	
			
			//viewProvisionalIncomeDtlsForAllDept
			
			@RequestMapping(value="viewProvisionalIncomeDtlsForAllDept" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewProvisionalIncomeDtlsForAllDept(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
				logger.info("Method: viewProvisionalIncomeDtlsForAllDept View Start");
				
				logger.info("Method: viewProvisionalIncomeDtlsForAllDept ends");
				return restProvisionalBudgetDao.viewProvisionalIncomeDtlsForAllDept(fyId,orgName,orgDivision);
			}
			
			//viewProvisionalExpenseDtlsForAllDept
			
			@RequestMapping(value="viewProvExpenseDtlsForAllDept" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewProvisionalExpenseDtlsForAllDept(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
				logger.info("Method: viewProvisionalExpenseDtlsForAllDept View Start");
				
				logger.info("Method: viewProvisionalExpenseDtlsForAllDept ends");
				return restProvisionalBudgetDao.viewProvisionalExpenseDtlsForAllDept(fyId,orgName,orgDivision);
			}
			
			//aggregationFyCurrInflationData
			@RequestMapping(value="provFyCurrInflationData" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> provFyCurrInflationData(@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
				logger.info("Method: provFyCurrInflationData Start");
				logger.info("Method: provFyCurrInflationData ends");
				return restProvisionalBudgetDao.prvFyCurrInflationData(fyId,orgName,orgDivision);
			}

}
