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
import nirmalya.aatithya.restmodule.purchase.dao.RestManageInvoiceDao;
import nirmalya.aatithya.restmodule.purchase.model.RestQaRequestModel;
import nirmalya.aatithya.restmodule.purchase.model.RestGrnReturnExcelModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

@RestController
@RequestMapping("purchase/")
public class RestManageInvoiceController {
	Logger logger = LoggerFactory.getLogger(RestManageInvoiceController.class);

	@Autowired

	RestManageInvoiceDao restManageInvoiceDao;

	@GetMapping(value = "getInvoiceInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceInsertedId(@RequestParam String requestType,String org,String orgDiv) {
		logger.info("Method : getInvoiceInsertedId starts");

		logger.info("Method : getInvoiceInsertedId endss");
		return restManageInvoiceDao.getInvoiceInsertedId(requestType,org,orgDiv);
	}
	
	// Capex Header
	
	@RequestMapping(value = "rest-capexHeader", method = { RequestMethod.GET })
	public List<DropDownModel> capexHeader(@RequestParam String organization, String orgDivision) {
		logger.info("Method : capexHeader starts");

		logger.info("Method : capexHeader ends");
		return restManageInvoiceDao.capexHeader(organization, orgDivision);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addInvoice")
	public ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> addPurchase(
			@RequestBody List<RestManageInvoiceModel> restManageInvoiceModel) {
		logger.info("Method :addInvoice starts");

		logger.info("Method :addInvoice endss");
		return restManageInvoiceDao.addInvoice(restManageInvoiceModel);
	}
	
	@RequestMapping(value = "rest-viewInvoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> viewInvoice(@RequestParam String org,
			@RequestParam String orgDiv, String requestType) {

		logger.info("Method :viewInvoice startssssssssssssssssss");

		logger.info("Method :viewInvoice endss");
		return restManageInvoiceDao.viewInvoice(org, orgDiv, requestType);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewInvoiteEdit")
	public List<RestManageInvoiceModel> viewInvoiteEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewInvoiteEdit starts");
		// logger.info(id);
		logger.info("Method : viewInvoiteEdit endss");
		return restManageInvoiceDao.viewInvoiteEdit(id, org, orgDiv);
	}

	@RequestMapping(value = "getPoList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPoList(@RequestParam String id, String grnId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getPoList starts");
		logger.info("Method : getPoList ends");
		return restManageInvoiceDao.getPoList(id, grnId, org, orgDiv);
	}

	/*
	 * delete
	 * 
	 */
	@PostMapping(value = "deleteInvoice")
	public ResponseEntity<JsonResponse<Object>> deleteInvoice(
			@RequestBody RestManageInvoiceModel restManageInvoiceModel) {
		logger.info("Method : deleteInvoice starts");
		// logger.info(restSalesInvoiceNewModel);
		logger.info("Method : deleteInvoice ends");
		return restManageInvoiceDao.deleteInvoice(restManageInvoiceModel);
	}

	/*
	 * pdf
	 */ @GetMapping(value = "view-invoice-viewPdf")
	public List<RestManageInvoiceModel> viewInvoiceViewPdf(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewInvoiceViewPdf starts");
		logger.info("Method : viewInvoiceViewPdf endss");
		return restManageInvoiceDao.viewInvoiceViewPdf(id, org, orgDiv);
	}

