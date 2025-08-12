package nirmalya.aatithya.restmodule.procurment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.dao.InventoryActionInvoiceDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionInvoiceModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryActionInvoiceController {
	Logger logger = LoggerFactory.getLogger(InventoryActionInvoiceController.class);

	@Autowired
	InventoryActionInvoiceDao inventoryActionInvoiceDao;

	/**
	 * for get vendor list
	 */
	@GetMapping(value = "get-action-vendor-list")
	public List<DropDownModel> getVendorList() {
		logger.info("Method : getVendorList starts");
		logger.info("Method : getVendorList endss");
		return inventoryActionInvoiceDao.getVendorList();
	}

	/**
	 * 
	 * @return payment status list
	 */
	@GetMapping(value = "get-payment-status")
	public List<DropDownModel> getPaymentStatus() {
		logger.info("Method : getPaymentStatus starts");
		logger.info("Method : getPaymentStatus endss");
		return inventoryActionInvoiceDao.getPaymentStatus();
	}

	/*
	 * for drop down of vendor location
	 */
	@GetMapping(value = "getVendorLocChange")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorLocChange(@RequestParam String vendorId) {
		logger.info("Method in rest: getVendorLocChange starts");

		logger.info("Method in rest: getVendorLocChange ends");
		return inventoryActionInvoiceDao.getVendorLocChange(vendorId);
	}

	/*
	 * for drop down of vendor location
	 */
	@GetMapping(value = "getVendorContactChange")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorContactChange(@RequestParam String vendorId) {
		logger.info("Method in rest: getVendorContactChange starts");

		logger.info("Method in rest: getVendorContactChange ends");
		return inventoryActionInvoiceDao.getVendorContactChange(vendorId);
	}
	/*
	 * for drop down of vendor location
	 */
	@GetMapping(value = "getCostCenterChange")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCostCenterChange(@RequestParam String costCenterId) {
		logger.info("Method in rest: getCostCenterChange starts");
		
		logger.info("Method in rest: getCostCenterChange ends");
		return inventoryActionInvoiceDao.getCostCenterChange(costCenterId);
	}

	/**
	 * PostMapping for add po
	 */

	@PostMapping(value = "rest-add-action-invoice")
	public ResponseEntity<JsonResponse<InventoryActionInvoiceModel>> restAddInvoice(
			@RequestBody InventoryActionInvoiceModel inventoryActionInvoiceModel) {
		logger.info("Method : restAddInvoice starts");
		logger.info("Method : restAddInvoice ends");
		return inventoryActionInvoiceDao.restAddInvoice(inventoryActionInvoiceModel);
	}

	/**
	 * get all po for view
	 */
	@GetMapping(value = "get-invoice-view-list")
	public List<InventoryActionInvoiceModel> getInvoiceViewList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getInvoiceViewList starts");
		logger.info("Method : getInvoiceViewList endss");
		return inventoryActionInvoiceDao.getInvoiceViewList(org,orgDiv);
	}

	/**
	 * Get mapping for edit po
	 */
	@GetMapping(value = "get-invoice-edit")
	public InventoryActionInvoiceModel geInvoiceEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : geInvoiceEdit starts");
		logger.info("Method : geInvoiceEdit endss");
		return inventoryActionInvoiceDao.geInvoiceEdit(id,org,orgDiv);
	}
	
	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-delete-invoice")
	public ResponseEntity<JsonResponse<Object>> restDeleteAction(
			@RequestBody InventoryActionInvoiceModel inventoryRfqModel) {
		logger.info("Method : restDeleteAction starts");
		logger.info("Method : restDeleteAction ends");
		return inventoryActionInvoiceDao.restDeleteAction(inventoryRfqModel);
	}

	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-approve-invoice")
	public ResponseEntity<JsonResponse<Object>> restApproveInvoice(
			@RequestBody InventoryActionInvoiceModel inventoryRfqModel) {
		logger.info("Method : restApproveInvoice starts");
		logger.info("Method : restApproveInvoice ends");
		return inventoryActionInvoiceDao.restApproveInvoice(inventoryRfqModel);
	}
	
	@GetMapping(value="get-invoice-pdfDetails")
	public JsonResponse<List<InventoryActionInvoiceModel>> getInvoicePdfDetails(@RequestParam String id ,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : getInvoicePdfDetails starts");
		
		logger.info("Method : getInvoicePdfDetails ends");
		return inventoryActionInvoiceDao.getInvoicePdfDetails(id,organization,orgDivision);
	}
}
