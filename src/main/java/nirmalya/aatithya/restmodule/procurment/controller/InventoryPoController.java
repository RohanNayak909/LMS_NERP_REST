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
import nirmalya.aatithya.restmodule.procurment.dao.InventoryPoDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryPoModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryPoController {
	Logger logger = LoggerFactory.getLogger(InventoryPoController.class);

	@Autowired
	InventoryPoDao inventoryPoDao;

	/* Get mapping for get Payment Term */
	@GetMapping(value = "get-Payment-term")
	public List<DropDownModel> getPaymentTerm() {
		logger.info("Method : getPaymentTerm starts");
		logger.info("Method : getPaymentTerm endss");
		return inventoryPoDao.getPaymentTerm();
	}

	/* Get mapping for get Payment Term */
	@GetMapping(value = "get-legal-term")
	public List<DropDownModel> getLegalTerm() {
		logger.info("Method : getLegalTerm starts");
		logger.info("Method : getLegalTerm endss");
		return inventoryPoDao.getLegalTerm();
	}

	/* get vendor list */
	@GetMapping(value = "get-vendor-master")
	public List<DropDownModel> getVendorList() {
		logger.info("Method : getVendorList starts");
		logger.info("Method : getVendorList endss");
		return inventoryPoDao.getVendorList();
	}

	/**
	 * PostMapping for add po
	 */

	@PostMapping(value = "rest-add-po")
	public ResponseEntity<JsonResponse<InventoryPoModel>> restAddPo(@RequestBody InventoryPoModel inventoryPoModel) {
		logger.info("Method : restAddPo starts");
		logger.info("Method : restAddPo ends");
		return inventoryPoDao.restAddPo(inventoryPoModel);
	}

	/**
	 * get all po for view
	 */
	@GetMapping(value = "get-po-view-list")
	public List<InventoryPoModel> getPoViewList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getPoViewList starts");
		logger.info("Method : getPoViewList endss");
		return inventoryPoDao.getPoViewList(org, orgDiv);
	}

	/**
	 * PostMapping for approve Po
	 */
	@PostMapping(value = "rest-approve-po")
	public ResponseEntity<JsonResponse<Object>> restApprovePo(@RequestBody InventoryPoModel inventoryPoModel) {
		logger.info("Method : restApprovePo starts");
		logger.info("Method : restApprovePo ends");
		return inventoryPoDao.restApprovePo(inventoryPoModel);
	}

	/**
	 * Get mapping for edit po
	 */
	@GetMapping(value = "get-po-edit")
	public InventoryPoModel gePoEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : gePoEdit starts");
		logger.info("Method : gePoEdit endss");
		return inventoryPoDao.gePoEdit(id,org,orgDiv);
	}
	/**
	 * PostMapping for approve Po
	 */
	@PostMapping(value = "rest-delete-po")
	public ResponseEntity<JsonResponse<Object>> restDeletePo(@RequestBody InventoryPoModel inventoryPoModel) {
		logger.info("Method : restDeletePo starts");
		logger.info("Method : restDeletePo ends");
		return inventoryPoDao.restDeletePo(inventoryPoModel);
	}
}
