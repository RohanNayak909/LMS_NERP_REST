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
import nirmalya.aatithya.restmodule.budget.dao.RestMonitoringBudgetDao;
import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.budget.model.RestMonitoringBudgetModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "budget")
public class RestMonitoringBudgetController {
	Logger logger = LoggerFactory.getLogger(RestMonitoringBudgetController.class);
	@Autowired
	RestMonitoringBudgetDao restMonitoringBudgetDao;
	
	
	//budgetMonitoringIncomeQuarterly
	@RequestMapping(value="budgetMonitoringIncomeQuarterly" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>> budgetMonitoringIncomeQuarterly(@RequestParam String dept,@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
		logger.info("Method: budgetMonitoringIncomeQuarterly Start");
		logger.info("Method: budgetMonitoringIncomeQuarterly ends");
		return restMonitoringBudgetDao.budgetMonitoringIncomeQuarterly(dept,fyId,orgName,orgDivision);
	}
	

	
	
	//budgetMonitoringExpenseQuarterly
	@RequestMapping(value="budgetMonitoringExpenseQuarterly" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>> budgetMonitoringExpenseQuarterly(@RequestParam String dept,@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
		logger.info("Method: budgetMonitoringExpenseQuarterly Start");
		logger.info("Method: budgetMonitoringExpenseQuarterly ends");
		return restMonitoringBudgetDao.budgetMonitoringExpenseQuarterly(dept,fyId,orgName,orgDivision);
	}
	
	//departmentDataInMonitoring
	@RequestMapping(value="departmentDataInMonitoring" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> departmentDataInMonitoring(){
		logger.info("Method: departmentDataInMonitoring Start");
		logger.info("Method: departmentDataInMonitoring ends");
		return restMonitoringBudgetDao.departmentDataInMonitoring();
	}
	
	//departmentDataByIdMonitoring
	@RequestMapping(value="departmentDataByIdMonitoring" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> departmentDataByIdMonitoring(@RequestParam String dept){
		logger.info("Method: departmentDataByIdMonitoring Start");
		logger.info("Method: departmentDataByIdMonitoring ends");
		return restMonitoringBudgetDao.departmentDataByIdMonitoring(dept);
	}
	//deptByAllDataIncomExpenseMonitoring
	@RequestMapping(value="deptByAllDataIncomExpenseMonitoring" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> deptByAllDataIncomExpenseMonitoring(@RequestParam String dept,@RequestParam String fyId,@RequestParam String orgName,@RequestParam String orgDivision){
		logger.info("Method: deptByAllDataIncomExpenseMonitoring Start");
		logger.info("Method: deptByAllDataIncomExpenseMonitoring ends");
		return restMonitoringBudgetDao.deptByAllDataIncomExpenseMonitoring(dept,fyId,orgName,orgDivision);
	}
}

