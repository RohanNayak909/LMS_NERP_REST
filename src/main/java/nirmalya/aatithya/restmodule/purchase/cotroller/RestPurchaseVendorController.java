package nirmalya.aatithya.restmodule.purchase.cotroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseVendorDao;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase" })
public class RestPurchaseVendorController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseVendorController.class);
	@Autowired
	RestPurchaseVendorDao restPurchaseVendorDao;

	// getStateLists

	@RequestMapping(value = "getStateLists", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateLists(@RequestParam String id) {
		logger.info("Method : getStateLists starts");
		logger.info("Method : getStateLists ends");
		return restPurchaseVendorDao.getStateLists(id);
	}

	// addVendor

	@RequestMapping(value = "addVendor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addVendor(@RequestBody RestVendorNewModel restVendorNewModel) {
		logger.info("Method : addVendor starts");

		logger.info("addVendor---------------------" + restVendorNewModel);

		logger.info("Method : addVendor ends");

		return restPurchaseVendorDao.addVendor(restVendorNewModel);
	}
	
	@RequestMapping(value = "deleteChildDataOfVendor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> deleteChildDataOfVendor(@RequestBody DropDownModel dropDownModel) {
		logger.info("Method : deleteChildDataOfVendor starts");
		
		logger.info("delete sub data---------------------" + dropDownModel);
		
		logger.info("Method : addVendor ends");
		return restPurchaseVendorDao.deleteChildDataOfVendor(dropDownModel);
	}

	// restViewVendorDtls
	/*
	 * for view
	 */
	@RequestMapping(value = "restViewVendorDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestVendorNewModel>>> restViewVendorDtls(@RequestParam String org,
			@RequestParam String orgDiv,@RequestParam String from) {
		logger.info("Method: restViewVendorDtls View Start");
		logger.info("Method: restViewVendorDtls ends");
		return restPurchaseVendorDao.restViewVendorDtls(org, orgDiv,from);
	}

	// editVendorInfo

	@GetMapping(value = "editVendorPurchaseInfo")
	public ResponseEntity<JsonResponse<List<RestVendorNewModel>>> editVendorPurchaseInfo(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :editVendorPurchaseInfo starts");
		logger.info("editVendorPurchaseInfo-------------------------------rest");
		logger.info("Method :editVendorPurchaseInfo ends" + id);
		return restPurchaseVendorDao.editVendorPurchaseInfo(id, org, orgDiv);

	}

	// deleteVendorDetails
	@RequestMapping(value = "deleteVendorDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVendorDetails(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :  deleteVendorDetails starts" + id);

		logger.info("Method :  deleteVendorDetails ends");
		return restPurchaseVendorDao.deleteVendorDetails(id, org, orgDiv);
	}

	@RequestMapping(value = "getVendorCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getVendorCategory() {
		logger.info("Method : getVendorCategory starts");

		logger.info("Method : getVendorCategory ends");
		return restPurchaseVendorDao.getVendorCategory();
	}

	@RequestMapping(value = "getSalutationLists", method = { RequestMethod.GET })
	public List<DropDownModel> getSalutationLists() {
		logger.info("Method : getSalutationLists starts");

		logger.info("Method : getSalutationLists ends");
		return restPurchaseVendorDao.getSalutationLists();
	}

	@RequestMapping(value = "getPaymentTermsLists", method = { RequestMethod.GET })
	public List<DropDownModel> getPaymentTermsLists() {
		logger.info("Method : getPaymentTermsLists starts");

		logger.info("Method : getPaymentTermsLists ends");
		return restPurchaseVendorDao.getPaymentTermsLists();
	}

	@RequestMapping(value = "getbankAutoSearchList", method = { RequestMethod.GET })
	public JsonResponse<Object> getbankAutoSearchList(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getbankAutoSearchList start");

		logger.info("Method :getbankAutoSearchList endss");
		return restPurchaseVendorDao.getbankAutoSearchList(id, org, orgDiv);
	}
	
	@RequestMapping(value = "restViewVendorProfileDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestVendorNewModel>>> restViewVendorProfileDtls(@RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String  userId) {
		logger.info("Method: restViewVendorProfileDtls View Start");
		logger.info("Method: restViewVendorProfileDtls ends");
		return restPurchaseVendorDao.restViewVendorProfileDtls(org, orgDiv, userId);
	}

	
	
}
