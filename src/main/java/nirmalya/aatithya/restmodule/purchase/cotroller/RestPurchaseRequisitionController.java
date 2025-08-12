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
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.purchase.dao.PurchaseRequisitionDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;

@RestController
@RequestMapping(value = { "purchase/" })
public class RestPurchaseRequisitionController {
	Logger logger = LoggerFactory.getLogger(RestPurchaseRequisitionController.class);

	@Autowired
	PurchaseRequisitionDao purchaseRequisitionDao;

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	/*
	 * add
	 */
	@PostMapping(value = "addRequisitionDetails")
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> addRequisitionDetails(
			@RequestBody List<RestPurchaseIndentModel> restPurchaseModel) {
		logger.info("Method :addRequisitionDetails starts");

		logger.info("Method :addRequisitionDetails endss");
		return purchaseRequisitionDao.addRequisitionDetails(restPurchaseModel);
	}

	/*
	 * view
	 */
	@RequestMapping(value = "rest-viewRequisitionDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> viewRequisitionDetails(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewRequisitionDetails starts");

		logger.info("Method :viewRequisitionDetails endss");
		return purchaseRequisitionDao.viewRequisitionDetails(org, orgDiv);

	}

	/*
	 * edit
	 */
	@GetMapping(value = "viewPurchaseRequisitionEdit")
	public List<RestPurchaseIndentModel> viewPurchaseRequisitionEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewPurchaseRequisitionEdit starts");
		// logger.info(id);
		logger.info("Method : viewPurchaseRequisitionEdit endss");
		return purchaseRequisitionDao.viewPurchaseRequisitionEdit(id, org, orgDiv);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteRequisitionDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRequisitionDetails(@RequestParam String id) {
		logger.info("Method : deleteRequisitionDetails starts");

		logger.info("Method : deleteRequisitionDetails ends");
		return purchaseRequisitionDao.deleteRequisitionDetails(id);
	}

	@GetMapping(value = "approveRequisitionDetails")
	public JsonResponse<DropDownModel> approveRequisitionDetails(@RequestParam String approveStatus, String reqId,
			String orgName, String orgDivision) {
		logger.info("Method : approveRequisitionDetails starts");

		logger.info("Method : approveRequisitionDetails ends");
		return purchaseRequisitionDao.approveRequisitionDetails(approveStatus, reqId, orgName, orgDivision);
	}

	@RequestMapping(value = "ProjectList", method = { RequestMethod.GET })
	public List<DropDownModel> ProjectList(@RequestParam String organization, String orgDivision) {
		logger.info("Method : ProjectList starts");

		logger.info("Method : ProjectList ends");
		return purchaseRequisitionDao.ProjectList(organization, orgDivision);
	}
	

	/*
	 * view
	 */
	@RequestMapping(value = "rest-viewRequisitionDetailsForPurchase", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRequisitionDetailsForPurchase(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewRequisitionDetailsForPurchase starts");

		logger.info("Method :viewRequisitionDetailsForPurchase endss");
		return purchaseRequisitionDao.viewRequisitionDetailsForPurchase(org, orgDiv);

	}
	
	
	
	@PostMapping(value = "rest-addRequisitionMasterFile")
	public ResponseEntity<JsonResponse<Object>> addRequisitionMasterFile(
			@RequestBody List<RestPurchaseIndentModel> modeldata) {
		logger.info("Method : addRequisitionMasterFile starts");

		logger.info("Method : addRequisitionMasterFile ends");
		return purchaseRequisitionDao.addRequisitionMasterFile(modeldata);
	}

	@GetMapping(value = "getRequisitionData")
	public List<RestPurchaseIndentModel> getRequisitionData(@RequestParam String sku,String id , String org,String orgDiv) {
		logger.info("Method : getRequisitionData starts");
		logger.info("Method : getRequisitionData endss");
		return purchaseRequisitionDao.getRequisitionData(sku,id, org, orgDiv);
	}
	
	// Material Issue
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "getMaterialIssueData")
	public JsonResponse getMaterialIssueData(@RequestParam String sku, String reqId, String org,
			String orgDiv) {
		logger.info("Method : getMaterialIssueData starts");
		
		logger.info("Method : getMaterialIssueData endss");
		return purchaseRequisitionDao.getMaterialIssueData(sku, reqId, org, orgDiv );
	}
	@GetMapping(value = "getStoreItemQuotationAutoSearchListForItem")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getStoreItemQuotationAutoSearchListForItem(
			@RequestParam String id,String type,String org, String orgDiv) {
		logger.info("Method : getStoreItemQuotationAutoSearchListForItem starts");

		logger.info("Method :getStoreItemQuotationAutoSearchListForItem endss");
		return purchaseRequisitionDao.getStoreItemQuotationAutoSearchListForItem(id,type, org, orgDiv);
	}
	

	
}
