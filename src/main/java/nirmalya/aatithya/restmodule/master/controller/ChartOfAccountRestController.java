package nirmalya.aatithya.restmodule.master.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCostCenterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ChartOfAccountDao;
import nirmalya.aatithya.restmodule.master.dao.CostCenterDao;
import nirmalya.aatithya.restmodule.master.model.ChartOfAccountModel;
import nirmalya.aatithya.restmodule.master.model.CostCenterModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class ChartOfAccountRestController {
	Logger logger = LoggerFactory.getLogger(ChartOfAccountRestController.class);
	
	@Autowired
	ChartOfAccountDao chartOfAccountDao;
	@RequestMapping(value = "saveChartOfAccount", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ChartOfAccountModel>> saveChartAccount(@RequestBody ChartOfAccountModel chartOfAccountModel) {
		logger.info("Method : saveCostCenter starts");
		
		logger.info("Method : saveCostCenter ends");
		return chartOfAccountDao.saveChartAccount(chartOfAccountModel);
	}
	
	@RequestMapping(value = "getAllChartAccList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> getAllChartAccList() {
		logger.info("Method : getAllChartAccList starts");
		
		logger.info("Method : getAllChartAccList ends");
		return chartOfAccountDao.getAllChartAccList();
	}
	
	
	@RequestMapping(value = "getCAListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> getCAListById(@RequestParam String id) {
		logger.info("Method : getCAListById starts");
		
		logger.info("Method : getCAListById ends");
		return chartOfAccountDao.getCAListById(id);
	}
	@RequestMapping(value = "deleteCAById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCAById(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteCAById starts");
		
		logger.info("Method : deleteCAById ends");
		return chartOfAccountDao.deleteCAById(id,createdBy);
	}
	
	
	@RequestMapping(value = "saveSubCA", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ChartOfAccountModel>> saveSubCA(@RequestBody ChartOfAccountModel chartOfAccountModel) {
		logger.info("Method : saveSubCostCenter starts");
		
		logger.info("Method : saveSubCostCenter ends");
		return chartOfAccountDao.saveSubCA(chartOfAccountModel);
	}
	
	@RequestMapping(value = "getChartLeafListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> getChartLeafListById(@RequestParam String id) {
		logger.info("Method : getChartLeafListById starts");
		
		logger.info("Method : getChartLeafListById ends");
		return chartOfAccountDao.getChartLeafListById(id);
	}
	
	@RequestMapping(value = "getAllLevel", method = { RequestMethod.GET })
	public List<DropDownModel> getAllLevel() {
		logger.info("Method : getCostNature starts");
		
		logger.info("Method : getAllLevel ends");
		return chartOfAccountDao.getAllLevel();
	}
}
