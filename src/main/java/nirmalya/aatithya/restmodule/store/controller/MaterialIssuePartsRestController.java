package nirmalya.aatithya.restmodule.store.controller;

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
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;
import nirmalya.aatithya.restmodule.store.dao.RestMaterialIssueDao;
import nirmalya.aatithya.restmodule.store.model.MaterialIssueDetailsRestModel;

@RestController
@RequestMapping(value = "master/")
public class MaterialIssuePartsRestController {

	Logger logger = LoggerFactory.getLogger(MaterialIssuePartsRestController.class);
	@Autowired
	RestMaterialIssueDao restMaterialIssueDao;

	@GetMapping(value = "rest-getIndentNameAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIndentNameAutoSearch(@RequestParam String id
			) {
		logger.info("Method : getIndentNameAutoSearch starts");

		logger.info("Method :getIndentNameAutoSearch endss");
		return restMaterialIssueDao.getIndentNameAutoSearch(id);
	}

	// budget view
	@RequestMapping(value = "rest-view-items", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>> getItemDetails(@RequestParam String id
			,@RequestParam String projectId) {
		logger.info("Method: restViewCustDtls View Start");

		logger.info("Method: restViewCustDtls ends");
		return restMaterialIssueDao.getItemDetailsDao(id,projectId);
	}

	// edit budget
	@GetMapping(value = "rest-edit-child")
	public ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>> childEdit(@RequestParam String id) {
		logger.info("Method :childEdit starts");

		logger.info("Method :childEdit ends" + id);
		return restMaterialIssueDao.childEdit(id);

	}

/*	@PostMapping(value = "rest-issue-add")
	public ResponseEntity<JsonResponse<Object>> addIssue(@RequestBody MaterialIssueDetailsRestModel budget) {
		logger.info("Method : estimateBudgetAdd starts");
		System.out.println("rest addBudget ======================" + budget);

		logger.info("Method : estimateBudgetAdd ends");
		return restMaterialIssueDao.addIssue(budget);
	}*/
	//
	@RequestMapping(value = "rest-issue-add", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addProductDetails(
			@RequestBody List<MaterialIssueDetailsRestModel> productBeheraModel) {
		logger.info("Method : addProductDetails starts");
		logger.info("Method : addProductDetails ends");
		return restMaterialIssueDao.addIssue(productBeheraModel);
	}


	// budget view
	@RequestMapping(value = "rest-issue-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewIssue(@RequestParam String org, String orgDiv) {
		logger.info("Method: viewIssue View Start");

		logger.info("Method: viewIssue ends");
		return restMaterialIssueDao.viewIssue(org, orgDiv);
	}

	/*
	 * @RequestMapping(value = "rest-issueEdit", method = { RequestMethod.GET })
	 * public ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>>
	 * issueEdit(@RequestParam String id) {
	 * logger.info("Method: issueEdit View Start");
	 * 
	 * logger.info("Method: issueEdit ends"); return
	 * restMaterialIssueDao.issueEdit(id); }
	 */
	
	@GetMapping(value = "rest-issueEdit")
	public JsonResponse<Object> issueEdit(@RequestParam String id) {
		logger.info("Method :issueEdit starts");

		logger.info("Method :issueEdit ends" + id);
		return restMaterialIssueDao.issueEdit(id);

	}

	@GetMapping(value = "getVendorAutoSearch")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> getVendorAutoSearch(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getVendorAutoSearch starts");

		logger.info("Method :getVendorAutoSearch endss");
		return restMaterialIssueDao.getVendorAutoSearch(id, org, orgDiv);
	}
	
	// Emp List DropDown.
	
	@RequestMapping(value = "employeeList", method = { RequestMethod.GET })
	public List<DropDownModel> employeeList(@RequestParam String organization, String orgDivision) {
		logger.info("Method : employeeList starts");

		logger.info("Method : employeeList ends");
		return restMaterialIssueDao.employeeList(organization, orgDivision);
	}
	// Delete
	@GetMapping(value = "rest-deleteIssue")
	public JsonResponse<Object> deleteIssue(@RequestParam String id,String org, String orgDiv) {
		logger.info("Method :deleteIssue starts");

		logger.info("Method :deleteIssue ends");
		return restMaterialIssueDao.deleteIssue(id,org,orgDiv);

	}
	
	//Approve
	
	@GetMapping(value = "rest-approveIssue")
	public JsonResponse<Object> approveIssue(@RequestParam String id,String org, String orgDiv, String userId) {
		logger.info("Method :approveIssue starts");

		logger.info("Method :approveIssue ends");
		return restMaterialIssueDao.approveIssue(id,org,orgDiv,userId);

	}
	
	// Add Material Return Quantity.
	
	@RequestMapping(value = "rest-add-return", method = { RequestMethod.GET })
	public JsonResponse<Object> addReturn(@RequestParam String org, String orgDiv, String slipNo, String returnQuant, String returnRemark, String sku) {
		logger.info("Method: addReturn View Start");

		logger.info("Method: addReturn ends");
		return restMaterialIssueDao.addReturn(org, orgDiv, slipNo, returnQuant, returnRemark, sku);
	}
	
	// Stock Quantity.
	
	@RequestMapping(value = "rest-viewStockQuantity", method = { RequestMethod.GET })
	public JsonResponse<Object> viewStockQuantity(@RequestParam String org, String orgDiv, String sku) {
		logger.info("Method: viewStockQuantity View Start");

		logger.info("Method: viewStockQuantity ends");
		return restMaterialIssueDao.viewStockQuantity(org, orgDiv, sku);
	}
	
	@GetMapping(value = "getItemQuotationAutoSearchNewListForMI")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemQuotationAutoSearchNewListForMI(
			@RequestParam String id,String org, String orgDiv) {
		logger.info("Method : getItemQuotationAutoSearchNewListForMI starts");

		logger.info("Method :getItemQuotationAutoSearchNewListForMI endss");
		return restMaterialIssueDao.getItemQuotationAutoSearchNewListForMI(id, org, orgDiv);
	}
	
	// Excel Download
	
	@GetMapping(value = "rest-downloadExcel")
	public JsonResponse<Object> downloadExcel(@RequestParam String org, String orgDiv) {
		logger.info("Method :downloadExcel starts");

		logger.info("Method :downloadExcel ends");
		return restMaterialIssueDao.downloadExcel(org, orgDiv);

	}


}
