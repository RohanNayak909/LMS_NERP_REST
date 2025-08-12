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
import nirmalya.aatithya.restmodule.sales.dao.RestSaleOrderNewDao;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;

@RestController
@RequestMapping("sales/")
public class RestSaleOrderNewController {
	Logger logger = LoggerFactory.getLogger(RestSaleOrderNewController.class);

	@Autowired

	RestSaleOrderNewDao RestSaleOrderNewDao;

	/*
	 * store name drp down
	 */
	@GetMapping(value = "GetStoreList")
	public List<DropDownModel> GetStoreList() {
		logger.info("Method : GetStoreList starts");

		logger.info("Method : GetStoreList ends");
		return RestSaleOrderNewDao.GetStoreList();
	}

	/*
	 * customer auto search
	 */
	@GetMapping(value = "getCustomerAutoSearchNewList")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getCustomerAutoSearchNewList(
			@RequestParam String id) {
		logger.info("Method : getCustomerAutoSearchNewList starts");

		logger.info("Method :getCustomerAutoSearchNewList endss");
		return RestSaleOrderNewDao.getCustomerAutoSearchNewList(id);
	}

	/*
	 * item autosearch
	 * 
	 */
	@GetMapping(value = "getItemQuotationAutoSearchNewList")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getItemQuotationAutoSearchNewList(
			@RequestParam String id) {
		logger.info("Method : getItemQuotationAutoSearchNewList starts");

		logger.info("Method :getItemQuotationAutoSearchNewList endss");
		return RestSaleOrderNewDao.getItemQuotationAutoSearchNewList(id);
	}

	// get product category list

	@RequestMapping(value = "getProductCategoryDataListModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryDataListModal starts");

