package nirmalya.aatithya.restmodule.purchase.cotroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionRfqModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorRfqModel;
import nirmalya.aatithya.restmodule.purchase.dao.InventoryVendorRfqDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase/" })
public class InventoryVendorRfqController {
	Logger logger = LoggerFactory.getLogger(InventoryVendorRfqController.class);

	@Autowired
	InventoryVendorRfqDao inventoryVendorRfqDao;

	/*
	 * get all requisition for view
	 */
	@GetMapping(value = "get-vendor-rfq-view-list")
	public List<InventoryActionRfqModel> getVendorRfqViewList(@RequestParam String userId, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getVendorRfqViewList starts");
		logger.info("Method : getVendorRfqViewList endss");
		return inventoryVendorRfqDao.getVendorRfqViewList(userId, org, orgDiv);
	}
	/*
	 * 
	 * PostMapping for add rest ItemRequisition
	 * 
	 * 
	 */

	@PostMapping(value = "rest-add-vendor-rqf")
	public ResponseEntity<JsonResponse<List<InventoryVendorRfqModel>>> restAddRfq(
			@RequestBody List<InventoryVendorRfqModel> restItemRequisitonModel) {
		logger.info("Method : restAddRfq starts");
		logger.info("Method : restAddRfq ends");
		return inventoryVendorRfqDao.restAddRfq(restItemRequisitonModel);
	}

	/*
	 * 
	 * Get mapping for edit Rfq
	 * 
	 * 
	 */
	@GetMapping(value = "get-vendor-rfq-edit")
	public List<InventoryVendorRfqModel> getRfqEdit(@RequestParam String id, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getRfqEdit starts");
		logger.info("Method : getRfqEdit endss");
		return inventoryVendorRfqDao.getVendorRfqEdit(id, userId, org, orgDiv);
	}

	// view

	@RequestMapping(value = "viewVendorRFQData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVendorRFQData(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :viewVendorRFQData start");

		logger.info("Method :viewVendorRFQData endss");
		return inventoryVendorRfqDao.viewVendorRFQData(orgName, orgDivision,userId);

	}
	/*
	 * edit
	 */ @GetMapping(value = "viewRFQVendorEdit")
	public List<RestPurchaseQuotationModel> viewRFQVendorEdit(@RequestParam String id,@RequestParam String orgName,
			@RequestParam String orgDivision ,@RequestParam String userId) {
		logger.info("Method : viewRFQVendorEdit starts");
		logger.info("Method : viewRFQVendorEdit endss");
		return inventoryVendorRfqDao.viewRFQVendorEdit(id,orgName,orgDivision,userId);
	}
}
