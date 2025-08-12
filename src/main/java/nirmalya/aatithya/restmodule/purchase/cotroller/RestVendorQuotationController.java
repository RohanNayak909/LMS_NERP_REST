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
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseVendorDao;
import nirmalya.aatithya.restmodule.purchase.dao.VendorQuotationDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestQuotationDetailsModel;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase" })
public class RestVendorQuotationController {

	Logger logger = LoggerFactory.getLogger(RestVendorQuotationController.class);
	@Autowired
	VendorQuotationDao vendorQuotationDao;

	/*
	 * view
	 */
	@RequestMapping(value = "rest-viewquotationdetailsForVendor", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> viewquotationdetailsForVendor(
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String userId) {

		logger.info("Method :viewquotationdetailsForVendor start");

		logger.info("Method :viewquotationdetailsForVendor endss");
		return vendorQuotationDao.viewquotationdetailsForVendor(orgName, orgDivision, userId);

	}

	// approve

	@GetMapping(value = "approveQuotationForVendor")
	public JsonResponse<DropDownModel> approveQuotationForVendor(@RequestParam String approveStatus, String quotationId,
			String orgName, String orgDivision,String userId) {
		logger.info("Method : approveQuotationForVendor starts");

		logger.info("Method : approveQuotationForVendor ends");
		return vendorQuotationDao.approveQuotationForVendor(approveStatus, quotationId, orgName, orgDivision, userId);
	}
}
