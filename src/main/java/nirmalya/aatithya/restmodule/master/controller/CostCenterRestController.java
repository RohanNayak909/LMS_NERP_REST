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
import nirmalya.aatithya.restmodule.master.dao.CostCenterDao;
import nirmalya.aatithya.restmodule.master.dao.LocationMasterDao;
import nirmalya.aatithya.restmodule.master.model.CostCenterModel;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class CostCenterRestController {
	
	Logger logger = LoggerFactory.getLogger(CostCenterRestController.class);

	@Autowired
	CostCenterDao costCenterDao;
	@RequestMapping(value = "saveCostCenter", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<CostCenterModel>> saveCostCenter(@RequestBody CostCenterModel costCenterModel) {
		logger.info("Method : saveCostCenter starts");
		
		logger.info("Method : saveCostCenter ends");
		return costCenterDao.saveCostCenter(costCenterModel);
	}
	
	@RequestMapping(value = "getCostNature", method = { RequestMethod.GET })
	public List<DropDownModel> getCostNature() {
		logger.info("Method : getCostNature starts");
		
		logger.info("Method : getCostNature ends");
		return costCenterDao.getCostNature();
	}
	@RequestMapping(value = "getLabourType", method = { RequestMethod.GET })
	public List<DropDownModel> getLabourType() {
		logger.info("Method : getLabourType starts");
		
		logger.info("Method : getLabourType ends");
		return costCenterDao.getLabourType();
	}
	
	@RequestMapping(value = "getAllCostCenterList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CostCenterModel>>> getAllCostCenterList() {
		logger.info("Method : getAllCostCenterList starts");
		
		logger.info("Method : getAllCostCenterList ends");
		return costCenterDao.getAllCostCenterList();
	}
	
	@RequestMapping(value = "getCostCenterListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CostCenterModel>>> getCostCenterListById(@RequestParam String id) {
		logger.info("Method : getCostCenterListById starts");
		
		logger.info("Method : getCostCenterListById ends");
		return costCenterDao.getCostCenterListById(id);
	}
	
	@RequestMapping(value = "saveSubCostCenter", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<CostCenterModel>> saveSubCostCenter(@RequestBody CostCenterModel costCenterModel) {
		logger.info("Method : saveSubCostCenter starts");
		
		logger.info("Method : saveSubCostCenter ends");
		return costCenterDao.saveSubCostCenter(costCenterModel);
	}
	@RequestMapping(value = "getLeafListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CostCenterModel>>> getLeafListById(@RequestParam String id) {
		logger.info("Method : getLeafListById starts");
		
		logger.info("Method : getLeafListById ends");
		return costCenterDao.getLeafListById(id);
	}
	
	@RequestMapping(value = "deleteCostCenter", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCostCenter(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteCostCenter starts");
		
		logger.info("Method : deleteCostCenter ends");
		return costCenterDao.deleteCostCenter(id,createdBy);
	}
	
}
