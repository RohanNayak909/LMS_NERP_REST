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

import nirmalya.aatithya.restmodule.budget.dao.RestFinancialYearDao;
import nirmalya.aatithya.restmodule.budget.model.RestFinancialYearModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "budget")
public class RestFinancialYearController {
	Logger logger = LoggerFactory.getLogger(RestFinancialYearController.class);

	@Autowired
	RestFinancialYearDao restFinancialYearDao;

	// Add FinancialYear
	@RequestMapping(value = "restAddFinancialYear", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restFinancialYearModel(
			@RequestBody RestFinancialYearModel restFinancialYearModel) {
		logger.info("Method : restAddDepartmentInfo starts");
		System.out.println("restAddDepartmentInfo=====>>>>>" + restFinancialYearModel);
		logger.info("Method : restAddDepartmentInfo  ends");
		return restFinancialYearDao.addFinancialYearInfo(restFinancialYearModel);
	}

	// view
//		@RequestMapping(value="restViewFinancialYear" , method = {RequestMethod.GET})
//		public ResponseEntity<JsonResponse<List<RestFinancialYearModel>>> restViewFinancialYear(){
//			logger.info("Method: restViewFinancialYear View Start");
//			
//			logger.info("Method: restViewFinancialYear ends");
//			return restFinancialYearDao.restViewFinancialYear();
//		}

	// ==============view through json
	
	@RequestMapping(value = "viewFinancialYear", method = { RequestMethod.GET })
	public JsonResponse<Object> viewFinancialYear(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewBudget start");

		logger.info("Method :viewBudget endss");
		return restFinancialYearDao.restViewFinancialYear(orgName, orgDivision);
	}

	@GetMapping(value = "restfinancialyearedit")
	public ResponseEntity<JsonResponse<List<RestFinancialYearModel>>> restEditBudgetDepartment(
			@RequestParam String id) {
		logger.info("Method :restEditBudgetDepartment starts");

		logger.info("Method :restEditBudgetDepartment ends" + id);
		return restFinancialYearDao.editFinancialYearInfo(id);
	}

	@RequestMapping(value = "financialyear-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restFinancialyearDelete(@RequestParam String id) {
		logger.info("Method : restFinancialyearDelete starts---------------------" + id);

		logger.info("Method :  restFinancialyearDelete ends");
		return restFinancialYearDao.deletefinancialInfo(id);
	}
}
