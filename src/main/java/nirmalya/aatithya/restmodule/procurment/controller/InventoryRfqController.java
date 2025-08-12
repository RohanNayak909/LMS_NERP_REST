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
import nirmalya.aatithya.restmodule.procurment.dao.InventoryRfqDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRfqModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRfqVendorModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryRfqController {
	Logger logger = LoggerFactory.getLogger(InventoryRfqController.class);

	@Autowired
	InventoryRfqDao inventoryRfqDao;
	/*
	 * get all requisition for view
	 */
	@GetMapping(value = "get-vendor-view-list")
	public List<InventoryRfqVendorModel> getVendorList(@RequestParam String org, String orgDiv) {
		logger.info("Method : getVendorList starts");
		logger.info("Method : getVendorList endss");
		return inventoryRfqDao.getVendorList(org,orgDiv);
	}
	
	/*
	 * 
	 * PostMapping for add rest ItemRequisition
	 * 
	 * 
	 */
	 
	@PostMapping(value = "rest-add-rqf")
	public ResponseEntity<JsonResponse<List<InventoryRfqModel>>> restAddRfq(
			@RequestBody List<InventoryRfqModel> restItemRequisitonModel) {
		logger.info("Method : restAddRfq starts"+restItemRequisitonModel);
		logger.info("Method : restAddRfq ends");
		return inventoryRfqDao.restAddRfq(restItemRequisitonModel);
		
	}
	
	/*
	 * get all requisition for view
	 */
	@GetMapping(value = "get-rfq-view-list")
	public List<InventoryRfqModel> getRfqViewList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getRfqViewList starts");
		logger.info("Method : getRfqViewList endss");
		return inventoryRfqDao.getRfqViewList(org,orgDiv);
	}
	
	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-delete-rfq")
	public ResponseEntity<JsonResponse<Object>> restDeleteRfq(
			@RequestBody InventoryRfqModel inventoryRfqModel) {
		logger.info("Method : restDeleteRfq starts");
		logger.info("Method : restDeleteRfq ends");
		return inventoryRfqDao.restDeleteRfq(inventoryRfqModel);
	}

	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-approve-rfq")
	public ResponseEntity<JsonResponse<Object>> restApproveRfq(
			@RequestBody InventoryRfqModel inventoryRfqModel) {
		logger.info("Method : restApproveRfq starts");
		logger.info("Method : restApproveRfq ends");
		return inventoryRfqDao.restApproveRfq(inventoryRfqModel);
	}
	
	/*
	 * 
	 * Get mapping for edit Rfq
	 * 
	 * 
	 */
	@GetMapping(value = "get-rfq-edit")
	public List<InventoryRfqModel> getRfqEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getRfqEdit starts");
		logger.info("Method : getRfqEdit endss");
		return inventoryRfqDao.getRfqEdit(id,org,orgDiv);
	}
}
