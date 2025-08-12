package nirmalya.aatithya.restmodule.warehouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.RestWarehouseStockVerificationDao;

@RestController
@RequestMapping(value = "master")
public class RestWarehouseStockVerificationController {
	Logger logger = LoggerFactory.getLogger(RestWarehouseStockVerificationController.class);

	@Autowired
	RestWarehouseStockVerificationDao restWarehouseStockVerificationDao;
	
	@RequestMapping(value = "zoneListData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getzoneList(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : zoneListData starts");
		
		logger.info("Method : zoneListData ends");
		return restWarehouseStockVerificationDao.zoneListData(id,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-getWarehouseOpenListData", method = { RequestMethod.GET })
	public JsonResponse getWarehouseData(@RequestParam  String warehouseId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getWarehouseOpenListData start");

		logger.info("Method :getWarehouseOpenListData endss");
		return restWarehouseStockVerificationDao.getWarehouseOpenListData(warehouseId, orgName, orgDivision);

	}
	

	@RequestMapping(value = "rackListData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> rackListData(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : rackListData starts");
		
		logger.info("Method : rackListData ends");
		return restWarehouseStockVerificationDao.rackListData(id,orgName, orgDivision);
	}
	@RequestMapping(value = "binListData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> binListData(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : binListData starts");
		
		logger.info("Method : binListData ends");
		return restWarehouseStockVerificationDao.binListData(id,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-getStockVerificationData", method = { RequestMethod.GET })
	public JsonResponse warehouseGetAllData(@RequestParam  String warehouseId,@RequestParam String zoneId,
			@RequestParam String categoryId,@RequestParam String itemName,@RequestParam String rackId,@RequestParam String binId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getStockVerificationData start");

		logger.info("Method :getStockVerificationData endss");
		return restWarehouseStockVerificationDao.getStockVerificationData(warehouseId,zoneId,categoryId,itemName,rackId,binId,orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-viewstockdetails", method = { RequestMethod.GET })
	public JsonResponse viewstockdetails(@RequestParam  String rmId,@RequestParam String allocateid,@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewstockdetails start");

		logger.info("Method :viewstockdetails endss");
		return restWarehouseStockVerificationDao.viewstockdetails(rmId,allocateid,orgName, orgDivision);

	}
}
