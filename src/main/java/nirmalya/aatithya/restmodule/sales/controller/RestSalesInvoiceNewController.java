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
import nirmalya.aatithya.restmodule.sales.dao.SalesInvoiceNewDao;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoicePaymentModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;

@RestController
@RequestMapping("sales/")
public class RestSalesInvoiceNewController {

	Logger logger = LoggerFactory.getLogger(RestSalesInvoiceNewController.class);

	@Autowired

	SalesInvoiceNewDao SalesInvoiceNewDao;
	
	/*
	 * store name drp down
	 */
	/*
	 * @GetMapping(value = "GetStoreNameList") public List<DropDownModel>
	 * GetStoreNameList() { logger.info("Method : GetStoreNameList starts");
	 * 
	 * logger.info("Method : GetStoreNameList ends"); return
	 * SalesInvoiceNewDao.GetStoreNameList(); }
	 */

	@GetMapping(value = "getSalesOrderAutoSearchNewList")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> getSalesOrderAutoSearchNewList(
			@RequestParam String id) {
		logger.info("Method : getSalesOrderAutoSearchNewList starts");
		//logger.info("RestSalesInvoiceNewModel" + id);
		logger.info("Method :getSalesOrderAutoSearchNewList endss");
		return SalesInvoiceNewDao.getSalesOrderAutoSearchNewList(id);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addsaleInvoicenew")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> addsaleInvoicenew(
			@RequestBody List<RestSalesInvoiceNewModel> restSalesInvoiceNewModel) {
		logger.info("Method :addsaleInvoicenew starts");
			logger.error("rest data---->>>"+restSalesInvoiceNewModel);
			logger.info("Method :addsaleInvoicenew endss");
		return SalesInvoiceNewDao.addsaleInvoicenew(restSalesInvoiceNewModel);
	}

	/*
	 * edit
	 * 
	 */
	@RequestMapping(value = "rest-editSalesInvoice", method = { RequestMethod.GET })
	public JsonResponse<Object> editSalesInvoice(@RequestParam String id, String orgName, @RequestParam String orgDivision) {
		logger.info("Method :editSalesInvoice start");

		logger.info("Method :editSalesInvoice endss");
		return SalesInvoiceNewDao.editSalesInvoice(id, orgName, orgDivision);

	}


