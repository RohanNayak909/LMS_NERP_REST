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
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseOrderrDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

@RestController
@RequestMapping("purchase/")
public class RestPurchaseOrderConrtoller {
	Logger logger = LoggerFactory.getLogger(RestPurchaseOrderConrtoller.class);

	@Autowired

	RestPurchaseOrderrDao restPurchaseOrderrDao;

	@GetMapping(value = "getVendorAutoSearchListStore")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> getVendorAutoSearchListStore(@RequestParam String id,@RequestParam String type,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getVendorAutoSearchListStore starts");

		logger.info("Method :getVendorAutoSearchListStore endss");
		return restPurchaseOrderrDao.getVendorAutoSearchListStore(id,type, org, orgDiv);
	}

	@GetMapping(value = "getPoInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPoInsertedId() {
		logger.info("Method : getPoInsertedId starts");

		logger.info("Method : getPoInsertedId endss");
		return restPurchaseOrderrDao.getPoInsertedId();
	}

	/*
	 * @GetMapping(value = "getVendorStateData") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>
	 * getVendorStateData(@RequestParam String id,String type) {
	 * logger.info("Method : getVendorStateData starts");
	 * 
	 * logger.info("Method : getVendorStateData endss"); return
	 * restPurchaseOrderrDao.getVendorStateData(id,type); }
	 */
	/*
	 * add
	 */
	@PostMapping(value = "addPurchase")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> addPurchase(
			@RequestBody List<RestPurchaseOrderModel> restPurchaseOrderModel) {
		logger.info("Method :addPurchase starts");
			System.out.println("add rest------>>>>"+restPurchaseOrderModel);
		logger.info("Method :addPurchase endss");
		return restPurchaseOrderrDao.addPurchase(restPurchaseOrderModel);
	}

	@RequestMapping(value = "rest-viewPurchaseOrder", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> viewPurchaseOrder(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewPurchaseOrder startssssssssssssssssss");

		logger.info("Method :viewPurchaseOrder endss");
		return restPurchaseOrderrDao.viewPurchaseOrder(org, orgDiv);

	}

	@RequestMapping(value = "rest-viewPOreport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> viewPOReport(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewPOReport startssssssssssssssssss");

		logger.info("Method :viewPOReport endss");
		return restPurchaseOrderrDao.viewPOReport(org, orgDiv);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewPoEdit")
	public List<RestPurchaseOrderModel> viewPoEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewPoEdit starts");
		// logger.info(id);
		logger.info("Method : viewPoEdit endss");
		return restPurchaseOrderrDao.viewPoEdit(id, org, orgDiv);
	}

	/*
	 * delete
	 * 
	 */
	@PostMapping(value = "deletePo")
	public ResponseEntity<JsonResponse<Object>> deletePo(@RequestBody RestPurchaseOrderModel restPurchaseOrderModel) {
		logger.info("Method : deletePo starts");
		// logger.info(restSalesInvoiceNewModel);
		logger.info("Method : deletePo ends");
		return restPurchaseOrderrDao.deletePo(restPurchaseOrderModel);
	}

	@RequestMapping(value = "getCarrierList", method = { RequestMethod.GET })
	public List<DropDownModel> getCarrierList() {
		logger.info("Method : getCarrierList starts");

		logger.info("Method : getCarrierList ends");
		return restPurchaseOrderrDao.getCarrierList();
	}

	@RequestMapping(value = "getPaymentterm", method = { RequestMethod.GET })
	public List<DropDownModel> getPaymentterm() {
		logger.info("Method : getPaymentterm starts");

		logger.info("Method : getPaymentterm ends");
		return restPurchaseOrderrDao.getPaymentterm();
	}

	@RequestMapping(value = "getVendorAddressAddressById", method = { RequestMethod.GET })
	public JsonResponse<RestVendorNewModel> getVendorAddressAddressById(@RequestParam String id) {
		logger.info("Method : getVendorAddressAddressById rest starts");

		logger.info("Method :getVendorAddressAddressById rest ends");
		return restPurchaseOrderrDao.getVendorAddressAddressById(id);
	}

	@PostMapping(value = "addVendorBillingaddres")
	public JsonResponse<Object> addVendorBillingaddres(@RequestBody RestVendorNewModel restVendorNewModel) {
		logger.info("Method :addVendorBillingaddres starts");

		logger.info("Method : addVendorBillingaddres ends");
		return restPurchaseOrderrDao.addVendorBillingaddres(restVendorNewModel);
	}

	@PostMapping(value = "addvendorShippingaddress")
	public JsonResponse<Object> addvendorShippingaddress(@RequestBody RestVendorNewModel restVendorNewModel) {
		logger.info("Method :addvendorShippingaddress starts");

		logger.info("Method : addvendorShippingaddress ends");
		return restPurchaseOrderrDao.addvendorShippingaddress(restVendorNewModel);
	}

