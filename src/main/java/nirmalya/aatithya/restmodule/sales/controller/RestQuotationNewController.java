package nirmalya.aatithya.restmodule.sales.controller;

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
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.sales.dao.RestQuotationDao;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;
import nirmalya.aatithya.restmodule.sales.model.ScopeMatrixRestModel;

@RestController
@RequestMapping("sales/")
public class RestQuotationNewController {
	Logger logger = LoggerFactory.getLogger(RestQuotationNewController.class);

	@Autowired

	RestQuotationDao RestQuotationDao;

	@GetMapping(value = "getSalesPersonListByAutoSearch")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> getSalesPersonListByAutoSearch(
			@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getSalesPersonListByAutoSearch starts");

		logger.info("Method :getSalesPersonListByAutoSearch endss");
		return RestQuotationDao.getSalesPersonListByAutoSearch(id, org, orgDiv);
	}

	@RequestMapping(value = "getProjectAutoSearchList", method = { RequestMethod.GET })
	public List<DropDownModel> getProjectAutoSearchList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getProjectAutoSearchList starts");

		logger.info("Method : getProjectAutoSearchList ends");
		return RestQuotationDao.getProjectAutoSearchList(org, orgDiv);
	}
	
	@RequestMapping(value = "get-bom-item-list", method = { RequestMethod.GET })
	public List<DropDownModel> getBomItemList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getBomItemList starts");
		
		logger.info("Method : getBomItemList ends");
		return RestQuotationDao.getBomItemList(org, orgDiv);
	}

	@RequestMapping(value = "rest-getAllquotation", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllquotation(@RequestParam String orgName, @RequestParam String orgDivision,
			String pageno, String userId,String fDate,String tDate) {
		logger.info("Method :getAllquotation start");

		logger.info("Method :getAllquotation endss");
		return RestQuotationDao.getAllquotation(orgName, orgDivision, pageno, userId,fDate,tDate);

	}

	// View Draft
	@PostMapping(value = "viewquotationDraft")
	public JsonResponse<List<RestQuotationNewModel>> viewquotationDraft(@RequestBody EmpRoleModel empModel) {
		logger.info("Method :viewquotationDraft starts");
		String userId = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();

		logger.info("Method :viewquotationDraft endss");
		return RestQuotationDao.viewquotationDraft(userId, organization, orgDivision);

	}

	@GetMapping(value = "getAllquotationItem")
	public JsonResponse<List<RestQuotationNewModel>> getAllquotationItem() {
		logger.info("Method :getAllquotationItem starts");

		logger.info("Method :getAllquotationItem endss");
		return RestQuotationDao.getAllquotationItem();

	}

	@GetMapping(value = "getCustomerListByAutoSearch")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> getCustomerListByAutoSearch(
			@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getCustomerListByAutoSearch starts");

		logger.info("Method :getCustomerListByAutoSearch endss");
		return RestQuotationDao.getCustomerListByAutoSearch(id, org, orgDiv);
	}

	@GetMapping(value = "getItemQuotationAutoSearchListForItem")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemQuotationAutoSearchListForItem(
			@RequestParam String id) {
		logger.info("Method : getItemQuotationAutoSearchListForItem starts");

		logger.info("Method :getItemQuotationAutoSearchListForItem endss");
		return RestQuotationDao.getItemQuotationAutoSearchListForItem(id);
	}

	@PostMapping(value = "addquotationnew")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> addquotationnew(
			@RequestBody List<RestQuotationNewModel> restQuotationNewModel) {
		logger.info("Method :addquotationnew starts");

		logger.info("Method :addquotationnew endss");
		return RestQuotationDao.addquotationnew(restQuotationNewModel);
	}

	@PostMapping(value = "addquotationdraft")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> addquotationdraft(
			@RequestBody List<RestQuotationNewModel> restQuotationNewModel) {
		logger.info("Method :addquotationdraft starts");

		logger.info("Method :addquotationdraft endss");
		return RestQuotationDao.addquotationdraft(restQuotationNewModel);
	}

	// get product category list
	@GetMapping(value = "rest-getProductCategoryListModalQuot")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryListModalQuot() {
		logger.info("Method : getProductCategoryListModalQuot starts");

		logger.info("Method : getProductCategoryListModalQuot ends");
		return RestQuotationDao.getProductCategoryListModalQuot();
	}

	@GetMapping(value = "getProductsByCat")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getProductsByCat(@RequestParam String id) {
		logger.info("Method in rest: getProductsByCat starts");
		// logger.info(id);
		logger.info("Method in rest: getProductsByCat ends");
		return RestQuotationDao.getProductsByCat(id);
	}

	@GetMapping(value = "viewQuotationEdit")
	public List<RestQuotationNewModel> viewQuotationEdit(@RequestParam String id) {
		logger.info("Method : viewQuotationEdit starts");

		logger.info("Method : viewQuotationEdit endss");
		return RestQuotationDao.viewQuotationEdit(id);
	}

	// Edit draft
	@GetMapping(value = "viewQuotationDraftEdit")
	public List<RestQuotationNewModel> viewQuotationDraftEdit(@RequestParam String draftId) {
		logger.info("Method : viewQuotationDraftEdit starts");

		logger.info("Method : viewQuotationDraftEdit endss");
		return RestQuotationDao.viewQuotationDraftEdit(draftId);
	}

//viewQuotationGetOrder
	@GetMapping(value = "viewQuotationGetOrder")
	public List<RestQuotationNewModel> viewQuotationGetOrder(@RequestParam String id) {
		logger.info("Method : viewQuotationGetOrder starts");

		logger.info("Method : viewQuotationGetOrder endss");
		return RestQuotationDao.viewQuotationGetOrder(id);
	}

	@PostMapping(value = "deleteItemQuotation")
	public ResponseEntity<JsonResponse<Object>> deleteItemQuotation(

			@RequestBody RestQuotationNewModel restQuotationNewModel) {
		logger.info("Method : deleteItemQuotation starts");
		logger.info(restQuotationNewModel.toString());
		logger.info("Method : deleteItemQuotation ends");
		return RestQuotationDao.deleteItemQuotation(restQuotationNewModel);
	}

	@PostMapping(value = "deleteDraft")
	public ResponseEntity<JsonResponse<Object>> deleteDraft(

			@RequestBody RestQuotationNewModel restQuotationNewModel) {
		logger.info("Method : deleteDraft starts");
		logger.info(restQuotationNewModel.toString());
		logger.info("Method : deleteDraft ends");
		return RestQuotationDao.deleteDraft(restQuotationNewModel);
	}

	@PostMapping(value = "addpoNo")
	public ResponseEntity<JsonResponse<Object>> addpoNo(@RequestBody RestQuotationNewModel quotationNewModel) {
		logger.info("Method :addpoNo starts");
		logger.info(quotationNewModel.toString());
		logger.info("Method :addpoNo endss");
		return RestQuotationDao.addpoNo(quotationNewModel);
	}

	@PostMapping(value = "add-salesperson")
	public JsonResponse<Object> addSalesPerson(@RequestBody RestQuotationNewModel restQuotationNewModel) {
		logger.info("Method :addSalesPerson starts");

		logger.info("Method : addSalesPerson ends");
		return RestQuotationDao.addSalesPerson(restQuotationNewModel);
	}

	@RequestMapping(value = "getCustomerAddressById", method = { RequestMethod.GET })
	public JsonResponse<RestCustoomerNewModel> getCustomerAddressById(@RequestParam String id, String orgName,
			String orgDivision) {
		logger.info("Method : getCustomerAddressById rest starts");

		logger.info("Method :getCustomerAddressById rest ends");
		return RestQuotationDao.getCustomerAddressById(id, orgName, orgDivision);
	}

	@PostMapping(value = "add-billingaddress")
	public JsonResponse<Object> addbillingaddress(@RequestBody RestCustoomerNewModel restCustoomerNewModel) {
		logger.info("Method :addbillingaddress starts");

		logger.info("Method : addbillingaddress ends");
		return RestQuotationDao.addbillingaddress(restCustoomerNewModel);
	}

	@PostMapping(value = "add-shippingaddress")
	public JsonResponse<Object> addshippingaddress(@RequestBody RestCustoomerNewModel restCustoomerNewModel) {
		logger.info("Method :addshippingaddress starts");

		logger.info("Method : addshippingaddress ends");
		return RestQuotationDao.addshippingaddress(restCustoomerNewModel);
	}

	@GetMapping(value = "getTCSAutoSearchList")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> getTCSAutoSearchList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getTCSAutoSearchList starts");

		logger.info("Method :getTCSAutoSearchList endss");
		return RestQuotationDao.getTCSAutoSearchList(id, org, orgDiv);
	}

	@PostMapping(value = "add-tcs")
	public JsonResponse<Object> addTcs(@RequestBody RestQuotationNewModel restQuotationNewModel) {
		logger.info("Method :addTcs starts");

		logger.info("Method : addTcs ends");
		return RestQuotationDao.addTcs(restQuotationNewModel);
	}
	
	@PostMapping(value = "add-shipping-address")
	public JsonResponse<Object> addShippingAddressRest(@RequestBody DropDownModel data) {
		logger.info("Method : addShippingAddressRest starts");
		
		logger.info("Method : addShippingAddressRest ends");
		return RestQuotationDao.addShippingAddressDao(data);
	}

	@RequestMapping(value = "getCollectionList", method = { RequestMethod.GET })
	public List<DropDownModel> getCollectionList() {
		logger.info("Method : getCollectionList starts");

		logger.info("Method : getCollectionList ends");
		return RestQuotationDao.getCollectionList();
	}

	@RequestMapping(value = "getQuotationTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getQuotationTypeList() {
		logger.info("Method : getQuotationTypeList starts");

		logger.info("Method : getQuotationTypeList ends");
		return RestQuotationDao.getQuotationTypeList();
	}

	// approve

	@GetMapping(value = "approveItemQuatation")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> approveItemQuatation(@RequestParam String approveStatus,
			String quotationId, String reference) {
		logger.info("Method : approveItemQuatation starts");

		logger.info("Method : approveItemQuatation ends");
		return RestQuotationDao.approveItemQuatation(approveStatus, quotationId, reference);
	}

	@GetMapping(value = "getQuotationInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuotationInsertedId() {
		logger.info("Method : getQuotationInsertedId starts");

		logger.info("Method : getQuotationInsertedId endss");
		return RestQuotationDao.getQuotationInsertedId();
	}