	@PostMapping(value = "rest-add-grn-return")
	public ResponseEntity<JsonResponse<Object>> grnReturn(@RequestBody RestManageInvoiceModel restManageInvoiceModel) {
		logger.info("Method : grnReturn starts");
		// logger.info(restSalesInvoiceNewModel);
		logger.info("Method : grnReturn ends");
		return restManageInvoiceDao.grnReturn(restManageInvoiceModel);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewInvoiceEditForReturn")
	public List<RestManageInvoiceModel> viewInvoiceEditForReturn(@RequestParam String id, String hsnCode,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewInvoiceEditForReturn starts");
		// logger.info(id);
		logger.info("Method : viewInvoiceEditForReturn endss");
		return restManageInvoiceDao.viewInvoiceEditForReturn(id, hsnCode, org, orgDiv);
	}
	// approve

	@GetMapping(value = "approveinvoice")
	public JsonResponse<DropDownModel> approveinvoice(@RequestParam String approveStatus, String invoiceId, String invType,
			String orgName, String orgDivision, String approvedBy) {
		logger.info("Method : approveinvoice starts");

		logger.info("Method : approveinvoice ends");
		return restManageInvoiceDao.approveinvoice(approveStatus, invoiceId, invType, orgName, orgDivision,approvedBy);
	}

	// add For QA-Request

	/*
	 * @PostMapping(value = "rest-qaRequestAddData") public
	 * ResponseEntity<JsonResponse<List<RestQaRequestModel>>> saveQaRequest(
	 * 
	 * @RequestBody List<RestQaRequestModel> data) {
	 * logger.info("Method :saveQaRequest starts");
	 * 
	 * logger.info("Method :saveQaRequest endss"); return
	 * restManageInvoiceDao.saveQaRequest(data); }
	 */
	
	@RequestMapping(value = "rest-qaRequestAddData", method = { RequestMethod.GET })
	public JsonResponse<Object> saveQaRequest(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :saveQaRequest start");

		logger.info("Method :saveQaRequest endss");
		return restManageInvoiceDao.saveQaRequest(id, orgName, orgDivision);
	}

	@RequestMapping(value = "getVendorList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorList(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getVendorList starts");

		logger.info("Method : getVendorList ends");
		return restManageInvoiceDao.getVendorList(id, orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-addGrnRecieveExcel")
	public ResponseEntity<JsonResponse<Object>> addGrnRecieveExcel(@RequestBody List<RestGrnReturnExcelModel> grnRecieve) {
		logger.info("Method : addGrnRecieveExcel starts");

		logger.info("Method : addGrnRecieveExcel ends");
		return restManageInvoiceDao.addGrnRecieveExcel(grnRecieve);
	}
	
	// Search
	
	
	@RequestMapping(value = "rest-viewInvoiceSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> viewInvoiceSearch(@RequestParam String org,
			@RequestParam String orgDiv, String requestType, String searchValue) {

		logger.info("Method :viewInvoiceSearch startssssssssssssssssss");

		logger.info("Method :viewInvoiceSearch endss");
		return restManageInvoiceDao.viewInvoiceSearch(org, orgDiv, requestType,searchValue);

	}
	@GetMapping(value = "getVendorAutoSearchListInventory")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> getVendorAutoSearchListInventory(@RequestParam String id,@RequestParam String type,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getVendorAutoSearchListInventory starts");

		logger.info("Method :getVendorAutoSearchListInventory endss");
		return restManageInvoiceDao.getVendorAutoSearchListInventory(id,type, org, orgDiv);
	}
	
	// Vendor State.
	@RequestMapping(value = "getVendorState", method = { RequestMethod.GET })
	public JsonResponse<Object> getVendorState(@RequestParam String id, String type, String orgName, String orgDivision) {
		logger.info("Method :getVendorState start");

		logger.info("Method :getVendorState endss");
		return restManageInvoiceDao.getVendorState(id, type, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-viewFilterInvoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> viewFilteredInvoice(@RequestParam String org,
			@RequestParam String orgDiv, String requestType, String fromDate, String toDate,String searchData) {

		logger.info("Method :viewFilteredInvoice starts");

		logger.info("Method :viewFilteredInvoice endss");
		return restManageInvoiceDao.viewFilteredInvoiceData(org, orgDiv, requestType,fromDate,toDate,searchData);

	}
	
	// view grn report data
	
	@RequestMapping(value = "rest-grnReportView", method = { RequestMethod.GET })
	public JsonResponse<Object> grnReportView(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :grnReportView start");

		logger.info("Method :grnReportView endss");
		return restManageInvoiceDao.grnReportView(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-grn-report-view-filtered", method = { RequestMethod.GET })
	public JsonResponse<Object> grnFilteredView(@RequestParam String orgName, @RequestParam String orgDivision, String id, 
			String fromDate,String toDate, String searchData) {
		logger.info("Method :grnFilteredView start");

		logger.info("Method :grnFilteredView endss");
		return restManageInvoiceDao.grnFilteredView(orgName, orgDivision,fromDate,toDate,searchData);

	}
	
	
	@RequestMapping(value = "rest-getGrnDtlsPO", method = { RequestMethod.GET })
	public JsonResponse<Object> getGrnDtlsPO(@RequestParam String orgName, @RequestParam String orgDivision, String id) {
		logger.info("Method :getGrnDtlsPO start");

		logger.info("Method :getGrnDtlsPO endss");
		return restManageInvoiceDao.getGrnDtlsPO(orgName, orgDivision, id);

	}
}
