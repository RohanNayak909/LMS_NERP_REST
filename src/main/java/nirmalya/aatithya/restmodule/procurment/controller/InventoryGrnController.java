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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.dao.InventoryGrnDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryGRNModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryGoodsReturnModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryGrnController {

	Logger logger = LoggerFactory.getLogger(InventoryGrnController.class);

	@Autowired
	InventoryGrnDao inventoryGrnDao;

	/**
	 * for get vendor list
	 */
	@GetMapping(value = "get-delivery-method")
	public List<DropDownModel> getDeliveryMethodList() {
		logger.info("Method : getDeliveryMethodList starts");
		logger.info("Method : getDeliveryMethodList endss");
		return inventoryGrnDao.getDeliveryMethodList();
	}

	/**
	 * get all po for view
	 */
	@GetMapping(value = "get-grn-view-list")
	public List<InventoryGRNModel> getGrnViewList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getGrnViewList starts");
		logger.info("Method : getGrnViewList endss");
		return inventoryGrnDao.getGrnViewList(org,orgDiv);
	}

	/**
	 * PostMapping for add po
	 */

	@PostMapping(value = "rest-add-execute-grn")
	public ResponseEntity<JsonResponse<InventoryGRNModel>> restAddGrn(
			@RequestBody InventoryGRNModel inventoryActionInvoiceModel) {
		logger.info("Method : restAddGrn starts");
		logger.info("Method : restAddGrn ends");
		return inventoryGrnDao.restAddGrn(inventoryActionInvoiceModel);
	}

	/**
	 * Get mapping for edit po
	 */
	@GetMapping(value = "get-grn-edit")
	public InventoryGRNModel geGrnEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : geGrnEdit starts");
		logger.info("Method : geGrnEdit endss");
		return inventoryGrnDao.geGrnEdit(id,org,orgDiv);
	}

	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-complete-grn")
	public ResponseEntity<JsonResponse<Object>> completeGrn(@RequestBody InventoryGRNModel inventoryRfqModel) {
		logger.info("Method : completeGrn starts");
		logger.info("Method : completeGrn ends");
		return inventoryGrnDao.completeGrn(inventoryRfqModel);
	}

	/**
	 * PostMapping for add po
	 */

	@PostMapping(value = "rest-add-grn-return")
	public ResponseEntity<JsonResponse<InventoryGoodsReturnModel>> restAddGrnReturn(
			@RequestBody InventoryGoodsReturnModel inventoryGoodsReturnModel) {
		logger.info("Method : restAddGrnReturn starts");
		logger.info("Method : restAddGrnReturn ends");
		return inventoryGrnDao.restAddGrnReturn(inventoryGoodsReturnModel);
	}
}
