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
import nirmalya.aatithya.restmodule.sales.dao.RestSalesShipmentsDao;
import nirmalya.aatithya.restmodule.sales.model.RestDeliveryChallanModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesShipmentsModel;

@RestController
@RequestMapping("sales/")
public class RestSalesShipmentsController {
	Logger logger = LoggerFactory.getLogger(RestSalesShipmentsController.class);

	@Autowired

	RestSalesShipmentsDao restSalesShipmentsDao;
	
	@PostMapping(value = "addShipments")
	public ResponseEntity<JsonResponse<List<RestSalesShipmentsModel>>> addShipments(@RequestBody List<RestSalesShipmentsModel> restSalesShipmentsModel) {
		logger.info("Method :addShipments starts");
		logger.info(restSalesShipmentsModel.toString());
		logger.info("Method :addShipments endss");
		return restSalesShipmentsDao.addShipments(restSalesShipmentsModel);
	}
	@RequestMapping(value = "rest-viewsalesShipments", method = { RequestMethod.GET })
	public JsonResponse<Object> viewsalesShipments(@RequestParam String orgName, @RequestParam String orgDivision,String pageno) {
		logger.info("Method :viewsalesShipments start");

		logger.info("Method :viewsalesShipments endss");
		return restSalesShipmentsDao.viewsalesShipments(orgName, orgDivision, pageno);

	}
	@GetMapping(value = "viewShipmentEdit")
	public List<RestSalesShipmentsModel> viewShipmentEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewShipmentEdit starts");
		//logger.info(id);
		logger.info("Method : viewShipmentEdit endss");
		return restSalesShipmentsDao.viewShipmentEdit(id,org, orgDiv);
	}
	

 	@RequestMapping(value = "/deletShipments", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deletShipments(@RequestParam String id,@RequestParam String org,
				@RequestParam String orgDiv) {
		logger.info("Method : deletShipments starts");

		logger.info("Method : deletShipments ends");
		return restSalesShipmentsDao.deletShipments(id,org, orgDiv); 
	}
 	
 	@RequestMapping(value = "getPackageId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPackageId(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getPackageId starts");
		logger.info("Method : getPackageId ends");
		return restSalesShipmentsDao.getPackageId(id,org, orgDiv);
	}
 	@GetMapping(value = "getShipmentInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getShipmentInsertedId() {
		logger.info("Method : getShipmentInsertedId starts");

		logger.info("Method : getShipmentInsertedId endss");
		return restSalesShipmentsDao.getShipmentInsertedId();
	}
 	
 	@GetMapping(value = "get-carrier-list")
	public List<DropDownModel> getCarrierList() {
		logger.info("Method : getCarrierList starts");
		logger.info("Method : getCarrierList endss");
		return restSalesShipmentsDao.getCarrierList();
	}
 	 @GetMapping(value="deliveryStatus")
  	public JsonResponse<RestSalesShipmentsModel> deliveryStatus(@RequestParam String shipmentStatus,
  			String salesShipmentId,@RequestParam String org,
			@RequestParam String orgDiv){
  		logger.info("Method : deliveryStatus starts");
  		
  		logger.info("Method : deliveryStatus ends");
  		return restSalesShipmentsDao.deliveryStatus(shipmentStatus, salesShipmentId,org, orgDiv);
  	}
	/*
	 * @RequestMapping(value = "rest-viewsalesPOWiseShipment", method = {
	 * RequestMethod.GET }) public
	 * ResponseEntity<JsonResponse<List<RestSalesShipmentsModel>>>
	 * viewsalesPOWiseShipment(
	 * 
	 * @RequestParam String org, @RequestParam String orgDiv, @RequestParam String
	 * id) {
	 * 
	 * logger.info("Method :viewsalesPOWiseShipment starts");
	 * 
	 * logger.info("Method :viewsalesPOWiseShipment endss"); return
	 * restSalesShipmentsDao.viewsalesPOWiseShipment(org, orgDiv, id);
	 * 
	 * }
	 */
 	 

 	/*
 	 * get challan data
 	 */ @GetMapping(value = "viewsalesChallanData")
	public List<RestDeliveryChallanModel> viewsalesChallanData(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewsalesChallanData starts");
		//logger.info(id);
		logger.info("Method : viewsalesChallanData endss");
		return restSalesShipmentsDao.viewsalesChallanData(id,org, orgDiv);
	}
 	@GetMapping("rest-get-challan")
	public JsonResponse<Object> getChallanOnPo(@RequestParam String poId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :getChallanOnPo start");

		logger.info("Method :getChallanOnPo ends");
		return restSalesShipmentsDao.getChallanOnPo(poId, orgName, orgDiv);
	}
 	@GetMapping("rest-get-po-shipment")
	public JsonResponse<Object> getPoOnCustomerChange(@RequestParam String custId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :getPoOnCustomerChange start");

		logger.info("Method :getPoOnCustomerChange ends");
		return restSalesShipmentsDao.getPoOnCustomerChange(custId, orgName, orgDiv);
	}
}