	@RequestMapping(value = "rest-getAllsalesInvoice", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllsalesInvoice(@RequestParam String userId, String orgName,String orgDivision,String type,String fromDate,String toDate) {
		logger.info("Method :getAllsalesInvoice start");

		logger.info("Method :getAllsalesInvoice endss");
		return SalesInvoiceNewDao.getAllsalesInvoice(userId, orgName, orgDivision, type,fromDate,toDate);

	}

	// pdf
	@RequestMapping(value = "rest-getSalesInvoicePdf", method = { RequestMethod.GET })
	public JsonResponse<Object> getSalesInvoicePdf(@RequestParam String id, String orgName, String orgDivision,String type) {
		logger.info("Method :getSalesInvoicePdf start");

		logger.info("Method :getSalesInvoicePdf endss");
		return SalesInvoiceNewDao.getSalesInvoicePdf(id, orgName, orgDivision,type);

	}
	/*
	 * view Invoice search
	 * 
	 */
	@GetMapping(value = "view-saleInvoice-search")
	public JsonResponse<List<RestSalesInvoicePaymentModel>> viewsalesInvoiceSearch(
			@RequestParam String userId, String organization,  String orgDivision, String searchValue){
		logger.info("Method :viewsalesInvoiceSearch starts");
		
		logger.info("Method :viewsalesInvoiceSearch endss");
		return SalesInvoiceNewDao.viewsalesInvoiceSearch(userId,organization,orgDivision,searchValue);
		
	}

	/*
	 * edit
	 */ @GetMapping(value = "viewsalesIvoiceEdit")
	public List<RestSalesInvoiceNewModel> viewsalesIvoiceEdit(@RequestParam String id, String organization, String orgDivision) {
		logger.info("Method : viewsalesIvoiceEdit starts");
		//logger.info(id);
		logger.info("Method : viewsalesIvoiceEdit endss");
		return SalesInvoiceNewDao.viewsalesIvoiceEdit(id, organization, orgDivision);
	}
/*delete
 * 	 
 */
	/* @PostMapping(value = "deletesalesInvoice")
		public ResponseEntity<JsonResponse<Object>> deletesalesInvoice(
				@RequestBody RestSalesInvoiceNewModel restSalesInvoiceNewModel) {
			logger.info("Method : deletesalesInvoice starts");
			//logger.info(restSalesInvoiceNewModel);
			logger.info("Method : deletesalesInvoice ends");
			return SalesInvoiceNewDao.deletesalesInvoice(restSalesInvoiceNewModel);
}*/
	 @RequestMapping(value = "/deletesalesInvoice", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deletesalesInvoice(@RequestParam String id,@RequestParam String org,
				@RequestParam String orgDiv) {
		logger.info("Method : deletesalesInvoice starts");

		logger.info("Method : deletesalesInvoice ends");
		return SalesInvoiceNewDao.deletesalesInvoice(id,org, orgDiv); 
	}
 	
	 
	 /*
	  * payment mode drpdown
	  */
	 
	 @GetMapping(value = "GetpaymentModeList")
		public List<DropDownModel> GetpaymentModeList() {
			logger.info("Method : paymentModeListrest starts");

			logger.info("Method : paymentModeListrest ends");
			return SalesInvoiceNewDao.GetpaymentModeList();
		}
	 
	 /*
		 *  payment add
		 */
		@PostMapping(value = "addinvPaymentnew")
		public ResponseEntity<JsonResponse<Object>> addinvPaymentnew(@RequestBody RestSalesInvoiceNewModel salesInvoiceNewModel) {
			logger.info("Method :addinvPaymentnewrest starts");
			logger.info(salesInvoiceNewModel.toString());
			logger.info("Method :addinvPaymentnewrest endss");
			return SalesInvoiceNewDao.addinvPaymentnew(salesInvoiceNewModel);
		}
		
		@RequestMapping(value = "getSalesorderList",method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderList(@RequestParam String id,String type) {
			logger.info("Method : getSalesorderList starts");
			logger.info("Method : getSalesorderList ends");
			return SalesInvoiceNewDao.getSalesorderList(id,type);
		}
		/*
		 * @GetMapping(value = "getInvoiceInsertedId") public
		 * ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceInsertedId() {
		 * logger.info("Method : getInvoiceInsertedId starts");
		 * 
		 * logger.info("Method : getInvoiceInsertedId endss"); return
		 * SalesInvoiceNewDao.getInvoiceInsertedId(); }
		 */
		
		@GetMapping(value = "getInvoicepodata")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoicepodata() {
			logger.info("Method : getInvoicepodata starts");

			logger.info("Method : getInvoicepodata endss");
			return SalesInvoiceNewDao.getInvoicepodata();
	}
		/*
		 * pdf
		 */ @GetMapping(value = "viewsales-invoice-viewPdf")
		public List<RestSalesInvoiceNewModel> viewsalesInvoiceViewPdf(@RequestParam String id,@RequestParam String organization, @RequestParam String orgDivision) {
			logger.info("Method : viewsalesInvoiceViewPdf starts");
			logger.info("Method : viewsalesInvoiceViewPdf endss");
			return SalesInvoiceNewDao.viewsalesInvoiceViewPdf(id,organization,orgDivision);
		}
		 
		 
	/*Project Sutosearch*/
		 
	@GetMapping(value = "geProjectListByAutoSearch")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> getCustomerListByAutoSearch(
			@RequestParam String id) {
		logger.info("Method : geProjectListByAutoSearch starts");

		logger.info("Method :geProjectListByAutoSearch endss");
		return SalesInvoiceNewDao.geProjectListByAutoSearch(id);
	}
	
	
	/*
	 * view Item
	 * 
	 */
	@GetMapping(value = "getAllsalesInvoiceitem")
	public JsonResponse<List<RestSalesInvoiceNewModel>> getAllsalesInvoiceitem(@RequestParam String prId, @RequestParam String crId) {
		logger.info("Method :getAllsalesInvoiceitem starts");

		logger.info("Method :getAllsalesInvoiceitem endss");
		return SalesInvoiceNewDao.getAllsalesInvoiceitem(prId,crId);

	}
	
//	@RequestMapping(value = "viewsalesIvoiceEdit-new", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<RestSalesInvoiceNewModel>> viewsalesIvoiceEdits(@RequestParam String id) {
//		logger.info("Method : viewsalesIvoiceEdits rest starts");
//
//		logger.info("Method :viewsalesIvoiceEdits rest ends");
//		return SalesInvoiceNewDao.viewsalesIvoiceEdits(id);
//	}
	@GetMapping(value = "viewSalesPdfNew")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> viewSalesPdfNew(@RequestParam String id) {
		logger.info("Method :viewSalesPdfNew starts");

		logger.info("Method :viewSalesPdfNew ends" + id);
		return SalesInvoiceNewDao.viewSalesPdfNew(id);
	}
	
	@RequestMapping(value = "rest-rejectInvoice", method = { RequestMethod.GET })
	public JsonResponse<Object> rejectInvoice(@RequestParam String invId,String comment, String org,String orgDiv,String userId) {
		logger.info("Method :rejectInvoice start");

		logger.info("Method :rejectInvoice endss");
		return SalesInvoiceNewDao.rejectInvoice(invId,comment,org, orgDiv, userId);
	}
	
	// Post mapping for add upload Invoice

	@PostMapping(value = "rest-addInvoiceUploadData")
	public ResponseEntity<JsonResponse<Object>> addInvoiceUploadData(@RequestBody List<RestSalesInvoiceNewModel> invoice) {
		logger.info("Method : addInvoiceUploadData starts");

		logger.info("Method : addInvoiceUploadData ends");
		return SalesInvoiceNewDao.addInvoiceUploadData(invoice);
	}
	
	@RequestMapping(value = "addPaymentInvoice", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPaymentInvoice(@RequestBody RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		logger.info("Method : addPaymentInvoice starts"+restSalesInvoicePaymentModel);

		logger.info("Method : addPaymentInvoice ends");
		return SalesInvoiceNewDao.addPaymentInvoice(restSalesInvoicePaymentModel);
	}
	
	@GetMapping(value = "paymentApproval")
	public JsonResponse<RestSalesInvoicePaymentModel> paymentApproval(@RequestParam String invoiceId, String userId) {
		logger.info("Method : paymentApproval starts");
		
		logger.info("Method : paymentApproval ends");
		return SalesInvoiceNewDao.paymentApproval(invoiceId, userId);
	}
	
	@GetMapping(value = "paymentReject")
	public JsonResponse<RestSalesInvoicePaymentModel> paymentReject(@RequestParam String invoiceId, String userId) {
		logger.info("Method : paymentReject starts");
		
		logger.info("Method : paymentReject ends");
		return SalesInvoiceNewDao.paymentReject(invoiceId, userId);
	}
	
	@RequestMapping(value = "rest-approveInvoice", method = { RequestMethod.GET })
	public JsonResponse<Object> approveInvoice(@RequestParam String invId,String comment, String orgName,String orgDiv, String userId) {
		logger.info("Method :approveInvoice start");

		logger.info("Method :approveInvoice endss");
		return SalesInvoiceNewDao.approveInvoice(invId,comment,orgName, orgDiv,userId);
	}
	
	// getFiscalYearList

	@RequestMapping(value = "getFiscalYearList", method = { RequestMethod.GET })
	public List<DropDownModel> getFiscalYearList() {

		logger.info("Method : getFiscalYearList starts");
		logger.info("Method : getFiscalYearList ends");

		return SalesInvoiceNewDao.getFiscalYearList();
	}
	
	
	@RequestMapping(value = "saleInvoiceFilterdata", method = { RequestMethod.GET })
	public JsonResponse<Object> saleInvoiceFilterdata(@RequestParam String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method :saleInvoiceFilterdata start");

		logger.info("Method :saleInvoiceFilterdata endss");
		return SalesInvoiceNewDao.saleInvoiceFilterdata(orgName, orgDivision, fromDate, toDate);

	}
	

	@GetMapping("rest-get-po-challan-saleInvoice")
	public JsonResponse<Object> getPosaleInvoiceChange(@RequestParam String custId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :getPosaleInvoiceChange start");

		logger.info("Method :getPosaleInvoiceChange ends");
		return SalesInvoiceNewDao.getPoOnSaleInvoiceList(custId, orgName, orgDiv);
	}

	@GetMapping("rest-get-challan-id-by-po")
	public JsonResponse<Object> getChallanOByPoList(@RequestParam String poId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :getChallanOByPoList start");

		logger.info("Method :getChallanOByPoList ends");
		return SalesInvoiceNewDao.getChallanOByPoList(poId, orgName, orgDiv);
	}

	@GetMapping("rest-get-items-details-by-challan-id")
	public JsonResponse<Object> getItemDetailsOnChallan(@RequestParam String selectedValuesStr,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getItemDetailsOnChallan start");

		logger.info("Method :getItemDetailsOnChallan ends");
		return SalesInvoiceNewDao.getItemDetailsOnChallan(selectedValuesStr, orgName, orgDiv);
	}
	
	@GetMapping("rest-get-items-details-by-order-id")
	public JsonResponse<Object> getItemDetailsOnOrder(@RequestParam String selectedValuesStr,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getItemDetailsOnOrder start");
		
		logger.info("Method :getItemDetailsOnOrder ends");
		return SalesInvoiceNewDao.getItemDetailsOnOrder(selectedValuesStr, orgName, orgDiv);
	}
	
	@GetMapping(value = "getSalesInvoiceInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeliveryChallanInsertedId(@RequestParam String type) {
		logger.info("Method : getSalesInvoiceInsertedId starts");

		logger.info("Method : getSalesInvoiceInsertedId endss");
		return SalesInvoiceNewDao.getSalesInvoiceInsertedId(type);
	}
	
}
