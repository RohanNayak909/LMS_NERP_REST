package nirmalya.aatithya.restmodule.budget.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nirmalya.aatithya.restmodule.account.model.RestManageCurrencyModel;
import nirmalya.aatithya.restmodule.budget.dao.RestBudgetCurrencyDao;
import nirmalya.aatithya.restmodule.budget.model.RestBudgetCurrencyModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Controller
@RequestMapping(value = { "budget/" })
public class RestBudgetCurrencyController {
	
	Logger logger = LoggerFactory.getLogger(RestBudgetCurrencyController.class);
	@Autowired
	RestBudgetCurrencyDao restBudgetCurrencyDao;

	@RequestMapping(value = "restaddcurrency", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addIncentive(@RequestBody RestBudgetCurrencyModel curencyDetails) {
		logger.info("Method : addrestCurrency starts");

		logger.info("Method : addrestCurrency  ends");

		return restBudgetCurrencyDao.addManageCurrency(curencyDetails);
	}
	
	
	@RequestMapping(value = "restBudgetViewCurrency", method = { RequestMethod.GET })
	public @ResponseBody JsonResponse<Object> viewCurrency(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewCurrency start");

		logger.info("Method :viewCurrency endss");
		return restBudgetCurrencyDao.viewBudgetCurrency(orgName, orgDivision);
	}
	
	
	@GetMapping(value = "edit-Currency-Info")
	public ResponseEntity<JsonResponse<List<RestBudgetCurrencyModel>>> editrestViewcurencyDetailsInfo(

			
	@RequestParam String id) {
		logger.info("Method :editCurrencyMemberInfo starts");

		logger.info("Method :editCurrencyMemberInfo ends" + id);
		return restBudgetCurrencyDao.editCurrency(id);

	}
	@RequestMapping(value = "delete-currency-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleterestViewcurencyDetails(@RequestParam String id) {
		logger.info("Method : deleteclubmemberDetails starts" + id);

		logger.info("Method :  deleteclubmemberDetails ends");
		return restBudgetCurrencyDao.deletecurrencyMemberDetails(id);
	}

}
