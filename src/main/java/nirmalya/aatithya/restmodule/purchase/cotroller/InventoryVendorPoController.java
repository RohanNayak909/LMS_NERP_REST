package nirmalya.aatithya.restmodule.purchase.cotroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryPoModel;
import nirmalya.aatithya.restmodule.purchase.dao.InventoryVendorPoDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase/" })
public class InventoryVendorPoController {
	Logger logger = LoggerFactory.getLogger(InventoryVendorPoController.class);

	@Autowired
	InventoryVendorPoDao inventoryVendorPoDao;

	/**
	 * get all po for view
	 */
	@GetMapping(value = "get-vendor-po-view-list")
	public List<InventoryPoModel> getVendorPoViewList(@RequestParam String userId, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getVendorPoViewList starts");
		logger.info("Method : getVendorPoViewList endss");
		return inventoryVendorPoDao.getVendorPoViewList(userId, org, orgDiv);
	}

	@RequestMapping(value = "rest-viewPurchaseOrderForVendor", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> viewPurchaseOrderForVendor(
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String userId) {

		logger.info("Method :viewPurchaseOrderForVendor starts");

		logger.info("Method :viewPurchaseOrderForVendor endss");
		return inventoryVendorPoDao.viewPurchaseOrderForVendor(orgName, orgDivision, userId);

	}
	
	@GetMapping(value = "approvePorderForVendor")
	public JsonResponse<DropDownModel> approvePorderForVendor(@RequestParam String approveStatus, String poId, String orgName,
			String orgDivision , String userId) {
		logger.info("Method : approvePorderForVendor starts");

		logger.info("Method : approvePorderForVendor ends");
		return inventoryVendorPoDao.approvePorderForVendor(approveStatus, poId, orgName, orgDivision,userId);
	}
	
	@GetMapping(value = "rejectPorderForVendor")
	public JsonResponse<DropDownModel> rejectPorderForVendor(@RequestParam String rejectStatus, String poId, String orgName,
			String orgDivision , String userId) {
		logger.info("Method : rejectPorderForVendor starts");

		logger.info("Method : rejectPorderForVendor ends");
		return inventoryVendorPoDao.rejectPorderForVendor(rejectStatus, poId, orgName, orgDivision,userId);
	}
	

	@GetMapping(value = "getdeliverychallandata")
	public List<RestPurchaseOrderModel> getdeliverychallandata(@RequestParam String id, String sku, String gatePass, String org,
			String orgDiv) {
		logger.info("Method : getdeliverychallandata starts");
		logger.info("Method : getdeliverychallandata endss");
		return inventoryVendorPoDao.getdeliverychallandata(id, sku, gatePass, org, orgDiv);
	}
	
	
	/*
	 * edit
	 */ @GetMapping(value = "viewPoEditForVendor")
	public List<RestPurchaseOrderModel> viewPoEditForVendor(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewPoEditForVendor starts");
		// logger.info(id);
		logger.info("Method : viewPoEditForVendor endss");
		return inventoryVendorPoDao.viewPoEditForVendor(id, org, orgDiv);
	}
	 
	 
	
	
}
