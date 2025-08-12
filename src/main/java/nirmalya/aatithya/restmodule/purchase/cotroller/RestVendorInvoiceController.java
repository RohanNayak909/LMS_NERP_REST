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
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.purchase.dao.VendorInvoiceDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.VendorInvoiceRestModel;

@RestController
@RequestMapping("purchase/")
public class RestVendorInvoiceController {
	Logger logger = LoggerFactory.getLogger(RestVendorInvoiceController.class);

	@Autowired

	VendorInvoiceDao vendorInvoiceDao;

	/*
	 * add
	 */
	@PostMapping(value = "addVendorInvoicenew")
	public ResponseEntity<JsonResponse<List<VendorInvoiceRestModel>>> addVendorInvoicenew(
			@RequestBody List<VendorInvoiceRestModel> VendorInvoiceRestModel) {
		logger.info("Method :addVendorInvoicenew starts");

		logger.info("Method :addVendorInvoicenew endss");
		return vendorInvoiceDao.addVendorInvoicenew(VendorInvoiceRestModel);
	}

	/*
	 * view
	 * 
	 */
	@PostMapping(value = "viewVendorInvoice")
	public JsonResponse<List<VendorInvoiceRestModel>> viewVendorInvoice(@RequestBody EmpRoleModel empModel) {
		String userId = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();
		logger.info("Method :viewVendorInvoice starts");

		logger.info("Method :viewVendorInvoice endss");
		return vendorInvoiceDao.viewVendorInvoice(userId, organization, orgDivision);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewVendorIvoiceEdit")
	public List<VendorInvoiceRestModel> viewVendorIvoiceEdit(@RequestParam String id, String organization,
			String orgDivision) {
		logger.info("Method : viewVendorIvoiceEdit starts");
		logger.info("Method : viewVendorIvoiceEdit endss");
		return vendorInvoiceDao.viewVendorIvoiceEdit(id, organization, orgDivision);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteVendorInvoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDeliveryChallan(@RequestParam String id,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : deleteDeliveryChallan starts");

		logger.info("Method : deleteDeliveryChallan ends");
		return vendorInvoiceDao.deleteVendorInvoice(id, organization, orgDivision);
	}

	// approve

	@GetMapping(value = "approveVendorinvoice")
	public JsonResponse<DropDownModel> approveVendorinvoice(@RequestParam String approveStatus, String vendorInvoice,
			String orgName, String orgDivision) {
		logger.info("Method : approveVendorinvoice starts");

		logger.info("Method : approveVendorinvoice ends");
		return vendorInvoiceDao.approveVendorinvoice(approveStatus, vendorInvoice, orgName, orgDivision);
	}

	
}
