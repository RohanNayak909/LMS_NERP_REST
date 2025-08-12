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
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseProductDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseVendorDao;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase" })

public class RestPurchaseProductController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseProductController.class);
	@Autowired
	RestPurchaseProductDao restPurchaseProductDao;

	@PostMapping(value = "addbrandDetails")
	public JsonResponse<Object> addbrandDetails(@RequestBody ProductMasterModel productMasterModel) {
		logger.info("Method :addbrandDetails starts");

		logger.info("Method : addbrandDetails ends");
		return restPurchaseProductDao.addbrandDetails(productMasterModel);
	}

	@RequestMapping(value = "getBrandList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBrandList(@RequestParam String id,@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method : getBrandList starts");

		logger.info("Method : getBrandList ends");
		return restPurchaseProductDao.getBrandList(id,orgName, orgDivision);
	}
}
