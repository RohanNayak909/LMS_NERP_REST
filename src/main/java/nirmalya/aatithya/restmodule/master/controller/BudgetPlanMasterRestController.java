package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.BudgetPlanMasterDao;
import nirmalya.aatithya.restmodule.master.model.BudgetPlanMasterModel;
import nirmalya.aatithya.restmodule.master.model.CCAccountMapModel;
import nirmalya.aatithya.restmodule.master.model.FiscalYearModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class BudgetPlanMasterRestController {

	Logger logger = LoggerFactory.getLogger(BudgetPlanMasterRestController.class);

	@Autowired
	BudgetPlanMasterDao budgetPlanMasterDao;
	
	@RequestMapping(value = "getYearList", method = { RequestMethod.GET })
	public List<DropDownModel> getYearList() {
		logger.info("Method : getYearList starts");
		
		logger.info("Method : getYearList ends");
		return budgetPlanMasterDao.getYearList();
	}
	
	@RequestMapping(value = "saveBudgetPlanYear", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<FiscalYearModel>> saveBudgetPlanYear(@RequestBody FiscalYearModel yearDtls) {
		logger.info("Method : saveBudgetPlanYear starts");
		
		logger.info("Method : saveBudgetPlanYear ends");
		return budgetPlanMasterDao.saveBudgetPlanYear(yearDtls);
	}
	
	@RequestMapping(value = "getYearDataList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<FiscalYearModel>>> getYearDataList() {
		logger.info("Method : getYearDataList starts");
		
		logger.info("Method : getYearDataList ends");
		return budgetPlanMasterDao.getYearDataList();
	}
	
	@RequestMapping(value = "getCCAccountDataList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CCAccountMapModel>>> getCCAccountDataList(@RequestParam String id, @RequestParam String mnth) {
		logger.info("Method : getCCAccountDataList starts");
		
		logger.info("Method : getCCAccountDataList ends");
		return budgetPlanMasterDao.getCCAccountDataList(id,mnth);
	}
	
	@RequestMapping(value = "getChartAccountDetails", method = { RequestMethod.GET })
	public List<CCAccountMapModel> getChartAccountDetails(@RequestParam String id,@RequestParam String year,@RequestParam String mnth) {
		logger.info("Method : getChartAccountDetails starts");
		
		logger.info("Method : getChartAccountDetails ends");
		return budgetPlanMasterDao.getChartAccountDetails(id,year,mnth);
	}
	
	@RequestMapping(value = "saveBudgetPlanDtls", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveBudgetPlanDtls(@RequestBody List<BudgetPlanMasterModel> budgetPlanDtls) {
		logger.info("Method : saveBudgetPlanDtls starts");
		
		logger.info("Method : saveBudgetPlanDtls ends");
		return budgetPlanMasterDao.saveBudgetPlanDtls(budgetPlanDtls);
	}
}