//	 	NoAndaggridDetails		

	@GetMapping(value = "getNoAndaggridDetails")
	public List<RestQuotationNewModel> getNoAndaggridDetails() {
		logger.info("Method : getNoAndaggridDetails starts");
		logger.info("Method : getNoAndaggridDetails endss");
		return RestQuotationDao.getNoAndaggridDetails();
	}

	@GetMapping(value = "getQuotationNo")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuotationNo() {
		logger.info("Method : getQuotationNo starts");

		logger.info("Method : getQuotationNo endss");
		return RestQuotationDao.getQuotationNo();
	}

	@RequestMapping(value = "deletequotation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletequotation(@RequestParam String id) {
		logger.info("Method : deletequotation starts");

		logger.info("Method : deletequotation ends");
		return RestQuotationDao.deletequotation(id);
	}

	@GetMapping(value = "get-Quotation-pdfDetails")
	public JsonResponse<List<RestQuotationNewModel>> getQuotationPdfDetails(@RequestParam String id,
			@RequestParam String organization, @RequestParam String orgDivision, @RequestParam String userId) {
		logger.info("Method : getQuotationPdfDetails starts");

		logger.info("Method : getQuotationPdfDetails ends");
		return RestQuotationDao.getQuotationPdfDetails(id, organization, orgDivision, userId);
	}

	@GetMapping(value = "getSacCode")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSacCode() {
		logger.info("Method : getSacCode starts");

		logger.info("Method : getSacCode endss");
		return RestQuotationDao.getSacCode();
	}

	@GetMapping(value = "viewQuotationRevision")
	public List<RestQuotationNewModel> viewQuotationRevision(@RequestParam String id) {
		logger.info("Method : viewQuotationRevision starts");

		logger.info("Method : viewQuotationRevision endss");
		return RestQuotationDao.viewQuotationRevision(id);
	}

	@RequestMapping(value = "rest-getScopeMatrixDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ScopeMatrixRestModel>>> getScopeMatrixDetails(@RequestParam String org,

			@RequestParam String orgDiv) {

		logger.info("Method :getScopeMatrixDetails starts");

		logger.info("Method :getScopeMatrixDetails endss");
		return RestQuotationDao.getScopeMatrixDetails(org, orgDiv);

	}

	@RequestMapping(value = "rest-viewShippingAddressData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewBinAllocationdatas(@RequestParam String customerId, String org, String orgDiv) {
		logger.info("Method :viewShippingAddressData start");

		logger.info("Method :viewShippingAddressData endss");
		return RestQuotationDao.viewShippingAddressData(customerId, org, orgDiv);

	}

	@RequestMapping(value = "rest-editShippingAddressData", method = { RequestMethod.GET })
	public JsonResponse<Object> editShippingAddressData(@RequestParam String addressId, String org, String orgDiv) {
		logger.info("Method :editShippingAddressData start");

		logger.info("Method :editShippingAddressData endss");
		return RestQuotationDao.editShippingAddressData(addressId, org, orgDiv);

	}

	@RequestMapping(value = "ProjectListForSale", method = { RequestMethod.GET })
	public List<DropDownModel> ProjectListForSale(@RequestParam String organization, String orgDivision) {
		logger.info("Method : ProjectListForSale starts");

		logger.info("Method : ProjectListForSale ends");
		return RestQuotationDao.ProjectListForSale(organization, orgDivision);
	}

	@GetMapping(value = "sendEmailQuotation")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> sendEmailQuotation(
			@RequestParam String quotationId, String customerNames, String customerCns, String customerMails,
			String customerCc, String customerBcc, String customerMsg, String url) {
		logger.info("Method : sendEmailQuotation starts");

		logger.info("Method : sendEmailQuotation ends");
		return RestQuotationDao.sendEmailQuotation(quotationId, customerNames, customerCns, customerMails, customerCc,
				customerBcc, customerMsg, url);
	}

	// Search
	@RequestMapping(value = "rest-quotationDataViewSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> quotationDataViewSearch(@RequestParam String orgName, @RequestParam String orgDivision,
			String searchValue) {
		logger.info("Method :quotationDataViewSearch start");

		logger.info("Method :quotationDataViewSearch endss");
		return RestQuotationDao.quotationDataViewSearch(orgName, orgDivision, searchValue);

	}

	@RequestMapping(value = "get-item-list", method = { RequestMethod.GET })
	public List<DropDownModel> getProductList(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getCollectionList starts with org: " + org + " and orgDiv: " + orgDiv);

		logger.info("Method : getProductList ends");
		return RestQuotationDao.getProductList(org, orgDiv);
	}
	
	@RequestMapping(value = "get-sku-master-list", method = { RequestMethod.GET })
	public List<DropDownModel> getSkuMasterList(@RequestParam String org, @RequestParam String orgDiv) {
		
		logger.info("Method : getCollectionList starts with org: " + org + " and orgDiv: " + orgDiv);
		
		logger.info("Method : getSkuMasterList ends");
		return RestQuotationDao.getSkuMasterList(org, orgDiv);
	}

	@RequestMapping(value = "get-item-bySkuId", method = { RequestMethod.GET })
	public JsonResponse<Object> getItemdDtailsBySku(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :getItemdDtailsBySku start");

		logger.info("Method :getItemdDtailsBySku endss");
		return RestQuotationDao.getItemdDtailsBySku(id, org, orgDiv);

	}

	@RequestMapping(value = "get-sku-list", method = { RequestMethod.GET })
	public JsonResponse<Object> getSKUList(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :getSKUList start");

		logger.info("Method :getSKUList endss");
		return RestQuotationDao.getSKUList(id, org, orgDiv);

	}

	@RequestMapping(value = "getBomDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getBomDetails(@RequestParam String id, @RequestParam String sku,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getBomDetails start");

		logger.info("Method :getBomDetails endss");
		return RestQuotationDao.getBomDetails(id, sku, org, orgDiv);

	}

	@RequestMapping(value = "get-quotation-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> getQuotationPdf(@RequestParam String id, String org, @RequestParam String orgDiv) {
		logger.info("Method :getQuotationPdf start");

		logger.info("Method :getQuotationPdf endss");
		return RestQuotationDao.getQuotationPdf(id, org, orgDiv);

	}

}
