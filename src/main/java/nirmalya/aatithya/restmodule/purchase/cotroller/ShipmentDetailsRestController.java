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
import nirmalya.aatithya.restmodule.purchase.dao.ShipmentDetailsRestDao;
import nirmalya.aatithya.restmodule.purchase.model.RestShipmentDetailsVendorModel;

@RestController
@RequestMapping("purchase/")
public class ShipmentDetailsRestController {

	Logger logger = LoggerFactory.getLogger(ShipmentDetailsRestController.class);

	@Autowired
	ShipmentDetailsRestDao shipmentDetailsRestDao;

	@GetMapping(value = "viewShipmentDetails")
	public ResponseEntity<JsonResponse<List<RestShipmentDetailsVendorModel>>> viewShipmentDetails(
			@RequestParam String userId, String organization, String orgDivision, String pageno) {
		logger.info("Method : viewShipmentDetails starts");

		logger.info("Method : viewShipmentDetails ends");
		return shipmentDetailsRestDao.viewShipmentDetails(userId, organization, orgDivision, pageno);
	}

	@RequestMapping(value = "getCustomerAutoSearchList", method = { RequestMethod.GET })
	public JsonResponse<Object> getCustomerAutoSearchList(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getCustomerAutoSearchList start");

		logger.info("Method :getCustomerAutoSearchList endss");
		return shipmentDetailsRestDao.getCustomerAutoSearchList(id, org, orgDiv);
	}

	@PostMapping(value = "addShipmentDetails")
	public ResponseEntity<JsonResponse<List<RestShipmentDetailsVendorModel>>> addShipmentDetails(
			@RequestBody List<RestShipmentDetailsVendorModel> restGatePassDetailsModel) {
		logger.info("Method :addGatepassEntry starts");
		System.out.println(restGatePassDetailsModel.get(0).getCustId());
		logger.info("Method :addGatepassEntry endss");
		return shipmentDetailsRestDao.addShipmentDetails(restGatePassDetailsModel);
	}

	@GetMapping(value = "editShipmentData")
	public List<RestShipmentDetailsVendorModel> editShipmentData(@RequestParam String shippingId,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : editShipmentData starts");
		// System.out.println(id);
		logger.info("Method : editShipmentData endss");
		return shipmentDetailsRestDao.editShipmentData(shippingId, organization, orgDivision);
	}

	@RequestMapping(value = "deleteShipment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteShipment(@RequestParam String id, String org,
			String orgDivision) {
		logger.info("Method : deleteShipment starts");

		logger.info("Method : deleteShipment ends");
		return shipmentDetailsRestDao.deleteShipment(id, org, orgDivision);
	}

	@GetMapping(value = "approveshipment")
	public JsonResponse<DropDownModel> approveshipment(@RequestParam String approveStatus, String shippingId,
			String org, String orgDivision) {
		logger.info("Method : approveshipment starts");

		logger.info("Method : approveshipment ends");
		return shipmentDetailsRestDao.approveshipment(approveStatus, shippingId, org, orgDivision);
	}
}
