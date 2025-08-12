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
import nirmalya.aatithya.restmodule.purchase.dao.QuotationDetailsDao;
import nirmalya.aatithya.restmodule.purchase.model.RestQuotationDetailsModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase" })
public class RestQuotationDetailsController {

	Logger logger = LoggerFactory.getLogger(RestQuotationDetailsController.class);
	@Autowired
	QuotationDetailsDao quotationDetailsDao;

	// getReferenceInquiry

	@RequestMapping(value = "getReferenceInquiry", method = { RequestMethod.GET })
	public List<DropDownModel> getVendorCategory() {
		logger.info("Method : getReferenceInquiry starts");

		logger.info("Method : getReferenceInquiry ends");
		return quotationDetailsDao.getReferenceInquiry();
	}

	@GetMapping(value = "getQuotationInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuotationInsertedId() {
		logger.info("Method : getQuotationInsertedId starts");

		logger.info("Method : getQuotationInsertedId endss");
		return quotationDetailsDao.getQuotationInsertedId();
	}

	@RequestMapping(value = "getrfqdropdown", method = { RequestMethod.GET })
	public List<DropDownModel> getRfqListForQuotation() {
		logger.info("Method : getRfqListForQuotation starts");

		logger.info("Method : getRfqListForQuotation ends");
		return quotationDetailsDao.getRfqListForQuotation();
	}

	/*
	 * add
	 */
	@PostMapping(value = "addquotationDetails")
	public ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> addquotationDetails(
			@RequestBody List<RestQuotationDetailsModel> restPurchaseModel) {
		logger.info("Method :addquotationDetails starts");

		logger.info("Method :addquotationDetails endss");
		return quotationDetailsDao.addquotationDetails(restPurchaseModel);
	}

	/*
	 * view
	 */
	@RequestMapping(value = "rest-viewquotationdetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> viewquotationdetails(@RequestParam String org,
			@RequestParam String orgDiv,@RequestParam String userId) {

		logger.info("Method :viewquotationdetails startssssssssssssssssss");

		logger.info("Method :viewquotationdetails endss");
		return quotationDetailsDao.viewquotationdetails(org, orgDiv,userId);

	}

	/*
	 * edit
	 */
	@GetMapping(value = "viewPurchaseQutEdit")
	public List<RestQuotationDetailsModel> viewPurchaseQutEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewPurchaseQutEdit starts");
		// logger.info(id);
		logger.info("Method : viewPurchaseQutEdit endss");
		return quotationDetailsDao.viewPurchaseQutEdit(id, org, orgDiv);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deletequotationDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletequotationDetails(@RequestParam String id) {
		logger.info("Method : deletequotationDetails starts");

		logger.info("Method : deletequotationDetails ends");
		return quotationDetailsDao.deletequotationDetails(id);
	}

	//
	@RequestMapping(value = "getPaymentModeList", method = { RequestMethod.GET })
	public List<DropDownModel> getPaymentModeList() {
		logger.info("Method : getPaymentModeList starts");

		logger.info("Method : getPaymentModeList ends");
		return quotationDetailsDao.getPaymentModeList();
	}

	@RequestMapping(value = "getReferenceList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getReferenceList(@RequestParam String id, String quotId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getReferenceList starts");

		logger.info("Method : getReferenceList ends");
		return quotationDetailsDao.getReferenceList(id, quotId, org, orgDiv);
	}

	// approve

	@GetMapping(value = "approveQuotation")
	public JsonResponse<DropDownModel> approveQuotation(@RequestParam String approveStatus, String quotationId,
			String orgName, String orgDivision) {
		logger.info("Method : approveQuotation starts");

		logger.info("Method : approveQuotation ends");
		return quotationDetailsDao.approveQuotation(approveStatus, quotationId, orgName, orgDivision);
	}
	// item against getReferenceItemDetails

	@GetMapping(value = "getReferenceItemDetails")
	public List<RestQuotationDetailsModel> getReferenceItemDetails(@RequestParam String id, String taxType1, String org,
			String orgDivision) {
		logger.info("Method : getReferenceItemDetails starts");

		logger.info("Method : getReferenceItemDetails endss");
		return quotationDetailsDao.getReferenceItemDetails(id, taxType1, org, orgDivision);
	}

	@GetMapping(value = "getRfqListByAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRfqListByAutoSearch(@RequestParam String id) {
		logger.info("Method : getRfqListByAutoSearch starts");

		logger.info("Method :getRfqListByAutoSearch endss");
		return quotationDetailsDao.getRfqListByAutoSearch(id);
	}

	@RequestMapping(value = "rest-rfq-quotaition-compare", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> rfqQuotationCompare(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :rfqQuotationCompare start");

		logger.info("Method :rfqQuotationCompare endss ");
		return quotationDetailsDao.rfqQuotationCompare(id, orgName, orgDivision);

	}
}