	/*
	 * pdf
	 */ @GetMapping(value = "view-po-viewPdf")
	public List<RestPurchaseOrderModel> viewPoViewPdf(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewPoViewPdf starts");
		logger.info("Method : viewPoViewPdf endss");
		return restPurchaseOrderrDao.viewPoViewPdf(id, org, orgDiv);
	}
	 
	// edit rest sub contractor
		@RequestMapping(value = "rest-viewannexurelist", method = { RequestMethod.GET })
		public JsonResponse<Object>  viewAnnexure(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :viewAnnexure start");

			logger.info("Method :viewAnnexure endss");
			return restPurchaseOrderrDao.viewAnnexure(id, orgName, orgDivision);
		}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "getGRNdata")
	public JsonResponse getGRNdata(@RequestParam String sku, String gatePass, String org,
			String orgDiv, String challanNo, String challanDt ) {
		logger.info("Method : getGRNdata starts");
		
		logger.info("Method : getGRNdata endss");
		return restPurchaseOrderrDao.getGRNdata(sku, gatePass, org, orgDiv, challanNo, challanDt );
	}
	// Ori-Food
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "getGRNdataOf")
	public JsonResponse getGRNdataOf(@RequestParam String sku, String gatePass, String org,
			String orgDiv, String challanNo, String challanDt,String vendorId ) {
		logger.info("Method : getGRNdataOf starts");
		
		logger.info("Method : getGRNdataOf endss");
		return restPurchaseOrderrDao.getGRNdataOf(sku, gatePass, org, orgDiv, challanNo, challanDt,vendorId );
	}
	// approve

	@GetMapping(value = "approvePorder")
	public JsonResponse<DropDownModel> approvePorder(@RequestParam String approveStatus, String poId, String orgName,
			String orgDivision) {
		logger.info("Method : approvePorder starts");

		logger.info("Method : approvePorder ends");
		return restPurchaseOrderrDao.approvePorder(approveStatus, poId, orgName, orgDivision);
	}
	// Post mapping for add upload po

	@PostMapping(value = "rest-addPOUploadData")
	public ResponseEntity<JsonResponse<Object>> addPOUploadData(@RequestBody List<RestPurchaseOrderModel> pOrder) {
		logger.info("Method : addPOUploadData starts");

		logger.info("Method : addPOUploadData ends");
		return restPurchaseOrderrDao.addPOUploadData(pOrder);
	}

	@GetMapping(value = "getItemQuotationAutoSearchNewListForPO")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemQuotationAutoSearchNewListForPO(
			@RequestParam String id,String type, String org, String orgDiv) {
		logger.info("Method : getItemQuotationAutoSearchNewListForPO starts");

		logger.info("Method :getItemQuotationAutoSearchNewListForPO endss");
		return restPurchaseOrderrDao.getItemQuotationAutoSearchNewListForPO(id,type, org, orgDiv);
	}

	// get product category list
	@PostMapping(value = "getProductCategoryDataListModal")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryDataListModal starts");

		logger.info("Method : getProductCategoryDataListModal ends");
		return restPurchaseOrderrDao.getProductCategoryDataListModal();
	}
	
	@RequestMapping(value = "getModeListForPurchaseProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getModeListForPurchaseProduct() {
		logger.info("Method : getModeListForPurchaseProduct starts");
		
		logger.info("Method : getModeListForPurchaseProduct ends");
		return restPurchaseOrderrDao.getModeListForPurchaseProduct();
	}
	

	// View Annexure
	@RequestMapping(value = "rest-viewannexureDetails-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAnnexurePdf(@RequestParam String id) {
		logger.info("Method :viewAnnexurePdf start");

		logger.info("Method :viewAnnexurePdf endss");
		return restPurchaseOrderrDao.viewAnnexurePdf(id);
	}
	
	
	 // PO Referance List (Quatation)
	 
	 @RequestMapping(value = "getReferenceListPO", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getReferenceListPO(@RequestParam String id,String poId,
				@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : getReferenceListPO starts");

			logger.info("Method : getReferenceListPO ends");
			return restPurchaseOrderrDao.getReferenceListPO(id,poId, org, orgDiv);
		}
	 
	 
	 @RequestMapping(value = "rest-getReferenceItemDetailsPO", method = { RequestMethod.GET })
		public JsonResponse<Object> getReferenceItemDetailsPO(@RequestParam String orgName, @RequestParam String orgDivision, String id) {
			logger.info("Method :getReferenceItemDetailsPO start");

			logger.info("Method :getReferenceItemDetailsPO endss");
			return restPurchaseOrderrDao.getReferenceItemDetailsPO(orgName, orgDivision, id);

		}

}
