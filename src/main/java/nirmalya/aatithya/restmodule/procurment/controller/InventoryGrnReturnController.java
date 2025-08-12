package nirmalya.aatithya.restmodule.procurment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.dao.InventoryGrnreturnDao; 
import nirmalya.aatithya.restmodule.procurment.model.InventoryGoodsReturnModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryGrnReturnController {
	Logger logger = LoggerFactory.getLogger(InventoryGrnReturnController.class);

	@Autowired
	InventoryGrnreturnDao inventoryGrnreturnDao;

	/**
	 * get all po for view
	 */
	@GetMapping(value = "get-grn-return-view-list")
	public List<InventoryGoodsReturnModel> getGrnViewList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getGrnViewList starts");
		logger.info("Method : getGrnViewList endss");
		return inventoryGrnreturnDao.getGrnViewList(org, orgDiv);
	}

	/**
	 * Get mapping for edit po
	 */
	@GetMapping(value = "get-grn-return-edit")
	public InventoryGoodsReturnModel getGrnReturnEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getGrnReturnEdit starts");
		logger.info("Method : geGrnReturnEdit endss");
		return inventoryGrnreturnDao.getGrnReturnEdit(id,org,orgDiv);
	}
	
	/**
	 * PostMapping for add po
	 */

	@PostMapping(value = "rest-modify-grn-return")
	public ResponseEntity<JsonResponse<InventoryGoodsReturnModel>> restModifyGrn(
			@RequestBody InventoryGoodsReturnModel inventoryGoodsReturnModel) {
		logger.info("Method : restAddGrnReturn starts");
		logger.info("Method : restAddGrnReturn ends");
		return inventoryGrnreturnDao.restModifyGrn(inventoryGoodsReturnModel);
	}
	
	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-complete-grn-return")
	public ResponseEntity<JsonResponse<Object>> completeGrnReturn(@RequestBody InventoryGoodsReturnModel inventoryRfqModel) {
		logger.info("Method : completeGrnReturn starts");
		logger.info("Method : completeGrnReturn ends");
		return inventoryGrnreturnDao.completeGrn(inventoryRfqModel);
	}
}
