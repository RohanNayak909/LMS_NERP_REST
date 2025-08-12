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
import nirmalya.aatithya.restmodule.procurment.dao.InventoryVendorInvoiceDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionInvoiceModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryVendorInvoiceController {
	Logger logger = LoggerFactory.getLogger(InventoryVendorInvoiceController.class);

	@Autowired
	InventoryVendorInvoiceDao inventoryVendorInvoiceDao;

	/**
	 * get all po for view
	 */
	@GetMapping(value = "get-vendor-invoice-view-list")
	public List<InventoryActionInvoiceModel> getInvoiceViewList(@RequestParam String vendorId,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getInvoiceViewList starts");
		logger.info("Method : getInvoiceViewList endss");
		return inventoryVendorInvoiceDao.getInvoiceViewList(vendorId,org,orgDiv);
	}

	/**
	 * PostMapping for add po
	 */

	@PostMapping(value = "rest-add-dn")
	public ResponseEntity<JsonResponse<InventoryActionInvoiceModel>> restAddDn(
			@RequestBody InventoryActionInvoiceModel inventoryActionInvoiceModel) {
		logger.info("Method : restAddDn starts");
		logger.info("Method : restAddDn ends");
		return inventoryVendorInvoiceDao.restAddDn(inventoryActionInvoiceModel);
	}
}
