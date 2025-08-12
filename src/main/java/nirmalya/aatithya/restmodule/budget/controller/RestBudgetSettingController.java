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

import nirmalya.aatithya.restmodule.budget.dao.RestBudgetSettingDao;
import nirmalya.aatithya.restmodule.budget.model.RestBudgetSettingModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping(value = "budget")
public class RestBudgetSettingController {
	
	Logger logger = LoggerFactory.getLogger(RestBudgetSettingController.class);
	@Autowired
	RestBudgetSettingDao restBudgetSettingDao;
	
	
	@GetMapping(value = "viewBudgetsetting")
	public ResponseEntity<JsonResponse<List<RestBudgetSettingModel>>> viewBudgetSetting(@RequestParam String id) {
		logger.info("Method :viewBudgetSetting starts");

		logger.info("Method :viewBudgetSetting ends" + id);
		return restBudgetSettingDao.viewBudgetSet(id);
	}
	
	//getBudgetFiscalYear

		@RequestMapping(value = "getBudgetFiscalYear", method = { RequestMethod.GET })
		public List<DropDownModel> getFiscalYear() {
			
			logger.info("Method : getBudgetFiscalYear starts");
			logger.info("Method : getBudgetFiscalYear ends");
			
			
			return restBudgetSettingDao.getBudgetFiscalYear();
		}
	
	@RequestMapping(value = "updateBudget", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> updateBudgetSet(
			@RequestBody RestBudgetSettingModel restBudgetSettingModel) {
		logger.info("Method : updateBudget starts");

		logger.info("Method : updateBudget ends");

		return restBudgetSettingDao.updateBudgetSet(restBudgetSettingModel);
	}

}
