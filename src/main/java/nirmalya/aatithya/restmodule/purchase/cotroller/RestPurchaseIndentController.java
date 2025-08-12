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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;
import nirmalya.aatithya.restmodule.purchase.dao.PurchaseIndentDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase" })
public class RestPurchaseIndentController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseIndentController.class);
	@Autowired
	PurchaseIndentDao purchaseIndentDao;

	/*
	 * add
	 */
	@PostMapping(value = "addIndentDetails")
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> addIndentDetails(
			@RequestBody List<RestPurchaseIndentModel> restPurchaseModel) {
		logger.info("Method :addIndentDetails starts");

		logger.info("Method :addIndentDetails endss");
		return purchaseIndentDao.addIndentDetails(restPurchaseModel);
	}

	/*
	 * view
	 */
	@RequestMapping(value = "rest-viewIndentDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> viewIndentDetails(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewIndentDetails starts");

		logger.info("Method :viewIndentDetails endss");
		return purchaseIndentDao.viewIndentDetails(org, orgDiv);

	}

	/*
	 * edit
	 */
	@GetMapping(value = "viewPurchaseIndentEdit")
	public List<RestPurchaseIndentModel> viewPurchaseIndentEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewPurchaseIndentEdit starts");
		// logger.info(id);
		logger.info("Method : viewPurchaseIndentEdit endss");
		return purchaseIndentDao.viewPurchaseIndentEdit(id, org, orgDiv);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteIndentDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIndentDetails(@RequestParam String id) {
		logger.info("Method : deleteIndentDetails starts");

		logger.info("Method : deleteIndentDetails ends");
		return purchaseIndentDao.deleteIndentDetails(id);
	}

	@GetMapping(value = "approveIndentDetails")
	public JsonResponse<DropDownModel> approveIndentDetails(@RequestParam String approveStatus, String indentId,
			String orgName, String orgDivision) {
		logger.info("Method : approveIndentDetails starts");

		logger.info("Method : approveIndentDetails ends");
		return purchaseIndentDao.approveIndentDetails(approveStatus, indentId, orgName, orgDivision);
	}

	@PostMapping(value = "addFeedBackDetails")
	public JsonResponse<Object> addFeedBackDetails(@RequestBody RestPurchaseIndentModel restPurchaseIndentModel) {
		logger.info("Method :addFeedBackDetails starts");

		logger.info("Method : addFeedBackDetails ends");
		return purchaseIndentDao.addFeedBackDetails(restPurchaseIndentModel);
	}
	
	/*
	 * view
	 */
	@RequestMapping(value = "rest-viewIndentDetailsForPurchase", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> viewIndentDetailsForPurchase(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewIndentDetailsForPurchase starts");

		logger.info("Method :viewIndentDetailsForPurchase endss");
		return purchaseIndentDao.viewIndentDetailsForPurchase(org, orgDiv);

	}
	
	@GetMapping(value = "getIndentdataForRFQ")
	public List<RestPurchaseIndentModel> getIndentdataForRFQ(@RequestParam String sku,String id , String org,String orgDiv) {
		logger.info("Method : getIndentdataForRFQ starts");
		logger.info("Method : getIndentdataForRFQ endss");
		return purchaseIndentDao.getIndentdataForRFQ(sku,id, org, orgDiv);
	}

}
