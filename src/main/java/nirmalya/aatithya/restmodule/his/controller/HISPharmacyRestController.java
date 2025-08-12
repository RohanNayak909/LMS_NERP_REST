package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISPharmacyRestDao;

@RestController
@RequestMapping(value = "his/")
public class HISPharmacyRestController {

	Logger logger = LoggerFactory.getLogger(HISPharmacyRestController.class);

	@Autowired
	HISPharmacyRestDao hisPharmacyRestDao;

	@RequestMapping(value = "getItemList", method = { RequestMethod.GET })
	public List<DropDownModel> getItemList(@RequestParam String org, String orgDiv) {
		logger.info("Method : getItemList starts");

		logger.info("Method : getItemList ends");
		return hisPharmacyRestDao.getItemList(org, orgDiv);
	}

	@RequestMapping(value = "getPayModeList", method = { RequestMethod.GET })
	public List<DropDownModel> getPayModeList(@RequestParam String org, String orgDiv) {
		logger.info("Method : getPayModeList starts");

		logger.info("Method : getPayModeList ends");
		return hisPharmacyRestDao.getPayModeList(org, orgDiv);
	}

	@GetMapping(value = "getPatientListByAutoSearch")
	public JsonResponse<Object> getPatientListByAutoSearch(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getPatientListByAutoSearch starts");

		logger.info("Method :getPatientListByAutoSearch endss");
		return hisPharmacyRestDao.getPatientListByAutoSearch(id, org, orgDiv);
	}

	@RequestMapping(value = "rest-his-viewPharmacy", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPharmacy(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewPharmacy start");

		logger.info("Method :viewPharmacy endss");
		return hisPharmacyRestDao.viewPharmacy(orgName, orgDivision, userId);
	}

	@RequestMapping(value = "rest-getBatchDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getBatchDetails(@RequestParam String orgName, String orgDivision, String userId,
			String id) {
		logger.info("Method :getBatchDetails start");

		logger.info("Method :getBatchDetails endss");
		return hisPharmacyRestDao.getBatchDetails(orgName, orgDivision, userId, id);
	}

	@RequestMapping(value = "rest-dispatchMedicine", method = { RequestMethod.POST })
	public JsonResponse<Object> dispatchMedicine(@RequestParam String orgName, String orgDivision, String userId,
			@RequestBody String data) {
		logger.info("Method :dispatchMedicine start");

		logger.info("Method :getBatchDdispatchMedicineetails endss");
		return hisPharmacyRestDao.dispatchMedicine(orgName, orgDivision, userId, data);
	}

	// view
	@RequestMapping(value = "rest-pharmacy-dashboard-expiried-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewmedicine(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewmedicine start");

		logger.info("Method :viewmedicine endss");
		return hisPharmacyRestDao.viewmedicine(orgName, orgDivision, userId);
	}

	@RequestMapping(value = "rest-pharmacy-dashboard-payment-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPayment(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewPayment start");

		logger.info("Method :viewPayment endss");
		return hisPharmacyRestDao.viewPayment(orgName, orgDivision, userId);
	}
}
