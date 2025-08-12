package nirmalya.aatithya.restmodule.warehouse.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.RestWarehouseGoodsBlockingDao;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestWarehouseGoodsBlockingController {
	Logger logger = LoggerFactory.getLogger(RestWarehouseGoodsBlockingController.class);

	@Autowired
	RestWarehouseGoodsBlockingDao restWarehouseGoodsBlockingDao;

	//getWarehouseBlockData 
	@RequestMapping(value = "rest-getWarehouseBlockData", method = { RequestMethod.GET })
	public JsonResponse<Object> getWarehouseBlockData(@RequestParam String orgName, String orgDivision,String pageno,String type) {
		logger.info("Method :getWarehouseBlockData start");

		logger.info("Method :getWarehouseBlockData endss");
		return restWarehouseGoodsBlockingDao.getWarehouseBlockData(orgName,orgDivision,pageno,type);
	}
	//getWarehouseAllocateDataForBlocking
	@RequestMapping(value = "getWarehouseAllocateDataForBlocking", method = { RequestMethod.GET })
	public JsonResponse<Object> getWarehouseAllocateDataForBlocking(@RequestParam  String warehouseId,String orgName, String orgDivision) {
		logger.info("Method :getWarehouseAllocateDataForBlocking start");

		logger.info("Method :getWarehouseAllocateDataForBlocking endss");
		return restWarehouseGoodsBlockingDao.getWarehouseAllocateDataForBlocking(warehouseId, orgName, orgDivision);
	}
	//Get Go button onclick data
	@RequestMapping(value = "getGoodsAllocatefilterData", method = { RequestMethod.GET })
	public JsonResponse<Object> getBlockStockData(@RequestParam  String warehouseId,String zoneId,String rackId,
			 String categoryId,String itemName,String orgName,String orgDivision) {
		logger.info("Method :getGoodsAllocatefilterData start");

		logger.info("Method :getGoodsAllocatefilterData endss");
		return restWarehouseGoodsBlockingDao.getGoodsAllocatefilterData(warehouseId,zoneId,rackId,categoryId,itemName,orgName, orgDivision);
	}
	
	//Save
	@PostMapping(value = "warehouse-blocking-save")
	public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> submitBlockDetails(
			@RequestBody List<WirehouseRomeModel> wirehouseRomeModel) {
		logger.info("Method :submitBlockDetails starts");
		
		logger.info("Method :submitBlockDetails endss");
		return restWarehouseGoodsBlockingDao.submitBlockDetails(wirehouseRomeModel);
	}
	
	//Assign Dispatch request
	  @GetMapping(value="assignDispatchRequest")
	 	public JsonResponse<WirehouseRomeModel> assignDispatchRequest(@RequestParam String assignStatus,
	 			String blockId,String orgName,String orgDivision){
	 		logger.info("Method : assignDispatchRequest starts");
	 		
	 		logger.info("Method : assignDispatchRequest ends");
	 	return restWarehouseGoodsBlockingDao.assignDispatchRequest(assignStatus, blockId,orgName, orgDivision);
	 	}
	  
		//delete Block Data
	  @GetMapping(value = "deleteBlockdata")
		public JsonResponse<Object> deleteBlockdata(@RequestParam String blockId,String orgName,String orgDivision) {
			logger.info("Method : deleteBlockdata starts");
			logger.info("Method : deleteBlockdata ends");
			return restWarehouseGoodsBlockingDao.deleteBlockdata(blockId,orgName, orgDivision);
		}
	  
		//View Bin Data
		@RequestMapping(value = "rest-viewblock", method = { RequestMethod.GET })
		public JsonResponse viewblock(@RequestParam String rmId, String org,
				 String orgDiv) {
			logger.info("Method :viewblock start");

			logger.info("Method :viewblock endss");
			return restWarehouseGoodsBlockingDao.viewblock(rmId,org, orgDiv);

		}
}