		logger.info("Method : getProductCategoryDataListModal ends");
		return RestSaleOrderNewDao.getProductCategoryDataListModal();
	}

	/*
	 * get product by cat
	 * 
	 */
	@GetMapping(value = "getProductsNByCat")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getProductsNByCat(@RequestParam String id) {
		logger.info("Method in rest: getProductsByCat starts");
		// logger.info(id);
		logger.info("Method in rest: getProductsByCat ends");
		return RestSaleOrderNewDao.getProductsNByCat(id);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addsalenew")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> addsalenew(
			@RequestBody List<RestSaleOrderNewModel> restSaleOrderNewModel) {
		logger.info("Method :addsalenew starts");
		 
		logger.info("Method :addsalenew endss");
		return RestSaleOrderNewDao.addsalenew(restSaleOrderNewModel);
	}

	/*
	 * view
	 * 
	 */
	
	@RequestMapping(value = "rest-getAllsalesOrder", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllsalesOrder(@RequestParam String orgName, @RequestParam String orgDivision,String pageno,String userId,String fDate,String tDate) {
		logger.info("Method :getAllsalesOrder start");

		logger.info("Method :getAllsalesOrder endss");
		return RestSaleOrderNewDao.getAllsalesOrder(orgName, orgDivision, pageno, userId, fDate, tDate);
	}
	
	@RequestMapping(value = "rest-getSalesOrderTimeline", method = { RequestMethod.GET })
	public JsonResponse<Object> getSalesOrderTimelineRest(@RequestParam String org, @RequestParam String orgDiv, String id) {
		logger.info("Method :getSalesOrderTimelineRest start");
		
		logger.info("Method :getSalesOrderTimelineRest endss");
		return RestSaleOrderNewDao.getSalesOrderTimelineDao(org, orgDiv, id);
	}

	/*
	 * edit
	 */
	@GetMapping(value = "viewsalesOrdeerEdit")
	public List<RestSaleOrderNewModel> viewsalesOrdeerEdit(@RequestParam String id,@RequestParam String invoiceId) {
		logger.info("Method : viewsalesOrdeerEdit starts");
		logger.info("Method : viewsalesOrdeerEdit endss");
		return RestSaleOrderNewDao.viewsalesOrdeerEdit(id,invoiceId);
	}
	/*
	 * viewsalesOrderForPacking
	 */
	@GetMapping(value = "viewsalesOrderForPacking")
	public List<RestSaleOrderNewModel> viewsalesOrderForPacking(@RequestParam String id,String poidd) {
		logger.info("Method : viewsalesOrderForPacking starts");
		
		logger.info("Method : viewsalesOrderForPacking endss");
		return RestSaleOrderNewDao.viewsalesOrderForPacking(id,poidd);
	}

	/*
	 * delete
	 * 
	 */
	@PostMapping(value = "deletesalesOrder")
	public ResponseEntity<JsonResponse<Object>> deletesalesOrder(
			@RequestBody RestSaleOrderNewModel restSaleOrderNewModel) {
		logger.info("Method : deletesalesOrder starts");
		logger.info(restSaleOrderNewModel.toString());
		logger.info("Method : deletesalesOrder ends");
		return RestSaleOrderNewDao.deletesalesOrder(restSaleOrderNewModel);
	}
	
	@GetMapping(value = "getSOInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSOInsertedId() {
		logger.info("Method : getSOInsertedId starts");

		logger.info("Method : getSOInsertedId endss");
		return RestSaleOrderNewDao.getSOInsertedId();
	}
	@RequestMapping(value = "getSalesPoListt", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesPoListt(@RequestParam String id) {
		logger.info("Method : getSalesPoListt starts");
		
		logger.info("Method : getSalesPoListt ends");
		return RestSaleOrderNewDao.getSalesPoListt(id);
	}
	@RequestMapping(value = "rest-viewsalesOrderPoWise", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> viewsalesOrderPoWise(
			@RequestParam String org, @RequestParam String orgDiv, @RequestParam String id) {
		logger.info("Method :viewsalesOrderPoWise starts");

		logger.info("Method :viewsalesOrderPoWise endss");
		return RestSaleOrderNewDao.viewsalesOrderPoWise(org, orgDiv, id);

	}
	
	 // Block Order
    @GetMapping(value="blockSaleOrderItem")
	public JsonResponse<RestSaleOrderNewModel> blockSaleOrderItem(@RequestParam String blockeOrder, String salesOrder,String sku){
		logger.info("Method : blockSaleOrderItem starts");
		
		logger.info("Method : blockSaleOrderItem ends");
		return RestSaleOrderNewDao.blockSaleOrderItem(blockeOrder, salesOrder,sku);
	}
    
 // approve


 	
    @GetMapping(value="approveSaleOrder")
 	public JsonResponse<RestSaleOrderNewModel> approveSaleOrder(@RequestParam String approveStatus,
 			String salesOrder,String pendingQut,String userId,String org,String orgDiv){
 		logger.info("Method : approveSaleOrder starts");
 		
 		logger.info("Method : approveSaleOrder ends");
 		return RestSaleOrderNewDao.approveSaleOrder(approveStatus, salesOrder,pendingQut,userId,org,orgDiv);
 	}
 // Search
  	@RequestMapping(value = "rest-soDataViewSearch", method = { RequestMethod.GET })
  	public JsonResponse<Object> soDataViewSearch(@RequestParam String orgName, String orgDivision, String searchValue) {
  		logger.info("Method :soDataViewSearch start");

  		logger.info("Method :soDataViewSearch endss");
  		return RestSaleOrderNewDao.soDataViewSearch(orgName, orgDivision, searchValue);

  	}
  	
  	@GetMapping("rest-get-po")
	public JsonResponse<Object> getPoOnSelectionCustomer(@RequestParam String custId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :getPoOnSelectionCustomer start");

		logger.info("Method :getPoOnSelectionCustomer ends");
		return RestSaleOrderNewDao.getPoOnSelectionCustomer(custId,orgName,orgDiv);
	}
  	@GetMapping("rest-get-po-details")
	public JsonResponse<Object> getPoDetails(@RequestParam String poId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :getPoDetails start");

		logger.info("Method :getPoDetails ends");
		return RestSaleOrderNewDao.getPoDetails(poId,orgName,orgDiv);
	}
 	
 // Sales Order PDF 
 	@RequestMapping(value = "rest-getSalesOrderPdf", method = { RequestMethod.GET })
 	public JsonResponse<Object> getSalesOrderPdf(@RequestParam String id, String orgName,
 			String orgDivision,String poId) {
 		logger.info("Method :getSalesOrderPdf start");

 		logger.info("Method :getSalesOrderPdf endss");
 		return RestSaleOrderNewDao.getSalesOrderPdf(id, orgName, orgDivision,poId);
 	}
 	
//
 	@PostMapping(value = "rest-addShippingAddressSO")
	public JsonResponse<Object> addShippingAddressSO(@RequestBody DropDownModel data) {
		logger.info("Method : addShippingAddressSO starts");
		
		logger.info("Method : addShippingAddressSO ends");
		return RestSaleOrderNewDao.addShippingAddressSO(data);
	}
 	@PostMapping(value = "addsaleInvoice")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> addsaleInvoice(
			@RequestBody List<RestSalesInvoiceNewModel> restSalesInvoiceNewModel) {
		logger.info("Method :addsaleInvoice starts");
			logger.error("rest data---->>>"+restSalesInvoiceNewModel);
			logger.info("Method :addsaleInvoice endss");
		return RestSaleOrderNewDao.addsaleInvoice(restSalesInvoiceNewModel);
	}
//
 	@RequestMapping(value = "rest-saleorderInvoicePdf-data", method = { RequestMethod.GET })
	public JsonResponse<Object> saleorderInvoicePdf(@RequestParam String id, String orgName, @RequestParam String orgDivision,@RequestParam String poId) {
		logger.info("Method :saleorderInvoicePdf start");

		logger.info("Method :saleorderInvoicePdf endss");
		return RestSaleOrderNewDao.saleorderInvoicePdf(id, orgName, orgDivision,poId);

	}
}
